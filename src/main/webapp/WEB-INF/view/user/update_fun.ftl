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
	  	
	  	
	  			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/fun/toFunList?currentPage=${currentPage}";
			}
	  	
	  	
	  	
	  	 $("#firstLevel").children("option").each(function(){
	        var defaultValue=$(this).val();
	        if(${first.funId!}==defaultValue){
	            $(this).attr("selected",true);
	        }
	    });
	    
	     $("#secondLevel").children("option").each(function(){
	        var defaultValue=$(this).val();
	        if(${second.funId!}==defaultValue){
	            $(this).attr("selected",true);
	        }
	    });
	  	
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
	});
</script>
</head>
<body><center>
	${message}
	<form action="${req.contextPath}/fun/updateFun" method="post" id="frm">
		<table border ="1">
			<tr>
			<td>功能名称:</td>
			<td><input id="funName" type="text" name="funName" value="${third.funName}" /></td>
			<td><span id="nameMsg">功能为2-10中文字符</span></td></tr>
			<tr>
			<td>所属模块：</td>
			<td><select id="firstLevel" name="firstLevel">
					<#list firstLevel as fl>
						<option value="${fl.funId}">${fl.funName}</option>
					</#list>
				</select>
				<select id="secondLevel" name="secondLevel">
					<#list secondLevel as second>
							<option value="${second.funId}">${second.funName}</option>
					</#list>
				</select>
				</td>
			<td></td></tr>
			<tr>
			<td>URL</td>
			<td><input id="funUrl" type="text" name = "funUrl" value="${third.funUrl}" /></td>
			<td><span id="urlMsg">url地址以http://开头</span></td></tr>
			<tr>
			<td colspan="3"><center>
								<input type="hidden" name="currentPage" value="${currentPage}" />
								<input type="hidden" name="funId" id="funId" value="${third.funId}" />
								<input type="button"  value="提交" id="bn" />
								<input type="button" value="返回" onclick="history.go(-1)" />
			</center></td></tr></table>
		 
	</form>
	</center>
	
</body>
</html>