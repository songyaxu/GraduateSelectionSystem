package com.seventh.action.topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.ChoiceMap;
import com.seventh.entity.Config;
import com.seventh.entity.Position;
import com.seventh.entity.Student;
import com.seventh.entity.Teacher;
import com.seventh.entity.Topic;
import com.seventh.service.ChoiceMapService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.service.TopicService;

@SuppressWarnings("serial")
public class ChoiceStuTopicAction extends ActionSupport{
	private ChoiceMapService choiceMapService;
	private TopicService topicService;
	private StudentService studentService;
	private TeacherService teacherService;
	private String message;
	private int id;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		Topic topic=this.getTopicService().findTopicById(id);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		Config config=(Config)session.getAttribute("config");
		Position position=(Position)session.getAttribute("position");
		if(teacher.getMaxGuidanceNum()+position.getLevel()+config.getTeaGuidanceNum()==teacher.getGuidanceNum())
		{
			message="指导数量已达到上限";
			return ERROR;
		}
		topic.setTeacherId(teacher.getId());
		topic.setIsCheck(0);
		topic.setIsEnable(1);
		topic.setState(1);
		try{
			this.getTopicService().update(topic);
		}
		catch(Exception e){
			message="客户端信息与服务器短信息不符";
			return ERROR;
		}
		List<ChoiceMap> choicemap=this.getChoiceMapService().findByStudentId(topic.getStudentId());
		choicemap.get(0).setState(1);
		this.choiceMapService.update(choicemap.get(0));
		Student student=this.getStudentService().findStudentById(topic.getStudentId());
		student.setIsMatched(1);
		this.getStudentService().updateStudent(student);
		List<ChoiceMap> choiceMaps=this.getChoiceMapService().findByStudentId(topic.getStudentId());
		for(int i=0;i<choiceMaps.size();i++)
		{
			if(choiceMaps.get(i).getTopicId()!=id)
			{
				choiceMaps.get(i).setState(2);
				this.getChoiceMapService().update(choiceMaps.get(i));
				Topic topic1=this.getTopicService().findTopicById(choiceMaps.get(i).getTopicId());
				topic.setApplyNum(topic1.getApplyNum()-1);
			}
		}
		teacher.setGuidanceNum(teacher.getGuidanceNum()+1);
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
		
		this.getTeacherService().update(teacher);
		message="选择成功";
		return SUCCESS;
	}
}
