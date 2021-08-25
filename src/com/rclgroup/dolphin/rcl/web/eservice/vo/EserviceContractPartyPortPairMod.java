 /*------------------------------------------------------
  EserviceContractPartyPortPairMod.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 07/10/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    -User-         -TaskRef-   -ShortDescription-
 ## 09/12/2015    Watchakorn      01         Change solution for Represented Company Contract
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EserviceContractPartyPortPairMod{

    private String pkPortPairSeq;
    private String fkUserId;
    private String fkContractPartyCode;
    private String contractPartyName;
    private String contractPartyNameDisabled;
    private String fkPOL;
    private String POLDesc;
    private String fkPOD;
    private String PODDesc;
    private String effDate;
    private String expDate;
    private String recStatus;
    private String recStatusDesc;
    private String userId;
    private String errMsg;
    private String statusFlag;
    private String approveFlag;
    private String errCrmDesc;
    private String contractPartyFscCode;
    private String contractPartyType;
    private String userName;
    private String userNameDisabled;
    private String flagPortPair;
    private String contractCompany;

    //##01 Begin
    private String contractPartyStatus;
    private String pkEsvPpHdrSeq;
    private String pwd;
    private String reactPwd;
    private String pkEsvPpDtlSeq;
    private String portPairStatusFlag;
    //##01 End

    public EserviceContractPartyPortPairMod(){
        this.pkPortPairSeq              = "";
        this.fkUserId                   = "";
        this.fkContractPartyCode        = "";
        this.contractPartyName          = "";
        this.contractPartyNameDisabled  = "";
        this.fkPOL                      = "";
        this.fkPOD                      = "";
        this.effDate                    = "";
        this.expDate                    = "";
        this.recStatus                  = "P";
        this.recStatusDesc              = "New";
        this.userId                     = "";
        this.errMsg                     = "";
        this.statusFlag                 = "";
        this.approveFlag                = "N";
        this.errCrmDesc                 = "";
        this.contractPartyFscCode       = "";
        this.contractPartyType          = "";
        this.userName                   = "";
        this.userNameDisabled           = "";
        this.flagPortPair               = "";
        this.contractCompany            = "";
        this.POLDesc                    = "";
        this.PODDesc                    = "";

        //##01 Begin
        this.contractPartyStatus        = "Expired";
        this.pkEsvPpHdrSeq              = "";
        this.pwd                        = "";
        this.reactPwd                   = "";
        this.pkEsvPpDtlSeq              = "";
        this.portPairStatusFlag         = "";
        //##01 End
    }

    public void setPkPortPairSeq(String pkPortPairSeq) {
        this.pkPortPairSeq = pkPortPairSeq;
    }

    public String getPkPortPairSeq() {
        return pkPortPairSeq;
    }

    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId;
    }

    public String getFkUserId() {
        return fkUserId;
    }

    public void setFkContractPartyCode(String fkContractPartyCode) {
        this.fkContractPartyCode = fkContractPartyCode;
    }

    public String getFkContractPartyCode() {
        return fkContractPartyCode;
    }

    public void setContractPartyName(String contractPartyName) {
        this.contractPartyName = contractPartyName;
    }

    public String getContractPartyName() {
        return contractPartyName;
    }

    public void setFkPOL(String fkPOL) {
        this.fkPOL = fkPOL;
    }

    public String getFkPOL() {
        return fkPOL;
    }

    public void setFkPOD(String fkPOD) {
        this.fkPOD = fkPOD;
    }

    public String getFkPOD() {
        return fkPOD;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }

    public String getRecStatus() {
        return recStatus;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }

    public String getEffDate() {
        return effDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setApproveFlag(String approveFlag) {
        this.approveFlag = approveFlag;
    }

    public String getApproveFlag() {
        return approveFlag;
    }

    public void setContractPartyNameDisabled(String contractPartyNameDisabled) {
        this.contractPartyNameDisabled = contractPartyNameDisabled;
    }

    public String getContractPartyNameDisabled() {
        return contractPartyNameDisabled;
    }

    public void setErrCrmDesc(String errCrmDesc) {
        this.errCrmDesc = errCrmDesc;
    }

    public String getErrCrmDesc() {
        return errCrmDesc;
    }

    public void setContractPartyFscCode(String contractPartyFscCode) {
        this.contractPartyFscCode = contractPartyFscCode;
    }

    public String getContractPartyFscCode() {
        return contractPartyFscCode;
    }

    public void setContractPartyType(String contractPartyType) {
        this.contractPartyType = contractPartyType;
    }

    public String getContractPartyType() {
        return contractPartyType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setFlagPortPair(String flagPortPair) {
        this.flagPortPair = flagPortPair;
    }

    public String getFlagPortPair() {
        return flagPortPair;
    }

    public void setUserNameDisabled(String userNameDisabled) {
        this.userNameDisabled = userNameDisabled;
    }

    public String getUserNameDisabled() {
        return userNameDisabled;
    }

    public void setRecStatusDesc(String recStatusDesc) {
        this.recStatusDesc = recStatusDesc;
    }

    public String getRecStatusDesc() {
        return recStatusDesc;
    }

    public void setContractCompany(String contractCompany) {
        this.contractCompany = contractCompany;
    }

    public String getContractCompany() {
        return contractCompany;
    }

    public void setPOLDesc(String pOLDesc) {
        this.POLDesc = pOLDesc;
    }

    public String getPOLDesc() {
        return POLDesc;
    }

    public void setPODDesc(String pODDesc) {
        this.PODDesc = pODDesc;
    }

    public String getPODDesc() {
        return PODDesc;
    }

    public String getContractPartyStatus() {
        return contractPartyStatus;
    }

    public void setContractPartyStatus(String contractPartyStatus) {
        this.contractPartyStatus = contractPartyStatus;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    public String getReactPwd(){
        return reactPwd;
    }

    public void setReactPwd(String reactPwd){
        this.reactPwd = reactPwd;
    }

    public String getPkEsvPpHdrSeq(){
        return pkEsvPpHdrSeq;
    }

    public void setPkEsvPpHdrSeq(String pkEsvPpHdrSeq){
        this.pkEsvPpHdrSeq = pkEsvPpHdrSeq;
    }

    public String getPkEsvPpDtlSeq(){
        return pkEsvPpDtlSeq;
    }

    public void setPkEsvPpDtlSeq(String pkEsvPpDtlSeq){
        this.pkEsvPpDtlSeq = pkEsvPpDtlSeq;
    }

    public String getPortPairStatusFlag(){
        return portPairStatusFlag;
    }

    public void setPortPairStatusFlag(String portPairStatusFlag){
        this.portPairStatusFlag = portPairStatusFlag;
    }
}
