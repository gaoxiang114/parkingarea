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
		
		<link rel="stylesheet" href="${req.contextPath}/dialog/themes/base/jquery.ui.all.css">
		<link rel="stylesheet" href="${req.contextPath}/dialog/css/demos.css">
		<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript"  src="${req.contextPath}/js/common.js" type="text/javascript"></script>
		<script type="text/javascript"  src="${req.contextPath}/js/returnBook.js" type="text/javascript" ></script>
		<script type="text/javascript"  src="${req.contextPath}/js/json.js" type="text/javascript"></script>
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
		<style type="text/css" media="all">
		body { font-size: 62.5%; }
		label, input { display:block; }
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		div#users-contain { width: 700px; margin: 20px 0; }
		div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
		div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips { border: 1px solid transparent; padding: 0.3em; }
		table{border-collapse:collapse;}
		.big {width:700px;}
	</style>
	
	</head>
	<body>
	
		
		<form action="${req.contextPath}/borrow/toReturnBook" method="post" id="returnBook">
			<input type="hidden" id="basePath" name="basePath" value="${req.contextPath}"/>
			<table>
				<tr>
					<td>请输入图书编号：</td>
					<td><input type="text" id="bookId" name="bookId"/></td>
				</tr>
				
		        <tr>
		            <td><input type="button"  value="还书" id="selectReturnBook"/></td>
	
		        	<td><input type="reset" value="重置" /></td>
		        </tr>

			</table>
			<div id="dialog-form" title="图书列表">
				<div id="users-contain" class="ui-widget">
					<h1>借书信息</h1>
					<table id="users" width="800">
						<thead>
					    </thead>
						<tbody>
							
						</tbody>
					</table>
				</div>
			</div>
   		</form>
   		
	</body>
</html>