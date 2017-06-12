package com.seventh.dao;

import java.util.List;

import com.seventh.entity.Major;

public interface MajorDAO {
	public Major findMajorById(int id);
	public List<Major> findAllMajor();
	public void update(Major major);
	public void delete(Major major);
	public void save(Major major);
}
