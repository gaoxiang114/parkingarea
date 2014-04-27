<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>停车场管理系统 </title>
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
			            
			            <h1 class="page-title">添加停车记录</h1>
			        </div>
			        
			                <ul class="breadcrumb">
			            <li><a href="${req.contextPath}/manager/user/index">主页</a> <span class="divider">/</span></li>
			            <li><a href="${req.contextPath}/manager/product/productList">进出车管理</a> <span class="divider">/</span></li>
			            <li class="active">添加停车记录</li>
			        </ul>
			
			        <div class="container-fluid">
			            <div class="row-fluid">
			                    
				
					<div class="well">
					    <div id="myTabContent" class="tab-content">
					      <div class="tab-pane active in" id="home">
							    <form id="myForm" action="${req.contextPath}/position/doPositionAdd" method="post" onsubmit="return submitForm();">
							        <table style="width:100% ">
									    	<tr>
									    		<td style="width: 100px;">停车位名称   ：</td>
									    		<td><input type="text" name="parkingNum" id="parkingNum" class="wid" onblur="checkExist()"/></td>
									    		<td><span id="msg"></span></td>
									    	</tr>
									        <tr>
									            <td colspan="3">
									            	<input type="submit"  value="添加" id="bn" class="btn btn-primary" style="margin-left: 74px;"/>
									        		<input type="button" onclick="history.go(-1)" value="返回" class="btn btn-primary" style="margin-left: 60px;"/>
									        	</td>
								        		
								        	</tr>
								</table>
									 <!--  <button class="btn btn-primary"><i class="icon-save"></i>&nbsp;保;存</button>  -->
							    </form>
					      </div>
					  </div>
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
        
        function checkExist(){
        	var temp = true;
        	if($("#parkingNum").val() == "" || $("#parkingNum").val() == null){
        		alert("请输入停车位的名称");
        		return false;
        	} else{
        		$.ajax({
  			       type: 'POST',  
  			       url: '${req.contextPath}/position/checkPositionExist?rand='+Math.random(),
  			       data:{"parkingNum":$("#parkingNum").val()},
  			       async:false,
  			       success : function(data){
  			    	   if(data == 0){
  			    		  temp = true;
  			    	   }else{
  			    		   alert("停车场名字重复！");
  			    		   temp = false;
  			    	   }
  			       }
  				});
         		return temp;
         	}
        }
        
        function submitForm(){
        	return checkExist();
        }
    </script>
    
  </body>
</html>


