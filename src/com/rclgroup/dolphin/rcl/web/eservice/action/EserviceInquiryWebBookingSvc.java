/* -----------------------------------------------------------------------------
Name    : EserviceInquiryWebBookingSvc.java
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
NTL)Vikas         24/04/2013      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
## 04/10/2013   PRATYA  01           Eservice phase 3.1
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceBookingNumberPopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rclgroup.dolphin.rcl.web.eservice.dao.*;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceBookingListMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EserviceInquiryWebBookingSvc extends BaseAction 
{
    public static String DAO_BEAN_ID                = "EserviceInquiryWebBookingDao";
    public static String BROWSE_BOOKING_NUMBER      = "browseBookingNumber";
    public static String GET_DATA                   = "getData";
    public static String INPUT_YOURSELF_MODE        = "yourself";
    public static String KEY_DATA_TEMPLATE          = "TEMPLATE";    
    public EserviceInquiryWebBookingSvc() {
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

        String strAction = mapping.getParameter();
        if (ONLOAD.equals(strAction)) {
            this.onLoad(mapping, form, request);
        }else if(BROWSE_BOOKING_NUMBER.equals(strAction)){
            this.listBooking(mapping, form, request);
        }else if(GET_DATA.equals(strAction)){
            this.getWebBooking(mapping, form, request);
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
    	 EserviceBookingNumberPopupUim objForm=new EserviceBookingNumberPopupUim();
         request.setAttribute("equipmentList", null);
         request.setAttribute("commodityList", null);
         request.setAttribute("statusList", getComboBoxStatus(objForm));
        
         return mapping.findForward(SUCCESS);

     } // end of onLoad method
     
    
    public ActionForward listBooking(ActionMapping mapping, ActionForm form, 
                                HttpServletRequest request) throws Exception {
        
        List                            lstTableData    = null;
        int                             intTotDBRec     = 0;
        int                             intTotListRec   = 0;
        String                          pageFlag        = null;           
        EserviceBookingNumberPopupUim   objForm         = (EserviceBookingNumberPopupUim)form;
        EserviceInquiryWebBookingDao    objDao          = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID); 
        int                             fromRecord      = getFromRecord(objForm.getCurrPageNo());
        int                             toRecord        = getToRecord(objForm.getCurrPageNo());
        Map                             mapParam        = new HashMap();
        
        
        pageFlag = request.getParameter("pageFlag");
        
        mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
        mapParam.put(KEY_USER_ID, getUserID(request));
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_TEXT_FIND, objForm.getTbxFind());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_COLUMN, objForm.getColumnValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_SORTBY, objForm.getSortByValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_ORDER, objForm.getOrderValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_STATUS, objForm.getStatusValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_WILDCARD, objForm.getChkBoxWildCard());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_FROM_RECORD, fromRecord);
        mapParam.put(EserviceInquiryWebBookingDao.KEY_TO_RECORD, toRecord);
        
        Map result = objDao.getListWebBooking(mapParam);
        List list = (List)result.get(EserviceInquiryWebBookingDao.KEY_DATA);
        
        if(pageFlag!=null && !pageFlag.equals("")){
            objForm.setPageFlag(pageFlag);
        }
        
        if(null!=list)
        {
            intTotListRec = (Integer)result.get(KEY_SIZE);
            intTotDBRec = -1;
//            lstTableData = getTableData(list, objForm.getCurrPageNo());
            lstTableData = list;
        }
        
        if (null==lstTableData) 
        {
            objForm.setTotRecord(0);
            objForm.setValues(new ArrayList());
        } 
        else 
        {
            objForm.setSearchPerformed("true");
            objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
            objForm.setValues(lstTableData);
        }
        
        setComboBox(objForm);
        
        request.setAttribute("listBooking", objForm.getValues());
        
        return mapping.findForward(SUCCESS);

    }
    
    public void setComboBox(EserviceBookingNumberPopupUim objForm)
    {
        objForm.setColumnList(getComboBoxColumn());
        objForm.setSortByList(getComboBoxColumn());
        objForm.setOrderList(getComboBoxOrderBy());
        objForm.setStatusList(getComboBoxStatus(objForm));
    }
    
    public List getComboBoxColumn()
    {
        List list = new ArrayList();
        list.add(new ComboVO(BLANK, SELECT_ONE));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_BOOKING_DATE, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_DATE));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_BOOKING_NO, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_NO));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_POL, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_POL));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_POD, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_POD));
        return list;
    }
    
    public List getComboBoxOrderBy()
    {
        List list = new ArrayList();
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_ORDER_ASC, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_ORDER_ASC));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_ORDER_DESC, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_ORDER_DESC));
        return list;
    }
    
    public List getComboBoxStatus(EserviceBookingNumberPopupUim objForm)
    {
        List list = new ArrayList();
        list.add(new ComboVO(BLANK, SELECT_ONE));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_OPEN, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_OPEN));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_CONFIRMED, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_CONFIRMED));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_WASTLISTED, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_WASTLISTED));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_CANCELLED, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_CANCELLED));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_REJECTED, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_REJECTED));
        return list;
    }
    
    public ActionForward getWebBooking(ActionMapping mapping, ActionForm form, 
                                 HttpServletRequest request) throws Exception {
        System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking][Begin]");
        EserviceBookingNumberPopupUim   objstatus=new EserviceBookingNumberPopupUim();
        EserviceInquiryWebBookingUim    objForm                     = null;
        EserviceInquiryWebBookingDao    objDao                      = null;
        String                          bookingNo                   = null;
        String 							bookingStatus				= null;
        String                          modeGetData                 = null;
        Map                             mapParams                   = null;
        Map                             result                      = null;
        List<EserviceBookingListMod>    list                        = null;
        Boolean                         isDisableEditBooking        = null;
        EserviceBookingListMod          bookingObj                  = null;
        request.setAttribute("statusList", getComboBoxStatus(objstatus)); 
        try{
            objForm                     = (EserviceInquiryWebBookingUim)form;
            objDao                      = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID);
            bookingNo                   = objForm.getBookingNo();
            bookingStatus				= objForm.getStatus();
            modeGetData                 = objForm.getMode();
            mapParams                   = new HashMap();
            
            objForm.setNotFound(Boolean.FALSE);
            
            System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] modeGetData   :: " + modeGetData);
            System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] bookingNo     :: " + bookingNo);
            System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] bookingStatus     :: " + bookingStatus);
            System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] KEY_USER_ID   :: " + getUserID(request));
             
            if(INPUT_YOURSELF_MODE.equals(modeGetData)){
                mapParams.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_TEXT_FIND   , bookingNo);
                mapParams.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_COLUMN      , EserviceInquiryWebBookingDao.KEY_COLUMN_BOOKING_NO);
                mapParams.put(KEY_USER_ID                                           , getUserID(request));
                
                result      = objDao.getListWebBooking(mapParams);
                list        = (List<EserviceBookingListMod>)result.get(EserviceInquiryWebBookingDao.KEY_DATA);
                
                if(null!=list && !list.isEmpty()){
                    bookingObj              = list.get(0);
                    isDisableEditBooking    = !KEY_DATA_TEMPLATE.equals(bookingObj.getBookingType());
                    
                    mapParams.put(EserviceInquiryWebBookingDao.KEY_BOOKING_NO, bookingNo);
                    populateAllData(objForm, objDao, mapParams, request, isDisableEditBooking);
                }else{
                    objForm.setNotFound(Boolean.TRUE);
                }
            }else{
                mapParams.put(EserviceInquiryWebBookingDao.KEY_BOOKING_NO, bookingNo);
                mapParams.put(EserviceInquiryWebBookingDao.KEY_BOOKING_STATUS ,bookingStatus);
                // 16/11/2015 Add Param user id 
                mapParams.put(KEY_USER_ID, getUserID(request));
                
                isDisableEditBooking = !KEY_DATA_TEMPLATE.equals(objForm.getBookingType());
                if(objDao.checkBookingNoAndStatus(mapParams)>0) {
                populateAllData(objForm, objDao, mapParams, request, isDisableEditBooking);
                }else {
                	System.out.println("no Record found....");
                	objForm.setNotFound(Boolean.TRUE);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking][End]");
        }
         
         return mapping.findForward(SUCCESS);

     }
     
     public void populateAllData(EserviceInquiryWebBookingUim objForm, EserviceInquiryWebBookingDao objDao
                                    , Map mapParams, HttpServletRequest request
                                    , Boolean isDisableEditBooking) throws Exception {
        System.out.println("[EserviceInquiryWebBookingSvc][populateAllData][Begin]");
         
        EserviceNewWebBookingUim        eserviceNewWebBookingUim    = null;
        EserviceUploadUim               eserviceUploadUim           = null;
                                    
        try{
            eserviceNewWebBookingUim    = (EserviceNewWebBookingUim)request.getSession().getAttribute("feserv01");
            eserviceUploadUim           = new EserviceUploadUim();
            
            if(eserviceNewWebBookingUim==null){
                eserviceNewWebBookingUim = new EserviceNewWebBookingUim();
            }
            
            objDao.setBookingHeader(mapParams, objForm);
            objDao.setRoutingDetails(mapParams, objForm);
            objDao.setEquipmentDetails(mapParams, objForm);
            objDao.setCommodityDetails(mapParams, objForm);
            
            /*Begin @01*/
            objDao.setUploadListDetail(objForm, eserviceUploadUim);
            eserviceNewWebBookingUim.setEserviceUploadUim(eserviceUploadUim);
            eserviceNewWebBookingUim.setCommodityVoDataList(objForm.getCommodityDetails());
            request.getSession().setAttribute("feserv01", eserviceNewWebBookingUim);
            /*End @01*/
            
            request.setAttribute("routingList", objForm.getRoutingDetails());
            request.setAttribute("equipmentList", objForm.getEquipmentDetails());
            request.setAttribute("commodityList", objForm.getCommodityDetails());
            request.setAttribute("disabledEdit", isDisableEditBooking);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceInquiryWebBookingSvc][populateAllData][End]");
        }
     }
}
