package org.gateway.gd.dao;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.InventoryWarn;

public interface InventoryWareDao extends BaseDao<InventoryWarn>{

	InventoryWarn getByMaterialsName(String name);

}
