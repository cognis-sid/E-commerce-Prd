package com.rclgroup.dolphin.rcl.web.common;

import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.ezl.email.EZLMail;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.AdminBookingLogDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

public class BookingThread extends Thread {
	private EserviceNewWebBookingUim uim;
	private EserviceNewWebBookingDao objDao;
	private AdminBookingLogDao adminLogDAO;
	private String cutomeNmae;
	private String repCompanyName;
	private String bookingPartyComName;
	
	public BookingThread(EserviceNewWebBookingUim uim, EserviceNewWebBookingDao objDao, String cutomeNmae,String repCompanyName ,String bookingPartyComName,AdminBookingLogDao adminLogDAO) {
		this.uim = uim;
		this.objDao = objDao;
		this.cutomeNmae = cutomeNmae;
		this.repCompanyName=repCompanyName;
		this.bookingPartyComName=bookingPartyComName;
		this.adminLogDAO = adminLogDAO;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			System.out.println(uim.getBookingNo());
			System.out.println(uim.getBookingRef());
			Utilis.generateBookingXmlFile(uim, objDao, cutomeNmae);
		} catch (Exception e) {
			e.printStackTrace();
			this.adminLogDAO.insertLogInLogTable(uim, e, AdminBookingLogDao.DAO_BOOKING_SUBMIT_XML);
		}
		try {
			System.out.println("Ready for mail sending..");
			System.out.println("Email : "+uim.getEmail());
			EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail");
			mail.bookingSubmitionMail(uim,repCompanyName,bookingPartyComName);
			if(uim.getToPicMail()!=null && !uim.getToPicMail().equals("")) {
				System.out.println("ready for pic mail : "+uim.getToPicMail());
				mail.bookingSubmitionMailToAll(uim,repCompanyName,bookingPartyComName);
            }
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
