package com.parkarea.park.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.parkarea.common.util.ConstantUtil;
import com.parkarea.common.util.ToolPage;
import com.parkarea.park.model.CarInOut;
import com.parkarea.park.service.CarInOutService;
import com.parkarea.position.model.ParkingPosition;
import com.parkarea.position.service.ParkingPositionService;

@Controller
@RequestMapping(value="/carInOut")
public class CarInOutController {
	public Logger logger = Logger.getLogger(CarInOutController.class);
	@Resource(name="carInOutService")
	private CarInOutService carInOutService;
	@Resource(name="parkingPositionService")
	private ParkingPositionService positionService;
	
	@RequestMapping(value="/carInOutList",method={RequestMethod.GET,RequestMethod.POST})
	public String carInOutList(Model model,HttpServletRequest request,CarInOut carInOut){
		logger.info("carInOutList method is starting .....");
		
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		String[] parameterNames = null;
		String[] parameterValues = null;
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<CarInOut> carInOutList = null;  //定义查询的进出车列表
		try {

			carInOutList = this.carInOutService.getCarInOutPageList(pageIndex, pageSize, carInOut);
			totalRecord = (Integer)this.carInOutService.getAllCount();
			
			parameterNames = new String[]{"carNum","realname","idCard"};
			parameterValues = new String[]{carInOut.getCarNum(),carInOut.getRealname(),carInOut.getIdCard()};
			
			ToolPage toolPage = ToolPage.pagination(model, pageIndex, carInOutList, totalRecord, pageSize,request.getContextPath()  + "/carInOut/carInOutList", parameterNames, parameterValues);
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			
		} catch (NullPointerException e) {
			logger.error(e.getMessage()+": 进入查询进出车列表出现异常！");
		}
		return "/car_in_out";
	}
	
	@RequestMapping(value="/historyList",method={RequestMethod.GET,RequestMethod.POST})
	public String historyList(Model model,HttpServletRequest request,CarInOut carInOut){
		logger.info("carInOutList method is starting .....");
		
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		String[] parameterNames = null;
		String[] parameterValues = null;
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<CarInOut> carInOutList = null;  //定义查询的进出车列表
		try {

			carInOutList = this.carInOutService.getHistoryList(pageIndex, pageSize, carInOut);
			totalRecord = (Integer)this.carInOutService.getHistoryAllCount();
			
			parameterNames = new String[]{"carNum","realname","idCard"};
			parameterValues = new String[]{carInOut.getCarNum(),carInOut.getRealname(),carInOut.getIdCard()};
			
			ToolPage toolPage = ToolPage.pagination(model, pageIndex, carInOutList, totalRecord, pageSize,request.getContextPath()  + "/carInOut/historyList", parameterNames, parameterValues);
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			
		} catch (NullPointerException e) {
			logger.error(e.getMessage()+": 进入查询进出车列表出现异常！");
		}
		return "/history_list";
	}
	
	@RequestMapping(value="toCarInOutAdd",method=RequestMethod.GET)
	public String toCarInOutAdd(Model model,int parkingId){
		model.addAttribute("parkingId", parkingId);
		return "/car_in_out_add";
	}
	
	@RequestMapping(value="doCarInOutAdd",method=RequestMethod.POST)
	public String doCarInOutAdd(Model model,CarInOut carInOut){
		carInOut.setPriceHour(Double.valueOf(System.getProperty("parkingMoney")));
		this.carInOutService.addCarInOut(carInOut);
		ParkingPosition position = new ParkingPosition();
		position.setParkingId(carInOut.getParkingId());
		position.setParkingStatus(1);
		this.positionService.updatePosition(position);
		return "redirect:/carInOut/carInOutList";
	}
	
	/*@RequestMapping(value="/toCarInOutUpdate")
	public String toUpdateCarInOut(Model model,int id){
		CarInOut carInOut = this.carInOutService.getCarInOutById(id);
		model.addAttribute("carInOut", carInOut);
		return "/car_in_out_update";
	}
	
	@RequestMapping(value="/doUpdateCarInOut")
	public String doUpdateCarInOut(){
		return "";
	}*/
	
	@RequestMapping(value="calcMoney",method=RequestMethod.POST)
	public String calcMoney(int id,String totalPrice){
		CarInOut carInOut = this.carInOutService.getCarInOutById(id);
		carInOut.setStatus("1");
		carInOut.setTotalPrice(Double.parseDouble(totalPrice));
		this.carInOutService.updateCarInOut(carInOut);
		ParkingPosition position = new ParkingPosition();
		position.setParkingId(carInOut.getParkingId());
		position.setParkingStatus(0);
		this.positionService.updatePosition(position);
		return "redirect:/carInOut/carInOutList";
	}
}
