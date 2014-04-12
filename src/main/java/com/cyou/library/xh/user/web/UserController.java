/**
 * 
 */
package com.cyou.library.xh.user.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.MyException;
import com.cyou.library.xh.common.util.ToolPage;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.domain.User;
import com.cyou.library.xh.user.service.RoleService;
import com.cyou.library.xh.user.service.UserService;
import com.google.gson.Gson;

/**
 * UserController:人员管理控制器
 * @author lirenkui
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "roleService")
	private RoleService roleService;
	
	private Logger logger = Logger.getLogger(UserController.class);
	private String path = null;
	private String message = "message";

	
	@RequestMapping(value= "/toLogin")
	public String login(){
		return "/login";
	}
	
	@RequestMapping(value= "/login")
	public String login(Model model,HttpServletRequest request,User user){
		
		String message = null;
		User u = this.userService.checkUser(user);
		if(u != null){
			Map<String,Object> permitMap = userService.login(u);
			List roleIdList = (List)permitMap.get("roleIdList");
			if(roleIdList == null){
				message = "你的帐号被冻结，请到管理员处解除";
				return "/login";
			}
			permitMap.put("user", u);
			request.getSession().setAttribute("permitMap", permitMap);
			return "/index";
		}else{
			return "/login";
		}
	}
	/**
	 * toAddUser:跳转到页面
	 * @author lirenkui
	 * @param model
	 * @return String 转向的页面名称
	 */
	@RequestMapping(value = "/toAddUser")
	public String toAddUser(Model model, HttpServletRequest request) {

		String message = request.getParameter("message");
		String currentPage = request.getParameter("currentPage");
		String inputString = request.getParameter("quicklyInput");
		currentPage = currentPage != null&&!currentPage.equals("") ? currentPage: "0";
		try {
			List<Role> roleList = this.roleService.getRoleList();
			model.addAttribute("roleList", roleList);
			if (message != null && !"".equals(message)) {
				model.addAttribute("message",URLDecoder.decode(message, "UTF-8"));}
			if(inputString!=null&&!"".equals(inputString)){
				model.addAttribute("quicklyInput", URLDecoder.decode(inputString, "UTF-8"));
			}
			model.addAttribute("currentPage", currentPage);
		} catch (UnsupportedEncodingException e) {
			logger.error("message解码错误", e);
		}
		return ConstantUtil.USER_PATH + "addUser";
	}

	/**
	 * addUser:添加用户
	 * @author lirenkui
	 * @param model
	 * @param user
	 * @return String 转向的页面名称
	 */
	@RequestMapping(value = "/addOne")
	public String addUser(Model model, User user, int[] roleId,HttpServletRequest request, String currentPage) {

		Integer allRecord = null;
		Integer current = null;
		Integer pageIndex = null;
		String inputString = request.getParameter("quicklyInput");
		Integer currentP = currentPage == null ? Integer.parseInt("0"): Integer.parseInt(currentPage);
		currentP = (currentP - 1 >= 0) ? (currentP - 1) : 0;;

		try {
			logger.info("======UserController addUser start ======");
			user.setUser_num(user.getUser_num().trim().toLowerCase());
			user.setUser_mail(user.getUser_mail().trim() + "@cyou-inc.com");
			if(inputString!=null&&!"".equals(inputString)){
				
			allRecord = this.userService.getAllUserRecords();
			Integer oldPageCount = (allRecord + ConstantUtil.PAGE_COUNTS - 1)/ConstantUtil.PAGE_COUNTS;
			userService.addUser(user, roleId);
			allRecord = this.userService.getAllUserRecords();
			Integer newPageCount = (allRecord + ConstantUtil.PAGE_COUNTS - 1)/ConstantUtil.PAGE_COUNTS;
			pageIndex = newPageCount > oldPageCount ? newPageCount: oldPageCount;
			}else{
				allRecord = this.userService.getCountByFuzzy(inputString);
				Integer oldPageCount = (allRecord + ConstantUtil.PAGE_COUNTS - 1)/ConstantUtil.PAGE_COUNTS;
				userService.addUser(user, roleId);
				allRecord = this.userService.getCountByFuzzy(inputString);
				Integer newPageCount = (allRecord + ConstantUtil.PAGE_COUNTS - 1)/ConstantUtil.PAGE_COUNTS;
				pageIndex = newPageCount > oldPageCount ? newPageCount: oldPageCount;
			}
			current = pageIndex - 1 > 0 ? pageIndex - 1 : 0;
			current = (Integer) (current != null ? current : "0");

			message = "恭喜，信息添加成功！";
			model.addAttribute("user", user);
			path = "redirect:" + ConstantUtil.USER_PATH + "toAddUser?message=" + URLEncoder.encode(message, "UTF-8") + "&currentPage=" + current + "&quicklyInput=" + URLEncoder.encode(inputString, "UTF-8");
			logger.info("======UserController addUser success ======");
		} catch (MyException e) {
			try {
				message = e.getMessage();
				path = "redirect:" + ConstantUtil.USER_PATH + "toAddUser?message=" + URLEncoder.encode(message, "UTF-8") + "&currentPage=" + currentP +"&quicklyInput=" + URLEncoder.encode(inputString, "UTF-8");
				logger.error("======UserController addUser error ======" + e.getMessage());
			} catch (UnsupportedEncodingException e1) {
				logger.error("======UserController addUser error ======" + e1.getMessage());
			}
		} catch (Exception e) {
			try {
				message = "对不起，数据添加失败！";
				path = "redirect:" + ConstantUtil.USER_PATH + "toAddUser?message=" + URLEncoder.encode(message, "UTF-8") + "&currentPage=" + currentP +"&quicklyInput=" + URLEncoder.encode(inputString, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				logger.error("======UserController addUser error ======" + e1.getMessage());
			}
		}
		return path;
	}

	/**
	 * toUserPageList:分页查询
	 * @author lirenkui
	 * @param Model model 封装数据
	 * @param HttpServletRequest request 获取工程的路径
	 * @return java.lang.String 转到数据列表页面
	 */
	@RequestMapping("/toUserPageList")
	public String toUserPageList(Model model, String currentPage, HttpServletRequest request) {

		logger.info("=====UserController.toUserPageList start!=====");
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0"); // 当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS; // 每页最大显示条数
		int totalRecord = 0; // 总记录数
		List<User> userList = null; // 定义查询的角色列表userList

		try {
			userList = userService.getUserPageList(pageIndex, pageSize, null);
			totalRecord = (Integer) userService.getAllUserRecords();
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + ConstantUtil.USER_PATH + "toUserPageList", model, userList);

			// 将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			model.addAttribute("currentPage", pageIndex);
			String message = request.getParameter("message");
			if (message != null && !"".equals(message)) {
				model.addAttribute("message",URLDecoder.decode(message, "UTF-8"));
			}
		} catch (Exception e) {
			logger.error("=====UserController.toUserPageList error!=====", e);
		}

		return ConstantUtil.USER_PATH + "userList";
	}

	/**
	 * getUsersQuickly:快速搜索
	 * @param model
	 * @param quicklyInput
	 * @return
	 */
	@RequestMapping(value = "/getUsersQuickly")
	public String getUsersQuickly(Model model, String quicklyInput, String currentPage, HttpServletRequest request) {
		try {

			int totalRecord = 0; // 总记录数
			List<User> userList = null; // 定义查询的角色列表userList
			logger.info("=====UserController.getUsersQuickly start!=====");
			int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0"); // 当前的页数
			int pageSize = ConstantUtil.PAGE_COUNTS; // 每页最大显示条数
			String message = request.getParameter("message");
			userList = this.userService.getUserListByFuzzy(pageIndex, pageSize, quicklyInput, null);
			totalRecord = this.userService.getCountByFuzzy(quicklyInput);
			ToolPage toolPage = ToolPage.pagination( pageIndex, totalRecord,pageSize, request.getContextPath() + ConstantUtil.USER_PATH + "getUsersQuickly?quicklyInput=" + URLEncoder.encode(quicklyInput, "UTF-8"), model, userList);

			model.addAttribute("toolPage", toolPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("quicklyInput",URLDecoder.decode(quicklyInput, "UTF-8"));
			if (message != null && !"".equals(message)) {
				model.addAttribute("message",URLDecoder.decode(message, "UTF-8"));
			}
			String inputString = request.getParameter("quicklyInput");
			if(inputString!=null&&!"".equals(inputString)){
				model.addAttribute("quicklyInput", URLDecoder.decode(inputString,"utf-8"));
			}
		} catch (Exception e) {
			logger.error("=====UserController getUsersQuickly error!=====" + e.getMessage());
		}
		return ConstantUtil.USER_PATH + "userList";
	}

	/**
	 * toUpdateUser：跳转到update_user页面
	 * @author lirenkui
	 * @param model
	 * @param user
	 * @return 转向的页面名称
	 */
	@RequestMapping(value = "/toUpdateUser")
	public String toUpdateUser(Model model, User user, HttpServletRequest request) {

		try {

			logger.info(user + "forward to updateUser.ftl");
			String message = request.getParameter("message");
			String inputString = request.getParameter("quicklyInput");
			String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
			
			user = userService.getUserByUserId(user);
			user.setUser_mail(user.getUser_mail().split("@")[0]);// 将邮箱字符串自@后面的字符去掉

			if (user != null) {
				model.addAttribute("user", user);
				model.addAttribute("currentPage", currentPage);
			}
			if (inputString != null && !inputString.equals("")) {
				model.addAttribute("quicklyInput",URLDecoder.decode(inputString, "UTF-8"));
			}
			if (message != null && !"".equals(message)) {
				model.addAttribute("message",URLDecoder.decode(message, "UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("进入修改页面解码错误", e);
		}
		return ConstantUtil.USER_PATH + "update_user";
	}

	/**
	 * updateUser:修改用户个人信息
	 * @author lirenkui
	 * @param model
	 * @param user user的user_id
	 * @return 转向的页面名称
	 */
	@RequestMapping(value = "/updateUser")
	public String updateUser(Model model, User user, HttpServletRequest request) {

		try {
			logger.info("=====UserController updateUser start!=====");
			String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
			int pageIndex = (Integer.parseInt(currentPage) - 1) >= 0 ? (Integer.parseInt(currentPage) - 1) : 0;
			String quicklyInput = request.getParameter("quicklyInput");
			user.setUser_mail(user.getUser_mail().trim() + "@cyou-inc.com");
			
			userService.updateUser(user);
			logger.info("update success!");
			message = "修改信息成功";
			path = "redirect:" + ConstantUtil.USER_PATH + "toUpdateUser?currentPage=" + pageIndex + "&user_id=" + user.getUser_id() + "&quicklyInput=" + URLEncoder.encode(quicklyInput, "UTF-8") + "&message=" + URLEncoder.encode(message, "UTF-8");
		}catch (Exception e) {
			logger.error("=====UserController updateUser error!=====" + e.getMessage());
		}
		return path;
	}

	/**
	 * deleteUsers:批量删除用户
	 * @author lirenkui
	 * @param model
	 * @param user_id 用户user_id数组
	 * @param pagenum 批量删除的用户所在的分页页码
	 * @return
	 */
	@RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
	public String deleteUsers(Model model, int[] user_id, String currentPage,HttpServletRequest request) {

		Integer pageIndex = null;
		logger.info("=====UserController deleteUsers start!=====");
		String inputString = request.getParameter("quicklyInput");
		List idList = new ArrayList();
		Integer current = null;
		try {
			if(inputString!=null&&!"".equals(inputString)){
				Integer allRecord = this.userService.getCountByFuzzy(inputString);
				Integer oldPageCount = (allRecord + ConstantUtil.PAGE_COUNTS - 1)/ConstantUtil.PAGE_COUNTS;
				if (user_id != null && user_id.length > 0) {
					// 将user_id数组转换为list集合
					for (int i = 0; i < user_id.length; i++)
						idList.add(user_id[i]);
					userService.delUserList(idList);
				}
				
				allRecord = this.userService.getCountByFuzzy(inputString);
				Integer newPageCount = (allRecord + ConstantUtil.PAGE_COUNTS-1)/ConstantUtil.PAGE_COUNTS;
				pageIndex = newPageCount < oldPageCount ? newPageCount: oldPageCount;
				current = pageIndex - 1 >= 0 ? pageIndex - 1 : 0;
				current = (Integer) (current != null ? current : "0");
				
				//model.addAttribute("message", URLEncoder.encode("删除成功");
				path = "redirect:" + ConstantUtil.USER_PATH + "getUsersQuickly?currentPage=" + current+"&quicklyInput=" + URLEncoder.encode(inputString,"UTF-8") + "&message=" + URLEncoder.encode("删除成功！","utf-8");
				//path = "redirect:" + ConstantUtil.USER_PATH + "getUsersQuickly?currentPage=" + current+"&quicklyInput=" + URLEncoder.encode(inputString,"UTF-8") + "&message=" + URLEncoder.encode("删除成功！","utf-8");
			}else{
			
			
				Integer allRecord = this.userService.getAllUserRecords();
				Integer oldPageCount = (allRecord + ConstantUtil.PAGE_COUNTS - 1)/ConstantUtil.PAGE_COUNTS;
				if (user_id != null && user_id.length > 0) {
					// 将user_id数组转换为list集合
					for (int i = 0; i < user_id.length; i++)
						idList.add(user_id[i]);
					userService.delUserList(idList);
				}
				
				allRecord = this.userService.getAllUserRecords();
				Integer newPageCount = (allRecord + ConstantUtil.PAGE_COUNTS-1)/ConstantUtil.PAGE_COUNTS;
				pageIndex = newPageCount < oldPageCount ? newPageCount: oldPageCount;
				current = pageIndex - 1 >= 0 ? pageIndex - 1 : 0;
				current = (Integer) (current != null ? current : "0");
	
				//path = "redirect:" + ConstantUtil.USER_PATH + "toUserPageList?currentPage=" + current;
				path = "redirect:" + ConstantUtil.USER_PATH + "toUserPageList?currentPage=" + current + "&message=" + URLEncoder.encode("删除成功！","utf-8");
			}
		} catch (Exception e) {

			logger.error("=====UserController deleteUsers error!=====");
			model.addAttribute(message, "对不起，删除出现错误！");
			model.addAttribute("quicklyInput",inputString);
			try {
			if(inputString!=null&&!"".equals("")){
				path = "redirect:" + ConstantUtil.USER_PATH + "getUsersQuickly?currentPage=" + current+"&quicklyInput=" + URLEncoder.encode(inputString,"UTF-8") + "&message=" + URLEncoder.encode("删除成功！","utf-8");
			}else{
				path = "redirect:" + ConstantUtil.USER_PATH + "toUserPageList?currentPage=" + current + "&message=" + URLEncoder.encode("删除成功！","utf-8");
			}
			} catch (UnsupportedEncodingException e1) {
				logger.error("=====UserController deleteUsers error!=====" +e.getMessage());
			}
		}
			return path;
	}

	/**
	 * toUpdateUserPassword:跳转页面到update_userpwd.ftl
	 * @author lirenkui
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toUpdateUserPassword")
	public String toUpdateUserPassword(Model model, HttpServletRequest request) {

		try {
			logger.info("=====UserController toUpdateUserPassword start ! =======");
			// ********************************************************************************************************************************************//
			model.addAttribute("user_num", "sx1618");// 测试数据
			String message = request.getParameter("message");
			if (message != null && !"".equals(message)) {
				model.addAttribute("message",URLDecoder.decode(message, "UTF-8"));
			}
			logger.info("=====UserController toUpdateUserPassword success ! =======");
		} catch (UnsupportedEncodingException e) {
			logger.error("=====UserController toUpdateUserPassword error ! =======");
		}
		path = ConstantUtil.USER_PATH + "updateUserpwd";
		return path;
	}

	/**
	 * updateUserPassword:更新用户密码
	 * @param model
	 * @param oldpwd
	 * @param newpwd
	 * @param checkpwd
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUserPassword")
	public String updateUserPassword(Model model, String oldpwd, String newpwd,String checkpwd, User user, HttpServletRequest request,HttpServletResponse response) {
		
		PrintWriter out;
		String result = null;
		Gson gson = null;
		try {

			logger.info("=====UserController updateUserPassword success ! =======");
			userService.updateUserPassword(user, oldpwd, newpwd);
			message = "密码修改成功！";
			model.addAttribute("message", message);
			gson = new Gson();
			message = "1";
			result = gson.toJson(message);
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "No-cache");
			response.setDateHeader("Expires", 0);
			out = response.getWriter();
			out.print(result);
		} catch (IOException e) {
			logger.error("=====UserController updateUserPassword error ! =======" + e.getMessage());
		}
		return path;
	}

	@RequestMapping(value = "/updatePerson")
	public String updatePerson(Model model, HttpServletRequest request, User user) {

		try {
			user.setUser_mail(user.getUser_mail() + "@cyou-inc.com");
			this.userService.updateUserMail(user);
			message = "邮箱修改成功！";
			path = "redirect:" + ConstantUtil.USER_PATH + "getPersonMessage?userId=" + user.getUser_id() + "&message=" + URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("=====UserController updatePerson error ! =======" + e);
		}
		return path;
	}

	@RequestMapping(value = "/getPersonMessage")
	public String getPersonMessage(Model model, HttpServletRequest request, int userId) {

		User user = new User();
		user.setUser_id(userId);
		message = request.getParameter("message");
		user = this.userService.getUserByUserId(user);
		user.setUser_mail(user.getUser_mail().split("@")[0]);
		model.addAttribute("user", user);
		try {
			if (user != null) {
				model.addAttribute("user", user);
			}
			if (message != null && !"".equals(message)) {
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("进入修改页面解码错误", e);
		}
		path = ConstantUtil.PERSON_CENTER + "updatePerson";
		return path;
	}
}
