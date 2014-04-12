/**
 * 
 */
package com.cyou.library.xh.user.service;

import java.util.List;

import com.cyou.library.xh.user.domain.AssignRoles;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.domain.User;

/**
 * @author Administrator
 *
 */
public interface AssignRolesService {

	/**
	 * getRolesList:获取userId对应的角色集合
	 * @author lirenkui
	 * @param userId
	 * @return
	 */
	public List<Role> getRolesList(int userId);
	
	/**
	 * updateAssignRolesList:根据userid和对应的roleId更新userId对应的角色
	 * @author lirenkui
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public int updateAssignRolesList(int userId,int[] roleId);
	
	/**
	 * addAssignRolesList:批量添加角色
	 * @author lirenkui
	 * @param assignRolesList
	 * @return
	 */
	public int addAssignRolesList(List<AssignRoles> assignRolesList);
	
	/**
	 * delAssignRolesList:批量删除角色
	 * @author lirenkui
	 * @param assignRolesList
	 * @return
	 */
	public int delAssignRolesList(List<AssignRoles> assignRolesList);
	
	/**
	 * getAssignRoles:根据userId获取对应的角色集合
	 * @author lirnekui
	 * @param userId
	 * @return
	 */
	public List<AssignRoles> getAssignRoles(int userId);
	
}
