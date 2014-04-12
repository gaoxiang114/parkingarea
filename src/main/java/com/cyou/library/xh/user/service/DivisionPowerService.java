/**
 * 
 */
package com.cyou.library.xh.user.service;

import java.util.List;

import com.cyou.library.xh.user.domain.DivisionPower;
import com.cyou.library.xh.user.domain.Fun;

/**
 * @author Administrator
 *
 */
public interface DivisionPowerService {

	/**
	 * getDivisionPowersByRoleId:根据roleid获取对应的全县集合
	 * @author lirenkui
	 * @param roleId
	 * @return
	 */
	public List<DivisionPower> getDivisionPowersByRoleId(int roleId);
	
	/**
	 * addAssignRolesList:批量添加权限
	 * @author lirenkui
	 * @param divisionPowerList
	 * @return
	 */
	public int addAssignRolesList(List<DivisionPower> divisionPowerList);
	
	/**
	 * delAssignRolesList:批量删除权限
	 * @author lirenkui
	 * @param divisionPowerList
	 * @return
	 */
	public int delAssignRolesList(List<DivisionPower> divisionPowerList);
	
	public List<Fun> getRootFunList(List<Integer> roleIdList);
	
}
