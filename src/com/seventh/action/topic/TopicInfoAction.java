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
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.service.TopicService;

@SuppressWarnings("serial")
public class TopicInfoAction extends ActionSupport{
	private TopicService topicService;
	private FieldService fieldService;
	private TeacherService teacherService;
	private StudentService studentService;
	private ChoiceMapService choiceMapService;
	private String message;
	private Teacher teacher;
	private Student student;
	private String loginType;
	private String editorValue;
	private int id;
	private Topic topic;
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
	
	public String getEditorValue() {
		return editorValue;
	}
	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public ChoiceMapService getChoiceMapService() {
		return choiceMapService;
	}
	public void setChoiceMapService(ChoiceMapService choiceMapService) {
		this.choiceMapService = choiceMapService;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String detail(){
		topic=this.getTopicService().findTopicById(id);
		if(topic.getIsStuApply()==1)
			student=this.getStudentService().findStudentById(topic.getStudentId());
		else
			teacher=this.getTeacherService().findTeacherById(topic.getTeacherId());
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		Field field=this.getFieldService().findFieldById(topic.getFieldId());
		request.setAttribute("field", field);
		List<ChoiceMap> choiceMaps=this.getChoiceMapService().findByTopicId(id);
		request.setAttribute("choiceMaps", choiceMaps);
		return "detail";
	}
	public String init(){
		topic=this.getTopicService().findTopicById(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		Field field=this.getFieldService().findFieldById(topic.getFieldId());
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("field", field);
		request.setAttribute("fields", fields);
		return "edit";
	}
	public String update(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		Topic old=this.getTopicService().findTopicById(topic.getId());
		old.setContent(editorValue);
		old.setDescription(topic.getDescription());
		old.setDifficulty(topic.getDifficulty());
		old.setEnvironment(topic.getEnvironment());
		old.setNeedNum(topic.getNeedNum());
		old.setTitle(topic.getTitle());
		old.setFieldId(topic.getFieldId());
		this.getTopicService().update(old);
		message="ÐÞ¸Ä³É¹¦";
		return "update";
	}
}
