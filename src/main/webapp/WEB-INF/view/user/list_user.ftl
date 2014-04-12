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
  <a href="${req.contextPath}/user/addUser">新增</a><br />
  <center>
  <form action ="${req.contextPath}/user/getUsersQuickly" ,method="post">
  				<table>
  					<tr>
  					<td><快速检索></td>
  					<td><select id="seletetype" name="seletetype">
						<option value="1" id="seletetype" name="seletetype">员工编号</option>
						<option value="2" id="seletetype" name="seletetype">所属部门</option>
					</select></td>
					<td>
						<input type="text" name="selectcontent" id="selectcontent" />
					</td>
					<td><input type="submit" value="检索" ></td>
				</tr>
  				</table>
  	
  </form>
  <form action="${req.contextPath}/user/deleteUsers" method="post" >
  	<table border="1">
		<tr><td colspan="9">用户列表</td></tr>
		<tr><td align="center"><input name="chooseAll" id="chooseAll" type="checkbox" title="全选/全部选" onClick= "selORcancel('chooseAll','user_id')"></td>
			<td>流水号 </td>
			<td>用户名</td>
			<td>真实姓名</td>
			<td>邮箱</td>
			<td>所属中部</td>
			<td>所属角色</td>
			<td colspan="2">操作</td>
		</tr>		
		<#if page!=null>
			<#list page.list as user>
			<tr>
				<td><input name="user_id" id="user_id" type="checkbox" value="${user.user_id}" /></td>
				<td>${(page.pagenum-1)*page.pagesize+user_index+1}</td>
				<td>${user.user_num}</td>
				<td>${user.user_realname}</td>
				<td>${user.user_mail}</td>
				<td>${user.user_department}</td>
				<td>xx</td>
				<td><a href="${req.contextPath}/user/toUpdateUser?user_id=${user.user_id}&pagenum=${page.pagenum}">编辑</a></td>
				<td><a href="#">分配权限</td>
				</tr>
	  		</#list>
  		
		<!--分页码-->
  		<tr>
  			<td colspan="9">
				<a href="${req.contextPath}/user/getPageUserList?pagenum=1">首页</a>
				<#if (page.pagenum &gt; 1)>
					<a href="${req.contextPath}/user/getPageUserList?pagenum=${page.pagenum-1}" >上一页</a>
				</#if>
				<#list page.pagination as sizeEach>
					<#if sizeEach!=page.pagenum>
						<a href="${req.contextPath}/user/getPageUserList?pagenum=${sizeEach}">${sizeEach}</a>
					</#if>
					<#if sizeEach==page.pagenum>
						【<a href="${req.contextPath}/user/getPageUserList?pagenum=${sizeEach}">${sizeEach}</a>】
					</#if>
				</#list>
				<#if page.pagenum &lt; page.totalpage >
					<a href="${req.contextPath}/user/getPageUserList?pagenum=${page.pagenum+1}">下一页</a>
				</#if>
				<a href="${req.contextPath}/user/getPageUserList?pagenum=${page.totalpage}">尾页</a>
  		</td>
  		</tr>
	<#else>
			<tr>
				<td colspan="9"><center>
				暂无数据</center>
			</td>
			</tr>
	</#if>
<tr>
<td colspan="9">
  <input type="submit" value="删除" onclick="return confirm('是否确认删除！')">
</td>
</tr>
  	</table>
  </form>
  </center>
  </body>
</html>