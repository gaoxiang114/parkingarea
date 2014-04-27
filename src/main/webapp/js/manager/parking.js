var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);

$(function(){
	var carNum = $("#carNum");
	var realname = $("#realname");
	var idCard = $("#idCard");
	var telephone = $("#telephone");
	var mobileMatcher = /^1[4,3,5,8]\d{9}$/;
	var result = new Array(4);

	carNum.bind("blur",function(){
		var val =jQuery.trim(this.value);
	  	if(is_empty(val)) {
	  		result[0] = false;
	  		$("#msg").html("<font color='red'>请输入车牌号码</font>");
		} else {
			$.ajax({
			       type: 'POST',  
			       url: projectName+'/carInOut/checkCarPark?rand='+Math.random(),
			       data:{"carNum":val},
			       async:false,
			       success : function(data){
			    	   if(data == 0){
			    		   result[0] = true;
			    		   $("#msg").html("");
			    	   }else{
			    		   $("#msg").html("该车已经停在停车场中！");
			    		   result[0] = false;
			    	   }
			       }
			});
	  	}
	  	return result[0];
	});

	realname.bind("blur",function(){
		var val = jQuery.trim(this.value);
		if(is_empty(val)){
			result[1] = false;
			$("#msg1").html("<font color='red'>请输入车主姓名</font>");
		} else {
			result[1] = true;
			$("#msg1").html("");
		}
		return result[1];
	});

	idCard.bind("blur",function(){
		var val = jQuery.trim(this.value);
		if(is_empty(val)){
			result[2] = false;
			$("#msg2").html("<font color='red'>请输入身份证号</font>");
		} else if(!isIdCardNo(val)){
			result[2] = false;
		} else{
			result[2] = true;
			$("#msg2").html("");
		}
		return result[2];
	});

	telephone.bind("blur",function(){
		var val = jQuery.trim(this.value);
		if(is_empty(val)){
			$("#msg3").html("<font color='red'>请输入车主手机号</font>");
			result[3]=false;
		}else if(!mobileMatcher.test(val)){
			$("#msg3").html("<font color='red'>输入的手机格式不正确</font>");
			result[3]=false;
		}else{
			$("#msg3").html("");
			result[3]=true;
		}
		return result[3];
	});

	$("#bn").click(function(){
		var flag = true;
		if(is_empty(carNum.val())){
			$("msg").html("<font color='red'>请输入车牌号码</font>");
			return false;
		}
		if(is_empty(realname.val())){
			$("msg1").html("<font color='red'>请输入车主姓名</font>");
			return false;
		}
		
		if(is_empty(idCard.val())){
			$("msg2").html("<font color='red'>请输入身份证号</font>");
			return false;
		}
		
		if(is_empty(telephone.val())){
			$("msg3").html("<font color='red'>请输入身份证号</font>");
			return false;
		}
		for(var i=0;i<result.length;i++){
			if(typeof(result[i]) == undefined || typeof(result[i]) == "undefined"){
				result[i]=true;
			}
			flag = flag & result[i];
		}
		if(flag){
			$("#myForm").submit();
		}
	});
});



function isIdCardNo(num){  
	num = num.toUpperCase();
	//身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。  
	if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))){
		alert('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。');
		return false;
	}
	//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	//下面分别分析出生日期和校验位
	var len, re;
	len = num.length;
	if (len == 15){
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
		var arrSplit = num.match(re);
		//检查生日日期是否正确
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay){
			alert('输入的身份证号里出生日期不对！');  
			return false;
		}else{
		//将15位身份证转成18位
		//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			var nTemp = 0, i;  
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
			for(i = 0; i < 17; i ++){
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			num += arrCh[nTemp % 11];  
			return num;  
		}
	}

	if (len == 18){
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var arrSplit = num.match(re);
		//检查生日日期是否正确
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay){
			alert(dtmBirth.getYear());
			alert(arrSplit[2]);
			alert('输入的身份证号里出生日期不对！');
			return false;
		}else{
			//检验18位身份证的校验码是否正确。
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var valnum;
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			var nTemp = 0, i;
			for(i = 0; i < 17; i ++){
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			valnum = arrCh[nTemp % 11];
			if (valnum != num.substr(17, 1)){
				alert('18位身份证的校验码不正确！应该为：' + valnum);
				return false;
			}
			return num;
		}
	}
	return false;
}