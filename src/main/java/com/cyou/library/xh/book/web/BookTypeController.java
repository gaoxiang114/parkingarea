package com.cyou.library.xh.book.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cyou.library.xh.book.dao.BookTypeDao;
import com.cyou.library.xh.book.domain.Book;
import com.cyou.library.xh.book.domain.BookType;
import com.cyou.library.xh.book.service.BookTypeService;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.ToolPage;

@Controller
@RequestMapping("/bookType")
public class BookTypeController {
	//日志管理
	private Logger logger = Logger.getLogger(BookController.class);
	
	@Resource(name="bookTypeService")
	BookTypeService bookTypeService;
	
	/**
	 * 增加书藉类别
	 * @param bookType
	 * @return
	 */
	@RequestMapping("/addBookType")
	public String addBookType(Model model,BookType bookType){
		logger.info("增加书藉类别"+" name:"+bookType.getTypeName()+" fatherId:"+bookType.getFatherTypeId());
		
		int line=0;
		int totalRecord=0;
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalPage=0;
		int currentPage=0;
		try{

			line=bookTypeService.addBookType(bookType);
			totalRecord = (Integer)bookTypeService.selectBookTypeCount();
			totalPage=totalRecord/pageSize+(totalRecord%pageSize==0?0:1);
			currentPage=totalPage-1;
			return "redirect:selectBookTypeList?currentPage="+currentPage;
		}catch(Exception e1){
			logger.error("增加书藉类别发生错误",e1);
			model.addAttribute("msg","增加书藉类别发生异常");
			return "book/bookListFail";
		}
	}
	/**
	 * 跳转到增加书藉列表页
	 * @return
	 */
	@RequestMapping(value="/addPage")
	public String addPage(){
		return "book/addBookType";
	}
	
	/**
	 * 查询书藉类别列表
	 * @param model
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="/selectBookTypeList")
	public String selectBookList(Model model,String currentPage){
		
		logger.info("进入书藉列表页");
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  //获取页面request对象
		
		int pageIndex = Integer.parseInt(currentPage != null ? currentPage : "0");  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<BookType> bookTypeList=null; 
		try {
			
			bookTypeList=bookTypeService.selectBookTypeList(pageIndex, pageSize);
			for(BookType booktype:bookTypeList){
				System.out.println(booktype.getTypeName());
			}
			totalRecord = (Integer)bookTypeService.selectBookTypeCount();
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + "/bookType/selectBookTypeList", model, bookTypeList);
			
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			
		} catch (NullPointerException e) {
			logger.error("进入查询书类别信息列表出现异常！",e);
		}
		
		return "book/bookTypeList";
	}
	
	/**
	 * 删除书的类别
	 * @param model
	 * @param typeId
	 * @param currentPage
	 * @return 返回页面
	 */
	@RequestMapping("/deleteBookType")
	public String deleteBookType(Model model,int typeId,int currentPage){
		
		logger.info("删除类别："+typeId);
		int line=0;
		int totalRecord=0;
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalPage=0;
		try {
			line=bookTypeService.deleteBookType(typeId);
			totalRecord = (Integer)bookTypeService.selectBookTypeCount();
			totalPage=totalRecord/pageSize+(totalRecord%pageSize==0?0:1);
		
			currentPage=currentPage+1;
			if(currentPage>totalPage) currentPage--;
			if(currentPage==0) currentPage=1;
			return "redirect:selectBookTypeList?currentPage="+(currentPage-1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "book/bookListFail";
		}
	}
	@RequestMapping("/selectBookTypeEdit")
	public String selectBookTypeEdit(Model model,int typeId,int currentPage){
		
		BookType bookType;
		try {
			bookType=bookTypeService.selectBookTypeByid(typeId);
			model.addAttribute("bookType", bookType);
			model.addAttribute("currentPage", currentPage);
			return "book/editBookType";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "book/bookListFail";
		}
	}
	
/**
 *  修改类别
 * @param model
 * @param bookType
 * @param currentPage
 * @return
 */
	@RequestMapping("/editBookType")
	public String editBookType(Model model,BookType bookType,int currentPage){
		int line=0;
		int totalRecord=0;
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalPage=0;
		
		try {
			line=bookTypeService.updateBookType(bookType);
			logger.info("修改类别："+bookType.getTypeId()+" 名字改为："+bookType.getTypeName());
			totalRecord = (Integer)bookTypeService.selectBookTypeCount();
			totalPage=totalRecord/pageSize+(totalRecord%pageSize==0?0:1);

			currentPage=currentPage+1;
			if(currentPage>totalPage) currentPage--;
			if(currentPage==0) currentPage=1;
			return "redirect:selectBookTypeList?currentPage="+(currentPage-1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("修改书藉类别发生错误",e);
			model.addAttribute("msg","修改书藉类别发生异常");
			return "book/bookListFail";
		}
		
	}

	
}
