package com.dao;	
import com.common.PageBean;	
import com.vo.Ling;	
	
import java.util.List;	
	
public interface LingDAO	
{	
	
	public void save(Ling ling);	
		
	public void update(Ling ling);	
		
	public void delete(Ling ling);	
		
	public Ling getLing(Ling ling);	
		
	public Ling getLing(Long id);	
	/**	
	 * 获得Ling的分页列表	
	 * @param pageBean	
	 * @return	
	 */	
	public List<Ling> findPageInfoLing(Ling ling,PageBean pageBean);	
		
	public Integer getCount(Ling ling);	
		
	public List<Ling> findPageInfoLing1(Ling ling,PageBean pageBean);	
		
	public Integer getCount1(Ling ling);	
		
	public List<Ling> getAllLing() ;	
}	
