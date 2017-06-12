package com.seventh.action.field;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Field;
import com.seventh.service.FieldService;

@SuppressWarnings("serial")
public class AddFieldAction extends ActionSupport{
	private FieldService fieldService;
	private Field field;
	private String message;
	public FieldService getFieldService() {
		return fieldService;
	}
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
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
		this.fieldService.save(field);
		message="Ìí¼Ó³É¹¦";
		return SUCCESS;
	}
}
