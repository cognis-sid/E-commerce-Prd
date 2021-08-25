 /*------------------------------------------------------
 EserviceEquipmentTypePopUpSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 11/09/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceEquipmentTypePopUpUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceEquipmentTypePopUpDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EserviceEquipmentTypePopUpSvc extends BaseAction {
    public  static final String DAO_BEAN_ID                     = "EserviceEquipmentTypePopUpDao";
    private static final String GET_EQUIP_TYPE_LOOKUP_DATA      = "equipTypeLookUp";


    public EserviceEquipmentTypePopUpSvc() {
        
    }
    
    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceEquipmentTypePopUpUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction   = null;
        String forwardPage  = null;
        
        try{
            pageAction = this.getPageAction(mapping);
        
            if (GET_EQUIP_TYPE_LOOKUP_DATA.equals(pageAction)) {
                forwardPage = this.getEquipTypeLookUpData(mapping, form, request);
            }
        } catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }

    /**
     *
     * Called from Action Servlet
     *
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, 
                                       HttpServletRequest request, 
                                       HttpServletResponse response) throws Exception {

        EserviceEquipmentTypePopUpUim       form            = null;
        String                              pageAction      = null;
        String                              errorMsg        = null;
        String                              forwardPage     = null;
        String                              transaction     = null;
        
        try{
            
            transaction         = FormatUtil.nullToBlank(request.getParameter("transaction"));
            form                = this.getForm(actionForm, pageAction, transaction);
            
            form.setUserId(getUserID(request));
            forwardPage = this.getForwardPage(mapping, actionForm, form, request, response);
            
        } catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
            form.setErrorMsg(errorMsg);

            forwardPage = FAILURE;
        }
        return mapping.findForward(forwardPage);

    } //executeAction
    
     private EserviceEquipmentTypePopUpUim getForm(ActionForm actionForm, String pageAction, String transaction) throws Exception{
         EserviceEquipmentTypePopUpUim form = null;
         try{
             form = (EserviceEquipmentTypePopUpUim) actionForm;
             if (form == null){
                 form = new EserviceEquipmentTypePopUpUim();
             }
             if(transaction.equals("new")) form.resetForm();
             
         } catch(Exception ex){
             throw ex;
         }

         return form;
     }
     
    private String getPageAction(ActionMapping mapping) throws Exception{
        String pageAction = null;
        try{
            pageAction = mapping.getParameter();
        } catch(Exception ex){
            pageAction = "";
        }

        return pageAction;
    }

    public void populateComboData(EserviceEquipmentTypePopUpUim objForm) {
        objForm.setColumnList(getColumnList());
        objForm.setSortByList(getColumnList());
        objForm.setOrderList(getComboBoxOrderBy());
        
    }

    public String getEquipTypeLookUpData(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceEquipmentTypePopUpSvc][getHualageLookUpData][Begin]");
        //------------------- varable declaration.
        List                                    lstTableData        = null;
        int                                     intTotDBRec         = 0;
        int                                     intTotListRec       = 0;
        Map                                     mapParam            = new HashMap();
        Map                                     result              = null;
        List                                    list                = null;
        EserviceEquipmentTypePopUpUim           objForm             = null;
        EserviceEquipmentTypePopUpDao           objDao              = null;
        String                                  forwardPage         = FAILURE;
        String                                  rowIndex            = null;
        
        try{
            
            rowIndex    = request.getParameter("rowIndex");
            
            //------------------- get object of form.
            objForm     = (EserviceEquipmentTypePopUpUim)form;
    
            //------------------- get object of dao.
            objDao      = (EserviceEquipmentTypePopUpDao)getDao(DAO_BEAN_ID);
    
            //------------------- 
    
//            mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
//            mapParam.put(KEY_USER_ID, getUserID(request));
    
            mapParam.put(EserviceEquipmentTypePopUpDao.KEY_CRITERIA_TEXT_FIND    , objForm.getFind());
            mapParam.put(EserviceEquipmentTypePopUpDao.KEY_CRITERIA_COLUMN       , objForm.getColumn());
            mapParam.put(EserviceEquipmentTypePopUpDao.KEY_CRITERIA_SORTBY       , objForm.getSortBy());
            mapParam.put(EserviceEquipmentTypePopUpDao.KEY_CRITERIA_ORDER        , objForm.getOrder());
            mapParam.put(EserviceEquipmentTypePopUpDao.KEY_CRITERIA_WILDCARD     , objForm.getChkBoxWildCard());
    
            result      = objDao.getEquipmentTypeList(mapParam);
            list        = (List)result.get(EserviceEquipmentTypePopUpDao.KEY_DATA);
            
            System.out.println("[EserviceEquipmentTypePopUpSvc][getEquipTypeLookUpData] list :: " + list);
    
            if (null != list) {
                intTotListRec   = (Integer)result.get(KEY_SIZE);
                intTotDBRec     = -1;
                lstTableData    = getTableDataForSailingSchedulePopup(list, objForm.getCurrPageNo());
            }
            
            System.out.println("[EserviceEquipmentTypePopUpSvc][getEquipTypeLookUpData] CurrPageNo :: " + objForm.getCurrPageNo());
            System.out.println("[EserviceEquipmentTypePopUpSvc][getEquipTypeLookUpData] lstTableData :: " + lstTableData);
            System.out.println("[EserviceEquipmentTypePopUpSvc][getEquipTypeLookUpData] lstTableData.size() :: " + lstTableData.size());
            
            if (null == lstTableData || lstTableData.size() == 0) {
                objForm.setTotRecord(0);
                objForm.setSearchResultsList(new ArrayList());
            } else {
                objForm.setSearchPerformed("true");
                objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                objForm.setSearchResultsList(lstTableData);
            }
            
            if(rowIndex!=null) objForm.setRowIndex(rowIndex);
    
            populateComboData(objForm);
            
            forwardPage = SUCCESS;
    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceEquipmentTypePopUpSvc][getEquipTypeLookUpData][End]");
        }
        
        return forwardPage;
    }

    public List getComboBoxOrderBy()
    {
        List list = new ArrayList();
        list.add(new ComboVO(EserviceEquipmentTypePopUpDao.KEY_COLUMN_ORDER_ASC,  EserviceEquipmentTypePopUpDao.KEY_COLUMN_SHOW_ORDER_ASC));
        list.add(new ComboVO(EserviceEquipmentTypePopUpDao.KEY_COLUMN_ORDER_DESC, EserviceEquipmentTypePopUpDao.KEY_COLUMN_SHOW_ORDER_DESC));
        return list;
    }
    
    public List getColumnList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("", "Select One..."));
        list.add(new ComboVO("code"   , "Code"));
        list.add(new ComboVO("descr"  , "Description"));
        return list;
    }
    
    public List getSortByList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("code"   , "Code"));
        list.add(new ComboVO("descr"  , "Description"));
        return list;
    }

}

/* * end of class * */
