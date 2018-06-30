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
					寻物管理	
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
										寻物管理	
									</legend>	
									<table border="0" cellpadding="2" cellspacing="1"	
										style="width: 100%">	
	
										<tr>	
											<td nowrap align="right" width="15%">	
												标题：	
											</td>	
											<td width="35%">	
												 ${xun.title} 
													
											</td>	
											
										</tr>	
										<tr>	
											<td nowrap align="right" width="15%">	
												描述：	
											</td>	
											<td width="35%">	
												${xun.title} 		
													
											</td>	
											
										</tr>	
										 
										<tr>	
											<td nowrap align="right" width="15%">	
												联系人：	
											</td>	
											<td width="35%">	
												${xun.lianxiren}
													
											</td>	
											
										</tr>	
										<tr>	
											<td nowrap align="right" width="15%">	
												联系电话：	
											</td>	
											<td width="35%">	
												${xun.tel} 
													
											</td>	
											
										</tr>	
										<tr>	
											<td nowrap align="right" width="15%">	
												QQ：	
											</td>	
											<td width="35%">	
												${xun.qq}
													
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
	
	
