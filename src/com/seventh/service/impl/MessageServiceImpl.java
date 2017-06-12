package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.MessageDAO;
import com.seventh.entity.Message;
import com.seventh.entity.Page;
import com.seventh.service.MessageService;

public class MessageServiceImpl implements MessageService{
	private MessageDAO messageDao;
	
	public MessageDAO getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDAO messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void add(Message message) {
		this.messageDao.add(message);
	}

	@Override
	public Message findMessageById(int id) {
		return this.messageDao.findMessageById(id);
	}

	@Override
	public int messageCounts(String column, String value) {
		return this.messageDao.messageCounts(column,value);
	}

	@Override
	public int receiveMeesageCounts(String id, String type) {
		return this.messageDao.receiveMeesageCounts(id, type);
	}

	@Override
	public List<Message> searchMessageBySendId(String id, String type,final Page page) {
		return this.messageDao.searchMessageBySendId(id, type,page);
	}

	@Override
	public List<Message> searchMessageByReceiveId(String id, String type,final Page page) {
		return this.messageDao.searchMessageByReceiveId(id, type,page);
	}
	
}
