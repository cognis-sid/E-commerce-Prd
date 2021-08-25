/*------------------------------------------------------
 EserviceCustomerPopupSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 12/12/13
 - Change Log ----------------------------------------------------
##  DD/MM/YY    –User-      -TaskRef-       -ShortDescription-
    07/10/14    Pratya      01              PD_CR_20140826_ESV [Contract Party for registeration]
---------------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.rclgroup.dolphin.rcl.web.common.ComboBoxESVUtil;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceCustomerPopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustomerPopupDao;


public class EserviceCustomerPopupSvc extends BaseAction {
    private String getForwardPage(EserviceCustomerPopupUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageAction = null;
        String forwardPage = FAILURE;
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
        EserviceCustomerPopupUim form = null;
        
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
    
    private String initial(EserviceCustomerPopupUim form, HttpServletRequest request) throws Exception {
        String userId           = null;
        String fscCode          = null;
        String controlFsc       = null;
        String country          = null;
        String forwardPage      = SUCCESS;
        /*Begin @01*/
        String rowIndex         = null;
        /*End @01*/
        
        try{
            userId = request.getParameter("userId");
            if(userId == null || BLANK.equals(userId)){
                userId = getUserID(request);
            }
            form.setUserId(userId);
            
            fscCode = request.getParameter("fscCode");
            if(fscCode == null || BLANK.equals(fscCode)){
                fscCode = getUserFsc(request);
            }
            form.setFscCode(fscCode);
            
            controlFsc = request.getParameter("controlFsc");
            if(controlFsc == null || BLANK.equals(controlFsc)){
                controlFsc = NO;
            }
            form.setControlFsc(controlFsc);
            
            country = FormatUtil.nullToBlank(request.getParameter("country"));
            form.setCountry(country);
            
            if(form.getColumnList() == null || form.getColumnList().isEmpty()){
                form.setColumnList(ComboBoxESVUtil.getCustomerColumnDDList());
            }
            if(form.getSortByList() == null || form.getSortByList().isEmpty()){
                form.setSortByList(ComboBoxESVUtil.getCustomerColumnDDList());
            }
            if(form.getOrderList() == null || form.getOrderList().isEmpty()){
                form.setOrderList(ComboBoxESVUtil.getOrderByDDList());
            }
            /*Begin @01*/
            rowIndex = request.getParameter("rowIndex");
            if(rowIndex!=null) form.setRowIndex(rowIndex);
            /*End @01*/
            
            forwardPage = lookUpData(form, request);
        }catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }
    
    private String lookUpData(EserviceCustomerPopupUim form, HttpServletRequest request) throws Exception {
        EserviceCustomerPopupDao objDao = null;

        Map paramsMap = null;
        Map resultMap = null;

        List customerList = null;

        String configDate = null;
        String tbxFind = null;
        String column = null;
        
        String searchPerformed = "false";
        String forwardPage = FAILURE;

        int intTotDBRec = 0;
        int intTotListRec = 0;
        int fromRecord = 0;
        int toRecord = 0;
        int totalRecord= 0;
        try{
            fromRecord = getFromRecord(form.getCurrPageNo());
            toRecord = getToRecord(form.getCurrPageNo());
            
            if("true".equals(form.getDefaultSearch())){
                tbxFind = form.getPodCountry();
                column = EserviceCustomerPopupDao.KEY_COLUMN_COUNTRY;

                form.setChkBoxWildCard("on");
            } else {
                tbxFind = form.getTbxFind();
                column = form.getColumnValue();
            }

            paramsMap = new HashMap();
            paramsMap.put(KEY_CURR_PAGE_NO, form.getCurrPageNo());
            paramsMap.put(KEY_USER_ID, getUserID(request));
            paramsMap.put(KEY_USER_FSC, getUserFsc(request));
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.TEXT_FIND, tbxFind);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.COLUMN, column);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.SORTBY, form.getSortByValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.ORDER, form.getOrderValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.WILDCARD, form.getChkBoxWildCard());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.FSC_CODE, form.getFscCode());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.CONTROL_FSC, form.getControlFsc());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.FROM_RECORD, fromRecord);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.TO_RECORD, toRecord);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.COUNTRY, form.getCountry());
//            paramsMap.put(EserviceCustomerPopupDao.KEY_ORG_CODE, getOrgCode(request));
//            paramsMap.put(EserviceCustomerPopupDao.KEY_COC_SOC, form.getCocSoc());
            
            objDao = getDao();
            if(objDao != null){
                resultMap = objDao.findCustomerForESVCustomer(paramsMap);
                if(resultMap != null && !resultMap.isEmpty()){
                    if(resultMap.containsKey(EserviceCustomerPopupDao.KEY_DATA)){
                        customerList = (List) resultMap.get(EserviceCustomerPopupDao.KEY_DATA);
                    }
                    if(resultMap.containsKey(KEY_SIZE)){
                        intTotListRec = (Integer) resultMap.get(KEY_SIZE);
                    }
                    forwardPage = SUCCESS;
                }
            }
        } catch(Exception ex){
            throw ex;
        } finally{
            if(customerList != null && !customerList.isEmpty()){
                searchPerformed = "true";
                intTotDBRec = -1;
                totalRecord = getTotRec(intTotDBRec, intTotListRec);
            }else{
                customerList = new ArrayList();
                totalRecord = 0;
            }
            form.setSearchPerformed(searchPerformed);
            form.setTotRecord(totalRecord);
            form.setCustomerList(customerList);
            form.setTbxFind(tbxFind);
            form.setColumnValue(column);
            
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

    private EserviceCustomerPopupUim getForm(ActionForm actionForm, String pageAction) throws Exception {
        EserviceCustomerPopupUim form = null;
        try {
            form = (EserviceCustomerPopupUim) actionForm;
            if (form == null){
                form = new EserviceCustomerPopupUim();
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

    private EserviceCustomerPopupDao getDao() throws Exception {
        EserviceCustomerPopupDao dao = null;
        try {
            dao = (EserviceCustomerPopupDao) getDao(EserviceCustomerPopupDao.DAO_NAME);
        } catch (Exception ex) {
            throw ex;
        }
        return dao;
    }
}

/* * end of class * */
