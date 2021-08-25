/*------------------------------------------------------
 EservicePdfUim.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Pratya Thanuchaisak 08/08/2014
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

public class EservicePdfUim extends PaginationForm {
    
    //For default page
    private String userId;
    private String currPageAction;
    private String errMsg;
    
    //for field in this screen
    
    public EservicePdfUim(){
        this.userId             = "";
        this.currPageAction     = "";
        this.errMsg             = "";
        
        this.resetForm();
    }
    
    public void resetForm(){
        
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
}
