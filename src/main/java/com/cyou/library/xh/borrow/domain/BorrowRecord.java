package com.cyou.library.xh.borrow.domain;

import java.io.Serializable;
import java.util.Date;

public class BorrowRecord implements Serializable{
	private Integer check_id;
	private Integer user_id;
	private String book_id;
	private Integer check_flag;
	private Date check_requestTime;
	private Date check_startTime;
	private Date check_endTime;
	private Integer check_mailTime;
	private Integer check_overdue;
	private Integer check_renew;
	public Integer getCheck_id() {
		return check_id;
	}
	public void setCheck_id(Integer check_id) {
		this.check_id = check_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public Integer getCheck_flag() {
		return check_flag;
	}
	public void setCheck_flag(Integer check_flag) {
		this.check_flag = check_flag;
	}
	public Date getCheck_requestTime() {
		return check_requestTime;
	}
	public void setCheck_requestTime(Date check_requestTime) {
		this.check_requestTime = check_requestTime;
	}
	public Date getCheck_startTime() {
		return check_startTime;
	}
	public void setCheck_startTime(Date check_startTime) {
		this.check_startTime = check_startTime;
	}
	public Date getCheck_endTime() {
		return check_endTime;
	}
	public void setCheck_endTime(Date check_endTime) {
		this.check_endTime = check_endTime;
	}
	public Integer getCheck_mailTime() {
		return check_mailTime;
	}
	public void setCheck_mailTime(Integer check_mailTime) {
		this.check_mailTime = check_mailTime;
	}
	public Integer getCheck_overdue() {
		return check_overdue;
	}
	public void setCheck_overdue(Integer check_overdue) {
		this.check_overdue = check_overdue;
	}
	public Integer getCheck_renew() {
		return check_renew;
	}
	public void setCheck_renew(Integer check_renew) {
		this.check_renew = check_renew;
	}
	
	
}
