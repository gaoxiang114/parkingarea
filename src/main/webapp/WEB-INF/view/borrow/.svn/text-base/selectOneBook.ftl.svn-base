<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script type="text/javascript" src="${req.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${req.contextPath}/js/borrow_book.js"></script>
		<script language="javascript">
		$(function(){
			<#if message!=null>
			
				alert ("${message}");
				window.location.href="${req.contextPath}/book/selectBookListFront?currentPage=${currentPage}"
			</#if>
			
			$("#borrowBook").click(function(){
				if(confirm("是否确认要借这本书？")){
					
					window.location.href="${req.contextPath}/borrow/addBorrowRecord?bookId=${book.id!}&currentPage=${currentPage}";
				}
			});
			
			$("#preorder").click(function(){
				if(confirm("是否确认要预定这本书？")){
					
					window.location.href="${req.contextPath}/order/addOrder?bookId=${book.id!}&currentPage=${currentPage}";
				}
			});
			
		});
		</script>

	</head>
	<body>
		<form action="${req.contextPath}/book/editBook" method="post" id="editBook">
			<input type="hidden" name="currentPage" value="${currentPage!}">
	    	<table>
	    		<tr>
		    		<td>书      名   :</td>
		    		<td>
		    			${book.name!}
		    		</td>
		    	</tr>
	    		<tr>
		    		<td>图书编号:</td>
		    		<td>
		    			${book.id!}
		    		</td>
		    	</tr>
		    	<tr>
			 		<td>类       别   ：</td>
			 		<td>
			 			${book.type.typeName!}
			 		</td>
		       	</tr>
		       	<tr>
		       	 	<td>作       者   ：</td>
		       	 	<td>
		       	 		${book.author!}
		       	 	</td>
		       	</tr>
		       	<tr>
		       		<td>出  版  社  ：</td>
		       		<td>
		       			${book.publish!}
		       		</td>
		       	</tr>
		       	<tr>
		       		<td>豆瓣书评  ：</td>
		       		<td>
		       			${book.doban!}
		       		</td>
		      	</tr>
		      	<tr>
		      		<td>借阅状态  ：</td>
		      		<td>
		      	 			<#if book.bookCheckFlag==0>
		      	 				可借
		      	 			<#else>
		      	 				不可借
		      	 			</#if>
		      		</td>
		      	</tr>
		        <tr>
		       		<#if book.bookCheckFlag==1>
		           		<td><input type="button"  value="借书" id="" disabled="disabled" id="borrowBook"/></td>
		           	<#else>
		           		<td><input type="button"  value="借书" id="borrowBook"/></td>
					</#if>
		        	<#if book.bookIsOrder==1>
		        		<td><input type="button" onclick="" value="预借" disabled="disabled" id="preorder"/></td>
		        	<#else>
		        		<td><input type="button" onclick="" value="预借" id="preorder"/></td>
		        	</#if>
		        </tr>
	
			</tale>
	    </form>
	</body>
</html>