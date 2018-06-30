package com.service;	
	
import java.util.List;	
	
import com.common.PageBean;	
import com.dao.PingDAO;	
import com.vo.Ping;	
	
public class PingServiceImpl implements PingService {	
	private PingDAO pingDAO;	
	
	public void save(Ping ping) {	
		pingDAO.save(ping);	
	}	
	
	public void update(Ping ping) {	
		pingDAO.update(ping);	
	}	
	
	public Ping getPing(Ping ping) {	
		return pingDAO.getPing(ping);	
	}	
	
	public Ping getPing(Long id) {	
		return pingDAO.getPing(id);	
	}	
	
	public void delete(Ping ping) {	
		pingDAO.delete(ping);	
	}	
	
	public List<Ping> findPageInfoPing(Ping ping, PageBean pageBean) {	
		return pingDAO.findPageInfoPing(ping, pageBean);	
	}	
	
	public Integer getCount(Ping ping) {	
		return pingDAO.getCount(ping);	
	}	
	
	public void setPingDAO(PingDAO pingDAO) {	
		this.pingDAO = pingDAO;	
	}	
	
	public List<Ping> findPageInfoPing1(Ping ping, PageBean pageBean) {	
	
		return pingDAO.findPageInfoPing1(ping, pageBean);	
	}	
	
	public Integer getCount1(Ping ping) {	
	
		return pingDAO.getCount1(ping);	
	}	
	
	public List<Ping> getAllPing() {	
	
		return pingDAO.getAllPing();	
	}	
}	
