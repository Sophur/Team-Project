package com.service;	
import java.util.List;	
	
import com.common.PageBean;	
import com.vo.Xun;	
	
public interface XunService	
{	
    public void save(Xun xun);	
		
	public void update(Xun xun);	
		
	public void delete(Xun xun);	
		
	public Xun getXun(Xun xun);	
		
	public Xun getXun(Long id);	
	
	public List<Xun> findPageInfoXun(Xun xun,PageBean pageBean);	
		
	public Integer getCount(Xun xun);	
		
	public List<Xun> findPageInfoXun1(Xun xun,PageBean pageBean);	
		
	public Integer getCount1(Xun xun);	
		
	public List<Xun> getAllXun();	
}	
