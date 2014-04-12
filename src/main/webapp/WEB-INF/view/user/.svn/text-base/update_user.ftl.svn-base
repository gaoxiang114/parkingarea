<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人员添加</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="add_user,人员添加,用户管理">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/userupdate.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
		<script>

		// 提示信息			
		$(function(){
			if("${message!}" != ""){
				alert("${message}");
				if("${quicklyInput!}" != ""){					
					window.location.href = "${req.contextPath}/user/getUsersQuickly?currentPage=${currentPage}&quicklyInput=${quicklyInput}";
				}else{
					window.location.href = "${req.contextPath}/user/toUserPageList?currentPage=${currentPage}";
				}
			}
		});
		
	</script>
  <body>
  <center>
	${message}
	<form action="${req.contextPath}/user/updateUser" id="frm" method="post">
	<input type="hidden" name="user_id" value="${user.user_id}" />
	<input type="hidden" name="currentPage" value="${currentPage}" />
	<input type="hidden" name="quicklyInput" value="${quicklyInput}" />
		<table border ="1">
			<tr>
			<td>员工编号:</td>
			<td><input type="text" id="user_num" name="user_num" value="${user.user_num}"/></td>
			<td><span id="numMsg">正式员工或实习员工编号 . 如：CY1234</span></td></tr>
			<tr>
			<td>真实姓名：</td>
			<td><input type="text" id="user_realname" name="user_realname" value="${user.user_realname}" /></td>
			<td><span id="nameMsg">员工姓名为2-6中文字符</span></td></tr>
			<tr>
			<td>用户邮箱：</td>
			<td><input type="text" id="user_mail" name="user_mail" name = "user_mail" value="${user.user_mail}" />@cyou-inc.com</td>
			<td><span id="mailMsg">邮箱为以字母开头，长度为4-25个字符，包括字母和下划线</span></td></tr>
			<tr>
			<td>部门：</td>
			<td><select id="user_department" name="user_department">
			<#if user.user_department=="技术中部">
					<option value="技术中部" name="user_department" selected="selected">技术中部</option>
					<option value="策划中部" name="user_department" >策划中部</option>
					<option value="测试中部" name="user_department" >测试中部</option>
			</#if>
			<#if user.user_department=="策划中部">
					<option value="技术中部" name="user_department" >技术中部</option>
					<option value="策划中部" name="user_department" selected="selected">策划中部</option>
					<option value="测试中部" name="user_department" >测试中部</option>
			</#if>
			<#if user.user_department=="测试中部">
					<option value="技术中部" name="user_department" >技术中部</option>
					<option value="策划中部" name="user_department" >策划中部</option>
					<option value="测试中部" name="user_department" selected="selected">测试中部</option>
			</#if>
				</select></td>
			<td><span id="deptMsg"></span></td>
			</tr>

			<tr>
			<td colspan="3"><center>
							<input type="button" id="bn" value="提交" />
							<input type="button" value="返回" onclick="history.go(-1)" />
			</center></td></tr></table>
		 
	</form>
	</center>
  </body>
</html>