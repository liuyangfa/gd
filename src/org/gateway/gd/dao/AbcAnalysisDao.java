package org.gateway.gd.dao;

import org.gateway.gd.base.BaseDao;
import org.gateway.gd.domain.AbcAnalysis;

public interface AbcAnalysisDao extends BaseDao<AbcAnalysis> {

	Double getMax();

}
