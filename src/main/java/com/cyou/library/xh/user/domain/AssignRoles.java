/**
 * 
 */
package com.cyou.library.xh.user.domain;

import java.io.Serializable;

/**
 * @author lirenkui
 *
 */
public class AssignRoles implements Serializable{

	private static final long serialVersionUID = 1L;

	private int assignId;
	private int userId;
	private int roleId;
	
	public AssignRoles() {
	}

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String toString() {
		return "AssignRolesDao [assignId=" + assignId + ", userId=" + userId
				+ ", roleId=" + roleId + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignId;
		result = prime * result + roleId;
		result = prime * result + userId;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignRoles other = (AssignRoles) obj;

		if (roleId != other.roleId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
