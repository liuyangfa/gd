package org.gateway.gd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 客户实体
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Consumer implements Serializable {

	// --------------field-----------------------
	private Long id; // 客户编号
	private String name; // 客户名称
	private String contact; // 联系人
	private String address; // 客户地址
	private String phoneNumber; // 客户联系电话
	private String description; // 说明

	private Set<InventoryOutItem> inventoryOutItem = new HashSet<InventoryOutItem>();

	// ====================setter and getter method=======================
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

	public Set<InventoryOutItem> getInventoryOutItem() {
		return inventoryOutItem;
	}

	public void setInventoryOutItem(Set<InventoryOutItem> inventoryOutItem) {
		this.inventoryOutItem = inventoryOutItem;
	}

}
