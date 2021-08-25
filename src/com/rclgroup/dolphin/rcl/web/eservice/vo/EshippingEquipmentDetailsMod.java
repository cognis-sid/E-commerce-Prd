package com.rclgroup.dolphin.rcl.web.eservice.vo;

import com.niit.control.common.ComboVO;

import java.util.List;

public class EshippingEquipmentDetailsMod{
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
    private String packagesKindName;
    private String packagesKindCode;
    private String grossContainerWeight;
    private String commodity;
    private String ladenMt;
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
    private String strCommodityName;
    
    public EshippingEquipmentDetailsMod(){
        this.seqNo                      = null;
        this.containerNo                = null;
        this.containerType              = null;
        this.containerEqSize            = null;
        this.containerEqType            = null;
        this.carrierSeal                = null;
        this.shipperSeal                = null;
        this.marksAndNumbers            = null;
        this.description                = null;
        this.ofPackages                 = null;
        this.packagesKindName           = null;
        this.packagesKindCode           = null;
        this.grossContainerWeight       = null;
        this.commodity                  = null;
        this.ladenMt                    = null;
        this.height                     = null;
        this.grossCargoMeasurement      = null;
        this.valueFlag                  = null;
        this.dbFlag                     = null;
        this.statusFlag                 = null;
        this.originalSeqNo              = null;
        this.cntrSeq                    = null;
        this.fkEquipmentDetail          = null;
        this.fkBookingSupplier          = null;
        this.fkBookingSizeTypeDetail    = null;
        this.strCommodityName           = null;
    }

    public void setSeqNo(Integer seqNo){
        this.seqNo = seqNo;
    }

    public Integer getSeqNo(){
        return seqNo;
    }

    public void setContainerNo(String containerNo){
        this.containerNo = containerNo;
    }

    public String getContainerNo(){
        return containerNo;
    }

    public void setContainerType(String containerType){
        this.containerType = containerType;
    }

    public String getContainerType(){
        return containerType;
    }

    public void setContainerEqSize(String containerEqSize){
        this.containerEqSize = containerEqSize;
    }

    public String getContainerEqSize(){
        return containerEqSize;
    }

    public void setContainerEqType(String containerEqType){
        this.containerEqType = containerEqType;
    }

    public String getContainerEqType(){
        return containerEqType;
    }

    public void setCarrierSeal(String carrierSeal){
        this.carrierSeal = carrierSeal;
    }

    public String getCarrierSeal(){
        return carrierSeal;
    }

    public void setShipperSeal(String shipperSeal){
        this.shipperSeal = shipperSeal;
    }

    public String getShipperSeal(){
        return shipperSeal;
    }

    public void setMarksAndNumbers(String marksAndNumbers){
        this.marksAndNumbers = marksAndNumbers;
    }

    public String getMarksAndNumbers(){
        return marksAndNumbers;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setOfPackages(String ofPackages){
        this.ofPackages = ofPackages;
    }

    public String getOfPackages(){
        return ofPackages;
    }

    public void setPackagesKindName(String packagesKindName){
        this.packagesKindName = packagesKindName;
    }

    public String getPackagesKindName(){
        return packagesKindName;
    }

    public void setPackagesKindCode(String packagesKindCode){
        this.packagesKindCode = packagesKindCode;
    }

    public String getPackagesKindCode(){
        return packagesKindCode;
    }

    public void setGrossContainerWeight(String grossContainerWeight){
        this.grossContainerWeight = grossContainerWeight;
    }

    public String getGrossContainerWeight(){
        return grossContainerWeight;
    }

    public void setCommodity(String commodity){
        this.commodity = commodity;
    }

    public String getCommodity(){
        return commodity;
    }

    public void setLadenMt(String ladenMt){
        this.ladenMt = ladenMt;
    }

    public String getLadenMt(){
        return ladenMt;
    }

    public void setHeight(String height){
        this.height = height;
    }

    public String getHeight(){
        return height;
    }

    public void setGrossCargoMeasurement(String grossCargoMeasurement){
        this.grossCargoMeasurement = grossCargoMeasurement;
    }

    public String getGrossCargoMeasurement(){
        return grossCargoMeasurement;
    }

    public void setValueFlag(String valueFlag){
        this.valueFlag = valueFlag;
    }

    public String getValueFlag(){
        return valueFlag;
    }

    public void setDbFlag(String dbFlag){
        this.dbFlag = dbFlag;
    }

    public String getDbFlag(){
        return dbFlag;
    }

    public void setStatusFlag(String statusFlag){
        this.statusFlag = statusFlag;
    }

    public String getStatusFlag(){
        return statusFlag;
    }

    public void setOriginalSeqNo(String originalSeqNo){
        this.originalSeqNo = originalSeqNo;
    }

    public String getOriginalSeqNo(){
        return originalSeqNo;
    }

    public void setCntrSeq(String cntrSeq){
        this.cntrSeq = cntrSeq;
    }

    public String getCntrSeq(){
        return cntrSeq;
    }

    public void setFkEquipmentDetail(String fkEquipmentDetail){
        this.fkEquipmentDetail = fkEquipmentDetail;
    }

    public String getFkEquipmentDetail(){
        return fkEquipmentDetail;
    }

    public void setFkBookingSupplier(String fkBookingSupplier){
        this.fkBookingSupplier = fkBookingSupplier;
    }

    public String getFkBookingSupplier(){
        return fkBookingSupplier;
    }

    public void setFkBookingSizeTypeDetail(String fkBookingSizeTypeDetail){
        this.fkBookingSizeTypeDetail = fkBookingSizeTypeDetail;
    }

    public String getFkBookingSizeTypeDetail(){
        return fkBookingSizeTypeDetail;
    }

    public void setStrCommodityName(String strCommodityName){
        this.strCommodityName = strCommodityName;
    }

    public String getStrCommodityName(){
        return strCommodityName;
    }
}
