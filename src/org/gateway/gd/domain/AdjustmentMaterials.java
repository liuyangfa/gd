package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * 库存调整附表
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class AdjustmentMaterials implements Serializable {

	// ---------------filed-----------------------------
	private Long id;
	private Double number; // 账存数量
	private Double realNumber; // 实存数量
	private Double adjustNumber; // 调整数量
	private Double differenceQuantity;// 差异量
	private String differenceReason; // 差异原因
	private String adjustReason; // 调整原因
	private Materials materials;
	private AdjustmentItem adjustmentItem;

	// ===============getter and setter method==================
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

	public Double getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(Double realNumber) {
		this.realNumber = realNumber;
	}

	public Double getAdjustNumber() {
		return adjustNumber;
	}

	public void setAdjustNumber(Double adjustNumber) {
		this.adjustNumber = adjustNumber;
	}

	public Double getDifferenceQuantity() {
		return differenceQuantity;
	}

	public void setDifferenceQuantity(Double differenceQuantity) {
		this.differenceQuantity = differenceQuantity;
	}

	public String getDifferenceReason() {
		return differenceReason;
	}

	public void setDifferenceReason(String differenceReason) {
		this.differenceReason = differenceReason;
	}

	public String getAdjustReason() {
		return adjustReason;
	}

	public void setAdjustReason(String adjustReason) {
		this.adjustReason = adjustReason;
	}

	public Materials getMaterials() {
		return materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public AdjustmentItem getAdjustmentItem() {
		return adjustmentItem;
	}

	public void setAdjustmentItem(AdjustmentItem adjustmentItem) {
		this.adjustmentItem = adjustmentItem;
	}

}
