/**
 * 
 */
package com.cyou.library.xh.book.web;

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

import com.cyou.library.xh.book.domain.Order;
import com.cyou.library.xh.book.domain.OrderRecord;
import com.cyou.library.xh.book.service.OrderService;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.MyException;
import com.cyou.library.xh.common.util.ToolPage;

/**
 * @author lirenkui
 *
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Resource(name = "orderService")
	private OrderService orderService;
	private Logger logger = Logger.getLogger(OrderController.class);
	private String path = null;
	private String message = "message";

	@RequestMapping(value="/addOrder")
	public String setOrder(Model model,String bookId,HttpServletRequest request,int currentPage){

		try {
			logger.info("========OrderController.setOrder start========");
			Order orderBook = new Order();
			orderBook.setUserId(1);
			orderBook.setId(bookId);
			orderService.addOrder(orderBook);
			logger.info("========OrderController.setOrder success========");
			message = "恭喜你，预定成功！";

		} catch (MyException e) {
			message = e.getMessage();
			logger.error("========OrderController.setOrder error========" + e.getMessage());
		}catch (Exception e) {
			message = "对不起，预定失败！";
			logger.error("========OrderController.setOrder error========" + e.getMessage());
		}
		try {
			path = "redirect:"+"/book/selectBookBorrow?message="+URLEncoder.encode(message,"UTF-8")+"&bookId="+bookId+"&currentPage="+currentPage;
		} catch (UnsupportedEncodingException e) {
			logger.error("========OrderController.setOrder error========" + e.getMessage());
		};
		return path;
	}

	@RequestMapping(value = "/deleOrder")
	public String deleOrder(Model model,Order orderBook,HttpServletRequest request,String currentPage){
		
		try{
			logger.info("====OrderController.deleOrder start====");
			int pageIndex = (Integer.parseInt(currentPage) - 1) >= 0 ? (Integer.parseInt(currentPage) - 1) : 0;
			
			orderService.deleteOrders(orderBook);	
			logger.info("====OrderController.deleOrder success====");
			model.addAttribute("currentPage", currentPage);
			message = "成功取消！";
			///////////////////////////////////////////////////////////////后期修改/////////////////////////////////////////////////////////////////////////////////////
			path = "redirect:" + ConstantUtil.ORDER_PATH + "getUserOrderList?userId=" + orderBook.getUserId() + "&message=" + URLEncoder.encode(message, "UTF-8")+ "&currentPage=" + pageIndex;
		}catch (Exception e) {
			logger.error("====OrderController.deleOrder error====", e);
			message = "对不起，更改失败！";
		}

		return path;
	}

	@RequestMapping(value = "/getUserOrderList")
	public String getUserOrderList(Model model,HttpServletRequest request){

		
		logger.info("====OrderController getUserOrderList start====");
		String user_Id = request.getParameter("userId");
		int userId = Integer.parseInt(user_Id);
		String message = request.getParameter("message");
		String currentPage =  request.getParameter("currentPage");
		
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage: "0"); // 当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS; // 每页最大显示条数
		int totalRecord = 0; // 总记录数
		///////////////////////////////////////////
		userId = 1;
		try {

			List<OrderRecord> orderList = this.orderService.getOrderByUserId(pageIndex,pageSize,userId,null);
			totalRecord = this.orderService.getCountByUserId(userId);
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord,pageSize, request.getContextPath() + ConstantUtil.ORDER_PATH + "getUserOrderList", model, orderList);
			
			if(message != null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
			
			model.addAttribute("toolPage", toolPage);
			//message = "查询数据成功！";
		} catch (Exception e) {
			logger.error("====OrderController getUserOrderList error====" +e.getMessage());
			//message = "获取数据失败！";
		}
		/////////////////////////////////////////////////////////////////////
		path = ConstantUtil.PERSON_CENTER + "personOrderList";


		return path;
	}

}
