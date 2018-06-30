package com.service;	
	
import java.util.List;	
	
import com.common.PageBean;	
import com.dao.NewsDAO;	
import com.vo.News;	
	
public class NewsServiceImpl implements NewsService {	
	private NewsDAO newsDAO;	
	
	public void save(News news) {	
		newsDAO.save(news);	
	}	
	
	public void update(News news) {	
		newsDAO.update(news);	
	}	
	
	public News getNews(News news) {	
		return newsDAO.getNews(news);	
	}	
	
	public News getNews(Long id) {	
		return newsDAO.getNews(id);	
	}	
	
	public void delete(News news) {	
		newsDAO.delete(news);	
	}	
	
	public List<News> findPageInfoNews(News news, PageBean pageBean) {	
		return newsDAO.findPageInfoNews(news, pageBean);	
	}	
	
	public Integer getCount(News news) {	
		return newsDAO.getCount(news);	
	}	
	
	public void setNewsDAO(NewsDAO newsDAO) {	
		this.newsDAO = newsDAO;	
	}	
	
	public List<News> findPageInfoNews1(News news, PageBean pageBean) {	
	
		return newsDAO.findPageInfoNews1(news, pageBean);	
	}	
	
	public Integer getCount1(News news) {	
	
		return newsDAO.getCount1(news);	
	}	
	
	public List<News> getAllNews() {	
	
		return newsDAO.getAllNews();	
	}	
}	
