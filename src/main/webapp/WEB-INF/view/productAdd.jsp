<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>万佳信后台管理系统 </title>
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
	<script src="${req.contextPath}/js/common.js" type="text/javascript"></script>
	<script>
  		function mySubmit(){
  			var proTitle = $("#proTitle");
  			var editor_data = CKEDITOR.instances.editor1.getData();
  			if(is_empty(proTitle.val())){
  				alert("请输入标题");
  				proTitle.focus();
  				return false;
  			}
  			
  			if(is_empty(editor_data)){
  				alert("请输入内容");
  				CKEDITOR.instances.editor1.focus();
  				return false;
  			}
  			return true;
  		}
 	 </script>
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
			            
			            <h1 class="page-title">产品添加</h1>
			        </div>
			        
			                <ul class="breadcrumb">
			            <li><a href="${req.contextPath}/manager/user/index">主页</a> <span class="divider">/</span></li>
			            <li><a href="${req.contextPath}/manager/product/productList">产品列表</a> <span class="divider">/</span></li>
			            <li class="active">产品添加</li>
			        </ul>
			
			        <div class="container-fluid">
			            <div class="row-fluid">
			                    
				
					<div class="well">
					    <div id="myTabContent" class="tab-content">
					      <div class="tab-pane active in" id="home">
							    <form id="myForm" action="${req.contextPath}/manager/product/doProductAdd" method="post" onsubmit="return mySubmit();">
							        <label>标题</label>
							        <input type="text" id="proTitle" name="proTitle" value="" class="input-xlarge">
							        <label>内容</label>
							        <textarea id="editor1" name="proContent" class="ckeditor" rows="10" cols="80"></textarea>
							        <label>产品图标地址</label>
							        <input type="text" id="imageUrl" name="imageUrl" value="" class="input-xlarge">
							        <label>首页显示设置</label>
							        <label class="radio">
									  <input type="radio" name="isShow" id="optionsRadios1" value="0" checked>
									  显示
									</label>
									<label class="radio">
									  <input type="radio" name="isShow" id="optionsRadios2" value="1">
									  不显示
									</label>
									 <button class="btn btn-primary"><i class="icon-save"></i>&nbsp;保;存</button>
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


