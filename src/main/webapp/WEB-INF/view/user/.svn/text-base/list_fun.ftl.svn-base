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
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>	
  </head>

  <body>

人员管理：<br />
  ${message}<br/>
  <a href="${req.contextPath}/fun/toAddFun">新增</a><br />
  <center>
  <#--
  <form action="${req.contextPath}/fun/delFun" method="post" >
  -->
  	<table border="1">
		<tr><td colspan="6">功能列表</td></tr>
		<tr><td><input name="chooseAll" id="chooseAll" type="checkbox" title="全选/全部选" onClick= "selORcancel('chooseAll','fun_id')"></td>
			<td>流水号 </td>
			<td>功能名称</td>
			<td>所属模块</td>
			<td>包含模块</td>
			<td>操作</td>
		</tr>		
		<#if page?if_exists>
			<#list page as fun>
					<#if fun.list?if_exists>
						<#list fun.getList() as child>
			<tr>
				<td><input name="fun_id" id="fun_id" type="checkbox" /></td>
				<td>${child_index+1}</td>
				<td>
							${child.fun_name}&nbsp;&nbsp;
				
				</td>
				<td>${fun.fun_fathername}</td>
				<td>${fun.fun_name}</td>
				<td><a href="${req.contextPath}/fun/toUpdateFun?fun_id=${child.fun_id}")>编辑</td>
			</tr>
						</#list>
						</#if>
	  		</#list>
	  	<#else>
	  		<tr>
	  			<td colspan="6">
					对不起，系统暂无二级功能数据，请添加！	  				
	  			</td>
	  		</tr>
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