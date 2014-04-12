package com.cyou.library.xh.borrow.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyou.library.xh.book.dao.BookDao;
import com.cyou.library.xh.book.domain.Book;
import com.cyou.library.xh.borrow.dao.BorrowRecordDao;
import com.cyou.library.xh.borrow.domain.BorrowRecord;
import com.cyou.library.xh.borrow.domain.BorrowRecordList;
import com.cyou.library.xh.borrow.domain.ReturnBook;
import com.cyou.library.xh.borrow.service.BorrowRecordService;
import com.cyou.library.xh.common.domain.DataBean;
import com.cyou.library.xh.user.dao.UserDao;
import com.cyou.library.xh.user.domain.User;

@Service("borrowRecordService")
public class BorrowRecordServiceImpl implements BorrowRecordService {
	@Resource(name="borrowRecordDao")
	BorrowRecordDao borrowRecordDao;
	@Resource(name="userDao")
	UserDao userDao;
	@Resource(name="bookDao")
	BookDao bookDao;

	public List<BorrowRecordList> selectBorrowRecord(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return borrowRecordDao.selectBorrowRecord(pageIndex, pageSize,1);
	}

	public int addBorrowRecord(String bookId,int userId) {
		// TODO Auto-generated method stub
		BorrowRecord borrowRecord=new BorrowRecord();
		
		borrowRecord.setBook_id(bookId);
		borrowRecord.setUser_id(userId);
		return borrowRecordDao.addBorrowRecord(borrowRecord);
	}

	public int borrowRecordCount() {
		// TODO Auto-generated method stub
		return borrowRecordDao.borrowRecordCount();
	}

	public int updateBorrowRecord(BorrowRecord borrowRecord) {
		// TODO Auto-generated method stub
		return borrowRecordDao.updateBorrowRecord(borrowRecord);
	}

	public int deleteBorrowRecord(int checkId) {
		// TODO Auto-generated method stub
		return borrowRecordDao.deleteBorrowRecord(checkId);
	}
	public int getBorrowAndOrerBooks(int userId){
		User user=new User();
		user.setUser_id(userId);
		user = userDao.getUserByUserId(user);
		return (6-user.getUser_ordernum()-user.getUser_borrownum());
	}

	public ReturnBook selectReturnBook(String bookId) {
		// TODO Auto-generated method stub
		ReturnBook returnBook=borrowRecordDao.selectReturnBook(bookId);
		if(returnBook!=null){
			Date endDate=returnBook.getCheck_endTime();
			Date returnDate=new Date();
			int overDue=0;
			if(returnDate.getTime() > endDate.getTime()){
				overDue=(int)((returnDate.getTime()-endDate.getTime())/(24*60*60*1000));
			}
			returnBook.setOverDue(overDue);
			return returnBook;
		}else{
			return null;
		}
	}

	public void doReturnBook(String bookId) {
		ReturnBook returnBook=borrowRecordDao.selectReturnBook(bookId);
		Date endDate=returnBook.getCheck_endTime();
		Date returnDate=new Date();
		int check_flag=2;
		int overDue=0;
		User user=new User();
		Book book=new Book();
		int line=0;
		
		BorrowRecord borrowRecord=new BorrowRecord();
		
		borrowRecord.setCheck_id(returnBook.getCheck_id());
		
		
		if(returnDate.getTime() > endDate.getTime()){
			overDue=(int)((returnDate.getTime()-endDate.getTime())/(24*60*60*1000));
			borrowRecord.setCheck_overdue(overDue);
			borrowRecord.setCheck_flag(4);
		}else{
			borrowRecord.setCheck_flag(3);
			borrowRecord.setCheck_overdue(0);
		}
		line=borrowRecordDao.updateBorrowRecord(borrowRecord);

		book.setId(returnBook.getBook_id());
		book.setBookCheckFlag(0);
		bookDao.updateBook(book);
		
		user.setUser_id(returnBook.getUser_id());
		user=userDao.getUserByUserId(user);
		int borrowNum=user.getUser_borrownum();
		user.setUser_borrownum(borrowNum+1);
		userDao.updateBorrowNumById(user);
		
	}


	public BorrowRecordList selectRecordById(Integer checkId) {
		// TODO Auto-generated method stub
		return borrowRecordDao.selectRecordById(checkId);
	}

	public List<DataBean> countBorrowState(int pageIndex,int pageSize,DataBean dataBean) {
		return this.borrowRecordDao.countBorrowState(pageIndex,pageSize,dataBean);
	}


	public List<String> getBookNameByUserId(Integer userId) {
		return this.borrowRecordDao.getBookNameByUserId(userId);
	}

	public Integer allBorrowRecords(DataBean dataBean) {
		return this.borrowRecordDao.allBorrowRecords(dataBean);
	}

	public List<DataBean> countBorrowByBook(int pageIndex,int pageSize,DataBean dataBean) {
		return this.borrowRecordDao.countBorrowByBook(pageIndex,pageSize,dataBean);
	}

	public Integer allBorrowRecordByBook(DataBean dataBean) {
		return this.borrowRecordDao.allBorrowRecordByBook(dataBean);
	}

	public List<DataBean> countBorrowByType(DataBean dataBean) {
		return this.borrowRecordDao.countBorrowByType(dataBean);
	}




}
