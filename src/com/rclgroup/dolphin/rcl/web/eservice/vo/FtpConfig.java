package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class FtpConfig {

	private String ip;
	private String userId;
	private String password;
//wrting the xml
	private String bookingIn;
	private String bookingIn_Bkup;
// reading the edit file
	private String bookingOut;
	private String shiipingIn;
	private String shiipingIn_Bkup;
	private String shiipingOut;
	private String outBkup;
	private String urlForSeach;
	private String outBkupForshiiping;
	private String outBkupSI;
	private String fileuploadlocation;
	
	public String getFileuploadlocation() {
		return fileuploadlocation;
	}

	public void setFileuploadlocation(String fileuploadlocation) {
		this.fileuploadlocation = fileuploadlocation;
	}

	public String getOutBkupForshiiping() {
		return outBkupForshiiping;
	}

	public void setOutBkupForshiiping(String outBkupForshiiping) {
		this.outBkupForshiiping = outBkupForshiiping;
	}

	public String getUrlForSeach() {
		return urlForSeach;
	}

	public void setUrlForSeach(String urlForSeach) {
		this.urlForSeach = urlForSeach;
	}

	public String getOutBkup() {
		return outBkup;
	}

	public void setOutBkup(String outBkup) {
		this.outBkup = outBkup;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBookingIn() {
		return bookingIn;
	}

	public void setBookingIn(String bookingIn) {
		this.bookingIn = bookingIn;
	}

	public String getBookingOut() {
		return bookingOut;
	}

	public void setBookingOut(String bookingOut) {
		this.bookingOut = bookingOut;
	}

	public String getShiipingIn() {
		return shiipingIn;
	}

	public void setShiipingIn(String shiipingIn) {
		this.shiipingIn = shiipingIn;
	}

	public String getShiipingOut() {
		return shiipingOut;
	}

	public void setShiipingOut(String shiipingOut) {
		this.shiipingOut = shiipingOut;
	}

	public String getOutBkupSI() {
		return outBkupSI;
	}

	public void setOutBkupSI(String outBkupSI) {
		this.outBkupSI = outBkupSI;
	}

	public String getBookingIn_Bkup() {
		return bookingIn_Bkup;
	}

	public void setBookingIn_Bkup(String bookingIn_Bkup) {
		this.bookingIn_Bkup = bookingIn_Bkup;
	}

	public String getShiipingIn_Bkup() {
		return shiipingIn_Bkup;
	}

	public void setShiipingIn_Bkup(String shiipingIn_Bkup) {
		this.shiipingIn_Bkup = shiipingIn_Bkup;
	}

}
