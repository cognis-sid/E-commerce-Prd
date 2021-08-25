package com.rclgroup.dolphin.rcl.web.getRate.vo;

public class UserData {

	private String userToken;

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public UserData() {
		// TODO Auto-generated constructor stub
	}

	public UserData(String userToken) {
		super();
		this.userToken = userToken;
	}

	@Override
	public String toString() {
		return "UserData [userToken=" + userToken + "]";
	}
	
	
	
}
