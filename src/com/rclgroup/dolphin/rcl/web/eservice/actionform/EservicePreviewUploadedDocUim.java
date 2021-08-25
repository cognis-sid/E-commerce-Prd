/*------------------------------------------------------
EservicePreviewUploadedDocUim.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Pratya Thanuchaisak 08/08/2014
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.ArrayList;
import java.util.List;

public class EservicePreviewUploadedDocUim extends PaginationForm {
    
    public static final String ASC                      = "ASC";
    public static final String DESC                     = "DESC";
    public static final String ASC_DESCRIPTION          = "Ascending";
    public static final String DESC_DESCRIPTION         = "Descending";
    
    //For combo
    private List   sortByComboList;
    private List   orderByComboList;
    
    //For default page
    private String userId;
    private String currPageAction;
    private String errMsg;
    private String fscCode;
    private String controlFsc;
    
    //for field in this screen
    private String bookingNo;
    private String bookingDateFrom;
    private String bookingDateTo;
    private String bookingDateBy;
    private String sortBy;
    private String orderBy;
    
    private List   searchResultsList;
    
    
    // ------------------------------------default constructor
    public EservicePreviewUploadedDocUim() {
        this.userId               = "";
        this.currPageAction       = "";
        this.errMsg               = "";
        this.fscCode              = "";
        this.controlFsc           = "";
        
        this.resetForm();
    }
    
    public void resetForm(){
        this.bookingNo                      = "";
        this.bookingDateFrom                = "";
        this.bookingDateTo                  = "";
        this.bookingDateBy                  = "";
        this.sortBy                         = "";
        this.orderBy                        = ASC;
        this.searchResultsList              = new ArrayList();
        
        resetFields();
    }

    public void setSortByComboList(List sortByComboList) {
        this.sortByComboList = sortByComboList;
    }

    public List getSortByComboList() {
        return sortByComboList;
    }

    public void setOrderByComboList(List orderByComboList) {
        this.orderByComboList = orderByComboList;
    }

    public List getOrderByComboList() {
        return orderByComboList;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setCurrPageAction(String currPageAction) {
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction() {
        return currPageAction;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingDateFrom(String bookingDateFrom) {
        this.bookingDateFrom = bookingDateFrom;
    }

    public String getBookingDateFrom() {
        return bookingDateFrom;
    }

    public void setBookingDateTo(String bookingDateTo) {
        this.bookingDateTo = bookingDateTo;
    }

    public String getBookingDateTo() {
        return bookingDateTo;
    }

    public void setBookingDateBy(String bookingDateBy) {
        this.bookingDateBy = bookingDateBy;
    }

    public String getBookingDateBy() {
        return bookingDateBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setSearchResultsList(List searchResultsList) {
        this.searchResultsList = searchResultsList;
    }

    public List getSearchResultsList() {
        return searchResultsList;
    }

    public void setFscCode(String fscCode) {
        this.fscCode = fscCode;
    }

    public String getFscCode() {
        return fscCode;
    }

    public void setControlFsc(String controlFsc) {
        this.controlFsc = controlFsc;
    }

    public String getControlFsc() {
        return controlFsc;
    }
}
