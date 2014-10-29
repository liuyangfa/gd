package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * 库存盘点附表
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class PhysicalMaterials implements Serializable {

	// --------------field--------------------------------
	private Long id;
	private Double unitPrice; // 单价
	private Double number; // 账存数量
	private Double profitNumber;// 盘盈数量
	private Double lossNumber; // 盘亏数量
	private Double realNumber; // 实存数量
	private Double plprice; // 盘盈/盘亏金额

	private PhysicalItem physicalItem;
	private Materials materials;
	private Unit unit;

	// =============== getter and setter method =============
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

	public Double getProfitNumber() {
		return profitNumber;
	}

	public void setProfitNumber(Double profitNumber) {
		this.profitNumber = profitNumber;
	}

	public Double getLossNumber() {
		return lossNumber;
	}

	public void setLossNumber(Double lossNumber) {
		this.lossNumber = lossNumber;
	}

	public Double getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(Double realNumber) {
		this.realNumber = realNumber;
	}

	public Double getPlprice() {
		return plprice;
	}

	public void setPlprice(Double plprice) {
		this.plprice = plprice;
	}

	public PhysicalItem getPhysicalItem() {
		return physicalItem;
	}

	public void setPhysicalItem(PhysicalItem physicalItem) {
		this.physicalItem = physicalItem;
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
