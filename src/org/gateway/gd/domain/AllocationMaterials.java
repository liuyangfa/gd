package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * 库存调拨附表
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class AllocationMaterials implements Serializable {

	// --------------field--------------------------------
	private Long id; 
	private Double number; // 调拨数量
	
	private AllocationItem allocationItem;
	private Materials materials;
	private Unit unit;

	// ============== getter and setter method ==================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public AllocationItem getAllocationItem() {
		return allocationItem;
	}

	public void setAllocationItem(AllocationItem allocationItem) {
		this.allocationItem = allocationItem;
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
