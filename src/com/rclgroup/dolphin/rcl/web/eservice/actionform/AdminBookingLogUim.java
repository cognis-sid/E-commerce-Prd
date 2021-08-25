package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

public class AdminBookingLogUim  extends PaginationForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String currPageAction;
	private String bookingNo;
	private String submitDate;
	private String confirmDate;
	private String bLNo;
	private String bookingRef;
	
	private String userId;
	private String siSubmitDate;
	
	private String id;
	private String cancelDate;
	
	private String errorType;
	
	
	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getbLNo() {
		return bLNo;
	}

	public void setbLNo(String bLNo) {
		this.bLNo = bLNo;
	}

	public String getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}

	 

	public String getCurrPageAction() {
		return currPageAction;
	}

	public void setCurrPageAction(String currPageAction) {
		this.currPageAction = currPageAction;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSiSubmitDate() {
		return siSubmitDate;
	}

	public void setSiSubmitDate(String siSubmitDate) {
		this.siSubmitDate = siSubmitDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
