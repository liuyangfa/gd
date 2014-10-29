package org.gateway.gd.dao.impl;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.SluggishMaterialsDao;
import org.gateway.gd.domain.SluggishMaterials;
import org.springframework.stereotype.Repository;

@Repository
public class SluggishMaterialsDaoImpl extends BaseDaoImpl<SluggishMaterials>
		implements SluggishMaterialsDao {

	public SluggishMaterials getMWById(Long id,String name) {
		return (SluggishMaterials) getSession().createQuery(//
				"FROM SluggishMaterials s WHERE s.materialsId=? AND s.warehouseName=?")//
				.setParameter(0, id).setParameter(1, name)//
				.uniqueResult();
	}

}
