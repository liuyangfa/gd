package org.gateway.gd.dao;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.SluggishMaterials;

public interface SluggishMaterialsDao extends BaseDao<SluggishMaterials>{

	SluggishMaterials getMWById(Long id, String name);

}
