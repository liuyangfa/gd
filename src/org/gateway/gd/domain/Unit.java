package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 计量单位实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Unit implements Serializable {

	// --------------field-------------------------------
	private Long id;
	private String name;
	private String description;
	private Set<InventoryInMaterials> inventoryInMaterials = new HashSet<InventoryInMaterials>();
	private Set<InventoryOutMaterials> inventoryOutMaterials = new HashSet<InventoryOutMaterials>();
	private Set<RealtimeInventory> realtimeInventories = new HashSet<RealtimeInventory>();
	private Set<AllocationMaterials> allocationMaterials = new HashSet<AllocationMaterials>();
	private Set<PhysicalMaterials> physicalMaterials = new HashSet<PhysicalMaterials>();

	// =====================setter and getter method===================
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

	public Set<InventoryInMaterials> getInventoryInMaterials() {
		return inventoryInMaterials;
	}

	public void setInventoryInMaterials(
			Set<InventoryInMaterials> inventoryInMaterials) {
		this.inventoryInMaterials = inventoryInMaterials;
	}

	public Set<InventoryOutMaterials> getInventoryOutMaterials() {
		return inventoryOutMaterials;
	}

	public void setInventoryOutMaterials(
			Set<InventoryOutMaterials> inventoryOutMaterials) {
		this.inventoryOutMaterials = inventoryOutMaterials;
	}

	public Set<RealtimeInventory> getRealtimeInventories() {
		return realtimeInventories;
	}

	public void setRealtimeInventories(
			Set<RealtimeInventory> realtimeInventories) {
		this.realtimeInventories = realtimeInventories;
	}

	public Set<AllocationMaterials> getAllocationMaterials() {
		return allocationMaterials;
	}

	public void setAllocationMaterials(
			Set<AllocationMaterials> allocationMaterials) {
		this.allocationMaterials = allocationMaterials;
	}

	public Set<PhysicalMaterials> getPhysicalMaterials() {
		return physicalMaterials;
	}

	public void setPhysicalMaterials(Set<PhysicalMaterials> physicalMaterials) {
		this.physicalMaterials = physicalMaterials;
	}

}
