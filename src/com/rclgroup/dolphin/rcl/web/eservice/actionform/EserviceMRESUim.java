package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.BaseActionForm;

import com.niit.control.web.actionform.PaginationForm;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESNotificationsMod;

import java.util.List;
import java.util.Map;

public class EserviceMRESUim extends PaginationForm{
    public static final String ORDER_BY_DEFAULT = SORT_IN_DESC;

    public static final String SORT_TYPE_ID = "1";
    public static final String SORT_TYPE_SUBJECT = "2";
    public static final String SORT_TYPE_DATE = "3";
    public static final String SORT_TYPE_DEFAULT = SORT_TYPE_DATE;    
    private List<EserviceMRESNotificationsMod> notificationsList;
    
    private Map<String, List<EserviceMRESMyEServiceMod>> esvMap;
    
    private Integer totalNotification;
    private String currPageAction;
    private String prevPageAction;
    private String sortCol;
    private String orderBy;
    private String idSortCol;
    private String idOrderBy;
    private String subjectSortCol;
    private String subjectOrderBy;
    private String dateSortCol;
    private String dateOrderBy;
    private String errMsg;
    private String fullCurrentDate;
    private String passwordEncrypt;
    private boolean authPass;
    
    public EserviceMRESUim(){
        this.notificationsList = null;
        this.currPageAction = null;
        this.prevPageAction = null;
        this.sortCol = SORT_TYPE_DEFAULT;
        this.orderBy = ORDER_BY_DEFAULT;
        this.idSortCol = SORT_TYPE_ID;
        this.idOrderBy = ORDER_BY_DEFAULT;
        this.subjectSortCol = SORT_TYPE_SUBJECT;
        this.subjectOrderBy = ORDER_BY_DEFAULT;
        this.dateSortCol = SORT_TYPE_DATE;
        this.dateOrderBy=ORDER_BY_DEFAULT;
        this.errMsg = null;
        this.authPass = false;
        this.totalNotification = null;
        this.fullCurrentDate = null;
        this.esvMap = null;
        this.passwordEncrypt = null;
    }

    public void setNotificationsList(List<EserviceMRESNotificationsMod> notificationsList){
        this.notificationsList = notificationsList;
    }

    public List<EserviceMRESNotificationsMod> getNotificationsList(){
        return notificationsList;
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

    public void setErrMsg(String errMsg){
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }

    public void setTotalNotification(Integer totalNotification){
        this.totalNotification = totalNotification;
    }

    public Integer getTotalNotification(){
        return totalNotification;
    }

    public void setAuthPass(boolean authPass){
        this.authPass = authPass;
    }

    public boolean getAuthPass(){
        return authPass;
    }

    public void setSortCol(String sortCol){
        this.sortCol = sortCol;
    }

    public String getSortCol(){
        return sortCol;
    }

    public void setOrderBy(String orderBy){
        this.orderBy = orderBy;
    }

    public String getOrderBy(){
        return orderBy;
    }

    public void setIdSortCol(String idSortCol){
        this.idSortCol = idSortCol;
    }

    public String getIdSortCol(){
        return idSortCol;
    }

    public void setIdOrderBy(String idOrderBy){
        this.idOrderBy = idOrderBy;
    }

    public String getIdOrderBy(){
        return idOrderBy;
    }

    public void setSubjectSortCol(String subjectSortCol){
        this.subjectSortCol = subjectSortCol;
    }

    public String getSubjectSortCol(){
        return subjectSortCol;
    }

    public void setSubjectOrderBy(String subjectOrderBy){
        this.subjectOrderBy = subjectOrderBy;
    }

    public String getSubjectOrderBy(){
        return subjectOrderBy;
    }

    public void setDateSortCol(String dateSortCol){
        this.dateSortCol = dateSortCol;
    }

    public String getDateSortCol(){
        return dateSortCol;
    }

    public void setDateOrderBy(String dateOrderBy){
        this.dateOrderBy = dateOrderBy;
    }

    public String getDateOrderBy(){
        return dateOrderBy;
    }

    public void setFullCurrentDate(String fullCurrentDate){
        this.fullCurrentDate = fullCurrentDate;
    }

    public String getFullCurrentDate(){
        return fullCurrentDate;
    }

    public void setEsvMap(Map<String, List<EserviceMRESMyEServiceMod>> esvMap){
        this.esvMap = esvMap;
    }

    public Map<String, List<EserviceMRESMyEServiceMod>> getEsvMap(){
        return esvMap;
    }

    public void setPasswordEncrypt(String passwordEncrypt){
        this.passwordEncrypt = passwordEncrypt;
    }

    public String getPasswordEncrypt(){
        return passwordEncrypt;
    }
}
