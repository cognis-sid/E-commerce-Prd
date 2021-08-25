 /*------------------------------------------------------
  EservicePreviewUploadedDocMod.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 08/08/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EservicePreviewUploadedDocMod{
    
    private String          fileName;
    private String          newFileName;
    private String          pkUploadDtlSeq;
    private String          uploadSeqNo;
    private String          module;
    private String          recAddUser;
    private String          recAddDate;
    private String          bookingNo;
    private String          bookingDate;
    private String          bookingBy;
    
    public EservicePreviewUploadedDocMod(){
        this.fileName           = "";
        this.newFileName        = "";
        this.pkUploadDtlSeq     = "";
        this.uploadSeqNo        = "";
        this.module             = "";
        this.recAddUser         = "";
        this.recAddDate         = "";
        this.bookingNo          = "";
        this.bookingDate        = "";
        this.bookingBy          = "";
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setPkUploadDtlSeq(String pkUploadDtlSeq) {
        this.pkUploadDtlSeq = pkUploadDtlSeq;
    }

    public String getPkUploadDtlSeq() {
        return pkUploadDtlSeq;
    }

    public void setUploadSeqNo(String uploadSeqNo) {
        this.uploadSeqNo = uploadSeqNo;
    }

    public String getUploadSeqNo() {
        return uploadSeqNo;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    public void setRecAddUser(String recAddUser) {
        this.recAddUser = recAddUser;
    }

    public String getRecAddUser() {
        return recAddUser;
    }

    public void setRecAddDate(String recAddDate) {
        this.recAddDate = recAddDate;
    }

    public String getRecAddDate() {
        return recAddDate;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingBy(String bookingBy) {
        this.bookingBy = bookingBy;
    }

    public String getBookingBy() {
        return bookingBy;
    }
}
