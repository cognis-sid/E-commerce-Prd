package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceCustomerPopupMod implements Serializable{
    private String rownum;
    private String customerCode;
    private String description;
    private String address;
    private String cityName;
    private String stateCode;
    private String stateName;
    private String zipCode;
    private String telephone;
    private String faxNo;
    private String email;
    private String countryCode;
    private String countryName;
    private String consolidated;
    private String fscCode;
    private String customerType;

    public EserviceCustomerPopupMod(){

    }

    public String getRownum(){
        return rownum;
    }

    public void setRownum(String rownum){
        this.rownum = rownum;
    }

    public String getCustomerCode(){
        return customerCode;
    }

    public void setCustomerCode(String customerCode){
        this.customerCode = customerCode;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCityName(){
        return cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public String getStateCode(){
        return stateCode;
    }

    public void setStateCode(String stateCode){
        this.stateCode = stateCode;
    }

    public String getStateName(){
        return stateName;
    }

    public void setStateName(String stateName){
        this.stateName = stateName;
    }

    public String getZipCode(){
        return zipCode;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public String getFaxNo(){
        return faxNo;
    }

    public void setFaxNo(String faxNo){
        this.faxNo = faxNo;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }

    public String getCountryName(){
        return countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public String getConsolidated(){
        return consolidated;
    }

    public void setConsolidated(String consolidated){
        this.consolidated = consolidated;
    }


    public void setFscCode(String fscCode){
        this.fscCode = fscCode;
    }

    public String getFscCode(){
        return fscCode;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }
}
