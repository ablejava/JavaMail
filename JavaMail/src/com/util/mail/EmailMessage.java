package com.util.mail;

import java.util.Date;

/**
 * �����ʼ���Ҫ������Ϣ��
 */
public class EmailMessage {
	//	�ʼ�������
	public  static String TO = "15026933568@163.com";   

	//	�ʼ�������
	public  static String FROM = "15026933568@163.com"; 
	
	// ����������
	public  static String FROM_NAME = "15026933568"; 

	//	 ������	
	public  static String CC="1298243794@qq.com";   	

	//	 ������
	public  static String BCC="15026933568@163.com";   	

	//	�ʼ�����
	public 	static String Email_Content = "text/plain";

	//	�ʼ�����
	public  static String Email_Subject = "Test Email With JavaMail";   

	//	�ʼ�ͷ
	public  static String Email_Header = "This Is Email Header";   	

	//	�ʼ�����
	public  static String Email_Body = "<a href=\"http://www.baidu.com\">This Is Email Body</a>"; 

	//	ʹ������	���ʹ��QQ�޸�Ϊsmtp.qq.com
	public  static String Email_Host = "smtp.163.com";   		

	//	�ʼ���������
	public 	static Date sendDate = new Date(); 	

	//	�Ƿ���֤
	public 	static boolean validate = true; 	
}