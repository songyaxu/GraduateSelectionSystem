package com.seventh.action.choicemap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Field;
import com.seventh.entity.Page;
import com.seventh.entity.Topic;
import com.seventh.service.ChoiceMapService;
import com.seventh.service.FieldService;
import com.seventh.service.TopicService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class TeacherChoiceAction extends ActionSupport{
	private ChoiceMapService choiceMapService;
	private TopicService topicService;
	private FieldService fieldService;
	private Page page;
	private String message;
	private final int everyPage=10;
	private int currentPage;
	public ChoiceMapService getChoiceMapService() {
		return choiceMapService;
	}
	public void setChoiceMapService(ChoiceMapService choiceMapService) {
		this.choiceMapService = choiceMapService;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	public FieldService getFieldService() {
		return fieldService;
	}
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String execute(){
		String hql="from Topic t where t.isCheck>1 order by t.state desc";
		String hql2="select count(id) from Topic t where t.isCheck>1";
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, 0);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return SUCCESS;
	}
	public String frontPage(){
		String hql="from Topic t where t.isCheck>1 order by t.state desc";
		String hql2="select count(id) from Topic t where t.isCheck>1";
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, currentPage-1);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return "frontpage";
	}
	public String nextPage(){
		String hql="from Topic t where t.isCheck>1 order by t.state desc";
		String hql2="select count(id) from Topic t where t.isCheck>1";
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, currentPage+1);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return "nextpage";
	}
}
