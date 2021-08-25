
package com.rclgroup.dolphin.rcl.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.ezl.email.EZLMail;
import com.rclgroup.dolphin.rcl.web.eservice.action.EshippingInstructionSvc;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.AdminBookingLogDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;



public class ShippingThread extends Thread{

	private EshippingInstructionUim uim;
	private EshippingInstructionDao objDao;
	private String cutomeNmae;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String bookingParty;
	private String RepCompanyName;
	private AdminBookingLogDao adminDao;
	
	public ShippingThread(AdminBookingLogDao adminDao ,EshippingInstructionUim uim, EshippingInstructionDao objDao, String cutomeNmae,HttpServletRequest request, HttpServletResponse response,String bookingParty,String RepCompanyName) {
		this.uim = uim;
		this.objDao = objDao;
		this.cutomeNmae = cutomeNmae;
		this.request=request;
		this.response= response;
		this.bookingParty=bookingParty;
		this.RepCompanyName=RepCompanyName;
		this.adminDao=adminDao;
	}
	
	@Override
	public void run() {

		try {
			Utilis.generateEshippingInstructionXmlFile(uim, objDao, cutomeNmae);
		} catch (Exception e) {
			e.printStackTrace();
			adminDao.insertLogInLogSiTable(uim.getBookingNo(), uim.getBlNo(),uim.getUserName(),e, AdminBookingLogDao.DAO_SI_SUBMIT_XML);
		}
		try {
			EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail");
			EshippingInstructionSvc objSvc=new EshippingInstructionSvc();	
			byte[] data=objSvc.priperPdfForMail(uim,objDao,request);
			mail.shippingSubmitionMail(uim,data,bookingParty,RepCompanyName);
            if(uim.getToPicMail()!=null && !uim.getToPicMail().equals("")) {
				mail.shippingSubmitionMailPicuser(uim,data,bookingParty,RepCompanyName);
           }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
 
