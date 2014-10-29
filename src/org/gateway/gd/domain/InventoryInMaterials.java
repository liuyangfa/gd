package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * 入库物料详单
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class InventoryInMaterials implements Serializable {

	// -------------field-----------------------
	private Long id;
	private Double unitPrice;	// 单价
	private Double number;		// 数量
	private Double totalPrice;  // 总价
	private String description;

	private InventoryInItem inventoryInItem;
	private Materials materials;
	private Unit unit;

	// ================setter and getter method================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InventoryInItem getInventoryInItem() {
		return inventoryInItem;
	}

	public void setInventoryInItem(InventoryInItem inventoryInItem) {
		this.inventoryInItem = inventoryInItem;
	}

	public Materials getMaterials() {
		return materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
