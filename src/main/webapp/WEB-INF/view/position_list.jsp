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
	<script src="${req.contextPath}/js/common.js" type="text/javascript"></script>
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
  		function positionAdd(){
  			window.location.href="${req.contextPath}/position/toPositionAdd";
  		}
  		
  		$(function(){
  			$("#mySubmit").click(function(){
				var ids = returnCheckValue("parkingId");
				
				if(ids.length==0){
					alert("请勾选要删除的数据");
					return;
				}
				
				if(confirm("您确认要删除么？")){
					$("#myForm").submit();
				}
				
			});
  		});
  	</script>
  </head>

  <body class=""> 
    <%@ include file="menu.jsp"%>
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">停车位管理</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="${req.contextPath}/manager/user/index">主页</a> <span class="divider">/</span></li>
            <li class="active">停车位管理</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
	<div class="btn-toolbar">
	    <button class="btn btn-primary" onclick="positionAdd();"><i class="icon-plus"></i>新增</button>
	</div>
<div class="well">
	<form action="${req.contextPath}/position/positionList" method="post" id="searchFrm" style="margin-left: 108px;">
            <div style="width:908px">
				<span style="font-size:18px">&nbsp;&nbsp;&nbsp;查询条件：&nbsp;&nbsp;&nbsp;</span>
				<input type="text" id = "parkingNum" class="input-block-level" placeholder="请输入停车位名称" name="parkingNum" style="width:200px" />
				<select name="parkingStatus">
					<option value="">===请选择===</option>
					<option value="2">空闲</option>
					<option value="1">占用</option>
				</select>
				<input type="button" value="搜索" class="btn" id="bn" style="margin-bottom:10px"/>
			</div>
   </form>
   <form  action="${req.contextPath}/position/delPosition" method="post" id="myForm">
	    <table class="table table-bordered table-hover">
	      <thead>
	        <tr>
	          <th><input name="chooseAll" id="chooseAll" type="checkbox" title="全选/全部选" onClick= "selORcancel('chooseAll','parkingId')"></th>
	          <th>停车位</th>
	          <th>状态</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
		      <c:forEach items="${toolPage.dataList}" var="position" varStatus="status">
		      	 <tr>
		          <td><input type="checkbox" name="parkingId" value="${position.parkingId}"/></td>
		          <td>${position.parkingNum}</td>
		          <td>
					<c:choose>
						<c:when test="${position.parkingStatus == 2 }">
							空闲
						</c:when>
						<c:otherwise>
							占用
						</c:otherwise>
					</c:choose>
		          </td>
		          <td>
			          	<c:choose>
							<c:when test="${position.parkingStatus == 2 }">
								<a href="${req.contextPath}/position/toPositionUpdate?parkingId=${position.parkingId}">修改</a>
							</c:when>
							<c:otherwise>
								修改(<font color="red">占用时不可修改</font>)
							</c:otherwise>
						</c:choose>
						<c:if test="${position.parkingStatus == 2}">
							&nbsp;<a href="${req.contextPath}/carInOut/toCarInOutAdd?parkingId=${position.parkingId}">停车</a>
						</c:if>
					</td>
		        </tr>
		   	  </c:forEach>
	      </tbody>
	    </table>
	    <div class="pagination pagination-right">
	    <input type="button" value="删除" style="float:left" class="btn btn-primary" id="mySubmit"/>
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
    </script>
    
  </body>
</html>


