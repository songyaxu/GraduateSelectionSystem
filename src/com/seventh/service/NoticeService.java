package com.seventh.service;

import java.util.List;

import com.seventh.entity.Notice;
import com.seventh.entity.Page;

public interface NoticeService {
	public List<Notice> queryByPage(final Page page);
	public int noticeCounts(String columnName,String keyword);
	public Notice detailNotice(int id);
	public List<Notice> searchByName(final Page page,String keyword);
	public void save(Notice notice);
}
