/*------------------------------------------------------
EserviceDGCommoditiesUim.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Pratya Thanuchaisak 08/08/2014
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.List;

public class EserviceDGCommoditiesUim extends PaginationForm {
    
    //For combo
    private List   unitMeasurementComboList;
    
    //For default page
    private String userId;
    private String currPageAction;
    private String errMsg;
    private String seqNo;
    private String rowIndex;
    private String disBtn;
    
    //for field in this screen
    private String flashPoint;
    private String unitMeasurement;
    private String unNo;
    private String variant;
    private String imdgClass;
    private String unNoDis;
    private String variantDis;
    private String imdgClassDis;
    private String portClass;
    private String residue;
    private String fumigration;
    
    
    // ------------------------------------default constructor
    public EserviceDGCommoditiesUim() {
        this.userId               = "";
        this.currPageAction       = "";
        this.errMsg               = "";
        this.seqNo                = "";
        this.rowIndex             = "";
        
        this.resetForm();
    }
    
    public void resetForm(){
        this.flashPoint             = "";
        this.unitMeasurement        = "";
        this.unNo                   = "";
        this.variant                = "";
        this.imdgClass              = "";
        this.portClass              = "";
        this.residue                = "N";
        this.fumigration            = "N";
        this.disBtn                 = "N";
        this.unNoDis                = "";
        this.variantDis             = "";
        this.imdgClassDis           = "";
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setCurrPageAction(String currPageAction) {
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction() {
        return currPageAction;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowIndex() {
        return rowIndex;
    }

    public void setFlashPoint(String flashPoint) {
        this.flashPoint = flashPoint;
    }

    public String getFlashPoint() {
        return flashPoint;
    }

    public void setUnNo(String unNo) {
        this.unNo = unNo;
    }

    public String getUnNo() {
        return unNo;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }

    public void setImdgClass(String imdgClass) {
        this.imdgClass = imdgClass;
    }

    public String getImdgClass() {
        return imdgClass;
    }

    public void setPortClass(String portClass) {
        this.portClass = portClass;
    }

    public String getPortClass() {
        return portClass;
    }

    public void setResidue(String residue) {
        this.residue = residue;
    }

    public String getResidue() {
        return residue;
    }

    public void setFumigration(String fumigration) {
        this.fumigration = fumigration;
    }

    public String getFumigration() {
        return fumigration;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurementComboList(List unitMeasurementComboList) {
        this.unitMeasurementComboList = unitMeasurementComboList;
    }

    public List getUnitMeasurementComboList() {
        return unitMeasurementComboList;
    }

    public void setDisBtn(String disBtn) {
        this.disBtn = disBtn;
    }

    public String getDisBtn() {
        return disBtn;
    }

    public void setUnNoDis(String unNoDis) {
        this.unNoDis = unNoDis;
    }

    public String getUnNoDis() {
        return unNoDis;
    }

    public void setVariantDis(String variantDis) {
        this.variantDis = variantDis;
    }

    public String getVariantDis() {
        return variantDis;
    }

    public void setImdgClassDis(String imdgClassDis) {
        this.imdgClassDis = imdgClassDis;
    }

    public String getImdgClassDis() {
        return imdgClassDis;
    }
}
