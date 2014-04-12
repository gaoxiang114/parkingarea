// 每个页面都要加载这个js，当页面中session过期，弹出对话框并返回登录页面。
//window.onload = function() {
//	var jsId = document.getElementById("jsId");
//	var session = jsId.getAttribute("data");
//	if(session == null || session == "") {
//		alert("session 失效，您无法操作，请重新登录。");
//		window.parent.location.href="login.do";
//	}
//}

// 点击功能条上的复选框所触发的动作。
function selORcancel(checkConsole, childCheckBox) {
	
	var bool = document.getElementById(checkConsole).checked; // 获取当前状态（选中，还是未选中）
	for(i = 0; i < document.getElementsByName(childCheckBox).length; i++) {
		document.getElementsByName(childCheckBox)[i].checked = bool;
	}
}

// ajax创建对象。
function createAjaxObj() {
	var httpRequest = false;
	if (window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
		if(httpRequest.overrideMimeType) {
			httpRequest.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) {
		try {
			httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {
			}
		}
	}
	return httpRequest;
}

//将被选中的checkBox的值拼成一个字符串返回
function returnCheckValue(checkId) {
	var obj = "";//定义字符
	for(i=0; i<document.getElementsByName(checkId).length; i++){//取到所有name为checkId的checkbox
		if(document.getElementsByName(checkId)[i].checked) {//如果被选中
			if(i<document.getElementsByName(checkId).length-1){
		   		obj+=document.getElementsByName(checkId)[i].value+"|";//将值拼到obj中
		   	}
		   	else{
		   		obj+=document.getElementsByName(checkId)[i].value;
		   	}
	    }
	}
	return obj;
}

// 将页面中所有的checkBox的值拼成一个字符串返回
function allCheckBoxValue(checkId) {
	var obj = "";
	for(i=0; i<document.getElementsByName(checkId).length; i++){
		if(i<document.getElementsByName(checkId).length-1){
			obj+=document.getElementsByName(checkId)[i].value+"|";//将值拼到obj中
		} else {
			obj+=document.getElementsByName(checkId)[i].value;
		}
	}
	return obj;
}


/***********************************表单验证（开始）*******************************/
// 验证是否为空
function is_empty(str) {
	var white_space = " \t\n\r";
	// 返回 true 表示字符串为空
	if(str == null || str.length == 0) {
		return true;
	}
	
	for(var i = 0; i < str.length; i ++) {
		if(white_space.indexOf(str.charAt(i)) == -1) {
			return false;//表示字符串str中含有非空字符
		}
	}
	
	return true;
}

// 检测数字字符串
function is_integer(str) {
	var integer_str = "0123456789";
	for(var i = 0; i < str.length; i ++) {
		if(integer_str.indexOf(str.charAt(i)) == -1) {
			return false;
		}
	}
	return true;
}

// E-mail 地址验证
function is_email_reg(email_str) {
	var arr = ["ac", "com", "net", "org", "edu", "gov", "mil", "ac\.cn", "com\.cn", "edu\.cn", "net\.cn", "org\.cn"];
	var temp_str = arr.join("|");
	// 通过字符形式构造正则表达式
	var reg_str = "^[0-9a-zA-z](\\w|-)*@\\w+\\.(" + temp_str + ")$";
	var reg = new RegExp(reg_str);
	return reg.test(email_str);
}

// 屏蔽非数字字符的输入,表单引用时 onkeypress="return is_number(event);";
function is_number(e) {
	var char_code = e.charCode ? e.charCode : e.keyCode;
	if(char_code < 48 || char_code > 57) {
		alert("只允许输入数字。");
		return false;
	} else {
		return true;
	}
}

// 清除两侧空格
function trim(str) {
	return left_trim(right_trim(str));
}

// 后台列表页面搜索显示与隐藏
function showSearch() {
	var search = document.getElementById("search");
	if(search.style.display=="") {
		search.style.display="none";
	} else {
		search.style.display="";
	}
}
/***********************************表单验证（结束）*******************************/

// 想让自己的js永远不在状态栏显示错误，可以让出错的js都返回真。
window.onerror = function() {
	return true;
}