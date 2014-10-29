package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 入库单公共信息类
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class InventoryInItem implements Serializable {

	public static final String TYPE1 = "外购入库";
	public static final String TYPE2 = "产品入库";
	public static final String TYPE3 = "其他入库";

	public static final String CHECKY = "已审核";
	public static final String CHECKN = "未审核";

	// -------------field-----------------------
	private Long id;
	private Date date; // 入库日期
	private String inType; // 入库类型
	private String checkyn; // 审核状态
	private String checker; // 审核人
	private String producer; // 制单人
	private String checkDate; // 审核日期
	private String description;

	private User user;
	private Department department;
	private Warehouse warehouse;
	private Supplier supplier;
	private Set<InventoryInMaterials> inventoryInMaterials = new HashSet<InventoryInMaterials>();

	// ================setter and getter method================

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

	public String getInType() {
		return inType;
	}

	public void setInType(String inType) {
		this.inType = inType;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Set<InventoryInMaterials> getInventoryInMaterials() {
		return inventoryInMaterials;
	}

	public void setInventoryInMaterials(
			Set<InventoryInMaterials> inventoryInMaterials) {
		this.inventoryInMaterials = inventoryInMaterials;
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
