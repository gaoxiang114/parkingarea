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
  	<link rel="stylesheet" href="${req.contextPath}/js/ichartjs/css/demo.css" type="text/css"/>
  	<script src="${req.contextPath}/js/bootstrap.js"></script>
    <script src="${req.contextPath}/js/ichartjs/js/ichart.1.2.min.js"></script>
    <script type="text/javascript">
			$(function(){
				$.ajax({
				       type: 'POST',  
				       url: '${req.contextPath}/carInOut/getDataByParkMoney?rand='+Math.random(),
				       success : function(result){
				    	   if(result == 0){
				    		   
				    	   }else{
				    	   /*****************************************start******************************************/
				    	   $("#type").html(result.data[0].name);
				    	   $("#type1").html(result.data[1].name);
				    	   $("#count").html(result.data[0].value+"&nbsp;元");
				    	   $("#count1").html(result.data[1].value+"&nbsp;元");
				    	   var data = result.data;
							
							var chart = new iChart.Pie3D({
								render : 'canvasDiv',
								title:{
									text:result.title,
									color:'#e0e5e8',
									height:40,
									border:{
										enable:true,
										width:[0,0,2,0],
										color:'#343b3e'
									}
								},
								padding:'2 10',
								width : 965,
								height : 300,
								data:data,
								shadow:true,
								shadow_color:'#15353a',
								shadow_blur:8,
								background_color : '#3b4346',
								gradient:true,
								color_factor:0.28,
								gradient_mode:'RadialGradientOutIn',
								showpercent:true,
								decimalsnum:2,
								legend:{
									enable:true,
									padding:30,
									color:'#e0e5e8',
									border:{
										width:[0,0,0,2],
										color:'#343b3e'
									},
									background_color : null,
								},
								sub_option:{
									border:{
										enable:false
									},
									label : {
										background_color:'#fefefe',
										sign:false,//设置禁用label的小图标
										line_height:10,
										padding:4,
										border:{
											enable:true,
											radius : 4,//圆角设置
											color:'#e0e5e8'
										},
										fontsize:11,
										fontweight:600,
										color : '#444444'
									}
								},
								border:{
									width:[0,20,0,20],
									color:'#1e2223'
								}
							});
							
							chart.bound(0);
							/*****************************************end******************************************/
				    	   }	park_money_report.jsp
				       }
				});
				
			});
		</script>
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
				<div class="well">
				<!-- 
					<form action="${req.contextPath}/carInOut/carInOutList" method="post" id="searchFrm" style="margin-left: 108px;">
				            <div style="width:908px">
								<span style="font-size:18px">&nbsp;&nbsp;&nbsp;查询条件：&nbsp;&nbsp;&nbsp;</span>
								<input type="text" id = "quicklyInput" class="input-block-level" placeholder="请输入车牌号" name="carNum" style="width:200px" />
								<input type="text" id = "quicklyInput" class="input-block-level" placeholder="请输入车主姓名" name="realname" style="width:200px;" />
								<input type="text" id = "quicklyInput" class="input-block-level" placeholder="请输入身份证号" name="idCard" style="width:200px;" />
								<input type="button" value="搜索" class="btn" id="bn" style="margin-bottom:10px"/>
							</div>
				   </form>
				 -->
				 	<div>
						<table class="table table-bordered table-hover">
					      <thead>
					        <tr>
					          <th align="center">类型</th>
					          <th align="center">利润</th>
					        </tr>
					      </thead>
					      <tbody>
						      	 <tr>
						          	<td id="type"></td>
						          	<td id="count"></td>
						        </tr>
						        <tr>
						          	<td id="type1"></td>
						          	<td id="count1"></td>
						        </tr>
					      </tbody>
					    </table>
					</div>
				   <div id='canvasDiv' style="width:100%;height:100%"></div>
				   
				</div>
            </div>
        </div>
    </div>
  </body>
</html>


