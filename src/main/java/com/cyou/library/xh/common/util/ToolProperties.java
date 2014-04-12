package com.cyou.library.xh.common.util;

/**
 * @author gaoxiang_nad
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lianze
 * @since 2009-03-07
 * <b>这是一个读取properties文件的类，可以读到文件中的相关信息.</b>
 *
 */
public class ToolProperties {
	
	/**
	 * @param fileName 这是src下的properties文件，写的时候要写全文件名，包括后缀名。
	 * @param keyName 这是properties文件中的属性，即每行冒号前面的信息。
	 * @return 返回的是每行冒号后面的信息。
	 */
	public String getMessage(String fileName, String keyName) {
		InputStream inputStream = null;
		Properties propertie = null;
		String keyValue = "";//返回值
		try {
			inputStream = this.getClass().getResourceAsStream("/"+fileName);
			propertie = new Properties();
			propertie.load(inputStream);
			keyValue = propertie.getProperty(keyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyValue;
	}
	
	/**
	 * 读取默认消息文件ApplicationResources.properties中的消息
	 * @param keyName 这是properties文件中的属性名，即每行冒号前面的信息
	 * @return 返回的是每行冒号后面的信息
	 */
	public String getMessage(String keyName) {
		InputStream inputStream = null;
		Properties propertie = null;
		String keyValue = "";//返回值
		try {
			inputStream = this.getClass().getResourceAsStream("/ApplicationResources.properties");
			propertie = new Properties();
			propertie.load(inputStream);
			keyValue = propertie.getProperty(keyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyValue;
	}
	
	/*ToolProperties.java 类的使用方法*/
	public static void main(String args[]){
		ToolProperties tm = new ToolProperties();
		System.out.println("************************************************************");
		System.out.println("mail.properties文件中的 mail.smtp.password 信息：\n"+tm.getMessage("mail.properties", "mail.smtp.password"));
		System.out.println("************************************************************");
		System.out.println("database.properties文件中的 hibernate.c3p0.maxPoolSize 信息：\n"+tm.getMessage("database.properties", "hibernate.c3p0.maxPoolSize"));
		System.out.println("************************************************************");
	}
}
