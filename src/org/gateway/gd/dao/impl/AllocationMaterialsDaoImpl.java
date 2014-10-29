package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.AllocationMaterialsDao;
import org.gateway.gd.domain.AllocationMaterials;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class AllocationMaterialsDaoImpl extends
		BaseDaoImpl<AllocationMaterials> implements AllocationMaterialsDao {

	public List<AllocationMaterials> getByItemId(Long id) {
		return getSession().createQuery(//
				"FROM AllocationMaterials a WHERE a.allocationItem.id=?")//
				.setParameter(0, id).list();
	}

}
