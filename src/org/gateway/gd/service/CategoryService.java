package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.Category;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface CategoryService {

	void delete(Long id);

	List<Category> findAll();

	void save(Category category);

	Category getById(Long id);

	void update(Category category);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
