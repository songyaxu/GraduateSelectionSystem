package com.seventh.action.clazz;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.service.ClassService;
import com.seventh.entity.Class;
@SuppressWarnings("serial")
public class AddClassAction extends ActionSupport{
	private ClassService classService;
	private Class clazz;
	private String message;
	private int majorId;
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String execute() throws UnsupportedEncodingException{
		if(clazz.getMajorId()!=-1)
		{
			majorId=clazz.getMajorId();
			this.getClassService().save(clazz);
			message="添加成功";
			message=URLEncoder.encode(message, "UTF-8"); 
			return SUCCESS;
		}
		else
		{
			message="请选择专业";
			return ERROR;
		}
	}
}
