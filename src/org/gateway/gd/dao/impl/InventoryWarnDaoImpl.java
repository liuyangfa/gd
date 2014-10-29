package org.gateway.gd.dao.impl;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.InventoryWareDao;
import org.gateway.gd.domain.InventoryWarn;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryWarnDaoImpl extends BaseDaoImpl<InventoryWarn> implements
		InventoryWareDao {

	public InventoryWarn getByMaterialsName(String name) {
		return (InventoryWarn) getSession().createQuery(//
				"FROM InventoryWarn i WHERE i.materialsName=?")
				.setParameter(0, name).uniqueResult();
	}

}
