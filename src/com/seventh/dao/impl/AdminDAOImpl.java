package com.seventh.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.AdminDAO;
import com.seventh.entity.Admin;

public class AdminDAOImpl extends HibernateDaoSupport implements AdminDAO{


	@Override
	public Admin findAdminById(String id) {
		return (Admin)this.getHibernateTemplate().get(Admin.class, id);
	}

	@Override
	public void update(Admin admin) {
		this.getHibernateTemplate().update(admin);
	}

	@Override
	public void delete(Admin admin) {
		this.getHibernateTemplate().delete(admin);
	}

	@Override
	public void save(Admin admin) {
		this.getHibernateTemplate().save(admin);
	}
	
}
