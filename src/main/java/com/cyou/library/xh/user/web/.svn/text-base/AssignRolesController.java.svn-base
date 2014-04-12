/**
 * 
 */
package com.cyou.library.xh.user.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.user.domain.AssignRoles;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.domain.User;
import com.cyou.library.xh.user.service.AssignRolesService;
import com.cyou.library.xh.user.service.RoleService;
import com.google.gson.Gson;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/assign")
public class AssignRolesController {

	@Resource(name = "assignRolesService")
	private AssignRolesService assignRolesService;
	@Resource(name = "roleService")
	private RoleService roleService;
	
	private Logger logger = Logger.getLogger(AssignRolesController.class);
	private String path = "fail_user";
	private String message = "message";
	
	@RequestMapping(value = "/toAssignRoles")
	public String toAssignRoles(Model model,HttpServletRequest request,User user){
		
		Gson gson = null;
		String data = null;
		String message = request.getParameter("message");
		String inputString = request.getParameter("quicklyInput");
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		logger.info(user + "forward to updateUser.ftl");
		List<Role> userRoles = this.assignRolesService.getRolesList(user.getUser_id());//根据userId获取当前用户的角色集合
		user.setAssignList(userRoles);
		List<Role> roleList = this.roleService.getRoleList();//获取全部角色
		
		gson = new Gson();
		data = gson.toJson(user.getAssignList());
		try {
			
			if(user != null){
				model.addAttribute("user", user);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("roleList", roleList);
				model.addAttribute("data", data);
			}
		
			if(message != null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
			if(inputString!=null&&!"".equals(inputString)){
				model.addAttribute("quicklyInput", URLDecoder.decode(inputString, "UTF-8"));
			}
			
		} catch (UnsupportedEncodingException e) {
			logger.error("进入修改页面解码错误",e);
		}
		path = ConstantUtil.USER_PATH + "assignRoles";
		return path; 
	}
	
	@RequestMapping(value = "/updateAssignRoles")
	public String updateAssignRoles(Model model,int[] roleId,int user_id,String currentPage,HttpServletRequest request){
		
		logger.info("=====AssignRolesControll.updateAssignRoles start=======");
		String quicklyInput = request.getParameter("quicklyInput");
		List<AssignRoles> delTemp= null ,addTemp = null;//记录每次提交时要删除的和要添加的		
		List<AssignRoles> baseAssignRoles = this.assignRolesService.getAssignRoles(user_id);//根据userId获取当前用户的角色集合
		List<AssignRoles> inputAssignRoles = new ArrayList<AssignRoles>();//得到为用户更改后的角色集合
		for(int i=0;i<roleId.length;i++){
			AssignRoles inputs = new AssignRoles();
			inputs.setUserId(user_id);
			inputs.setRoleId(roleId[i]);
			inputAssignRoles.add(inputs);
		}
		
		try{
		//求两个集合的差集
		delTemp = new ArrayList(Arrays.asList(new Object[baseAssignRoles.size()]));
		Collections.copy(delTemp, baseAssignRoles);
		delTemp.removeAll(inputAssignRoles);    
		
		addTemp = new ArrayList(Arrays.asList(new Object[inputAssignRoles.size()]));
		Collections.copy(addTemp, inputAssignRoles);
		addTemp.removeAll(baseAssignRoles);    
		
		if(addTemp.size()!=0){
			this.assignRolesService.addAssignRolesList(addTemp);//批量添加对于某一用户的角色
		}
		if(delTemp.size()!=0){
			this.assignRolesService.delAssignRolesList(delTemp);//批量删除对某一用户的角色
		}
		
		int pageIndex = (Integer.parseInt(currentPage) - 1) >= 0 ? (Integer.parseInt(currentPage) - 1) : 0;
		message = "修改信息成功";
		path = "redirect:" + ConstantUtil.ASSIGN_PATH + "toAssignRoles?currentPage=" + pageIndex+"&user_id="+user_id + "&message=" + URLEncoder.encode(message, "UTF-8")+"&quicklyInput=" + quicklyInput;
		}catch (Exception e) {
			logger.error("======AssignRolesController.updateAssignRoles error!======", e);
		}
		
		return path;
	}
	
}
