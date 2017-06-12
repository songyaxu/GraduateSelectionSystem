package com.seventh.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;
import com.seventh.service.AdminService;
import com.seventh.service.NoticeService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport{
	private AdminService adminService;
	private NoticeService noticeService;
	private Page loginNoticePage;
	
	
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

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		session.removeAttribute("logintype");
		return ERROR;
	}
	public String adminIndex(){
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
