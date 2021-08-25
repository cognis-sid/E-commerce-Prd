package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceEquipmentDetailsMod implements Serializable {

    private int     eqSeqNo;
    private String  type;
    private String  typeDesc;
    private String  size;
    private String  cargoType;
    private String  laden;
    private String  mt;
    private String  grossContainerWeight;
    private String  polStatus;
    private String  podStatus;
    private String  eqRecordStatus;
    private String  equipmentSelectChkBox;
    private String  emptyPickupDepot;
    private String  emptyPickupDate;
    private String  cargoDescription;
    private String  eqNumber;
    private String specialCargo;
    private String specialCargoDesc;
		
	
    
    public EserviceEquipmentDetailsMod(){
        this.size                       = "20";
        this.type                       = "GP";
        this.cargoType                  = "N";
        this.laden                      = "0";
        this.mt                         = "0";
        this.polStatus                  = "L";
        this.podStatus                  = "L";
        this.grossContainerWeight       = "";
        this.equipmentSelectChkBox      = "N";
        this.typeDesc                   = "GP - GENERAL PURPOSE CONTAINER";
    }

    
    public String getEqNumber() {
		return eqNumber;
	}


    
	public String getSpecialCargo() {
		return specialCargo;
	}


	public void setSpecialCargo(String specialCargo) {
		this.specialCargo = specialCargo ;
	}


	public String getSpecialCargoDesc() {
		return specialCargoDesc;
	}


	public void setSpecialCargoDesc(String specialCargoDesc) {
		this.specialCargoDesc = specialCargoDesc ;
	}


	public void setEqNumber(String eqNumber) {
		this.eqNumber = eqNumber;
	}


	public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setLaden(String laden) {
        this.laden = laden;
    }

    public String getLaden() {
        return laden;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getMt() {
        return mt;
    }

    public void setGrossContainerWeight(String grossContainerWeight) {
        this.grossContainerWeight = grossContainerWeight;
    }

    public String getGrossContainerWeight() {
        return grossContainerWeight;
    }

    public void setPolStatus(String polStatus) {
        this.polStatus = polStatus;
    }

    public String getPolStatus() {
        return polStatus;
    }

    public void setPodStatus(String podStatus) {
        this.podStatus = podStatus;
    }

    public String getPodStatus() {
        return podStatus;
    }

    public void setEquipmentSelectChkBox(String equipmentSelectChkBox) {
        this.equipmentSelectChkBox = equipmentSelectChkBox;
    }

    public String getEquipmentSelectChkBox() {
        return equipmentSelectChkBox;
    }

    public void setEmptyPickupDepot(String emptyPickupDepot) {
        this.emptyPickupDepot = emptyPickupDepot;
    }

    public String getEmptyPickupDepot() {
        return emptyPickupDepot;
    }

    public void setEmptyPickupDate(String emptyPickupDate) {
        this.emptyPickupDate = emptyPickupDate;
    }

    public String getEmptyPickupDate() {
        return emptyPickupDate;
    }

    public void setCargoDescription(String cargoDescription){
        this.cargoDescription = cargoDescription ;
    }

    public String getCargoDescription(){
        return cargoDescription;
    }

    public void setEqSeqNo(int eqSeqNo) {
        this.eqSeqNo = eqSeqNo;
    }

    public int getEqSeqNo() {
        return eqSeqNo;
    }

    public void setEqRecordStatus(String eqRecordStatus) {
        this.eqRecordStatus = eqRecordStatus;
    }

    public String getEqRecordStatus() {
        return eqRecordStatus;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc ;
    }

    public String getTypeDesc() {
        return typeDesc;
    }
}
