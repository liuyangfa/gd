package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.WarehouseDao;
import org.gateway.gd.domain.Warehouse;
import org.gateway.gd.service.WarehouseService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

	@Resource
	private WarehouseDao warehouseDao;

	public List<Warehouse> findAll() {
		return warehouseDao.findAll();
	}

	public void delete(Long id) {
		warehouseDao.delete(id);
	}

	public void save(Warehouse warehouse) {
		warehouseDao.save(warehouse);
	}

	public Warehouse getById(Long id) {
		return warehouseDao.getById(id);
	}

	public void update(Warehouse warehouse) {
		warehouseDao.update(warehouse);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return warehouseDao.getPageBean(pageNum, pageSize, queryHelper);
	}

}
