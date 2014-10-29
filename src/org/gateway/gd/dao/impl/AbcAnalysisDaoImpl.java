package org.gateway.gd.dao.impl;

import org.gateway.gd.base.BaseDaoImpl;
import org.gateway.gd.dao.AbcAnalysisDao;
import org.gateway.gd.domain.AbcAnalysis;
import org.springframework.stereotype.Repository;

@Repository
public class AbcAnalysisDaoImpl extends BaseDaoImpl<AbcAnalysis> implements
		AbcAnalysisDao {

	public Double getMax() {
		return (Double) getSession().createQuery(
				"SELECT max(yearAmountOfCapitalTotal) FROM AbcAnalysis")
				.uniqueResult();
	}

}
