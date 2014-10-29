package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.InventoryOutMaterials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface InventoryOutMaterialsService {

	List<InventoryOutMaterials> findAll(String type3);

	void save(InventoryOutMaterials inventoryOutMaterials);

	List<InventoryOutMaterials> getByItemId(Long itemId);

	void delete(Long id);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
