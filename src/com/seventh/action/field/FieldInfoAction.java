package com.seventh.action.field;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Field;
import com.seventh.service.FieldService;
import com.seventh.service.TeacherService;

@SuppressWarnings("serial")
public class FieldInfoAction extends ActionSupport{
	private FieldService fieldService;
	private TeacherService teacherService;
	private Field field;
	private String message;
	private int id;
	public FieldService getFieldService() {
		return fieldService;
	}
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}
	
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		field=this.fieldService.findFieldById(id);
		return SUCCESS;
	}
	public String delete() throws UnsupportedEncodingException{
		field=this.getFieldService().findFieldById(id);
		String hql="select count(*) from Teacher t where t.fieldId="+id;
		int rows=this.getTeacherService().teacherCounts(hql);
		if(rows>0){
			message="不能删除已被使用的领域";
			message=URLEncoder.encode(message, "UTF-8"); 
			return ERROR;
		}
		else{
			field=this.fieldService.findFieldById(id);
			this.getFieldService().delete(field);
			message="删除成功";
			message=URLEncoder.encode(message, "UTF-8"); 
			return "delete";
		}
	}
	public String update() throws UnsupportedEncodingException{
		this.fieldService.update(field);
		message="修改成功";
		message=URLEncoder.encode(message, "UTF-8"); 
		return "update";
	}
}
