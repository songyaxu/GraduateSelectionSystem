package com.seventh.action.topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.ChoiceMap;
import com.seventh.entity.Config;
import com.seventh.entity.Field;
import com.seventh.entity.Student;
import com.seventh.entity.Topic;
import com.seventh.service.ChoiceMapService;
import com.seventh.service.FieldService;
import com.seventh.service.MessageService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.service.TopicService;
import com.seventh.util.TimeUtil;

@SuppressWarnings("serial")
public class StuAddTopicAction extends ActionSupport{
	private TopicService topicService;
	private FieldService fieldService;
	private StudentService studentService;
	private TeacherService teacherService;
	private MessageService messageService;
	private ChoiceMapService choiceMapService;
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
	
	public ChoiceMapService getChoiceMapService() {
		return choiceMapService;
	}
	public void setChoiceMapService(ChoiceMapService choiceMapService) {
		this.choiceMapService = choiceMapService;
	}
	public String init()
	{
		List<Field> fields=this.getFieldService().findAllField();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("fields", fields);
		return "init";
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Config config=(Config)session.getAttribute("config");
		Student student=(Student)session.getAttribute("student");
		if(student.getIsMatched()==1)
		{
			message="您已选题成功！";
			return INPUT;
		}
		if(student.getChoiceNum()+1>config.getStuMaxChoiceNum())
		{
			message="已选择题目总数已等于最大选择数"+config.getStuMaxChoiceNum();
			return INPUT;
		}
		if(topic.getFieldId()==-1)
		{
			message="请选择研究方向";
			return INPUT;
		}
		else{
			topic.setApplyNum(0);
			topic.setContent(editorValue);
			topic.setCreatetime(TimeUtil.currentTime());
			topic.setIsAutoMatch(0);
			topic.setIsCheck(2);
			topic.setIsEnable(0);
			topic.setIsStuApply(1);
			topic.setApplyNum(1);
			topic.setState(0);
			topic.setStudentId(student.getId());
			this.getTopicService().save(topic);
			student.setChoiceNum(student.getChoiceNum()+1);
			this.getStudentService().updateStudent(student);
			ChoiceMap choiceMap=new ChoiceMap();
			choiceMap.setCreateTime(TimeUtil.currentTime());
			choiceMap.setStudentId(student.getId());
			choiceMap.setStudentName(student.getName());
			choiceMap.setTopicId(topic.getId());
			choiceMap.setTopicTitle(topic.getTitle());
			this.getChoiceMapService().save(choiceMap);
			message="发布成功";
			return SUCCESS;
		}
	}
}	
