package com.seventh.action.topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Field;
import com.seventh.entity.Page;
import com.seventh.entity.Topic;
import com.seventh.service.FieldService;
import com.seventh.service.TopicService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class SearchTopicAction extends ActionSupport{
	private TopicService topicService;
	private FieldService fieldService;
	private String check;
	private String fieldId;
	private String name;
	private String id;
	private String difficulty;
	private String matchType;
	private String state;
	private String message;
	private final int everyPage=10;
	private int currentPage;
	private String loginType;
	private Page page;
	public FieldService getFieldService() {
		return fieldService;
	}
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String execute(){
		String hqlstart="from Topic t";
		String hqlbody="";
		String hqlend=" order by t.state asc";
		if(!id.equals(""))
			hqlbody+=" t.id="+id;
		if(!fieldId.equals(""))
		{
			if(!hqlbody.equals(""))
				hqlbody+=" and ";
			hqlbody+=" t.fieldId="+fieldId;
		}
		if(!difficulty.equals(""))
		{
			if(!hqlbody.equals(""))
				hqlbody+=" and ";
			hqlbody+=" t.difficulty="+difficulty;
		}
		if(!state.equals(""))
		{
			if(!hqlbody.equals(""))
				hqlbody+=" and ";
			hqlbody+=" t.isEnable="+state;
		}
		if(!matchType.equals(""))
		{
			if(!hqlbody.equals(""))
				hqlbody+=" and ";
			hqlbody+=" t.isAutoMatch="+matchType;
		}
		if(!check.equals(""))
		{
			if(!hqlbody.equals(""))
				hqlbody+=" and ";
			hqlbody+=" t.isCheck="+check;
		}
		if(!name.equals(""))
		{
			if(!hqlbody.equals(""))
				hqlbody+=" and ";
			hqlbody+=" t.title like '%"+name+"%'";
		}
		if(!hqlbody.equals(""))
			hqlstart+=" where ";
		String hql=hqlstart+hqlbody+hqlend;
		String hql2="select count(id) "+hqlstart+hqlbody;
		System.out.println("hql"+hql);
		System.out.println("hql2:"+hql2);
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, 0);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		loginType=(String)session.getAttribute("logintype");
		session.setAttribute("hql", hql);
		session.setAttribute("hql2", hql2);
		if(loginType.equals("admin"))
			loginType="administrator";
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return SUCCESS;
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String hql=(String)session.getAttribute("hql");
		String hql2=(String)session.getAttribute("hql2");
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, currentPage-1);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return SUCCESS;
	}
	public String nextPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String hql=(String)session.getAttribute("hql");
		String hql2=(String)session.getAttribute("hql2");
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, currentPage+1);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return SUCCESS;
	}
}
