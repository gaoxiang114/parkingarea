<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>角色列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="个人中心,预定书籍">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/personReader.js"></script>
	<script>

		// 提示信息			
		$(function(){
			if("${message}" != ""){
				alert("${message}");
				//window.location.href = "${req.contextPath}/order/getUserOrderList?currentPage="+${currentPage};
			}
		});
		
	</script>

  </head>

  <body>
  	<center>
  		<form action="${req.contextPath}/user/deleteUsers" id="myForm" method="post" >
		  	<table border="1">
				<tr>
				<#-------------------------------------------------------------修改---------------------------------------------------------------------------------------------->
  			<input type="hidden" name="basePath" id="basePath" value="${req.contextPath}" />
  			<input type="hidden" name="userId" id="userId" value="1" />
		  	<table border="1">
				<tr><td colspan="9" align="right">检索条件:<select id="personSelect" name="personSelect">
																<option value="0">在借</option>
																<option value="1">预定</option>
																<option value="2" selected="selected">已还</option>
														   </select></td></tr>
				<tr><td colspan="9" align="left">已还书籍</td></tr>
					<td>书名</td>
					<td>类别</td>
					<td>作者</td>
					<td>出版社</td>
					<td>借书时间</td>
					<td>归还时间</td>
					<td>超期</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				
				<#if toolPage.dataList??>
					<#if (toolPage.dataList?size > 0)>
						<#list toolPage.dataList as borrowedBook>
							<tr>
								<td>${borrowedBook.bookName}</td>
								<td>${borrowedBook.bookTypeName}</td>
								<td>${borrowedBook.bookAuthor}</td>
								<td>${borrowedBook.bookPublish}</td>
								<td>${borrowedBook.startTime?string("yyyy-MM-dd")}</td>
								<td>${borrowedBook.endTime?string("yyyy-MM-dd")}</td>
								<td>已借	</td>
								<td>
									<#if borrowedBook.overDue==0>
										否
									<#else>
										是
									</#if>
								</td>					
							</tr>
		  				</#list>
					</#if>
				</#if>
				
				<br/>
				
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="9" align="right">
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