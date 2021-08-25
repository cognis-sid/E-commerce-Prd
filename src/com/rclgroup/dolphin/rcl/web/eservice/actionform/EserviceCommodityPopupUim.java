package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import java.util.ArrayList;
import java.util.List;


public class EserviceCommodityPopupUim extends PaginationForm {

    // ------------------------------------default constructor

    public EserviceCommodityPopupUim() {
        setBackVisible(true);
        setRefreshVisible(false);
        setSaveVisible(true);
    }

    private String find = null;
    private String column = null;
    private List columnList = null;
//    private String sortBy = null;
    private List sortByList = null;
    private String order = null;
    private List orderList = null;
    private String chkBoxWildCard = null;
    private List tableData = new ArrayList();
    private String commodityRowIndex;

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
    public List getValues() {
        return this.tableData;
    }

    public void setValues(List aarlTableData) {
        this.tableData = aarlTableData;
    }

    public void setCommodityRowIndex(String commodityRowIndex) {
        this.commodityRowIndex = commodityRowIndex;
    }

    public String getCommodityRowIndex() {
        return commodityRowIndex;
    }
} // EserviceCommodityPopupUim
