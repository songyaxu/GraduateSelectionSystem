package com.seventh.action.topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.ChoiceMap;
import com.seventh.entity.Field;
import com.seventh.entity.Student;
import com.seventh.entity.Teacher;
import com.seventh.entity.Topic;
import com.seventh.service.ChoiceMapService;
import com.seventh.service.FieldService;
import com.seventh.service.TopicService;
import com.seventh.util.TimeUtil;

@SuppressWarnings("serial")
public class TopicAction extends ActionSupport{
	private TopicService topicService;
	private FieldService fieldService;
	private ChoiceMapService choiceMapService;
	private String message;
	private Topic topic;
	
	public ChoiceMapService getChoiceMapService() {
		return choiceMapService;
	}
	public void setChoiceMapService(ChoiceMapService choiceMapService) {
		this.choiceMapService = choiceMapService;
	}
	public TopicService getTopicService() {
		return topicService;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String execute(){
		return SUCCESS;
	}
	public String checkStuTopic(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String id=((Student)session.getAttribute("student")).getId();
		List<ChoiceMap> choiceMaps=this.getChoiceMapService().findByStudentId(id); 
		for(int i=0;i<choiceMaps.size();i++)
		{
			choiceMaps.get(i).setStudentName(TimeUtil.getTimeWithoutMilliSecond(choiceMaps.get(i).getCreateTime()));
		}
		request.setAttribute("choiceMaps", choiceMaps);
		return "stu";
	}
	public String checkTeaTopic(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String id=((Teacher)session.getAttribute("teacher")).getId();
		List<Topic> topics=this.getTopicService().checkTopicByTeacherId(id);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		request.setAttribute("topics", topics);
		return "tea";
	}
}
