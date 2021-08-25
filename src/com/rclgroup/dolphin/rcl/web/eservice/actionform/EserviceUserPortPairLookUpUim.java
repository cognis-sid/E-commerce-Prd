 /*------------------------------------------------------
  EserviceUserPortPairLookUpUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 21/10/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;
import com.niit.control.web.actionform.PaginationForm;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceUserPortPairLookUpDao;
import java.util.ArrayList;
import java.util.List;

public class EserviceUserPortPairLookUpUim extends PaginationForm {
    
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
    private String  userLoginId;
    private String  errorMsg;
    private String  rowIndex;
    /*End Default page*/
    
    public EserviceUserPortPairLookUpUim() {
        
        this.columnList     = new ArrayList();
        this.sortByList     = new ArrayList();
        this.orderList      = new ArrayList();
        
        this.errorMsg       = "";
        this.rowIndex       = "";
        this.userLoginId    = "";
        
        this.resetForm();
    }
    
    public void resetForm(){
        setBackVisible(false);
        setRefreshVisible(false);
        setSaveVisible(false);
        this.find                   = "";
        this.column                 = "";
        this.sortBy                 = "";
        this.order                  = EserviceUserPortPairLookUpDao.KEY_COLUMN_ORDER_ASC;
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

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserLoginId() {
        return userLoginId;
    }
}
