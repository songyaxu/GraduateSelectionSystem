package com.seventh.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.seventh.entity.Admin;
import com.seventh.service.AdminService;
import com.seventh.util.MD5Util;


@SuppressWarnings("serial")
public class AdminInfoAction extends ActionSupport{
	private Admin admin;
	private String message;
	private AdminService adminService;
	private String oldPassword;
	private String newPassword1;
	private String newPassword2;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Admin admin1=(Admin)session.getAttribute("admin");
		admin=this.adminService.findAdminById(admin1.getId());
		return SUCCESS;
	}
	public String update(){
		this.adminService.update(admin);
		message="修改成功";
		return "update";
	}
	public String modify(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Admin adminLogin=(Admin)session.getAttribute("admin");
		admin=this.adminService.findAdminById(adminLogin.getId());
		message="";
		return "modify";
	}
	public String modifyPW(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Admin adminLogin=(Admin)session.getAttribute("admin");
		Admin oldpwadmin=this.adminService.findAdminById(adminLogin.getId());
		if(MD5Util.md5(oldPassword).equals(oldpwadmin.getPassword()))
		{
			if(newPassword1.equals(newPassword2))
			{
				oldpwadmin.setPassword(MD5Util.md5(newPassword1));
				this.adminService.update(oldpwadmin);
				message="修改成功";
				return "modified";
			}
			else
			{
				message="两次密码输入不一致";
				return ERROR;
			}
		}
		else
		{
			message="原密码错误！";
			return ERROR;
		}
	}
}
