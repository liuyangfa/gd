package org.gateway.gd.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.AllocationItem;
import org.gateway.gd.domain.AllocationMaterials;
import org.gateway.gd.domain.InventoryInItem;
import org.gateway.gd.domain.Materials;
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
 * 库存调拨
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AllocationAction extends BaseAction<Object> {

	private Long id; // 调拨单编号
	private Date date; // 调拨日期
	private String checkyn; // 审核标志
	private String checker; // 审核人
	private String description; // 说明
	private Long inWarehouseId;
	private Long outWarehouseId;
	private Long userId;

	private Double[] number; // 调拨数量
	private Long[] materialsId;
	private Long[] unitId;

	private int pageNum = 1;
	private int pageSize = 8;
	private List reaList;
	
	
	private Object data;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(AllocationMaterials.class,
				"alm").addOrderByProperty("id", true);
		PageBean pageBean = allocationMaterialsService.getPageBean(pageNum,
				pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		// 单据未审核就可以删除，否则不能删除
		if (allocationItemService.getById(id).getCheckyn().equals("未审核")) {
			allocationItemService.delete(id);
		}
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {

		// 准备需要选择的数据
		// 仓库的相关数据
		List<Warehouse> warehouseList = warehouseService.findAll();
		ActionContext.getContext().put("warehouseList", warehouseList);

		// 用户的相关数据
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);

		// 物料的相关数据
//		List<Materials> materialsList = materialsService.findAll();
//		ActionContext.getContext().put("materialsList", materialsList);

		// 单位相关数据
//		List<Unit> unitList = unitService.findAll();
//		ActionContext.getContext().put("unitList", unitList);

		// 显示单据当前的审核状态
		ActionContext.getContext().put("checkyn", InventoryInItem.CHECKN);

		// 当前日期
		DateFormat ddf = DateFormat.getDateInstance();
		String dateString = ddf.format(new Date());
		ActionContext.getContext().put("date", dateString);

		return "saveUI";
	}

	// 根据前台传回的outWarehouseId，获取到实时库存中的
	public String getMaterials() throws Exception {
		System.out.println(outWarehouseId);
		List<RealtimeInventory> realtimeInventories = realtimeInventoryService.getByWarehouseId(outWarehouseId);
		for(RealtimeInventory reInventory:realtimeInventories){
			reInventory.setUnit(null);
			Materials materials=reInventory.getMaterials();
			materials.setAdjustmentMaterials(null);
			materials.setAllocationMaterials(null);
			materials.setInventoryInMaterials(null);
			materials.setInventoryOutMaterials(null);
			materials.setRealtimeInventories(null);
			materials.setCategory(null);
			materials.setPhysicalMaterials(null);
			Warehouse warehouse=reInventory.getWarehouse();
			warehouse.setAllocationItem(null);
			warehouse.setAllocationItems(null);
			warehouse.setInventoryInItem(null);
			warehouse.setInventoryOutItem(null);
			warehouse.setPhysicalItems(null);
			warehouse.setPositions(null);
			warehouse.setRealtimeInventories(null);
			warehouse.setUsers(null);
		}
		data = realtimeInventories;
		return "ajax";
	}
	
	public String getUnit() throws Exception{
		System.out.println(materialsId[0]);
		RealtimeInventory realtimeInventory=realtimeInventoryService.getByMWId(materialsId[0], outWarehouseId);
		System.out.println(realtimeInventory.getMaterials().getName());
		realtimeInventory.setWarehouse(null);
		realtimeInventory.setMaterials(null);
		
		Unit unit=realtimeInventory.getUnit();
		unit.setAllocationMaterials(null);
		unit.setInventoryInMaterials(null);
		unit.setInventoryOutMaterials(null);
		unit.setPhysicalMaterials(null);
		unit.setRealtimeInventories(null);
		
		data = realtimeInventory;
		return "ajax";
	}
	
	// ==========添加=====================
	public String add() throws Exception {

		// 保存主表
		AllocationItem allocationItem = new AllocationItem();
		allocationItem.setCheckyn(AllocationItem.CHECKN);
		allocationItem.setDate(date);
		allocationItem.setDescription(description);
		allocationItem.setInWarehouse(warehouseService.getById(inWarehouseId));
		allocationItem
				.setOutWarehouse(warehouseService.getById(outWarehouseId));
		allocationItem.setUser(userService.getById(userId));
		allocationItemService.save(allocationItem);

		// 保存入库单附表，也就是入库单的表体部分
		for (int i = 0; i < materialsId.length; i++) {
			AllocationMaterials allocationMaterials = new AllocationMaterials();
			if (materialsId[i] == null || unitId[i] == null) {
				continue;
			}

			// 保存每一条物料信息
			allocationMaterials.setMaterials(materialsService
					.getById(materialsId[i]));
			allocationMaterials.setNumber(number[i]);
			allocationMaterials.setUnit(unitService.getById(unitId[i]));
			allocationMaterials.setAllocationItem(allocationItem);

			allocationMaterialsService.save(allocationMaterials);
			// 添加附表与主表的关联关系
			allocationItem.getAllocationMaterials().add(allocationMaterials);
		}
		// 更新主表与附表的关联关系
		allocationItemService.update(allocationItem);

		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
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
		AllocationItem allocationItem = allocationItemService.getById(id);
		ActionContext.getContext().getValueStack().push(allocationItem);

		// 附表信息（表体信息）
		List<AllocationMaterials> allocationMaterialsList = allocationMaterialsService
				.getByItemId(id);
		ActionContext.getContext().put("allocationMaterialsList",
				allocationMaterialsList);

		// 确定回显的已有数据
		if (allocationItem.getUser() != null) {
			userId = allocationItem.getUser().getId();
		}
		if (allocationItem.getInWarehouse() != null) {
			inWarehouseId = allocationItem.getInWarehouse().getId();
		}
		if (allocationItem.getOutWarehouse() != null) {
			outWarehouseId = allocationItem.getOutWarehouse().getId();
		}
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 保存主表
		AllocationItem allocationItem = allocationItemService.getById(id);
		allocationItem.setDate(date);
		allocationItem.setDescription(description);
		allocationItem.setInWarehouse(warehouseService.getById(inWarehouseId));
		allocationItem
				.setOutWarehouse(warehouseService.getById(outWarehouseId));
		allocationItem.setUser(userService.getById(userId));

		// 删除和主表有关的附表信息
		for (AllocationMaterials aMaterials : allocationItem
				.getAllocationMaterials()) {
			allocationMaterialsService.delete(aMaterials.getId());
		}

		// 保存入库单附表，也就是入库单的表体部分
		for (int i = 0; i < materialsId.length; i++) {
			AllocationMaterials allocationMaterials = new AllocationMaterials();
			if (materialsId[i] == null || unitId[i] == null) {
				continue;
			}

			// 保存每一条物料信息
			allocationMaterials.setMaterials(materialsService
					.getById(materialsId[i]));
			allocationMaterials.setNumber(number[i]);
			allocationMaterials.setUnit(unitService.getById(unitId[i]));
			allocationMaterials.setAllocationItem(allocationItem);

			allocationMaterialsService.save(allocationMaterials);
			// 添加附表与主表的关联关系
			allocationItem.getAllocationMaterials().add(allocationMaterials);
		}
		// 更新主表与附表的关联关系
		allocationItemService.update(allocationItem);
		return "toList";
	}

	// ===============审核=======================
	public String audit() throws Exception {
		// 获取要审核的入库单信息
		AllocationItem allocationItem = allocationItemService.getById(id);
		// 审核入库单
		if (allocationItem.getCheckyn().equals("未审核")) {
			allocationItem.setCheckyn(InventoryInItem.CHECKY);
			allocationItem.setChecker(BaseAction.getCurrentUser().getName()); // 记录入库单的审核人
			allocationItemService.update(allocationItem);
		}

		return "toList";
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

	public Long getInWarehouseId() {
		return inWarehouseId;
	}

	public void setInWarehouseId(Long inWarehouseId) {
		this.inWarehouseId = inWarehouseId;
	}

	public Long getOutWarehouseId() {
		return outWarehouseId;
	}

	public void setOutWarehouseId(Long outWarehouseId) {
		this.outWarehouseId = outWarehouseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double[] getNumber() {
		return number;
	}

	public void setNumber(Double[] number) {
		this.number = number;
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

	public List getReaList() {
		return reaList;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
