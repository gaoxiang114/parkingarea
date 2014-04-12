package com.cyou.library.xh.mail.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyou.library.xh.common.util.ConstantUtil;
import com.cyou.library.xh.mail.domain.Mail;
import com.cyou.library.xh.mail.service.MailService;

@Controller
@RequestMapping("/mail")
public class MailController {
	private static Logger logger = Logger.getLogger(MailController.class);
	@Resource(name="mailService")
	private MailService mailService;
	
	@RequestMapping(value="/toAddMail")
	public String toAddMail(Model model,HttpServletRequest request){
		
		String message = request.getParameter("message");
		System.out.println(message+"----------------");
		try {
			if(message != null && !"".equals(message)){
				model.addAttribute("message",URLDecoder.decode(message, "UFT-8"));
			}
			
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage()+": 提示消息解码出现异常！");
		}
		
		
		return ConstantUtil.MAIL_PATH + "addMail";
	}
	
	@RequestMapping(value="/doAddMail")
	public String doAddMail(Model model,Mail mail){
		String message="邮件预设信息添加失败！";
		try {
			this.mailService.addMail(mail);
			message="邮件预设信息添加成功！";
			message=URLEncoder.encode(message,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			try {
				message=URLEncoder.encode(message,"UTF-8");
			} catch (UnsupportedEncodingException e1) {
				logger.error(e.getMessage()+": 提示消息转码异常！");
				e1.printStackTrace();
			}
			logger.error(e.getMessage()+"：提示消息转码异常！");
		}
		
		return "redirect:" + ConstantUtil.MAIL_PATH + "toAddMail?message="+message;
	}
	
	@RequestMapping(value="/toUpdateMail")
	public String toUpdateMail(Model model,HttpServletRequest request,Integer mailId){
		String message = request.getParameter("message");
		Mail mail = null;
		try {
			mail=this.mailService.getMailById(mailId);
			if(message!=null && !"".equals(message)){
				message=URLDecoder.decode(message, "UTF-8");
				model.addAttribute("message", message);
			}
			
			model.addAttribute("mail", mail);
			
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage()+": 出现解码异常");
		}
		
		return ConstantUtil.MAIL_PATH+"updateMail";
	}
	
	@RequestMapping(value="/doUpdateMail")
	public String doUpdateMail(Model model,Mail mail){
		String message = "邮件预设信息修改成功！";
		try {
			this.mailService.updateMail(mail);
			message = URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			try {
				message = URLEncoder.encode(message,"UTF-8");
			} catch (UnsupportedEncodingException e2) {
				logger.error(e2.getMessage()+": 邮件预设信息修改时出现 转码异常");
			}
			logger.error(e.getMessage()+": 邮件预设信息修改时出现 转码异常");
		}
		
		return "redirect:"+ConstantUtil.MAIL_PATH + "toUpdateMail?message="+message+"&mailId="+mail.getMailId();
	}
	
	@RequestMapping(value="/toMailList")
	public String toMailList(Model model,HttpServletRequest request,String currentPage){
		
		List<Mail> mailList = this.mailService.getMailList();
		model.addAttribute("mailList", mailList);
		return ConstantUtil.MAIL_PATH+"mailList";
	}
}
