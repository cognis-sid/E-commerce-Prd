package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EserviceCustRegistReqMod{

    private String companyName      = null;
    private String country          = null;
    private String city             = null;
    private String userId           = null;
    private String userName         = null;
    private String addDate          = null;
    private String addTime          = null;
    private String addDateTime      = null;
    private String countryName      = null;
    private String portPairFlag     = null;
    
    public EserviceCustRegistReqMod(){
        this.companyName      = "";
        this.country          = "";
        this.city             = "";
        this.userId           = "";
        this.userName         = "";
        this.addDate          = "";
        this.addTime          = "";
        this.addDateTime      = "";
        this.countryName      = "";
        this.portPairFlag     = "N";
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getAddDate(){
        return addDate;
    }

    public void setAddDate(String addDate){
        this.addDate = addDate;
    }

    public String getAddTime(){
        return addTime;
    }

    public void setAddTime(String addTime){
        this.addTime = addTime;
    }

    public String getAddDateTime(){
        return addDateTime;
    }

    public void setAddDateTime(String addDateTime){
        this.addDateTime = addDateTime;
    }
    
    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public String getCountryName(){
        return countryName;
    }

    public void setPortPairFlag(String portPairFlag) {
        this.portPairFlag = portPairFlag;
    }

    public String getPortPairFlag() {
        return portPairFlag;
    }
}
