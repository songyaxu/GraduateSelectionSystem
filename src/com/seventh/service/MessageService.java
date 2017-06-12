package com.seventh.service;

import java.util.List;

import com.seventh.entity.Message;
import com.seventh.entity.Page;

public interface MessageService {
	public void add(Message message);
	public Message findMessageById(int id);
	public int messageCounts(String column,String value);
	public int receiveMeesageCounts(String id,String type);
	public List<Message> searchMessageBySendId(String id,String type,final Page page);
	public List<Message> searchMessageByReceiveId(String id,String type,final Page page);
}
