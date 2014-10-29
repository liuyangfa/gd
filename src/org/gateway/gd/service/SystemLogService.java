package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.Systemlog;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface SystemLogService {

	void save(Systemlog systemlog);

	void update(Systemlog systemlog);

	List<Systemlog> findAll();

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	

}
