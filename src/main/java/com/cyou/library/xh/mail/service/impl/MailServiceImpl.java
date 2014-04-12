package com.cyou.library.xh.mail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyou.library.xh.mail.dao.MailDao;
import com.cyou.library.xh.mail.domain.Mail;
import com.cyou.library.xh.mail.service.MailService;
@Service("mailService")
public class MailServiceImpl implements MailService {

	@Resource(name="mailDao")
	private MailDao mailDao;
	public void addMail(Mail mail) {
		this.mailDao.addMail(mail);
	}

	public void updateMail(Mail mail) {
		this.mailDao.updateMail(mail);
	}

	public List<Mail> getMailList() {
		return this.mailDao.getMailList();
	}

	public Mail getMailById(Integer mailId) {
		return this.mailDao.getMailById(mailId);
	}

}
