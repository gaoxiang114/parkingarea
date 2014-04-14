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
  		function serviceAdd(){
  			window.location.href="${req.contextPath}/manager/services/toAddService";
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
    <button class="btn btn-primary" onclick="serviceAdd();"><i class="icon-plus"></i>新增</button>
    <a href="#myModal" data-toggle="modal" class="btn">删除</a>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <table class="table table-bordered table-hover">
      <thead>
        <tr>
          <th><input name="chooseAll" id="chooseAll" type="checkbox" title="全选/全部选" onClick= "selORcancel('chooseAll','funId')"></th>
          <th>车牌号</th>
          <th>身份证号</th>
          <th>车主名</th>
          <th>手机</th>
          <th>停车位</th>
          <th>停车时间</th>
          <th>单价</th>
          <th>总价钱</th>
        </tr>
      </thead>
      <tbody>
	      <c:forEach items="${toolPage.dataList}" var="carInOut" varStatus="status">
	      	 <tr>
	          <td>1</td>
	          <td>${carInOut.carNum}</td>
	          <td>${carInOut.idCard}</td>
	          <td>${carInOut.realname}</td>
	          <td>${carInOut.telephone}</td>
	          <td>${carInOut.parkingId}</td>
	          <td>${carInOut.startTime}</td>
	          <td>${carInOut.priceHour}</td>
	          <td>${carInOut.totalPrice}</td>
	        </tr>
	   	  </c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="#">上一页</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">下一页</a></li>
    </ul>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">确认删除</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定要删除该产品么?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <input type="button" class="btn btn-danger"  data-dismiss="modal" value="删除"/>
    </div>
</div>
                    
                 <footer>
                     <hr>
                     <p>&copy; 2012 <a href="http://www.good10000.com" target="_blank">北京万佳信科技有限公司</a></p>
                 </footer>
                    
            </div>
        </div>
    </div>
    


    <script src="${req.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


