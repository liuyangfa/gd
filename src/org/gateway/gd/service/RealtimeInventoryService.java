package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.RealtimeInventory;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface RealtimeInventoryService {

	List<RealtimeInventory> findAll();

	List<RealtimeInventory> getByMaterialsId(Long materialsd);

	List<RealtimeInventory> getByWarehouseId(Long id);

	void save(RealtimeInventory realtimeInventory);

	void update(RealtimeInventory realtimeInventory);

	RealtimeInventory getByMWId(Long id, Long id2);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	List<RealtimeInventory> getByWareGroup();

	Double getByMaterialsName(String materialsName);

	RealtimeInventory getByMId(Long[] materialsId);

}
