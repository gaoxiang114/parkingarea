/*
 * CopyRight (c) 2014 北京万佳信科技有限公司 保留所有权利。
 */
package com.parkarea.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parkarea.system.dao.SystemDao;
import com.parkarea.system.model.SystemInfo;
import com.parkarea.system.service.SystemInfoService;

/**
 * @author <a href="mailto:gaoxiang@good10000.com">高祥</a>
 * @version 1.0.0.2014年4月24日
 */
@Service("systemInfoService")
public class SystemInfoServiceImpl implements SystemInfoService {

	@Resource(name="systemDao")
	private SystemDao systemInfoDao;
	@Override
	public SystemInfo getObject() {
		return systemInfoDao.getObject();
	}

	@Override
	public void updateObject(SystemInfo sysInfo) {
		systemInfoDao.updateObject(sysInfo);
	}


}

