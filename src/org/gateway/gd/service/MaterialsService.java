package org.gateway.gd.service;

import java.util.List;
import java.util.Set;

import org.gateway.gd.domain.Materials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface MaterialsService {

	void delete(Long id);

	List<Materials> findAll();

	void update(Materials materials);

	void save(Materials materials);

	Materials getById(Long id);

	Set<Materials> getByIds(Long[] materialsId);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
