/*------------------------------------------------------
 EserviceOOGCommoditiesUim.java
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

public class EserviceOOGCommoditiesUim extends PaginationForm {
    
    //For default page
    private String userId;
    private String currPageAction;
    private String errMsg;
    private String seqNo;
    private String rowIndex;
    private String disBtn;
    
    //for field in this screen
    private String txtLength;
    private String txtWidth;
    private String txtHeight;
    private String txtDiameter;
    
    
    // ------------------------------------default constructor
    public EserviceOOGCommoditiesUim() {
        this.userId               = "";
        this.currPageAction       = "";
        this.errMsg               = "";
        this.seqNo                = "";
        this.rowIndex             = "";
        
        this.resetForm();
    }
    
    public void resetForm(){
        this.txtLength             = "";
        this.txtWidth              = "";
        this.txtHeight             = "";
        this.txtDiameter           = "";
        this.disBtn                = "N";
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

    public void setTxtLength(String txtLength) {
        this.txtLength = txtLength;
    }

    public String getTxtLength() {
        return txtLength;
    }

    public void setTxtWidth(String txtWidth) {
        this.txtWidth = txtWidth;
    }

    public String getTxtWidth() {
        return txtWidth;
    }

    public void setTxtHeight(String txtHeight) {
        this.txtHeight = txtHeight;
    }

    public String getTxtHeight() {
        return txtHeight;
    }

    public void setTxtDiameter(String txtDiameter) {
        this.txtDiameter = txtDiameter;
    }

    public String getTxtDiameter() {
        return txtDiameter;
    }

    public void setDisBtn(String disBtn) {
        this.disBtn = disBtn;
    }

    public String getDisBtn() {
        return disBtn;
    }
}
