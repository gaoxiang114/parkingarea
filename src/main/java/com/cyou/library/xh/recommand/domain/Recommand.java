package com.cyou.library.xh.recommand.domain;

import java.io.Serializable;
import java.util.Date;

import com.cyou.library.xh.book.domain.BookType;
import com.cyou.library.xh.user.domain.User;

public class Recommand implements Serializable{
	
	   private Integer recId;  // '推荐表主键标识',
       private User user; // '户用id',
	   private String bookName; // 图书名称
	   private String bookPublish;  // 出版社
	   private float bookPrice;  // 图书数量
  	   private String bookDouban;  // 豆瓣链接
  	   private String bookAuthor; // 作者名称
	   private BookType type;  // '书籍类别',
	   private String recFlag; // 0处理中、1未通过、2审核通过购买中、3购买成功、4购买失败
	   private String recUrl; // 购买书籍的url
	   private Date recDate; //推荐时间
	   
		public Integer getRecId() {
			return recId;
		}
		public void setRecId(Integer recId) {
			this.recId = recId;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getBookPublish() {
			return bookPublish;
		}
		public void setBookPublish(String bookPublish) {
			this.bookPublish = bookPublish;
		}
		public String getBookDouban() {
			return bookDouban;
		}
		public void setBookDouban(String bookDouban) {
			this.bookDouban = bookDouban;
		}
		public String getBookAuthor() {
			return bookAuthor;
		}
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		public String getRecFlag() {
			return recFlag;
		}
		public void setRecFlag(String recFlag) {
			this.recFlag = recFlag;
		}
		public String getRecUrl() {
			return recUrl;
		}
		public void setRecUrl(String recUrl) {
			this.recUrl = recUrl;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public BookType getType() {
			return type;
		}
		public void setType(BookType type) {
			this.type = type;
		}

		public float getBookPrice() {
			return bookPrice;
		}
		public void setBookPrice(float bookPrice) {
			this.bookPrice = bookPrice;
		}
		public Date getRecDate() {
			return recDate;
		}
		public void setRecDate(Date recDate) {
			this.recDate = recDate;
		}
		
		public String toString() {
			return "Recommand [recId=" + recId + ", user=" + user
					+ ", bookName=" + bookName + ", bookPublish=" + bookPublish
					+ ", bookPrice=" + bookPrice + ", bookDouban=" + bookDouban
					+ ", bookAuthor=" + bookAuthor + ", type=" + type
					+ ", recFlag=" + recFlag + ", recUrl=" + recUrl
					+ ", recDate=" + recDate + "]";
		}
		
		
}
