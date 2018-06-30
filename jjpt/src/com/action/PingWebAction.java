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
	
import com.service.PingService;	
import com.vo.Ping;	
	
import com.opensymphony.xwork2.ActionSupport;	
	
	
public class PingWebAction extends ActionSupport {	
	
	/**	
	 * Service层实例	
	 */	
	private PingService pingService;	
	
	/**	
	 * 日志	
	 */	
	private Logger log = Logger.getLogger(this.getClass());	
	
	private Ping ping = new Ping();	
	
	private Long id;	
	
	@SuppressWarnings("unchecked")	
	public String queryPing() {	
		log.debug("queryPing" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
	
		int resultSize = 0;	
		PageBean pageBean = null;	
			
//		Loginuser user = (Loginuser) request.getSession().getAttribute("currentUser");	
			
		resultSize = pingService.getCount(ping);	
		pageBean = PageBean.getPageBean("ping",	
				resultSize, request);	
		pageBean.setPageSize(10);	
		List list = pingService.findPageInfoPing(ping, pageBean);	
		request.setAttribute("ping_list", list);	
		log.debug("queryPing" + "结束");	
		return Constants.LIST;	
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
	public String toAddPing() {	
		log.debug("toAddPing" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		Date date = new Date();	
	 	
			
		log.debug("toAddPing" + "结束");	
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
	public String addPing() {	
		log.debug("addPing" + "开始");	
		try {	
				
			pingService.save(ping);	
				
			ping = new Ping();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addPing failed" + ping.toString());	
		}	
		log.debug("addPing" + "结束");	
		return queryPing();	
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
	public String delPing() {	
		log.debug("delPing" + "开始");	
		try {	
			ping.setId(id);	
			pingService.delete(ping);	
			ping = new Ping();	
		} catch (Exception e) {	
			log.error("delPing failed" + ping.toString());	
		}	
		log.debug("delPing" + "结束");	
		return queryPing();	
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
	public String toEditPing() {	
		log.debug("toEditPing" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		ping = pingService.getPing(id);	
		initSelect(request);	
		log.debug("toEditPing" + "结束");	
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
		ping = pingService.getPing(id);	
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
	public String viewPing() {	
		log.debug("viewPing" + "开始");	
		ping = pingService.getPing(id);	
		log.debug("viewPing" + "结束");	
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
	public String editPing() {	
		log.debug("editPing" + "开始");	
		try {	
				
			pingService.update(ping);	
			ping = new Ping();	
		} catch (Exception e) {	
			log.error("editPing failed" + ping.toString());	
		}	
		log.debug("editPing" + "结束");	
		return queryPing();	
	}	
	
		
		
	/**	
	 * @param PingService	
	 *            the PingService to set	
	 */	
	public void setPingService(PingService pingService) {	
		this.pingService = pingService;	
	}	
	
	public Ping getPing() {	
		return ping;	
	}	
	
	public void setPing(Ping ping) {	
		this.ping = ping;	
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
