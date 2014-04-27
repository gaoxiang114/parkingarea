/*
 * CopyRight (c) 2014 北京万佳信科技有限公司 保留所有权利。
 */
package com.parkarea.system.dao;

import org.springframework.stereotype.Component;

import com.parkarea.common.dao.BaseDao;
import com.parkarea.system.model.SystemInfo;

/**
 * @author <a href="mailto:gaoxiang@good10000.com">高祥</a>
 * @version 1.0.0.2014年4月24日
 */
@Component("systemDao")
public class SystemDao extends BaseDao{

	public SystemInfo getObject(){
		return this.getUniqueOne("getSystemInfoById");
	}
	
	public void updateObject(SystemInfo sysInfo){
		this.update("updateSystemInfo", sysInfo);
	}
}

