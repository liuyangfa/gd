package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 仓库实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Warehouse implements Serializable {

	// ------------field--------------------------------------
	private Long id;
	private String name;
	private String address;
	private String description;
	private Set<User> users = new HashSet<User>();
	private Set<Position> positions = new HashSet<Position>();
	private Set<InventoryInItem> inventoryInItem = new HashSet<InventoryInItem>();
	private Set<InventoryOutItem> inventoryOutItem = new HashSet<InventoryOutItem>();
	private Set<RealtimeInventory> realtimeInventories = new HashSet<RealtimeInventory>();
	private Set<AllocationItem> allocationItems = new HashSet<AllocationItem>();
	private Set<AllocationItem> allocationItem = new HashSet<AllocationItem>();
	private Set<PhysicalItem> physicalItems = new HashSet<PhysicalItem>();

	// =============setter and getter method=================
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Position> getPositions() {
		return positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}

	public Set<InventoryInItem> getInventoryInItem() {
		return inventoryInItem;
	}

	public void setInventoryInItem(Set<InventoryInItem> inventoryInItem) {
		this.inventoryInItem = inventoryInItem;
	}

	public Set<InventoryOutItem> getInventoryOutItem() {
		return inventoryOutItem;
	}

	public void setInventoryOutItem(Set<InventoryOutItem> inventoryOutItem) {
		this.inventoryOutItem = inventoryOutItem;
	}

	public Set<RealtimeInventory> getRealtimeInventories() {
		return realtimeInventories;
	}

	public void setRealtimeInventories(
			Set<RealtimeInventory> realtimeInventories) {
		this.realtimeInventories = realtimeInventories;
	}

	public Set<AllocationItem> getAllocationItems() {
		return allocationItems;
	}

	public void setAllocationItems(Set<AllocationItem> allocationItems) {
		this.allocationItems = allocationItems;
	}

	public Set<AllocationItem> getAllocationItem() {
		return allocationItem;
	}

	public void setAllocationItem(Set<AllocationItem> allocationItem) {
		this.allocationItem = allocationItem;
	}

	public Set<PhysicalItem> getPhysicalItems() {
		return physicalItems;
	}

	public void setPhysicalItems(Set<PhysicalItem> physicalItems) {
		this.physicalItems = physicalItems;
	}

}
