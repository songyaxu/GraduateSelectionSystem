package com.seventh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.ChoiceMapDAO;
import com.seventh.entity.ChoiceMap;

public class ChoiceMapDAOImpl extends HibernateDaoSupport implements ChoiceMapDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ChoiceMap> findByStudentId(String id) {
		String hql="from ChoiceMap c where c.studentId='"+id+"'";
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChoiceMap> findByTopicId(int id) {
		String hql="from ChoiceMap c where c.topicId="+id;
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void save(ChoiceMap choiceMap) {
		this.getHibernateTemplate().save(choiceMap);
	}

	@Override
	public void update(ChoiceMap choiceMap) {
		this.getHibernateTemplate().update(choiceMap);
	}

	@Override
	public void delete(ChoiceMap choiceMap) {
		this.getHibernateTemplate().delete(choiceMap);
	}

	@Override
	public ChoiceMap findChoiceMapById(int id) {
		return this.getHibernateTemplate().get(ChoiceMap.class, id);
	}
	
}
