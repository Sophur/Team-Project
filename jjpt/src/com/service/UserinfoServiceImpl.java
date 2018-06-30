package com.service;	
	
import java.util.List;	
	
import com.common.PageBean;	
import com.dao.UserinfoDAO;	
import com.vo.Userinfo;	
	
public class UserinfoServiceImpl implements UserinfoService {	
	private UserinfoDAO userinfoDAO;	
	
	public void save(Userinfo userinfo) {	
		userinfoDAO.save(userinfo);	
	}	
	
	public void update(Userinfo userinfo) {	
		userinfoDAO.update(userinfo);	
	}	
	
	public Userinfo getUserinfo(Userinfo userinfo) {	
		return userinfoDAO.getUserinfo(userinfo);	
	}	
	
	public Userinfo getUserinfo(Long id) {	
		return userinfoDAO.getUserinfo(id);	
	}	
	
	public void delete(Userinfo userinfo) {	
		userinfoDAO.delete(userinfo);	
	}	
	
	public List<Userinfo> findPageInfoUserinfo(Userinfo userinfo, PageBean pageBean) {	
		return userinfoDAO.findPageInfoUserinfo(userinfo, pageBean);	
	}	
	
	public Integer getCount(Userinfo userinfo) {	
		return userinfoDAO.getCount(userinfo);	
	}	
	
	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {	
		this.userinfoDAO = userinfoDAO;	
	}	
	
	public List<Userinfo> findPageInfoUserinfo1(Userinfo userinfo, PageBean pageBean) {	
	
		return userinfoDAO.findPageInfoUserinfo1(userinfo, pageBean);	
	}	
	
	public Integer getCount1(Userinfo userinfo) {	
	
		return userinfoDAO.getCount1(userinfo);	
	}	
	
	public List<Userinfo> getAllUserinfo() {	
	
		return userinfoDAO.getAllUserinfo();	
	}	
}	
