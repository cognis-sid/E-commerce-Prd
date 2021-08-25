/*
-------------------------------------------------------------------------------------------------------------
EshippingCargoDescriptionMod.java
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author anurak 01/01/2013
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 06/08/2013     TANA              01              add commodity name
## 04/09/2013     YOSSUN1           02              add type of list of commodityValues
-------------------------------------------------------------------------------------------------------------
*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

import com.niit.control.common.ComboVO;

import java.io.Serializable;

import java.util.List;

public class EshippingCargoDescriptionMod implements Serializable
{
    private Integer seqNo;
    private String containerNo;
    private String containerType;
    private String containerEqSize;
    private String containerEqType;
    private String carrierSeal;
    private String shipperSeal;
    private String marksAndNumbers;
    private String description;
    private String ofPackages;
    private String packagesKind;
    private String packagesKindCode;
    private String grossContainerWeight;
    private String commodity;
    private String ladenMt;
    private String ladenCount;
    private String height;
    private String grossCargoMeasurement;
    private String valueFlag;
    private String dbFlag;
    private String statusFlag;
    private String originalSeqNo;
    private String cntrSeq;
    private String fkEquipmentDetail;
    private String fkBookingSupplier;
    private String fkBookingSizeTypeDetail;
    private List containerTypeValues;
    private List packagesKindValues;
    //@02 BEGIN
    private List<ComboVO> commodityValues;
    //@02 END
    private List<ComboVO> ladenMtValues;
    
    //@01 BEGIN
    private String strCommodityName;
    //@01 END
    private String strEqptCommodity;
    
    private String editFlag="N" ;

 public EshippingCargoDescriptionMod() {
    	
    }
    public EshippingCargoDescriptionMod(EshippingCargoDescriptionMod obj) {
    	this.seqNo=obj.seqNo;
    	this.containerNo=obj.containerNo;
    	this.containerType=obj.containerType;
    	this.containerEqSize=obj.containerEqSize;
    	this.containerEqType=obj.containerEqType;
    	this.carrierSeal=obj.carrierSeal;
    	this.marksAndNumbers=obj.marksAndNumbers;
    	this.description=obj.description;
    	this.ofPackages=obj.ofPackages;
    	this.packagesKind=obj.packagesKind;
    	this.packagesKindCode=obj.packagesKindCode;
    	this.grossContainerWeight=obj.grossContainerWeight;
    	this.commodity=obj.commodity;
    	this.ladenMt=obj.ladenMt;
    	this.ladenCount=obj.ladenCount;
    	this.height=obj.height;
    	this.grossCargoMeasurement=obj.grossCargoMeasurement;
    	this.valueFlag=obj.valueFlag;
    	this.dbFlag=obj.dbFlag;
    	this.statusFlag=obj.statusFlag;
    	this.originalSeqNo=obj.originalSeqNo;
    	this.cntrSeq=obj.cntrSeq;
    	this.fkEquipmentDetail=obj.fkEquipmentDetail;
    	this.fkBookingSupplier=obj.fkBookingSupplier;
    	this.fkBookingSizeTypeDetail=obj.fkBookingSizeTypeDetail;
    	this.containerTypeValues=obj.containerTypeValues;
    	this.packagesKindValues=obj.packagesKindValues;
    	this.editFlag=obj.editFlag;
    }
    
    public String getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	public String getStrEqptCommodity() {
		return strEqptCommodity;
	}
    
	public void setStrEqptCommodity(String strEqptCommodity) {
		this.strEqptCommodity = strEqptCommodity;
	}
	
	public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getLadenCount() {
		return ladenCount;
	}

	public void setLadenCount(String ladenCount) {
		this.ladenCount = ladenCount;
	}

	public String getContainerNo() {
        return containerNo;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setCarrierSeal(String carrierSeal) {
        this.carrierSeal = carrierSeal;
    }

    public String getCarrierSeal() {
        return carrierSeal;
    }

    public void setShipperSeal(String shipperSeal) {
        this.shipperSeal = shipperSeal;
    }

    public String getShipperSeal() {
        return shipperSeal;
    }

    public void setOfPackages(String ofPackages) {
        this.ofPackages = ofPackages;
    }

    public String getOfPackages() {
        return ofPackages;
    }

    public void setPackagesKind(String packagesKind) {
        this.packagesKind = packagesKind;
    }

    public String getPackagesKind() {
        return packagesKind;
    }

    public void setGrossContainerWeight(String grossContainerWeight) {
        this.grossContainerWeight = grossContainerWeight;
    }

    public String getGrossContainerWeight() {
        return grossContainerWeight;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setLadenMt(String ladenMt) {
        this.ladenMt = ladenMt;
    }

    public String getLadenMt() {
        return ladenMt;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    public void setGrossCargoMeasurement(String grossCargoMeasurement) {
        this.grossCargoMeasurement = grossCargoMeasurement;
    }

    public String getGrossCargoMeasurement() {
        return grossCargoMeasurement;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setContainerTypeValues(List containerTypeValues) {
        this.containerTypeValues = containerTypeValues;
    }

    public List getContainerTypeValues() {
        return containerTypeValues;
    }

    public void setPackagesKindValues(List packagesKindValues) {
        this.packagesKindValues = packagesKindValues;
    }

    public List getPackagesKindValues() {
        return packagesKindValues;
    }
    //@02 BEGIN
    public void setCommodityValues(List<ComboVO> commodityValues) {
        this.commodityValues = commodityValues;
    }

    public List<ComboVO> getCommodityValues() {
        return commodityValues;
    }
    //@02 END
    public void setLadenMtValues(List<ComboVO> ladenMtValues) {
        this.ladenMtValues = ladenMtValues;
    }

    public List<ComboVO> getLadenMtValues() {
        return ladenMtValues;
    }

    public void setDescription(String description) {
        this.description = description ;
    }

    public String getDescription() {
        return description;
    }

    public void setMarksAndNumbers(String marksAndNumbers) {
        this.marksAndNumbers = marksAndNumbers ;
    }

    public String getMarksAndNumbers() {
        return marksAndNumbers;
    }

    public void setValueFlag(String valueFlag) {
        this.valueFlag = valueFlag;
    }

    public String getValueFlag() {
        return valueFlag;
    }

    public void setDbFlag(String dbFlag) {
        this.dbFlag = dbFlag;
    }

    public String getDbFlag() {
        return dbFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setOriginalSeqNo(String originalSeqNo) {
        this.originalSeqNo = originalSeqNo;
    }

    public String getOriginalSeqNo() {
        return originalSeqNo;
    }

    public void setContainerEqSize(String containerEqSize) {
        this.containerEqSize = containerEqSize;
    }

    public String getContainerEqSize() {
        return containerEqSize;
    }

    public void setContainerEqType(String containerEqType) {
        this.containerEqType = containerEqType;
    }

    public String getContainerEqType() {
        return containerEqType;
    }

    public void setPackagesKindCode(String packagesKindCode) {
        this.packagesKindCode = packagesKindCode;
    }

    public String getPackagesKindCode() {
        return packagesKindCode;
    }

    public void setCntrSeq(String cntrSeq) {
        this.cntrSeq = cntrSeq;
    }

    public String getCntrSeq() {
        return cntrSeq;
    }
    
    
//    public Boolean equals(List<EshippingCargoDescriptionMod> list) 
//    {
//        for(EshippingCargoDescriptionMod ecd : list)
//        {
//            if (ecd.originalSeqNo == this.originalSeqNo) 
//            {
//                return Boolean.TRUE;
//            }
//            return Boolean.FALSE;
//        }
//    }

    public void setFkEquipmentDetail(String fkEquipmentDetail) {
        this.fkEquipmentDetail = fkEquipmentDetail;
    }

    public String getFkEquipmentDetail() {
        return fkEquipmentDetail;
    }

    public void setFkBookingSupplier(String fkBookingSupplier) {
        this.fkBookingSupplier = fkBookingSupplier;
    }

    public String getFkBookingSupplier() {
        return fkBookingSupplier;
    }

    public void setFkBookingSizeTypeDetail(String fkBookingSizeTypeDetail) {
        this.fkBookingSizeTypeDetail = fkBookingSizeTypeDetail;
    }

    public String getFkBookingSizeTypeDetail() {
        return fkBookingSizeTypeDetail;
    }

    public void setStrCommodityName(String strCommodityName) {
        this.strCommodityName = strCommodityName;
    }

    public String getStrCommodityName() {
        return strCommodityName;
    }
}
