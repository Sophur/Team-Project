package com.service;	
import java.util.List;	
	
import com.common.PageBean;	
import com.vo.Ling;	
	
public interface LingService	
{	
    public void save(Ling ling);	
		
	public void update(Ling ling);	
		
	public void delete(Ling ling);	
		
	public Ling getLing(Ling ling);	
		
	public Ling getLing(Long id);	
	
	public List<Ling> findPageInfoLing(Ling ling,PageBean pageBean);	
		
	public Integer getCount(Ling ling);	
		
	public List<Ling> findPageInfoLing1(Ling ling,PageBean pageBean);	
		
	public Integer getCount1(Ling ling);	
		
	public List<Ling> getAllLing();	
}	
