<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${user.username}
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="${req.contextPath}/manager/user/toEditPasswdPage">修改密码</a></li>
                            <li><a tabindex="-1" href="${req.contextPath}/manager/loginOut">注销</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.html"><span class="second">停车场管理系统</span></a>
        </div>
    </div>
    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard">${parkingLot}</i></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li id="1"><a href="${req.contextPath}/carInOut/carInOutList">进出车管理</a></li>
            <li id="2"><a href="${req.contextPath}/position/positionList">停车位管理</a></li>
            <li id="3"><a href="${req.contextPath}/carInOut/historyList">历史管理</a></li>
            <li id="4"><a href="${req.contextPath}/admin/systemInfo">系统设置</a></li>
            <li id="5">
            	<a href="#accounts-menu" data-toggle="collapse">统计分析</a>
            	<ul id="accounts-menu" class="nav nav-list collapse">
		            <li id="6"><a href="${req.contextPath}/carInOut/parkCarReport">停车数量统计</a></li>
		            <li id="7"><a href="${req.contextPath}/carInOut/parkMoneyReport">停车费用统计</a></li>
       			</ul>	
            </li>
        </ul>

        <!--  <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户管理</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li id="6"><a href="#?tab=5">注销</a></li>
            <li id="7"><a href="#?tab=6">重置密码</a></li>
        </ul>
        -->
    </div>
    
  	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".sidebar-nav ul li").each(function(){
				$(this).removeClass();
			});
			$(".sidebar-nav ul li").each(function(index,item){
				if(item.id == "${tab}"){
					item.className="active";
				}
			});
		});
	</script>