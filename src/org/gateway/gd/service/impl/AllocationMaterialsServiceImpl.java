package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.AllocationMaterialsDao;
import org.gateway.gd.domain.AllocationMaterials;
import org.gateway.gd.service.AllocationMaterialsService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AllocationMaterialsServiceImpl implements
		AllocationMaterialsService {
	
	@Resource
	private AllocationMaterialsDao allocationMaterialsDao;

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return allocationMaterialsDao.getPageBean(pageNum, pageSize, queryHelper);
	}

	public void save(AllocationMaterials allocationMaterials) {
		allocationMaterialsDao.save(allocationMaterials);
	}

	public List<AllocationMaterials> getByItemId(Long id) {
		return allocationMaterialsDao.getByItemId(id);
	}

	public void delete(Long id) {
		allocationMaterialsDao.delete(id);
	}

}
