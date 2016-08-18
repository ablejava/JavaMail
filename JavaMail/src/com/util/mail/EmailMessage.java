package com.util.mail;

import java.util.Date;

/**
 * 发送邮件需要基本信息类
 */
public class EmailMessage {
	//	邮件接收者
	public  static String TO = "15026933568@163.com";   

	//	邮件发送人
	public  static String FROM = "15026933568@163.com"; 
	
	// 发送人姓名
	public  static String FROM_NAME = "15026933568"; 

	//	 抄送者	
	public  static String CC="1298243794@qq.com";   	

	//	 暗送者
	public  static String BCC="15026933568@163.com";   	

	//	邮件类型
	public 	static String Email_Content = "text/plain";

	//	邮件主题
	public  static String Email_Subject = "Test Email With JavaMail";   

	//	邮件头
	public  static String Email_Header = "This Is Email Header";   	

	//	邮件内容
	public  static String Email_Body = "<a href=\"http://www.baidu.com\">This Is Email Body</a>"; 

	//	使用邮箱	如果使用QQ修改为smtp.qq.com
	public  static String Email_Host = "smtp.163.com";   		

	//	邮件发送日期
	public 	static Date sendDate = new Date(); 	

	//	是否验证
	public 	static boolean validate = true; 	
}