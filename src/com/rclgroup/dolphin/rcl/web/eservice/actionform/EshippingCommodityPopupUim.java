package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.common.ComboVO;
import com.niit.control.web.actionform.PaginationForm;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityPopupMod;

import java.util.ArrayList;
import java.util.List;


public class EshippingCommodityPopupUim extends PaginationForm {

    // ------------------------------------default constructor
    private String commodityGroup;
    private String commodityCode;
    private String commodityDesc;
//    private String sortBy = null;
    private String orderBy = null;
    private String commodityRowIndex;
    private String page;
    private String defaultSearch;
    
    private String currPageAction;
    
    private List<ComboVO> commodityGroupList;
    private List<ComboVO> sortByList;
    private List<ComboVO> orderList;
//    private List orderList;
    private List<EshippingCommodityPopupMod> commodityList;
    
    private String chkBoxWildCard;
    
    public EshippingCommodityPopupUim(){  
        this.commodityGroupList = null;
        this.sortByList = null;
        this.orderList = null;
        this.commodityList = null;
        
        resetForm();
    }
    
    public void resetForm(){
        this.commodityGroup = null;
        this.commodityCode = null;
        this.commodityDesc = null;
        this.orderBy = null;
        this.commodityRowIndex = null;
        this.page = null;
        this.defaultSearch = null;
        this.currPageAction = null;
        this.chkBoxWildCard = "N";
        
        setBackVisible(true);
        setRefreshVisible(false);
        setSaveVisible(true);
    }

    public void setCommodityGroup(String commodityGroup) {
        this.commodityGroup = commodityGroup;
    }

    public String getCommodityGroup() {
        return commodityGroup;
    }
    
    public void setCommodityCode(String commodityCode){
        this.commodityCode = commodityCode;
    }
    
    public String getCommodityCode(){
        return commodityCode;
    }

    public void setCommodityGroupList(List<ComboVO> commodityGroupList) {
        this.commodityGroupList = commodityGroupList;
    }

    public List<ComboVO> getCommodityGroupList() {
        return commodityGroupList;
    }

    public void setSortByList(List<ComboVO> sortByList) {
        this.sortByList = sortByList;
    }

    public List<ComboVO> getSortByList() {
        return sortByList;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderList(List<ComboVO> orderList) {
        this.orderList = orderList;
    }

    public List<ComboVO> getOrderList() {
        return orderList;
    }

    public void setCommodityRowIndex(String commodityRowIndex) {
        this.commodityRowIndex = commodityRowIndex;
    }

    public String getCommodityRowIndex() {
        return commodityRowIndex;
    }


    public void setCommodityDesc(String commodityDesc) {
        this.commodityDesc = commodityDesc;
    }

    public String getCommodityDesc() {
        return commodityDesc;
    }


    public void setCommodityList(List<EshippingCommodityPopupMod> commodityList) {
        this.commodityList = commodityList;
    }

    public List getCommodityList() {
        return commodityList;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
//    public void setOrderList(List orderList) {
//        this.orderList = orderList;
//    }
//
//    public List getOrderList() {
//        return orderList;
//    }

    public void setDefaultSearch(String defaultSearch){
        this.defaultSearch = defaultSearch;
    }

    public String getDefaultSearch(){
        return defaultSearch;
    }

    public void setCurrPageAction(String currPageAction){
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction(){
        return currPageAction;
    }

    public void setChkBoxWildCard(String chkBoxWildCard) {
        this.chkBoxWildCard = chkBoxWildCard;
    }

    public String getChkBoxWildCard() {
        return chkBoxWildCard;
    }
} // EserviceCommodityPopupUim
