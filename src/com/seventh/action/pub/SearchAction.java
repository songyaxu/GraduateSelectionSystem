package com.seventh.action.pub;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.service.AdminService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;

@SuppressWarnings("serial")
public class SearchAction extends ActionSupport{
	private String id;
	private StudentService studentService;
	private TeacherService teacherService;
	private AdminService adminService;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public String execute(){
		return SUCCESS;
	}
}
