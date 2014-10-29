package org.gateway.gd.service.impl;

import javax.annotation.Resource;

import org.gateway.gd.dao.AdjustmentItemDao;
import org.gateway.gd.domain.AdjustmentItem;
import org.gateway.gd.service.AdjustmentItemService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdjustmentItemServiceImpl implements AdjustmentItemService {

	@Resource
	private AdjustmentItemDao adjustmentItemDao;

	public AdjustmentItem getById(Long id) {
		return adjustmentItemDao.getById(id);
	}

	public void delete(Long id) {
		adjustmentItemDao.delete(id);
	}

	public void save(AdjustmentItem adjustmentItem) {
		adjustmentItemDao.save(adjustmentItem);
	}

	public void update(AdjustmentItem adjustmentItem) {
		adjustmentItemDao.update(adjustmentItem);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return adjustmentItemDao.getPageBean(pageNum, pageSize, queryHelper);
	}

}
