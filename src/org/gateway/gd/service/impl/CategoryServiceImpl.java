package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.CategoryDao;
import org.gateway.gd.domain.Category;
import org.gateway.gd.service.CategoryService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryDao categoryDao;

	public void delete(Long id) {
		categoryDao.delete(id);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void save(Category category) {
		categoryDao.save(category);
	}

	public Category getById(Long id) {
		return categoryDao.getById(id);
	}

	public void update(Category category) {
		categoryDao.update(category);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return categoryDao.getPageBean(pageNum, pageSize, queryHelper);
	}
}
