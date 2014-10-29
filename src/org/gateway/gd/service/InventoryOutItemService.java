package org.gateway.gd.service;

import org.gateway.gd.domain.InventoryOutItem;

public interface InventoryOutItemService {

	InventoryOutItem getById(Long itemId);

	void delete(Long id);

	void save(InventoryOutItem inventoryOutItem);

	void update(InventoryOutItem inventoryOutItem);

}
