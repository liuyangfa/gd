package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Long id);

	List<Department> findTopList();

	List<Department> findChildren(Long parentId);

	Department getById(Long id);

	void save(Department department);

	void update(Department department);

}
