package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceInquieyHeaderMod implements Serializable{

	private String bookingNo;
    private String status;
	private String etd;
    private String sailingDate;
    private String desiredArrivalDate;
    private String bookingReferenceNo;
    private String portOfDischarge;
    private String podName;
    private String portOfLoading;
    private String polName;
    private String shippingSplFalg;
    private String bookingSplFlag;
    private String templateName;
    private String vesselEtd;
    private String repCompName;
    private String confirmDate;
    private String resivedDate;
    private String loadedDate;
    private String onBoardDate;
    private int countContaine;
    private String podNameDes;
    private String polNameDes;
    
    
	public String getPodNameDes() {
		return podNameDes;
	}
	public void setPodNameDes(String podNameDes) {
		this.podNameDes = podNameDes;
	}
	public String getPolNameDes() {
		return polNameDes;
	}
	public void setPolNameDes(String polNameDes) {
		this.polNameDes = polNameDes;
	}
	public String getPodName() {
		return podName;
	}
	public void setPodName(String podName) {
		this.podName = podName;
	}
	public String getPolName() {
		return polName;
	}
	public void setPolName(String polName) {
		this.polName = polName;
	}
	public String getRepCompName() {
		return repCompName;
	}
	public void setRepCompName(String repCompName) {
		this.repCompName = repCompName;
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
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getShippingSplFalg() {
		return shippingSplFalg;
	}
	public void setShippingSplFalg(String shippingSplFalg) {
		this.shippingSplFalg = shippingSplFalg;
	}
	public String getBookingSplFlag() {
		return bookingSplFlag;
	}
	public void setBookingSplFlag(String bookingSplFlag) {
		this.bookingSplFlag = bookingSplFlag;
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
	public String getEtd() {
		return etd;
	}
	public void setEtd(String etd) {
		this.etd = etd;
	}
	public String getBookingReferenceNo() {
		return bookingReferenceNo;
	}
	public void setBookingReferenceNo(String bookingReferenceNo) {
		this.bookingReferenceNo = bookingReferenceNo;
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
	public String getVesselEtd() {
		return vesselEtd;
	}
	public void setVesselEtd(String vesselEtd) {
		this.vesselEtd = vesselEtd;
	}
	
	@Override
	public String toString() {
		return "EserviceInquieyHeaderMod [bookingNo=" + bookingNo + ", status=" + status + ", etd=" + etd
				+ ", sailingDate=" + sailingDate + ", desiredArrivalDate=" + desiredArrivalDate
				+ ", bookingReferenceNo=" + bookingReferenceNo + ", portOfDischarge=" + portOfDischarge
				+ ", portOfLoading=" + portOfLoading + ", shippingSplFalg=" + shippingSplFalg + ", bookingSplFlag="
				+ bookingSplFlag + ", templateName=" + templateName + ", vesselEtd=" + vesselEtd + "]";
	}
	
}
