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

@Controller
@RequestMapping(value="/carInOut")
public class CarInOutController {
	public Logger logger = Logger.getLogger(CarInOutController.class);
	@Resource(name="carInOutService")
	private CarInOutService carInOutService;
	
	@RequestMapping(value="/carInOutList",method=RequestMethod.GET)
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
			
			parameterNames = new String[]{};
			parameterValues = new String[]{};
			
			ToolPage toolPage = ToolPage.pagination(model, pageIndex, carInOutList, totalRecord, pageSize,request.getContextPath()  + "/carInOut/carInOutList", parameterNames, parameterValues);
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			
		} catch (NullPointerException e) {
			logger.error(e.getMessage()+": 进入查询进出车列表出现异常！");
		}
		return "/car_in_out";
	}
}
