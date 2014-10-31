package org.gateway.gd.dao;

import java.util.List;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.SystemNotice;

public interface SystemNoticeDao extends BaseDao<SystemNotice> {

	Long getCount(String viewn);

	List<SystemNotice> getNotViewNumber(String viewn);

}
