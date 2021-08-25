package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceBookingListMod implements Serializable
{
    private String bookingDate;
    private String bookingNo;
    private String cocSoc;
    private String bookingType;
    private String pol;
    private String pod;
    private String status;

	public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setCocSoc(String cocSoc) {
        this.cocSoc = cocSoc;
    }

    public String getCocSoc() {
        return cocSoc;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getBookingType() {
        return bookingType;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }
}
