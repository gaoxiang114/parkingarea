package com.parkarea.common.util;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {  
	        request.setCharacterEncoding("UTF-8");  
	        response.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html;charset=UTF-8");  
	        // 后台session控制  
	        String[] noFilters = new String[] {"manager/loginOut","manager/login",
	        		"parkingarea/css","parkingarea/js","parkingarea/images","font/fontawesome-webfont.svg"
	        };  
	        String uri = request.getRequestURI();
	        	
	            boolean beFilter = true;  
	            for (String s : noFilters) {  
	                if (uri.indexOf(s) != -1) {  
	                    beFilter = false;
	                    break;  
	                }
	            }
	            
	            if (beFilter) {  
	            	Object obj = request.getSession().getAttribute("user");
	            	
	            	if (null == obj) {
	            		request.setAttribute("message", "您没有登录系统，请登录");
	                	request.getRequestDispatcher("/manager/login").forward(request, response);
	                	return false;
	                }
	                
	            }
	  
	        return super.preHandle(request, response, handler); 
	    }  
}
