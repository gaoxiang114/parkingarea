package com.cyou.library.xh.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download {
	public static boolean download(HttpServletResponse response,String fileName,String filePath,String old) throws Exception{
		boolean flag = false;
		File file = new File(filePath);//
		System.out.println("--file_path:--"+filePath+"\\"+fileName);
		if(file.exists()){
			
			    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			    byte[] buffer = new byte[1];
			    response.reset();
			    response.setCharacterEncoding("UTF-8");
			    response.setContentType("application/x-rar-compressed");
			    old=URLEncoder.encode(old, "UTF-8").replace("+", "%20").length()>100?URLEncoder.encode(old, "UTF-8").replace("+", "%20").substring(0,100)+"."+old.substring(old.lastIndexOf(".")+1):URLEncoder.encode(old, "UTF-8").replace("+", "%20");
			    response.setHeader("Content-disposition", "attachment;filename="+old);
			    OutputStream os = response.getOutputStream();
			    while(bis.read(buffer) > 0){
			    	System.out.println(buffer);
			     os.write(buffer);
			    }
			    bis.close();
			    os.close();
			    flag = true;
		}
		return flag;
	}
	
	public static boolean download(HttpServletRequest request,HttpServletResponse response,String fileName,String filePath,String old) throws Exception{
		boolean flag = false;
		File file = new File(filePath);//
		System.out.println("--file_path:--"+filePath+"\\"+fileName);
		if(file.exists()){
				String agent=request.getHeader("User-Agent");
				String type="";
				
			    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			    byte[] buffer = new byte[1];
			    response.reset();
			    response.setCharacterEncoding("UTF-8");
			    response.setContentType("application/x-rar-compressed");
			    if(agent.indexOf("MSIE 7")>0){
			    	old=URLEncoder.encode(old, "UTF-8").replace("+", "%20").length()>100?URLEncoder.encode(old, "UTF-8").replace("+", "%20").substring(0,100)+"."+old.substring(old.lastIndexOf(".")+1):URLEncoder.encode(old, "UTF-8").replace("+", "%20");
				    response.setHeader("Content-disposition", "attachment;filename="+old);}
				else if(agent.indexOf("Firefox")>0){
					response.setHeader("Content-disposition", "attachment;filename*="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}else{
					response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}
			    OutputStream os = response.getOutputStream();
			    while(bis.read(buffer) > 0){
			    	System.out.println(buffer);
			     os.write(buffer);
			    }
			    bis.close();
			    os.close();
			    flag = true;
		}
		return flag;
	}
	
	 public static void download1(HttpServletRequest request,HttpServletResponse response, String storeName, String path,String realName) throws Exception {  
	        response.setContentType("text/html;charset=UTF-8");  
	        request.setCharacterEncoding("UTF-8");  
	        BufferedInputStream bis = null;  
	        BufferedOutputStream bos = null;  
	        response.reset();
	        long fileLength = new File(path).length();  
	  
	        response.setContentType("application/x-rar-compressed");
	        response.setHeader("Content-disposition", "attachment; filename="  
	                + new String(realName.getBytes("utf-8"), "ISO8859-1"));  
	        response.setHeader("Content-Length", String.valueOf(fileLength));  
	        
	        bis = new BufferedInputStream(new FileInputStream(path));  
	        bos = new BufferedOutputStream(response.getOutputStream());  
	        byte[] buff = new byte[2048];  
	        int bytesRead;  
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	            bos.write(buff, 0, bytesRead);  
	        }  
	        bis.close();  
	        bos.close();  
	}
	
}
