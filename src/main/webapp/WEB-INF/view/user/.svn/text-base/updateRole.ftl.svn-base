<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/role.js"></script>
	<script>
		// 提示信息
		$(function(){
				if("${message!}" != ""){
					alert("${message}");
					window.location.href = "${req.contextPath}/role/toRolePageList?currentPage="+${currentPage};
				}
		});
		
	</script>
	</head>
	
	<body>
		<form id="myForm" name="myForm" method="post" action="${req.contextPath}/role/doUpdateRole">
			<input type="hidden" name="roleId" value="${role.roleId}"/>
			<input type="hidden" name="currentPage" value="${currentPage}"/>
			<table align="center">
				<tr>
					<td>角色名称：</td>
					<td><input type="text" id="roleName" name="roleName" maxLength="20" value="${role.roleName}"/><span id="msg1"></span></td>
				</tr>
				
				<tr>
					<td>角色描述：</td>
					<td>
						<textarea id="roleDesc" name="roleDesc" cols="50" rows="10">${role.roleDesc!}</textarea>
					</td>
				</tr>
				<tr align="center">
					<td><input type="button" id="bn" value="修改角色" /></td>
					<td><input type = "button" onclick="history.go(-1)" value="返回" /></td>
				</tr>
			</table>
		</form>
	</body>
	