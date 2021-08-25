package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EserviceSearchApiServiceMod {
	
	private String service;
	private String tsValue;
	private String effectivedate;
	private String expireddate;
	private String pot1;
	
	
	public String getPot1() {
		return pot1;
	}
	public void setPot1(String pot1) {
		this.pot1 = pot1;
	}
	public String getEffectivedate() {
		return effectivedate;
	}
	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}
	public String getExpireddate() {
		return expireddate;
	}
	public void setExpireddate(String expireddate) {
		this.expireddate = expireddate;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getTsValue() {
		return tsValue;
	}
	public void setTsValue(String tsValue) {
		this.tsValue = tsValue;
	}

}
