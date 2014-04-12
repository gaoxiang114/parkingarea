/**
 * 
 */
package com.cyou.library.xh.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Page:分页
 * 
 * @author lirenkui
 * 
 */
public class Page implements Serializable {

	private int totalrecord;// 总纪录数
	private int pagesize = 10;// 每页显示多少记录条
	private int totalpage;// 总页数
	private int startindex;// 从数据库哪个位置开始取值
	@SuppressWarnings("rawtypes")
	private List list; // 记住某一页的数据
	private int pagenum; // 记住当前页
	private int forEachBegin; // 页面中页码开始值
	private int forEachEnd; // 页面中页码结束值
	private int forEachlength = 3; // 页面中页码的长度
	@SuppressWarnings("rawtypes")
	private List pagination = new ArrayList();// 页码集合

	public List<Integer> getPagination() {
		return pagination;
	}

	public void setPagination(List<Integer> pagination) {
		this.pagination = pagination;
	}

	public Page() {
	}

	public Page(int pagenum, int totalrecord, int pagesize) {

		this.pagesize = pagesize;
		this.totalrecord = totalrecord;
		// 根据总纪录数　算出　总页数
		if (this.totalrecord % pagesize == 0) {
			totalpage = this.totalrecord / pagesize;
		} else {
			totalpage = this.totalrecord / pagesize + 1;
		}
		if (pagenum > totalpage)
			this.pagenum = totalpage;
		else
			this.pagenum = pagenum;

		// 根据页码，算出startindex的值（即该页的数据，应该从数据库哪个地方开始取）
		this.startindex = (this.pagenum - 1) * pagesize;

		// 根据当前页码，算出forEachBegin和forEachEnd
		if (totalpage <= forEachlength) {
			forEachBegin = 1;
			forEachEnd = totalpage;
		} else {
			forEachBegin = this.pagenum - 1;
			forEachEnd = this.pagenum + 1;

			if (forEachBegin < 1) {
				forEachBegin = 1;
				forEachEnd = 3;
			}
			if (forEachEnd > totalpage) {
				forEachEnd = totalpage;
				forEachBegin = totalpage - 3 + 1;
			}

		}
		for (int i = forEachBegin; i <= forEachEnd; i++) {
			pagination.add(Integer.valueOf(i));
		}
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getForEachBegin() {
		return forEachBegin;
	}

	public void setForEachBegin(int forEachBegin) {
		this.forEachBegin = forEachBegin;
	}

	public int getForEachEnd() {
		return forEachEnd;
	}

	public void setForEachEnd(int forEachEnd) {
		this.forEachEnd = forEachEnd;
	}

	public int getForEachlength() {
		return forEachlength;
	}

	public void setForEachlength(int forEachlength) {
		this.forEachlength = forEachlength;
	}

}
