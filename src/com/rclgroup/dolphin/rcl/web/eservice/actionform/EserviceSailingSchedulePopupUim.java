 /*------------------------------------------------------
  EserviceSailingSchedulePopupUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 11/09/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;
import com.niit.control.web.actionform.PaginationForm;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceSailingSchedulePopupDao;
import java.util.ArrayList;
import java.util.List;

public class EserviceSailingSchedulePopupUim extends PaginationForm {
    
    /*Begin combo*/
    private List    columnList;
    private List    sortByList;
    private List    orderList;
    /*End combo*/
    
    /*Begin column criteria*/
    private String  find;
    private String  column;
    private String  sortBy;
    private String  order;
    private String  chkBoxWildCard;
    /*End column criteria*/
    
    //table result
    private List    searchResultsList;
    
    /*Begin Default page*/
    private String  flag;
    private String  userId;
    private String  errorMsg;
    private String  rowIndex;
    private String  objName;
    /*End Default page*/
    
    public EserviceSailingSchedulePopupUim() {
        
        this.columnList     = new ArrayList();
        this.sortByList     = new ArrayList();
        this.orderList      = new ArrayList();
        
        this.flag           = "";
        this.userId         = "";
        this.errorMsg       = "";
        this.rowIndex       = "";
        this.objName        = "";
        
        this.resetForm();
    }
    
    public void resetForm(){
        setBackVisible(false);
        setRefreshVisible(false);
        setSaveVisible(false);
        this.find                   = "";
        this.column                 = "";
        this.sortBy                 = "";
        this.order                  = EserviceSailingSchedulePopupDao.KEY_COLUMN_ORDER_ASC;
        this.chkBoxWildCard         = "N";
        
        this.searchResultsList      = new ArrayList();
        
        resetFields();
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

    public void setSearchResultsList(List searchResultsList) {
        this.searchResultsList = searchResultsList;
    }

    public List getSearchResultsList() {
        return searchResultsList;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowIndex() {
        return rowIndex;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getObjName() {
        return objName;
    }
}
