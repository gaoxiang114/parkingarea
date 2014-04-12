package com.cyou.library.xh.borrow.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cyou.library.xh.book.domain.Book;
import com.cyou.library.xh.book.service.BookService;
import com.cyou.library.xh.book.web.BookController;
import com.cyou.library.xh.borrow.domain.BorrowRecord;
import com.cyou.library.xh.borrow.domain.BorrowRecordList;
import com.cyou.library.xh.borrow.domain.ReturnBook;
import com.cyou.library.xh.borrow.service.BorrowRecordService;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.ToolPage;
import com.cyou.library.xh.common.web.BaseController;
import com.cyou.library.xh.user.domain.User;
import com.cyou.library.xh.user.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/borrow")
public class BorrowRecordController extends BaseController{
	
	//日志管理
	private Logger logger = Logger.getLogger(BookController.class);
	
	@Resource(name="borrowRecordService")
	BorrowRecordService borrowRecordService;
	@Resource(name="bookService")
	BookService bookService;
	@Resource(name="userService")
	UserService userService;
	
	
	@RequestMapping(value="/selectBorrowRecord")
	public String selectBorrowRecord(Model model,String currentPage,String message){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  //获取页面request对象
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0");  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<BorrowRecordList> borrowRecordList=null;
		try {
			if(message!=null){
				model.addAttribute("message",URLDecoder.decode(message, "UTF-8"));
			}
			borrowRecordList=borrowRecordService.selectBorrowRecord(pageIndex, pageSize);
			totalRecord = (Integer)borrowRecordService.borrowRecordCount();
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + "/borrow/selectBorrowRecord", model, borrowRecordList);
			model.addAttribute("toolPage", toolPage);
			
			return "borrow/borrowList";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "book/fail";
		}
	}
	
	@RequestMapping(value="/addBorrowRecord")
	public String addBorrowRecord(HttpServletRequest request,String bookId,int currentPage){
		int borrowAndOrderBooks=0;
		int line=0;
		HttpSession session=request.getSession();
		Book book=new Book();
		String path=request.getServletPath();
		User user=new User();
		int borrowNum=0;
		//session.getAttribute("user");
		int userId=1;       //得到用户Id借书
		String message="恭喜你！借书成功，你的借书日期从今天开始计算，请到陈洲同学处领取书柜钥匙!";
		
		//user=session.getAttribute("user");      得到借书用户
		user.setUser_id(1);
		
		borrowAndOrderBooks=borrowRecordService.getBorrowAndOrerBooks(userId);
		if(borrowAndOrderBooks>=3){
			message="您已借和预定的书总和等于3本，不能再借！";
			try {
				return "redirect:"+"/book/selectBookBorrow?message="+URLEncoder.encode(message,"UTF-8")+"&bookId="+bookId+"&currentPage="+currentPage;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			
			line=borrowRecordService.addBorrowRecord(bookId,userId);
			book.setId(bookId);

			book.setBookCheckFlag(1);
			bookService.updateBook(book);

			user=userService.getUserByUserId(user);
			borrowNum=user.getUser_borrownum();
			user.setUser_borrownum(borrowNum-1);
			userService.updateBorrowNumById(user);
			return "redirect:"+"/book/selectBookBorrow?message="+URLEncoder.encode(message,"UTF-8")+"&bookId="+bookId+"&currentPage="+currentPage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping("/doBorrowBook")
	public String doBorrowBook(Model model,Integer check_id,Integer user_id,int currentPage) throws UnsupportedEncodingException{
		BorrowRecord borrowRecord=new BorrowRecord();
		Calendar check_startTime=Calendar.getInstance();
		Date check_endTime=null;
		int totalRecord=0;
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalPage=0;
		
		borrowRecord.setCheck_id(check_id);
		borrowRecord.setCheck_flag(2);
		borrowRecord.setCheck_startTime(check_startTime.getTime());
		check_startTime.add(Calendar.DATE, 30);   //根据配制文件读取借书天数
		check_endTime=check_startTime.getTime();
		
		borrowRecord.setCheck_endTime(check_endTime);
		try {
			borrowRecordService.updateBorrowRecord(borrowRecord);
			
			totalRecord=(Integer)borrowRecordService.borrowRecordCount();
			totalPage=totalRecord/pageSize+(totalRecord%pageSize==0?0:1);
			currentPage=currentPage+1;
			if(currentPage>totalPage) currentPage--;
			if(currentPage==0) currentPage=1;
			//user
			return "redirect:/borrow/selectBorrowRecord?currentPage="+(currentPage-1)+"&message="+URLEncoder.encode("借书成功","UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("借书失败");
			return "redirect:/borrow/selectBorrowRecord?currentPage="+currentPage+"&message="+URLEncoder.encode("借书失败","UTF-8");
		}
	}
	@RequestMapping("/doCancleBorrow")
	public String doCancleBorrow(Model model,Integer check_id,Integer user_id,String bookId,int currentPage){
		
		Book book=new Book();
		book.setId(bookId);
		book.setBookCheckFlag(0);
		User user=new User();
		int borrowNum=0;
		int totalRecord=0;
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalPage=0;
		
		user.setUser_id(user_id);
		
		try {
			borrowNum=userService.getUserByUserId(user).getUser_borrownum();
			user.setUser_borrownum(borrowNum+1);
			userService.updateBorrowNumById(user);
			
			borrowRecordService.deleteBorrowRecord(check_id);
			totalRecord=(Integer)borrowRecordService.borrowRecordCount();
			totalPage=totalRecord/pageSize+(totalRecord%pageSize==0?0:1);
			currentPage=currentPage+1;
			if(currentPage>totalPage) currentPage--;
			if(currentPage==0) currentPage=1;
			bookService.updateBook(book);
			return "redirect:/borrow/selectBorrowRecord?currentPage="+(currentPage-1)+"&message="+URLEncoder.encode("取消借书成功","UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("取消借书失败:"+e.getMessage());
			try {
				return "redirect:/borrow/selectBorrowRecord?currentPage="+currentPage+"&message="+URLEncoder.encode("取消借书失败","UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
		}
		
	}
	
	@RequestMapping("/toReturnBook")
	public void  toReturnBook(HttpServletRequest reques,HttpServletResponse response,String bookId){
		ReturnBook returnBook;
		PrintWriter out;
		try {
			returnBook=borrowRecordService.selectReturnBook(bookId);
			Gson gson=new Gson();
			String data=gson.toJson(returnBook);
			//model.addAttribute("returnBook",returnBook);
			//return "borrow/returnBookOne";
			 response.setContentType("text/html; charset=UTF-8");
		      response.setHeader("Cache-Control", "no-cache");
		      response.setHeader("Pragma", "No-cache");
		      response.setDateHeader("Expires", 0);

			out = response.getWriter();
			out.print(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/toSearchReturnBookPage")
	public String toSearchReturnBookPage(){
		return "borrow/returnBook";
	}
	/**
	 * 还书
	 * @return
	 */
	@RequestMapping("/doReturnBook")
	public void doReturnBook (Model model,HttpServletResponse response,String bookId){
		PrintWriter out = null; 
		response.setContentType("text/html; charset=UTF-8");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "No-cache");
	    response.setDateHeader("Expires", 0);

		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			borrowRecordService.doReturnBook(bookId);
			out.print("还书成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("还书失败");
		}
		
		
		
	
	}
	@RequestMapping("/test")
	public void test(int checkId){
		BorrowRecordList b=borrowRecordService.selectRecordById(checkId);
		System.out.println(b.getCheck_id());
		System.out.println(b.getUser_realname());
	}
}
