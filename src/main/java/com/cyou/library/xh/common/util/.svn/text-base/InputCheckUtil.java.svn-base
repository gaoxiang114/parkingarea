/**
 * 
 */
package com.cyou.library.xh.common.util;

/**
 * @author lirenkui
 *
 */
public class InputCheckUtil {

	private String inputFirst;
	private String inputSecond;
	private String inputThird;
	private String inputFour;
	private static String message  = "t";

	public static String checkInputIsNull(String inputFirst,String inputSecond,String inputThrid){

		if(inputFirst.trim().equals("")||inputFirst==null)
			message = "用户名不能为空！";
		else if(inputSecond.trim().equals("")||inputFirst==null)
			message = "真实姓名不能为空";
		else if(inputThrid.trim().equals("")||inputThrid==null)
			message = "邮箱不能为空！";
		else
			message = "t";
		return message;
	}

	public static String checkIsLegitimate(String inputFirst,String inputSecond,String inputThird){

		if(!inputFirst.matches("^(cy|sx|CY|SX|cY|Cy|Sx|sX)[0-9]{4}$"))//验证账号合法性：字母开头，允许4-16字节，允许字母下划线 ^[a-zA-Z][a-zA-Z0-9_]{4,15}$
			message ="员工编号输入格式有误！";
		else if(!inputSecond.matches("^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]){2,6}$"))//验证用户名是否正确：只能为汉字2到4个
			message = "真实姓名输入有误！";
		else if(!inputThird.matches("^[a-zA-Z][a-zA-Z_]{3,24}$"))
			message = "邮箱输入格式有误！";
		else
			message = "t";
		return message;
	}

}
