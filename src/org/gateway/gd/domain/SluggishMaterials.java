package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 呆滞料
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class SluggishMaterials implements Serializable {

	// --------------------field-----------------------
	private Long id;
	private Long materialsId; // 物料Id
	private String materialsName; // 物料名称
	private Double number; // 数量
	private String warehouseName; // 所属仓库名称
	private Date date; // 最后异动日
	private String description; // 说明

	// =======================getter and setter====================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMaterialsId() {
		return materialsId;
	}

	public void setMaterialsId(Long materialsId) {
		this.materialsId = materialsId;
	}

	public String getMaterialsName() {
		return materialsName;
	}

	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
