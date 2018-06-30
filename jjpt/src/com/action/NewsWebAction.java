package com.action;	
	
import java.util.Calendar;	
import java.util.Date;	
import java.util.List;	
	
import javax.servlet.http.HttpServletRequest;	
	
import org.apache.commons.lang.StringUtils;	
import org.apache.log4j.Logger;	
import org.apache.struts2.ServletActionContext;	
	
import com.common.Constants;	
	
import com.common.PageBean;	
	
import com.service.NewsService;	
import com.vo.News;	
	
import com.opensymphony.xwork2.ActionSupport;	
	
	
public class NewsWebAction extends ActionSupport {	
	
	/**	
	 * Service层实例	
	 */	
	private NewsService newsService;	
	
	/**	
	 * 日志	
	 */	
	private Logger log = Logger.getLogger(this.getClass());	
	
	private News news = new News();	
	
	private Long id;	
	
	@SuppressWarnings("unchecked")	
	public String queryNews() {	
		log.debug("queryNews" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
	
		int resultSize = 0;	
		PageBean pageBean = null;	
			
//		Loginuser user = (Loginuser) request.getSession().getAttribute("currentUser");	
			
		resultSize = newsService.getCount(news);	
		pageBean = PageBean.getPageBean("news",	
				resultSize, request);	
		pageBean.setPageSize(10);	
		List list = newsService.findPageInfoNews(news, pageBean);	
		request.setAttribute("news_list", list);	
		log.debug("queryNews" + "结束");	
		return Constants.LIST;	
	}	
		
	public String queryFrNews() {	
		List<News>  list=newsService.getAllNews();
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	

		request.setAttribute("newsList", list);
		return "xian";
	}
	
	
	public String toLoadNews() {	
		log.debug("toEditNews" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		news = newsService.getNews(id);	
		initSelect(request);	
		log.debug("toEditNews" + "结束");	
		return "xiand";	
	}	
 	
		
	
	/**	
	 * 	
	 * 进入增加界面	
	 * 	
	 * @param mapping	
	 * @param form	
	 * @param request	
	 * @param response	
	 * @return	
	 * @throws Exception	
	 */	
	public String toAddNews() {	
		log.debug("toAddNews" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		Date date = new Date();	
	 	
			
		log.debug("toAddNews" + "结束");	
		return Constants.ADD;	
	}	
	
	/**	
	 * 	
	 * 增加	
	 * 	
	 * @param mapping	
	 * @param form	
	 * @param request	
	 * @param response	
	 * @return	
	 * @throws Exception	
	 */	
	public String addNews() {	
		log.debug("addNews" + "开始");	
		try {	
			news.setDate(new Date().toLocaleString());
			newsService.save(news);	
				
			news = new News();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addNews failed" + news.toString());	
		}	
		log.debug("addNews" + "结束");	
		return queryNews();	
	}	
	
	/**	
	 * 	
	 * 删除	
	 * 	
	 * @param mapping	
	 * @param form	
	 * @param request	
	 * @param response	
	 * @return	
	 * @throws Exception	
	 */	
	public String delNews() {	
		log.debug("delNews" + "开始");	
		try {	
			news.setId(id);	
			newsService.delete(news);	
			news = new News();	
		} catch (Exception e) {	
			log.error("delNews failed" + news.toString());	
		}	
		log.debug("delNews" + "结束");	
		return queryNews();	
	}	
	
	/**	
	 * 	
	 * 进入编辑界面	
	 * 	
	 * @param mapping	
	 * @param form	
	 * @param request	
	 * @param response	
	 * @return	
	 * @throws Exception	
	 */	
	public String toEditNews() {	
		log.debug("toEditNews" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		news = newsService.getNews(id);	
		initSelect(request);	
		log.debug("toEditNews" + "结束");	
		return Constants.EDIT;	
	}	
		
	/**	
	 * 	
	 * 进入调整访问周期界面	
	 * 	
	 * @param mapping	
	 * @param form	
	 * @param request	
	 * @param response	
	 * @return	
	 * @throws Exception	
	 */	
	public String tomodifyZQ() {	
		log.debug("tomodifyZQ" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		news = newsService.getNews(id);	
		initSelect(request);	
		log.debug("tomodifyZQ" + "结束");	
		return "tomodifyZQ";	
	}	
	
	/**	
	 * 	
	 * 查看信息	
	 * 	
	 * @param mapping	
	 * @param form	
	 * @param request	
	 * @param response	
	 * @return	
	 * @throws Exception	
	 */	
	public String viewNews() {	
		log.debug("viewNews" + "开始");	
		news = newsService.getNews(id);	
		log.debug("viewNews" + "结束");	
		return Constants.VIEW;	
	}	
	
	/**	
	 * 	
	 * 编辑	
	 * 	
	 * @param mapping	
	 * @param form	
	 * @param request	
	 * @param response	
	 * @return	
	 * @throws Exception	
	 */	
	public String editNews() {	
		log.debug("editNews" + "开始");	
		try {	
			news.setDate(new Date().toLocaleString());
			newsService.update(news);	
			news = new News();	
		} catch (Exception e) {	
			log.error("editNews failed" + news.toString());	
		}	
		log.debug("editNews" + "结束");	
		return queryNews();	
	}	
	
		
		
	/**	
	 * @param NewsService	
	 *            the NewsService to set	
	 */	
	public void setNewsService(NewsService newsService) {	
		this.newsService = newsService;	
	}	
	
	public News getNews() {	
		return news;	
	}	
	
	public void setNews(News news) {	
		this.news = news;	
	}	
	
	public Long getId() {	
		return id;	
	}	
	
	public void setId(Long id) {	
		this.id = id;	
	}	
	
	public void initSelect(HttpServletRequest request) {	
			
 	
	}	
	
}	
