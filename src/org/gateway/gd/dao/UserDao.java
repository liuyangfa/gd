package org.gateway.gd.dao;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.User;

public interface UserDao extends BaseDao<User>{

	void initPassword(Long id);

	User getByLoginNameAndPassword(String loginName, String password);

}
