package com.dao;	
import com.common.PageBean;	
import com.vo.Userinfo;	
	
import java.util.List;	
	
public interface UserinfoDAO	
{	
	
	public void save(Userinfo userinfo);	
		
	public void update(Userinfo userinfo);	
		
	public void delete(Userinfo userinfo);	
		
	public Userinfo getUserinfo(Userinfo userinfo);	
		
	public Userinfo getUserinfo(Long id);	
	/**	
	 * 获得Userinfo的分页列表	
	 * @param pageBean	
	 * @return	
	 */	
	public List<Userinfo> findPageInfoUserinfo(Userinfo userinfo,PageBean pageBean);	
		
	public Integer getCount(Userinfo userinfo);	
		
	public List<Userinfo> findPageInfoUserinfo1(Userinfo userinfo,PageBean pageBean);	
		
	public Integer getCount1(Userinfo userinfo);	
		
	public List<Userinfo> getAllUserinfo() ;	
}	
