<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>推荐书籍添加页面</title>
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/recommand.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
	<script type="text/javascript">
		$(function(){
		
		    // 提示信息			
			if("${message!}" != ""){
				alert("${message!}");
				window.location.href = "${req.contextPath}/recommand/toPersonRecommandList";
			}
			
		});
	</script>
</head>
	<body>
		<form id="myForm" name="myForm" method="post" action="${req.contextPath}/recommand/doAddRecommand">
			<input type="hidden" id="basePath" name="basePath" value="${req.contextPath}"/>
			<table align="center" cellpadding="0" cellspacing="0" width="750" border="1">
				  <tr align="left">
				    <th width="180" scope="row">图书名称</th>
				    <td width="550"><input id="bookName" name="bookName" type="text" maxlength="20"/>&nbsp; <span id="msg1"></span></td>
				  </tr>
				  
				  <tr align="left">
				    <th scope="row">作者</th>
				    <td><input id="bookAuthor" name="bookAuthor" type="text" /> <span id="msg2"></span></td>
				   
				  </tr>
				  <tr align="left">
				    <th scope="row">出版社</th>
				    <td><input id="bookPublish" name="bookPublish" type="text" /><span id="msg3"></span></td>
				  </tr>
				  <tr align="left">
				    <th scope="row">类型</th>
				    <td>&nbsp;
					    <select id="typeId" name="type.typeId">
			 				<#if rootTypeList??>
								<#if (rootTypeList?size > 0)>
					    			<#list rootTypeList as type>
					    				<option value="${type.typeId}">${type.typeName}</option>
					    			</#list>
					    		</#if>
					    	</#if>
			 			</select>
				      <span id="msg4"></span>
				    </td>
				  </tr>
				  <tr align="left">
				    <th scope="row">豆瓣链接</th>
				    <td><input id="bookDouban" name="bookDouban" type="text" /><span id="msg5"></span></td>
				  </tr>
				  <tr align="left">
				    <th scope="row">买书链接</th>
				    <td><input id="recUrl" name="recUrl" type="text" /><span id="msg6"></span></td>
				  </tr>
			</table>
		</form>
		
		<div align="center">
			    <td colspan="2"><input id="bn" name="bn" type="button" value="添加" />
			    <input name="name2" type="button" value="返回" /></td>
		</div>
	</body>
</html>
	