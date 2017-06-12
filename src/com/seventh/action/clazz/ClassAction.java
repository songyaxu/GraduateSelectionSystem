package com.seventh.action.clazz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Class;
import com.seventh.entity.Major;
import com.seventh.service.ClassService;
import com.seventh.service.MajorService;
import com.seventh.service.StudentService;
@SuppressWarnings("serial")
public class ClassAction extends ActionSupport{
	private StudentService studentService;
	private ClassService classService;
	private MajorService majorService;
	private Major major;
	private Class clazz; 
	private String message;
	private int id;
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
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
	
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		List<Class> clazzs=this.getClassService().findClassByMajorId(id);
		major=this.getMajorService().findMajorById(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("clazzs", clazzs);
		return SUCCESS;
	}
	public String addinit(){
		List<Major> majors=this.getMajorService().findAllMajor();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("majors", majors);
		return "add";
	}
}
