package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.InventoryInItem;

public interface InventoryInItemDao extends BaseDao<InventoryInItem>{

	public List<InventoryInItem> findAll(String type);
}
