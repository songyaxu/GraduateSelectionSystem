package com.seventh.action.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;
import com.seventh.entity.Teacher;
import com.seventh.service.NoticeService;
import com.seventh.service.TeacherService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class TeacherAction extends ActionSupport{
	private Teacher teacher;
	private TeacherService teacherService;
	private NoticeService noticeService;
	private String message;
	private Page loginNoticePage;
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
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public Page getLoginNoticePage() {
		return loginNoticePage;
	}
	public void setLoginNoticePage(Page loginNoticePage) {
		this.loginNoticePage = loginNoticePage;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("teacher");
		session.removeAttribute("logintype");
		return ERROR;
	}
	public String teacherIndex(){
		int totalCount=this.noticeService.noticeCounts("0","0");
		loginNoticePage=PageUtil.createPage(10, totalCount, 0);
		List<Notice> notices=this.noticeService.queryByPage(loginNoticePage);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("loginIndexnotices", notices);
		session.setAttribute("loginNoticePage", loginNoticePage);
		return "Index";
	}
	public String teacherDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Teacher teacher1=(Teacher)session.getAttribute("teacher");
		teacher =this.teacherService.findTeacherById(teacher1.getId());
		return "teacher";
	}
}
