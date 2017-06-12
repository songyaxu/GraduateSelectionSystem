package com.seventh.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.ConfigDAO;
import com.seventh.entity.Config;

public class ConfigDAOImpl extends HibernateDaoSupport implements ConfigDAO{
	private final int id=1;
	@Override
	public Config init() {
		return this.getHibernateTemplate().get(Config.class, id);
	}
	@Override
	public void update(Config config) {
		this.getHibernateTemplate().update(config);
	}
	
}
