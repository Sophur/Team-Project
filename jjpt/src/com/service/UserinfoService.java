package com.service;	
import java.util.List;	
	
import com.common.PageBean;	
import com.vo.Userinfo;	
	
public interface UserinfoService	
{	
    public void save(Userinfo userinfo);	
		
	public void update(Userinfo userinfo);	
		
	public void delete(Userinfo userinfo);	
		
	public Userinfo getUserinfo(Userinfo userinfo);	
		
	public Userinfo getUserinfo(Long id);	
	
	public List<Userinfo> findPageInfoUserinfo(Userinfo userinfo,PageBean pageBean);	
		
	public Integer getCount(Userinfo userinfo);	
		
	public List<Userinfo> findPageInfoUserinfo1(Userinfo userinfo,PageBean pageBean);	
		
	public Integer getCount1(Userinfo userinfo);	
		
	public List<Userinfo> getAllUserinfo();	
}	
