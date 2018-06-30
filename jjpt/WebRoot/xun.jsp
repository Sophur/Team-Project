<%@ page language="java" import="java.util.*,java.sql.*,com.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教员需求</title>
		<link href="css1/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/tab.js">
</script>
	</head>

	<body>

		<div class="page">
			<div class="page_con">
				<jsp:include flush="true" page="/inc/top.jsp"></jsp:include>
				<!----------------内容区开始-------------------->
				
				<div class="sub_main">
					<div class="sub_maincon">
						<div class="sub_mainbox clearfix">
						<form name="form1" action="xun!queryFrXun.action" method="post">	
						标题：<input type="text" name="xun.title" value="${xun.title}"	
											clazz="box1" />	
							授课/(求教)年级：<s:select list="#request.kmlx" theme="simple"
													name="xun.style" cssClass="box1" listKey="key"
													listValue="value"></s:select>			
										<input type="submit"  type="button"	
											class="right-button02" value="查 询" />	
									</form>		
							<div class="m_title2">
							   
								<h3>
									教员需求
								</h3>
							</div>
							<div class="article_listbox">
								<ul>
									<%
									     List<Xun> list=(List<Xun>)request.getAttribute("xunList");
									     if(list!=null){
									     for(Xun xun:list){
									    
									    %>
									<li>
										<span class="time"><%=xun.getAddate()%>(<%=xun.getStyle()%>)</span><a href="xun!toLoadXun.action?id=<%=xun.getId()%>"
											><%=xun.getTitle()%></a>
									</li>
									 <%
										}}%>
								</ul>
							</div>
							 <div class="message_con">
							 
                </div>
						</div>
					</div>
				</div>
				<!----------------内容区结束-------------------->
				<!---------------页脚开始---------------->
				<div class="bottom">
					<p>
						版权所有
					</p>
				</div>
				<!---------------页脚结束---------------->
			</div>
		</div>
	</body>
</html>
