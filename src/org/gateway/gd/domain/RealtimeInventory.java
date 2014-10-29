package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 实时库存实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class RealtimeInventory implements Serializable {
	private Long id;
	private Double number; // 库存数量
	private Date date; // 最后异动日
	private Warehouse warehouse;
	private Unit unit;
	private Materials materials;

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

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Materials getMaterials() {
		return materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
