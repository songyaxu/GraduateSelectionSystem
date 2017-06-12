package com.seventh.service;

import java.util.List;

import com.seventh.entity.Field;

public interface FieldService {
	public Field findFieldById(int id);
	public List<Field> findAllField();
	public void update(Field field);
	public void delete(Field field);
	public void save(Field field);
}
