package com.cyou.library.xh.common.listener;


import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cyou.library.xh.common.util.ToolTime;

public class TimerTaskListener implements ServletContextListener {

	private Timer timer = null;

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	public void contextInitialized(ServletContextEvent event) {
	    Date startDate = ToolTime.getParseTime(ToolTime.getCurYear()+"-"+ToolTime.getCurMonth()+"-"+"20"+" 00:00:00","yyyy-MM-dd hh:mm:ss");
		System.out.println(startDate.toLocaleString()+"========================================");
	    timer = new Timer(false); // 在这里初始化监听器，在tomcat启动的时候监听器启动，提示可以在这里实现定时器功能
		event.getServletContext().log("定时器启动");
		timer.scheduleAtFixedRate(new MyTask(event.getServletContext()), startDate, 60000*1000);
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		event.getServletContext().log("library timer is cancel..."); // 添加日志，可在tomcat日志中查看到
	}
}
