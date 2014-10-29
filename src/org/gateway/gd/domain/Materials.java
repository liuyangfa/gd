package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 物料实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Materials implements Serializable {

	// -------------------field---------------------------
	private Long id;
	private String name;
	private String specifications; // 规格
	private String description;
	private Category category; // 物料类别
	private Double lowestInventory; // 最低库存
	private Double highestInventory; // 最高库存
	private Double safeInventory; // 安全库存
	private Long noAmountOfTime; // 无发生额时间

	private Set<InventoryInMaterials> inventoryInMaterials = new HashSet<InventoryInMaterials>();
	private Set<InventoryOutMaterials> inventoryOutMaterials = new HashSet<InventoryOutMaterials>();
	private Set<RealtimeInventory> realtimeInventories = new HashSet<RealtimeInventory>();
	private Set<AllocationMaterials> allocationMaterials = new HashSet<AllocationMaterials>();
	private Set<PhysicalMaterials> physicalMaterials = new HashSet<PhysicalMaterials>();
	private Set<AdjustmentMaterials> adjustmentMaterials = new HashSet<AdjustmentMaterials>();

	// =============setter and getter method======================
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
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

	public Set<AdjustmentMaterials> getAdjustmentMaterials() {
		return adjustmentMaterials;
	}

	public void setAdjustmentMaterials(
			Set<AdjustmentMaterials> adjustmentMaterials) {
		this.adjustmentMaterials = adjustmentMaterials;
	}

	public Double getLowestInventory() {
		return lowestInventory;
	}

	public void setLowestInventory(Double lowestInventory) {
		this.lowestInventory = lowestInventory;
	}

	public Double getHighestInventory() {
		return highestInventory;
	}

	public void setHighestInventory(Double highestInventory) {
		this.highestInventory = highestInventory;
	}

	public Double getSafeInventory() {
		return safeInventory;
	}

	public void setSafeInventory(Double safeInventory) {
		this.safeInventory = safeInventory;
	}

	public Long getNoAmountOfTime() {
		return noAmountOfTime;
	}

	public void setNoAmountOfTime(Long noAmountOfTime) {
		this.noAmountOfTime = noAmountOfTime;
	}

}
