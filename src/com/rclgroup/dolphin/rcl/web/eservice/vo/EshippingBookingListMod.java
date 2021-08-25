package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EshippingBookingListMod implements Serializable {
    private String bookingDate;
    private String bookingNo;
    private String legVessel;
    private String legVoyage;
    private String pol;
    private String pod;
    private String polNo;
    private String podNo;
    private String blNo;
    private String cocSoc;
    private String shipperName;
    private String esiStatusCode;
    private String esiStatusDesc;

    public String getPolNo() {
		return polNo;
	}

	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}

	public String getPodNo() {
		return podNo;
	}

	public void setPodNo(String podNo) {
		this.podNo = podNo;
	}

	public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getPol() {
        return pol;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getPod() {
        return pod;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    public String getBlNo() {
        return blNo;
    }

    public void setLegVessel(String legVessel) {
        this.legVessel = legVessel;
    }

    public String getLegVessel() {
        return legVessel;
    }

    public void setLegVoyage(String legVoyage) {
        this.legVoyage = legVoyage;
    }

    public String getLegVoyage() {
        return legVoyage;
    }

    public void setCocSoc(String cocSoc) {
        this.cocSoc = cocSoc;
    }

    public String getCocSoc() {
        return cocSoc;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperName() {
        return shipperName;
    }
    
    public void setEsiStatusCode(String esiStatusCode) {
        this.esiStatusCode = esiStatusCode;
    }

    public String getEsiStatusCode() {
        return esiStatusCode;
    }

    public void setEsiStatusDesc(String esiStatusDesc) {
        this.esiStatusDesc = esiStatusDesc;
    }

    public String getEsiStatusDesc() {
        return esiStatusDesc;
    }
}
