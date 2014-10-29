package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.PhysicalMaterials;

public interface PhysicalMaterialsDao extends BaseDao<PhysicalMaterials>{

	List<PhysicalMaterials> getByListId(Long id);

	PhysicalMaterials getByMaterialsId(Long id);

}
