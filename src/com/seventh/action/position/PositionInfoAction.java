package com.seventh.action.position;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Position;
import com.seventh.service.PositionService;
import com.seventh.service.TeacherService;

@SuppressWarnings("serial")
public class PositionInfoAction extends ActionSupport{
	private int id;
	private Position position;
	private PositionService positionService;
	private TeacherService teacherService;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public PositionService getPositionService() {
		return positionService;
	}
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
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
	public String execute(){
		position=this.positionService.findPositionById(id);
		return SUCCESS;
	}
	public String delete() throws UnsupportedEncodingException{
		String hql="select count(*) from Teacher t where t.positionId="+id;
		int rows=this.getTeacherService().teacherCounts(hql);
		if(rows>0)
		{
			message="不能删除已使用的职称信息";
			message=URLEncoder.encode(message, "UTF-8"); 
			return ERROR;
		}
		else
		{	
			position=this.getPositionService().findPositionById(id);
			this.getPositionService().delete(position);
			message="删除成功";
			message=URLEncoder.encode(message, "UTF-8"); 
			return "delete";
		}
		
	}
	public String update() throws UnsupportedEncodingException{
		this.getPositionService().update(position);
		message="修改成功";
		message=URLEncoder.encode(message, "UTF-8"); 
		return "update";
	}
}
