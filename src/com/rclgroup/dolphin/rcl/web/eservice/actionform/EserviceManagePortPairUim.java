 /*------------------------------------------------------
  EserviceManagePortPairUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 16/10/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    -User-       -TaskRef-   -ShortDescription-
 01  11/12/2015   Watchakorn               Change solution for Represented Company Contract
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.BaseActionForm;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceManagePortPairDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;

import java.util.ArrayList;
import java.util.List;


public class EserviceManagePortPairUim extends BaseActionForm {

    //Combo
    private List    columnList          = null;
    private List    sortByList          = null;
    private List    orderList           = null;

    //Field Criteria
    private String  find                = null;
    private String  column              = null;
    private String  sortBy              = null;
    private String  order               = null;
    private String  chkBoxWildCard      = null;
    private String  fkContractPartyCode = null;
    private String  userLoginId         = null;
    private String  POL                 = null;
    private String  POD                 = null;

    //Default param
    private String  pageAction          = null;
    private int     totRecord           = 0;
    
    
    //cognis
    private String  erroMessage   = "NO";    

    //Data return
    private String                                  maxPkPortPairSeq;
    private List <EserviceContractPartyPortPairMod> portpairContractPartyList;

    //##01 Begin
    private String                                  maxPkEsvPpHdrSeq;
    private List <EserviceContractPartyPortPairMod> userContractPartyList;
    private int                                     totPortpairRecord;
    private String                                  maxPkEsvPpDtlSeq;
    private String                                  selectedPkEsvPpHdrSeq;
    private List<EserviceContractPartyPortPairMod>  newUserList;
    private List<EserviceContractPartyPortPairMod>  newPortPairList;
    private List<EserviceContractPartyPortPairMod>  updPortPairList;
    private String                                  chkBoxExcludeExpiredPortPair;
    private String                                  customerName;
    //##01 End

    public EserviceManagePortPairUim() {
        setBackVisible(false);
        setRefreshVisible(false);
        setSaveVisible(false);

        this.pageAction = "";

        this.resetForm();
    }

    public void resetForm(){
        this.find                         = "";
        this.column                       = "";
        this.sortBy                       = "";
        this.order                        = EserviceManagePortPairDao.KEY_COLUMN_ORDER_ASC;
        this.chkBoxWildCard               = "N";
        this.fkContractPartyCode          = "";
        this.userLoginId                  = "";
        this.POL                          = "";
        this.POD                          = "";
        this.maxPkPortPairSeq             = "0";
        this.totRecord                    = 0;
        //##01 Begin
        this.portpairContractPartyList    = new ArrayList <EserviceContractPartyPortPairMod>();
        this.maxPkEsvPpHdrSeq             = "0";
        this.userContractPartyList        = new ArrayList <EserviceContractPartyPortPairMod> ();
        this.maxPkEsvPpDtlSeq             = "0";
        this.totPortpairRecord            = 0;
        this.selectedPkEsvPpHdrSeq        = "0";
        this.newUserList                  = new ArrayList<EserviceContractPartyPortPairMod>();
        this.newPortPairList              = new ArrayList<EserviceContractPartyPortPairMod>();
        this.updPortPairList              = new ArrayList<EserviceContractPartyPortPairMod>();
        this.chkBoxExcludeExpiredPortPair = "N";
        //##01 End
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }

    public void setColumnList(List columnList) {
        this.columnList = columnList;
    }

    public List getColumnList() {
        return columnList;
    }

    public void setSortByList(List sortByList) {
        this.sortByList = sortByList;
    }

    public List getSortByList() {
        return sortByList;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrderList(List orderList) {
        this.orderList = orderList;
    }

    public List getOrderList() {
        return orderList;
    }

    public void setChkBoxWildCard(String chkBoxWildCard) {
        this.chkBoxWildCard = chkBoxWildCard;
    }

    public String getChkBoxWildCard() {
        return chkBoxWildCard;
    }


    public void setFind(String find) {
        this.find = find;
    }

    public String getFind() {
        return find;
    }

    public void setFkContractPartyCode(String fkContractPartyCode) {
        this.fkContractPartyCode = fkContractPartyCode;
    }

    public String getFkContractPartyCode() {
        return fkContractPartyCode;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setMaxPkPortPairSeq(String maxPkPortPairSeq) {
        this.maxPkPortPairSeq = maxPkPortPairSeq;
    }

    public String getMaxPkPortPairSeq() {
        return maxPkPortPairSeq;
    }

    public void setPortpairContractPartyList(List<EserviceContractPartyPortPairMod> portpairContractPartyList) {
        this.portpairContractPartyList = portpairContractPartyList;
    }

    public List<EserviceContractPartyPortPairMod> getPortpairContractPartyList() {
        return portpairContractPartyList;
    }

    public void setPageAction(String pageAction) {
        this.pageAction = pageAction;
    }

    public String getPageAction() {
        return pageAction;
    }

    public void setPOL(String pOL) {
        this.POL = pOL;
    }

    public String getPOL() {
        return POL;
    }

    public void setPOD(String pOD) {
        this.POD = pOD;
    }

    public String getPOD() {
        return POD;
    }

    public void setTotRecord(int totRecord) {
        this.totRecord = totRecord;
    }

    public int getTotRecord() {
        return totRecord;
    }

    public void setMaxPkEsvPpHdrSeq(String maxPkEsvPpHdrSeq){
        this.maxPkEsvPpHdrSeq = maxPkEsvPpHdrSeq;
    }

    public String getMaxPkEsvPpHdrSeq(){
      return maxPkEsvPpHdrSeq;
    }

    public List<EserviceContractPartyPortPairMod> getUserContractPartyList() {
        return userContractPartyList;
    }

    public void setUserContractPartyList(List<EserviceContractPartyPortPairMod> userContractPartyList) {
        this.userContractPartyList = userContractPartyList;
    }

    public int getTotPortpairRecord(){
        return totPortpairRecord;
    }

    public void setTotPortpairRecord(int totPortpairRecord){
        this.totPortpairRecord = totPortpairRecord;
    }

    public String getMaxPkEsvPpDtlSeq(){
        return maxPkEsvPpDtlSeq;
    }

    public void setMaxPkEsvPpDtlSeq(String maxPkEsvPpDtlSeq){
        this.maxPkEsvPpDtlSeq = maxPkEsvPpDtlSeq;
    }

    public String getSelectedPkEsvPpHdrSeq(){
        return selectedPkEsvPpHdrSeq;
    }

    public void setSelectedPkEsvPpHdrSeq(String selectedPkEsvPpHdrSeq){
        this.selectedPkEsvPpHdrSeq = selectedPkEsvPpHdrSeq;
    }

    public List<EserviceContractPartyPortPairMod> getNewUserList(){
        return newUserList;
    }

    public void setNewUserList(List<EserviceContractPartyPortPairMod> newUserList){
        this.newUserList = newUserList;
    }

    public List<EserviceContractPartyPortPairMod> getNewPortPairList(){
        return newPortPairList;
    }

    public void setNewPortPairList(List<EserviceContractPartyPortPairMod> newPortPairList){
        this.newPortPairList = newPortPairList;
    }

    public List<EserviceContractPartyPortPairMod> getUpdPortPairList(){
        return updPortPairList;
    }

    public void setUpdPortPairList(List<EserviceContractPartyPortPairMod> updPortPairList){
        this.updPortPairList = updPortPairList;
    }

    public String getChkBoxExcludeExpiredPortPair(){
        return chkBoxExcludeExpiredPortPair;
    }

    public void setChkBoxExcludeExpiredPortPair(String chkBoxExcludeExpiredPortPair){
        this.chkBoxExcludeExpiredPortPair = chkBoxExcludeExpiredPortPair;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

	public String getErroMessage() {
		return erroMessage;
	}

	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}

	
}
