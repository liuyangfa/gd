package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.InventoryInItemDao;
import org.gateway.gd.domain.InventoryInItem;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class InventoryInItemDaoImpl extends BaseDaoImpl<InventoryInItem>
		implements InventoryInItemDao {

	public List<InventoryInItem> findAll(String type) {
		return getSession().createQuery(//
				"FROM InventoryInItem i WHERE i.inType=?")//
				.setParameter(0, type)//
				.list();
	}

}
