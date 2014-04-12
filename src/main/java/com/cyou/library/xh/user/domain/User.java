/**
 * 
 */
package com.cyou.library.xh.user.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 人员javaBean
 * @author lirenkui
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int user_id;//user表标示字段
	private String user_num;//user真实姓名
	private String user_password;//user登录密码 初始密码123456--------需加密
	private String user_mail;
	private String user_realname;//user真实姓名
	private int user_borrownum;//用户借书数，初始为3，最大为3
	private String user_department;//用户部门
	private int user_ordernum;//用户书籍预定数 初始值为3；
	private List<Role> assignList;//用户的角色集合
	public User() {
	}
	
	
	public List<Role> getAssignList() {
		return assignList;
	}


	public void setAssignList(List<Role> assignList) {
		this.assignList = assignList;
	}


	public int getUser_ordernum() {
		return user_ordernum;
	}

	public void setUser_ordernum(int user_ordernum) {
		this.user_ordernum = user_ordernum;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_num() {
		return user_num;
	}

	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}

	public int getUser_borrownum() {
		return user_borrownum;
	}

	public void setUser_borrownum(int user_borrownum) {
		this.user_borrownum = user_borrownum;
	}

	public String getUser_department() {
		return user_department;
	}

	public void setUser_department(String user_department) {
		this.user_department = user_department;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_num=" + user_num
				+ ", user_password=" + user_password + ", user_mail="
				+ user_mail + ", user_realname=" + user_realname
				+ ", user_borrownum=" + user_borrownum + ", user_department="
				+ user_department + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_borrownum;
		result = prime * result
				+ ((user_department == null) ? 0 : user_department.hashCode());
		result = prime * result + user_id;
		result = prime * result
				+ ((user_mail == null) ? 0 : user_mail.hashCode());
		result = prime * result
				+ ((user_num == null) ? 0 : user_num.hashCode());
		result = prime * result
				+ ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result
				+ ((user_realname == null) ? 0 : user_realname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_borrownum != other.user_borrownum)
			return false;
		if (user_department == null) {
			if (other.user_department != null)
				return false;
		} else if (!user_department.equals(other.user_department))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_mail == null) {
			if (other.user_mail != null)
				return false;
		} else if (!user_mail.equals(other.user_mail))
			return false;
		if (user_num == null) {
			if (other.user_num != null)
				return false;
		} else if (!user_num.equals(other.user_num))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_realname == null) {
			if (other.user_realname != null)
				return false;
		} else if (!user_realname.equals(other.user_realname))
			return false;
		return true;
	}
	
}
