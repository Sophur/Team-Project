package com.dao;	
	
import java.util.ArrayList;	
import java.util.List;	
	
import org.apache.commons.lang.StringUtils;	
	
import com.common.HibernateGenericDao;	
import com.common.PageBean;	
import com.vo.Ling;	
	
public class LingDAOImpl extends HibernateGenericDao<Ling> implements	
		LingDAO {	
	
	public void save(Ling ling) {	
		super.save(ling);	
	}	
	
	public void update(Ling ling) {	
		super.update(ling);	
	}	
	
	public void delete(Ling ling) {	
		super.remove(ling);	
	}	
	
	public Ling getLing(Ling ling) {	
		return get(ling.getId());	
	}	
	
	public Ling getLing(Long id) {	
		return get(id);	
	}	
	
	public List<Ling> getAllLing() {	
	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM ling WHERE 1=1 ");	
		sql = getStringBuffer(new Ling(), sql, args);	
		return getPageInfo(null, sql.toString()+" order by addate desc", args);		
	}	
	
	public List<Ling> findPageInfoLing(Ling ling, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM ling WHERE 1=1 ");	
		sql = getStringBuffer(ling, sql, args);	
		return getPageInfo(pageBean, sql.toString()+" order by addate desc", args);	
	}	
	
	public List<Ling> findPageInfoLing1(Ling ling, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM ling WHERE  NAME<>'admin' ");	
		sql = getStringBuffer(ling, sql, args);	
		return getPageInfo(pageBean, sql.toString(), args);	
	}	
	
	public Integer getCount1(Ling ling) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM ling WHERE NAME<>'admin'  ");	
		sql = getStringBuffer(ling, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	public Integer getCount(Ling ling) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM ling WHERE 1=1 ");	
		sql = getStringBuffer(ling, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	/**	
	 * 构造查询条件	
	 * 	
	 * @param ling	
	 * @param buf3	
	 * @param args	
	 * @return	
	 * @author Alex 10/28/2011 create	
	 */	
	private StringBuffer getStringBuffer(Ling ling, StringBuffer buf,	
			List args) {	
		/*	
		 * 需要加入查询条件时封装	
		 */	
	
		if (StringUtils.isNotBlank(ling.getTitle())) {	
			buf.append(" and title like '%"+ling.getTitle().trim()+"%' ");	
				
		}	
		
		if (StringUtils.isNotBlank(ling.getStyle())) {	
			buf.append(" and style like '%"+ling.getStyle().trim()+"%' ");	
			 
		}	
	
		return buf;	
	}	
}	
