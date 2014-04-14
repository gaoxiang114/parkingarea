<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>万佳信后台管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${req.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${req.contextPath}/css/theme.css">
    <link rel="stylesheet" href="${req.contextPath}/css/font-awesome/css/font-awesome.css">
	<script type="text/javascript" src="${req.contextPath}/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="${req.contextPath}/ckfinder/ckfinder.js"></script>
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
  	<script>
  		function mySubmit(){
  			$("#myForm").submit();
  		}
  	</script>
  </head>

  <body class=""> 
    <%@ include file="menu.jsp"%>
    <div class="content">
			        <div class="header">
			            
			            <h1 class="page-title">公司信息管理</h1>
			        </div>
			        
			                <ul class="breadcrumb">
			            <li><a href="${req.contextPath}/manager/user/index">主页</a> <span class="divider">/</span></li>
			            <li>系统管理<span class="divider">/</span></li>
			            <li class="active">公司信息管理</li>
			        </ul>
			
			        <div class="container-fluid">
			            <div class="row-fluid">
			                    
				
					<div class="well">
					    <div id="myTabContent" class="tab-content">
					      <div class="tab-pane active in" id="home">
							    <form id="myForm" action="${req.contextPath}/manager/company/companyInfoUpdate" method="post">
							        <input type="hidden" name="id" value="${company.id}"/>
							        <label>公司名称</label>
							        <input type="text" name="companyName" style="width:300px" value="${company.companyName}">
							        <label>公司地址</label>
							        <input type="text" name="companyAddress" style="width:300px" value="${company.companyAddress}" class="input-xlarge">
							         <label>公司传真</label>
							        <input type="text" name="companyFax" style="width:300px" value="${company.companyFax}" class="input-xlarge">
							         <label>公司行政邮箱</label>
							        <input type="text" name="companyEmail" style="width:300px" value="${company.companyEmail}" class="input-xlarge"><br>
									<button style="margin-left:240px" class="btn btn-primary" onclick=""><i class="icon-save"></i>&nbsp;保存</button>
							    </form>
					      </div>
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


