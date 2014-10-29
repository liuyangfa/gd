package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.AbcAnalysisDao;
import org.gateway.gd.domain.AbcAnalysis;
import org.gateway.gd.service.AbcAnalysisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AbcAnalysisServiceImpl implements AbcAnalysisService {

	@Resource
	private AbcAnalysisDao abcAnalysisDao;

	public List<AbcAnalysis> findAll() {
		return abcAnalysisDao.findAll();
	}

	public void save(AbcAnalysis abcAnalysis) {
		abcAnalysisDao.save(abcAnalysis);
	}

	public Double getMax() {
		return abcAnalysisDao.getMax();
	}

	public void update(AbcAnalysis abcAnalysis) {
		abcAnalysisDao.update(abcAnalysis);
	}

	public void delete(Long id) {
		abcAnalysisDao.delete(id);
	}

}
