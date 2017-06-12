package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.ClassDAO;
import com.seventh.entity.Class;
import com.seventh.service.ClassService;

public class ClassServiceImpl implements ClassService{
	private ClassDAO classDao;
	
	public ClassDAO getClassDao() {
		return classDao;
	}

	public void setClassDao(ClassDAO classDao) {
		this.classDao = classDao;
	}

	@Override
	public Class findClassById(int id) {
		return this.getClassDao().findClassById(id);
	}

	@Override
	public List<Class> findAllClass() {
		return  this.getClassDao().findAllClass();
	}

	@Override
	public List<Class> findClassByMajorId(int id) {
		return this.getClassDao().findClassByMajorId(id);
	}

	@Override
	public void update(Class clazz) {
		this.getClassDao().update(clazz);
	}

	@Override
	public void delete(Class clazz) {
		this.getClassDao().delete(clazz);
	}

	@Override
	public void save(Class clazz) {
		this.getClassDao().save(clazz);
	}
	
}
