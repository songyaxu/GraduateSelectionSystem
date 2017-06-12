package com.seventh.action.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Config;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;
import com.seventh.service.ConfigService;
import com.seventh.service.NoticeService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class NoticeAction extends ActionSupport{
	private String message;
	private Page noticePage;
	private int currentPage;
	private Notice notice;
	private Config config;
	private NoticeService noticeService;
	private ConfigService configService;
	private final int everyPage=10;
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Page getNoticePage() {
		return noticePage;
	}


	public void setNoticePage(Page noticePage) {
		this.noticePage = noticePage;
	}

	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public Notice getNotice() {
		return notice;
	}


	public void setNotice(Notice notice) {
		this.notice = notice;
	}


	public Config getConfig() {
		return config;
	}


	public void setConfig(Config config) {
		this.config = config;
	}
	
	public NoticeService getNoticeService() {
		return noticeService;
	}


	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public ConfigService getConfigService() {
		return configService;
	}


	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}
	public String addinit(){
		return "addinit";
	}
	public String execute(){
		int totalCount=this.noticeService.noticeCounts("0","0");
		noticePage=PageUtil.createPage(8, totalCount, 0);
		config=configService.init();
		List<Notice> notices=this.noticeService.queryByPage(noticePage);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("scrolling", config.getScrollingNotice());
		request.setAttribute("indexnotices", notices);
		return SUCCESS;
	}
	public String more(){
		int totalCount=this.noticeService.noticeCounts("0","0");
		noticePage=PageUtil.createPage(everyPage, totalCount, 0);
		List<Notice> notices=this.noticeService.queryByPage(noticePage);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("notices", notices);
		request.setAttribute("noticePage", noticePage);
		return "more";
	}
	public String nextPage(){
		int totalCount=this.noticeService.noticeCounts("0","0");
		noticePage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Notice> notices=this.noticeService.queryByPage(noticePage);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("notices", notices);
		request.setAttribute("noticePage", noticePage);
		return "NextPage";
		
	}
	public String frontPage(){
		int totalCount=this.noticeService.noticeCounts("0","0");
		noticePage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Notice> notices=this.noticeService.queryByPage(noticePage);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("notices", notices);
		request.setAttribute("noticePage", noticePage);
		return "frontPage";
	}
}
