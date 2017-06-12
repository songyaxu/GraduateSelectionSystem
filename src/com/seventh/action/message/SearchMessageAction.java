package com.seventh.action.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Admin;
import com.seventh.entity.Message;
import com.seventh.entity.Page;
import com.seventh.entity.Student;
import com.seventh.entity.Teacher;
import com.seventh.service.MessageService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class SearchMessageAction extends ActionSupport{
	private String type;
	private Message message;
	private Page messagePage;
	private int currentPage;
	private String loginType;
	private MessageService messageService;
	private final int everyPage=10;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Page getMessagePage() {
		return messagePage;
	}
	public void setMessagePage(Page messagePage) {
		this.messagePage = messagePage;
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
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String checkMessage()
	{	
		String id;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String logintype=(String)session.getAttribute("logintype");
		loginType=logintype;
		if(logintype.equals("student"))
			id=((Student)session.getAttribute("student")).getId();
		else
			if(logintype.equals("teacher"))
				id=((Teacher)session.getAttribute("teacher")).getId();
			else
			{
				id=((Admin)session.getAttribute("admin")).getId();
				loginType="administrator";
			}
		int totalCount=this.messageService.receiveMeesageCounts(id, logintype);
		messagePage=PageUtil.createPage(everyPage, totalCount, 0);
		List<Message> messages=this.messageService.searchMessageByReceiveId(id, logintype, messagePage);
		request.setAttribute("messages", messages);
		request.setAttribute("messagePage", messagePage);
		return SUCCESS;
	}
	public String nextPage(){
		String id;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String logintype=(String)session.getAttribute("logintype");
		loginType=logintype;
		if(logintype.equals("student"))
			id=((Student)session.getAttribute("student")).getId();
		else
			if(logintype.equals("teacher"))
				id=((Teacher)session.getAttribute("teacher")).getId();
			else
			{
				id=((Admin)session.getAttribute("admin")).getId();
				loginType="administrator";
			}
		int totalCount=this.messageService.receiveMeesageCounts(id, logintype);
		messagePage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Message> messages=this.messageService.searchMessageByReceiveId(id, logintype, messagePage);
		request.setAttribute("messages", messages);
		request.setAttribute("messagePage", messagePage);
		return "nextPage";
	}
	public String frontPage(){
		String id;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String logintype=(String)session.getAttribute("logintype");
		loginType=logintype;
		if(logintype.equals("student"))
			id=((Student)session.getAttribute("student")).getId();
		else
			if(logintype.equals("teacher"))
				id=((Teacher)session.getAttribute("teacher")).getId();
			else
			{
				id=((Admin)session.getAttribute("admin")).getId();
				loginType="administrator";
			}
		int totalCount=this.messageService.receiveMeesageCounts(id, logintype);
		messagePage=PageUtil.createPage(everyPage, totalCount, currentPage-1);
		List<Message> messages=this.messageService.searchMessageByReceiveId(id, logintype, messagePage);
		request.setAttribute("messages", messages);
		request.setAttribute("messagePage", messagePage);
		return "frontPage";
	}
}
