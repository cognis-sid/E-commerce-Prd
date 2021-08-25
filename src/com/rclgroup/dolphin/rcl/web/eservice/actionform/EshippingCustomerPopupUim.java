package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.ArrayList;
import java.util.List;

public class EshippingCustomerPopupUim extends PaginationForm{
    private String currPageAction;
    private String prevPageAction;
    
    private String tbxFind;
    private String columnValue;
    private String sortByValue;
    private String orderValue;
    private String chkBoxWildCard;
    private String cocSoc;
    private String podCountry;
    private String defaultSearch;
    private String bookingNo;
    
    private List columnList;
    private List sortByList;
    private List orderList;

    private List customerList;
    
    public EshippingCustomerPopupUim(){
        this.columnList = null;
        this.sortByList = null;
        this.orderList = null;
        this.customerList = null;
        
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
        this.cocSoc = null;
        this.podCountry = null;
        this.defaultSearch = null;
    }

    
    public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
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
}
