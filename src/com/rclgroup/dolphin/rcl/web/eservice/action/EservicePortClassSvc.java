 /*------------------------------------------------------
  EservicePortClassSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 08/08/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePortClassUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EservicePortClassDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EservicePortClassSvc extends BaseAction {
    public  static final String DAO_BEAN_ID         = "EservicePortClassDao";
    private static final String GET_LOOKUP_DATA     = "lookUpData";


    public EservicePortClassSvc() {
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
    public ActionForward executeAction(ActionMapping mapping, ActionForm form, 
                                       HttpServletRequest request, 
                                       HttpServletResponse response) throws Exception {
        //
        //        EserviceCommodityPopupUim objForm = (EserviceCommodityPopupUim)form;
        //
        //        populateComboData(objForm);

        String strAction = mapping.getParameter();
        if (ONLOAD.equals(strAction)) {
//            return onLoad(mapping, form, request);
            return getLookupData(mapping, form, request);
        } else if (GET_LOOKUP_DATA.equals(strAction)) {
            return getLookupData(mapping, form, request);
        }

        return mapping.findForward(SUCCESS);

    } //executeAction

    /**
     * This method called when screen loads
     * @param mapping
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public ActionForward onLoad(ActionMapping mapping, ActionForm form, 
                                HttpServletRequest request) throws Exception {

        EservicePortClassUim objForm = (EservicePortClassUim)form;

        request.setAttribute("listLookupData", null);
//        request.setAttribute("commodityList", null);

        populateComboData(objForm);

        return mapping.findForward(SUCCESS);

    } // end of onLoad method

    public void populateComboData(EservicePortClassUim objForm) {
        objForm.setColumnList(getColumnList());
        objForm.setSortByList(getColumnList());
        objForm.setOrderList(getComboBoxOrderBy());
        
    }

    public List getBlankComboList() {
        List list = new ArrayList(0);
        list.add(0, new ComboVO("", SELECT_ONE));

        return list;
    }


    public ActionForward getLookupData(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
        System.out.println("[EservicePortClassSvc][getLookupData][Begin]");
        //------------------- varable declaration.
        List                        lstTableData        = null;
        int                         intTotDBRec         = 0;
        int                         intTotListRec       = 0;
        Map                         mapParam            = new HashMap();
        Map                         result              = null;
        List                        list                = null;
        EservicePortClassUim        objForm             = null;
        EservicePortClassDao        objDao              = null;
        
        try{
            //------------------- get object of form.
            objForm = (EservicePortClassUim)form;
    
            //------------------- get object of dao.
            objDao = (EservicePortClassDao)getDao(DAO_BEAN_ID);
    
            //------------------- 
    
            mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
            mapParam.put(KEY_USER_ID, getUserID(request));
    
            mapParam.put(EservicePortClassDao.KEY_CRITERIA_TEXT_FIND    , objForm.getFind());
            mapParam.put(EservicePortClassDao.KEY_CRITERIA_COLUMN       , objForm.getColumn());
            mapParam.put(EservicePortClassDao.KEY_CRITERIA_SORTBY       , objForm.getSortBy());
            mapParam.put(EservicePortClassDao.KEY_CRITERIA_ORDER        , objForm.getOrder());
            mapParam.put(EservicePortClassDao.KEY_CRITERIA_WILDCARD     , objForm.getChkBoxWildCard());
    
            result      = objDao.getList(mapParam);
            list        = (List)result.get(EservicePortClassDao.KEY_DATA);
            
            System.out.println("[EservicePortClassSvc][getLookupData] list :: " + list.size());
    
            if (null != list) {
                intTotListRec   = (Integer)result.get(KEY_SIZE);
                intTotDBRec     = -1;
                lstTableData    = getTableDataForPortClass(list, objForm.getCurrPageNo());
            }
            
            System.out.println("[EservicePortClassSvc][getLookupData] lstTableData :: " + lstTableData);
            System.out.println("[EservicePortClassSvc][getLookupData] lstTableData.size() :: " + lstTableData.size());
            
            if (null == lstTableData || lstTableData.size() == 0) {
                objForm.setTotRecord(0);
                objForm.setValues(new ArrayList());
            } else {
                objForm.setSearchPerformed("true");
                objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                objForm.setValues(lstTableData);
            }
    
            populateComboData(objForm);
    
            System.out.println("[EservicePortClassSvc][getLookupData] listLookupData :: " + objForm.getValues());
            
            objForm.setTableData(objForm.getValues());
    
//            request.setAttribute("listLookupData", objForm.getValues());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EservicePortClassSvc][getLookupData][End]");
        }
        
        return mapping.findForward(SUCCESS);
    }

    public List getComboBoxOrderBy()
    {
        List list = new ArrayList();
        list.add(new ComboVO(EservicePortClassDao.KEY_COLUMN_ORDER_ASC,  EservicePortClassDao.KEY_COLUMN_SHOW_ORDER_ASC));
        list.add(new ComboVO(EservicePortClassDao.KEY_COLUMN_ORDER_DESC, EservicePortClassDao.KEY_COLUMN_SHOW_ORDER_DESC));
        return list;
    }
    
    public List getColumnList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("", "Select One..."));
        list.add(new ComboVO("PORT_CLASS_CODE"  , "Port Class"));
        list.add(new ComboVO("PORT_CLASS_TYPE"  , "Port class type"));
        list.add(new ComboVO("UNNO"             , "UNNO"));
        list.add(new ComboVO("VARIANT"          , "VARIANT"));
        list.add(new ComboVO("IMDG_CLASS"       , "IMDG"));
        list.add(new ComboVO("PSN"              , "PSN"));
        list.add(new ComboVO("DGRCST"           , "RECORD STATUS"));
        return list;
    }
    
    public List getSortByList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("PORT_CLASS_CODE"  , "Port Class"));
        list.add(new ComboVO("PORT_CLASS_TYPE"  , "Port class type"));
        list.add(new ComboVO("UNNO"             , "UNNO"));
        list.add(new ComboVO("VARIANT"          , "VARIANT"));
        list.add(new ComboVO("IMDG_CLASS"       , "IMDG"));
        list.add(new ComboVO("PSN"              , "PSN"));
        list.add(new ComboVO("DGRCST"           , "RECORD STATUS"));
        return list;
    }

}

/* * end of class * */
