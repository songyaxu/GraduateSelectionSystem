package com.seventh.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.seventh.dao.NoticeDAO;
import com.seventh.entity.Notice;
import com.seventh.entity.Page;

public class NoticeDAOImpl extends HibernateDaoSupport implements NoticeDAO{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Notice> queryByPage(final Page page){
		return (List<Notice>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery("from Notice n order by n.createTime desc");  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Notice> searchByName(final Page page,final String keyword){
		return (List<Notice>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
            	String hql="from Notice notice where notice.title like '%"+keyword+"%' order by notice.createTime desc";
            	Query query = session.createQuery(hql);  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        });
	};
	public int noticeCounts(String columnName,String keyword){
		int rowTotal=0;
		if(columnName.equals("0"))
			rowTotal = ((Long)this.getHibernateTemplate().find("select count(id) from Notice").get(0)).intValue(); 
		else
		{
			System.out.println("¹Ø¼ü×Ö"+keyword);
			rowTotal = ((Long)this.getHibernateTemplate().find("select count(*) from Notice notice where notice."+columnName+" like '%"+keyword+"%'").get(0)).intValue();
		}
		return rowTotal;
	}
	public Notice detailNotice(int id){
		return (Notice)this.getHibernateTemplate().get(Notice.class, id);
	}
	@Override
	public void save(Notice notice) {
		this.getHibernateTemplate().save(notice);
	}
	
}
