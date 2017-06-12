package com.seventh.action.topic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Admin;
import com.seventh.entity.Field;
import com.seventh.entity.Message;
import com.seventh.entity.Page;
import com.seventh.entity.Student;
import com.seventh.entity.Teacher;
import com.seventh.entity.Topic;
import com.seventh.service.FieldService;
import com.seventh.service.MessageService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.service.TopicService;
import com.seventh.util.PageUtil;
import com.seventh.util.TimeUtil;

@SuppressWarnings("serial")
public class TopicManageAction extends ActionSupport{
	private TopicService topicService;
	private FieldService fieldService;
	private MessageService messageService;
	private StudentService studentService;
	private TeacherService teacherService;
	private Message message;
	private Topic topic;
	private Admin admin;
	private Page page;
	private int id; 
	private String pageMessage;
	private final int everyPage=10;
	private int currentPage;
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
	public int getEveryPage() {
		return everyPage;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getPageMessage() {
		return pageMessage;
	}
	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String execute(){
		String hql="from Topic t order by t.isCheck asc";
		String hql2="select count(id) from Topic";
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
		String hql="from Topic t order by t.isCheck asc";
		String hql2="select count(id) from Topic";
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, currentPage-1);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return SUCCESS;
	}
	public String nextPage(){
		String hql="from Topic t order by t.isCheck asc";
		String hql2="select count(id) from Topic";
		int rows=this.getTopicService().topicTotalNumByHql(hql2);
		page=PageUtil.createPage(everyPage, rows, currentPage+1);
		List<Topic> topics=this.getTopicService().SearchTopicByhql(hql, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("topics", topics);
		List<Field> fields=this.getFieldService().findAllField();
		request.setAttribute("fields", fields);
		return SUCCESS;
	}
	public String Pass(){
		topic=this.getTopicService().findTopicById(id);
		topic.setIsCheck(3);
		this.getTopicService().update(topic);
		pageMessage="审核成功";
		return "pass";
	}
	public String NotPass(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		admin=(Admin)session.getAttribute("admin");
		topic=this.getTopicService().findTopicById(id);
		return "notpass";
	}
	public String sendreason(){
		this.message.setCreateTime(TimeUtil.currentTime());
		topic=this.getTopicService().findTopicById(id);
		topic.setIsCheck(1);
		if(topic.getIsStuApply()==0)
		{
			Teacher teacher=this.getTeacherService().findTeacherById(topic.getTeacherId());
			message.setReceiveId(teacher.getId());
			message.setReceiveName(teacher.getName());
		}
		else
		{
			Student student=this.getStudentService().findStudentById(topic.getStudentId());
			message.setReceiveId(student.getId());
			message.setReceiveName(student.getName());
		}
		message.setContent("关于题目《"+topic.getTitle()+"》未通过的原因:"+message.getContent());
		message.setAction("选题通知");
		this.getMessageService().add(message);
		this.getTopicService().update(topic);
		pageMessage="审核并发送成功";
		return "send";
	}
}
