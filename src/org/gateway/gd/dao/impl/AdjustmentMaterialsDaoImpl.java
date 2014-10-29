package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.AdjustmentMaterialsDao;
import org.gateway.gd.domain.AdjustmentMaterials;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class AdjustmentMaterialsDaoImpl extends
		BaseDaoImpl<AdjustmentMaterials> implements AdjustmentMaterialsDao {

	public List<AdjustmentMaterials> getByListId(Long id) {
		return getSession().createQuery(//
				"FROM AdjustmentMaterials a WHERE a.adjustmentItem.id=?")//
				.setParameter(0, id).list();
	}

	public AdjustmentMaterials getByMaterials(Long id) {
		return (AdjustmentMaterials) getSession().createQuery(//
				"FROM AdjustmentMaterials a WHERE a.materials.id=?")//
				.setParameter(0, id)//
				.uniqueResult();
	}

}
