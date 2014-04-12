/**
 * 
 */
package com.cyou.library.xh.book.web;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.library.xh.book.domain.PersonBorrow;
import com.cyou.library.xh.book.service.PersonReadService;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.ToolPage;

/**
 * @author lirenkui
 *
 */
@Controller
@RequestMapping(value = "/personReader")
public class PersonReadController {

	@Resource(name = "personReaderService")
	private PersonReadService personReaderService;
	private String message = "";
	private String path = null;
	private Logger logger = Logger.getLogger(RenewController.class);
	
	@RequestMapping(value = "/personBorrowing")
	public String getBorrowingBook(Model model,HttpServletRequest request,String currentPage){
		
		
		logger.info("=====UserController.toUserPageList start!=====");
		String user_Id = request.getParameter("userId");
		String message = request.getParameter("message");
		int userId = Integer.parseInt(user_Id);
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage: "0"); // 当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS; // 每页最大显示条数
		int totalRecord = 0; // 总记录数
		List<PersonBorrow> borrowRecordLists = null; // 定义查询的角色列表userList
		try {
			borrowRecordLists = this.personReaderService.getBorrowingBook(pageIndex, pageSize,2,userId);//获取用户正在借阅的书籍
			totalRecord = this.personReaderService.getBorrowingCountByUserId(userId, 2);
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord,pageSize, request.getContextPath() + ConstantUtil.PERSON_READER + "personBorrowing", model, borrowRecordLists);
			
			model.addAttribute("toolPage", toolPage);
			
			if(message!=null && !"".equals(message)){
				model.addAttribute("message",URLDecoder.decode(message, "UTF-8"));
			}
			
			
		} catch (Exception e) {
			logger.error("=====PersonReadController getBorrowingBook start!=====" + e.getMessage());
		}
		path = ConstantUtil.PERSON_CENTER + "personBorrowing";
		return path;
	}
	
	@RequestMapping(value = "/personBorrowed")
	public String getBorrowedBook(Model model,HttpServletRequest request,String currentPage){
		
		
		logger.info("=====UserController.toUserPageList start!=====");
		message = request.getParameter("message");
		String user_Id = request.getParameter("userId");
		int userId = Integer.parseInt(user_Id);
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage: "0"); // 当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS; // 每页最大显示条数
		int totalRecord = 0; // 总记录数
		List<PersonBorrow> borrowRecordLists = null; // 定义查询的角色列表userList
		try {
			borrowRecordLists = this.personReaderService.getBorrowedBook(pageIndex, pageSize,userId);//获取用户正在借阅的书籍
			totalRecord = this.personReaderService.getBorrowedCountByUserId(userId);
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord,pageSize, request.getContextPath() + ConstantUtil.PERSON_READER + "personBorrowed", model, borrowRecordLists);
			
			if(message!=null&&!message.equals(""))
				model.addAttribute("message", message);
			model.addAttribute("toolPage", toolPage);
		} catch (Exception e) {
			logger.error("=====PersonReadController getBorrowingBook start!=====" + e.getMessage());
		}
		path = ConstantUtil.PERSON_CENTER + "personBorrowed";
		return path;
	}
	
	@RequestMapping(value = "/getQuicklySearchBook")
	public String getQuicklySearchBook(Model model, HttpServletRequest request, String currentPage, String inputString) {
		logger.info("=====UserController.getUsersQuickly start!=====");
		try {
			int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0"); // 当前的页数
			int pageSize = ConstantUtil.PAGE_COUNTS; // 每页最大显示条数
			int totalRecord = 0; // 总记录数
			///////////////PersonBorrow///////////////////////
			List<PersonBorrow> searchBookList = null; // 定义查询的角色列表userList

			searchBookList = this.personReaderService.getQuicklySearchBook(pageIndex, pageSize, inputString, null);
			totalRecord = this.personReaderService.getQuicklySearchBookCount(inputString);
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + ConstantUtil.PERSON_READER + "getQuicklySearchBook?inputString=" + inputString, model, searchBookList);

			model.addAttribute("toolPage", toolPage);
		} catch (Exception e) {
			logger.error("=====UserController getUsersQuickly error!=====" + e.getMessage());
		}
		return ConstantUtil.BOOK_PATH + "test";
	}
	
	@RequestMapping(value = "/toQuicklySearchBook")
	public String toQuicklySearchBook(Model model){
		
		return ConstantUtil.BOOK_PATH + "searchBook";
	}
}
