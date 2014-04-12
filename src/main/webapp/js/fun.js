$(function(){
	var fun_name = $("#funName")
	  , fun_url = $("#funUrl")
	  , reg_name =/^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]){2,10}$/
	  , reg_url =/^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	
	fun_name.bind("blur",function(e){
		  var val = this.value;
		  if($("#funName").val()==""){
			$("#nameMsg").html("<font color='red'>功能名称不能为空！</font>");
		  }else{
			if(reg_name.test(val)){
				$("#nameMsg").html("功能名称为2-10个中文字符");
			}else {
				$("#nameMsg").html("<font color='red'>功能名称输入格式有误！</font>");
		  	}
		  }
	  });	  
	  fun_url.bind("blur",function(e){
		  var val = this.value;
		  if(val == "")
		  $("#urlMsg").html("<font color='red'>URL地址不能为空！</font>");
		  else{
			  if(!reg_url.test(val)){
				  $("#urlMsg").html("<font color='red'>URL地址输入格式有误！</font>");
			  }else {
					$("#urlMsg").html("url地址以http://开头");
			  	}
		  }		  
	  });
	  
	  $("#bn").click(function() {
		  if($("#funName").length==0&&$("#funUrl").length==0){
			  $("#nameMsg").html("<font color='red'>输入不能为空！</font>");
			  return false;
		  }else{
			  if(!reg_name.test($("#funName").val())){
				  $("#nameMsg").html("<font color='red'>功能名称输入格式有误！</font>");
				  return false;
			  }else{
				  if(!reg_url.test($("#funUrl").val())){
					  $("#urlMsg").html("<font color='red'>URL输入格式有误！</font>");
					  return false;
				  }
			  }
			  
		  }  

		  if(confirm("是否确认?")) {
			  $("#frm").submit();
		  }  
	  });
	  
});


