package com.rclgroup.dolphin.rcl.web.common;

import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.ezl.email.EZLMail;

public class ForgetPasswordThread extends Thread{
String name;
String password;
String useId;
String email;
	
	public ForgetPasswordThread(String name,String password,String email,String useId) {
	this.name =	name;
	this.password = password;
	this.useId =useId;
	this.email=email;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail");
			mail.forgetPasswordMail(name, password, email , useId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
