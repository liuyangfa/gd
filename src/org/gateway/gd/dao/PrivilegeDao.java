package org.gateway.gd.dao;

import java.util.Collection;
import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {

	List<Privilege> findTopList();

	Collection<String> getAllPrivilegeUrls();

	String getByPath(String path);

}
