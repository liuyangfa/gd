package org.gateway.gd.service;

import java.util.List;

import org.gateway.gd.domain.AbcAnalysis;

public interface AbcAnalysisService {

	List<AbcAnalysis> findAll();

	void save(AbcAnalysis abcAnalysis);

	Double getMax();

	void update(AbcAnalysis abcAnalysis);

	void delete(Long id);

}
