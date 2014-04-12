/**
 * 
 */
package com.cyou.library.xh.common.util;

/**
 * @author lirenkui
 *密码验证util
 */
public class PasswordCheckUtil {

	private String oldpwd = null;//原密码
	private String newpwd = null; //新密码
	private String checkpwd = null; //验证密码
	private static String msg = "t";//输出信息
	
	/**
	 * checkIsNull:校验密码是否为空
	 * @author lirenkui
	 * @param oldpwd
	 * @param newpwd
	 * @param checkpwd
	 * @return
	 */
	public static String checkIsNull(String oldpwd,String newpwd,String checkpwd){
		
		if(oldpwd.trim().equals("")||oldpwd==null)
			msg = "原密码不能为空！";
		else if(newpwd.trim().equals("")||newpwd==null)
				msg = "新密码不能为空！";
			else if(checkpwd.trim().equals("")||checkpwd==null)
				msg = "验证密码不能为空！";
				else
					msg ="t";
		return msg;
	}
	
	/**
	 * checkIsLegitimate:校验输入格式是否合法，密码确认是否正确
	 * @author lirenkui
	 * @param oldpwd
	 * @param newpwd
	 * @param checkpwd
	 * @return
	 */
	public static String checkIsLegitimate(String oldpwd,String newpwd,String checkpwd){
		
		if(!oldpwd.matches("^[a-zA-Z0-9]{5,14}$"))
			msg = "原密码输入格式有误！";
		else if(!newpwd.matches("^[a-zA-Z0-9]{5,14}$"))
				msg = "新密码输入格式有误！";
			else if(!checkpwd.matches("^[a-zA-Z0-9]{5,14}$"))
				msg = "确认密码输入格式有误！";
				else if(newpwd.equals(checkpwd))
						msg = "t";
					else
						msg = "新密码与验证密码不匹配！";
		return msg;
	}
}
