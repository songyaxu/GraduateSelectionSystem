package com.seventh.action.choicemap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.ChoiceMap;
import com.seventh.entity.Config;
import com.seventh.entity.Student;
import com.seventh.entity.Topic;
import com.seventh.service.ChoiceMapService;
import com.seventh.service.StudentService;
import com.seventh.service.TopicService;
import com.seventh.util.TimeUtil;

@SuppressWarnings("serial")
public class StuChoiceTopic extends ActionSupport{
	private StudentService studentService;
	private ChoiceMapService choiceMapService;
	private TopicService topicService;
	private String message;
	private int id;
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
	
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Topic topic=this.getTopicService().findTopicById(id);
		Student student=(Student)session.getAttribute("student");
		Config config=(Config)session.getAttribute("config");
		List<ChoiceMap> choiceMaps=this.getChoiceMapService().findByStudentId(student.getId());
		for(int i=0;i<choiceMaps.size();i++)
		{
			if(choiceMaps.get(i).getTopicId()==id)
			{
				message="不能选择已选择的题目";
				return ERROR;
			}
		}
		if(student.getIsMatched()==1)
		{
			message="你已成功选题";
			return ERROR;
		}
		if(student.getChoiceNum()+1>config.getStuMaxChoiceNum())
		{
			message="你的选题数已达到上限";
			return ERROR;
		}
		if(topic.getIsEnable()==0)
		{
			ChoiceMap choiceMap=new ChoiceMap();
			choiceMap.setCreateTime(TimeUtil.currentTime());
			choiceMap.setStudentId(student.getId());
			choiceMap.setStudentName(student.getName());
			choiceMap.setTopicId(topic.getId());
			choiceMap.setTopicTitle(topic.getTitle());
			this.getChoiceMapService().save(choiceMap);
			topic.setApplyNum(topic.getApplyNum()+1);
			if(topic.getApplyNum()==config.getTopicChoiceLimit())
				topic.setIsEnable(1);
			this.getTopicService().update(topic);
			student.setChoiceNum(student.getChoiceNum()+1);
			this.getStudentService().updateStudent(student);
			return SUCCESS;
		}
		else{
			message="题目不可选";
			return ERROR;
		}
	}
}
