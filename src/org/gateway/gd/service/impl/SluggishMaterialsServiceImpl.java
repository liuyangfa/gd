package org.gateway.gd.service.impl;

import javax.annotation.Resource;

import org.gateway.gd.dao.SluggishMaterialsDao;
import org.gateway.gd.domain.SluggishMaterials;
import org.gateway.gd.service.SluggishMaterialsService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SluggishMaterialsServiceImpl implements SluggishMaterialsService {

	@Resource
	private SluggishMaterialsDao sluggishMaterialsDao;

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return sluggishMaterialsDao.getPageBean(pageNum, pageSize, queryHelper);
	}

	public void delete(Long id) {
		sluggishMaterialsDao.delete(id);
	}

	public void save(SluggishMaterials sluggishMaterials) {
		sluggishMaterialsDao.save(sluggishMaterials);
	}

	public SluggishMaterials getMWById(Long id, String name) {
		return sluggishMaterialsDao.getMWById(id,name);
	}

	public void update(SluggishMaterials sluggishMaterials) {
		sluggishMaterialsDao.update(sluggishMaterials);
	}
}
