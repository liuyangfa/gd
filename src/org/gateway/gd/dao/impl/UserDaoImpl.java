package org.gateway.gd.dao.impl;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.UserDao;
import org.gateway.gd.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public void save(User user) {
		// 把密码设置为1234的MD5摘要
		String digest = DigestUtils.md5DigestAsHex("1234".getBytes());
		user.setPassword(digest);
		getSession().save(user);
	}

	public void initPassword(Long id) {
		// 把密码设置为1234的MD5摘要
		String digest = DigestUtils.md5DigestAsHex("1234".getBytes());
		User user = getById(id);
		user.setPassword(digest);
	}

	public User getByLoginNameAndPassword(String loginName, String password) {
		// 使用明文密码的MD5摘要进行对比
		String digest = DigestUtils.md5DigestAsHex(password.getBytes());
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, digest)//
				.uniqueResult();
	}
}
