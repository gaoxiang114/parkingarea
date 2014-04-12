<html>
	<head>
		<script language="javascript">
				function deleteBookType(id){
	
					if(confirm("您确认要删除么？")){
						return true;
					}
					return false;
				}
		</script>
	</head>
	<body>
		<table border="1">
			<tr>
				<td>类别编号</td>
				<td>类别名称</td>
				<td>类别描述</td>
				<!--<td>父类别</td>-->
				<td colspan="2">操作</td>
			</tr>
			<#list toolPage.dataList as bookType>
				<tr>
					<td>${bookType.typeId}</td>
					<td>${bookType.typeName}</td>
					<td>${bookType.prefix}</td>
					<!--<td>${bookType.fatherTypeId}</td>-->
					<td><a href="${req.contextPath}/bookType/selectBookTypeEdit?typeId=${bookType.typeId}&currentPage=${toolPage.currentPage-1}">修改</a></td>
					<td><a href="${req.contextPath}/bookType/deleteBookType?typeId=${bookType.typeId}&currentPage=${toolPage.currentPage-1}" onClick="return deleteBookType()">删除</a></td>
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