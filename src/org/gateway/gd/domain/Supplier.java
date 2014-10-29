package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 供应商实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Supplier implements Serializable {

	// ---------------field-------------------------
	private Long id;
	private String name;
	private String contact;
	private String address;
	private String phoneNumber;
	private String description;
	private Set<InventoryInItem> inventoryInItem = new HashSet<InventoryInItem>();

	// =====================setter and getter===========================
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<InventoryInItem> getInventoryInItem() {
		return inventoryInItem;
	}

	public void setInventoryInItem(Set<InventoryInItem> inventoryInItem) {
		this.inventoryInItem = inventoryInItem;
	}

}
