package com.action;	
	
import java.util.Calendar;	
import java.util.Date;	
import java.util.List;	
import java.util.Map;
	
import javax.servlet.http.HttpServletRequest;	
	
import org.apache.commons.lang.StringUtils;	
import org.apache.log4j.Logger;	
import org.apache.struts2.ServletActionContext;	
	
import com.common.Constants;	
import com.common.DataSource;
	
import com.common.PageBean;	
	
import com.service.UserinfoService;	
import com.vo.Loginuser;
import com.vo.Userinfo;	
	
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;	
	
	
public class UserinfoWebAction extends ActionSupport {	
	
	/**	
	 * Service层实例	
	 */	
	private UserinfoService userinfoService;	
	
	/**	
	 * 日志	
	 */	
	private Logger log = Logger.getLogger(this.getClass());	
	
	private Userinfo userinfo = new Userinfo();	
	
	private Long id;	
	
	private String fujian;
	
	@SuppressWarnings("unchecked")	
	public String queryUserinfo() {	
		log.debug("queryUserinfo" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
	
		int resultSize = 0;	
		PageBean pageBean = null;	
			
//		Loginuser user = (Loginuser) request.getSession().getAttribute("currentUser");	
			
		resultSize = userinfoService.getCount(userinfo);	
		pageBean = PageBean.getPageBean("userinfo",	
				resultSize, request);	
		pageBean.setPageSize(10);	
		List list = userinfoService.findPageInfoUserinfo(userinfo, pageBean);	
		request.setAttribute("userinfo_list", list);	
		log.debug("queryUserinfo" + "结束");	
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
	public String toAddUserinfo() {	
		log.debug("toAddUserinfo" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);	
		Date date = new Date();	
	 	
			
		log.debug("toAddUserinfo" + "结束");	
		return Constants.ADD;	
	}	
	
	public String addFUserinfo() {	
		log.debug("toAddUserinfo" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		userinfo.setPic(fujian);
		
		Userinfo ui=new Userinfo();
		ui.setName(userinfo.getName());
		List list=userinfoService.findPageInfoUserinfo(ui, null);
		if(list!=null&&list.size()>0){
			 request.setAttribute("messageInfo", "该用户已存在！");
			return regUserinfo();	
		}
		
		userinfoService.save(userinfo);	
		
		userinfo = new Userinfo();	
		 
        request.setAttribute("messageInfo", "注册成功请登录！");
			
		log.debug("toAddUserinfo" + "结束");	
		return regUserinfo();	
	}	
	
	public String editFUserinfo() {	
		log.debug("editUserinfo" + "开始");	
		try {	
			HttpServletRequest request = ServletActionContext.getRequest();	
			userinfo.setPic(fujian);
			userinfoService.update(userinfo);	
			 request.getSession().setAttribute("user", userinfo);
			userinfo = new Userinfo();	
			
			request.setAttribute("messageInfo", "修改成功！");
			
		} catch (Exception e) {	
			log.error("editUserinfo failed" + userinfo.toString());	
		}	
		log.debug("editUserinfo" + "结束");	
		return "regs";
	}	
	
	
	public String regUserinfo() {	
		log.debug("toAddUserinfo" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		initSelect(request);
			
		log.debug("toAddUserinfo" + "结束");	
		return "reg";	
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
	public String addUserinfo() {	
		log.debug("addUserinfo" + "开始");	
		try {	
				
			userinfoService.save(userinfo);	
				
			userinfo = new Userinfo();	
		} catch (Exception e) {	
			e.printStackTrace();	
			log.error("addUserinfo failed" + userinfo.toString());	
		}	
		log.debug("addUserinfo" + "结束");	
		return queryUserinfo();	
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
	public String delUserinfo() {	
		log.debug("delUserinfo" + "开始");	
		try {	
			userinfo.setId(id);	
			userinfoService.delete(userinfo);	
			userinfo = new Userinfo();	
		} catch (Exception e) {	
			log.error("delUserinfo failed" + userinfo.toString());	
		}	
		log.debug("delUserinfo" + "结束");	
		return queryUserinfo();	
	}
	
	
	public String logon() {
		log.debug("logon" + "开始");
		List list = userinfoService.findPageInfoUserinfo(userinfo, null);
		if(list == null){
			HttpServletRequest request = ServletActionContext.getRequest();
	        request.setAttribute("messageInfo", "用户名或密码错误！");
			return "fail";
		}
		Userinfo userinfo = (Userinfo) list.get(0);
		HttpServletRequest request = ServletActionContext.getRequest();

        request.getSession().setAttribute("user", userinfo);

		log.debug("logon" + "结束");
		return "success";
	}
	
	/**
	 * 退出
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String logonOut() {
		log.debug("logonOut" + "开始");
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("user", null);
		return "success";
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
	public String toEditUserinfo() {	
		log.debug("toEditUserinfo" + "开始");	
		HttpServletRequest request = ServletActionContext.getRequest();	
		userinfo = userinfoService.getUserinfo(id);	
		initSelect(request);	
		log.debug("toEditUserinfo" + "结束");	
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
		userinfo = userinfoService.getUserinfo(id);	
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
	public String viewUserinfo() {	
		log.debug("viewUserinfo" + "开始");	
		userinfo = userinfoService.getUserinfo(id);	
		log.debug("viewUserinfo" + "结束");	
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
	public String editUserinfo() {	
		log.debug("editUserinfo" + "开始");	
		try {	
				
			userinfoService.update(userinfo);	
			userinfo = new Userinfo();	
		} catch (Exception e) {	
			log.error("editUserinfo failed" + userinfo.toString());	
		}	
		log.debug("editUserinfo" + "结束");	
		return queryUserinfo();	
	}	
	
		
		
	/**	
	 * @param UserinfoService	
	 *            the UserinfoService to set	
	 */	
	public void setUserinfoService(UserinfoService userinfoService) {	
		this.userinfoService = userinfoService;	
	}	
	
	public Userinfo getUserinfo() {	
		return userinfo;	
	}	
	
	public void setUserinfo(Userinfo userinfo) {	
		this.userinfo = userinfo;	
	}	
	
	public Long getId() {	
		return id;	
	}	
	
	public void setId(Long id) {	
		this.id = id;	
	}	
	
	public void initSelect(HttpServletRequest request) {	
		request.setAttribute("yhlx", DataSource.XB);
		request.setAttribute("kmlx", DataSource.STYLE);
			
 	
	}




	public String getFujian() {
		return fujian;
	}




	public void setFujian(String fujian) {
		this.fujian = fujian;
	}	
	
	
	
}	
