package com.seventh.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.TopicDAO;
import com.seventh.entity.Page;
import com.seventh.entity.Topic;

@SuppressWarnings("unchecked")
public class TopicDAOImpl extends HibernateDaoSupport implements TopicDAO{

	@Override
	public int topicTotalNumByHql(String hql) {
		return ((Long)this.getHibernateTemplate().find(hql).get(0)).intValue();
	}
	
	
	@Override
	public Topic findTopicById(int id) {
		return this.getHibernateTemplate().get(Topic.class, id);
	}

	@Override
	public void save(Topic topic) {
		this.getHibernateTemplate().save(topic);
	}

	@Override
	public void delete(Topic topic) {
		this.getHibernateTemplate().delete(topic);
	}

	@Override
	public void update(Topic topic) {
		this.getHibernateTemplate().update(topic);
	}

	@Override
	public List<Topic> checkTopicByStudentId(String id) {
		String hql="from Topic t where t.studentId='"+id+"'";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<Topic> checkTopicByTeacherId(String id) {
		String hql="from Topic t where t.teacherId='"+id+"'";
		return this.getHibernateTemplate().find(hql);
	}


	@SuppressWarnings("rawtypes")
	@Override
	public List<Topic> SearchTopicByhql(final String hql,final Page page) {
		return (List<Topic>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery(hql);  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}
	
}
