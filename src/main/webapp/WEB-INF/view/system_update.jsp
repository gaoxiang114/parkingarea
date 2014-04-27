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
	<script src="${req.contextPath}/js/common.js" type="text/javascript"></script>
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
  </head>

  <body class=""> 
    <%@ include file="menu.jsp"%>
    <div class="content">
			        <div class="header">
			            
			            <h1 class="page-title">系统信息管理</h1>
			        </div>
			        
			                <ul class="breadcrumb">
			            <li><a href="${req.contextPath}/manager/user/index">主页</a> <span class="divider">/</span></li>
			            <li>系统管理<span class="divider">/</span></li>
			            <li class="active">系统信息管理</li>
			        </ul>
			
			        <div class="container-fluid">
			            <div class="row-fluid">
			                    
				
					<div class="well">
					    <div id="myTabContent" class="tab-content">
					      <div class="tab-pane active in" id="home">
							    <form id="myForm" action="${req.contextPath}/admin/doUpdateSystemInfo" method="post" onsubmit="return mySubmit();">
							        <label>停车场名称</label>
							        <input type="text" name="parkingLot" id="parkingLot" style="width:300px" value=" ${systemInfo.parkingLot}">
							        <label>收费标准</label>
							        <input type="text" name="parkingMoney" id="parkingMoney" style="width:300px" value="${systemInfo.parkingMoney}" class="input-xlarge">
									</br>
									<button style="margin-left:240px" class="btn btn-primary" onclick=""><i class="icon-save"></i>&nbsp;保存</button>
							    </form>
					      </div>
					  </div>
					</div>
            </div>
        </div>
    </div>

    <script src="${req.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript">
    	function mySubmit(){
    		var parkingLot = $("#parkingLot").val();
    		var parkingMoney = $("#parkingMoney").val();
    		var moneyPattern = /^(([1-9]\d*)(\.\d{1,2})?)$|(0\.0?([1-9]\d?))$/;
    		if(is_empty(parkingLot)){
    			alert("请输入停车场名字！");
    			return false;
    		}
    		if(is_empty(parkingMoney)){
    			alert("请输入钱数！");
    			return false;
    		}else if(!moneyPattern.test(string)){
    			alert("格式不对，正确格式如：正整数，浮点数");
    			return false;
    		}
    		return true;
    	}
    </script>
    
  </body>
</html>


