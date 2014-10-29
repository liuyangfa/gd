package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.Consumer;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface ConsumerService {

	List<Consumer> findAll();

	void delete(Long id);

	void save(Consumer consumer);

	Consumer getById(Long id);

	void update(Consumer consumer);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
