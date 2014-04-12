$(function(){
	var oldpwd = $("#oldpwd")
	, newpwd = $("#newpwd")
	, checkpwd = $("#checkpwd")
	, reg_pwd = /^[a-zA-Z0-9]{6,15}$/;  
	oldpwd.bind("blur", function(e){
		var val = this.value;
		if(val == "") {
			$("#oldMsg").html("<font color='red'>原密码不能为空！</font>");
		} else {
			if(!reg_pwd.test(val)) {
				$("#oldMsg").html("<font color='red'>原密码输入格式有误！</font>");
			}else {
				$("#oldMsg").html("密码由6-15个字母和数字组成");
			}
		}
	});		  
	newpwd.bind("blur",function(e){
		var val = this.value;
		if(val == ""){
			$("#newMsg").html("<font color='red'>密码输入不能为空！</font>");
		}else{
			if(!reg_pwd.test(val)){
				$("#newMsg").html("<font color='red'>密码输入格式不正确！</font>");
			}else {
				$("#newMsg").html("密码由6-15个字母和数字组成");
			}
		}
	});	  
	checkpwd.bind("blur",function(e){
		var val = this.value;
		if(val =="")
			$("#checkMsg").html("<font color='red'>验证密码不能为空！</font>");
		else{

				if($("#newpwd").val()!=$("#checkpwd").val()){
					$("#checkMsg").html("<font color='red'>验证密码与新密码不一致！</font>");
				}else{				
					$("#checkMsg").html("确认密码必须新密码一致");
				}
		}		  
	});

});
