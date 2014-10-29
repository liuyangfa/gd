package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.InventoryOutMaterialsDao;
import org.gateway.gd.domain.InventoryOutMaterials;
import org.gateway.gd.service.InventoryOutMaterialsService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryOutMaterialsServiceImpl implements InventoryOutMaterialsService{
	
	@Resource
	private InventoryOutMaterialsDao inventoryOutMaterialsDao;

	public List<InventoryOutMaterials> findAll(String type) {
		return inventoryOutMaterialsDao.findAll(type);
	}

	public void save(InventoryOutMaterials inventoryOutMaterials) {
		inventoryOutMaterialsDao.save(inventoryOutMaterials);
	}

	public List<InventoryOutMaterials> getByItemId(Long itemId) {
		return inventoryOutMaterialsDao.getByItemId(itemId);
	}

	public void delete(Long id) {
		inventoryOutMaterialsDao.delete(id);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return inventoryOutMaterialsDao.getPageBean(pageNum, pageSize, queryHelper);
	}
	
}
