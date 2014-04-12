package com.cyou.library.xh.user.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.ToolPage;
import com.cyou.library.xh.common.web.BaseController;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.service.RoleService;
@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController{
	
	@Resource(name="roleService")
	private RoleService roleService;
	private static Logger logger = Logger.getLogger(RoleController.class);
	
	/**
	 * addRole:进入角色信息添加页面
	 * @author gaoxiang_nad
	 * @param Model model
	 * @param Role role
	 * @param HttpServletRequest request 用来接收url的参数，作为页面的提示信息
	 * @return java.lang.String 转向的页面名
	 */
	@RequestMapping("/toAddRole")
	public String addRole(Model model,Role role,HttpServletRequest request){
		
		String message = request.getParameter("message");
		String currentPage = request.getParameter("currentPage");
		try {
			
			if(message != null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
				model.addAttribute("currentPage", Integer.parseInt(currentPage));
			}
			
		} catch (UnsupportedEncodingException e) {
			logger.error("message解码错误",e);
		}
		
		return ConstantUtil.USER_PATH + "toAddRole";
	}
	
	/**
	 * doAddRole:添加角色信息
	 * @author gaoxiang_nad
	 * @param Model model 
	 * @param Role role 将表单中的信息封装到role对象中
	 * @return java.lang.String 转向的页面名
	 */
	@RequestMapping("/doAddRole")
	public String doAddRole(Model model ,Role role){
		String path = null;
		String message = null;
		Integer allRecord = null;
		Integer currentPage = null;
		Integer pageIndex = null;
		try {
			allRecord = this.roleService.getAllCount();
			Integer oldPageCount = (allRecord+ConstantUtil.PAGE_COUNTS-1)/ConstantUtil.PAGE_COUNTS;
			System.out.println(role.getRoleDesc()+"=======================");
			this.roleService.addRole(role);
			
			allRecord = this.roleService.getAllCount();
			Integer pageCount = (allRecord+ConstantUtil.PAGE_COUNTS-1)/ConstantUtil.PAGE_COUNTS;
			pageIndex = pageCount > oldPageCount ? pageCount : oldPageCount;
			currentPage = pageIndex -1 > 0 ? pageIndex - 1 : 0 ;
			
			message="角色添加成功！";
			path = "redirect:" + ConstantUtil.ROLE_PATH + "toAddRole?message="+URLEncoder.encode(message, "UTF-8")+"&currentPage="+currentPage;
			
		} catch (Exception e) {
			model.addAttribute("message", "角色添加失败");
			logger.error(e.getMessage()+" 添加角色时出现异常");
		}
		
		return path;
				
	}
	
	/**
	 * toRoleList:分页查询
	 * @author gaoxiang_nad
	 * @param Model model 封装数据
	 * @param HttpServletRequest request 获取工程的路径
	 * @return java.lang.String 转到数据列表页面
	 */
	@RequestMapping("/toRolePageList")
	public String toRolePageList(Model model,String currentPage,HttpServletRequest request){
		
		logger.info("toRolePageList method is starting .....");
		
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0");  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<Role> roleList = null;  //定义查询的角色列表roleList

		try {
			
			roleList = this.roleService.getRolePageList(pageIndex, pageSize, null);
			totalRecord = (Integer)this.roleService.getAllCount();
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + ConstantUtil.ROLE_PATH + "toRolePageList", model, roleList);
			
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			
		} catch (NullPointerException e) {
			logger.error("进入查询角色信息列表出现异常！",e);
		}
		
		return ConstantUtil.USER_PATH + "roleList";
	}
	
	/**
	 * doDelRole:按id删除角色信息
	 * @author gaoxiang_nad
	 * @param Model model 封装数据
	 * @param Integer[] roleId 角色的Id，用来查询出对象
	 * @param String currentPage 当前页
	 * @return java.lang.String
	 */
	@RequestMapping(value="/doDelRole",method = RequestMethod.POST)
	public String doDelRole(Model model,Integer[] roleId,String currentPage){
		
		Integer pageIndex = null ;
		try {
			logger.info("doDelRole method is starting .....");
		
			if(roleId != null && roleId.length >0){
				this.roleService.delRole(roleId);
			}
			
			Integer allCount = this.roleService.getAllCount();
			
			pageIndex = (allCount / ConstantUtil.PAGE_COUNTS + (allCount % ConstantUtil.PAGE_COUNTS != 0 ? 1 : 0))
								!= Integer.parseInt(currentPage) ? Integer.parseInt(currentPage)-2 
										:Integer.parseInt(currentPage)-1;
			
			pageIndex = pageIndex >= 0 ?pageIndex : 0;
			
			logger.info("角色删除成功");
			model.addAttribute("message", "删除角色成功");
			
		} catch (Exception e) {
			logger.error("删除角色失败",e);
			model.addAttribute("message", "删除角色失败");
		}
		
		return "redirect:" + ConstantUtil.ROLE_PATH + "toRolePageList?currentPage=" + pageIndex;
	}
	
	/**
	 * toUpdateRolePage:进入修改角色信息页面
	 * @author gaoxiang_nad
	 * @param Model model
	 * @param Integer roleId
	 * @param HttpServletRequest request
	 * @return java.lang.String
	 */
	@RequestMapping(value="/toUpdateRolePage")
	public String toUpdateRolePage(Model model,Integer roleId,HttpServletRequest request){
		String message = request.getParameter("message");
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		Role role = (Role)this.roleService.getRoleById(roleId);
		//判断当前是否存在这条角色信息
		try {
			
			if(role != null){
				model.addAttribute("role", role);
				model.addAttribute("currentPage", currentPage);
			}
		
			if(message != null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
			
		} catch (UnsupportedEncodingException e) {
			logger.error("进入修改页面解码错误",e);
		}
		
		return ConstantUtil.USER_PATH + "updateRole";
	}
	
	/**
	 * doUpdateRole:按roleId修改角色信息
	 * @author gaoxiang_nad
	 * @param Model model
	 * @param Role role
	 * @return java.lang.String
	 */
	@RequestMapping(value="/doUpdateRole")
	public String doUpdateRole(Model model,Role role,HttpServletRequest request){
		
		String message = "";
		String path = null;
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		int pageIndex = (Integer.parseInt(currentPage) - 1) >= 0 ? (Integer.parseInt(currentPage) - 1) : 0;
		try {
			System.out.println(role.getRoleDesc());
			this.roleService.updateRole(role);
			
			message="角色修改成功"; //页面提示信息
			
			path =  "redirect:" + ConstantUtil.ROLE_PATH + "toUpdateRolePage?roleId="+role.getRoleId()+
							"&message="+URLEncoder.encode(message,"UTF-8")
									+"&currentPage="+pageIndex; 
			
		} catch (UnsupportedEncodingException e) {
			
			message="角色修改失败"; //页面提示信息
			logger.error("修改角色信息出现异常：" , e); //添加异常日志s
			
		}
		
		return path;
	}
	
}
