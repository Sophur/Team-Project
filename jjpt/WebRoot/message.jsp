<%@ page language="java" import="java.util.*,java.sql.*,com.vo.*"
	pageEncoding="UTF-8"%>
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
		<title>留言</title>
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
							<div class="m_title2">
								<h3>
									留言
								</h3>
							</div>
							<div class="message_con">
								<%
      Object user= session.getAttribute("user");
      System.out.println(user);
      if(user!=null){
     %>
								<form id="form2" name="form2" method="post"
									action="message!addMessageFr.action">
									<h3>
										留言：
									</h3>
									<p>
										<textarea name="info" id="info" cols="30" rows="5"
											class="text_mes"></textarea>
									</p>
									<p class="btn_box">
										<input type="submit" name="button2" id="button2" value="保存"
											class="btn" />
									</p>
								</form>
								<%} %>
							</div>
							<div class="m_content">

								<% List<Message> list=(List<Message>)request.getAttribute("msgList");
									    if(list!=null){
									     for(Message msg:list){
									%>
								<div class="leave_mes">

									<div class="mes_con">
										<%=msg.getMsg() %>
										<br />
										<font color="blue">回复：<%=msg.getReply()%></font>
										<br />
										<font color="blue">回复时间：<%=msg.getReplydate()%></font>
									</div>
									<p class="mes_info">
										<span class="reply"> </span><span>留言人：<%=msg.getAppuser()%></span><span>时间：<%=msg.getDate() %></span>
									</p>
								</div>

								<%
									}}
									%>


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
