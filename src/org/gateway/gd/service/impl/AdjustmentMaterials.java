package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.AdjustmentMaterialsDao;
import org.gateway.gd.service.AdjustmentMaterialsService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class AdjustmentMaterials implements AdjustmentMaterialsService {

	@Resource
	private AdjustmentMaterialsDao adjustmentMaterialsDao;

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return adjustmentMaterialsDao.getPageBean(pageNum, pageSize,
				queryHelper);
	}

	public void save(
			org.gateway.gd.domain.AdjustmentMaterials adjustmentMaterials) {
		adjustmentMaterialsDao.save(adjustmentMaterials);
	}

	public List<org.gateway.gd.domain.AdjustmentMaterials> getByListId(Long id) {
		return adjustmentMaterialsDao.getByListId(id);
	}

	public org.gateway.gd.domain.AdjustmentMaterials getByMaterialsId(Long id) {
		return adjustmentMaterialsDao.getByMaterials(id);
	}

	public void update(
			org.gateway.gd.domain.AdjustmentMaterials adjustmentMaterials) {
		adjustmentMaterialsDao.update(adjustmentMaterials);
	}

}
