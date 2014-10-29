package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.RealtimeInventoryDao;
import org.gateway.gd.domain.Materials;
import org.gateway.gd.domain.RealtimeInventory;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class RealtimeInventoryDaoImpl extends BaseDaoImpl<RealtimeInventory>
		implements RealtimeInventoryDao {

	public List<RealtimeInventory> getByMaterialsId(Long materialsd) {
		return getSession().createQuery(//
				"FROM RealtimeInventory r WHERE r.materials.id=?")//
				.setParameter(0, materialsd).list();
	}

	public List<RealtimeInventory> getByWarehouseId(Long id) {
		return getSession().createQuery(//
				"FROM RealtimeInventory r WHERE r.warehouse.id=?")//
				.setParameter(0, id).list();
	}

	public RealtimeInventory getByMWId(Long id, Long id2) {
		RealtimeInventory realtimeInventory = (RealtimeInventory) getSession()
				.createQuery(//
						"FROM RealtimeInventory r WHERE r.materials.id=? and r.warehouse.id=?")
				.setParameter(0, id).setParameter(1, id2).uniqueResult();
		return realtimeInventory;
	}

	public List<RealtimeInventory> getByWareGroup() {
		return getSession().createQuery(
				"FROM RealtimeInventory r GROUP BY r.warehouse").list();
	}

	public Double getByMaterialsName(String materialsName) {
		return (Double) getSession()
				.createQuery(
						"SELECT SUM(number) FROM RealtimeInventory r WHERE r.materials.name=?")
				.setParameter(0, materialsName).uniqueResult();
	}

	public Materials getByMId(Long materialsId) {
		return (Materials) getSession().createQuery(//
				"FROM RealtimeInventory r WHERE r.materials.id=?")
				.setParameter(0, materialsId).uniqueResult();
	}


}
