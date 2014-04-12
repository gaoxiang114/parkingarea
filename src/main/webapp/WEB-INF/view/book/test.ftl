<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>添加功能</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="addFun,添加功能">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<script language="javascript">

		</script>
	
</head>

<body><center>
	${message}
<table border="1">
		<tr><td colspan="9" align="left">角色列表</td></tr>
		<tr>
			<td>图书编号</td>
			<td>书名</td>
			<td>类别</td>
			<td>作者</td>
			<td>出版社</td>
			<td>豆瓣书评</td>
			<td>借书</td>
			<td>预定</td>
		</tr>
				
		<#if toolPage.dataList??>
			<#if (toolPage.dataList?size > 0)>
				<#list toolPage.dataList as searchBook>
					<tr>
						<td>${searchBook.bookId}</td>
						<td>${searchBook.bookName}</td>						
						<td>${searchBook.bookTypeName}</td>
						<td>${searchBook.bookAuthor}</td>
						<td>${searchBook.bookPublish}</td>
						<td>${searchBook.bookDouBan}</td>
						<td>
						<#if searchBook.bookCheckFlag==0>
							<a href="${req.contextPath}/borrow/addBorrowRecord?bookId=${searchBook.bookId!}&currentPage=${toolPage.currentPage}">借阅</a></td>
						<td>不可预订</td>
						<#else>
							不可借阅</td><td>
							<#if searchBook.bookIsOrder==0>
								可预订
							<#else>
								不可预订
							</#if>
							</td>
						</#if>
						
						
						<#--借书状态为0时：可借阅，不可预定
						<#if searchBook.bookCheckFlag==0>
							<td>
								<a id="">借阅</a>
							</td>
							<td>不可预订</td>
						</#if>
						
						<#--借书状态为1,预定状态为0时：不可借阅，逻辑判断是/否续借，逻辑判断预订/取消预定
						<#if searchBook.bookCheckFlag==1>
							<td>
							<#if searchBook.userId=1>
									<#if searchBook.renew==1>
										已续借
									<#else>
										<a href="${req.contextPath}/renew/setRenewBook?currentPage=${toolPage.currentPage}&checkId=${searchBook.checkId}&userId=1">续借</td>
									</#if>
									</td><td>不可预定</td>
							<#else>
									不可借阅
							</td><td>
								<#if searchBook.bookIsOrder==0>
									可预订<a id="preorder">预定</a></td>
								<#else>
									<#if searchBook.bookOrderUserId==1>//是否为预订用户登陆
										取消预定</td>
									<#else>
									不可预订</td>
									</#if>
								</#if>
							</#if>
						</#if>
					-->	
					</tr>
  				</#list>
			</#if>
		<#else>
			<tr>
				<td colspan="3">暂无数据</td>
			</tr>
		</#if>
				
		<br/>
				
		<tr bgcolor="#EEF4EA">
			<#if toolPage.dataList??> 
            		<td height="35" colspan="9" align="right">
            		  			<input type="hidden" name="currentPage" value="${toolPage.currentPage}" />
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
				<td height="35" colspan="4" align="center">暂时没有数据</td>
				
			</#if>
		</tr>
        		
	</table>
	</center>
	
</body>
</html>