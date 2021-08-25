package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EserviceMRESMyEServiceMod implements Serializable {
    private String menuCode;
    private String menuName;
    private String module;
    private String information;
    private String url;
    private String usrLogin;
    
    public EserviceMRESMyEServiceMod(){
        this.module = null;
        this.menuCode = null;
        this.menuName = null;
        this.information = null;
        this.url = null;
        this.usrLogin = null;
    }
    
    public String getModule(){
        return module;
    }
    
    public void setModule(String module){
        this.module = module;
    }
    
    public String getInformation(){
        return information;
    }
    
    public void setInformation(String information){
        this.information = information;
    }
    
    public String getUrl(){
        return url;
    }
    
    public void setUrl(String url){
        this.url = url;
    }

    public void setMenuCode(String menuCode){
        this.menuCode = menuCode;
    }

    public String getMenuCode(){
        return menuCode;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getMenuName(){
        return menuName;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public String getUsrLogin() {
        return usrLogin;
    }
}
