package com.cyou.library.xh.borrow.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyou.library.xh.borrow.domain.BorrowRecord;
import com.cyou.library.xh.borrow.domain.BorrowRecordList;
import com.cyou.library.xh.borrow.domain.ReturnBook;
import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.common.domain.DataBean;

@Repository("borrowRecordDao")
public class BorrowRecordDao extends BaseDao{
	public List<BorrowRecordList> selectBorrowRecord(int pageIndex, int pageSize,int state){
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("pageIndex", pageIndex*pageSize);
    	map.put("pageSize", pageSize);
    	map.put("state", state);
		return this.getList("selectBorrowRecord",map);
	}	
	public int addBorrowRecord(BorrowRecord borrowRecord){
		return this.add("addBorrowRecord",borrowRecord);
	}
	public BorrowRecordList selectRecordById(Integer checkId){
		return this.getUniqueOne("selectBorrowRecordById", checkId);
	}
	public int borrowRecordCount(){
		return (Integer) this.getSqlSession().selectOne("borrowRecordCount");
	}
	public int updateBorrowRecord(BorrowRecord borrowRecord){
		return this.update("updateBorrowRecord", borrowRecord);
	}
	public int deleteBorrowRecord(int checkId){
		return this.delete("deleteBorrowRecord", checkId);
	}
	public ReturnBook selectReturnBook(String bookId){
		return this.getUniqueOne("selectReturnBook", bookId);
	}
	
	/**
	 * countBorrowState:按用户的user_id来获取他说借阅的书籍的名称
	 * @param DataBean dataBean
	 * @return 返回 泛型为DataBean 的数据列表List<DataBean> 
	 */
	public List<DataBean> countBorrowState(int pageIndex,int pageSize,DataBean dataBean){
		
		List list = null;
	    
	    try {
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("pageIndex", pageIndex*pageSize);
	    	map.put("pageSize", pageSize);
	    	map.put("startDate", dataBean.getStartDate());
	    	map.put("endDate", dataBean.getEndDate());
	    	map.put("department", dataBean.getDepartment());
	    	
		    if(-1 == pageIndex && 0 == pageSize){
		    	list = this.getList("countBorrowState", map);
		    }else{
		    	list = this.getList("countBorrowState", map);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  list;
	}
	
	/**
	 * getBookNameByUserId:按用户的user_id来获取他说借阅的书籍的名称
	 * @param Integer userId
	 * @return 返回 泛型为String 的数据列表List<String> 
	 */
	public List<String> getBookNameByUserId(Integer userId){
		return this.getList("getBookNameByUserId",userId);
	}
	
	/**
	 * allBorrowRecords:按条件来统计符合条件的总记录数
	 * @param DataBean dataBean
	 * @return 返回 Integer 类型的记录数
	 */
	public Integer allBorrowRecords(DataBean dataBean){
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("startDate", dataBean.getStartDate());
    	map.put("endDate", dataBean.getEndDate());
    	map.put("department", dataBean.getDepartment());
		return this.getCount("allBorrowRecords", dataBean);
	}
	
	/**
	 * countBorrowByType:按书的类型统计
	 * @param DataBean dataBean
	 * @return 返回 List<DataBean> 列表
	 */
	public List<DataBean> countBorrowByType(DataBean dataBean){
		return this.getList("countBorrowByType",dataBean);
	}
	
	/**
	 * countBorrowByBook:按书籍统计借阅情况
	 * @param DataBean dataBean
	 * @return 返回List<DataBean> 列表
	 */
	public List<DataBean> countBorrowByBook(int pageIndex,int pageSize,DataBean dataBean){
		List list = null;
	    
	    try {
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("pageIndex", pageIndex*pageSize);
	    	map.put("pageSize", pageSize);
	    	map.put("typeId", dataBean.getTypeId());
	    	map.put("startDate", dataBean.getStartDate());
	    	map.put("endDate", dataBean.getEndDate());
	    	
		    if(-1 == pageIndex && 0 == pageSize){
		    	list = this.getList("countBorrowByBook", map);
		    }else{
		    	list = this.getList("countBorrowByBook", map);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  list;
		
	}
	
	/**
	 * allBorrowRecordByBook:按书籍统计符合条件的总记录数
	 * @return
	 */
	public Integer allBorrowRecordByBook(DataBean dataBean){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("typeId", dataBean.getTypeId());
    	map.put("endDate", dataBean.getEndDate());
    	map.put("department", dataBean.getDepartment());
		return this.getCount("allBorrowByBook",map);
	}
} 
