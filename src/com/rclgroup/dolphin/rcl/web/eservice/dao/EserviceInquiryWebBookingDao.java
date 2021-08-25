/* -----------------------------------------------------------------------------
System  : RCLEAPPS
Module  : Common
Prog ID : ESER008 - EserviceNewWebBookingDao.java
Name    : New Web Booking
Purpose : DAO Class for EserviceNewWebBookingDao Interface
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
NTL)Vikas         24/04/2013      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
## 19/08/2013          01          change package name
## 04/10/2013   PRATYA  02           Eservice phase 3.1
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;

/** 
 * Interface for DAO
 * @class EdlBulkUpdate
 * @author NTL) Vikas
 * @version v1.00 2013/04/26
 * @see
 */
public interface EserviceInquiryWebBookingDao 
{
// Package Store Procedure
    //@01 BEGIN
    public static final String SQL_GET_BOOKING_HEADER       = "PCR_ESV_WEB_BKG.PRR_ERCL_GET_BKG_HDR";
    public static final String SQL_GET_ROUNTING_DETAILS     = "PCR_ESV_WEB_BKG.PRR_ERCL_GET_BKG_ROUTING";
    public static final String SQL_GET_EQUIPMENT_DETAILS    = "PCR_ESV_WEB_BKG.PRR_ERCL_GET_BKG_SIZE_TYPE";
    public static final String SQL_GET_COMMODITY_DETAILS    = "PCR_ESV_WEB_BKG.PRR_ERCL_GET_BKG_COMMD";
    //@01 END
    
    /*Begin @02*/
    public static final String STYLE_BLUE                       = "m-btn smallest blue rnd smallericn-only";
    public static final String STYLE_GREEN                      = "m-btn smallest green rnd smallericn-only";
    public static final String KEY_MAPPER_CLASS                 = "KEY_MAPPER_CLASS";
    public static final String KEY_PROC_NAME                    = "KEY_PROC_NAME";
    public static final String KEY_PROC_PARAMS                  = "KEY_PROC_PARAMS";
    public static final String KEY_PROCE_EXCECTION_RESULT_MAP   = "KEY_PROCE_EXCECTION_RESULT_MAP";
    public static final String NEWLINE                          = "\n";
    /*End @02*/
    
    
    public static final String KYE_ERROR_CODE  ="p_i_v_error";
    public static final String KEY_REF_CURSOR_DATA = "P_O_V_HDR_DATA";
    public static final String KEY_DTL_CURSOR_DATA = "P_O_V_DTL_DATA";
    public static final String KEY_DATA         = "DATA";
    public static final String KEY_BOOKING_NO  = "p_i_v_bkg_no";
    public static final String KEY_BOOKING_REF  ="p_i_v_bkg_ref";
    public static final String KEY_BOOKING_STATUS= "piv_bkg_status";
    public static final String KEY_BL_NO  = "P_I_V_BL_NO";
    public static final String KEY_BOOKING_HEADER = "BOOKING_HEADER";
    public static final String KEY_CRITERIA_TEXT_FIND = "TEXT";
    public static final String KEY_CRITERIA_COLUMN = "COLUMN";
    public static final String KEY_CRITERIA_SORTBY = "SORTBY";
    public static final String KEY_CRITERIA_ORDER = "ORDER";
    public static final String KEY_CRITERIA_STATUS = "STATUS";
    public static final String KEY_CRITERIA_WILDCARD = "WILDCARD";
    public static final String KEY_CRITERIA_PAGE = "page";
    public static final String KEY_FROM_RECORD = "fromRecord";
    public static final String KEY_TO_RECORD = "toRecord";
    
    public static final String KEY_P_USER_ID = "P_I_V_USER_ID";
    
    public static final String KEY_DATA_WEBBOOKING = "webbooking";
    public static final String KEY_DATA_ESHIPPING = "eshipping";
    
//  Value of dropdown : [column] in jsp page
    public static final String KEY_COLUMN_BOOKING_DATE = "BABKDT";
    public static final String KEY_COLUMN_BOOKING_NO = "BABKNO";
    public static final String KEY_COLUMN_BOOKING_TYPE = "BOOKING_TYPE";
    public static final String KEY_COLUMN_POL = "BAPOL";
    public static final String KEY_COLUMN_POD = "BAPOD";
    public static final String KEY_COLUMN_BOOKING_STATUS = "BASTAT";
    public static final String KEY_COLUMN_ORDER_ASC = "asc";
    public static final String KEY_COLUMN_ORDER_DESC = "desc";
    
    public static final String KEY_COLUMN_OPEN = "O";
    public static final String KEY_COLUMN_CONFIRMED = "C";
    public static final String KEY_COLUMN_WASTLISTED = "W";
    public static final String KEY_COLUMN_CANCELLED = "N";
    public static final String KEY_COLUMN_REJECTED = "R";
    public static final String KEY_COLUMN_CLOSED = "L";
    public static final String KEY_COLUMN_PARTIAL = "P";
    public static final String KEY_COLUMN_COMPLETE = "L";
    
//  Column name dropdown : [column] & column name in jsp page
    public static final String KEY_COLUMN_SHOW_BOOKING_DATE = "Booking Date";
    public static final String KEY_COLUMN_SHOW_BOOKING_NO = "Booking No";
    public static final String KEY_COLUMN_SHOW_BOOKING_TYPE = "Booking Type";
    public static final String KEY_COLUMN_SHOW_POL = "POL";
    public static final String KEY_COLUMN_SHOW_POD = "POD";
    public static final String KEY_COLUMN_SHOW_STATUS = "Status";
    public static final String KEY_COLUMN_SHOW_BL_NO = "BL No";
    public static final String KEY_COLUMN_SHOW_BL_STATUS = "BL Status";
    public static final String KEY_COLUMN_SHOW_ORDER_ASC = "Ascending";
    public static final String KEY_COLUMN_SHOW_ORDER_DESC = "Descending";  
    
    public static final String KEY_COLUMN_SHOW_OPEN = "Open";
    public static final String KEY_COLUMN_SHOW_CONFIRMED = "Confirmed";
    public static final String KEY_COLUMN_SHOW_WASTLISTED = "Waitlisted";
    public static final String KEY_COLUMN_SHOW_CANCELLED = "Cancelled";
    public static final String KEY_COLUMN_SHOW_REJECTED = "Rejected";
    public static final String KEY_COLUMN_SHOW_CLOSED = "Closed";
    public static final String KEY_COLUMN_SHOW_PARTIAL = "Partial";
    public static final String KEY_COLUMN_SHOW_COMPLETE = "Completed";

    public int checkBookingNoAndStatus(Map amap);
    
    public void setBookingHeader(Map amap, EserviceInquiryWebBookingUim form) throws BusinessException, DataAccessException;
    
    public void setRoutingDetails(Map amap, EserviceInquiryWebBookingUim form) throws BusinessException, DataAccessException;
    
    public void setEquipmentDetails(Map amap, EserviceInquiryWebBookingUim form) throws BusinessException, DataAccessException;

    public void setCommodityDetails(Map amap, EserviceInquiryWebBookingUim form) throws BusinessException, DataAccessException;
    
    public Map getListWebBooking(Map amap) throws BusinessException, DataAccessException;    
    
    public Map getListWebBookingNew(Map amap) throws BusinessException, DataAccessException;
    
    public Map getBookingDtlsNew(Map amap) throws BusinessException, DataAccessException;
    
    public Map getBookingDtlsBtn(Map amap,EserviceInquiryWebBookingUim  	formObj ) throws BusinessException, DataAccessException;
    
    /*Begin @02*/
    public Hashtable getRateType() throws BusinessException, DataAccessException;
    public void setUploadListDetail(EserviceInquiryWebBookingUim form, EserviceUploadUim eserviceUploadUim)  throws BusinessException, DataAccessException;
    /*End @02*/

	public void getCustomerDtls(Map mapParams, EserviceInquiryWebBookingUim objForm) throws BusinessException, DataAccessException;

	public void setBookingHeaderNew(Map mapParams, EserviceInquiryWebBookingUim objForm)  throws BusinessException, DataAccessException;

	public void setRoutingDetailsNew(Map mapParams, EserviceInquiryWebBookingUim objForm) throws BusinessException, DataAccessException;

	public void setEquipmentDetailsNew(Map mapParams, EserviceInquiryWebBookingUim objForm) throws BusinessException, DataAccessException;

	public void setCommodityDetailsNew(Map mapParams, EserviceInquiryWebBookingUim objForm) throws BusinessException, DataAccessException;

	

	public Map getListOfTemplate(String id);

	public void deleteTemplate(EserviceInquiryWebBookingUim formObj);

	public void setRoutingDtls(Map mapParams, EserviceInquiryWebBookingUim fromObj); 

}
