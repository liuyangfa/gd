package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.Warehouse;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface WarehouseService {

	List<Warehouse> findAll();

	void delete(Long id);

	void save(Warehouse warehouse);

	Warehouse getById(Long id);

	void update(Warehouse warehouse);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
