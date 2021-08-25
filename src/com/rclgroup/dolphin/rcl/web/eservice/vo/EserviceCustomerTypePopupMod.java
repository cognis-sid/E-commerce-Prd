package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EserviceCustomerTypePopupMod{
    private String customerType;
    private String description;
    private String organizationType;
    private String status;
    
    public EserviceCustomerTypePopupMod(){
        this.customerType = null;
        this.description = null;
        this.organizationType = null;
        this.status = null;
    }

    public void setCustomerType(String customerType){
        this.customerType = customerType;
    }

    public String getCustomerType(){
        return customerType;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setOrganizationType(String organizationType){
        this.organizationType = organizationType;
    }

    public String getOrganizationType(){
        return organizationType;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
