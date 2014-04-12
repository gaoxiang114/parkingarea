<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>邮件预设信息列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="mailList,邮件预设信息列表">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/mail.js"></script>
	<script>
	
		function mySubmit(){
			
			var ids = returnCheckValue("roleId");
			if(ids.length==0){
				alert("请勾选要删除的数据");
				return;
			}
			
			if(confirm("您确认要删除么？")){
				document.getElementById("myForm").submit();
			}
		}
	</script>
	<style>
		table{border-collapse:collapse;}
	</style>
  </head>

  <body>
  	<center>
  		<form action="" id="myForm" method="post" >
		  	<table align="center"  cellpadding="0" cellspacing="0" width="750" border="1">
				<tr><td colspan="5" align="center">邮件预设信息列表</td></tr>
				<tr>
					<td>序号</td>
					<td>主题</td>
					<td>提醒内容</td>
					<td>操作</td>
				</tr>
				
				<#if mailList??>
					<#if (mailList?size > 0)>
						<#list mailList as mail>
							<tr>
								<td align="center">${mail_index+1}</td>
								<td>${mail.mailTitle!}</td>
								<td>${mail.mailContent!}</td>
								<td align="center">
									<a href="${req.contextPath}/mail/toUpdateMail?mailId=${mail.mailId!}">修改</a>
								</td>
							</tr>
		  				</#list>
					</#if>
				</#if>
				
		  	</table>
  		</form>
  </center>
  </body>
</html>