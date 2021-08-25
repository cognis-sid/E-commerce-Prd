package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.List;

public class EshippingPackagePopupUim extends PaginationForm {
    private String packageCodeDocNameForSet;
    private String packageNameDocNameForSet;
    private String packageType;
    private String rowForSet;
    
    private String tbxFind;
    private String columnValue;
    private String sortByValue;
    private String orderValue;
    private String chkBoxWildCard;
    private String defaultSearch;
    
    private List columnList;
    private List sortByList;
    private List orderList;

    private List packageList;
    
    private String currPageAction;
    
    public EshippingPackagePopupUim(){    
        this.columnList = null;
        this.sortByList = null;
        this.orderList = null;
        this.packageList = null;
        
        resetForm();
    }
    
    public void resetForm(){
        this.packageCodeDocNameForSet = null;
        this.packageNameDocNameForSet = null;
        this.packageType = null;
        this.rowForSet = null;
        
        this.tbxFind = null;
        this.columnValue = null;
        this.sortByValue = null;
        this.orderValue = null;
        this.chkBoxWildCard = null;
        this.defaultSearch = null;
        
        this.currPageAction = null;
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

    public void setPackageList(List packageList) {
        this.packageList = packageList;
    }

    public List getPackageList() {
        return packageList;
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

    public void setPackageCodeDocNameForSet(String packageCodeDocNameForSet){
        this.packageCodeDocNameForSet = packageCodeDocNameForSet;
    }

    public String getPackageCodeDocNameForSet(){
        return packageCodeDocNameForSet;
    }

    public void setPackageNameDocNameForSet(String packageNameDocNameForSet){
        this.packageNameDocNameForSet = packageNameDocNameForSet;
    }

    public String getPackageNameDocNameForSet(){
        return packageNameDocNameForSet;
    }

    public void setPackageType(String packageType){
        this.packageType = packageType;
    }

    public String getPackageType(){
        return packageType;
    }

    public void setRowForSet(String rowForSet){
        this.rowForSet = rowForSet;
    }

    public String getRowForSet(){
        return rowForSet;
    }
}
