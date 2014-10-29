package org.gateway.gd.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InventoryWarn implements Serializable {

	public static final String LARGE = "超储";
	public static final String SHORT = "短缺";
	public static final String MIDDLE="库存不足";

	// -----------------------field------------------------
	private Long id;
	private String category; // 物料类别
	private String materialsName; // 物料名称
	private String unitName; // 单位
	private Double lowestInventory; // 最低库存
	private Double highestInventory; // 最高库存
	private Double safeInventory; // 安全库存
	private Double realInventory; // 实际库存
	private Double changeNumber; // 变化量
	private String status; // 状态
	private String description; // 说明

	// =====================getter and setter==================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMaterialsName() {
		return materialsName;
	}

	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Double getLowestInventory() {
		return lowestInventory;
	}

	public void setLowestInventory(Double lowestInventory) {
		this.lowestInventory = lowestInventory;
	}

	public Double getHighestInventory() {
		return highestInventory;
	}

	public void setHighestInventory(Double highestInventory) {
		this.highestInventory = highestInventory;
	}

	public Double getSafeInventory() {
		return safeInventory;
	}

	public void setSafeInventory(Double safeInventory) {
		this.safeInventory = safeInventory;
	}

	public Double getRealInventory() {
		return realInventory;
	}

	public void setRealInventory(Double realInventory) {
		this.realInventory = realInventory;
	}

	public Double getChangeNumber() {
		return changeNumber;
	}

	public void setChangeNumber(Double changeNumber) {
		this.changeNumber = changeNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
