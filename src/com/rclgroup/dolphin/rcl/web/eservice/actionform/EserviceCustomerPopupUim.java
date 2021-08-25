/*------------------------------------------------------
 EserviceCustomerPopupUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 12/12/13
 - Change Log ----------------------------------------------------
##  DD/MM/YY    –User-      -TaskRef-       -ShortDescription-
    07/10/14    Pratya      01              PD_CR_20140826_ESV [Contract Party for registeration]
---------------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.List;

public class EserviceCustomerPopupUim extends PaginationForm {
    private String currPageAction;
    private String prevPageAction;
    
    private String userId;
    private String fscCode;
    private String controlFsc;
    
    private String tbxFind;
    private String columnValue;
    private String sortByValue;
    private String orderValue;
    private String chkBoxWildCard;
    private String cocSoc;
    private String podCountry;
    private String defaultSearch;
    private String country;
    
    /*Begin @01*/
    private String rowIndex;
    /*End @01*/
    
    private List columnList;
    private List sortByList;
    private List orderList;

    private List customerList;
    
    public EserviceCustomerPopupUim(){
        resetForm();
        
        this.currPageAction = null;
        
        this.columnList = null;
        this.sortByList = null;
        this.orderList = null;
    }
    
    public void resetForm(){
        this.prevPageAction     = null;
        this.userId             = null;
        this.fscCode            = null;
        this.controlFsc         = null;
        this.tbxFind            = null;
        this.columnValue        = null;
        this.sortByValue        = null;
        this.orderValue         = null;
        this.chkBoxWildCard     = null;
        this.cocSoc             = null;
        this.podCountry         = null;
        this.defaultSearch      = null;
        this.customerList       = null;
        this.rowIndex           = "";
    }
    
    public void setControlFsc(String controlFsc){
        this.controlFsc = controlFsc;
    }

    public String getControlFsc(){
        return controlFsc;
    }

    public void setTbxFind(String tbxFind) {
        this.tbxFind = tbxFind;
    }

    public String getTbxFind() {
        return tbxFind;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setSortByValue(String sortByValue) {
        this.sortByValue = sortByValue;
    }

    public String getSortByValue() {
        return sortByValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setChkBoxWildCard(String chkBoxWildCard) {
        this.chkBoxWildCard = chkBoxWildCard;
    }

    public String getChkBoxWildCard() {
        return chkBoxWildCard;
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

    public void setOrderList(List orderList) {
        this.orderList = orderList;
    }

    public List getOrderList() {
        return orderList;
    }

    public void setCustomerList(List customerList) {
        this.customerList = customerList;
    }

    public List getCustomerList() {
        return customerList;
    }

    public void setCocSoc(String cocSoc) {
        this.cocSoc = cocSoc;
    }

    public String getCocSoc() {
        return cocSoc;
    }

    public void setPodCountry(String podCountry) {
        this.podCountry = podCountry;
    }

    public String getPodCountry() {
        return podCountry;
    }

    public void setDefaultSearch(String defaultSearch) {
        this.defaultSearch = defaultSearch;
    }

    public String getDefaultSearch() {
        return defaultSearch;
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

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

    public void setFscCode(String fscCode){
        this.fscCode = fscCode;
    }

    public String getFscCode(){
        return fscCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowIndex() {
        return rowIndex;
    }
}
