package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EshippingCustomerDetailsMod implements Serializable
{
    private String customerCode;
    private String customerName;
    private String customerNameRe;
    private String countryCode;
    private String countryName;
    private String cocSoc;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
        
    public EshippingCustomerDetailsMod() 
    {
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress4() {
        return address4;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCocSoc(String cocSoc) {
        this.cocSoc = cocSoc;
    }

    public String getCocSoc() {
        return cocSoc;
    }

    public void setCustomerNameRe(String customerNameRe) {
        this.customerNameRe = customerNameRe;
    }

    public String getCustomerNameRe() {
        return customerNameRe;
    }
}
