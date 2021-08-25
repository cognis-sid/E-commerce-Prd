 /*------------------------------------------------------
  EserviceSailingSchedulePopupMod.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 11/09/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EserviceSailingSchedulePopupMod{

    private String code;
    private String description;
    
    public EserviceSailingSchedulePopupMod(){
        this.code               = "";
        this.description        = "";
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
