package org.gateway.gd.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.AdjustmentItem;
import org.gateway.gd.domain.AdjustmentMaterials;
import org.gateway.gd.domain.Materials;
import org.gateway.gd.domain.PhysicalItem;
import org.gateway.gd.domain.PhysicalMaterials;
import org.gateway.gd.domain.RealtimeInventory;
import org.gateway.gd.domain.Unit;
import org.gateway.gd.domain.User;
import org.gateway.gd.domain.Warehouse;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

/**
 * 库存盘点
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PhysicalAction extends BaseAction<Object> {

	private int pageNum = 1;
	private int pageSize = 10;
	private Long id; // 盘点单编号
	private Date date; // 盘点日期
	private String checkyn; // 审核标志
	private String checker; // 审核人
	private String description; // 说明
	private Long userId;
	private Long warehouseId;
	private Long[] materialsId;
	private Long[] unitId;
	private Double[] number; // 账存数量
	private Double[] profitNumber;// 盘盈数量
	private Double[] lossNumber; // 盘亏数量
	private Double[] realNumber; // 实存数量

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(PhysicalItem.class, "pm");
		PageBean pageBean = physicalItemService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	// =============盘点单详细情况=======================
	public String listInfo() throws Exception {

		// 该盘点单的详细情况
		List<PhysicalMaterials> physicalMaterials = physicalMaterialsService
				.getByListId(id);
		ActionContext.getContext().put("physicalMaterials", physicalMaterials);

		return "listInfo";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		// 单据未审核就可以删除，否则不能删除
		if (physicalItemService.getById(id).getCheckyn().equals("未审核")) {
			physicalItemService.delete(id);
		}
		return "toList";
	}

	public String addWay() throws Exception {

		// 列出所有存有物料的仓库
		List<RealtimeInventory> realtimeInventoryList = realtimeInventoryService
				.getByWareGroup();
		ActionContext.getContext().put("realtimeInventoryList",
				realtimeInventoryList);

		return "addWay";
	}

	// ==========添加=====================
	public String add() throws Exception {
		
		PhysicalItem physicalItem = new PhysicalItem();
		physicalItem.setDate(new Date());
		physicalItem.setCheckyn(PhysicalItem.CHECKN);
		physicalItem.setWarehouse(warehouseService.getById(warehouseId));
		physicalItemService.save(physicalItem);

		// 根据所选仓库得到该仓库所有物料
		List<RealtimeInventory> realtimeInventoryList = realtimeInventoryService
				.getByWarehouseId(warehouseId);
		for (RealtimeInventory reInventory : realtimeInventoryList) {
			PhysicalMaterials physicalMaterials = new PhysicalMaterials();
			physicalMaterials.setMaterials(reInventory.getMaterials());
			physicalMaterials.setUnit(reInventory.getUnit());
			physicalMaterials.setNumber(reInventory.getNumber());
			physicalMaterials.setRealNumber(reInventory.getNumber());
			physicalMaterials.setPhysicalItem(physicalItem);
			physicalMaterialsService.save(physicalMaterials);

			physicalItem.getPhysicalMaterials().add(physicalMaterials);
		}

		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {

		// 当前日期
		DateFormat ddf = DateFormat.getDateInstance();
		String dateString = ddf.format(new Date());
		ActionContext.getContext().put("date", dateString);

		// 仓库列表
		List<Warehouse> warehouseList = warehouseService.findAll();
		ActionContext.getContext().put("warehouseList", warehouseList);

		// 用户列表
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);

		// 物料列表
		List<Materials> materialsList = materialsService.findAll();
		ActionContext.getContext().put("materialsList", materialsList);

		// 单位列表
		List<Unit> unitList = unitService.findAll();
		ActionContext.getContext().put("unitList", unitList);

		// 主表信息（表头、表尾信息）
		PhysicalItem physicalItem = physicalItemService.getById(id);
		ActionContext.getContext().getValueStack().push(physicalItem);

		// 附表信息（表体信息）
		List<PhysicalMaterials> physicalMaterialsList = physicalMaterialsService
				.getByListId(id);
		ActionContext.getContext().put("physicalMaterialsList",
				physicalMaterialsList);

		// 确定回显的已有数据
		if (physicalItem.getWarehouse() != null) {
			warehouseId = physicalItem.getWarehouse().getId();
		}
		if (physicalItem.getUser() != null) {
			userId = physicalItem.getUser().getId();
		}

		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 获取入库单信息
		PhysicalItem physicalItem = physicalItemService.getById(id);
		// 主表信息
		physicalItem.setDate(date);
		physicalItem.setDescription(description);
		physicalItem.setUser(userService.getById(userId));

		for (int i = 0; i < lossNumber.length; i++) {
			// 添加修改之后的附表信息
			PhysicalMaterials physicalMaterials = physicalMaterialsService
					.getByMaterialsId(materialsId[i]);
			physicalMaterials.setRealNumber(realNumber[i]);
			physicalMaterials.setLossNumber(lossNumber[i]);
			physicalMaterials.setProfitNumber(profitNumber[i]);
			physicalMaterialsService.update(physicalMaterials);
		}
		return "toList";
	}

	// ===============审核=======================
	public String audit() throws Exception {
		// 获取要审核的入库单信息

		PhysicalItem physicalItem = physicalItemService.getById(id);
		// 审核入库单
		if (physicalItem.getCheckyn().equals("未审核")) {
			physicalItem.setCheckyn(PhysicalItem.CHECKY);
			physicalItem.setChecker(BaseAction.getCurrentUser().getName()); // 记录入库单的审核人
			physicalItemService.update(physicalItem);
		}
		return "toList";
	}

	// =============== 生成库存调整单 =============================
	public String createAdjust() throws Exception {
		if (physicalItemService.getById(id).getCheckyn().equals("已审核")) {
			AdjustmentItem adjustmentItem = new AdjustmentItem();
			adjustmentItem.setCheckyn(AdjustmentItem.CHECKN);
			adjustmentItem.setDate(new Date());
			adjustmentItemService.save(adjustmentItem);

			List<PhysicalMaterials> physicalMaterials = physicalMaterialsService
					.getByListId(id);
			for (PhysicalMaterials phMaterials : physicalMaterials) {
				AdjustmentMaterials adjustmentMaterials = new AdjustmentMaterials();
				adjustmentMaterials.setMaterials(phMaterials.getMaterials());
				adjustmentMaterials.setAdjustmentItem(adjustmentItem);

				if (phMaterials.getProfitNumber() != null) {
					adjustmentMaterials.setAdjustNumber(phMaterials
							.getProfitNumber());
					adjustmentMaterials.setDifferenceQuantity(phMaterials
							.getProfitNumber());
					adjustmentMaterials.setAdjustReason("盘盈调整");
				}
				if (phMaterials.getLossNumber() != null) {
					adjustmentMaterials.setAdjustNumber(phMaterials
							.getLossNumber());
					adjustmentMaterials.setDifferenceQuantity(phMaterials
							.getLossNumber());
					adjustmentMaterials.setAdjustReason("盘亏调整");
				}
				adjustmentMaterials.setNumber(phMaterials.getNumber());
				adjustmentMaterials.setRealNumber(phMaterials.getRealNumber());
				adjustmentMaterialsService.save(adjustmentMaterials);
				adjustmentItem.getAdjustmentMaterials()
						.add(adjustmentMaterials);
			}
			adjustmentItemService.update(adjustmentItem);
			return "createAdjust";
		} else {
			return "toList";
		}

	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCheckyn() {
		return checkyn;
	}

	public void setCheckyn(String checkyn) {
		this.checkyn = checkyn;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long[] getMaterialsId() {
		return materialsId;
	}

	public void setMaterialsId(Long[] materialsId) {
		this.materialsId = materialsId;
	}

	public Long[] getUnitId() {
		return unitId;
	}

	public void setUnitId(Long[] unitId) {
		this.unitId = unitId;
	}

	public Double[] getNumber() {
		return number;
	}

	public void setNumber(Double[] number) {
		this.number = number;
	}

	public Double[] getProfitNumber() {
		return profitNumber;
	}

	public void setProfitNumber(Double[] profitNumber) {
		this.profitNumber = profitNumber;
	}

	public Double[] getLossNumber() {
		return lossNumber;
	}

	public void setLossNumber(Double[] lossNumber) {
		this.lossNumber = lossNumber;
	}

	public Double[] getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(Double[] realNumber) {
		this.realNumber = realNumber;
	}

}
