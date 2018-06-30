package com.service;	
import java.util.List;	
	
import com.common.PageBean;	
import com.vo.Message;	
	
public interface MessageService	
{	
    public void save(Message message);	
		
	public void update(Message message);	
		
	public void delete(Message message);	
		
	public Message getMessage(Message message);	
		
	public Message getMessage(Long id);	
	
	public List<Message> findPageInfoMessage(Message message,PageBean pageBean);	
		
	public Integer getCount(Message message);	
		
	public List<Message> findPageInfoMessage1(Message message,PageBean pageBean);	
		
	public Integer getCount1(Message message);	
		
	public List<Message> getAllMessage();	
}	
