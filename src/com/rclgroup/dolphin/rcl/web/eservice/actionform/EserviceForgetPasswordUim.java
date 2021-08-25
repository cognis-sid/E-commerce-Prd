package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.BaseActionForm;

public class EserviceForgetPasswordUim extends BaseActionForm {
    private String userId;
    private String emailAddress;
    private boolean sentPassword;
    private String currPageAction;
    private String prevPageAction;
    private String errMsg;
    
    public EserviceForgetPasswordUim(){
        this.userId = null;
        this.emailAddress = null;
        this.currPageAction = null;
        this.prevPageAction = null;
        this.errMsg = null;
        this.sentPassword = false;
    }
    
    public String getUserId(){
        return userId;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
    
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public void setCurrPageAction(String currPageAction){
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction(){
        return currPageAction;
    }

    public void setPrevPageAction(String prevPageAction){
        this.prevPageAction = prevPageAction;
    }

    public String getPrevPageAction(){
        return prevPageAction;
    }

    public void setErrMsg(String errMsg){
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }

    public void setSentPassword(boolean sentPassword){
        this.sentPassword = sentPassword;
    }

    public boolean getSentPassword(){
        return sentPassword;
    }
}
