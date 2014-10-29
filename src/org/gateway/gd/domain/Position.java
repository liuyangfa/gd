package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * 仓位实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Position implements Serializable {

	// -----------------------field-------------------------
	private Long id;
	private String name;
	private String description;
	private Warehouse warehouse;// 所属仓库

	// ================setter and getter method=========================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}
