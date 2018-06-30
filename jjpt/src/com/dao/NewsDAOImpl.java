package com.dao;	
	
import java.util.ArrayList;	
import java.util.List;	
	
import org.apache.commons.lang.StringUtils;	
	
import com.common.HibernateGenericDao;	
import com.common.PageBean;	
import com.vo.News;	
	
public class NewsDAOImpl extends HibernateGenericDao<News> implements	
		NewsDAO {	
	
	public void save(News news) {	
		super.save(news);	
	}	
	
	public void update(News news) {	
		super.update(news);	
	}	
	
	public void delete(News news) {	
		super.remove(news);	
	}	
	
	public News getNews(News news) {	
		return get(news.getId());	
	}	
	
	public News getNews(Long id) {	
		return get(id);	
	}	
	
	public List<News> getAllNews() {	
	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM news WHERE 1=1 ");	
		sql = getStringBuffer(new News(), sql, args);	
		return getPageInfo(null, sql.toString()+" order by date desc", args);		
	}	
	
	public List<News> findPageInfoNews(News news, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM news WHERE 1=1 ");	
		sql = getStringBuffer(news, sql, args);	
		return getPageInfo(pageBean, sql.toString()+" order by date desc", args);	
	}	
	
	public List<News> findPageInfoNews1(News news, PageBean pageBean) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT * FROM news WHERE  NAME<>'admin' ");	
		sql = getStringBuffer(news, sql, args);	
		return getPageInfo(pageBean, sql.toString(), args);	
	}	
	
	public Integer getCount1(News news) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM news WHERE NAME<>'admin'  ");	
		sql = getStringBuffer(news, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	public Integer getCount(News news) {	
		List args = new ArrayList();	
		StringBuffer sql = new StringBuffer();	
		sql.append(" SELECT COUNT(0) FROM news WHERE 1=1 ");	
		sql = getStringBuffer(news, sql, args);	
		return super.getCount(sql.toString(), args.toArray());	
	}	
	
	/**	
	 * 构造查询条件	
	 * 	
	 * @param news	
	 * @param buf3	
	 * @param args	
	 * @return	
	 * @author Alex 10/28/2011 create	
	 */	
	private StringBuffer getStringBuffer(News news, StringBuffer buf,	
			List args) {	
		/*	
		 * 需要加入查询条件时封装	
		 */	
	
		if (StringUtils.isNotBlank(news.getTitle())) {	
			buf.append(" and title = ? ");	
			args.add(news.getTitle().trim());	
		}	
	
		return buf;	
	}	
}	
