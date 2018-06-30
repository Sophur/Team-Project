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
		<title>学生需求发布</title>
		<link href="css1/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/tab.js">
</script>
		<LINK
			href="<%=path%>/js/jquery/plugin/jquery-easyui/themes/default/easyui.css"
			type="text/css" rel="stylesheet">
		<LINK href="<%=path%>/js/jquery/plugin/jquery-easyui/themes/icon.css"
			type="text/css" rel="stylesheet">

		<script type="text/javascript"
			src="<%=path%>/js/jquery/jquery-1.4.2.min.js">
		</script>
		<script type="text/javascript" src="<%=path%>/js/xiehui.js">
		</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery/plugin/jquery-easyui/jquery.easyui.min.js">
		</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery/plugin/jquery-easyui/locale/easyui-lang-zh_CN.js">
		</script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery/plugin/jquery-easyui/plugins/jquery.window.js">
		</script>
		
		<script charset="utf-8" src="<%=path%>/kindeditor/kindeditor-min.js">
</script>
		<script charset="utf-8" src="<%=path%>/kindeditor/lang/zh_CN.js">
</script>
<script type="text/javascript" src="<%=path%>/js/calendar/WdatePicker.js"></script>
		<script type="">
function phonecheck(s) {
	var str = s;

	if (!(/^1[3|5][0-9]\d{4,8}$/.test(s))) {

		alert("您的电话输入不正确");
		return false;
	} else {

		return true;
	}
}
</script>
<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
		 <script type="text/javascript">
		  function up()
		    {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
	            //另一红上传方式可以参照进销存
		    }
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
										学生需求发布
									</h3>
								</div>
								<div class="m_content message_con">
									<form id="form1" name="form1" method="post"
										action="<%=path%>/ling!addLingFr.action"
										>
										<p class="tips">
											<input type="hidden" id="messageInfo"
												value="${requestScope.messageInfo}" />
											<b>注：</b>带
											<span class="red">*</span>号为必填项
										</p>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>	
											<td nowrap align="right" width="15%">	
												标题：	
											</td>	
											<td width="35%">	
												<input id="title" name="ling.title" class="text"	
													style="width: 200px" value="" />	
													
											</td>	
											
										</tr>	
										<tr>	
											<td nowrap align="right" width="15%">	
												描述：	
											</td>	
											<td width="35%">	
												
												<textarea style="width: 600px; height: 250px; visibility: hidden;" name="ling.info"></textarea>			
													
											</td>	
											
										</tr>	
										  
										<tr>	
											<td nowrap align="right" width="15%">	
												联系人：	
											</td>	
											<td width="35%">	
												<input id="lianxiren" name="ling.lianxiren" class="text"	
													style="width: 154px" value="" />	
													
											</td>	
											
										</tr>	
										<tr>	
											<td nowrap align="right" width="15%">	
												联系电话：	
											</td>	
											<td width="35%">	
												<input id="tel" name="ling.tel" class="text"	
													style="width: 154px" value="" />	
													
											</td>	
											
										</tr>	
										<tr>	
											<td nowrap align="right" width="15%">	
												QQ：	
											</td>	
											<td width="35%">	
												<input id="qq" name="ling.qq" class="text"	
													style="width: 154px" value="" />	
													
											</td>	
											
										</tr>	
									 
										



											<tr>
												<td>
													&nbsp;
												</td>
												<td>
													<input type="image" name="button" id="button"
														src="images/ok.gif" />
												</td>
											</tr>
										</table>
									</form>
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
<script>

$(document).ready(function() {
	var $messageInfo = $("#messageInfo").val();
	if ($messageInfo != null && $messageInfo != "") {
		$.messager.show( {
			title : '提示',
			msg : $messageInfo,
			timeout : 2000,
			showType : 'slide'
		});
		$("#messageInfo").val("");
	}
});

var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="ling.info"]', {
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
