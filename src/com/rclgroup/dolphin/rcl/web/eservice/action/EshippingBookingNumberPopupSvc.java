package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.ComboBoxConstants;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIConstants;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingBookingNumberPopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceBookingNoPopupDao;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EshippingBookingNumberPopupSvc extends BaseAction {
    public EshippingBookingNumberPopupSvc(){
    }
    private String getForwardPage(EshippingBookingNumberPopupUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = form.getCurrPageAction();
            if ("onload".equals(pageAction)){
                forwardPage = initial(form, request);
            }else if("lookUpData".equals(pageAction)){
                forwardPage = lookUpData(form, request);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return forwardPage;
    }
    
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response){
        EshippingBookingNumberPopupUim form = null;
        
        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = getPageAction(mapping);

            form = getForm(actionForm, pageAction);
            form.setCurrPageAction(pageAction);

            forwardPage = getForwardPage(form, request, response);
        } catch (Exception ex) {
            ex.printStackTrace();

    //            forwardPage = form.getPrevPageAction();
    //            if ((forwardPage == null) || ("".equals(forwardPage))) {
                forwardPage = FAILURE;
    //            }
        }

        return mapping.findForward(forwardPage);
    }
    
    private String initial(EshippingBookingNumberPopupUim form, HttpServletRequest request) throws Exception {
        String forwardPage = SUCCESS;
        try{
            form.setDefaultSearch("true");
            if(form.getColumnList() == null || form.getColumnList().isEmpty()){
                form.setColumnList(ComboBoxESIUtil.getBookingColumnDDList());
            }
            if(form.getSortByList() == null || form.getSortByList().isEmpty()){
                form.setSortByList(ComboBoxESIUtil.getBookingColumnDDList());
            }
            if(form.getOrderList() == null || form.getOrderList().isEmpty()){
                form.setOrderList(ComboBoxESIUtil.getOrderByDDList());
            }
            if(form.getStatusList() == null || form.getStatusList().isEmpty()){
                 form.setStatusList(ComboBoxESIUtil.getESIStatusDDList());
            }
            
            forwardPage = lookUpData(form, request);
        }catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }
    
    private String lookUpData(EshippingBookingNumberPopupUim form, HttpServletRequest request) throws Exception {
        EserviceBookingNoPopupDao objDao = null;

        Map paramsMap = null;
        Map resultMap = null;

        List bookingList = null;
        
        String searchPerformed = null;
        String forwardPage = FAILURE;
        
        BigDecimal totalRow = null;

        int intTotDBRec = 0;
        int intTotListRec = 0;
        int fromRecord = 0;
        int toRecord = 0;
        int totalRecord = 0;
        try{
            fromRecord = getFromRecord(form.getCurrPageNo());
            toRecord = getToRecord(form.getCurrPageNo());

            if("true".equals(form.getDefaultSearch())){
                form.setSortByValue(ComboBoxESIConstants.BOOKING.BOOKING_DATE.getCode());
                form.setOrderValue(ComboBoxConstants.ORDER_BY.DESC.getCode());

                form.setChkBoxWildCard("on");
            }
            
            paramsMap = new HashMap();
            paramsMap.put(KEY_CURR_PAGE_NO, form.getCurrPageNo());
            paramsMap.put(KEY_USER_ID, getUserID(request));
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.TEXT_FIND, form.getTbxFind());
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.COLUMN, form.getColumnValue());
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.SORTBY, form.getSortByValue());
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.ORDER, form.getOrderValue());
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.STATUS, form.getStatusValue());
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.WILDCARD, form.getChkBoxWildCard());
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.FROM_RECORD, fromRecord);
            paramsMap.put(EserviceBookingNoPopupDao.CRITERIA_KEY.TO_RECORD, toRecord);

            objDao = getDao();
            if(objDao != null){
                resultMap = objDao.findESIBookingNoDetails(paramsMap);
                if(resultMap != null && !resultMap.isEmpty()){
                    if(resultMap.containsKey(EserviceBookingNoPopupDao.P_O_V.REF_CURSOR_DTL_DATA)){
                        bookingList = (List) resultMap.get(EserviceBookingNoPopupDao.P_O_V.REF_CURSOR_DTL_DATA);
                    }
                    if(resultMap.containsKey(EserviceBookingNoPopupDao.P_O_V.TOTAL_ROW)){
                        totalRow = (BigDecimal) resultMap.get(EserviceBookingNoPopupDao.P_O_V.TOTAL_ROW);
                        if(totalRow != null){
                            intTotListRec = totalRow.intValue();
                        }else{
                            intTotListRec = 0;
                        }
                    }
                    forwardPage = SUCCESS;
                }
            }
        } catch(Exception ex){
            throw ex;
        } finally{
            if(bookingList != null && !bookingList.isEmpty()){
                searchPerformed = "true";
                intTotDBRec = -1;
                totalRecord = getTotRec(intTotDBRec, intTotListRec);
            }else{
                bookingList = new ArrayList();
                totalRecord = 0;
            }
            form.setSearchPerformed(searchPerformed);
            form.setTotRecord(totalRecord);
            form.setBookingList(bookingList);
            
//            setComboBox(form);
        }
        return forwardPage;
    }
    
    public int getFromRecord(int aintCurrPageNo){
        return ((aintCurrPageNo - 1) * this.TOT_REC_PER_PAGE);
    }
    
    public int getToRecord(int aintCurrPageNo){
        return (aintCurrPageNo * this.TOT_REC_PER_PAGE) - 1;
    }

    private EshippingBookingNumberPopupUim getForm(ActionForm actionForm, String pageAction) throws Exception {
        EshippingBookingNumberPopupUim form = null;
        try {
            form = (EshippingBookingNumberPopupUim) actionForm;
            if (form == null){
                form = new EshippingBookingNumberPopupUim();
            }else if("onload".equals(pageAction)){
                form.resetForm();
            }
        } catch (Exception ex) {
            throw ex;
        }

        return form;
    }

    private String getPageAction(ActionMapping mapping) throws Exception {
        String pageAction = null;
        try {
            pageAction = mapping.getParameter();
        } catch (Exception ex) {
            pageAction = "";
        }

        return pageAction;
    }

    private EserviceBookingNoPopupDao getDao() throws Exception {
        EserviceBookingNoPopupDao dao = null;
        try {
            dao = (EserviceBookingNoPopupDao) getDao(EserviceBookingNoPopupDao.DAO_NAME);
        } catch (Exception ex) {
            throw ex;
        }
        return dao;
    }
}
