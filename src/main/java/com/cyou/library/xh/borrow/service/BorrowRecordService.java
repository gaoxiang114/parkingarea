package com.cyou.library.xh.borrow.service;

import java.util.List;

import com.cyou.library.xh.borrow.domain.BorrowRecord;
import com.cyou.library.xh.borrow.domain.BorrowRecordList;
import com.cyou.library.xh.borrow.domain.ReturnBook;
import com.cyou.library.xh.common.domain.DataBean;

public interface BorrowRecordService {
	public List<BorrowRecordList> selectBorrowRecord(int pageIndex, int pageSize);
	public int addBorrowRecord(String bookId,int userId);
	public int borrowRecordCount();
	public int updateBorrowRecord(BorrowRecord borrowRecord);
	public int deleteBorrowRecord(int checkId);
	public int getBorrowAndOrerBooks(int userId);
	public ReturnBook selectReturnBook(String bookId);
	public void doReturnBook(String bookId);
	public BorrowRecordList selectRecordById(Integer checkId);
	/**
	 * countBorrowState:按书籍类型统计书库的情况
	 * @param DataBean dataBean
	 * @return List<DataBean>
	 */
	public List<DataBean> countBorrowState(int pageIndex,int pageSize,DataBean dataBean);
	
	/**
	 * getBookNameByUserId:按用户的id来查处该用户所借阅的书籍列表
	 * @param Integer userId
	 * @return List<String>
	 */
	public List<String> getBookNameByUserId(Integer userId);
	
	/**
	 * allBorrowRecords:获取总记录数
	 * @param DataBean dataBean
	 * @return Integer 记录
	 */
	public Integer allBorrowRecords(DataBean dataBean);
	/**
	 * countBorrowByBook:按书籍统计书库的情况
	 * @param Integer userId
	 * @return List<String>
	 */
	public List<DataBean> countBorrowByBook(int pageIndex,int pageSize,DataBean dataBean);
	/**
	 * allBorrowRecords:获取总记录数
	 * @param DataBean dataBean
	 * @return Integer 记录
	 */
	public Integer allBorrowRecordByBook(DataBean dataBean);
	
	public List<DataBean> countBorrowByType(DataBean dataBean);
}
