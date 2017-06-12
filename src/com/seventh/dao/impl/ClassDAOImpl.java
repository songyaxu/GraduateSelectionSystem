package com.seventh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.ClassDAO;
import com.seventh.entity.Class;

public class ClassDAOImpl extends HibernateDaoSupport implements ClassDAO{

	@Override
	public Class findClassById(int id) {
		return this.getHibernateTemplate().get(Class.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Class> findAllClass() {
		return this.getHibernateTemplate().find("from Class");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Class> findClassByMajorId(int id) {
		String hql="from Class clazz where clazz.majorId="+id;
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void update(Class clazz) {
		this.getHibernateTemplate().update(clazz);
	}

	@Override
	public void delete(Class clazz) {
		this.getHibernateTemplate().delete(clazz);
	}

	@Override
	public void save(Class clazz) {
		this.getHibernateTemplate().save(clazz);
	}
	
}
