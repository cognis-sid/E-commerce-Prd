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
## DD/MM/YY – User- -Task/CR No- -Short Description-
## 17/07/2013            01         add P_I_V_PLR and P_I_V_PLD
## 19/08/2013            02         change package name
## 18/09/2013            03         add P_I_V_MTY_PICKUP_DEP ,add proc PRR_ESV_VALIDATE
## 18/09/2013            04         add function getCheckPickUpDepot
## 01/08/2014 PRATHA1    05         Eservice phase 3.1
## 24/10/2014 PRATHA1    06         PD_CR_20140826_ESV [Contract Party for registeration]
## 27/10/2014 PRATHA1    07         PD_CR_20141003_ESV [COC_SOC in eBKG]
## 28/12/2015 Watchakorn 08         add PRE_GET_DESTINATION_COUNTRY_COMBO
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;
import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceDGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AutoCompleteVO;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.CustomerMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.TerminalMod;

/**
 * Interface for DAO
 * 
 * @class EserviceNewWebBookingDao
 * @author NTL) Vikas
 * @version v1.00 2013/04/26
 * @see
 */
public interface EserviceNewWebBookingDao {
	public static final String DAO_NAME = "EserviceNewWebBookingDao";
	public static final String EXCEPTION = "EXCEPTION";
	public static final String STYLE_BLUE = "m-btn smallest blue rnd smallericn-only";
	public static final String STYLE_GREEN = "m-btn smallest green rnd smallericn-only";

	public interface PCR_ESV_NEW_WEB_BOOKING {
		public final String PACKAGE_NAME = "PCR_ESV_NEW_WEB_BOOKING";

		public final String PRE_GET_QUOTATION_COMBO = PACKAGE_NAME + ".PRE_GET_QUOTATION_COMBO";
		public final String PRE_GET_SHIPMENT_TERM_COMBO = PACKAGE_NAME + ".PRE_GET_SHIPMENT_TERM_COMBO";
		public final String PRE_GET_ORIGIN_COUNTRY_COMBO = PACKAGE_NAME + ".PRE_GET_ORIGIN_COUNTRY_COMBO";
		public final String PRE_GET_PLACE_OF_RECEIPT = PACKAGE_NAME + ".PRE_GET_PLACE_OF_RECEIPT";
		public final String PRE_GET_PORT_OF_LOADING = PACKAGE_NAME + ".PRE_GET_PORT_OF_LOADING";
		public final String PRE_GET_EMPTY_PICKUP_DEPOT = PACKAGE_NAME + ".PRE_GET_EMPTY_PICKUP_DEPOT";
		public final String PRE_GET_ESERVICE_ONLOAD_DATA = PACKAGE_NAME + ".PRE_GET_ESERVICE_ONLOAD_DATA";
		public final String PRE_GET_TEMPLATE_COMBO_DATA = PACKAGE_NAME + ".PRE_GET_TEMPLATE_COMBO_DATA";
		public final String PRE_SAVE_BOOKING_DATA = PACKAGE_NAME + ".PRE_SAVE_BOOKING_DATA";
		public final String PRE_UPD_EQUIPMENT_DATA = PACKAGE_NAME + ".PRE_UPD_EQUIPMENT_DATA";
		public final String PRE_UPD_COMMODITY_DATA = PACKAGE_NAME + ".PRE_UPD_COMMODITY_DATA";
		public final String PRE_SAVE_EQUIPMENT_DATA = PACKAGE_NAME + ".PRE_SAVE_EQUIPMENT_DATA";
		public final String PRE_SAVE_COMMODITY_DATA = PACKAGE_NAME + ".PRE_SAVE_COMMODITY_DATA";
		public final String PRE_UPDATE_TEMPLATE = PACKAGE_NAME + ".PRE_UPDATE_TEMPLATE";
		public final String PRE_DEL_EQ_SIZE_TYPE = PACKAGE_NAME + ".PRE_DEL_EQ_SIZE_TYPE";
		public final String PRE_DEL_COMMODITY_DATA = PACKAGE_NAME + ".PRE_DEL_COMMODITY_DATA";

		// ##08 BEGIN
		public final String PRE_GET_DSTNTN_CNTRY_COMBO = PACKAGE_NAME + ".PRE_GET_DSTNTN_CNTRY_COMBO";
		public final String PRE_GET_PORT_OF_DISCHARGE = PACKAGE_NAME + ".PRE_GET_PORT_OF_DISCHARGE";
		// ##08 END
	}

	public interface PCR_ZCC_MAIN {
		public final String PACKAGE_NAME = "PCR_ZCC_MAIN";

		public final String PRR_GET_CODE_VALUE_LIST = PACKAGE_NAME + ".PRR_GET_CODE_VALUE_LIST";// @05
	}

	public interface PCR_ESV_WEB_BKG {
		public final String PACKAGE_NAME = "PCR_ESV_WEB_BKG";

		public final String PRR_ERCL_GET_BKG_SIZE_TYPE = PACKAGE_NAME + ".PRR_ERCL_GET_BKG_SIZE_TYPE";
		public final String PRR_ERCL_GET_BKG_COMMD = PACKAGE_NAME + ".PRR_ERCL_GET_BKG_COMMD";
		public final String PRR_ERCL_GET_QTN_INFO = PACKAGE_NAME + ".PRR_ERCL_GET_QTN_INFO";
		public final String PRR_ERCL_GET_BKG_HDR = PACKAGE_NAME + ".PRR_ERCL_GET_BKG_HDR";
		public final String PRR_ERCL_GET_LIST_QTN = PACKAGE_NAME + ".PRR_ERCL_GET_LIST_QTN";
		public final String PRR_ESV_VALIDATE = PACKAGE_NAME + ".PRR_ESV_VALIDATE";

		/* Begin @05 */
		public final String PRR_ESV_GET_BKG_RE_COMMD = PACKAGE_NAME + ".PRR_ESV_GET_BKG_RE_COMMD";
		public final String PRR_ESV_GET_BKG_DG_COMMD = PACKAGE_NAME + ".PRR_ESV_GET_BKG_DG_COMMD";
		public final String PRR_ESV_GET_BKG_OOG_COMMD = PACKAGE_NAME + ".PRR_ESV_GET_BKG_OOG_COMMD";
		/* End @05 */

		/* Begin @06 */
		public final String PRR_ERCL_GET_REP_COMP = PACKAGE_NAME + ".PRR_ERCL_GET_REP_COMP";
		/* End @06 */

		/* Begin @07 */
		public final String PRR_ERCL_GET_COC_SOC = PACKAGE_NAME + ".PRR_ERCL_GET_COC_SOC";
		/* End @07 */

	}

	public interface PCE_ENOTICE_WEB_BKG_SUBMISSION {
		public final String PACKAGE_NAME = "PCE_ENOTICE_WEB_BKG_SUBMISSION";
		public final String PPRE_RAISE_ENOTICE_WEB_BKG = PACKAGE_NAME + ".PPRE_RAISE_ENOTICE_WEB_BKG";
	}

	public interface P_I_V {
		public final String USER_ID = "P_I_V_USER_ID";
		public final String COUNTRY_CODE = "P_I_V_COUNTRY_CODE";
		public final String TEMPLATE_NAME = "P_I_V_TEMPLATE_NAME";
		public final String SHIPMENT_TERM = "P_I_V_SHIPMENT_TERM";
		public final String CUSTOMER_REF = "P_I_V_CUSTOMER_REF";
		public final String EMAIL = "P_I_V_EMAIL";
		public final String TELEPHONE = "P_I_V_TELEPHONE";
		public final String FAX = "P_I_V_FAX";
		public final String CONTACT = "P_I_V_CONTACT";
		public final String ADD_EMAIL_RECIPEINTS = "P_I_V_ADD_MAIL_RECIPEINTS";
		public final String ROUTING_REF = "P_I_V_ROUTING_REF";
		public final String SHIPMENT_DATE = "P_I_V_SHIPMENT_DATE";
		public final String BKG_NO = "P_I_V_BKG_NO";
		public final String BOOKING_NO = "P_I_V_BOOKING_NO";
		public final String SAVE_OPERATION_FLAG = "P_I_V_SAVE_OPERATION_FLAG";
		public final String LINE = "P_I_V_LINE";
		public final String TRADE = "P_I_V_TRADE";
		public final String AGENT = "P_I_V_AGENT";
		public final String CUST_CODE = "P_I_V_CUST_CODE";
		public final String WEIGHT_TYPE = "P_I_V_WEIGHT_TYPE";
		public final String POL_STATUS = "P_I_V_POL_STATUS";
		public final String POD_STATUS = "P_I_V_POD_STATUS";
		public final String QTN_NO = "P_I_V_QTN_NO";
		public final String PLR = "P_I_V_PLR";
		public final String PLD = "P_I_V_PLD";
		public final String EMPTY_PICKUP_DEP = "P_I_V_EMPTY_PICKUP_DEP";
		public final String EMPTY_PICKUP_DATE = "P_I_V_EMPTY_PICKUP_DATE";
		public final String SEQ = "P_I_V_SEQ";
		public final String EQ_TYPE = "P_I_V_EQ_TYPE";
		public final String EQ_SIZE = "P_I_V_EQ_SIZE";
		public final String CARGO_TYPE = "P_I_V_CARGO_TYPE";
		public final String QTY_LADEN = "P_I_V_QTY_LADEN";
		public final String QTY_MTY = "P_I_V_QTY_MTY";
		public final String GROSS_WEIGHT = "P_I_V_GROSS_WEIGHT";
		public final String SUM_GROSS_WEIGHT = "P_I_V_SUM_GROSS_WEIGHT";
		public final String QUOTATION_NUMBER = "P_I_V_QUOTATION_NUMBER";
		public final String PLACE_OF_RECEIPT = "P_I_V_PLACE_OF_RECEIPT";
		public final String PORT_OF_LOADING = "P_I_V_PORT_OF_LOADING";
		public final String PORT_OF_DISCHARGE = "P_I_V_PORT_OF_DISCHARGE";
		public final String PLACE_OF_DELIVERY = "P_I_V_PLACE_OF_DELIVERY";
		public final String DESIRED_ARRIVAL_DATE = "P_I_V_DESIRED_ARRIVAL_DATE";
		public final String CARGO_DESCRIPTION = "P_I_V_CARGO_DESCRIPTION";
		public final String SAILING_DATE = "P_I_V_SAILING_DATE";
		public final String COMMODITY_GROUP = "P_I_V_COMMODITY_GROUP";
		public final String SPECIAL_FLAG = "P_I_V_SPECIAL_FLAG";
		public final String SPECIAL_INSTRUCTION = "P_I_V_SPECIAL_INSTRUCTION";
		public final String SIZE = "P_I_V_SIZE";
		public final String TYPE = "P_I_V_TYPE";
		public final String QTN = "P_I_V_QTN";
		public final String POL = "P_I_V_POL";
		public final String POD = "P_I_V_POD";
		public final String MTY_PICKUP_DEP = "P_I_V_MTY_PICKUP_DEP";
		public final String ENOTICE_BKG_NO = "P_BKG_NO";

		/* Begin @05 */
		public final String P_I_MODULE = "P_I_MODULE";
		public final String P_I_TABLE_OWNER = "P_I_TABLE_OWNER";
		public final String P_I_TABLE_NAME = "P_I_TABLE_NAME";
		public final String P_I_TABLE_FIELD = "P_I_TABLE_FIELD";
		public final String P_I_CODE_VALUE = "P_I_CODE_VALUE";

		public final String RATE_TYPE = "P_I_V_RATE_TYPE";
		public final String RF_TEMP = "P_I_V_RF_TEMP";
		public final String RF_VENTILATION = "P_I_V_RF_VENTILATION";
		public final String RF_REMARK = "P_I_V_RF_REMARK";
		public final String RF_HUMIDITY = "P_I_V_RF_HUMIDITY";
		public final String RF_CON_ATM = "P_I_V_RF_CON_ATM";
		public final String RF_NITROGEN = "P_I_V_RF_NITROGEN";
		public final String RF_OXYGEN = "P_I_V_RF_OXYGEN";
		public final String RF_CO2 = "P_I_V_RF_CO2";
		public final String RF_REFR_MODE = "P_I_V_RF_REFR_MODE";
		public final String RF_PRE_COOL = "P_I_V_RF_PRE_COOL";
		public final String DG_FLASH_POINT = "P_I_V_DG_FLASH_POINT";
		public final String DG_UNIT = "P_I_V_DG_UNIT";
		public final String DG_UNNO = "P_I_V_DG_UNNO";
		public final String DG_VARINT = "P_I_V_DG_VARINT";
		public final String DG_IMDG = "P_I_V_DG_IMDG";
		public final String PORT_CLASS = "P_I_V_PORT_CLASS";
		public final String DG_RESIDUE = "P_I_V_DG_RESIDUE";
		public final String DG_FUMIGATION = "P_I_V_DG_FUMIGATION";
		public final String OOG_LENGTH = "P_I_V_OOG_LENGTH";
		public final String OOG_WIDTH = "P_I_V_OOG_WIDTH";
		public final String OOG_HEIGHT = "P_I_V_OOG_HEIGHT";
		public final String OOG_DIAMETER = "P_I_V_OOG_DIAMETER";
		public final String COMMD_SEQ = "P_I_V_COMMD_SEQ";
		/* End @05 */

		/* Begin @06 */
		public final String REP_FLAG = "P_I_V_REP_FLAG";
		public final String REP_CODE = "P_I_V_REP_CODE";
		/* End @06 */

		/* Begin @07 */
		public final String COC_SOC = "P_I_V_COC_SOC";
		/* End @07 */

		// public final String COUNTRY_CODE = "P_I_V_COUNTRY_CODE";
	}

	public interface P_O_V {
		public final String REF_CURSOR_DATA = "P_O_V_REF_CURSOR_DATA";
		public final String BOOKING_NO = "P_O_V_BOOKING_NO";
		public final String HDR_DATA = "P_O_V_HDR_DATA";
		public final String LINE = "P_O_V_LINE";
		public final String TRADE = "P_O_V_TRADE";
		public final String AGENT = "P_O_V_AGENT";
		public final String CUSTOMER_CODE = "P_O_V_CUSTOMER_CODE";
		public final String CUSTOMER_NAME = "P_O_V_CUSTOMER_NAME";
		public final String QTN_DATA = "P_O_V_QTN_DATA";
		public final String QTN_EXISTS = "P_O_V_QTN_EXISTS";
		public final String ERROR = "P_O_V_ERROR";
		public final String ERR_CD = "P_O_V_ERR_CD";
		public final String ERR_DESC = "P_O_V_ERR_DESC";

		/* Begin @05 */
		public final String P_O_RESULT_STATUS = "P_O_RESULT_STATUS";
		public final String P_O_RESULT_MESSAGE = "P_O_RESULT_MESSAGE";
		public final String P_O_RECORD_SET = "P_O_RECORD_SET";
		/* End @05 */

		/* Begin @06 */
		public final String REP_COMP = "P_O_V_REP_COMP";
		/* End @06 */

		/* Begin @07 */
		public final String COC_SOC = "P_O_V_COC_SOC";
		
		public final String SPECIAL_CARGO = "P_O_V_SPECIAL_CARGO";
		/* End @07 */

	}

	// ------------------------- constants declaration
	public static final String KEY_ORIGIN_COUNTRY_CODE = "KEY_ORIGIN_COUNTRY_CODE";
	public static final String KEY_DEST_COUNTRY_CODE = "KEY_DEST_COUNTRY_CODE";
	public static final String KEY_ORIGIN_MAP_CODE = "KEY_ORIGIN_MAP_CODE";
	public static final String KEY_DEST_MAP_CODE = "KEY_DEST_MAP_sCODE";
	public static final String KEY_DESTINATION_COUNTRY = "DESTINATION_COUNTRY";
	public static final String KEY_TEMPLATE = "TEMPLATE";
	public static final String KEY_MAPPER_CLASS = "KEY_MAPPER_CLASS";
	public static final String KEY_PROC_NAME = "KEY_PROC_NAME";
	public static final String KEY_PROC_PARAMS = "KEY_PROC_PARAMS";
	/* Begin @05 */
	public static final String RATE_TYPE = "RATE_TYPE";
	public static final String ERR_MSG = "ERR_MSG";
	/* End @05 */
	/* Begin @06 */
	public static final String REP_COMP = "REP_COMP";
	/* End @06 */
	/* Begin @07 */
	public static final String COC_SOC = "COC_SOC";
	public static final String SECIAL_CAERGO = "SECIAL_CAERGO";
	/* End @07 */
	public static final String KEY_PROCE_EXCECTION_RESULT_MAP = "KEY_PROCE_EXCECTION_RESULT_MAP";
	public static final String NEWLINE = "\n";
	public static final String KEY_QUOTATION = "QUOTATION";
	public static final String KEY_SHIPMENT_TERM = "SHIPMENT_TERM";
	public static final String KEY_ORIGIN_COUNTRY = "ORIGIN_COUNTRY";
	public static final String KEY_PLACE_OF_RECEIPT = "PLACE_OF_RECEIPT";
	public static final String KEY_PORT_OF_LOADING = "PORT_OF_LOADING";
	public static final String KEY_PORT_OF_DISCHARGE = "PORT_OF_DISCHARGE";
	public static final String KEY_PLACE_OF_DELIVERY = "PLACE_OF_DELIVERY";
	public static final String KEY_EMPTY_PICKUP_DEPT = "EMPTY_PICKUP_DEPT";

	public static final String KEY_HEADER_DATA = "KEY_HEADER_DATA";
	public static final String KEY_REF_PROC_DATA_OUT = "P_O_V_DTL_DATA";
	public static final String KEY_SIZE_TYPE_DATA = "KEY_SIZE_TYPE_DATA";
	public static final String KEY_COMMODITY_DATA = "KEY_COMMODITY_DATA";
	public static final String ADD_OPERATION = "ADD";
	public static final String UPD_OPERATION = "UPD";
	public static final String DEL_OPERATION = "DEL";
	public static final String SER_OPERATION = "SER";
	public static final String KEY_CODE = "CODE";
	public static final String KEY_NAME = "NAME";

	// -------------------------procedure parameter declaration

	// @03 BEGIN
	public static final String KEY_CHECK_PICKUP_DEPOT = "pickUpDepot";
	// @03 END
	// ------------------------- method declaration

	public Map onLoad(Map amapParam) throws BusinessException, DataAccessException;

	public Map getComboData(Map amap) throws BusinessException, DataAccessException;

	public Map getOnloadData(Map amap) throws BusinessException, DataAccessException;

	public Map getOnLoadDataForEditBooking(Map amap) throws BusinessException, DataAccessException;

	public Map saveBookingData(EserviceNewWebBookingUim obj) throws BusinessException, DataAccessException, Exception;

	public Map saveEquipmentDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws Exception;

	public Map saveCommodityDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException, Exception;

	// P
	public Map sendEnotice(String bookingNo) throws BusinessException, DataAccessException;

	public Map getTemplateOnloadData(String templateName, String userId) throws BusinessException, DataAccessException;

	public Map updateBookingData(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException;

	public Map updateEquipmentDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException;

	public Map updateCommodityDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException;

	public String getCustomerName(Map amap) throws BusinessException, DataAccessException;

	public Map deleleEqSizeType(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException;

	public Map deleleCommodity(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException;

	public Map getFSCDetails(Map amap) throws BusinessException, DataAccessException;

	// p
	public Map getCheckQuotationNo(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException;

	// p
	public Map findQuotationNoList(Map paramsMap) throws BusinessException, DataAccessException;

	/**
	 *
	 * This abstract method for get quotation information show in screen.
	 *
	 * @exception BusinessException
	 *                and DataAccessException
	 * @param map
	 *            List of parameters in
	 */
	public Map getQuotationInfo(Map map) throws BusinessException, DataAccessException;

	// @04 BEGIN
	/**
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getCheckPickUpDepot(Map amap) throws BusinessException, DataAccessException;

	// @04 END
	public Map getPlaceOfReceipt(Map amap) throws BusinessException, DataAccessException;

	public Map getPortOfLoading(Map amap) throws BusinessException, DataAccessException;

	public Map getPortOfDischarge(Map amap) throws BusinessException, DataAccessException;

	public Map getPlaceOfDelivery(Map amap) throws BusinessException, DataAccessException;

	public List getRefrMode() throws BusinessException, DataAccessException;

	public List getUnitMeasurementCombo() throws BusinessException, DataAccessException;

	/* Begin @05 */
	public String getConfigPath() throws BusinessException, DataAccessException;

	public Map saveUploadDocument(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException,Exception;

	public String getRfTypeNormal();

	public String validateDG(EserviceDGCommoditiesUim uim);
	/* End @05 */

	/* Begin @06 */
	public Map getRepresentComp(Map amapParam);

	/* Begin @07 */
	public List<ContryMod> getContry();

	public String getContryByContyCode(String code);

	public CustomerMod getCustomerDetailes(String code);

	public List<EserviceNewWebBookingMod> getQuotationComboDataNew(Map amapParam)
			throws BusinessException, DataAccessException;

	public void getEserviceNewWebBookingUim(Map map, EserviceNewWebBookingUim form);

	
	public void setEquipmentDetailsNew(Map mapParams, EserviceNewWebBookingUim objForm)	throws BusinessException, DataAccessException;
	public void setCommodityDetailsNew(Map mapParams, EserviceNewWebBookingUim objForm);
	
	public List getComboData(String comboName);
	
	public void cancelBooking(EserviceNewWebBookingUim form);

	public List<TerminalMod> getTeminal();

	public List<AutoCompleteVO> getPolList(String val);

	public String getCommodityCode(String group);
	public String getCommodityGroupCode(String group);
	public void  saveEquipmentBkgTable(List<EserviceEquipmentDetailsMod> equipmentDetailsList,String bookingNo);
	public String getUSerID(String bookingNo);

	public String getTerminalDes(String terminal);

	public String checkContaineAvailability(EserviceNewWebBookingUim actionForm);

	public String getRepresentCompName(String bookingNo);
	
	public String getBookingPatyCompName(String bookingNo);

	public String getPointByContyCode(String code);

	public Map getEmptyPickUpDepoData(String placeOfReceipt);

}
