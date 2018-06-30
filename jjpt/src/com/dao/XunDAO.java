package com.dao;	
import com.common.PageBean;	
import com.vo.Xun;	
	
import java.util.List;	
	
public interface XunDAO	
{	
	
	public void save(Xun xun);	
		
	public void update(Xun xun);	
		
	public void delete(Xun xun);	
		
	public Xun getXun(Xun xun);	
		
	public Xun getXun(Long id);	
	/**	
	 * 获得Xun的分页列表	
	 * @param pageBean	
	 * @return	
	 */	
	public List<Xun> findPageInfoXun(Xun xun,PageBean pageBean);	
		
	public Integer getCount(Xun xun);	
		
	public List<Xun> findPageInfoXun1(Xun xun,PageBean pageBean);	
		
	public Integer getCount1(Xun xun);	
		
	public List<Xun> getAllXun() ;	
}	
