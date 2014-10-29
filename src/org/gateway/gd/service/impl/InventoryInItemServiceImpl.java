package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.InventoryInItemDao;
import org.gateway.gd.domain.InventoryInItem;
import org.gateway.gd.service.InventoryInItemService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryInItemServiceImpl implements InventoryInItemService {

	@Resource
	private InventoryInItemDao inventoryInItemDao;

	public void save(InventoryInItem inventoryInItem) {
		inventoryInItemDao.save(inventoryInItem);
	}

	public void update(InventoryInItem inventoryInItem) {
		inventoryInItemDao.update(inventoryInItem);

	}

	public void delete(Long id) {
		inventoryInItemDao.delete(id);
	}

	public InventoryInItem getById(Long id) {
		return inventoryInItemDao.getById(id);
	}

	public List<InventoryInItem> findAll(String type) {
		return inventoryInItemDao.findAll(type);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return inventoryInItemDao.getPageBean(pageNum, pageSize, queryHelper);
	}


}