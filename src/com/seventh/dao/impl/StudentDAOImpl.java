package com.seventh.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.seventh.dao.StudentDAO;
import com.seventh.entity.Page;
import com.seventh.entity.Student;

public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO{

	@Override
	public void saveUser(Student student) {
		this.getHibernateTemplate().save(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudents() {
		String hql="from Student student order by student.id desc";
		return (List<Student>)this.getHibernateTemplate().find(hql);
	}

	@Override
	public void removeStudent(Student student) {
		this.getHibernateTemplate().delete(student);
	}

	@Override
	public void updateStudent(Student student) {
		this.getHibernateTemplate().update(student);
	}

	@Override
	public Student findStudentById(String id) {
		Student student=(Student)this.getHibernateTemplate().get(Student.class, id);
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Student loginStudent(Student student) {
		String hql = "from Student student where student.id='"
				+ student.getId() + "' and student.password='"
				+ student.getPassword() + "'";
		List<Student> students = (List<Student>) this.getHibernateTemplate().find(hql);
		if (students.size() > 0) {
			return students.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Student findStudentByStudentname(Student student) {
		String hql = "from Student student where student.name='"
				+ student.getName() + "'";
		List<Student> students = (List<Student>) this.getHibernateTemplate().find(hql);
		if (students.size() > 0) {
			return students.get(0);
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Student> findStudentByClassId(final int id,final Page page) {
		return (List<Student>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
            	String hql="from Student s where s.classId="+id;
                Query query = session.createQuery(hql); 
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        });
	}

	@Override
	public int studentCounts(String hql) {
		return ((Long)this.getHibernateTemplate().find(hql).get(0)).intValue();
	}
	
}
