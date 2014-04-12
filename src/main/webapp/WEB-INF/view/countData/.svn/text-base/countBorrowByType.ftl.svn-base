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
	 <script type="text/javascript" src="${req.contextPath}/js/FusionCharts.js"></script>  
	<script type="text/javascript">
		$(function(){
			var majorXml;
        	initXml(); 
        	function initXml(){
        	
            majorXml="<chart caption='图书类型比例统计' showNames='1'  decimalPrecision='0'>";
	            <#list list as data>
	           		 majorXml += "<set label='${data.bookType}' value='${data.num}'/>";  
	            </#list>
            majorXml+="</chart>";   
            showDou3D(); 
	        }
	        
	        function showDou3D(){   
	           var myChart=new FusionCharts("${req.contextPath}/FusionCharts/Pie3D.swf", "ChartId", "600", "300", "0", "0");   
	           myChart.setDataXML(majorXml);   
	           myChart.render("majorbus");
	        }
		
			$("#search").bind("click",function(){
				var myFrom = document.getElementById("myForm");
				myForm.action="${req.contextPath}/countData/countBorrowByType";
				myForm.submit();
			});
			
			 $("#type").children("option").each(function(){
		        var defaultValue=$(this).val();
		        if(defaultValue == ${type}){
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
			起始时间：<input type="text" id="startDate" name="startDate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})" class="Wdate"/>
			结束时间：<input type="text" id="endDate" name="endDate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})" class="Wdate"/>
			<input type="button" name="search" id="search" value="搜索">
			<table cellpadding="0" cellspacing="0"style="border-collapse: collapse;width:800px" border="1" >
				<tr>
					<th>序号</th>
					<th>书籍类型</th>
					<th>累计借阅次数</th>
				</tr>
				<#list list as data>
					<tr align="center">
						<td width="10%">${data_index+1}</td>
						<td width="15%">${data.bookType}</td>
						<td width="15%">${data.num}</td>
					</tr>
				</#list>
				<br>
			</table>
		</form>
	</div>
	<div id="majorbus">
		
	</div>
</body>
</html>