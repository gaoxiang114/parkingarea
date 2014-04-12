<html xmlns="http://www.w3.org/1999/xhtml">
<html>
	<head>
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script language="javascript">
	
	$(function(){
			$("#bn").click(function() {
				if($("#quicklyInput").val().length==0){
					alert("请输入用于检索的书名/出版社！");
				}else{
					$("#frm").submit();
				}
			});
		});
	
	function selectBookList()
	{
	 	window.location.href="selectBookList"
	}
	</script>
	</head>
	<body>
	<form action="${req.contextPath}/personReader/getQuicklySearchBook" method="post">
    	<table>
    		<tr>
	    		<td>图书编号:</td><td><input type="text" id = "inputString" title="请输入书名/出版社" name="inputString"/></td>
	            <td><input type="submit"  value="检索" /></td>
	        </tr>
    		<tr>
	    		<td>
	    			<select id="personSelect" name="personSelect">
																<option value="0" selected="selected">在借</option>
																<option value="1">预定</option>
																<option value="2" selected="selected">已还</option>
														   </select>
	    		</td>
	        </tr>
		</tale>
    </form>

    
    
    
	</body>
</html>