package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EshippingShipmentDetailsMod implements Serializable{
    private String bookingNo;
    private String contact;
    private String email;
    private String telephone;
    private String fax;
    private String submittedBy;
    private String blNumber;
    private String blType;
    private String additionalEmail;
    private String noOfOriginal;
    private String remarks;
    private String choiceRad;
    private String esiStatusCode;
    private String esiStatusDesc;
    
    public EshippingShipmentDetailsMod(){
        resetMod();
    }
    
    public void resetMod(){
        this.bookingNo = null;
        this.contact = null;
        this.email = null;
        this.telephone = null;
        this.fax = null;
        this.submittedBy = null;
        this.blNumber = null;
        this.blType = "T";
        this.additionalEmail = null;
        this.noOfOriginal = null;
        this.remarks = null;
        this.choiceRad = "1";
        this.esiStatusCode = null;
        this.esiStatusDesc = null;    
    }

    public void setBookingNo(String bookingNo){
        this.bookingNo = bookingNo;
    }

    public String getBookingNo(){
        return bookingNo;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public String getContact(){
        return contact;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setFax(String fax){
        this.fax = fax;
    }

    public String getFax(){
        return fax;
    }

    public void setSubmittedBy(String submittedBy){
        this.submittedBy = submittedBy;
    }

    public String getSubmittedBy(){
        return submittedBy;
    }

    public void setBlNumber(String blNumber){
        this.blNumber = blNumber;
    }

    public String getBlNumber(){
        return blNumber;
    }

    public void setBlType(String blType){
        this.blType = blType;
    }

    public String getBlType(){
        return blType;
    }

    public void setAdditionalEmail(String additionalEmail){
        this.additionalEmail = additionalEmail;
    }

    public String getAdditionalEmail(){
        return additionalEmail;
    }

    public void setNoOfOriginal(String noOfOriginal){
        this.noOfOriginal = noOfOriginal;
    }

    public String getNoOfOriginal(){
        return noOfOriginal;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setChoiceRad(String choiceRad){
        this.choiceRad = choiceRad;
    }

    public String getChoiceRad(){
        return choiceRad;
    }

    public void setEsiStatusCode(String esiStatusCode){
        this.esiStatusCode = esiStatusCode;
    }

    public String getEsiStatusCode(){
        return esiStatusCode;
    }

    public void setEsiStatusDesc(String esiStatusDesc){
        this.esiStatusDesc = esiStatusDesc;
    }

    public String getEsiStatusDesc(){
        return esiStatusDesc;
    }
}
