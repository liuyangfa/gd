package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 库存调拨主表
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class AllocationItem implements Serializable {

	public static final String CHECKY = "已审核";
	public static final String CHECKN = "未审核";

	// --------------field--------------------------------
	private Long id; // 调拨单编号
	private Date date; // 调拨日期
	private String checkyn; // 审核标志
	private String checker; // 审核人
	private String producer; // 制单人
	private String checkDate; // 审核日期
	private String description; // 说明

	private Set<AllocationMaterials> allocationMaterials = new HashSet<AllocationMaterials>();
	private Warehouse inWarehouse;
	private Warehouse outWarehouse;
	private User user;

	// ================ getter and setter method ========================
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

	public Set<AllocationMaterials> getAllocationMaterials() {
		return allocationMaterials;
	}

	public void setAllocationMaterials(
			Set<AllocationMaterials> allocationMaterials) {
		this.allocationMaterials = allocationMaterials;
	}

	public Warehouse getInWarehouse() {
		return inWarehouse;
	}

	public void setInWarehouse(Warehouse inWarehouse) {
		this.inWarehouse = inWarehouse;
	}

	public Warehouse getOutWarehouse() {
		return outWarehouse;
	}

	public void setOutWarehouse(Warehouse outWarehouse) {
		this.outWarehouse = outWarehouse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
