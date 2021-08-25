package com.rclgroup.dolphin.rcl.web.eservice.vo;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceDGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceOOGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceReferCommoditiesUim;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

import java.io.Serializable;

public class EserviceCommodityDetailsMod implements Serializable {
    private Integer seqNo;
    
    private String description;
    private String code;

    private String radCommodity;
    private String group;
//    private String description;
    private String grossWeight;
    
    //added by sid cognis 
    
    private String measurement;
    
    private String specialCargo;
    private String specialInstruction;
    private String recordStatus;
    private String isSelected;
    private String rateType;
    private String rateTypeDesc;
   
    private EserviceReferCommoditiesUim eserviceReferCommoditiesUim;
    private EserviceDGCommoditiesUim    eserviceDGCommoditiesUim;
    private EserviceOOGCommoditiesUim   eserviceOOGCommoditiesUim;
    private String rateTypeClassName;
    private String rateTypeFlag;
    private boolean rateTypeDisabled;
    
    public EserviceCommodityDetailsMod(){
        this.isSelected                         = "N";
        this.grossWeight                        = "";
        this.measurement						= "";
        this.group                              = "";
        this.description                        = "";
        this.specialInstruction                 = "";
        this.rateTypeClassName                  = EserviceNewWebBookingDao.STYLE_BLUE;
        this.rateTypeFlag                       = "N";
        this.specialCargo                       = "N";
        this.rateType                           = "";
        this.rateTypeDesc                       = "";
        this.eserviceReferCommoditiesUim        = null;
        this.eserviceDGCommoditiesUim           = null;
        this.eserviceOOGCommoditiesUim          = null;
        this.rateTypeDisabled                   = false;
        this.radCommodity                       = "0";
    }


	public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRadCommodity(String radCommodity) {
        this.radCommodity = radCommodity;
    }

    public String getRadCommodity() {
        return radCommodity;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getGrossWeight() {
        return grossWeight;
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

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getRateType() {
        return rateType;
    }

    public void setEserviceReferCommoditiesUim(EserviceReferCommoditiesUim eserviceReferCommoditiesUim) {
        this.eserviceReferCommoditiesUim = eserviceReferCommoditiesUim;
    }

    public EserviceReferCommoditiesUim getEserviceReferCommoditiesUim() {
        return eserviceReferCommoditiesUim;
    }

    public void setRateTypeClassName(String rateTypeClassName) {
        this.rateTypeClassName = rateTypeClassName;
    }

    public String getRateTypeClassName() {
        return rateTypeClassName;
    }

    public void setRateTypeFlag(String rateTypeFlag) {
        this.rateTypeFlag = rateTypeFlag;
    }

    public String getRateTypeFlag() {
        return rateTypeFlag;
    }

    public void setEserviceDGCommoditiesUim(EserviceDGCommoditiesUim eserviceDGCommoditiesUim) {
        this.eserviceDGCommoditiesUim = eserviceDGCommoditiesUim;
    }

    public EserviceDGCommoditiesUim getEserviceDGCommoditiesUim() {
        return eserviceDGCommoditiesUim;
    }

    public void setEserviceOOGCommoditiesUim(EserviceOOGCommoditiesUim eserviceOOGCommoditiesUim) {
        this.eserviceOOGCommoditiesUim = eserviceOOGCommoditiesUim;
    }

    public EserviceOOGCommoditiesUim getEserviceOOGCommoditiesUim() {
        return eserviceOOGCommoditiesUim;
    }

    public void setRateTypeDisabled(boolean rateTypeDisabled) {
        this.rateTypeDisabled = rateTypeDisabled;
    }

    public boolean isRateTypeDisabled() {
        return rateTypeDisabled;
    }

    public void setRateTypeDesc(String rateTypeDesc) {
        this.rateTypeDesc = rateTypeDesc;
    }

    public String getRateTypeDesc() {
        return rateTypeDesc;
    }

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
    
    
}
