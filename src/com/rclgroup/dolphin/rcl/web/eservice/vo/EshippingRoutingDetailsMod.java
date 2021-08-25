package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EshippingRoutingDetailsMod{ 
    private String placeDateOfIssue;
    private String pol;
    private String pod;
    private String placeOfReceipt;
    private String placeOfDelivery;
    private String vessel;
    private String voyageNo;
    private String shippedOnBoardDate;
    private String podCountry;    
    private String fsc;
    
    
    public EshippingRoutingDetailsMod(){
        this.placeDateOfIssue = null;
        this.pol = null;
        this.pod = null;
        this.placeOfReceipt = null;
        this.placeOfDelivery = null; 
        this.vessel = null;
        this.voyageNo = null;    
        this.shippedOnBoardDate = null;
        this.podCountry = null;    
        this.fsc = null;
    }

    public void setPlaceDateOfIssue(String placeDateOfIssue){
        this.placeDateOfIssue = placeDateOfIssue;
    }

    public String getPlaceDateOfIssue(){
        return placeDateOfIssue;
    }

    public void setPol(String pol){
        this.pol = pol;
    }

    public String getPol(){
        return pol;
    }

    public void setPod(String pod){
        this.pod = pod;
    }

    public String getPod(){
        return pod;
    }

    public void setPlaceOfReceipt(String placeOfReceipt){
        this.placeOfReceipt = placeOfReceipt;
    }

    public String getPlaceOfReceipt(){
        return placeOfReceipt;
    }

    public void setPlaceOfDelivery(String placeOfDelivery){
        this.placeOfDelivery = placeOfDelivery;
    }

    public String getPlaceOfDelivery(){
        return placeOfDelivery;
    }

    public void setVessel(String vessel){
        this.vessel = vessel;
    }

    public String getVessel(){
        return vessel;
    }

    public void setVoyageNo(String voyageNo){
        this.voyageNo = voyageNo;
    }

    public String getVoyageNo(){
        return voyageNo;
    }

    public void setShippedOnBoardDate(String shippedOnBoardDate){
        this.shippedOnBoardDate = shippedOnBoardDate;
    }

    public String getShippedOnBoardDate(){
        return shippedOnBoardDate;
    }

    public void setPodCountry(String podCountry){
        this.podCountry = podCountry;
    }

    public String getPodCountry(){
        return podCountry;
    }

    public void setFsc(String fsc){
        this.fsc = fsc;
    }

    public String getFsc(){
        return fsc;
    }
}
