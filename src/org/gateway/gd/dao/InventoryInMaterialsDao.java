package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.InventoryInMaterials;

public interface InventoryInMaterialsDao extends BaseDao<InventoryInMaterials>{

	List<org.gateway.gd.domain.InventoryInMaterials> getByItemId(Long itemId);

	List<org.gateway.gd.domain.InventoryInMaterials> findAll(String type);

}
