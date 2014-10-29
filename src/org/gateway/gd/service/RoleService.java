package org.gateway.gd.service;

import java.util.List;
import java.util.Set;

import org.gateway.gd.domain.Role;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface RoleService {

	List<Role> findAll();

	void delete(Long id);

	void save(Role model);

	Role getById(Long id);

	void update(Role model);

	Set<Role> getByIds(Long[] roleIds);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);


}
