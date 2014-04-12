<html>
<haed>

<head>
	<body>
	<table border="1">
		<tr>
			<td>图书编号</td>
			<td>书名</td>
			<td>类别</td>
			<td>作者</td>
			<td>出版社</td>
			<td>豆瓣书评</td>
		</tr>
		<#list toolPage.dataList as book>
			<tr>
				<td><#if book.id??>${book.id}</#if></td>
				<td><#if book.name??><a href="${req.contextPath}/book/selectBookBorrow?bookId=${book.id}&currentPage=${toolPage.currentPage-1}">${book.name}</a></#if></td>
				<td><#if book.type.typeName??>${book.type.typeName}</#if></td>
				<td><#if book.author??>${book.author}</#if></td>
				<td><#if book.publish??>${book.publish}</#if></td>
				<td><#if book.doban??><a href="http://${book.doban}">${book.doban}</a></#if></td>				
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