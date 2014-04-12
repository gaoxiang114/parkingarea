package com.cyou.library.xh.recommand.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.library.xh.book.domain.Book;
import com.cyou.library.xh.book.domain.BookType;
import com.cyou.library.xh.book.service.BookService;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.Download;
import com.cyou.library.xh.common.util.ExcelUtil;
import com.cyou.library.xh.common.util.JsonUtil;
import com.cyou.library.xh.common.util.ToolPage;
import com.cyou.library.xh.common.util.ToolTime;
import com.cyou.library.xh.common.util.XmlUtil;
import com.cyou.library.xh.common.util.XmlUtilHelpForm;
import com.cyou.library.xh.recommand.domain.Recommand;
import com.cyou.library.xh.recommand.domain.RecommandExcel;
import com.cyou.library.xh.recommand.service.RecommandService;
import com.cyou.library.xh.user.domain.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/recommand")
public class RecommandController {
	
	public static Logger logger = Logger.getLogger(RecommandController.class);
	@Resource(name="recommandService")
	private RecommandService recommandService;
	@Resource(name="bookService")
	private BookService bookService;
	
	/**
	 * toAddRecommandPage:进入添加推荐书籍的页面
	 * @author gaoxiang_nad
	 * @param Model model
	 * @param Recommand recommand
	 * @param HttpServletRequest request
	 * @return java.lang.String
	 */
	@RequestMapping(value="/toAddRecommandPage")
	public String toAddRecommandPage(Model model,Recommand recommand,HttpServletRequest request){
		
		String message = request.getParameter("message");
		List<BookType> rootTypeList = null;
		try {
			
			rootTypeList=bookService.selectTypeByFatherId(0);
			
			model.addAttribute("rootTypeList", rootTypeList);
			
			if(message!=null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}

		} catch (UnsupportedEncodingException e) {
			logger.error("读取信息解码出现异常",e);
			logger.error("");
		}
		
		return ConstantUtil.RECOMMAND_PATH + "addRecommand";
	}
	
	/**
	 * doAddRecommand:添加推荐书籍的方法
	 * @author gaoxiang_nad
	 * @param Model model
	 * @param Recommand recommand
	 * @return java.lang.String
	 */
	@RequestMapping(value="/doAddRecommand" ,method = RequestMethod.POST)
	public String doAddRecommand(Model model,Recommand recommand){
		String message="推荐书籍添加失败";
		String path = "";
		System.out.println(recommand);
		try {
			
			User user = new User();
			user.setUser_id(1);
			user.setUser_realname("李仁奎");
			recommand.setRecDate(new Date());
			recommand.setUser(user);
			this.recommandService.addRecommand(recommand);
			message="推荐书籍添加成功";
			path="redirect:" + ConstantUtil.RECOMMAND_PATH + "toPersonRecommandList?message="+URLEncoder.encode(message, "UTF-8");;
		
			
			
		} catch (UnsupportedEncodingException e) {
			logger.error("推荐书籍添加出现异常：",e);
		}
		
		return path;
	}
	
	/**
	 * toRecommandListPage:分页查询的方法
	 * @author gaoxiang_nad
	 * @param Model model
	 * @param HttpServletRequest request
	 * @param String currentPage
	 * @return java.lang.String
	 */
	@RequestMapping(value="/toRecommandList")
	public String toRecommandListPage(Model model,HttpServletRequest request){
		
		logger.info("toRecommandListPage method is starting .....");
		
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		String recFlag = request.getParameter("recFlag") != null ? request.getParameter("recFlag") : "0";
		String[] parameterNames = null;
		String[] parameterValues = null;
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<Recommand> recommandList = null;  //定义查询的推荐书籍列表recommandList
		String path = null;
		try {

			recommandList = this.recommandService.recommandList(pageIndex, pageSize,Integer.parseInt(recFlag));
			totalRecord = (Integer)this.recommandService.getRecommandCount(Integer.parseInt(recFlag));
			
			parameterNames = new String[]{"recFlag"};
			parameterValues = new String[]{recFlag};
			path = ConstantUtil.RECOMMAND_PATH + "recommandList";
			
			//ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + ConstantUtil.RECOMMAND_PATH + "toRecommandList", model, recommandList);
			ToolPage toolPage = ToolPage.pagination(model, pageIndex, recommandList, totalRecord, pageSize,request.getContextPath() + ConstantUtil.RECOMMAND_PATH + "toRecommandList", parameterNames, parameterValues);
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			model.addAttribute("recFlag",recFlag);
			
			
		} catch (NullPointerException e) {
			logger.error(e.getMessage()+": 进入查询角色信息列表出现异常！");
		}
		
		return path;
	}
	
	@RequestMapping(value="/toPersonRecommandList")
	public String toPersonRecommandList(Model model,HttpServletRequest request){
		
		logger.info("toPersonRecommandList method is starting .....");
		
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List<Recommand> personRecommandList = null;  //定义查询的推荐书籍列表recommandList
		String path = null;
		try {

			personRecommandList = this.recommandService.personRecommandPageList(pageIndex, pageSize);
			totalRecord = (Integer)this.recommandService.getPersonRecommandCount();
			
			path = ConstantUtil.PERSON_CENTER + "personRecommandList";
			
			ToolPage toolPage = ToolPage.pagination(pageIndex, totalRecord, pageSize, request.getContextPath() + ConstantUtil.RECOMMAND_PATH + "toPersonRecommandList", model, personRecommandList);
			//将分页信息和数据放入model域中，用来页面回显信息
			model.addAttribute("toolPage", toolPage);
			
			
		} catch (NullPointerException e) {
			logger.error(e.getMessage()+": 进入查询角色信息列表出现异常！");
		}
		
		return path;
	}
	
	/**
	 * toUpdateRecommandPage:进入修改信息页面
	 * @author gaoxiang_nad
	 * @param Model model
	 * @param HttpServletRequest request
	 * @param int recId
	 * @return java.lang.String
	 */
	@RequestMapping(value="/toUpdateRecommandPage")
	public String toUpdateRecommandPage(Model model,HttpServletRequest request,int recId){

		String message = request.getParameter("message");
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0" ;
		List<BookType> rootTypeList = null;
		List<BookType> sameTypeList = null;
		Recommand recommand = null;
		try {
			recommand = this.recommandService.getRecommandById(recId);
			rootTypeList=bookService.selectTypeByFatherId(0);
			System.out.println(recommand);
			if(recommand != null){
				if(rootTypeList != null && rootTypeList.size() > 0){
					sameTypeList = this.bookService.selectTypeByFatherId(rootTypeList.get(0).getTypeId());
				}
				
				model.addAttribute("rootTypeList", rootTypeList);
				model.addAttribute("sameTypeList", sameTypeList);
			}
			model.addAttribute("recommand", recommand);
			model.addAttribute("currentPage", currentPage);
			
			if(message!=null && !"".equals(message)){
				model.addAttribute("message", URLDecoder.decode(message, "UTF-8"));
			}
			
		} catch (UnsupportedEncodingException e) {
			logger.error("读取信息解码出现异常",e);
		}
		
		return ConstantUtil.RECOMMAND_PATH+"updateRecommand";
	}
	
	@RequestMapping(value="/doUpdateRecommand")
	public String doUpdateRecommand(Model model,Recommand recommand,HttpServletRequest request,int recId){
		String message = "修改推荐书籍失败！";
		String path = "";
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0";
		int pageIndex = (Integer.parseInt(currentPage)-1) >=0 ? (Integer.parseInt(currentPage)-1) : 0;
		
		try {
			
			this.recommandService.updateRecommand(recommand);
			message = "修改推荐书籍成功！";
			message = URLEncoder.encode(message, "UTF-8");
			path="redirect:" + ConstantUtil.RECOMMAND_PATH + "toUpdateRecommandPage?message="
						+message+"&currentPage="+pageIndex+"&recFlag="+recommand.getRecFlag()+"&recId="+recId;
			
		} catch (UnsupportedEncodingException e) {
			
			try {
				message = URLEncoder.encode(message, "UTF-8");
				path="redirect:" + ConstantUtil.RECOMMAND_PATH + "toUpdateRecommandPage?message="+message+"&currentPage="+pageIndex+"&recFlag="+recommand.getRecFlag();
			} catch (UnsupportedEncodingException e1) {
				logger.error("异常："+e1.getMessage());
			}
			
			logger.error("异常："+e.getMessage());
		}
		
		return path;
	}
	
	@RequestMapping(value="/doUpdateProcedure")
	public String doUpdateProcedure(Model model,HttpServletRequest request,Integer[] recId){
		String recFlag = request.getParameter("state");
		
		String message = "";
		
		try {
			if(recId != null && recId.length > 0){
				this.recommandService.updateProcedure(recId,Integer.parseInt(recFlag));
				message = "状态更改成功";
				message = URLEncoder.encode(message, "UTF-8");
			}
		}catch (UnsupportedEncodingException e) {
			
			try {
				message = URLEncoder.encode("状态修改失败", "UTF-8");
			} catch (Exception e2) {
				logger.error(e.getMessage()+": 修改状态时出现转码异常");
			}
			
			logger.error(e.getMessage()+": 修改状态时出现更新异常");
		}
		
		
		return "redirect:" + ConstantUtil.RECOMMAND_PATH + "toRecommandList?message="+message+"&recFlag="+Integer.parseInt(recFlag);
	}
	
	@RequestMapping(value="/doDelRecommand",method = RequestMethod.GET)
	public String doDelRecommand(Model model,HttpServletRequest request,int recId,String currentPage){
		Integer pageIndex = null ;
		
		try {
			logger.info("doDelRole method is starting .....");
		
			this.recommandService.deleteRecommand(recId);
			
			Integer allCount = this.recommandService.getRecommandCount(0);
			
			pageIndex = (allCount / ConstantUtil.PAGE_COUNTS + (allCount % ConstantUtil.PAGE_COUNTS != 0 ? 1 : 0))
								!= Integer.parseInt(currentPage) ? Integer.parseInt(currentPage)-1 
										:Integer.parseInt(currentPage);
			
			pageIndex = pageIndex >= 0 ? pageIndex : 0;
			
			logger.info("推荐书籍信息删除成功");
			model.addAttribute("message", "推荐书籍信息删除成功");
			
		} catch (Exception e) {
			logger.error("推荐书籍信息删除失败",e);
			model.addAttribute("message", "推荐书籍信息删除失败");
		}
		
		return "redirect:" + ConstantUtil.RECOMMAND_PATH + "toPersonRecommandList?currentPage=" + pageIndex;
	}
	
	@RequestMapping(value="/toStorageBook")
	public void toStorageBook(Model model,HttpServletRequest request,HttpServletResponse response){
		
		String recId = request.getParameter("recId") != null ? request.getParameter("recId") : "";
		List<Recommand> recommandList = null;
		String[] ids = recId.split("\\|");
		PrintWriter out = null;
		try {
			if(ids != null && ids.length > 0){
				
				recommandList = this.recommandService.recommandList(ids);
					
				String data = getBookData(recommandList);
			    
				response.setContentType("text/html; charset=UTF-8");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setHeader("Pragma", "No-cache");
		        response.setDateHeader("Expires", 0);
			    out = response.getWriter();
			    out.print(data+"&"+recId);
					
				}
		} catch (IOException e) {
			logger.error(e.getMessage()+":aJax获取推荐书籍数据出现异常");
		}
	}
	
	@RequestMapping("/doStorageBook")
	public void doStorageBook(HttpServletRequest request,HttpServletResponse response){
		String data = request.getParameter("data");
		String recIds = request.getParameter("recIds");
		String recFlag = "6";
		String[] ids = null;
		Integer[] recId = null;
		List<Book> bookList = null;
		PrintWriter out = null;
		Gson gson = null;
		int flag = 0;
	    try {
	    	gson = new Gson();
	    	if(recIds!=null && !"".equals(recIds)){
	    		ids = recIds.split("\\|");
	    		recId = new Integer[ids.length];
	    		bookList = gson.fromJson(data, new TypeToken<List<Book>>(){}.getType());
	    		
	    		for(int i=0;i<ids.length;i++){
		    		recId[i]=Integer.parseInt(ids[i]);
		    	}

	    		this.recommandService.updateProcedure(recId, Integer.parseInt(recFlag));
		    	this.bookService.addBookList(bookList);
		    	
		    	response.setContentType("text/html; charset=UTF-8");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setHeader("Pragma", "No-cache");
		        response.setDateHeader("Expires", 0);
		        
				out = response.getWriter();
				flag=1;
	    		
	    	}
	    	
	    	
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	    out.print(flag);
	}
	
	public String getBookData(List<Recommand> recommandList){
		
		List<Book> dataList = null;
		String data=null;
		if(recommandList != null && recommandList.size() > 0){
			dataList = new ArrayList<Book>(recommandList.size());
			Book book = null;
			String pre = null;
			String end = null;
			Recommand recommand = null;
			List<Integer> typeIdList = new ArrayList<Integer>(recommandList.size());
			List<String> idList = null;
			for(int i=0;i<recommandList.size();i++){
				typeIdList.add(recommandList.get(i).getType().getTypeId());
			}
			//****************************未完待续***********************************//
			
			idList = this.bookService.getBookId(typeIdList);
			for(int i=0;i<recommandList.size();i++){
				recommandList.get(ConstantUtil.ZERO);
				
				
				recommand=recommandList.get(i);
				book = new Book();
				
				book.setId(idList.get(i));
				book.setName(recommand.getBookName());
				book.setAuthor(recommand.getBookAuthor());
				book.setType(recommand.getType());
				book.setDoban(recommand.getBookDouban());
				book.setPublish(recommand.getBookPublish());
				book.setBookCheckFlag(ConstantUtil.ZERO);
				book.setBookIsOrder(ConstantUtil.ZERO);

				dataList.add(book);
			}
			
			data = JsonUtil.Object2Json(dataList);
			
		}
		return data;
	}
	
	@RequestMapping(value="/checkBookName")
	public void checkBookName(HttpServletRequest request,HttpServletResponse response){

		String bookName = request.getParameter("bookName");
		System.out.println(bookName);
		List list = this.recommandService.checkBookName(bookName);

		PrintWriter out;
		try {
			  response.setContentType("text/html; charset=UTF-8");
		      response.setHeader("Cache-Control", "no-cache");
		      response.setHeader("Pragma", "No-cache");
		      response.setDateHeader("Expires", 0);
		     
		      out = response.getWriter();
		      if(list!=null && list.size() > 0){
		    	  out.print(1);
		      }else{
		    	  out.print(0);
		      }
		      
			
		} catch (IOException e) {
			logger.error("ajax校验书名方法出现异常：",e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	@RequestMapping(value="/exportExcel")
	public void exportExcel(HttpServletRequest request,HttpServletResponse response){
		String state = request.getParameter("state") != null ? request.getParameter("state") : "0" ;
		ExcelUtil<RecommandExcel> ex2 = new ExcelUtil<RecommandExcel>();
		OutputStream out = null;
		String date = ToolTime.getFormatTime(new Date(), "yyyy-MM");
		
		try {
			out = new FileOutputStream(request.getRealPath("/")+"WEB-INF"+File.separator+"fileData"+File.separator+date+".xls");
			System.out.println(request.getRealPath("/")+"WEB-INF"+File.separator+"fileData"+File.separator+date+".xls");
		
		XmlUtilHelpForm xmlUtilHelpForm = XmlUtil.getInstance("data.xml").readXmlDetail("data","exportRecommand");
		List<XmlUtilHelpForm> list = xmlUtilHelpForm.getChildNodeNames();
		List<String> headerList = new ArrayList<String>(list.size());
		List<RecommandExcel> dataList = null;
		List<Recommand> recommandList = null;
		RecommandExcel recommandExcel = null;
		for(XmlUtilHelpForm x : list){
			headerList.add(x.getValue());
		}
		
		recommandList = this.recommandService.recommandList(Integer.parseInt(state));
		System.out.println(recommandList);
		dataList = new ArrayList<RecommandExcel>();
		for(Recommand r : recommandList){
			recommandExcel = new RecommandExcel();
			recommandExcel.setBookAuthor(r.getBookAuthor());
			recommandExcel.setBookName(r.getBookName());
			recommandExcel.setBookPublish(r.getBookPublish());
			recommandExcel.setBuyUrl(r.getRecUrl());
			recommandExcel.setUserName(r.getUser().getUser_realname());
			recommandExcel.setBookPrice(r.getBookPrice());
			dataList.add(recommandExcel);
		}
		
		System.out.println(headerList);
		System.out.println(dataList);
		
		ex2.exportExcel("图表", headerList, dataList, out, "yyyy-MM-dd");
			
		Download.download1(request, response, "", request.getRealPath("/")+"WEB-INF"+File.separator+"fileData"+File.separator+date+".xls", date+".xls");
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage()+": aJax请求导出Excel文件，文件找不到的异常");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
