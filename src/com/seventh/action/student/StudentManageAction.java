package com.seventh.action.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.seventh.entity.Class;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Major;
import com.seventh.entity.Page;
import com.seventh.entity.Student;
import com.seventh.service.ClassService;
import com.seventh.service.MajorService;
import com.seventh.service.StudentService;
import com.seventh.util.PageUtil;

@SuppressWarnings("serial")
public class StudentManageAction extends ActionSupport{
	private int id;
	private Page page;
	private Class clazz;
	private Major major;
	private int currentPage;
	private MajorService majorService;
	private ClassService classService;
	private StudentService studentService;
	private final int everyPage=10;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
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
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String execute(){
		String hql="select count(*) from Student s where s.classId="+id;
		clazz=this.getClassService().findClassById(id);
		major=this.getMajorService().findMajorById(clazz.getMajorId());
		int totalCount=this.studentService.studentCounts(hql);
		page=PageUtil.createPage(everyPage, totalCount, 0);
		List<Student> students=this.studentService.findStudentByClassId(id, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		request.setAttribute("students", students);
		return SUCCESS;
	}
	public String frontPage(){
		String hql="select count(*) from Student s where s.classId="+id;
		clazz=this.getClassService().findClassById(id);
		major=this.getMajorService().findMajorById(clazz.getMajorId());
		int totalCount=this.studentService.studentCounts(hql);
		page=PageUtil.createPage(everyPage, totalCount, currentPage-1);
		List<Student> students=this.studentService.findStudentByClassId(id, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		request.setAttribute("students", students);
		return "frontpage";
	}
	public String nextPage(){
		String hql="select count(*) from Student s where s.classId="+id;
		clazz=this.getClassService().findClassById(id);
		major=this.getMajorService().findMajorById(clazz.getMajorId());
		int totalCount=this.studentService.studentCounts(hql);
		page=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Student> students=this.studentService.findStudentByClassId(id, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		request.setAttribute("students", students);
		return "nextpage";
	}
}
