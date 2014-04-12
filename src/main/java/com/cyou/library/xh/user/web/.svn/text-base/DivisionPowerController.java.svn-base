/**
 * 
 */
package com.cyou.library.xh.user.web;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.user.domain.DivisionPower;
import com.cyou.library.xh.user.domain.Fun;
import com.cyou.library.xh.user.service.DivisionPowerService;
import com.cyou.library.xh.user.service.FunService;
import com.google.gson.Gson;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/division")
public class DivisionPowerController {

	@Resource(name = "divisionPowerService")
	private DivisionPowerService divisionPowerService;
	@Resource(name = "funService")
	private FunService funService;
	private Logger logger = Logger.getLogger(DivisionPowerController.class);
	private String path = "fail_user";
	private String message = "message";
	
	
	@RequestMapping(value = "/toDivisionPower")
	public String toDivisionPower(Model model,HttpServletRequest request,int roleId,String currentPage){
		
		Gson gson = null;
		String data = null;
		String message = request.getParameter("message");
		currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		logger.info("======DivisionPowerController.toDivisionPower start !======");
		try {

			gson = new Gson();
			List<Fun> funlist = funService.getAllLevelFun();//得到全部功能的目录集合
			Map<String, Integer> secondLength = this.funService.getLength(); //map<String,Integer>String:一级功能的funId,Integer:几级功能所包含的二级功能的个数
			List<DivisionPower> divisionPowersForRoleId = this.divisionPowerService.getDivisionPowersByRoleId(roleId);//当前角色所具有的功能集合
			data = gson.toJson(divisionPowersForRoleId);
			
			if (funlist != null) {
				model.addAttribute("page", funlist);
				model.addAttribute("secondLength", secondLength);
			}
			else
				model.addAttribute("page", null);
			
			model.addAttribute("roleId", roleId);		
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("divisionPowersForRoleId", divisionPowersForRoleId);		
			model.addAttribute("data", data);
		
			if(message != null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
		}catch (Exception e) {
			logger.error("======DivisionPowerController.toDivisionPower error======", e);
		}
		path = ConstantUtil.USER_PATH + "divisionPower";
		return path;
	}
	
	@RequestMapping(value = "/updateDivisionPower")
	public String updateDivisionPower(Model model,HttpServletRequest request,int roleId,String allFunIds,String currentPage){
		
		logger.info("=====DivisionPowerController.updateDivisionPower start=======");
		List<DivisionPower> delTemp= null ,addTemp = null;//记录每次提交时要删除的和要添加的		
		List<DivisionPower> baseDivison = this.divisionPowerService.getDivisionPowersByRoleId(roleId);//根据userId获取当前用户的角色集合
		List<DivisionPower> inputDivision = new ArrayList<DivisionPower>();//得到为用户更改后的角色集合
		String[] inputString = allFunIds.split("&");
		for(int i=0;i<inputString.length;i++){
			DivisionPower inputs = new DivisionPower();
			inputs.setRoleId(roleId);
			inputs.setFunId(Integer.parseInt(inputString[i]));
			inputDivision.add(inputs);
		}
		
		try{
		//求两个集合的差集
		delTemp = new ArrayList(Arrays.asList(new Object[baseDivison.size()]));
		Collections.copy(delTemp, baseDivison);
		delTemp.removeAll(inputDivision);    
		
		addTemp = new ArrayList(Arrays.asList(new Object[inputDivision.size()]));
		Collections.copy(addTemp, inputDivision);
		addTemp.removeAll(baseDivison);    
		
		if(addTemp.size()!=0){
			this.divisionPowerService.addAssignRolesList(addTemp);//批量添加对于某一用户的角色
		}
		if(delTemp.size()!=0){
			this.divisionPowerService.delAssignRolesList(delTemp);//批量删除对某一用户的角色
		}
		
		Map<String, Integer> secondLength = this.funService.getLength();
		model.addAttribute("secondLength", secondLength);
		
		message = "修改信息成功";
		int pageIndex = (Integer.parseInt(currentPage) - 1) >= 0 ? (Integer.parseInt(currentPage) - 1) : 0;
		path = "redirect:" + ConstantUtil.Division_PATH + "toDivisionPower?currentPage=" + pageIndex+"&roleId="+roleId + "&message=" + URLEncoder.encode(message, "UTF-8");
		}catch (Exception e) {
			logger.error("======DivisionPowerController.updateDivisionPower error!======", e);
		}
		
		return path;
	}
}
