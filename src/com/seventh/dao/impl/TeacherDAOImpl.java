package com.seventh.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.seventh.dao.TeacherDAO;
import com.seventh.entity.Page;
import com.seventh.entity.Teacher;

public class TeacherDAOImpl extends HibernateDaoSupport implements TeacherDAO{
	@Override
	public Teacher findTeacherById(String id) {
		Teacher teacher	=this.getHibernateTemplate().get(Teacher.class, id);
		return teacher;
	}

	@Override
	public int teacherCounts(String hql) {
		return ((Long)this.getHibernateTemplate().find(hql).get(0)).intValue();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Teacher> findAllTeacher(final Page page) {
		return (List<Teacher>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery("from Teacher");  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}

	@Override
	public void save(Teacher teacher) {
		this.getHibernateTemplate().save(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		this.getHibernateTemplate().update(teacher);
	}

	@Override
	public void delete(Teacher teacher) {
		this.getHibernateTemplate().delete(teacher);
	}
	
	
}
