/*
-------------------------------------------------------------------------------------------------------------
EserviceNewWebBookingSvc.java
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author vikas Verma 01/01/2013
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 11/07/2013                       01                add check QTN before save booking
## 11/07/2013                       02                add get default data when select QTN
## 12/07/2013                       03                default value back to same as 1st time user open the Web Booking New
## 16/07/2013                       04                change check QTN only once when save template or submit booking
## 19/07/2013                       05                set Default to Place of Receipt  and Place of Delivery
## 18/09/2013                       06                add check pickup depot
## 30/09/2013    YOSSUN1            07                add check quatation routing process.
## 07/10/2013    YOSSUN1            08                add function for set quotation number detail.
## 11/10/2013    YOSSUN1            09                add function for get quotation by routing detail.
## 14/10/2013    YOSSUN1            10                add get quotation detail method.
## 21/10/2013    YOSSUN1            11                change process of change country.
## 23/06/2014    PRATHA1            12                Delete after add new commodity and delete, in bkp050 have duplicatie commodity.
## 01/08/2014    PRATHA1            13                Eservice phase 3.1
## 24/10/2014    PRATHA1            14                PD_CR_20140826_ESV [Contract Party for registeration]
## 27/10/2014    PRATHA1            15                PD_CR_20141003_ESV [COC_SOC in eBKG]
-------------------------------------------------------------------------------------------------------------
*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.dao.DataAccessException;

import com.niit.control.common.ComboVO;
import com.niit.control.common.GlobalConstants;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.BookingThread;
import com.rclgroup.dolphin.rcl.web.common.CancelBooking;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESVUtil;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxUtil;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.AdminBookingLogDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;
import com.rclgroup.dolphin.rcl.web.util.WebUtils;


public class EserviceNewWebBookingSvc extends BaseAction {
    private static final String CHANGE_COUNTRY_CODE         = "changeCountryCode";
    private static final String SAVE_BOOKING_CODE           = "saveBooking";
    private static final String GET_TEMPLATE_DATA           = "templateData";
    private static final String DEL_EQ_SIZE_TYPE            = "deleleEqSizeType";
    private static final String DEL_COMMODITY               = "deleleCommodity";
    private static final String CHECK_QTN                   = "checkQuotation";
    private static final String GET_DATA_BT_QTN             = "getQuotationData";

    private static final String MSG_CHECK_QTN               = "Selected quotation is invalid , pls choose another quotation";

    private static final String CHECK_QTN_SIZE              = "checkQuotationSize";
    private static final String SET_QUATATION_ROUTING_DATA  = "setQuotationRoutingData";

    private static final String GET_EMPTY_PICK_UP_DATA		= "getEmptypickupDepo";
    /*Begin @13*/
    private static final String ADD_COMMODITY               = "addCommodity";
    private static final String UPD_COMMODITY_DATA          = "updateCommodity";
    private static final String CHANGE_RATE_TYPE            = "onChangeRateType";
    private static final String ADD_SIZE_TYPE_DATA          = "addEqSizeType";
    private static final String UPD_SIZE_TYPE_DATA          = "updateEqSizeType";
    private static final String EDIT_BOOKING                = "editBooking";
    private static final String copy_Booking				= "copyBooking";
    private static final String CANCEL_BOOKING				= "cancelbooking";
    private static final String CHECK_BOOKING				= "checkingContainer";
    
    /*End @13*/

    private HttpServletRequest  request;
    private FormatUtil          formatUtil                  = null;

    public EserviceNewWebBookingSvc() {

    }

    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceNewWebBookingUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction = null;
        String forwardPage = null;
    	form.setUserId(WebUtils.getUserNew(request).getUserId());
    	form.setAgent(WebUtils.getUserNew(request).getAgent());
    	form.setLine(WebUtils.getUserNew(request).getLine());
    	form.setTrade(WebUtils.getUserNew(request).getTrade());
    	
        try{
            pageAction = form.getCurrPageAction();

            this.request        = request;
            this.formatUtil     = new FormatUtil(request, response);

            if (ONLOAD.equals(pageAction)) {
                form.setUserId(getUserID(request));
                form.setUserFsc(getUserFSC(form.getUserId()));

                forwardPage = onLoad(form, request);
            } else if (CHANGE_COUNTRY_CODE.equals(pageAction)) {
                forwardPage = changeCountryCode(mapping, form, request, response);
            } else if (SAVE_BOOKING_CODE.equals(pageAction)) {
                forwardPage = saveBooking(form, request);
            } else if (GET_TEMPLATE_DATA.equals(pageAction)) {
                forwardPage = getTemplateOnloadData(form, request);
            }else if (DEL_EQ_SIZE_TYPE.equals(pageAction)) {
                forwardPage = onDeleleEqSizeType(form);
            }else if (DEL_COMMODITY.equals(pageAction)) {
                forwardPage = onDeleleCommodity(form);
            }else if (CHECK_QTN.equals(pageAction)) {
                forwardPage = checkQuotationNo(form, request);
                //@02 BEGIN
            }else if(GET_DATA_BT_QTN.equals(pageAction)){
                forwardPage = getQuotationData(form, request);
            }else if (CHECK_QTN_SIZE.equals(pageAction)) {
                forwardPage = checkQuotationNoSize(request, response);
            }else if(SET_QUATATION_ROUTING_DATA.equals(pageAction)){
                forwardPage = setQuotationRoutingData(form, request);
            }else if(ADD_COMMODITY.equals(pageAction)){
                forwardPage = onADDCommodity(form);
            }else if(UPD_COMMODITY_DATA.equals(pageAction)){
                forwardPage = onUpdateCommodity(form);
            }else if(CHANGE_RATE_TYPE.equals(pageAction)){
                forwardPage = onChangeRateType(form);
            }else if(ADD_SIZE_TYPE_DATA.equals(pageAction)){
                forwardPage = onADDEqSizeType(form);
            }else if(UPD_SIZE_TYPE_DATA.equals(pageAction)){
                forwardPage = onUpdateEqSizeType(form);
            }else if(EDIT_BOOKING.equals(pageAction)) {
            	forwardPage = onEditBooking(form);
            }else if(CANCEL_BOOKING.equals(pageAction)) {
            	forwardPage = onCancelBooking(actionForm,request);
            }else if(CHECK_BOOKING.equals(pageAction)) {
            	forwardPage = getContainerAvailability(form,request,response);
            }else if(GET_EMPTY_PICK_UP_DATA.equals(pageAction)) {
            	forwardPage = getEmptyPickUpData(form,request,response);
            }
        } catch(Exception ex){
        	try {
        		
        	}catch (Exception e) {
				// TODO: handle exception
			}
            throw ex;
        }
        return forwardPage;
    }

    private String getEmptyPickUpData(EserviceNewWebBookingUim form, HttpServletRequest request2,
			HttpServletResponse response) {
    	System.out.println(form.getPorTemp());// TODO Auto-generated method stub
    	 EserviceNewWebBookingDao objDao			 =null;
    	 List<ComboVO>   placeOfReceiptList          = null;
    	 try {
 			objDao = getDao();
 			Map	mapResult = objDao.getEmptyPickUpDepoData(form.getPorTemp());
 			mapResult=(Map) mapResult.get("KEY_PROCE_EXCECTION_RESULT_MAP");
 			placeOfReceiptList      = ComboBoxUtil.getDropDownListFromMap(mapResult, "P_O_V_REF_CURSOR_DATA");
    	 
 			net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
			jsonObj = new net.sf.json.JSONObject();
			jsonObj.put("Result", placeOfReceiptList);
			response.setContentType("text");
			jsonObj.write(response.getWriter());
			System.out.println("Json In string " + jsonObj.write(new StringWriter()));
 			
    	 }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getContainerAvailability(EserviceNewWebBookingUim form, HttpServletRequest request,HttpServletResponse response) {
		 
    	 EserviceNewWebBookingDao objDao=null;
		try {
			objDao = getDao();
			String result= objDao.checkContaineAvailability(form);
	    	System.out.println(result);
			response.getWriter().print(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
     *
     * Called from Action Servlet
     *
     * @param mapping ActionMapping
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EserviceNewWebBookingUim form = null;

        String pageAction = null;
        String errorMsg = null;
        String forwardPage = null;
        try{
            pageAction = getPageAction(mapping);

            form = getForm(actionForm, pageAction);
            form.setCurrPageAction(pageAction);
            forwardPage = getForwardPage(mapping, actionForm, form, request, response);
        } catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
            form.setErrMsg(errorMsg);

            forwardPage = FAILURE;
        }
        return mapping.findForward(forwardPage);
    }

    private EserviceNewWebBookingUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EserviceNewWebBookingUim form = null;
        try{
            form = (EserviceNewWebBookingUim) actionForm;
            if (form == null){
                form = new EserviceNewWebBookingUim();
            }else if(ONLOAD.equals(pageAction)){
                form.resetForm();
            }
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

    private EserviceNewWebBookingDao getDao() throws Exception{
        EserviceNewWebBookingDao dao = null;
        try{
            dao = (EserviceNewWebBookingDao) getDao(EserviceNewWebBookingDao.DAO_NAME);
        } catch(Exception ex){
            throw ex;
        }
        return dao;
    }
    
    private AdminBookingLogDao getAdminLoginDao() throws Exception{
    	AdminBookingLogDao dao = null;
        try{
            dao = (AdminBookingLogDao) getDao(AdminBookingLogDao.DAO_NAME);
        } catch(Exception ex){
            throw ex;
        }
        return dao;
    }
    
    /**
     * This method called when screen loads
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public String onLoad(EserviceNewWebBookingUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][onLoad][Begin]");

        EserviceNewWebBookingUim    eServiceNewWebBookingUim    = null;
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        EserviceNewWebBookingDao 	objDao 						= getDao();
        try{
        	form.setErrMsg("");
            System.out.println("[EserviceNewWebBookingSvc][onLoad] form.getBackFlag() :: " + form.getBackFlag());
            if("true".equals(form.getBackFlag())){
                form.resetForm();
            }
            form.setRepresentedCompanyCheckValidation("");            
            originCountry = form.getUserFsc();
            System.out.println("[EserviceNewWebBookingSvc][onLoad] originCountry :: "+originCountry);
            form.setErrMsg("");
            form.setTemplateFlag("");
            eServiceNewWebBookingUim = new EserviceNewWebBookingUim();
            eServiceNewWebBookingUim.setOriginCountry(originCountry);

			/*Template Expected Sailing Date and Desired Arrival Date 
			 * Set in session 
			 * It will use when user select any option from Template drop down.*/
            request.getSession().setAttribute("EXPECTED_SAILING_DATE", request.getParameter("etd"));
            request.getSession().setAttribute("DESIRED_ARRIVAL_DATE", request.getParameter("eta"));
            
            request.getSession().setAttribute("TO_TERMINAL_DATA", request.getParameter("terminal"));
            request.getSession().setAttribute("FROM_TERMINAL_DATA", request.getParameter("fromTerminal"));
            request.getSession().setAttribute("VESSEL_ETD_DATE", request.getParameter("vesseldate"));
            request.getSession().setAttribute("FIRST_LEG_LOCATION_DATE", request.getParameter("toLoaction"));
            request.getSession().setAttribute("FIRST_LEG_TERMENAL_DATE", request.getParameter("toTerminal"));
            
            
            
          //chandu
            form.setSaveOperationFlag("");
            form.setVessel(request.getParameter("vessel"));
            form.setVoyage(request.getParameter("voyage"));
            form.setVesselName(request.getParameter("vesselName"));
            form.setEtd(request.getParameter("etd"));
            form.setEta(request.getParameter("eta"));
            form.setSailingDate(request.getParameter("etd"));
            form.setDesiredArrivalDate(request.getParameter("eta"));
            
            eServiceNewWebBookingUim.setDestinationCountry(request.getParameter("pod").substring(0,2));
            eServiceNewWebBookingUim.setOriginCountry(request.getParameter("pol").substring(0,2));
            eServiceNewWebBookingUim.setPortOfLoading(request.getParameter("pol"));
            eServiceNewWebBookingUim.setPortOfDischarge(request.getParameter("pod"));
            eServiceNewWebBookingUim.setPlaceOfDelivery(request.getParameter("pod"));
            eServiceNewWebBookingUim.setPlaceOfReceipt(request.getParameter("pol"));

            form.setPortOfLoading(request.getParameter("pol"));
            form.setPortOfDischarge(request.getParameter("pod"));
            form.setPlaceOfDelivery(request.getParameter("pod"));
            form.setPlaceOfReceipt(request.getParameter("pol"));
            
            
            form.setToTerminal(request.getParameter("terminal"));
            form.setToTerminalDes(objDao.getTerminalDes(request.getParameter("terminal")));
            form.setFromTerminal(request.getParameter("fromTerminal"));
            form.setFromTerminalDes(objDao.getTerminalDes(request.getParameter("fromTerminal")));
            
            //port pair 
            form.setTo(request.getParameter("toTerminal"));
            form.setToLocation(request.getParameter("toLoaction"));
           
            form.setVesselEtd(request.getParameter("vesseldate"));
            
            
            
            setQuotationRoutingDetail(form, eServiceNewWebBookingUim);

            //------------------- populate combo
            mapParam = getAllNewWebBookingDropDownList(form, request);

            //------------------- get onload data from dao
            mapParam = getOnloadData(form, request);

            if(form.getContact() == null || BLANK.equals(form.getContact())){
                account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
                if(account.getUserName().length() > 25){
                    form.setContact(account.getUserName().substring(0,25));
                }else{
                    form.setContact(account.getUserName());
                }
            }

            //------------------- set acknowledgement screen open flag to false.
            form.setOpenAcknowledgement(Boolean.FALSE);

            //------------------- get blank row for size type.
            getDefaultEquipmentSizeTypeRow(form);

            //------------------- get blank row for cargo type.
            getDefaultCargoDetailRow(form);

            /*Begin @13*/
            this.setRfTypeNormal(form);
            /*End @13*/

            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][onLoad][End]");
        }
        return forwardPage;

    } 
    public String onEditBooking(EserviceNewWebBookingUim form) throws Exception {
		
    	UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String  					forwardPage                 = FAILURE;
        form.setEditSatus("");
        try {
        	form.setErrMsg("");
            form.setTemplateFlag("");
            form.setTemplate("");
            
        	System.out.println("[EserviceNewWebBookingSvc][onLoad] form.getBackFlag() :: " + form.getBackFlag());
        	
        	originCountry = form.getUserFsc();
        	
            System.out.println("[EserviceNewWebBookingSvc][onLoad] originCountry :: "+originCountry);

            
            form.setBookingNo(request.getParameter("bookingNo"));
// Sushil
            
            Map getBokkingMap = new HashMap<>();
            getBokkingMap.put("P_I_V_BKG_NO",form.getBookingNo());
            EserviceNewWebBookingDao   objDao          = getDao();
            objDao.getEserviceNewWebBookingUim(getBokkingMap, form);
            form.setRepresentCompChkBox("N");
        	mapParam = getOnLoadDataForEditBooking(form, request);
        	
        	if(form.getContact() == null || BLANK.equals(form.getContact())){
                account = WebUtils.getUser(request);
                if(account.getUserName().length() > 25){
                    form.setContact(account.getUserName().substring(0,25));
                }else{
                    form.setContact(account.getUserName());
                }
            }
        	
        	//------------------- set acknowledgement screen open flag to false.
            form.setOpenAcknowledgement(Boolean.FALSE);

            //------------------- get blank row for size type.
            getDefaultEquipmentSizeTypeRow(form);

            //------------------- get blank row for cargo type.
            //need to see
           // getDefaultCargoDetailRow(form);

            /*Begin @13*/
            this.setRfTypeNormal(form);
            objDao.setEquipmentDetailsNew(getBokkingMap, form);
            objDao.setCommodityDetailsNew(getBokkingMap, form);
        	
            /*End @13*/

            
            
            forwardPage = SUCCESS;
            
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][onLoad][End]");
        }
        return forwardPage;
    }
    
 public String onCancelBooking(ActionForm actionForm,HttpServletRequest request) throws Exception {
		
    	UserAccountBean             account                     = null;
    	EserviceNewWebBookingUim 	form						=(EserviceNewWebBookingUim) actionForm;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String  					forwardPage                 = FAILURE;
    	
        try {
        	
        	System.out.println("[EserviceNewWebBookingSvc][onLoad] form.getBackFlag() :: " + form.getBackFlag());
        	
        	originCountry = form.getUserFsc();
        	
            System.out.println("[EserviceNewWebBookingSvc][onLoad] originCountry :: "+originCountry);

            
            form.setBookingNo(request.getParameter("bookingNo"));
// Sushil
            String bookingNoTem=form.getBookingNo();
            Map getBokkingMap = new HashMap<>();
            getBokkingMap.put("P_I_V_BKG_NO",form.getBookingNo());
            EserviceNewWebBookingDao   objDao          = getDao();
            objDao.getEserviceNewWebBookingUim(getBokkingMap, form);
             
        	mapParam = getOnLoadDataForEditBooking(form, request);
        	
        	if(form.getContact() == null || BLANK.equals(form.getContact())){
                account = WebUtils.getUser(request);
                if(account.getUserName().length() > 25){
                    form.setContact(account.getUserName().substring(0,25));
                }else{
                    form.setContact(account.getUserName());
                }
            }
        	
        	//------------------- set acknowledgement screen open flag to false.
            form.setOpenAcknowledgement(Boolean.FALSE);

            //------------------- get blank row for size type.
            getDefaultEquipmentSizeTypeRow(form);

            //------------------- get blank row for cargo type.
            //need to see
           // getDefaultCargoDetailRow(form);

            /*Begin @13*/
            this.setRfTypeNormal(form);
            objDao.setEquipmentDetailsNew(getBokkingMap, form);
            objDao.setCommodityDetailsNew(getBokkingMap, form);
        	
            /*End @13*/
            try {
            objDao.cancelBooking(form);
            form.setStatus("N");
            request.getSession(false).setAttribute("status", "N");
            request.getSession(false).setAttribute("bookingno", bookingNoTem);
            }catch (Exception e) {
				e.printStackTrace();
				return forwardPage;
			}
			try {
				String user = form.getUserId();
				AdminBookingLogDao adminLogDAO = getAdminLoginDao();
				CancelBooking cancelBooking = new CancelBooking(form, objDao, user,adminLogDAO);
				cancelBooking.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            forwardPage = SUCCESS;
            
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][onLoad][End]");
        }
        return forwardPage;
    }

    
    // end of onLoad method
     //@08 END

      /*Begin @13*/
      private void setRfTypeNormal(EserviceNewWebBookingUim form){
          System.out.println("[EserviceNewWebBookingSvc][setRfTypeNormal][Begin]");
          EserviceNewWebBookingDao    objDao          = null;
          String                      rfTypeNormal    = null;

          try{
              objDao          = getDao();
              rfTypeNormal    = objDao.getRfTypeNormal();

              System.out.println("[EserviceNewWebBookingSvc][setRfTypeNormal] rfTypeNormal :: " + rfTypeNormal);
              if(rfTypeNormal!=null){
                  form.setRfTypeNormal(rfTypeNormal);
              }

          }catch(Exception e){
              e.printStackTrace();
          }finally{
              System.out.println("[EserviceNewWebBookingSvc][setRfTypeNormal][End]");
          }
      }
      /*End @13*/

//     @11 BEGIN
    /**
     * This function populates the screen combo box label and values
     *
     * @param request
     * @throws Exception
     */
    public String changeCountryCode(ActionMapping mapping,
                                           ActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        System.out.println("[EserviceNewWebBookingSvc][changeCountryCode][Begin]");

        EserviceNewWebBookingUim    objForm                     = null;
        Map                         mapResult                   = null;
        List<ComboVO>               quotationNoList             = null;
        String                      strSelectEmptyPickup        = null;
        String                      forwardPage                 = FAILURE;

        try{
            objForm                 = (EserviceNewWebBookingUim)form;
            //-------------- get form object
            strSelectEmptyPickup    = request.getParameter("selEmptyPickupDepot");

            mapNewEquipmentAndCommodity(objForm);

            getAllNewWebBookingDropDownList(objForm, request);

            mapResult               = getQuotationData(objForm);
            quotationNoList         = ComboBoxESVUtil.getQuotationNoDDList(mapResult);

            objForm.setQuotationNumberValues(quotationNoList);
            objForm.setQuotationNumber(getValueFormDropDownList(quotationNoList, objForm.getQuotationNumber()));

            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][changeCountryCode][End]");
        }
        return forwardPage;
    } // changeCountryCode

    private String getValueFormDropDownList(List dropDownList, String valueSearch) throws Exception{
        System.out.println("[EserviceNewWebBookingSvc][getValueFormDropDownList][Begin]");

        ComboVO     comboVo         = null;
        String      valueReturn     = null;
        int         ddlSize         = 0;

        try{
            System.out.println("[EserviceNewWebBookingSvc][getValueFormDropDownList] valueSearch :: " + valueSearch);

            valueReturn = BLANK;
            if(dropDownList != null && !dropDownList.isEmpty()){
                ddlSize = dropDownList.size();
                if(ddlSize <= 2){
                    comboVo = (ComboVO) dropDownList.get(ddlSize-1);
                    valueReturn = comboVo.getCode();
                }else{
                    if(ComboBoxUtil.checkValueExistFormDropDownList(dropDownList, valueSearch)){
                        valueReturn = valueSearch;
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][getValueFormDropDownList][End]");
        }
        return valueReturn;
    }
//    @11 END
//    @09 BEGIN

     /**
      * This function populates the screen combo box label and values
      *
      * @param form
      * @param request
      * @throws Exception
      */
      public String checkQuotationNo(EserviceNewWebBookingUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][checkQuotationNo][Begin]");

         //-------------- get form object
         Map            quotationMap            = null;
         List<ComboVO>  quotationNOComboList    = null;
         String         quotationNoSelected     = null;
         String         errMsg                  = null;
         String         forwardPage             = SUCCESS;
         Map resultMap  = null;
         try{

             //-------------- get combo data for changed origin country code.
        	 if("update".equalsIgnoreCase(request.getParameter("saveOperationFlag"))) {
        		 resultMap=getOnLoadDataForEditBooking(form, request);
        	 }else {
        		 resultMap= getAllNewWebBookingDropDownList(form, request);
        	 }
            quotationNoSelected     = form.getQuotationNumber();
           // quotationMap            = getQuotationData(form);
            quotationNOComboList    =getQuotationNoListNew((List<EserviceNewWebBookingMod>) resultMap.get("QTN_DATA"));

            if(quotationNOComboList != null && !quotationNOComboList.isEmpty()){
                 if(quotationNoSelected != null && !BLANK.equals(quotationNoSelected)){
                    if(!ComboBoxUtil.checkValueExistFormDropDownList(quotationNOComboList, quotationNoSelected)){
                        errMsg = "Selected quotation is invalid , pls choose another quotation";
                        form.setNewWebBookingErrMsg(errMsg);
                        form.setQuotationNumber(BLANK);
                    }
                 }
            }
         }catch(Exception ex){
             ex.printStackTrace();
         }finally{

             //System.out.println("[EserviceNewWebBookingSvc][checkQuotationNo] quotationNOComboList.size() " + quotationNOComboList.size());

            
             form.setQuotationNumberValues(quotationNOComboList);
             System.out.println("[EserviceNewWebBookingSvc][checkQuotationNo][End]");
         }
         form.setRepresentedCompanyCheckValidation("CHECKED");
         return forwardPage;
      }
//        @09 END

     /**
      * This function populates the screen combo box label and values
      *
      * @param request
      * @param response
      * @throws Exception
      */
     public String checkQuotationNoSize(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][checkQuotationNoSize][Begin]");
        EserviceNewWebBookingDao objDao = null;
        List<EserviceNewWebBookingUim> list = null;
        PrintWriter out = null;

        String quotationNumber = null;

        Map amap = null;

        int totalQuotationNo = 0;
        try {
            quotationNumber = request.getParameter("quotationNumber");
            if(quotationNumber != null){
                amap = new HashMap();
                amap.put(EserviceNewWebBookingDao.P_I_V.QTN_NO, quotationNumber);
                //----------------------------------------get object of DAO
                objDao = getDao();
                amap = objDao.getQuotationInfo(amap);
                if(amap != null && !amap.isEmpty()){
                    if(amap.containsKey(EserviceNewWebBookingDao.P_O_V.QTN_DATA)){
                        list = (List<EserviceNewWebBookingUim>) amap.get(EserviceNewWebBookingDao.P_O_V.QTN_DATA);
                        if(list != null && !list.isEmpty()){
                            totalQuotationNo = list.size();
                        }
                    }
                }
            }

            response.setContentType("text/html");
            response.setHeader("Cache-Control", "no-cache");

            out = response.getWriter();
            out.print(String.valueOf(totalQuotationNo));
            System.out.println("Total QuotationNO = "+totalQuotationNo);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.out.println("[EserviceNewWebBookingSvc][checkQuotationNoSize][End]");
        }
        return null;
    }

//    @07 BEGIN

     /**
      * This function get default data when select quotation no
      *
      * @param form
      * @param request
      * @throws Exception
      */
     public String getQuotationData(EserviceNewWebBookingUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][getQuotationData][Begin]");

        //-------------- get form object
        EserviceNewWebBookingUim        eserviceNewWebBookingUim    = null;
        List<EserviceNewWebBookingUim>  listQuatationRouting        = null;
        List                            lstResult                   = null;
        String                          quotationNumber             = null;
        String                          forwardPage                 = null;
        /*Begin @14*/
        String                          representCompChkBox         = null;
        String                          representComp               = null;
        /*End @14*/

        try{
            listQuatationRouting    = new ArrayList<EserviceNewWebBookingUim>();
            quotationNumber         = request.getParameter("quotationNumber");
            /*Begin @14*/
            representCompChkBox     = FormatUtil.chkNullForCheckBox(request.getParameter("representCompChkBox"));
            representComp           = FormatUtil.nullToBlank(request.getParameter("representComp"));

            form.setRepresentCompChkBox(representCompChkBox);
            form.setRepresentComp(representComp);
            /*End @14*/

            if(quotationNumber != null && !"".equals(quotationNumber)){
                form.setQuotationNumber(quotationNumber);
            }

            lstResult = getDataByQuotationNo(form);
            if(lstResult != null && !lstResult.isEmpty()){

                forwardPage = "search";

                for(int count=0, size=lstResult.size(); count<size; count++){
                    eserviceNewWebBookingUim = (EserviceNewWebBookingUim) lstResult.get(count);
                    if(size == 1){
                        setQuotationRoutingDetail(form, eserviceNewWebBookingUim);

                        form.setShipmentType(eserviceNewWebBookingUim.getShipmentType());
                        form.setSocCocUserFlag(eserviceNewWebBookingUim.getSocCocUserFlag());

                        forwardPage = SUCCESS;
                    }
                    listQuatationRouting.add(eserviceNewWebBookingUim);
                }
            }else{
                forwardPage = FAILURE;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            forwardPage = FAILURE;
        }finally{
            form.setQuatationRoutingList(listQuatationRouting);
            getAllNewWebBookingDropDownList(form, request);

            if(!"search".equals(forwardPage) && !SUCCESS.equals(forwardPage)){
                if(form.getOriginCountry()== null || form.getOriginCountry().equals("")){
                    form.setOriginCountry(form.getUserFsc());
                }
                //------------------- set acknowledgement screen open flag to false.
                form.setOpenAcknowledgement(Boolean.FALSE);
                //------------------- get blank row for size type.
                getDefaultEquipmentSizeTypeRow(form);
                //------------------- get blank row for cargo type.
//                getDefaultCargoDetailRow(form);
            }else{
                request.setAttribute("quotationNumber", quotationNumber);
                request.getSession().setAttribute("eServiceQuatationRoutingList", listQuatationRouting);
            }
            System.out.println("[EserviceNewWebBookingSvc][getQuotationData][End]");
        }
        //-------------- return to view.
        return forwardPage;
     }// end getQuotationData
//    @07 END
     /**
      * use for when delete row in equipment list and commodity list then change country
      * @param objForm
      * @return
      * @throws Exception
      */
     public void mapNewEquipmentAndCommodity(EserviceNewWebBookingUim objForm) throws Exception {

         List newEquipmentList = new ArrayList();
         List newCommodityList = new ArrayList();
         for(int i = 0 ; i < objForm.getEquipmentVoDataList().size() ; i++){
             EserviceEquipmentDetailsMod mod = (EserviceEquipmentDetailsMod)objForm.getEquipmentVoDataList().get(i);
             if(mod.getLaden() !=null){
                 newEquipmentList.add(mod);
             }
         }
         for(int i = 0 ; i < objForm.getCommodityVoDataList().size() ; i++){
             EserviceCommodityDetailsMod mod = (EserviceCommodityDetailsMod)objForm.getCommodityVoDataList().get(i);
             if(mod.getGroup() !=null){
                 if(i == 0){
                     mod.setRadCommodity("0");
                 }
                 newCommodityList.add(mod);
             }
         }

         objForm.setEquipmentVoDataList(newEquipmentList);
         objForm.setCommodityVoDataList(newCommodityList);

//         return getComboDataFromDao(null, aobjForm, request);
     }// end mapNewEquipmentAndCommodity

    public static List<ComboVO> getQuotationNoList(List<EserviceNewWebBookingMod> list){
        System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true][Begin]");
        List<ComboVO>               quolist = null;
        EserviceNewWebBookingMod    mod     = null;

        try{
            quolist = new ArrayList<ComboVO>(0);
            quolist.add(0, new ComboVO(BLANK, SELECT_ONE));

            System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true] list :: " + list);
            if (list != null) {
                System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true] list.size() :: " + list.size());
                for(int i = 0 ; i < list.size() ; i++){
                    mod = list.get(i);
                    quolist.add(new ComboVO(mod.getQuotationNo(),mod.getQuotationDesc()));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true][End]");
        }

        return quolist;
    }
    
    public static List<ComboVO> getQuotationNoListNew(List<EserviceNewWebBookingMod> list){
        System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true][Begin]");
        List<ComboVO>               quolist = null;
        EserviceNewWebBookingMod    mod     = null;

        try{
            quolist = new ArrayList<ComboVO>(0);
            quolist.add(0, new ComboVO(BLANK, SELECT_ONE));

            System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true] list :: " + list);
            if (list != null) {
                System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true] list.size() :: " + list.size());
                for(int i = 0 ; i < list.size() ; i++){
                    mod = list.get(i);
                    quolist.add(new ComboVO(mod.getQuotationNo(),mod.getQuotationNo()));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList true][End]");
        }

        return quolist;
    }

    /**
     *
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public Map getAllNewWebBookingDropDownList(EserviceNewWebBookingUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList][Begin]");

        EserviceNewWebBookingDao    objDao          = null;
        Map                         paramsMap       = null;
        Map                         resultMap       = null;

        try{
        
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] UserId              :: " + form.getUserId());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] DestinationCountry  :: " + form.getDestinationCountry());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] OriginCountry       :: " + form.getOriginCountry());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] REP_FLAG            :: " + form.getRepresentCompChkBox());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] REP_CODE            :: " + form.getRepresentComp());
            
            paramsMap = new HashMap();
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.USER_ID        , form.getUserId());
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.REP_FLAG       , form.getRepresentCompChkBox());
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.REP_CODE       , form.getRepresentComp());
            paramsMap.put(EserviceNewWebBookingDao.KEY_DEST_MAP_CODE    , form.getDestinationCountry());
            paramsMap.put(EserviceNewWebBookingDao.KEY_ORIGIN_MAP_CODE  , form.getOriginCountry());
            paramsMap.put("P_I_V_PORT_OF_LOADING"  , form.getPortOfLoading());
            //chandu
            paramsMap.put("USER_ID"        , form.getUserId());
            paramsMap.put("POL"      , form.getPortOfLoading());
            paramsMap.put("POD"      , form.getPortOfDischarge());
            paramsMap.put("REPRESENEDCOMAPNYCHECK"      , form.getRepresentCompChkBox());
            paramsMap.put("REPRESENEDCOMAPNY"      , form.getRepresentComp());
            if(form.getTemplateFlag()!=null && form.getTemplateFlag().equals("TB"))
            	paramsMap.put("ETDATE"      , (String)request.getSession().getAttribute("EXPECTED_SAILING_DATE"));
            else
            	paramsMap.put("ETDATE"      , form.getSailingDate());
            
            

            objDao      = getDao();
            resultMap   = objDao.getComboData(paramsMap);

            // resultMap.put(EserviceNewWebBookingDao.P_O_V.QTN_DATA, getQuotationNoList(form, objDao).get(EserviceNewWebBookingDao.P_O_V.QTN_DATA));
            List<EserviceNewWebBookingMod> list = objDao.getQuotationComboDataNew(paramsMap);
            resultMap.put("QTN_DATA" ,list);
            resultMap.put(EserviceNewWebBookingDao.P_O_V.QTN_DATA ,list);
         
            /*@11 BEGIN*/
            populateComboData(resultMap, form, request, true);
            /*@11 END*/

        }catch(Exception ex){
            throw ex;
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList][End]");
        }

        return resultMap;
    } //getComboDataFromDao
//    @11 BEGIN
    /**
     *
     * @param mapResult
     * @param objForm
     * @param request
     * @param initQtnNo
     * @throws Exception
     */
    public void populateComboData(Map mapResult, EserviceNewWebBookingUim objForm, HttpServletRequest request, boolean initQtnNo) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][populateComboData][Begin]");

//        List            typeList                    = null;
        List            sizeList                    = null;
        List            cargoTypeList               = null;

        List<ComboVO>   quotationNoList             = null;
        List<ComboVO>   shipmentTermList            = null;
        List<ComboVO>   originalCountryList         = null;
        List<ComboVO>   destinationCountryList      = null;
        List<ComboVO>   placeOfReceiptList          = null;
        List<ComboVO>   placeOfDeliveryList         = null;
        List<ComboVO>   emptyPickUpDepotList        = null;
        List<ComboVO>   portOfDischargeList         = null;
        List<ComboVO>   portOfLoadingList           = null;
        List<ComboVO>   templateList                = null;
        List<ComboVO>   polPodList                  = null;
        List<ComboVO>   polPodStatusList            = null;
        List<ComboVO>   rateTypeList                = null;//@13
        List<ComboVO>   representCompList           = null;//@14
        List<ComboVO>   cocSocList                  = null;//@15
        List<ComboVO>   sepcialCargoList            = null;
        List<ComboVO>   CargoTypeList            = null;
        
        String          dropDownValue               = null;
        String          placeOfReceipt              = null;
        String          placeOfDelivery             = null;
        String          portOfDischarge             = null;
        String          portOfLoading               = null;

        try{
            //----------------------------------------set parameters needed to populate combo
//            typeList            = getComboData(request, KEY_TYPE, false);
            sizeList            = getComboDataNew(request, KEY_SIZE, false);
            cargoTypeList       = getComboDataNew(request, KEY_CARGO_TYPE, false);

            polPodList          = ComboBoxESVUtil.getPolPodDDList();
            polPodStatusList    = ComboBoxESVUtil.getPolPodStatusDDList();
            //--------------------------------------------individual logic for combo
            System.out.println("[EserviceNewWebBookingSvc][populateComboData] initQtnNo :: " + initQtnNo);
            if(initQtnNo){
                quotationNoList = getQuotationNoList((List<EserviceNewWebBookingMod>) mapResult.get(EserviceNewWebBookingDao.P_O_V.QTN_DATA));
            	//quotationNoList = getQuotationNoListNew((List<EserviceNewWebBookingMod>) mapResult.get("QTN_DATA"));
            }
            //System.out.println("[EserviceNewWebBookingSvc][populateComboData] quotationNoList.size() :: " + quotationNoList.size());

            shipmentTermList        = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_SHIPMENT_TERM);
            originalCountryList     = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_ORIGIN_COUNTRY);
            destinationCountryList  = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_DESTINATION_COUNTRY);
            placeOfReceiptList      = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_PLACE_OF_RECEIPT);
            placeOfDeliveryList     = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_PLACE_OF_DELIVERY);
            emptyPickUpDepotList    = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_EMPTY_PICKUP_DEPT);
            portOfLoadingList       = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_PORT_OF_LOADING);
            portOfDischargeList     = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_PORT_OF_DISCHARGE);
            templateList            = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.KEY_TEMPLATE);
          //rateTypeList            = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.RATE_TYPE);//@13
            rateTypeList            = getCargoTypeList(request, KEY_CARGO_TYPE, false);
            representCompList       = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.REP_COMP);//@14
            cocSocList              = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.COC_SOC);//@15
            sepcialCargoList        = ComboBoxUtil.getDropDownListFromMap(mapResult, EserviceNewWebBookingDao.SECIAL_CAERGO);
            CargoTypeList			= ComboBoxUtil.getDropDownListFromMap(mapResult, "CARGOTYPELIST");
            //GET portOfLoading value
            dropDownValue           = objForm.getPortOfLoading();

            portOfLoading           = getValueFormDropDownList(portOfLoadingList, dropDownValue);
            //GET portOfDischarge value
            dropDownValue           = objForm.getPortOfDischarge();

            portOfDischarge         = getValueFormDropDownList(portOfDischargeList, dropDownValue);
            //@01 BEGIN
            //GET placeOfReceipt value
            dropDownValue           = objForm.getPlaceOfReceipt();

            placeOfReceipt          = getValueFormDropDownList(placeOfReceiptList, dropDownValue);
            //GET placeOfDelivery value
            dropDownValue           = objForm.getPlaceOfDelivery();

            placeOfDelivery         = getValueFormDropDownList(placeOfDeliveryList, dropDownValue);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
        //---------------------------------------------common combo from config master
            objForm.setTypeValues(getComboDataNew(request, KEY_TYPE, false));
            objForm.setSizeValues(getComboDataNew(request, KEY_SIZE, false));
            //objForm.setCargoTypeValues(getComboDataNew(request, KEY_CARGO_TYPE, false));
            objForm.setCargoTypeValues(getCargoTypeList(request, KEY_CARGO_TYPE, false));

            objForm.setPolList(polPodList);
            objForm.setPodList(polPodList);

            objForm.setPodStatusList(polPodStatusList);
            objForm.setPolStatusList(polPodStatusList);
            if(initQtnNo){
                objForm.setQuotationNumberValues(quotationNoList);
            }
            objForm.setShipmentTermValues(shipmentTermList);
            objForm.setOriginCountryValues(originalCountryList);
            objForm.setDestinationCountryValues(destinationCountryList);
            objForm.setPlaceOfReceiptValues(placeOfReceiptList);
            objForm.setPlaceOfDeliveryValues(placeOfDeliveryList);
            objForm.setEmptyPickupDepotValues(emptyPickUpDepotList);
            objForm.setPortOfLoadingValues(portOfLoadingList);
            objForm.setPortOfDischargeValues(portOfDischargeList);
            objForm.setTemplateValues(templateList);
            objForm.setRateTypeValues(rateTypeList);//@13
            objForm.setSpecialCargoValues(sepcialCargoList);
            objForm.setCarogoTypeValues(CargoTypeList);
            
            objForm.setRepresentCompValues(representCompList);//@14
            this.setcocSoc(objForm, cocSocList);//@15

            objForm.setPortOfDischarge(portOfDischarge);
            objForm.setPortOfLoading(portOfLoading);
            objForm.setPlaceOfReceipt(placeOfReceipt);
            objForm.setPlaceOfDelivery(placeOfDelivery);

            System.out.println("[EserviceNewWebBookingSvc][populateComboData][End]");
        }
    } //populateComboData
//    @11 END

  

	/*Begin @15*/
    private void setcocSoc(EserviceNewWebBookingUim objForm, List<ComboVO> cocSocList){
        System.out.println("[EserviceNewWebBookingSvc][setcocSoc][Begin]");

        try{
            objForm.setCocSocValues(cocSocList);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][setcocSoc][End]");
        }
    }
    /*End @15*/

    //-----------------------------add function for get Quotation List  05/06/2013
     /**
      * Method to get data when screen loades.
      *
      * @param form
      * @param objDao
      * @return
      * @throws Exception
      */
     private Map getQuotationNoList(EserviceNewWebBookingUim form, EserviceNewWebBookingDao objDao) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList][Begin]");

        Map                             paramsMap                   = null;
        Map                             resultMap                   = null;
        /*Begin @14*/
        String                          representCompChkBox         = null;
        String                          representComp               = null;
        /*End @14*/

        try{
            /*Begin @14*/
            representCompChkBox     = FormatUtil.chkNullForCheckBox(request.getParameter("representCompChkBox"));
            representComp           = FormatUtil.nullToBlank(request.getParameter("representComp"));
            /*End @14*/

            paramsMap = new HashMap();
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.USER_ID, form.getUserId());
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.COC_SOC, form.getSocCocUserFlag());

            /*Begin @14*/
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.REP_FLAG, representCompChkBox);
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.REP_CODE, representComp);
            /*End @14*/

            if(objDao == null){
                objDao = getDao();
            }

            resultMap = objDao.findQuotationNoList(paramsMap);
        }catch(Exception ex){
           throw ex;
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][getQuotationNoList][End]");
        }
        return resultMap;
    }// end getQuotationNoListData

    //---------------------add function for check quotation number has in list 05/06/2013
     /**
      * This method for set quotation information from procedure to show in tooltip
      *
      * @param map List of quotation information
      */
    public void setQuotationInfoToShow(Map map, EserviceNewWebBookingUim uim)
    {
        List<EserviceNewWebBookingUim> list = (List<EserviceNewWebBookingUim>)map.get(EserviceNewWebBookingDao.P_O_V.QTN_DATA);
        String msg = BLANK;
        int row = 1;
        for(EserviceNewWebBookingUim obj : list)
        {
            msg += "Origin Country : "+ obj.getOriginCountryShow() + "\n";
            msg += "Destination Country  : "+ obj.getDestinationCountryShow() + "\n";
            msg += "Port of Loading POL  : "+ obj.getPortOfLoadingShow() + "\n";
            msg += "Port of Discharge POD  : "+ obj.getPortOfDischargeShow() + "\n";
            msg += "POL Term  : "+ obj.getPolShow() + "\n";
            msg += "POD Term  : "+ obj.getPodShow() + "\n";
            msg += "Shipment Type : "+ obj.getShipmentType() + "\n";
            msg += "SOC/COC : "+ obj.getSocCocUserFlag();

            if(row > 1)
            {
                msg += "\n\n";
            }

            row++;
        }
        uim.setMsgTooltip(msg);
        System.out.println("msg : " + msg);
    }
    //@07 BEGIN
     /**
      * Method to get data when screen loades.
      *
      * @param uim
      * @return String
      * @throws Exception
      */
     private List getDataByQuotationNo(EserviceNewWebBookingUim uim) throws Exception {
        //----------------------------------------variable declaration
        Map amap = null;
        EserviceNewWebBookingDao objDao = null;

        List lstResult = null;
        try{
            lstResult = new ArrayList();
            //----------------------------------------call dao method to get data from DB
            amap = new HashMap();
            amap.put(EserviceNewWebBookingDao.P_I_V.QTN_NO, uim.getQuotationNumber());
            //----------------------------------------get object of DAO
            objDao = getDao();
            amap = objDao.getQuotationInfo(amap);
            if(amap != null){
                setQuotationInfoToShow(amap, uim);
                lstResult =  (List)amap.get(EserviceNewWebBookingDao.P_O_V.QTN_DATA);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return lstResult;
     }// end getDataByQuotationNo
    //@07 END
    /**
     * Method to get data when screen loades.
     *
     * @param eserviceNewWebBookingUim
     * @param request
     * @return
     * @throws Exception
     */
    private Map getOnloadData(EserviceNewWebBookingUim eserviceNewWebBookingUim,
                              HttpServletRequest request) throws Exception {

        //----------------------------------------variable declaration
        Map amap = new HashMap(0);
        EserviceNewWebBookingMod eserviceNewWebBookingMod;

        amap.put(KEY_USER_ID, getUserID(request));
        amap.put("POL", eserviceNewWebBookingUim.getPortOfLoading());
        //----------------------------------------get object of DAO
        EserviceNewWebBookingDao objDao = getDao();

        //----------------------------------------call dao method to get data from DB
        amap = objDao.getOnloadData(amap);

        eserviceNewWebBookingMod =
                (EserviceNewWebBookingMod)amap.get(EserviceNewWebBookingDao.P_O_V.REF_CURSOR_DATA);

        //----------------------------------------set onload values
        eserviceNewWebBookingUim.setSocCocUserFlag(eserviceNewWebBookingMod.getSosCoc());
        eserviceNewWebBookingUim.setTelephone(WebUtils.getUserNew(request).getPhoneNumber());
        eserviceNewWebBookingUim.setFax(WebUtils.getUserNew(request).getFaxNumber());
        eserviceNewWebBookingUim.setEmail(WebUtils.getUserNew(request).getMailId());
        eserviceNewWebBookingUim.setToPicMail(eserviceNewWebBookingMod.getToPicMail());
        eserviceNewWebBookingUim.setCcPicMail(eserviceNewWebBookingMod.getCcPicMail());
        eserviceNewWebBookingUim.setBccPicMail(eserviceNewWebBookingMod.getBccPicMail());
        //        eserviceNewWebBookingUim.setEmptyPickupDate(eserviceNewWebBookingMod.getDate());
        eserviceNewWebBookingUim.setShipmentDate(eserviceNewWebBookingMod.getDate());

        return amap;
    } // getOnloadData

    public Map getOnLoadDataForEditBooking(EserviceNewWebBookingUim form,         HttpServletRequest request) throws Exception {
     
    	System.out.println("[EserviceNewWebBookingSvc][getOnLoadDataForEditBooking][Begin]");

        EserviceNewWebBookingDao    objDao          = null;
        Map                         paramsMap       = null;
        Map                         resultMap       = null;

        try{
        
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] UserId              :: " + form.getUserId());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] DestinationCountry  :: " + form.getDestinationCountry());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] OriginCountry       :: " + form.getOriginCountry());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] REP_FLAG            :: " + form.getRepresentCompChkBox());
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList] REP_CODE            :: " + form.getRepresentComp());
            
            paramsMap = new HashMap();
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.USER_ID        , form.getUserId());
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.REP_FLAG       , form.getRepresentCompChkBox());
            paramsMap.put(EserviceNewWebBookingDao.P_I_V.REP_CODE       , form.getRepresentComp());
            paramsMap.put(EserviceNewWebBookingDao.KEY_DEST_MAP_CODE    , form.getDestinationCountry());
            paramsMap.put(EserviceNewWebBookingDao.KEY_ORIGIN_MAP_CODE  , form.getOriginCountry());
            paramsMap.put("REPRESENEDCOMAPNYCHECK"      , form.getRepresentCompChkBox());
            paramsMap.put("REPRESENEDCOMAPNY"      , form.getRepresentComp());
            paramsMap.put("ETDATE"      , form.getSailingDate());
            
            
            
            //chandu
            paramsMap.put("USER_ID"        , form.getUserId());
            paramsMap.put("POL"      , form.getPortOfLoading());
            paramsMap.put("POD"      , form.getPortOfDischarge());
            paramsMap.put("REPRESENEDCOMAPNY"      , form.getRepresentComp());

            objDao      = getDao();
            resultMap   = objDao.getComboData(paramsMap);

            // resultMap.put(EserviceNewWebBookingDao.P_O_V.QTN_DATA, getQuotationNoList(form, objDao).get(EserviceNewWebBookingDao.P_O_V.QTN_DATA));
            List<EserviceNewWebBookingMod> list = objDao.getQuotationComboDataNew(paramsMap);
            resultMap.put("QTN_DATA" ,list);
            form.setQuotationNumberValues(getQuotationNoList(list));
             
            /*@11 BEGIN*/
            
            populateComboData(resultMap, form, request, false);
            /*@11 END*/

        }catch(Exception ex){
            throw ex;
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][getAllNewWebBookingDropDownList][End]");
        }

        return resultMap;

    }
    
    /**
     * Method to save booking data when user click on SUBMIT/TEMPLATE button.
     *
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public String saveBooking(EserviceNewWebBookingUim form, HttpServletRequest request) throws Exception {

        Map                             map;
        Map                             mapParam                = new HashMap(0);
        String BookingStatus 									= "";
        //------------------- get object of dao
        EserviceNewWebBookingDao objDao = getDao();
        form.setEditSatus("");
        form.setErrMsg("");
        String forwardPage = SUCCESS;
        if(form.getSaveOperationFlag().equals("N")) {
        	form.setBookingNo("");
        	form.setTemplateName("");
        }
        try {
        	form.setShipmentTerm(form.getPol()+""+form.getPod());
            //@01 BEGIN
            String strCheck ="success";// checkQuotationNo(form, request);
            String strMsg = "";
            if(strCheck.equalsIgnoreCase("n")){
                strMsg = MSG_CHECK_QTN;

                form.setNewWebBookingErrMsg(strMsg);
            }else{
                form.setNewWebBookingErrMsg(strMsg);
            //@01 END


             //Begin Delete from table

              if(form.getSaveOperationFlag().equalsIgnoreCase("T")){
                 mapParam = objDao.deleleEqSizeType(form);
                 mapParam = objDao.deleleCommodity(form);
              }

              form.setDeleleEqSizeType("");
              form.setDeleteCommod("");

             //End Delete from table

            //regenerate EquipmentVoDataList and CommodityVoDataList

             List newEquipmentList = new ArrayList();
             List newCommodityList = new ArrayList();
             for(int i = 0 ; i < form.getEquipmentVoDataList().size() ; i++){
                 EserviceEquipmentDetailsMod mod = (EserviceEquipmentDetailsMod)form.getEquipmentVoDataList().get(i);
                    System.out.println("Laden::" + mod.getLaden());
                     if(mod.getLaden() !=null ){
                         if(!mod.getEqRecordStatus().equals(EserviceNewWebBookingDao.DEL_OPERATION)){
                             if(form.getSaveOperationFlag().equals("N")){
                                mod.setEqRecordStatus("ADD");
                             }
                             newEquipmentList.add(mod);
                         }
                     }
             }
             for(int i = 0 ; i < form.getCommodityVoDataList().size() ; i++){
                 EserviceCommodityDetailsMod mod = (EserviceCommodityDetailsMod)form.getCommodityVoDataList().get(i);
                     if(mod.getGroup() !=null ){
                         if(!mod.getRecordStatus().equals(EserviceNewWebBookingDao.DEL_OPERATION)){
                             if(form.getSaveOperationFlag().equals("N")){
                                mod.setRecordStatus("ADD");
                             }
                             newCommodityList.add(mod);
                         }
                     }
             }

             form.setEquipmentVoDataList(newEquipmentList);
             form.setCommodityVoDataList(newCommodityList);

            //------------------- set user id in form bean.
            form.setUserId(getUserID(request));

            //------------------ check which operation should perform

            //@06 BEGIN
             Map mapCheckPickup = new HashMap(0);
             mapCheckPickup.put(objDao.KEY_EMPTY_PICKUP_DEPT,form.getEmptyPickupDepot());
             mapCheckPickup.put(objDao.KEY_PORT_OF_LOADING,form.getPortOfLoading());
             /*
              * sushil
              * try{
                 if(!form.getEmptyPickupDepot().equals("")){
                     mapCheckPickup = objDao.getCheckPickUpDepot(mapCheckPickup);
                 }
             }catch(BusinessException e){
                 throw e;
             }*/
             //@06 END
//             System.out.println("mapCheckPickup >>>>>>>>KEY_ERR_CD_OUT>>>>>>>>>>>>>>>>> :"+mapCheckPickup.get(objDao.KEY_ERR_CD_OUT)+":");
//             System.out.println("mapCheckPickup >>>>>>>>KEY_ERR_DESC_OUT>>>>>>>>>>>>>>>>> :"+mapCheckPickup.get(objDao.KEY_ERR_DESC_OUT)+":");
            //@06 BEGIN
            if(mapCheckPickup.get(EserviceNewWebBookingDao.P_O_V.ERR_CD) == null || mapCheckPickup.get(EserviceNewWebBookingDao.P_O_V.ERR_CD).equals("SUCCESS")){
                //@06 END
                if (null == form.getBookingNo() ||
                    (BLANK.equals(form.getBookingNo()))) {


                    //------------------- add new booking data
                    map = saveBookingData(objDao, form);

    //                System.out.println("testtesttest.....saveBookingData...1111...............................................");
                } else {

                    //add check save flag equal "N" for submit booking when load template
                    if(form.getSaveOperationFlag().equals("N")&& ( form.getBookingNo()== null || form.getBookingNo().equals(""))){




                        map = saveBookingData(objDao, form);
    //                    System.out.println("testtesttest.....saveBookingData..................................................");
                    }else{
                    	//sushil 
                    	for(int i = 0 ; i < form.getCommodityVoDataList().size() ; i++){
                            EserviceCommodityDetailsMod mod = (EserviceCommodityDetailsMod)form.getCommodityVoDataList().get(i);
                            mod.setRecordStatus("ADD");
                        }
                    	//form.setPortOfLoading(form.getPol());
                    	//form.setPortOfDischarge(form.getPod());
                        map = updateBookingData(objDao, form);
                        form.setTemplateFlag("");
                        form.setEditSatus("New");
                        
    //                    System.out.println("testtesttest.....updateBookingData..................................................");
                    }

                    //------------------- update template data

                }
                //@06 BEGIN

                 //@12 BEGIN
                  if(form.getSaveOperationFlag().equalsIgnoreCase("T")){

                     form.setEserviceUploadUim(null);
                     form.setUploadFlag("N");

                     getTemplateOnloadData(form, request);
                  }
                 //@12 END

            }else{

                 form.setNewWebBookingErrMsg(mapCheckPickup.get(EserviceNewWebBookingDao.P_O_V.ERR_DESC).toString());
            }// end check pickup depot
            //@06 END
                 //@01 BEGIN
                 }// end check QTN
                  //@01 END

//                System.out.println("testtesttest.......................................................");
            
            // Sushil Save 
            AdminBookingLogDao  daoObj = getAdminLoginDao();
            daoObj.insertLogInLogTable(form,null,AdminBookingLogDao.SAVE_BOOKING);
            
        } catch (Exception e) {
            e.printStackTrace();
            form.setErrMsg("Booking Creation Faild.");
            AdminBookingLogDao  daoObj = getAdminLoginDao();
            daoObj.insertLogInLogTable(form,e,AdminBookingLogDao.SAVE_BOOKING_ERROR);
            getAllNewWebBookingDropDownList(form, request);
            forwardPage = FAILURE;
            return forwardPage;
        }

        
        System.out.println("before thread creation.");
        //------------------- populate combo data.
        // getAllNewWebBookingDropDownList(form, request);
		String volume="";
        for(int i = 0 ; i < form.getEquipmentVoDataList().size() ; i++){
         String cargtype="";  
        EserviceEquipmentDetailsMod list=	(EserviceEquipmentDetailsMod) form.getEquipmentVoDataList().get(i);
        if(list.getCargoType().equals("N")) {
        	cargtype="Normal";
        }else if(list.getCargoType().equals("NR")){
        	cargtype="Non-Reefer";
        }else if(list.getCargoType().equals("O0")) {
        	cargtype="OOG";
        }else if(list.getCargoType().equals("OD")) {
        	cargtype="Open Door";
        }else if(list.getCargoType().equals("D1")){
        	cargtype="DG";
        }else if(list.getCargoType().equals("DA")){
        	cargtype="Door Ajar";
        }	
        if(volume.equals("")) {
               volume=volume+list.getLaden()+ " X " +list.getSize()+""+list.getType()  +" (Laden - "+cargtype+")";
        	}else {
        	   volume=volume+" & "+list.getLaden()+ " X " + list.getSize() +""+ list.getType() +" (Laden - "+cargtype+")";
        	}
        }
        form.setMailVolume(volume);
        try { 
        HttpSession session = request.getSession(true);

        UserAccountBean
        account=(UserAccountBean)session.getAttribute(GlobalConstants.
        		USER_ACCOUNT_BEAN); 
        if(!form.getSaveOperationFlag().equalsIgnoreCase("T")) {
        			try {
        				String user = form.getUserId();
        				form.setUserName(account.get_userName());
        				form.setCustomerName(account.get_userName());
        				//form.setCustomerName(account.get_userName());
        				String bookingPartyComName=objDao.getBookingPatyCompName(form.getBookingNo());
        				String RepCompanyNAme=objDao.getRepresentCompName(form.getBookingNo());
        				AdminBookingLogDao adminLogDAO= getAdminLoginDao();
    					BookingThread th = new BookingThread(form, objDao, user,RepCompanyNAme,bookingPartyComName,adminLogDAO);
    					th.start();
        			}catch (Exception e) { 
        				e.printStackTrace(); 
        				}
        		} 
        }catch (Exception e) { 
        	e.printStackTrace();
        }

        //------------------- return success
        return forwardPage;
    } // saveBooking


    

	/**
     * Method to load template data on screen when user chane
     * template name in combo box.
     *
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public String getTemplateOnloadData(EserviceNewWebBookingUim form, HttpServletRequest request) throws Exception {

        Map                         map             = new HashMap(0);
        EserviceNewWebBookingUim    objMod          = null;
        String                      forwardPage     = SUCCESS;

        try{
            if(form.getTemplate().equals(BLANK)){
            //@03 BEGIN
                resetDefaultFieldValue(form);
                //------------------------------- get onload data
                 map = getOnloadData(form, request);

                //------------------- get blank row for size type.
                getDefaultEquipmentSizeTypeRow(form);

                //------------------- get blank row for cargo type.
                getDefaultCargoDetailRow(form);

                form.setOriginCountry(getUserFSC(form.getUserId()));
            //@03 END
            }else{
                //------------------------------- get object of DAO
                EserviceNewWebBookingDao objDao = getDao();

                //-------------------------------
                // get template data from DB and set on actionform.
                //-------------------------------
                map = objDao.getTemplateOnloadData(form.getTemplate(),form.getUserId());

                //---------------------------
                // get header data
                //---------------------------
                objMod =
                        (EserviceNewWebBookingUim)map.get(EserviceNewWebBookingDao.KEY_HEADER_DATA);
                setBookingHdrData(form, objMod);

                Map mapQtn = new HashMap();
                mapQtn.put(EserviceNewWebBookingDao.P_I_V.QTN_NO, form.getQuotationNumber());
                if(form.getQuotationNumber() != null && !form.getQuotationNumber().equals("")){
                    mapQtn = objDao.getQuotationInfo(mapQtn);

                    if(null!=mapQtn)
                    {
                        setQuotationInfoToShow(mapQtn, form);
                    }
                }


                //---------------------------
                // get size type data
                //---------------------------
                List listSizeTypeData = (List)map.get(EserviceNewWebBookingDao.KEY_SIZE_TYPE_DATA);
                setSizeTypeData(form, listSizeTypeData);

                //---------------------------
                // get commodity data logic start
                //---------------------------
                List listCommodityData = (List)map.get(EserviceNewWebBookingDao.KEY_COMMODITY_DATA);
                setCommodityData(form, listCommodityData);
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
            getAllNewWebBookingDropDownList(form, request);
            throw e;
        }

        getAllNewWebBookingDropDownList(form, request);
        
        form.setSailingDate((String)request.getSession().getAttribute("EXPECTED_SAILING_DATE"));
        form.setDesiredArrivalDate((String)request.getSession().getAttribute("DESIRED_ARRIVAL_DATE"));
        
        form.setToTerminal((String)request.getSession().getAttribute("TO_TERMINAL_DATA"));
        form.setFromTerminal((String)request.getSession().getAttribute("FROM_TERMINAL_DATA"));
        form.setVesselEtd((String)request.getSession().getAttribute("VESSEL_ETD_DATE"));
        form.setTo((String)request.getSession().getAttribute("FIRST_LEG_TERMENAL_DATE"));
        form.setToLocation((String)request.getSession().getAttribute("FIRST_LEG_LOCATION_DATE"));
        
        
        form.setEmptyPickupDate("");
        form.setShipmentDate("");
        //------------------------------- return to view.
        return forwardPage;
    } // getTemplateOnloadData

    /**
     * Method called to update booking data on DB.
     *
     * @param objDao
     * @param objForm
     * @return
     * @throws BusinessException
     */
    public Map updateBookingData(EserviceNewWebBookingDao objDao,
                                 EserviceNewWebBookingUim objForm) throws Exception {
        Map map = new HashMap(0);

        //----------------- update booking header data
        map = objDao.updateBookingData(objForm);

        //----------------- update booking size-type data
//        map = objDao.updateEquipmentDetails(objForm);
        map = objDao.saveEquipmentDetails(objForm);

        //----------------- udpate commodity data
        map = objDao.saveCommodityDetails(objForm);

        if (objForm.getSaveOperationFlag().equals("N")) {
            //Upload document
            map = objDao.saveUploadDocument(objForm);
        }

        return map;
    } // updateBookingData

    /**
     * Method to add new booking on DB.
     *
     * @param objDao
     * @param eserviceNewWebBookingUim
     * @return
     * @throws Exception 
     * @throws DataAccessException 
     */
    public Map saveBookingData(EserviceNewWebBookingDao objDao,
                               EserviceNewWebBookingUim eserviceNewWebBookingUim) throws DataAccessException, Exception {
        String bookingNo = null;
        String bookingRef =null;
        String line = null;
        String trade = null;
        String agent = null;
        String customerCode = null;
        String customerName = null;

        Map map = new HashMap(0);
        try{
        	eserviceNewWebBookingUim.setUserId(WebUtils.getUserNew(request).getUserId());
        	eserviceNewWebBookingUim.setAgent(WebUtils.getUserNew(request).getAgent());
        	eserviceNewWebBookingUim.setLine(WebUtils.getUserNew(request).getLine());
        	eserviceNewWebBookingUim.setTrade(WebUtils.getUserNew(request).getTrade());
        	
            map = objDao.saveBookingData(eserviceNewWebBookingUim);
        }catch(BusinessException e){
            throw e;
        }
        //-------------------- get DB output from map.
        
        
        bookingNo = (String)map.get(EserviceNewWebBookingDao.P_O_V.BOOKING_NO);
        bookingRef =  (String)map.get("P_O_V_BOOKING_REF");
        customerCode = (String)map.get(EserviceNewWebBookingDao.P_O_V.CUSTOMER_CODE);
        customerName = (String)map.get(EserviceNewWebBookingDao.P_O_V.CUSTOMER_NAME);

        //-------------------- initialize action form.
        eserviceNewWebBookingUim.setBookingNo(bookingNo);  
        eserviceNewWebBookingUim.setBookingRef(bookingRef);
        eserviceNewWebBookingUim.setCustomerCode(customerCode);
        eserviceNewWebBookingUim.setCustomerName(customerName);

        request.setAttribute("bookingNo", bookingNo);
        //------------------- call dao method to save size equipment Details.
        try{
        map = objDao.saveEquipmentDetails(eserviceNewWebBookingUim);
        System.out.println("saveEquipmentDetails ............................................. ");
        //------------------- call dao method to save size comodity Details.
        map = objDao.saveCommodityDetails(eserviceNewWebBookingUim);

        System.out.println("saveCommodityDetails ............................................. ");
        }catch(Exception e){
            e.printStackTrace();            
            throw e;
        }

        //------------------- set default value, for acknowledgement screen.
        eserviceNewWebBookingUim.setOpenAcknowledgement(Boolean.FALSE);

        //------------------- run only if, saving new booking.
        if (eserviceNewWebBookingUim.getSaveOperationFlag().equals("N")) {
            //Upload document
            map = objDao.saveUploadDocument(eserviceNewWebBookingUim);
            
            //------------------- call enotice logic.
            // map = objDao.sendEnotice(eserviceNewWebBookingUim.getBookingNo());

            //------------------- show acknowledge popup page.
            eserviceNewWebBookingUim.setOpenAcknowledgement(Boolean.TRUE);
        }
        return map;
    } //saveBookingData

    /**
     * Method to set template data in header fields.
     *
     * @param objForm
     * @param objMod
     */
    public void setBookingHdrData(EserviceNewWebBookingUim objForm,
                                  EserviceNewWebBookingUim objMod) {
        objForm.setBookingNo(objMod.getBookingNo());
        objForm.setQuotationNumber(objMod.getQuotationNumber());
        objForm.setStatus(objMod.getStatus());
        objForm.setFax(objMod.getFax());
        objForm.setEmail(objMod.getEmail());
        objForm.setCustomerReference(objMod.getCustomerReference());
        objForm.setPlaceOfReceipt(objMod.getPlaceOfReceipt());
        objForm.setPortOfLoading(objMod.getPortOfLoading());
        objForm.setPortOfDischarge(objMod.getPortOfDischarge());
        objForm.setPlaceOfDelivery(objMod.getPlaceOfDelivery());
        objForm.setShipmentDate(objMod.getShipmentDate());
        objForm.setShipmentTerm(objMod.getShipmentTerm());
        objForm.setTelephone(objMod.getTelephone());
        objForm.setAdditionalMailRecipeints(objMod.getAdditionalMailRecipeints());
        objForm.setDesiredArrivalDate(objMod.getDesiredArrivalDate());
        objForm.setRoutingPreference(objMod.getRoutingPreference());
        objForm.setCargoDescription(objMod.getCargoDescription());
        objForm.setOriginCountry(objMod.getOriginCountry());
        objForm.setDestinationCountry(objMod.getOriginCountry());
        objForm.setTemplateFlag(objMod.getTemplateFlag());
        objForm.setTemplateName(objMod.getTemplateName());
        objForm.setContact(objMod.getContact());
        objForm.setOriginCountry(objMod.getOriginCountry());
        objForm.setDestinationCountry(objMod.getDestinationCountry());
        objForm.setLine(objMod.getLine());
        objForm.setTrade(objMod.getTrade());
        objForm.setAgent(objMod.getAgent());
        objForm.setCustomerCode(objMod.getCustomerCode());

        objForm.setSailingDate(objMod.getSailingDate());

        /*Begin @14*/
        objForm.setRepresentCompChkBox(objMod.getRepresentCompChkBox());
        objForm.setRepresentComp(objMod.getRepresentComp());
        /*End @14*/
        objForm.setSocCocUserFlag(objMod.getSocCocUserFlag());//@15

    } //setBookingHdrData

    /**
     * Method to set template data in size-type fields.
     *
     * @param objForm
     * @param list
     */
    public void setSizeTypeData(EserviceNewWebBookingUim objForm, List list) {

        System.out.println("[EserviceNewWebBookingSvc][setSizeTypeData][Begin]");

        EserviceEquipmentDetailsMod     objMod      = null;
        Integer                         seqNo       = null;
        Integer                         seqNoTmp    = null;

        try{
            System.out.println("[EserviceNewWebBookingSvc][setSizeTypeData] list :: " + list);

            for (Object obj: list ){
                objMod = (EserviceEquipmentDetailsMod )obj;
                objForm.setEmptyPickupDepot(objMod.getEmptyPickupDepot());
                objForm.setEmptyPickupDate(objMod.getEmptyPickupDate());
                break;
            }

            for (int i=0;i<list.size();i++){
                objMod = (EserviceEquipmentDetailsMod) list.get(i);

                if(seqNoTmp==null){
                    seqNoTmp = objMod.getEqSeqNo();
                }else{
                    seqNo = objMod.getEqSeqNo();
                    if(seqNo > seqNoTmp){
                        seqNoTmp = seqNo;
                    }
                }
            }
            objForm.setEquipmentSeqNoTmp(String.valueOf(seqNoTmp));
            objForm.setEquipmentVoDataList(list);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][setSizeTypeData][End]");
        }
    }//setSizeTypeData

    /**
     * Method to set template data in commodity fields.
     *
     * @param objForm
     * @param list
     */
    public void setCommodityData(EserviceNewWebBookingUim objForm, List list) {
        System.out.println("[EserviceNewWebBookingSvc][setCommodityData][Begin]");
        EserviceCommodityDetailsMod     objMod      = null;
        Integer                         seqNo       = null;
        Integer                         seqNoTmp    = null;

        try{
            for (int i=0;i<list.size();i++){
                objMod = (EserviceCommodityDetailsMod) list.get(i);

                if(seqNoTmp==null){
                    seqNoTmp = objMod.getSeqNo();
                }else{
                    seqNo = objMod.getSeqNo();
                    if(seqNo > seqNoTmp){
                        seqNoTmp = seqNo;
                    }
                }
            }
            objForm.setCommoditySeqNoTmp(String.valueOf(seqNoTmp));
            objForm.setCommodityVoDataList(list);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][setCommodityData][End]");
        }


    }

    public void resetDefaultFieldValue(EserviceNewWebBookingUim objForm){
        objForm.setRclArrangementChkBox("on");
        objForm.setSize("20");
        objForm.setType("GP");
        objForm.setCargoType("N");
        objForm.setLaden("0");
        objForm.setMt("0");
        objForm.setStatus("Open");
        objForm.setShipmentTerm("CYCY");
        objForm.setBookingNo(BLANK);
        objForm.setQuotationNumber(BLANK);
        objForm.setShipmentTerm(BLANK);
        objForm.setCustomerReference(BLANK);
        objForm.setEmail(BLANK);
        objForm.setTelephone(BLANK);
        objForm.setFax(BLANK);
        objForm.setContact(BLANK);
        objForm.setAdditionalMailRecipeints(BLANK);
        objForm.setOriginCountry(BLANK);
        objForm.setDestinationCountry(BLANK);
        objForm.setPlaceOfReceipt(BLANK);
        objForm.setPortOfLoading(BLANK);
        objForm.setPortOfDischarge(BLANK);
        objForm.setPlaceOfDelivery(BLANK);
        objForm.setEmptyPickupDepot(BLANK);
        objForm.setEmptyPickupDate(BLANK);
        objForm.setShipmentDate(BLANK);
        objForm.setDesiredArrivalDate(BLANK);
        objForm.setRoutingPreference(BLANK);
        objForm.setGrossContainerWeight(BLANK);
        objForm.setCargoDescription(BLANK);
        objForm.setCommodityGroup(BLANK);
        objForm.setCommodityGroupDetail(BLANK);
        objForm.setGrossWeight(BLANK);
        objForm.setSpecialInstruction(BLANK);
        objForm.setTemplateName(BLANK);

        /*Begin @14*/
        objForm.setRepresentCompChkBox("N");
        objForm.setRepresentComp("");
        /*End @14*/

        objForm.setSailingDate(BLANK);
    } // resetDefaultFieldValue

    public void getDefaultEquipmentSizeTypeRow(EserviceNewWebBookingUim objForm){

        List                        lst     = new ArrayList();
        EserviceEquipmentDetailsMod objVo   = new EserviceEquipmentDetailsMod();

        objVo.setEqSeqNo(1);


        objVo.setEqRecordStatus("ADD");

        lst.add(objVo);
        objForm.setEquipmentVoDataList(lst);

        /*Begin @13*/
        objForm.setEquipmentSeqNoTmp("1");
        /*End @13*/


    } // getDefaultEquipmentSizeTypeRow


    public void getDefaultCargoDetailRow(EserviceNewWebBookingUim objForm){

        List                        lst     = new ArrayList();
        EserviceCommodityDetailsMod objVo   = new EserviceCommodityDetailsMod ();

        objVo.setSeqNo(1);
        objVo.setRecordStatus("ADD");

        lst.add(objVo);
        objForm.setCommodityVoDataList(lst);

        /*Begin @13*/
        objForm.setCommoditySeqNoTmp("1");
        /*End @13*/

    }// getDefaultCargoDetailRow

     public String getUserFSC(String userId){
         System.out.println("[EserviceNewWebBookingSvc][getUserFSC][Begin]");

         EserviceNewWebBookingDao   objDao          = null;
         Map                        paramsMap       = null;
         Map                        resultMap       = null;
         String                     userFSC         = null;

         try{
            System.out.println("[EserviceNewWebBookingSvc][getUserFSC] userId :: " + userId);

            paramsMap = new HashMap(0);
            paramsMap.put(KEY_USER_ID, userId);

            objDao = getDao();
            resultMap = objDao.getFSCDetails(paramsMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(resultMap != null && resultMap.containsKey(EserviceNewWebBookingDao.KEY_CODE)){
                userFSC = (String) resultMap.get(EserviceNewWebBookingDao.KEY_CODE);
            }
            System.out.println("[EserviceNewWebBookingSvc][getUserFSC][End]");
        }
        return userFSC;
     }

    /*Begin @13*/
     public String onDeleleEqSizeType(EserviceNewWebBookingUim form) throws Exception {
         System.out.println("[EserviceNewWebBookingSvc][onDeleleEqSizeType][Begin]");

         String                          paramReq                = null;
         String[]                        la_seq                  = null;
         List                            equipmentVoDataList     = null;
         EserviceEquipmentDetailsMod     objVo                   = null;
         String                          eqRecordStatus          = null;

         try{
             paramReq                = this.request.getParameter("paramReq");
             la_seq                  = paramReq.split("\\#");
             equipmentVoDataList     = form.getEquipmentVoDataList();

             for(int i=0;i<la_seq.length;i++){
                 for(int j=0;j<equipmentVoDataList.size();j++){
                     objVo = (EserviceEquipmentDetailsMod)equipmentVoDataList.get(j);
                     if(String.valueOf(objVo.getEqSeqNo()).equals(la_seq[i])){
                         eqRecordStatus = objVo.getEqRecordStatus();
                         if(eqRecordStatus.equals(EserviceNewWebBookingDao.ADD_OPERATION)){
                             equipmentVoDataList.remove(j);
                         }else{
                             objVo.setEqRecordStatus(EserviceNewWebBookingDao.DEL_OPERATION);
                         }
                     }
                 }
             }

             this.formatUtil.writeMSG("OK");

         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceNewWebBookingSvc][onDeleleEqSizeType][End]");
         }

         return null;
     }
    /*End @13*/

    /*Begin @13*/
    public String onDeleleCommodity(EserviceNewWebBookingUim form) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][onDeleleCommodity][Begin]");
        String                          paramReq                = null;
        String[]                        la_seq                  = null;
        List                            commodityVoDataList     = null;
        EserviceCommodityDetailsMod     objVo                   = null;
        String                          recordStatus            = null;

        try{
            paramReq                = this.request.getParameter("paramReq");
            la_seq                  = paramReq.split("\\#");
            commodityVoDataList     = form.getCommodityVoDataList();

            for(int i=0;i<la_seq.length;i++){
                for(int j=0;j<commodityVoDataList.size();j++){
                    objVo = (EserviceCommodityDetailsMod)commodityVoDataList.get(j);
                    if(String.valueOf(objVo.getSeqNo()).equals(la_seq[i])){
                        recordStatus = objVo.getRecordStatus();
                        if(recordStatus.equals(EserviceNewWebBookingDao.ADD_OPERATION)){
                            commodityVoDataList.remove(j);
                        }else{
                            objVo.setRecordStatus(EserviceNewWebBookingDao.DEL_OPERATION);
                        }
                    }
                }
            }

            this.formatUtil.writeMSG("OK");

        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][onDeleleCommodity][End]");
        }

        return null;
    }
    /*End @13*/

     /*Begin @13*/
     public String onADDEqSizeType(EserviceNewWebBookingUim form) throws Exception {
         System.out.println("[EserviceNewWebBookingSvc][onADDEqSizeType][Begin]");

         EserviceEquipmentDetailsMod     objVo       = null;
         String                          newSeq      = null;

         try{
             objVo       = new EserviceEquipmentDetailsMod ();
             newSeq      = this.request.getParameter("newSeq");

             objVo.setEqSeqNo(Integer.parseInt(newSeq));
             objVo.setEqRecordStatus(EserviceNewWebBookingDao.ADD_OPERATION);

             form.getEquipmentVoDataList().add(objVo);
             form.setEquipmentSeqNoTmp(newSeq);

             this.formatUtil.writeMSG("OK");

         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceNewWebBookingSvc][onADDEqSizeType][End]");
         }

         return null;
      }
     /*End @13*/

      /*Begin @13*/
      public String onUpdateEqSizeType(EserviceNewWebBookingUim form) throws Exception {
          System.out.println("[EserviceNewWebBookingSvc][onUpdateEqSizeType][Begin]");

         EserviceEquipmentDetailsMod     objVo                                  = null;
         String                          type                                   = null;
         String                          typeDesc                               = null;
         String                          size                                   = null;
         String                          cargoType                              = null;
         String 						 specialCargo							= null;
         String                          laden                                  = null;
         String                          mt                                     = null;
         String                          grossContainerWeight                   = null;
         String                          polStatus                              = null;
         String                          podStatus                              = null;
         String                          eqSeqNo                                = null;
         String                          eqRecordStatus                         = null;
         String                          equipmentSelectChkBox                  = null;
         List                            equipmentVoDataList                    = null;

         try{

             type                           = this.nullToSpace(this.request.getParameter("type"));
             typeDesc                       = this.nullToSpace(this.request.getParameter("typeDesc"));
             size                           = this.nullToSpace(this.request.getParameter("size"));
             cargoType                      = this.nullToSpace(this.request.getParameter("cargoType"));
             specialCargo                   = this.nullToSpace(this.request.getParameter("specialCargo"));
             laden                          = this.nullToSpace(this.request.getParameter("laden"));
             mt                             = this.nullToSpace(this.request.getParameter("mt"));
             grossContainerWeight           = this.nullToSpace(this.request.getParameter("grossContainerWeight"));
             polStatus                      = this.nullToSpaceForCheckbox(this.request.getParameter("polStatus"));
             podStatus                      = this.nullToSpace(this.request.getParameter("podStatus"));
             eqSeqNo                        = this.nullToSpace(this.request.getParameter("eqSeqNo"));
             equipmentSelectChkBox          = this.nullToSpaceForCheckbox(this.request.getParameter("equipmentSelectChkBox"));

             if(polStatus.equals("")){
                 polStatus = "L";
             }

             if(podStatus.equals("")){
                 podStatus = "L";
             }

             equipmentVoDataList            = form.getEquipmentVoDataList();

             if(eqSeqNo!=null && !eqSeqNo.equals("")){
                 for(int i=0; i<equipmentVoDataList.size();i++){
                     objVo = (EserviceEquipmentDetailsMod) equipmentVoDataList.get(i);
                     if(String.valueOf(objVo.getEqSeqNo()).equals(eqSeqNo)){
                         objVo.setEqSeqNo(Integer.parseInt(eqSeqNo));
                         objVo.setType(type);
                         objVo.setTypeDesc(typeDesc);
                         objVo.setSize(size);
                         objVo.setCargoType(cargoType);
                         objVo.setSpecialCargo(specialCargo);
                         objVo.setLaden(laden);
                         objVo.setMt(mt);
                         objVo.setGrossContainerWeight(grossContainerWeight);
                         objVo.setPolStatus(polStatus);
                         objVo.setPodStatus(podStatus);
                         objVo.setEquipmentSelectChkBox(equipmentSelectChkBox);

                         eqRecordStatus = objVo.getEqRecordStatus();
                         if(eqRecordStatus.equals("") || eqRecordStatus.equals(EserviceNewWebBookingDao.SER_OPERATION)){
                             objVo.setEqRecordStatus(EserviceNewWebBookingDao.UPD_OPERATION);
                         }
                     }
                 }
             }

             this.formatUtil.writeMSG("OK");

         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceNewWebBookingSvc][onUpdateEqSizeType][End]");
         }

         return null;
       }
      /*End @13*/

    /*Begin @13*/
    public String onADDCommodity(EserviceNewWebBookingUim form) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][onADDCommodity][Begin]");

        EserviceCommodityDetailsMod     objVo       = null;
        String                          newSeq      = null;

        try{
            objVo       = new EserviceCommodityDetailsMod ();
            newSeq      = this.request.getParameter("newSeq");

            objVo.setSeqNo(Integer.parseInt(newSeq));
            objVo.setRecordStatus(EserviceNewWebBookingDao.ADD_OPERATION);
            objVo.setRadCommodity(newSeq);

            form.getCommodityVoDataList().add(objVo);
            form.setCommoditySeqNoTmp(newSeq);

            this.formatUtil.writeMSG("OK");

        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][onADDCommodity][End]");
        }

        return null;
     }
    /*End @13*/

     /*Begin @13*/
     public String onUpdateCommodity(EserviceNewWebBookingUim form) throws Exception {
        System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity][Begin]");

        EserviceCommodityDetailsMod     objVo                   = null;
        String                          radCommodity            = null;
        String                          posObjectCommod         = null;
        String                          seqNo                   = null;
        String                          group                   = null;
        String                          description             = null;
        String                          grossWeight             = null;
        String                          specialCargo            = null;
        String                          specialInstruction      = null;
        List                            commodityVoDataList     = null;
        String                          recordStatus            = null;
        String                          rateType                = null;
        String                          specialCargoBox         = null;

        try{

            radCommodity            = this.nullToSpace(this.request.getParameter("radCommodity"));
            posObjectCommod         = this.nullToSpace(this.request.getParameter("posObjectCommod"));
            seqNo                   = this.nullToSpace(this.request.getParameter("seqNo"));
            group                   = this.nullToSpace(this.request.getParameter("group"));
            description             = this.nullToSpace(this.request.getParameter("description"));
            grossWeight             = this.nullToSpace(this.request.getParameter("grossWeight"));
            specialCargo            = this.nullToSpaceForCheckbox(this.request.getParameter("specialCargo"));
            specialInstruction      = this.nullToSpace(this.request.getParameter("specialInstruction"));
            rateType                = this.nullToSpace(this.request.getParameter("rateType"));
            
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] radCommodity          :: " + radCommodity);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] posObjectCommod       :: " + posObjectCommod);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] seqNo                 :: " + seqNo);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] group                 :: " + group);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] description           :: " + description);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] grossWeight           :: " + grossWeight);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] specialCargo          :: " + specialCargo);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] specialInstruction    :: " + specialInstruction);
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity] rateType              :: " + rateType);

            commodityVoDataList     = form.getCommodityVoDataList();

            if(seqNo!=null && !seqNo.equals("")){
                for(int i=0; i<commodityVoDataList.size();i++){
                    objVo = (EserviceCommodityDetailsMod) commodityVoDataList.get(i);
                    if(String.valueOf(objVo.getSeqNo()).equals(seqNo)){
                        objVo.setSeqNo(Integer.parseInt(seqNo));
                        objVo.setDescription(description);
                        objVo.setGroup(group);
                        objVo.setGrossWeight(grossWeight);
                        objVo.setSpecialCargo(specialCargo);
                        objVo.setRadCommodity(radCommodity);
                        objVo.setSpecialInstruction(specialInstruction);
                        objVo.setRateType(rateType);
                        
                        recordStatus = objVo.getRecordStatus();
                        if(recordStatus.equals("") || recordStatus.equals(EserviceNewWebBookingDao.SER_OPERATION)){
                            objVo.setRecordStatus(EserviceNewWebBookingDao.UPD_OPERATION);
                        }
                    }
                }
            }

            this.formatUtil.writeMSG("OK");

        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][onUpdateCommodity][End]");
        }

        return null;
      }
     /*End @13*/

      /*Begin @13*/
      public String onChangeRateType(EserviceNewWebBookingUim form) throws Exception {
          System.out.println("[EserviceNewWebBookingSvc][onChangeRateType][Begin]");

         EserviceCommodityDetailsMod     objVo                   = null;
         String                          seqNo                   = null;
         List                            commodityVoDataList     = null;

         try{

             seqNo                   = this.request.getParameter("seqNo");
             commodityVoDataList     = form.getCommodityVoDataList();

             if(seqNo!=null && !seqNo.equals("")){
                 for(int i=0; i<commodityVoDataList.size();i++){
                     objVo = (EserviceCommodityDetailsMod) commodityVoDataList.get(i);
                     if(objVo.getSeqNo().equals(seqNo)){
                         objVo.setRateTypeClassName(EserviceNewWebBookingDao.STYLE_BLUE);
                         objVo.setEserviceReferCommoditiesUim(null);
                         objVo.setEserviceDGCommoditiesUim(null);
                         objVo.setEserviceOOGCommoditiesUim(null);
                         objVo.setRateTypeFlag("N");
                     }
                 }
             }

             this.formatUtil.writeMSG("OK");

         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceNewWebBookingSvc][onChangeRateType][End]");
         }

         return null;
       }
      /*End @13*/

 
      
       /*Begin @13*/
        String nullToSpace(String av_obj){
           String lv_str = "";

           try{
               if(av_obj!=null){
                   lv_str = av_obj;
               }
           }catch(Exception e){
               e.printStackTrace();
           }

           return lv_str;
        }

        String nullToSpaceForCheckbox(String av_obj){
          String lv_str = "N";

          try{
              if(av_obj!=null){
                  lv_str = av_obj;
              }
          }catch(Exception e){
              e.printStackTrace();
          }

          return lv_str;
        }
        /*End @13*/

     //@08 BEGIN

    public String setQuotationRoutingData(EserviceNewWebBookingUim form, HttpServletRequest request) throws Exception {

        System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingData][Begin]");

        EserviceNewWebBookingUim    eserviceNewWebBookingUim    = null;
        Map                         mapParam                    = null;
        String                      shipmentType                = null;
        String                      socCocUserFlag              = null;
        String                      forwardPage                 = SUCCESS;

        try{
            eserviceNewWebBookingUim = new EserviceNewWebBookingUim();
            eserviceNewWebBookingUim.setPol(request.getParameter("pol"));
            eserviceNewWebBookingUim.setPod(request.getParameter("pod"));
            eserviceNewWebBookingUim.setOriginCountry(request.getParameter("originCountry"));
            eserviceNewWebBookingUim.setDestinationCountry(request.getParameter("destinationCountry"));
            eserviceNewWebBookingUim.setPlaceOfReceipt(request.getParameter("placeOfReceipt"));
            eserviceNewWebBookingUim.setPortOfLoading(request.getParameter("portOfLoading"));
            eserviceNewWebBookingUim.setPortOfDischarge(request.getParameter("portOfDischarge"));
            eserviceNewWebBookingUim.setPlaceOfDelivery(request.getParameter("placeOfDelivery"));

//            setQuotationRoutingDetail(objForm, eserviceNewWebBookingUim);
            setQuotationRoutingDetail(form, eserviceNewWebBookingUim);

            shipmentType    = request.getParameter("shipmentType");
            socCocUserFlag  = request.getParameter("socCocUserFlag");

            System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingData] shipmentType    :: " + shipmentType);
            System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingData] socCocUserFlag  :: " + socCocUserFlag);

//            objForm.setShipmentType(shipmentType);
//            objForm.setSocCocUserFlag(socCocUserFlag);
            form.setShipmentType(shipmentType);
            form.setSocCocUserFlag(socCocUserFlag);

            mapParam = getAllNewWebBookingDropDownList(form, request);

            //------------------- set acknowledgement screen open flag to false.
//            objForm.setOpenAcknowledgement(Boolean.FALSE);
            form.setOpenAcknowledgement(Boolean.FALSE);
            //------------------- get blank row for size type.
//            getDefaultEquipmentSizeTypeRow(objForm);
            getDefaultEquipmentSizeTypeRow(form);
            //------------------- get blank row for cargo type.
//            getDefaultCargoDetailRow(objForm);
//            getDefaultCargoDetailRow(form);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingData][End]");
        }

        return forwardPage;
    }

     private void setQuotationRoutingDetail(EserviceNewWebBookingUim qtnSet, EserviceNewWebBookingUim qtnGet) throws Exception{

         System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail][Begin]");

         String pol                     = null;
         String pod                     = null;
         String originCountry           = null;
         String destinationCountry      = null;
         String placeOfReceipt          = null;
         String portOfLoading           = null;
         String portOfDischarge         = null;
         String placeOfDelivery         = null;

         try{
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] qtnGet :: " + qtnGet);

             if(qtnGet != null){
                pol                     = qtnGet.getPol();
                pod                     = qtnGet.getPod();
                originCountry           = qtnGet.getOriginCountry();
                destinationCountry      = qtnGet.getDestinationCountry();
                placeOfReceipt          = qtnGet.getPlaceOfReceipt();
                portOfLoading           = qtnGet.getPortOfLoading();
                portOfDischarge         = qtnGet.getPortOfDischarge();
                placeOfDelivery         = qtnGet.getPlaceOfDelivery();
             }

             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] pol                  :: " + pol);
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] pod                  :: " + pod);
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] originCountry        :: " + originCountry);
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] destinationCountry   :: " + destinationCountry);
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] placeOfReceipt       :: " + placeOfReceipt);
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] portOfLoading        :: " + portOfLoading);
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] portOfDischarge      :: " + portOfDischarge);
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail] placeOfDelivery      :: " + placeOfDelivery);

             qtnSet.setOriginCountry(originCountry);
             qtnSet.setDestinationCountry(destinationCountry);
             qtnSet.setPortOfLoading(portOfLoading);
             qtnSet.setPortOfDischarge(portOfDischarge);
             qtnSet.setPol(pol);
             qtnSet.setPod(pod);
             qtnSet.setPlaceOfReceipt(placeOfReceipt);
             qtnSet.setPlaceOfDelivery(placeOfDelivery);
         }catch(Exception ex){
             ex.printStackTrace();
         }finally{
             System.out.println("[EserviceNewWebBookingSvc][setQuotationRoutingDetail][End]");
         }
     }
     //@08 END
//     @10 BEGIN
     private Map getQuotationData(EserviceNewWebBookingUim eserviceNewWebBookingUim) throws Exception{
         System.out.println("[EserviceNewWebBookingSvc][getQuotationData][Begin]");

         EserviceNewWebBookingDao           objDao                      = null;
         Map                                amap                        = null;
         /*Begin @14*/
         String                             representCompChkBox         = null;
         String                             representComp               = null;
         /*End @14*/

         try{
             /*Begin @14*/
             representCompChkBox     = FormatUtil.chkNullForCheckBox(this.request.getParameter("representCompChkBox"));
             representComp           = FormatUtil.nullToBlank(this.request.getParameter("representComp"));

             System.out.println("[EserviceNewWebBookingSvc][getQuotationData] representCompChkBox   :: " + representCompChkBox);
             System.out.println("[EserviceNewWebBookingSvc][getQuotationData] representComp         :: " + representComp);

             eserviceNewWebBookingUim.setRepresentCompChkBox(representCompChkBox);
             eserviceNewWebBookingUim.setRepresentComp(representComp);
             /*End @14*/

             objDao = getDao();
             amap   = objDao.getCheckQuotationNo(eserviceNewWebBookingUim);
         }catch(Exception ex){
             ex.printStackTrace();
         }finally{
             System.out.println("[EserviceNewWebBookingSvc][getQuotationData][End]");
         }
         return amap;
     }
//     @10 END
     
     public List getComboDataNew(HttpServletRequest request, String comboName,boolean flag) throws Exception { 
    	 List<ComboVO> retList = null;
    	 retList =getDao().getComboData(comboName);
    	 return retList;
     }
     
     private List getCargoTypeList(HttpServletRequest request2, String keyCargoType, boolean b) {
		 
    	 List<ComboVO> retList = new ArrayList<ComboVO>();
    	 ComboVO obj=new ComboVO();
    	 obj.setCode("");
    	 obj.setName("Select One...");
    	 ComboVO obj1=new ComboVO();
    	 obj1.setCode("D1");
    	 obj1.setName("DG");
    	 ComboVO obj2=new ComboVO();
    	 obj2.setCode("N");
    	 obj2.setName("Normal");
    	 
    	 retList.add(obj);
    	 retList.add(obj1);
    	 retList.add(obj2);
    	 
 		return retList;
 	}
     
}
