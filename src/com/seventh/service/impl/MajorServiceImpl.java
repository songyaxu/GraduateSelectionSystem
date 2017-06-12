package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.MajorDAO;
import com.seventh.entity.Major;
import com.seventh.service.MajorService;

public class MajorServiceImpl implements MajorService{
	private MajorDAO majorDao;
	public MajorDAO getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(MajorDAO majorDao) {
		this.majorDao = majorDao;
	}

	@Override
	public Major findMajorById(int id) {
		return this.getMajorDao().findMajorById(id);
	}

	@Override
	public List<Major> findAllMajor() {
		return this.getMajorDao().findAllMajor();
	}

	@Override
	public void update(Major major) {
		this.getMajorDao().update(major);
	}

	@Override
	public void delete(Major major) {
		this.getMajorDao().delete(major);
	}

	@Override
	public void save(Major major) {
		this.getMajorDao().save(major);
	}
	
}
