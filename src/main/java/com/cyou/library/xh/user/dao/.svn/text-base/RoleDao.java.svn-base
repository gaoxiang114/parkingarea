package com.cyou.library.xh.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.user.domain.Role;

@Component("roleDao")
public class RoleDao extends BaseDao {
	
	/**
	 * addRole:添加角色信息的方法
	 * @author gaoxiang_nad
	 * @param Role role
	 * @return void
	 */
	public  void addRole(Role role){
		this.add("addRole", role);
	}
	
	/**
	 * updateRole:修改角色信息的方法
	 * @author gaoxiang_nad
	 * @param Role role
	 * @return Integer 影响的行数
	 */
	public  void updateRole(Role role){
		this.update("updateRole", role);
	}
	
	/**
	 * delRole:删除角色信息的方法
	 * @author gaoxiang_nad
	 * @param Role role
	 * @return Integer 影响的行数
	 */
	public  void delRole(Integer[] roleIds){
		List<Integer> idList = new ArrayList<Integer>(roleIds.length);
		for(Integer id : roleIds){
			idList.add(id);
		}
		this.delete("delRole", idList);
	}
	
	/**
	 * getRoleById:按id获取角色的信息
	 * @author gaoxiang_nad
	 * @param Integer id
	 * @return Role 的对象
	 */
	public  Role getRoleById(Integer id){
		return (Role)this.getUniqueOne("getRoleById", id);
	}
	
	/**
	 * getRoleList:获取角色列表
	 * @author gaoxiang_nad
	 * @return List<Role> 泛型为Role的列表
	 */
	public  List<Role> getRoleList(){
		return this.getList("getRoleList");
	}
	
	/**
	 * getRolePageList:分页查询角色列表
	 * @param pageIndex
	 * @param pageSize
	 * @param role
	 * @return List<Role> 返回一个list
	 */
	public List getRolePageList(int pageIndex, int pageSize,Role role) {
	    List list = null;
	    
	    try {
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("pageIndex", pageIndex*pageSize);
	    	map.put("pageSize", pageSize);
	    	
		    if(-1 == pageIndex && 0 == pageSize){
		    	list = this.getList("getRoleList", map);
		    }else{
		    	list = this.getList("getRolePageList", map);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  list;
	}
	
	/**
	 * getAllCount:获取总的数量
	 * @author gaoxiang_nad
	 * @return
	 */
	public Integer getAllCount(){
		return this.getCount("getAllCount");
	}
}
