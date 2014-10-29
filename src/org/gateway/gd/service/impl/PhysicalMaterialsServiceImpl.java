package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.PhysicalMaterialsDao;
import org.gateway.gd.domain.PhysicalMaterials;
import org.gateway.gd.service.PhysicalMaterialsService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhysicalMaterialsServiceImpl implements PhysicalMaterialsService {

	@Resource
	private PhysicalMaterialsDao physicalMaterialsDao;

	public List<PhysicalMaterials> findAll() {
		return physicalMaterialsDao.findAll();
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return physicalMaterialsDao.getPageBean(pageNum, pageSize, queryHelper);
	}

	public void save(PhysicalMaterials physicalMaterials) {
		physicalMaterialsDao.save(physicalMaterials);
	}

	public PhysicalMaterials getById(Long id) {
		return physicalMaterialsDao.getById(id);
	}

	/*
	 * 根据physicalItem的id，查找对应的物料信息 (non-Javadoc)
	 * 
	 * @see
	 * org.gateway.gd.service.PhysicalMaterialsService#getByListId(java.lang
	 * .Long)
	 */
	public List<PhysicalMaterials> getByListId(Long id) {
		return physicalMaterialsDao.getByListId(id);
	}

	public void delete(Long id) {
		physicalMaterialsDao.delete(id);
	}

	public void update(PhysicalMaterials pMaterials) {
		physicalMaterialsDao.update(pMaterials);
	}

	public PhysicalMaterials getByMaterialsId(Long id) {
		return physicalMaterialsDao.getByMaterialsId(id);
	}

}
