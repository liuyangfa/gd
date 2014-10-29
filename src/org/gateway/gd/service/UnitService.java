package org.gateway.gd.service;

import java.util.List;
import java.util.Set;

import org.gateway.gd.domain.Unit;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface UnitService {

	List<Unit> findAll();

	void delete(Long id);

	void save(Unit unit);

	Unit getById(Long id);

	void update(Unit unit);

	Set<Unit> getByIds(Long[] unitId);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
