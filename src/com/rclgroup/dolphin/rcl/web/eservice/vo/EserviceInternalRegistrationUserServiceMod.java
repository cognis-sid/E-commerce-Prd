package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceInternalRegistrationUserServiceMod implements Serializable {
    private String moduleName;
    private String sfu;
    private String usageRemark;
    
    private boolean checked;
    
    public EserviceInternalRegistrationUserServiceMod(){
        this.moduleName = null;
        this.sfu = null;
        this.usageRemark = null;
        this.checked = false;
    }


    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }

    public String getModuleName(){
        return moduleName;
    }

    public void setSfu(String sfu){
        this.sfu = sfu;
    }

    public String getSfu(){
        return sfu;
    }

    public void setChecked(boolean checked){
        this.checked = checked;
    }

    public boolean getChecked(){
        return checked;
    }

    public void setUsageRemark(String usageRemark){
        this.usageRemark = usageRemark;
    }

    public String getUsageRemark(){
        return usageRemark;
    }
}
