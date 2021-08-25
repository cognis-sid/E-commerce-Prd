package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionPrintDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EReportServerConfigMod;

public class EvgmDeclarationPDFReportUim extends PaginationForm{
    
    
    private String bookingNo;
    private String vessel;
    private String voyage;
    private String shipperName;
    private String respresentName;
    private String authorizePerson;
    private String submissionDate;
    private String displayVesslVoy;
    private String reportUrl;
    private String reportFormat;
    private String pageAction;
    private String errMsg;
    
    public static final String REPORT_FORMAT_PDF = "PDF";
    
    public EvgmDeclarationPDFReportUim() {
        
        this.bookingNo = "";
        this.vessel= "";
        this.voyage= "";
        this.shipperName= "";
        this.respresentName= "";
        this.authorizePerson= "";
        this.submissionDate= "";
        this.displayVesslVoy = "";
        
        this.reportUrl = "";
        
    }
    
    public String getReportUrlConstant(EshippingInstructionPrintDao objDao) {
        EReportServerConfigMod reportServerConfigMod = objDao.getDefaultReportServerConfigMod();
        String reportUrlConstant = "http://"+reportServerConfigMod.getServerName()+":"+reportServerConfigMod.getPortNumber()+"/reports/rwservlet?rclrepenv&report=";
        return reportUrlConstant;
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

    public void setAuthorizePerson(String authorizePerson) {
        this.authorizePerson = authorizePerson;
    }

    public String getAuthorizePerson() {
        return authorizePerson;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setDisplayVesslVoy(String displayVesslVoy) {
        this.displayVesslVoy = displayVesslVoy;
    }

    public String getDisplayVesslVoy() {
        return displayVesslVoy;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public String getReportFormat() {
        return reportFormat;
    }

    public void setPageAction(String pageAction) {
        this.pageAction = pageAction;
    }

    public String getPageAction() {
        return pageAction;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
