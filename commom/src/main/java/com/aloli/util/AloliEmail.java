package com.aloli.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jboss.logging.Logger;

public class AloliEmail { 

private String sender; 
private String username; 
private String password; 
public String getSender() { 
return sender; 
} 
public void setSender(String sender) { 
this.sender = sender; 
} 
public String getUsername() { 
return username; 
} 
public void setUsername(String username) { 
this.username = username; 
} 
public String getPassword() { 
return password; 
} 
public void setPassword(String password) { 
this.password = password; 
} 

public static  AloliEmail  sender() {
	AloliEmail mail = new AloliEmail();
	// 发件人的邮箱地址（要完整），会显示在收件人的邮件中
	mail.setSender("11263132@qq.com");
	// 发件人登录邮箱的账号（@符合前面的部分）
	mail.setUsername("11263132");
	// 下面填的是邮箱客户端授权码，切记：邮箱务必要开启（POP3/SMTP服务）
	mail.setPassword("anfkhutlwsfbbhaj");
	return mail;
}
public  static void send(AloliEmail aloliEmail, String recipients,String numSmall) {
		
	Logger logger = Logger.getLogger(AloliEmail.class);
	logger.info("开始发送邮件！");
	sendMails( aloliEmail.getSender(), aloliEmail.getUsername(), aloliEmail.getPassword(), recipients,numSmall);

}
private static  void sendMails(String sender,String username,String password,String recipients,String numSmall) {
	try {
//创建邮件对象 
		Session session = null;
		Properties props = new Properties();
		// 此处为发送方邮件服务器地址，要根据邮箱的不同需要自行设置
		props.put("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.transport.protocol", "smtp");
//465端口是为SMTPS（SMTP-over-SSL）协议服务开放的，这是SMTP协议基于SSL安全协议之上的一种变种协议。
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// SMTP端口号
		props.put("mail.smtp.port", "465");
		// 设置成需要邮件服务器认证
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		session = Session.getInstance(props);
		session.setDebug(true);
		Message message = new MimeMessage(session);
		// 设置发件人
		message.setFrom(new InternetAddress(sender));
		// 设置收件人
		message.addRecipient(RecipientType.TO, new InternetAddress(recipients));
		// 设置标题
		message.setSubject("aloli验证中心");
		// 邮件内容，根据自己需要自行制作模板
		message.setContent("<p>尊敬的"+recipients+"用户：</p><p>您好!</p><p>欢迎加入aloli群体！" + "您的验证码是："+numSmall+"。"
				, "text/html;charset=utf-8");
		//发送邮件 
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.qq.com", username, password);// 以smtp方式登录邮箱
		// 发送邮件,其中第二个参数是所有已设好的收件人地址
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}