<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>密码修改</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="update_userpwd">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${req.contextPath}/js/userpwd.js"></script>
		<script>

		// 提示信息			
		$(function(){
			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/user/toUserPageList";
			}
		});
		
	</script>
</head>

<body><center>
${message}
	<form action="updateUserPassword" method="post" id="frm">
	<table border="1">
		<tr>
			<td>原密码：</td>
			<td><input type="password" name="oldpwd" id="oldpwd" /></td>
			<td><span id="oldMsg">密码由5-15个字母和数字组成</span></td>
		</tr>
		<tr>
			<td>新密码：</td>
			<td><input type="password" name="newpwd" id="newpwd" /></td>
			<td><span id="newMsg">密码由5-15个字母和数字组成</span></td>
		</tr>
		<tr>
			<td>密码确认：</td>
			<td><input type="password" name="checkpwd" id="checkpwd" /></td>
			<td><span id="checkMsg">确认密码和新密码一致</span></td>
		</tr>
		<tr><td colspan="3">
			<input type="hidden" name="user_num" value="${user_num}" />
			<input type="button" value="提交" id="bn" />
			<input type="button" value="返回" onclick="history.go(-1)" />
		</td></tr>
	</table>
	</form></center>
</body>
</html>