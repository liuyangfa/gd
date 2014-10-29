package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.InventoryOutMaterialsDao;
import org.gateway.gd.domain.InventoryOutMaterials;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class InventoryOutMaterialsDaoImpl extends
		BaseDaoImpl<InventoryOutMaterials> implements InventoryOutMaterialsDao {

	public List<InventoryOutMaterials> findAll(String type) {
		return getSession()
				.createQuery(//
						"FROM InventoryOutMaterials i WHERE i.inventoryOutItem.outType=?")//
				.setParameter(0, type)//
				.list();
	}

	public List<InventoryOutMaterials> getByItemId(Long itemId) {
		return getSession().createQuery(//
				"FROM InventoryOutMaterials i WHERE i.inventoryOutItem.id=?")//
				.setParameter(0, itemId)//
				.list();
	}

}
