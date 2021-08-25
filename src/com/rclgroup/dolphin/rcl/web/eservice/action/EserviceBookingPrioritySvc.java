/*------------------------------------------------------
EserviceBookingPrioritySvc.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Joga 06/05/21
---------------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.io.File;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePolPodPriorityUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EBookingPolPodPriorityDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EBookingPriorityErrorMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePolPodPriorityMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PolPod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserAccountBeanNew;
import com.rclgroup.dolphin.rcl.web.util.ExcelField;
import com.rclgroup.dolphin.rcl.web.util.ExcelUtil;

/**
 * @author JOGA
 *
 */
public class EserviceBookingPrioritySvc extends BaseAction {

	private static final String CRETAE_POLPOD = "createPolPod";
	private static final String DELETE_POLPOD = "deletePolPod";
	private static final String EDIT_POLPOD = "editpolpod";
	private static final String UPDATE_POLPOD = "updatepolpod";
	private static final String CREATE_EXCEL_TEMPLATE = "createExcelTemplate";
	private static final String CREATE_SEARCH = "createSearch";
	private static final String CHANGE_CREATE = "changeCreate";
	private static final String UPLOAD_EXCEL = "uploadExcel";
	
	private static final String DOWNLOAD_EXCEL = "downloadData";
	
	public static final String NO_WRITE_ACCESS = "noWriteAccess";


	/**
	 *
	 * Called from Action Servlet
	 *
	 * @param mapping    ActionMapping
	 * @param actionForm ActionForm
	 * @param request    HttpServletRequest
	 * @param response   HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) {
		EservicePolPodPriorityUim form = null;

		String pageAction = null;
		String forwardPage = null;
		try {
			pageAction = getPageAction(mapping);
			form = getForm(actionForm, pageAction);
			form.setCurrPageAction(pageAction);

			if ("onload".equals(pageAction)) {
				form.setFormName("load");
				forwardPage = initPolPodPriority(form, request);
			} else if (CRETAE_POLPOD.equals(pageAction)) {
				forwardPage = createPolPod(form, request);

			} else if (DELETE_POLPOD.equals(pageAction)) {
				forwardPage = deletePolPod(form, request);
			} else if (EDIT_POLPOD.equals(pageAction)) {
				forwardPage = onEditPolPod(form, request);
			} else if (UPDATE_POLPOD.equals(pageAction)) {
				forwardPage = updatepolpod(form, request);
			} else if (CREATE_EXCEL_TEMPLATE.equals(pageAction)) {
				forwardPage = createExcelTemplate(form, request, response);
			} else if (CREATE_SEARCH.equals(pageAction)) {
				forwardPage = searchedData(form, request);
			} else if (CHANGE_CREATE.equals(pageAction)) {
				forwardPage = changeAction(form, request);
			} else if (UPLOAD_EXCEL.equals(pageAction)) {
				forwardPage = uploadExcel(form, request, response);
			}
			else if (DOWNLOAD_EXCEL.equals(pageAction)) {
				 exportExcel(form, request, response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			if ((forwardPage == null) || ("".equals(forwardPage))) {
				forwardPage = "initPolPodPriority";
			}
		}

		return mapping.findForward(forwardPage);
	}

	public String changeAction(EservicePolPodPriorityUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][changeAction][Begin]");

		String forwardPage = FAILURE;
		try {
			System.out.println("selectAction" + form.getSelectAction());
			String selectAction = form.getSelectAction();

			form.resetForm();
			form.setTotRecord(0);
			form.setDisplayDetailList(new ArrayList());
			form.setSelectAction(selectAction);

			if (selectAction.equals("1")) {
				form.setPol("");
				form.setPod("");
				form.setPot1("");
				form.setService("");
				form.setVessel("");
				form.setVoyage("");
				form.setBsa("");
				form.setTs("");
				form.setEffDate("");
				form.setExpDate("");
			}

			request.getSession().setAttribute("esrvicePolPodPriorityUim", form);
			getPolPodPriority(request);

			forwardPage = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("[EserviceBookingPrioritySvc][changeAction][End]");
		}
		return forwardPage;

	}

	private EservicePolPodPriorityUim getForm(ActionForm actionForm, String pageAction) throws Exception {
		EservicePolPodPriorityUim form = null;
		try {
			form = (EservicePolPodPriorityUim) actionForm;
			if (form == null) {
				form = new EservicePolPodPriorityUim();
			} else if ("onload".equals(pageAction)) {
				form.resetForm();
			}
		} catch (Exception ex) {
			throw ex;
		}

		return form;
	}

	/**
	 *
	 * Intializing of form for pol/pod
	 *
	 * @param form    EservicePolPodPriorityUim
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	public String initPolPodPriority(EservicePolPodPriorityUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][initPolPodPriority][Begin]");
		boolean flag=false;
		
		UserAccountBeanNew account = (UserAccountBeanNew) request.getSession().getAttribute(USER_ACCOUNT_BEAN);

		 if(account.getLocation() == null || account.getLocation().equals("")) {
			 return NO_WRITE_ACCESS;
		 }
//		 else if(account.getLocation().equals("ALL")) {
//			 flag=true;
//		 }
//		 else if(!account.getLocation().contains(form.getPol()) && !flag) {
//			 request.setAttribute("access", "access");
//			 return NO_WRITE_ACCESS;
//		 }
		String forwardPage = SUCCESS;
		form.setSubmitStatus(false);
		EBookingPolPodPriorityDao dao = getDao();
		try {
			form.setContryList(dao.getCountryCodeNameList()); 
			if(form.isSubmitStatus()==false) {
				getPolPodPriority(request);
				
			}
			forwardPage = SUCCESS;
		} catch (Exception ex) {
			throw ex;
		} finally {
			System.out.println("[EserviceBookingPrioritySvc][initPolPodPriority][End]");
		}

		return forwardPage;
	}

	/**
	 *
	 * creation of pol/pod
	 *
	 * @param form    EservicePolPodPriorityUim
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	private String createPolPod(EservicePolPodPriorityUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][createPolPod][Begin]");
		
		//boolean flag=false;
			
			UserAccountBeanNew account = (UserAccountBeanNew) request.getSession().getAttribute(USER_ACCOUNT_BEAN);

			 if(account.getLocation() == null || account.getLocation().equals("")) {
				 return NO_WRITE_ACCESS;
			 }
//			 else if(account.getLocation().equals("ALL")) {
//				 flag=true;
//			 }
			 else if(!account.getLocation().contains(form.getPol())){// && !flag) {
				 request.setAttribute("access", "access");
				 return NO_WRITE_ACCESS;
			 }
		String forwardPage = SUCCESS;
		EBookingPolPodPriorityDao objDao;
		
		try {
			if (form.getPol().equals("") || form.getPod().equals("") || form.getService().equals("")
					|| form.getEffDate().equals("") || form.getExpDate().equals("")) {
				form.setErrorMessage("Please Insert Mandatory Fields.");
				form.setVessel("");
				form.setVoyage("");
				form.setPot1("");
				form.setEffDate("");
				form.setExpDate("");
				form.setTs("N");
				
			} else if(form.getPol().equalsIgnoreCase(form.getPod())){
				form.setErrorMessage("Cannot Insert data with same POL and POD");
//				form.setPol("");
//				form.setPod("");
//				form.setPot1("");
//				form.setService("");
//				form.setVessel("");
//				form.setVoyage("");
			}
			else {
				objDao = getDao();
				String returnData = objDao.insertPolPodPriority(form);
				form.setSelectAction("1");
				if (returnData.equalsIgnoreCase("Y")) {
					form.setErrorMessage("Data Already Exist.");
					form.setSubmitStatus(false);
					form.setPol("");
					form.setPod("");
					form.setPot1("");
					form.setService("");
					form.setVessel("");
					form.setVoyage("");
					form.setEffDate("");
					form.setExpDate("");
					form.setTs("N");
			
				} else {
					Map result = objDao.getAllPolPodPriority(form);
					List list = null;
					
					List lstTableData = null;
					
					if (result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE) != null) {
						request.setAttribute("polPodError",
								result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE).toString());
					} else {
						list = (List) result.get(EBookingPolPodPriorityDao.KEY_POL_POD_DATA);
					}

					if (null != list) {
						lstTableData = list;
					}

					if (null == lstTableData) {
						form.setTotRecord(0);
						form.setValues(new ArrayList());
						form.setErrorMessage(null);
					} else {
						form.setSearchPerformed("true");
						form.setValues(lstTableData);
						form.setErrorMessage(null);
					}
					request.setAttribute("listpolpod", form.getValues());
					form.setErrorMessage(null);
					form.setSubmitStatus(true);
					
					form.setPol("");
					form.setPod("");
					form.setPot1("");
					form.setService("");
					form.setVessel("");
					form.setVoyage("");
					form.setBsa("");
					form.setTs("");
					form.setEffDate("");
					form.setExpDate("");
					
					
				}
			}
			forwardPage = SUCCESS;
		} catch (Exception ex) {
			throw ex;
		} finally {
			System.out.println("[EserviceBookingPrioritySvc][createPolPod][End]");
		}
		return forwardPage;
	}

	/**
	 *
	 * creation of page
	 *
	 * @param ActionMapping mapping
	 * @throws Exception
	 */
	private String getPageAction(ActionMapping mapping) throws Exception {
		String pageAction = null;
		try {
			pageAction = mapping.getParameter();
		} catch (Exception ex) {
			pageAction = "";
		}

		return pageAction;
	}

	private EBookingPolPodPriorityDao getDao() throws Exception {
		EBookingPolPodPriorityDao dao = null;
		try {
			dao = (EBookingPolPodPriorityDao) getDao(EBookingPolPodPriorityDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}
		return dao;
	}

	/**
	 *
	 * result with all pol/pod
	 *
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	private void getPolPodPriority(HttpServletRequest request) throws Exception {

		List lstTableData = null;
		EBookingPolPodPriorityDao objDao = getDao();
		EservicePolPodPriorityUim objForm = new EservicePolPodPriorityUim();
		int intTotDBRec = 0;
		int intTotListRec = 0;

		Map result = objDao.getAllPolPodPriority();
		List list = null;
		if (result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE) != null) {
			request.setAttribute("polPodError",
					result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE).toString());
		} else {
			list = (List) result.get(EBookingPolPodPriorityDao.KEY_POL_POD_DATA);
		}

		if (null != list) {
			lstTableData = list;
		}

		if (null == lstTableData) {
			objForm.setTotRecord(0);
			objForm.setValues(new ArrayList());
			objForm.setErrorMessage(null);
		} else {
			objForm.setSearchPerformed("true");
			objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
			objForm.setValues(lstTableData);
			objForm.setDetailList(lstTableData);
			objForm.setErrorMessage(null);
		}
		objForm.setContryList(objDao.getCountryCodeNameList()); 

		request.setAttribute("listpolpod", objForm.getValues());

	}

	/**
	 *
	 * delete pol/pod EservicePolPodPriorityUim form
	 * 
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	private String deletePolPod(EservicePolPodPriorityUim form, HttpServletRequest request) {

		//boolean flag=false;
			
			UserAccountBeanNew account = (UserAccountBeanNew) request.getSession().getAttribute(USER_ACCOUNT_BEAN);

			 if(account.getLocation() == null || account.getLocation().equals("")) {
				 return NO_WRITE_ACCESS;
			 }
//			 else if(account.getLocation().equals("ALL")) {
//				 flag=true;
//			 }
			 else if(!account.getLocation().contains(form.getPol())) {// && !flag) {
				 request.setAttribute("access", "access");
				 return NO_WRITE_ACCESS;
			 }
			 
		String forwardPage = SUCCESS;
		try {
			EBookingPolPodPriorityDao objDao = getDao();
			objDao.deletePolPod(form);
			form.setSubmitStatus(false);
			getPolPodPriority(request);
			form.setPol("");
			form.setPod("");
			form.setService("");
			form.setEffDate("");
			form.setExpDate("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forwardPage;

	}

	/**
	 *
	 * edit pol/pod EservicePolPodPriorityUim form
	 * 
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	public String onEditPolPod(EservicePolPodPriorityUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][onEditPolPod][Begin]");

		String forwardPage = FAILURE;
		//boolean flag=false;
		try {
			
			UserAccountBeanNew account = (UserAccountBeanNew) request.getSession().getAttribute(USER_ACCOUNT_BEAN);

			 if(account.getLocation() == null || account.getLocation().equals("")) {
				 return NO_WRITE_ACCESS;
			 }
//			 else if(account.getLocation().equals("ALL")) {
//				 flag=true;
//			 }
			 else if(!account.getLocation().contains(form.getPol())) {// && !flag) {
				 request.setAttribute("access", "access");
				 return NO_WRITE_ACCESS;
			 }
			 
			EBookingPolPodPriorityDao objDao = getDao();
			EservicePolPodPriorityUim priorityMod = (EservicePolPodPriorityUim) objDao.getPodPolPriority(form);

			if (priorityMod != null) {
				form.setPol(priorityMod.getPol());
				form.setPod(priorityMod.getPod());
				form.setService(priorityMod.getService());
				form.setVessel(priorityMod.getVessel());
				form.setVoyage(priorityMod.getVoyage());
				// form.setBsa(priorityMod.getBsa());
				form.setPot1(priorityMod.getPot1());
				// form.setTs(priorityMod.getTs());
				form.setEffDate(priorityMod.getEffDate());
				form.setExpDate(priorityMod.getExpDate());
				form.setSubmitStatus(false);
				form.setFormName("edit");
				form.setContryList(objDao.getCountryCodeNameList()); 

				forwardPage = SUCCESS;
				request.setAttribute("edit", form.getFormName());
			} else
				forwardPage = FAILURE;

		} finally {
			System.out.println("[EserviceNewWebBookingSvc][onEditPolPod][End]");
		}
		return forwardPage;
	}

	/**
	 *
	 * update pol/pod EservicePolPodPriorityUim form
	 * 
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	public String updatepolpod(EservicePolPodPriorityUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][updatepolpod][Begin]");
		String forwardPage = SUCCESS;
		EBookingPolPodPriorityDao objDao = getDao();
		try {
			objDao.updatePolPodPriority(form);
			getPolPodPriority(request);
			form.resetForm();

		} finally {
			System.out.println("[EserviceBookingPrioritySvc][updatepolpod][End]");
		}
		return forwardPage;
	}

	/**
	 * search data EservicePolPodPriorityUim form
	 * 
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	public String searchedData(EservicePolPodPriorityUim objForm, HttpServletRequest request) throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][onCriteriaSearch][Begin]");
		List lstTableData = null;
		EBookingPolPodPriorityDao objDao = getDao();
		int intTotDBRec = 0;
		int intTotListRec = 0;
      //  boolean flag=false;
		String forwardPage = SUCCESS;
		try {

			
			UserAccountBeanNew account = (UserAccountBeanNew) request.getSession().getAttribute(USER_ACCOUNT_BEAN);

			 if(account.getLocation() == null || account.getLocation().equals("")) {
				 return NO_WRITE_ACCESS;
			 }
//			 else if(account.getLocation().equals("ALL")) {
//				 flag=true;
//			 }
			 else if(!account.getLocation().contains(objForm.getPol())) {// && !flag) {
				 request.setAttribute("access", "access");
				 return NO_WRITE_ACCESS;
			 }
	
			 
			Map result = objDao.getSearchData(objForm.getPol(), objForm.getPod(), objForm.getService());
			List list = null;
			if (result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE) != null) {
				request.setAttribute("polPodError",
						result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE).toString());
			} else {
				list = (List) result.get(EBookingPolPodPriorityDao.KEY_POL_POD_DATA);
			}

			if (null != list) {
				lstTableData = list;
			}

			if (null == lstTableData) {
				objForm.setTotRecord(0);
				objForm.setValues(new ArrayList());
				objForm.setErrorMessage(null);
			} else {
				objForm.setSearchPerformed("true");
				objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
				objForm.setValues(lstTableData);
				objForm.setDetailList(lstTableData);
				objForm.setErrorMessage(null);
			}
			objForm.setSubmitStatus(false);
			
			//List<ContryMod> code= objDao.getCountryCodeNameList(objForm.getPol(),objForm.getPod());
			
			
			objForm.setContryList(objDao.getCountryCodeNameList()); 
			request.setAttribute("listpolpod", objForm.getValues());
			//objForm.setPol("");
			//objForm.setPod("");
			objForm.setService("");
			objForm.setEffDate("");
			objForm.setExpDate("");
			request.setAttribute("search", "search");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceBookingPrioritySvc][onCriteriaSearch][End]");
		}

		return forwardPage;

	}

	public String uploadExcel(EservicePolPodPriorityUim form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][uploadExcel][Begin]");
		//boolean flag=false;
		
		UserAccountBeanNew account = (UserAccountBeanNew) request.getSession().getAttribute(USER_ACCOUNT_BEAN);

		 if(account.getLocation() == null || account.getLocation().equals("")) {
			 return NO_WRITE_ACCESS;
		 }
//		 else if(account.getLocation().equals("ALL")) {
//			 flag=true;
//		 }
			/*
			 * else if(!account.getLocation().contains(form.getPol())) {// && !flag) {
			 * request.setAttribute("access", "access"); return NO_WRITE_ACCESS; }
			 */
		String forwardPage = FAILURE;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String fileName = null;
		String newFileName = null;
		String[] fileTypeS = null;
		String fileType = null;
		int size = 0;
		long curr = System.currentTimeMillis();
		int totalSize = 0;
		int limitSize = 2048000;// 2 MB
		EservicePolPodPriorityUim polpodform = null;
		int newSeq = 0;
		FormFile dataFile = null;
		String sizeDisplay = null;
		int numberOfSheets = 0;
		Row[] rowArray = null;
		List errorList = new ArrayList();
		List detailList = new ArrayList();
		EBookingPolPodPriorityDao objDao = null;
		Map msgMap = null;
		try {
			System.out.println("[EserviceBookingPrioritySvc][uploadExcel] isMultipart :: " + isMultipart);
			objDao = getDao();
				if (isMultipart) {
					polpodform = form;
				dataFile = polpodform.getDataFile();

				System.out.println("[EserviceBookingPrioritySvc][uploadExcel] this.request :: " + request);
				System.out.println("[EserviceBookingPrioritySvc][uploadExcel] dataFile :: " + dataFile);

				if (dataFile != null) {
					fileName = new File(dataFile.getFileName()).getName();
					fileTypeS = fileName.split("\\.");
					fileType = fileTypeS[(fileTypeS.length - 1)];
					newFileName = String.valueOf(curr) + "." + fileType;
					size = dataFile.getFileSize();
//	                    totalSize                       = size + eserviceUploadUim.getTotalSize();
					sizeDisplay = String.valueOf(Math.round(size / 1000));

					System.out.println("EserviceBookingPrioritySvc][uploadExcel] fileName :: " + fileName);
					System.out.println("EserviceBookingPrioritySvc][uploadExcel] fileType :: " + fileType);
					System.out.println("EserviceBookingPrioritySvc][uploadExcel] size :: " + size);
					System.out.println("EserviceBookingPrioritySvc][uploadExcel] sizeDisplay :: " + sizeDisplay);
					System.out.println("EserviceBookingPrioritySvc][uploadExcel] totalSize :: " + totalSize);
					System.out.println("EserviceBookingPrioritySvc][uploadExcel] newFileName :: " + newFileName);
					System.out.println("EserviceBookingPrioritySvc][uploadExcel] seq :: " + newSeq);

					Workbook workbook = WorkbookFactory.create(dataFile.getInputStream());
					Sheet firstSheet = workbook.getSheetAt(0);
					rowArray = ExcelUtil.getAllRows_EX(firstSheet);
					System.out
							.println("EserviceBookingPrioritySvc][uploadExcel] rowArray.length :: " + rowArray.length);
					System.out.println(
							"EserviceBookingPrioritySvc][uploadExcel] workbook :: " + workbook.getNumberOfSheets());
					numberOfSheets = workbook.getNumberOfSheets();

					System.out.println("EserviceBookingPrioritySvc][uploadExcel] numberOfSheets :: " + numberOfSheets);
					int countBooking = 0;
					String returndata = null;
					String msg7;
					String msg8;
					for (int j = 0; j < rowArray.length; j++) {
						String msg1 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 0).getValue());
						String msg2 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 1).getValue());
						String msg3 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 2).getValue());
						String msg4 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 3).getValue());
						String msg5 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 4).getValue());
						String msg6 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 5).getValue());
						msg7 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 6).getValue());
						msg8 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 7).getValue());

						if (j == 1) {
							Row row1 = rowArray[1];
							Cell effdate = row1.getCell(6);
							msg7 = effdate.toString();
							Cell expdate = row1.getCell(7);
							msg8 = expdate.toString();

						}

						if (msg1.equals("Pol *") && msg2.equals("Pod *") && msg3.equals("Service *")
								&& msg4.equals("Pot1") && msg5.equals("Vessel") && msg6.equals("Voyage")
								&& msg7.equals("Effective *") && msg8.equals("Expired *")) {
							continue;
						}
						if (msg1.equals("") && msg2.equals("") && msg3.equals("") && msg4.equals("") && msg5.equals("")
								&& msg6.equals("") && msg7.equals("") && msg8.equals("")) {
							break;
						}
						form.setPol(msg1);
						form.setPod(msg2);
						form.setService(msg3);
						form.setPot1(msg4);
						form.setVessel(msg5);
						form.setVoyage(msg6);
						form.setEffDate(msg7);
						form.setExpDate(msg8);

						if (form.getPol().equals("") || form.getPod().equals("") || form.getService().equals("")
								|| form.getEffDate().equals("") || form.getExpDate().equals("")) {
							EBookingPriorityErrorMod bookingPriorityErrorMod = new EBookingPriorityErrorMod();
							bookingPriorityErrorMod
									.setErrorDesc("Please check excel upload and insert mandatory data fields.");
							errorList.add(bookingPriorityErrorMod);
						}else if(form.getPol().equalsIgnoreCase(form.getPod())){
							EBookingPriorityErrorMod bookingPriorityErrorMod = new EBookingPriorityErrorMod();
							bookingPriorityErrorMod.setErrorDesc("Cannot Insert data with same POL and POD");
							errorList.add(bookingPriorityErrorMod);
						}else {
							returndata = objDao.insertPolPodPriority(form);

							if (returndata.equalsIgnoreCase("Y")) {
								EBookingPriorityErrorMod bookingPriorityErrorMod = new EBookingPriorityErrorMod();
								bookingPriorityErrorMod
										.setErrorDesc("Upload cannot proceed due to Data Already Exist in System.");
								errorList.add(bookingPriorityErrorMod);
//	                                    	} 
							}
							countBooking++;
							System.out.println("countBooking >>>>>>>>>>>>>> " + countBooking);

						}
					}
				}

			}

			form.setErrorList(errorList);
			if (form.getErrorList().size() == 0) {
				form.setSelectAction("1");
				form.setPol("");
				form.setPod("");
				form.setPot1("");
				form.setService("");
				form.setVessel("");
				form.setVoyage("");
				form.setEffDate("");
				form.setExpDate("");
				getPolPodPriority(request);

			} else if (errorList != null) {
				if (errorList.size() == 0) {
					if (detailList != null) {
						form.setSearchPerformed("true");
						form.setTotRecord(getTotRec(-1, detailList.size()));
						form.setDetailList(detailList);

					}
				}
			}

			request.getSession().setAttribute("esrvicePolPodPriorityUim", form);
			forwardPage = SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceUploadSvc][uploadExcel][End]");
		}
		return forwardPage;
	}

	public static String getReportDate(HttpServletRequest request) {
		GregorianCalendar lobjCal = null;
		final DateFormat mobjRptDateFormat_ = new SimpleDateFormat("dd/MM/yyyy");
		String lstrReportDate = null;
		try {
			lobjCal = new GregorianCalendar(DEFAULT_LOCALE);
			lstrReportDate = mobjRptDateFormat_.format(lobjCal.getTime());
		} catch (Exception lobjEx) {
			lobjEx.printStackTrace();
		} finally {
			lobjCal = null;
		}

		return lstrReportDate;
	} // getReportDate

	public String createExcelTemplate(EservicePolPodPriorityUim form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("[EserviceBookingPrioritySvc][createExcelTemplate][Begin]");

		UserAccountBean account = null;
		Map mapParam = null;
		String originCountry = null;
		String forwardPage = FAILURE;

		EBookingPolPodPriorityDao objDao = getDao();

		try {
			String fileName;
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String fileDate = dateFormat.format(Calendar.getInstance().getTime());
			fileName = "Excel_Template_" + fileDate;

			String[] titles1 = { "Pol *", "Pod *", "Service *", "Pot1 ", "Vessel ", "Voyage ", "Effective *", "Expired *" };

			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet worksheet = workBook.createSheet("Template");

			Map<String, CellStyle> styles = createStyles(workBook);

			short shRow = 0;
			Row headerRow = worksheet.createRow(shRow);
			Cell headerCell;
			for (int i = 0; i < titles1.length; i++) {
				headerCell = headerRow.createCell(i);
				headerCell.setCellValue(titles1[i]);

				headerCell.setCellStyle(styles.get("header"));
			}

			Row detailRow = worksheet.createRow(shRow + 1);
			Cell detailCell;
			detailCell = detailRow.createCell(0);
			detailCell.setCellValue("");
			detailCell.setCellStyle(styles.get("cell_yellow"));

			detailCell = detailRow.createCell(1);
			detailCell.setCellStyle(styles.get("cell_yellow"));

			detailCell = detailRow.createCell(2);
			detailCell.setCellValue("");
			detailCell.setCellStyle(styles.get("cell_yellow"));

			detailCell = detailRow.createCell(3);
			detailCell.setCellStyle(styles.get("cell_gray"));

			detailCell = detailRow.createCell(4);
			detailCell.setCellValue("");
			detailCell.setCellStyle(styles.get("cell_gray"));

			detailCell = detailRow.createCell(5);
			detailCell.setCellValue("");
			detailCell.setCellStyle(styles.get("cell_gray"));

			detailCell = detailRow.createCell(6);
			detailCell.setCellValue(getReportDate(request));
			detailCell.setCellStyle(styles.get("cell_yellow"));

			detailCell = detailRow.createCell(7);
			detailCell.setCellValue(getReportDate(request));
			detailCell.setCellStyle(styles.get("cell_yellow"));


			headerRow = worksheet.createRow(shRow + 7);

			for (int i = 0; i < titles1.length; i++) {
				headerCell = headerRow.createCell(i);
				//headerCell.setCellStyle(styles.get("header"));
			}

			for (int i = 0; i < 9; i++) {
				worksheet.setColumnWidth(i, 13 * 256); // 13 characters wide
			}
			response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
			response.addHeader("Content-Type", "application/excel");
			OutputStream out = response.getOutputStream();
			workBook.write(out);
			out.flush();
			out.close();

			forwardPage = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("[EserviceBookingPrioritySvc][onLoad][End]");
		}
		return forwardPage;

	}

	private static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFont(titleFont);
		styles.put("title", style);

		Font monthFont = wb.createFont();
		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFont(monthFont);
		style.setWrapText(true);
		styles.put("header", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		styles.put("cell", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		styles.put("cell_common", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("cell_gray", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styles.put("cell_yellow", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
		styles.put("formula", style);

		style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
		styles.put("formula_2", style);

		return styles;
	}
	
	 private void downloadData(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException{
		 
			try {
				EBookingPolPodPriorityDao objDao = getDao();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        ResultSetMetaData metaData = result.getMetaData();
	        int numberOfColumns = metaData.getColumnCount();
	 
	        int rowCount = 1;
	 
	        while (result.next()) {
	            Row row = sheet.createRow(rowCount++);
	 
	            for (int i = 2; i <= numberOfColumns; i++) {
	                Object valueObject = result.getObject(i);
	 
	                Cell cell = row.createCell(i - 2);
	 
	                if (valueObject instanceof Boolean)
	                    cell.setCellValue((Boolean) valueObject);
	                else if (valueObject instanceof Double)
	                    cell.setCellValue((double) valueObject);
	                else if (valueObject instanceof Float)
	                    cell.setCellValue((float) valueObject);
	                else if (valueObject instanceof Date) {
	                    cell.setCellValue((Date) valueObject);
	                    formatDateCell(workbook, cell);
	                } else cell.setCellValue((String) valueObject);
	 
	            }
	 
	        }
	    }
	 
	 private void formatDateCell(XSSFWorkbook workbook, Cell cell) {
	        CellStyle cellStyle = workbook.createCellStyle();
	        CreationHelper creationHelper = workbook.getCreationHelper();
	        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
	        cell.setCellStyle(cellStyle);
	    }
	 
	 
	 public void exportExcel(EservicePolPodPriorityUim form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 EservicePolPodPriorityUim userForm = (EservicePolPodPriorityUim) form;
			EBookingPolPodPriorityDao objDao = getDao();

//			Map result = objDao.getAllPolPodPriority();
//			List list = null;
//			if (result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE) != null) {
//				request.setAttribute("polPodError",
//						result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE).toString());
//			} else {
//				list = (List) result.get(EBookingPolPodPriorityDao.KEY_POL_POD_DATA);
//			}
			
			
			Map result = objDao.getSearchData(userForm.getPol(), userForm.getPod(), userForm.getService());

			List list = null;
			if (result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE) != null) {
				request.setAttribute("polPodError",
						result.get(EBookingPolPodPriorityDao.KYE_POL_POD_ERROR_CODE).toString());
			} else {
				list = (List) result.get(EBookingPolPodPriorityDao.KEY_POL_POD_DATA);
			}

			if(list.size()>0) {
	        HSSFWorkbook workbook = createWorkbook(list);
			


	        response.setHeader("Content-disposition", "attachment;filename=" + "UserDetails" + ".xls");
			response.addHeader("Content-Type", "application/excel");
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
			}
			
	    }
	 
	 
	 public HSSFWorkbook createWorkbook(List userList) throws Exception {

	        HSSFWorkbook wb = new HSSFWorkbook();
	        HSSFSheet sheet = wb.createSheet("User Data");

	        /**
	         * Setting the width of the first three columns.
	         */
	        sheet.setColumnWidth(0, 13 * 256);
	        sheet.setColumnWidth(1, 13 * 256);
	        sheet.setColumnWidth(2, 13 * 256);
	        sheet.setColumnWidth(3, 13 * 256);
	        sheet.setColumnWidth(4, 13 * 256);
	        sheet.setColumnWidth(5, 13 * 256);
	        sheet.setColumnWidth(6, 13 * 256);
	        sheet.setColumnWidth(7, 13 * 256);
	        
	        try  {
	        	String[] titles1 = { "Pol", "Pod", "Service", "Pot1 ", "Vessel ", "Voyage ", "Effective", "Expired" };
	            // Header
	            Row headerRow = sheet.createRow(0);

	            for (int col = 0; col < titles1.length; col++) {
	              Cell cell = headerRow.createCell(col);
	              cell.setCellValue(titles1[col]);
	            }

	            int rowIdx = 1;
	            
	            for (int index = 0; index < userList.size(); index++) {
	            	
	               Row row = sheet.createRow(rowIdx++);

	              EservicePolPodPriorityMod userData = (EservicePolPodPriorityMod) userList.get(index);
		            
		            HSSFRichTextString pol = new HSSFRichTextString(userData.getPol());
		            row.createCell(0).setCellValue(pol);
		            
		            HSSFRichTextString pod = new HSSFRichTextString(userData.getPod());
		            row.createCell(1).setCellValue(pod);;
		            
		            HSSFRichTextString service = new HSSFRichTextString(userData.getService());
		            row.createCell(2).setCellValue(service);;
		            
		            HSSFRichTextString pot1 = new HSSFRichTextString(userData.getPot1());
		            row.createCell(3).setCellValue(pot1);
		            
		            HSSFRichTextString vessel = new HSSFRichTextString(userData.getVessel());
		            row.createCell(4).setCellValue(vessel);
		            
		            HSSFRichTextString voyage = new HSSFRichTextString(userData.getVoyage());
		            row.createCell(5).setCellValue(voyage);
		            
		            HSSFRichTextString effDate = new HSSFRichTextString(userData.getEffDate());
		            row.createCell(6).setCellValue(effDate);
		            
		            HSSFRichTextString expDate = new HSSFRichTextString(userData.getExpDate());
		            row.createCell(7).setCellValue(expDate); 
		            
		            
	            }
	        }catch (Exception e) {
	            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	        }
	        return wb;
	        }
	 
}
