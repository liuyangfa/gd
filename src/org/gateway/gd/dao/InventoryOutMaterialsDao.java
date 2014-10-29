package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.InventoryOutMaterials;

public interface InventoryOutMaterialsDao extends BaseDao<InventoryOutMaterials>{

	List<InventoryOutMaterials> findAll(String type);

	List<InventoryOutMaterials> getByItemId(Long itemId);

}
