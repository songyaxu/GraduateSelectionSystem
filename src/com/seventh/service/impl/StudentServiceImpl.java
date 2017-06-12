package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.StudentDAO;
import com.seventh.entity.Page;
import com.seventh.entity.Student;
import com.seventh.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDAO  studentDao;
	public StudentDAO getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void saveUser(Student student) {
		this.studentDao.saveUser(student);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentDao.findAllStudents();
	}

	@Override
	public void removeStudent(Student student) {
		this.studentDao.removeStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		this.studentDao.updateStudent(student);
	}

	@Override
	public Student findStudentById(String id) {
		return this.studentDao.findStudentById(id);
	}

	@Override
	public Student loginStudent(Student student) {
		return this.studentDao.loginStudent(student);
	}

	@Override
	public Student findStudentByStudentname(Student student) {
		return this.studentDao.findStudentByStudentname(student);
	}

	@Override
	public List<Student> findStudentByClassId(int id,Page page) {
		return this.getStudentDao().findStudentByClassId(id,page);
	}

	@Override
	public int studentCounts(String hql) {
		return this.getStudentDao().studentCounts(hql);
	}
	
	
}
