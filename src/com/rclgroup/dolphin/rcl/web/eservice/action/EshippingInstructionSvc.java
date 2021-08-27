/*------------------------------------------------------
  EshippingInstructionSvc.java
  --------------------------------------------------------
  Copyright RCL Public Co., Ltd. 2013
  --------------------------------------------------------
  Author Anurak Thanapradit 27/05/13
  - Change Log -------------------------------------------
  ## DD/MM/YY 		-User- 		-TaskRef- 	-ShortDescription-
  ## 31/07/2013    	TANA     	01     		add commodity in Equipment detail
  ## 01/08/2013    	TANA     	02     		fix search booking no
  ## 01/08/2013    	TANA     	03     		add msg error
  ## 20/08/2013    	TANA     	04     		add step config date
  ## 22/08/2013    	YOSSUN1  	05     		add commodity detail.
  ## 26/08/2013    	YOSSUN1  	06     		add commodity detail.
  ## 27/08/2013    	YOSSUN1  	07     		fixed commodity bug.
  ## 02/09/2013    	YOSSUN1  	08     		change the wording of commodity combo box.
  ## 04/09/2013    	YOSSUN1  	09     		add type to list.
  ## 11/09/2013    	YOSSUN1  	10     		fix the esiMessage not display and disable submit esi button.
  ## 12/09/2013    	YOSSUN1  	11     		change coding method.
  ## 13/09/2013    	YOSSUN1  	12     		add check dupplicate container no. \
  ## 14/10/2013    	YOSSUN1  	13     		add get esiStatus from request.
  ## 31/10/2013    	YOSSUN1  	14     		add esi submission runnable.
  ## 01/11/2013    	YOSSUN1  	15     		add weight parameter to commodity
  ## 14/11/2013    	YOSSUN1  	16     		add cocSoc parameter.
  ## 21/11/2013    	YOSSUN1  	17     		add login id parameter to submitEsi.
  ## 12/12/2013    	YOSSUN1  	18     		add setting esiStatusCode.
  ## 26/12/2013    	YOSSUN1  	19     		Add validate COC.
  ## 26/12/2013    	YOSSUN1  	20     		Add function cargoDesc.
  ## 27/01/2014    	YOSSUN1  	21     		Add new parameters for commodity.
  ## 10/09/2014    	PRATYA   	22     		PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
  ## 18/03/2015    	TANAPHOL 	23     		Add setComboBoxCommodity() in setCommodityDetails() for generate commodity drop down
  ## 23/08/2019	   	Sarawut A.	24			Add method validateData
  ## 26/08/2019	   	Sarawut A.	25			Add method clearESIData
  ## 18/10/2019		Sarawut A.	26			Add fields vessel no, pol no, pod no for save method
  ------------------------------------------------------*/

package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.dao.DataAccessException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.niit.control.common.ComboVO;
import com.niit.control.common.Debug;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.common.exception.ExceptionFactory;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIUtil;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.common.ShippingThread;
import com.rclgroup.dolphin.rcl.web.common.Utilis;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.AdminBookingLogDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingBookingListMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCargoDescriptionMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ShippingPdfPrintVO;

//==============================================================================
//OLD VERSION
//==============================================================================
public class EshippingInstructionSvc extends BaseAction {
	private static  int PDF_NUM_ROWS=25;
	// @11 BEGIN
	public static String BROWSE_BOOKING_NUMBER = "browseBookingNumber";
	public static String SAVE_AS_DRAFT = "saveAsDraft";
	public static String SUBMIT_ESI = "submitEsi";
	public static String GET_DATA = "getData";
	public static String ACKNOWLEDGEMENT = "acknowledgement";
	public static String VALIDATE_DATA_CHANGE = "validateData";
	public static String CLEAR_ESI_DATA = "clearESIData";
	public static String CANCEL_BOOKING = "cancelBooking";
	public static String ON_LOAD_SHIPPING_BTN = "searchBtn";
	public static String PDF_DOWNLOAD = "pdfgenerater";
	// @06 BEGIN
	public static final String SET_COMMODITY_DATA = "setCommodityData";
	public static final String ADD_COMMODITY_DATA = "addCommodity";
	public static final String DELETE_COMMODITY_DATA = "deleteCommodity";
	public static final String ON_LOAD_SHIPPING_INQ = "onLoadShippingInquery";
	public static final String SHIPPING_INQ_MORE_DATA = "onLoadShippingInqueryMoreData";
	public static final String CHECK_SI_EDIT_FLAG	  = "checkSiEditFlag";
	public static final String CHECK_BOOKING_RATE_TYPE_CHECK= "checkBookingRateTypeCheck";
	public static final String VALIDATE_CONTAINER_NO  ="validateContainerNo";
	// @06 END
	public static String NULL_DATA = "null";
	public static String FLAG_DELETE = "delete";
	public static String FLAG_BOOKING = "booking";
	public static String INPUT_YOURSELF_MODE = "yourself";
	public static String STATUS_NEW = "NEW";
	public static String STATUS_IN_PROGRESS = "Entry";
	public static String STATUS_SUBMITTED = "SUBMITTED";
	public static String COMMODITY_STRING = "Commodity ";

	private Boolean isAfterSave = Boolean.FALSE;

	private static List<EshippingCargoDescriptionMod> equipmentTmp;

	private HttpServletRequest request = null;
	private HttpServletResponse response = null;

	
	public EshippingInstructionSvc() {
	}
	// @20 BEGIN

	private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EshippingInstructionUim form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageAction = null;
		String forwardPage = null;

		this.request = request;
		this.response = response;

		try {
			pageAction = form.getCurrPageAction();
			if (ONLOAD.equals(pageAction)) {
				forwardPage = onLoad(form, request);
			} else if (GET_DATA.equals(pageAction)) {
				forwardPage = getWebBooking(form, request);
			} else if (SAVE_AS_DRAFT.equals(pageAction)) {
				forwardPage = saveDraft(form, request);
			} else if (SUBMIT_ESI.equals(pageAction)) {
				forwardPage = submitEsi(form, request);
			} else if (ACKNOWLEDGEMENT.equals(pageAction)) {
				forwardPage = openAcknowledgementPopup(form, request);
			} else if (SET_COMMODITY_DATA.equals(pageAction)) {
				// forwardPage = setCommodityData(form, request);
				forwardPage = this.setCommodityData(form);
			} else if (DELETE_COMMODITY_DATA.equals(pageAction)) {
				// forwardPage = deleteCommodity(form, request);
				forwardPage = this.deleteCommodity(form);
			} else if (ADD_COMMODITY_DATA.equals(pageAction)) {
				forwardPage = this.addCommodity(form);
			} else if (VALIDATE_DATA_CHANGE.equals(pageAction)) {
				forwardPage = this.validateData(form);
			} else if (CLEAR_ESI_DATA.equals(pageAction)) {
				forwardPage = this.clearESIData(form);
			} else if (ON_LOAD_SHIPPING_INQ.equals(pageAction)) {
				forwardPage = this.getShippingInquery(form, request);
			} else if (ON_LOAD_SHIPPING_BTN.equals(pageAction)) {
				forwardPage = this.shippingBtn(form, actionForm, request);
			} else if (SHIPPING_INQ_MORE_DATA.equals(pageAction)) {
				forwardPage = this.getShippingInqueryMoreData(form, request, response);
			} else if (CANCEL_BOOKING.equals(pageAction)) {
				forwardPage = this.getBookingAndShippingCancel(form, request, response);
			} else if (PDF_DOWNLOAD.equals(pageAction)) {
				this.getPDFData(form, actionForm, request, response);
			} else if (CHECK_SI_EDIT_FLAG.equals(pageAction)) {
				forwardPage = this.getCheckSiEditFlag(form, request, response);
			} else if (CHECK_BOOKING_RATE_TYPE_CHECK.equals(pageAction)) {
				forwardPage = this.getCheckBookingRateType(form, request, response);
			}else if (VALIDATE_CONTAINER_NO.equals(pageAction)) {
				forwardPage = this.getValidateContainerNo(form, request, response);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return forwardPage;
	}
	
	// @20 END

	private String getValidateContainerNo(EshippingInstructionUim form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(form.getContainerArrayJson());
		Map<String,String> map=new HashMap<String,String>();
		List list =new ArrayList();
		try {
			EshippingInstructionDao objDao = getDao();
			map=objDao.getValidateConatinerNos(form.getContainerArrayJson());
			net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
			jsonObj = new net.sf.json.JSONObject();
			jsonObj.put("Result", map);
			response.setContentType("text");
			jsonObj.write(response.getWriter());
			System.out.println("Json In string " + jsonObj.write(new StringWriter()));
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private String getCheckSiEditFlag(EshippingInstructionUim form, HttpServletRequest request,
			HttpServletResponse response) {
		  System.out.println("getCheckSiEditFlag() called ..");
		  try {
		  EshippingInstructionDao objDao = getDao();
		  System.out.println("booking no. "+form.getBookingNo());
		  String flag = objDao.checkSiEditFlag(form.getBookingNo());
		  System.out.println(flag);
		  response.getWriter().print(flag);
		  }catch (Exception e) {
			 e.printStackTrace();
		  }
		  
		return null;
	}

	private String getCheckBookingRateType(EshippingInstructionUim form, HttpServletRequest request,
			HttpServletResponse response) {
		 System.out.println("getCheckSiEditFlag() called ..");
		  try {
		  EshippingInstructionDao objDao = getDao();
		  System.out.println("booking no. "+form.getBookingNo());
		  String flag = objDao.checkBookingRatetypeValidation(form.getBookingNo());
		  System.out.println(flag);
		  response.getWriter().print(flag);
		  }catch (Exception e) {
			 e.printStackTrace();
		  }
		  
		return null;
	}
	
	private String getBookingAndShippingCancel(EshippingInstructionUim form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forwardPage = FAILURE;

		EshippingInstructionDao objDao = getDao();
		try {
			objDao.cancelBookingDtl(form);
			request.getSession(false).setAttribute("status", "N");
			request.getSession(false).setAttribute("bookingno", form.getBookingNo());
			forwardPage = SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			forwardPage = FAILURE;
		}

		onLoad(form, request);

		return forwardPage;
	}

	/**
	 *
	 * Called from Action Servlet.
	 *
	 * @exception Exception
	 * @param mapping
	 *            ActionMapping
	 * @param actionForm
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EshippingInstructionUim form = null;

		String pageAction = null;
		String errorMsg = null;
		String forwardPage = null;
		try {
			pageAction = getPageAction(mapping);

			form = getForm(actionForm, pageAction);
			form.setCurrPageAction(pageAction);
			forwardPage = getForwardPage(mapping, actionForm, form, request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
			form.setErrMsg(errorMsg);

			forwardPage = FAILURE;
		}
		return mapping.findForward(forwardPage);
	} // end of executeAction method

	/**
	 *
	 * This method called when screen load.
	 *
	 * @exception Exception
	 * @param form
	 *            EshippingInstructionUim
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public String onLoad(EshippingInstructionUim form, HttpServletRequest request) throws Exception {
		List<ComboVO> blTypeValues = null;

		String forwardPage = FAILURE;
		try {
			blTypeValues = form.getBlTypeValues();
			if (blTypeValues == null || blTypeValues.isEmpty()) {
				blTypeValues = ComboBoxESIUtil.getBLTypeDDList();
				form.setBlTypeValues(blTypeValues);
			}

			forwardPage = SUCCESS;
		} catch (Exception ex) {
			throw ex;
		} finally {
			form.setChoiceRad("1");
			form.setBlType("T");

			newCargeDetails(1, form, "0", null);

			getDefaultCargoDetailRow(form);

			setSessionForm(request, form);
		}
		return forwardPage;
	}

	private String getShippingInquery(EshippingInstructionUim form, HttpServletRequest request) {
		String forwardPage = FAILURE;
		Map resultMap = null;
		EshippingInstructionDao objDao = null;
		List lstTableData = null;
		EshippingInstructionUim objForm = new EshippingInstructionUim();
		UserAccountBean account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
		try {
			objDao = getDao();
			String userId = (getUserID(request));
			String orgCode = account.getOrgCode();
			resultMap = objDao.getInquiryHeaderData(form, userId, orgCode);

			List list = null;
			if (resultMap.get("ERROR_CODE") != null) {
				request.setAttribute("listShippingError", resultMap.get("ERROR_CODE").toString());
				request.setAttribute("listShipping", objForm.getValues());
				// formObj.setStatus("");
				return SUCCESS;
			} else {
				list = (List) resultMap.get("DATA");
			}

			if (null != list) {
				lstTableData = list;
			}

			if (null == lstTableData) {
				objForm.setValues(new ArrayList());
			} else {
				objForm.setValues(lstTableData);
			}

			request.setAttribute("listShipping", objForm.getValues());
			request.setAttribute("listShippingError", null);

		} catch (Exception e) {
			e.printStackTrace();
		}

		forwardPage = SUCCESS;
		return forwardPage;
	}

	private String shippingBtn(EshippingInstructionUim form, ActionForm actionForm, HttpServletRequest request) {
		String forwardPage = FAILURE;
		Map resultMap = null;
		EshippingInstructionDao objDao = null;
		List lstTableData = null;
		EshippingInstructionUim uimForm = new EshippingInstructionUim();
		EshippingInstructionUim objForm = (EshippingInstructionUim) actionForm;
		UserAccountBean account = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
		try {
			
			if(request.getSession().getAttribute("bookingno")!=null) {
				objForm.setBookingNo((String)request.getSession().getAttribute("bookingno"));
				objForm.setEsiStatusCode((String)request.getSession(false).getAttribute("status"));
				request.getSession(false).setAttribute("status",null);
				request.getSession(false).setAttribute("bookingno", null);
			}
			objDao = getDao();
			String userID = (getUserID(request));
			String orgCode = account.getOrgCode();
			resultMap = objDao.getInquiryShippingBtn(objForm, userID, orgCode);

			List list = null;
			if (resultMap.get("ERROR_CODE") != null) {

				request.setAttribute("listShippingError", resultMap.get("ERROR_CODE").toString());
				request.setAttribute("listShipping", uimForm.getValues());
				return FAILURE;
			} else {
				list = (List) resultMap.get("DATA");
			}

			if (null != list) {
				lstTableData = list;
			}

			if (null == lstTableData) {
				uimForm.setValues(new ArrayList());
			} else {
				uimForm.setValues(lstTableData);
			}

			request.setAttribute("listShipping", uimForm.getValues());
			request.setAttribute("listShippingError", null);

		} catch (Exception e) {
			e.printStackTrace();
		}

		forwardPage = SUCCESS;
		return forwardPage;
	}

	public String getShippingInqueryMoreData(EshippingInstructionUim form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		EshippingInstructionUim objForm = null;
		EshippingInstructionDao objDao = null;
		String bookingNo = null;
		String bookingStatus = null;
		String modeGetData = null;
		Map mapParams = null;
		Map result = null;
		Boolean isLoadData = Boolean.FALSE;
		String esiStatusCode = null;
		String strMode = null;
		String blNo = null;
		try {
			objForm = (EshippingInstructionUim) form;
			objDao = getDao();
			bookingNo = objForm.getBookingNo();
			bookingStatus = objForm.getEsiStatusCode();
			modeGetData = objForm.getMode();
			mapParams = new HashMap();
			blNo = objForm.getBlNo();
			esiStatusCode = form.getEsiStatusCode();
			if (esiStatusCode == null || esiStatusCode.equals("")) {
				esiStatusCode = "N";
			}

			objForm.setNotFound(Boolean.FALSE);

			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] blNo   :: " + blNo);
			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] bookingNo     :: " + bookingNo);
			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] esiStatusCode     :: " + esiStatusCode);

			mapParams.put(EshippingInstructionDao.P_I_V.BL_NO, blNo);
			mapParams.put(EshippingInstructionDao.P_I_V.BKG_NO, bookingNo);

			strMode = convertStatus(esiStatusCode);

			mapParams.put(EshippingInstructionDao.P_I_V.STATUS, convertStatus(esiStatusCode));
			mapParams.put(EshippingInstructionDao.P_I_V.MODE, convertStatus(esiStatusCode));

			if (objDao.checkBookingNoAndStatus(mapParams) > 0) {

				populateAllData(objForm, objDao, mapParams, request, true);
				objDao.getRatChargeDtls(objForm, mapParams);
				objDao.setRoutingDtls(objForm, mapParams);
				
			} else {
				System.out.println("no Record found....");
				objForm.setNotFound(Boolean.TRUE);
			}

			net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
			jsonObj = new net.sf.json.JSONObject();
			jsonObj.put("Result", objForm);
			response.setContentType("text");
			jsonObj.write(response.getWriter());
			System.out.println("Json In string " + jsonObj.write(new StringWriter()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking][End]");
		}

		return null;
	}

	/**
	 *
	 * This method for get all data to show in eshipping screen.
	 *
	 * @exception Exception
	 * @param form
	 *            EshippingInstructionUim
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public String getWebBooking(EshippingInstructionUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EshippingInstructionSvc][getWebBooking][Begin]");

		EshippingInstructionDao objDao = null;
		List<EshippingCargoDescriptionMod> cargoDescriptionDetails = null;
		String[] cargoDetails = null;
		String[] itemsDelete = null;
		String flag = null;
		String dbFlag = null;
		String forwardPage = null;
		Boolean isLoadData = Boolean.FALSE;
		form.setEsiErrMsg("");
		int row = 0;
		int seqNo = 1;
		// @10 BEGIN
		// @10 END
		try {
			cargoDetails = form.getCargoDetails();
			flag = form.getFlag();
			cargoDescriptionDetails = new ArrayList<EshippingCargoDescriptionMod>();
			objDao = getDao();

			System.out.println("[EshippingInstructionSvc][getWebBooking] flag :: " + flag);
			if (!FLAG_DELETE.equals(flag)) {
				if (StringUtils.EMPTY.equals(flag)) {
					dbFlag = "0";
					isLoadData = Boolean.FALSE;
				} else if (FLAG_BOOKING.equals(flag)) {
					dbFlag = "1";
					if (!isAfterSave) {
						isLoadData = Boolean.TRUE;
					}
				}
				System.out.println("[EshippingInstructionSvc][getWebBooking] dbFlag         :: " + dbFlag);
				System.out.println("[EshippingInstructionSvc][getWebBooking] cargoDetails   :: " + cargoDetails);

				if ("0".equals(dbFlag) || cargoDetails != null) {
					for (String obj : cargoDetails) {
						setCargoDetails(seqNo, cargoDescriptionDetails, form, obj);
						seqNo++;
					}
				}
				System.out.println(
						"[EshippingInstructionSvc][getWebBooking] form.getBookingNo()   :: " + form.getBookingNo());
				if (!StringUtils.EMPTY.equals(form.getBookingNo())) {
					try {
						getBookingData(form, objDao, request, isLoadData);
					} catch (Exception wex) {
						wex.printStackTrace();
					}
				}

				newCargeDetails(seqNo, form, dbFlag, EshippingInstructionDao.KEY_STATUS_INSERT);
			} else {
				updateFlagItemsDelete(form);

				itemsDelete = form.getItemsDelete().split(",");
				for (String obj : cargoDetails) {
					if ("0".equals(itemsDelete[row])) {
						setCargoDetails(seqNo, cargoDescriptionDetails, form, obj);
						seqNo++;
					}
					row++;
				}
			}
			form.setBlTypeValues(ComboBoxESIUtil.getBLTypeDDList());

			form.setFlagItemsDelete(form.getItemsDelete());
			// -------------------- Reset flag for delete -------------------
			form.setFlag(StringUtils.EMPTY);
			form.setItemsDelete(StringUtils.EMPTY);
			form.setFlagItemsDelete(StringUtils.EMPTY);
			// -------------------- Set Default BL Type -------------------
			form.setBlType("T");

			forwardPage = SUCCESS;
		} catch (Exception ex) {
			throw ex;
		} finally {
			setSessionForm(request, form);
			System.out.println("[EshippingInstructionSvc][getWebBooking][End]");
		}
		return forwardPage;
	}

	public String getWebBookingNew(EshippingInstructionUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EshippingInstructionSvc][getWebBooking][Begin]");

		EshippingInstructionDao objDao = null;
		List<EshippingCargoDescriptionMod> cargoDescriptionDetails = null;
		String[] cargoDetails = null;
		String[] itemsDelete = null;
		String flag = null;
		String dbFlag = null;
		String forwardPage = null;
		Boolean isLoadData = Boolean.FALSE;

		int row = 0;
		int seqNo = 1;
		// @10 BEGIN
		// @10 END
		try {
			cargoDetails = form.getCargoDetails();
			flag = form.getFlag();
			cargoDescriptionDetails = new ArrayList<EshippingCargoDescriptionMod>();
			objDao = getDao();

			System.out.println("[EshippingInstructionSvc][getWebBooking] flag :: " + flag);
			if (!FLAG_DELETE.equals(flag)) {
				if (StringUtils.EMPTY.equals(flag)) {
					dbFlag = "0";
					isLoadData = Boolean.FALSE;
				} else if (FLAG_BOOKING.equals(flag)) {
					dbFlag = "1";
					if (!isAfterSave) {
						isLoadData = Boolean.TRUE;
					}
				}
				System.out.println("[EshippingInstructionSvc][getWebBooking] dbFlag         :: " + dbFlag);
				System.out.println("[EshippingInstructionSvc][getWebBooking] cargoDetails   :: " + cargoDetails);
				System.out.println(
						"[EshippingInstructionSvc][getWebBooking] form.getBookingNo()   :: " + form.getBookingNo());
				if (!StringUtils.EMPTY.equals(form.getBookingNo())) {
					try {
						// getBookingData(form, objDao, request, isLoadData);
						Map mapParams = new HashMap();

						String esiStatusCode = request.getParameter("esiStatusCode");
						String esiStatusDesc = request.getParameter("esiStatusDesc");

						String bookingNo = form.getBookingNo();
						String blNo = form.getBlNo();
						String modeGetData = form.getMode();

						form.setNotFound(Boolean.FALSE);
						// @13 BEGIN
						// esiStatusDesc = request.getParameter("esiStatus");
						// @13 END
						// @18 END
						mapParams.put(EshippingInstructionDao.P_I_V.BL_NO, blNo);
						mapParams.put(EshippingInstructionDao.P_I_V.BKG_NO, bookingNo);

						// @06 BEGIN
						String strMode = convertStatus(esiStatusCode);
						// @13 BEGIN
						mapParams.put(EshippingInstructionDao.P_I_V.STATUS, convertStatus(esiStatusCode));
						mapParams.put(EshippingInstructionDao.P_I_V.MODE, convertStatus(esiStatusCode));
						// @13 END
						// @06 END
						populateAllData(form, objDao, mapParams, request, isLoadData);

						// @18 BEGIN
						// form.setEsiStatusCode(esiStatusCode);
						// form.setEsiStatusDesc(esiStatusDesc);
						form.setPrevEsiStatusCode(esiStatusCode);
						form.setPrevEsiStatusCode(esiStatusDesc);

					} catch (Exception wex) {
						wex.printStackTrace();
					}
				}

				newCargeDetails(seqNo, form, dbFlag, EshippingInstructionDao.KEY_STATUS_INSERT);
			} else {
				updateFlagItemsDelete(form);

				itemsDelete = form.getItemsDelete().split(",");
				for (String obj : cargoDetails) {
					if ("0".equals(itemsDelete[row])) {
						setCargoDetails(seqNo, cargoDescriptionDetails, form, obj);
						seqNo++;
					}
					row++;
				}
			}
			form.setBlTypeValues(ComboBoxESIUtil.getBLTypeDDList());

			form.setFlagItemsDelete(form.getItemsDelete());
			// -------------------- Reset flag for delete -------------------
			form.setFlag(StringUtils.EMPTY);
			form.setItemsDelete(StringUtils.EMPTY);
			form.setFlagItemsDelete(StringUtils.EMPTY);
			// -------------------- Set Default BL Type -------------------
			form.setBlType("T");

			forwardPage = SUCCESS;
		} catch (Exception ex) {
			throw ex;
		} finally {
			setSessionForm(request, form);
			System.out.println("[EshippingInstructionSvc][getWebBooking][End]");
		}
		return forwardPage;
	}

	/**
	 *
	 * This method for validate original data has changed
	 *
	 * @exception Exception
	 * @param form
	 *            EshippingInstructionUim
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public String validateData(EshippingInstructionUim form) throws Exception {
		System.out.println("[EshippingInstructionSvc][validateData][Begin]");

		EshippingInstructionDao objDao = null;
		boolean bookingStatusValidation=false;
		String bookingNo = this.request.getParameter("bookingNo");
		try {
			objDao = getDao();
			// int validateResult = objDao.validateDataChange(bookingNo);
			int validateResult = 0;
			bookingStatusValidation=checkBookingStatus(form,objDao);
			if(bookingStatusValidation==false) {
				validateResult=3;
			}
			this.writeMSG(validateResult + "");
		} catch (Exception ex) {
			throw ex;
		} finally {
			System.out.println("[EshippingInstructionSvc][getWebBooking][End]");
		}

		return null;

	}

	/**
	 *
	 * This method for clear ESI when original data has changed
	 *
	 * @exception Exception
	 * @param form
	 *            EshippingInstructionUim
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public String clearESIData(EshippingInstructionUim form) throws Exception {
		System.out.println("[EshippingInstructionSvc][clearESIData][Begin]");

		EshippingInstructionDao objDao = null;
		String forwardPage = null;
		String bookingNo = this.request.getParameter("bookingNo");
		try {
			objDao = getDao();

			objDao.clearESIData(form.getBookingNo());
			form.setMode(INPUT_YOURSELF_MODE);
			form.setFlag(FLAG_BOOKING);
			getWebBooking(form, request);
			forwardPage = SUCCESS;
		} catch (Exception ex) {
			throw ex;
		} finally {
			System.out.println("[EshippingInstructionSvc][getWebBooking][End]");
		}

		return forwardPage;

	}

	/**
	 *
	 * This method for save eshipping instruction
	 *
	 * @exception BusinessException
	 *                and DataAccessException and Exception
	 * @param form
	 *            EshippingInstructionUim
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public String saveDraft(EshippingInstructionUim form, HttpServletRequest request)
			throws BusinessException, DataAccessException, Exception {
		
		System.out.println("[EshippingInstructionSvc][saveDraft][Begin]");

		List<EshippingCargoDescriptionMod> equipmentList = null;
		// List<EshippingCommodityDetailsMod> commodityDelList = null;
		// List<EshippingCommodityDetailsMod> commodityList = null;
		// List<EshippingCommodityDetailsMod> commodityUsedList = null;
		// List<EshippingCommodityDetailsMod> commoditySessionList = null;
		Map<String, String> paramsMap = null;
		Map result = null;
		String errCode = null;
		String errDesc = null;
		EshippingInstructionUim objFormSession = null;
		EshippingInstructionDao objDao = null;
		StringBuffer containerNoAll = null;
		String[] cargoDetails = null;
		String[] values = null;
		// String commCode = null;
		// String commGroupCode = null;
		String cocSoc = null;
		String containerNoExist = null;
		String forwardPage = FAILURE;
		boolean isFirstContainer = true;
		boolean isSuccess = true;
		
		try {
			objFormSession = getSessionForm(request);
			cocSoc = form.getCocSoc();
			objDao = getDao();

			if ("C".equals(cocSoc)) {
				cargoDetails = form.getCargoDetails();
				containerNoAll = new StringBuffer();

				for (String cargoDetail : cargoDetails) {
					if (!StringUtils.EMPTY.equals(cargoDetail)) {
						values = cargoDetail.split(form.getTextSeparate());
						if (values[0] != null && !BLANK.equals(values[0].trim())
								&& !NULL_DATA.equals(values[0].trim())) {
							if (!isFirstContainer) {
								containerNoAll.append(",");
							} else {
								isFirstContainer = false;
							}
							containerNoAll.append(values[0]);
						}
					}
				}
				if (!BLANK.equals(containerNoAll.toString().trim())) {
					paramsMap = new HashMap<String, String>();
					paramsMap.put(EshippingInstructionDao.P_I_V.CNTR, containerNoAll.toString());
					System.out.println("containerNoAll = " + containerNoAll.toString());

					result = objDao.findContainerNoExist(paramsMap);
					if (result != null && !result.isEmpty()) {
						if (result.containsKey(EshippingInstructionDao.P_O_V.EXIST)) {
							containerNoExist = (String) result.get(EshippingInstructionDao.P_O_V.EXIST);
						}
					}
				}
			}
			// commodityUsedList = new ArrayList<EshippingCommodityDetailsMod>();
			//
			// setCommodityVoDataList(form, objFormSession, request);
			//
			// commodityDelList = objFormSession.getCommodityVoDataDelList();
			// commoditySessionList = objFormSession.getCommodityVoDataList();
			// commodityList = form.getCommodityVoDataList();
			// for(EshippingCommodityDetailsMod mod: commodityList){
			// commCode = mod.getStrCommCode();
			// commGroupCode = mod.getStrCommGroup();
			// if(commCode!=null&&!BLANK.equals(commCode)){
			// commodityUsedList.add(mod);
			// }
			// }
			// if(commodityDelList!=null&&!commodityDelList.isEmpty()){
			// commodityUsedList.addAll(commodityDelList);
			// }

			form.setFlag(FLAG_BOOKING);
			isAfterSave = Boolean.TRUE;

			getWebBooking(form, request);
			
			/* Begin @22 */
			this.setCommodityDetails(form, objFormSession);
			// form.setCommodityVoDataList(commodityUsedList);
			/* End @22 */
			// @19 BEGIN
			if (containerNoExist == null || BLANK.equals(containerNoExist.trim())) {
				// @19 END
				result = objDao.insertOrUpdateShipmentHeader(setParamsHeaderForSave(form, request));
				// result = new HashMap();
				errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);

				System.out.println("[EshippingInstructionSvc][saveDraft] errDesc :: " + errDesc);
				if (null != errDesc) {
					throw ExceptionFactory.createApplicationException(errDesc);
				} else {
					result = setParamsDetailsTmpForSave(objDao, form, request);
					if (result == null)
						result = setParamsCommodityDetailsInsertForSave(objDao, form, request);

					System.out.println("[EshippingInstructionSvc][saveDraft] result :: " + result);
					if (result != null) {
						errCode = (String) result.get(EshippingInstructionDao.P_O_V.ERR_CD);
						if (errCode != null && !"SUCCESS".equals(errCode)) {
							errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);
							if (errDesc != null) {
								isAfterSave = Boolean.FALSE;
								isSuccess = false;

								throw ExceptionFactory.createApplicationException(errDesc);
							}
						}
					}
					if (isSuccess) {
						result = setParamsDetailsInsertForSave(objDao, form, request);
						if (null != result) {
							errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);
							isAfterSave = Boolean.FALSE;

							// getWebBooking(mapping, objForm, request);
							throw ExceptionFactory.createApplicationException(errDesc);
						} else {
							isAfterSave = Boolean.TRUE;
						}
					}
					form.setSaveDraftIsSuccess(Boolean.TRUE);
				}
			} else {
				// Change error message from 'Please input RCL container for container number'
				// to 'INVALID CONTAINER NUMBER'
				// errDesc = "Please input RCL container for container number
				// "+containerNoExist;
				// errDesc = "INVALID CONTAINER NUMBER "+containerNoExist;
				errDesc = "Booking Status is subject to CONFIRMED before create eSI." + containerNoExist;
				form.setSaveDraftIsSuccess(Boolean.FALSE);
			}
			getAdminLoginDao().insertLogInLogSiTable(form.getBookingNo(), form.getBlNo(), form.getUserName(), null,AdminBookingLogDao.DAO_SI_SAVE);
		} catch (Exception ex) {
			getAdminLoginDao().insertLogInLogSiTable(form.getBookingNo(), form.getBlNo(), form.getUserName(), ex,AdminBookingLogDao.DAO_SI_SAVE_ERROR);
			ex.printStackTrace();
			throw ex;
		} finally {
			request.getSession(false).setAttribute("status", "E");
			request.getSession(false).setAttribute("bookingno", form.getBookingNo());
			isAfterSave = Boolean.FALSE;
			form.setMsgFieldChanged("");

			form.setEsiErrMsg(errDesc);
			if (errDesc == null || BLANK.equals(errDesc.trim())) {
				form.setMode("select");

				getBookingData(form, objDao, request, true);

				equipmentList = form.getCargoDescriptionDetails();
				equipmentTmp = equipmentList;

				forwardPage = SUCCESS;
			}
			System.out.println("[EshippingInstructionSvc][saveDraft][End]");
		}

		return forwardPage;
	}

	/**
	 *
	 * This method for submit eshipping instruction
	 *
	 * @exception BusinessException
	 *                and DataAccessException and Exception
	 * @param form
	 *            EshippingInstructionUim
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public String submitEsi(EshippingInstructionUim form, HttpServletRequest request)
			throws BusinessException, DataAccessException, Exception {

		System.out.println("[EshippingInstructionSvc][submitEsi][Begin]");

		EshippingInstructionDao objDao = null;
		Map map = null;
		String errDesc = null;
		String emailAck = null;
		Boolean openAcknowledgement = null;
		Boolean submitIsSuccess = null;
		Boolean disabledSubmit = null;
		String bookingNo = null;
		String forwardPage = FAILURE;
		form.setEsiErrMsg("");
		try {

		    saveDraftSubmit(form, request);
			
			bookingNo = form.getBookingNo();

			form.setFlag(FLAG_BOOKING);
			isAfterSave = Boolean.TRUE;

			map = new HashMap();
			map.put(EshippingInstructionDao.P_I_V.BOOKING_NO, bookingNo);
			map.put(EshippingInstructionDao.P_I_V.LOGIN_ID, getUserID(request));

			objDao = getDao();
			map = objDao.submitEsi(map);
			objDao.getMailDtls(form, getUserID(request));
			objDao.checkConatinerNoInBookingTbl(form);
			if (map != null && !map.isEmpty()) {
				errDesc = (String) map.get(EshippingInstructionDao.P_O_V.ERR_DESC);
				if (errDesc != null && !errDesc.equals("")) {
					throw ExceptionFactory.createApplicationException(errDesc);
				}
				// if(map.containsKey(EshippingInstructionDao.P_O_V.ERR_DESC)){
				// errDesc = (String) map.get(EshippingInstructionDao.P_O_V.ERR_DESC);
				// throw ExceptionFactory.createApplicationException(errDesc);
				// }
			} else {
				errDesc = "Oracle Database Error Occurred";
			}
			getAdminLoginDao().insertLogInLogSiTable(form.getBookingNo(), form.getBlNo(), form.getUserName(), null,AdminBookingLogDao.DAO_SI_SUBMIT);
		} catch (Exception ex) {
			getAdminLoginDao().insertLogInLogSiTable(form.getBookingNo(), form.getBlNo(), form.getUserName(), ex,AdminBookingLogDao.DAO_SI_SUBMIT_ERROR);
			ex.printStackTrace();
			errDesc="Si Submission Faild";
		} finally {
			if (errDesc != null && !BLANK.equals(errDesc)) {
				emailAck = null;
				form.setEsiErrMsg(errDesc);
				openAcknowledgement = Boolean.FALSE;
				submitIsSuccess = Boolean.FALSE;
				disabledSubmit = Boolean.FALSE;
			} else {
				map.put(EshippingInstructionDao.P_I_V.FSC, form.getFsc());

				objDao.setAcknowledgementDetail(map, form);

				emailAck = form.getEmail();
				openAcknowledgement = Boolean.TRUE;
				submitIsSuccess = Boolean.TRUE;
				disabledSubmit = Boolean.TRUE;
				forwardPage = SUCCESS;
				String userId = getUserID(request);
				String bookingParty= objDao.getBookingPartyFromCamCustomer(form);
				String RepCompanyNnme=objDao.getRepresentCompName(form.getBookingNo());
				AdminBookingLogDao adminDao = getAdminLoginDao();
				try {
					ShippingThread th = new ShippingThread(adminDao,form, objDao, userId, request, response,bookingParty,RepCompanyNnme);
					th.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			form.setEmailAcknowledgment(emailAck);
			form.setOpenAcknowledgement(openAcknowledgement);
			form.setSubmitIsSuccess(submitIsSuccess);
			form.setIsDisabledSubmit(disabledSubmit);
			form.setEsiErrMsg(errDesc);
			form.setMode(INPUT_YOURSELF_MODE);

			isAfterSave = Boolean.FALSE;
			
			// getBookingData(form, objDao, request, true);
		}
		return forwardPage;
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

	public String saveDraftSubmit(EshippingInstructionUim form, HttpServletRequest request)
			throws BusinessException, DataAccessException, Exception {

		System.out.println("[EshippingInstructionSvc][saveDraft][Begin]");

		List<EshippingCargoDescriptionMod> equipmentList = null;
		// List<EshippingCommodityDetailsMod> commodityDelList = null;
		// List<EshippingCommodityDetailsMod> commodityList = null;
		// List<EshippingCommodityDetailsMod> commodityUsedList = null;
		// List<EshippingCommodityDetailsMod> commoditySessionList = null;
		Map<String, String> paramsMap = null;
		Map result = null;
		String errCode = null;
		String errDesc = null;
		EshippingInstructionUim objFormSession = null;
		EshippingInstructionDao objDao = null;
		StringBuffer containerNoAll = null;
		String[] cargoDetails = null;
		String[] values = null;
		// String commCode = null;
		// String commGroupCode = null;
		String cocSoc = null;
		String containerNoExist = null;
		String forwardPage = FAILURE;
		boolean isFirstContainer = true;
		boolean isSuccess = true;

		try {
			objFormSession = getSessionForm(request);
			cocSoc = form.getCocSoc();
			objDao = getDao();

			if ("C".equals(cocSoc)) {
				cargoDetails = form.getCargoDetails();
				containerNoAll = new StringBuffer();

				for (String cargoDetail : cargoDetails) {
					if (!StringUtils.EMPTY.equals(cargoDetail)) {
						values = cargoDetail.split(form.getTextSeparate());
						if (values[0] != null && !BLANK.equals(values[0].trim())
								&& !NULL_DATA.equals(values[0].trim())) {
							if (!isFirstContainer) {
								containerNoAll.append(",");
							} else {
								isFirstContainer = false;
							}
							containerNoAll.append(values[0]);
						}
					}
				}
				if (!BLANK.equals(containerNoAll.toString().trim())) {
					paramsMap = new HashMap<String, String>();
					paramsMap.put(EshippingInstructionDao.P_I_V.CNTR, containerNoAll.toString());
					System.out.println("containerNoAll = " + containerNoAll.toString());

					result = objDao.findContainerNoExist(paramsMap);
					if (result != null && !result.isEmpty()) {
						if (result.containsKey(EshippingInstructionDao.P_O_V.EXIST)) {
							containerNoExist = (String) result.get(EshippingInstructionDao.P_O_V.EXIST);
						}
					}
				}
			}
			// commodityUsedList = new ArrayList<EshippingCommodityDetailsMod>();
			//
			// setCommodityVoDataList(form, objFormSession, request);
			//
			// commodityDelList = objFormSession.getCommodityVoDataDelList();
			// commoditySessionList = objFormSession.getCommodityVoDataList();
			// commodityList = form.getCommodityVoDataList();
			// for(EshippingCommodityDetailsMod mod: commodityList){
			// commCode = mod.getStrCommCode();
			// commGroupCode = mod.getStrCommGroup();
			// if(commCode!=null&&!BLANK.equals(commCode)){
			// commodityUsedList.add(mod);
			// }
			// }
			// if(commodityDelList!=null&&!commodityDelList.isEmpty()){
			// commodityUsedList.addAll(commodityDelList);
			// }

			form.setFlag(FLAG_BOOKING);
			isAfterSave = Boolean.TRUE;

			getWebBooking(form, request);

			/* Begin @22 */
			this.setCommodityDetails(form, objFormSession);
			// form.setCommodityVoDataList(commodityUsedList);
			/* End @22 */
			// @19 BEGIN
			if (containerNoExist == null || BLANK.equals(containerNoExist.trim())) {
				// @19 END
				result = objDao.insertOrUpdateShipmentHeader(setParamsHeaderForSave(form, request));
				// result = new HashMap();
				errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);

				System.out.println("[EshippingInstructionSvc][saveDraft] errDesc :: " + errDesc);
				if (null != errDesc) {
					throw ExceptionFactory.createApplicationException(errDesc);
				} else {
					result = setParamsDetailsTmpForSave(objDao, form, request);
					if (result == null)
						result = setParamsCommodityDetailsInsertForSave(objDao, form, request);

					System.out.println("[EshippingInstructionSvc][saveDraft] result :: " + result);
					if (result != null) {
						errCode = (String) result.get(EshippingInstructionDao.P_O_V.ERR_CD);
						if (errCode != null && !"SUCCESS".equals(errCode)) {
							errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);
							if (errDesc != null) {
								isAfterSave = Boolean.FALSE;
								isSuccess = false;

								throw ExceptionFactory.createApplicationException(errDesc);
							}
						}
					}
					if (isSuccess) {
						result = setParamsDetailsInsertForSave(objDao, form, request);
						if (null != result) {
							errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);
							isAfterSave = Boolean.FALSE;

							// getWebBooking(mapping, objForm, request);
							throw ExceptionFactory.createApplicationException(errDesc);
						} else {
							isAfterSave = Boolean.TRUE;
						}
					}
					form.setSaveDraftIsSuccess(Boolean.TRUE);
				}
			} else {
				// Change error message from 'Please input RCL container for container number'
				// to 'INVALID CONTAINER NUMBER'
				// errDesc = "Please input RCL container for container number
				// "+containerNoExist;
				// errDesc = "INVALID CONTAINER NUMBER "+containerNoExist;
				errDesc = "Booking Status is subject to CONFIRMED before create eSI." + containerNoExist;
				form.setSaveDraftIsSuccess(Boolean.FALSE);
			}
		} catch (Exception ex) {
			errDesc="Si Submition faild";
			throw ex;
		} finally {
			isAfterSave = Boolean.FALSE;
			form.setMsgFieldChanged("");

			form.setEsiErrMsg(errDesc);
			if (errDesc == null || BLANK.equals(errDesc.trim())) {
				form.setMode("select");

				// getBookingData(form, objDao, request, true);

				equipmentList = form.getCargoDescriptionDetails();
				equipmentTmp = equipmentList;

				forwardPage = SUCCESS;
			}
			System.out.println("[EshippingInstructionSvc][saveDraft][End]");
		}
		return forwardPage;
	}
	// public String setCommodityData(EshippingInstructionUim form,
	// HttpServletRequest request) throws Exception{
	// EshippingInstructionUim objFormSession = null;
	// EshippingCommodityDetailsMod mod = null;
	//
	// String commodityCode = null;
	// String commodityGroupCode = null;
	// String commodityGroupDesc = null;
	// String commodityDesc = null;
	// String commodityRowIndex = null;
	// String commodityWeight = null;
	// String commodityOfPackage = null;
	// String commodityPackageKindCode = null;
	// String commodityPackageKindName = null;
	// String commodityMeasurement = null;
	//
	// String forwardPage = SUCCESS;
	//
	// boolean isExist = false;
	// try{
	// objFormSession = getSessionForm(request);
	//
	// commodityCode = request.getParameter("commodityCode");
	// commodityDesc = request.getParameter("commodityDesc");
	// commodityGroupCode = request.getParameter("commodityGroupCode");
	// commodityGroupDesc = request.getParameter("commodityGroupDesc");
	// commodityRowIndex = request.getParameter("commodityRowIndex");
	//// // @15 BEGIN
	//// commodityWeight = request.getParameter("commodityWeight");
	//// if(commodityWeight==null||BLANK.equals(commodityWeight)){
	//// commodityWeight = "0.000";
	//// }
	//// // @15 END
	////// @21 BEGIN
	//// commodityOfPackage = request.getParameter("commodityOfPackage");
	//// if(commodityOfPackage==null||BLANK.equals(commodityOfPackage)){
	//// commodityOfPackage = "0";
	//// }
	//// commodityPackageKindCode =
	// request.getParameter("commodityPackageKindCode");
	//// if(commodityPackageKindCode==null||BLANK.equals(commodityPackageKindCode)){
	//// commodityPackageKindCode = BLANK;
	//// }
	//// commodityPackageKindName =
	// request.getParameter("commodityPackageKindName");
	//// if(commodityPackageKindName==null||BLANK.equals(commodityPackageKindName)){
	//// commodityPackageKindName = BLANK;
	//// }
	//// commodityMeasurement = request.getParameter("commodityMeasurement");
	//// if(commodityMeasurement==null||BLANK.equals(commodityMeasurement)){
	//// commodityMeasurement = "0.0000";
	//// }
	//// @21 END
	// Debug.logFramework("1.CommodityCode = "+commodityCode+"\n2.CommodityGroup =
	// "+commodityGroupCode+
	// "\n3.commodityGroupDesc = "+commodityGroupDesc+"\n4.CommodityDesc =
	// "+commodityDesc+
	// "\n5.CommodityRowIndex = "+commodityRowIndex+"\n6.CommodityWeight =
	// "+commodityWeight);
	//
	// mod = objFormSession.getCommodityValue(Integer.parseInt(commodityRowIndex));
	// if(mod.getStrCommCode()!=null&&!BLANK.equals(mod.getStrCommCode())){
	// isExist = true;
	// }
	// mod.setStrCommCode(commodityCode);
	// mod.setStrCommDesc(commodityDesc);
	// mod.setStrCommGroupCode(commodityGroupCode);
	// mod.setStrCommGroup(commodityGroupDesc);
	// // @15 BEGIN
	// mod.setStrCommWeight(commodityWeight);
	// // @15 END
	//// @21 BEGIN
	// mod.setStrCommOfPackages(commodityOfPackage);
	// mod.setStrCommPackageKindCode(commodityPackageKindCode);
	// mod.setStrCommPackageKindName(commodityPackageKindName);
	// mod.setStrCommMeasurement(commodityMeasurement);
	//// @21 END
	// setCommodityDetails(form, objFormSession, request);
	//
	// setComboBoxCommodity(objFormSession);
	//
	// form.setCargoDescriptionDetails(objFormSession.getCargoDescriptionDetails());
	// form.setBlTypeValues(objFormSession.getBlTypeValues());
	//
	// //Set Form
	// setShippmentDetails(form, objFormSession);
	//
	// setContactDetails(form, objFormSession);
	//
	// setRoutingDetails(form, objFormSession);
	//
	// setEquipmentDetails(form, objFormSession);
	// } catch(Exception ex){
	// throw ex;
	// } finally{
	// combineDataUpdateToTmp(form);
	//
	// objFormSession.setBlTypeValues(ComboBoxESIUtil.getBLTypeDDList());
	// form.setBlTypeValues(objFormSession.getBlTypeValues());
	//
	// setSessionForm(request, objFormSession);
	// }
	// return forwardPage;
	// }

	/* Begin @22 */
	public String setCommodityData(EshippingInstructionUim form1) throws Exception {
		System.out.println("[EshippingInstructionSvc][setCommodityData][Begin]");

		EshippingCommodityDetailsMod mod = null;
		List commodityVoDataList = null;
		String intCommGroupSeqNo = null;
		String strCommCode = null;
		String strCommGroupCode = null;
		String strCommPackageKindCode = null;
		String marksAndNumbers = null;
		String description = null;
		String comBookingNo = null;
		String strCommodityForMark = null;
		String containerNoToCargo = null;
		String comSeqNo = null;
		String strCommGroup = null;
		String strCommDesc = null;
		String strCommOfPackages = null;
		String strCommPackageKindName = null;
		String strCommWeight = null;
		String strCommMeasurement = null;
		String recordStatus = null;
		EshippingInstructionUim objFormSession = null;

		try {
			intCommGroupSeqNo = FormatUtil.nullToBlank(this.request.getParameter("intCommGroupSeqNo"));
			strCommCode = FormatUtil.nullToBlank(this.request.getParameter("strCommCode"));
			strCommGroupCode = FormatUtil.nullToBlank(this.request.getParameter("strCommGroupCode"));
			strCommPackageKindCode = FormatUtil.nullToBlank(this.request.getParameter("strCommPackageKindCode"));
			marksAndNumbers = FormatUtil.nullToBlank(this.request.getParameter("marksAndNumbers"));
			description = FormatUtil.nullToBlank(this.request.getParameter("description"));
			comBookingNo = FormatUtil.nullToBlank(this.request.getParameter("comBookingNo"));
			strCommodityForMark = FormatUtil.nullToBlank(this.request.getParameter("strCommodityForMark"));
			containerNoToCargo = FormatUtil.nullToBlank(this.request.getParameter("containerNoToCargo"));
			comSeqNo = FormatUtil.nullToBlank(this.request.getParameter("comSeqNo"));
			strCommGroup = FormatUtil.nullToBlank(this.request.getParameter("strCommGroup"));
			strCommDesc = FormatUtil.nullToBlank(this.request.getParameter("strCommDesc"));
			strCommOfPackages = FormatUtil.nullToBlank(this.request.getParameter("strCommOfPackages"));
			strCommPackageKindName = FormatUtil.nullToBlank(this.request.getParameter("strCommPackageKindName"));
			strCommWeight = FormatUtil.nullToBlank(this.request.getParameter("strCommWeight"));
			strCommMeasurement = FormatUtil.nullToBlank(this.request.getParameter("strCommMeasurement"));
			objFormSession = this.getSessionForm(this.request);

			if (intCommGroupSeqNo.equals(""))
				intCommGroupSeqNo = "0";

			System.out.println("[EshippingInstructionSvc][setCommodityData] intCommGroupSeqNo :: " + intCommGroupSeqNo);
			System.out.println("[EshippingInstructionSvc][setCommodityData] strCommCode :: " + strCommCode);
			System.out.println("[EshippingInstructionSvc][setCommodityData] strCommGroupCode :: " + strCommGroupCode);
			System.out.println(
					"[EshippingInstructionSvc][setCommodityData] strCommPackageKindCode :: " + strCommPackageKindCode);
			System.out.println("[EshippingInstructionSvc][setCommodityData] marksAndNumbers :: " + marksAndNumbers);
			System.out.println("[EshippingInstructionSvc][setCommodityData] description :: " + description);
			System.out.println("[EshippingInstructionSvc][setCommodityData] comBookingNo :: " + comBookingNo);
			System.out.println(
					"[EshippingInstructionSvc][setCommodityData] strCommodityForMark :: " + strCommodityForMark);
			System.out
					.println("[EshippingInstructionSvc][setCommodityData] containerNoToCargo :: " + containerNoToCargo);
			System.out.println("[EshippingInstructionSvc][setCommodityData] strCommGroup :: " + strCommGroup);
			System.out.println("[EshippingInstructionSvc][setCommodityData] strCommDesc :: " + strCommDesc);
			System.out.println("[EshippingInstructionSvc][setCommodityData] strCommOfPackages :: " + strCommOfPackages);
			System.out.println(
					"[EshippingInstructionSvc][setCommodityData] strCommPackageKindName :: " + strCommPackageKindName);
			System.out.println("[EshippingInstructionSvc][setCommodityData] strCommWeight :: " + strCommWeight);
			System.out
					.println("[EshippingInstructionSvc][setCommodityData] strCommMeasurement :: " + strCommMeasurement);
			System.out.println("[EshippingInstructionSvc][setCommodityData] comSeqNo :: " + comSeqNo);

			commodityVoDataList = objFormSession.getCommodityVoDataList();

			System.out.println("[EshippingInstructionSvc][setCommodityData] commodityVoDataList.size() :: "
					+ commodityVoDataList.size());

			if (!comSeqNo.equals("")) {
				for (int i = 0; i < commodityVoDataList.size(); i++) {
					mod = (EshippingCommodityDetailsMod) commodityVoDataList.get(i);
					recordStatus = mod.getRecordStatus();

					System.out.println("[EshippingInstructionSvc][setCommodityData] recordStatus :: " + recordStatus);
					if (!recordStatus.equals(EshippingInstructionDao.DEL_OPERATION)) {

						if (mod.getComSeqNo().equals(comSeqNo)) {
							mod.setComSeqNo(comSeqNo);
							mod.setIntCommGroupSeqNo(Integer.parseInt(intCommGroupSeqNo));
							mod.setStrCommCode(strCommCode);
							mod.setStrCommGroupCode(strCommGroupCode);
							mod.setStrCommPackageKindCode(strCommPackageKindCode);
							mod.setMarksAndNumbers(marksAndNumbers);
							mod.setDescription(description);
							mod.setComBookingNo(comBookingNo);
							mod.setStrCommodityForMark(strCommodityForMark);
							mod.setContainerNoToCargo(containerNoToCargo);
							mod.setStrCommGroup(strCommGroup);
							mod.setStrCommDesc(strCommDesc);
							mod.setStrCommOfPackages(strCommOfPackages);
							mod.setStrCommPackageKindName(strCommPackageKindName);
							mod.setStrCommWeight(strCommWeight);
							mod.setStrCommMeasurement(strCommMeasurement);

							if (recordStatus.equals(""))
								mod.setRecordStatus(EshippingInstructionDao.UPD_OPERATION);

							// this.setCommodityDetails(form, objFormSession, this.request);

							this.setComboBoxCommodity(objFormSession);

							// form.setCargoDescriptionDetails(objFormSession.getCargoDescriptionDetails());
							// form.setBlTypeValues(objFormSession.getBlTypeValues());
							//
							// //Set Form
							// this.setShippmentDetails(form, objFormSession);
							//
							// this.setContactDetails(form, objFormSession);
							//
							// this.setRoutingDetails(form, objFormSession);
							//
							// this.setEquipmentDetails(form, objFormSession);

							this.setSessionForm(this.request, objFormSession);

							break;
						}
						// comIndex++;
					}
				}
			}

			this.writeMSG("OK");

		} catch (Exception e) {
			e.printStackTrace();
			this.writeMSG("ERROR::" + e.getMessage());
		} finally {

			System.out.println("[EshippingInstructionSvc][setCommodityData][End]");
		}

		return null;

	}
	/* End @22 */

	/* Begin @22 */
	public String addCommodity(EshippingInstructionUim form1) throws Exception {
		System.out.println("[EshippingInstructionSvc][addCommodity][Begin]");

		EshippingCommodityDetailsMod mod = null;
		String newSeq = null;
		EshippingInstructionUim objFormSession = null;

		try {
			mod = new EshippingCommodityDetailsMod();
			newSeq = this.request.getParameter("newSeq");
			objFormSession = this.getSessionForm(this.request);

			System.out.println("[EshippingInstructionSvc][addCommodity] newSeq :: " + newSeq);

			mod.setComSeqNo(newSeq);
			mod.setRecordStatus(EshippingInstructionDao.ADD_OPERATION);

			objFormSession.getCommodityVoDataList().add(mod);
			objFormSession.setComSeqNoTemp(newSeq);

			this.setSessionForm(this.request, objFormSession);

			this.writeMSG("OK");

		} catch (Exception e) {
			e.printStackTrace();
			this.writeMSG("ERROR::" + e.getMessage());
		} finally {
			mod = null;
			newSeq = null;

			System.out.println("[EshippingInstructionSvc][addCommodity][End]");
		}

		return null;
	}
	/* End @22 */

	/* Begin @22 */
	public String deleteCommodity(EshippingInstructionUim form1) throws Exception {
		System.out.println("[EshippingInstructionSvc][deleteCommodity][Begin]");

		String paramReq = null;
		String[] la_seq = null;
		List commodityVoDataList = null;
		EshippingCommodityDetailsMod mod = null;
		String recordStatus = null;
		EshippingInstructionUim objFormSession = null;

		try {
			paramReq = this.request.getParameter("paramReq");
			la_seq = paramReq.split("\\#");
			objFormSession = this.getSessionForm(this.request);
			commodityVoDataList = objFormSession.getCommodityVoDataList();

			for (int i = 0; i < la_seq.length; i++) {
				for (int j = 0; j < commodityVoDataList.size(); j++) {
					mod = (EshippingCommodityDetailsMod) commodityVoDataList.get(j);
					if (mod.getComSeqNo().equals(la_seq[i])) {
						recordStatus = mod.getRecordStatus();
						if (recordStatus.equals(EserviceNewWebBookingDao.ADD_OPERATION)) {
							commodityVoDataList.remove(j);
						} else {
							mod.setRecordStatus(EserviceNewWebBookingDao.DEL_OPERATION);
						}
					}
				}
			}

			this.setComboBoxCommodity(objFormSession);
			this.setSessionForm(request, objFormSession);

			this.writeMSG("OK");

		} catch (Exception e) {
			e.printStackTrace();
			this.writeMSG("ERROR::" + e.getMessage());
		} finally {
			paramReq = null;
			la_seq = null;
			commodityVoDataList = null;
			mod = null;
			recordStatus = null;
			System.out.println("[EshippingInstructionSvc][deleteCommodity][End]");
		}

		return null;

	}
	/* End @22 */

	// public String deleteCommodity(EshippingInstructionUim form,
	// HttpServletRequest request) throws Exception{
	// EshippingInstructionUim objFormSession = null;
	// EshippingCommodityDetailsMod commMod = null;
	//
	// List<EshippingCommodityDetailsMod> commodityList = null;
	// List<EshippingCommodityDetailsMod> commodityDelList = null;
	// List<EshippingCargoDescriptionMod> newEquipementList = null;
	//
	// String[] weightArr = null;
	// String[] delRows = null;
	//
	// String delRowStr = null;
	// String currRow = null;
	// String errorMsg = null;
	// String forwardPage = SUCCESS;
	// String msgFieldChanged = request.getParameter("msgFieldChanged");
	//
	// boolean isNullWeightArr = false;
	// try{
	//
	// System.out.println("msgFieldChanged::" + msgFieldChanged);
	//
	// weightArr = request.getParameterValues("weightArr");
	// if(weightArr==null){
	// isNullWeightArr = true;
	// }
	//
	// objFormSession = getSessionForm(request);
	//
	// setCommodityVoDataList(form, objFormSession, request);
	//
	// commodityList = form.getCommodityVoDataList();
	//
	// commodityDelList = objFormSession.getCommodityVoDataDelList();
	// if(commodityDelList==null){
	// objFormSession.setCommodityVoDataDelList(new
	// ArrayList<EshippingCommodityDetailsMod>());
	// commodityDelList = objFormSession.getCommodityVoDataDelList();
	// }
	//
	// delRowStr = request.getParameter("delRows");
	//// System.out.println("delRowStr::" + delRowStr);
	// if(delRowStr!=null&&!"".equals(delRowStr.trim())){
	// delRows = delRowStr.split("\\,");
	//// System.out.println("delRows::" + delRows.length);
	// for(int index = (delRows.length-1); index>=0; index--){
	// currRow = delRows[index];
	// System.out.println("POUND " + Integer.parseInt(currRow) + " :: " +
	// delRows.length);
	//
	// if(Integer.parseInt(currRow)<=(delRows.length + 1)){
	// commMod = commodityList.get(Integer.parseInt(currRow));
	//// System.out.println("IntCommGroupSeqNo::" + commMod.getIntCommGroupSeqNo());
	// if(commMod.getIntCommGroupSeqNo()!=null&&commMod.getIntCommGroupSeqNo()>0){
	// commMod.setDeleted(true);
	// commodityDelList.add(commMod);
	// }
	// commodityList.remove(Integer.parseInt(currRow));
	// }
	// }
	// } else {
	// errorMsg = "Not found commodity selected for delete.";
	// }
	//
	// newEquipementList = setEquipmentListFromPage(form);
	// // objFormSession.setCargoDescriptionDetails();
	// } catch(Exception ex){
	// throw ex;
	// } finally{
	// combineDataUpdateToTmp(form);
	//
	// setCommodityDetails(objFormSession, form, null);
	//
	// form.setBlTypeValues(objFormSession.getBlTypeValues());
	//
	// setComboBoxCommodity(objFormSession);
	//
	// setSessionForm(request, objFormSession);
	// }
	// return forwardPage;
	// } // onDeleleCommodity

	/**
	 *
	 * This method for convert Esi Status from screen to mode for sent to procedure.
	 *
	 * @param esiStatusCode
	 *            String
	 * @return esiStatus(mode)
	 */
	public String convertStatus(String esiStatusCode) {
		String statusConverted = null;
		try {
			if (EshippingInstructionDao.ESI_STATUS.NEW.equals(esiStatusCode)) {
				statusConverted = "1";
			} else if (EshippingInstructionDao.ESI_STATUS.IN_PROGRESS.equals(esiStatusCode)) {
				statusConverted = "2";
			} else if (EshippingInstructionDao.ESI_STATUS.SUBMITTED.equals(esiStatusCode)) {
				statusConverted = "3";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return statusConverted;
	}

	public static String convertStatu(String esiStatusCode) {
		String statusConverted = null;
		try {
			if (EshippingInstructionDao.ESI_STATUS.NEW.equals(esiStatusCode)) {
				statusConverted = "1";
			} else if (EshippingInstructionDao.ESI_STATUS.IN_PROGRESS.equals(esiStatusCode)) {
				statusConverted = "2";
			} else if (EshippingInstructionDao.ESI_STATUS.SUBMITTED.equals(esiStatusCode)) {
				statusConverted = "3";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return statusConverted;
	}

	public String convertNumberStatus(String strNumberStatus) {
		if ("1".equals(strNumberStatus)) {
			return STATUS_NEW;
		} else if ("2".equals(strNumberStatus)) {
			return STATUS_IN_PROGRESS;
		} else if ("3".equals(strNumberStatus)) {
			return STATUS_SUBMITTED;
		}
		return null;
	}

	/**
	 *
	 * This method for set value combobox (container type, packages kind, commodity,
	 * laden M/T) in eshipping screen.
	 *
	 * @exception Exception
	 * @param obj
	 *            Object's Eshipping Equipment Detail
	 */
	public void setComboBoxEquipment(EshippingCargoDescriptionMod obj) throws Exception {
		EshippingInstructionDao objDao = null;
		try {
			objDao = getDao();

			obj.setContainerTypeValues(
					ComboBoxESIUtil.getESIComboBox(null, objDao, ComboBoxESIUtil.COMBO_BOX_TYPE.CONTAINER_TYPE));
			obj.setLadenMtValues(ComboBoxESIUtil.getLadenMtDDList());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// @01 BEGIN

	/**
	 *
	 * This method for set value combobox (commodity) in eshipping screen.
	 *
	 * @exception Exception
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 */
	public void setComboBoxCommodity(EshippingInstructionUim objForm) throws Exception {
		// @07 BEGIN
		List<EshippingCargoDescriptionMod> cargoDescriptionList = null;
		List<EshippingCommodityDetailsMod> commodityList = null;
		List<ComboVO> commodityUsedList = null;
		EshippingCargoDescriptionMod cargoDescMod = null;
		ComboVO comboVo = null;
		// String COMMODITY_STRING = "Commodity ";
		int intCommodityIndex = 0;

		try {
			commodityUsedList = new ArrayList<ComboVO>();
			commodityList = objForm.getCommodityVoDataList();

			if (commodityList != null && !commodityList.isEmpty()) {
				for (EshippingCommodityDetailsMod commodityMod : commodityList) {
					// if(commodityMod.getStrCommCode()!=null&&!BLANK.equals(commodityMod.getStrCommCode())&&!commodityMod.isDeleted()){
					if (commodityMod.getStrCommCode() != null && !BLANK.equals(commodityMod.getStrCommCode())
							&& !commodityMod.getRecordStatus().equals(EshippingInstructionDao.DEL_OPERATION)) {
						++intCommodityIndex;

						comboVo = new ComboVO();
						comboVo.setCode(commodityMod.getStrCommCode());
						// @08 BEGIN
						comboVo.setName(COMMODITY_STRING + intCommodityIndex);
						// comboVo.setName(commodityMod.getStrCommDesc());
						// @08 END
						commodityUsedList.add(comboVo);
					}
				}

				cargoDescriptionList = objForm.getCargoDescriptionDetails();
				if (cargoDescriptionList != null && !cargoDescriptionList.isEmpty()) {
					for (EshippingCargoDescriptionMod cargoDescriptionMod : cargoDescriptionList) {
						cargoDescriptionMod.setCommodityValues(commodityUsedList);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (cargoDescriptionList == null) {
				cargoDescriptionList = new ArrayList<EshippingCargoDescriptionMod>();
				cargoDescMod = new EshippingCargoDescriptionMod();
				if (commodityUsedList == null) {
					commodityUsedList = new ArrayList<ComboVO>();
				}
				cargoDescMod.setCommodityValues(commodityUsedList);
				cargoDescriptionList.add(cargoDescMod);
			}
		}
		// @07 END
	}
	// @01 END

	/**
	 *
	 * This method for combobox of container type in screen.
	 *
	 * @exception Exception
	 * @param seqNo
	 *            No of equipment row in screen
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 * @param stautsFlag
	 *            Flag Status for check in equipment detail
	 */
	private void newCargeDetails(int seqNo, EshippingInstructionUim objForm, String dbFlag, String stautsFlag)
			throws Exception {
		EshippingCargoDescriptionMod ecd = null;
		List<EshippingCargoDescriptionMod> cargoDescriptionDetails = null;

		try {
			cargoDescriptionDetails = objForm.getCargoDescriptionDetails();
			if (cargoDescriptionDetails == null) {
				cargoDescriptionDetails = new ArrayList<EshippingCargoDescriptionMod>();
			}
			if (cargoDescriptionDetails.isEmpty()) {
				ecd = new EshippingCargoDescriptionMod();

				ecd.setSeqNo(seqNo);
				setComboBoxEquipment(ecd);
				ecd.setDbFlag(dbFlag);
				ecd.setCntrSeq("0");
				ecd.setStatusFlag(EshippingInstructionDao.KEY_COLUMN_IN_PROGRESS);

				cargoDescriptionDetails.add(ecd);
			}
			objForm.setCargoDescriptionDetails(cargoDescriptionDetails);

			setComboBoxCommodity(objForm);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *
	 * This method for set value to object equipment detail from screen.
	 *
	 * @exception Exception
	 * @param seqNo
	 *            No of equipment row in screen
	 * @param cargoDescriptionDetails
	 *            List's Eshipping Equipment Detail for use in screen
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 * @param obj
	 *            It's values of equipment detail from screen
	 */
	public void setCargoDetails(int seqNo, List<EshippingCargoDescriptionMod> cargoDescriptionDetails,
			EshippingInstructionUim objForm, String obj) throws Exception {

		System.out.println("[EshippingInstructionSvc][setCargoDetails][Begin]");
		// @08 BEGIN
		EshippingCargoDescriptionMod ecd = null;
		String[] values = null;
		String txtSeperate = null;
		String newValue = null;
		int MAX_COLUMN = 21;
		int valueSize = 0;

		try {
			System.out.println("[EshippingInstructionSvc][setCargoDetails] obj :: " + obj);
			if (obj != null) {
				txtSeperate = objForm.getTextSeparate();
				System.out.println("[EshippingInstructionSvc][setCargoDetails] txtSeperate :: " + txtSeperate);
				if (txtSeperate != null) {
					values = obj.split(objForm.getTextSeparate());

					if (values != null && values.length > 0) {
						valueSize = values.length;
					}
				}
			}

			ecd = new EshippingCargoDescriptionMod();
			ecd.setSeqNo(seqNo);
			for (int index = 0; index < MAX_COLUMN; index++) {
				if (index < valueSize) {
					newValue = values[index];
				} else {
					newValue = null;
				}
				setCargoDetailByIndex(ecd, newValue, index);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			cargoDescriptionDetails.add(ecd);
			objForm.setCargoDescriptionDetails(cargoDescriptionDetails);
			setComboBoxEquipment(ecd);

			System.out.println("[EshippingInstructionSvc][setCargoDetails][End]");
		}
	}
	// @08 BEGIN

	private void setCargoDetailByIndex(EshippingCargoDescriptionMod equipmentDescMod, String newValue,
			int currentIndex) {
		try {
			if (newValue == null || "null".equals(newValue.trim())) {
				newValue = StringUtils.EMPTY;
			}

			switch (currentIndex) {
			case 0:
				equipmentDescMod.setContainerNo(newValue);
				break;
			case 1:
				equipmentDescMod.setContainerType(newValue);
				break;
			case 2:
				equipmentDescMod.setCarrierSeal(newValue);
				break;
			case 3:
				equipmentDescMod.setShipperSeal(newValue);
				break;
			case 4:
				equipmentDescMod.setOfPackages(newValue);
				break;
			case 5:
				equipmentDescMod.setPackagesKind(newValue);
				break;
			case 6:
				equipmentDescMod.setGrossContainerWeight(newValue);
				break;
			case 7:
				equipmentDescMod.setLadenMt(newValue);
				break;
			case 8:
				equipmentDescMod.setGrossCargoMeasurement(newValue);
				break;
			case 9:
				equipmentDescMod.setDbFlag(newValue);
				break;
			case 10:
				equipmentDescMod.setStatusFlag(newValue);
				break;
			case 11:
				equipmentDescMod.setOriginalSeqNo(newValue);
				break;
			case 12:
				equipmentDescMod.setContainerEqSize(newValue);
				break;
			case 13:
				equipmentDescMod.setContainerEqType(newValue);
				break;
			case 14:
				equipmentDescMod.setPackagesKindCode(newValue);
				break;
			case 15:
				equipmentDescMod.setCntrSeq(newValue);
				break;
			case 16:
				if (StringUtils.EMPTY.equals(newValue)) {
					equipmentDescMod.setSeqNo(new Integer(0));
				} else {
					try {
						equipmentDescMod.setSeqNo(new Integer(newValue));
					} catch (NumberFormatException nex) {
						equipmentDescMod.setSeqNo(new Integer(0));
					}
				}
				break;
			case 17:
				equipmentDescMod.setFkEquipmentDetail(newValue);
				break;
			case 18:
				equipmentDescMod.setFkBookingSupplier(newValue);
				break;
			case 19:
				equipmentDescMod.setFkBookingSizeTypeDetail(newValue);
				break;
			case 20:
				equipmentDescMod.setCommodity(newValue);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// @08 END

	/**
	 *
	 * This method for combine list between object temp static and obj from screen.
	 *
	 * @param listSend
	 *            List from screen
	 * @param status
	 *            Status for set in temp object
	 */
	public void combineListFromTmp(List<EshippingCargoDescriptionMod> listSend, String status) {
		if (null != listSend) {
			for (EshippingCargoDescriptionMod eqTmp : equipmentTmp) {
				for (EshippingCargoDescriptionMod ls : listSend) {
					if (eqTmp.getOriginalSeqNo().contains(ls.getOriginalSeqNo())) {
						if (!eqTmp.getStatusFlag().equals(status)) {
							eqTmp.setOriginalSeqNo(ls.getOriginalSeqNo());
							eqTmp.setStatusFlag(status);
						}
					} else {
						if (!eqTmp.getStatusFlag().equals(status)) {
							eqTmp.setStatusFlag("U");
						}
					}
				}

			}
		}
	}

	/**
	 *
	 * This method for update flag 'Delete' from equipment object has send.
	 *
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 */
	public void updateFlagItemsDelete(EshippingInstructionUim objForm) {
		List<EshippingCargoDescriptionMod> listDeleted = null;

		String[] flagItemsDeleteFromJSP = null;
		String[] equipmentEachColumn = null;
		String originalSeqNo = null;

		int i = 0;

		try {
			if (equipmentTmp != null) {
				if (!BLANK.equals(objForm.getItemsDelete())) {
					listDeleted = new ArrayList<EshippingCargoDescriptionMod>();

					flagItemsDeleteFromJSP = objForm.getFlagItemsDelete().split(",");

					for (String equipmentDetailFromJSP : objForm.getCargoDetails()) {
						equipmentEachColumn = equipmentDetailFromJSP.split(objForm.getTextSeparate());
						originalSeqNo = equipmentEachColumn[11];
						if (originalSeqNo.equals(flagItemsDeleteFromJSP[i])) {
							EshippingCargoDescriptionMod ecd = new EshippingCargoDescriptionMod();
							ecd.setContainerNo(!NULL_DATA.equals(equipmentEachColumn[0]) ? equipmentEachColumn[0]
									: StringUtils.EMPTY);
							ecd.setContainerType(!NULL_DATA.equals(equipmentEachColumn[1]) ? equipmentEachColumn[1]
									: StringUtils.EMPTY);
							ecd.setCarrierSeal(!NULL_DATA.equals(equipmentEachColumn[2]) ? equipmentEachColumn[2]
									: StringUtils.EMPTY);
							ecd.setShipperSeal(!NULL_DATA.equals(equipmentEachColumn[3]) ? equipmentEachColumn[3]
									: StringUtils.EMPTY);
							ecd.setOfPackages(!NULL_DATA.equals(equipmentEachColumn[4]) ? equipmentEachColumn[4]
									: StringUtils.EMPTY);
							ecd.setPackagesKind(!NULL_DATA.equals(equipmentEachColumn[5]) ? equipmentEachColumn[5]
									: StringUtils.EMPTY);
							ecd.setGrossContainerWeight(
									!NULL_DATA.equals(equipmentEachColumn[6]) ? equipmentEachColumn[6]
											: StringUtils.EMPTY);
							ecd.setLadenMt(!NULL_DATA.equals(equipmentEachColumn[7]) ? equipmentEachColumn[7]
									: StringUtils.EMPTY);
							ecd.setGrossCargoMeasurement(
									!NULL_DATA.equals(equipmentEachColumn[8]) ? equipmentEachColumn[8]
											: StringUtils.EMPTY);
							ecd.setDbFlag(!NULL_DATA.equals(equipmentEachColumn[9]) ? equipmentEachColumn[9]
									: StringUtils.EMPTY);
							ecd.setStatusFlag(!NULL_DATA.equals(equipmentEachColumn[10]) ? equipmentEachColumn[10]
									: StringUtils.EMPTY);
							ecd.setOriginalSeqNo(equipmentEachColumn[11]);
							ecd.setContainerEqSize(!NULL_DATA.equals(equipmentEachColumn[12]) ? equipmentEachColumn[12]
									: StringUtils.EMPTY);
							ecd.setContainerEqType(!NULL_DATA.equals(equipmentEachColumn[13]) ? equipmentEachColumn[13]
									: StringUtils.EMPTY);
							ecd.setPackagesKindCode(!NULL_DATA.equals(equipmentEachColumn[14]) ? equipmentEachColumn[14]
									: StringUtils.EMPTY);
							ecd.setCntrSeq(!NULL_DATA.equals(equipmentEachColumn[15]) ? equipmentEachColumn[15]
									: StringUtils.EMPTY);
							listDeleted.add(ecd);
						}
						i++;
					}
				}
				combineListFromTmp(listDeleted, "D");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *
	 * This method for clear form in screen.
	 *
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 */
	public void clearForm(EshippingInstructionUim objForm) {
		try {
			objForm.resetForm();

			newCargeDetails(1, objForm, "0", null);

			getDefaultCargoDetailRow(objForm);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *
	 * This method for get all data to show in eshipping screen.
	 *
	 * @exception Exception
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 * @param objDao
	 *            DAO of Eshipping Intruction
	 * @param request
	 *            HttpServletRequest
	 * @param isLoadData
	 *            Flag of load/not load data, when click add/delete equipment from
	 *            screen will be not load data
	 * @return ActionForward
	 */
	public void getBookingData(EshippingInstructionUim objForm, EshippingInstructionDao objDao,
			HttpServletRequest request, Boolean isLoadData) throws Exception {
		List<EshippingBookingListMod> list = null;
		EshippingBookingListMod mod = null;
		// @18 BEGIN
		String prevEsiStatusCode = null;
		String prevEsiStatusDesc = null;
		String esiStatusCode = null;
		String esiStatusDesc = null;
		// @18 END
		// @06 BEGIN
		String strMode = null;
		// @06 END
		String bookingNo = null;
		String blNo = null;
		// @16 BEGIN
		String cocSoc = null;
		// @16 END
		String modeGetData = null;

		Map mapResult = null;
		Map mapParams = null;

		boolean hasBlNO = false;
		try {
			mapParams = new HashMap();

			bookingNo = objForm.getBookingNo();
			blNo = objForm.getBlNo();
			modeGetData = objForm.getMode();

			objForm.setNotFound(Boolean.FALSE);

			prevEsiStatusCode = objForm.getPrevEsiStatusCode();
			prevEsiStatusDesc = objForm.getPrevEsiStatusDesc();
			esiStatusCode = objForm.getEsiStatusCode();
			esiStatusDesc = objForm.getEsiStatusDesc();

			if (INPUT_YOURSELF_MODE.equals(modeGetData)) {
				mapParams.put(EshippingInstructionDao.P_I_V.BOOKING_NO, bookingNo);
				mapParams.put(KEY_USER_ID, getUserID(request));
				mapParams.put(EshippingInstructionDao.KEY_CRITERIA_STATUS, BLANK);

				// mapResult = objDao.getBLNo(mapParams);
				// if(mapResult != null){
				// //@06 BEGIN
				// strMode = (String) mapResult.get(EshippingInstructionDao.KEY_OUT_MODE);
				// //@06 END
				// if(mapResult.containsKey(EshippingInstructionDao.KEY_OUT_BL_NO)){
				// blNo = (String) mapResult.get(EshippingInstructionDao.KEY_OUT_BL_NO);

				// HOLD By YOSSUN ***********************************
				// if(blNo != null && !BLANK.equals(blNo)){
				// hasBlNO = true;
				// }
				// }
				// **********************************************
				// }
				if (hasBlNO) {
					mapParams.put(EshippingInstructionDao.KEY_CRITERIA_TEXT_FIND, blNo);
					mapParams.put(EshippingInstructionDao.KEY_CRITERIA_COLUMN,
							EshippingInstructionDao.KEY_COLUMN_BL_NO);
				} else {
					mapParams.put(EshippingInstructionDao.KEY_CRITERIA_TEXT_FIND, bookingNo);
					mapParams.put(EshippingInstructionDao.KEY_CRITERIA_COLUMN,
							EshippingInstructionDao.KEY_COLUMN_BOOKING_NO);
				}

				mapResult = objDao.getListEShipping(mapParams);
				if (mapResult != null) {
					System.out.println(
							"[EshippingInstructionSvc][getBookingData] objDao.getListEShipping(mapParams) is not null");
					list = (List<EshippingBookingListMod>) mapResult.get(EshippingInstructionDao.KEY_DATA);
					if (null != list && !list.isEmpty()) {
						System.out.println(
								"[EshippingInstructionSvc][getBookingData] mapResult.get(EshippingInstructionDao.KEY_DATA) is not null");
						mod = list.get(0);

						blNo = mod.getBlNo();

						// @18 BEGIN
						esiStatusCode = mod.getEsiStatusCode();
						esiStatusDesc = mod.getEsiStatusDesc();
						// @18 END
						// @16 BEGIN
						cocSoc = mod.getCocSoc();
						objForm.setCocSoc(cocSoc);
						// @16 END
						// System.out.println("list not null mode >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						mapParams.put(EshippingInstructionDao.P_I_V.BL_NO, blNo);
						mapParams.put(EshippingInstructionDao.P_I_V.BKG_NO, bookingNo);
						mapParams.put(EshippingInstructionDao.P_I_V.STATUS, convertStatus(esiStatusCode));
						mapParams.put(EshippingInstructionDao.P_I_V.MODE, convertStatus(esiStatusCode));

						populateAllData(objForm, objDao, mapParams, request, Boolean.TRUE);

						if (esiStatusDesc == null || BLANK.equals(esiStatusDesc)) {
							esiStatusDesc = convertNumberStatus(strMode);
						}
					} else {
						System.out.println(
								"[EshippingInstructionSvc][getBookingData] mapResult.get(EshippingInstructionDao.KEY_DATA) is null");
						// System.out.println("list null mode >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						mapResult = new HashMap();
						mapResult.put(EshippingInstructionDao.P_I_V.BL_NO, BLANK);
						mapResult.put(EshippingInstructionDao.P_I_V.BKG_NO, BLANK);
						mapResult.put(EshippingInstructionDao.P_I_V.STATUS, BLANK);
						// @06 BEGIN
						mapResult.put(EshippingInstructionDao.P_I_V.MODE, BLANK);
						// @06 END

						populateAllData(objForm, objDao, mapResult, request, Boolean.TRUE);

						clearForm(objForm);

						objForm.setNotFound(Boolean.TRUE);
					}
				} else {
					System.out.println(
							"[EshippingInstructionSvc][getBookingData] objDao.getListEShipping(mapParams) is null");
					// @02 BEGIN
					Map mapNoData = new HashMap();
					mapNoData.put(EshippingInstructionDao.P_I_V.BL_NO, blNo);
					mapNoData.put(EshippingInstructionDao.P_I_V.BKG_NO, bookingNo);
					mapNoData.put(EshippingInstructionDao.P_I_V.STATUS, strMode);
					mapNoData.put(EshippingInstructionDao.P_I_V.MODE, strMode);

					populateAllData(objForm, objDao, mapNoData, request, Boolean.TRUE);
					// @02 END
					if (esiStatusDesc == null || BLANK.equals(esiStatusDesc)) {
						esiStatusDesc = convertNumberStatus(strMode);
					}
				}
			} else {
				// @18 BEGIN
				esiStatusCode = request.getParameter("esiStatusCode");
				esiStatusDesc = request.getParameter("esiStatusDesc");

				if (null == esiStatusCode || "".equals(esiStatusCode)) {
					esiStatusCode = objDao.getEsiStatusCodeForValidation(bookingNo);
				}
				// @13 BEGIN
				// esiStatusDesc = request.getParameter("esiStatus");
				// @13 END
				// @18 END
				mapParams.put(EshippingInstructionDao.P_I_V.BL_NO, blNo);
				mapParams.put(EshippingInstructionDao.P_I_V.BKG_NO, bookingNo);

				// @06 BEGIN
				strMode = convertStatus(esiStatusCode);
				// @13 BEGIN
				mapParams.put(EshippingInstructionDao.P_I_V.STATUS, convertStatus(esiStatusCode));
				mapParams.put(EshippingInstructionDao.P_I_V.MODE, convertStatus(esiStatusCode));
				// @13 END
				// @06 END
				populateAllData(objForm, objDao, mapParams, request, isLoadData);
			}
			// @18 BEGIN
			// objForm.setEsiStatusCode(esiStatusCode);
			// objForm.setEsiStatusDesc(esiStatusDesc);
			objForm.setPrevEsiStatusCode(esiStatusCode);
			objForm.setPrevEsiStatusCode(esiStatusDesc);
			// //@13 BEGIN
			// objForm.setEsiStatus(esiStatusDesc);
			// //@13 END
			// objForm.setPrevEsiStatus(esiStatusDesc);
			// @18 END
		} catch (Exception ex) {
			objForm.setEsiStatusCode(prevEsiStatusCode);
			objForm.setEsiStatusDesc(prevEsiStatusDesc);
		}
	}
	// New Version --- END

	/**
	 *
	 * This method for set all data of eshipping procedure for show data in screen.
	 *
	 * @exception Exception
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 * @param objDao
	 *            DAO of Eshipping Intruction
	 * @param mapParams
	 *            List of paratemers for sent to procedure
	 * @param request
	 *            HttpServletRequest
	 * @param isLoadData
	 *            Flag of load/not load data, when click add/delete equipment from
	 *            screen will be not load data
	 */
	public void populateAllData(EshippingInstructionUim objForm, EshippingInstructionDao objDao, Map mapParams,
			HttpServletRequest request, Boolean isLoadData) throws Exception {
		// System.out.println("isLoadData ----------------> " + isLoadData);
		Map mapResult = null;

		List<EshippingCommodityDetailsMod> commodityList = null;
		List<EshippingCargoDescriptionMod> equipmentList = null;
		// @10 BEGIN
		String esiErrMsg = null;
		String bookingNo = null;
		String prevBookingNo = null;
		String bookingNoMap = null;
		// @10 END
		String strError = null;
		String strError2 = null;

		/* Begin @22 */
		String comSeqNoTemp = null;
		EshippingCommodityDetailsMod mod = null;
		/* End @22 */

		try {
			bookingNo = objForm.getBookingNo();
			prevBookingNo = objForm.getPrevBookingNo();
			if (isLoadData) {
				mapParams.put(KEY_USER_ID, getUserID(request));
				bookingNoMap = (String) mapParams.get(EshippingInstructionDao.P_I_V.BKG_NO);
				if (bookingNoMap != null && !BLANK.equals(bookingNoMap)) {
					objDao.setShipmentDetail(mapParams, objForm);
					objDao.setContactDetail(mapParams, objForm);
					// System.out.println("Created flag : " +
					// result.get(EshippingInstructionDao.KEY_CREATED_FLAG));

					objDao.setRoutingDetail(mapParams, objForm);
					objDao.setEquipmentDetail(mapParams, objForm);

					// @06 BEGIN
					mapResult = objDao.getCommodityDetails(mapParams);
					if (mapResult != null && !mapResult.isEmpty()) {
						commodityList = (List<EshippingCommodityDetailsMod>) mapResult
								.get(EshippingInstructionDao.KEY_DATA);
						if (commodityList == null) {
							commodityList = new ArrayList<EshippingCommodityDetailsMod>();
							comSeqNoTemp = "0";// @22
						} else {
							/* Begin @22 */
							for (int i = 0; i < commodityList.size(); i++) {
								mod = commodityList.get(i);
								if (comSeqNoTemp == null) {
									comSeqNoTemp = mod.getComSeqNo();
								} else {
									if (Integer.parseInt(mod.getComSeqNo()) > Integer.parseInt(comSeqNoTemp)) {
										comSeqNoTemp = mod.getComSeqNo();
									}
								}
							}
							/* End @22 */
						}
					}

					/* Begin @22 */
					objForm.setComSeqNoTemp(comSeqNoTemp);
					// objDao.setCargoMark(mapParams, objForm);
					/* End @22 */

					objForm.setPrevBookingNo(bookingNo);
				} else {
					// strError = "Invalid Booking number.";
					strError = "Booking Status is subject to CONFIRMED before create eSI.";
					objForm.setEsiErrMsg(strError);
					objForm.setBookingNo(prevBookingNo);
				}
			}
		} catch (Exception ex) {
			// @03 BEGIN
			if (ex.toString().indexOf("ORA-20001:") > 0) {
				strError = ex.toString().substring(ex.toString().indexOf("ORA-20001:"));
				strError2 = strError.substring(strError.indexOf(":") + 1, strError.indexOf(".") + 1);
				objForm.setEsiErrMsg(strError2);
			}
			;

			objForm.setBookingNo(prevBookingNo);
			// #03 END
			throw ex;
			// throw e;
			// System.out.println("error 1 : "+e.toString());
		} finally {
			// @10 BEGIN
			esiErrMsg = objForm.getEsiErrMsg();
			if (esiErrMsg != null && !BLANK.equals(esiErrMsg)) {
				request.setAttribute("btnSubmitEsiDisp", "false");
			}

			if (commodityList == null) {
				commodityList = objForm.getCommodityVoDataList();
				if (commodityList == null) {
					commodityList = new ArrayList<EshippingCommodityDetailsMod>();
				}
			}
			if (commodityList.size() == 0) {
				EshippingCommodityDetailsMod objVo = new EshippingCommodityDetailsMod();
				objVo.setStrCommCode(BLANK);
				objVo.setStrCommDesc(BLANK);
				objVo.setStrCommGroup(BLANK);
				objVo.setStrCommGroupCode(BLANK);
				// objVo.setIntCommGroupSeqNo(null);
				// @21 BEGIN
				objVo.setStrCommOfPackages("0");
				objVo.setStrCommPackageKindCode(BLANK);
				objVo.setStrCommPackageKindName(BLANK);
				objVo.setStrCommWeight("0.000");
				objVo.setStrCommMeasurement("0.0000");
				// @21 END
				commodityList.add(objVo);
			}
			objForm.setCommodityVoDataList(commodityList);

			equipmentList = objForm.getCargoDescriptionDetails();
			if (equipmentList == null || equipmentList.isEmpty()) {
				equipmentList = new ArrayList<EshippingCargoDescriptionMod>();
				newCargeDetails(1, objForm, "0", null);
			}
			equipmentTmp = equipmentList;

			objForm.setFromPoup("0");
			// @01 BEGIN
			setComboBoxCommodity(objForm);
			// @01 END
			// --------------- Workaround for booking number lose after call setCargoMark
			// method -----------------
			// @10 END
		}
	}

	/**
	 *
	 * This method for set all data in eshipping header (support save or submit
	 * function).
	 *
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 * @param request
	 *            HttpServletRequest
	 * @return List of params has been set
	 */
	public Map setParamsHeaderForSave(EshippingInstructionUim objForm, HttpServletRequest request) {
		Map mapParam = new HashMap();
		mapParam.put(EshippingInstructionDao.P_I_V.STATUS, convertStatus(objForm.getEsiStatusCode()));

		mapParam.put(EshippingInstructionDao.P_I_V.ARCHE_TYPE, objForm.getChoiceRad());
		mapParam.put(EshippingInstructionDao.P_I_V.BL_TYPE, objForm.getBlType());
		mapParam.put(EshippingInstructionDao.P_I_V.BKG_NO, objForm.getBookingNo());
		mapParam.put(EshippingInstructionDao.P_I_V.BL_NO, objForm.getBlNo());
		mapParam.put(EshippingInstructionDao.P_I_V.SUBMIT_BY, getUserID(request));
		mapParam.put(EshippingInstructionDao.P_I_V.CONTACT, objForm.getContact());
		mapParam.put(EshippingInstructionDao.P_I_V.EMAIL, objForm.getEmail());
		mapParam.put(EshippingInstructionDao.P_I_V.ADD_EMAILS, objForm.getAdditionalEmail());
		mapParam.put(EshippingInstructionDao.P_I_V.PHONE, objForm.getTelephone());
		mapParam.put(EshippingInstructionDao.P_I_V.FAX, objForm.getFax());
		mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_CODE, objForm.getShipperCode());
		mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_NAME, objForm.getShipperName());
		mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_ADD1, objForm.getShipperAddress1());
		mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_ADD2, objForm.getShipperAddress2());
		mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_ADD3, objForm.getShipperAddress3());
		mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_ADD4, objForm.getShipperAddress4());
		mapParam.put(EshippingInstructionDao.P_I_V.CNEE_CODE, objForm.getConsigneeCode());
		mapParam.put(EshippingInstructionDao.P_I_V.CNEE_NAME, objForm.getConsigneeName());
		mapParam.put(EshippingInstructionDao.P_I_V.CNEE_ADD1, objForm.getConsigneeAddress1());
		mapParam.put(EshippingInstructionDao.P_I_V.CNEE_ADD2, objForm.getConsigneeAddress2());
		mapParam.put(EshippingInstructionDao.P_I_V.CNEE_ADD3, objForm.getConsigneeAddress3());
		mapParam.put(EshippingInstructionDao.P_I_V.CNEE_ADD4, objForm.getConsigneeAddress4());
		mapParam.put(EshippingInstructionDao.P_I_V.NTFY_CODE, objForm.getNotifyPartyCode());
		mapParam.put(EshippingInstructionDao.P_I_V.NTFY_NAME, objForm.getNotifyPartyName());
		mapParam.put(EshippingInstructionDao.P_I_V.NTFY_ADD1, objForm.getNotifyPartyAddress1());
		mapParam.put(EshippingInstructionDao.P_I_V.NTFY_ADD2, objForm.getNotifyPartyAddress2());
		mapParam.put(EshippingInstructionDao.P_I_V.NTFY_ADD3, objForm.getNotifyPartyAddress3());
		mapParam.put(EshippingInstructionDao.P_I_V.NTFY_ADD4, objForm.getNotifyPartyAddress4());
		mapParam.put(EshippingInstructionDao.P_I_V.ISSUE_PLACE_NAME, objForm.getPlaceDateOfIssue());
		mapParam.put(EshippingInstructionDao.P_I_V.POL_NAME, objForm.getPol());
		mapParam.put(EshippingInstructionDao.P_I_V.POD_NAME, objForm.getPod());
		mapParam.put(EshippingInstructionDao.P_I_V.POL_NO, objForm.getPolNo());
		mapParam.put(EshippingInstructionDao.P_I_V.POD_NO, objForm.getPodNo());
		mapParam.put(EshippingInstructionDao.P_I_V.PLR_NAME, objForm.getPlaceOfReceipt());
		mapParam.put(EshippingInstructionDao.P_I_V.PLD_NAME, objForm.getPlaceOfDelivery());
		mapParam.put(EshippingInstructionDao.P_I_V.ORG_BL_COUNT, objForm.getNoOfOriginal());
		/* Begin @22 */
		// mapParam.put(EshippingInstructionDao.P_I_V.MARKS_NO,
		// objForm.getMarksAndNumbers());
		// mapParam.put(EshippingInstructionDao.P_I_V.DESC, objForm.getDescription());
		mapParam.put(EshippingInstructionDao.P_I_V.MARKS_NO, BLANK);
		mapParam.put(EshippingInstructionDao.P_I_V.DESC, BLANK);
		/* End @22 */
		mapParam.put(EshippingInstructionDao.P_I_V.REMARK, objForm.getRemarks());
		mapParam.put(EshippingInstructionDao.P_I_V.VESSEL, objForm.getVessel());
		mapParam.put(EshippingInstructionDao.P_I_V.VESSEL_NO, objForm.getVesselNo());
		mapParam.put(EshippingInstructionDao.P_I_V.VOYAGE, objForm.getVoyageNo());
		mapParam.put(EshippingInstructionDao.P_I_V.LOGIN_ID, getUserID(request));
		mapParam.put("P_I_V_TO_TERMINAL", objForm.getToTerminal());
		mapParam.put("P_I_V_FROM_TERMINAL", objForm.getFromTerminal());
		mapParam.put("P_I_V_VESSEL_ETD", objForm.getVesselEdi());
		mapParam.put("P_I_V_QUOTATION", objForm.getQuotation());
		return mapParam;
	}

	/**
	 *
	 * This method for convert Laden/MT from screen to flag for sent to procedure.
	 *
	 * @param ladenMt
	 *            Value of Laden/MT from screen has sent
	 * @return Flag of Laden/MT
	 */
	public String convertLadenMt(String ladenMt) {
		if (EshippingInstructionDao.KEY_COLUMN_LADEN.equals(ladenMt)) {
			return "F";
		} else if (EshippingInstructionDao.KEY_COLUMN_EMPTY.equals(ladenMt)) {
			return "E";
		} else if (BLANK.equals(ladenMt)) {
			return " ";
		}
		return ladenMt;
	}

	/**
	 *
	 * This method for called procedure save equipment detail(new item(s) only).
	 *
	 * @exception BusinessException
	 *                and DataAccessException and Exception
	 * @param objDao
	 *            DAO of Eshipping Intruction
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 * @param request
	 *            HttpServletRequest
	 * @return Status or error after save
	 */
	public Map setParamsDetailsInsertForSave(EshippingInstructionDao objDao, EshippingInstructionUim objForm,
			HttpServletRequest request) throws BusinessException, DataAccessException, Exception {
		System.out.println("[EshippingInstructionSvc][setParamsDetailsInsertForSave][Begin]");

		String[] values = null;
		String containnerNo = null;
		String ladenMt = null;
		String containnerEqSize = null;
		String containnerEqType = null;
		String carrierSeal = null;
		String shipperSeal = null;
		String ofPackages = null;
		String grossWeight = null;
		String grossCargo = null;
		String packageKindCode = null;
		String cntrSeq = null;
		String dbFlag = null;
		String statusFlag = null;
		String esiStatus = null;
		String mode = null;
		String originalSeq = null;
		String fkEquipmentDetail = null;
		String fkBookingSupplier = null;
		String fkBookingSizeTypeDetail = null;
		// @01 BEGIN
		String strCommodity = null;
		// @01 END
		List cargoDetailsList = null;
		String[] cargoDetails = objForm.getCargoDetails();
		Map mapParam = null;
		int seqNo;
		int i = equipmentTmp.size();
		int j = 1;

		try {
			for (String cargoDetail : cargoDetails) {

				System.out.println(
						"[EshippingInstructionSvc][setParamsDetailsInsertForSave] cargoDetail :: " + cargoDetail);

				if (!StringUtils.EMPTY.equals(cargoDetail)) {
					values = cargoDetail.split(objForm.getTextSeparate());
					statusFlag = !NULL_DATA.equals(values[10]) ? values[10] : StringUtils.EMPTY;

					System.out.println(
							"[EshippingInstructionSvc][setParamsDetailsInsertForSave] statusFlag :: " + statusFlag);

					if (EshippingInstructionDao.KEY_STATUS_INSERT.equals(statusFlag)) {
						// System.out.println("[Insert mode] sent to DB --------> " + statusFlag);
						containnerNo = !NULL_DATA.equals(values[0]) ? values[0] : StringUtils.EMPTY;
						carrierSeal = !NULL_DATA.equals(values[2]) ? values[2] : StringUtils.EMPTY;
						shipperSeal = !NULL_DATA.equals(values[3]) ? values[3] : StringUtils.EMPTY;
						ofPackages = values[4];
						grossWeight = values[6];
						ladenMt = !NULL_DATA.equals(values[7]) ? values[7] : StringUtils.EMPTY;
						;
						grossCargo = values[8];
						dbFlag = values[9];
						originalSeq = values[11];
						containnerEqSize = values[12];
						containnerEqType = values[13];
						packageKindCode = values[14];
						cntrSeq = values[15];
						seqNo = Integer.parseInt(values[16]);
						fkEquipmentDetail = values[17];
						fkBookingSupplier = values[18];
						fkBookingSizeTypeDetail = values[19];
						// @01 BEGIN
						strCommodity = values[20];
						// @01 END

						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] containnerNo               :: "
										+ containnerNo);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] carrierSeal                :: "
										+ carrierSeal);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] shipperSeal                :: "
										+ shipperSeal);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] ofPackages                 :: "
										+ ofPackages);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] grossWeight                :: "
										+ grossWeight);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] ladenMt                    :: "
										+ ladenMt);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] grossCargo                 :: "
										+ grossCargo);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] dbFlag                     :: "
										+ dbFlag);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] originalSeq                :: "
										+ originalSeq);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] containnerEqSize           :: "
										+ containnerEqSize);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] containnerEqType           :: "
										+ containnerEqType);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] packageKindCode            :: "
										+ packageKindCode);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] cntrSeq                    :: "
										+ cntrSeq);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] seqNo                      :: "
										+ seqNo);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] fkEquipmentDetail          :: "
										+ fkEquipmentDetail);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] fkBookingSupplier          :: "
										+ fkBookingSupplier);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] fkBookingSizeTypeDetail    :: "
										+ fkBookingSizeTypeDetail);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] strCommodity               :: "
										+ strCommodity);

						mapParam = new HashMap();
						esiStatus = convertStatus(objForm.getEsiStatusCode());
						if ("1".equals(esiStatus)) {
							mode = esiStatus;
						} else {
							if ("I".equals(statusFlag)) {
								mode = "1";
							} else if ("U".equals(statusFlag)) {
								mode = "2";
							} else if ("D".equals(statusFlag)) {
								mode = "3";
							}
						}

						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] esiStatus          :: "
										+ esiStatus);
						System.out.println(
								"[EshippingInstructionSvc][setParamsDetailsInsertForSave] mode               :: "
										+ mode);

						mapParam.put(EshippingInstructionDao.P_I_V.MODE, mode);
						mapParam.put(EshippingInstructionDao.P_I_V.BKG_NO, objForm.getBookingNo());
						mapParam.put(EshippingInstructionDao.P_I_V.LOGIN_ID, getUserID(request));
						mapParam.put(EshippingInstructionDao.P_I_V.SCREEN_SEQNO, seqNo + "");
						mapParam.put(EshippingInstructionDao.P_I_V.DN_EQ_NO, containnerNo);
						mapParam.put(EshippingInstructionDao.P_I_V.EQ_NO_SOURCE, "B");
						mapParam.put(EshippingInstructionDao.P_I_V.LADEN_MT, convertLadenMt(ladenMt));
						mapParam.put(EshippingInstructionDao.P_I_V.DN_EQ_SIZE, containnerEqSize);
						mapParam.put(EshippingInstructionDao.P_I_V.DN_EQ_TYPE, containnerEqType);
						mapParam.put(EshippingInstructionDao.P_I_V.GROSS_CARGO_WEIGHT, grossWeight);
						mapParam.put(EshippingInstructionDao.P_I_V.GROSS_CARGO_MSMT, grossCargo);
						mapParam.put(EshippingInstructionDao.P_I_V.CARRIER_SEAL, carrierSeal);
						mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_SEAL, shipperSeal);
						mapParam.put(EshippingInstructionDao.P_I_V.NO_OF_PACKAGES, ofPackages);
						mapParam.put(EshippingInstructionDao.P_I_V.DN_PACKAGE_KIND_CODE, packageKindCode);
						mapParam.put(EshippingInstructionDao.P_I_V.PK_DTL_SEQNO, cntrSeq);
						mapParam.put(EshippingInstructionDao.P_I_V.FK_BKG_EQUIPM_DTL, fkEquipmentDetail);
						mapParam.put(EshippingInstructionDao.P_I_V.FK_BKG_SUPPLIER, fkBookingSupplier);
						mapParam.put(EshippingInstructionDao.P_I_V.FK_BKG_SIZE_TYPE_DTL, fkBookingSizeTypeDetail);
						// @01 BEGIN
						mapParam.put(EshippingInstructionDao.P_I_V.COMMODITY_CODE, strCommodity);
						// @01 END
						// Map result = new HashMap();

						System.out.println("[EshippingInstructionSvc][setParamsDetailsInsertForSave] mapParam "
								+ mapParam.toString());

						Map result = objDao.insertOrUpdateContainerDetail(mapParam);

						String errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);
						if (null != errDesc) {
							result.put(EshippingInstructionDao.P_O_V.ERR_DESC, errDesc);
							result.put(EshippingInstructionDao.KEY_IS_SUCCESS, Boolean.FALSE);
							return result;
						}
						i++;
						j++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			System.out.println("[EshippingInstructionSvc][setParamsDetailsInsertForSave][End]");
		}
		return null;
	}

	public Map setParamsCommodityDetailsInsertForSave(EshippingInstructionDao objDao, EshippingInstructionUim objForm,
			HttpServletRequest request) throws BusinessException, DataAccessException, Exception {
		System.out.println("[EshippingInstructionSvc][setParamsCommodityDetailsInsertForSave][Begin]");

		Map mapParam = null;
		Map resultMap = null;
		EshippingCommodityDetailsMod commodityMod = null;
		List commodityList = null;
		String bookingNo = null;
		String loginId = null;
		String esiStatus = null;
		String commCode = null;
		Integer seqNo = null;
		String weight = null;
		String ofPackage = null;
		String packageKindCode = null;
		String measurement = null;
		String errDesc = null;
		/* Begin @22 */
		String marksAndNumbers = null;
		String description = null;
		String recordStatus = null;
		/* End @22 */
		// String status = null;

		try {
			// status = objForm.getStatus();
			bookingNo = objForm.getBookingNo();
			loginId = getUserID(request);
			commodityList = objForm.getCommodityVoDataList();
			esiStatus = convertStatus(objForm.getEsiStatusCode());

			System.out.println("[EshippingInstructionSvc][setParamsCommodityDetailsInsertForSave] commodityList :: "
					+ commodityList);

			if (commodityList != null && !commodityList.isEmpty()) {
				mapParam = new HashMap();

				System.out.println(
						"[EshippingInstructionSvc][setParamsCommodityDetailsInsertForSave] commodityList.size() :: "
								+ commodityList.size());

				for (int index = 0, size = commodityList.size(); index < size; index++) {
					commodityMod = (EshippingCommodityDetailsMod) commodityList.get(index);

					commCode = commodityMod.getStrCommCode();
					if (commodityMod.getIntCommGroupSeqNo() != null
							&& commodityMod.getIntCommGroupSeqNo().intValue() > 0) {
						seqNo = commodityMod.getIntCommGroupSeqNo();
					} else {
						seqNo = null;
					}

					// @10 BEGIN
					weight = commodityMod.getStrCommWeight();
					// @10 END

					// @21 BEGIN
					ofPackage = commodityMod.getStrCommOfPackages();
					packageKindCode = commodityMod.getStrCommPackageKindCode();
					measurement = commodityMod.getStrCommMeasurement();
					// @21 END

					// @22 BEGIN
					marksAndNumbers = commodityMod.getMarksAndNumbers();
					description = commodityMod.getDescription();
					recordStatus = FormatUtil.nullToBlank(commodityMod.getRecordStatus());
					// @22 END

					// @22 BEGIN
					// if(seqNo==null){
					// esiStatus = "1";
					// }else if(!commodityMod.isDeleted()){
					// esiStatus = "2";
					// }else {
					// esiStatus = "3";
					// }

					System.out.println(
							"[EshippingInstructionSvc][setParamsCommodityDetailsInsertForSave] recordStatus :: "
									+ recordStatus);
					if (recordStatus.equals("")) {
						System.out.println(
								"[EshippingInstructionSvc][setParamsCommodityDetailsInsertForSave] seqNo :: " + seqNo);
						if (seqNo == null) {
							esiStatus = "1";
						} else {
							esiStatus = "2";
						}
					} else {

						// Status New insert only !!
						if (!"1".equals(esiStatus)) {
							if (recordStatus.equals(EshippingInstructionDao.ADD_OPERATION)) {
								esiStatus = "1";
							} else if (recordStatus.equals(EshippingInstructionDao.UPD_OPERATION)) {
								esiStatus = "2";
							} else {
								esiStatus = "3";
							}
						}

						// if(recordStatus.equals(EshippingInstructionDao.ADD_OPERATION)){
						// esiStatus = "1";
						// }else if(recordStatus.equals(EshippingInstructionDao.UPD_OPERATION)){
						// esiStatus = "2";
						// }else{
						// esiStatus = "3";
						// }
					}
					// @22 END

					mapParam.put(EshippingInstructionDao.P_I_V.MODE, esiStatus);
					mapParam.put(EshippingInstructionDao.P_I_V.BOOKING_NO, bookingNo);
					mapParam.put(EshippingInstructionDao.P_I_V.LOGIN_ID, loginId);
					mapParam.put(EshippingInstructionDao.P_I_V.DN_COMMODITY, commCode);
					mapParam.put(EshippingInstructionDao.P_I_V.PK_SEQNO, seqNo);
					// @10 BEGIN
					mapParam.put(EshippingInstructionDao.P_I_V.WEIGHT, weight);
					// @10 END
					// @21 BEGIN
					mapParam.put(EshippingInstructionDao.P_I_V.TOT_PACKAGE, ofPackage);
					mapParam.put(EshippingInstructionDao.P_I_V.TOT_PACKAGE_KIND, packageKindCode);
					mapParam.put(EshippingInstructionDao.P_I_V.TOT_MEASUREMENT, measurement);
					// @21 END
					// @22 BEGIN
					mapParam.put(EshippingInstructionDao.P_I_V.COMM_LVL_MARKS_NO, marksAndNumbers);
					mapParam.put(EshippingInstructionDao.P_I_V.COMM_LVL_DESC, description);
					// @22 END
					Debug.logFramework("Call insertOrUpdateCommodityDetails time: " + (index + 1));
					Debug.logFramework("1." + EshippingInstructionDao.P_I_V.MODE + " = " + esiStatus);
					Debug.logFramework("2." + EshippingInstructionDao.P_I_V.BOOKING_NO + " = " + bookingNo);
					Debug.logFramework("3." + EshippingInstructionDao.P_I_V.LOGIN_ID + " = " + loginId);
					Debug.logFramework("4." + EshippingInstructionDao.P_I_V.DN_COMMODITY + " = " + commCode);
					Debug.logFramework("5." + EshippingInstructionDao.P_I_V.PK_SEQNO + " = " + seqNo);
					Debug.logFramework("6." + EshippingInstructionDao.P_I_V.WEIGHT + " = " + weight);
					Debug.logFramework("7." + EshippingInstructionDao.P_I_V.TOT_PACKAGE + " = " + ofPackage);
					Debug.logFramework("8." + EshippingInstructionDao.P_I_V.TOT_PACKAGE_KIND + " = " + packageKindCode);
					Debug.logFramework("9." + EshippingInstructionDao.P_I_V.TOT_MEASUREMENT + " = " + measurement);
					Debug.logFramework(
							"10." + EshippingInstructionDao.P_I_V.COMM_LVL_MARKS_NO + " = " + marksAndNumbers);
					Debug.logFramework("11." + EshippingInstructionDao.P_I_V.COMM_LVL_DESC + " = " + description);

					resultMap = objDao.insertOrUpdateCommodityDetails(mapParam);
					// resultMap = new HashMap();
					errDesc = (String) resultMap.get(EshippingInstructionDao.P_O_V.ERR_DESC);
					if (errDesc != null) {
						resultMap.put(EshippingInstructionDao.P_O_V.ERR_DESC, errDesc);
						resultMap.put(EshippingInstructionDao.KEY_IS_SUCCESS, Boolean.FALSE);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			System.out.println("[EshippingInstructionSvc][setParamsCommodityDetailsInsertForSave][End]");
		}
		return null;
	}

	/**
	 *
	 * This method for combine list between object temp static and obj from
	 * screen(item for update only).
	 *
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 */
	public void combineDataUpdateToTmp(EshippingInstructionUim objForm) {

		System.out.println("[EshippingInstructionSvc][combineDataUpdateToTmp][Begin]");

		String[] values = null;
		String containnerNo = null;
		String ladenMt = null;
		String containnerEqSize = null;
		String containnerEqType = null;
		String carrierSeal = null;
		String shipperSeal = null;
		String ofPackages = null;
		String grossWeight = null;
		String grossCargo = null;
		String packageKindCode = null;
		String seqNo = null;
		String fkEquipmentDetail = null;
		String fkBookingSupplier = null;
		String fkBookingSizeTypeDetail = null;
		String packageKind = null;
		// @01 BEGIN
		String strCommodity = null;
		// @01 END
		String[] cargoDetails = null;
		int i = 0;

		try {
			cargoDetails = objForm.getCargoDetails();

			System.out.println("[EshippingInstructionSvc][combineDataUpdateToTmp] equipmentTmp :: " + equipmentTmp);
			if (equipmentTmp != null) {
				System.out.println("[EshippingInstructionSvc][combineDataUpdateToTmp] equipmentTmp.size() :: "
						+ equipmentTmp.size());
				for (EshippingCargoDescriptionMod cargoDetailTmp : equipmentTmp) {
					System.out.println(
							"[EshippingInstructionSvc][combineDataUpdateToTmp] cargoDetailTmp.getStatusFlag() :: "
									+ cargoDetailTmp.getStatusFlag());
					if (EshippingInstructionDao.KEY_STATUS_UPDATE.equals(cargoDetailTmp.getStatusFlag())) {
						if (!StringUtils.EMPTY.equals(cargoDetails[i])) {

							values = cargoDetails[i].split(objForm.getTextSeparate());

							containnerNo = !NULL_DATA.equals(values[0]) ? values[0] : StringUtils.EMPTY;
							carrierSeal = !NULL_DATA.equals(values[2]) ? values[2] : StringUtils.EMPTY;
							shipperSeal = !NULL_DATA.equals(values[3]) ? values[3] : StringUtils.EMPTY;
							ofPackages = !NULL_DATA.equals(values[4]) ? values[4] : StringUtils.EMPTY;
							packageKind = !NULL_DATA.equals(values[5]) ? values[5] : StringUtils.EMPTY;
							grossWeight = !NULL_DATA.equals(values[6]) ? values[6] : StringUtils.EMPTY;
							ladenMt = !NULL_DATA.equals(values[7]) ? values[7] : StringUtils.EMPTY;
							grossCargo = !NULL_DATA.equals(values[8]) ? values[8] : StringUtils.EMPTY;
							containnerEqSize = !NULL_DATA.equals(values[12]) ? values[12] : StringUtils.EMPTY;
							containnerEqType = !NULL_DATA.equals(values[13]) ? values[13] : StringUtils.EMPTY;
							packageKindCode = !NULL_DATA.equals(values[14]) ? values[14] : StringUtils.EMPTY;
							seqNo = values[16];
							fkEquipmentDetail = !NULL_DATA.equals(values[17]) ? values[17] : StringUtils.EMPTY;
							fkBookingSupplier = !NULL_DATA.equals(values[18]) ? values[18] : StringUtils.EMPTY;
							fkBookingSizeTypeDetail = !NULL_DATA.equals(values[19]) ? values[19] : StringUtils.EMPTY;
							// @01 BEGIN
							strCommodity = !NULL_DATA.equals(values[20]) ? values[20] : StringUtils.EMPTY;
							// @01 END

							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] containnerNo              :: "
											+ containnerNo);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] carrierSeal               :: "
											+ carrierSeal);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] shipperSeal               :: "
											+ shipperSeal);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] ofPackages                :: "
											+ ofPackages);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] packageKind               :: "
											+ packageKind);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] grossWeight               :: "
											+ grossWeight);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] ladenMt                   :: "
											+ ladenMt);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] grossCargo                :: "
											+ grossCargo);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] containnerEqSize          :: "
											+ containnerEqSize);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] containnerEqType          :: "
											+ containnerEqType);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] packageKindCode           :: "
											+ packageKindCode);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] seqNo                     :: "
											+ seqNo);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] fkEquipmentDetail         :: "
											+ fkEquipmentDetail);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] fkBookingSupplier         :: "
											+ fkBookingSupplier);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] fkBookingSizeTypeDetail   :: "
											+ fkBookingSizeTypeDetail);
							System.out.println(
									"[EshippingInstructionSvc][combineDataUpdateToTmp] strCommodity              :: "
											+ strCommodity);

							cargoDetailTmp.setContainerNo(containnerNo);
							cargoDetailTmp.setCarrierSeal(carrierSeal);
							cargoDetailTmp.setShipperSeal(shipperSeal);
							cargoDetailTmp.setOfPackages(ofPackages);
							cargoDetailTmp.setGrossContainerWeight(grossWeight);
							cargoDetailTmp.setLadenMt(ladenMt);
							cargoDetailTmp.setGrossCargoMeasurement(grossCargo);
							cargoDetailTmp.setContainerEqSize(containnerEqSize);
							cargoDetailTmp.setContainerEqType(containnerEqType);
							cargoDetailTmp.setPackagesKindCode(packageKindCode);
							cargoDetailTmp.setPackagesKind(packageKind);
							cargoDetailTmp.setSeqNo(Integer.parseInt(seqNo));
							cargoDetailTmp.setFkEquipmentDetail(fkEquipmentDetail);
							cargoDetailTmp.setFkBookingSupplier(fkBookingSupplier);
							cargoDetailTmp.setFkBookingSizeTypeDetail(fkBookingSizeTypeDetail);

							// @01 BEGIN
							cargoDetailTmp.setCommodity(strCommodity);
							// @01 END

							i++;
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("[EshippingInstructionSvc][combineDataUpdateToTmp][End]");
		}
	}

	/**
	 *
	 * This method for called procedure save equipment detail(update and delete
	 * item(s) only).
	 *
	 * @exception BusinessException
	 *                and DataAccessException and Exception
	 * @param objDao
	 *            DAO of Eshipping Intruction
	 * @param objForm
	 *            Object's Eshipping Instruction Form
	 * @param request
	 *            HttpServletRequest
	 * @return Status or error after save
	 */
	public Map setParamsDetailsTmpForSave(EshippingInstructionDao objDao, EshippingInstructionUim objForm,
			HttpServletRequest request) throws BusinessException, DataAccessException, Exception {

		System.out.println("[EshippingInstructionSvc][setParamsDetailsTmpForSave][Begin]");

		String containnerNo = null;
		String ladenMt = null;
		String containnerEqSize = null;
		String containnerEqType = null;
		String carrierSeal = null;
		String shipperSeal = null;
		String ofPackages = null;
		String grossWeight = null;
		String grossCargo = null;
		String packageKindCode = null;
		String cntrSeq = null;
		String dbFlag = null;
		String statusFlag = null;
		String esiStatus = null;
		String mode = null;
		String originalSeq = null;
		String fkEquipmentDetail = null;
		String fkBookingSupplier = null;
		String fkBookingSizeTypeDetail = null;
		int seqNo = 0;
		Map mapParam=null;
		int i = 1;
		// @01 BEGIN
		String strCommodity = null;
		// @01 END

		try {

			combineDataUpdateToTmp(objForm);

			for (EshippingCargoDescriptionMod cargoDetail : equipmentTmp) {
				if (!EshippingInstructionDao.KEY_STATUS_INSERT.equals(cargoDetail.getStatusFlag())) {
					// System.out.println("[Delete mode] sent to DB --------> " +
					// cargoDetail.getStatusFlag());
					containnerNo = cargoDetail.getContainerNo();
					carrierSeal = cargoDetail.getCarrierSeal();
					shipperSeal = cargoDetail.getShipperSeal();
					ofPackages = cargoDetail.getOfPackages();
					grossWeight = cargoDetail.getGrossContainerWeight();
					ladenMt = cargoDetail.getLadenMt();
					grossCargo = cargoDetail.getGrossCargoMeasurement();
					dbFlag = cargoDetail.getDbFlag();
					statusFlag = cargoDetail.getStatusFlag();
					originalSeq = cargoDetail.getOriginalSeqNo();
					containnerEqSize = cargoDetail.getContainerEqSize();
					containnerEqType = cargoDetail.getContainerEqType();
					packageKindCode = cargoDetail.getPackagesKindCode();
					cntrSeq = cargoDetail.getCntrSeq();
					seqNo = cargoDetail.getSeqNo();
					fkEquipmentDetail = cargoDetail.getFkEquipmentDetail();
					fkBookingSupplier = cargoDetail.getFkBookingSupplier();
					fkBookingSizeTypeDetail = cargoDetail.getFkBookingSizeTypeDetail();
					// @01 BEGIN
					strCommodity = cargoDetail.getCommodity();
					// @01 END
					mapParam = new HashMap();
					esiStatus = convertStatus(objForm.getEsiStatusCode());
					if ("1".equals(esiStatus)) {
						mode = esiStatus;
					} else {
						if ("I".equals(statusFlag)) {
							mode = "1";
						} else if ("U".equals(statusFlag)) {
							mode = "2";
						} else if ("D".equals(statusFlag)) {
							mode = "3";
						}
					}

					mapParam.put(EshippingInstructionDao.P_I_V.MODE, FormatUtil.nullToBlank(mode));
					mapParam.put(EshippingInstructionDao.P_I_V.BKG_NO, FormatUtil.nullToBlank(objForm.getBookingNo()));
					mapParam.put(EshippingInstructionDao.P_I_V.LOGIN_ID, FormatUtil.nullToBlank(getUserID(request)));
					mapParam.put(EshippingInstructionDao.P_I_V.SCREEN_SEQNO, FormatUtil.nullToBlank(seqNo + ""));
					mapParam.put(EshippingInstructionDao.P_I_V.DN_EQ_NO, FormatUtil.nullToBlank(containnerNo));
					mapParam.put(EshippingInstructionDao.P_I_V.EQ_NO_SOURCE, FormatUtil.nullToBlank("B"));
					mapParam.put(EshippingInstructionDao.P_I_V.LADEN_MT,
							FormatUtil.nullToBlank(convertLadenMt(ladenMt)));
					mapParam.put(EshippingInstructionDao.P_I_V.DN_EQ_SIZE, FormatUtil.nullToBlank(containnerEqSize));
					mapParam.put(EshippingInstructionDao.P_I_V.DN_EQ_TYPE, FormatUtil.nullToBlank(containnerEqType));
					mapParam.put(EshippingInstructionDao.P_I_V.GROSS_CARGO_WEIGHT, FormatUtil.nullToBlank(grossWeight));
					mapParam.put(EshippingInstructionDao.P_I_V.GROSS_CARGO_MSMT, FormatUtil.nullToBlank(grossCargo));
					mapParam.put(EshippingInstructionDao.P_I_V.CARRIER_SEAL, FormatUtil.nullToBlank(carrierSeal));
					mapParam.put(EshippingInstructionDao.P_I_V.SHIPPER_SEAL, FormatUtil.nullToBlank(shipperSeal));
					mapParam.put(EshippingInstructionDao.P_I_V.NO_OF_PACKAGES, FormatUtil.nullToBlank(ofPackages));
					mapParam.put(EshippingInstructionDao.P_I_V.DN_PACKAGE_KIND_CODE,
							FormatUtil.nullToBlank(packageKindCode));
					mapParam.put(EshippingInstructionDao.P_I_V.PK_DTL_SEQNO, FormatUtil.nullToBlank(cntrSeq));
					mapParam.put(EshippingInstructionDao.P_I_V.FK_BKG_EQUIPM_DTL,
							FormatUtil.nullToBlank(fkEquipmentDetail));
					mapParam.put(EshippingInstructionDao.P_I_V.FK_BKG_SUPPLIER,
							FormatUtil.nullToBlank(fkBookingSupplier));
					mapParam.put(EshippingInstructionDao.P_I_V.FK_BKG_SIZE_TYPE_DTL,
							FormatUtil.nullToBlank(fkBookingSizeTypeDetail));
					// @01 BEGIN
					mapParam.put(EshippingInstructionDao.P_I_V.COMMODITY_CODE, strCommodity);
					// @01 END

					Map result = objDao.insertOrUpdateContainerDetail(mapParam);
					// Map result = new HashMap();
					String errDesc = (String) result.get(EshippingInstructionDao.P_O_V.ERR_DESC);

					System.out.println("[EshippingInstructionSvc][setParamsDetailsTmpForSave] errDesc :: " + errDesc);

					if (null != errDesc) {
						result.put(EshippingInstructionDao.P_O_V.ERR_DESC, errDesc);
						result.put(EshippingInstructionDao.KEY_IS_SUCCESS, Boolean.FALSE);
						return result;
					}
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			System.out.println("[EshippingInstructionSvc][setParamsDetailsTmpForSave][End]");
		}
		return mapParam;
	}

	/**
	 *
	 * This method for acknowledgement popup
	 *
	 * @exception BusinessException
	 *                and DataAccessException and Exception
	 * @param form
	 *            EshippingInstructionUim
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public String openAcknowledgementPopup(EshippingInstructionUim form, HttpServletRequest request) throws Exception {
		return SUCCESS;
	}
	// ==================================================
	//
	// ==================================================
	// ##05 BEGIN

	/**
	 *
	 * @param objForm
	 */
	public void getDefaultCargoDetailRow(EshippingInstructionUim objForm) {
		List<EshippingCommodityDetailsMod> lst = null;
		List<ComboVO> blTypeList = null;

		EshippingCommodityDetailsMod objVo = null;
		try {
			lst = new ArrayList<EshippingCommodityDetailsMod>();

			objVo = new EshippingCommodityDetailsMod();
			objVo.setStrCommCode(BLANK);
			objVo.setStrCommDesc(BLANK);
			objVo.setStrCommGroup(BLANK);
			objVo.setStrCommGroupCode(BLANK);
			// objVo.setIntCommGroupSeqNo(null);
			// @21 BEGIN
			objVo.setStrCommOfPackages("0");
			objVo.setStrCommPackageKindCode(BLANK);
			objVo.setStrCommWeight("0.000");
			objVo.setStrCommMeasurement("0.0000");
			// @21 END
			lst.add(objVo);

			blTypeList = objForm.getBlTypeValues();
			if (blTypeList == null || blTypeList.size() == 0) {
				blTypeList = ComboBoxESIUtil.getBLTypeDDList();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			objForm.setCommodityVoDataList(lst);
			objForm.setBlTypeValues(blTypeList);
		}
	} // getDefaultCargoDetailRow
		// ##05 END
		// @07 BEGIN

	// private void setShippmentDetails(EshippingInstructionUim formReceive,
	// EshippingInstructionUim formSend) throws Exception{
	// try{
	// if(formSend!=null&&formReceive!=null){
	// formReceive.setBookingNo(formSend.getBookingNo());
	// formReceive.setContact(formSend.getContact());
	// formReceive.setEmail(formSend.getEmail());
	// formReceive.setTelephone(formSend.getTelephone());
	// formReceive.setFax(formSend.getFax());
	// formReceive.setSiSubmittedBy(formSend.getSiSubmittedBy());
	// formReceive.setBlNumber(formSend.getBlNumber());
	// // formReceive.setStatus(formSend.getStatus());
	// formReceive.setBlType(formSend.getBlType());
	// formReceive.setAdditionalEmail(formSend.getAdditionalEmail());
	// formReceive.setNoOfOriginal(formSend.getNoOfOriginal());
	// formReceive.setRemarks(formSend.getRemarks());
	// formReceive.setChoiceRad(formSend.getChoiceRad());
	// // @18 BEGIN
	// formReceive.setEsiStatusCode(formSend.getEsiStatusCode());
	// formReceive.setEsiStatusDesc(formSend.getEsiStatusDesc());
	// // @18 END
	// }
	// } catch(Exception ex){
	// ex.printStackTrace();
	// }
	// }
	//
	// private void setContactDetails(EshippingInstructionUim formReceive,
	// EshippingInstructionUim formSend) throws Exception{
	// try{
	// // if(KEY_FLAG_SHIPPER.equals(rs.getString(6)))
	// // {
	// // System.out.println("KEY_FLAG_SHIPPER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	// formReceive.setShipperName(formSend.getShipperName());
	// formReceive.setShipperAddress1(formSend.getShipperAddress1());
	// formReceive.setShipperAddress2(formSend.getShipperAddress2());
	// formReceive.setShipperAddress3(formSend.getShipperAddress3());
	// formReceive.setShipperAddress4(formSend.getShipperAddress4());
	// formReceive.setShipperCode(formSend.getShipperCode());
	// // }
	// // else if(KEY_FLAG_CONSIGNEE.equals(rs.getString(6)))
	// // {
	// // System.out.println("KEY_FLAG_CONSIGNEE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	// formReceive.setConsigneeName(formSend.getConsigneeName());
	// formReceive.setConsigneeAddress1(formSend.getConsigneeAddress1());
	// formReceive.setConsigneeAddress2(formSend.getConsigneeAddress2());
	// formReceive.setConsigneeAddress3(formSend.getConsigneeAddress3());
	// formReceive.setConsigneeAddress4(formSend.getConsigneeAddress4());
	// formReceive.setConsigneeCode(formSend.getConsigneeCode());
	// // }
	// // else if(KEY_FLAG_NOTIFY_PART.equals(rs.getString(6)))
	// // {
	// // System.out.println("KEY_FLAG_NOTIFY_PART >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	// formReceive.setNotifyPartyName(formSend.getNotifyPartyName());
	// formReceive.setNotifyPartyAddress1(formSend.getNotifyPartyAddress1());
	// formReceive.setNotifyPartyAddress2(formSend.getNotifyPartyAddress2());
	// formReceive.setNotifyPartyAddress3(formSend.getNotifyPartyAddress3());
	// formReceive.setNotifyPartyAddress4(formSend.getNotifyPartyAddress4());
	// formReceive.setNotifyPartyCode(formSend.getNotifyPartyCode());
	// // }
	// } catch(Exception ex){
	// ex.printStackTrace();
	// }
	// }
	//
	// private void setRoutingDetails(EshippingInstructionUim formReceive,
	// EshippingInstructionUim formSend) throws Exception{
	// try{
	// formReceive.setVessel(formSend.getVessel());
	// formReceive.setVoyageNo(formSend.getVoyageNo());
	// formReceive.setShippedOnBoardDate(formSend.getShippedOnBoardDate());
	// formReceive.setPlaceDateOfIssue(formSend.getPlaceDateOfIssue());
	// formReceive.setPol(formSend.getPol());
	// formReceive.setPod(formSend.getPod());
	// formReceive.setPlaceOfReceipt(formSend.getPlaceOfReceipt());
	// formReceive.setPlaceOfDelivery(formSend.getPlaceOfDelivery());
	// formReceive.setFsc(formSend.getFsc());
	// formReceive.setPodCountry(formSend.getPodCountry());
	// } catch(Exception ex){
	// ex.printStackTrace();
	// }
	// }
	//
	// private void setEquipmentDetails(EshippingInstructionUim formReceive,
	// EshippingInstructionUim formSend) throws Exception{
	// List<EshippingCargoDescriptionMod> equipmentSendList = null;
	// List<EshippingCargoDescriptionMod> equipmentReceiveList = null;
	//
	// EshippingCargoDescriptionMod cargoDescReceive = null;
	// try{
	// equipmentReceiveList = new ArrayList<EshippingCargoDescriptionMod>();
	//
	// equipmentSendList = formSend.getCargoDescriptionDetails();
	// if(equipmentSendList!=null){
	// for(EshippingCargoDescriptionMod cargoDescSend: equipmentSendList){
	// cargoDescReceive = new EshippingCargoDescriptionMod();
	// cargoDescReceive.setContainerNo(cargoDescSend.getContainerNo());
	// cargoDescReceive.setContainerType(cargoDescSend.getContainerType());
	// cargoDescReceive.setCarrierSeal(cargoDescSend.getCarrierSeal());
	// cargoDescReceive.setShipperSeal(cargoDescSend.getShipperSeal());
	// cargoDescReceive.setOfPackages(cargoDescSend.getOfPackages());
	// cargoDescReceive.setPackagesKind(cargoDescSend.getPackagesKind());
	// cargoDescReceive.setPackagesKindCode(cargoDescSend.getPackagesKindCode());
	// cargoDescReceive.setGrossContainerWeight(cargoDescSend.getGrossContainerWeight());
	// cargoDescReceive.setGrossCargoMeasurement(cargoDescSend.getGrossCargoMeasurement());
	// cargoDescReceive.setLadenMt(cargoDescSend.getLadenMt());
	// cargoDescReceive.setSeqNo(cargoDescSend.getSeqNo());
	// cargoDescReceive.setDbFlag(cargoDescSend.getDbFlag());
	// cargoDescReceive.setStatusFlag(cargoDescSend.getStatusFlag());
	// cargoDescReceive.setOriginalSeqNo(cargoDescSend.getOriginalSeqNo());
	// cargoDescReceive.setCntrSeq(cargoDescSend.getCntrSeq());
	// cargoDescReceive.setContainerEqSize(cargoDescSend.getContainerEqSize());
	// cargoDescReceive.setContainerEqType(cargoDescSend.getContainerEqType());
	// cargoDescReceive.setFkEquipmentDetail(cargoDescSend.getFkEquipmentDetail());
	// cargoDescReceive.setFkBookingSupplier(cargoDescSend.getFkBookingSupplier());
	// cargoDescReceive.setFkBookingSizeTypeDetail(cargoDescSend.getFkBookingSizeTypeDetail());
	// //@01 BEGIN
	// cargoDescReceive.setCommodity(cargoDescSend.getCommodity());
	// cargoDescReceive.setStrCommodityName(cargoDescSend.getStrCommodityName());
	//
	// equipmentReceiveList.add(cargoDescReceive);
	// }
	// }
	// formReceive.setCargoDescriptionDetails(equipmentReceiveList);
	//
	// } catch(Exception ex){
	// ex.printStackTrace();
	// }
	// }

	private void setCommodityDetails(EshippingInstructionUim form, EshippingInstructionUim formSession)
			throws Exception {

		System.out.println("[EshippingInstructionSvc][setCommodityDetails][Begin]");

		List<EshippingCommodityDetailsMod> commoditySendList = null;
		EshippingCommodityDetailsMod commoditySend = null;
		String[] intCommGroupSeqNo = null;
		String[] strCommCode = null;
		String[] strCommGroupCode = null;
		String[] recordStatus = null;
		String[] strCommPackageKindCode = null;
		String[] marksAndNumbers = null;
		String[] description = null;
		String[] comBookingNo = null;
		String[] strCommodityForMark = null;
		String[] containerNoToCargo = null;
		String[] comSeqNo = null;
		String[] strCommGroup = null;
		String[] strCommDesc = null;
		String[] strCommOfPackages = null;
		String[] strCommPackageKindName = null;
		String[] strCommWeight = null;
		String[] strCommMeasurement = null;
		String strIntCommGroupSeqNo = null;

		try {
			if (request != null) {
				intCommGroupSeqNo = request.getParameterValues("intCommGroupSeqNo");
				strCommCode = request.getParameterValues("strCommCode");
				strCommGroupCode = request.getParameterValues("strCommGroupCode");
				recordStatus = request.getParameterValues("recordStatus");
				strCommPackageKindCode = request.getParameterValues("strCommPackageKindCode");
				marksAndNumbers = request.getParameterValues("marksAndNumbers");
				description = request.getParameterValues("description");
				comBookingNo = request.getParameterValues("comBookingNo");
				strCommodityForMark = request.getParameterValues("strCommodityForMark");
				containerNoToCargo = request.getParameterValues("containerNoToCargo");
				comSeqNo = request.getParameterValues("comSeqNo");
				strCommGroup = request.getParameterValues("strCommGroup");
				strCommDesc = request.getParameterValues("strCommDesc");
				strCommOfPackages = request.getParameterValues("strCommOfPackages");
				strCommPackageKindName = request.getParameterValues("strCommPackageKindName");
				strCommWeight = request.getParameterValues("strCommWeight");
				strCommMeasurement = request.getParameterValues("strCommMeasurement");

			}
			commoditySendList = formSession.getCommodityVoDataList();
			for (int i = 0; i < comSeqNo.length; i++) {
				for (int j = 0; j < commoditySendList.size(); j++) {
					commoditySend = commoditySendList.get(j);
					if (commoditySend.getComSeqNo().equals(comSeqNo[i])) {

						if (intCommGroupSeqNo[i].equals("")) {
							strIntCommGroupSeqNo = "0";
						} else {
							strIntCommGroupSeqNo = intCommGroupSeqNo[i];
						}

						commoditySend.setIntCommGroupSeqNo(Integer.parseInt(strIntCommGroupSeqNo));
						commoditySend.setStrCommCode(FormatUtil.nullToBlank(strCommCode[i]));
						commoditySend.setRecordStatus(FormatUtil.nullToBlank(recordStatus[i]));
						commoditySend.setStrCommPackageKindCode(FormatUtil.nullToBlank(strCommPackageKindCode[i]));
						commoditySend.setMarksAndNumbers(FormatUtil.nullToBlank(marksAndNumbers[i]));
						commoditySend.setDescription(FormatUtil.nullToBlank(description[i]));
						commoditySend.setComBookingNo(FormatUtil.nullToBlank(comBookingNo[i]));
						commoditySend.setStrCommodityForMark(FormatUtil.nullToBlank(strCommodityForMark[i]));
						commoditySend.setContainerNoToCargo(FormatUtil.nullToBlank(containerNoToCargo[i]));
						commoditySend.setComSeqNo(FormatUtil.nullToBlank(comSeqNo[i]));
						commoditySend.setStrCommGroup(FormatUtil.nullToBlank(strCommGroup[i]));
						commoditySend.setStrCommDesc(FormatUtil.nullToBlank(strCommDesc[i]));
						commoditySend.setStrCommOfPackages(FormatUtil.nullToBlank(strCommOfPackages[i]));
						commoditySend.setStrCommPackageKindName(FormatUtil.nullToBlank(strCommPackageKindName[i]));
						commoditySend.setStrCommWeight(FormatUtil.nullToBlank(strCommWeight[i]));
						commoditySend.setStrCommMeasurement(FormatUtil.nullToBlank(strCommMeasurement[i]));

					}
				}
			}
			form.setCommodityVoDataList(commoditySendList);

			// @23 BEGIN
			setComboBoxCommodity(form);
			// @23 END

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("[EshippingInstructionSvc][setCommodityDetails][End]");
		}
	}

	// private void setCommodityDetails(EshippingInstructionUim formReceive,
	// EshippingInstructionUim formSend, HttpServletRequest request) throws
	// Exception{
	//
	// System.out.println("[EshippingInstructionSvc][setCommodityDetails][Begin]");
	//
	// List<EshippingCommodityDetailsMod> commoditySendList = null;
	// List<EshippingCommodityDetailsMod> commodityReceiveList = null;
	// EshippingCommodityDetailsMod commoditySend = null;
	// EshippingCommodityDetailsMod commodityReceive = null;
	// //@10 BEGIN
	// String[] weightArr = null;
	// //@21 BEGIN
	// String[] ofPackageArr = null;
	// String[] packageKindCodeArr = null;
	// String[] packageKindNameArr = null;
	// String[] measurementArr = null;
	// boolean isNullRequest = true;
	// boolean isNullOfPackage = true;
	// boolean isNullPackageKindCode = true;
	// boolean isNullPackageKindName = true;
	// boolean isNullMeasurement = true;
	// //@21 END
	//
	// /*Begin @22*/
	// String[] marksAndNumbers = null;
	// String[] description = null;
	// String[] comBookingNo = null;
	// String[] strCommodityForMark = null;
	// String[] containerNoToCargo = null;
	// String[] comSeqNo = null;
	// String[] recordStatus = null;
	// boolean isNullMarksAndNumbers = true;
	// boolean isNullDescription = true;
	// boolean isNullComBookingNo = true;
	// boolean isNullStrCommodityForMark = true;
	// boolean isNullContainerNoToCargo = true;
	// boolean isNullcomSeqNo = true;
	// boolean isNullrecordStatus = true;
	// /*End @22*/
	//
	// try{
	// if(request != null){
	// weightArr = request.getParameterValues("strCommWeight");
	// if(weightArr != null){
	// isNullRequest = false;
	// }
	// ofPackageArr = request.getParameterValues("strCommOfPackages");
	// if(ofPackageArr != null){
	// isNullOfPackage = false;
	// }
	// packageKindCodeArr = request.getParameterValues("strCommPackageKindCode");
	// if(packageKindCodeArr != null){
	// isNullPackageKindCode = false;
	// }
	//
	// packageKindNameArr = request.getParameterValues("strCommPackageKindName");
	// System.out.println("packageKindNameArr::" + packageKindNameArr);
	// if(packageKindNameArr != null){
	// isNullPackageKindName = false;
	// }
	//
	// measurementArr = request.getParameterValues("strCommMeasurement");
	// if(measurementArr != null){
	// isNullMeasurement = false;
	// }
	//
	// /*Begin @22*/
	// marksAndNumbers = request.getParameterValues("marksAndNumbers");
	// description = request.getParameterValues("description");
	// comBookingNo = request.getParameterValues("comBookingNo");
	// strCommodityForMark = request.getParameterValues("strCommodityForMark");
	// containerNoToCargo = request.getParameterValues("containerNoToCargo");
	// comSeqNo = request.getParameterValues("comSeqNo");
	// recordStatus = request.getParameterValues("recordStatus");
	//
	// if(marksAndNumbers != null)isNullMarksAndNumbers = false;
	// if(description != null)isNullDescription = false;
	// if(comBookingNo != null)isNullComBookingNo = false;
	// if(strCommodityForMark != null)isNullStrCommodityForMark = false;
	// if(containerNoToCargo != null)isNullContainerNoToCargo = false;
	// if(comSeqNo != null)isNullcomSeqNo = false;
	// if(recordStatus != null)isNullrecordStatus = false;
	// /*End @22*/
	//
	// }
	// // @10 END
	// commodityReceiveList = new ArrayList<EshippingCommodityDetailsMod>();
	// commoditySendList = formSend.getCommodityVoDataList();
	//
	// if(!isNullcomSeqNo && commoditySendList!=null &&
	// !commoditySendList.isEmpty()){
	// for(int i=0;i<comSeqNo.length;i++){
	// System.out.println("[EshippingInstructionSvc][setCommodityDetails] comSeqNo
	// :: " + comSeqNo[i]);
	// for(int j=0; j<commoditySendList.size(); j++){
	// commoditySend = commoditySendList.get(j);
	// if(commoditySend.getComSeqNo().equals(comSeqNo[i])){
	// //@10 BEGIN
	// if(!isNullRequest) commoditySend.setStrCommWeight(weightArr[i]);
	// //@10 END
	// //@21 BEGIN
	// if(!isNullOfPackage) commoditySend.setStrCommOfPackages(ofPackageArr[i]);
	// if(!isNullPackageKindCode)
	// commoditySend.setStrCommPackageKindCode(packageKindCodeArr[i]);
	// if(!isNullPackageKindName)
	// commoditySend.setStrCommPackageKindName(packageKindNameArr[i]);
	// if(!isNullMeasurement)
	// commoditySend.setStrCommMeasurement(measurementArr[i]);
	// //@21 END
	// /*Begin @22*/
	// if(!isNullMarksAndNumbers)
	// commoditySend.setMarksAndNumbers(marksAndNumbers[i]);
	// if(!isNullDescription) commoditySend.setDescription(description[i]);
	// if(!isNullComBookingNo) commoditySend.setComBookingNo(comBookingNo[i]);
	// if(!isNullStrCommodityForMark)
	// commoditySend.setStrCommodityForMark(strCommodityForMark[i]);
	// if(!isNullContainerNoToCargo)
	// commoditySend.setContainerNoToCargo(containerNoToCargo[i]);
	// if(!isNullcomSeqNo) commoditySend.setComSeqNo(comSeqNo[i]);
	// if(!isNullrecordStatus) commoditySend.setRecordStatus(recordStatus[i]);
	// /*End @22*/
	// }
	// commodityReceive = new EshippingCommodityDetailsMod();
	// setCommodityDetailsMod(commodityReceive, commoditySend);
	// commodityReceiveList.add(commodityReceive);
	// }
	// }
	// }
	//
	//
	//// if(commoditySendList!=null&&!commoditySendList.isEmpty()){
	//// for(int countIndex = 0, size = commoditySendList.size(); countIndex<size;
	// countIndex++){
	//// commoditySend = commoditySendList.get(countIndex);
	//// if(!commoditySend.getRecordStatus().equals(EshippingInstructionDao.DEL_OPERATION)){
	//// //@10 BEGIN
	//// if(!isNullRequest)commoditySend.setStrCommWeight(weightArr[countIndex]);
	//// //@10 END
	//// //@21 BEGIN
	//// if(!isNullOfPackage)commoditySend.setStrCommOfPackages(ofPackageArr[countIndex]);
	//// if(!isNullPackageKindCode)commoditySend.setStrCommPackageKindCode(packageKindCodeArr[countIndex]);
	//// if(!isNullPackageKindName)commoditySend.setStrCommPackageKindName(packageKindNameArr[countIndex]);
	//// if(!isNullMeasurement)commoditySend.setStrCommMeasurement(measurementArr[countIndex]);
	//// //@21 END
	////
	//// /*Begin @22*/
	//// if(!isNullMarksAndNumbers)
	// commoditySend.setMarksAndNumbers(marksAndNumbers[countIndex]);
	//// if(!isNullDescription)
	// commoditySend.setDescription(description[countIndex]);
	//// if(!isNullComBookingNo)
	// commoditySend.setComBookingNo(comBookingNo[countIndex]);
	//// if(!isNullStrCommodityForMark)
	// commoditySend.setStrCommodityForMark(strCommodityForMark[countIndex]);
	//// if(!isNullContainerNoToCargo)
	// commoditySend.setContainerNoToCargo(containerNoToCargo[countIndex]);
	//// if(!isNullcomSeqNo) commoditySend.setComSeqNo(comSeqNo[countIndex]);
	//// if(!isNullrecordStatus)
	// commoditySend.setRecordStatus(recordStatus[countIndex]);
	//// /*End @22*/
	//// }
	//// commodityReceive = new EshippingCommodityDetailsMod();
	////
	//// setCommodityDetailsMod(commodityReceive, commoditySend);
	////
	//// commodityReceiveList.add(commodityReceive);
	//// }
	//// }
	// if(commodityReceiveList.isEmpty()){
	// commodityReceive = new EshippingCommodityDetailsMod();
	//
	// setCommodityDetailsMod(commodityReceive, null);
	//
	// commodityReceiveList.add(commodityReceive);
	// }
	//
	// formReceive.setCommodityVoDataList(commodityReceiveList);
	// } catch(Exception ex){
	// ex.printStackTrace();
	// }finally{
	// System.out.println("[EshippingInstructionSvc][setCommodityDetails][End]");
	// }
	// }

	// private void setCommodityDetailsMod(EshippingCommodityDetailsMod
	// commodityReceive, EshippingCommodityDetailsMod commoditySend) throws
	// Exception{
	// try{
	// if(commodityReceive!=null){
	// if(commoditySend==null){
	// commoditySend = new EshippingCommodityDetailsMod();
	// }
	// commodityReceive.setStrCommGroup(commoditySend.getStrCommGroup());
	// commodityReceive.setStrCommDesc(commoditySend.getStrCommDesc());
	// commodityReceive.setStrCommCode(commoditySend.getStrCommCode());
	// commodityReceive.setStrCommGroupCode(commoditySend.getStrCommGroupCode());
	// commodityReceive.setIntCommGroupSeqNo(commoditySend.getIntCommGroupSeqNo());
	// // @10 BEGIN
	// commodityReceive.setStrCommWeight(commoditySend.getStrCommWeight());
	// // @10 END
	// // @21 BEGIN
	// commodityReceive.setStrCommOfPackages(commoditySend.getStrCommOfPackages());
	// commodityReceive.setStrCommPackageKindCode(commoditySend.getStrCommPackageKindCode());
	// commodityReceive.setStrCommMeasurement(commoditySend.getStrCommMeasurement());
	// // @21 END
	//
	// /*Begin @22*/
	// commodityReceive.setMarksAndNumbers(commoditySend.getMarksAndNumbers());
	// commodityReceive.setDescription(commoditySend.getDescription());
	// commodityReceive.setComBookingNo(commoditySend.getComBookingNo());
	// commodityReceive.setStrCommodityForMark(commoditySend.getStrCommodityForMark());
	// commodityReceive.setContainerNoToCargo(commoditySend.getContainerNoToCargo());
	// commodityReceive.setComSeqNo(commoditySend.getComSeqNo());
	// commodityReceive.setRecordStatus(commoditySend.getRecordStatus());
	// /*End @22*/
	//
	// commodityReceive.setDeleted(commoditySend.isDeleted());
	// }
	// } catch(Exception ex){
	// ex.printStackTrace();
	// }
	// }
	// @07 END

	// private void setCommodityVoDataList(EshippingInstructionUim objForm,
	// EshippingInstructionUim objFormSession, HttpServletRequest request) throws
	// Exception{
	// System.out.println("[EshippingInstructionSvc][setCommodityVoDataList][Begin]");
	//
	// List<EshippingCommodityDetailsMod> commoditySessionList = null;
	// List<EshippingCommodityDetailsMod> commodityList = null;
	// EshippingCommodityDetailsMod commMod = null;
	// EshippingCommodityDetailsMod commSessionMod = null;
	// //@10 BEGIN
	// String[] weightArr = null;
	// boolean isNullWeight = false;
	// //@10 END
	// //@21 BEGIN
	// String[] ofPackageArr = null;
	// String[] packageKindCodeArr = null;
	// String[] measurementArr = null;
	// boolean isNullOfPackage = false;
	// boolean isNullPackageKindCode = false;
	// boolean isNullMeasurement = false;
	// //@21 END
	// /*Begin @22*/
	// String[] marksAndNumbers = null;
	// String[] description = null;
	// String[] comBookingNo = null;
	// String[] strCommodityForMark = null;
	// String[] containerNoToCargo = null;
	// String[] comSeqNo = null;
	// String[] recordStatus = null;
	// boolean isNullMarksAndNumbers = true;
	// boolean isNullDescription = true;
	// boolean isNullComBookingNo = true;
	// boolean isNullStrCommodityForMark = true;
	// boolean isNullContainerNoToCargo = true;
	// boolean isNullcomSeqNo = true;
	// boolean isNullrecordStatus = true;
	// /*End @22*/
	// int commoditySessionListSize = 0;
	// int commodityListSize = 0;
	//
	// try{
	// commoditySessionList = objFormSession.getCommodityVoDataList();
	// if(commoditySessionList==null){
	// objFormSession.setCommodityVoDataList(new
	// ArrayList<EshippingCommodityDetailsMod>());
	// commoditySessionList = objFormSession.getCommodityVoDataList();
	// }
	// commoditySessionListSize = commoditySessionList.size();
	//
	// commodityList = objForm.getCommodityVoDataList();
	// if(commodityList==null){
	// objForm.setCommodityVoDataList(new
	// ArrayList<EshippingCommodityDetailsMod>());
	// commodityList = objForm.getCommodityVoDataList();
	// }
	// commodityListSize = commodityList.size();
	//
	// setCommodityDetails(objForm, objFormSession, request);
	//
	//// if(commodityListSize>commoditySessionListSize){
	//// //@10 BEGIN
	//// weightArr = request.getParameterValues("strCommWeight");
	//// if(weightArr==null){
	//// isNullWeight = true;
	//// }
	//// //@10 END
	//// //@21 BEGIN
	//// measurementArr = request.getParameterValues("strCommOfPackages");
	//// if(measurementArr==null){
	//// isNullOfPackage = true;
	//// }
	//// measurementArr = request.getParameterValues("strCommPackageKindCode");
	//// if(measurementArr==null){
	//// isNullPackageKindCode = true;
	//// }
	//// measurementArr = request.getParameterValues("strCommMeasurement");
	//// if(measurementArr==null){
	//// isNullMeasurement = true;
	//// }
	//// //@21 END
	////
	//// /*Begin @22*/
	//// marksAndNumbers = request.getParameterValues("marksAndNumbers");
	//// description = request.getParameterValues("description");
	//// comBookingNo = request.getParameterValues("comBookingNo");
	//// strCommodityForMark = request.getParameterValues("strCommodityForMark");
	//// containerNoToCargo = request.getParameterValues("containerNoToCargo");
	//// comSeqNo = request.getParameterValues("comSeqNo");
	//// recordStatus = request.getParameterValues("recordStatus");
	////
	//// if(marksAndNumbers != null)isNullMarksAndNumbers = false;
	//// if(description != null)isNullDescription = false;
	//// if(comBookingNo != null)isNullComBookingNo = false;
	//// if(strCommodityForMark != null)isNullStrCommodityForMark = false;
	//// if(containerNoToCargo != null)isNullContainerNoToCargo = false;
	//// if(comSeqNo != null)isNullcomSeqNo = false;
	//// if(recordStatus != null)isNullrecordStatus = false;
	//// /*End @22*/
	////
	//// for(int i=0;i<commodityListSize;i++){
	//// commMod = commodityList.get(i);
	//// if(i<commoditySessionListSize){
	////
	//// }
	//// }
	////
	//// for(int count = 0; count<commodityListSize; count++){
	//// commMod = commodityList.get(count);
	//// if(count<commoditySessionListSize){
	//// commSessionMod = commoditySessionList.get(count);
	//// if(!commSessionMod.getRecordStatus().equals(EshippingInstructionDao.DEL_OPERATION)){
	//// //@10 BEGIN
	//// if(!isNullWeight)commSessionMod.setStrCommWeight(weightArr[count]);
	//// //@10 END
	//// //@21 BEGIN
	//// if(!isNullOfPackage)commSessionMod.setStrCommOfPackages(ofPackageArr[count]);
	//// if(!isNullPackageKindCode)commSessionMod.setStrCommPackageKindCode(packageKindCodeArr[count]);
	//// if(!isNullMeasurement)commSessionMod.setStrCommMeasurement(measurementArr[count]);
	//// //@21 END
	////
	//// /*Begin @22*/
	//// if(!isNullMarksAndNumbers)
	// commSessionMod.setMarksAndNumbers(marksAndNumbers[count]);
	//// if(!isNullDescription) commSessionMod.setDescription(description[count]);
	//// if(!isNullComBookingNo)
	// commSessionMod.setComBookingNo(comBookingNo[count]);
	//// if(!isNullStrCommodityForMark)
	// commSessionMod.setStrCommodityForMark(strCommodityForMark[count]);
	//// if(!isNullContainerNoToCargo)
	// commSessionMod.setContainerNoToCargo(containerNoToCargo[count]);
	//// if(!isNullcomSeqNo) commSessionMod.setComSeqNo(comSeqNo[count]);
	//// if(!isNullrecordStatus)
	// commSessionMod.setRecordStatus(recordStatus[count]);
	//// /*End @22*/
	//// }
	//// setCommodityDetailsMod(commMod, commSessionMod);
	//// }
	//// }
	//// } else {
	//// setCommodityDetails(objForm, objFormSession, request);
	//// }
	// } catch(Exception ex){
	// throw ex;
	// }finally{
	// System.out.println("[EshippingInstructionSvc][setCommodityVoDataList][End]");
	// }
	// }
	// @11 END
	// @19 BEGIN

	private EshippingInstructionUim getForm(ActionForm actionForm, String pageAction) throws Exception {
		System.out.println("[EshippingInstructionSvc][getForm][Begin]");

		EshippingInstructionUim form = null;
		try {
			form = (EshippingInstructionUim) actionForm;

			System.out.println("[EshippingInstructionSvc][getForm] form :: " + form);
			System.out.println("[EshippingInstructionSvc][getForm] pageAction :: " + pageAction);

			if (form == null)
				form = new EshippingInstructionUim();
			if (ONLOAD.equals(pageAction))
				form.resetForm();

		} catch (Exception ex) {
			throw ex;
		} finally {
			System.out.println("[EshippingInstructionSvc][getForm][End]");
		}

		return form;
	}

	// private List<EshippingCargoDescriptionMod>
	// setEquipmentListFromPage(EshippingInstructionUim objForm) throws
	// BusinessException, DataAccessException, Exception{
	//
	// System.out.println("[setEquipmentListFromPage][Begin]");
	//
	// List equiptmentList = null;
	//
	// EshippingCargoDescriptionMod mod = null;
	//
	// String[] values = null;
	// String containerNo = null;
	// String carrierSeal = null;
	// String shipperSeal = null;
	// String statusFlag = null;
	// String[] cargoDetails = objForm.getCargoDetails();
	// try{
	// equiptmentList = new ArrayList<EshippingCargoDescriptionMod>();
	// for(String cargoDetail: cargoDetails){
	// if(!StringUtils.EMPTY.equals(cargoDetail)){
	// values = cargoDetail.split(objForm.getTextSeparate());
	//
	// containerNo = values[0];
	// if(NULL_DATA.equals(values[0])){
	// containerNo = StringUtils.EMPTY;
	// }
	// statusFlag = values[10];
	// if(NULL_DATA.equals(statusFlag)){
	// statusFlag = StringUtils.EMPTY;
	// }
	// carrierSeal = values[2];
	// if(NULL_DATA.equals(values[2])){
	// carrierSeal = StringUtils.EMPTY;
	// }
	// shipperSeal = values[3];
	// if(NULL_DATA.equals(values[3])){
	// shipperSeal = StringUtils.EMPTY;
	// }
	//
	// mod = new EshippingCargoDescriptionMod();
	// mod.setContainerNo(containerNo);
	// mod.setCarrierSeal(carrierSeal);
	// mod.setShipperSeal(shipperSeal);
	// mod.setStatusFlag(statusFlag);
	// mod.setOfPackages(values[4]);
	//
	// System.out.println("PackagesKind::" + values[5]);
	//
	// mod.setPackagesKind(values[5]);
	// mod.setGrossContainerWeight(values[6]);
	// mod.setLadenMt(values[7]);
	// mod.setGrossCargoMeasurement(values[8]);
	// mod.setDbFlag(values[9]);
	// mod.setOriginalSeqNo(values[11]);
	// mod.setContainerEqSize(values[12]);
	// mod.setContainerEqType(values[13]);
	// mod.setPackagesKindCode(values[14]);
	// mod.setCntrSeq(values[15]);
	// // mod.setSeqNo(Integer.parseInt(values[16]));
	// mod.setFkEquipmentDetail(values[17]);
	// mod.setFkBookingSupplier(values[18]);
	// mod.setFkBookingSizeTypeDetail(values[19]);
	// mod.setStrCommodityName(values[20]);
	//
	// equiptmentList.add(mod);
	// }
	// }
	// } catch(Exception ex){
	// throw ex;
	// }finally{
	// System.out.println("[setEquipmentListFromPage][End]");
	// }
	// return equiptmentList;
	// }

	private EshippingInstructionUim getSessionForm(HttpServletRequest request) throws Exception {
		EshippingInstructionUim form = null;
		try {
			form = (EshippingInstructionUim) request.getSession()
					.getAttribute(EshippingInstructionUim.FORM_BUFF_ESHHIPING_INSTRUCTION);
			if (form == null)
				form = new EshippingInstructionUim();
		} catch (Exception ex) {
			throw ex;
		}

		return form;
	}

	private void setSessionForm(HttpServletRequest request, EshippingInstructionUim form) throws Exception {
		try {
			request.getSession().setAttribute(EshippingInstructionUim.FORM_BUFF_ESHHIPING_INSTRUCTION, form);
		} catch (Exception ex) {
			throw ex;
		}
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

	private EshippingInstructionDao getDao() throws Exception {
		EshippingInstructionDao dao = null;
		try {
			dao = (EshippingInstructionDao) getDao(EshippingInstructionDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}
		return dao;
	}

	// private EshippingCommodityPopupDao getCommodityDao() throws Exception{
	// EshippingCommodityPopupDao dao = null;
	// try{
	// dao = (EshippingCommodityPopupDao)
	// getDao(EshippingInstructionDao.DAO_NAME_COMMODITY);
	// } catch(Exception ex){
	// throw ex;
	// }
	// return dao;
	// }

	private void writeMSG(String msg) {
		PrintWriter print = null;
		try {
			response.setContentType("text/html");
			print = this.response.getWriter();
			print.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] getPDFData(EshippingInstructionUim form, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) {
		String forwardPage = FAILURE;
		EshippingInstructionUim objForm = null;
		EshippingInstructionDao objDao = null;
		String bookingNo = null;
		String bookingStatus = null;
		String modeGetData = null;
		Map mapParams = null;
		Map result = null;
		Boolean isLoadData = Boolean.FALSE;
		String esiStatusCode = null;
		String strMode = null;
		String blNo = null;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		try {
			objForm = (EshippingInstructionUim) form;
			objDao = getDao();
			objDao.getMailDtls(objForm, getUserID(request));
			bookingNo = objForm.getBookingNo();
			bookingStatus = objForm.getEsiStatusCode();
			modeGetData = objForm.getMode();
			mapParams = new HashMap();
			blNo = objForm.getBlNo();
			esiStatusCode = form.getEsiStatusCode();

			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] blNo   :: " + blNo);
			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] bookingNo     :: " + bookingNo);
			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] esiStatusCode     :: " + esiStatusCode);

			mapParams.put(EshippingInstructionDao.P_I_V.BL_NO, blNo);
			mapParams.put(EshippingInstructionDao.P_I_V.BKG_NO, bookingNo);

			strMode = convertStatus(esiStatusCode);

			mapParams.put(EshippingInstructionDao.P_I_V.STATUS, convertStatus(esiStatusCode));
			mapParams.put(EshippingInstructionDao.P_I_V.MODE, convertStatus(esiStatusCode));

			populateAllData(objForm, objDao, mapParams, request, true);
			objDao.getRatChargeDtls(objForm, mapParams);
			objDao.getSailingDate(objForm, mapParams);
			if(objForm.getVessel().equals("TBA")) {
				objDao.getFirstLegVesselDtl(objForm);	
			}
			 

			EshippingInstructionUim model = objForm;

			Document document = new Document();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + bookingNo + ".pdf");

			OutputStream out = response.getOutputStream();

			PdfWriter pdfWriter = PdfWriter.getInstance(document, out);
			PdfWriter pdfWriterMail = PdfWriter.getInstance(document, stream);

			document.open();
			HeaderFooterPageEvent event = new HeaderFooterPageEvent();
			pdfWriter.setPageEvent(event);
			List<ShippingPdfPrintVO> listOfItems = new ArrayList<>();
			// Start of Logic for page number

			int totalNumberOfRecord = 0;
			int currentContainIndex = 0;
			ShippingPdfPrintVO printVO;
			for (int i = 0; i < model.getCommodityVoDataList().size(); i++) {
				String containerNoDtls = "";
				String sizeTypeDtls = "";
				String cargoDescription = "";
				String markAndNo = "";
				List<String> list = new ArrayList<String>();
				markAndNo = ((model.getCommodityVoDataList().get(i).getMarksAndNumbers() == null
						|| "".equals(model.getCommodityVoDataList().get(i).getMarksAndNumbers())) ? ""
								: model.getCommodityVoDataList().get(i).getMarksAndNumbers());
				cargoDescription = cargoDescription + " "
						+ ((model.getCommodityVoDataList().get(i).getDescription() == null
								|| "".equals(model.getCommodityVoDataList().get(i).getDescription())) ? ""
										: model.getCommodityVoDataList().get(i).getDescription());
				for (int j = 0; j < model.getCargoDescriptionDetails().size(); j++) {
					if (model.getCommodityVoDataList().get(i).getStrCommCode()
							.equals(model.getCargoDescriptionDetails().get(j).getCommodity())) {
						if (containerNoDtls.equals("")) {
							containerNoDtls = ((model.getCargoDescriptionDetails().get(j).getContainerNo() == null
									|| "".equals(model.getCargoDescriptionDetails().get(j).getContainerNo())) ? "/"
											: model.getCargoDescriptionDetails().get(j).getContainerNo() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getCarrierSeal() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getCarrierSeal()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getCarrierSeal() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqSize() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqSize()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqSize()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqType() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqType()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqType()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getOfPackages() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getOfPackages()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getOfPackages() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getPackagesKind() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getPackagesKind()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getPackagesKind()
															+ "\r\n");

						} else {

							containerNoDtls = containerNoDtls 
									+ ((model.getCargoDescriptionDetails().get(j).getContainerNo() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getContainerNo()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerNo() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getCarrierSeal() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getCarrierSeal()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getCarrierSeal() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqSize() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqSize()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqSize()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqType() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqType()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqType()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getOfPackages() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getOfPackages()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getOfPackages() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getPackagesKind() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getPackagesKind()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getPackagesKind()
															+ "\r\n");

						}

						String sizetupeTemp = model.getCargoDescriptionDetails().get(j).getContainerEqSize() + " "
								+ model.getCargoDescriptionDetails().get(j).getContainerEqType();
						list.add(sizetupeTemp);
					}
				}
				sizeTypeDtls = updateSizeType(list);
				sizeTypeDtls = sizeTypeDtls + "\r\n" 
						+ ((model.getCommodityVoDataList().get(i).getStrCommOfPackages() == null
								|| "".equals(model.getCommodityVoDataList().get(i).getStrCommOfPackages())
								|| "0".equals(model.getCommodityVoDataList().get(i).getStrCommOfPackages())) ? ""
										: model.getCommodityVoDataList().get(i).getStrCommOfPackages())
						+ " "
						+ ((model.getCommodityVoDataList().get(i).getStrCommPackageKindName() == null
								|| "".equals(model.getCommodityVoDataList().get(i).getStrCommPackageKindName())) ? ""
										: model.getCommodityVoDataList().get(i).getStrCommPackageKindName()) +" (S)";

				printVO = new ShippingPdfPrintVO();
				printVO.setItem((i + 1) + ""); 
				//if("".equals(containerNoDtls)) {
				printVO.setContainerName( markAndNo.toUpperCase());
				//}//else {
				//printVO.setContainerName(containerNoDtls + markAndNo);
				//}
				printVO.setNoOfPackages(sizeTypeDtls);

				printVO.setWeight(((model.getCommodityVoDataList().get(i).getStrCommWeight() == null
						|| "".equals(model.getCommodityVoDataList().get(i).getStrCommWeight())) ? ""
								: model.getCommodityVoDataList().get(i).getStrCommWeight())
						+ "");
				printVO.setMeasurement((model.getCommodityVoDataList().get(i).getStrCommMeasurement() == null
						|| "".equals(model.getCommodityVoDataList().get(i).getStrCommMeasurement())) ? ""
								: model.getCommodityVoDataList().get(i).getStrCommMeasurement());
				listOfItems.add(printVO);

				if (cargoDescription.split("\r\n").length > 1) {
					 
					List<String> sizeTypeDtlsArray = Utilis.splitEqually(printVO.getNoOfPackages().replaceAll("\r\n", ""), 9);
					 
					int sizeTypeDtlsIndex=0;
					if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
						printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
					}
					
					// This Logic for Description
					String containerArray[]=printVO.getContainerName().split("\r\n"); 
					int containerNumber=0;
					 
					String desc = cargoDescription;
					List<String> arryCountTemp = Utilis.splitEquallyForDes(desc.trim(), 32);
					totalNumberOfRecord += arryCountTemp.size() ;
					String arry[]=new String[totalNumberOfRecord+1];
					 for (i = 0; i < arryCountTemp.size(); i++) {
						arry[i]=arryCountTemp.get(i);
						
					}
					 
					printVO.setDescription(arry[0]);
					 
					 
					if(containerNumber<containerArray.length)
					printVO.setContainerName(containerArray[containerNumber++]);
				 
					
					printVO.setRowSpan(arry.length);
					 
					for (int k = 1; k <  arry.length; k++) {
						
						printVO = new ShippingPdfPrintVO();
						
						if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
							printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
						}
						
						 
							if(containerNumber<containerArray.length)
								printVO.setContainerName(containerArray[containerNumber++]);							
						
						
						if(arry[k]!=null) {	
							if ( arry[k].length() > 32) {
							} else {
								printVO.setDescription(arry[k]);
								 
							}
						}
						listOfItems.add(printVO);
					}
					// This if container size is less than descip
					if(totalNumberOfRecord<=containerArray.length)
					{
						totalNumberOfRecord=0;
					}
					for(;containerNumber<containerArray.length;containerNumber++) {
						printVO = new ShippingPdfPrintVO();
						printVO.setContainerName(containerArray[containerNumber]);	
						if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
							printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
						}
						listOfItems.add(printVO);
						if(totalNumberOfRecord<=containerArray.length)
								totalNumberOfRecord++;
					}
					
					for(;sizeTypeDtlsIndex<sizeTypeDtlsArray.size();sizeTypeDtlsIndex++) {
						printVO = new ShippingPdfPrintVO();						 
						if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
							printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
						}
						listOfItems.add(printVO);						 
					}
					
				} else {
					totalNumberOfRecord++;
					printVO.setDescription(cargoDescription);

				}
				printVO = new ShippingPdfPrintVO();
				printVO.setDescription("\n");
				listOfItems.add(printVO);
			}
			

			// Logic to caluclate pages
			totalNumberOfRecord=listOfItems.size();
			int numOfPages = totalNumberOfRecord / PDF_NUM_ROWS;
			if (totalNumberOfRecord % PDF_NUM_ROWS != 0) {
				numOfPages++;
			}
			// End of start of Page number

			for (int pages = 0; pages < numOfPages; pages++) {

				float fontSize = 8f;
				String fontName = FontFactory.TIMES;  //Calibri
				Font font = FontFactory.getFont("Calibri",fontName, fontSize);
				Font fontSmall = FontFactory.getFont("Calibri",fontName, 7f);
				document.open();

				PdfPTable table = new PdfPTable(2); // 3 columns.
				table.setWidthPercentage(100); // Width 100%
				// table.setSpacingBefore(10f); //Space before table
				// table.setSpacingAfter(10f); //Space after table

				// Set Column widths
				float[] columnWidths = { 1f, 1f };
				table.setWidths(columnWidths);

				// start of Shipper

				PdfPTable innterTable = new PdfPTable(2); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				PdfPCell cell1 = new PdfPCell(new Paragraph("Shipper Name", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);

				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Code " + ((model.getShipperCode() == null || "".equals(model.getShipperCode())) ? ""
								: model.getShipperCode()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getShipperName() == null || "".equals(model.getShipperName())) ? ""
								: model.getShipperName())
								+ "\r\n"
								+ ((model.getShipperAddress1() == null || "".equals(model.getShipperAddress1())) ? ""
										: model.getShipperAddress1())
								+ "\r\n"
								+ ((model.getShipperAddress2() == null || "".equals(model.getShipperAddress2())) ? ""
										: model.getShipperAddress2())
								+ "\r\n"
								+ ((model.getShipperAddress3() == null || "".equals(model.getShipperAddress3())) ? ""
										: model.getShipperAddress3())
								+ "\r\n"
								+ ((model.getShipperAddress4() == null || "".equals(model.getShipperAddress4())) ? ""
										: model.getShipperAddress4())
								+ "\r\n", font));
				cell1.setColspan(2);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				// end of shippr

				// start of ATTN
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("ATTN: Agents Of RCL Feeder PTE.,LTD", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Export Document - NGOW HOCK CO. LTD ", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Above represents the trade name", font));
				cell1.setColspan(1);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				// innterTable.addCell(cell1);

				table.addCell(innterTable);

				// End ATTN

				// start of Consifnee
				innterTable = new PdfPTable(2); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("Consignee (if 'Order' State Notify Party)", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Code " + ((model.getConsigneeCode() == null || "".equals(model.getConsigneeCode())) ? ""
								: model.getConsigneeCode()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getConsigneeName() == null || "".equals(model.getConsigneeName()))
								? ""
								: model.getConsigneeName())
								+ "\r\n"
								+ ((model.getConsigneeAddress1() == null || "".equals(model.getConsigneeAddress1()))
										? ""
										: model.getConsigneeAddress1())
								+ "\r\n"
								+ ((model.getConsigneeAddress2() == null || "".equals(model.getConsigneeAddress2()))
										? ""
										: model.getConsigneeAddress2())
								+ "\r\n"
								+ ((model.getConsigneeAddress3() == null || "".equals(model.getConsigneeAddress3()))
										? ""
										: model.getConsigneeAddress3())
								+ "\r\n"
								+ ((model.getConsigneeAddress4() == null || "".equals(model.getConsigneeAddress4()))
										? ""
										: model.getConsigneeAddress4())
								+ "\r\n", font));
				cell1.setColspan(2);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				// End Consine address

				// BKG NO: start
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("Above represents the trade name", font));
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				cell1.setBorder(Rectangle.NO_BORDER);
				innterTable.addCell(cell1);
				innterTable.getDefaultCell().setBorder(0);
				// innterTable.getDefaultCell().setRowspan(3);
				innterTable.getDefaultCell().setPaddingLeft(40);
				innterTable.getDefaultCell().setPaddingRight(40);
				innterTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1 = new PdfPCell(new Paragraph());
				cell1.setFixedHeight(20);
				cell1.setBorder(Rectangle.NO_BORDER);
				innterTable.addCell(cell1);

				PdfPTable table1 = new PdfPTable(1); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.setTotalWidth(100);

				cell1 = new PdfPCell(new Paragraph(
						"BKG NO : " + ((model.getBookingNo() == null || "".equals(model.getBookingNo())) ? ""
								: model.getBookingNo()),
						font));

				cell1.setBorder(Rectangle.BOX);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);
				innterTable.addCell(table1);

				cell1 = new PdfPCell(new Paragraph());
				cell1.setFixedHeight(20);
				cell1.setBorder(Rectangle.NO_BORDER);

				innterTable.addCell(cell1);

				table.addCell(innterTable);
				// end BKG NO:

				// start of Notify Party/Address
				innterTable = new PdfPTable(2); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("Notify Party/Address", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Code " + ((model.getNotifyPartyCode() == null || "".equals(model.getNotifyPartyCode())) ? ""
								: model.getNotifyPartyCode()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getNotifyPartyName() == null || "".equals(model.getNotifyPartyName()))
								? ""
								: model.getNotifyPartyName())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress1() == null || "".equals(model.getNotifyPartyAddress1()))
										? ""
										: model.getNotifyPartyAddress1())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress2() == null || "".equals(model.getNotifyPartyAddress2()))
										? ""
										: model.getNotifyPartyAddress2())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress3() == null || "".equals(model.getNotifyPartyAddress3()))
										? ""
										: model.getNotifyPartyAddress3())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress4() == null || "".equals(model.getNotifyPartyAddress4()))
										? ""
										: model.getNotifyPartyAddress4())
								+ "\r\n", font));
				cell1.setColspan(2);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				// End Notify Party/Address

				// start of Vessel
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				innterTable.getDefaultCell().setBorder(0);

				innterTable.getDefaultCell().setPaddingTop(40);
				innterTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

				table1 = new PdfPTable(2); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.getDefaultCell().setPadding(0);
				innterTable.setWidthPercentage(100);

				cell1 = new PdfPCell(new Paragraph("Vessel", font));
				cell1.setBorder(Rectangle.TOP);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Voyage No ", font));

				cell1.setBorder(Rectangle.TOP | Rectangle.LEFT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				if(!model.getVessel().equalsIgnoreCase("BARGE")) {
					cell1 = new PdfPCell(new Paragraph(
							((model.getVessel() == null || "".equals(model.getVessel())) ? "" : model.getVessel()), font));
				}else {
					cell1 = new PdfPCell(new Paragraph(
							((model.getVessel() == null || "".equals(model.getVessel())) ? "" : model.getVessel1()), font));	
				}
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);
				if(!model.getVoyageNo().equals("TBA")) {
				cell1 = new PdfPCell(new Paragraph(
						((model.getVoyageNo() == null || "".equals(model.getVoyageNo())) ? "" : model.getVoyageNo()),
						font));
				}else {
					cell1 = new PdfPCell(new Paragraph(
							((model.getVoyage1() == null || "".equals(model.getVoyage1())) ? "" : model.getVoyage1()),
							font));
				}
				cell1.setBorder(Rectangle.LEFT);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				innterTable.addCell(table1);
				table.addCell(innterTable);
				// end of Vessel

				// Port of Loading table

				table1 = new PdfPTable(2); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.getDefaultCell().setPadding(0);

				cell1 = new PdfPCell(new Paragraph("Port of Loading ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Port of Discharge ", font));

				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				// adding data of POL adnd POD

				cell1 = new PdfPCell(new Paragraph(
						((model.getPol() == null || "".equals(model.getPol())) ? "" : model.getPol()), font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						((model.getPod() == null || "".equals(model.getPod())) ? "" : model.getPod()), font));

				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				table.addCell(table1);

				// end of pol and pod table

				// start of Receipt heading
				table1 = new PdfPTable(2); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.getDefaultCell().setPadding(0);
				cell1 = new PdfPCell(new Paragraph("Place of Receipt (Applicable only when this\r\n"
						+ "document is used as a combined Transport\r\n" + "Bill of Lading) ", fontSmall));

				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Place of Delivery (Applicable only when \r\n"
						+ "this document is used as a combined \r\n" + "Transport Bill of Lading) ", fontSmall));

				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getPlaceOfReceipt() == null || "".equals(model.getPlaceOfReceipt())) ? ""
								: model.getPlaceOfReceipt()), font));

				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						((model.getPlaceOfDelivery() == null || "".equals(model.getPlaceOfDelivery())) ? ""
								: model.getPlaceOfDelivery()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				table.addCell(table1);
				document.add(table);
				// end of Receipt

				table = new PdfPTable(1); // 3 columns.
				table.setWidthPercentage(100); // Width 100%

				float[] columnWidthsCon = { 1.f };
				table.setWidths(columnWidthsCon);

				// start item table
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				innterTable.getDefaultCell().setBorder(0);

				table1 = new PdfPTable(6); // 3 columns.
				table1.getDefaultCell().setBorder(1);
				table1.getDefaultCell().setPadding(0);
				table1.setWidthPercentage(100);
				table1.setWidths(new int[] { 5, 35, 10, 30, 10, 10 });
				innterTable.addCell(table1);

				cell1 = new PdfPCell(new Paragraph("Item ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Container No./Seal No.\r\n" + "Marks & Numbers (For FCL must be stated) ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);
				cell1 = new PdfPCell(new Paragraph("No. of\r\n" + "Packages ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Description of Goods\r\n" + "Said To Contain ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Gross Weight\r\n" + "(Kgs) ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Measurement\r\n" + "(Cu. Metres) ", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				innterTable.addCell(table1);
				table.addCell(innterTable);
				document.add(table);
				// start loop
				// conain size

				table = new PdfPTable(1); // 3 columns.
				table.setWidthPercentage(100); // Width 100%

				float[] columnWidthsContion = { 1.f };
				table.setWidths(columnWidthsContion);

				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				innterTable.getDefaultCell().setBorder(0);

				table1 = new PdfPTable(6); // 3 columns.
				table1.getDefaultCell().setBorder(1);
				table1.getDefaultCell().setPadding(0);
				table1.setWidthPercentage(100);
				table1.setWidths(new int[] { 5, 35, 10, 30, 10, 10 });

				innterTable.addCell(table1);
				int sizeOfContainer = 0;

				// List<String> descriptionList=new LinkedList<String>();
				// for(int o=0;o<3;o++) {
				for (; currentContainIndex < listOfItems.size(); currentContainIndex++) {
					int i = currentContainIndex;
					sizeOfContainer++;
					if (sizeOfContainer >= PDF_NUM_ROWS) {
						break;
					}
					String containerNoDtls = listOfItems.get(currentContainIndex).getContainerName();
					String sizeTypeDtls = listOfItems.get(currentContainIndex).getNoOfPackages();
					String cargoDescription ="";
					if(!listOfItems.get(currentContainIndex).getDescription().equals("")) {
						cargoDescription = listOfItems.get(currentContainIndex).getDescription();
					}else {
						cargoDescription = "\r\n";
					}
					
					String weight = listOfItems.get(currentContainIndex).getWeight();
					String messuremnet = listOfItems.get(currentContainIndex).getMeasurement();

					cell1 = new PdfPCell(new Paragraph((listOfItems.get(currentContainIndex).getItem()) + "", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(containerNoDtls, font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(sizeTypeDtls, font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);

					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(cargoDescription.toUpperCase(), font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(weight + "", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(messuremnet, font));
					cell1.setBorder(Rectangle.NO_BORDER);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

				}
				// this For making page size full width
				boolean flag=false;
				for (int emptySize = sizeOfContainer; emptySize < PDF_NUM_ROWS; emptySize++) {
					flag=true;
					cell1 = new PdfPCell(new Paragraph("", font));

					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph("", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.NO_BORDER);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					
					

				}
				 
				// }

				innterTable.addCell(table1);
				table.addCell(innterTable);
				document.add(table);

				// Last part

				// Set Column widths
				float[] columnWidths1 = { 1.f, 1f, 1f };
				table = new PdfPTable(3); // 3 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setWidths(columnWidths1);
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%

				cell1 = new PdfPCell(new Paragraph("ABOVE PARTICULARS AS DECLARED BY SHIPPER", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%

				cell1 = new PdfPCell(new Paragraph(
						"Total No. of Pkgs/Cntrs " + model.getCargoDescriptionDetails().size() + "  CNTR", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setFixedHeight(30);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Shipped on Board Date   " + model.getSailinDate(), font));
				cell1.setFixedHeight(30);
				cell1.setBorder(Rectangle.BOTTOM | Rectangle.TOP);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Place & Date of Issue   " + model.getSailinDate() + "\r\n " + model.getPlaceDateOfIssue(),
						font));
				cell1.setFixedHeight(30);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(" ", font));
				cell1.setFixedHeight(30);
				cell1.setBorder(Rectangle.TOP);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%

				cell1 = new PdfPCell(new Paragraph(
						"FROM: " + "\r\n" + model.getCustomerCompany() + "/" + model.getCustomerName(), font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph("TEL" + ((model.getTelephone() == null || "".equals(model.getTelephone())) ? ""
								: model.getTelephone()), font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"FAX" + ((model.getFax() == null || "".equals(model.getFax())) ? "" : model.getFax()), font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Email " + ((model.getEmail() == null || "".equals(model.getEmail())) ? "" : model.getEmail()),
						font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				Phrase phrase = new Phrase("DRAFT/SHIPPING INSTRUCTION", new Font(FontFamily.COURIER, // Select the Font
						33, // Select the Font type of waterMark Text
						Font.BOLD, // Select the Font style of waterMark Text
						new BaseColor(233, 233, 233)));

				ColumnText.showTextAligned(pdfWriter.getDirectContentUnder(), Element.ALIGN_CENTER, // Keep waterMark
																									// center
						phrase, 300f, 330f, 360f);

				document.add(table);
				document.newPage();

			}
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		forwardPage = SUCCESS;

		return stream.toByteArray();
	}

	public byte[] priperPdfForMail(EshippingInstructionUim form, EshippingInstructionDao objDaoR,
			HttpServletRequest request) {
		EshippingInstructionUim objForm = null;
		EshippingInstructionDao objDao = objDaoR;
		String bookingNo = null;
		String bookingStatus = null;
		String modeGetData = null;
		Map mapParams = null;
		Map result = null;
		Boolean isLoadData = Boolean.FALSE;
		String esiStatusCode = null;
		String strMode = null;
		String blNo = null;
 

		try {
			objForm = (EshippingInstructionUim) form;
			objDao = getDao();
			objDao.getMailDtls(objForm, getUserID(request));
			bookingNo = objForm.getBookingNo();
			bookingStatus = objForm.getEsiStatusCode();
			modeGetData = objForm.getMode();
			mapParams = new HashMap();
			blNo = objForm.getBlNo();
			esiStatusCode = form.getEsiStatusCode();

			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] blNo   :: " + blNo);
			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] bookingNo     :: " + bookingNo);
			System.out.println("[EserviceInquiryWebBookingSvc][getWebBooking] esiStatusCode     :: " + esiStatusCode);

			mapParams.put(EshippingInstructionDao.P_I_V.BL_NO, blNo);
			mapParams.put(EshippingInstructionDao.P_I_V.BKG_NO, bookingNo);

			strMode = convertStatu(esiStatusCode);

			mapParams.put(EshippingInstructionDao.P_I_V.STATUS, convertStatu(esiStatusCode));
			mapParams.put(EshippingInstructionDao.P_I_V.MODE, convertStatu(esiStatusCode));

			populateAllData(objForm, objDao, mapParams, request, true);
			objDao.getRatChargeDtls(objForm, mapParams);
			objDao.getSailingDate(objForm, mapParams);

			EshippingInstructionUim model = objForm;

			Document document = new Document();

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, stream);
			document.open();
			HeaderFooterPageEvent event = new HeaderFooterPageEvent();
			pdfWriter.setPageEvent(event);

			List<ShippingPdfPrintVO> listOfItems = new ArrayList<>();
			// Start of Logic for page number

			int totalNumberOfRecord = 0;
			int currentContainIndex = 0;
			ShippingPdfPrintVO printVO;
			for (int i = 0; i < model.getCommodityVoDataList().size(); i++) {
				String containerNoDtls = "";
				String sizeTypeDtls = "";
				String cargoDescription = "";
				String markAndNo = "";
				List<String> list = new ArrayList<String>();
				markAndNo = ((model.getCommodityVoDataList().get(i).getMarksAndNumbers() == null
						|| "".equals(model.getCommodityVoDataList().get(i).getMarksAndNumbers())) ? ""
								: model.getCommodityVoDataList().get(i).getMarksAndNumbers());
				cargoDescription = cargoDescription + " "
						+ ((model.getCommodityVoDataList().get(i).getDescription() == null
								|| "".equals(model.getCommodityVoDataList().get(i).getDescription())) ? ""
										: model.getCommodityVoDataList().get(i).getDescription());
				for (int j = 0; j < model.getCargoDescriptionDetails().size(); j++) {
					if (model.getCommodityVoDataList().get(i).getStrCommCode()
							.equals(model.getCargoDescriptionDetails().get(j).getCommodity())) {
						if (containerNoDtls.equals("")) {
							containerNoDtls = ((model.getCargoDescriptionDetails().get(j).getContainerNo() == null
									|| "".equals(model.getCargoDescriptionDetails().get(j).getContainerNo())) ? "/"
											: model.getCargoDescriptionDetails().get(j).getContainerNo() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getCarrierSeal() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getCarrierSeal()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getCarrierSeal() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqSize() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqSize()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqSize()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqType() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqType()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqType()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getOfPackages() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getOfPackages()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getOfPackages() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getPackagesKind() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getPackagesKind()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getPackagesKind()
															+ "\r\n");

						} else {

							containerNoDtls = containerNoDtls
									+ ((model.getCargoDescriptionDetails().get(j).getContainerNo() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getContainerNo()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerNo() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getCarrierSeal() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getCarrierSeal()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getCarrierSeal() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqSize() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqSize()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqSize()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getContainerEqType() == null || ""
											.equals(model.getCargoDescriptionDetails().get(j).getContainerEqType()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getContainerEqType()
															+ "/")
									+ ((model.getCargoDescriptionDetails().get(j).getOfPackages() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getOfPackages()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getOfPackages() + "/")
									+ ((model.getCargoDescriptionDetails().get(j).getPackagesKind() == null
											|| "".equals(model.getCargoDescriptionDetails().get(j).getPackagesKind()))
													? "/"
													: model.getCargoDescriptionDetails().get(j).getPackagesKind()
															+ "\r\n");

						}

						String sizetupeTemp = model.getCargoDescriptionDetails().get(j).getContainerEqSize() + " "
								+ model.getCargoDescriptionDetails().get(j).getContainerEqType();
						list.add(sizetupeTemp);
					}
				}
				sizeTypeDtls = updateSizeType(list);
				sizeTypeDtls = sizeTypeDtls + "\r\n"
						+ ((model.getCommodityVoDataList().get(i).getStrCommOfPackages() == null
								|| "".equals(model.getCommodityVoDataList().get(i).getStrCommOfPackages())
								|| "0".equals(model.getCommodityVoDataList().get(i).getStrCommOfPackages())) ? ""
										: model.getCommodityVoDataList().get(i).getStrCommOfPackages())
						+ " "
						+ ((model.getCommodityVoDataList().get(i).getStrCommPackageKindName() == null
								|| "".equals(model.getCommodityVoDataList().get(i).getStrCommPackageKindName())) ? ""
										: model.getCommodityVoDataList().get(i).getStrCommPackageKindName() +" (S)");

				printVO = new ShippingPdfPrintVO();
				printVO.setItem((i + 1) + ""); 
				//if("".equals(containerNoDtls)) {
				printVO.setContainerName( markAndNo.toUpperCase());
				//}//else {
				//printVO.setContainerName(containerNoDtls + markAndNo);
				//}
				printVO.setNoOfPackages(sizeTypeDtls);

				printVO.setWeight(((model.getCommodityVoDataList().get(i).getStrCommWeight() == null
						|| "".equals(model.getCommodityVoDataList().get(i).getStrCommWeight())) ? ""
								: model.getCommodityVoDataList().get(i).getStrCommWeight())
						+ "");
				printVO.setMeasurement((model.getCommodityVoDataList().get(i).getStrCommMeasurement() == null
						|| "".equals(model.getCommodityVoDataList().get(i).getStrCommMeasurement())) ? ""
								: model.getCommodityVoDataList().get(i).getStrCommMeasurement());
				listOfItems.add(printVO);

				if (cargoDescription.split("\r\n").length > 1) {
					 
					List<String> sizeTypeDtlsArray = Utilis.splitEqually(printVO.getNoOfPackages().replaceAll("\r\n", "  "), 9);
					
					int sizeTypeDtlsIndex=0;
					if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
						printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
					}
					
					// This Logic for Description
					String containerArray[]=printVO.getContainerName().split("\r\n"); 
					int containerNumber=0;
					 
					String desc = cargoDescription;
					List<String> arryCountTemp = Utilis.splitEquallyForDes(desc.trim(), 32);
					totalNumberOfRecord += arryCountTemp.size() ;
					String arry[]=new String[totalNumberOfRecord+1];
					 for (i = 0; i < arryCountTemp.size(); i++) {
						arry[i]=arryCountTemp.get(i);
					}
					 
					printVO.setDescription(arry[0]);
					 
					 
					if(containerNumber<containerArray.length)
					printVO.setContainerName(containerArray[containerNumber++]);
				 
					
					printVO.setRowSpan(arry.length);
					 
					for (int k = 1; k <  arry.length; k++) {
						
						printVO = new ShippingPdfPrintVO();
						
						if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
							printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
						}
						
						 
							if(containerNumber<containerArray.length)
								printVO.setContainerName(containerArray[containerNumber++]);							
						
						
						if(arry[k]!=null) {	
							if ( arry[k].length() > 32) {
							} else {
								printVO.setDescription(arry[k]);
								 
							}
						}
						listOfItems.add(printVO);
					}
					// This if container size is less than descip
					if(totalNumberOfRecord<=containerArray.length)
					{
						totalNumberOfRecord=0;
					}
					for(;containerNumber<containerArray.length;containerNumber++) {
						printVO = new ShippingPdfPrintVO();
						printVO.setContainerName(containerArray[containerNumber]);	
						if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
							printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
						}
						listOfItems.add(printVO);
						if(totalNumberOfRecord<=containerArray.length)
								totalNumberOfRecord++;
					}
					
					for(;sizeTypeDtlsIndex<sizeTypeDtlsArray.size();sizeTypeDtlsIndex++) {
						printVO = new ShippingPdfPrintVO();						 
						if(sizeTypeDtlsIndex<sizeTypeDtlsArray.size()) {
							printVO.setNoOfPackages(sizeTypeDtlsArray.get(sizeTypeDtlsIndex++).trim());
						}
						listOfItems.add(printVO);						 
					}
					
				} else {
					totalNumberOfRecord++;
					printVO.setDescription(cargoDescription);

				}
				printVO = new ShippingPdfPrintVO();
				printVO.setDescription("\n");
				listOfItems.add(printVO);
			}
			

			// Logic to caluclate pages
			totalNumberOfRecord=listOfItems.size();			
			int numOfPages = totalNumberOfRecord / PDF_NUM_ROWS;
			if (totalNumberOfRecord % PDF_NUM_ROWS != 0) {
				numOfPages++;
			}
			// End of start of Page number

			for (int pages = 0; pages < numOfPages; pages++) {

				float fontSize = 8f;
				String fontName = FontFactory.TIMES;
				Font font = FontFactory.getFont("Calibri",fontName, fontSize);
				Font fontSmall = FontFactory.getFont("Calibri",fontName, 7f);
				document.open();

				PdfPTable table = new PdfPTable(2); // 3 columns.
				table.setWidthPercentage(100); // Width 100%
				// table.setSpacingBefore(10f); //Space before table
				// table.setSpacingAfter(10f); //Space after table

				// Set Column widths
				float[] columnWidths = { 1f, 1f };
				table.setWidths(columnWidths);

				// start of Shipper

				PdfPTable innterTable = new PdfPTable(2); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				PdfPCell cell1 = new PdfPCell(new Paragraph("Shipper Name", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);

				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Code " + ((model.getShipperCode() == null || "".equals(model.getShipperCode())) ? ""
								: model.getShipperCode()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getShipperName() == null || "".equals(model.getShipperName())) ? ""
								: model.getShipperName())
								+ "\r\n"
								+ ((model.getShipperAddress1() == null || "".equals(model.getShipperAddress1())) ? ""
										: model.getShipperAddress1())
								+ "\r\n"
								+ ((model.getShipperAddress2() == null || "".equals(model.getShipperAddress2())) ? ""
										: model.getShipperAddress2())
								+ "\r\n"
								+ ((model.getShipperAddress3() == null || "".equals(model.getShipperAddress3())) ? ""
										: model.getShipperAddress3())
								+ "\r\n"
								+ ((model.getShipperAddress4() == null || "".equals(model.getShipperAddress4())) ? ""
										: model.getShipperAddress4())
								+ "\r\n", font));
				cell1.setColspan(2);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				// end of shippr

				// start of ATTN
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("ATTN: Agents Of RCL Feeder PTE.,LTD", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Export Document - NGOW HOCK CO. LTD ", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Above represents the trade name", font));
				cell1.setColspan(1);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				// innterTable.addCell(cell1);

				table.addCell(innterTable);

				// End ATTN

				// start of Consifnee
				innterTable = new PdfPTable(2); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("Consignee (if 'Order' State Notify Party)", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Code " + ((model.getConsigneeCode() == null || "".equals(model.getConsigneeCode())) ? ""
								: model.getConsigneeCode()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getConsigneeName() == null || "".equals(model.getConsigneeName()))
								? ""
								: model.getConsigneeName())
								+ "\r\n"
								+ ((model.getConsigneeAddress1() == null || "".equals(model.getConsigneeAddress1()))
										? ""
										: model.getConsigneeAddress1())
								+ "\r\n"
								+ ((model.getConsigneeAddress2() == null || "".equals(model.getConsigneeAddress2()))
										? ""
										: model.getConsigneeAddress2())
								+ "\r\n"
								+ ((model.getConsigneeAddress3() == null || "".equals(model.getConsigneeAddress3()))
										? ""
										: model.getConsigneeAddress3())
								+ "\r\n"
								+ ((model.getConsigneeAddress4() == null || "".equals(model.getConsigneeAddress4()))
										? ""
										: model.getConsigneeAddress4())
								+ "\r\n", font));
				cell1.setColspan(2);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				// End Consine address

				// BKG NO: start
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("Above represents the trade name", font));
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				cell1.setBorder(Rectangle.NO_BORDER);
				innterTable.addCell(cell1);
				innterTable.getDefaultCell().setBorder(0);
				// innterTable.getDefaultCell().setRowspan(3);
				innterTable.getDefaultCell().setPaddingLeft(40);
				innterTable.getDefaultCell().setPaddingRight(40);
				innterTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1 = new PdfPCell(new Paragraph());
				cell1.setFixedHeight(20);
				cell1.setBorder(Rectangle.NO_BORDER);
				innterTable.addCell(cell1);

				PdfPTable table1 = new PdfPTable(1); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.setTotalWidth(100);

				cell1 = new PdfPCell(new Paragraph(
						"BKG NO : " + ((model.getBookingNo() == null || "".equals(model.getBookingNo())) ? ""
								: model.getBookingNo()),
						font));

				cell1.setBorder(Rectangle.BOX);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);
				innterTable.addCell(table1);

				cell1 = new PdfPCell(new Paragraph());
				cell1.setFixedHeight(20);
				cell1.setBorder(Rectangle.NO_BORDER);

				innterTable.addCell(cell1);

				table.addCell(innterTable);
				// end BKG NO:

				// start of Notify Party/Address
				innterTable = new PdfPTable(2); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				cell1 = new PdfPCell(new Paragraph("Notify Party/Address", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Code " + ((model.getNotifyPartyCode() == null || "".equals(model.getNotifyPartyCode())) ? ""
								: model.getNotifyPartyCode()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getNotifyPartyName() == null || "".equals(model.getNotifyPartyName()))
								? ""
								: model.getNotifyPartyName())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress1() == null || "".equals(model.getNotifyPartyAddress1()))
										? ""
										: model.getNotifyPartyAddress1())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress2() == null || "".equals(model.getNotifyPartyAddress2()))
										? ""
										: model.getNotifyPartyAddress2())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress3() == null || "".equals(model.getNotifyPartyAddress3()))
										? ""
										: model.getNotifyPartyAddress3())
								+ "\r\n"
								+ ((model.getNotifyPartyAddress4() == null || "".equals(model.getNotifyPartyAddress4()))
										? ""
										: model.getNotifyPartyAddress4())
								+ "\r\n", font));
				cell1.setColspan(2);
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				// End Notify Party/Address

				// start of Vessel
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				innterTable.getDefaultCell().setBorder(0);

				innterTable.getDefaultCell().setPaddingTop(40);
				innterTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

				table1 = new PdfPTable(2); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.getDefaultCell().setPadding(0);
				innterTable.setWidthPercentage(100);

				cell1 = new PdfPCell(new Paragraph("Vessel", font));
				cell1.setBorder(Rectangle.TOP);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Voyage No ", font));

				cell1.setBorder(Rectangle.TOP | Rectangle.LEFT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						((model.getVessel() == null || "".equals(model.getVessel())) ? "" : model.getVessel()), font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						((model.getVoyageNo() == null || "".equals(model.getVoyageNo())) ? "" : model.getVoyageNo()),
						font));

				cell1.setBorder(Rectangle.LEFT);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				innterTable.addCell(table1);
				table.addCell(innterTable);
				// end of Vessel

				// Port of Loading table

				table1 = new PdfPTable(2); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.getDefaultCell().setPadding(0);

				cell1 = new PdfPCell(new Paragraph("Port of Loading ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Port of Discharge ", font));

				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				// adding data of POL adnd POD

				cell1 = new PdfPCell(new Paragraph(
						((model.getPol() == null || "".equals(model.getPol())) ? "" : model.getPol()), font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						((model.getPod() == null || "".equals(model.getPod())) ? "" : model.getPod()), font));

				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				table.addCell(table1);

				// end of pol and pod table

				// start of Receipt heading
				table1 = new PdfPTable(2); // 3 columns.
				table1.getDefaultCell().setBorder(0);
				table1.getDefaultCell().setPadding(0);
				cell1 = new PdfPCell(new Paragraph("Place of Receipt (Applicable only when this\r\n"
						+ "document is used as a combined Transport\r\n" + "Bill of Lading) ", fontSmall));

				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Place of Delivery (Applicable only when \r\n"
						+ "this document is used as a combined \r\n" + "Transport Bill of Lading) ", fontSmall));

				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph(((model.getPlaceOfReceipt() == null || "".equals(model.getPlaceOfReceipt())) ? ""
								: model.getPlaceOfReceipt()), font));

				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						((model.getPlaceOfDelivery() == null || "".equals(model.getPlaceOfDelivery())) ? ""
								: model.getPlaceOfDelivery()),
						font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				table.addCell(table1);
				document.add(table);
				// end of Receipt

				table = new PdfPTable(1); // 3 columns.
				table.setWidthPercentage(100); // Width 100%

				float[] columnWidthsCon = { 1.f };
				table.setWidths(columnWidthsCon);

				// start item table
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				innterTable.getDefaultCell().setBorder(0);

				table1 = new PdfPTable(6); // 3 columns.
				table1.getDefaultCell().setBorder(1);
				table1.getDefaultCell().setPadding(0);
				table1.setWidthPercentage(100);
				table1.setWidths(new int[] { 5, 35, 10, 30, 10, 10 });
				innterTable.addCell(table1);

				cell1 = new PdfPCell(new Paragraph("Item ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Container No./Seal No.\r\n" + "Marks & Numbers (For FCL must be stated) ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);
				cell1 = new PdfPCell(new Paragraph("No. of\r\n" + "Packages ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Description of Goods\r\n" + "Said To Contain ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Gross Weight\r\n" + "(Kgs) ", font));
				cell1.setBorder(Rectangle.RIGHT);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Measurement\r\n" + "(Cu. Metres) ", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table1.addCell(cell1);

				innterTable.addCell(table1);
				table.addCell(innterTable);
				document.add(table);
				// start loop
				// conain size

				table = new PdfPTable(1); // 3 columns.
				table.setWidthPercentage(100); // Width 100%

				float[] columnWidthsContion = { 1.f };
				table.setWidths(columnWidthsContion);

				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%
				innterTable.getDefaultCell().setBorder(0);

				table1 = new PdfPTable(6); // 3 columns.
				table1.getDefaultCell().setBorder(1);
				table1.getDefaultCell().setPadding(0);
				table1.setWidthPercentage(100);
				table1.setWidths(new int[] { 5, 35, 10, 30, 10, 10 });

				innterTable.addCell(table1);
				int sizeOfContainer = 0;

				// List<String> descriptionList=new LinkedList<String>();
				// for(int o=0;o<3;o++) {
				for (; currentContainIndex < listOfItems.size(); currentContainIndex++) {
					int i = currentContainIndex;
					sizeOfContainer++;
					if (sizeOfContainer >= PDF_NUM_ROWS) {
						break;
					}
					String containerNoDtls = listOfItems.get(currentContainIndex).getContainerName();
					String sizeTypeDtls = listOfItems.get(currentContainIndex).getNoOfPackages();
					String cargoDescription ="";
					if(!listOfItems.get(currentContainIndex).getDescription().equals("")) {
						cargoDescription = listOfItems.get(currentContainIndex).getDescription();
					}else {
						cargoDescription = "\r\n";
					}
					
					String weight = listOfItems.get(currentContainIndex).getWeight();
					String messuremnet = listOfItems.get(currentContainIndex).getMeasurement();

					cell1 = new PdfPCell(new Paragraph((listOfItems.get(currentContainIndex).getItem()) + "", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(containerNoDtls, font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(sizeTypeDtls, font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);

					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(cargoDescription.toUpperCase(), font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

					cell1 = new PdfPCell(new Paragraph(weight + "", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(messuremnet, font));
					cell1.setBorder(Rectangle.NO_BORDER);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);

				}
				// this For making page size full width
				boolean flag=false;
				for (int emptySize = sizeOfContainer; emptySize < PDF_NUM_ROWS; emptySize++) {
					flag=true;
					cell1 = new PdfPCell(new Paragraph("", font));

					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph("", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.RIGHT);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					cell1 = new PdfPCell(new Paragraph(" ", font));
					cell1.setBorder(Rectangle.NO_BORDER);
					cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_TOP);
					table1.addCell(cell1);
					
					

				}
				if(flag && sizeOfContainer<10) {
						
					for(int p=0;p<6;p++) {
						cell1 = new PdfPCell(new Paragraph("", font));

						cell1.setBorder(Rectangle.RIGHT);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell1.setVerticalAlignment(Element.ALIGN_TOP);
						table1.addCell(cell1);
						cell1 = new PdfPCell(new Paragraph("", font));
						cell1.setBorder(Rectangle.RIGHT);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell1.setVerticalAlignment(Element.ALIGN_TOP);
						table1.addCell(cell1);
						cell1 = new PdfPCell(new Paragraph(" ", font));
						cell1.setBorder(Rectangle.RIGHT);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell1.setVerticalAlignment(Element.ALIGN_TOP);
						table1.addCell(cell1);
						cell1 = new PdfPCell(new Paragraph(" ", font));
						cell1.setBorder(Rectangle.RIGHT);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell1.setVerticalAlignment(Element.ALIGN_TOP);
						table1.addCell(cell1);
						cell1 = new PdfPCell(new Paragraph(" ", font));
						cell1.setBorder(Rectangle.RIGHT);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell1.setVerticalAlignment(Element.ALIGN_TOP);
						table1.addCell(cell1);
						cell1 = new PdfPCell(new Paragraph(" ", font));
						cell1.setBorder(Rectangle.NO_BORDER);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell1.setVerticalAlignment(Element.ALIGN_TOP);
						table1.addCell(cell1);
						
					}
				}
				// }

				innterTable.addCell(table1);
				table.addCell(innterTable);
				document.add(table);

				// Last part

				// Set Column widths
				float[] columnWidths1 = { 1.f, 1f, 1f };
				table = new PdfPTable(3); // 3 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setWidths(columnWidths1);
				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%

				cell1 = new PdfPCell(new Paragraph("ABOVE PARTICULARS AS DECLARED BY SHIPPER", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%

				cell1 = new PdfPCell(new Paragraph(
						"Total No. of Pkgs/Cntrs " + model.getCargoDescriptionDetails().size() + "  CNTR", font));
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setFixedHeight(30);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph("Shipped on Board Date   " + model.getSailinDate(), font));
				cell1.setFixedHeight(30);
				cell1.setBorder(Rectangle.BOTTOM | Rectangle.TOP);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Place & Date of Issue   " + model.getSailinDate() + "\r\n " + model.getPlaceDateOfIssue(),
						font));
				cell1.setFixedHeight(30);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(" ", font));
				cell1.setFixedHeight(30);
				cell1.setBorder(Rectangle.TOP);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				innterTable = new PdfPTable(1); // 3 columns.
				innterTable.setWidthPercentage(100); // Width 100%

				cell1 = new PdfPCell(new Paragraph(
						"FROM: " + "\r\n" + model.getCustomerCompany() + "/" + model.getCustomerName(), font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(
						new Paragraph("TEL" + ((model.getTelephone() == null || "".equals(model.getTelephone())) ? ""
								: model.getTelephone()), font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"FAX" + ((model.getFax() == null || "".equals(model.getFax())) ? "" : model.getFax()), font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				cell1 = new PdfPCell(new Paragraph(
						"Email " + ((model.getEmail() == null || "".equals(model.getEmail())) ? "" : model.getEmail()),
						font));
				cell1.setPaddingLeft(5);
				cell1.setPaddingTop(5);
				cell1.setBorder(Rectangle.NO_BORDER);
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_TOP);
				innterTable.addCell(cell1);

				table.addCell(innterTable);

				Phrase phrase = new Phrase("DRAFT/SHIPPING INSTRUCTION", new Font(FontFamily.COURIER, // Select the Font
						33, // Select the Font type of waterMark Text
						Font.BOLD, // Select the Font style of waterMark Text
						new BaseColor(233, 233, 233)));

				ColumnText.showTextAligned(pdfWriter.getDirectContentUnder(), Element.ALIGN_CENTER, // Keep waterMark
																									// center
						phrase, 300f, 330f, 360f);

				document.add(table);
				document.newPage();

			}


			document.close();
			return stream.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String updateSizeType(List<String> list) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		String sizeType = "";
		for (String sizeTypeTemp : list) {
			if (map.containsKey(sizeTypeTemp)) {
				map.put(sizeTypeTemp, map.get(sizeTypeTemp) + 1);
			} else {
				map.put(sizeTypeTemp, 1);
			}
		}

		Set<String> set = map.keySet();

		for (String string : set) {
			if (sizeType.equals(""))
				sizeType = sizeType + map.get(string) + " X " + string;
			else
				sizeType = sizeType + "\r\n" + map.get(string) + " X " + string;
		}

		return sizeType;

	}
	
	 public boolean checkBookingStatus(EshippingInstructionUim form,EshippingInstructionDao objDao)   {
	    	 
	    	boolean proced = objDao.checkBookingStatus(form.getBookingNo());
	    	
	    	return proced;
	    }
	
}


class HeaderFooterPageEvent extends PdfPageEventHelper {

   private int pageNumber=0;

    public void onEndPage(PdfWriter writer, Document document) {
    	pageNumber++;
       // ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("http://www.xxxx-your_example.com/"), 110, 30, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("Page " + pageNumber), 550, 30, 0);
    }

}