<%@include file="/common/sub_header.jsp"%>	
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>	
<form action="" method="post" enctype="multipart/form-data" name="form"	
	>	
	<input type="hidden" name="loginuser.id" value="${loginuser.id}" />	
	<div class="MainDiv">	
		<table width="99%" border="0" cellpadding="0" cellspacing="0"	
			class="CContent">	
			<tr>	
				<th class="tablestyle_title">	
					会员管理	
				</th>	
			</tr>	
			<tr>	
				<td class="CPanel">	
	
					<table border="0" cellpadding="0" cellspacing="0"	
						style="width: 100%">	
						<tr>	
							<td align="left">	
	
							</td>	
						</tr>	
						<TR>	
							<TD width="100%">	
								<fieldset style="height: 100%;">	
									<legend>	
										会员管理	
									</legend>	
									<table border="0" cellpadding="2" cellspacing="1"	
										style="width: 100%">	
	
										
										<tr>
											<td nowrap align="right" width="15%">
												登录名：
											</td>
											<td width="35%">
												${userinfo.name}

											</td>
											<td width="16%" align="right" nowrap="nowrap">
												密码:
											</td>
											<td width="34%">
											${userinfo.pwd}
											</td>
										</tr>
										<tr>
											<td nowrap align="right" width="15%">
												性别：
											</td>
											<td width="35%">
												${userinfo.sex}

											</td>
											<td width="16%" align="right" nowrap="nowrap">
												年龄:
											</td>
											<td width="34%">
												${userinfo.age}
											</td>
										</tr>
										<tr>
											<td nowrap align="right" width="15%">
												电话：
											</td>
											<td width="35%">
												${userinfo.tel}

											</td>
											<td width="16%" align="right" nowrap="nowrap">
												联系方式:
											</td>
											<td width="34%">
												${userinfo.address}
											</td>
										</tr>
										<tr>
											<td nowrap align="right" width="15%">
												邮箱：
											</td>
											<td width="35%">
												${userinfo.email}

											</td>
											<td width="16%" align="right" nowrap="nowrap">

											</td>
											<td width="34%">

											</td>
										</tr>
	
	
	
									</table>	
									<br />	
								</fieldset>	
							</TD>	
	
						</TR>	
	
	
	
	
	
					</TABLE>	
	
	
				</td>	
			</tr>	
	
	
	
	
	
			<TR>	
				<TD colspan="2" align="center" height="50px">	
						
	
					<input type="button" name="Submit2" value="返回" class="button"	
						onclick="window.history.go(-1);" />	
				</TD>	
			</TR>	
		</TABLE>	
	
	
		</td>	
		</tr>	
	
	
	
		</table>	
	
	</div>	
</form>	
</body>	
</html>	
	
	
