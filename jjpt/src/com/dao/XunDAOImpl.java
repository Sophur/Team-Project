package com.dao;	
	
import java.util.ArrayList;	
import java.util.List;	
	
import org.apache.commons.lang.StringUtils;	
	
import com.common.HibernateGenericDao;	
import com.common.PageBean;	
import com.vo.Xun;	
	
public class XunDAOImpl extends HibernateGenericDao<Xun> implements	
		XunDAO {	
	
	public void save(Xun xun) {	
		super.save(xun);	
	}	
	
	public void update(Xun xun) {	
		super.update(xun);	
	}	
	
	public void delete(Xun xun) {	
		super.remove(xun);	
	}	
	
	public Xun getXun(Xun xun) {	
		return get(xun.getId());	
	}	
	
	public Xun getXun(Long id) {	
		return get(id);	
	}	
	
	public List<Xun> getAllXun() {	
	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM xun WHERE 1=1 ");	
		sql = getStringBuffer(new Xun(), sql, args);	
		return getPageInfo(null, sql.toString()+" order by addate desc", args);	
	}	
	
	public List<Xun> findPageInfoXun(Xun xun, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM xun WHERE 1=1 ");	
		sql = getStringBuffer(xun, sql, args);	
		return getPageInfo(pageBean, sql.toString()+" order by addate desc", args);	
	}	
	
	public List<Xun> findPageInfoXun1(Xun xun, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM xun WHERE  NAME<>'admin' ");	
		sql = getStringBuffer(xun, sql, args);	
		return getPageInfo(pageBean, sql.toString(), args);	
	}	
	
	public Integer getCount1(Xun xun) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM xun WHERE NAME<>'admin'  ");	
		sql = getStringBuffer(xun, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	public Integer getCount(Xun xun) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM xun WHERE 1=1 ");	
		sql = getStringBuffer(xun, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	/**	
	 * 构造查询条件	
	 * 	
	 * @param xun	
	 * @param buf3	
	 * @param args	
	 * @return	
	 * @author Alex 10/28/2011 create	
	 */	
	private StringBuffer getStringBuffer(Xun xun, StringBuffer buf,	
			List args) {	
		/*	
		 * 需要加入查询条件时封装	
		 */	
	
		if (StringUtils.isNotBlank(xun.getTitle())) {	
			buf.append(" and title like '%"+xun.getTitle().trim()+"%' ");	
			 
		}	
		
		if (StringUtils.isNotBlank(xun.getStyle())) {	
			buf.append(" and style like '%"+xun.getStyle().trim()+"%' ");	
			 
		}	
	
		return buf;	
	}	
}	
