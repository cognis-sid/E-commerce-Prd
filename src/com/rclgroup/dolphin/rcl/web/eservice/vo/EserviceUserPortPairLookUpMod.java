 /*------------------------------------------------------
  EserviceUserPortPairLookUpMod.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 21/10/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EserviceUserPortPairLookUpMod{

    private String userId           = null;
    private String userName         = null;
    private String companyName      = null;
    private String contractCompany  = null;
    
    public EserviceUserPortPairLookUpMod(){
        this.userId                 = "";
        this.userName               = "";
        this.companyName            = "";
        this.contractCompany        = "";
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setContractCompany(String contractCompany) {
        this.contractCompany = contractCompany;
    }

    public String getContractCompany() {
        return contractCompany;
    }
}
