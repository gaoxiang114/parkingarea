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
        <title>图书类型比例统计</title>
        <script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script> 
        <script type="text/javascript" src="${req.contextPath}/js/FusionCharts.js"></script>  
        <script type="text/javascript">
        $(function(){
        	var majorXml;
        	initXml(); 
        	function initXml(){
        	
            majorXml="<chart caption='图书类型比例统计' showNames='1'  decimalPrecision='0'>";
	            <#list dataList as data>
	           		 majorXml += "<set label='${data.displayName}' value='${data.num}'/>";  
	            </#list>
            majorXml+="</chart>";   
            showDou3D(); 
	        }
	        
	        function showDou3D(){   
	           var myChart=new FusionCharts("${req.contextPath}/FusionCharts/Pie3D.swf", "ChartId", "600", "300", "0", "0");   
	           myChart.setDataXML(majorXml);   
	           myChart.render("majorbus");
	        }
        });
        </script>
    </head>
  
    <body>
        <center>
        <div style="width:700px">
        	<table cellpadding="0" cellspacing="0" style="border-collapse:collapse;width:700px"  border="1">
        		<tr>
        			<th>类型</th>
        			<th>数量</th>
        		</tr>
        		<#assign count=0>
        		<#list dataList as data>
        			<#assign count=count+data.num>
	        		<tr>
	        			<td align="center">${data.displayName}</td>
	        			<td align="center">${data.num}</td>
	        		</tr>
        		</#list>
        		
        	</table>
        	<br>
        	<p style="text-align:right;">合计：${count}</p>
        </div>
        <div style="" id="majorbus">  
        </div>  
        </center>  
    </body>  
</html> 