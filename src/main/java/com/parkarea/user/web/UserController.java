package com.parkarea.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parkarea.common.util.Md5ConverterUtil;
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
		return "redirect:/carInOut/carInOutList";
	}
	
	@RequestMapping(value="/toEditPasswdPage")
	public String toEditPasswdPage(){
		return "/editPasswd";
	}
	
	@RequestMapping(value="/doEditPasswd")
	public String doEditPasswd(Model model,HttpServletRequest request,String oldPasswd,String newPasswd){
		User user = (User) request.getSession().getAttribute("user");
		if(!user.getPasswd().equals(Md5ConverterUtil.Md5(oldPasswd))){
			model.addAttribute("msg", "原密码输入的不正确!");
			return "redirect:/manager/user/toEditPasswdPage";
		}else{
			user.setPasswd(Md5ConverterUtil.Md5(newPasswd));
			model.addAttribute("msg", "密码修改成功,请重新登录!");
			this.userService.editPasswd(user);
		}
		return "redirect:/manager/login";
	}
}

