package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.PositionDao;
import org.gateway.gd.domain.Position;
import org.gateway.gd.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

	@Resource
	private PositionDao positionDao;

	public List<Position> findAll() {
		return positionDao.findAll();
	}

	public void delete(Long id) {
		positionDao.delete(id);
	}

	public void save(Position position) {
		positionDao.save(position);
	}

	public Position getById(Long id) {
		return positionDao.getById(id);
	}

	public void update(Position position) {
		positionDao.update(position);
	}
	
	
}
