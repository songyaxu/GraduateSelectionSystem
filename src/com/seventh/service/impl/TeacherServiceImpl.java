package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.TeacherDAO;
import com.seventh.entity.Page;
import com.seventh.entity.Teacher;
import com.seventh.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDAO teacherDao;
	
	public TeacherDAO getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public List<Teacher> findAllTeacher(final Page page) {
		return this.getTeacherDao().findAllTeacher(page);
	}

	@Override
	public Teacher findTeacherById(String id) {
		return (Teacher)this.teacherDao.findTeacherById(id);
	}

	@Override
	public int teacherCounts(String hql) {
		return this.getTeacherDao().teacherCounts(hql);
	}

	@Override
	public void save(Teacher teacher) {
		this.getTeacherDao().save(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		this.getTeacherDao().update(teacher);
	}

	@Override
	public void delete(Teacher teacher) {
		this.getTeacherDao().delete(teacher);
	}
	
	
}
