package com.util.mail;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail 
{
	
	/**  
	* 发送普通邮件  
	* @throws Exception  
	*/   
	public void doSendNormalMail() 
	{   
//		 获取系统环境  
		Properties prop = new Properties();  
		Authenticator auth = null;
//		判断发送邮件是否需要验证
		if (EmailMessage.validate) 
		{
//			 邮件服务器认证   用户名和密码
			auth =	new MailAuthenticator();  
		}
//		添加必要的信息
		prop.put("mail.smtp.host", EmailMessage.Email_Host);   
		prop.put("mail.smtp.auth", "true");   
		
//		 设置对话和邮件服务器进行通讯
		Session session = Session.getDefaultInstance(prop, auth);   
//		在控制台显示Debug信息
		session.setDebug(true);
//		设置邮件对象
		Message message = new MimeMessage(session);   
		try 
		{   
//			 设置邮件主题 
			message.setSubject(EmailMessage.Email_Subject);   
//			 设置邮件标题   
			message.setHeader("Header", EmailMessage.Email_Header); 
//			  设置发送时间   
			message.setSentDate(EmailMessage.sendDate);
			
//			 设置发信人地址  和 名字
			Address address = new InternetAddress(EmailMessage.FROM, EmailMessage.FROM_NAME);   
//			把发件人信息添加到信息中
			message.setFrom(address);   
			
//			设置发件人地址
			Address toAddress = new InternetAddress(EmailMessage.TO); 
//			 设置接收人地址
			message.setRecipient(Message.RecipientType.TO, toAddress);   
		  
//		 	设置多个收件人地址   
//		 	message.addRecipient(Message.RecipientType.TO,new InternetAddress("xxx@xxx.com"));   

//			 设置邮件格式
			message.setContent("Content", EmailMessage.Email_Content); 
//			 设置邮件内容    必须在设置文件格式后面
			message.setText(EmailMessage.Email_Body); 
			
//			保存上面添加的信息
			message.saveChanges();   
//			 发送邮件 
			System.out.println("sendNormalEmail() 开始发送邮件……");   
			Transport.send(message);   
			System.out.println("发送成功！");   
		} catch (Exception e) {   
				System.out.println("出错");   
				e.printStackTrace();   
		}   
	}   
	
	/**
	 * 发送HTML格式的邮件
	 */
	public void doSendHtmlMail() {   
//		 获取系统环境  
		Properties prop = new Properties();  

		Authenticator auth = null;
		if (EmailMessage.validate)
		{
//			 邮件服务器认证   用户名和密码
			auth = new MailAuthenticator();
		}
//		添加必要的信息
		prop.put("mail.smtp.host", EmailMessage.Email_Host);   
		prop.put("mail.smtp.auth", "true");   
		
//		 设置对话和邮件服务器进行通讯
		Session session = Session.getDefaultInstance(prop, auth);   
		
//		设置邮件对象
		Message message = new MimeMessage(session);   
		try 
		{   
//			 设置邮件主题 
			message.setSubject(EmailMessage.Email_Subject);   
//			 设置邮件标题   
			message.setHeader("Header", EmailMessage.Email_Header); 
//			  设置发送时间   
			message.setSentDate(EmailMessage.sendDate);
			
//			 设置发信人地址  和 名字
			Address address = new InternetAddress(EmailMessage.FROM, EmailMessage.FROM_NAME);   
//			把发件人信息添加到信息中
			message.setFrom(address);   
			
//			设置发件人地址
			Address toAddress = new InternetAddress(EmailMessage.TO); 
//			 设置接收人地址
			message.setRecipient(Message.RecipientType.TO, toAddress);   
		  
//		 	设置多个收件人地址   
//		 	message.addRecipient(Message.RecipientType.TO,new InternetAddress("xxx@xxx.com"));   

//			设置发送信息的内容   下面为发送hmml
//			设置邮件格式
			EmailMessage.Email_Content = "text/html; charset=utf-8";
			message.setContent(EmailMessage.Email_Body, EmailMessage.Email_Content); 

//			保存上面添加的信息
			message.saveChanges();   
//			 发送邮件 
			System.out.println("doSendHtmlMail() 开始发送邮件……");   
			Transport.send(message);   
			System.out.println("发送成功！");   
		} catch (Exception e) {   
				System.out.println("出错");   
				e.printStackTrace();   
		}   
	}   
	/**
	 * 发送带有附件格式的邮件
	 */
	public void doSendAttachmentMail() 
	{   
//		 获取系统环境  
		Properties prop = new Properties();  

		Authenticator auth = null;
		if (EmailMessage.validate)
		{
//			 邮件服务器认证   用户名和密码
			auth = new MailAuthenticator();
		}
//		添加必要的信息
		prop.put("mail.smtp.host", EmailMessage.Email_Host);   
		prop.put("mail.smtp.auth", "true");   
		
//		 设置对话和邮件服务器进行通讯
		Session session = Session.getDefaultInstance(prop, auth);   
		
//		设置邮件对象
		Message message = new MimeMessage(session);   
		try 
		{   
//			 设置邮件主题 
			message.setSubject(EmailMessage.Email_Subject);   
//			 设置邮件标题   
			message.setHeader("Header", EmailMessage.Email_Header); 
//			  设置发送时间   
			message.setSentDate(EmailMessage.sendDate);
			
//			 设置发信人地址  和 名字
			Address address = new InternetAddress(EmailMessage.FROM, EmailMessage.FROM_NAME);   
//			把发件人信息添加到信息中
			message.setFrom(address);   
			
//			设置发件人地址
			Address toAddress = new InternetAddress(EmailMessage.TO); 
//			 设置接收人地址
			message.setRecipient(Message.RecipientType.TO, toAddress);   
		  
//		 	设置多个收件人地址   
//		 	message.addRecipient(Message.RecipientType.TO,new InternetAddress("xxx@xxx.com"));   
		  
			
//			设置发送信息的内容   下面为发送附件
			message.setContent(EmailMessage.Email_Body, EmailMessage.Email_Content); 
			
			//BodyPart messageBodyPart = new MimeBodyPart();   
			MimeBodyPart messageBodyPart = new MimeBodyPart(); 
			String body = "<h4>内含附件、图文并茂的邮件测试！！！</h4> </br>" 
	                + "<a href = http://haolloyin.blog.51cto.com/> 蚂蚁</a></br>" 
	                + "<img src = \"cid:logo_jpg\"></a>";
			
			MimeBodyPart image = createContent(body,"E:\\1.jpg");
			messageBodyPart.setText("<img src='cid:image_fairy_tail'/>");   
			
			Multipart multipart = new MimeMultipart();   
			//multipart.addBodyPart(messageBodyPart);   
			
			messageBodyPart = new MimeBodyPart();   
			
//			设置上传的资源
			DataSource source = new FileDataSource("E:\\3.txt");  
//			添加到
			messageBodyPart.setDataHandler(new DataHandler(source));   
//			设置文件名称,记得后缀名
			messageBodyPart.setFileName("3.txt");   
			multipart.addBodyPart(messageBodyPart);
			
			
			// 5. 创建图片“节点”
			/*MimeBodyPart image = new MimeBodyPart();
	        DataHandler dh = new DataHandler(new FileDataSource("E:\\1.jpg")); // 读取本地文件
	        image.setDataHandler(dh);                   // 将图片数据添加到“节点”
	        image.setContentID("image_fairy_tail"); */    // 为“节点”设置一个唯一编号（在文本“节点”将引用该ID）
	     // 6. 创建文本“节点”
	        MimeBodyPart text = new MimeBodyPart();
	        //    这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
	        text.setContent("这是一张图片<br/><img src='cid:image_fairy_tail'/>", "text/html;charset=UTF-8");
	        multipart.addBodyPart(image);
	        multipart.addBodyPart(text);
			
			message.setContent(multipart);   
			
//			保存上面添加的信息
			message.saveChanges();   
//			 发送邮件 
			System.out.println("doSendAttachmentMail() 开始发送邮件……");   
			Transport.send(message);   
			System.out.println("发送成功！");   
		} catch (Exception e)
		{   
				System.out.println("出错");   
				e.printStackTrace();   
		}   
	} 
	
	
	/**  
     * 根据传入的邮件正文body和文件路径创建图文并茂的正文部分  
     */ 
    public MimeBodyPart createContent(String body, String fileName)  
            throws Exception {  
        // 用于保存最终正文部分  
        MimeBodyPart contentBody = new MimeBodyPart();  
        // 用于组合文本和图片，"related"型的MimeMultipart对象  
        MimeMultipart contentMulti = new MimeMultipart("related");  
 
        // 正文的文本部分  
        MimeBodyPart textBody = new MimeBodyPart();  
        textBody.setContent(body, "text/html;charset=utf-8");  
        contentMulti.addBodyPart(textBody);  
 
        // 正文的图片部分  
        MimeBodyPart jpgBody = new MimeBodyPart();  
        FileDataSource fds = new FileDataSource(fileName);  
        jpgBody.setDataHandler(new DataHandler(fds));  
        jpgBody.setContentID("logo_jpg");  
        contentMulti.addBodyPart(jpgBody);  
 
        // 将上面"related"型的 MimeMultipart 对象作为邮件的正文  
        contentBody.setContent(contentMulti);  
        return contentBody;  
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		new SendEmail().doSendNormalMail();
//		new SendEmail().doSendHtmlMail();
		new SendEmail().doSendAttachmentMail();
	}
}