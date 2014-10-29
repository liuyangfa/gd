package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

/**
 * 用户实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	// -----------field------------------------------------
	private Long id;
	private String name;
	private String loginName;
	private String password;
	private Date birthday;
	private String sex;
	private String phoneNumber;
	private String email;
	private String address;
	private String description;

	private Department department;// 所属部门
	private Set<Role> roles = new HashSet<Role>();
	private Set<Warehouse> warehouses = new HashSet<Warehouse>();
	private Set<Systemlog> systemlogs = new HashSet<Systemlog>();
	private Set<SystemNotice> systemNotices = new HashSet<SystemNotice>();
	private Set<InventoryInItem> inventoryInItems = new HashSet<InventoryInItem>();
	private Set<InventoryOutItem> inventoryOutItem = new HashSet<InventoryOutItem>();
	private Set<PhysicalItem> physicalItems = new HashSet<PhysicalItem>();
	private Set<AllocationItem> allocationItems = new HashSet<AllocationItem>();
	private Set<AdjustmentItem> adjustmentItems = new HashSet<AdjustmentItem>();

	/**
	 * 检测本用户是否拥有指定名称的权限
	 * 
	 * @param privilegeName
	 * @return
	 */
	public boolean hasPrivilegeByName(String privilegeName) {
		// 超级管理员
		if (isAdmin()) {
			return true;
		}

		// 普通用户
		for (Role role : roles) {
			for (Privilege privilege : role.getPrivileges()) {
				if (privilegeName.equals(privilege.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 检测本用户是否拥有指定URL的权限
	 * 
	 * @param url
	 *            (actionName)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean hasPrivilegeByUrl(String url) {
		// 超级管理员
		if (isAdmin()) {
			return true;
		}

		// >> 去掉后面的参数
		int pos = url.indexOf("?");
		if (pos > -1) {
			url = url.substring(0, pos); // 去掉参数
		}
		// >> 去掉UI后缀（例：userAction_addUI就是userAction_add权限）
		if (url.endsWith("UI")) {
			url = url.substring(0, url.length() - 2);
		}

		// 如果本URL不需要控制，则登录用户就可以使用
		// 普通用户
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext
				.getContext().getApplication().get("allPrivilegeUrls");// 所有需要控制权限的URL集合
		if (!allPrivilegeUrls.contains(url)) {// 不需要权限控制，登录后就能访问
			return true;
		} else {// 需要权限控制，则有权限后才能访问
			for (Role role : roles) {
				for (Privilege privilege : role.getPrivileges()) {
					if (url.equals(privilege.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}

	}

	/**
	 * 判断当前用户是否是超级管理员
	 * 
	 * @return
	 */
	public boolean isAdmin() {
		return "admin".equals(loginName);
	}

	// ================setter and getter method=============
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Set<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public Set<Systemlog> getSystemlogs() {
		return systemlogs;
	}

	public void setSystemlogs(Set<Systemlog> systemlogs) {
		this.systemlogs = systemlogs;
	}

	public Set<SystemNotice> getSystemNotices() {
		return systemNotices;
	}

	public void setSystemNotices(Set<SystemNotice> systemNotices) {
		this.systemNotices = systemNotices;
	}

	public Set<InventoryInItem> getInventoryInItems() {
		return inventoryInItems;
	}

	public void setInventoryInItems(Set<InventoryInItem> inventoryInItems) {
		this.inventoryInItems = inventoryInItems;
	}

	public Set<InventoryOutItem> getInventoryOutItem() {
		return inventoryOutItem;
	}

	public void setInventoryOutItem(Set<InventoryOutItem> inventoryOutItem) {
		this.inventoryOutItem = inventoryOutItem;
	}

	public Set<PhysicalItem> getPhysicalItems() {
		return physicalItems;
	}

	public void setPhysicalItems(Set<PhysicalItem> physicalItems) {
		this.physicalItems = physicalItems;
	}

	public Set<AllocationItem> getAllocationItems() {
		return allocationItems;
	}

	public void setAllocationItems(Set<AllocationItem> allocationItems) {
		this.allocationItems = allocationItems;
	}

	public Set<AdjustmentItem> getAdjustmentItems() {
		return adjustmentItems;
	}

	public void setAdjustmentItems(Set<AdjustmentItem> adjustmentItems) {
		this.adjustmentItems = adjustmentItems;
	}

}
