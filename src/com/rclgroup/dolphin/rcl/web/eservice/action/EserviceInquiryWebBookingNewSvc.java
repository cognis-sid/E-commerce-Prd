package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.ComboVO;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingNewUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceBookingListMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceInquiryCustomerDtlMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRoutingDetailsMod;



public class EserviceInquiryWebBookingNewSvc extends BaseAction 
{
    public static String DAO_BEAN_ID                = "EserviceInquiryWebBookingDao";
    public static String BROWSE_BOOKING_NUMBER      = "browseBookingNumber";
    public static String GET_DATA                   = "getData";
    public static String GET_MORE_DATA				= "getmoredata";
    public static String INPUT_YOURSELF_MODE        = "yourself";
    public static String KEY_DATA_TEMPLATE          = "TEMPLATE"; 
    public static String GET_DATA_BTN     				= "getWebBookingNewBtn";
    public static String GET_TEMPLATE					="getTemplate";
    public static String DELETE_TEMPLATE			= "deleteTemplate";
    public EserviceInquiryWebBookingNewSvc() {
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
        	this.getWebBookingNew(mapping, form, request);
        	//this.getWebBooking(mapping, form, request);
        }else if(GET_MORE_DATA.equals(strAction)) {
        	this.getMoreWebBooking(mapping, form, request,response);
        }else if(GET_DATA_BTN.equals(strAction)) {
        	this.getWebBookingBtn(mapping, form, request);
        }else if(GET_TEMPLATE.equals(strAction)) {
        	this.getTemlate(mapping, form, request);
        }else if(DELETE_TEMPLATE.equals(strAction)) {
        	this.deleteTemlate(mapping, form, request);
        }
        
        return mapping.findForward(SUCCESS);

    } //executeAction
    
    private ActionForward deleteTemlate(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
		
    	EserviceInquiryWebBookingDao    objDao          = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID);
    	EserviceInquiryWebBookingUim  	formObj         = (EserviceInquiryWebBookingUim)form;
    	
    	
    	objDao.deleteTemplate(formObj);
    	
    	return getTemlate(mapping,form,request);
	}

	private ActionForward getTemlate(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception{
    	
    	List                            lstTableData    = null;
    	EserviceInquiryWebBookingDao    objDao          = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID);
    	EserviceInquiryWebBookingNewUim   objForm         = new EserviceInquiryWebBookingNewUim();
    	int                             intTotDBRec     = 0;
        int                             intTotListRec   = 0;
        UserAccountBean account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
    	String 							userID			=  	account.get_userId();				
    	Map result = objDao.getListOfTemplate(userID);
    	List list=null;
        if(result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE)!=null) {
        	request.setAttribute("listBookingError", result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE).toString());
        	request.setAttribute("statusList", getComboBoxStatus(objForm));
        	request.setAttribute("listBooking", objForm.getValues());
            return null;
        }else {
         list = (List)result.get(EserviceInquiryWebBookingDao.KEY_DATA);
        }
        
		
        
        if(null!=list)
        {
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
        
        request.setAttribute("statusList", getComboBoxStatus(objForm));
        
		/* objForm.setStatus("Template"); */
        
        request.setAttribute("listTemplate", objForm.getValues());
    	
    	return mapping.findForward(SUCCESS);
	}

	

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
    	 HttpSession 					session 		= request.getSession(true);
    	 UserAccountBean account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
    	 System.out.println(account.getDateFormat());
    	 if(account.getDateFormat()==null || account.getDateFormat().equals("")) {
    		 return mapping.findForward(SUCCESS);
    	 }
         request.setAttribute("equipmentList", null);
         request.setAttribute("commodityList", null);
         
         listBooking(mapping,form,request);
         
         return mapping.findForward(SUCCESS);

     } // end of onLoad method
     
    
    public void listBooking(ActionMapping mapping, ActionForm form, 
                                HttpServletRequest request) throws Exception {
    	EserviceInquiryWebBookingUim  	formObj         = (EserviceInquiryWebBookingUim)form;
        List                            lstTableData    = null;
        int                             intTotDBRec     = 0;
        int                             intTotListRec   = 0;
        String                          pageFlag        = null;           
        EserviceInquiryWebBookingNewUim   objForm         = new EserviceInquiryWebBookingNewUim();
        EserviceInquiryWebBookingDao    objDao          = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID); 
        int                             fromRecord      = getFromRecord(objForm.getCurrPageNo());
        int                             toRecord        = getToRecord(objForm.getCurrPageNo());
        Map                             mapParam        = new HashMap();
        UserAccountBean account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
        
        
     //pageFlag = request.getParameter("pageFlag");
        
     // mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
        mapParam.put(KEY_USER_ID, getUserID(request));
        mapParam.put("ORG_CODE", account.getOrgCode());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_TEXT_FIND, objForm.getTbxFind());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_COLUMN, objForm.getColumnValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_SORTBY, formObj.getSortByValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_ORDER, formObj.getOrderValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_STATUS, formObj.getStatus());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_WILDCARD, objForm.getChkBoxWildCard());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_FROM_RECORD, fromRecord);
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_TO_RECORD, toRecord);
        
        Map result = objDao.getListWebBookingNew(mapParam);
        List list=null;
        if(result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE)!=null) {
        	request.setAttribute("listBookingError", result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE).toString());
        	request.setAttribute("statusList", getComboBoxStatus(objForm));
        	request.setAttribute("listBooking", objForm.getValues());
        }else {
         list = (List)result.get(EserviceInquiryWebBookingDao.KEY_DATA);
        }
        
		
        
        if(null!=list)
        {
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
        
        request.setAttribute("statusList", getComboBoxStatus(objForm));
        
        
        request.setAttribute("listBooking", objForm.getValues());
        
    }
    
    public void setComboBox(EserviceInquiryWebBookingNewUim objForm)
    {
        objForm.setStatusList(getComboBoxStatus(objForm));
    }
    
    public List getComboBoxStatus(EserviceInquiryWebBookingNewUim objForm)
    {
        List list = new ArrayList();
        list.add(new ComboVO(BLANK, SELECT_ONE));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_OPEN, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_WASTLISTED));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_CONFIRMED, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_CONFIRMED));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_CANCELLED, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_CANCELLED));
        return list;
    }
    
    public ActionForward getWebBooking(ActionMapping mapping, ActionForm form, 
                                 HttpServletRequest request) throws Exception {
        System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking][Begin]");
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
     
    public ActionForward getWebBookingNew(ActionMapping mapping, ActionForm form, 
    		HttpServletRequest request) throws Exception {
    	UserAccountBean account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
    	HttpSession 					session 		= request.getSession(true);
    	EserviceInquiryWebBookingUim  	formObj         = (EserviceInquiryWebBookingUim)form;
        List                            lstTableData    = null;
        int                             intTotDBRec     = 0;
        int                             intTotListRec   = 0;
        String                          pageFlag        = null;           
        EserviceInquiryWebBookingNewUim   objForm         = new EserviceInquiryWebBookingNewUim();
        EserviceInquiryWebBookingDao    objDao          = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID); 
        int                             fromRecord      = getFromRecord(objForm.getCurrPageNo());
        int                             toRecord        = getToRecord(objForm.getCurrPageNo());
        Map                             mapParam        = new HashMap();
        
        
       
       
        
     //pageFlag = request.getParameter("pageFlag");
        
     // mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
        mapParam.put(KEY_USER_ID, getUserID(request));
        mapParam.put("ORG_CODE", account.getOrgCode());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_TEXT_FIND, objForm.getTbxFind());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_COLUMN, objForm.getColumnValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_SORTBY, formObj.getSortByValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_ORDER, formObj.getOrderValue());
        if(null!=formObj.getStatus() && !formObj.getStatus().equals("")) {
        	mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_STATUS, formObj.getStatus());
        }else {
        	mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_STATUS, session.getAttribute("status"));
        	formObj.setStatus((String)session.getAttribute("status"));
        	session.removeAttribute("status");
        }if(null!=formObj.getBookingNo() && !formObj.getBookingNo().equals("")){
        	mapParam.put(EserviceInquiryWebBookingDao.KEY_BOOKING_NO,  formObj.getBookingNo());
        }else {
        	mapParam.put(EserviceInquiryWebBookingDao.KEY_BOOKING_NO,  session.getAttribute("bookingno"));
        	session.removeAttribute("bookingno");
        }
        mapParam.put(EserviceInquiryWebBookingDao.KEY_BOOKING_REF, formObj.getBookingRef());
        //mapParam.put("", value)
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_WILDCARD, objForm.getChkBoxWildCard());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_FROM_RECORD, fromRecord);
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_TO_RECORD, toRecord);
        
        Map result = objDao.getBookingDtlsNew(mapParam);
        List list=null;
        if(result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE)!=null) {
        	request.setAttribute("listBookingError", result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE).toString());
        	request.setAttribute("statusList", getComboBoxStatus(objForm));
        	request.setAttribute("listBooking", objForm.getValues());
            return null;
        }else {
         list = (List)result.get(EserviceInquiryWebBookingDao.KEY_DATA);
        }
		
        
        if(null!=list)
        {
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
        
        
        
        request.setAttribute("statusList", getComboBoxStatus(objForm));
        
        request.setAttribute("listBookingError", null);
        
        request.setAttribute("listBooking", objForm.getValues());

        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward getWebBookingBtn(ActionMapping mapping, ActionForm form, 
    		HttpServletRequest request) throws Exception {
    	EserviceInquiryWebBookingUim  	formObj         = (EserviceInquiryWebBookingUim)form;
    	UserAccountBean account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
        List                            lstTableData    = null;
        int                             intTotDBRec     = 0;
        int                             intTotListRec   = 0;
        String                          pageFlag        = null;           
        EserviceInquiryWebBookingNewUim   objForm         = new EserviceInquiryWebBookingNewUim();
        EserviceInquiryWebBookingDao    objDao          = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID); 
        int                             fromRecord      = getFromRecord(objForm.getCurrPageNo());
        int                             toRecord        = getToRecord(objForm.getCurrPageNo());
        Map                             mapParam        = new HashMap();
        
        
     //pageFlag = request.getParameter("pageFlag");
        
     // mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
        mapParam.put(KEY_USER_ID, getUserID(request));
        mapParam.put("ORG_CODE", account.getOrgCode());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_TEXT_FIND, objForm.getTbxFind());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_COLUMN, objForm.getColumnValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_SORTBY, formObj.getSortByValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_ORDER, formObj.getOrderValue());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_STATUS, formObj.getStatus());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_BOOKING_NO,  formObj.getBookingNo());
        mapParam.put(EserviceInquiryWebBookingDao.KEY_BOOKING_REF, formObj.getBookingRef());
        //mapParam.put("", value)
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_CRITERIA_WILDCARD, objForm.getChkBoxWildCard());
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_FROM_RECORD, fromRecord);
     //  mapParam.put(EserviceInquiryWebBookingDao.KEY_TO_RECORD, toRecord);
        
         
        Map result = objDao.getBookingDtlsBtn(mapParam,formObj);
        List list=null;
        if(result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE)!=null) {
        	request.setAttribute("listBookingError", result.get(EserviceInquiryWebBookingDao.KYE_ERROR_CODE).toString());
        	request.setAttribute("statusList", getComboBoxStatus(objForm));
        	request.setAttribute("listBooking", objForm.getValues());
        	//formObj.setStatus("");
            return null;
        }else {
         list = (List)result.get(EserviceInquiryWebBookingDao.KEY_DATA);
        }
		
        
        if(null!=list)
        {
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
        
       
        
        request.setAttribute("statusList", getComboBoxStatus(objForm));
        
        request.setAttribute("listBookingError", null);
        
        request.setAttribute("listBooking", objForm.getValues());

        return null;
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
     
     public ActionForward getMoreWebBooking(ActionMapping mapping, ActionForm form, 
    		 HttpServletRequest request,HttpServletResponse response) throws Exception {
    	 System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking][Begin]");
    	 EserviceInquiryWebBookingUim    objForm                     = null;
    	 EserviceInquiryWebBookingDao    objDao                      = null;
    	 String                          bookingNo                   = null;
    	 String 						 bookingStatus				= null;
    	 String                          modeGetData                 = null;
    	 Map                             mapParams                   = null;
    	 Map                             result                      = null;
    	 Boolean                         isDisableEditBooking        = null;
    	 EserviceInquiryCustomerDtlMod   customerDtlMod              = null;
    	 List<EserviceRoutingDetailsMod> eserviceRoutingDetailsMods  = null;
    	 List<EserviceEquipmentDetailsMod> equipmentDetails          = null;
    	 List<EserviceCommodityDetailsMod> commodityDetails  		 = null;
    	 EserviceInquiryWebBookingUim    fromObj    = new EserviceInquiryWebBookingUim();
    	 List<EserviceInquiryWebBookingUim> bookinginquiry=new ArrayList<EserviceInquiryWebBookingUim>();
    	 try{
    		 objForm                     = (EserviceInquiryWebBookingUim)form;
    		 objDao                      = (EserviceInquiryWebBookingDao)getDao(DAO_BEAN_ID);
    		 bookingNo                   = objForm.getBookingNo();
    		 bookingStatus				 = objForm.getStatus();
    		 modeGetData                 = objForm.getMode();
    		 mapParams                   = new HashMap();

    		 objForm.setNotFound(Boolean.FALSE);

    		 System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] modeGetData   :: " + modeGetData);
    		 System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] bookingNo     :: " + bookingNo);
    		 System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] bookingStatus     :: " + bookingStatus);
    		 System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] KEY_USER_ID   :: " + getUserID(request));

    		 
    			 mapParams.put(EserviceInquiryWebBookingDao.KEY_BOOKING_NO, bookingNo);
    			 mapParams.put(EserviceInquiryWebBookingDao.KEY_BOOKING_STATUS ,bookingStatus);
    			 // 16/11/2015 Add Param user id 
    			 mapParams.put(KEY_USER_ID, getUserID(request));

    			 isDisableEditBooking = !KEY_DATA_TEMPLATE.equals(objForm.getBookingType());
    			 if(objDao.checkBookingNoAndStatus(mapParams)>0) {
    				
    			    objDao.getCustomerDtls(mapParams, fromObj ); 
    			    objDao.setBookingHeaderNew(mapParams, fromObj);
    			    objDao.setRoutingDetailsNew(mapParams, fromObj);
    	            objDao.setEquipmentDetailsNew(mapParams, fromObj);
    	            objDao.setCommodityDetailsNew(mapParams, fromObj);
    	            objDao.setRoutingDtls(mapParams, fromObj);    
    			 }else {
    				 System.out.println("no Record found....");
    				 objForm.setNotFound(Boolean.TRUE);
    		 }
    			    
    			    net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
    				jsonObj = new net.sf.json.JSONObject();
    				jsonObj.put("Result", fromObj);
    				response.setContentType("text");
    				jsonObj.write(response.getWriter()); 
    			 System.out.println("Json In string "+jsonObj.write(new StringWriter()));
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking][End]");
    	 }

    	 return null;

     }
     
     
}
