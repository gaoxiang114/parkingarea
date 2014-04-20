<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>停车场管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${req.contextPath}/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="${req.contextPath}/css/theme.css">
    <link rel="stylesheet" href="${req.contextPath}/css/font-awesome/css/font-awesome.css">

    <script src="${req.contextPath}/js/jquery-1.7.1.min.js" type="text/javascript"></script>

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <link rel="shortcut icon" href="${req.contextPath}/images/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${req.contextPath}/images/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${req.contextPath}/images/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${req.contextPath}/images/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${req.contextPath}/images/assets/ico/apple-touch-icon-57-precomposed.png">
  	<script type="text/javascript">
  		function carInOutAdd(){
  			window.location.href="${req.contextPath}/position/positionList";
  		}
  	</script>
  </head>

  <body class=""> 
    <%@ include file="menu.jsp"%>
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">进出车管理</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="${req.contextPath}/manager/user/index">主页</a> <span class="divider">/</span></li>
            <li class="active">进出车管理</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
	    <button class="btn btn-primary" onclick="carInOutAdd();"><i class="icon-plus"></i>新增</button>
	</div>
<div class="well">
	<form action="${req.contextPath}/carInOut/carInOutList" method="post" id="searchFrm" style="margin-left: 108px;">
            <div style="width:908px">
				<span style="font-size:18px">&nbsp;&nbsp;&nbsp;查询条件：&nbsp;&nbsp;&nbsp;</span>
				<input type="text" id = "quicklyInput" class="input-block-level" placeholder="请输入车牌号" name="carNum" style="width:200px" />
				<input type="text" id = "quicklyInput" class="input-block-level" placeholder="请输入车主姓名" name="realname" style="width:200px;" />
				<input type="text" id = "quicklyInput" class="input-block-level" placeholder="请输入身份证号" name="idCard" style="width:200px;" />
				<input type="button" value="搜索" class="btn" id="bn" style="margin-bottom:10px"/>
			</div>
   </form>
   <form action="${req.contextPath}/carInOut/calcMoney" name="myForm" id="myForm" method="post">
    <input type="hidden" name="id" id="id" value=""/>
    <input type="hidden" name="totalPrice" id="totalPrice" value=""/>
    <table class="table table-bordered table-hover">
      <thead>
        <tr>
          <th>车牌号</th>
          <th>身份证号</th>
          <th>车主名</th>
          <th>手机</th>
          <th>停车位</th>
          <th>停车时间</th>
          <th>单价</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
	      <c:forEach items="${toolPage.dataList}" var="carInOut" varStatus="status">
	      	 <tr id="tr_${carInOut.id}">
	          <td>${carInOut.carNum}</td>
	          <td>${carInOut.idCard}</td>
	          <td>${carInOut.realname}</td>
	          <td>${carInOut.telephone}</td>
	          <td>${carInOut.parkingId}</td>
	          <td><fmt:formatDate value="${carInOut.startTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
	          <td>${carInOut.priceHour}/小时</td>
	          <td><a href="#this" onclick="calcMoney('tr_${carInOut.id}')">结账</a></td>
	        </tr>
	   	  </c:forEach>
      </tbody>
    </table>
    <div class="pagination pagination-right">
	    <ul>
	        <li>${toolPage.firstPage}</li>
	        <li>${toolPage.precursorPage}</li>
	        <c:forEach items="${toolPage.numList}" var="num" varStatus="status">
	        	<li>${num}</li>
	        </c:forEach>
	        <li>${toolPage.nextPage}</li>
	        <li>${toolPage.lastPage}</li>
	        <li><a href="#">${toolPage.currentPage}/${toolPage.pageCount}页</a></li>
	    </ul>
	</div>
</form>
</div>

            </div>
        </div>
    </div>
    


    <script src="${req.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
        $("#bn").click(function() {
			$("#searchFrm").submit();
		});
        
        function calcMoney(tr_id){
        	var arr = $("#"+tr_id+" td");
        	var carNum = arr[0].innerText;//车牌号
        	var name =  arr[2].innerText; //车主姓名
        	var position = arr[4].innerText;
        	var time = arr[5].innerText;
        	var startTime = new Date(time);
        	var nowTime = new Date();
        	var time = (nowTime - startTime.getTime())/(1000*60*60*1.0);
        	var totalTime = Math.round(time);
        	var totalPrice = parseInt(arr[6].innerText)*totalTime;
        	var content  = "                    车主姓名："+name+"\r\n";
	        	content += "                    车牌号："+carNum+"\r\n";
	        	content += "                    停车位："+position+"\r\n";
	        	content += "                    停车时间："+totalTime+"\r\n";
	        	content += "                    停车费用："+totalPrice+"\r\n";
	        	content += "                    是否确认结账?";
        	if(confirm(content)){
        		$("#id").val(tr_id.split("_")[1]);
        		$("#totalPrice").val(totalPrice);
        		$("#myForm").submit();
        	}
        }
    </script>
    
  </body>
</html>


