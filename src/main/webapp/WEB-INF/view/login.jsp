<%@ page contentType="text/html;charset=UTF-8"%>
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
                <a class="brand" href="index.html"><span class="first">北京</span> <span class="second">万佳信</span></a>
        </div>
    </div>
    
    <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">北京万佳信科技有限公司</p>
            <div class="block-body">
                <form method="post" action="${req.contextPath}/manager/login">
                    <label>用户名：</label>
                    <input type="text" name="username" class="span12">
                    <label>密  码：</label>
                    <input type="password" name="passwd" class="span12">
                    <input type="submit" class="btn btn-primary pull-right" value="登录"/>
                    <label class="remember-me"><input type="checkbox"> 记住我</label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p><a href="reset-password.html">忘记密码?</a></p>
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


