package org.gateway.gd.service.impl;

import javax.annotation.Resource;

import org.gateway.gd.dao.AllocationItemDao;
import org.gateway.gd.domain.AllocationItem;
import org.gateway.gd.service.AllocationItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AllocationItemServiceImpl implements AllocationItemService {

	@Resource
	private AllocationItemDao allocationItemDao;

	public AllocationItem getById(Long id) {
		return allocationItemDao.getById(id);
	}

	public void delete(Long id) {
		allocationItemDao.delete(id);
	}
	
	public void save(AllocationItem allocationItem) {
		allocationItemDao.save(allocationItem);
	}

	public void update(AllocationItem allocationItem) {
		allocationItemDao.update(allocationItem);
	}
}
