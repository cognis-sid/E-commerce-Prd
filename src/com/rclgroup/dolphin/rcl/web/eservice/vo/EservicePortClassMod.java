 /*------------------------------------------------------
  EservicePortClassMod.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 08/08/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EservicePortClassMod{

    private String portClassCode;
    private String portClassType;
    private String unno;
    private String variant;
    private String imdgClass;
    private String psn;
    private String recStatus;
    
    public EservicePortClassMod(){
        this.portClassCode  = "";
        this.portClassType  = "";
        this.unno           = "";
        this.variant        = "";
        this.imdgClass      = "";
        this.psn            = "";
        this.recStatus         = "";
    }

    public void setPortClassCode(String portClassCode) {
        this.portClassCode = portClassCode;
    }

    public String getPortClassCode() {
        return portClassCode;
    }

    public void setPortClassType(String portClassType) {
        this.portClassType = portClassType;
    }

    public String getPortClassType() {
        return portClassType;
    }

    public void setUnno(String unno) {
        this.unno = unno;
    }

    public String getUnno() {
        return unno;
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

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getPsn() {
        return psn;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }

    public String getRecStatus() {
        return recStatus;
    }
}
