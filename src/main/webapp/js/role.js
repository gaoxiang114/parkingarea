$(function(){
	    var roleName = $("#roleName");
	    var flag = true;
	    roleName.bind("blur",function(){
	        if(is_empty(roleName.val())){
	        	 $("#msg1").html("<font color='red'>角色名不能为空</font>");
	        	 flag = false;
	        }else{
	            $("#msg1").html("");
	            flag = true;
	        }
	        
	        return flag;
	    });
	    
	    $("#bn").click(function() {
	    	if(is_empty($("#roleName").val())){
	    		$("#msg1").html("<font color='red'>角色名不能为空</font>");
	    		return false;
	    	}
	    	
	    	if(flag){
	    		$('#myForm').submit();
	    	}
			
		});
});

