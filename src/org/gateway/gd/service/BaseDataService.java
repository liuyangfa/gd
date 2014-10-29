package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.BaseData;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface BaseDataService {

	List<BaseData> findAll();

	void delete(Long id);

	void save(BaseData model);

	BaseData getById(Long id);

	void update(BaseData baseData);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	Double getTotalCapital();

}
