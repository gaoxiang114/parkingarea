package com.parkarea.user.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parkarea.user.model.User;
import com.parkarea.user.service.UserService;


/**
 * @author <a href="mailto:gaoxiang@good10000.com">高祥</a>
 * @version 1.0.0.2013年10月16日
 */
@Controller
@RequestMapping(value="/manager/user")
public class UserController{
	
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * 
	 * Description: 通过id获取user对象
	 * @param int
	 * @param model
	 */
	@RequestMapping(value="/getUser")
	public void getUser(Model model){
		
	}
	
	@RequestMapping(value="/index")
	public String login(Model model,User user){
		return "/index";
	}
	
}

