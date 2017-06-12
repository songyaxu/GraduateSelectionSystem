package com.seventh.service;

import java.util.List;

import com.seventh.entity.Page;
import com.seventh.entity.Topic;

public interface TopicService {
	public int topicTotalNumByHql(String hql);
	public List<Topic> SearchTopicByhql(final String hql,final Page page);
	public Topic findTopicById(int id);
	public List<Topic> checkTopicByStudentId(String id);
	public List<Topic> checkTopicByTeacherId(String id);
	public void save(Topic topic);
	public void delete(Topic topic);
	public void update(Topic topic);
}
