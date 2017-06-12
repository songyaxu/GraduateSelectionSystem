package com.seventh.action.clazz;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Class;
import com.seventh.entity.Major;
import com.seventh.service.ClassService;
import com.seventh.service.MajorService;
import com.seventh.service.StudentService;
@SuppressWarnings("serial")
public class ClassInfoAction extends ActionSupport{
	private int id;
	private int majorId;
	private Class clazz;
	private Major major;
	private ClassService classService;
	private MajorService majorService;
	private StudentService studentService;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public String edit(){
		clazz=this.getClassService().findClassById(id);
		major=this.getMajorService().findMajorById(clazz.getMajorId());
		List<Major> majors=this.getMajorService().findAllMajor();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("majors", majors);
		return "edit";
	}
	public String update(){
		this.getClassService().update(clazz);
		message="修改成功";
		major=this.getMajorService().findMajorById(clazz.getMajorId());
		return "update";
	}
	public String delete() throws UnsupportedEncodingException{
		clazz=this.getClassService().findClassById(id);
		
		String hql="select count(*) from Student s where s.classId="+id;
		int rows=this.studentService.studentCounts(hql);
		System.out.println(rows);
		if(rows>0){
			majorId=clazz.getMajorId();
			message="不能删除已被使用的班级信息";
			message=URLEncoder.encode(message, "UTF-8"); 
			return ERROR;
		}
		else
		{
			this.getClassService().delete(clazz);
			message="删除成功";
			message=URLEncoder.encode(message, "UTF-8"); 
			return "delete";
		}
	}
}
