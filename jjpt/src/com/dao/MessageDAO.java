package com.dao;	
import com.common.PageBean;	
import com.vo.Message;	
	
import java.util.List;	
	
public interface MessageDAO	
{	
	
	public void save(Message message);	
		
	public void update(Message message);	
		
	public void delete(Message message);	
		
	public Message getMessage(Message message);	
		
	public Message getMessage(Long id);	
	/**	
	 * 获得Message的分页列表	
	 * @param pageBean	
	 * @return	
	 */	
	public List<Message> findPageInfoMessage(Message message,PageBean pageBean);	
		
	public Integer getCount(Message message);	
		
	public List<Message> findPageInfoMessage1(Message message,PageBean pageBean);	
		
	public Integer getCount1(Message message);	
		
	public List<Message> getAllMessage() ;	
}	
