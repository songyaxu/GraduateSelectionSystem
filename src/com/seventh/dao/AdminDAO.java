package com.seventh.dao;

import com.seventh.entity.Admin;

public interface AdminDAO {
	public Admin findAdminById(String id);
	public void update(Admin admin);
	public void delete(Admin admin);
	public void save(Admin admin);
}
