package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.AllocationMaterials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface AllocationMaterialsService {

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	void save(AllocationMaterials allocationMaterials);

	List<AllocationMaterials> getByItemId(Long id);

	void delete(Long id);

}
