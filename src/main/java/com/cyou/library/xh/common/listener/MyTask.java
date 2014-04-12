package com.cyou.library.xh.common.listener;

import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.common.util.SpringUtil;
import com.cyou.library.xh.user.dao.UserDao;
import com.cyou.library.xh.user.domain.User;

public class MyTask extends TimerTask {

	private ServletContext context = null;

	public MyTask(ServletContext context) {
		this.context = context;
	}

	public void run() {
		myCode();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void myCode() {
		System.out.println("定时器好用了");
		JdbcTemplate template = (JdbcTemplate)SpringUtil.getBean("jdbcTemplate");

    	List<User> list = (List<User>)template.query("select * from t_user",new BeanPropertyRowMapper(User.class));
    	System.out.println(list.size()+"=======================> size");
		System.out.println("程序执行了！");
	}

}
