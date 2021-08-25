package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

public class AutoCompleteUim extends PaginationForm {

	private String action;
	
	private String kyePress;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getKyePress() {
		return kyePress;
	}

	public void setKyePress(String kyePress) {
		this.kyePress = kyePress;
	}

	@Override
	public String toString() {
		return "AutoCompleteUim [action=" + action + ", kyePress=" + kyePress + "]";
	}
	
	
	
	
}
