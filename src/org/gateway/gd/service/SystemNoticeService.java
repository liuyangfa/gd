package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.SystemNotice;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface SystemNoticeService {

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	SystemNotice getById(Long id);

	Long getCount(String viewn);

	void save(SystemNotice systemNotice);

	List<SystemNotice> getNotViewNumber(String viewn);

}
