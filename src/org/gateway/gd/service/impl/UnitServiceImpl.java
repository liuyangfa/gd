package org.gateway.gd.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.gateway.gd.dao.UnitDao;
import org.gateway.gd.domain.Unit;
import org.gateway.gd.service.UnitService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

	@Resource
	private UnitDao unitDao;

	public List<Unit> findAll() {
		return unitDao.findAll();
	}

	public void delete(Long id) {
		unitDao.delete(id);
	}

	public void save(Unit unit) {
		unitDao.save(unit);
	}

	public Unit getById(Long id) {
		return unitDao.getById(id);
	}

	public void update(Unit unit) {
		unitDao.update(unit);
	}

	public Set<Unit> getByIds(Long[] unitId) {
		return unitDao.getByIds(unitId);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return unitDao.getPageBean(pageNum, pageSize, queryHelper);
	}
}
