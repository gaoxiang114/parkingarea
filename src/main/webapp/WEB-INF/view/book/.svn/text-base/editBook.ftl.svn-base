<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${req.contextPath}/js/book.js"></script>
		<script type="text/javascript" src="${req.contextPath}/js/json.js"></script>
		<script language="javascript">
		$(function(){
	      /*  $("#largeType").children("option").each(function(){
		        var defaultValue=$(this).val();
		        if(${book.type.fatherTypeId!}==defaultValue){
		            $(this).attr("selected",true);
		        }
		    });
		    */
		    
		     $("#typeId").children("option").each(function(){
		        var defaultValue=$(this).val();
		        if(${book.type.typeId!}==defaultValue){
		            $(this).attr("selected",true);
		        }
		    });
		           
		  /*	$("#largeType").bind("change",function(){
				$.ajax({
			     	type: "POST",
			     	url: "${req.contextPath}/book/selectTypeByFatherId",
			    	 data: "typeId="+$(this).val(),
			    	 success: function(data){
			    	 
				  	 //  var content = eval('(' + data + ')');
				       var typeList = JSON.parse(data);              //将字符串解析
				   	   $("#typeId").empty();
				       $.each(typeList,function(i,item){
				     		
				     		 $("<option></option>")
		                    .val(item["typeId"])
		                    .text(item["typeName"])
		                    .appendTo($("#typeId"));
	
				     		
				     	});
			     	}
			   });
			
			}); 
		 */
			$("#bookCheckFlag").bind("change",function(){
				
				var bookCheckFalg=$(this).val();
				
				if(bookCheckFalg==0) $("#bookIsOrder option[value='1']").attr("selected","true");
				//$("#bookIsOrder").val(1);
			});
			
			$("#bookIsOrder").bind("change",function(){
				
				var bookIsOrder=$(this).val();
				
				if(bookIsOrder==0) $("#bookCheckFlag option[value='1']").attr("selected","true");
				
			});
		                 
		});
		
	
		
		</script>
	</head>
	<body>
	<form action="${req.contextPath}/book/editBook" method="post" id="editBook">
	<input type="hidden" name="currentPage" value="${currentPage}">
    	<table>
    		<tr>
	    		<td>图书编号:</td>
	    		<td>
	    			<input type="text" id="id" name="id" value="${book.id}" readonly/>
	    		</td>
	    		<td></td>
	    	</tr>
	    	<tr>
	    		<td>书      名   :</td>
	    		<td>
	    			<input type="text" id="name" name="name" value="${book.name}" />
	    		</td>
	    		<td><span id="nameMsg"></span></td>
	    	</tr>
	    	<tr>
		 		<td>类       别   ：</td>
		 		<td>
		 			<#--<input type="text" name="type.typeId" value="${book.type.typeName}"/>-->
		 			<#--<select id="largeType" name="largeType">
		 				<#list largeType as type>
		 					<option value="${type.typeId}">${type.typeName}</option>
		 				</#list>
		 			-->
		 			</select>
		 			<select id="typeId" name="type.typeId">
		 				<#list sameType as type>
		 					<option value="${type.typeId}">${type.typeName}</option>
		 				</#list>
		 			</select>
		 		</td>
		 		<td></td>
	       	</tr>
	       	<tr>
	       	 	<td>作       者   ：</td>
	       	 	<td>
	       	 		<input type="text" id="author" name="author" value="${book.author}" />
	       	 	</td>
	       	 	<td><span id="authorMsg"></span></td>
	       	</tr>
	       	<tr>
	       		<td>出  版  社  ：</td>
	       		<td>
	       			<input type="text" id="publish" name="publish" value="${book.publish}" />
	       		</td>
	       		<td><span id="publishMsg"></span></td>
	       	</tr>
	       	<tr>
	       		<td>豆瓣链接  ：</td>
	       		<td>
	       			<input type="text" id="doban" name="doban" value="${book.doban}" />
	       		</td>
	       		<td><span id="dobanMsg"></span></td>
	      	</tr>
	      	<tr>
	      		<td>借阅状态  ：</td>
	      		<td>
	      			
	      			<select name="bookCheckFlag" id="bookCheckFlag">
	      				
	      	 			<#if book.bookCheckFlag==0>
	      	 				<option value="0" selected="selected">可借</option>
	      	 			<#else>
	      	 				<option value="0">可借</option>
	      	 			</#if>
	      	 			<#if book.bookCheckFlag==1>
	      	 				<option value="1" selected="selected">不可借</option>
	      	 			<#else>
	      	 				<option value="1">不可借</option>
	      	 			</#if>	
	      	 			
	      	 		</select>
	      		</td>
	      	</tr>
	      	<tr>
	      	 	<td>预定状态  :</td>
	      	 	<td>
	      	 		
					<select name="bookIsOrder" id="bookIsOrder">
	      	 			<#if book.bookIsOrder==0>
	      	 				<option value="0" selected="selected">可预定</option>
	      	 			<#else>
	      	 				<option value="0">可预定</option>
	      	 			</#if>
	      	 			<#if book.bookIsOrder==1>
	      	 				<option value="1" selected="selected">不可预定</option>
	      	 			<#else>
	      	 				<option value="1">不可预定</option>
	      	 			</#if>	
	      	 		</select>
	      	 	</td>
	        </tr>
	        <tr>
	            <td><input type="button"  value="保存" id="sub"/></td>

	        	<td><input type="button" onclick="history.go(-1)" value="返回" /></td>
	        </tr>

		</tale>
    </form>
	</body>
</html>