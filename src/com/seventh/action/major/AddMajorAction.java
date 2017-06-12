package com.seventh.action.major;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Major;
import com.seventh.service.MajorService;

@SuppressWarnings("serial")
public class AddMajorAction extends ActionSupport{
	private MajorService majorService;
	private String message;
	private Major major;
	public MajorService getMajorService() {
		return majorService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public String execute(){
		this.majorService.save(major);
		return SUCCESS;
	}
}
