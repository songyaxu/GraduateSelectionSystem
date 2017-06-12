package com.seventh.service;

import java.util.List;

import com.seventh.entity.Class;

public interface ClassService {
	public Class findClassById(int id);
	public List<Class> findAllClass();
	public List<Class> findClassByMajorId(int id);
	public void update(Class clazz);
	public void delete(Class clazz);
	public void save(Class clazz);
}
