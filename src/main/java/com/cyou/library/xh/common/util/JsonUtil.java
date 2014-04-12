package com.cyou.library.xh.common.util;

import java.util.ArrayList;
import java.util.List;

import com.cyou.library.xh.book.domain.Book;
import com.google.gson.Gson;

public class JsonUtil {
	
	
	public static String Object2Json(Object o){
		Gson gson = new Gson();
		return gson.toJson(o);
	}
	
	/*public static <T> T Json2Object(String json){
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<T>(){}.getType();
		Gson gson = new Gson();
		List testBeanListFromJson = gson.fromJson(json, type);
		System.out.println(testBeanListFromJson);
		return null;
	}*/
	
	public static void main(String[] args) {
		
		
	}
}
