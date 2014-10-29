package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.AdjustmentMaterials;

public interface AdjustmentMaterialsDao extends BaseDao<AdjustmentMaterials> {

	List<org.gateway.gd.domain.AdjustmentMaterials> getByListId(Long id);

	org.gateway.gd.domain.AdjustmentMaterials getByMaterials(Long id);

}
