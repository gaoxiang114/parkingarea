package com.cyou.library.xh.mail.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.mail.domain.Mail;
@Component("mailDao")
public class MailDao extends BaseDao {
	
	/**
	 * addMail:添加邮件预设信息
	 * @author gaoxiang_nad
	 * @param Mail mail
	 */
	public void addMail(Mail mail){
		this.add("addMail", mail);
	}
	
	/**
	 * updateMail:修改邮件预设信息
	 * @author gaoxiang_nad
	 * @param Mail mail
	 */
	public void updateMail(Mail mail){
		this.update("updateMail", mail);
	}
	
	/**
	 * getMailList:获取邮件信息列表
	 * @author gaoxiang_nad
	 */
	public List<Mail> getMailList(){
		return this.getList("getMailList");
	}
	
	public Mail getMailById(Integer mailId){
		return this.getUniqueOne("getMailById", mailId);
	}
}
