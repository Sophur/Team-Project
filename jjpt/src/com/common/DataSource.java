package com.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataSource {
	 
	
	
	//用户类型
	public static Map<String,String>  YHLX = new LinkedHashMap<String,String>();
	
	 
	
	//性别
	public static Map<String,String>  XB  = new LinkedHashMap<String,String>();
	
	public static Map<String,String>  STYLE  = new LinkedHashMap<String,String>();

	 
	
	
	
	static{
		
		
	 
		
		
		YHLX.put("管理员","管理员");
		YHLX.put("普通用户","普通用户");
		
		XB.put("教员","教员");
		XB.put("学生","学生");
		
		STYLE.put("小学","小学");
		STYLE.put("初中","初中");
		STYLE.put("高中","高中");
	
		
		 
		 
		
		
		
	}
}
