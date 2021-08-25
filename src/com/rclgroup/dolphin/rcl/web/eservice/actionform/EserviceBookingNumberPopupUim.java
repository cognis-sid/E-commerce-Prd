/*------------------------------------------------------
EserviceBookingNumberPopupUim.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
1   01/08/2014  Pratya  @01         Eservice phase 3.1
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.ArrayList;
import java.util.List;

public class EserviceBookingNumberPopupUim extends PaginationForm {
    
    private String tbxFind;
    private String columnValue;
    private String sortByValue;
    private String orderValue;
    private String chkBoxWildCard;
    private String page;
    private String statusValue;
    
    /*Begin @01*/
    private String pageFlag;
    /*End @01*/
    
    private List columnList;
    private List sortByList;
    private List orderList;
    private List statusList;
    private List tableData = new ArrayList();
    
    /*Begin @01*/
    public EserviceBookingNumberPopupUim(){
        this.pageFlag = "";
    }
    /*End @01*/
       
    public List getValues() {
        return this.tableData;
    }

    public void setValues(List aarlTableData) {
        this.tableData = aarlTableData;
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

    public void setColumnList(List columnList) {
        this.columnList = columnList;
    }

    public List getColumnList() {
        return columnList;
    }

    public void setSortByValue(String sortByValue) {
        this.sortByValue = sortByValue;
    }

    public String getSortByValue() {
        return sortByValue;
    }

    public void setSortByList(List sortByList) {
        this.sortByList = sortByList;
    }

    public List getSortByList() {
        return sortByList;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }

    public String getOrderValue() {
        return orderValue;
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

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }


    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusList(List statusList) {
        this.statusList = statusList;
    }

    public List getStatusList() {
        return statusList;
    }

    public void setPageFlag(String pageFlag) {
        this.pageFlag = pageFlag;
    }

    public String getPageFlag() {
        return pageFlag;
    }
}
