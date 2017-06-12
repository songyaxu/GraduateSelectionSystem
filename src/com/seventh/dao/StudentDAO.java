package com.seventh.dao;

import java.util.List;

import com.seventh.entity.Page;
import com.seventh.entity.Student;

public interface StudentDAO {
	public void saveUser(Student student);
	public List<Student> findAllStudents();
	public void removeStudent(Student student);
	public void updateStudent(Student student);
	public Student findStudentById(String id);
	public Student loginStudent(Student student);
	public Student findStudentByStudentname(Student student);
	public List<Student> findStudentByClassId(final int id,final Page page);
	public int studentCounts(String hql);
}
