<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>推荐书籍修改页面</title>
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/recommand.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
	<script type="text/javascript">
		$(function(){
		
		    // 提示信息			
			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/recommand/toRecommandList?recFlag="+${recommand.recFlag};
			}
			
			
		  	$("#largeType").bind("change",function(){
				$.ajax({
			     	type: "POST",
			     	url: "${req.contextPath}/book/selectTypeByFatherId",
			    	 data: "typeId="+$(this).val(),
			    	 success: function(data){
			    	 
				       var typeList = JSON.parse(data);              //将字符串解析
				   	   $("#typeId").empty();
				       $.each(typeList,function(i,item){
				     		
				     		$("<option></option>")
		                    .val(item["typeId"])
		                    .text(item["typeName"])
		                    .appendTo($("#typeId"));
				     		
				     	});
			     	}
			   });
			});
			
		});
	</script>
</head>
	<body>
		<form id="myForm" name="myForm" method="post" action="${req.contextPath}/recommand/doUpdateRecommand">
			<input type="hidden" name="recId" value="${recommand.recId}"/>
			<input type="hidden" name="recFlag" value="${recommand.recFlag}"/> 
			<table align="center"  cellpadding="0" cellspacing="0" width="750" border="1">
				  <tr align="left">
				    <th width="180" scope="row">图书名称</th>
				    <td width="550"><input id="bookName" name="bookName" type="text" value="${recommand.bookName!}" maxlength="20"/>&nbsp; <span id="msg1"></span></td>
				  </tr>
				  
				  <tr align="left">
				    <th scope="row">作者</th>
				    <td><input id="bookAuthor" name="bookAuthor" type="text"  value="${recommand.bookAuthor!}"/> <span id="msg2"></span></td>
				   
				  </tr>
				  <tr align="left">
				    <th scope="row">出版社</th>
				    <td><input id="bookPublish" name="bookPublish" type="text" value="${recommand.bookPublish!}"/><span id="msg3"></span></td>
				  </tr>
				  
				  <tr align="left">
				    <th scope="row">类型</th>
				    <td>&nbsp;
					<select id="largeType" name="largeType">
		 				<#list rootTypeList as type>
		 					<option value="${type.typeId}">${type.typeName}</option>
		 				</#list>
		 			</select>
		 			<select id="typeId" name="type.typeId">
		 				<#list sameTypeList as type>
		 					<option value="${type.typeId}">${type.typeName}</option>
		 				</#list>
		 			</select>
				      <span id="msg4"></span>
				    </td>
				  </tr>
				  <tr align="left">
				    <th scope="row">豆瓣链接</th>
				    <td><input id="bookDouban" name="bookDouban" type="text" value="${recommand.bookDouban!}"/><span id="msg5"></span></td>
				  </tr>
				  <tr align="left">
				    <th scope="row">买书链接</th>
				    <td><input id="recUrl" name="recUrl" type="text" value="${recommand.recUrl!}"/><span id="msg6"></span></td>
				  </tr>
			</table>
		</form>
		
		<div align="center">
			    <td colspan="2"><input id="bn" name="bn" type="button" value="修改" />
			    <input name="name2" type="button" onclick="history.go(-1)" value="返回" /></td>
		</div>
	</body>
</html>
	