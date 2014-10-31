package org.gateway.gd.dao.impl;

import java.util.List;

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

	public int getNotViewNumber() {
		return (int) getSession().createQuery("SELECT COUNT(*) FROM SystemNotice s WHERE s.viewyn='NO'").uniqueResult();
	}

	public List<SystemNotice> getNotViewNumber(String viewn) {
		viewn="NO";
		return getSession().createQuery("FROM SystemNotice s WHERE s.viewyn=?").setParameter(0, viewn).list();
	}

}
