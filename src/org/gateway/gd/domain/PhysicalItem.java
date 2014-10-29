package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 库存盘点主表
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class PhysicalItem implements Serializable {

	public static final String CHECKY = "已审核";
	public static final String CHECKN = "未审核";

	// --------------field--------------------------------
	private Long id; // 盘点单编号
	private Date date; // 盘点日期
	private String checkyn; // 审核标志
	private String checker; // 审核人
	private String producer; // 制单人
	private String checkDate; // 审核日期
	private String description; // 说明

	private User user;
	private Warehouse warehouse;
	private Set<PhysicalMaterials> physicalMaterials = new HashSet<PhysicalMaterials>();

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Set<PhysicalMaterials> getPhysicalMaterials() {
		return physicalMaterials;
	}

	public void setPhysicalMaterials(Set<PhysicalMaterials> physicalMaterials) {
		this.physicalMaterials = physicalMaterials;
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
