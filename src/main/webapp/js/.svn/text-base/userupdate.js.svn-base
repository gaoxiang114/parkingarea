$(function(){
	var user_num = $("#user_num")
	  , user_realname = $("#user_realname")
	  , user_mail = $("#user_mail")
	  , reg_num = /^(cy|sx|CY|SX|sX|Sx|cY|Cy)[0-9]{4}$/
	  , reg_realname =/^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]){2,6}$/
	  , reg_mail = /^[a-zA-Z][a-zA-Z_]{3,24}$/;
		  
	  user_num.bind("blur", function(e){
	  	var val = this.value;
	  	if(val == "") {
	  		$("#numMsg").html("<font color='red'>员工编号不能为空！</font>");
		} else {
	  		if(!reg_num.test(val)) {
		  		$("#numMsg").html("<font color='red'>员工编号输入格式有误！</font>");
		  	}else {
				$("#numMsg").html("员工编号为正式员工或实习员工编号 . 如：CY1234");
		  	}
	  	}
	  });	
	  
	  user_realname.bind("blur",function(e){
		  var val = this.value;
		  if(val == ""){
			$("#nameMsg").html("<font color='red'>姓名不能为空！</font>");
		  }else{
			if(!reg_realname.test(val)){
				$("#nameMsg").html("<font color='red'>真实姓名输入格式有误！</font>");
			}else {
				$("#nameMsg").html("员工姓名为2-6中文字符");
		  	}
		  }
	  });	  
	  user_mail.bind("blur",function(e){
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
	  
	  
	  $("#bn").click(function() {
		  if($("#user_num").length==0&&$("#user_realname").length==0&&$("#user_mail")==0){
			  $("#nameMsg").html("<font color='red'>输入不能为空！</font>");
			  return false;
		  }
		  if(!reg_num.test($("#user_num").val())){
			  $("#numMsg").html("<font color='red'>员工编号输入格式有误！</font>");
			  return false;
		  }
		  if(!reg_realname.test($("#user_realname").val())){
			  $("#nameMsg").html("<font color='red'>真实姓名输入格式有误！</font>");
			  return false;
		}
		if(!reg_mail.test($("#user_mail").val())){
		  $("#mailMsg").html("<font color='red'>邮箱输入格式有误！</font>");
		  return false;
		  }
		if(confirm('是否确认修改?')) {
			$("#frm").submit();
		}  
	  });
	  
});


