package com.service;	
	
import java.util.List;	
	
import com.common.PageBean;	
import com.dao.XunDAO;	
import com.vo.Xun;	
	
public class XunServiceImpl implements XunService {	
	private XunDAO xunDAO;	
	
	public void save(Xun xun) {	
		xunDAO.save(xun);	
	}	
	
	public void update(Xun xun) {	
		xunDAO.update(xun);	
	}	
	
	public Xun getXun(Xun xun) {	
		return xunDAO.getXun(xun);	
	}	
	
	public Xun getXun(Long id) {	
		return xunDAO.getXun(id);	
	}	
	
	public void delete(Xun xun) {	
		xunDAO.delete(xun);	
	}	
	
	public List<Xun> findPageInfoXun(Xun xun, PageBean pageBean) {	
		return xunDAO.findPageInfoXun(xun, pageBean);	
	}	
	
	public Integer getCount(Xun xun) {	
		return xunDAO.getCount(xun);	
	}	
	
	public void setXunDAO(XunDAO xunDAO) {	
		this.xunDAO = xunDAO;	
	}	
	
	public List<Xun> findPageInfoXun1(Xun xun, PageBean pageBean) {	
	
		return xunDAO.findPageInfoXun1(xun, pageBean);	
	}	
	
	public Integer getCount1(Xun xun) {	
	
		return xunDAO.getCount1(xun);	
	}	
	
	public List<Xun> getAllXun() {	
	
		return xunDAO.getAllXun();	
	}	
}	
