package org.gateway.gd.util;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.domain.InventoryWarn;
import org.gateway.gd.domain.RealtimeInventory;
import org.gateway.gd.domain.SluggishMaterials;
import org.gateway.gd.domain.SystemNotice;
import org.gateway.gd.service.InventoryWarnService;
import org.gateway.gd.service.RealtimeInventoryService;
import org.gateway.gd.service.SluggishMaterialsService;
import org.gateway.gd.service.SystemNoticeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/**
 * 定时任务
 * 
 * @author gateway
 *
 */
/**
 * 隔5s检查一次 "0/5 * * * * ?"
 * 隔1分钟检查一次 "0 * * * * ?"
 * @author gateway
 *
 */
@Service
public class Timer {

	/**
	 *  "0 0 12 * * ?"    每天中午十二点触发 
	 *  "0 15 10 ? * *"    每天早上10：15触发 
     *  "0 15 10 * * ?"    每天早上10：15触发 
	 *  "0 15 10 * * ? *"    每天早上10：15触发 
	 *  "0 15 10 * * ? 2005"    2005年的每天早上10：15触发 
	 *  "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发 
	 *  "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发 
	 *  "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 
	 *  "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发 
	 *  "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发 
	 *  "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发 
	 */
	@Resource
	private RealtimeInventoryService realtimeInventoryService;
	@Resource
	private SluggishMaterialsService sluggishMaterialsService;
	@Resource
	private SystemNoticeService systemNoticeService;
	@Resource
	private InventoryWarnService inventoryWarnService;
	
	/**
	 * 检查呆滞料情况
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Scheduled(cron = "0 5 * * * ?")
	public void sluggishMaterials() throws Exception{
		/**
		 * 
		 * 判断物料是否为呆滞料
		 * 
		 * 1.判断实时库存表中的每一条物料的最后异动日和当前时间的差是否大于等于无发生额天数 .
		 *		 --|如果大于等于，则判断该物料在呆滞料表中是否存在
		 * 			 --|如果存在，最后异动日相同则不更新，不同则更新，同时发送系统通知
		 *   		 --|如果不存在，就添加一条记录.同时发送系统通知
		 * 		--|如果小于，则判断该物料在呆滞料表中是否存在 
		 * 			--|如果存在，就删除呆滞料表中的这条记录.同时发送系统通知
		 * 
		 * 
		 */
		System.out.println("呆滞料状态检查");
		/**
		 * 首先，拿到所有的实时库存数据
		 * 然后，对比每个库存物料的最后异动日和各自的无发生额天数：
		 * 		若果当前日期和最后异动日的差额大于无发生额天数，就将其置为呆滞料，并发出通知
		 * 		若果小于，则忽略
		 */
		List<RealtimeInventory> realtimeInventory = realtimeInventoryService
				.findAll();
		for (RealtimeInventory reaInventory : realtimeInventory) {
			Long dateLong = reaInventory.getMaterials().getNoAmountOfTime();// 无发生额天数
			SluggishMaterials sluggishMaterials=sluggishMaterialsService.getMWById(reaInventory.getMaterials().getId(), reaInventory.getWarehouse().getName());
			if (IntervalDays
					.getIntervalDays(new Date(), reaInventory.getDate()) >= dateLong) {
				/**
				 * 呆滞料中是否有此物料:若有，则更新其最后异动日
				 */
				if (sluggishMaterials!=null) {
						System.out.println(reaInventory.getDate()+"实时库存的最后异动日");
						sluggishMaterials.setDate(reaInventory.getDate());
						sluggishMaterialsService.update(sluggishMaterials);
				} else {
					SluggishMaterials sMaterials = new SluggishMaterials();
					sMaterials.setDate(reaInventory.getDate());
					sMaterials.setMaterialsId(reaInventory
							.getMaterials().getId());
					sMaterials.setMaterialsName(reaInventory
							.getMaterials().getName());
					sMaterials.setNumber(reaInventory.getNumber());
					sMaterials.setWarehouseName(reaInventory
							.getWarehouse().getName());
					sluggishMaterialsService.save(sMaterials);
					
					SystemNotice systemNotice=new SystemNotice();
					systemNotice.setName("呆滞料:"+reaInventory.getMaterials().getName()+""+new Date().toLocaleString());
					systemNotice.setSummary("呆滞料"+""+reaInventory.getDate().toLocaleString());
					systemNotice.setViewyn(SystemNotice.VIEWN);
					systemNotice.setContent("呆滞料"+reaInventory.getMaterials().getName()+"_"+reaInventory.getDate().toString()+"_"+reaInventory.getWarehouse().getName());
					systemNoticeService.save(systemNotice);
				}
			} else {
				if (sluggishMaterials != null) {
					sluggishMaterialsService.delete(sluggishMaterials.getId());
				}
			}
		}
	}
	
	/**
	 * 预警状态检查
	 * @throws Exception
	 */
	@Scheduled(cron = "0 5 * * * ?")
	public void warnInventory() throws Exception{
		
		System.out.println("--------------库存预警状态-----------------------");
		List<InventoryWarn> invnetoryWarnList=inventoryWarnService.findAll();
		for (InventoryWarn inventoryWarn : invnetoryWarnList) {
			Double safe=inventoryWarn.getSafeInventory();
			Double highest=inventoryWarn.getHighestInventory();
			Double lowest=inventoryWarn.getLowestInventory();
			Double real=inventoryWarn.getRealInventory();
			
			if(real>highest){
				System.out.println(inventoryWarn.getStatus());
				if(!(InventoryWarn.LARGE).equals(inventoryWarn.getStatus())){
					inventoryWarn.setStatus(InventoryWarn.LARGE);
					inventoryWarnService.update(inventoryWarn);
					SystemNotice systemNotice=new SystemNotice();
					systemNotice.setName(inventoryWarn.getMaterialsName()+"_"+InventoryWarn.LARGE+new Date());
					systemNotice.setSummary("超储"+(real-highest));
					systemNotice.setContent("超过最大库存"+highest+"，超出量为:"+(real-highest)+"，急需处理");
					systemNotice.setViewyn(SystemNotice.VIEWN);
					systemNoticeService.save(systemNotice);
				}
			}else if ((real >= lowest) && (real <= safe)) {
				System.out.println(inventoryWarn.getStatus());
				if(!InventoryWarn.MIDDLE.equals(inventoryWarn.getStatus())){
					inventoryWarn.setStatus(InventoryWarn.MIDDLE);
					inventoryWarnService.update(inventoryWarn);
					SystemNotice systemNotice=new SystemNotice();
					systemNotice.setName(inventoryWarn.getMaterialsName()+"_"+InventoryWarn.MIDDLE+new Date());
					systemNotice.setSummary("库存量不足");
					systemNotice.setContent("库存少于安全库存，实际为"+real+"，不足量为:"+(safe-real)+"，急需处理");
					systemNotice.setViewyn(SystemNotice.VIEWN);
					systemNoticeService.save(systemNotice);
				}
			}else if (real<lowest) {
				System.out.println(inventoryWarn.getStatus());
				if(!InventoryWarn.SHORT.equals(inventoryWarn.getStatus())){
					inventoryWarn.setStatus(InventoryWarn.SHORT);
					inventoryWarnService.update(inventoryWarn);
					SystemNotice systemNotice=new SystemNotice();
					systemNotice.setName(inventoryWarn.getMaterialsName()+"_"+InventoryWarn.SHORT+new Date());
					systemNotice.setSummary("短缺"+(real-highest));
					systemNotice.setContent("少于最小库存，实际为"+real+"，短缺量为:"+(lowest-real)+"，急需处理");
					systemNotice.setViewyn(SystemNotice.VIEWN);
					systemNoticeService.save(systemNotice);
				}
			}else{
				inventoryWarn.setStatus(null);
				inventoryWarnService.update(inventoryWarn);
			}
		}
	}
	
	/**
	 * 定时检查实时库存和库存预警中的数据的一致性
	 */
	@Scheduled(cron="0 5 * * * ?")
	public void consistent() throws Exception{
		System.out.println("===========实时库存和库存预警数据一致性检查===============");
		List<InventoryWarn> inventoryWarn=inventoryWarnService.findAll();
		for (InventoryWarn inWarn : inventoryWarn) {
			Double num = realtimeInventoryService.getByMaterialsName(inWarn.getMaterialsName());
			if(!num.equals(inWarn.getRealInventory())){
				inWarn.setRealInventory(num);
				inWarn.setChangeNumber(num);
				inventoryWarnService.update(inWarn);
			}
		}
	}
}
