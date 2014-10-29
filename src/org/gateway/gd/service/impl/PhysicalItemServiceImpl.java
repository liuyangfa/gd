package org.gateway.gd.service.impl;

import javax.annotation.Resource;

import org.gateway.gd.dao.PhysicalItemDao;
import org.gateway.gd.domain.PhysicalItem;
import org.gateway.gd.service.PhysicalItemService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhysicalItemServiceImpl implements PhysicalItemService {

	@Resource
	private PhysicalItemDao physicalItemDao;

	public PhysicalItem getById(Long id) {
		return physicalItemDao.getById(id);
	}

	public void delete(Long id) {
		physicalItemDao.delete(id);
	}

	public void save(PhysicalItem physicalItem) {
		physicalItemDao.save(physicalItem);
	}

	public void update(PhysicalItem physicalItem) {
		physicalItemDao.update(physicalItem);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return physicalItemDao.getPageBean(pageNum, pageSize, queryHelper);
	}
}
