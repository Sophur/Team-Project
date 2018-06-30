package com.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.common.Constants;

import com.common.PageBean;

import com.service.LingService;
import com.service.NewsService;
import com.service.XunService;

import com.vo.Ling;
import com.vo.News;
import com.vo.Xun;

import com.opensymphony.xwork2.ActionSupport;

public class IndexWebAction extends ActionSupport {

	/**
	 * Service层实例
	 */
	private NewsService newsService;

	private LingService lingService;

	private XunService xunService;

	/**
	 * 日志
	 */
	private Logger log = Logger.getLogger(this.getClass());

	private Long id;

	@SuppressWarnings("unchecked")
	public String queryIndex() {
		log.debug("queryGoods" + "开始");
		HttpServletRequest request = ServletActionContext.getRequest();
		initSelect(request);
		
		List<News> list = newsService.getAllNews();
		request.setAttribute("newsList", list);//将获得的list变量值 set到前台， newsList

		List<Xun> listxun = xunService.getAllXun();
		if(listxun==null){
			listxun=new ArrayList<Xun>();
		}
		if (listxun!=null&&listxun.size() >= 10) {
			request.setAttribute("xunList", listxun.subList(0, 8));
		} else {
			request.setAttribute("xunList", listxun);
		}

		List<Ling> listling = lingService.getAllLing();
		if(listling==null){
			listling=new ArrayList<Ling>();
		}
		if (listling!=null&&listling.size() >= 10) {
			request.setAttribute("lingList", listling.subList(0, 8));
		} else {
			request.setAttribute("lingList", listling);
		}
		log.debug("queryGoods" + "结束");
		return "index";
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public LingService getLingService() {
		return lingService;
	}

	public void setLingService(LingService lingService) {
		this.lingService = lingService;
	}

	public XunService getXunService() {
		return xunService;
	}

	public void setXunService(XunService xunService) {
		this.xunService = xunService;
	}

	public void initSelect(HttpServletRequest request) {

	}

}
