package com.parkarea.common.util;


import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.jdbc.core.JdbcTemplate;


public class TimerTaskListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		JdbcTemplate template = (JdbcTemplate)SpringUtil.getBean("jdbcTemplate");
		java.util.Map data = (java.util.Map)template.queryForList("select * from sys_info").get(0);
		System.setProperty("parkingCount", String.valueOf(data.get("parking_count")));
		System.setProperty("parkingMoney", String.valueOf(data.get("parking_money")));
		System.setProperty("parkingLot", String.valueOf(data.get("parking_lot")));
		System.setProperty("sysId", String.valueOf(data.get("sys_id")));
		System.setProperty("currentNum", "0");
		System.out.println(System.getProperty("parkingCount")+"----------------");
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		event.getServletContext().log("listener is destroy ......"); // 添加日志，可在tomcat日志中查看到
	}
}
