package org.gateway.gd.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.gateway.gd.domain.User;
import org.gateway.gd.service.AbcAnalysisService;
import org.gateway.gd.service.AdjustmentItemService;
import org.gateway.gd.service.AdjustmentMaterialsService;
import org.gateway.gd.service.AllocationItemService;
import org.gateway.gd.service.AllocationMaterialsService;
import org.gateway.gd.service.BaseDataService;
import org.gateway.gd.service.CategoryService;
import org.gateway.gd.service.ConsumerService;
import org.gateway.gd.service.DepartmentService;
import org.gateway.gd.service.InventoryInItemService;
import org.gateway.gd.service.InventoryInMaterialsService;
import org.gateway.gd.service.InventoryOutItemService;
import org.gateway.gd.service.InventoryOutMaterialsService;
import org.gateway.gd.service.InventoryWarnService;
import org.gateway.gd.service.MaterialsService;
import org.gateway.gd.service.PhysicalItemService;
import org.gateway.gd.service.PhysicalMaterialsService;
import org.gateway.gd.service.PositionService;
import org.gateway.gd.service.PrivilegeService;
import org.gateway.gd.service.RealtimeInventoryService;
import org.gateway.gd.service.RoleService;
import org.gateway.gd.service.SluggishMaterialsService;
import org.gateway.gd.service.SupplierService;
import org.gateway.gd.service.SystemLogService;
import org.gateway.gd.service.SystemNoticeService;
import org.gateway.gd.service.UnitService;
import org.gateway.gd.service.UserService;
import org.gateway.gd.service.WarehouseService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 提供modelDriven支持和service的公用
 * 
 * @author gateway
 * 
 * @param <T>
 */
@SuppressWarnings("serial")
public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	// ------------ModelDriven的支持--------------
	protected T model;

	protected Class<T> modelClass;

	@SuppressWarnings("unchecked")
	public BaseAction() {

		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			modelClass = (Class<T>) pt.getActualTypeArguments()[0];
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {

		try {
			if (model == null) {
				// 通过反射创建model的实例
				model = modelClass.newInstance();
			}
			return model;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 获取当前登录用户
	 */
	public static User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}

	// -----------所有service的实例声明---------------

	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected SystemLogService systemLogService;
	@Resource
	protected ConsumerService consumerService;
	@Resource
	protected SupplierService supplierService;
	@Resource
	protected WarehouseService warehouseService;
	@Resource
	protected PositionService positionService;
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected UnitService unitService;
	@Resource
	protected MaterialsService materialsService;
	@Resource
	protected InventoryInItemService inventoryInItemService;
	@Resource
	protected InventoryInMaterialsService inventoryInMaterialsService;
	@Resource
	protected InventoryOutItemService inventoryOutItemService;
	@Resource
	protected InventoryOutMaterialsService inventoryOutMaterialsService;
	@Resource
	protected RealtimeInventoryService realtimeInventoryService;
	@Resource
	protected PhysicalItemService physicalItemService;
	@Resource
	protected PhysicalMaterialsService physicalMaterialsService;
	@Resource
	protected AdjustmentItemService adjustmentItemService;
	@Resource
	protected AdjustmentMaterialsService adjustmentMaterialsService;
	@Resource
	protected AllocationItemService allocationItemService;
	@Resource
	protected AllocationMaterialsService allocationMaterialsService;
	@Resource
	protected SluggishMaterialsService sluggishMaterialsService;
	@Resource
	protected InventoryWarnService inventoryWarnService;
	@Resource
	protected SystemNoticeService systemNoticeService;
	@Resource
	protected AbcAnalysisService abcAnalysisService;
	@Resource
	protected BaseDataService baseDataService;
}
