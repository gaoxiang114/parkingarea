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
				myForm.action="${req.contextPath}/countData/countBorrowState";
				myForm.submit();
			});
			
			 $("#type").children("option").each(function(){
		        var defaultValue=$(this).val();
		        if(defaultValue==${type}){
		        	$(this).attr("selected",true);
		        }
		     });
		     
		      $("#type").bind("change",function(){
					if($(this).val() == "1"){
						window.location.href="${req.contextPath}/countData/countBorrowByBook?type=1";
					}else if($(this).val() == "2"){
						window.location.href="${req.contextPath}/countData/countBorrowState?type=2";
					}else{
						window.location.href="${req.contextPath}/countData/countBorrowByType?type=3";
					}
				});
		     
		     $("#department").children("option").each(function(){
		        var defaultValue=$(this).val();
		        if("${dataBean.department!}" == defaultValue){
		        	$(this).attr("selected",true);
		        }
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
		<span>查看类型：</span>
		<select name="type" id="type">
			<option value="1">按书籍</option>
			<option value="2">按借阅人</option>
			<option value="3">按书籍类型</option>
		</select>

	</div>

	<div>
		<form id="myForm" method="post" action="">
			搜索条件：
			中部：
			<select name="department" id="department">
				<option value="-1">全部</option>
				<option value="测试">测试</option>
				<option value="美术">美术</option>
				<option value="技术中部">技术中部</option>
				<option value="开发">开发</option>
			</select>
			起始时间：<input type="text" id="startDate" name="startDate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})" class="Wdate"/>
			结束时间：<input type="text" id="endDate" name="endDate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})" class="Wdate"/>
			<input type="button" name="search" id="search" value="搜索">
			<table cellpadding="0" cellspacing="0"style="border-collapse: collapse;width:800px" border="1" >
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>所属中部</th>
					<th>借阅次数</th>
					<th>书名</th>
				</tr>
				<#assign name=""/>
				<#list dataList as data>
					<tr>
						<td width="10%">${data.userName}</td>
						<td width="15%">${data.realName}</td>
						<td width="15%">${data.department}</td>
							<#list data.bookNameList as bookName>
								<#assign name=name+"《"+bookName+"》"/>
							</#list>
						<td width="15%">${data.num}</td>
						<td title="${name}" width="45%">
							${name}
						</td>
					</tr>
				</#list>
				
				<br>
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="5" align="center">
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
						<td height="35" colspan="5" align="center">暂时没有数据</td>
						
					</#if>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>