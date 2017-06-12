package com.seventh.action.topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Config;
import com.seventh.entity.Field;
import com.seventh.entity.Message;
import com.seventh.entity.Position;
import com.seventh.entity.Teacher;
import com.seventh.entity.Topic;
import com.seventh.service.FieldService;
import com.seventh.service.MessageService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.service.TopicService;
import com.seventh.util.TimeUtil;

@SuppressWarnings("serial")
public class AddTopicAction extends ActionSupport{
	private TopicService topicService;
	private FieldService fieldService;
	private StudentService studentService;
	private TeacherService teacherService;
	private MessageService messageService;
	private Topic topic;
	private String message;
	private String editorValue;
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
	
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
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
	
	public String getEditorValue() {
		return editorValue;
	}
	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Position position=(Position)session.getAttribute("position");
		Config config=(Config)session.getAttribute("config");
		String id=((Teacher)session.getAttribute("teacher")).getId();
		Teacher teacher=this.teacherService.findTeacherById(id);
		if(teacher.getQuestionNum()+1>position.getMaxQuestionNum())
		{
			message="出题数量超过最大限制";
			return INPUT;
		}
		if(topic.getFieldId()==-1)
		{
			message="请选择研究方向";
			return INPUT;
		}
		else
		{
			topic.setApplyNum(0);
			topic.setContent(editorValue);
			topic.setCreatetime(TimeUtil.currentTime());
			topic.setIsAutoMatch(0);
			topic.setIsCheck(0);
			if(teacher.getMaxGuidanceNum()+position.getLevel()+config.getTeaGuidanceNum()==teacher.getGuidanceNum())
			{
				topic.setIsEnable(1);
			}
			else
				topic.setIsEnable(0);
			topic.setIsStuApply(0);
			topic.setState(0);
			topic.setTeacherId(id);
			this.getTopicService().save(topic);
			teacher.setQuestionNum(teacher.getQuestionNum()+1);
			this.getTeacherService().update(teacher);
			if(teacher.getQuestionNum()<config.getTeaMinTopicNum())
			{
				Message mes=new Message();
				mes.setAction("系统通知");
				mes.setContent("根据您的出题情况，您还需要至少出题"+(config.getTeaMinTopicNum()-teacher.getQuestionNum()+"道."));
				mes.setCreateTime(TimeUtil.currentTime());
				mes.setReceiveId(teacher.getId());
				mes.setReceiveName(teacher.getName());
				mes.setSendId("0000");
				mes.setSendName("系统通知");
				mes.setSendType("system");
				this.getMessageService().add(mes);
			}
			message="发布成功";
			return SUCCESS;
		}
	}
	public String init(){
		List<Field> fields=this.getFieldService().findAllField();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("fields", fields);
		return "init";
	}
}
