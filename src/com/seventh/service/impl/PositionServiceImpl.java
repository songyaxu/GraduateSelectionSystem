package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.PositionDAO;
import com.seventh.entity.Position;
import com.seventh.service.PositionService;

public class PositionServiceImpl implements PositionService{
	private PositionDAO positionDao;
	public PositionDAO getPositionDao() {
		return positionDao;
	}
	public void setPositionDao(PositionDAO positionDao) {
		this.positionDao = positionDao;
	}
	@Override
	public Position findPositionById(int id) {
		return this.getPositionDao().findPositionById(id);
	}
	@Override
	public List<Position> findAllPosition() {
		return this.getPositionDao().findAllPosition();
	}
	@Override
	public void update(Position position) {
		this.getPositionDao().update(position);
	}
	@Override
	public void delete(Position position) {
		this.getPositionDao().delete(position);
	}
	@Override
	public void save(Position position) {
		this.getPositionDao().save(position);
	}
	
}
