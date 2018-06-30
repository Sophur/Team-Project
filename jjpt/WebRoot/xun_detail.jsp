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
		<title>${xun.title}</title>
		<link href="css1/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/tab.js">
</script>
	</head>

	<body>

		<div class="page">
			<div class="page_con">
				<jsp:include flush="true" page="inc/top.jsp"></jsp:include>
				<!----------------内容区开始-------------------->
				<div class="sub_main">
					<div class="sub_maincon">
						<div class="sub_mainbox clearfix">
							<!-------------左边开始------------->

							<!-------------左边结束------------->

							<div class="m_border">

								<div class="m_content">
									<div class="article_conbox">

										<h1 class="title">
											${xun.title}
										</h1>
										<div class="article_info">
											<span>发布时间：${xun.addate}</span>
										</div>
										<div class="article_con">
											<p>


												<table
													style="table-layout: fixed; margin-bottom: 5px; width: 704px; font-size: 11pt; background-position: 110px bottom;"
													cellpadding="0" cellspacing="0">
													<tr>
														<td style="width: 100px; height: 5px;"></td>
														<td style="width: 200px;"></td>
														<td style="width: 71px;"></td>
														<td style="width: 132px;"></td>
														<td style="width: 81px;"></td>
														<td
															style="width: 120px; color: red; font-weight: bold; font-size: 20px; font-style: italic; font-family: Microsoft Yahei, '微软雅黑', '宋体';"
															rowspan="2">

														</td>
													</tr>

													<tr>
														<td align="right" style="height: 240px;">
															<em>详细描述：</em>&nbsp;
														</td>
														<td colspan="4"
															style="word-wrap: break-word; width: 484px; line-height: 25px; background-color: #F2FCEB; padding: 5px 5px 5px 10px; word-break: break-all;"
															valign="top">
															${xun.info}
														 
															 
														</td>
														<td valign="top">

														</td>
													</tr>
													 
													<tr>
														<td align="right" style="height: 30px;">
															<em>联系人：</em>&nbsp;
														</td>
														<td>
															${xun.lianxiren}
														</td>
														<td align="right">
															<em>电话：</em>&nbsp;
														</td>
														<td>
															${xun.tel}
														</td>
													</tr>
													<tr>
														<td align="right" style="height: 30px;">
															<em>QQ：</em>${xun.qq}
														</td>
														<td></td>
														<td align="right">

														</td>
														<td></td>
													</tr>

													</tr>
												</table>

											</p>
										</div>
										<div class="article_info" align="center">

										</div>


									</div>
								</div>
							</div>




							<div class="m_border">

								<div class="m_content">
									<div class="article_conbox">

										<div class="article_info">
											<span>网友评论</span>
										</div>
										<div class="article_con">
											<p>
												<%
													List<Ping> listP = (List<Ping>) request.getAttribute("pingList");
													if (listP != null) {
														for (Ping ping : listP) {
												%>
												<div class="leave_mes">

													<div class="mes_con">

														评论人：<%=ping.getName()%>&nbsp;&nbsp;时间：<%=ping.getAdddate()%>
													</div>
													<p class="mes_info">
														<%=ping.getInfo()%>
													</p>
												</div>
												<%
													}
													}
												%>





											</p>
											<%
												com.vo.Userinfo user = (com.vo.Userinfo) session
														.getAttribute("user");
												System.out.println(user);
												if (user != null) {
											%>
											<form id="form2" name="form2" method="post"
												action="xun!addMsg.action">
												<h3>
													评论：
												</h3>
												<p>
													<input type="hidden" value="${xun.id}" name="id" />
													<textarea name="msg" id="msg" cols="30" rows="5"
														class="text_mes"></textarea>
												</p>
												<p class="btn_box">
													<input type="submit" name="button2" id="button2" value="保存"
														class="btn" />
												</p>
											</form>
											<%
												}
											%>
										</div>
										<div class="article_info" align="center">

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

	</body>
</html>
