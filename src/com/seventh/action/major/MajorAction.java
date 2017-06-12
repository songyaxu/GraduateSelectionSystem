package com.seventh.action.major;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Major;
import com.seventh.service.MajorService;

@SuppressWarnings("serial")
public class MajorAction extends ActionSupport{
	private MajorService majorService;
	private Major major;
	private String message;
	
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public String checkMajor(){
		List<Major> majors=this.getMajorService().findAllMajor();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("majors", majors);
		return "check";
	}
	public String addinit(){
		return "add";
	}
}
