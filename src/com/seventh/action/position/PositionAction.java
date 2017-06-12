package com.seventh.action.position;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Position;
import com.seventh.service.PositionService;
import com.seventh.service.TeacherService;

@SuppressWarnings("serial")
public class PositionAction extends ActionSupport{
	private TeacherService teacherService;
	private String message;
	private int id;
	private PositionService positionService;
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
	public PositionService getPositionService() {
		return positionService;
	}
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
	public String execute(){
		List<Position> positions=this.getPositionService().findAllPosition();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("positions", positions);
		return SUCCESS;
	}
	public String addinit(){
		return "init";
	}
}
