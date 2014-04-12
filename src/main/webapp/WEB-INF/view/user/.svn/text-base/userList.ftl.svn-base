<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>角色列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="userList,角色列表">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script>
		// 提示信息	
		$(function(){
			if("${message!}" != ""){
				alert("${message!}");
				if("${quicklyInput!}" != ""){					
					window.location.href = "${req.contextPath}/user/getUsersQuickly?currentPage=${currentPage}&quicklyInput=${quicklyInput}";
				}else{
					window.location.href = "${req.contextPath}/user/toUserPageList?currentPage=${currentPage}";
				}
			}
		
			
			$("#bn").click(function() {
					if($("#quicklyInput").val().length==0){
						alert("请输入用于检索的姓名或员工编号！");
					}else{
						$("#frm").submit();
					}
	   		});
	   		
	   		$("#mySubmit").click(function(){
			var ids = returnCheckValue("user_id");
				if(ids.length==0){
					alert("请勾选要删除的数据");
					return;
				}
				
				if(confirm("您确认要删除么？")){
					$("#myForm").submit();
				}
			});
		});
	</script>
  </head>

  <body>
				<a href="${req.contextPath}/user/toAddUser?currentPage=${toolPage.currentPage}&quicklyInput=${quicklyInput}">添加</a>
  	<center>
  	
  	<form action = "${req.contextPath}/user/getUsersQuickly" id = "frm" method = "post" >
  		<span>快速检索：</span><input type="text" title="真实姓名/员工编号" id="quicklyInput" name="quicklyInput" /><input type="button" value="检索" id="bn">
  	</form>
  		<form action="${req.contextPath}/user/deleteUsers" id="myForm" method="post" >
		  	<table border="1">
				<tr><td colspan="9" align="left">角色列表</td></tr>
				<tr>
				<td align="center"><input type="checkbox" id="chooseAll" name="chooseAll" onclick="selORcancel('chooseAll','user_id')"/></td>
				<td>流水号 </td>
				<td>用户名</td>
				<td>真实姓名</td>
				<td>邮箱</td>
				<td>所属中部</td>
				<td>所属角色</td>
				<td colspan="2">操作</td>
				</tr>
				
				<#if toolPage.dataList??>
					<#if (toolPage.dataList?size > 0)>
						<#list toolPage.dataList as user>
							<tr>
								<td align="center"><input type="checkbox" name="user_id" value="${user.user_id!}"/></td>
								<td>${(toolPage.currentPage-1)*toolPage.pageSize+user_index+1}</td>
								<td>${user.user_num}</td>
								<td>${user.user_realname}</td>
								<td>${user.user_mail}</td>
								<td>${user.user_department}</td>
								<td>
								
									<#if user.assignList?if_exists>
										<#list user.getAssignList() as child>
											${child.roleName}<#if child_has_next>、</#if>
										</#list>
									<#else>	
										暂无角色
									</#if>
								
								</td>
								<td><a href="${req.contextPath}/user/toUpdateUser?user_id=${user.user_id}&currentPage=${toolPage.currentPage}&quicklyInput=${quicklyInput}">编辑</a></td>
								<td><a href="${req.contextPath}/assign/toAssignRoles?user_id=${user.user_id}&currentPage=${toolPage.currentPage}&quicklyInput=${quicklyInput}">分配角色</td>
							</tr>
		  				</#list>
					</#if>
				</#if>
				
				<br/>
				
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="9" align="right">
		            		  			<input type="hidden" name="currentPage" value="${toolPage.currentPage}" />
		            		  			<input type="hidden" name="quicklyInput" value="${quicklyInput}" />
		            			<input type="button" value="删除" id="mySubmit"/>
		            			第${toolPage.currentPage}页
		            			共${toolPage.pageCount}页
								${toolPage.firstPage}
								${toolPage.precursorPage}
								${toolPage.nextPage}
								${toolPage.lastPage}
		            			${toolPage.currentPage}/${toolPage.pageCount}页
		            		</td>
						<#else>
						<td height="35" colspan="4" align="center">暂时没有数据</td>
						
					</#if>
				</tr>
        		
		  	</table>
  		</form>
  </center>
  </body>
</html>