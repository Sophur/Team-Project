package com.service;	
	
import java.util.List;	
	
import com.common.PageBean;	
import com.dao.LingDAO;	
import com.vo.Ling;	
	
public class LingServiceImpl implements LingService {	
	private LingDAO lingDAO;	
	
	public void save(Ling ling) {	
		lingDAO.save(ling);	
	}	
	
	public void update(Ling ling) {	
		lingDAO.update(ling);	
	}	
	
	public Ling getLing(Ling ling) {	
		return lingDAO.getLing(ling);	
	}	
	
	public Ling getLing(Long id) {	
		return lingDAO.getLing(id);	
	}	
	
	public void delete(Ling ling) {	
		lingDAO.delete(ling);	
	}	
	
	public List<Ling> findPageInfoLing(Ling ling, PageBean pageBean) {	
		return lingDAO.findPageInfoLing(ling, pageBean);	
	}	
	
	public Integer getCount(Ling ling) {	
		return lingDAO.getCount(ling);	
	}	
	
	public void setLingDAO(LingDAO lingDAO) {	
		this.lingDAO = lingDAO;	
	}	
	
	public List<Ling> findPageInfoLing1(Ling ling, PageBean pageBean) {	
	
		return lingDAO.findPageInfoLing1(ling, pageBean);	
	}	
	
	public Integer getCount1(Ling ling) {	
	
		return lingDAO.getCount1(ling);	
	}	
	
	public List<Ling> getAllLing() {	
	
		return lingDAO.getAllLing();	
	}	
}	
