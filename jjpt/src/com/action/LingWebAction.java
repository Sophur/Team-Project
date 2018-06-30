package com.action;	
	
import java.util.Date;	
import java.util.List;	
	
import javax.servlet.http.HttpServletRequest;	
	
import org.apache.log4j.Logger;	
import org.apache.struts2.ServletActionContext;	
	
import com.common.Constants;	
import com.common.DataSource;
	
import com.common.PageBean;	
	
import com.service.LingService;	
import com.service.PingService;
import com.vo.Ling;	
import com.vo.Ping;
import com.vo.Userinfo;
	
import com.opensymphony.xwork2.ActionSupport;	
	
	
public class LingWebAction extends ActionSupport {	
	
	/**	
	 * Service层实例	
	 */	
	private LingService lingService;	
	
	/**	
	 * 日志	
	 */	
	private Logger log = Logger.getLogger(this.getClass());	
	
	private Ling ling = new Ling();	
	
	private Long id;	
	
	private String fujian;
	
	private PingService pingService;
	
	private String msg;
	
	@SuppressWarnings("unchecked")	
	public String queryLing() {	
		log.debug("queryLing" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
	
		int resultSize = 0;	
		PageBean pageBean = null;	
		resultSize = lingService.getCount(ling);	
		pageBean = PageBean.getPageBean("ling",	resultSize, request);	
		pageBean.setPageSize(10);	
		List list = lingService.findPageInfoLing(ling, pageBean);	
		request.setAttribute("ling_list", list);
		log.debug("queryLing" + "结束");	
		return Constants.LIST;	
	}	
		
	
	public String queryFrLing() {	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		
		int resultSize = 0;	
		PageBean pageBean = null;	
		resultSize = lingService.getCount(ling);	
		pageBean = PageBean.getPageBean("ling",	
				resultSize, request);	
		pageBean.setPageSize(8);	
		List list = lingService.findPageInfoLing(ling, pageBean);

		request.setAttribute("lingList", list);
		return "ling";
	}
	
	public String toLoadLing() {	
		log.debug("toEditNews" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		ling = lingService.getLing(id);	
		initSelect(request);	
		Ping ping=new Ping();
		ping.setType("ling");
		ping.setInid(id);
		List<Ping> list=pingService.findPageInfoPing(ping, null);
		request.setAttribute("pingList", list);
		log.debug("toEditNews" + "结束");	
		return "lingd";	
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
	public String toAddLing() {	
		log.debug("toAddLing" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		Date date = new Date();	
	 	
			
		log.debug("toAddLing" + "结束");	
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
	public String addLing() {	
		log.debug("addLing" + "开始");	
		try {	
				
			 
			lingService.save(ling);	
				
			ling = new Ling();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addLing failed" + ling.toString());	
		}	
		log.debug("addLing" + "结束");	
		return queryLing();	
	}	
	
	public String addMsg() {
		try {	
			HttpServletRequest request = ServletActionContext.getRequest();	
			ling = lingService.getLing(id);
			
			Ping ping=new Ping();
			ping.setInfo(msg);
			Userinfo user=(Userinfo) request.getSession().getAttribute("user");
			ping.setName(user.getName());
			ping.setPic(user.getPic());
			ping.setType("ling");
			ping.setInid(id);
			ping.setAdddate(new Date().toLocaleString());
			
			pingService.save(ping);
		
				
			ling = new Ling();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addXun failed" + ling.toString());	
		}	
		return this.toLoadLing();
	}
	
	public String addLingFr() {	
		log.debug("addLing" + "开始");
		HttpServletRequest request = ServletActionContext.getRequest();	
		try {	
			ling.setAddate(new Date().toLocaleString());
			Userinfo user=(Userinfo) request.getSession().getAttribute("user");
			 	
			ling.setUserid(user.getId());
			ling.setStyle(user.getStyle());
			lingService.save(ling);	
				
			ling = new Ling();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addLing failed" + ling.toString());	
		}	
		log.debug("addLing" + "结束");	
		return queryFrLing();	
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
	public String delLing() {	
		log.debug("delLing" + "开始");	
		try {	
			ling.setId(id);	
			lingService.delete(ling);	
			ling = new Ling();	
		} catch (Exception e) {	
			log.error("delLing failed" + ling.toString());	
		}	
		log.debug("delLing" + "结束");	
		return queryLing();	
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
	public String toEditLing() {	
		log.debug("toEditLing" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		ling = lingService.getLing(id);	
		initSelect(request);	
		log.debug("toEditLing" + "结束");	
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
		ling = lingService.getLing(id);	
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
	public String viewLing() {	
		log.debug("viewLing" + "开始");	
		ling = lingService.getLing(id);	
		log.debug("viewLing" + "结束");	
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
	public String editLing() {	
		log.debug("editLing" + "开始");	
		try {	
			 
			lingService.update(ling);	
			ling = new Ling();	
		} catch (Exception e) {	
			log.error("editLing failed" + ling.toString());	
		}	
		log.debug("editLing" + "结束");	
		return queryLing();	
	}	
	
		
		
	/**	
	 * @param LingService	
	 *            the LingService to set	
	 */	
	public void setLingService(LingService lingService) {	
		this.lingService = lingService;	
	}	
	
	public Ling getLing() {	
		return ling;	
	}	
	
	public void setLing(Ling ling) {	
		this.ling = ling;	
	}	
	
	public Long getId() {	
		return id;	
	}	
	
	public void setId(Long id) {	
		this.id = id;	
	}	
	
	public void initSelect(HttpServletRequest request) {	
		request.setAttribute("kmlx", DataSource.STYLE);
 	
	}	
	
	public String getFujian() {
		return fujian;
	}




	public void setFujian(String fujian) {
		this.fujian = fujian;
	}


	public PingService getPingService() {
		return pingService;
	}


	public void setPingService(PingService pingService) {
		this.pingService = pingService;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}	
	
	
	
}	
