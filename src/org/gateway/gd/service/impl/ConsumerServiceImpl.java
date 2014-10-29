package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.ConsumerDao;
import org.gateway.gd.domain.Consumer;
import org.gateway.gd.service.ConsumerService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService{
	
	@Resource
	private ConsumerDao consumerDao;

	public List<Consumer> findAll() {
		return consumerDao.findAll();
	}

	public void delete(Long id) {
		consumerDao.delete(id);
	}

	public void save(Consumer consumer) {
		consumerDao.save(consumer);
		
	}

	public Consumer getById(Long id) {
		return consumerDao.getById(id);
	}

	public void update(Consumer consumer) {
		consumerDao.update(consumer);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return consumerDao.getPageBean(pageNum, pageSize, queryHelper);
	}
}
