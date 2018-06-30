package com.service;	
import java.util.List;	
	
import com.common.PageBean;	
import com.vo.Ping;	
	
public interface PingService	
{	
    public void save(Ping ping);	
		
	public void update(Ping ping);	
		
	public void delete(Ping ping);	
		
	public Ping getPing(Ping ping);	
		
	public Ping getPing(Long id);	
	
	public List<Ping> findPageInfoPing(Ping ping,PageBean pageBean);	
		
	public Integer getCount(Ping ping);	
		
	public List<Ping> findPageInfoPing1(Ping ping,PageBean pageBean);	
		
	public Integer getCount1(Ping ping);	
		
	public List<Ping> getAllPing();	
}	
