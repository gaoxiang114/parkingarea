$(function(){
	var book_id;
	//弹出窗口的方法，初始化数据
	$( "#selectReturnBook")
		.button()
		.click(function() {
				var bookId =$("#bookId").val();
				if(bookId==""){
					alert("请输入书藉编号");
					return;
				}
				
			$.ajax({
			     	type: "POST",
			     	url: $("#basePath").val()+"/borrow/toReturnBook",
			    	 data:"bookId="+bookId,
			    	 success: function(data){
			    		
			    		 if(data!=""){

				    		 var returnBook= JSON.parse(data);
				    		 book_id=returnBook.book_id;
				    		 $( "#users tbody" ).empty();
				    		 $("#users tbody").append( 
					    		 "+<tr>"
									+"<td colspan='2'>图书信息</td>"
								+"</tr>"
								+"<tr>"
									+"<td>图书编号</td>"
									+"<td>"+returnBook.book_id+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>书名</td>"
									+"<td>"+returnBook.book_name+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>作者</td>"
									+"<td>"+returnBook.book_author+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>类型</td>"
									+"<td>"+returnBook.type_name+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td clospan='2'>借阅人信息</td>"
								+"</tr>"
								+"<tr>"
									+"<td>用户名</td>"
									+"<td>"+returnBook.user_num+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>真实姓名</td>"
									+"<td>"+returnBook.user_realName+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>借书时间</td>"
									+"<td>"+returnBook.check_startTime+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>到期时间</td>"
									+"<td>"+returnBook.check_endTime+"</td>"
								+"</tr>"
								

						
				    		 );
				    		 $( "#dialog-form" ).dialog( "open" );
			    		 }else{
			    			 alert("借阅记录不存在");
			    		 }
			    		
			    	 }
			});
			
		 });
	//弹出的div
	$( "#dialog-form" ).dialog({
		autoOpen: false,
		height: 300,
		width: 720,
		modal: true,
		buttons: {
			"还书": function() {
				$.ajax({
			     	type: "POST",
			     	url: $("#basePath").val()+"/borrow/doReturnBook",
			    	 data: "bookId="+book_id,
			    	 success: function(data){
			    		 if(data!=""){
			    			 alert(data);
			    		 }
			    	 	window.location.href=$("#basePath").val()+"/borrow/toSearchReturnBookPage";
			   		 }
		    	});
				
				$( this ).dialog("close");
				//window.location.href=$("#basePath").val()+"/recommand/toRecommandList?recFlag="+$("#flag").val();
			},
			"返回": function() {
				$( this ).dialog("close");
			}
		},
		close: function() {
			allFields.val( "" ).removeClass( "ui-state-error" );
		}
	});
	
});