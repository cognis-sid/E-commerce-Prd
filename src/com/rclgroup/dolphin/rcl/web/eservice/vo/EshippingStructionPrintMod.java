package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EshippingStructionPrintMod implements Serializable{
 
 
    public final String COC = "C";
    public final String SOC = "S";
    public final String COC_FULL = "COC";
    public final String SOC_FULL = "SOC";
    
    private String sessionId;
    private String blNo;
    private String shipperName;
    private String pla_of_issue;
    private String office;
    private String blcdtec;
    private String cocsoc;
    private String blstatus;
    private String printed;
    private String userName;
    
    
    
    // for new BKG Report
    
        
        
        private String bkgNo;
        private String shipperCode;
        private String shipperAdd1;
        private String shipperAdd2;
        private String shipperAdd3;
        private String shipperAdd4;
        private String cneeCode;
        private String cneeName;
        private String cneeAdd1;
        private String cneeAdd2;
        private String cneeAdd3;
        private String cneeAdd4;
        private String ntfyCode;
        private String ntfyName;
        private String ntfyAdd1;
        private String ntfyAdd2;
        private String ntfyAdd3;
        private String ntfyAdd4;
        private String vesselName;
        private String voyageNo;
        private String polName;
        private String podName;
        private String plrName;
        private String pldName;
        private String ITEM_NO;
        private String COMM_LVL_MARKS_NO;
        private String COMM_LVL_DESC;
        private String BL_ISSUE_PLACE_NAME;
        private String SHIPPED_ON_BOARD_DATE;
        private String BL_ISSUE_DATE;
        private String ORG_BL_COUNT;
        private String BY_FSC_NAME;

        

        
        
        
        
        
        
    
    public EshippingStructionPrintMod() {
        sessionId = "";
        blNo = "";
        shipperName = "";
        pla_of_issue = "";
        office = "" ;
        blcdtec = "";
        cocsoc = "";
        blstatus = "";
        printed = "";
        userName="";
        
        
           bkgNo ="";
           shipperCode ="";
           shipperAdd1="";
           shipperAdd2="";
           shipperAdd3="";
           shipperAdd4="";
           cneeCode="";
           cneeName="";
           cneeAdd1="";
           cneeAdd2="";
           cneeAdd3="";
           cneeAdd4="";
           ntfyCode="";
           ntfyName="";
           ntfyAdd1="";
           ntfyAdd2="";
           ntfyAdd3="";
           ntfyAdd4="";
           vesselName="";
           voyageNo="";
           polName="";
           podName="";
           plrName="";
           pldName="";
           ITEM_NO="";
           COMM_LVL_MARKS_NO="";
           COMM_LVL_DESC="";
           BL_ISSUE_PLACE_NAME="";
           SHIPPED_ON_BOARD_DATE="";
           BL_ISSUE_DATE="";
           ORG_BL_COUNT="";
           BY_FSC_NAME="";
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    public String getBlNo() {
        return blNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setPla_of_issue(String pla_of_issue) {
        this.pla_of_issue = pla_of_issue;
    }

    public String getPla_of_issue() {
        return pla_of_issue;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setBlcdtec(String blcdtec) {
        this.blcdtec = blcdtec;
    }

    public String getBlcdtec() {
        return blcdtec;
    }

    public void setCocsoc(String cocsoc) {
        this.cocsoc = cocsoc;
        if (this.cocsoc.equals(COC)) {
            this.cocsoc = COC_FULL;
        }else{
            this.cocsoc = SOC_FULL;
        }
    }

    public String getCocsoc() {
        return cocsoc;
    }

    public void setBlstatus(String blstatus) {
        this.blstatus = blstatus;
    }

    public String getBlstatus() {
        return blstatus;
    }

    public void setPrinted(String printed) {
        this.printed = printed;
        if (this.printed .equalsIgnoreCase("A")){
            this.printed = "Printed";
        }else{
            this.printed  = "-";
        }
    }

    public String getPrinted() {
        return printed;
    }


    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    public String getBkgNo() {
        return bkgNo;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperAdd1(String shipperAdd1) {
        this.shipperAdd1 = shipperAdd1;
    }

    public String getShipperAdd1() {
        return shipperAdd1;
    }

    public void setShipperAdd2(String shipperAdd2) {
        this.shipperAdd2 = shipperAdd2;
    }

    public String getShipperAdd2() {
        return shipperAdd2;
    }

    public void setShipperAdd3(String shipperAdd3) {
        this.shipperAdd3 = shipperAdd3;
    }

    public String getShipperAdd3() {
        return shipperAdd3;
    }

    public void setShipperAdd4(String shipperAdd4) {
        this.shipperAdd4 = shipperAdd4;
    }

    public String getShipperAdd4() {
        return shipperAdd4;
    }

    public void setCneeCode(String cneeCode) {
        this.cneeCode = cneeCode;
    }

    public String getCneeCode() {
        return cneeCode;
    }

    public void setCneeName(String cneeName) {
        this.cneeName = cneeName;
    }

    public String getCneeName() {
        return cneeName;
    }

    public void setCneeAdd1(String cneeAdd1) {
        this.cneeAdd1 = cneeAdd1;
    }

    public String getCneeAdd1() {
        return cneeAdd1;
    }

    public void setCneeAdd2(String cneeAdd2) {
        this.cneeAdd2 = cneeAdd2;
    }

    public String getCneeAdd2() {
        return cneeAdd2;
    }

    public void setCneeAdd3(String cneeAdd3) {
        this.cneeAdd3 = cneeAdd3;
    }

    public String getCneeAdd3() {
        return cneeAdd3;
    }

    public void setCneeAdd4(String cneeAdd4) {
        this.cneeAdd4 = cneeAdd4;
    }

    public String getCneeAdd4() {
        return cneeAdd4;
    }

    public void setNtfyCode(String ntfyCode) {
        this.ntfyCode = ntfyCode;
    }

    public String getNtfyCode() {
        return ntfyCode;
    }

    public void setNtfyName(String ntfyName) {
        this.ntfyName = ntfyName;
    }

    public String getNtfyName() {
        return ntfyName;
    }

    public void setNtfyAdd1(String ntfyAdd1) {
        this.ntfyAdd1 = ntfyAdd1;
    }

    public String getNtfyAdd1() {
        return ntfyAdd1;
    }

    public void setNtfyAdd2(String ntfyAdd2) {
        this.ntfyAdd2 = ntfyAdd2;
    }

    public String getNtfyAdd2() {
        return ntfyAdd2;
    }

    public void setNtfyAdd3(String ntfyAdd3) {
        this.ntfyAdd3 = ntfyAdd3;
    }

    public String getNtfyAdd3() {
        return ntfyAdd3;
    }

    public void setNtfyAdd4(String ntfyAdd4) {
        this.ntfyAdd4 = ntfyAdd4;
    }

    public String getNtfyAdd4() {
        return ntfyAdd4;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVoyageNo(String voyageNo) {
        this.voyageNo = voyageNo;
    }

    public String getVoyageNo() {
        return voyageNo;
    }

    public void setPolName(String polName) {
        this.polName = polName;
    }

    public String getPolName() {
        return polName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getPodName() {
        return podName;
    }

    public void setPlrName(String plrName) {
        this.plrName = plrName;
    }

    public String getPlrName() {
        return plrName;
    }

    public void setPldName(String pldName) {
        this.pldName = pldName;
    }

    public String getPldName() {
        return pldName;
    }

    public void setITEM_NO(String iTEM_NO) {
        this.ITEM_NO = iTEM_NO;
    }

    public String getITEM_NO() {
        return ITEM_NO;
    }

    public void setCOMM_LVL_MARKS_NO(String cOMM_LVL_MARKS_NO) {
        this.COMM_LVL_MARKS_NO = cOMM_LVL_MARKS_NO;
    }

    public String getCOMM_LVL_MARKS_NO() {
        return COMM_LVL_MARKS_NO;
    }

    public void setCOMM_LVL_DESC(String cOMM_LVL_DESC) {
        this.COMM_LVL_DESC = cOMM_LVL_DESC;
    }

    public String getCOMM_LVL_DESC() {
        return COMM_LVL_DESC;
    }

    public void setBL_ISSUE_PLACE_NAME(String bL_ISSUE_PLACE_NAME) {
        this.BL_ISSUE_PLACE_NAME = bL_ISSUE_PLACE_NAME;
    }

    public String getBL_ISSUE_PLACE_NAME() {
        return BL_ISSUE_PLACE_NAME;
    }

    public void setSHIPPED_ON_BOARD_DATE(String sHIPPED_ON_BOARD_DATE) {
        this.SHIPPED_ON_BOARD_DATE = sHIPPED_ON_BOARD_DATE;
    }

    public String getSHIPPED_ON_BOARD_DATE() {
        return SHIPPED_ON_BOARD_DATE;
    }

    public void setBL_ISSUE_DATE(String bL_ISSUE_DATE) {
        this.BL_ISSUE_DATE = bL_ISSUE_DATE;
    }

    public String getBL_ISSUE_DATE() {
        return BL_ISSUE_DATE;
    }

    public void setORG_BL_COUNT(String oRG_BL_COUNT) {
        this.ORG_BL_COUNT = oRG_BL_COUNT;
    }

    public String getORG_BL_COUNT() {
        return ORG_BL_COUNT;
    }

    public void setBY_FSC_NAME(String bY_FSC_NAME) {
        this.BY_FSC_NAME = bY_FSC_NAME;
    }

    public String getBY_FSC_NAME() {
        return BY_FSC_NAME;
    }
}
