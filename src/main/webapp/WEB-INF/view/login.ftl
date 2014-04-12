<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<script>
	</script>
	
	
	</head>
	<body>
		<form id="myForm" name="myForm" method="post" action="${req.contextPath}/user/login">
			<table align="center" >
				<tr><td>登录页面</td></tr>
				<tr>
					<td>用户名：：</td>
					<td><input type="text" id="user_num" name="user_num" maxLength="20"/><span id="msg1"></span></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="text" id="user_password" name="user_password" maxLength="20"/><span id="msg1"></span></td>
				</tr>
				<tr align="center">
					<td><input type="submit" id="bn" value="添加" /></td>
					<td><input type = "button" onclick="history.go(-1)" value="返回" /></td>
				</tr>
			</table>
		</form>
	</body>
	