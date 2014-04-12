$(function(){
	$("#personSelect").bind("change",function(){
		  if($("#personSelect")[0].selectedIndex=="0")
			  window.location.href = $("#basePath").val() + "/personReader/personBorrowing?userId=" + $("#userId").val();//在借书籍查询
		  if($("#personSelect")[0].selectedIndex=="1")
			  window.location.href = $("#basePath").val()+"/order/getUserOrderList?userId=" + $("#userId").val();//预定书籍查询
		  if($("#personSelect")[0].selectedIndex=="2")
			  window.location.href = $("#basePath").val()+"/personReader/personBorrowed?userId=" + $("#userId").val();//已还书籍查询
		  
	  });
});