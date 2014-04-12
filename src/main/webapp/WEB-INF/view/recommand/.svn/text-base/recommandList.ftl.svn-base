<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>推荐书籍列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="recommandList,推荐书籍列表">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<#--jQuery UI 要引入的js-->
	<link rel="stylesheet" href="${req.contextPath}/dialog/themes/base/jquery.ui.all.css">
	<script type="text/javascript" src="${req.contextPath}/dialog/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.position.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.resizable.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.dialog.js"></script>
	
    <script type="text/javascript"  src="${req.contextPath}/js/common.js" type="text/javascript"></script>
	<script type="text/javascript"  src="${req.contextPath}/js/recommand.js" type="text/javascript" ></script>
	<script type="text/javascript"  src="${req.contextPath}/js/json.js" type="text/javascript"></script>
	
	<script>
	
		$(function(){
		
		    // 提示信息			
			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/recommand/toRecommandList?recFlag="+${recFlag!0};
			}
			
		});
		
	</script>
	
	<style type="text/css" media="all">
		body { font-size: 100%; font-family: "宋体"}
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		div#users-contain { width: 700px; margin: 20px 0; }
		div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
		div#users-contain table td, div#users-contain table th { border: 1px solid #eee;   padding: .6em 10px; text-align: left; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips { border: 1px solid transparent; padding: 0.3em; }
		
		table td {font-size: 14px; width: 80px; text-overflow:ellipsis; overflow: hidden; white-space: nowrap;}
		table{border-collapse:collapse; table-layout: fixed; width:80%;}
		.big {width:700px;}
	</style>
  </head>

  <body>
  	<center>
  		<form action="" id="myForm" method="post" >
  			<input type="hidden" name="currentPage" value="${toolPage.currentPage}" />
  			<input type="hidden" id="data" name="data" value="" />
  			<input type="hidden" id="recIds" name="recIds" value=""/>
  			<input type="hidden" id="basePath" name="basePath" value="${req.contextPath}"/>
  			<input type="hidden" id="flag" name="flag" value="${recFlag!0}"/>
  			
  			查询条件：
  			<select id="recFlag" name="recFlag">
  				<option value="0">未处理</option>
  				<option value="1">处理中</option>
  				<option value="2">未通过</option>
  				<option value="3">购买中</option>
  				<option value="4">购买成功</option>
  				<option value="5">购买失败</option>
  			</select>
		  	<table align="center"  cellpadding="0" cellspacing="0" border="1">
				<tr><td colspan="13" align="center"><font size="5">推荐书籍列表</font></td></tr>
				<tr>
					<td align="center"><input type="checkbox" id="chooseAll" name="chooseAll" onclick="selORcancel('chooseAll','recId')"/></td>
					<td>序号</td>
					<td>图书名称</td>
					<td>图书作者</td>
					<td>图书出版社</td>
					<td>图书类别</td>
					<td>豆瓣链接</td>
					<td>图书购买链接</td>
					<td>图书单价</td>
					<td>推荐人</td>
					<td>推荐日期</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				
				<#if toolPage.dataList??>
					<#if (toolPage.dataList?size > 0)>
						<#list toolPage.dataList as recommand>
							<tr>
								<td align="center"><input type="checkbox" name="recId" value="${recommand.recId!}"/></td>
								<td align="center">${(toolPage.currentPage-1)*toolPage.pageSize+recommand_index+1}</td>
								<td title="${recommand.bookName!}">${recommand.bookName!}</td>
								<td>${recommand.bookAuthor!}</td>
								<td>${recommand.bookPublish!}</td>
								<td>${recommand.type.typeName!}</td>
								<td>${recommand.bookDouban!}</td>
								<td>${recommand.recUrl!}</td>
								<td>${recommand.bookPrice!}</td>
								<td>${recommand.user.user_realname!}</td>
								<td>${recommand.recDate?date}</td>
								<td>
									<#if recommand.recFlag == 0>
										未处理
									<#elseif recommand.recFlag == 1>
										处理中
									<#elseif recommand.recFlag == 2>
										未通过
									<#elseif recommand.recFlag == 3>
										购买中
									<#elseif recommand.recFlag == 4>
										购买成功
									<#elseif recommand.recFlag ==5>
										购买失败
									</#if>
								</td>
								<td>                                  
									<a href="${req.contextPath}/recommand/toUpdateRecommandPage?recId=${recommand.recId}&currentPage=${toolPage.currentPage}&recFlag=${recFlag}">修改</>
								</td>
							</tr>
		  				</#list>
					</#if>
				</#if>
				
				<br/>
				
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="13" align="center">
		            			<#--<input type="button" id="mySubmit" value="删除"/>-->
		            			第${toolPage.currentPage}页
		            			共${toolPage.pageCount}页
								${toolPage.firstPage}
								${toolPage.precursorPage}
								${toolPage.nextPage}
								${toolPage.lastPage}
		            			${toolPage.currentPage}/${toolPage.pageCount}页
		            		</td>
						<#else>
						<td height="35" colspan="13" align="center">暂时没有数据</td>
						
					</#if>
				</tr>
        		
		  	</table>
		  	<#if toolPage.dataList??>
			  	<div>
			  		            <#if recFlag==0>
			  				   更改状态: 
			  				    <input type="radio" name="state" value="1"/>处理中
			  				    <input type="button" id="bn_${recFlag}" class="ui-button ui-widget ui-state-default ui-corner-all" value="确认更改"/>
			  				    <input type="button" id="exportExcel" value="导出表格"/>
			  				    <#elseif recFlag==1>
			  				    更改状态:
			  				     <input type="radio" name="state" value="2"/>未通过
			  				    <input type="radio" name="state" value="3"/>购买中
			  				    <input type="button" id="bn_${recFlag}" value="确认更改"/>
			  				    <#elseif recFlag==3>
			  				    更改状态:<input type="radio" name="state" value="4"/>购买成功
			  				    <input type="radio" name="state" value="5"/>购买失败
			  				    <input type="button" id="bn_${recFlag}" value="确认更改"/>
			  				    <input type="button" id="exportExcel" value="导出表格"/>
			  				    <#elseif recFlag==4>
				  				    <input type="hidden" name="state" value="6"/>
				  				    <input type="button" id="income" value="入库">
				  				    <input type="button" id="exportExcel" value="导出表格"/>
			  				    </#if>
				</div>
		  	<#else>
		  	</#if>
		  	
		  	<div id="dialog-form" title="图书列表">
				<div id="users-contain" class="ui-widget">
					<h1>Existing Users:</h1>
					<table id="users" width="800">
						<thead>
							<tr class="ui-widget-header ">
								<th width="100">序号</th>
								<th width="80">图书名称</th>
								<th width="100">图书作者</th>
								<th width="120">图书出版社</th>
								<th width="120">图书类别</th>
								<th width="130">豆瓣链接</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
  		</form>
  </center>
  </body>
</html>