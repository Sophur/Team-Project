package com.dao;
import com.common.PageBean;
import com.vo.Loginuser;

import java.util.List;

public interface LoginuserDAO
{

	public void save(Loginuser loginuser);
	
	public void update(Loginuser loginuser);
	
	public void delete(Loginuser loginuser);
	
	public Loginuser getLoginuser(Loginuser loginuser);
	
	public Loginuser getLoginuser(Long id);
	/**
	 * 获得Loginuser的分页列表
	 * @param pageBean
	 * @return
	 */
	public List<Loginuser> findPageInfoLoginuser(Loginuser loginuser,PageBean pageBean);
	
	public Integer getCount(Loginuser loginuser);
	
	public List<Loginuser> findPageInfoLoginuser1(Loginuser loginuser,PageBean pageBean);
	
	public Integer getCount1(Loginuser loginuser);
}
