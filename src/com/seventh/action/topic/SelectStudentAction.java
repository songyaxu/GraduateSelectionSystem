package com.seventh.action.topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.*;
import com.seventh.service.ChoiceMapService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.service.TopicService;

@SuppressWarnings("serial")
public class SelectStudentAction extends ActionSupport{
	private ChoiceMapService choiceMapService;
	private TopicService topicService;
	private StudentService studentService;
	private TeacherService teacherService;
	private int id;
	private int topicId;
	private String message;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String accept(){
		ChoiceMap choicemap=this.getChoiceMapService().findChoiceMapById(id);
		System.out.println("id="+id);
		Topic topic=this.getTopicService().findTopicById(choicemap.getTopicId());
		topicId=topic.getId();
		System.out.println("topicId="+topicId);
		topic.setStudentId(choicemap.getStudentId());
		topic.setState(1);
		topic.setIsEnable(1);
		try{
			this.getTopicService().update(topic);
		}
		catch(Exception e){
			message="客户端信息与服务端信息不一致";
			return ERROR;
		}
		List<ChoiceMap> choicemaps=this.getChoiceMapService().findByTopicId(choicemap.getTopicId());
		for(int i=0;i<choicemaps.size();i++)
		{
			if(choicemaps.get(i).getId()!=choicemap.getId())
			{
				choicemaps.get(i).setState(2);
				Student studenttemp=this.getStudentService().findStudentById(choicemaps.get(i).getStudentId());
				studenttemp.setChoiceNum(studenttemp.getChoiceNum()-1);
				this.studentService.updateStudent(studenttemp);
				this.getChoiceMapService().update(choicemaps.get(i));
			}
		}
		choicemap.setState(1);
		Student student=this.getStudentService().findStudentById(choicemap.getStudentId());
		student.setIsMatched(1);
		System.out.println(topic.getTeacherId());
		topic=this.getTopicService().findTopicById(choicemap.getTopicId());
		System.out.println(topic.getTeacherId());
		System.out.println("topic="+topic.getId());
		Teacher teacher=this.getTeacherService().findTeacherById(topic.getTeacherId());
		//update
		List<ChoiceMap> choicemaps2=this.getChoiceMapService().findByStudentId(student.getId());
		for(int i=0;i<choicemaps2.size();i++)
		{
			if(choicemaps2.get(i).getId()!=choicemap.getId())
			{
				choicemaps2.get(i).setState(2);
				Topic topictemp=this.getTopicService().findTopicById(choicemaps2.get(i).getTopicId());
				if(topictemp.getIsStuApply()!=1)
				{
					topictemp.setApplyNum(topictemp.getApplyNum()-1);
					topictemp.setIsEnable(0);
					this.getTopicService().update(topictemp);
				}
				else
				{
					topictemp.setIsEnable(1);
					this.getTopicService().update(topictemp);
				}
				this.getChoiceMapService().update(choicemaps2.get(i));
			}
		}
		this.getChoiceMapService().update(choicemap);
		student.setIsMatched(1);
		this.getStudentService().updateStudent(student);
		teacher.setGuidanceNum(teacher.getGuidanceNum()+1);
		this.getTeacherService().update(teacher);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Config config=(Config)session.getAttribute("config");
		Position position=(Position)session.getAttribute("position");
		if(config.getTeaGuidanceNum()+teacher.getMaxGuidanceNum()+position.getLevel()==teacher.getGuidanceNum()+1)
		{
			List<Topic> topics=this.getTopicService().checkTopicByTeacherId(teacher.getId());
			for(int i=0;i<topics.size();i++)
			{
				topics.get(i).setIsEnable(0);
				List<ChoiceMap> lcs=this.getChoiceMapService().findByTopicId(topics.get(i).getId());
				for(int j=0;j<lcs.size();j++)
				{
					if(lcs.get(j).getState()==0)
					{
						lcs.get(j).setState(2);
						this.getChoiceMapService().update(lcs.get(j));
						Student stu=this.getStudentService().findStudentById(lcs.get(j).getStudentId());
						stu.setChoiceNum(stu.getChoiceNum()-1);
						this.getStudentService().updateStudent(stu);
					}
				}
				this.getTopicService().update(topics.get(i));
			}
		}
		message="选择成功";
		return SUCCESS;
	}
	public String refuse(){
		ChoiceMap choicemap=this.getChoiceMapService().findChoiceMapById(id);
		Topic topic=this.getTopicService().findTopicById(choicemap.getTopicId());
		topicId=topic.getId();
		Student student=this.getStudentService().findStudentById(choicemap.getStudentId());
		student.setChoiceNum(student.getChoiceNum()-1);
		this.getStudentService().updateStudent(student);
		topic.setApplyNum(topic.getApplyNum()-1);
		topic.setIsEnable(0);
		try{
			this.getTopicService().update(topic);
		}
		catch(Exception e){
			message="客户端信息与服务端信息不一致";
			return ERROR;
		}
		message="成功拒绝";
		return SUCCESS;
	}
}
