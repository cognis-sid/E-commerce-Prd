/*------------------------------------------------------
EserviceSpecialBkgDetailsMod.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Pratya Thanuchaisak 01/08/14
- Change Log -------------------------------------------
## DD/MM/YY –User- -TaskRef- -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceSpecialBkgDetailsMod implements Serializable{
    private String specialSeq;
    private String specialType;
    private String specialDetails;
    private String specialRecordStatus;
    private String specialSelected;
    
    public EserviceSpecialBkgDetailsMod(){
        this.specialSeq             = "";
        this.specialType            = "";
        this.specialDetails         = "";
        this.specialRecordStatus    = "";
        this.specialSelected        = "";
    }

    public void setSpecialSeq(String specialSeq) {
        this.specialSeq = specialSeq;
    }

    public String getSpecialSeq() {
        return specialSeq;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialDetails(String specialDetails) {
        this.specialDetails = specialDetails;
    }

    public String getSpecialDetails() {
        return specialDetails;
    }

    public void setSpecialRecordStatus(String specialRecordStatus) {
        this.specialRecordStatus = specialRecordStatus;
    }

    public String getSpecialRecordStatus() {
        return specialRecordStatus;
    }

    public void setSpecialSelected(String specialSelected) {
        this.specialSelected = specialSelected;
    }

    public String getSpecialSelected() {
        return specialSelected;
    }
}
