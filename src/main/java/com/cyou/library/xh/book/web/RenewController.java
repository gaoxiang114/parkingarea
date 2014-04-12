/**
 * 
 */
package com.cyou.library.xh.book.web;

import java.net.URLEncoder;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.library.xh.book.domain.PersonBorrow;
import com.cyou.library.xh.book.service.RenewService;
import com.cyou.library.xh.borrow.domain.BorrowRecord;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.MyException;

/**
 * @author lirenkui
 *
 */
@Controller
@RequestMapping(value = "/renew")
public class RenewController {

	@Resource(name = "renewService")
	private RenewService renewService;
	private String message = "message";
	private String path = null;
	private Logger logger = Logger.getLogger(RenewController.class);
	

	/**
	 * setRenewBook:根据借书表的book_id设定续借功能
	 * @param model
	 * @param borrowRecord
	 * @return 
	 */
	@RequestMapping(value = "/setRenewBook")
	public String setRenewBook(Model model,PersonBorrow	personBorrow,String currentPage){

		try {
			logger.error("=====RenewController.setRenewBook start!=====");
			int pageIndex = Integer.parseInt(currentPage != null ? currentPage: "0"); // 当前的页数
			pageIndex = pageIndex-1 > 0 ? pageIndex-1:0;
			renewService.setRenewBook(personBorrow);
			
			message = "恭喜您，续借成功！";
			path = "redirect:" + ConstantUtil.PERSON_READER + "personBorrowing?userId="+personBorrow.getUserId()+"&message=" + URLEncoder.encode(message, "UTF-8") + "&currentPage=" + pageIndex;
			logger.error("=====RenewController.setRenewBook sucess!=====");
			
		} catch (Exception e) {
			logger.error("=====RenewController.setRenewBook error!=====", e);
		}
		return path;
	}
	
	@RequestMapping(value = "/delCancleRenewBook")
	public String delCancleRenewBook(Model model,PersonBorrow personBorrow,String currentPage){
		try {
			logger.error("=====RenewController.delCancleRenewBook start!=====");			
			int pageIndex = Integer.parseInt(currentPage != null ? currentPage: "0"); // 当前的页数
			pageIndex = pageIndex-1 > 0 ? pageIndex-1:0;
			renewService.delCancleRenewBook(personBorrow);
			
			message = "恭喜您，续借成功取消！";
			path = "redirect:" + ConstantUtil.PERSON_READER + "personBorrowing?userId="+personBorrow.getUserId()+"&message=" + URLEncoder.encode(message, "UTF-8") + "&currentPage=" + pageIndex;
			logger.error("=====RenewController.delCancleRenewBook sucess!=====");
		} catch (Exception e) {
			logger.error("=====RenewController.delCancleRenewBook error!=====", e);
		}
		return path;
	}
	
}
