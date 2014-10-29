package org.gateway.gd.dao.impl;

import java.util.Collection;
import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.PrivilegeDao;
import org.gateway.gd.domain.Privilege;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements
		PrivilegeDao {

	public List<Privilege> findTopList() {
		return getSession().createQuery(//
				"FROM Privilege p WHERE p.parent IS NULL")//
				.list();
	}

	public Collection<String> getAllPrivilegeUrls() {
		return getSession()
				.createQuery(//
						"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")//
				.list();
	}

	public String getByPath(String path) {
		return (String) getSession()
				.createQuery(//
						"SELECT p.name FROM Privilege p WHERE p.parent IS NOT NULL AND p.url=?")//
				.setParameter(0, path)//
				.uniqueResult();
	}

}
