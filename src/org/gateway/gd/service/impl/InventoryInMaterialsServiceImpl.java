package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.InventoryInMaterialsDao;
import org.gateway.gd.service.InventoryInMaterialsService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryInMaterialsServiceImpl implements InventoryInMaterialsService {

	@Resource
	private InventoryInMaterialsDao inventoryInMaterialsDao;

	public List<org.gateway.gd.domain.InventoryInMaterials> findAll(String type) {
		return inventoryInMaterialsDao.findAll(type);
	}

	public void save(
			org.gateway.gd.domain.InventoryInMaterials inventoryInMaterials) {
		inventoryInMaterialsDao.save(inventoryInMaterials);
	}

	public org.gateway.gd.domain.InventoryInMaterials getById(Long id) {
		return inventoryInMaterialsDao.getById(id);
	}

	public void update(
			org.gateway.gd.domain.InventoryInMaterials inventoryInMaterials) {
		inventoryInMaterialsDao.update(inventoryInMaterials);
	}

	public List<org.gateway.gd.domain.InventoryInMaterials> getByItemId(
			Long itemId) {
		return inventoryInMaterialsDao.getByItemId(itemId);
	}

	public void delete(Long id) {
		inventoryInMaterialsDao.delete(id);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return inventoryInMaterialsDao.getPageBean(pageNum, pageSize, queryHelper);
	}

}
