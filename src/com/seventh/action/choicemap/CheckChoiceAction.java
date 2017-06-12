package com.seventh.action.choicemap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.ChoiceMap;
import com.seventh.entity.Topic;
import com.seventh.service.ChoiceMapService;
import com.seventh.service.TopicService;

@SuppressWarnings("serial")
public class CheckChoiceAction extends ActionSupport{
	private ChoiceMapService choiceMapService;
	private TopicService topicService;
	private String loginType;
	private int id;
	private int topicId;
	private Topic topic;
	private String message;
	public ChoiceMapService getChoiceMapService() {
		return choiceMapService;
	}
	public void setChoiceMapService(ChoiceMapService choiceMapService) {
		this.choiceMapService = choiceMapService;
	}
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
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		System.out.println(loginType);
		if(id==0)
			id=topicId;
		topic=this.getTopicService().findTopicById(id);
		List<ChoiceMap> choiceMaps=this.getChoiceMapService().findByTopicId(id);
		request.setAttribute("choiceMaps", choiceMaps);
		return SUCCESS;
	}
}
