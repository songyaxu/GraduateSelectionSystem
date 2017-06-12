package com.seventh.action.pub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Class;
import com.seventh.entity.*;
import com.seventh.service.AdminService;
import com.seventh.service.ClassService;
import com.seventh.service.FieldService;
import com.seventh.service.MajorService;
import com.seventh.service.PositionService;
import com.seventh.service.StudentService;
import com.seventh.service.TeacherService;

@SuppressWarnings("serial")
public class UserInfoAction extends ActionSupport{
	private String id;
	private String userType;
	private String loginType;
	private Student student;
	private Admin admin;
	private String message;
	private Teacher teacher;
	private Major major;
	private Class clazz;
	private Position position;
	private Field field;
	private StudentService studentService;
	private TeacherService teacherService;
	private AdminService adminService;
	private FieldService fieldService;
	private PositionService positionService;
	private ClassService classService;
	private MajorService majorService;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
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
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		loginType=(String)session.getAttribute("logintype");
		if(loginType.equals("admin"))
			loginType="administrator";
		if(userType.equals("student"))
		{
			this.student=this.studentService.findStudentById(id);
			clazz=this.getClassService().findClassById(student.getClassId());
			major=this.getMajorService().findMajorById(clazz.getMajorId());
			return "stu";
		}
		if(userType.equals("teacher"))
		{
			this.teacher=this.teacherService.findTeacherById(id);
			position=this.getPositionService().findPositionById(teacher.getPositionId());
			field=this.getFieldService().findFieldById(teacher.getFieldId());
			return "tea";
		}
		if(userType.equals("admin")){
			this.admin=this.adminService.findAdminById(id);
			return "admin";
		}
		setMessage("无法查看相关信息");
		return ERROR;
	}
}
