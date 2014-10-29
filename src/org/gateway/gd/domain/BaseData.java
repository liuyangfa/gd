package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * ABC分析基础数据
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class BaseData implements Serializable {
	// （物料类别，序号，年库存量，单价，年资金占用额）
	// ----------------filed-------------------
	private Long id;
	private String category; // 物料类别
	private Double yearStorage; // 年存储量
	private Double price; // 单价
	private Double yearAmountOfCapital; // 年资金占用额

	// ================= getter and setter ====================
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

	public Double getYearStorage() {
		return yearStorage;
	}

	public void setYearStorage(Double yearStorage) {
		this.yearStorage = yearStorage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getYearAmountOfCapital() {
		return yearAmountOfCapital;
	}

	public void setYearAmountOfCapital(Double yearAmountOfCapital) {
		this.yearAmountOfCapital = yearAmountOfCapital;
	}

}
