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
	<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
		<script>

		// 提示信息			
		$(function(){
			if("${message!}" != ""){
				alert("${message}");
				//window.location.href = "${req.contextPath}/user/toUserPageList?currentPage=${currentPage}";
				if("${quicklyInput!}" != ""){					
					window.location.href = "${req.contextPath}/user/getUsersQuickly?currentPage=${currentPage}&quicklyInput=${quicklyInput}";
				}else{
					window.location.href = "${req.contextPath}/user/toUserPageList?currentPage=${currentPage}";
				}
			}
			
			var arr = ${data!};		
			var roleIds = document.getElementsByName("roleId");
			
			$.each(roleIds,function(i,item){
			     $.each(arr,function(j,data){
				     	if(item.value == data.roleId){
								item.checked="true";
						}
			     });	
			});
			
			//提交校验
			$("#bn").click(function() {
				if($('input:checkbox:checked').length==0){			
					alert("请分配角色！");
					return false;
				}else{
					if(confirm('是否确认?')) {
			 			 $("#frm").submit();
		  			}  	
				}
			});
			
			
		});
		
	</script>
  <body>
  <center>
	${message}
	<form action="${req.contextPath}/assign/updateAssignRoles" id="frm" method="post">
	<input type="hidden" name="user_id" value="${user.user_id}" />
	<input type="hidden" name="currentPage" value="${currentPage}" />
	<input type="hidden" name="quicklyInput" value="${quicklyInput}" />
		<table border ="1">
			<tr>
				<td colspan="4">分配角色</td>
			</tr>
			<tr>
				<td>角色编号</td>
				<td>角色名称</td>
				<td>角色描述</td>
				<td>分配角色</td>
			</tr>
				<#list roleList as role>
					<tr>
						<td>${role_index+1}</td>
						<td>${role.roleName}</td>
						<td></td>
						<td align="center"><input type="checkbox" name="roleId" id="roleId" value="${role.roleId}"></td>			
					</tr>
				</#list>
				</td>
			
			<tr>
			<td colspan="4"><center>
							<input type="button" id="bn" value="提交" />
							<input type="button" value="返回" onclick="history.go(-1)" />
			</center></td></tr></table>
		 
	</form>
	</center>
  </body>
</html>