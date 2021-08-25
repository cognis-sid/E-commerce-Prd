package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceRegistrationUserInfoMod implements Serializable{
    private String userId;
    private String userName;
    private String cmpName;
    private String customerCode;
    private String email;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    private String state;
    private String country;
    private String phoneNo;
    private String faxNo;
    private String rejectReason;
    
    public EserviceRegistrationUserInfoMod(){
        this.userId = null;
        this.userName = null;
        this.cmpName = null;
        this.email = null;
        this.address1 = null;
        this.address2 = null;
        this.address3 = null;
        this.address4 = null;
        this.city = null;
        this.state = null;
        this.country = null;
        this.phoneNo = null;
        this.faxNo = null;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    
    public String getUserId(){
        return userId;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setCmpName(String cmpName){
        this.cmpName = cmpName;
    }

    public String getCmpName(){
        return cmpName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setAddress1(String address1){
        this.address1 = address1;
    }

    public String getAddress1(){
        return address1;
    }

    public void setAddress2(String address2){
        this.address2 = address2;
    }

    public String getAddress2(){
        return address2;
    }

    public void setAddress3(String address3){
        this.address3 = address3;
    }

    public String getAddress3(){
        return address3;
    }

    public void setAddress4(String address4){
        this.address4 = address4;
    }

    public String getAddress4(){
        return address4;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setFaxNo(String faxNo){
        this.faxNo = faxNo;
    }

    public String getFaxNo(){
        return faxNo;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getRejectReason() {
        return rejectReason;
    }

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

}
