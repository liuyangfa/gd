package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.RealtimeInventoryDao;
import org.gateway.gd.domain.RealtimeInventory;
import org.gateway.gd.service.RealtimeInventoryService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RealtimeInventoryServiceImpl implements RealtimeInventoryService {

	@Resource
	private RealtimeInventoryDao realtimeInventoryDao;

	public List<RealtimeInventory> findAll() {
		return realtimeInventoryDao.findAll();
	}

	public List<RealtimeInventory> getByMaterialsId(Long materialsd) {
		return realtimeInventoryDao.getByMaterialsId(materialsd);
	}

	public List<RealtimeInventory> getByWarehouseId(Long id) {
		return realtimeInventoryDao.getByWarehouseId(id);
	}

	public void save(RealtimeInventory realtimeInventory) {
		realtimeInventoryDao.save(realtimeInventory);
	}

	public void update(RealtimeInventory realtimeInventory) {
		realtimeInventoryDao.update(realtimeInventory);
	}

	public RealtimeInventory getByMWId(Long id, Long id2) {
		return realtimeInventoryDao.getByMWId(id,id2);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return realtimeInventoryDao.getPageBean(pageNum, pageSize, queryHelper);
	}

	public List<RealtimeInventory> getByWareGroup() {
		return realtimeInventoryDao.getByWareGroup();
	}

	public Double getByMaterialsName(String materialsName) {
		return realtimeInventoryDao.getByMaterialsName(materialsName);
	}

	public List<Long> getTotalWareId() {
		return realtimeInventoryDao.getTotalWareId();
	}

}
