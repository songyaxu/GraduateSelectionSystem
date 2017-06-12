package com.seventh.service;

import java.util.List;

import com.seventh.entity.Position;

public interface PositionService {
	public Position findPositionById(int id);
	public List<Position> findAllPosition();
	public void update(Position position);
	public void delete(Position position);
	public void save(Position position);
}
