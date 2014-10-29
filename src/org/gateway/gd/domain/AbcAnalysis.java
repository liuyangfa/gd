package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * ABC分析
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class AbcAnalysis implements Serializable {

	public static final String A = "A";
	public static final String B = "B";
	public static final String C = "C";

	// ---------------filed----------------------------
	private Long id; // 品目数累计
	private String category;// 物料类别
	private Double itemTotalPercent; // 品目数累计（%）
	private Double price; // 单价
	private Double yearStorage; // 年库存量
	private Double yearAmountOfCapital; // 年资金占用额（元）
	private Double yearAmountOfCapitalTotal; // 年资金占用额累计（元）
	private Double yearAmountOfCapitalTotalPercent; // 年资金占用额累计（%）
	private String classification; // 分类

	// ====================getter and setter================
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

	public Double getItemTotalPercent() {
		return itemTotalPercent;
	}

	public void setItemTotalPercent(Double itemTotalPercent) {
		this.itemTotalPercent = itemTotalPercent;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getYearStorage() {
		return yearStorage;
	}

	public void setYearStorage(Double yearStorage) {
		this.yearStorage = yearStorage;
	}

	public Double getYearAmountOfCapital() {
		return yearAmountOfCapital;
	}

	public void setYearAmountOfCapital(Double yearAmountOfCapital) {
		this.yearAmountOfCapital = yearAmountOfCapital;
	}

	public Double getYearAmountOfCapitalTotal() {
		return yearAmountOfCapitalTotal;
	}

	public void setYearAmountOfCapitalTotal(Double yearAmountOfCapitalTotal) {
		this.yearAmountOfCapitalTotal = yearAmountOfCapitalTotal;
	}

	public Double getYearAmountOfCapitalTotalPercent() {
		return yearAmountOfCapitalTotalPercent;
	}

	public void setYearAmountOfCapitalTotalPercent(
			Double yearAmountOfCapitalTotalPercent) {
		this.yearAmountOfCapitalTotalPercent = yearAmountOfCapitalTotalPercent;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
