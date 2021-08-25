/*------------------------------------------------------
 EserviceUploadUim.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Pratya Thanuchaisak 08/08/2014
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

public class EserviceUploadUim extends PaginationForm {
    
    //For default page
    private String userId;
    private String currPageAction;
    private String errMsg;
    private String disBtn;
    
    //for field in this screen
    private List        list;
    private int         totalSize;
    private String      maxSeq;
    private FormFile    dataFile;
    private String      filePathConf;
    
    public EserviceUploadUim(){
        this.userId             = "";
        this.currPageAction     = "";
        this.errMsg             = "";
        
        this.resetForm();
    }
    
    public void resetForm(){
        this.list                   = new ArrayList();
        this.totalSize              = 0;
        this.maxSeq                 = "0";
        this.filePathConf           = "";
        this.disBtn                 = "N";
    }

    public void setList(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
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

    public void setMaxSeq(String maxSeq) {
        this.maxSeq = maxSeq;
    }

    public String getMaxSeq() {
        return maxSeq;
    }

    public void setDataFile(FormFile dataFile) {
        this.dataFile = dataFile;
    }

    public FormFile getDataFile() {
        return dataFile;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setFilePathConf(String filePathConf) {
        this.filePathConf = filePathConf;
    }

    public String getFilePathConf() {
        return filePathConf;
    }

    public void setDisBtn(String disBtn) {
        this.disBtn = disBtn;
    }

    public String getDisBtn() {
        return disBtn;
    }
}
