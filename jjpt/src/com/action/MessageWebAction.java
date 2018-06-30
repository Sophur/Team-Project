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
	
import com.service.MessageService;	
import com.vo.Message;	
import com.vo.Userinfo;
	
import com.opensymphony.xwork2.ActionSupport;	
	
	
public class MessageWebAction extends ActionSupport {	
	
	/**	
	 * Service层实例	
	 */	
	private MessageService messageService;	
	
	/**	
	 * 日志	
	 */	
	private Logger log = Logger.getLogger(this.getClass());	
	
	private Message message = new Message();	
	
	private Long id;	 
	
	private String info;
	
	@SuppressWarnings("unchecked")	
	public String queryMessage() {	
		log.debug("queryMessage" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
	
		int resultSize = 0;	
		PageBean pageBean = null;	
			
//		Loginuser user = (Loginuser) request.getSession().getAttribute("currentUser");	
			
		resultSize = messageService.getCount(message);	
		pageBean = PageBean.getPageBean("message",	
				resultSize, request);	
		pageBean.setPageSize(10);	
		List list = messageService.findPageInfoMessage(message, pageBean);	
		request.setAttribute("message_list", list);	
		log.debug("queryMessage" + "结束");	
		return Constants.LIST;	
	}	
	
	public String queryMessageFr() {
		HttpServletRequest request = ServletActionContext.getRequest();	
		request.setAttribute("msgList", messageService.getAllMessage());
		
		return "fr";
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
	public String toAddMessage() {	
		log.debug("toAddMessage" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		Date date = new Date();	
	 	
			
		log.debug("toAddMessage" + "结束");	
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
	public String addMessage() {	
		log.debug("addMessage" + "开始");	
		try {	
				
//			messageService.save(message);	
			Message msg=messageService.getMessage(message.getId());
			msg.setReply(message.getReply());
			msg.setReplydate(new Date().toLocaleString());
			messageService.update(msg);
				
			message = new Message();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addMessage failed" + message.toString());	
		}	
		log.debug("addMessage" + "结束");	
		return queryMessage();	
	}	
	
	public String addMessageFr(){
		try {	
			HttpServletRequest request = ServletActionContext.getRequest();	
			Userinfo user=(Userinfo) request.getSession().getAttribute("user");
			
			
//			messageService.save(message);	
			Message message = new Message();	
			message.setMsg(info);
			message.setAppuser(user.getName());
			message.setDate(new Date().toLocaleString());
			message.setReply("");
			message.setReplydate("");
			messageService.save(message);
				
			
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addMessage failed" + message.toString());	
		}	
		return queryMessageFr();	
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
	public String delMessage() {	
		log.debug("delMessage" + "开始");	
		try {	
			message.setId(id);	
			messageService.delete(message);	
			message = new Message();	
		} catch (Exception e) {	
			log.error("delMessage failed" + message.toString());	
		}	
		log.debug("delMessage" + "结束");	
		return queryMessage();	
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
	public String toEditMessage() {	
		log.debug("toEditMessage" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		message = messageService.getMessage(id);	
		initSelect(request);	
		log.debug("toEditMessage" + "结束");	
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
		message = messageService.getMessage(id);	
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
	public String viewMessage() {	
		log.debug("viewMessage" + "开始");	
		message = messageService.getMessage(id);	
		log.debug("viewMessage" + "结束");	
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
	public String editMessage() {	
		log.debug("editMessage" + "开始");	
		try {	
				
			messageService.update(message);	
			message = new Message();	
		} catch (Exception e) {	
			log.error("editMessage failed" + message.toString());	
		}	
		log.debug("editMessage" + "结束");	
		return queryMessage();	
	}	
	
		
		
	/**	
	 * @param MessageService	
	 *            the MessageService to set	
	 */	
	public void setMessageService(MessageService messageService) {	
		this.messageService = messageService;	
	}	
	
	public Message getMessage() {	
		return message;	
	}	
	
	public void setMessage(Message message) {	
		this.message = message;	
	}	
	
	public Long getId() {	
		return id;	
	}	
	
	public void setId(Long id) {	
		this.id = id;	
	}	
	
	public void initSelect(HttpServletRequest request) {	
			
 	
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}	
	
}	
