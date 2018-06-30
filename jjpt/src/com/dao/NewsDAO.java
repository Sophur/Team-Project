package com.dao;	
import com.common.PageBean;	
import com.vo.News;	
	
import java.util.List;	
	
public interface NewsDAO	
{	
	
	public void save(News news);	
		
	public void update(News news);	
		
	public void delete(News news);	
		
	public News getNews(News news);	
		
	public News getNews(Long id);	
	/**	
	 * 获得News的分页列表	
	 * @param pageBean	
	 * @return	
	 */	
	public List<News> findPageInfoNews(News news,PageBean pageBean);	
		
	public Integer getCount(News news);	
		
	public List<News> findPageInfoNews1(News news,PageBean pageBean);	
		
	public Integer getCount1(News news);	
		
	public List<News> getAllNews() ;	
}	
