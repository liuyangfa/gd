package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.User;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface UserService {

	List<User> findAll();

	void delete(Long id);

	void save(User model);

	User getById(Long id);

	void update(User user);

	void initPassword(Long id);

	User getByLoginNameAndPassword(String loginName, String password);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);


}
