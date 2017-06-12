package com.seventh.action.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Student;
import com.seventh.entity.Class;
import com.seventh.entity.Major;
import com.seventh.service.ClassService;
import com.seventh.service.MajorService;
import com.seventh.service.StudentService;
import com.seventh.util.MD5Util;

@SuppressWarnings("serial")
public class StuInfoAction extends ActionSupport{
	private String message;
	private Student student;
	private Major major;
	private Class clazz;
	private String oldPassword;
	private String newPassword1;
	private String newPassword2;
	private StudentService studentService;
	private MajorService majorService;
	private ClassService classService;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
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
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword1() {
		return newPassword1;
	}
	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}
	public String getNewPassword2() {
		return newPassword2;
	}
	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Student studentLogin=(Student)session.getAttribute("student");
		student=this.studentService.findStudentById(studentLogin.getId());
		clazz=this.getClassService().findClassById(student.getClassId());
		major=this.getMajorService().findMajorById(clazz.getMajorId());
		message="";
		return SUCCESS;
	}
	public String update(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Student studentLogin=(Student)session.getAttribute("student");
		studentLogin.setBirthday(student.getBirthday());
		studentLogin.setEmail(student.getEmail());
		studentLogin.setGender(student.getGender());
		studentLogin.setPhone(student.getPhone());
		studentLogin.setQq(student.getQq());
		this.studentService.updateStudent(studentLogin);
		message="修改成功";
		return "update";
	}
	public String modify(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Student studentLogin=(Student)session.getAttribute("student");
		student=this.studentService.findStudentById(studentLogin.getId());
		message="";
		return "modify";
	}
	public String modifyPW(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Student studentLogin=(Student)session.getAttribute("student");
		Student oldpwstudent=this.studentService.findStudentById(studentLogin.getId());
		System.out.println(oldPassword+"   "+oldpwstudent.getPassword());
		if(MD5Util.md5(oldPassword).equals(oldpwstudent.getPassword()))
		{
			if(newPassword1.equals(newPassword2))
			{
				oldpwstudent.setPassword(MD5Util.md5(newPassword1));
				this.studentService.updateStudent(oldpwstudent);
				message="修改成功";
				return "modified";
			}
			else
			{
				message="两次密码输入不一致";
				return ERROR;
			}
		}
		else
		{
			message="原密码错误！";
			return ERROR;
		}
	}
}
