package org.gateway.gd.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.gateway.gd.dao.PrivilegeDao;
import org.gateway.gd.domain.Privilege;
import org.gateway.gd.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

	@Resource
	private PrivilegeDao privilegeDao;

	public List<Privilege> findAll() {
		return privilegeDao.findAll();
	}

	public Set<Privilege> getByIds(Long[] privilegeIds) {
		return privilegeDao.getByIds(privilegeIds);
	}

	//查询所有顶级权限的集合
	public List<Privilege> findTopList() {
		return privilegeDao.findTopList();
	}

	//获取所有权限的url
	public Collection<String> getAllPrivilegeUrls() {
		return privilegeDao.getAllPrivilegeUrls();
	}

	public String getByPath(String path) {
		return privilegeDao.getByPath(path);
	}

}
