package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.FieldDAO;
import com.seventh.entity.Field;
import com.seventh.service.FieldService;

public class FieldServiceImpl implements FieldService{
	private FieldDAO FieldDao;

	public FieldDAO getFieldDao() {
		return FieldDao;
	}

	public void setFieldDao(FieldDAO fieldDao) {
		FieldDao = fieldDao;
	}

	@Override
	public Field findFieldById(int id) {
		return this.getFieldDao().findFieldById(id);
	}

	@Override
	public List<Field> findAllField() {
		return this.getFieldDao().findAllField();
	}

	@Override
	public void update(Field field) {
		this.getFieldDao().update(field);
	}

	@Override
	public void delete(Field field) {
		this.getFieldDao().delete(field);
	}

	@Override
	public void save(Field field) {
		this.getFieldDao().save(field);
	}
	
}
