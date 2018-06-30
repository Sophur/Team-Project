package com.dao;	
import com.common.PageBean;	
import com.vo.Ping;	
	
import java.util.List;	
	
public interface PingDAO	
{	
	
	public void save(Ping ping);	
		
	public void update(Ping ping);	
		
	public void delete(Ping ping);	
		
	public Ping getPing(Ping ping);	
		
	public Ping getPing(Long id);	
	/**	
	 * 获得Ping的分页列表	
	 * @param pageBean	
	 * @return	
	 */	
	public List<Ping> findPageInfoPing(Ping ping,PageBean pageBean);	
		
	public Integer getCount(Ping ping);	
		
	public List<Ping> findPageInfoPing1(Ping ping,PageBean pageBean);	
		
	public Integer getCount1(Ping ping);	
		
	public List<Ping> getAllPing() ;	
}	
