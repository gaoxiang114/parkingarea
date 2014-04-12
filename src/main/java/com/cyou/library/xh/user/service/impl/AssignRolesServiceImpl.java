/**
 * 
 */
package com.cyou.library.xh.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyou.library.xh.user.dao.AssignRolesDao;
import com.cyou.library.xh.user.domain.AssignRoles;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.domain.User;
import com.cyou.library.xh.user.service.AssignRolesService;

/**
 * @author lirenkui
 *
 */
@Service("assignRolesService")
public class AssignRolesServiceImpl implements AssignRolesService{

	@Resource(name = "assignRolesDao")
	private AssignRolesDao assignRolesDao;

	public List<Role> getRolesList(int userId) {
		List<Role> assignList = null;
		assignList = (List<Role>) assignRolesDao.getRolesList(userId);
		return assignList;
	}

	public int updateAssignRolesList(int userId, int[] roleId) {
		
		AssignRoles assignRoles = new AssignRoles();
		assignRoles.setUserId(userId);
		for(int temp = 0;temp<roleId.length;temp++){
			assignRoles.setRoleId(roleId[temp]);
/*			if(assignRolesDao.getAssignRoles(assignRoles)==null){
				
			}*/
		}
		return 0;
	}

	public int addAssignRolesList(List<AssignRoles> assignRolesList) {
		return this.assignRolesDao.addAssignRolesList(assignRolesList);
	}

	public int delAssignRolesList(List<AssignRoles> assignRolesList) {
		return this.assignRolesDao.delAssignRolesList(assignRolesList);
	}

	public List<AssignRoles> getAssignRoles(int userId) {
		return this.assignRolesDao.getAssignRoles(userId);
	}

	
}