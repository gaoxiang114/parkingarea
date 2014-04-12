package com.cyou.library.xh.book.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.library.xh.book.domain.BookType;
import com.cyou.library.xh.book.service.BookService;
import com.cyou.library.xh.book.service.BookTypeService;
import com.cyou.library.xh.borrow.service.BorrowRecordService;
import com.cyou.library.xh.common.domain.DataBean;
import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.common.util.ToolPage;
import com.cyou.library.xh.common.util.ToolTime;

@Controller
@RequestMapping(value="countData")
public class DataCountController {
	
	@Resource(name="bookService")
	private BookService bookService;
	
	@Resource(name="borrowRecordService")
	private BorrowRecordService borrowRecordService;
	
	@RequestMapping(value="/countBookByType")
	public String countBookByType(Model model){
		List<DataBean> dataList = this.bookService.countBookByType();
		model.addAttribute("dataList", dataList);
		return ConstantUtil.COUNT_DATA + "countBookState";
	}
	
	@RequestMapping(value="/countBorrowState")
	public String countBorrowState(Model model,HttpServletRequest request){
		
		String department = request.getParameter("department");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String type = request.getParameter("type") != null ? request.getParameter("type") : "1" ;
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0" ;
		
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		List dataList = null;
		DataBean data= null;
		String[] parameterNames = null;
		String[] parameterValues = null;
		
		parameterNames = new String[]{"type","department","startDate","endDate"};
		parameterValues = new String[]{type,department,startDate,endDate};
		DataBean dataBean = new DataBean();
		
		if(!"-1".equals(department)){
			dataBean.setDepartment(department);
		}
		
		if(startDate!=null && !"".equals(startDate) && endDate!=null && !"".equals(endDate)){
			dataBean.setStartDate(ToolTime.getParseTime(startDate, "yyyy-MM"));
			dataBean.setEndDate(ToolTime.getParseTime(endDate, "yyyy-MM"));
		}
		List<DataBean> list = this.borrowRecordService.countBorrowState(pageIndex,pageSize,dataBean);
		
		if(list != null && list.size() > 0){
			dataList = new ArrayList<DataBean>(list.size());
			for(int i=0;i<list.size();i++){
				data = (DataBean) list.get(i);
				data.setBookNameList(this.borrowRecordService.getBookNameByUserId(data.getUserId()));
				dataList.add(data);
			}
		}
		
		totalRecord = this.borrowRecordService.allBorrowRecords(dataBean);
		ToolPage toolPage = ToolPage.pagination(model, pageIndex, dataList, totalRecord, pageSize,request.getContextPath() + ConstantUtil.COUNT_DATA + "countBorrowState", parameterNames, parameterValues);
		//将分页信息和数据放入model域中，用来页面回显信息
		model.addAttribute("toolPage", toolPage);
		model.addAttribute("dataBean", dataBean);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("dataList", dataList);
		model.addAttribute("type", type);
		return ConstantUtil.COUNT_DATA + "countBorrowState";
	}
	
	@RequestMapping("/countBorrowByBook")
	public String countBorrowByBook(Model model,HttpServletRequest request){
		
		String typeId = request.getParameter("typeId");
		System.out.println(typeId);
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String type = request.getParameter("type") != null ? request.getParameter("type") : "2" ;
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0" ;
		
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		String[] parameterNames = null;
		String[] parameterValues = null;
		System.out.println(typeId);
		parameterNames = new String[]{"type","typeId","startDate","endDate"};
		parameterValues = new String[]{type,typeId,startDate,endDate};
		DataBean dataBean = new DataBean();
		if(!"-1".equals(typeId)){
			dataBean.setTypeId(typeId);
		}
		if(startDate!=null && !"".equals(startDate) && endDate!=null && !"".equals(endDate)){
			dataBean.setStartDate(ToolTime.getParseTime(startDate, "yyyy-MM"));
			dataBean.setEndDate(ToolTime.getParseTime(endDate, "yyyy-MM"));
		}
		List<DataBean> list = this.borrowRecordService.countBorrowByBook(pageIndex,pageSize,dataBean);
		List<BookType> typeList = this.bookService.selectTypeByFatherId(0);
		
		totalRecord = this.borrowRecordService.allBorrowRecords(dataBean);
		ToolPage toolPage = ToolPage.pagination(model, pageIndex, list, totalRecord, pageSize,request.getContextPath() + ConstantUtil.COUNT_DATA + "countBorrowByBook", parameterNames, parameterValues);
		//将分页信息和数据放入model域中，用来页面回显信息
		model.addAttribute("toolPage", toolPage);
		model.addAttribute("dataBean", dataBean);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("typeList",typeList);
		return ConstantUtil.COUNT_DATA + "countBorrowByBook";
	}
	
	@RequestMapping(value="countBorrowByType")
	public String countBorrowByType(Model model,HttpServletRequest request){
		
		String typeId = request.getParameter("typeId");
		System.out.println(typeId);
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String type = request.getParameter("type") != null ? request.getParameter("type") : "2" ;
		
		DataBean dataBean = new DataBean();
		if(!"-1".equals(typeId)){
			dataBean.setTypeId(typeId);
		}
		if(startDate!=null && !"".equals(startDate) && endDate!=null && !"".equals(endDate)){
			dataBean.setStartDate(ToolTime.getParseTime(startDate, "yyyy-MM"));
			dataBean.setEndDate(ToolTime.getParseTime(endDate, "yyyy-MM"));
		}
		List<DataBean> list = this.borrowRecordService.countBorrowByType(dataBean);
		
		//将分页信息和数据放入model域中，用来页面回显信息
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		return ConstantUtil.COUNT_DATA + "countBorrowByType";
	}
	
	@RequestMapping(value="/purchaseCount")
	public String purchaseCount(Model model,HttpServletRequest request){
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "0" ;
		int pageIndex = Integer.parseInt(currentPage);  //当前的页数
		int pageSize = ConstantUtil.PAGE_COUNTS;  //每页最大显示条数
		int totalRecord = 0;  //总记录数
		String[] parameterNames = null;
		String[] parameterValues = null;
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		parameterNames = new String[]{"startDate","endDate"};
		parameterValues = new String[]{startDate,endDate};
		
		
		DataBean dataBean = new DataBean();
		if(startDate!=null && !"".equals(startDate) && endDate!=null && !"".equals(endDate)){
			dataBean.setStartDate(ToolTime.getParseTime(startDate, "yyyy-MM"));
			dataBean.setEndDate(ToolTime.getParseTime(endDate, "yyyy-MM"));
		}
		List<DataBean> list = this.bookService.purchaseCount(pageIndex,pageSize,dataBean);
		totalRecord = this.bookService.getPurchaseRecord(dataBean);
		ToolPage toolPage = ToolPage.pagination(model, pageIndex, list, totalRecord, pageSize,request.getContextPath() + ConstantUtil.COUNT_DATA + "purchaseCount", parameterNames, parameterValues);
		
		//将分页信息和数据放入model域中，用来页面回显信息
		model.addAttribute("toolPage",toolPage);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("list", list);
		return ConstantUtil.COUNT_DATA + "purchaseCount";
	}
}
