$(function(){
	
	var mailTitle=$("#mailTitle"),
	    mailContent=$("#mailContent");
	var flag = new Array();
	var result=true;
	$("#mailTitle").bind("blur",function(){
		if(is_empty(mailTitle.val())){
			$("#msg1").html("<font color='red'>邮件主题不能为空！</font>");
			flag[0]=true;
		}else{
			flag[0]=true;
		}
		
		return flag[0];
	});
	
	
	$("#mailContent").bind("blur",function(){
		if(is_empty(mailContent.val())){
			$("#msg2").html("<font color='red'>邮件内容不能为空！</font>");
			flag[1]=true;
		}else{
			flag[1]=true;
		}
		
		return flag[1];
		
		
	});
	

	
	$("#bn").bind("click",function(){
		
		if(is_empty(mailTitle.val())){
			$("#msg1").html("<font color='red'>请输入邮件主题</font>");
			return false; 
		}
		
		if(is_empty(mailContent.val())){
			$("#msg2").html("<font color='red'>请输入邮件内容</font>");
			return false; 
		}
		
		for(var i=0;i<flag.length;i++){
			result = result&flag[i];
		}
		
		if(result){
			$("#myForm").submit();
		}
	});
	
	
});