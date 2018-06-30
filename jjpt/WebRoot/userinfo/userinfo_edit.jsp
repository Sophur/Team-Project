<%@include file="/common/sub_header.jsp"%>	
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>	
<form action="" method="post" enctype="multipart/form-data" name="form"	
	>	
	<input type="hidden" name="userinfo.id" value="${userinfo.id}" />	
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
												<input id="name" name="userinfo.name" class="text"
													style="width: 154px" value="${userinfo.name}" />

											</td>
											<td width="16%" align="right" nowrap="nowrap">
												密码:
											</td>
											<td width="34%">
												<input class="text" id="pwd" name="userinfo.pwd"
													style="width: 154px" value="${userinfo.pwd}">
											</td>
										</tr>
										<tr>
											<td nowrap align="right" width="15%">
												性别：
											</td>
											<td width="35%">
												<input id="sex" name="userinfo.sex" class="text"
													style="width: 154px" value="${userinfo.sex}" />

											</td>
											<td width="16%" align="right" nowrap="nowrap">
												年龄:
											</td>
											<td width="34%">
												<input class="text" id="age" name="userinfo.age"
													style="width: 154px" value="${userinfo.age}">
											</td>
										</tr>
										<tr>
											<td nowrap align="right" width="15%">
												电话：
											</td>
											<td width="35%">
												<input id="tel" name="userinfo.tel" class="text"
													style="width: 154px" value="${userinfo.tel}" />

											</td>
											<td width="16%" align="right" nowrap="nowrap">
												联系方式:
											</td>
											<td width="34%">
												<input class="text" id="address" name="userinfo.address"
													style="width: 154px" value="${userinfo.address}">
											</td>
										</tr>
										<tr>
											<td nowrap align="right" width="15%">
												邮箱：
											</td>
											<td width="35%">
												<input id="email" name="userinfo.email" class="text"
													style="width: 154px" value="${userinfo.email}" />

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
					<input type="button" name="Submit" value="保存" class="button"	
						onclick="save();" />	
	
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
<script>	
	
function save() {	
	if ($("#name").val() == "") {	
		$.messager.alert('警告', '用户名不能为空！', 'warning');	
		return;	
	}	
	if ($("#rname").val() == "") {	
		$.messager.alert('警告', '姓名不能为空！', 'warning');	
		return;	
	}	
	if ($("#password").val() == "") {	
		$.messager.alert('警告', '密码不能为空！', 'warning');	
		return;	
	}	
	document.forms[0].action = "<%=path%>/userinfo!editUserinfo.action";	
	document.forms[0].submit();	
	
}	
</script>	
