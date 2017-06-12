package com.seventh.action.teacher;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Teacher;
import com.seventh.service.TeacherService;
import com.seventh.util.MD5Util;

@SuppressWarnings("serial")
public class TeacherInfoAction extends ActionSupport{
	private Teacher teacher;
	private String oldPassword;
	private String newPassword1;
	private String newPassword2;
	private TeacherService teacherService;
	private String message;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public String update(){
		Teacher old=this.getTeacherService().findTeacherById(teacher.getId());
		old.setEmail(teacher.getEmail());
		old.setGender(teacher.getGender());
		old.setPhone(teacher.getPhone());
		old.setQq(teacher.getQq());
		this.getTeacherService().update(old);
		message="修改成功";
		return SUCCESS;
	}
	public String modifyPw(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Teacher teacherLogin=(Teacher)session.getAttribute("teacher");
		Teacher oldpwteacher=this.teacherService.findTeacherById(teacherLogin.getId());
		if(MD5Util.md5(oldPassword).equals(oldpwteacher.getPassword()))
		{
			if(newPassword1.equals(newPassword2))
			{
				oldpwteacher.setPassword(MD5Util.md5(newPassword1));
				this.teacherService.update(oldpwteacher);
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
	public String init(){
		return "init";
	}
}
