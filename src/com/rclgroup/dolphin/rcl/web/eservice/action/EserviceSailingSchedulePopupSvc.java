 /*------------------------------------------------------
 EserviceSailingSchedulePopupSvc.java
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
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceSailingSchedulePopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceSailingSchedulePopupDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EserviceSailingSchedulePopupSvc extends BaseAction {
    public  static final String DAO_BEAN_ID                 = "EserviceSailingSchedulePopupDao";
    private static final String GET_HAULAGE_LOOKUP_DATA     = "hualageLookUp";
    private static final String GET_PORT_LOOKUP_ONLOAD      = "portLookUpOnload";
    private static final String GET_PORT_LOOKUP_DATA        = "portLookUp";
    private static final String GET_PLACE_LOOKUP_DATA       = "placeLookUp";


    public EserviceSailingSchedulePopupSvc() {
        
    }
    
    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceSailingSchedulePopupUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction   = null;
        String forwardPage  = null;
        
        try{
            pageAction = this.getPageAction(mapping);
        
            if (GET_HAULAGE_LOOKUP_DATA.equals(pageAction)) {
                forwardPage = this.getHualageLookUpData(mapping, form, request);
            }else if (GET_PORT_LOOKUP_DATA.equals(pageAction) ||GET_PORT_LOOKUP_ONLOAD.equals(pageAction)) {
                forwardPage = this.getPortLookUpData(mapping, form, request);
            }else if (GET_PLACE_LOOKUP_DATA.equals(pageAction)) {
                forwardPage = this.getPlaceLookUpData(mapping, form, request);
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

        EserviceSailingSchedulePopupUim     form            = null;
        String                              pageAction      = null;
        String                              errorMsg        = null;
        String                              forwardPage     = null;
        try{
            pageAction  = this.getPageAction(mapping);
            form        = this.getForm(actionForm, pageAction);
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
    
     private EserviceSailingSchedulePopupUim getForm(ActionForm actionForm, String pageAction) throws Exception{
         EserviceSailingSchedulePopupUim form = null;
         try{
             form = (EserviceSailingSchedulePopupUim) actionForm;
             if (form == null){
                 form = new EserviceSailingSchedulePopupUim();
             }
             
             if(pageAction.equals(GET_PORT_LOOKUP_ONLOAD)) form.resetForm();
             
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

    public void populateComboData(EserviceSailingSchedulePopupUim objForm) {
        objForm.setColumnList(getColumnList());
        objForm.setSortByList(getColumnList());
        objForm.setOrderList(getComboBoxOrderBy());
        
    }

    public String getHualageLookUpData(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceSailingSchedulePopupSvc][getHualageLookUpData][Begin]");
        //------------------- varable declaration.
        List                                    lstTableData        = null;
        int                                     intTotDBRec         = 0;
        int                                     intTotListRec       = 0;
        Map                                     mapParam            = new HashMap();
        Map                                     result              = null;
        List                                    list                = null;
        EserviceSailingSchedulePopupUim         objForm             = null;
        EserviceSailingSchedulePopupDao         objDao              = null;
        String                                  forwardPage         = FAILURE;
        
        try{
            //------------------- get object of form.
            objForm = (EserviceSailingSchedulePopupUim)form;
    
            //------------------- get object of dao.
            objDao = (EserviceSailingSchedulePopupDao)getDao(DAO_BEAN_ID);
    
            //------------------- 
    
//            mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
//            mapParam.put(KEY_USER_ID, getUserID(request));
    
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_TEXT_FIND    , objForm.getFind());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_COLUMN       , objForm.getColumn());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_SORTBY       , objForm.getSortBy());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_ORDER        , objForm.getOrder());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_WILDCARD     , objForm.getChkBoxWildCard());
    
            result      = objDao.getHuaLageList(mapParam);
            list        = (List)result.get(EserviceSailingSchedulePopupDao.KEY_DATA);
            
            System.out.println("[EserviceSailingSchedulePopupSvc][getHualageLookUpData] list :: " + list);
    
            if (null != list) {
                intTotListRec   = (Integer)result.get(KEY_SIZE);
                intTotDBRec     = -1;
                lstTableData    = getTableDataForSailingSchedulePopup(list, objForm.getCurrPageNo());
            }
            
            System.out.println("[EserviceSailingSchedulePopupSvc][getHualageLookUpData] CurrPageNo :: " + objForm.getCurrPageNo());
            System.out.println("[EserviceSailingSchedulePopupSvc][getHualageLookUpData] lstTableData :: " + lstTableData);
            System.out.println("[EserviceSailingSchedulePopupSvc][getHualageLookUpData] lstTableData.size() :: " + lstTableData.size());
            
            if (null == lstTableData || lstTableData.size() == 0) {
                objForm.setTotRecord(0);
                objForm.setSearchResultsList(new ArrayList());
            } else {
                objForm.setSearchPerformed("true");
                objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                objForm.setSearchResultsList(lstTableData);
            }
            
            objForm.setFlag(GET_HAULAGE_LOOKUP_DATA);
    
            populateComboData(objForm);
            
            forwardPage = SUCCESS;
    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceSailingSchedulePopupSvc][getHualageLookUpData][End]");
        }
        
        return forwardPage;
    }


    public String getPortLookUpData(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceSailingSchedulePopupSvc][getPortLookUpData][Begin]");
        //------------------- varable declaration.
        List                                    lstTableData        = null;
        int                                     intTotDBRec         = 0;
        int                                     intTotListRec       = 0;
        Map                                     mapParam            = new HashMap();
        Map                                     result              = null;
        List                                    list                = null;
        EserviceSailingSchedulePopupUim         objForm             = null;
        EserviceSailingSchedulePopupDao         objDao              = null;
        String                                  forwardPage         = FAILURE;
        String                                  rowIndex            = null;
        String                                  objName             = null;
        
        try{
            rowIndex    = FormatUtil.nullToBlank(request.getParameter("rowIndex"));
            objName     = FormatUtil.nullToBlank(request.getParameter("objName"));
            //------------------- get object of form.
            objForm = (EserviceSailingSchedulePopupUim)form;
    
            //------------------- get object of dao.
            objDao = (EserviceSailingSchedulePopupDao)getDao(DAO_BEAN_ID);
    
            //------------------- 
    
            mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
            mapParam.put(KEY_USER_ID, getUserID(request));
    
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_TEXT_FIND    , objForm.getFind());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_COLUMN       , objForm.getColumn());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_SORTBY       , objForm.getSortBy());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_ORDER        , objForm.getOrder());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_WILDCARD     , objForm.getChkBoxWildCard());
    
            result      = objDao.getPortList(mapParam);
            list        = (List)result.get(EserviceSailingSchedulePopupDao.KEY_DATA);
            
            System.out.println("[EserviceSailingSchedulePopupSvc][getPortLookUpData] list :: " + list);
    
            if (null != list) {
                intTotListRec   = (Integer)result.get(KEY_SIZE);
                intTotDBRec     = -1;
                lstTableData    = getTableDataForSailingSchedulePopup(list, objForm.getCurrPageNo());
            }
            
            System.out.println("[EserviceSailingSchedulePopupSvc][getPortLookUpData] lstTableData :: " + lstTableData);
            System.out.println("[EserviceSailingSchedulePopupSvc][getPortLookUpData] lstTableData.size() :: " + lstTableData.size());
            
            if (null == lstTableData || lstTableData.size() == 0) {
                objForm.setTotRecord(0);
                objForm.setSearchResultsList(new ArrayList());
            } else {
                objForm.setSearchPerformed("true");
                objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                objForm.setSearchResultsList(lstTableData);
            }
            
            objForm.setFlag(GET_PORT_LOOKUP_DATA);
            objForm.setObjName(objName);
            if(!rowIndex.equals("")) objForm.setRowIndex(rowIndex);
    
            populateComboData(objForm);
            
            forwardPage = SUCCESS;
    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceSailingSchedulePopupSvc][getPortLookUpData][End]");
        }
        
        return forwardPage;
    }
    
    public String getPlaceLookUpData(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceSailingSchedulePopupSvc][getPlaceLookUpData][Begin]");
        //------------------- varable declaration.
        List                                    lstTableData        = null;
        int                                     intTotDBRec         = 0;
        int                                     intTotListRec       = 0;
        Map                                     mapParam            = new HashMap();
        Map                                     result              = null;
        List                                    list                = null;
        EserviceSailingSchedulePopupUim         objForm             = null;
        EserviceSailingSchedulePopupDao         objDao              = null;
        String                                  forwardPage         = FAILURE;
        
        try{
            //------------------- get object of form.
            objForm = (EserviceSailingSchedulePopupUim)form;
    
            //------------------- get object of dao.
            objDao = (EserviceSailingSchedulePopupDao)getDao(DAO_BEAN_ID);
    
            //------------------- 
    
            mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
            mapParam.put(KEY_USER_ID, getUserID(request));
    
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_TEXT_FIND    , objForm.getFind());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_COLUMN       , objForm.getColumn());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_SORTBY       , objForm.getSortBy());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_ORDER        , objForm.getOrder());
            mapParam.put(EserviceSailingSchedulePopupDao.KEY_CRITERIA_WILDCARD     , objForm.getChkBoxWildCard());
    
            result      = objDao.getPlaceList(mapParam);
            list        = (List)result.get(EserviceSailingSchedulePopupDao.KEY_DATA);
            
            System.out.println("[EserviceSailingSchedulePopupSvc][getPlaceLookUpData] list :: " + list);
    
            if (null != list) {
                intTotListRec   = (Integer)result.get(KEY_SIZE);
                intTotDBRec     = -1;
                lstTableData    = getTableDataForSailingSchedulePopup(list, objForm.getCurrPageNo());
            }
            
            System.out.println("[EserviceSailingSchedulePopupSvc][getPlaceLookUpData] lstTableData :: " + lstTableData);
            System.out.println("[EserviceSailingSchedulePopupSvc][getPlaceLookUpData] lstTableData.size() :: " + lstTableData.size());
            
            if (null == lstTableData || lstTableData.size() == 0) {
                objForm.setTotRecord(0);
                objForm.setSearchResultsList(new ArrayList());
            } else {
                objForm.setSearchPerformed("true");
                objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                objForm.setSearchResultsList(lstTableData);
            }
            
            objForm.setFlag(GET_PLACE_LOOKUP_DATA);
    
            populateComboData(objForm);
            
            forwardPage = SUCCESS;
    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceSailingSchedulePopupSvc][getPlaceLookUpData][End]");
        }
        
        return forwardPage;
    }


    public List getComboBoxOrderBy()
    {
        List list = new ArrayList();
        list.add(new ComboVO(EserviceSailingSchedulePopupDao.KEY_COLUMN_ORDER_ASC,  EserviceSailingSchedulePopupDao.KEY_COLUMN_SHOW_ORDER_ASC));
        list.add(new ComboVO(EserviceSailingSchedulePopupDao.KEY_COLUMN_ORDER_DESC, EserviceSailingSchedulePopupDao.KEY_COLUMN_SHOW_ORDER_DESC));
        return list;
    }
    
    public List getColumnList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("", "Select One..."));
        list.add(new ComboVO("CODE"         , "Code"));
        list.add(new ComboVO("DESCRIPTION"  , "Description"));
        return list;
    }
    
    public List getSortByList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("CODE"         , "Code"));
        list.add(new ComboVO("DESCRIPTION"  , "Description"));
        return list;
    }

}

/* * end of class * */
