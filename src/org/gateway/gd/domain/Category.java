package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 物料类别实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Category implements Serializable {

	// --------------field--------------------------------
	private Long id;			// 类别编号
	private String name;		// 类别名称
	private String description;	// 类别说明
	private Set<Materials> materials = new HashSet<Materials>();

	// ===============setter and getter method========================
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

	public Set<Materials> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<Materials> materials) {
		this.materials = materials;
	}

}
