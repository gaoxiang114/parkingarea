<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/mail.js"></script>
	<script>

		// 提示信息			
		$(function(){
			if("${message!}" != ""){
				alert("${message!}");
				window.location.href="${req.contextPath}/mail/toMailList";
			}
		});
		
	</script>
	
	
	</head>
	<body>
		<form id="myForm" name="myForm" method="post" action="${req.contextPath}/mail/doUpdateMail">
			<input type="hidden" name="mailId" value="${mail.mailId}"/>
			<table align="center">
				<tr><td>邮件预设信息修改页面</td></tr>
				
				<tr>
					<td>主题：</td>
					<td><input type="text" id="mailTitle" name="mailTitle" value="${mail.mailTitle}" maxLength="20"/><span id="msg1"></span></td>
				</tr>
				
				<tr>
					<td>提醒内容设定：</td>
					<td><input type="text" id="mailContent" name="mailContent" value="${mail.mailContent}" maxLength="20"/><span id="msg2"></span></td>
				</tr>
				<tr align="center">
					<td><input type="button" id="bn" value="修改" /></td>
					<td><input type = "button" onclick="history.go(-1)" value="返回" /></td>
				</tr>
			</table>
		</form>
	</body>
	