package com.rclgroup.dolphin.rcl.web.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.ezl.email.EZLMail;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.AdminBookingLogDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

public class CancelBooking extends Thread{

	private EserviceNewWebBookingUim 	form=null;
	private EserviceNewWebBookingDao   objDao=null;
	private String userId=null;
	private AdminBookingLogDao adminLogDAO;
	public CancelBooking(EserviceNewWebBookingUim 	form,EserviceNewWebBookingDao   objDao,String userId,AdminBookingLogDao adminLogDAO){
		this.form=form;
		this.objDao=objDao;
		this.userId=userId;
		this.adminLogDAO = adminLogDAO;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			 Utilis.generateBookingXmlFile(form, objDao, userId);
		} catch (Exception e) {
			e.printStackTrace();
			this.adminLogDAO.insertLogInLogTable(form, e, AdminBookingLogDao.DAO_BOOKING_CANCEL_XML);
		}
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String cuuntDate = dateFormat.format(date);
			EZLMail mail=(EZLMail) EZLBeanFactory.getBean("mailMail");
			mail.bookingCancelationMail(form.getBookingNo() ,form.getBookingRef() , cuuntDate, "BOOKINGCANCEL",form.getEmail(),form.getAdditionalMailRecipeints(),"SCREEN");
			if(form.getToPicMail()!=null && !form.getToPicMail().equals("")) {
				System.out.println("pic mail : "+form.getToPicMail()+" Pic cc mail : "+form.getCcPicMail()+" pic bcc mail "+form.getBccPicMail());
				mail.bookingCancelationPicMail(form);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
