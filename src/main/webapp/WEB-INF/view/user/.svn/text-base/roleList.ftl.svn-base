<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>角色列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="roleList,角色列表">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script>
	
		function mySubmit(){
			
			var ids = returnCheckValue("roleId");
			if(ids.length==0){
				alert("请勾选要删除的数据");
				return;
			}
			
			if(confirm("您确认要删除么？")){
				document.getElementById("myForm").submit();
			}
		}
	</script>
	
	<style>
	
		table td {font-size: 14px; width: 80px; text-overflow:ellipsis; overflow: hidden; white-space: nowrap;}
		table{border-collapse:collapse; table-layout: fixed; width:80%;}
	</style>
  </head>

  <body>
  	<center>
  		<form action="${req.contextPath}/role/doDelRole" id="myForm" method="post" >
  			<input type="hidden" name="currentPage" value="${toolPage.currentPage}" />
		  	<table border="1">
				<tr><td colspan="5" align="center">角色列表</td></tr>
				<tr><td colspan="5" align="left"><a href="${req.contextPath}/role/toAddRole">添加角色</a></td></tr>
				<tr>
					<td align="center"><input type="checkbox" id="chooseAll" name="chooseAll" onclick="selORcancel('chooseAll','roleId')"/></td>
					<td>序号</td>
					<td>角色名称</td>
					<td>角色描述</td>
					<td>操作</td>
				</tr>
				
				<#if toolPage.dataList??>
					<#if (toolPage.dataList?size > 0)>
						<#list toolPage.dataList as role>
							<tr>
								<td align="center"><input type="checkbox" name="roleId" value="${role.roleId!}"/></td>
								<td align="center">${(toolPage.currentPage-1)*toolPage.pageSize+role_index+1}</td>
								<td>${role.roleName!}</td>
								<td>${role.roleDesc!}</td>
								<td align="center">
									<a href="${req.contextPath}/role/toUpdateRolePage?roleId=${role.roleId!}&currentPage=${toolPage.currentPage}">修改</a>
                                    <a href="${req.contextPath}/division/toDivisionPower?roleId=${role.roleId!}&currentPage=${toolPage.currentPage}">分配权限</a>
								</td>
							</tr>
		  				</#list>
					</#if>
				</#if>
				
				<br/>
				
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="5" align="right">
		            			<input type="button" value="删除" onclick="mySubmit()"/>
		            			第${toolPage.currentPage}页
		            			共${toolPage.pageCount}页
								${toolPage.firstPage}
								${toolPage.precursorPage}
								${toolPage.nextPage}
								${toolPage.lastPage}
		            			${toolPage.currentPage}/${toolPage.pageCount}页
		            		</td>
						<#else>
						<td height="35" colspan="5" align="center">暂时没有数据</td>
						
					</#if>
				</tr>
        		
		  	</table>
  		</form>
  </center>
  </body>
</html>