package com.seventh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.FieldDAO;
import com.seventh.entity.Field;

public class FieldDAOImpl extends HibernateDaoSupport implements FieldDAO{

	@Override
	public Field findFieldById(int id) {
		return this.getHibernateTemplate().get(Field.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Field> findAllField() {
		String hql="from Field";
		return (List<Field>)this.getHibernateTemplate().find(hql);
	}

	@Override
	public void update(Field field) {
		this.getHibernateTemplate().update(field);
	}

	@Override
	public void delete(Field field) {
		this.getHibernateTemplate().delete(field);
	}

	@Override
	public void save(Field field) {
		this.getHibernateTemplate().save(field);
	}
	
}
