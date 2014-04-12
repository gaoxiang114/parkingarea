<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="userlist,用户列表">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>	
  </head>

  <body>

人员管理：<br />
  ${message}<br/>${toolPage.currentPage}
  <a href="${req.contextPath}/fun/toAddFun?currentPage=${toolPage.currentPage}">新增</a><br />
  <center>
  <#--
  <form action="${req.contextPath}/fun/delFun" method="post" >
  -->
  	<table border="1">
		<tr><td colspan="6">功能列表</td></tr>
		<tr>
			<#--
		<td><input name="chooseAll" id="chooseAll" type="checkbox" title="全选/全部选" onClick= "selORcancel('chooseAll','funId')"></td>
			<td>流水号 </td>
			-->
			<td>功能名称</td>
			<td>所属模块</td>
			<td>包含模块</td>
			<td>操作</td>
		</tr>	
		
		
		<#if toolPage.dataList??>
					<#if (toolPage.dataList?size > 0)>
						<#list toolPage.dataList as fun>
							<tr>
								<td>${fun.funName}</td>
								<td>${fun.fatherName}</td>
								<td><#if fun.fatherId ==1>
										普通用户功能
									<#else>
										系统功能
									</#if>
								</td>
								<td><a href="${req.contextPath}/fun/toUpdateFun?funId=${fun.funId}&currentPage=${currentPage}")>编辑</td>
							</tr>
		  				</#list>
					</#if>
				</#if>
				
				<br/>
				
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="9" align="right">
		            		  			<input type="hidden" name="currentPage" value="${toolPage.currentPage}" />
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
	  <#--
	  	<tr>
	  		<td clospan="6">
				<input type="submit" value="删除" onclick="return confirm('是否确认删除！')">	  				
	  		</td>
	  	</tr>
  -->
  	</table>
  <#--
  </form>
  -->

  </center>

  </body>
</html>