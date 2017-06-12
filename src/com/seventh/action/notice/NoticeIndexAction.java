package com.seventh.action.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;
import com.seventh.service.NoticeService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class NoticeIndexAction extends ActionSupport{
	private Notice notice;
	private Page noticeIndexPage;
	private int currentPage;
	private String loginType;
	private NoticeService noticeService;
	private final int everyPage=10;
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public Page getNoticeIndexPage() {
		return noticeIndexPage;
	}
	public void setNoticeIndexPage(Page noticeIndexPage) {
		this.noticeIndexPage = noticeIndexPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	

	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		int totalCount=this.noticeService.noticeCounts("0","0");
		setNoticeIndexPage(PageUtil.createPage(everyPage, totalCount, 0));
		List<Notice> notices=this.noticeService.queryByPage(noticeIndexPage);
		session.setAttribute("indexnotices", notices);
		session.setAttribute("noticeIndexPage", noticeIndexPage);
		return SUCCESS;
	}
	public String nextPage(){
		//ÏÂÒ»Ò³
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		int totalCount=this.noticeService.noticeCounts("0","0");
		noticeIndexPage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Notice> notices=this.noticeService.queryByPage(noticeIndexPage);
		session.setAttribute("indexnotices", notices);
		session.setAttribute("noticeIndexPage", noticeIndexPage);
		return "NextPage";
		
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		int totalCount=this.noticeService.noticeCounts("0","0");
		noticeIndexPage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Notice> notices=this.noticeService.queryByPage(noticeIndexPage);
		session.setAttribute("indexnotices", notices);
		session.setAttribute("noticeIndexPage", noticeIndexPage);
		return "frontPage";
	}
}
