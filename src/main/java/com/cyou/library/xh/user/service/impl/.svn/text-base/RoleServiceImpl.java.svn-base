package com.cyou.library.xh.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cyou.library.xh.user.dao.RoleDao;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.service.RoleService;

/**
 * 
 * @author gaoxiang_nad
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	Logger logger = Logger.getLogger(RoleServiceImpl.class);
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	public void addRole(Role role) {
		this.roleDao.addRole(role);
	}

	public void updateRole(Role role) {
		this.roleDao.updateRole(role);
	}

	public void delRole(Integer[] roleIds) {
		this.roleDao.delRole(roleIds);
	}

	public Role getRoleById(Integer id) {
		return this.roleDao.getRoleById(id);
	}

	public List<Role> getRoleList() {
		return this.roleDao.getRoleList();
	}

	public List<Role> getRolePageList(int pageIndex, int pageSize, Role role) {
		return (List<Role>)this.roleDao.getRolePageList(pageIndex,pageSize,role);
	}

	public Integer getAllCount() {
		return (Integer)this.roleDao.getAllCount();
	}

}
