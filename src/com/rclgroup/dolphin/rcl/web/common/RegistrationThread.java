package com.rclgroup.dolphin.rcl.web.common;

import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.ezl.email.EZLMail;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;

public class RegistrationThread extends Thread{

	private EserviceRegistrationUim uim;
	String allSFUCodeChecked;
	String representedCompany;
	public RegistrationThread(EserviceRegistrationUim uim,String allSFUCodeChecked,String representedCompany) {
		this.uim = uim;
		this.allSFUCodeChecked=allSFUCodeChecked;
		this.representedCompany=representedCompany;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			System.out.println("RegistrationThread class run() called...");
			EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail");
				mail.sendMailForRegistrationConfirmation(uim, allSFUCodeChecked);
				if (uim.getToPicMail() != null && !uim.getToPicMail().equals("")) {
					mail.sendMailForRegistrationConfirmationPic(uim, allSFUCodeChecked, representedCompany);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
