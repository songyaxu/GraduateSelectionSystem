package com.seventh.action.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Field;
import com.seventh.entity.Position;
import com.seventh.entity.Teacher;
import com.seventh.service.FieldService;
import com.seventh.service.PositionService;
import com.seventh.service.TeacherService;
import com.seventh.util.MD5Util;

@SuppressWarnings("serial")
public class AddTeacherAction extends ActionSupport{
	private String message;
	private TeacherService teacherService;
	private PositionService positionService;
	private FieldService fieldService;
	private Teacher teacher;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	public PositionService getPositionService() {
		return positionService;
	}
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	public FieldService getFieldService() {
		return fieldService;
	}
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String execute(){
		if(teacher.getFieldId()==-1)
		{
			message="请选择方向";
			return ERROR;
		}
		else if(teacher.getPositionId()==-1)
		{
			message="请选择职称";
			return ERROR;
		}
		else
		{
			this.teacher.setPassword(MD5Util.md5(teacher.getId()));
			this.teacher.setGuidanceNum(0);
			this.teacher.setQuestionNum(0);
			this.getTeacherService().save(teacher);
			message="添加成功";
			return SUCCESS;
		}
	}
	public String init(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		List<Position> positions=this.getPositionService().findAllPosition();
		List<Field> fields=this.fieldService.findAllField();
		session.setAttribute("fields", fields);
		session.setAttribute("positions", positions);
		return "init";
	}
}
