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