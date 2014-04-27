/*
 * CopyRight (c) 2014 北京万佳信科技有限公司 保留所有权利。
 */
package com.parkarea.system.service;

import com.parkarea.system.model.SystemInfo;

/**
 * @author <a href="mailto:gaoxiang@good10000.com">高祥</a>
 * @version 1.0.0.2014年4月24日
 */
public interface SystemInfoService {
	
	public SystemInfo getObject();
	
	public void updateObject(SystemInfo sysInfo);
}

