package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.InventoryInMaterialsDao;
import org.gateway.gd.domain.InventoryInMaterials;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class InventoryInMaterialsDaoImpl extends BaseDaoImpl<InventoryInMaterials> implements InventoryInMaterialsDao{

	
	public List<InventoryInMaterials> getByItemId(Long itemId) {
		return getSession().createQuery("FROM InventoryInMaterials i WHERE i.inventoryInItem.id=?").setParameter(0, itemId).list();
	}

	public List<InventoryInMaterials> findAll(String type) {
		return getSession().createQuery(//
				"FROM InventoryInMaterials i WHERE i.inventoryInItem.inType=?")//
				.setParameter(0, type)//
				.list();
	}

}
