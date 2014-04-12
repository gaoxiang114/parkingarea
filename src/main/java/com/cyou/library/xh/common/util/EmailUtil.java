package com.cyou.library.xh.common.util;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	
	public static String FROM;
	public static String USER;
	public static String PASSWORD;
	public static String SMTP;
	public static String NEED;
	
   static {
		ToolProperties tp = new ToolProperties();
		FROM = tp.getMessage("mail.properties", "mail.stmp.emailUrl");
		USER = tp.getMessage("mail.properties", "mail.smtp.username");
		PASSWORD = tp.getMessage("mail.properties", "mail.smtp.password");
		SMTP = tp.getMessage("mail.properties", "mail.smtp.host");// Stmp服务主机 smtp.qq.com
		NEED = tp.getMessage("mail.properties", "mail.smtp.auth");//是否需要身份论证
	}
	/**smtp.cyou-inc.com
	 * 
	 * @param recipient 收件人地址
	 * @param title  邮件标题
	 * @param content  邮件文字内容
	 * @param affixPath	 附件，为null时不添加附件
	 * @return
	 */
	public static boolean doSendMail(String recipient,String title,String content,String affixPath) {
		
		Properties prop = System.getProperties();
		Session session = Session.getDefaultInstance(prop, null);
		prop.put("mail.smtp.host",SMTP);
		prop.put("mail.smtp.auth",NEED);
		prop.put("mail.smtp.port", "25");//设置邮件服务器端口
		prop.put("mail.transpost.protocol", "smtp");//设置传输协议stmp

		Session mailSession=Session.getInstance(prop, null);
		MimeMessage mimeMessage=new MimeMessage(session);
		Multipart multipart=new MimeMultipart();//主体内容
		try {
			//
			BodyPart bodyPart=new MimeBodyPart();
			bodyPart.setContent(content,"text/html;charset=UTF-8");
			multipart.addBodyPart(bodyPart);//添加文字到主体内容
			
			addAffix( multipart, affixPath);//添加附件到主体内容
			mimeMessage.setSubject(title,"GB2312");//设置标题
			mimeMessage.setRecipients(Message.RecipientType.TO,recipient);//设置收件人
			mimeMessage.setFrom(new InternetAddress(FROM));//设置发件人
			
			mimeMessage.setContent(multipart);//设置邮件主体内容
			mimeMessage.saveChanges();
			Transport transport=mailSession.getTransport("smtp");
			transport.connect((String)prop.get("mail.smtp.host"), USER, PASSWORD);
			transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
			transport.close();
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("发件人邮箱设置错误,请检查用户和密码！");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 添加附件
	 * @param multipart
	 * @param affixPath
	 */
	private static void addAffix(Multipart multipart,String affixPath){
		if(affixPath!=null){
			FileDataSource affixFile=new FileDataSource(affixPath);
			BodyPart affix=new MimeBodyPart();
			try {
				affix.setFileName(affixFile.getName());
				affix.setDataHandler(new DataHandler(affixFile));
				multipart.addBodyPart(affix);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(doSendMail("gaoxiang_nad@cyou-inc.com","测试邮件例子","收到邮件请回复","C:\\Documents and Settings\\gaoxiang_nad\\My Documents\\我接收到的文件\\部门图书汇总_20121125.xlsx"));
	}
}