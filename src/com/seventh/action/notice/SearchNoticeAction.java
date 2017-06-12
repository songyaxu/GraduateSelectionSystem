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
public class SearchNoticeAction extends ActionSupport{
	private final int everyPage=10;
	private int currentPage;
	private Page searchNoticePage;
	private Notice notice;
	private String keyword;
	private NoticeService noticeService;
	private String loginType;
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

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Page getSearchNoticePage() {
		return searchNoticePage;
	}
	public void setSearchNoticePage(Page searchNoticePage) {
		this.searchNoticePage = searchNoticePage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		int totalCount=this.noticeService.noticeCounts("title",keyword);
		setSearchNoticePage(PageUtil.createPage(everyPage, totalCount, 0));
		List<Notice> notices=this.noticeService.searchByName(searchNoticePage, keyword);
		request.setAttribute("searchNotices", notices);
		request.setAttribute("searchNoticePage", searchNoticePage);
		return SUCCESS;
	}
	public String nextPage(){
		//ÏÂÒ»Ò³
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		int totalCount=this.noticeService.noticeCounts("title",keyword);
		searchNoticePage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Notice> notices=this.noticeService.searchByName(searchNoticePage, keyword);
		request.setAttribute("searchNotices", notices);
		request.setAttribute("searchNoticePage", searchNoticePage);
		return "NextPage";
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		int totalCount=this.noticeService.noticeCounts("title",keyword);
		searchNoticePage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Notice> notices=this.noticeService.searchByName(searchNoticePage, keyword);
		request.setAttribute("searchNotices", notices);
		request.setAttribute("searchNoticePage", searchNoticePage);
		return "frontPage";
	}
}
