<html xmlns="http://www.w3.org/1999/xhtml">
<html>
	<head>
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script language="javascript">
	function selectBookList()
	{
	 	window.location.href="selectBookList"
	}
	</script>
	</head>
	<body>
	<form action="${req.contextPath}/book/addBook" method="post">
    	<table>
    		<tr>
	    		<td>图书编号:</td><td><input type="text" name="id"/></td>
	    	</tr>
	    	<tr>
	    		<td>书      名   :</td><td><input type="text" name="name" /></td>
	    	</tr>
	    	<tr>
		 		<td>类       别   ：</td><td><input type="text" name="type.typeId" /></td>
	       	</tr>
	       	<tr>
	       	 	<td>作       者   ：</td><td><input type="text" name="author" /></td>
	       	</tr>
	       	<tr>
	       		<td>出  版  社  ：</td><td><input type="text" name="publish"}" /></td>
	       	</tr>
	       	<tr>
	       		<td>豆瓣链接  ：</td><td><input type="text" name="doban"  /></td>
	      	</tr>
	        <tr>
	            <td><input type="submit"  value="保存" /></td>

	        	<td><input type="button" onclick="history.go(-1)" value="返回" /></td>
	        </tr>

		</tale>
    </form>
	</body>
</html>