package org.gateway.gd.dao.impl;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.SystemNoticeDao;
import org.gateway.gd.domain.SystemNotice;
import org.springframework.stereotype.Repository;

@Repository
public class SystemNoticeDaoImpl extends BaseDaoImpl<SystemNotice> implements
		SystemNoticeDao {

	public Long getCount(String viewn) {
		return (Long) getSession().createQuery("SELECT COUNT(*) FROM SystemNotice s WHERE s.viewyn=?").setParameter(0, viewn).uniqueResult();
	}

}
