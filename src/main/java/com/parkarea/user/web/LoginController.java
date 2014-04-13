package com.parkarea.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parkarea.common.util.Md5ConverterUtil;
import com.parkarea.user.model.User;
import com.parkarea.user.service.UserService;

/**
 * @author <a href="mailto:gaoxiang@good10000.com">高祥</a>
 * @version 1.0.0.2013年10月18日
 */
@Controller
@RequestMapping(value="/manager")
public class LoginController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String login(User user,HttpServletRequest request){
		if(user == null ||StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPasswd())){
			return "/login";
		}
		user.setPasswd(Md5ConverterUtil.Md5(user.getPasswd()));
		User _user = this.userService.checkUser(user);
		if(_user == null){
			return "/login";
		}
		request.getSession().setAttribute("user", _user);
		return "redirect:/manager/user/index";
	}
	
}

