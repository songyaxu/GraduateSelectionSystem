package com.seventh.service.impl;

import com.seventh.dao.AdminDAO;
import com.seventh.entity.Admin;
import com.seventh.service.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDao;
	public AdminDAO getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public Admin findAdminById(String id) {
		return this.adminDao.findAdminById(id);
	}
	@Override
	public void update(Admin admin) {
		this.getAdminDao().update(admin);
	}
	@Override
	public void delete(Admin admin) {
		this.getAdminDao().delete(admin);
	}
	@Override
	public void save(Admin admin) {
		this.getAdminDao().save(admin);
	}
	
}
