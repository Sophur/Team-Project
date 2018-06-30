package com.dao;	
	
import java.util.ArrayList;	
import java.util.List;	
	
import org.apache.commons.lang.StringUtils;	
	
import com.common.HibernateGenericDao;	
import com.common.PageBean;	
import com.vo.Ping;	
	
public class PingDAOImpl extends HibernateGenericDao<Ping> implements	
		PingDAO {	
	
	public void save(Ping ping) {	
		super.save(ping);	
	}	
	
	public void update(Ping ping) {	
		super.update(ping);	
	}	
	
	public void delete(Ping ping) {	
		super.remove(ping);	
	}	
	
	public Ping getPing(Ping ping) {	
		return get(ping.getId());	
	}	
	
	public Ping getPing(Long id) {	
		return get(id);	
	}	
	
	public List<Ping> getAllPing() {	
	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM ping WHERE 1=1 ");	
		sql = getStringBuffer(new Ping(), sql, args);	
		return getPageInfo(null, sql.toString()+" order by adddate desc", args);		
	}	
	
	public List<Ping> findPageInfoPing(Ping ping, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM ping WHERE 1=1 ");	
		sql = getStringBuffer(ping, sql, args);	
		return getPageInfo(pageBean, sql.toString()+" order by adddate desc", args);	
	}	
	
	public List<Ping> findPageInfoPing1(Ping ping, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM ping WHERE  NAME<>'admin' ");	
		sql = getStringBuffer(ping, sql, args);	
		return getPageInfo(pageBean, sql.toString(), args);	
	}	
	
	public Integer getCount1(Ping ping) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM ping WHERE NAME<>'admin'  ");	
		sql = getStringBuffer(ping, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	public Integer getCount(Ping ping) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM ping WHERE 1=1 ");	
		sql = getStringBuffer(ping, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	/**	
	 * 构造查询条件	
	 * 	
	 * @param ping	
	 * @param buf3	
	 * @param args	
	 * @return	
	 * @author Alex 10/28/2011 create	
	 */	
	private StringBuffer getStringBuffer(Ping ping, StringBuffer buf,	
			List args) {	
		/*	
		 * 需要加入查询条件时封装	
		 */	
	
		if (StringUtils.isNotBlank(ping.getName())) {	
			buf.append(" and name = ? ");	
			args.add(ping.getName().trim());	
		}	
		if (StringUtils.isNotBlank(ping.getType())) {	
			buf.append(" and type = ? ");	
			args.add(ping.getType().trim());	
		}	
		if (ping.getInid()!=null && ping.getInid()>0) {	
			buf.append(" and inid = ? ");	
			args.add(ping.getInid());	
		}
	
		return buf;	
	}	
}	
