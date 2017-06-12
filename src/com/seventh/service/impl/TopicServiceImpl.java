package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.TopicDAO;
import com.seventh.entity.Page;
import com.seventh.entity.Topic;
import com.seventh.service.TopicService;

public class TopicServiceImpl implements TopicService{
	private TopicDAO topicDao;
	
	public TopicDAO getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDAO topicDao) {
		this.topicDao = topicDao;
	}
	
	
	@Override
	public List<Topic> SearchTopicByhql(String hql, Page page) {
		return this.getTopicDao().SearchTopicByhql(hql, page);
	}

	@Override
	public int topicTotalNumByHql(String hql) {
		return this.getTopicDao().topicTotalNumByHql(hql);
	}

	@Override
	public void save(Topic topic) {
		this.getTopicDao().save(topic);
	}

	@Override
	public void delete(Topic topic) {
		this.getTopicDao().delete(topic);
	}

	@Override
	public void update(Topic topic) {
		this.getTopicDao().update(topic);
	}

	@Override
	public List<Topic> checkTopicByStudentId(String id) {
		return this.getTopicDao().checkTopicByStudentId(id);
	}

	@Override
	public List<Topic> checkTopicByTeacherId(String id) {
		return this.getTopicDao().checkTopicByTeacherId(id);
	}

	@Override
	public Topic findTopicById(int id) {
		return this.getTopicDao().findTopicById(id);
	}
	
}
