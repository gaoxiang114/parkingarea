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
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/fun.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
<script language="javascript">
	$(function(){  
	
	  	$("#firstLevel").bind("change",function(){
			$.ajax({
		     	type: "POST",
		     	url: "${req.contextPath}/fun/getSecondLevelFun",
		    	 data: "funId="+$(this).val(),
		    	 success: function(result){
		    	 
			       var funList = JSON.parse(result);              //将字符串解析
			   	   $("#secondLevel").empty();
			       $.each(funList,function(i,item){
			     		
			     		 $("<option></option>")
	                    .val(item["funId"])
	                    .text(item["funName"])
	                    .appendTo($("#secondLevel"));

			     	});
		     	}
		   });
		});                  
		
		// 提示信息			

			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/fun/toFunList?currentPage=${currentPage}";
			}
	});
</script>
</head>

<body><center>
	${message}
	<form action="${req.contextPath}/fun/addFun?currentPage=${currentPage}" method="post" id="frm">
		<input type="hidden" name="currentPage" value="${currentPage}" />
		<table border ="1">
			<tr>
			<td>功能名称:</td>
			<td><input id="funName" type="text" name="funName" /></td>
			<td><span id="nameMsg">功能为2-10中文字符</span></td></tr>
			<tr>
			<td>所属模块：</td>
			<td><select id="firstLevel" name="firstLevel">
					<#if firstLevel?if_exists>
					<#list firstLevel as first>
						<option value="${first.funId}">${first.funName}</option>
					</#list>
					<#else>
						暂无数据
					</#if>
				</select>
				<select id="secondLevel" name="secondLevel">
					<#if firstLevel?if_exists>
					<#list secondLevel as second>
							<option value="${second.funId}">${second.funName}</option>
					</#list>
						<#else>
						暂无数据
					</#if>
				</select>
			</td>
			</tr>
			<tr>
			<td>url</td>
			<td><input id="funUrl" type="text" name = "funUrl" /></td>
			<td><span id="urlMsg">url地址以http://开头</span></td></tr>
			<tr>
			<td colspan="3"><center>
								<input type="button"  value="提交" id="bn" />
								<input type="button" value="返回" onclick="history.go(-1)" />
			</center>
			</td></tr></table>
		 
	</form>
	</center>
	
</body>
</html>