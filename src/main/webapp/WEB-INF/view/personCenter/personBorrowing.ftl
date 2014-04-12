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
				alert("${message!}");
			}
		});
		
	</script>

  </head>

  <body>
  	<center>
  		<form action="${req.contextPath}/user/deleteUsers" id="myForm" method="post" >
  		<#-------------------------------------------------------------修改---------------------------------------------------------------------------------------------->
  			<input type="hidden" name="basePath" id="basePath" value="${req.contextPath}" />
  			<input type="hidden" name="userId" id="userId" value="1" />
		  	<table border="1">
				<tr><td colspan="9" align="right">检索条件:<select id="personSelect" name="personSelect">
																<option value="在借" selected="selected">在借</option>
																<option value="预定">预定</option>
																<option value="已还">已还</option>
														   </select></td></tr>
				<tr><td colspan="9" align="left">在借书籍</td></tr>
				<tr>
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
						<#list toolPage.dataList as borrowingBook>
							<tr>
								<td>${borrowingBook.bookName}</td>
								<td>${borrowingBook.bookTypeName}</td>
								<td>${borrowingBook.bookAuthor}</td>
								<td>${borrowingBook.bookPublish}</td>
								<td>${borrowingBook.startTime?string("yyyy-MM-dd")}</td>
								<td>${borrowingBook.endTime?string("yyyy-MM-dd")}</td>
								<td>
									<#if borrowingBook.overDue==0>
										否
									<#else>
										是
									</#if>
								</td>
								<td>
									<#if borrowingBook.checkFlag==2>
										已借					
									</#if>
								</td>
								<#--------------------------------------------后期修改--------------------------------------------------------------->
								
								<td>
								<#if borrowingBook.renew==0>
								<a href="${req.contextPath}/renew/setRenewBook?currentPage=${toolPage.currentPage}&checkId=${borrowingBook.checkId}&userId=1">续借</td>									
					<#--
								<#else>	
								<a href="${req.contextPath}/renew/delCancleRenewBook?currentPage=${toolPage.currentPage}&checkId=${borrowingBook.checkId}&userId=1">取消续借</td>									
					-->		
										<#else>
								已续借
					
			
								</#if>
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