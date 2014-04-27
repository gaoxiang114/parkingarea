/*
 * CopyRight (c) 2014 北京万佳信科技有限公司 保留所有权利。
 */
package com.parkarea.system.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parkarea.system.model.SystemInfo;
import com.parkarea.system.service.SystemInfoService;

/**
 * @author <a href="mailto:gaoxiang@good10000.com">高祥</a>
 * @version 1.0.0.2014年4月24日
 */
@Controller
@RequestMapping(value="/admin")
public class SystemInfoController {
	
	@Resource(name="systemInfoService")
	private SystemInfoService systemInfoService;
	
	@RequestMapping(value="/systemInfo")
	public String systemInfoList(Model model){
		SystemInfo systemInfo =  this.systemInfoService.getObject();
		model.addAttribute("systemInfo", systemInfo);
		return "/system_info";
	}
	
	@RequestMapping(value="/toUpdateSystemInfo")
	public String toSystemInfoUpdate(Model model){
		SystemInfo systemInfo =  this.systemInfoService.getObject();
		model.addAttribute("systemInfo", systemInfo);
		return "/system_update";
	}
	
	@RequestMapping(value="/doUpdateSystemInfo")
	public String doSystemInfoUpdate(SystemInfo systemInfo,HttpServletRequest request){
		this.systemInfoService.updateObject(systemInfo);
		System.setProperty("parkingMoney", String.valueOf(systemInfo.getParkingMoney()));
		System.setProperty("parkingLot", systemInfo.getParkingLot());
		request.getSession().setAttribute("parkingLot", systemInfo.getParkingLot());
		return "redirect:/admin/systemInfo";
	}
}

