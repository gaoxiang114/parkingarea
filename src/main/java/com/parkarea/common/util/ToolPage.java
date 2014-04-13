package com.parkarea.common.util;


import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

/**
 * 分页帮助类
 * @author gaoxiang_nad
 *
 */
public class ToolPage {
	
	private String firstPage;
	private String precursorPage;
	private String nextPage;
	private String lastPage;
	private int currentPage;
	private int pageSize;
	private int total;
	private String pageCount;
	private List<?> dataList;
	private static int startNumIndex;
	private static int endNumIndex;
	private List<String> numList = new ArrayList<String>();
	private static int pageShowNum=3;
	private String parameterString;
	

	/**
	 * 查询分页
	 * @param request 访问对象
	 * @param currentPage 分页的第n页
	 * @param col 分页集合
	 * @param total 数据总数
	 * @param pageSize 分页每页面显示数
	 * @param url 分页“上一页”、“下一页”访问请求,此处应该加上工程路径
	 * @param parameterNames 多条件查询中的查询对象
	 * @param parameterValues 多条件查询中的查询对象值
	 */
	public static ToolPage pagination(int currentPage, int allObjectCount,int pageSize, String url, Model model, List list){
		String[] pageArray = new String[4]; //4个元素的字符串数组, 用来存放html页面上的上一页、下一页等链接
		int pageCount =  allObjectCount / pageSize + (allObjectCount % pageSize != 0 ? 1 : 0);
		
		if (pageCount <= pageShowNum) {
			startNumIndex = 0;
			endNumIndex = pageCount-1;
		} else {
			startNumIndex = currentPage - 1;
			endNumIndex = currentPage + 1;

			if (startNumIndex < 0) {
				startNumIndex = 0;
				endNumIndex = pageShowNum-1;
			}
			if (endNumIndex >pageCount-1) {
				endNumIndex = pageCount-1;
				startNumIndex = pageCount - 3;
			}
		}
		
		boolean hasWenhao = false;
		if(url.indexOf("?") != -1){
			hasWenhao = true;
		}
		
		if (currentPage == 0) {
			pageArray[0] = "<a href=\"#\">首页</a>";
		} else {
			pageArray[0] = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=0\">首页</a>";
		}
		
		if (currentPage == 0) {
			pageArray[1] = "<a href=\"#\">上一页</a>";
		} else {
			pageArray[1] = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (currentPage - 1) + "\">上一页</a>";
		}
		
		List<String> numList = new ArrayList<String>();
		String num = "";
		for(int i=startNumIndex;i<=endNumIndex;i++){
			
			 num = "&nbsp;<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (i) + "\">"+ (i== currentPage ? "<font color='red'>" : "<font color='#0088CC'>") 
			                           +(i+1)+"</font>"+"</a>";
			 numList.add(num);
			 num = "";
		}
		
		if (currentPage < pageCount - 1) {
			pageArray[2] = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (currentPage + 1) + "\">下一页</a>";
		} else {
			pageArray[2] = "<a href=\"#\">下一页</a>";
		}
		
		if (currentPage < pageCount - 1) {
			pageArray[3] = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (pageCount - 1) + "\">末页</a>";
		} else {
			pageArray[3] = "<a href=\"#\">末页</a>";
		}
		
		//将参数封装到map中
		ToolPage toolPage = new ToolPage();
		
		toolPage.setFirstPage(pageArray[0]);
		toolPage.setPrecursorPage(pageArray[1]);
		toolPage.setNumList(numList);
		toolPage.setNextPage(pageArray[2]);
		toolPage.setLastPage(pageArray[3]);
		toolPage.setPageSize(pageSize);
		toolPage.setPageCount(String.valueOf(pageCount));
		toolPage.setCurrentPage(currentPage+1);
		toolPage.setTotal(allObjectCount);
		toolPage.setDataList((list !=null && list.size() >0) ? list : null);
		return toolPage;
	}
	


	public static int getPageShowNum() {
		return pageShowNum;
	}

	public static void setPageShowNum(int pageShowNum) {
		ToolPage.pageShowNum = pageShowNum;
	}

	/**
	 * 多条件查询分页
	 * @param request 访问对象
	 * @param currentPage 分页的第n页
	 * @param col 分页集合
	 * @param total 数据总数
	 * @param pageSize 分页每页面显示数
	 * @param url 分页“上一页”、“下一页”访问请求,此处应该加上工程路径
	 * @param parameterNames 多条件查询中的查询对象
	 * @param parameterValues 多条件查询中的查询对象值
	 */
	public static ToolPage pagination(Model model, int currentPage, List list, int total, int pageSize, String url, String[] parameterNames, String[] parameterValues) {
		StringBuffer parameterString = new StringBuffer();
		
		for (int i = 0; i < parameterNames.length; i++) {
			if(parameterValues[i] != null && !parameterValues[i].equals("") && !parameterValues[i].equals("null")){
				parameterString.append("&");
				parameterString.append(parameterNames[i]);
				parameterString.append("=");
				parameterString.append(parameterValues[i]);
			}
		}
		
		int pageTotal = total / pageSize + (total % pageSize == 0 ? 0 : 1);
		String firstPage = "";
		String precursorPage = "";
		String nextPage = "";
		String lastPage = "";
		
		if (pageTotal <= pageShowNum) {
			startNumIndex = 0;
			endNumIndex = pageTotal-1;
		} else {
			startNumIndex = currentPage - 1;
			endNumIndex = currentPage + 1;

			if (startNumIndex < 1) {
				startNumIndex = 0;
				endNumIndex = pageShowNum-1;
			}
			if (endNumIndex > pageTotal-1) {
				endNumIndex = pageTotal-1;
				startNumIndex = pageTotal - 3;
			}
		}
		
		boolean hasWenhao = false;
		if(url.indexOf("?") != -1){
			hasWenhao = true;
		}
		
		if (currentPage == 0) {
			firstPage = "<a href=\"#\">首页</a>";
		} else {
			firstPage = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=0" + parameterString.toString() + "\">首页</a>";
		}
		if (currentPage == 0) {
			precursorPage = "<a href=\"#\">上一页</a>";
		} else {
			precursorPage = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (currentPage - 1) + parameterString.toString() + "\">上一页</a>";
		}
		
		
		

		List<String> numList = new ArrayList<String>();
		String num = "";
		for(int i=startNumIndex;i<=endNumIndex;i++){
			
			 num = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (i) + parameterString.toString() + "\">"+ (i== currentPage ? "<font color='red'>" : "<font color='#0088CC'>") 
			                           +(i+1)+"</font>"+"</a>";
			 numList.add(num);
			 num = "";
		}
		
		if (currentPage < pageTotal - 1) {
			nextPage = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (currentPage + 1) + parameterString.toString() + "\">下一页</a>";
		} else {
			nextPage = "<a href=\"#\">下一页</a>";
		}
		if (currentPage < pageTotal - 1) {
			lastPage = "<a href=\"" + url + (hasWenhao ? "&" : "?") + "currentPage=" + (pageTotal - 1) + parameterString.toString() + "\">末页</a>";
		} else {
			lastPage = "<a href=\"#\">末页</a>";;
		}
		
		if (pageTotal == 0) {
			pageTotal = 1;
		}
		
		
		//将参数封装到map中
		ToolPage toolPage = new ToolPage();
		
		toolPage.setFirstPage(firstPage);
		toolPage.setPrecursorPage(precursorPage);
		toolPage.setNextPage(nextPage);
		toolPage.setLastPage(lastPage);
		toolPage.setNumList(numList);
		toolPage.setCurrentPage(currentPage + 1);
		toolPage.setPageSize(pageSize);
		toolPage.setTotal(total);
		toolPage.setPageCount(String.valueOf(pageTotal));
		toolPage.setParameterString(parameterString.toString());
		toolPage.setDataList((list !=null && list.size() >0) ? list : null);
		
		return toolPage;
	}
	
	
	
	public String getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}

	public String getPrecursorPage() {
		return precursorPage;
	}

	public void setPrecursorPage(String precursorPage) {
		this.precursorPage = precursorPage;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getParameterString() {
		return parameterString;
	}

	public void setParameterString(String parameterString) {
		this.parameterString = parameterString;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
	
	public List<String> getNumList() {
		return numList;
	}

	public void setNumList(List<String> numList) {
		this.numList = numList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}