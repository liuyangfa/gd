package org.gateway.gd.base;

import java.util.List;
import java.util.Set;

import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface BaseDao<T> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	T getById(Long id);

	/**
	 * 按id查询
	 * 
	 * @param roleIds
	 * @return
	 */
	Set<T> getByIds(Long[] roleIds);

	/**
	 * 查询所有实体
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
}
