<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>我推荐列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="recommandList,推荐书籍列表">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="${req.contextPath}/dialog/themes/base/jquery.ui.all.css">
	<link rel="stylesheet" href="${req.contextPath}/dialog/css/demos.css">
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js" type="text/javascript"></script>
	<script type="text/javascript" src="${req.contextPath}/js/recommand.js" type="text/javascript" ></script>
	<script type="text/javascript" src="${req.contextPath}/js/json.js" type="text/javascript"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.mouse.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.draggable.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.position.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.resizable.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.dialog.js"></script>
	<script type="text/javascript" src="${req.contextPath}/dialog/ui/jquery.ui.effect.js"></script>
	<script type="text/javascript">
	</script>
	<style type="text/css" media="all">
		table{border-collapse:collapse; table-layout: fixed; width:80%;}
	</style>
  </head>

  <body>
  	<center>
  		<form action="" id="myForm" method="post" >
  			<input type="hidden" name="currentPage" value="${toolPage.currentPage}" />
  			<input type="hidden" id="data" name="data" value="" />
  			<input type="hidden" id="recIds" name="recIds" value=""/>
  			<input type="hidden" id="basePath" name="basePath" value="${req.contextPath}"/>
  			
		  	<table align="center"  cellpadding="0" cellspacing="0" border="1">
				<tr>
					<td align="center"><input type="checkbox" id="chooseAll" name="chooseAll" onclick="selORcancel('chooseAll','recId')"/></td>
					<td>序号</td>
					<td>图书名称</td>
					<td>图书作者</td>
					<td>图书出版社</td>
					<td>图书类别</td>
					<td>豆瓣链接</td>
					<td>图书购买链接</td>
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
										处理中
									<#elseif recommand.recFlag == 4>
										处理中
									<#elseif recommand.recFlag ==5>
										未通过
									<#elseif recommand.recFlag ==6>
										已入库
									</#if>
								</td>
								<td align="center">
									<#if recommand.recFlag ==6>               
										<a href="dddd">借书</>
									<#else>
									<font color='#CCC'>借书</font>
									</#if>
									<#if recommand.recFlag == 0>
										<a href="${req.contextPath}/recommand/doDelRecommand?recId=${recommand.recId}&currentPage=${toolPage.currentPage}">取消</>
										<#else>
										<font color='#CCC'>取消</font>
									</#if>
								</td>
							</tr>
		  				</#list>
					</#if>
				</#if>
				
				<br/>
				
				<tr bgcolor="#EEF4EA">
					<#if toolPage.dataList??>
		            		<td height="35" colspan="12" align="center">
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
						<td height="35" colspan="12" align="center">暂时没有数据</td>
						
					</#if>
				</tr>
        		
		  	</table>
  		</form>
  </center>
  </body>
</html>