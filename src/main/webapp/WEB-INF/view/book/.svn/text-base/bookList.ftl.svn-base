<html>
<haed>
	<script language="javascript">
		function deleteBook(id){

			if(confirm("您确认要删除么？")){
				//alert("${req.contextPath}");
				//alert(id);
				//window.location.href="'${req.contextPath}'/book/deleteBook?id="+id;
				return true;
			}
			return false;
		}
	</script>
<head>
	<body>
		<table border="1">
			<tr>
				<td>图书编号</td>
				<td>书名</td>
				<td>类别</td>
				<td>作者</td>
				<td>出版社</td>
				<td>豆瓣链接</td>
				<td>状态</td>
				<td colspan="2">操作</td>
			</tr>
			<#list toolPage.dataList as book>
				<tr>
					<td><#if book.id??>${book.id}</#if></td>
					<td><#if book.name??>${book.name}</#if></td>
					<td><#if book.type.typeName??>${book.type.typeName}</#if></td>
					<td><#if book.author??>${book.author}</#if></td>
					<td><#if book.publish??>${book.publish}</#if></td>
					<td><#if book.doban??><a href="http://${book.doban}">${book.doban}</a></#if></td>
					<td>
						<#if book.bookCheckFlag??>
							<#if book.bookCheckFlag==0>在架
							<#else>不在架
							</#if>
						</#if>
					</td>
					<td><a href="${req.contextPath}/book/selectBookEdit?id=${book.id}&currentPage=${toolPage.currentPage-1}">修改</a></td>
					<td><a href="${req.contextPath}/book/deleteBook?id=${book.id}&currentPage=${toolPage.currentPage-1}" onclick="return deleteBook('${book.id}')">删除</a></td>
					
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