<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${req.contextPath}/js/bookType.js"></script>
	</head>
	<body>
	<form action="${req.contextPath}/bookType/editBookType" method="post" id="editBookType">
	<input type="hidden" name="currentPage" value="${currentPage}">
    	<table>
    		<tr>
	    		<td>类别编号:</td>
	    		<td>
	    			<input type="text" id="typeId" name="typeId" value="${bookType.typeId}" readonly/>
	    		</td>
	    		<td></td>
	    	</tr>
	    	<tr>
	    		<td>类别名称  :</td>
	    		<td>
	    			<input type="text" id="typeName" name="typeName" value="${bookType.typeName}" />
	    		</td>
	    		<td><span id="typeNameMsg"></span></td>
	    	</tr>
	    	<tr>
	    		<td>类别描述：</td><td><input type="text" name="prefix" id="prefix" value="${bookType.prefix}"/></td>
	    		<td id="prefixMsg">根据描述为书藉编号</td>
	    	</tr>
	    	
	        <tr>
	            <td><input type="button"  value="保存" id="sub"/></td>
				<!--<td><input type="submit"  value="保存"/>-->
	        	<td><input type="button" onclick="history.go(-1)" value="返回" /></td>
	        </tr>

		</tale>
    </form>
	</body>
</html>