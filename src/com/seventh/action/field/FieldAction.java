package com.seventh.action.field;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Field;
import com.seventh.service.FieldService;

@SuppressWarnings("serial")
public class FieldAction extends ActionSupport{
	private FieldService fieldService;
	private String message;
	public FieldService getFieldService() {
		return fieldService;
	}

	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute(){
		List<Field> fields=this.getFieldService().findAllField();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("fields", fields);
		return SUCCESS;
	}
	public String addinit(){
		return "init";
	}
}
