package com.service;	
	
import java.util.List;	
	
import com.common.PageBean;	
import com.dao.MessageDAO;	
import com.vo.Message;	
	
public class MessageServiceImpl implements MessageService {	
	private MessageDAO messageDAO;	
	
	public void save(Message message) {	
		messageDAO.save(message);	
	}	
	
	public void update(Message message) {	
		messageDAO.update(message);	
	}	
	
	public Message getMessage(Message message) {	
		return messageDAO.getMessage(message);	
	}	
	
	public Message getMessage(Long id) {	
		return messageDAO.getMessage(id);	
	}	
	
	public void delete(Message message) {	
		messageDAO.delete(message);	
	}	
	
	public List<Message> findPageInfoMessage(Message message, PageBean pageBean) {	
		return messageDAO.findPageInfoMessage(message, pageBean);	
	}	
	
	public Integer getCount(Message message) {	
		return messageDAO.getCount(message);	
	}	
	
	public void setMessageDAO(MessageDAO messageDAO) {	
		this.messageDAO = messageDAO;	
	}	
	
	public List<Message> findPageInfoMessage1(Message message, PageBean pageBean) {	
	
		return messageDAO.findPageInfoMessage1(message, pageBean);	
	}	
	
	public Integer getCount1(Message message) {	
	
		return messageDAO.getCount1(message);	
	}	
	
	public List<Message> getAllMessage() {	
	
		return messageDAO.getAllMessage();	
	}	
}	
