$(function(){
	 var bookName = $("#name");
	 var author = $("#author");
	 var publish = $("#publish");
	 var doban=$("#doban");
	 
	  
	 $("#name").bind("blur", function(e){
		 
	  	var val =jQuery.trim( this.value);
	  	if(val == "") {
	  		$("#nameMsg").html("<font color='red'>书名不能为空</font>");
		} else {
			$("#nameMsg").html("");
	  	}
	  });
		  
	 $("#author").bind("blur", function(e){
		  	var val = jQuery.trim(this.value);
		  	if(val == "") {
		  		$("#authorMsg").html("<font color='red'>作者不能为空</font>");
			} else {
				$("#authorMsg").html("");
		  	}
		  });
	 $("#publish").bind("blur", function(e){
		  	var val =jQuery.trim(this.value);
		  	if(val == "") {
		  		$("#publishMsg").html("<font color='red'>出版社不能为空</font>");
			} else {
				$("#publishMsg").html("");
		  	}
		  });
	 $("#doban").bind("blur", function(e){
		  	var val = jQuery.trim(this.value);
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
		  	if(val == "") {
		  		$("#dobanMsg").html("<font color='red'>豆瓣链接不能为空</font>");
			}else{
		  	 
		  		 //re.test() 
		  		   if (re.test(val)){ 
		  			   $("#dobanMsg").html("");  
		  		   }else{  
		  		    	 $("#dobanMsg").html("<font color='red'>输入地址无效</font>"); 
		  		   }
		  	}
		  });
	 $("#sub").click(function(){

		  	var name=jQuery.trim($("#name").val());
		  	
		  	var author=jQuery.trim($("#author").val());
		  	var publish=jQuery.trim($("#publish").val());
		  	var doban=jQuery.trim($("#doban").val());
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
		  	
		  	if(name == "" || author == "" || publish== "" || doban == "" || ! re.test(doban)) {
		  		alert("信息输入不正确");
			} 
		  	else if(name == null|| author == null || publish== null || doban == null || ! re.test(doban)) {
		  		alert("信息输入不正确");
			} 
		  	else {
				$("#editBook").submit();
		  	}
		  });
});