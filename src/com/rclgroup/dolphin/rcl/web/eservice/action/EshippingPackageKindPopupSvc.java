/*------------------------------------------------------
 EshippingCustomerPopupSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2014
 --------------------------------------------------------
 Author Yossawat Suntisukkasem 17/01/14
 - Change Log -------------------------------------------
 ## DD/MM/YY �User- -TaskRef- -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIUtil;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingPackagePopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EservicePackagePopupDao;

import java.math.BigDecimal;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EshippingPackageKindPopupSvc extends BaseAction {
    public EshippingPackageKindPopupSvc(){
    }
    
    private String getForwardPage(EshippingPackagePopupUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        EshippingPackagePopupUim form = null;
        
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
    
    private String initial(EshippingPackagePopupUim form, HttpServletRequest request) throws Exception {
        String packageCodeDocNameForSet = null;
        String packageNameDocNameForSet = null;
        String packageType = null;
        String rowForSet = null;
        String forwardPage = SUCCESS;
        try{
            packageCodeDocNameForSet = request.getParameter("packageCodeDocNameForSet");
            packageNameDocNameForSet = request.getParameter("packageNameDocNameForSet");
            packageType = request.getParameter("packageType");
            rowForSet = request.getParameter("rowForSet");
            System.out.println("1.packageCodeDocNameForSet = "+packageCodeDocNameForSet+
                "\n2.packageNameDocNameForSet = "+packageNameDocNameForSet+
                "\n3.packageType = "+packageType+
                "\n4.rowForSet = "+rowForSet);
                
            form.setPackageCodeDocNameForSet(packageCodeDocNameForSet); 
            form.setPackageNameDocNameForSet(packageNameDocNameForSet);
            form.setPackageType(packageType);
            form.setRowForSet(rowForSet);
            if(form.getColumnList() == null || form.getColumnList().isEmpty()){
                form.setColumnList(ComboBoxESIUtil.getPackageColumnDDList());
            }
            if(form.getSortByList() == null || form.getSortByList().isEmpty()){
                form.setSortByList(ComboBoxESIUtil.getPackageColumnDDList());
            }
            if(form.getOrderList() == null || form.getOrderList().isEmpty()){
                form.setOrderList(ComboBoxESIUtil.getOrderByDDList());
            }
            
            forwardPage = lookUpData(form, request);
        }catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }
    
    private String lookUpData(EshippingPackagePopupUim form, HttpServletRequest request) throws Exception {
        EservicePackagePopupDao objDao = null;
        
        List packageList = null;
        
        Map paramsMap = null;
        Map resultMap = null;
        
        String tbxFind = null;
        String column = null;
        String searchPerformed = null;
        String forwardPage = FAILURE;
        
        int totalRow =0;
        
        int intTotDBRec = 0;
        int intTotListRec = 0;
        int fromRecord = 0;
        int toRecord = 0;
        int totalRecord = 0;
        try{
            if("true".equals(form.getDefaultSearch())){
                tbxFind = BLANK;
                column = EservicePackagePopupDao.COLUMN_KEY.PACKAGE_CODE;

                form.setChkBoxWildCard("on");
            } else {
                tbxFind = form.getTbxFind();
                column = form.getColumnValue();
            }
            
            fromRecord = getFromRecord(form.getCurrPageNo());
            toRecord = getToRecord(form.getCurrPageNo());
            
            paramsMap = new HashMap();
            paramsMap.put(KEY_CURR_PAGE_NO, form.getCurrPageNo());
            paramsMap.put(EservicePackagePopupDao.CRITERIA_KEY.TEXT_FIND, tbxFind);
            paramsMap.put(EservicePackagePopupDao.CRITERIA_KEY.COLUMN, column);
            paramsMap.put(EservicePackagePopupDao.CRITERIA_KEY.SORTBY, form.getSortByValue());
            paramsMap.put(EservicePackagePopupDao.CRITERIA_KEY.ORDER, form.getOrderValue());
            paramsMap.put(EservicePackagePopupDao.CRITERIA_KEY.FROM_RECORD, fromRecord);
            paramsMap.put(EservicePackagePopupDao.CRITERIA_KEY.TO_RECORD, toRecord);
  
            objDao = getDao();
            if(objDao != null){
                resultMap = objDao.findPackageKindTypes(paramsMap);
                if(resultMap != null && !resultMap.isEmpty()){
                    if(resultMap.containsKey(EservicePackagePopupDao.P_O_V.REF_CURSOR_DTL_DATA)){
                        packageList = (List) resultMap.get(EservicePackagePopupDao.P_O_V.REF_CURSOR_DTL_DATA);
                    }
                    if(resultMap.containsKey(EservicePackagePopupDao.P_O_V.TOTAL_ROW)){
                        totalRow = (int) resultMap.get(EservicePackagePopupDao.P_O_V.TOTAL_ROW);
                    }else{
                        totalRow = new Integer(0);
                    }
                    
                    forwardPage = SUCCESS;
                }
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(packageList != null && !packageList.isEmpty()){
                searchPerformed = "true";
                intTotDBRec = -1;
                totalRecord = getTotRec(intTotDBRec, totalRow);
            }else{
                packageList = new ArrayList();
                totalRecord = 0;
            }
            form.setSearchPerformed(searchPerformed);
            form.setTotRecord(totalRecord);
            form.setPackageList(packageList);
            form.setTbxFind(tbxFind);
            form.setColumnValue(column);
            
//            setComboBoxPackageKind(form);
        }
        return forwardPage;
    }
    
    public int getFromRecord(int aintCurrPageNo){
        return ((aintCurrPageNo - 1) * this.TOT_REC_PER_PAGE);
    }
    
    public int getToRecord(int aintCurrPageNo){
        return (aintCurrPageNo * this.TOT_REC_PER_PAGE) - 1;
    }

    private EshippingPackagePopupUim getForm(ActionForm actionForm, String pageAction) throws Exception {
        EshippingPackagePopupUim form = null;
        try {
            form = (EshippingPackagePopupUim) actionForm;
            if (form == null){
                form = new EshippingPackagePopupUim();
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

    private EservicePackagePopupDao getDao() throws Exception {
        EservicePackagePopupDao dao = null;
        try {
            dao = (EservicePackagePopupDao) getDao(EservicePackagePopupDao.DAO_NAME);
        } catch (Exception ex) {
            throw ex;
        }
        return dao;
    }
}
