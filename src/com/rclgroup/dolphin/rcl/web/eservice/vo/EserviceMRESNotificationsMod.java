package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.Date;

public class EserviceMRESNotificationsMod implements Serializable{
    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");

    private String id;
    private String mailSubject;
    private Date mailDate;
    private String flag;
    private String flagDesc;
    private String mailDateStr;
    private String url;
    private String mailBody;
    private boolean hasUrl;
    
    public EserviceMRESNotificationsMod(){
        this.id = null;
        this.mailSubject = null;
        this.mailDate = null;
        this.flag = null;
        this.url = null;
        this.mailDateStr = null;
        this.mailBody = null;
        this.hasUrl = false;
        
        setMailDateStr(this.mailDate);
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setMailSubject(String mailSubject){
        this.mailSubject = mailSubject;
    }

    public String getMailSubject(){
        return mailSubject;
    }

    public void setMailDate(Date mailDate){
        this.mailDate = mailDate;
        
        setMailDateStr(mailDate);
    }

    public Date getMailDate(){
        return mailDate;
    }

    public void setFlag(String flag){
        this.flag = flag;
    }

    public String getFlag(){
        return flag;
    }
    
    public void setMailDateStr(String mailDateStr){
        this.mailDateStr = mailDateStr;
    }

    public void setMailDateStr(Date mailDate){
        if(mailDate != null){
            this.mailDateStr = df.format(mailDate);
        }else{
            this.mailDateStr = null;
        }
    }

    public String getMailDateStr(){
        return mailDateStr;
    }

    public void setUrl(String url){
        this.url = url;
        if(url != null && !"".equals(url.trim())){
            setHasUrl(true);
        }else{
            setHasUrl(false);
        }
    }

    public String getUrl(){
        return url;
    }

    public void setFlagDesc(String flagDesc){
        this.flagDesc = flagDesc;
    }

    public String getFlagDesc(){
        return flagDesc;
    }

    public void setHasUrl(boolean hasUrl){
        this.hasUrl = hasUrl;
    }

    public boolean getHasUrl(){
        return hasUrl;
    }

    public void setMailBody(String mailBody){
        this.mailBody = mailBody;
    }

    public String getMailBody(){
        return mailBody;
    }
}
