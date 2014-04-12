$(function(){
	var bookName = $("#bookName");
	var bookAuthor = $("#bookAuthor");
	var bookPublish = $("#bookPublish");
	var bookDouban = $("#bookDouban");
	var recUrl = $("#recUrl");
	var flag = new Array();
	var result = true;
	
	bookName.bind("blur",function(){
		if(is_empty(bookName.val())){
			$("#msg1").html("<font color='red'>请输入书名</font>");
			flag[0] = false;
		}else if(!/^[a-zA-Z][a-zA-Z0-9_]{4,19}$/.test(bookName.val())){
			$("#msg1").html("<font color='red'>以字母开头，允许5-20字节，允许字母数字下划线</font>");
			flag[0] = false;
		}else{
			
			$.ajax({
		     	type: "POST",
		     	url: $("#basePath").val()+"/recommand/checkBookName",
		    	 data: "bookName="+$("#bookName").val(),
		    	 success: function(data){
		    		if(data == 1){
		    			$("#msg1").html("<font color='red'>该书名已经存在，不能再推荐了</font>");
		    			flag[0] = false;
		    		}else{
		    			$("#msg1").html("");
		    			flag[0] = true;
		    		}
		   		 }
	    	});
		}
		
		return flag[0]; 
	});
	
	bookAuthor.bind("blur",function(){
		if(is_empty(bookAuthor.val())){
			$("#msg2").html("<font color='red'>请输入作者</font>");
			flag[1] = false;
		}else if(!/^[a-zA-Z][a-zA-Z0-9_]{4,19}$/.test(bookAuthor.val())){
			$("#msg2").html("<font color='red'>以字母开头，允许5-20字节，允许字母数字下划线</font>");
			flag[1] = false;
		}else{
			$("#msg2").html("");
			flag[1] = true;
		}
		
		return flag[1]; 
	});
	
	bookPublish.bind("blur",function(){
		if(is_empty(bookPublish.val())){
			$("#msg3").html("<font color='red'>请输入出版社</font>");
			flag[2] = false;
		}else if(!/^[a-zA-Z][a-zA-Z0-9_]{4,20}$/.test(bookPublish.val())){
			$("#msg3").html("<font color='red'>以字母开头，允许5-20字节，允许字母数字下划线</font>");
			flag[2] = false;
		}else{
			$("#msg3").html("");
			flag[2] = true;
		}
		
		return flag[2]; 
	});
	
	///^(http:[/][/]v.youku.com[/]((v_show[/]id[_])|(v_playlist[/]))(\w+){13}([.]html))$/
	bookDouban.bind("blur",function(){
		
		var strRegex = "^((https|http|ftp|rtsp|mms)?://)"  
		       + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
		       + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184  
		       + "|" // 允许IP和DOMAIN（域名） 
		       + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.  
		       + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名  
	           + "[a-z]{2,6})" // first level domain- .com or .museum  
	           + "(:[0-9]{1,4})?" // 端口- :80  
		       + "((/?)|" // a slash isn't required if there is no file name  
		       + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
		       var re=new RegExp(strRegex);
		
		if(is_empty(bookDouban.val())){
			$("#msg5").html("<font color='red'>请输入豆瓣url</font>");
			flag[3] = false;
		}else if(!re.test(bookDouban.val())){
			$("#msg5").html("<font color='red'>输入地址无效</font>");
			flag[3] = false;
		}else{
			$("#msg5").html("");
			flag[3] = true;
		}
		
		return flag[3]; 
	});
	
	recUrl.bind("blur",function(){
		if(is_empty(recUrl.val())){
			$("#msg6").html("<font color='red'>请输入购买url</font>");
			flag[4] = false;
		}else{
			$("#msg6").html("");
			flag[4] = true;
		}
		
		return flag[4]; 
	});
	
	
	//给页面中的状态下拉列表赋默认值
	$("#recFlag").children("option").each(function(){
		var value = $(this).val();
		if($("#flag").val() == value){
			$(this).attr("selected",true);
		}
	});
	
	//按状态查询列表
	$("#recFlag").bind("change",function(){
		window.location.href = $("#basePath").val()+"/recommand/toRecommandList?recFlag="+$(this).val();
	});
	
	//批量删除的方法
	$("#mySubmit").bind("click",function(){
		var ids = returnCheckValue("recId");
		
		if(ids.length == 0){
			alert("请选择要删除的数据");
			return;
		}
		
		if(confirm("您确认要删除么？")){
			var myForm = document.getElementById("myForm");
			 myForm.action=$("#basePath").val()+"/recommand/doDelRecommand";
			 alert(myForm.action);
			 myForm.submit();
		}
		
	});
	
	//提交表单时的验证
	$("#bn").bind("click",function(){
		if(is_empty(bookName.val())){
			$("#msg1").html("<font color='red'>请输入书名</font>");
			return false; 
		}
		
		if(is_empty(bookAuthor.val())){
			$("#msg2").html("<font color='red'>请输入作者</font>");
			return false; 
		}
		
		if(is_empty(bookPublish.val())){
			$("#msg3").html("<font color='red'>请输入出版社</font>");
			return false; 
		}
		
		if(is_empty(bookDouban.val())){
			$("#msg5").html("<font color='red'>请输入豆瓣链接</font>");
			return false; 
		}
		
		if(is_empty(recUrl.val())){
			$("#msg6").html("<font color='red'>请输入购买地址</font>");
			return false; 
		}
		
		for(var i = 0; i< flag.length; i++){
			result = result&flag[i];
		}
		
		if(result){
			$("#myForm").submit();
		}
		
	});
	
	
	//修改状态的方法
	$("#bn_"+$("#flag").val()).bind("click",function(){
		
		var index = 0;
		var radios = document.getElementsByName("state");
		var ids = returnCheckValue("recId");
		var myForm = document.getElementById("myForm");
		myForm.action=$("#basePath").val()+"/recommand/doUpdateProcedure";
		
		 if(ids.length == 0){
			 alert("请选择要处理的数据");
			 return;
		 }
		 
		 for(var i=0;i<radios.length;i++){
		   	if(radios[i].checked == true){
		   		index++;
		   	}
		 }
		   
		 if(index == 0){
		   	alert("请选择点选按钮");
		   	return;
		 }
		
		 if(confirm("您确认要修改么？")){
			
			 myForm.submit();
		 }
	});
	
	//弹出窗口的方法，初始化数据
	$( "#income" )
		.button()
		.click(function() {
			var recId = returnCheckValue("recId");
			if(recId.length==0){
				alert("请选择入库的数据");
				return;
			}
			
				$.ajax({
			     	type: "POST",
			     	url: $("#basePath").val()+"/recommand/toStorageBook",
			    	 data: "recId="+recId,
			    	 success: function(data){
			    	$("#data").val(data.split("&")[0]);
			    	$("#recIds").val(data.split("&")[1]);
			    	 	content=JSON.parse(data.split("&")[0]);
			    	 	$( "#users tbody" ).empty();
			    	 	$.each(content,function(i,item){
				     		$("#users tbody").append( "<tr>" +
							"<td>" + item.id + "</td>" + 
							"<td>" + item.name + "</td>" + 
							"<td>" + item.author + "</td>" +
							"<td>" + item.publish + "</td>" +
							"<td>" + item.publish + "</td>" + 
							"<td>" + item.doban + "</td>" + 
							"</tr>" ); 
				     	});
			   		 }
		    	});
		    
			$( "#dialog-form" ).dialog( "open" );
	});
	
	$( "#exportExcel" ).bind("click",function(){
		$.ajax({
	     	type: "POST",
	     	url: $("#basePath").val()+"/recommand/exportExcel",
	    	 data: "state="+$("#flag").val(),
	    	 success: function(data){
	   		 }
    	});
	});
	
	//弹出的div
	$( "#dialog-form" ).dialog({
		autoOpen: false,
		height: 500,
		width: 820,
		modal: true,
		buttons: {
			"确定": function() {
				$.ajax({
			     	type: "POST",
			     	url: $("#basePath").val()+"/recommand/doStorageBook",
			    	 data: "data="+$("#data").val()+"&recIds="+$("#recIds").val(),
			    	 success: function(data){
			    	 	window.location.href=$("#basePath").val()+"/recommand/toRecommandList?recFlag="+$("#flag").val();
			   		 }
		    	});
				
				$( this ).dialog("close");
				window.location.href=$("#basePath").val()+"/recommand/toRecommandList?recFlag="+$("#flag").val();
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