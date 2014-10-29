package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.AdjustmentMaterials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface AdjustmentMaterialsService {

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	void save(AdjustmentMaterials adjustmentMaterials);

	List<AdjustmentMaterials> getByListId(Long id);

	AdjustmentMaterials getByMaterialsId(Long id);

	void update(AdjustmentMaterials adjustmentMaterials);


}
