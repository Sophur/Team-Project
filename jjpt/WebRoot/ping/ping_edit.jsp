<%@include file="/common/sub_header.jsp"%>	
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>	
<form action="" method="post" enctype="multipart/form-data" name="form"	
	>	
	<input type="hidden" name="ping.id" value="${ping.id}" />	
	<div class="MainDiv">	
		<table width="99%" border="0" cellpadding="0" cellspacing="0"	
			class="CContent">	
			<tr>	
				<th class="tablestyle_title">	
					评论管理	
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
										评论管理	
									</legend>	
									<table border="0" cellpadding="2" cellspacing="1"	
										style="width: 100%">	
	
										<tr>	
											<td nowrap align="right" width="15%">	
												名称：	
											</td>	
											<td width="35%">	
												<input id="name" name="ping.name" class="text"	
													style="width: 154px" value="${ping.name}" />	
													
											</td>	
											<td width="16%" align="right" nowrap="nowrap">	
												备注:	
											</td>	
											<td width="34%">	
												<input class="text" id="beizhu"	
													name="ping.beizhu" style="width: 154px" value="${ping.beizhu}">	
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
	document.forms[0].action = "<%=path%>/ping!editPing.action";	
	document.forms[0].submit();	
	
}	
</script>	
