package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.NoticeDAO;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;
import com.seventh.service.NoticeService;

public class NoticeServiceImpl implements NoticeService{
	private NoticeDAO noticeDao;

	public NoticeDAO getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDAO noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public List<Notice> queryByPage(Page page) {
		return noticeDao.queryByPage(page);
	}
	public int noticeCounts(String columnName,String keyword){
		return noticeDao.noticeCounts(columnName,keyword);
	}
	public Notice detailNotice(int id){
		return noticeDao.detailNotice(id);
	}
	public List<Notice> searchByName(Page page,String keyword){
		return noticeDao.searchByName(page,keyword);
	}

	@Override
	public void save(Notice notice) {
		this.noticeDao.save(notice);
	}
	
}
