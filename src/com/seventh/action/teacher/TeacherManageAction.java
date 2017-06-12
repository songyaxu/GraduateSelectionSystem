package com.seventh.action.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Field;
import com.seventh.entity.Page;
import com.seventh.entity.Position;
import com.seventh.entity.Teacher;
import com.seventh.service.FieldService;
import com.seventh.service.PositionService;
import com.seventh.service.TeacherService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class TeacherManageAction extends ActionSupport{
	private TeacherService teacherService;
	private PositionService positionService;
	private FieldService fieldService;
	private Page page;
	private Position position;
	private Field field;
	private String message;
	private int currentPage;
	private final int everyPage=10;
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
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		List<Position> positions=this.getPositionService().findAllPosition();
		List<Field> fields=this.fieldService.findAllField();
		session.setAttribute("fields", fields);
		session.setAttribute("positions", positions);
		String hql="select count(id) from Teacher";
		int totalCounts=this.getTeacherService().teacherCounts(hql);
		page=PageUtil.createPage(everyPage, totalCounts, 0);
		List<Teacher> teachers=this.getTeacherService().findAllTeacher(page);
		request.setAttribute("page", page);
		request.setAttribute("teachers", teachers);
		return SUCCESS;
	}
	public String nextPage(){
		String hql="select count(id) from Teacher";
		int totalCounts=this.getTeacherService().teacherCounts(hql);
		page=PageUtil.createPage(everyPage, totalCounts, currentPage+1);
		List<Teacher> teachers=this.getTeacherService().findAllTeacher(page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		request.setAttribute("teachers", teachers);
		return "nextpage";
	}
	public String frontPage(){
		String hql="select count(id) from Teacher";
		int totalCounts=this.getTeacherService().teacherCounts(hql);
		page=PageUtil.createPage(everyPage, totalCounts, currentPage-1);
		List<Teacher> teachers=this.getTeacherService().findAllTeacher(page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		request.setAttribute("teachers", teachers);
		return "frontpage";
	}
}
