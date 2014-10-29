package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.InventoryInMaterials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface InventoryInMaterialsService {

	List<InventoryInMaterials> findAll(String type);

	void save(InventoryInMaterials inventoryInMaterials);

	InventoryInMaterials getById(Long id);

	void update(InventoryInMaterials inventoryInMaterials);

	List<InventoryInMaterials> getByItemId(Long itemId);

	void delete(Long id);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper1);

}
