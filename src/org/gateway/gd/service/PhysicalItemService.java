package org.gateway.gd.service;

import org.gateway.gd.domain.PhysicalItem;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface PhysicalItemService {

	PhysicalItem getById(Long id);

	void delete(Long id);

	void save(PhysicalItem physicalItem);

	void update(PhysicalItem physicalItem);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
