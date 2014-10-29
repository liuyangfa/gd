package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.PhysicalMaterials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface PhysicalMaterialsService {

	List<PhysicalMaterials> findAll();

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	void save(PhysicalMaterials physicalMaterials);

	PhysicalMaterials getById(Long id);

	List<PhysicalMaterials> getByListId(Long id);

	void delete(Long id);

	void update(PhysicalMaterials pMaterials);

	PhysicalMaterials getByMaterialsId(Long id);

}
