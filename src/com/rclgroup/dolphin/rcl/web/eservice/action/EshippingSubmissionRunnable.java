/*------------------------------------------------------
EshippingSubmissionRunnable.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Yossawat Suntisukkasem 31/10/13
- Change Log -------------------------------------------
## DD/MM/YY     –User-   -TaskRef- -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.JdbcServiceLocator;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;

public class EshippingSubmissionRunnable implements Runnable{
    private String bookingNo;
    private EshippingInstructionDao dao;

    public void run() {
        try{
            System.out.println("Process ESI Submission --- Running ....");
            if(bookingNo != null && !"".equals(bookingNo)){
                System.out.println("Booking no for processing = "+bookingNo);
                dao.doESISubmission(bookingNo);
                System.out.println("Process ESI Submission --- Finished.");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setDao(EshippingInstructionDao dao) {
        this.dao = dao;
    }

    public EshippingInstructionDao getDao() {
        if(dao == null){
            dao = (EshippingInstructionDao) JdbcServiceLocator.getDAO("eshippingInstructionDao");
        }
        return dao;
    }
}
