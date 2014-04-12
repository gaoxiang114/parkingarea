package com.cyou.library.xh.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 按bean的id获取实例
 * @author gaoxiang_nad
 *
 */
public class SpringUtil implements ApplicationContextAware{

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtil.applicationContext = applicationContext;
	}

	public static Object getBean(String serviceName) {
		return applicationContext.getBean(serviceName);
	}
}
