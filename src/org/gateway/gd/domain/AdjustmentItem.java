package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 库存调整主表
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class AdjustmentItem implements Serializable {

	public static final String CHECKY = "已审核";
	public static final String CHECKN = "未审核";

	// ---------------- filed ----------------------------
	private Long id;
	private Date date; // 调整时间
	private String checker;
	private String checkyn; // 审核状态
	private String producer; // 制单人
	private String checkDate; // 审核日期
	private String description;

	private User user;
	private Set<AdjustmentMaterials> adjustmentMaterials = new HashSet<AdjustmentMaterials>();

	// ===============getter and setter method==================
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

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckyn() {
		return checkyn;
	}

	public void setCheckyn(String checkyn) {
		this.checkyn = checkyn;
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

	public Set<AdjustmentMaterials> getAdjustmentMaterials() {
		return adjustmentMaterials;
	}

	public void setAdjustmentMaterials(
			Set<AdjustmentMaterials> adjustmentMaterials) {
		this.adjustmentMaterials = adjustmentMaterials;
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
