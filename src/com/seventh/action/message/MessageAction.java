package com.seventh.action.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Admin;
import com.seventh.entity.Message;
import com.seventh.entity.Student;
import com.seventh.entity.Teacher;
import com.seventh.service.AdminService;
import com.seventh.service.MessageService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.util.TimeUtil;

@SuppressWarnings("serial")
public class MessageAction extends ActionSupport{
	private String pageMessage;
	private Message message;
	private String type;
	private String loginType;
	private MessageService messageService;
	private TeacherService teacherService;
	private StudentService studentService;
	private AdminService adminService;
	public String getPageMessage() {
		return pageMessage;
	}
	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public String send(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		this.message.setCreateTime(TimeUtil.currentTime());
		if(this.message.getReceiveId()==null||this.message.getReceiveId().isEmpty())
			this.message.setReceiveId(type);
		else
		{
			Student studentLogin = studentService.findStudentById(message.getReceiveId());
			if(studentLogin!=null)
			{
				this.message.setReceiveName(studentLogin.getName());
				this.messageService.add(message);
				pageMessage="发送成功！";
				return "saved";
			}
			else
			{
				Teacher teacherLogin = teacherService.findTeacherById(this.message.getReceiveId()); 
				if(teacherLogin!=null)
				{
					this.message.setReceiveName(teacherLogin.getName());
					this.messageService.add(message);
					pageMessage="发送成功！";
					return "saved";
				}
				else
				{
					Admin adminLogin = adminService.findAdminById(message.getReceiveId());
					if(adminLogin!=null)
					{
						this.message.setReceiveName(adminLogin.getName());
						this.messageService.add(message);
						pageMessage="发送成功！";
						return "saved";
					}
					else
					{
						pageMessage="ID："+message.getReceiveId()+"不正确，请仔细验证！";
						return ERROR;
					}
				}
			}
		}
		if(message.getReceiveId().equals("student"))
			message.setReceiveName("学生");
		if(message.getReceiveId().equals("teacher"))
			message.setReceiveName("教师");
		if(message.getReceiveId().equals("admin"))
			message.setReceiveName("管理员");
		if(message.getReceiveId().equals("all"))
			message.setReceiveName("所有人");
		this.messageService.add(message);
		pageMessage="发送成功！";
		return "saved";
	}
	public String writeInit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		return "init";
	}
}
