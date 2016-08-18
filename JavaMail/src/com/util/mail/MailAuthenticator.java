package com.util.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 用户名和密码的验证
 * @author xiazhongwei
 *
 */
public class MailAuthenticator extends Authenticator{
	private  String username="15026933568";   
	private  String password="xzw19910721";   
	
	public MailAuthenticator() {
		super();
	}
	
	/**
	 * 设置验证的用户名和密码
	 */
	public MailAuthenticator(String userName , String password) {
		super();
		this.username = userName;
		this.password = password;
	}
	
	protected PasswordAuthentication getPasswordAuthentication()
	{   
		return new PasswordAuthentication(this.username,this.password);   
	}   
}
