package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.Department;

public interface DepartmentDao extends BaseDao<Department>{

	List<Department> findTopList();

	List<Department> findChildren(Long parentId);

}
