package com.dao;	
	
import java.util.ArrayList;	
import java.util.List;	
	
import org.apache.commons.lang.StringUtils;	
	
import com.common.HibernateGenericDao;	
import com.common.PageBean;	
import com.vo.Userinfo;	
	
public class UserinfoDAOImpl extends HibernateGenericDao<Userinfo> implements	
		UserinfoDAO {	
	
	public void save(Userinfo userinfo) {	
		super.save(userinfo);	
	}	
	
	public void update(Userinfo userinfo) {	
		super.update(userinfo);	
	}	
	
	public void delete(Userinfo userinfo) {	
		super.remove(userinfo);	
	}	
	
	public Userinfo getUserinfo(Userinfo userinfo) {	
		return get(userinfo.getId());	
	}	
	
	public Userinfo getUserinfo(Long id) {	
		return get(id);	
	}	
	
	public List<Userinfo> getAllUserinfo() {	
	
		return getAll();	
	}	
	
	public List<Userinfo> findPageInfoUserinfo(Userinfo userinfo, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM userinfo WHERE 1=1 ");	
		sql = getStringBuffer(userinfo, sql, args);	
		return getPageInfo(pageBean, sql.toString(), args);	
	}	
	
	public List<Userinfo> findPageInfoUserinfo1(Userinfo userinfo, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM userinfo WHERE  NAME<>'admin' ");	
		sql = getStringBuffer(userinfo, sql, args);	
		return getPageInfo(pageBean, sql.toString(), args);	
	}	
	
	public Integer getCount1(Userinfo userinfo) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM userinfo WHERE NAME<>'admin'  ");	
		sql = getStringBuffer(userinfo, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	public Integer getCount(Userinfo userinfo) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM userinfo WHERE 1=1 ");	
		sql = getStringBuffer(userinfo, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	/**	
	 * 构造查询条件	
	 * 	
	 * @param userinfo	
	 * @param buf3	
	 * @param args	
	 * @return	
	 * @author Alex 10/28/2011 create	
	 */	
	private StringBuffer getStringBuffer(Userinfo userinfo, StringBuffer buf,	
			List args) {	
		/*	
		 * 需要加入查询条件时封装	
		 */	
	
		if (StringUtils.isNotBlank(userinfo.getName())) {	
			buf.append(" and name = ? ");	
			args.add(userinfo.getName().trim());	
		}	
		
		if (StringUtils.isNotBlank(userinfo.getPwd())) {
			buf.append(" and pwd = ? ");
			args.add(userinfo.getPwd().trim());
		}
	
		return buf;	
	}	
}	
