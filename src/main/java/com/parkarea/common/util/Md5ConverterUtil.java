package com.parkarea.common.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5ConverterUtil {
	
	public static String Md5(String plainText) {
		String afterStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			afterStr = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return afterStr;
	}

	public static void main(String[] args) {
		System.out.println("“admin”加密后的字符串是: " + Md5ConverterUtil.Md5("wangyw"));
	}
}
