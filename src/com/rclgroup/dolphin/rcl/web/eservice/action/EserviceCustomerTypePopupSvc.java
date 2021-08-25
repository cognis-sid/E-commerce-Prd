 /*------------------------------------------------------
 EserviceCustomerTypePopupSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Yossawat Suntisukkasem 12/12/13
 - Change Log ----------------------------------------------------
##  DD/MM/YY    –User-      -TaskRef-       -ShortDescription-
    07/10/14    Pratya      01              PD_CR_20140826_ESV [Contract Party for registeration]
---------------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.ComboBoxESVUtil;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceCustomerTypePopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustomerPopupDao;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceUserPortPairLookUpDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCustomerTypePopupMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUserPortPairLookUpMod;

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

public class EserviceCustomerTypePopupSvc extends BaseAction {
    private String getForwardPage(EserviceCustomerTypePopupUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageAction = null;
        String forwardPage = FAILURE;
        try {
            pageAction = form.getCurrPageAction();
            if ("onload".equals(pageAction)){
                forwardPage = initial(form, request);
            }else if("lookUpData".equals(pageAction)){
//                forwardPage = lookUpData(form, request);
                forwardPage = lookUpDataNew(form, request);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return forwardPage;
    }
    
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response){
        EserviceCustomerTypePopupUim form = null;
        
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
    
    private String initial(EserviceCustomerTypePopupUim form, HttpServletRequest request) throws Exception {
        String forwardPage = SUCCESS;
        try{
            if(form.getColumnList() == null || form.getColumnList().isEmpty()){
                form.setColumnList(ComboBoxESVUtil.getCustomerTypeColumnDDList());
            }
            if(form.getSortByList() == null || form.getSortByList().isEmpty()){
                form.setSortByList(ComboBoxESVUtil.getCustomerTypeColumnDDList());
            }
            if(form.getOrderList() == null || form.getOrderList().isEmpty()){
                form.setOrderList(ComboBoxESVUtil.getOrderByDDList());
            }
            
//            forwardPage = lookUpData(form, request);
            forwardPage = lookUpDataNew(form, request);
        }catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }
    
    private String lookUpData(EserviceCustomerTypePopupUim form, HttpServletRequest request) throws Exception {
        
        System.out.println("[EserviceCustomerTypePopupSvc][lookUpData][Begin]");
        
        EserviceCustomerPopupDao    objDao              = null;
        Map                         paramsMap           = null;
        Map                         resultMap           = null;
        List                        customerList        = null;
        String                      tbxFind             = null;
        String                      column              = null;
        String                      searchPerformed     = "false";
        String                      forwardPage         = FAILURE;
        BigDecimal                  totalRow            = null;
        int                         intTotDBRec         = 0;
        int                         intTotListRec       = 0;
        int                         fromRecord          = 0;
        int                         toRecord            = 0;
        int                         totalRecord         = 0;
        /*Begin @01*/
        String                      rowIndex            = null;
        /*End @01*/
        
        try{
            fromRecord  = getFromRecord(form.getCurrPageNo());
            toRecord    = getToRecord(form.getCurrPageNo());
            
            /*Begin @01*/
            rowIndex    = request.getParameter("rowIndex");
            if(rowIndex!=null) form.setRowIndex(rowIndex);
            /*End @01*/
            
            if("true".equals(form.getDefaultSearch())){
                tbxFind = form.getTbxFind();
//                column = EserviceCustomerPopupDao.KEY_COLUMN_COUNTRY;

                form.setChkBoxWildCard("Y");
            } else {
                tbxFind = form.getTbxFind();
                column = form.getColumnValue();
            }

            paramsMap = new HashMap();
            paramsMap.put(KEY_CURR_PAGE_NO                                  , form.getCurrPageNo());
            paramsMap.put(KEY_USER_ID                                       , getUserID(request));
            paramsMap.put(KEY_USER_FSC                                      , getUserFsc(request));
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.TEXT_FIND   , tbxFind);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.IN          , column);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.SORT_COL    , form.getSortByValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.ORDER       , form.getOrderValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.WILDCARD    , form.getChkBoxWildCard());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.FROM_RECORD , fromRecord);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.TO_RECORD   , toRecord);
            
            objDao = getDao();
            if(objDao != null){
                resultMap = objDao.findCustomerTypeForESV(paramsMap);
                if(resultMap != null && !resultMap.isEmpty()){
                    if(resultMap.containsKey(EserviceCustomerPopupDao.P_O_V.CUST_TYPE_DATA)){
                        customerList = (List) resultMap.get(EserviceCustomerPopupDao.P_O_V.CUST_TYPE_DATA);
                    }
                    if(resultMap.containsKey(EserviceCustomerPopupDao.P_O_V.TOTAL_ROW)){
                        totalRow = (BigDecimal) resultMap.get(EserviceCustomerPopupDao.P_O_V.TOTAL_ROW);
                        if(totalRow != null){
                            intTotListRec = totalRow.intValue();
                        }
                    }
                    forwardPage = SUCCESS;
                }
            }
            
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpData] intTotListRec :: " + intTotListRec);
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
            
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpData][End]");
//            setComboBox(form);
        }
        return forwardPage;
    }
    
    private String lookUpDataNew(EserviceCustomerTypePopupUim form, HttpServletRequest request) throws Exception {
        
        System.out.println("[EserviceCustomerTypePopupSvc][lookUpDataNew][Begin]");
        
        EserviceCustomerPopupDao    objDao              = null;
        Map                         paramsMap           = null;
        Map                         resultMap           = null;
        List                        customerList        = null;
        String                      tbxFind             = null;
        String                      column              = null;
        String                      forwardPage         = FAILURE;
        int                         intTotDBRec         = 0;
        int                         intTotListRec       = 0;
        /*Begin @01*/
        String                      rowIndex            = null;
        /*End @01*/
         List<EserviceCustomerTypePopupMod>     list                = null;
        
        try{
            
            /*Begin @01*/
            rowIndex    = request.getParameter("rowIndex");
            if(rowIndex!=null) form.setRowIndex(rowIndex);
            /*End @01*/
            
            if("true".equals(form.getDefaultSearch())){
                tbxFind = form.getTbxFind();

                form.setChkBoxWildCard("on");
            } else {
                tbxFind = form.getTbxFind();
                column = form.getColumnValue();
            }

            paramsMap = new HashMap();
            paramsMap.put(KEY_CURR_PAGE_NO                                  , form.getCurrPageNo());
            paramsMap.put(KEY_USER_ID                                       , getUserID(request));
            paramsMap.put(KEY_USER_FSC                                      , getUserFsc(request));
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.TEXT_FIND   , tbxFind);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.IN          , column);
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.SORT_COL    , form.getSortByValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.ORDER       , form.getOrderValue());
            paramsMap.put(EserviceCustomerPopupDao.CRITERIA_KEY.WILDCARD    , form.getChkBoxWildCard());
            
            objDao = getDao();
            resultMap   = objDao.findCustomerTypeForESVNew(paramsMap);
            list        = (List<EserviceCustomerTypePopupMod>)resultMap.get(EserviceCustomerPopupDao.KEY_DATA);
            
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpDataNew] list :: " + list);
            
            if (null != list) {
                intTotListRec   = (Integer)resultMap.get(KEY_SIZE);
                intTotDBRec     = -1;
                customerList    = getTableDataNew(list, form.getCurrPageNo());
            }
            
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpDataNew] CurrPageNo          :: " + form.getCurrPageNo());
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpDataNew] lstTableData        :: " + customerList);
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpDataNew] lstTableData.size() :: " + customerList.size());
            
            if (null == customerList || customerList.size() == 0) {
                form.setTotRecord(0);
                form.setCustomerList(new ArrayList());
            } else {
                form.setSearchPerformed("true");
                form.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                form.setCustomerList(customerList);
            }
            
            form.setTbxFind(tbxFind);
            form.setColumnValue(column);
            
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpDataNew] intTotListRec :: " + intTotListRec);
            
            forwardPage = SUCCESS;
            
        } catch(Exception ex){
            throw ex;
        } finally{
            System.out.println("[EserviceCustomerTypePopupSvc][lookUpDataNew][End]");
        }
        return forwardPage;
    }
    
    public int getFromRecord(int aintCurrPageNo){
        return ((aintCurrPageNo - 1) * TOT_REC_PER_PAGE);
    }
    
    public int getToRecord(int aintCurrPageNo){
        return (aintCurrPageNo * TOT_REC_PER_PAGE) - 1;
    }

    private EserviceCustomerTypePopupUim getForm(ActionForm actionForm, String pageAction) throws Exception {
        EserviceCustomerTypePopupUim form = null;
        try {
            form = (EserviceCustomerTypePopupUim) actionForm;
            if (form == null){
                form = new EserviceCustomerTypePopupUim();
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
            pageAction = BLANK;
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
