package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.InventoryInItem;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface InventoryInItemService {

	void save(InventoryInItem inventoryInItem);

	void update(InventoryInItem inventoryInItem);

	void delete(Long id);

	InventoryInItem getById(Long id);

	List<InventoryInItem> findAll(String type);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);


}
