package com.dao;	
	
import java.util.ArrayList;	
import java.util.List;	
	
import org.apache.commons.lang.StringUtils;	
	
import com.common.HibernateGenericDao;	
import com.common.PageBean;	
import com.vo.Message;	
	
public class MessageDAOImpl extends HibernateGenericDao<Message> implements	
		MessageDAO {	
	
	public void save(Message message) {	
		super.save(message);	
	}	
	
	public void update(Message message) {	
		super.update(message);	
	}	
	
	public void delete(Message message) {	
		super.remove(message);	
	}	
	
	public Message getMessage(Message message) {	
		return get(message.getId());	
	}	
	
	public Message getMessage(Long id) {	
		return get(id);	
	}	
	
	public List<Message> getAllMessage() {	
	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM message WHERE 1=1 ");	
		sql = getStringBuffer(new Message(), sql, args);	
		return getPageInfo(null, sql.toString()+" order by date desc", args);
	}	
	
	public List<Message> findPageInfoMessage(Message message, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM message WHERE 1=1 ");	
		sql = getStringBuffer(message, sql, args);	
		return getPageInfo(pageBean, sql.toString()+" order by date desc", args);	
	}	
	
	public List<Message> findPageInfoMessage1(Message message, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM message WHERE  NAME<>'admin' ");	
		sql = getStringBuffer(message, sql, args);	
		return getPageInfo(pageBean, sql.toString(), args);	
	}	
	
	public Integer getCount1(Message message) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM message WHERE NAME<>'admin'  ");	
		sql = getStringBuffer(message, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	public Integer getCount(Message message) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM message WHERE 1=1 ");	
		sql = getStringBuffer(message, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	/**	
	 * 构造查询条件	
	 * 	
	 * @param message	
	 * @param buf3	
	 * @param args	
	 * @return	
	 * @author Alex 10/28/2011 create	
	 */	
	private StringBuffer getStringBuffer(Message message, StringBuffer buf,	
			List args) {	
		/*	
		 * 需要加入查询条件时封装	
		 */	
	
		if (StringUtils.isNotBlank(message.getAppuser())) {	
			buf.append(" and appuser = ? ");	
			args.add(message.getAppuser().trim());	
		}	
	
		return buf;	
	}	
}	
