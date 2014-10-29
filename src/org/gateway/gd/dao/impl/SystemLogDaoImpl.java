package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.SystemLogDao;
import org.gateway.gd.domain.Systemlog;
import org.springframework.stereotype.Repository;

@Repository
public class SystemLogDaoImpl extends BaseDaoImpl<Systemlog> implements
		SystemLogDao {
	@Override
	public List<Systemlog> findAll() {
		
		return super.findAll();
	}
}
