package org.gateway.gd.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.gateway.gd.dao.RoleDao;
import org.gateway.gd.domain.Role;
import org.gateway.gd.service.RoleService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public void delete(Long id) {
		roleDao.delete(id);
	}

	public void save(Role role) {
		roleDao.save(role);
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public Set<Role> getByIds(Long[] roleIds) {
		return roleDao.getByIds(roleIds);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return roleDao.getPageBean(pageNum, pageSize, queryHelper);
	}

}
