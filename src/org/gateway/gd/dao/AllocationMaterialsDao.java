package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.AllocationMaterials;

public interface AllocationMaterialsDao extends BaseDao<AllocationMaterials> {

	List<AllocationMaterials> getByItemId(Long id);

}
