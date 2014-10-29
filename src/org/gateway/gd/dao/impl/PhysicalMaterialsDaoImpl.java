package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.PhysicalMaterialsDao;
import org.gateway.gd.domain.PhysicalMaterials;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class PhysicalMaterialsDaoImpl extends BaseDaoImpl<PhysicalMaterials>
		implements PhysicalMaterialsDao {

	public List<PhysicalMaterials> getByListId(Long id) {
		return getSession().createQuery(//
				"FROM PhysicalMaterials p WHERE p.physicalItem.id=?")
				.setParameter(0, id).list();
	}

	public PhysicalMaterials getByMaterialsId(Long id) {
		return (PhysicalMaterials) getSession().createQuery(//
				"FROM PhysicalMaterials p WHERE p.materials.id=?")//
				.setParameter(0, id).uniqueResult();
	}

}
