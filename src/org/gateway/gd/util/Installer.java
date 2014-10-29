package org.gateway.gd.util;

import javax.annotation.Resource;

import org.gateway.gd.domain.Privilege;
import org.gateway.gd.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * 安装时的初始化操作，只能在安装时做一次
 * 
 * @author gateway
 * 
 */
@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();

		// 插入一个超级管理员用户
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));// 密码为"admin"的md5的摘要
		session.save(user);

		Privilege menu, menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9, menu10, menu11;

		// ======================入库管理============================================
		menu = new Privilege("入库管理", null, "fa fa-code-fork", null);
		menu1 = new Privilege("外购入库", "purchaseAction_list",
				"fa fa-arrow-circle-o-right", menu);
		menu2 = new Privilege("产品入库", "productAction_list",
				"fa fa-arrow-circle-o-right", menu);
		menu3 = new Privilege("其他入库", "otherInAction_list",
				"fa fa-arrow-circle-o-right", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		// 外购入库
		session.save(new Privilege("外购入库单列表", "purchaseAction_list", null,
				menu1));
		session.save(new Privilege("外购入库单添加", "purchaseAction_add", null, menu1));
		session.save(new Privilege("外购入库单修改", "purchaseAction_edit", null,
				menu1));
		session.save(new Privilege("外购入库单删除", "purchaseAction_delete", null,
				menu1));
		session.save(new Privilege("外购入库单审核", "purchaseAction_audit", null,
				menu1));

		// 产品入库
		session.save(new Privilege("产品入库单列表", "productAction_list", null, menu2));
		session.save(new Privilege("产品入库单添加", "productAction_add", null, menu2));
		session.save(new Privilege("产品入库单修改", "productAction_edit", null, menu2));
		session.save(new Privilege("产品入库单删除", "productAction_delete", null,
				menu2));
		session.save(new Privilege("产品入库单审核", "productAction_audit", null,
				menu2));

		// 其他入库
		session.save(new Privilege("其他入库单列表", "otherInAction_list", null, menu3));
		session.save(new Privilege("其他入库单添加", "otherInAction_add", null, menu3));
		session.save(new Privilege("其他入库单修改", "otherInAction_edit", null, menu3));
		session.save(new Privilege("其他入库单删除", "otherInAction_delete", null,
				menu3));
		session.save(new Privilege("其他入库单审核", "otherInAction_audit", null,
				menu3));

		// ======================出库管理============================================
		menu = new Privilege("出库管理", null, "fa fa-steam", null);
		menu1 = new Privilege("生产领料出库", "produceAction_list",
				"fa fa-arrow-circle-o-left", menu);
		menu2 = new Privilege("销售出库", "salesAction_list",
				"fa fa-arrow-circle-o-left", menu);
		menu3 = new Privilege("其他出库", "otherOutAction_list",
				"fa fa-arrow-circle-o-left", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		// 生产领料出库
		session.save(new Privilege("生产领料出库单列表", "produceAction_list", null,
				menu1));
		session.save(new Privilege("生产领料出库单添加", "produceAction_add", null,
				menu1));
		session.save(new Privilege("生产领料出库单修改", "produceAction_edit", null,
				menu1));
		session.save(new Privilege("生产领料出库单删除", "produceAction_delete", null,
				menu1));
		session.save(new Privilege("生产领料出库单审核", "produceAction_audit", null,
				menu1));

		// 销售出库
		session.save(new Privilege("销售出库单列表", "salesAction_list", null, menu2));
		session.save(new Privilege("销售出库单添加", "salesAction_add", null, menu2));
		session.save(new Privilege("销售出库单修改", "salesAction_edit", null, menu2));
		session.save(new Privilege("销售出库单删除", "salesAction_delete", null, menu2));
		session.save(new Privilege("销售出库单审核", "salesAction_audit", null, menu2));

		// 其他出库
		session.save(new Privilege("其他出库单列表", "otherOutAction_list", null,
				menu3));
		session.save(new Privilege("其他出库单添加", "otherOutAction_add", null, menu3));
		session.save(new Privilege("其他出库单修改", "otherOutAction_edit", null,
				menu3));
		session.save(new Privilege("其他出库单删除", "otherOutAction_delete", null,
				menu3));
		session.save(new Privilege("其他出库单审核", "otherOutAction_audit", null,
				menu3));

		// ======================库存管理============================================
		menu = new Privilege("库存管理", null, "fa fa-database", null);
		menu1 = new Privilege("实时库存管理", "realtimeInventoryAction_list",
				"fa fa-jsfiddle", menu);
		menu2 = new Privilege("库存盘点管理", "physicalAction_list", "fa fa-sitemap",
				menu);
		menu3 = new Privilege("库存调拨管理", "allocationAction_list",
				"fa fa-retweet", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		// 实时库存管理
		session.save(new Privilege("实时库存列表", "realtimeInventoryAction_list",
				null, menu1));

		// 库存盘点管理
		session.save(new Privilege("库存盘点列表", "physicalAction_list", null, menu2));
		session.save(new Privilege("库存盘点添加", "physicalAction_add", null, menu2));
		session.save(new Privilege("库存盘点修改", "physicalAction_edit", null, menu2));
		session.save(new Privilege("库存盘点删除", "physicalAction_delete", null,
				menu2));
		session.save(new Privilege("库存盘点审核", "physicalAction_audit", null,
				menu2));
		session.save(new Privilege("库存调整单添加", "adjustmentAction_add", null,
				menu2));
		session.save(new Privilege("库存调整单审核", "adjustmentAction_audit", null,
				menu2));
		session.save(new Privilege("库存调整单修改", "adjustmentAction_edit", null,
				menu2));
		session.save(new Privilege("库存调整单删除", "adjustmentAction_delete", null,
				menu2));

		// 库存调拨管理
		session.save(new Privilege("库存调拨单列表", "allocationAction_list", null,
				menu3));
		session.save(new Privilege("库存调拨单添加", "allocationAction_add", null,
				menu3));
		session.save(new Privilege("库存调拨单修改", "allocationAction_edit", null,
				menu3));
		session.save(new Privilege("库存调拨单删除", "allocationAction_delete", null,
				menu3));
		session.save(new Privilege("库存调拨单审核", "allocationAction_audit", null,
				menu3));

		// =======================决策分析=======================================
		menu = new Privilege("决策分析管理", null, "fa fa-folder-open", null);
		menu1 = new Privilege("呆滞料管理", "sluggishAction_list", "fa fa-leaf",
				menu);
		menu2 = new Privilege("库存预警管理", "inventoryWarnAction_list",
				"fa fa-exclamation", menu);
		menu3 = new Privilege("ABC分类管理", "baseDataAction_list ",
				"fa fa-magic", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		// 呆滞料管理
		session.save(new Privilege("呆滞料列表", "sluggishAction_list", null, menu1));
		session.save(new Privilege("呆滞料删除", "sluggishAction_delete", null,
				menu1));

		// 库存预警管理
		session.save(new Privilege("库存预警列表", "inventoryWarnAction_list", null,
				menu2));
		session.save(new Privilege("库存预警删除", "inventoryWarnAction_delete",
				null, menu2));

		// ==================个人设置=============================================
		menu = new Privilege("个人设置", null, "fa fa-wrench", null);
		menu1 = new Privilege("个人信息", "personAction_list", "fa fa-info-circle",
				menu);
		menu2 = new Privilege("密码修改", "passwordAction_list", "fa fa-key", menu);
		menu3 = new Privilege("系统通知", "systemNoticeAction_list", "fa fa-bell",
				menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		// 个人信息
		session.save(new Privilege("个人信息列表", "personAction_list", null, menu1));
		session.save(new Privilege("个人信息修改", "personAction_edit", null, menu1));
		
		// 密码修改
		session.save(new Privilege("密码修改", "passwordAction_edit", null, menu2));

		// =======================系统设置========================================
		// 插入权限数据
		menu = new Privilege("系统管理", null, "fa fa-cog", null);
		menu1 = new Privilege("岗位管理", "roleAction_list", "fa fa-group", menu);
		menu2 = new Privilege("部门管理", "departmentAction_list",
				"fa fa-institution", menu);
		menu3 = new Privilege("用户管理", "userAction_list", "fa fa-user", menu);
		menu4 = new Privilege("供应商管理", "supplierAction_list", "fa fa-truck",
				menu);
		menu5 = new Privilege("客户管理", "consumerAction_list", "fa fa-user-md",
				menu);
		menu6 = new Privilege("仓库管理", "warehouseAction_list",
				"fa fa-stumbleupon", menu);
		menu7 = new Privilege("仓位管理", "positionAction_list",
				"fa fa-stumbleupon-circle", menu);
		menu8 = new Privilege("物料类别管理", "categoryAction_list", "fa fa-ge", menu);
		menu9 = new Privilege("计量单位管理", "unitAction_list", "fa fa-rocket", menu);
		menu10 = new Privilege("物料管理", "materialsAction_list", "fa fa-ra", menu);
		menu11 = new Privilege("系统日志管理", "systemlogAction_list",
				"fa fa-exchange", menu);

		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
		session.save(menu6);
		session.save(menu7);
		session.save(menu8);
		session.save(menu9);
		session.save(menu10);
		session.save(menu11);

		// 岗位管理
		session.save(new Privilege("岗位列表", "roleAction_list", null, menu1));
		session.save(new Privilege("岗位添加", "roleAction_add", null, menu1));
		session.save(new Privilege("岗位删除", "roleAction_delete", null, menu1));
		session.save(new Privilege("岗位修改", "roleAction_edit", null, menu1));
		session.save(new Privilege("设置权限", "roleAction_setPrivilege", null,
				menu1));

		// 部门管理
		session.save(new Privilege("部门列表", "departmentAction_list", null, menu2));
		session.save(new Privilege("部门添加", "departmentAction_add", null, menu2));
		session.save(new Privilege("部门删除", "departmentAction_delete", null,
				menu2));
		session.save(new Privilege("部门修改", "departmentAction_edit", null, menu2));

		// 用户管理
		session.save(new Privilege("用户列表", "userAction_list", null, menu3));
		session.save(new Privilege("用户添加", "userAction_add", null, menu3));
		session.save(new Privilege("用户删除", "userAction_delete", null, menu3));
		session.save(new Privilege("用户修改", "userAction_edit", null, menu3));
		session.save(new Privilege("初始化密码", "userAction_initPassword", null,
				menu3));

		// 供应商管理
		session.save(new Privilege("供应商列表", "supplierAction_list", null, menu4));
		session.save(new Privilege("供应商添加", "supplierAction_add", null, menu4));
		session.save(new Privilege("供应商删除", "supplierAction_delete", null,
				menu4));
		session.save(new Privilege("供应商修改", "supplierAction_edit", null, menu4));

		// 客户管理
		session.save(new Privilege("客户列表", "consumerAction_list", null, menu5));
		session.save(new Privilege("客户添加", "consumerAction_add", null, menu5));
		session.save(new Privilege("客户删除", "consumerAction_delete", null, menu5));
		session.save(new Privilege("客户修改", "consumerAction_edit", null, menu5));

		// 仓库管理
		session.save(new Privilege("仓库列表", "warehouseAction_list", null, menu6));
		session.save(new Privilege("仓库添加", "warehouseAction_add", null, menu6));
		session.save(new Privilege("仓库删除", "warehouseAction_delete", null,
				menu6));
		session.save(new Privilege("仓库修改", "warehouseAction_edit", null, menu6));

		// 仓位管理
		session.save(new Privilege("仓位列表", "positionAction_list", null, menu7));
		session.save(new Privilege("仓位添加", "positionAction_add", null, menu7));
		session.save(new Privilege("仓位删除", "positionAction_delete", null, menu7));
		session.save(new Privilege("仓位修改", "positionAction_edit", null, menu7));

		// 物料类别管理
		session.save(new Privilege("物料类别列表", "categoryAction_list", null, menu8));
		session.save(new Privilege("物料类别添加", "categoryAction_add", null, menu8));
		session.save(new Privilege("物料类别删除", "categoryAction_delete", null,
				menu8));
		session.save(new Privilege("物料类别修改", "categoryAction_edit", null, menu8));

		// 计量单位管理
		session.save(new Privilege("计量单位列表", "unitAction_list", null, menu9));
		session.save(new Privilege("计量单位添加", "unitAction_add", null, menu9));
		session.save(new Privilege("计量单位删除", "unitAction_delete", null, menu9));
		session.save(new Privilege("计量单位修改", "unitAction_edit", null, menu9));

		// 物料管理
		session.save(new Privilege("物料列表", "materialsAction_list", null, menu10));
		session.save(new Privilege("物料添加", "materialsAction_add", null, menu10));
		session.save(new Privilege("物料修改", "materialsAction_edit", null, menu10));
		session.save(new Privilege("物料删除", "materialsAction_delete", null,
				menu10));

		// 系统日志管理
		session.save(new Privilege("系统日志列表", "systemlogAction_list", null,
				menu11));

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Installer install = (Installer) ac.getBean("installer");
		install.install();
		System.out.println("=======安装成功=========");
	}
}
