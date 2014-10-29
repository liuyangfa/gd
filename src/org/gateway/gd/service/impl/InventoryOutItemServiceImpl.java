package org.gateway.gd.service.impl;

import javax.annotation.Resource;

import org.gateway.gd.dao.InventoryOutItemDao;
import org.gateway.gd.domain.InventoryOutItem;
import org.gateway.gd.service.InventoryOutItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryOutItemServiceImpl implements InventoryOutItemService{
	
	@Resource
	private InventoryOutItemDao inventoryOutItemDao;

	public InventoryOutItem getById(Long id) {
		return inventoryOutItemDao.getById(id);
	}

	public void delete(Long id) {
		inventoryOutItemDao.delete(id);
	}

	public void save(InventoryOutItem inventoryOutItem) {
		inventoryOutItemDao.save(inventoryOutItem);
	}

	public void update(InventoryOutItem inventoryOutItem) {
		inventoryOutItemDao.update(inventoryOutItem);
	}
}
