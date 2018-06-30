<%@include file="/common/sub_header.jsp"%>	
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>	
<form action="" method="post" enctype="multipart/form-data" name="form"	
	>	
	<div class="MainDiv">	
		<table width="99%" border="0" cellpadding="0" cellspacing="0"	
			class="CContent">	
			<tr>	
				<th class="tablestyle_title">	
					新闻管理	
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
										新闻管理	
									</legend>	
									<table border="0" cellpadding="2" cellspacing="1"	
										style="width: 100%">	
	
										<tr>	
											<td nowrap align="right" width="15%">	
												标题：	
											</td>	
											<td width="35%">	
												<input id="title" name="news.title" class="text"	
													style="width: 154px" value="" />	
													
											</td>	
											<td width="16%" align="right" nowrap="nowrap">	
												 
											</td>	
											<td width="34%">	
												 
											</td>	
										</tr>
										<tr>	
											<td nowrap align="right" width="15%">	
												内容：	
											</td>	
											<td width="35%" colspan="3">	
											 
												<textarea style="width: 600px; height: 250px; visibility: hidden;" name="news.info"></textarea>		
													
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
	editor.sync();
	document.forms[0].action = "<%=path%>/news!addNews.action";	
	document.forms[0].submit();	
	
}	

var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="news.info"]', {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
				'bold', 'italic', 'underline', 'removeformat', '|',
				'justifyleft', 'justifycenter', 'justifyright',
				'insertorderedlist', 'insertunorderedlist' ]
	});
});

 
</script>	
