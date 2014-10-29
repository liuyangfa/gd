package org.gateway.gd.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.InventoryInItem;
import org.gateway.gd.domain.InventoryInMaterials;
import org.gateway.gd.domain.InventoryWarn;
import org.gateway.gd.domain.Materials;
import org.gateway.gd.domain.RealtimeInventory;
import org.gateway.gd.domain.Supplier;
import org.gateway.gd.domain.Unit;
import org.gateway.gd.domain.User;
import org.gateway.gd.domain.Warehouse;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

/**
 * 外购入库单
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PurchaseAction extends BaseAction<Object> {

	private Long itemId; // 入库单主表编号
	private Long supplierId; // 供应商编号
	private Long warehouseId; // 仓库编号
	private Long userId; // 用户编号
	private String checker; // 审核人
	private Long[] materialsId; // 物料编号
	private Long[] unitId; // 单位编号
	private Double[] unitPrice; // 物料单价
	private Double[] number; // 物料数量
	private Double[] totalPrice;// 物料总金额
	private Date date; // 入库日期
	private String producer; // 制单人
	private String checkDate; // 审核日期
	private int pageNum = 1;
	private int pageSize = 10;
	private String condition;
	private String content;

	// =============搜索===================
	public String search() throws Exception {

		QueryHelper queryHelper = new QueryHelper(InventoryInMaterials.class,
				"iim").addOrderByProperty("iim.inventoryInItem.id", false)
				.addWhereCondition("iim.inventoryInItem.inType=?",
						InventoryInItem.TYPE1)
				.addWhereCondition("iim.inventoryInItem.producer=?", BaseAction.getCurrentUser().getLoginName());
		if (condition.equals("date") && !content.equals("")) {
			queryHelper.addWhereCondition("iim.inventoryInItem.date=?",
					java.sql.Date.valueOf(content.trim()));
			PageBean pageBean = inventoryInMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("id") && !content.equals("")) {
			Long iLong = Long.parseLong(content.trim());
			queryHelper.addWhereCondition("iim.inventoryInItem.id=?", iLong);
			PageBean pageBean = inventoryInMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("userId") && !content.equals("")) {
			queryHelper.addWhereCondition(
					"iim.inventoryInItem.user.name like ?",
					"%" + content.trim() + "%");
			PageBean pageBean = inventoryInMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("checkyn") && !content.equals("")) {
			queryHelper.addWhereCondition("iim.inventoryInItem.checkyn like ?",
					"%" + content.trim() + "%");
			PageBean pageBean = inventoryInMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("warehouseId") && !content.equals("")) {
			queryHelper.addWhereCondition(
					"iim.inventoryInItem.warehouse.name like ?",
					"%" + content.trim() + "%");
			PageBean pageBean = inventoryInMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (condition.equals("supplierId") && !content.equals("")) {
			queryHelper.addWhereCondition(
					"iim.inventoryInItem.supplier.name like ?",
					"%" + content.trim() + "%");
			PageBean pageBean = inventoryInMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		if (content.trim().equals("") || condition.equals("")) {
			PageBean pageBean = inventoryInMaterialsService.getPageBean(
					pageNum, pageSize, queryHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		return "search";

	}

	// ==========列表=====================
	public String list() throws Exception {
		// 根据入库类型查找所有数据
		QueryHelper queryHelper = new QueryHelper(InventoryInMaterials.class,
				"iim")
				.addOrderByProperty("iim.inventoryInItem.id", false)
				.addWhereCondition("iim.inventoryInItem.inType=?",
						InventoryInItem.TYPE1)
				.addWhereCondition("iim.inventoryInItem.producer=?",
						BaseAction.getCurrentUser().getLoginName());
		PageBean pageBean = inventoryInMaterialsService.getPageBean(pageNum,
				pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	// =============删除=====================
	public String delete() throws Exception {
		// 单据未审核就可以删除，否则不能删除
		if (inventoryInItemService.getById(itemId).getCheckyn().equals("未审核")) {
			inventoryInItemService.delete(itemId);
		}
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		// 准备需要选择的数据
		// 供应商的相关数据
		List<Supplier> supplierList = supplierService.findAll();
		ActionContext.getContext().put("supplierList", supplierList);

		// 仓库的相关数据
		List<Warehouse> warehouseList = warehouseService.findAll();
		ActionContext.getContext().put("warehouseList", warehouseList);

		// 用户的相关数据
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);

		// 物料的相关数据
		List<Materials> materialsList = materialsService.findAll();
		ActionContext.getContext().put("materialsList", materialsList);

		// 单位相关数据
		List<Unit> unitList = unitService.findAll();
		ActionContext.getContext().put("unitList", unitList);

		// 显示单据当前的审核状态
		ActionContext.getContext().put("checkyn", InventoryInItem.CHECKN);

		// 当前日期
		DateFormat ddf = DateFormat.getDateInstance();
		String dateString = ddf.format(new Date());
		ActionContext.getContext().put("date", dateString);

		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		// 保存入库单主表
		InventoryInItem inventoryInItem = new InventoryInItem();
		inventoryInItem.setCheckyn(InventoryInItem.CHECKN); // 默认的审核状态为未审核
		inventoryInItem.setInType(InventoryInItem.TYPE1); // 入库类型为外购入库
		inventoryInItem.setSupplier(supplierService.getById(supplierId));
		inventoryInItem.setDate(date);
		inventoryInItem.setProducer(BaseAction.getCurrentUser().getLoginName());
		inventoryInItem.setWarehouse(warehouseService.getById(warehouseId));
		inventoryInItem.setUser(userService.getById(userId));
		inventoryInItemService.save(inventoryInItem);

		// 保存入库单附表，也就是入库单的表体部分
		for (int i = 0; i < materialsId.length; i++) {
			InventoryInMaterials inventoryInMaterials = new InventoryInMaterials();
			if (materialsId[i] == null || unitId[i] == null) {
				continue;
			}
			// 保存每一条物料信息
			inventoryInMaterials.setMaterials(materialsService
					.getById(materialsId[i]));
			inventoryInMaterials.setUnit(unitService.getById(unitId[i]));
			inventoryInMaterials.setUnitPrice(unitPrice[i]);
			inventoryInMaterials.setNumber(number[i]);
			inventoryInMaterials.setTotalPrice(totalPrice[i]);
			inventoryInMaterials.setInventoryInItem(inventoryInItem);
			inventoryInMaterialsService.save(inventoryInMaterials);
			// 添加附表与主表的关联关系
			inventoryInItem.getInventoryInMaterials().add(inventoryInMaterials);
		}
		// 更新主表与附表的关联关系
		inventoryInItemService.update(inventoryInItem);

		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		// 供应商列表
		List<Supplier> supplierList = supplierService.findAll();
		ActionContext.getContext().put("supplierList", supplierList);

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
		InventoryInItem inventoryInItem = inventoryInItemService
				.getById(itemId);
		ActionContext.getContext().getValueStack().push(inventoryInItem);

		// 附表信息（表体信息）
		List<InventoryInMaterials> inventoryInMaterialsList = inventoryInMaterialsService
				.getByItemId(itemId);
		ActionContext.getContext().put("inventoryInMaterialsList",
				inventoryInMaterialsList);

		// 确定回显的已有数据
		if (inventoryInItem.getSupplier() != null) {
			supplierId = inventoryInItem.getSupplier().getId();
		}
		if (inventoryInItem.getWarehouse() != null) {
			warehouseId = inventoryInItem.getWarehouse().getId();
		}
		if (inventoryInItem.getUser() != null) {
			userId = inventoryInItem.getUser().getId();
		}

		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 获取入库单信息
		InventoryInItem inventoryInItem = inventoryInItemService
				.getById(itemId);
		// 主表信息
		inventoryInItem.setSupplier(supplierService.getById(supplierId));
		inventoryInItem.setDate(date);
		inventoryInItem.setWarehouse(warehouseService.getById(warehouseId));
		inventoryInItem.setUser(userService.getById(userId));

		// 删除和主表有关的附表信息
		for (InventoryInMaterials inMaterials : inventoryInItem
				.getInventoryInMaterials()) {
			inventoryInMaterialsService.delete(inMaterials.getId());
		}
		for (int i = 0; i < materialsId.length; i++) {
			// 添加修改之后的附表信息
			InventoryInMaterials inMaterials = new InventoryInMaterials();
			inMaterials.setUnit(unitService.getById(unitId[i]));
			inMaterials.setMaterials(materialsService.getById(materialsId[i]));
			inMaterials.setUnitPrice(unitPrice[i]);
			inMaterials.setNumber(number[i]);
			inMaterials.setTotalPrice(totalPrice[i]);
			inMaterials.setInventoryInItem(inventoryInItem);
			inventoryInMaterialsService.save(inMaterials);
			// 设置关联关系
			inventoryInItem.getInventoryInMaterials().add(inMaterials);
		}
		// 更新主表与附表的关联关系
		inventoryInItemService.update(inventoryInItem);

		return "toList";

	}

	// ===============审核=======================
	@SuppressWarnings("deprecation")
	public String audit() throws Exception {
		// 获取要审核的入库单信息
		InventoryInItem inItem = inventoryInItemService.getById(itemId);
		// 审核入库单
		if (inItem.getCheckyn().equals("未审核")) {
			inItem.setCheckyn(InventoryInItem.CHECKY);
			inItem.setChecker(BaseAction.getCurrentUser().getName()); // 记录入库单的审核人
			inItem.setCheckDate(new Date().toLocaleString());
			inventoryInItemService.update(inItem);
		}

		/**
		 * 实时库存表数据的添加，修改 同时检查最低库存和安全库存
		 * 
		 */
		// 与此审核的入库单有关的表体数据
		List<InventoryInMaterials> inventoryInMaterials = inventoryInMaterialsService
				.getByItemId(inItem.getId());

		for (InventoryInMaterials inMaterials : inventoryInMaterials) {
			// 获取实时库存表中的数据
			RealtimeInventory reList = realtimeInventoryService.getByMWId(
					inMaterials.getMaterials().getId(), inMaterials
							.getInventoryInItem().getWarehouse().getId());
			// 判断在实时库存表中是否有此物料
			if (reList != null) {
				reList.setDate(new Date());
				reList.setNumber(inMaterials.getNumber() + reList.getNumber());
				realtimeInventoryService.update(reList);

				// 在库存预警表中添加相关物料信息
				InventoryWarn inWarn = inventoryWarnService
						.getByMaterialsName(reList.getMaterials().getName());
				if (inWarn == null) {
					InventoryWarn inventoryWarn = new InventoryWarn();
					inventoryWarn.setMaterialsName(reList.getMaterials()
							.getName());
					inventoryWarn.setHighestInventory(reList.getMaterials()
							.getHighestInventory());
					inventoryWarn.setChangeNumber(reList.getNumber());
					inventoryWarn.setLowestInventory(reList.getMaterials()
							.getLowestInventory());
					inventoryWarn.setCategory(reList.getMaterials()
							.getCategory().getName());
					inventoryWarn.setRealInventory(reList.getNumber());
					inventoryWarn.setSafeInventory(reList.getMaterials()
							.getSafeInventory());
					inventoryWarn.setUnitName(reList.getUnit().getName());
					inventoryWarnService.save(inventoryWarn);
				} else {
					inWarn.setChangeNumber(reList.getNumber());
					inWarn.setRealInventory(reList.getNumber());
					inventoryWarnService.update(inWarn);
				}
			} else {
				RealtimeInventory realtimeInventory = new RealtimeInventory();
				realtimeInventory.setMaterials(inMaterials.getMaterials());
				realtimeInventory.setWarehouse(inMaterials.getInventoryInItem()
						.getWarehouse());
				realtimeInventory.setUnit(inMaterials.getUnit());
				realtimeInventory.setNumber(inMaterials.getNumber());
				realtimeInventory.setDate(new Date());
				realtimeInventoryService.save(realtimeInventory);

				// 在库存预警表中添加相关物料信息
				// 判断库存预警表中是否有此物料
				InventoryWarn inventoryWarn = inventoryWarnService
						.getByMaterialsName(inMaterials.getMaterials()
								.getName());

				if (inventoryWarn == null) {
					InventoryWarn inWarn = new InventoryWarn();
					inWarn.setMaterialsName(inMaterials.getMaterials()
							.getName());
					inWarn.setHighestInventory(inMaterials.getMaterials()
							.getHighestInventory());
					inWarn.setLowestInventory(inMaterials.getMaterials()
							.getLowestInventory());
					inWarn.setChangeNumber(inMaterials.getNumber());
					inWarn.setCategory(inMaterials.getMaterials().getCategory()
							.getName());
					inWarn.setRealInventory(inMaterials.getNumber());
					inWarn.setSafeInventory(inMaterials.getMaterials()
							.getSafeInventory());
					inWarn.setUnitName(inMaterials.getUnit().getName());
					inventoryWarnService.save(inWarn);
				} else {
					inventoryWarn.setChangeNumber(inMaterials.getNumber());
					inventoryWarn.setRealInventory(inMaterials.getNumber());
					inventoryWarnService.update(inventoryWarn);
				}
			}

		}

		return "toList";
	}

	// ------------- getter and setter method----------------------------
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
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
