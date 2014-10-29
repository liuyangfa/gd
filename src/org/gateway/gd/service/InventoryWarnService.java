package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.InventoryWarn;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface InventoryWarnService {

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	void delete(Long id);

	void save(InventoryWarn inventoryWarn);

	InventoryWarn getByMaterialsName(String name);

	void update(InventoryWarn inWarn);

	List<InventoryWarn> findAll();

}
