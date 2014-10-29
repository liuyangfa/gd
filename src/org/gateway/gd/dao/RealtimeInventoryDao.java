package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.RealtimeInventory;

public interface RealtimeInventoryDao extends BaseDao<RealtimeInventory> {

	List<RealtimeInventory> getByMaterialsId(Long materialsd);

	List<RealtimeInventory> getByWarehouseId(Long id);

	RealtimeInventory getByMWId(Long id, Long id2);

	List<RealtimeInventory> getByWareGroup();

	Double getByMaterialsName(String materialsName);

}
