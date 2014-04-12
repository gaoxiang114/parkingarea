/**
 * 
 */
package com.cyou.library.xh.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.user.domain.DivisionPower;
import com.cyou.library.xh.user.domain.Fun;

/**
 * @author Administrator
 *
 */
@Component("divisionPowerDao")
public class DivisionPowerDao extends BaseDao{

	/**
	 * getDivisionPowerByRoleId:根据roleId获取对应的权限集合
	 * @author lirenkui
	 * @param roleId
	 * @return
	 */
	public List<DivisionPower> getDivisionPowerByRoleId(int roleId){
		return this.getList("getDivisionPowerByRoleId", roleId);
	}
	
	/**
	 * addDivisionPowerList:批量添加权限
	 * @author lirenkui
	 * @param divisionPowerList
	 * @return
	 */
	public int addDivisionPowerList(List<DivisionPower> divisionPowerList){
		return this.add("addDivisionPowerList", divisionPowerList);
	}
	
	/**
	 * delDivisionPowerList:批量删除权限
	 * @author lirenkui
	 * @param divisionPowerList
	 * @return
	 */
	public int delDivisionPowerList(List<DivisionPower> divisionPowerList){
		return this.delete("delDivisionPowerList", divisionPowerList);
	}
	
	public List<Fun> getRootFunList(List<Integer> roleIdList){
		return this.getList("getRootFunList", roleIdList);
	}
	
	public List<Fun> getSecondFunList(Integer funId,List<Integer> roleIdList){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("&&&&&&&&&&&&&&&&"+funId);
		System.out.println("&&&&&&&&&&&&&&&&"+roleIdList);
		map.put("funId", funId);
		map.put("roleIdList", roleIdList);
		return this.getList("getSecondFunList", map);
	}
	
}
