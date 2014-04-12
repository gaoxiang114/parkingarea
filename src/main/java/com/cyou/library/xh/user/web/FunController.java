/**
 * 
 */
package com.cyou.library.xh.user.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.MyException;
import com.cyou.library.xh.common.util.ToolPage;
import com.cyou.library.xh.user.domain.Fun;
import com.cyou.library.xh.user.service.FunService;
import com.google.gson.Gson;

/**
 * FuncitonController:功能管理控制器
 * 
 * @author lirenkui
 * 
 */
@Controller
@RequestMapping(value = "/fun")
public class FunController {

	@Resource(name = "funService")
	private FunService funService;
	private Logger logger = Logger.getLogger(FunController.class);
	private String path = "fail";
	private String message = null;

	/**
	 * getSecondLevelFun:获取二级功能集合
	 * 
	 * @return lirenkui
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getSecondLevelFun")
	public void getSecondLevelFun(Model model, HttpServletRequest reques,
			HttpServletResponse response, int funId) {

		logger.info("======FunController.getSecondLevelFun start ======");

		PrintWriter out;
		List<Fun> secondLevel = null;
		Gson gson = null;
		String data = null;
		Fun fun = new Fun();
		fun.setFunId(funId);

		try {
			if (funId != 0) {
				secondLevel = funService.getSecondByFatherId(fun);
				gson = new Gson();
				data = gson.toJson(secondLevel);
			} else {
				secondLevel = null;
			}
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "No-cache");
			response.setDateHeader("Expires", 0);

			out = response.getWriter();
			out.print(data);
		} catch (IOException e) {
			logger.error("======FunController.getSecondLevelFun error !======"
					+ e.getMessage());
		}
	}

	/**
	 * getAllLevelFun:得到当前功能目录集合
	 * 
	 * @author lirenkui
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getAllLevelFun")
	public String getAllLevelFun(Model model) {

		logger.info("======FunController.getAllLevelFun start !======");
		try {

			List<Fun> funlist = funService.getAllLevelFun();
			Map<String, Integer> secondLength = this.funService.getLength();
			if (funlist != null) {
				model.addAttribute("page", funlist);
				model.addAttribute("secondLength", secondLength);
			} else
				model.addAttribute("page", null);

			path = ConstantUtil.USER_PATH + "funList";
		} catch (Exception e) {

			model.addAttribute(message, "对不起，查询数据失败！");
			logger.error("======FunController.getAllLevelFun error !======"
					+ e.getMessage());
		}
		return path;
	}

	@RequestMapping(value = "/toFunList")
	public String toFunList(Model model,HttpServletRequest request,String currentPage) {

		int pageIndex = Integer.parseInt(currentPage != null ? currentPage: "0"); // 当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS; // 每页最大显示条数
		int totalRecord = 0; // 总记录数
		List<Fun> funList = null;
		
//		funList = this.funService.getFunList();
		funList = this.funService.getFunList(pageIndex, pageSize, null);
		totalRecord = this.funService.getThirdLevelCount();
		ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord,pageSize, request.getContextPath() + ConstantUtil.Fun_PATH + "toFunList", model, funList);
		model.addAttribute("toolPage", toolPage);
		model.addAttribute("currentPage", pageIndex);
		
		//model.addAttribute("funList", funList != null ? funList : null);
		path = ConstantUtil.USER_PATH + "funList";

		return path;
	}

	/**
	 * toAddFun:跳转页面到add_fun.ftl
	 * @author lirenkui
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAddFun")
	public String toAddFun(Model model, HttpServletRequest request,String currentPage) {

		logger.info("======FunController.toAddFun start ======");
		List<Fun> secondLevel = null;
		List<Fun> firstLevel = null;
		String message = request.getParameter("message");
		currentPage =currentPage != null ? currentPage: "0";
		//String currentPage = request.getParameter("currentPage");
		if(currentPage==null||currentPage.equals(""))
			currentPage = "0";
		try {
			firstLevel = funService.getFirstByFatherId(new Fun());
			//获取一二级目录
			if (firstLevel != null && !firstLevel.equals("")) {
				model.addAttribute("firstLevel", firstLevel);
				secondLevel = funService.getSecondByFatherId(firstLevel.get(0));
				if (secondLevel != null && !secondLevel.equals("")) {
					model.addAttribute("secondLevel", secondLevel);
				} else {
					model.addAttribute("secondLevel", null);
				}
			} else {
				model.addAttribute("firstLevel", null);
				model.addAttribute("secondLevel", null);
			}
			
			if (message != null && !"".equals(message)) {
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
			model.addAttribute("currentPage", Integer.parseInt(currentPage));
		} catch (UnsupportedEncodingException e) {
			logger.error("======FunController.toAddFun error! ====== "
					+ e.getMessage());
		}catch (Exception e) {
			//path// TODO: handle exception
		}
		path = ConstantUtil.USER_PATH + "addFun";
		return path;
	}

	/**
	 * addFun:添加功能
	 * 
	 * @author lirenkui
	 * @param model
	 * @param fun
	 * @param firstlevel
	 * @param secondlevel
	 * @return
	 */
	@RequestMapping(value = "/addFun")
	public String addFun(Model model, Fun fun, int firstLevel, int secondLevel) {

		logger.info("======FunController.addFun start ======");
		Integer allRecord = null;
		Integer currentPage = null;
		Integer pageIndex = null;
		try {
			// 逻辑判断：通过判定所添加的功能目录为几级目录，来设置fatherId
			/*
			 * if (firstLevel == 0) fun.setFatherId(firstLevel); else if
			 * (secondLevel == 0) fun.setFatherId(firstLevel); else
			 */
			allRecord = this.funService.getThirdLevelCount();
			Integer oldPageCount = (allRecord+ConstantUtil.PAGE_COUNTS -1)/ConstantUtil.PAGE_COUNTS;
			
			fun.setFatherId(secondLevel);
			funService.addFun(fun);
			
			Integer newPageCount = (allRecord + ConstantUtil.PAGE_COUNTS)/ConstantUtil.PAGE_COUNTS;
			pageIndex = newPageCount>oldPageCount?newPageCount:oldPageCount;
			currentPage = pageIndex-1 > 0 ? pageIndex-1:0;
			currentPage = (Integer) (currentPage != null ? currentPage: "0");
			//path = "redirect:" + ConstantUtil.USER_PATH + "toAddFun?message=" + URLEncoder.encode(message, "UTF-8") + "&currentPage=" + currentPage;
			message = "角色添加成功！";
			logger.info("======FunController.addFun success ======");

		} catch (MyException e1) {
			message = e1.getMessage();
			logger.error("======FunController.addFun error ======" + e1.getMessage());
			currentPage = 0;
		} catch (Exception e) {
			message = "添加功能失败！";
			logger.error("======FunController.addFun error ======" + e.getMessage());
			currentPage = 0;
		}
		try {
			//path = "redirect:" + ConstantUtil.Fun_PATH + "toAddFun?message=" + URLEncoder.encode(message, "UTF-8");
			path = "redirect:" + ConstantUtil.Fun_PATH + "toAddFun?message=" + URLEncoder.encode(message, "UTF-8") + "&currentPage=" + currentPage;
		} catch (UnsupportedEncodingException e) {
			logger.error("======FunController.addFun error ======" + e.getMessage());
		}
		return path;
	}

	/**
	 * toUpdateFun:跳转页面到update_fun.ftl
	 * 
	 * @author lirenkui
	 * @param model
	 * @param fun
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/toUpdateFun")
	public String toUpdateFun(Model model, int funId, HttpServletRequest request) {

		try {

			logger.info("to the update_fun.ftl");
			String message = request.getParameter("message");
			String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
			Fun third = funService.getFunById(funId);// 通过fun_id获取三级功能目录,其中包含fun_fatherid,fun_fathername
			Fun second = funService.getFunByFatherId(third);// 通过fun的fun_fatherid找到二级功能目录，包括fun_fatherid,fun_fathernam
			Fun first = funService.getFatherFunById(second);// 一级目录
			List<Fun> firstLevel = funService.getFirstByFatherId(new Fun());
			List<Fun> secondLevel = funService.getSecondByFatherId(first);

			if (message != null && !"".equals(message)) {
				model.addAttribute("message",
						URLDecoder.decode(message, "UTF-8"));
			}
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("firstLevel", firstLevel);
			model.addAttribute("secondLevel", secondLevel);
			model.addAttribute("first", first);
			model.addAttribute("second", second);
			model.addAttribute("third", third);
			path = ConstantUtil.USER_PATH + "update_fun";
		} catch (Exception e) {
			logger.error("init the update funciton error", e);
			model.addAttribute(message, "对不起，加载数据出现错误！");
			getAllLevelFun(model);
		}
		return path;
	}

	/**
	 * updateFun:更新功能
	 * @author lirenkui
	 * @param model
	 * @param fun
	 * @param firstLevel
	 * @param secondLevel
	 * @return
	 */
	@RequestMapping(value = "/updateFun")
	public String updateFun(Model model, Fun fun, int firstLevel,int secondLevel,HttpServletRequest request) {

		logger.info("add fun" + fun);
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		try {
			
				fun.setFatherId(secondLevel);
			funService.updateFun(fun);

			logger.info("add function success!");
			message = "恭喜您，数据更新成功！";
		} /*
		 * catch (MyException e) {
		 * 
		 * logger.error("update function error---has the same name function",
		 * e); model.addAttribute(message, e.getMessage());
		 * getAllLevelFun(model); }
		 */catch (Exception e) {

			logger.error("add function error", e);
			message = "对不起，更新数据失败！";
		}
		try {
			path = "redirect:" + ConstantUtil.Fun_PATH + "toUpdateFun?currentPage="+currentPage+"&message=" + URLEncoder.encode(message, "UTF-8") + "&funId=" + fun.getFunId();
		} catch (UnsupportedEncodingException e) {
			logger.error("======FunController.updateFun error ======"
					+ e.getMessage());
		}

		return path;
	}

}
