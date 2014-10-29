package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.BaseDataDao;
import org.gateway.gd.domain.BaseData;
import org.gateway.gd.service.BaseDataService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BaseDataServiceImpl implements BaseDataService {

	@Resource
	private BaseDataDao baseDataDao;

	public List<BaseData> findAll() {
		return baseDataDao.findAll();
	}

	public void delete(Long id) {
		baseDataDao.delete(id);
	}

	public void save(BaseData model) {
		baseDataDao.save(model);
	}

	public BaseData getById(Long id) {
		return baseDataDao.getById(id);
	}

	public void update(BaseData baseData) {
		baseDataDao.update(baseData);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return baseDataDao.getPageBean(pageNum, pageSize, queryHelper);
	}

	public Double getTotalCapital() {
		return baseDataDao.getTotalCapital();
	}

}
