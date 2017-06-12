package com.seventh.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Notice;
import com.seventh.service.NoticeService;

@SuppressWarnings("serial")
public class DetailNoticeAction extends ActionSupport{
	private int id;
	private String loginType;
	private Notice notice;
	private NoticeService noticeService;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public String execute(){
		notice=this.noticeService.detailNotice(id);
		return SUCCESS;
	}
	public String stuDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		notice=this.noticeService.detailNotice(id);
		return "user";
	}
}
