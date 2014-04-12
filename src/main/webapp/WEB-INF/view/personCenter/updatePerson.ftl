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
<link rel="stylesheet" href="${req.contextPath}/dialog/themes/base/jquery.ui.all.css">
<link rel="stylesheet" href="${req.contextPath}/dialog/css/demos.css">

<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript"  src="${req.contextPath}/js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="${req.contextPath}/js/personMessage.js"></script>
<script type="text/javascript" src="${req.contextPath}/js/userpwd.js"></script>
<script type="text/javascript"  src="${req.contextPath}/js/json.js" type="text/javascript"></script>

<script type="text/javascript" src="${req.contextPath}/dialog/external/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.button.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.position.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.effect.js"></script>

<script  type="text/javascript">

	// 提示信息			
	$(function(){
		if("${message!}" != ""){
			alert("${message}");
		}
	});
		
</script>

<style type="text/css" media="all">
		body { font-size: 100%; font-family: "宋体"}
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		div#users-contain { width: 700px; margin: 20px 0; }
		div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
		div#users-contain table td, div#users-contain table th { border: 1px solid #eee;   padding: .6em 10px; text-align: left; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips { border: 1px solid transparent; padding: 0.3em; }
		
		table td {font-size: 14px; width: 80px; text-overflow:ellipsis; overflow: hidden; white-space: nowrap;}
		table{border-collapse:collapse; table-layout: fixed; width:80%;}
		.big {width:700px;}
	</style>
</head>

<body><center>
	${message}
	<form action="${req.contextPath}/user/updatePerson" method="post" id="frm1">
			<input type="hidden" name="user_id" id="user_id" value="${user.user_id}" />
			<input type="hidden" id="basePath" name="basePath" value="${req.contextPath}"/>
			<input type="hidden" id="message" name="basePath" value="${message}"/>
		<#if user?if_exists>
		<table border ="1">
			<tr>
			<td>员工编号:</td>
			<td>${user.user_num}</td>
			<td></td>
			</tr>
			<tr>
			<td>真实姓名：</td>
			<td>${user.user_realname}</td>
			<td></td>
			</tr>
			<tr>
			<td>所属角色：</td>
			<td>
			<#if user.assignList?if_exists>
				<#list user.getAssignList() as role>
					${role.roleName}<#if role_has_next>、</#if>			
				</#list>
			<#else>
				暂未分配角色
			</#if>
			</td>
			<td></td>
			</tr>
			<tr>
			<td>部门：</td>
			<td>${user.user_department}</td>
			<td></td>
			</tr>
			<tr>
			<td>用户邮箱：</td>
			<td><input id="user_mail" type="text" name = "user_mail" value="${user.user_mail}" />@cyou-inc.com</td>
			<td><span id="mailMsg">邮箱为以字母开头，长度为4-25个字符，包括字母和下划线</span></td>
			</tr>
			<tr>
				<td>登陆密码：</td>
				<td><input type="button" id="income" value="更改"></td>
				<td></td>
					
			</tr>
			<td colspan="3"><center>
								<input type="button"  value="提交" id="butn" />
								<input type="button" value="返回" onclick="history.go(-1)" />
			</center></td></tr>
			
			
			
			</table>
			
				<div id="dialog-form" title="修改密码">
				<div id="users-contain" class="ui-widget">
					<h1>修改密码：</h1>
					<table id="userpwd" width="800">
						<tbody>
							<tr>
								<td>原密码：</td>
								<td><input type="password" name="oldpwd" id="oldpwd" /></td>
								<td><span id="oldMsg">密码由6-15个字母和数字组成</span></td>
							</tr>
							<tr>
								<td>新密码：</td>
								<td><input type="password" name="newpwd" id="newpwd" /></td>
								<td><span id="newMsg">密码由6-15个字母和数字组成</span></td>
							</tr>
							<tr>
								<td>密码确认：</td>
								<td><input type="password" name="checkpwd" id="checkpwd" /></td>
								<td><span id="checkMsg">确认密码和新密码一致</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
	</form>
		 <#else>
		 	异常，查无数据
		 </#if>
	</center>
	
</body>
</html>