 /*------------------------------------------------------
 EserviceCustomerTypePopupUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Yossawat Suntisukkasem 12/12/13
 - Change Log ----------------------------------------------------
##  DD/MM/YY    –User-      -TaskRef-       -ShortDescription-
    07/10/14    Pratya      01              PD_CR_20140826_ESV [Contract Party for registeration]
---------------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.common.ComboVO;
import com.niit.control.web.actionform.PaginationForm;

import java.util.List;

public class EserviceCustomerTypePopupUim extends PaginationForm {
    private String          currPageAction;
    private String          prevPageAction;
    
    private String          tbxFind;
    private String          columnValue;
    private String          sortByValue;
    private String          orderValue;
    private String          chkBoxWildCard;
    private String          defaultSearch;
    
    /*Begin @01*/
    private String          rowIndex;
    /*End @01*/
    
    private List<ComboVO>   columnList;
    private List<ComboVO>   sortByList;
    private List<ComboVO>   orderList;

    private List            customerList;
    
    public EserviceCustomerTypePopupUim(){
        resetForm();
        
        this.columnList     = null;
        this.sortByList     = null;
        this.orderList      = null;
    }
    
    public void resetForm(){
        this.currPageAction     = "";
        this.prevPageAction     = "";
        this.tbxFind            = "";
        this.columnValue        = "";
        this.sortByValue        = "";
        this.orderValue         = "";
        this.chkBoxWildCard     = "N";
        this.defaultSearch      = "";
        this.customerList       = null;
        this.rowIndex           = "";
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

    public void setColumnList(List<ComboVO> columnList) {
        this.columnList = columnList;
    }

    public List getColumnList() {
        return columnList;
    }

    public void setSortByList(List<ComboVO> sortByList) {
        this.sortByList = sortByList;
    }

    public List getSortByList() {
        return sortByList;
    }

    public void setOrderList(List<ComboVO> orderList) {
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

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowIndex() {
        return rowIndex;
    }
}
