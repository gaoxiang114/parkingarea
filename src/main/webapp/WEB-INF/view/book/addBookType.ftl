<html xmlns="http://www.w3.org/1999/xhtml">
<html>
	<head>
		<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${req.contextPath}/js/add_book_type.js"></script>
	</head>
	<body>
	<form id="addBookType" action="${req.contextPath}/bookType/addBookType" method="post">
		
    	<table>
	    	<tr>
	    		<td>类别名：</td><td><input type="text" name="typeName" id="typeName"/></td>
	    		<td id="typeNameMsg"></td>
	    	</tr>
	    	<!--<tr>
		 		<td>父类 别   ：</td><td><input type="text" name="fatherTypeId" /></td>
	       	</tr>
	       	-->
	       	<tr>
	    		<td>类别描述：</td><td><input type="text" name="prefix" id="prefix"/></td>
	    		<td id="prefixMsg">根据描述为书藉编号</td>
	    	</tr>
	        <tr>
	            <td><input type="button"  value="保存" id="sub"/></td>

	        	<td><input type="button" onclick="history.go(-1)" value="返回" /></td>
	        </tr>
	        

		</tale>
    </form>
	</body>
</html>