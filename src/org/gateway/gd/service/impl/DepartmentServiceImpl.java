package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.DepartmentDao;
import org.gateway.gd.domain.Department;
import org.gateway.gd.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource
	private DepartmentDao departmentDao;

	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public void delete(Long id) {
		departmentDao.delete(id);
	}

	//查询所有的顶级部门
	public List<Department> findTopList() {
		return departmentDao.findTopList();
	}

	//查询指定部门的子部门
	public List<Department> findChildren(Long parentId) {
		return departmentDao.findChildren(parentId);
	}

	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	public void save(Department department) {
		departmentDao.save(department);
		
	}

	public void update(Department department) {
		departmentDao.update(department);
	}
}
