package com.rclgroup.dolphin.rcl.web.getRate.vo;

import java.util.List;

import com.rclgroup.dolphin.rcl.web.getRate.actionForm.ContainerUim;

public class QuotationData {

	private UserData userData=new UserData();
	private QtnData qtnData=new QtnData();
	
	
	public UserData getUserData() {
		return userData;
	}
	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	public QtnData getQtnData() {
		return qtnData;
	}
	public void setQtnData(QtnData qtnData) {
		this.qtnData = qtnData;
	}
	public QuotationData() {
		// TODO Auto-generated constructor stub
	}
	public QuotationData(UserData userData, QtnData qtnData) {
		super();
		this.userData = userData;
		this.qtnData = qtnData;
	}
	@Override
	public String toString() {
		return "QuotationData [userData=" + userData + ", qtnData=" + qtnData + "]";
	}
	
	
}
