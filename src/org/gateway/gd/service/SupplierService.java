package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.Supplier;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface SupplierService {

	void delete(Long id);

	List<Supplier> findAll();

	void save(Supplier supplier);

	Supplier getById(Long id);

	void update(Supplier supplier);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
