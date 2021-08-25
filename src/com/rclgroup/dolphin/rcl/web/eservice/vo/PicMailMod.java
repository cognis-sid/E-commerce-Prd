package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class PicMailMod {

	private String mail;
	private String mailType;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMailType() {
		return mailType;
	}
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	@Override
	public String toString() {
		return "PicMailMod [mail=" + mail + ", mailType=" + mailType + "]";
	}
	
}
