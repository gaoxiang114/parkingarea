package com.cyou.library.xh.user.service;

import java.util.List;

import com.cyou.library.xh.user.domain.Role;

public interface RoleService {
	
	/**
	 * addRole:添加角色信息的方法
	 * @author gaoxiang_nad
	 * @param Role role
	 * @return void
	 */
	public abstract void addRole(Role role);
	
	/**
	 * updateRole:修改角色信息的方法
	 * @author gaoxiang_nad
	 * @param Role role
	 * @return Integer 影响的行数
	 */
	public abstract void updateRole(Role role);
	
	/**
	 * delRole:删除角色信息的方法
	 * @author gaoxiang_nad
	 * @param Role role
	 * @return Integer 影响的行数
	 */
	public abstract void delRole(Integer[] roleIds);
	
	/**
	 * getRoleById:按id获取角色的信息
	 * @author gaoxiang_nad
	 * @param Integer id
	 * @return Role 的对象
	 */
	public abstract Role getRoleById(Integer id);
	
	/**
	 * getRoleList:获取角色列表
	 * @author gaoxiang_nad
	 * @return List<Role> 泛型为Role的列表
	 */
	public abstract List<Role> getRoleList();
	
	public abstract List<Role> getRolePageList(int pageIndex, int pageSize,Role role);
	
	public abstract Integer getAllCount();
}
