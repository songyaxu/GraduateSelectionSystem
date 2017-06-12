package com.seventh.action.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;
import com.seventh.entity.Student;
import com.seventh.service.NoticeService;
import com.seventh.service.StudentService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class StudentAction extends ActionSupport{
	
	private Student student;
	private StudentService studentService;
	private NoticeService noticeService;
	private Page loginNoticePage;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("student");
		session.removeAttribute("logintype");
		return ERROR;
	}
	public String studentIndex(){
		int totalCount=this.noticeService.noticeCounts("0","0");
		loginNoticePage=PageUtil.createPage(10, totalCount, 0);
		List<Notice> notices=this.noticeService.queryByPage(loginNoticePage);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("loginIndexnotices", notices);
		session.setAttribute("loginNoticePage", loginNoticePage);
		return "Index";
	}
}
