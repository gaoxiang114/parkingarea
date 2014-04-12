<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人员添加</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="add_user,人员添加,用户管理">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/common.js"></script>
	<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
		<script>

		// 提示信息			
		$(function(){
			if("${message!}" != ""){
				alert("${message}");
				window.location.href = "${req.contextPath}/role/toRolePageList?currentPage=${currentPage}";
			}
			
			var arr = ${data!};		
		//--------------------显示已勾选的---------------------------
			var funIds = document.getElementsByName("fun_id");//获取一级目录的数组
			for(var i=0;i<funIds.length;i++){
				var funId = funIds[i];
				var temp = "funId_"+funId.value;	
							
				var subFunIds = document.getElementsByName(temp);//获取二级目录数组
					
				$.each(subFunIds,function(m,item){
					$.each(arr,function(n,data){
				if(funId.value==data.funId){
					funId.checked = "true";
				}
						//var subTemp = subFunIds[m];//获取第三级目录数组
						var grandsons = document.getElementsByName("subFunId_"+subFunIds[m].value);
						//用二级目录数组与数据集相比较：若值相等则勾选
						if(item.value == data.funId){
								//alert("全选");
								item.checked="true";
								
								//当二级目录勾选时：若有三级目录则全勾选，若没有三级目录则不作操作！
								if(grandsons.length!=0){
									$.each(grandsons,function(j,grandson){
										if(grandson.value==data.funId)
										grandson.checked = "true";
									});
								}
						}else{
							//alert("没有全选")
							$.each(grandsons,function(u,uu){
								$.each(arr,function(v,vv){
									if(uu.value == vv.funId){
										uu.checked = "true";
									}
								});
							});
						}
					});
				});				
				
			}
			
			//提交校验
			$("#bn").click(function() {
				if($('input:checkbox:checked').length==0){			
					alert("请分配权限！");
					return false;
				}else{
				
				//获取勾选
					var allFunId = "";
					var funIds = document.getElementsByName("fun_id");//获取一级目录的数组
					
					for(var i=0;i<funIds.length;i++){
						var funId = funIds[i];
						
						if(funId.checked){
							allFunId = allFunId + funId.value + "&";
						}
						var temp = "funId_"+funId.value;
						var subFunIds = document.getElementsByName(temp);//获取二级目录数组
						//对二级目录数组进行遍历
						$.each(subFunIds,function(a,sub){
							var second = sub.value;
							if(sub.checked){
								
								allFunId = allFunId + second + "&";
								var third = document.getElementsByName("subFunId_" + second);
							
								if(third.length!=0){
									$.each(third,function(b,gs){
										if(gs.checked){
											allFunId = allFunId + gs.value + "&";
										}
									});
								}
								
							}else{
								var thirdother = document.getElementsByName("subFunId_" + second);
							
								if(thirdother.length!=0){
									$.each(thirdother,function(c,gos){
										if(gos.checked){
											allFunId = allFunId + gos.value + "&";
										}
									});
								}
							}
							
						});

					}
					$("#allFunIds").val(allFunId);
					if(confirm('是否确认?')) {
			 			 $("#frm").submit();
		  			}  	
				}
			});
		});
	</script>
  <body>
  权限分配：<br />
  ${message}<br/>
  <center>
  <form action="${req.contextPath}/division/updateDivisionPower" method="post" id="frm">
  <input type="hidden" name="roleId" value="${roleId}" />
  <input type="hidden" name="currentPage" value="${currentPage}" />
  <input type="hidden" name="allFunIds" id = "allFunIds" value="" />
  	<table border="1">
		<tr><td colspan="3">功能列表</td></tr>
		<tr>
			<td>流水号 </td>
			<td>功能名称</td>
			<td>分配权限</td>
		</tr>
		<#assign index=1 />
			<#list  secondLength?keys as key>
				<tr>
					<td rowspan="${secondLength[key]}">${key_index+1}</td>
					<td rowspan="${secondLength[key]}">
					<#list page as fun>
						<#if fun.funId==key>
							<input name="fun_id" id="fun_id" type="checkbox" value="${fun.funId}">${fun.funName}
						</td>
						<#if fun.child?if_exists>
							<#list fun.getChild() as son >
							
							<#assign index=index+1 />
								<td><input name="funId_${fun.funId}" id="${index}" type="checkbox" onclick = "selORcancel('${index}','subFunId_${son.funId}')" title="全选/全部选" value="${son.funId}">${son.funName}:							
									<#if son.child?if_exists>
										<#list son.getChild() as grandson >
											<input name="subFunId_${son.funId}" id="subFunId_${son.funId}" type="checkbox" value="${grandson.funId}">${grandson.funName}
										</#list>
									<#else>
										暂无三级目录	
									</#if>
								</td></tr><tr>
							</#list>
						<#else>
							<td>
								暂无二级目录	
							</td>
							</tr>
						</#if>
							</tr>
						</#if>
					</#list>
			</#list>
	  	<tr>
	  		<td colspan="3" align="right">
				<input type="button" id="bn" value="分配">	 
				<input type="button" value="返回" onclick="history.go(-1)" />			
	  		</td>
	  	</tr>
  	</table>
  </form>
  </center>

  </body>
</html>