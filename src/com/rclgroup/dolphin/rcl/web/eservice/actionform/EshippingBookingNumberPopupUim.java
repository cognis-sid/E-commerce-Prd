package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.ArrayList;
import java.util.List;

public class EshippingBookingNumberPopupUim extends PaginationForm {
    private String currPageAction;
    private String prevPageAction;
    
    private String tbxFind;
    private String columnValue;
    private String sortByValue;
    private String orderValue;
    private String chkBoxWildCard;
    private String page;
    private String statusValue;
    private String defaultSearch;

    private List columnList;
    private List sortByList;
    private List orderList;
    private List statusList;
    private List bookingList;
    
    public EshippingBookingNumberPopupUim(){
        this.columnList = null;
        this.sortByList = null;
        this.orderList = null;
        this.statusList = null;
        this.bookingList = null;
        
        resetForm();
    }
    
    public void resetForm(){
        this.currPageAction = null;
        this.prevPageAction = null;
        this.tbxFind = null;
        this.columnValue = null;
        this.sortByValue = null;
        this.orderValue = null;
        this.chkBoxWildCard = null;
        this.page = null;
        this.statusValue = null;
        this.defaultSearch = null;
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

    public void setBookingList(List bookingList){
        this.bookingList = bookingList;
    }

    public List getBookingList(){
        return bookingList;
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

    public void setDefaultSearch(String defaultSearch){
        this.defaultSearch = defaultSearch;
    }

    public String getDefaultSearch(){
        return defaultSearch;
    }
}
