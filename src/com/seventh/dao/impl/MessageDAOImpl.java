package com.seventh.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.seventh.dao.MessageDAO;
import com.seventh.entity.Message;
import com.seventh.entity.Page;

public class MessageDAOImpl extends HibernateDaoSupport implements MessageDAO{

	@Override
	public void add(Message message) {
		this.getHibernateTemplate().save(message);
	}

	@Override
	public Message findMessageById(int id) {
		return this.getHibernateTemplate().get(Message.class, id);
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Message> searchMessageByReceiveId(String id,String type,final Page page) {
		final String  hql="from Message message where message.receiveId='"+id+"' or message.receiveId='"+type+"' or message.receiveId='all' order by message.createTime desc";
		return (List<Message>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery(hql);  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}
	
	@Override
	public int messageCounts(String column, String value) {
		
		String hql="select count(id) from Message message where message."+column+"='"+value+"'";
		
		return ((Long)this.getHibernateTemplate().find(hql).get(0)).intValue();
	}
	public int receiveMeesageCounts(String id,String type)
	{
		String hql="select count(*) from Message message where message.receiveId='"+id+"' or message.receiveId='"+type+"' or message.receiveId='all'";
		System.out.println(hql);
		return ((Long)this.getHibernateTemplate().find(hql).get(0)).intValue();
	}

	public List<Message> searchMessageBySendId(String id,String type,final Page page) {
//		String hql="from Message message where message.receiveId='"+"'";
		return null;
	}
}
