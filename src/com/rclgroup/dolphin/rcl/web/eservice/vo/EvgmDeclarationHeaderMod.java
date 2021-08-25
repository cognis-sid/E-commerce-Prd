package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EvgmDeclarationHeaderMod implements Serializable{
    
    private String hdrSeq;
    private String bookingNo;
    private String vessel;
    private String voyage;
    private String vesselVoy;
    private String shipperName;
    private String respresentName;
    private String authName;
    private String submissionDate;
    
    public EvgmDeclarationHeaderMod() {
    }

    public void setHdrSeq(String hdrSeq) {
        this.hdrSeq = hdrSeq;
    }

    public String getHdrSeq() {
        return hdrSeq;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public String getVoyage() {
        return voyage;
    }

    public void setVesselVoy(String vesselVoy) {
        this.vesselVoy = vesselVoy;
    }

    public String getVesselVoy() {
        return vesselVoy;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setRespresentName(String respresentName) {
        this.respresentName = respresentName;
    }

    public String getRespresentName() {
        return respresentName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthName() {
        return authName;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }
}
