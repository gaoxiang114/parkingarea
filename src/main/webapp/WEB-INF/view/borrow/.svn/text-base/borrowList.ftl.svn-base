<html>
<haed>
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script language="javascript">
		$(function(){
			if(""!="${message}"){
				alert("${message}");
			}
		});
	</script>
</head>
	<body>
		<table border="1">
			<tr>
				<td>流水号</td>
				<td>借书人</td>
				<td>图书编号</td>
				<td>书名</td>
				<td>申请时间</td>
				<td colspan="2">操作</td>
			</tr>
			<#list toolPage.dataList as borrowRecord>
				<tr>
					<td><#if borrowRecord.check_id??>${borrowRecord.check_id}</#if></td>
					<td><#if borrowRecord.user_realname??>${borrowRecord.user_realname}</#if></td>
					<td><#if borrowRecord.bookId??>${borrowRecord.bookId}</#if></td>
					<td><#if borrowRecord.bookName??>${borrowRecord.bookName}</#if></td>
					<td><#if borrowRecord.check_requestTime??>${borrowRecord.check_requestTime?string("yyyy-MM-dd")}</#if></td>
					<td><a href="${req.contextPath}/borrow/doBorrowBook?check_id=${borrowRecord.check_id}&currentPage=${toolPage.currentPage-1}&user_id=${borrowRecord.user_id}">借出</a></td>
					<td><a href="${req.contextPath}/borrow/doCancleBorrow?check_id=${borrowRecord.check_id}&currentPage=${toolPage.currentPage-1}&bookId=${borrowRecord.bookId}&user_id=${borrowRecord.user_id}">取消</a></td>
				</tr>
	
			</#list>
			<tr bgcolor="#EEF4EA">
	            		<td height="35" colspan="9" align="right">
	            第${toolPage.currentPage}页
	            			共${toolPage.pageCount}页
							${toolPage.firstPage}
							${toolPage.precursorPage}
							${toolPage.nextPage}
							${toolPage.lastPage}
	            			${toolPage.currentPage}/${toolPage.pageCount}页
	            		</td>
	        		</tr>
	
	
		</table>
	</body>
</html>