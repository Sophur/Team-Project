<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="top">
	<!----------------页面头部开始-------------------->
	<div class="banner">

		<img src="images/top.jpg" />
	</div>
	<!----------------页面头部结束-------------------->
	<!----------------主导航菜单开始-------------------->
	<div id="nav" align="center">
		<ul>
			<li>
				<span>&nbsp;</span>
			</li>
			<li>
				<span>&nbsp;</span>
			</li>
			<li>
				<span></span>
			</li>
			<li>
				<span></span>
			</li>
			<li>
				<a href="index.jsp"><span>首页</span> </a>
			</li>
			<li>
				<a href="news!queryFrNews.action"><span>网站新闻</span> </a>
			</li>
			<li>
				<a href="xun!queryFrXun.action"><span>教员需求</span> </a>
			</li>
			<li>
				<a href="ling!queryFrLing.action"><span>学生需求</span> </a>
			</li>
			<li>
				<a href="message!queryMessageFr.action"><span>留言板</span> </a>
			</li>
			<li>
				<a href="lianxi.jsp"><span>联系我们</span> </a>
			</li>

			<li>
				<a href="login.jsp" target="_blank"><span>后台管理</span> </a>
			</li>
		</ul>
	</div>
	<!----------------主导航菜单结束-------------------->
</div>
<!----------------内容区开始-------------------->
<div class="login_con">
	<%
		com.vo.Userinfo user = (com.vo.Userinfo) session
				.getAttribute("user");
		System.out.println(user);
		if (user == null) {
	%>
	<form id="form1" name="form1" method="post"
		action="<%=path%>/userinfo!logon.action">
		<span>账号： <input type="text" name="userinfo.name" id="name"
				class="text_input" /> </span>
		<span>密码： <input type="password" name="userinfo.pwd" id="pwd"
				class="text_input" /> </span>
		<span> <input type="submit" name="button" id="button"
				value="登录" class="denlu" /> </span>
		<span><a href="<%=path%>/userinfo!regUserinfo.action"
			class="zc">注册</a> </span>

	</form>
	<%
		} else {
	%>
	<span>欢迎你：<%=user.getName()%>(<%=user.getType()%>)</span>
<% 
	   if(user.getType().equals("教员")){
	 %>
	<span><a href="<%=path%>/xunad.jsp" class="zc">发布教员需求</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	<%
	}else{
	 %>
	<a href="<%=path%>/lingad.jsp" class="zc">发布学生需求</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<%
	}
	 %>
	<a href="<%=path%>/register.jsp" class="zc">修改个人信息</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	
	<a href="<%=path%>/userinfo!logonOut.action" class="zc">注销</a> </span>
	<%
		}
	%>
</div>
<script type="">
function checkLogn() {
	var check = false;
<%if (user != null) {
				out.println("check=true");
			}%>
    if(!check){
      alert("请登录！");
    }
   return check;
}
</script>