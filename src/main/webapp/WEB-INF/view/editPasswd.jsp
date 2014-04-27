<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>停车场管理信息系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${req.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${req.contextPath}/css/theme.css">
    <link rel="stylesheet" href="${req.contextPath}/css/font-awesome/css/font-awesome.css">

	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
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
  </head>

  <body class=""> 
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">欢迎您</span> <span class="second"></span></a>
        </div>
    </div>
    
    <div class="row-fluid">
    <div class="dialog"> 
        <div class="block">
            <p class="block-heading">密码修改</p>
            <div class="block-body">
                <form method="post" id="myFrm" action="${req.contextPath}/manager/user/doEditPasswd">
                    <label>原密码：</label>
                    <input type="password" name="oldPasswd" id="oldPasswd" class="span12">
                    <label>确认密码：：</label>
                    <input type="password" name="againPasswd" id="againPasswd" class="span12">
                    <label>新密码：：</label>
                    <input type="password" name="newPasswd" id="newPasswd" class="span12">
                    <input type="button" id="sub" class="btn btn-primary pull-right" value="修改"/>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>

    <script src="${req.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
        	
        	$("#sub").click(function(){
        		var oldPasswd = $("#oldPasswd").val();
            	var againPasswd = $("#againPasswd").val();
            	var newPasswd = $("#newPasswd").val();
            	var matter = /^[a-zA-Z]\w{5,17}$/;
            	if(is_empty(oldPasswd)){
            		alert("请输入原密码!");
            		return false;
            	}
            	if(is_empty(againPasswd)){
            		alert("请输入确认密码!");
            		return false;
            	}
            	if(oldPasswd != againPasswd){
            		alert("两次密码输入的不一致，请重新输入！");
            		return false;
            	}
            	if(is_empty(newPasswd)){
            		alert("请输入新密码!");
            		return false;
            	}
            	if(is_empty(newPasswd)){
            		alert("请输入新密码!");
            		return false;
            	}
            	$("#myFrm").submit();
        	});
        	
        });
    </script>
    
  </body>
</html>


