<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>联系我们</title>
		<link href="css1/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/tab.js">
</script>

		<script type="">

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


							<div class="m_border">
								<div class="m_title2">
									<h3>
										联系我们
									</h3>
								</div>
								<div class="m_content message_con">
									

<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 电&nbsp; 话：15399080773<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; QQ 群：200108739<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; E-mail：service@jjpt.com<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 微信号：jjpt_com</p>

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
	</body>
</html>
