package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.util.List;

import com.niit.control.web.actionform.PaginationForm;

public class InternalUserMod extends PaginationForm {

	private String loginId;
	private String oldPassword;
	private String password;
	private String rePassword;
	private String status;
	private String currPageAction;
	private String email;
	
	private Boolean loginStatus=false; 

	private String dbPasword="";
	private String errorMessage;

	private String userName;
    private String[] location;
    private String phoneNo;
    private String faxNo;
    private String companyName;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    private String state;
    private String country;
    private String msg;
    
    private List <EserviceContractPartyPortPairMod> contractPartyList;
    private String customerCode;
    private String customerFscCode;
    private String customerType;
    private String representedCompanyFlag;
    private String maxPkPortPairSeq;
    private String portPairFlag;   
    
    private List<ContryMod> contryList;

    
    
	public String getPortPairFlag() {
		return portPairFlag;
	}

	public void setPortPairFlag(String portPairFlag) {
		this.portPairFlag = portPairFlag;
	}

	public String getRepresentedCompanyFlag() {
		return representedCompanyFlag;
	}

	public void setRepresentedCompanyFlag(String representedCompanyFlag) {
		this.representedCompanyFlag = representedCompanyFlag;
	}

	public String getMaxPkPortPairSeq() {
		return maxPkPortPairSeq;
	}

	public void setMaxPkPortPairSeq(String maxPkPortPairSeq) {
		this.maxPkPortPairSeq = maxPkPortPairSeq;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerFscCode() {
		return customerFscCode;
	}

	public void setCustomerFscCode(String customerFscCode) {
		this.customerFscCode = customerFscCode;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getDbPasword() {
		return dbPasword;
	}

	public void setDbPasword(String dbPasword) {
		this.dbPasword = dbPasword;
	}

	public String getCurrPageAction() {
		return currPageAction;
	}

	public void setCurrPageAction(String currPageAction) {
		this.currPageAction = currPageAction;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<EserviceContractPartyPortPairMod> getContractPartyList() {
		return contractPartyList;
	}

	public void setContractPartyList(List<EserviceContractPartyPortPairMod> contractPartyList) {
		this.contractPartyList = contractPartyList;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String[] getLocation() {
		return location;
	}

	public void setLocation(String[] location) {
		this.location = location;
	}

	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	
	public List<ContryMod> getContryList() {
		return contryList;
	}

	public void setContryList(List<ContryMod> contryList) {
		this.contryList = contryList;
	}

	@Override
	public String toString() {
		return "InternalUserMod [loginId=" + loginId + ", password=" + password + ", status=" + status + ", currPageAction="
				+ currPageAction + ", email=" + email + ", loginStatus=" + loginStatus + ", dbPasword=" + dbPasword
				+ ", errorMessage=" + errorMessage + ", userName=" + userName + ", location=" + location
				+ ", phoneNo=" + phoneNo + ", faxNo=" + faxNo + ", companyName=" + companyName + ", address1="
				+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", address4=" + address4 + ", city="
				+ city + ", state=" + state + ", country=" + country + ", contryList=" + contryList + "]";
	}
}
