/*------------------------------------------------------
EserviceReferCommoditiesUim.java
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

public class EserviceReferCommoditiesUim extends PaginationForm {
    
    private String userId;
    private String userFsc;
    private String currPageAction;
    private String errMsg;
    private String temperature;
    private String ventilation;
    private String remark;
    private String humidity;
    private String controlledAtmosphere;
    private String nitrogen;
    private String oxygent;
    private String co2;
    private String refMode;
    private String preCooled;
    private String seqNo;
    private List   refrModeList;
    private String rowIndex;
    private String disBtn;
    
    
    // ------------------------------------default constructor
    public EserviceReferCommoditiesUim() {
        this.userId             = null;
        this.userFsc            = null;
        
        this.resetForm();
    }
    
    public void resetForm(){
        this.temperature            = "";
        this.ventilation            = "";
        this.remark                 = "";
        this.humidity               = "";
        this.controlledAtmosphere   = "N";
        this.nitrogen               = "";
        this.oxygent                = "";
        this.co2                    = "";
        this.refMode                = "";
        this.preCooled              = "N";
        this.seqNo                  = "";
        this.rowIndex               = "";
        this.disBtn                 = "N";
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserFsc(String userFsc) {
        this.userFsc = userFsc;
    }

    public String getUserFsc() {
        return userFsc;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setVentilation(String ventilation) {
        this.ventilation = ventilation;
    }

    public String getVentilation() {
        return ventilation;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setControlledAtmosphere(String controlledAtmosphere) {
        this.controlledAtmosphere = controlledAtmosphere;
    }

    public String getControlledAtmosphere() {
        return controlledAtmosphere;
    }

    public void setNitrogen(String nitrogen) {
        this.nitrogen = nitrogen;
    }

    public String getNitrogen() {
        return nitrogen;
    }

    public void setOxygent(String oxygent) {
        this.oxygent = oxygent;
    }

    public String getOxygent() {
        return oxygent;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getCo2() {
        return co2;
    }

    public void setPreCooled(String preCooled) {
        this.preCooled = preCooled;
    }

    public String getPreCooled() {
        return preCooled;
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

    public void setRefMode(String refMode) {
        this.refMode = refMode;
    }

    public String getRefMode() {
        return refMode;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setRefrModeList(List refrModeList) {
        this.refrModeList = refrModeList;
    }

    public List getRefrModeList() {
        return refrModeList;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowIndex() {
        return rowIndex;
    }

    public void setDisBtn(String disBtn) {
        this.disBtn = disBtn;
    }

    public String getDisBtn() {
        return disBtn;
    }
}
