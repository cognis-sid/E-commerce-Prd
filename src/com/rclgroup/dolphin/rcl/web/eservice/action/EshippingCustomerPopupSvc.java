/*------------------------------------------------------
 EshippingCustomerPopupSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2014
 --------------------------------------------------------
 Author Yossawat Suntisukkasem 17/01/14
 - Change Log -------------------------------------------
 ## DD/MM/YY –User- -TaskRef- -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.Debug;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIConstants;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIUtil;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingCustomerPopupUim;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustomerPopupDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EshippingCustomerPopupSvc extends BaseAction {
    public EshippingCustomerPopupSvc(){
    }
    private String getForwardPage(EshippingCustomerPopupUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        EshippingCustomerPopupUim form = null;
        
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
    
    private String initial(EshippingCustomerPopupUim form, HttpServletRequest request) throws Exception {
        String podCountry = null;
        String cocSoc = null;
        String defaultSearch = null;
        String forwardPage = SUCCESS;
        try{
            if(form.getColumnList() == null || form.getColumnList().isEmpty()){
                form.setColumnList(ComboBoxESIUtil.getCustomerColumnDDList());
            }
            if(form.getSortByList() == null || form.getSortByList().isEmpty()){
                form.setSortByList(ComboBoxESIUtil.getCustomerColumnDDList());
            }
            if(form.getOrderList() == null || form.getOrderList().isEmpty()){
                form.setOrderList(ComboBoxESIUtil.getOrderByDDList());
            }
            
            podCountry = request.getParameter("podCountry");
            cocSoc = request.getParameter("cocSoc");
            defaultSearch = request.getParameter("defaultSearch");
            
            Debug.logFramework("1.POD Country = "+podCountry+"\n"+
            "2.COC SOC = "+cocSoc+"\n3.Default search = "+defaultSearch);
            
            form.setPodCountry(podCountry);
            form.setCocSoc(cocSoc);
            form.setDefaultSearch(defaultSearch);
            
            forwardPage = lookUpData(form, request);
        }catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }
    
    private String lookUpData(EshippingCustomerPopupUim form, HttpServletRequest request) throws Exception {
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
                column = ComboBoxESIConstants.COLUMN_KEY.COUNTRY;

                form.setChkBoxWildCard("on");
            } else {
                tbxFind = form.getTbxFind();
                column = form.getColumnValue();
            }

            paramsMap = new HashMap();
            paramsMap.put(KEY_CURR_PAGE_NO, form.getCurrPageNo());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.TEXT_FIND, tbxFind);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.COLUMN, column);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.SORTBY, form.getSortByValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.ORDER, form.getOrderValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.WILDCARD, form.getChkBoxWildCard());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.FROM_RECORD, fromRecord);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.TO_RECORD, toRecord);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.ORG_CODE, getOrgCode(request));
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.COC_SOC, form.getCocSoc());
            paramsMap.put("BOOKING_NO", form.getBookingNo());
            objDao = getDao();
            if(objDao != null){
                configDate = objDao.getValueToConfigDate();
                if(configDate==null||BLANK.equals(configDate)){
                    paramsMap.put(EshippingInstructionDao.KEY_CONFIG_DATE, "180");
                } else {
                    paramsMap.put(EshippingInstructionDao.KEY_CONFIG_DATE, configDate);
                }
                
                resultMap = objDao.findCustomerForESICustomer(paramsMap);
                if(resultMap != null && !resultMap.isEmpty()){
                    if(resultMap.containsKey(EshippingInstructionDao.KEY_DATA)){
                        customerList = (List) resultMap.get(EshippingInstructionDao.KEY_DATA);
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

    private EshippingCustomerPopupUim getForm(ActionForm actionForm, String pageAction) throws Exception {
        EshippingCustomerPopupUim form = null;
        try {
            form = (EshippingCustomerPopupUim) actionForm;
            if (form == null){
                form = new EshippingCustomerPopupUim();
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
