package com.seventh.action.student;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Class;
import com.seventh.entity.Major;
import com.seventh.entity.Student;
import com.seventh.service.ClassService;
import com.seventh.service.MajorService;
import com.seventh.service.StudentService;
import com.seventh.util.MD5Util;

@SuppressWarnings("serial")
public class AddStudentAction extends ActionSupport{
	private ClassService classService;
	private MajorService majorService;
	private StudentService studentService;
	private Student student;
	private String message;
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String addinit(){
		List<Major> majors=this.getMajorService().findAllMajor();
		List<Class> clazzs=this.getClassService().findAllClass();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("majors", majors);
		request.setAttribute("clazzs", clazzs);
		return "init";
	}
	public String execute() throws UnsupportedEncodingException{
		if(student.getClassId()==-1)
		{
			message="请选择学生所在班级";
			message=URLEncoder.encode(message, "UTF-8"); 
			return ERROR;
		}
		else{
			student.setPassword(MD5Util.md5(student.getId()));
			this.getStudentService().saveUser(student);
			message="添加成功";
			message=URLEncoder.encode(message, "UTF-8"); 
			return SUCCESS;
		}
		
	}
}
