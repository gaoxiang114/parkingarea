package com.cyou.library.xh.common.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 在网站上使用Cookie工具类
 * 注：cookie 不能直接存入汉字，所以在存入前先转码，读的时候先解码。
 * @author gaoxiang_nad
 *
 */
public class CookieTool {
	
	private static Logger logger = Logger.getLogger(CookieTool.class);
	/**
	 * 设置cookie（接口方法）
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		try {
			if(value != null && !value.equals("")) {
				value = URLEncoder.encode(value, "UTF-8"); // 转码
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("cookie值在转码时发生错误。转码的值为：" + value);
		}
		
		Cookie cookie = new Cookie(name, value);
		
		cookie.setPath("/");
		
		if(maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		
		response.addCookie(cookie);
	}

	/**
	 * 根据名字获取cookie（接口方法）
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		
		Map<String,Cookie> cookieMap = ReadCookieMap(request);
		if(cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie)cookieMap.get(name);
			
			// if 块 代码为 lianze 加入的 cookie 解码代码。
			if(name.equals(cookie.getName())) {
				String value = "";
                try {
                	value = URLDecoder.decode(cookie.getValue(), "UTF-8");// 解码
                } catch (UnsupportedEncodingException e) {
                	logger.error("cookie值在解码时发生错误。解码的值为：" + value);
                }
                cookie.setValue(value);
			}
			
			return cookie;
		} else {
			return null;
		}
	}
	
	/**
	 * 将cookie封装到Map里面（非接口方法）
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
		Cookie[] cookies = request.getCookies();
		if(null != cookies) {
			for(Cookie cookie : cookies){
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	
    /**
     * 根据name值,从cookie当中取值
     *
     * @param name    要获取的name
     * @param request cookie存在的对象
     * @return 与name对应的cookie值
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cs = request.getCookies();
        String value = "";
        if (cs != null) {
            for (Cookie c : cs) {
                if (name.equals(c.getName())) {
                    try {
                    	value = URLDecoder.decode(c.getValue(), "UTF-8");// 解码
                    } catch (UnsupportedEncodingException e) {
                    	logger.error("cookie值在解码时发生错误。解码的值为：" + value);
                    }
                    return value;
                }
            }
        }
        return value;
    }
}
