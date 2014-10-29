package org.gateway.gd.service.impl;

import javax.annotation.Resource;

import org.gateway.gd.dao.SystemNoticeDao;
import org.gateway.gd.domain.SystemNotice;
import org.gateway.gd.service.SystemNoticeService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SystemNoticeServiceImpl implements SystemNoticeService {

	@Resource
	private SystemNoticeDao systemNoticeDao;

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return systemNoticeDao.getPageBean(pageNum, pageSize, queryHelper);
	}

	public SystemNotice getById(Long id) {
		return systemNoticeDao.getById(id);
	}

	public Long getCount(String viewn) {
		return systemNoticeDao.getCount(viewn);
	}

	public void save(SystemNotice systemNotice) {
		systemNoticeDao.save(systemNotice);
	}

}
