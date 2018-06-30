<%@ page language="java" import="java.util.*,java.sql.*,com.vo.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>

<%@ taglib uri="/tags/fmt" prefix="fmt"%>
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
		<title>大学生家教平台</title>

		<link href="css1/commons.css" rel="stylesheet" type="text/css">
		<link href="css1/style.css" rel="stylesheet" type="text/css" />

	</head>

	<body>

		<div class="page">
			<div class="page_con">
				<jsp:include flush="true" page="/inc/top.jsp"></jsp:include>
				
				<%
											   List<Xun> listXun = (List<Xun>) request.getAttribute("xunList");
											   
											 %>




				
				<div class="main">

					<div class="main_con">
						<div class="main_box clearfix">


							<div class="main_center">

								<div class="m_border">
									<div class="m_title2">
										<h3>
											网站新闻发布
										</h3>
									</div>
									<div class="m_content">

										<%
											List<News> list = (List<News>) request.getAttribute("newsList");
											for (News news : list) {
										%>
										<div class="leave_mes">
											<p class="mes_info">
												<span class="reply"><%=news.getDate()%> </span><span><a
													href="news!toLoadNews.action?id=<%=news.getId()%>"><%=news.getTitle()%></a>
												</span>
											</p>

										</div>

										<%
											}
										%>



									</div>
								</div>


								<div class="m_border">
									<div class="m_title2">
										<h3>
											教员需求
										</h3>
									</div>
									<div class="m_content">


										<%
											
											for (Xun xun : listXun) {
										%>
										<div class="leave_mes">
											<p class="mes_info">
												<span class="reply"><%=xun.getAddate()%> </span><span><a
													href="xun!toLoadXun.action?id=<%=xun.getId()%>"><%=xun.getTitle()%></a>
												</span>
											</p>

										</div>

										<%
											}
										%>



									</div>
								</div>
								
								<div class="m_border">
									<div class="m_title2">
										<h3>
											学员需求
										</h3>
									</div>
									<div class="m_content">


										<%
											List<Ling> listLing = (List<Ling>) request.getAttribute("lingList");
											for (Ling ling : listLing) {
										%>
										<div class="leave_mes">
											<p class="mes_info">
												<span class="reply"><%=ling.getAddate()%> </span><span><a
													href="ling!toLoadLing.action?id=<%=ling.getId()%>"><%=ling.getTitle()%></a>
												</span>
											</p>

										</div>

										<%
											}
										%>



									</div>
								</div>


								<div class="message_con">

								</div>
							</div>
						</div>


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
		<script>
<!--
var speed=10;
var tab=document.getElementById("Solutionsdemo");
var tab1=document.getElementById("Solutionsdemo1");
var tab2=document.getElementById("Solutionsdemo2");
tab2.innerHTML=tab1.innerHTML;
function Marquee(){
if(tab2.offsetWidth-tab.scrollLeft<=0)
tab.scrollLeft-=tab1.offsetWidth
else{
tab.scrollLeft++;
}
}
var MyMar=setInterval(Marquee,speed);
tab.onmouseover=function() {clearInterval(MyMar)};
tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
-->
									</script>
	</body>
</html>
