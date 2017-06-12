package com.seventh.dao;

import java.util.List;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;

public interface NoticeDAO {
	public List<Notice> queryByPage(final Page page);
	public int noticeCounts(String columnName,String keyword);
	public Notice detailNotice(int id);
	public List<Notice> searchByName(final Page page,String keyword);
	public void save(Notice notice);
}
