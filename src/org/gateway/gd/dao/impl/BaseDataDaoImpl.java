package org.gateway.gd.dao.impl;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.BaseDataDao;
import org.gateway.gd.domain.BaseData;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDataDaoImpl extends BaseDaoImpl<BaseData> implements
		BaseDataDao {

	public Double getTotalCapital() {
		return (Double) getSession().createQuery(//
				"SELECT SUM(yearAmountOfCapital) FROM BaseData").uniqueResult();
	}

}
