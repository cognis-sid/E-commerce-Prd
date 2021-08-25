package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceRoutingDetailsNewMod implements Serializable {
    private final String BLANK = "";

    private String originCountry;
    private String originCountryDesc;
    private String destinationCountry;
    private String destinationCountryDesc;
    private String placeOfReceipt;
    private String placeOfReceiptDesc;
    private String portOfLoading;
    private String portOfLoadingDesc;
    private String portOfDischarge;
    private String portOfDischargeDesc;
    private String placeOfDelivery;
    private String placeOfDeliveryDesc;
    private String emptyPickupDepot;    
    private String emptyPickupDate;
    private String shipmentDate;
    private String sailingDate;
    private String desiredArrivalDate;
    private String routingPreference;
    
    private Integer seqNo;
    private String from;
    private String to;
    private String etd;
    private String eta;
    private String service;
    private String vessel;
    private String voyage;
    private String transitTime;
    private String loadingTerminalName;
    private String dischargingTerminalName;
    
    public EserviceRoutingDetailsNewMod(){
        resetMod();
    }
    
    public void resetMod(){
        this.originCountry = BLANK;
        this.originCountryDesc = BLANK;
        this.destinationCountry = BLANK;
        this.destinationCountryDesc = BLANK;
        this.placeOfReceipt = BLANK;
        this.placeOfReceiptDesc = BLANK;
        this.portOfLoading = BLANK;
        this.portOfLoadingDesc = BLANK;
        this.portOfDischarge = BLANK;
        this.portOfDischargeDesc = BLANK;
        this.placeOfDelivery = BLANK;
        this.placeOfDeliveryDesc = BLANK;
        this.emptyPickupDepot = BLANK;    
        this.emptyPickupDate = BLANK;
        this.shipmentDate = BLANK;
        this.sailingDate = BLANK;
        this.desiredArrivalDate = BLANK;
        this.routingPreference = BLANK;
    }

    public void setOriginCountry(String originCountry){
        this.originCountry = originCountry;
    }

    public String getOriginCountry(){
        return originCountry;
    }

    public void setDestinationCountry(String destinationCountry){
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCountry(){
        return destinationCountry;
    }

    public void setPlaceOfReceipt(String placeOfReceipt){
        this.placeOfReceipt = placeOfReceipt;
    }

    public String getPlaceOfReceipt(){
        return placeOfReceipt;
    }

    public void setPortOfLoading(String portOfLoading){
        this.portOfLoading = portOfLoading;
    }

    public String getPortOfLoading(){
        return portOfLoading;
    }

    public void setPortOfDischarge(String portOfDischarge){
        this.portOfDischarge = portOfDischarge;
    }

    public String getPortOfDischarge(){
        return portOfDischarge;
    }

    public void setPlaceOfDelivery(String placeOfDelivery){
        this.placeOfDelivery = placeOfDelivery;
    }

    public String getPlaceOfDelivery(){
        return placeOfDelivery;
    }

    public void setEmptyPickupDepot(String emptyPickupDepot){
        this.emptyPickupDepot = emptyPickupDepot;
    }

    public String getEmptyPickupDepot(){
        return emptyPickupDepot;
    }

    public void setEmptyPickupDate(String emptyPickupDate){
        this.emptyPickupDate = emptyPickupDate;
    }

    public String getEmptyPickupDate(){
        return emptyPickupDate;
    }

    public void setShipmentDate(String shipmentDate){
        this.shipmentDate = shipmentDate;
    }

    public String getShipmentDate(){
        return shipmentDate;
    }

    public void setSailingDate(String sailingDate){
        this.sailingDate = sailingDate;
    }

    public String getSailingDate(){
        return sailingDate;
    }

    public void setDesiredArrivalDate(String desiredArrivalDate){
        this.desiredArrivalDate = desiredArrivalDate;
    }

    public String getDesiredArrivalDate(){
        return desiredArrivalDate;
    }

    public void setRoutingPreference(String routingPreference){
        this.routingPreference = routingPreference;
    }

    public String getRoutingPreference(){
        return routingPreference;
    }

    public void setSeqNo(Integer seqNo){
        this.seqNo = seqNo;
    }

    public Integer getSeqNo(){
        return seqNo;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public String getFrom(){
        return from;
    }

    public void setTo(String to){
        this.to = to;
    }

    public String getTo(){
        return to;
    }

    public void setEtd(String etd){
        this.etd = etd;
    }

    public String getEtd(){
        return etd;
    }

    public void setEta(String eta){
        this.eta = eta;
    }

    public String getEta(){
        return eta;
    }

    public void setService(String service){
        this.service = service;
    }

    public String getService(){
        return service;
    }

    public void setVessel(String vessel){
        this.vessel = vessel;
    }

    public String getVessel(){
        return vessel;
    }

    public void setVoyage(String voyage){
        this.voyage = voyage;
    }

    public String getVoyage(){
        return voyage;
    }

    public void setTransitTime(String transitTime){
        this.transitTime = transitTime;
    }

    public String getTransitTime(){
        return transitTime;
    }

    public void setLoadingTerminalName(String loadingTerminalName){
        this.loadingTerminalName = loadingTerminalName;
    }

    public String getLoadingTerminalName(){
        return loadingTerminalName;
    }

    public void setDischargingTerminalName(String dischargingTerminalName){
        this.dischargingTerminalName = dischargingTerminalName;
    }

    public String getDischargingTerminalName(){
        return dischargingTerminalName;
    }

    public void setOriginCountryDesc(String originCountryDesc){
        this.originCountryDesc = originCountryDesc;
    }

    public String getOriginCountryDesc(){
        return originCountryDesc;
    }

    public void setDestinationCountryDesc(String destinationCountryDesc){
        this.destinationCountryDesc = destinationCountryDesc;
    }

    public String getDestinationCountryDesc(){
        return destinationCountryDesc;
    }

    public void setPlaceOfReceiptDesc(String placeOfReceiptDesc){
        this.placeOfReceiptDesc = placeOfReceiptDesc;
    }

    public String getPlaceOfReceiptDesc(){
        return placeOfReceiptDesc;
    }

    public void setPortOfLoadingDesc(String portOfLoadingDesc){
        this.portOfLoadingDesc = portOfLoadingDesc;
    }

    public String getPortOfLoadingDesc(){
        return portOfLoadingDesc;
    }

    public void setPortOfDischargeDesc(String portOfDischargeDesc){
        this.portOfDischargeDesc = portOfDischargeDesc;
    }

    public String getPortOfDischargeDesc(){
        return portOfDischargeDesc;
    }

    public void setPlaceOfDeliveryDesc(String placeOfDeliveryDesc){
        this.placeOfDeliveryDesc = placeOfDeliveryDesc;
    }

    public String getPlaceOfDeliveryDesc(){
        return placeOfDeliveryDesc;
    }
}
