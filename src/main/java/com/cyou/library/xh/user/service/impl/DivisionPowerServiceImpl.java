/**
 * 
 */
package com.cyou.library.xh.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyou.library.xh.user.dao.DivisionPowerDao;
import com.cyou.library.xh.user.domain.DivisionPower;
import com.cyou.library.xh.user.domain.Fun;
import com.cyou.library.xh.user.service.DivisionPowerService;

/**
 * @author Administrator
 *
 */
@Service("divisionPowerService")
public class DivisionPowerServiceImpl implements DivisionPowerService {

	@Resource(name = "divisionPowerDao")
	private DivisionPowerDao divisionPowerDao;

	public List<DivisionPower> getDivisionPowersByRoleId(int roleId) {
		return this.divisionPowerDao.getDivisionPowerByRoleId(roleId);
	}

	public int addAssignRolesList(List<DivisionPower> divisionPowerList) {
		return this.divisionPowerDao.addDivisionPowerList(divisionPowerList);
	}

	public int delAssignRolesList(List<DivisionPower> divisionPowerList) {
		return this.divisionPowerDao.delDivisionPowerList(divisionPowerList);
	}

	public List<Fun> getRootFunList(List<Integer> roleIdList) {
		return this.divisionPowerDao.getRootFunList(roleIdList);
	}
	
}
