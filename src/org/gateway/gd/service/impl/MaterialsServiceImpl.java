package org.gateway.gd.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.gateway.gd.dao.MaterialsDao;
import org.gateway.gd.domain.Materials;
import org.gateway.gd.service.MaterialsService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialsServiceImpl implements MaterialsService {

	@Resource
	private MaterialsDao materialsDao;

	public void delete(Long id) {
		materialsDao.delete(id);
	}

	public List<Materials> findAll() {
		return materialsDao.findAll();
	}

	public void update(Materials materials) {
		materialsDao.update(materials);
	}

	public void save(Materials materials) {
		materialsDao.save(materials);
	}

	public Materials getById(Long id) {
		return materialsDao.getById(id);
	}

	public Set<Materials> getByIds(Long[] materialsId) {
		return materialsDao.getByIds(materialsId);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return materialsDao.getPageBean(pageNum, pageSize, queryHelper);
	}
}
