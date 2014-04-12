<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加用户</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="addUser,添加用户">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${req.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${req.contextPath}/js/user.js"></script>
<script>

		// 提示信息			
		$(function(){
			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/user/toUserPageList?currentPage=${currentPage}";
			}
		});
		
	</script>


</head>

<body><center>
	${message}
	<form action="${req.contextPath}/user/add" method="post" id="frm">
		<input type="hidden" name="quicklyInput" value="${quicklyInput}" />
		<table border ="1">
			<tr>
			<td>员工编号:</td>
			<td><input id="user_num" type="text" name="user_num" /></td>
			<td><span id="numMsg">正式员工或实习员工编号 . 如：CY1234</span></td></tr>
			<tr>
			<td>真实姓名：</td>
			<td><input id="user_realname" type="text" name="user_realname" /></td>
			<td><span id="nameMsg">员工姓名为2-4中文字符</span></td></tr>
			<tr>
			<td>用户邮箱：</td>
			<td><input id="user_mail" type="text" name = "user_mail" />@cyou-inc.com</td>
			<td><span id="mailMsg">邮箱为以字母开头，长度为4-25个字符，包括字母和下划线></span></td></tr>
			<tr>
			<td>部门：</td>
			<td><select id="user_department" name="user_department">
					<option value="技术中部">技术中部</option>
					<option value="策划中部">策划中部</option>
					<option value="测试">测试中部</option>
				</select></td>
			<td><span id="deptMsg"></span></td>
			</tr>
			<tr>
			<td colspan="3"><center>
								<input type="button"  value="提交" id="bn" />
								<input type="button" value="返回" onclick="history.go(-1)" />
			</center></td></tr></table>
		 
	</form>
	</center>
	
</body>
</html>