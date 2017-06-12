package com.seventh.action.major;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Major;
import com.seventh.entity.Class;
import com.seventh.service.ClassService;
import com.seventh.service.MajorService;

@SuppressWarnings("serial")
public class MajorInfoAction extends ActionSupport{
	private int id;
	private MajorService majorService;
	private ClassService classService;
	private Major major;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
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
	public String execute(){
		major=this.majorService.findMajorById(id);
		return SUCCESS;
	}
	public String deleteMajor(){
		List<Class> clazzs=(List<Class>)this.getClassService().findClassByMajorId(major.getId());
		if(clazzs.size()==0)
		{	
			this.majorService.findMajorById(major.getId());
			this.majorService.delete(major);
			message="删除成功";
			return "deleted";
		}
		else
		{
			message="无法删除已使用的专业";
			return ERROR;
		}
		
	}
	public String edit(){
		major=this.majorService.findMajorById(id);
		return "edit";
	}
	public String update(){
		this.majorService.update(major);
		message="修改成功";
		return "update";
	}
}
