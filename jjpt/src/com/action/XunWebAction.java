package com.action;	
	
import java.util.Calendar;	
import java.util.Date;	
import java.util.List;	
	
import javax.servlet.http.HttpServletRequest;	
	
import org.apache.commons.lang.StringUtils;	
import org.apache.log4j.Logger;	
import org.apache.struts2.ServletActionContext;	
	
import com.common.Constants;	
import com.common.DataSource;
	
import com.common.PageBean;	
	
import com.service.PingService;
import com.service.XunService;	
import com.vo.Loginuser;
import com.vo.News;
import com.vo.Ping;
import com.vo.Userinfo;
import com.vo.Xun;	
	
import com.opensymphony.xwork2.ActionSupport;	
	
	
public class XunWebAction extends ActionSupport {	
	
	/**	
	 * Service层实例	
	 */	
	private XunService xunService;	
	
	private PingService pingService;	
	
	/**	
	 * 日志	
	 */	
	private Logger log = Logger.getLogger(this.getClass());	
	
	private Xun xun = new Xun();	
	
	private Long id;	
	
	private String fujian;
	
	private String msg;
	
	@SuppressWarnings("unchecked")	
	public String queryXun() {	
		log.debug("queryXun" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
	
		int resultSize = 0;	
		PageBean pageBean = null;	
			
//		Loginuser user = (Loginuser) request.getSession().getAttribute("currentUser");	
			
		resultSize = xunService.getCount(xun);	
		pageBean = PageBean.getPageBean("xun",	
				resultSize, request);	
		pageBean.setPageSize(10);	
		List list = xunService.findPageInfoXun(xun, pageBean);	
		request.setAttribute("xun_list", list);	
		log.debug("queryXun" + "结束");	
		return Constants.LIST;	
	}	
		
	public String queryFrXun() {	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		
		int resultSize = 0;	
		PageBean pageBean = null;	
		resultSize = xunService.getCount(xun);	
		pageBean = PageBean.getPageBean("xun",	
				resultSize, request);	
		pageBean.setPageSize(200);	
		List list = xunService.findPageInfoXun(xun, pageBean);
		
		
		

		request.setAttribute("xunList", list);
		return "xun";
	}
	
	public String toLoadXun() {	
		log.debug("toEditNews" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		xun = xunService.getXun(id);	
		
		Ping ping=new Ping();
		ping.setType("xun");
		ping.setInid(id);
		List<Ping> list=pingService.findPageInfoPing(ping, null);
		request.setAttribute("pingList", list);
		initSelect(request);	
		log.debug("toEditNews" + "结束");	
		return "xund";	
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
	public String toAddXun() {	
		log.debug("toAddXun" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		Date date = new Date();	
	 	
			
		log.debug("toAddXun" + "结束");	
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
	public String addXun() {	
		log.debug("addXun" + "开始");	
		try {	
			xun.setAddate(new Date().toLocaleString());
			
	 	
			xunService.save(xun);	
				
			xun = new Xun();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addXun failed" + xun.toString());	
		}	
		log.debug("addXun" + "结束");	
		return queryXun();	
	}	
	
	public String addMsg() {
		try {	
			HttpServletRequest request = ServletActionContext.getRequest();	
			xun = xunService.getXun(id);
			
			Ping ping=new Ping();
			ping.setInfo(msg);
			Userinfo user=(Userinfo) request.getSession().getAttribute("user");
			ping.setName(user.getName());
			ping.setPic(user.getPic());
			ping.setType("xun");
			ping.setInid(id);
			ping.setAdddate(new Date().toLocaleString());
			
			pingService.save(ping);
		
				
			xun = new Xun();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addXun failed" + xun.toString());	
		}	
		return this.toLoadXun();
	}
	
	
	public String addXunFr() {	
		log.debug("addXun" + "开始");
		HttpServletRequest request = ServletActionContext.getRequest();	
		try {	
			xun.setAddate(new Date().toLocaleString());
			Userinfo user=(Userinfo) request.getSession().getAttribute("user");
		 
			xun.setUserid(user.getId());
			xun.setStyle(user.getStyle());
			xunService.save(xun);	
				
			xun = new Xun();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addXun failed" + xun.toString());	
		}	
		log.debug("addXun" + "结束");	
		return queryFrXun();	
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
	public String delXun() {	
		log.debug("delXun" + "开始");	
		try {	
			xun.setId(id);	
			xunService.delete(xun);	
			xun = new Xun();	
		} catch (Exception e) {	
			log.error("delXun failed" + xun.toString());	
		}	
		log.debug("delXun" + "结束");	
		return queryXun();	
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
	public String toEditXun() {	
		log.debug("toEditXun" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		xun = xunService.getXun(id);	
		initSelect(request);	
		log.debug("toEditXun" + "结束");	
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
		xun = xunService.getXun(id);	
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
	public String viewXun() {	
		log.debug("viewXun" + "开始");	
		xun = xunService.getXun(id);	
		log.debug("viewXun" + "结束");	
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
	public String editXun() {	
		log.debug("editXun" + "开始");	
		try {	
 
			xunService.update(xun);	
			xun = new Xun();	
		} catch (Exception e) {	
			log.error("editXun failed" + xun.toString());	
		}	
		log.debug("editXun" + "结束");	
		return queryXun();	
	}	
	
		
		
	/**	
	 * @param XunService	
	 *            the XunService to set	
	 */	
	public void setXunService(XunService xunService) {	
		this.xunService = xunService;	
	}	
	
	public Xun getXun() {	
		return xun;	
	}	
	
	public void setXun(Xun xun) {	
		this.xun = xun;	
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
