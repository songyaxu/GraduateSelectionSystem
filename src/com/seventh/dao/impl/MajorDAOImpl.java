package com.seventh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.MajorDAO;
import com.seventh.entity.Major;

public class MajorDAOImpl extends HibernateDaoSupport implements MajorDAO{

	@Override
	public Major findMajorById(int id) {
		return this.getHibernateTemplate().get(Major.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Major> findAllMajor() {
		String hql="from Major";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void update(Major major) {
		this.getHibernateTemplate().update(major);
	}

	@Override
	public void delete(Major major) {
		this.getHibernateTemplate().delete(major);
	}

	@Override
	public void save(Major major) {
		this.getHibernateTemplate().save(major);
	}
	
}
