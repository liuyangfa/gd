package org.gateway.gd.dao.impl;

import java.util.List;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.DepartmentDao;
import org.gateway.gd.domain.Department;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {

	
	public List<Department> findTopList() {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

	public List<Department> findChildren(Long parentId) {
		return (List<Department>) getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

}
