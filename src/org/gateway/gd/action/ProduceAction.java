package org.gateway.gd.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Department;
import org.gateway.gd.domain.InventoryOutItem;
import org.gateway.gd.domain.InventoryOutMaterials;
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
 * 生产领料出库单
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ProduceAction extends BaseAction<Object> {

	private Long itemId; // 出库单编号
	private Long warehouseId; // 仓库编号
	private Long departmentId; // 部门编号
	private Long userId; // 用户编号
	private String description; // 说明
	private Long[] materialsId; // 物料编号
	private Long[] unitId; // 单位编号
	private Double[] unitPrice; // 物料单价
	private Double[] number; // 物料数量
	private Double[] totalPrice;// 物料总金额
	private Date date; // 出库日期
	private String producer; // 制单人
	private String checkDate; // 审核日期
	private int pageNum = 1;
	private int pageSize = 10;
	private String condition;
	private String content;

	// =============搜索===================
	public String search() throws Exception {

		QueryHelper queryHelper = new QueryHelper(InventoryOutMaterials.class,
				"iom")
				.addOrderByProperty("iom.id", false)
				.addWhereCondition("iom.inventoryOutItem.outType=?",
						InventoryOutItem.TYPE1)
				.addWhereCondition("iom.inventoryOutItem.producer=?",
						BaseAction.getCurrentUser().getLoginName());
		if (condition.equals("date") && !content.equals("")) {
			queryHelper.addWhereCondition("iom.inventoryOutItem.date=?",
					java.sql.Date.valueOf(content.trim()));
			PageBean pageBean = inventoryOutMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("id") && !content.equals("")) {
			Long iLong = Long.parseLong(content.trim());
			queryHelper.addWhereCondition("iom.inventoryOutItem.id=?", iLong);
			PageBean pageBean = inventoryOutMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("userId") && !content.equals("")) {
			queryHelper.addWhereCondition(
					"iom.inventoryOutItem.user.name like ?",
					"%" + content.trim() + "%");
			PageBean pageBean = inventoryOutMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("checkyn") && !content.equals("")) {
			queryHelper.addWhereCondition(
					"iom.inventoryOutItem.checkyn like ?", "%" + content.trim()
							+ "%");
			PageBean pageBean = inventoryOutMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("warehouseId") && !content.equals("")) {
			queryHelper.addWhereCondition(
					"iom.inventoryOutItem.warehouse.name like ?",
					"%" + content.trim() + "%");
			PageBean pageBean = inventoryOutMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("departmentId") && !content.equals("")) {
			queryHelper.addWhereCondition(
					"iom.inventoryOutItem.department.name like ?", "%"
							+ content.trim() + "%");
			PageBean pageBean = inventoryOutMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("") || content.equals("")) {
			PageBean pageBean = inventoryOutMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}

		return "search";
	}

	// ==========列表=====================
	public String list() throws Exception {

		// 根据入库类型查找所有数据
		QueryHelper queryHelper = new QueryHelper(InventoryOutMaterials.class,
				"iom")
				.addOrderByProperty("iom.id", false)
				.addWhereCondition("iom.inventoryOutItem.outType=?",
						InventoryOutItem.TYPE1)
				.addWhereCondition("iom.inventoryOutItem.producer=?",
						BaseAction.getCurrentUser().getLoginName());
		PageBean pageBean = inventoryOutMaterialsService.getPageBean(pageNum,
				pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		if (inventoryOutItemService.getById(itemId).getCheckyn().equals("未审核")) {
			inventoryOutItemService.delete(itemId);
		}
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {

		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);

		List<Warehouse> warehouseList = warehouseService.findAll();
		ActionContext.getContext().put("warehouseList", warehouseList);

		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);

		List<RealtimeInventory> materialsList = realtimeInventoryService
				.findAll();
		ActionContext.getContext().put("materialsList", materialsList);

		List<Unit> unitList = unitService.findAll();
		ActionContext.getContext().put("unitList", unitList);

		// 显示单据当前的审核状态
		ActionContext.getContext().put("checkyn", InventoryOutItem.CHECKN);

		// 当前日期
		DateFormat ddf = DateFormat.getDateInstance();
		String dateString = ddf.format(new Date());
		ActionContext.getContext().put("date", dateString);

		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		InventoryOutItem inventoryOutItem = new InventoryOutItem();
		inventoryOutItem.setCheckyn(InventoryOutItem.CHECKN);
		inventoryOutItem.setOutType(InventoryOutItem.TYPE1);
		inventoryOutItem.setDescription(description);
		inventoryOutItem.setDate(date);
		inventoryOutItem.setProducer(BaseAction.getCurrentUser().getLoginName());
		inventoryOutItem.setDepartment(departmentService.getById(departmentId));
		inventoryOutItem.setWarehouse(warehouseService.getById(warehouseId));
		inventoryOutItem.setUser(userService.getById(userId));
		inventoryOutItemService.save(inventoryOutItem);

		for (int i = 0; i < materialsId.length; i++) {
			InventoryOutMaterials inventoryOutMaterials = new InventoryOutMaterials();
			if (materialsId[i] == null || unitId[i] == null) {
				continue;
			}
			inventoryOutMaterials.setMaterials(materialsService
					.getById(materialsId[i]));
			inventoryOutMaterials.setUnit(unitService.getById(unitId[i]));
			inventoryOutMaterials.setUnitPrice(unitPrice[i]);
			inventoryOutMaterials.setNumber(number[i]);
			inventoryOutMaterials.setTotalPrice(totalPrice[i]);
			inventoryOutMaterials.setInventoryOutItem(inventoryOutItem);
			inventoryOutMaterialsService.save(inventoryOutMaterials);
			inventoryOutItem.getInventoryOutMaterials().add(
					inventoryOutMaterials);
		}

		inventoryOutItemService.update(inventoryOutItem);

		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		// 部门列表
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);

		// 仓库列表
		List<Warehouse> warehouseList = warehouseService.findAll();
		ActionContext.getContext().put("warehouseList", warehouseList);

		// 用户列表
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);

		// 物料列表
		List<RealtimeInventory> materialsList = realtimeInventoryService
				.findAll();
		ActionContext.getContext().put("materialsList", materialsList);

		// 单位列表
		List<Unit> unitList = unitService.findAll();
		ActionContext.getContext().put("unitList", unitList);

		// 主体信息
		InventoryOutItem inventoryOutItem = inventoryOutItemService
				.getById(itemId);
		ActionContext.getContext().getValueStack().push(inventoryOutItem);

		List<InventoryOutMaterials> inventoryOutMaterialsList = inventoryOutMaterialsService
				.getByItemId(itemId);
		ActionContext.getContext().put("inventoryOutMaterialsList",
				inventoryOutMaterialsList);

		if (inventoryOutItem.getWarehouse() != null) {
			warehouseId = inventoryOutItem.getWarehouse().getId();
		}
		if (inventoryOutItem.getUser() != null) {
			userId = inventoryOutItem.getUser().getId();
		}
		if (inventoryOutItem.getDepartment() != null) {
			departmentId = inventoryOutItem.getDepartment().getId();
		}

		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		InventoryOutItem inventoryOutItem = inventoryOutItemService
				.getById(itemId);
		// 公共信息
		inventoryOutItem.setDate(date);
		inventoryOutItem.setDescription(description);
		inventoryOutItem.setWarehouse(warehouseService.getById(warehouseId));
		inventoryOutItem.setUser(userService.getById(userId));
		inventoryOutItem.setDepartment(departmentService.getById(departmentId));

		for (InventoryOutMaterials outMaterials : inventoryOutItem
				.getInventoryOutMaterials()) {
			inventoryOutMaterialsService.delete(outMaterials.getId());
		}
		for (int i = 0; i < materialsId.length; i++) {
			InventoryOutMaterials outMaterials = new InventoryOutMaterials();
			outMaterials.setUnit(unitService.getById(unitId[i]));
			outMaterials.setMaterials(materialsService.getById(materialsId[i]));
			outMaterials.setUnitPrice(unitPrice[i]);
			outMaterials.setNumber(number[i]);
			outMaterials.setTotalPrice(totalPrice[i]);
			outMaterials.setInventoryOutItem(inventoryOutItem);
			inventoryOutMaterialsService.save(outMaterials);
			// 设置关联关系
			inventoryOutItem.getInventoryOutMaterials().add(outMaterials);
		}

		inventoryOutItemService.update(inventoryOutItem);
		return "toList";

	}

	// ===============审核=======================
	@SuppressWarnings("deprecation")
	public String audit() throws Exception {
		InventoryOutItem outItem = inventoryOutItemService.getById(itemId);
		// 审核出库单
		if (outItem.getCheckyn().equals("未审核")) {
			outItem.setCheckyn(InventoryOutItem.CHECKY);
			outItem.setChecker(BaseAction.getCurrentUser().getName());
			outItem.setCheckDate(new Date().toLocaleString());
			inventoryOutItemService.update(outItem);
		}
		// 与此审核的入库单有关的表体数据
		List<InventoryOutMaterials> inventoryOutMaterials = inventoryOutMaterialsService
				.getByItemId(outItem.getId());

		for (InventoryOutMaterials outMaterials : inventoryOutMaterials) {
			// 获取实时库存表中的数据
			RealtimeInventory reList = realtimeInventoryService.getByMWId(
					outMaterials.getMaterials().getId(), outMaterials
							.getInventoryOutItem().getWarehouse().getId());
			if (reList != null) {
				reList.setNumber(reList.getNumber() - outMaterials.getNumber());
				realtimeInventoryService.update(reList);
			}
		}
		return "toList";
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
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

	public Double[] getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double[] unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double[] getNumber() {
		return number;
	}

	public void setNumber(Double[] number) {
		this.number = number;
	}

	public Double[] getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double[] totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

}
