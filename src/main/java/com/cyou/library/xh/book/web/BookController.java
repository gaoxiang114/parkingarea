package com.cyou.library.xh.book.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cyou.library.xh.book.domain.Book;
import com.cyou.library.xh.book.domain.BookType;
import com.cyou.library.xh.book.service.BookService;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.ToolPage;
import com.cyou.library.xh.common.web.BaseController;
import com.google.gson.Gson;


@Controller
@RequestMapping("/book")
public class BookController extends BaseController{
	//日志管理
	private Logger logger = Logger.getLogger(BookController.class);

	@Resource(name="bookService")
	private BookService bookService;



	@RequestMapping(value="/deleteBook")
	public String delBookById(Model model,String id,int currentPage){
		int line=0;
		int totalRecord=0;
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalPage=0;
		
		logger.info("删除的书藉id为："+id);
		
		
		try{
			line=bookService.delBookById(id);
			totalRecord = (Integer)bookService.selectBookCount();
			totalPage=totalRecord/pageSize+(totalRecord%pageSize==0?0:1);
		
			currentPage=currentPage+1;
			if(currentPage>totalPage) currentPage--;
			if(currentPage==0) currentPage=1;
			
			return "redirect:selectBookList?currentPage="+(currentPage-1);
		}catch(Exception e1){
			logger.error("删除书藉发生错误",e1);
			model.addAttribute("msg","删除书藉发生异常");
			return "book/bookListFail";
		}
	}


	/**
	 * selectBookList：查询书的列表
	 * @param model
	 * @return String
	 */

	@RequestMapping(value="selectBookList")
	public String selectBookList(Model model,String currentPage){

		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  //获取页面request对象
		
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0");  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<Book> bookList=null; 
		try {
			
			bookList=bookService.selectBookList(pageIndex, pageSize);
			totalRecord = (Integer)bookService.selectBookCount();
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + "/book/selectBookList", model, bookList);
			
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			return "book/bookList";
		} catch (NullPointerException e) {
			logger.error("进入书藉列表出现异常！",e);
			return "book/bookListFail";
		}
		
		
		
	/*	try{
			bookList=bookService.selectBookList();
			model.addAttribute("bookList",bookList);
			return "book/bookList";
		}catch(Exception e1){
			logger.error("查询书藉列表发生错误",e1);
			model.addAttribute("msg","查询书藉列表发生异常");
			return "book/bookListFail";
		}*/


	}
	
	@RequestMapping(value="selectBookListFront")
	public String selectBookListFront(Model model,String currentPage){

		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  //获取页面request对象
		
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0");  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<Book> bookList=null; 
		try {
			
			bookList=bookService.selectBookList(pageIndex, pageSize);
			totalRecord = (Integer)bookService.selectBookCount();
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + "/book/selectBookListFront", model, bookList);
			
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			return "book/bookListFront";
		} catch (NullPointerException e) {
			logger.error("进入查询书藉信息列表出现异常！",e);
		}
		
		return "book/bookList";
	}
/**
 * editBook:修改指定图书
 * @param model
 * @param id
 * @return String
 */
	@RequestMapping(value="editBook")
	public String editBook(Model model,Book book,int currentPage){

		int line=0;
		int totalRecord=0;
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalPage=0;

		try{

			line=bookService.updateBook(book);
			
			totalRecord = (Integer)bookService.selectBookCount();
			totalPage=totalRecord/pageSize+(totalRecord%pageSize==0?0:1);
		
			currentPage=currentPage+1;
			if(currentPage>totalPage) currentPage--;
			if(currentPage==0) currentPage=1;
			return "redirect:selectBookList?currentPage="+(currentPage-1);
		}catch(Exception e1){
			logger.error("修改书藉发生错误",e1);
			model.addAttribute("msg","修改书藉发生异常");
			return "book/bookListFail";
		}
	}

	/**
	 * selectBookEdit:查询指点定图书并显示修改页
	 * @param id
	 * @return String
	 */
	@RequestMapping(value="selectBookEdit")
	public String selectBookEdit(Model model,String id,int currentPage){
		Book book=null;
		List<BookType> largeType;
		List<BookType> sameType;
		try{
			
			book=bookService.selectBookById(id);
			//largeType=bookService.selectTypeByFatherId(0);
			sameType=bookService.selectTypeByFatherId(book.getType().getFatherTypeId());
			//model.addAttribute("largeType",largeType);
			model.addAttribute("sameType",sameType);
			model.addAttribute("book",book);
			model.addAttribute("currentPage",currentPage);
			
			return "book/editBook";
		}catch(Exception e1){
			logger.error("查询书藉发生错误",e1);
			model.addAttribute("msg","查询书藉发生异常");
			return "book/bookListFail";
		}
	}
	/**
	 * 查找一本书的信息
	 * @param model
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="/selectBookBorrow")
	public String selectBookBorrow(HttpServletRequest request,Model model,String bookId,int currentPage){
		Book book=null;
		String message = request.getParameter("message");
		try{
			
			book=bookService.selectBookById(bookId);
			
			model.addAttribute("book",book);
			model.addAttribute("currentPage",currentPage);
			if(message != null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
			return "borrow/selectOneBook";
		}catch(Exception e1){
			logger.error("查看书藉错误",e1);
			model.addAttribute("msg","查看书藉发生异常");
			return "book/bookListFail";
		}
		
	}
	
	/**
	 * addBook:增加图书
	 * @param model
	 * @param book
	 * @return
	 */
	@RequestMapping(value="addBookList")
	public String addBook(Model model,List<Book> bookList){
	
		int line=0;
		try{

			line=bookService.addBookList(bookList);
			return "redirect:selectBookList";
		}catch(Exception e1){
			logger.error("增加书藉发生错误",e1);
			model.addAttribute("msg","增加书藉发生异常");
			return "book/bookListFail";
		}
	}
	
	
	/**自动增加图书
	 * 
	 */
	@RequestMapping(value="addBookAuto")
	public String addBookAuto(Model model){
		int line=0;
		List<Book> bookList=new ArrayList<Book>();
		for(int i=0;i<100;i++){
			Book book=new Book();
			book.setAuthor("a"+(int)Math.random()*100);
			book.setName("书"+(int)Math.random()*100);
			book.setTypeId(1);
			book.setPublish("bbb");
			book.setDoban("www.baidu.com");
			book.setId("sx2"+i);
			bookList.add(book);
		}
			try{
	
				line=bookService.addBookList(bookList);
				
			}catch(Exception e1){
				logger.error("增加书藉发生错误",e1);
				model.addAttribute("msg","增加书藉发生异常");
				return "book/bookListFail";
			}
		return "redirect:selectBookList";
	}
	
	/**
	 * 增加图书页
	 * @return
	 */
	@RequestMapping(value="addPage")
	public String addPage(){
		return "book/addBook";
	}
	
	/**
	 * selectTypeByFatherId:Ajax找到具有相同父类别的书籍类别
	 * @param reques
	 * @param response
	 * @param typeId  类别id
	 */
	@RequestMapping(value="selectTypeByFatherId", method= RequestMethod.POST)
	public void selectTypeByFatherId(HttpServletRequest reques,HttpServletResponse response,int typeId){
		
		List<BookType> sameType=bookService.selectTypeByFatherId(typeId);
		
		PrintWriter out;
		Gson gson=new Gson();
		String data = gson.toJson(sameType);
		try {
			  response.setContentType("text/html; charset=UTF-8");
		      response.setHeader("Cache-Control", "no-cache");
		      response.setHeader("Pragma", "No-cache");
		      response.setDateHeader("Expires", 0);

			out = response.getWriter();
			out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
