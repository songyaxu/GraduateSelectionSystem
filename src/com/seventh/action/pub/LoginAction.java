package com.seventh.action.pub;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Admin;
import com.seventh.entity.Config;
import com.seventh.entity.Field;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;
import com.seventh.entity.Position;
import com.seventh.entity.Student;
import com.seventh.entity.Teacher;
import com.seventh.service.AdminService;
import com.seventh.service.ConfigService;
import com.seventh.service.FieldService;
import com.seventh.service.NoticeService;
import com.seventh.service.PositionService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;
import com.seventh.util.MD5Util;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	private String id;
	private String password;
	private String message;
	private Page loginNoticePage;
	private AdminService adminService;
	private TeacherService teacherService;
	private StudentService studentService;
	private NoticeService noticeService;
	private FieldService fieldService;
	private PositionService positionService;
	private ConfigService configService;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Page getLoginNoticePage() {
		return loginNoticePage;
	}
	public void setLoginNoticePage(Page loginNoticePage) {
		this.loginNoticePage = loginNoticePage;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	public FieldService getFieldService() {
		return fieldService;
	}
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}
	public PositionService getPositionService() {
		return positionService;
	}
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	public ConfigService getConfigService() {
		return configService;
	}
	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("logintype");
		session.removeAttribute("student");
		session.removeAttribute("teacher");
		session.removeAttribute("admin");
		Config config=this.getConfigService().init();
		Student studentLogin = studentService.findStudentById(getId());
		if (studentLogin != null) {
			if(studentLogin.getPassword().equals(MD5Util.md5(getPassword())))
			{	
				int totalCount=this.noticeService.noticeCounts("0","0");
				loginNoticePage=PageUtil.createPage(10, totalCount, 0);
				List<Notice> notices=this.noticeService.queryByPage(loginNoticePage);
				session.setAttribute("loginIndexnotices", notices);
				session.setAttribute("loginNoticePage", loginNoticePage);
				session.setAttribute("student", studentLogin);
				session.setAttribute("logintype", "student");
				session.setAttribute("config", config);
				message="登录成功！";
				return "stuLogin";
			}
			else
			{	
				message="密码不正确，请认真核实。";
				return INPUT;
			}
		}
		else
		{	
			Teacher teacherLogin = teacherService.findTeacherById(id); 
			if (teacherLogin != null) {
				if(teacherLogin.getPassword().equals(MD5Util.md5(getPassword())))
				{
					int totalCount=this.noticeService.noticeCounts("0","0");
					loginNoticePage=PageUtil.createPage(10, totalCount, 0);
					List<Notice> notices=this.noticeService.queryByPage(loginNoticePage);
					Position position=this.getPositionService().findPositionById(teacherLogin.getPositionId());
					Field field=this.getFieldService().findFieldById(teacherLogin.getFieldId());
					session.setAttribute("loginIndexnotices", notices);
					session.setAttribute("loginNoticePage", loginNoticePage);
					session.setAttribute("teacher", teacherLogin);
					session.setAttribute("logintype", "teacher");
					session.setAttribute("config", config);
					session.setAttribute("position", position);
					session.setAttribute("field", field);
					message="登录成功！";
					return "teaLogin";
				}
				else
				{
					message="密码不正确，请认真核实。";
					return INPUT;
				}
			}
			else
			{
				Admin adminLogin = adminService.findAdminById(id);
				if(adminLogin!=null)
				{	
					if(adminLogin.getPassword().equals(MD5Util.md5(getPassword())))
					{
						int totalCount=this.noticeService.noticeCounts("0","0");
						loginNoticePage=PageUtil.createPage(10, totalCount, 0);
						List<Notice> notices=this.noticeService.queryByPage(loginNoticePage);
						session.setAttribute("loginIndexnotices", notices);
						session.setAttribute("loginNoticePage", loginNoticePage);
						session.setAttribute("admin", adminLogin);
						session.setAttribute("logintype", "admin");
						session.setAttribute("config", config);
						message="登录成功！";
						return "adminLogin";
					}
					else
					{
						message="密码不正确，请认真核实。";
						return INPUT;
					}
				}
				else{
					message="没有此账号，请认真核实。";
					return INPUT;
				}
			}
		}
	}
}
