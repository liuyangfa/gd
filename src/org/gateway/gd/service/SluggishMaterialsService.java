package org.gateway.gd.service;

import org.gateway.gd.domain.SluggishMaterials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface SluggishMaterialsService {

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	void delete(Long id);

	void save(SluggishMaterials sluggishMaterials);

	SluggishMaterials getMWById(Long id, String name);

	void update(SluggishMaterials sluggishMaterials);

}
