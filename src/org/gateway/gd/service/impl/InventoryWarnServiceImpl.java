package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.InventoryWareDao;
import org.gateway.gd.domain.InventoryWarn;
import org.gateway.gd.service.InventoryWarnService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryWarnServiceImpl implements InventoryWarnService {
	
	@Resource
	private InventoryWareDao inventoryWareDao;

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return inventoryWareDao.getPageBean(pageNum, pageSize, queryHelper);
	}

	public void delete(Long id) {
		inventoryWareDao.delete(id);
	}

	public void save(InventoryWarn inventoryWarn) {
		inventoryWareDao.save(inventoryWarn);
	}

	public InventoryWarn getByMaterialsName(String name) {
		return inventoryWareDao.getByMaterialsName(name);
	}

	public void update(InventoryWarn inWarn) {
		inventoryWareDao.update(inWarn);
	}

	public List<InventoryWarn> findAll() {
		return inventoryWareDao.findAll();
	}
}
