package com.parkarea.position.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parkarea.common.util.ConstantUtil;
import com.parkarea.common.util.ToolPage;
import com.parkarea.position.model.ParkingPosition;
import com.parkarea.position.service.ParkingPositionService;

@Controller
@RequestMapping(value="/position")
public class PositionController {

	private Logger logger= Logger.getLogger(PositionController.class);
	@Resource(name="parkingPositionService")
	private ParkingPositionService positionService;
	@RequestMapping(value="/positionList")
	public String list(Model model,HttpServletRequest request,ParkingPosition position){
		logger.info("carInOutList method is starting .....");
		
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		String[] parameterNames = null;
		String[] parameterValues = null;
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<ParkingPosition> positionList = null;  //定义查询的进出车列表
		try {

			positionList = this.positionService.getPositionPageList(pageIndex, pageSize, position);
			totalRecord = (Integer)this.positionService.getAllCount(position);
			
			parameterNames = new String[]{"parkingNum","parkingStatus"};
			parameterValues = new String[]{position.getParkingNum(),String.valueOf(position.getParkingStatus())};
			
			ToolPage toolPage = ToolPage.pagination(model, pageIndex, positionList, totalRecord, pageSize,request.getContextPath()  + "/position/positionList", parameterNames, parameterValues);
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			
		} catch (NullPointerException e) {
			logger.error(e.getMessage()+": 进入查询进出车列表出现异常！");
		}
		return "/position_list";
	}
	
	@RequestMapping(value="toPositionAdd",method=RequestMethod.GET)
	public String toPositionAdd(){
		return "/position_add";
	}
	
	@RequestMapping(value="doPositionAdd",method=RequestMethod.POST)
	public String doPositionAdd(Model model,ParkingPosition position){
		this.positionService.addPosition(position);
		return "redirect:/position/positionList";
	}
	
	@RequestMapping(value="/toPositionUpdate")
	public String toPositionUpdate(Model model,int parkingId){
		ParkingPosition position = this.positionService.getPositionById(parkingId);
		model.addAttribute("position", position);
		return "/position_update";
	}
	
	@RequestMapping(value="/doPositionUpdate")
	public String doUpdateCarInOut(Model model,ParkingPosition position){
		this.positionService.updatePosition(position);
		return "redirect:/position/positionList";
	}
	
	@RequestMapping(value="delPosition")
	public String delPosition(Integer[] parkingId){
		this.positionService.delPosition(parkingId);
		return "redirect:/position/positionList";
	}
	
	@RequestMapping(value="/checkPositionExist",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object checkPositionExist(String parkingNum){
		Integer count = this.positionService.checkPositionExist(parkingNum);
		return count;
	}
	
}
