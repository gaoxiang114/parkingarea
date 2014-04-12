/**
 * 
 */
package com.cyou.library.xh.user.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.user.domain.AssignRoles;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.domain.User;

/**
 * @author Administrator
 *
 */
@Component("assignRolesDao")
public class AssignRolesDao extends BaseDao{
	
	/**
	 * addAssignRoles:添加角色分配
	 * @author lirenkui
	 * @param assignRoles：userId,roleId
	 * @return 影响行数
	 */
	public int addAssignRoles(AssignRoles assignRoles){
		return this.add("addAssignRoles", assignRoles);
	}
	/**
	 * addAssignRolesList:批量添加AssignRoles
	 * @author lirenkui
	 * @param assignRolesList
	 * @return
	 */
	public int addAssignRolesList(List<AssignRoles> assignRolesList){
		return this.add("addAssignRolesList", assignRolesList);
	}
	
	/**
	 * delAssignRolesList:批量删除AssignRoles
	 * @author lirenkui
	 * @param assignRolesList
	 * @return
	 */
	public int delAssignRolesList(List<AssignRoles> assignRolesList){
		return this.delete("delAssignRolesList", assignRolesList);
	}

	/**
	 * getRolesList:返回用户ID为userId对应的角色集合
	 * @author lirenkui
	 * @param userId
	 * @return List<Role> 返回结果包含roleId,roleName
	 */
	public List<Role> getRolesList(int userId){
		return this.getList("getRolesList", userId);
	}
	
	/**
	 * getAssignRoles:获取userId用户的roles集合
	 * @author lirenkui
	 * @param userId
	 * @return
	 */
	public List<AssignRoles> getAssignRoles(int userId){
		return this.getList("getAssignRoles", userId);
	}
	
	
	public List<Integer> getRoleIdList(User user){
		return this.getList("getRoleIdList", user);
	}
	/*	public List<AssignRoles> getAssignRoles(AssignRoles assignRoles){
		return this.getList("getAssignRoles", assignRoles);
	}*/
}
