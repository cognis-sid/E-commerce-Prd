/*------------------------------------------------------
EshippingCommodityDetailsMod.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Tanaphol Lhimmanee 23/08/13
- Change Log -------------------------------------------
## DD/MM/YY      –User-             -TaskRef-       -ShortDescription-
## 10/09/2014    PRATYA             01              PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EshippingCommodityDetailsMod implements Serializable{
    private String mode;

    private String  strCommGroup;
    private String  strCommCode;
    private String  strCommDesc;
    private String  strCommGroupCode;
    private Integer intCommGroupSeqNo;
    private String  radCommodity;
    private String  strCommWeight;
    private String  specialCargo;
    private String  specialInstruction;
    private String  recordStatus;
    private String  isSelected;
    private String  strCommOfPackages;
    private String  strCommPackageKindCode;
    private String  strCommPackageKindName;
    private String  strCommMeasurement;
    private boolean deleted;
    /*Begin @01*/
    private String marksAndNumbers;
    private String description;
    private String strCommodityForMark;
    private String containerNoToCargo;
    private String comBookingNo;
    private String comSeqNo;
    /*End @01*/
    
    /*Begin @01*/
    public EshippingCommodityDetailsMod(){
        
        this.strCommGroup               = "";
        this.strCommCode                = "";
        this.strCommDesc                = "";
        this.strCommGroupCode           = "";
        this.intCommGroupSeqNo          = 0;
        this.radCommodity               = "";
        this.strCommWeight              = "0.000";
        this.specialCargo               = "";
        this.specialInstruction         = "";
        this.isSelected                 = "N";
        this.strCommOfPackages          = "0";
        this.strCommPackageKindCode     = "";
        this.strCommPackageKindName     = "";
        this.strCommMeasurement         = "0.0000";
        this.marksAndNumbers            = "";
        this.description                = "";
        this.deleted                    = false;
        this.strCommodityForMark        = "";
        this.containerNoToCargo         = "";
        this.comBookingNo               = "";
        this.comSeqNo                   = "0";
        this.recordStatus               = "";
    }
    /*End @01*/

    public void setStrCommGroup(String strCommGroup) {
        this.strCommGroup = strCommGroup;
    }

    public String getStrCommGroup() {
        return strCommGroup;
    }

    public void setStrCommCode(String strCommCode) {
        this.strCommCode = strCommCode;
    }

    public String getStrCommCode() {
        return strCommCode;
    }

    public void setStrCommDesc(String strCommDesc) {
        this.strCommDesc = strCommDesc;
    }

    public String getStrCommDesc() {
        return strCommDesc;
    }

    public void setStrCommGroupCode(String strCommGroupCode) {
        this.strCommGroupCode = strCommGroupCode;
    }

    public String getStrCommGroupCode() {
        return strCommGroupCode;
    }

    public void setIntCommGroupSeqNo(Integer intCommGroupSeqNo) {
        this.intCommGroupSeqNo = intCommGroupSeqNo;
    }

    public Integer getIntCommGroupSeqNo() {
        return intCommGroupSeqNo;
    }

    public void setRadCommodity(String radCommodity) {
        this.radCommodity = radCommodity;
    }

    public String getRadCommodity() {
        return radCommodity;
    }

    public void setSpecialCargo(String specialCargo) {
        this.specialCargo = specialCargo;
    }

    public String getSpecialCargo() {
        return specialCargo;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    public String getIsSelected() {
        return isSelected;
    }


    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setStrCommOfPackages(String strCommOfPackages){
        this.strCommOfPackages = strCommOfPackages;
    }

    public String getStrCommOfPackages(){
        return strCommOfPackages;
    }

    public void setStrCommPackageKindCode(String strCommPackageKindCode){
        this.strCommPackageKindCode = strCommPackageKindCode;
    }

    public String getStrCommPackageKindCode(){
        return strCommPackageKindCode;
    }

    public void setStrCommPackageKindName(String strCommPackageKindName){
        this.strCommPackageKindName = strCommPackageKindName;
    }

    public String getStrCommPackageKindName(){
        return strCommPackageKindName;
    }

    public void setStrCommWeight(String strCommWeight){
        this.strCommWeight = strCommWeight;
    }

    public String getStrCommWeight(){
        return strCommWeight;
    }

    public void setStrCommMeasurement(String strCommMeasurement){
        this.strCommMeasurement = strCommMeasurement;
    }

    public String getStrCommMeasurement(){
        return strCommMeasurement;
    }

    public void setMode(String mode){
        this.mode = mode;
    }

    public String getMode(){
        return mode;
    }

    public void setMarksAndNumbers(String marksAndNumbers) {
        this.marksAndNumbers = marksAndNumbers;
    }

    public String getMarksAndNumbers() {
        return marksAndNumbers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStrCommodityForMark(String strCommodityForMark) {
        this.strCommodityForMark = strCommodityForMark;
    }

    public String getStrCommodityForMark() {
        return strCommodityForMark;
    }

    public void setContainerNoToCargo(String containerNoToCargo) {
        this.containerNoToCargo = containerNoToCargo;
    }

    public String getContainerNoToCargo() {
        return containerNoToCargo;
    }

    public void setComBookingNo(String comBookingNo) {
        this.comBookingNo = comBookingNo;
    }

    public String getComBookingNo() {
        return comBookingNo;
    }

    public void setComSeqNo(String comSeqNo) {
        this.comSeqNo = comSeqNo;
    }

    public String getComSeqNo() {
        return comSeqNo;
    }
}
