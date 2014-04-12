<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  

    <title>主页</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<title></title>
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#search").bind("click",function(){
				var myFrom = document.getElementById("myForm");
				myForm.action="${req.contextPath}/countData/purchaseCount";
				myForm.submit();
			});
		});
	</script>
	<style>
		table td {font-size: 14px; width: 80px; text-overflow:ellipsis; overflow: hidden; white-space: nowrap;}
		table{border-collapse:collapse; table-layout: fixed; width:80%;}
	</style>
</head>
<body>

	<div>
		<form id="myForm" method="post" action="">
			搜索条件：
			中部：
			<select name="typeId" id="typeId">
				<option value="-1">全部</option>
				<#list typeList as type>
					<option value="${type.typeId}">${type.typeName}</option>
				</#list>
			</select>
			起始时间：<input type="text" id="startDate" name="startDate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})" class="Wdate"/>
			结束时间：<input type="text" id="endDate" name="endDate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})" class="Wdate"/>
			<input type="button" name="search" id="search" value="搜索">
			<table cellpadding="0" cellspacing="0"style="border-collapse: collapse;width:800px" border="1" >
				<tr>
					<th>图书编号</th>
					<th>书名</th>
					<th>采购时间</th>
					<th>价格</th>
				</tr>
				<#assign name=""/>
				<#list list as data>
					<tr align="center">
						<td width="10%">${data.bookId}</td>
						<td width="15%">${data.bookName}</td>
						<td width="15%">${data.recDate?date}</td>
						<td width="45%">${data.price}</td>
					</tr>
				</#list>
				
				<br>
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="4" align="center">
		            			<#--<input type="button" id="mySubmit" value="删除"/>-->
		            			第${toolPage.currentPage}页
		            			共${toolPage.pageCount}页
								${toolPage.firstPage}
								${toolPage.precursorPage}
								${toolPage.nextPage}
								${toolPage.lastPage}
		            			${toolPage.currentPage}/${toolPage.pageCount}页
		            		</td>
						<#else>
						<td height="35" colspan="4" align="center">暂时没有数据</td>
						
					</#if>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>