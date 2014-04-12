$(function(){
	var reg_mail = /^[a-zA-Z][a-zA-Z_]{3,24}$/;
	 
	$("#user_mail").bind("blur",function(e){
		  var val = this.value;
		  if(val == "")
		  $("#mailMsg").html("<font color='red'>邮箱不能为空！</font>");
		  else{
			  if(!reg_mail.test(val)){
				  $("#mailMsg").html("<font color='red'>邮箱输入格式有误！</font>");
			  }else {
					$("#mailMsg").html("邮箱为以字母开头，长度为4-25个字符，包括字母和下划线");
			  	}
		  }		  
	  });
	
	$("#butn").click(function() {
		if($("#user_mail")==0){
			$("#mailMsg").html("<font color='red'>输入不能为空！</font>");
			/* alert("邮箱不能为空!");*/
			return false;
		} 
		if(!reg_mail.test($("#user_mail").val())){
			$("#mailMsg").html("<font color='red'>邮箱输入格式有误！</font>");
			/*alert("邮箱格式输入有误！");*/
			return false;
		}
		
		if(confirm('是否确认?')) {
			$("#frm1").submit();
		}  
		
	});
	
	
	
	
	//弹出窗口的方法，初始化数据
	$( "#income" )
		.button()
		.click(function() {	 
			
/*		 	$( "#userpwd tbody" ).empty();
	 		$("#userpwd tbody").append( "<tr><td>当前密码：</td><td></td></tr>" +
	 		"<tr><td><input type='password' name='oldpwd' id='oldpwd' /></td><td><span id='newMsg'></span></td></tr>" + 
			"<tr><td>新密码（字母或数字，至少6字符）：</td></tr>" +
			"<tr><td><input type='password' name='newpwd' id='newpwd' /></td><td><span id='checkMsg'></span></td</tr>" +
			"<tr><td>确认新密码：</td></tr>" + 
			"<tr><td><input type='password' name='checkpwd' id='checkpwd' /></td><td><span id='checkMsg'></span></td></tr>");
     */		
			$( "#dialog-form" ).dialog( "open" );
	});
	
	//弹出的div
	$( "#dialog-form" ).dialog({
		autoOpen: false,
		height: 500,
		width: 736,
		modal: true,
		buttons: {
			"确定": function() {
				var reg_pwd = /^[a-zA-Z0-9]{6,15}$/;
				if($("#oldpwd").val()==""){
					$("#oldMsg").html("<font color='red'>原密码不能为空！</font>");
					return false;
				}
				if($("#newpwd").val()==""){
					$("#newMsg").html("<font color='red'>密码输入不能为空！</font>");
					return false;
				}
				if($("#checkpwd").val()==""){
					$("#checkMsg").html("验证密码必须与新密码保持一致！");
					return false;
				}
				if(!reg_pwd.test($("#oldpwd").val())){
					$("#oldMsg").html("<font color='red'>原密码输入格式有误！</font>");
					return false;
				}
				if(!reg_pwd.test($("#newpwd").val())){
					$("#newMsg").html("<font color='red'>新密码输入格式有误！</font>");
					return false;
				}
				if($("#newpwd").val()!=$("#checkpwd").val()){
					$("#checkMsg").html("<font color='red'>验证密码与新密码不一致！</font>");
					return false;
				}

				
				
				
				
				$.ajax({
			     	type: "POST",
			     	url: $("#basePath").val()+"/user/updateUserPassword",
			    	 data: "user_id="+$("#user_id").val()+"&oldpwd="+ $("#oldpwd").val()+ "&newpwd="+ $("#newpwd").val()+"&checkpwd="+ $("#checkpwd").val(),
			    	 success: function(result){
			    		 alert("修改成功！");
			    	 	window.location.href=$("#basePath").val()+"/user/getPersonMessage?userId=" + $("#user_id").val();
			   		 }
		    	});
				
				$( this ).dialog("close");
				window.location.href=$("#basePath").val()+"/user/getPersonMessage?userId=" + $("#user_id").val();
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


