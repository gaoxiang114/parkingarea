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
			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/order/getUserOrderList?currentPage="+${currentPage};
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
																<option value="1" selected="selected">预定</option>
																<option value="2">已还</option>
														   </select></td></tr>
				<tr><td colspan="9" align="left">预定书籍</td></tr>
					<td>书名</td>
					<td>类别</td>
					<td>作者</td>
					<td>出版社</td>
					<td>预定时间</td>
					<td>是否可借</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				
				<#if toolPage.dataList??>
					<#if (toolPage.dataList?size > 0)>
						<#list toolPage.dataList as order>
							<tr>
								<td>${order.bookName}</td>
								<td>${order.bookType}</td>
								<td>${order.bookAuthor}</td>
								<td>${order.bookPublish}</td>
								<td>${order.orderTime}</td>
								<td>
									<#if order.bookCheckFlag==0>
										在架
									<#else>
										不在架
									</#if>
								</td>
								<td>
									<#if order.bookIsOrder==0>
										尚未预定
									<#else>
										预定中
									</#if>
								</td>
								<#--------------------------------------------后期修改--------------------------------------------------------------->
								<td><a href="${req.contextPath}/order/deleOrder?currentPage=${toolPage.currentPage}&id=${order.id}&userId=1&orderId=${order.orderId}">取消预订</td>
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