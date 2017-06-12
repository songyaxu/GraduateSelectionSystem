package com.seventh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.PositionDAO;
import com.seventh.entity.Position;

public class PositionDAOImpl extends HibernateDaoSupport implements PositionDAO{

	@Override
	public Position findPositionById(int id) {
		return this.getHibernateTemplate().get(Position.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findAllPosition() {
		String hql="from Position";
		return (List<Position>)this.getHibernateTemplate().find(hql);
	}

	@Override
	public void update(Position position) {
		this.getHibernateTemplate().update(position);
	}

	@Override
	public void delete(Position position) {
		this.getHibernateTemplate().delete(position);
	}

	@Override
	public void save(Position position) {
		this.getHibernateTemplate().save(position);
	}
	
	
}
