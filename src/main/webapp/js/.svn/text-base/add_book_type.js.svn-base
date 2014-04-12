$(function(){
	$("#sub").click(function(){
		
		var typeName=jQuery.trim($("#typeName").val());
		var regu = "^[0-9a-zA-Z\u4e00-\u9fa5_]+$";
		var re=new RegExp(regu);
		
		var prefix=jQuery.trim($("#prefix").val());
		var reguPrefix = "^[0-9a-zA-Z]{2}$";
		var rePrefix=new RegExp(reguPrefix);
		if(prefix==null || prefix==""){
			
			alert("类别名描述不能为空");
		}else if(!rePrefix.test(prefix)){
			alert("类别名描述只能由两个字母组成");
			
		}else if(typeName==null || typeName==""){
			alert("类别名不能为空");
			
			$("#typeNameMsg").html("<font color='red'>类别名不能为空</font>");
		}else if(!re.test(typeName)){
			$("#typeNameMsg").html("<font color='red'>类别名只能由字母、数字、汉字、下划线组成</font>");
			alert("类别名只能由字母、数字、汉字、下划线组成");
		}
		else $("#addBookType").submit();
	});	
	$("#typeName").blur(function(){
		var typeName=jQuery.trim($(this).val());
		var regu = "^[0-9a-zA-Z\u4e00-\u9fa5_]+$";
		var re=new RegExp(regu);
		if(typeName==null || typeName==""){
			
			$("#typeNameMsg").html("<font color='red'>类别名不能为空</font>");
		}else if(!re.test(typeName)){
			$("#typeNameMsg").html("<font color='red'>类别名只能由字母、数字、汉字、下划线组成</font>");
		}else 
			 $("#typeNameMsg").html("");
		
	});
	$("#prefix").blur(function(){
		var prefix=jQuery.trim($(this).val());
		var regu = "^[0-9a-zA-Z]{2}$";
		var re=new RegExp(regu);
		if(prefix==null || prefix==""){
			
			$("#prefixMsg").html("<font color='red'>类别名描述不能为空</font>");
		}else if(!re.test(prefix)){
			$("#prefixMsg").html("<font color='red'>类别名描述只能由两个字母组成</font>");
		}else 
			 $("#prefixMsg").html("");
		
	});
	
	
});
