package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.AdminBookingLogUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AdminBookingFileLogMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AdminBookingLogMod;

public interface AdminBookingLogDao {
	
	// This for File type
	public final String XML_FILE_BOOKING ="Booking Submit XML";	
	public final String EDI_FILE_BOOKING ="Booking EDI";
	public final String XML_FILE_SI ="Si Submit XML";
	public final String EDI_FILE_SI ="Si EDI";
	
	
	public final String DAO_NAME="AdminBookingLogDao";
	
	public final String DAO_BOOKING_CREATION = "Booking Creation";
	public final String DAO_BOOKING_CREATION_ERROR = "Booking Creation Error";
	
	public final String DAO_BOOKING_SUBMIT = "Booking Submit";
	public final String DAO_BOOKING_SUBMIT_XML = "Booking Submit XML Error";
	public final String DAO_BOOKING_CANCEL_XML = "Booking Cancel XML Error";
	
	public final String DAO_BOOKING_CONFIRMED = "Booking Confirmed";
	public final String DAO_BOOKING_EDIT ="Booking Edit";
	public final String DAO_BOOKING_CANCEL ="Booking Cancel";
	
	public final String DAO_BOOKING_CONFIRMED_ERROR = "Booking Confirmed Error";
	public final String DAO_BOOKING_EDIT_ERROR = "Booking Edit Error";
	public final String DAO_BOOKING_CANCEL_ERROR = "Booking Cancel Error";
	
	public final String DAO_BOOKING_UPDATE = "Booking Update";
	
	public final String DAO_SI_SUBMIT = "SI Submit";
	public final String DAO_SI_SUBMIT_ERROR = "SI Submit Error";
	public final String DAO_SI_SUBMIT_XML = "SI Submit XML Error";
	
	public final String DAO_SI_CONFIRMED = "SI Confirmed";
	public final String DAO_SI_CANCELED = "SI Canceled";
	public final String DAO_SI_CONFIRMED_ERROR = "SI Confirmed Error";
	public final String DAO_SI_CANCELED_ERROR = "SI Canceled Error";
	
	public final String DAO_SI_SAVE = "SI Save";
	public final String DAO_SI_SAVE_ERROR = "SI Save Error";
	
	
	public static final String SAVE_BOOKING="saveBooking";
	public static final String SAVE_BOOKING_ERROR="Save Booking Error";
	
	public List<AdminBookingLogMod> getBookingLog(AdminBookingLogUim uim);
	
	public void insertLogInLogTable(EserviceNewWebBookingUim form, Exception e,String errorType);
	
	 
	public void insertLogInLogTableBooking(String bookingNumber, String bookingNumberOld, Exception e1,String string);

	public void insertLogInLogSiTable(String bookingNumberForSI, String bLNum,String userId ,Exception e1, String errorType);
	
	public void setEdiFileName(String ediFileName);

	public List<AdminBookingFileLogMod> getBookingFileLog(AdminBookingLogUim form);
}
