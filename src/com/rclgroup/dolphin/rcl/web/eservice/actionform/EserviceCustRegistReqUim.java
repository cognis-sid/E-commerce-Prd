package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import java.util.List;

import com.niit.control.web.actionform.PaginationForm;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustRegistReqDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCustRegistReqMod;

public class EserviceCustRegistReqUim extends PaginationForm{
    private String fscCode;
    private String companyName;
    private String country;
    private String city;
    private String userName;
    private String addDateTime;
    
    private List<EserviceCustRegistReqMod> custRegistReqList;

    private String errMsg;
    private String currPageAction;
    private String prevPageAction;

    public EserviceCustRegistReqUim(){
        resetForm();
    }
    
    public void resetForm(){
        this.fscCode = null;
        this.companyName = null;
        this.country = null;
        this.city = null;
        this.userName = null;
        this.addDateTime = null;
        this.custRegistReqList = null;
        
        this.errMsg = null;
        this.currPageAction = null;
        this.prevPageAction = null;
    }

    public String getFscCode(){
        return fscCode;
    }

    public void setFscCode(String fscCode){
        this.fscCode = fscCode;
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

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getAddDateTime(){
        return addDateTime;
    }

    public void setAddDateTime(String addDateTime){
        this.addDateTime = addDateTime;
    }

    public List<EserviceCustRegistReqMod> getCustRegistReqList(){
        return custRegistReqList;
    }

    public void setCustRegistReqList(List<EserviceCustRegistReqMod> custRegistReqList){
        this.custRegistReqList = custRegistReqList;
    }

    public void setCurrPageAction(String currPageAction){
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction(){
        return currPageAction;
    }

    public void setPrevPageAction(String prevPageAction){
        this.prevPageAction = prevPageAction;
    }

    public String getPrevPageAction(){
        return prevPageAction;
    }

    public void setErrMsg(String errMsg){
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }
}
