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
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/fun.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
<script language="javascript">
	$(function(){           
	  	$("#firstLevel").bind("change",function(){
			$.ajax({
		     	type: "POST",
		     	url: "${req.contextPath}/fun/getSecondLevelFun",
		    	 data: "fun_id="+$(this).val(),
		    	 success: function(result){
		    	 
			       var funList = JSON.parse(result);              //将字符串解析
			   	   $("#secondLevel").empty();
			     		$("<option></option>").val(0).text("二级功能").appendTo($("#secondLevel"));
			       $.each(funList,function(i,item){
			     		
			     		 $("<option></option>")
	                    .val(item["fun_id"])
	                    .text(item["fun_name"])
	                    .appendTo($("#secondLevel"));

			     	});
		     	}
		   });
		});                  
	});
</script>
</head>

<body><center>
	${message}
	<form action="${req.contextPath}/fun/addFun" method="post" id="frm">
		<table border ="1">
			<tr>
			<td>功能名称:</td>
			<td><input id="fun_name" type="text" name="fun_name" /></td>
			<td><span id="nameMsg">功能为2-10中文字符</span></td></tr>
			<tr>
			<td>所属模块：</td>
			<td><select id="firstLevel" name="firstLevel">
					<#list firstLevel as first>
						<option value="${first.fun_id}">${first.fun_name}</option>
					</#list>
				</select>
				<select id="secondLevel" name="secondLevel">
					<#--
					<#list secondLevel as second>
							<option value="${second.fun_id}">${second.fun_name}</option>
					</#list>
					-->	
				</select>
				</td>
			<td></td></tr>
			<tr>
			<td>url</td>
			<td><input id="fun_url" type="text" name = "fun_url" /></td>
			<td><span id="urlMsg">url地址以http://开头</span></td></tr>
			<tr>
			<td colspan="3"><center>
								<input type="button"  value="提交" id="bn" />
								<input type="button" value="返回" onclick="history.go(-1)" />
			</center></td></tr></table>
		 
	</form>
	</center>
	
</body>
</html>