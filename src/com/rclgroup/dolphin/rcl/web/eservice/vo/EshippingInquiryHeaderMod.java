package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EshippingInquiryHeaderMod implements Serializable{

	private String bookingNo;
    private String status;
	 
    private String sailingDate;
    private String desiredArrivalDate;
     
    private String portOfDischarge;
    private String portOfLoading;
    private String portOfDischargeDess;
    private String portOfLoadingDes;
    
    private String shippingSplStatus;
    
    private String blNumber;
    
    private String confirmDate;
    private String resivedDate;
    private String loadedDate;
    private String onBoardDate;
    
    private String vesseletd;
    private int countContaine;
    
    private String bookingSplFlag;
    
    
	public String getBookingSplFlag() {
		return bookingSplFlag;
	}
	public void setBookingSplFlag(String bookingSplFlag) {
		this.bookingSplFlag = bookingSplFlag;
	}
	public int getCountContaine() {
		return countContaine;
	}
	public void setCountContaine(int countContaine) {
		this.countContaine = countContaine;
	}
	public String getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getResivedDate() {
		return resivedDate;
	}
	public void setResivedDate(String resivedDate) {
		this.resivedDate = resivedDate;
	}
	public String getLoadedDate() {
		return loadedDate;
	}
	public void setLoadedDate(String loadedDate) {
		this.loadedDate = loadedDate;
	}
	public String getOnBoardDate() {
		return onBoardDate;
	}
	public void setOnBoardDate(String onBoardDate) {
		this.onBoardDate = onBoardDate;
	}
	public String getBlNumber() {
		return blNumber;
	}
	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
	}
	public String getShippingSplStatus() {
		return shippingSplStatus;
	}
	public void setShippingSplStatus(String shippingSplStatus) {
		this.shippingSplStatus = shippingSplStatus;
	}
	public String getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSailingDate() {
		return sailingDate;
	}
	public void setSailingDate(String sailingDate) {
		this.sailingDate = sailingDate;
	}
	public String getDesiredArrivalDate() {
		return desiredArrivalDate;
	}
	public void setDesiredArrivalDate(String desiredArrivalDate) {
		this.desiredArrivalDate = desiredArrivalDate;
	}
	public String getPortOfDischarge() {
		return portOfDischarge;
	}
	public void setPortOfDischarge(String portOfDischarge) {
		this.portOfDischarge = portOfDischarge;
	}
	public String getPortOfLoading() {
		return portOfLoading;
	}
	public void setPortOfLoading(String portOfLoading) {
		this.portOfLoading = portOfLoading;
	}
	public String getVesseletd() {
		return vesseletd;
	}
	public void setVesseletd(String vesseletd) {
		this.vesseletd = vesseletd;
	}
	public String getPortOfDischargeDess() {
		return portOfDischargeDess;
	}
	public void setPortOfDischargeDess(String portOfDischargeDess) {
		this.portOfDischargeDess = portOfDischargeDess;
	}
	public String getPortOfLoadingDes() {
		return portOfLoadingDes;
	}
	public void setPortOfLoadingDes(String portOfLoadingDes) {
		this.portOfLoadingDes = portOfLoadingDes;
	}
	@Override
	public String toString() {
		return "EshippingInquiryHeaderMod [bookingNo=" + bookingNo + ", status=" + status + ", sailingDate="
				+ sailingDate + ", desiredArrivalDate=" + desiredArrivalDate + ", portOfDischarge=" + portOfDischarge
				+ ", portOfLoading=" + portOfLoading + "]";
	}
	
    
    
}
