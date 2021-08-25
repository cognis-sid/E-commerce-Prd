/* -----------------------------------------------------------------------------
 System  : RCLEAPPS
 Module  : Eservice
 Prog ID : ESER008 - EserviceNewWebBookingDaoImpl.java
 Name    : New Web Booking
 Purpose : DAO Class for EserviceNewWebBookingDao Interface
 --------------------------------------------------------------------------------
 History : None
 --------------------------------------------------------------------------------
 Author          Date            What
 --------------- --------------- ------------------------------------------------
 NTL)Vikas         24/04/2013      <Initial version>
 --Change Log--------------------------------------------------------------------
 ## DD/MM/YY User- -Task/CR No- -Short Description-
 ## 17/07/2013                         01           add P_I_V_PLR and P_I_V_PLD
 ## 19/07/2013       Teerakan  02           add  PLR  and ,  PLD  for set Default to Place of Receipt  and Place of Delivery
 ## 2/08/2013        TANA              03   change if emptyPickupDate is blank then use Cargo Availability Date
 ## 16/09/2013       TANA              04   add function checkDoubleValueNumber
 ## 20/09/2013       TANA              05   change format gross weight to show
 ## 01/08/2014       PRATHA1           06   Eservice phase 3.1
 ## 24/10/2014       PRATHA1           07   PD_CR_20140826_ESV [Contract Party for registeration]
 ## 27/10/2014       PRATHA1           08   PD_CR_20141003_ESV [COC_SOC in eBKG]
 ## 28/12/2015       Watchakorn        09   add filter for OriginCountry/DestinationCountry/pol/pod
 ----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.niit.control.common.ComboVO;
import com.niit.control.common.Debug;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.common.exception.ExceptionFactory;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.action.EservicePropertyFatchOperation;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceDGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceOOGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceReferCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AutoCompleteVO;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.CustomerMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.FtpConfig;
import com.rclgroup.dolphin.rcl.web.eservice.vo.TerminalMod;
import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;
import com.rclgroup.dolphin.rcl.web.procedure.PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER;
import com.rclgroup.dolphin.rcl.web.procedure.PPRR_ERCL_GET_SPECIAL_CARGO;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_DEL_COMMODITY_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_DEL_EQ_SIZE_TYPE;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_DSTNTN_CNTRY_COMBO;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_EMPTY_PICKUP_DEPOT;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_ESERVICE_ONLOAD_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_ORIGIN_COUNTRY_COMBO;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_PLACE_OF_RECEIPT;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_PORT_OF_DISCHARGE;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_PORT_OF_LOADING;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_QUOTATION_COMBO;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_SHIPMENT_TERM_COMBO;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_GET_TEMPLATE_COMBO_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_SAVE_BOOKING_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_SAVE_COMMODITY_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_SAVE_EQUIPMENT_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_UPDATE_TEMPLATE;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_UPD_COMMODITY_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRE_UPD_EQUIPMENT_DATA;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_COMMD;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_HDR;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_SIZE_TYPE;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_COC_SOC;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_QTN_INFO;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_REP_COMP;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_DG_VALIDATE;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_BKG_RE_COMMD;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_EQUIP_TYPE;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_RF_TYPE;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_INS_UPLOAD_DTL;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_INS_UPLOAD_HDR;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_GET_CODE_VALUE_LIST;
import com.rclgroup.dolphin.rcl.web.procedure.edit.booking.PRR_ERCL_GET_BKG_HDR_EDIT;

/**
 * Class for DAO
 * 
 * @class EserviceNewWebBookingDaoImpl
 * @author NTL) Vikas
 * @version v1.00 2013/04/29
 * @see
 */
public class EserviceNewWebBookingDaoImpl extends AncestorJdbcDao implements EserviceNewWebBookingDao {

	public EserviceNewWebBookingDaoImpl() {
	}

	/**
	 * Method called when page load
	 *
	 * @param amapParam
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map onLoad(Map amapParam) throws BusinessException, DataAccessException {
		return amapParam;
	}

	/**
	 * Method to populate combo data for Quotation Combo.
	 *
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getCarogoType(Map amapParam) throws BusinessException, DataAccessException {
		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = {
            {"P_O_V_DATA"                 , BLANK + ORACLE_CURSOR , PARAM_OUT , BLANK},
            {"P_I_V_COL_NAME"             , BLANK+ORACLE_VARCHAR  , PARAM_IN  , ""},
            {"P_I_V_COL_VAL"              , BLANK+ORACLE_VARCHAR  , PARAM_IN  , ""},
            {"P_I_V_SORT_BY"             , BLANK+ORACLE_VARCHAR  , PARAM_IN  , null},
            {"P_I_V_ORDER_BY"             , BLANK+ORACLE_VARCHAR  , PARAM_IN  , "asc"},
            {"P_I_V_WILD_CARD"            , BLANK+ORACLE_VARCHAR  , PARAM_IN  , "N"},
            {"P_I_V_KEY_SEARCH"            , BLANK+ORACLE_VARCHAR  , PARAM_IN , "N"}
        };
		// ----------------------- call action method to get combo data
		amapParam.put("CARGOTYPELIST", getComboDataFromDB(arrParam, "PCR_ESV_WEB_BKG.PRR_ESV_GET_EQUIP_TYPE"));

		// ---------------------- return map
		return amapParam;

	}
	public Map getQuotationComboData(Map amapParam) throws BusinessException, DataAccessException {
		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = {
				{ KEY_USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amapParam.get(P_I_V.USER_ID) },
				{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

		// ----------------------- call action method to get combo data
		amapParam.put(KEY_QUOTATION, getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_QUOTATION_COMBO));

		// ---------------------- return map
		return amapParam;

	} // getQuotationComboData

	/**
	 * Method to populate combo data for Shipment Term Combo.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getShipmentTermComboData(Map amap) throws BusinessException, DataAccessException {

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ P_O_V.ERROR, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

		// ----------------------- call action method to get combo data
		amap.put(KEY_SHIPMENT_TERM,
				getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_SHIPMENT_TERM_COMBO, false));

		// ---------------------- return map
		return amap;

	}

	public Map getOriginCountryData(Map amap) throws BusinessException, DataAccessException {
		// ##09 Begin
		System.out.println("[EserviceNewWebBookingDaoImpl][getOriginCountryData] REP_FLAG   :: "
				+ (String) amap.get(P_I_V.REP_FLAG));
		System.out.println("[EserviceNewWebBookingDaoImpl][getOriginCountryData] REP_CODE   :: "
				+ (String) amap.get(P_I_V.REP_CODE));
		System.out.println("[EserviceNewWebBookingDaoImpl][getOriginCountryData] USER_ID    :: "
				+ (String) amap.get(P_I_V.USER_ID));
		// ##09 End
		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_FLAG) },
				{ P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_CODE) },
				{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.USER_ID) },
				{ P_I_V.PORT_OF_LOADING, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POL") } };

		// ----------------------- call action method to get combo data
		amap.put(KEY_ORIGIN_COUNTRY,
				getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_ORIGIN_COUNTRY_COMBO));

		// amap.put(KEY_DESTINATION_COUNTRY, (List) amap.get(KEY_ORIGIN_COUNTRY));
		// --##09

		// ---------------------- return map
		return amap;
	}

	// ##09 BEGIN
	public Map getDestinationCountry(Map amap) throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getDestinationCountry] REP_FLAG   :: "
				+ (String) amap.get(P_I_V.REP_FLAG));
		System.out.println("[EserviceNewWebBookingDaoImpl][getDestinationCountry] REP_CODE   :: "
				+ (String) amap.get(P_I_V.REP_CODE));
		System.out.println("[EserviceNewWebBookingDaoImpl][getDestinationCountry] USER_ID    :: "
				+ (String) amap.get(P_I_V.USER_ID));

		String[][] arrParam = { { P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_FLAG) },
				{ P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_CODE) },
				{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.USER_ID) },
				{ P_I_V.PORT_OF_DISCHARGE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POD") } };

		amap.put(KEY_DESTINATION_COUNTRY,
				getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_DSTNTN_CNTRY_COMBO));

		return amap;
	}
	// ##09 End

	/* Begin @06 */
	public String getConfigPath() throws BusinessException, DataAccessException {
		SqlRowSet rowSet = null;
		StringBuffer sql = null;
		String configPath = BLANK;

		try {
			sql = new StringBuffer();
			sql.append("SELECT CONFIG_VALUE FROM VCM_CONFIG_MST WHERE CONFIG_TYP='ESV_UPLOAD_DIR'");

			rowSet = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(), new HashMap());
			while (rowSet.next()) {
				configPath = rowSet.getString("CONFIG_VALUE");
			}
		} catch (DataAccessException ex) {
			throw ex;
		}
		return configPath;
	}
	/* End @06 */

	/**
	 * Method to populate combo data for Place Of Receipt
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getPlaceOfReceipt(Map amap) throws BusinessException, DataAccessException {

		// --------------------variable declaration
		String originCountry;

		// --------------------check origin country value
		if ((amap.get(KEY_ORIGIN_MAP_CODE) == null)) {
			// ---------------------origin country not selected return blank cvombo
			List lst = new ArrayList(0);
			lst.add(0, new ComboVO(BLANK, SELECT_ONE));
			amap.put(KEY_PLACE_OF_RECEIPT, lst);
			return amap;
		}
		// --------------origin country selected populate plcace of delivery
		originCountry = (String) amap.get(KEY_ORIGIN_MAP_CODE);

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_I_V.COUNTRY_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POL") },
				{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

		// ----------------------- call action method to get combo data
		amap.put(KEY_PLACE_OF_RECEIPT, getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PLACE_OF_RECEIPT));

		// ---------------------- return map
		return amap;
	} // getPlaceOfReceipt

	/**
	 * Method to Poulate all combos availabe on scree.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getComboData(Map amap) throws BusinessException, DataAccessException {
		amap = getQuotationComboData(amap);
		amap = getShipmentTermComboData(amap);
		amap = getOriginCountryData(amap);
		amap = getDestinationCountry(amap);
		amap = getPlaceOfReceipt(amap);
		amap = getPortOfLoading(amap);
		amap = getEmptyPickUpDepot(amap);
		amap = getPortOfDischarge(amap);
		amap = getPlaceOfDelivery(amap);
		amap = getTemplate(amap);
		amap = getCarogoType(amap);

		/* Begin @06 */
		amap = this.getRateType(amap);
		/* End @06 */

		/* Begin @07 */
		amap = this.getRepresentComp(amap);
		/* End @07 */

		/* Begin @08 */
		amap = this.getCocSoc(amap);
		/* End @08 */
		amap = this.getSpecialCargo(amap);
		return amap;

	} // getComboData

	/* Begin @06 */
	public String getRfTypeNormal() {
		System.out.println("[EserviceNewWebBookingDaoImpl][getRfTypeNormal][Begin]");

		Map resultMap = null;
		JdbcStoredProcedure storedProcedure = null;
		String rfTypeNormal = null;

		try {
			String[][] array = { { "P_O_V_RF_TYPE", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

			/*
			 * storedProcedure = getStoreProcedure( "PCR_ESV_WEB_BKG.PRR_ESV_GET_RF_TYPE" ,
			 * null , array );
			 */
			resultMap = new HashMap();
			PRR_ESV_GET_RF_TYPE proc = new PRR_ESV_GET_RF_TYPE(getJdbcTemplate(), resultMap);
			proc.executeDbProcedure();

			rfTypeNormal = (String) resultMap.get("P_O_V_RF_TYPE");

			/*
			 * if(storedProcedure != null){ resultMap = storedProcedure.execute();
			 * if(resultMap != null && !resultMap.isEmpty()){ rfTypeNormal = (String)
			 * resultMap.get("P_O_V_RF_TYPE"); } }
			 */

			System.out.println("[EserviceNewWebBookingDaoImpl][getRfTypeNormal] rfTypeNormal :: " + rfTypeNormal);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getRfTypeNormal][End]");
		}

		return rfTypeNormal;
	}
	/* End @06 */

	/**
	 * Method to populate combo data for Port of Loading.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getPortOfLoading(Map amap) throws BusinessException, DataAccessException {

		// --------------------variable declaration
		String originCountry;

		// --------------------check origin country value
		if ((amap.get(KEY_ORIGIN_MAP_CODE) == null)) {
			// ---------------------origin country not selected return blank cvombo
			List lst = new ArrayList(0);
			lst.add(0, new ComboVO(BLANK, SELECT_ONE));
			amap.put(KEY_PORT_OF_LOADING, lst);
			return amap;

		}

		// ---------------------- get selected origin country
		originCountry = (String) amap.get(KEY_ORIGIN_MAP_CODE);

		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfLoading] originCountry :: " + originCountry);
		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfLoading] REP_FLAG      :: "
				+ (String) amap.get(P_I_V.REP_FLAG));
		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfLoading] REP_CODE      :: "
				+ (String) amap.get(P_I_V.REP_CODE));
		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfLoading] USER_ID       :: "
				+ (String) amap.get(P_I_V.USER_ID));
		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfLoading] USER_ID       :: "
				+ (String) amap.get(P_I_V.PORT_OF_LOADING));
		// ---------------------- String array to hold procedure parameter
		// ##09 Begin
		String[][] arrParam = { { P_I_V.COUNTRY_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, originCountry },
				{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_FLAG) },
				{ P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_CODE) },
				{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.USER_ID) },
				{ P_I_V.PORT_OF_LOADING, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POL") } };
		// ##09 end

		// ---------------------- call action method to get combo data
		amap.put(KEY_PORT_OF_LOADING, getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PORT_OF_LOADING));

		// ---------------------- return map
		return amap;

	} // getPortOfLoading

	/**
	 * Method to populate combo data for Empty Pick Up Depot.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getEmptyPickUpDepot(Map amap) throws BusinessException, DataAccessException {

		// --------------------variable declaration
		String originCountry;

		// --------------------check origin country value
		if ((amap.get(KEY_ORIGIN_MAP_CODE) == null)) {

			// ---------------------origin country not selected return blank cvombo
			List lst = new ArrayList(0);
			lst.add(0, new ComboVO(BLANK, SELECT_ONE));
			amap.put(KEY_EMPTY_PICKUP_DEPT, lst);
			return amap;
		}

		// ---------------------- origin country selected populate plcace of delivery
		originCountry = (String) amap.get(KEY_ORIGIN_MAP_CODE);

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_I_V.COUNTRY_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, originCountry },
				{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_I_V.PORT_OF_LOADING, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POL") } };

		// ----------------------- call action method to get combo data
		amap.put(KEY_EMPTY_PICKUP_DEPT,
				getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_EMPTY_PICKUP_DEPOT));

		// ---------------------- return map
		return amap;

	} // getEmptyPickUpDepot

	/**
	 * Method to populate combo data for port of discharge.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getPortOfDischarge(Map amap) throws BusinessException, DataAccessException {

		// --------------------variable declaration
		String destinationCountry;
		String errorFromDB = null;
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;

		// --------------------check origin country value
		if ((amap.get(KEY_DEST_MAP_CODE) == null)) {
			// ---------------------origin country not selected return blank cvombo
			List lst = new ArrayList(0);
			lst.add(0, new ComboVO("", SELECT_ONE));
			amap.put(KEY_PORT_OF_DISCHARGE, lst);
			return amap;

		}

		// --------------origin country selected populate plcace of delivery
		destinationCountry = (String) amap.get(KEY_DEST_MAP_CODE);

		System.out.println(
				"[EserviceNewWebBookingDaoImpl][getPortOfDischarge] destinationCountry  :: " + destinationCountry);
		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfDischarge] REP_FLAG            :: "
				+ (String) amap.get(P_I_V.REP_FLAG));
		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfDischarge] REP_CODE            :: "
				+ (String) amap.get(P_I_V.REP_CODE));
		System.out.println("[EserviceNewWebBookingDaoImpl][getPortOfDischarge] USER_ID             :: "
				+ (String) amap.get(P_I_V.USER_ID));

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_I_V.COUNTRY_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, destinationCountry },
				{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_FLAG) },
				{ P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.REP_CODE) },
				{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(P_I_V.USER_ID) },
				{ P_I_V.PORT_OF_DISCHARGE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POD") } };

		// ----------------------- call action method to get combo data
		amap.put(KEY_PORT_OF_DISCHARGE,
				getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PORT_OF_DISCHARGE));

		// ---------------------- return map
		return amap;

	} // getPortOfDischarge

	/**
	 * Method to check Empty Pick Up Depot.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getCheckPickUpDepot(Map amap) throws BusinessException, DataAccessException {

		// --------------------variable declaration
		String emptyPickup;
		String pol;

		// ---------------------- origin country selected populate plcace of delivery
		emptyPickup = (String) amap.get(KEY_EMPTY_PICKUP_DEPT);
		pol = (String) amap.get(KEY_PORT_OF_LOADING);

		// System.out.println("emptyPickup >>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+emptyPickup);
		// System.out.println("pol >>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+pol);
		Map map = new HashMap(0);

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_I_V.POL, BLANK + ORACLE_VARCHAR, PARAM_IN, pol },
				{ P_I_V.MTY_PICKUP_DEP, BLANK + ORACLE_VARCHAR, PARAM_IN, emptyPickup },
				{ P_O_V.ERR_CD, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_O_V.ERR_DESC, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

		// ---------------------- other procedure details
		map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ESV_VALIDATE);
		map.put(KEY_PROC_PARAMS, arrParam);

		// ---------------------- excecute procedure
		map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

		// ---------------------- returned result Map.
		return map;

		// ---------------------- return map

	} // getCheckPickUpDepot

	/**
	 * Method to populate combo data for place of delivery.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getPlaceOfDelivery(Map amap) throws BusinessException, DataAccessException {

		// --------------------variable declaration
		String destinationCountry;
		String errorFromDB = null;
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;

		// --------------------check origin country value
		if ((amap.get(KEY_DEST_MAP_CODE) == null)) {
			// ---------------------origin country not selected return blank cvombo
			List lst = new ArrayList(0);
			lst.add(0, new ComboVO("", SELECT_ONE));
			amap.put(KEY_PLACE_OF_DELIVERY, lst);
			return amap;

		}
		// --------------origin country selected populate plcace of delivery
		destinationCountry = (String) amap.get(KEY_DEST_MAP_CODE);

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_I_V.COUNTRY_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POD") },
				{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

		// ----------------------- call action method to get combo data
		amap.put(KEY_PLACE_OF_DELIVERY, getComboDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PLACE_OF_RECEIPT));

		// ---------------------- return map
		return amap;

	} // getPlaceOfDelivery

	/**
	 * Method to get Data need to load the page.
	 *
	 * @param amap
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getOnloadData(Map amap) throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getOnloadData][Begin]");

		String userId = null;
		String[][] arrParam = null;
		List list = null;
		EserviceNewWebBookingMod objMod = null;

		try {
			userId = (String) amap.get(KEY_USER_ID);
			arrParam = new String[][] { { KEY_USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId },
					{ P_I_V.PORT_OF_LOADING, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get("POL") },
					{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };
			list = getDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_ESERVICE_ONLOAD_DATA, new OnloadRowMapper());
			objMod = new EserviceNewWebBookingMod();

			for (Object obj : list) {
				objMod = (EserviceNewWebBookingMod) obj;
			}

			amap.put(P_O_V.REF_CURSOR_DATA, objMod);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getOnloadData][End]");
		}
		return amap;
	}

	public Map getOnLoadDataForEditBooking(Map amap) throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getOnloadData][Begin]");

		String userId = null;
		String[][] arrParam = null;
		List list = null;
		EserviceNewWebBookingMod objMod = null;

		try {
			userId = (String) amap.get(KEY_USER_ID);
			arrParam = new String[][] { { KEY_USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId },
					{ P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };
			list = getDataFromDB(arrParam, PCR_ESV_NEW_WEB_BOOKING.PRE_GET_ESERVICE_ONLOAD_DATA, new OnloadRowMapper());
			objMod = new EserviceNewWebBookingMod();

			for (Object obj : list) {
				objMod = (EserviceNewWebBookingMod) obj;
			}

			amap.put(P_O_V.REF_CURSOR_DATA, objMod);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getOnloadData][End]");
		}
		return amap;
	}

	/**
	 * Method to populate combo data for template.
	 *
	 * @param amapParam
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getTemplate(Map amapParam) throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getTemplate][Begin]");

		Map mapResult = null;

		try {
			System.out.println("[EserviceNewWebBookingDaoImpl][getTemplate] USER_ID    :: "
					+ (String) amapParam.get(P_I_V.USER_ID));
			System.out.println("[EserviceNewWebBookingDaoImpl][getTemplate] REP_FLAG   :: "
					+ (String) amapParam.get(P_I_V.REP_FLAG));
			System.out.println("[EserviceNewWebBookingDaoImpl][getTemplate] REP_CODE   :: "
					+ (String) amapParam.get(P_I_V.REP_CODE));

			/*
			 * String[][] arrParam = { { KEY_USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * (String) amapParam.get(P_I_V.USER_ID) }, { P_I_V.REP_FLAG, BLANK +
			 * ORACLE_VARCHAR, PARAM_IN, (String) amapParam.get(P_I_V.REP_FLAG) }, {
			 * P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String)
			 * amapParam.get(P_I_V.REP_CODE) }, { P_O_V.REF_CURSOR_DATA, BLANK +
			 * ORACLE_CURSOR, PARAM_OUT, BLANK }, { KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR,
			 * PARAM_OUT, BLANK } };
			 */
			// ---------------------- other DB trip details
			/*
			 * amapParam.put(KEY_PROC_NAME,
			 * PCR_ESV_NEW_WEB_BOOKING.PRE_GET_TEMPLATE_COMBO_DATA);
			 * amapParam.put(KEY_MAPPER_CLASS, new ComboRowMapper());
			 * amapParam.put(KEY_PROC_PARAMS, arrParam);
			 */

			// ---------------------- excecute procedure
			// amapParam = executeDbProcedure(amapParam);

			amapParam.put(KEY_USER_ID, (String) amapParam.get(P_I_V.USER_ID));
			amapParam.put(P_I_V.REP_FLAG, (String) amapParam.get(P_I_V.REP_FLAG));
			amapParam.put(P_I_V.REP_CODE, (String) amapParam.get(P_I_V.REP_CODE));
			amapParam.put("PORT_OF_LOADING_TEMPLATE", (String) amapParam.get("P_I_V_PORT_OF_LOADING") );
			amapParam.put("PORT_OF_DISCHARGE_TEMPLATE", (String) amapParam.get("POD") );
			PRE_GET_TEMPLATE_COMBO_DATA prgtemp = new PRE_GET_TEMPLATE_COMBO_DATA(getJdbcTemplate(), amapParam);
			prgtemp.executeDbProcedure();
			// ---------------------- get return result
			mapResult = (Map) amapParam.get(KEY_PROCE_EXCECTION_RESULT_MAP);

			// ---------------------- set data in returned list
			amapParam.put(KEY_TEMPLATE, addSelectOne(mapResult));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getTemplate][End]");
		}

		// ---------------------- return map
		return amapParam;

	} // getTemplate

	/* Begin @06 */
	/**
	 * Method to populate combo data for Rate Type.
	 *
	 * @param amapParam
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getRateType(Map amapParam) throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getRateType][Begin]");
		Map resultMap = null;
		List<ComboVO> lst = null;
		JdbcStoredProcedure storedProcedure = null;
		ComboVO objComboVO = null;
		String[][] arrParam = { { P_O_V.P_O_RESULT_STATUS, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_O_V.P_O_RESULT_MESSAGE, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_O_V.P_O_RECORD_SET, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ P_I_V.P_I_MODULE, BLANK + ORACLE_VARCHAR, PARAM_IN, "CAM" },
				{ P_I_V.P_I_TABLE_OWNER, BLANK + ORACLE_VARCHAR, PARAM_IN, "RCL" },
				{ P_I_V.P_I_TABLE_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, "EQUIPMENT_BOOKING" },
				{ P_I_V.P_I_TABLE_FIELD, BLANK + ORACLE_VARCHAR, PARAM_IN, "CARGO_TYPE" },
				{ P_I_V.P_I_CODE_VALUE, BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK }, };

		try {

			// storedProcedure = getStoreProcedure(PCR_ZCC_MAIN.PRR_GET_CODE_VALUE_LIST, new
			// RateTypeRowMapper(), arrParam);

			resultMap = new HashMap<>();

			resultMap.put("P_I_MODULE", "CAM");
			resultMap.put("P_I_TABLE_OWNER", "RCL");
			resultMap.put("P_I_TABLE_NAME", "EQUIPMENT_BOOKING");
			resultMap.put("P_I_TABLE_FIELD", "CARGO_TYPE");
			resultMap.put("P_I_CODE_VALUE", BLANK);

			PRR_GET_CODE_VALUE_LIST proc = new PRR_GET_CODE_VALUE_LIST(getJdbcTemplate(), resultMap);
			proc.executeDbProcedure();

			lst = (List<ComboVO>) resultMap.get(P_O_V.P_O_RECORD_SET);
			/*
			 * if(storedProcedure != null){ resultMap = storedProcedure.execute();
			 * if(resultMap != null && !resultMap.isEmpty()){ lst = (List<ComboVO>)
			 * resultMap.get(P_O_V.P_O_RECORD_SET); } }
			 */

			if (lst == null) {
				lst = new ArrayList<ComboVO>(0);
			} else {
				for (int i = 0; i < lst.size(); i++) {
					objComboVO = lst.get(i);
					if (objComboVO.getCode().equalsIgnoreCase("Z")) {
						lst.remove(i);
						break;
					}
				}
			}

			lst.add(0, new ComboVO(BLANK, SELECT_ONE));

			// ---------------------- set data in returned list
			amapParam.put(RATE_TYPE, lst);
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getRateType][End]");
		}
		// ---------------------- return map
		return amapParam;

	}
	/* End @06 */

	/* Begin @07 */
	public Map getRepresentComp(Map amapParam) {
		System.out.println("[EserviceNewWebBookingDaoImpl][getRepresentComp][Begin]");
		Map resultMap = null;
		List<ComboVO> lst = null;
		JdbcStoredProcedure storedProcedure = null;
		String[][] arrParam = null;
		String userId = null;
		String pol="";
		String pod="";
		/* sid */

		String L_V_USER_SOC_COC = "";
		String L_V_TELEPHONE = "";
		String L_V_FAX = "";
		String L_V_USER_EMAIL = "";

		try {
			userId = (String) amapParam.get(P_I_V.USER_ID);
			pol=(String) amapParam.get("POL");
			pod=(String) amapParam.get("POD");		
			System.out.println("[EserviceNewWebBookingDaoImpl][getRepresentComp] userId :: " + userId);

			arrParam = new String[][] { { P_O_V.REP_COMP, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId } };

			resultMap = new HashMap<>();
			resultMap.put(P_I_V.USER_ID, userId);
			resultMap.put("POL", pol);
			resultMap.put("POD", pod);
			PRR_ERCL_GET_REP_COMP prg = new PRR_ERCL_GET_REP_COMP(getJdbcTemplate(), resultMap);
			prg.executeDbProcedure();
			lst = (List<ComboVO>) resultMap.get(P_O_V.REP_COMP);

			// storedProcedure = getStoreProcedure(PCR_ESV_WEB_BKG.PRR_ERCL_GET_REP_COMP,
			// new RepCompMapper(), arrParam);

			/*
			 * if(storedProcedure != null){ resultMap = storedProcedure.execute();
			 * if(resultMap != null && !resultMap.isEmpty()){ lst = (List<ComboVO>)
			 * resultMap.get(P_O_V.REP_COMP); } }
			 */

			if (lst == null) {
				lst = new ArrayList<ComboVO>(0);
			}

			lst.add(0, new ComboVO(BLANK, SELECT_ONE));

			// ---------------------- set data in returned list
			amapParam.put(REP_COMP, lst);

			/* start JDBC */

			/*
			 * Map<String, String> mapObj= new HashMap<String, String>();
			 * 
			 * String sqlQuery=" SELECT " + "                I10.CUCORS AS SOS_COC," +
			 * "                I10.CUTELE AS TELEPHONE," +
			 * "                I10.CUFAX  AS FAX" + "            FROM" +
			 * "                ITP010 I10, SC_PRSN_LOG_INFO SPLI " + "            WHERE " +
			 * "                I10.CUCUST = SPLI.ORG_CODE " +
			 * "                AND SPLI.PRSN_LOG_ID = '"+userId+"'"; SqlRowSet rs =
			 * getNamedParameterJdbcTemplate().queryForRowSet(sqlQuery, new HashMap());
			 * 
			 * 
			 * while(rs.next()){ mapObj.put("SOS_COC" ,rs.getString("SOS_COC"));
			 * mapObj.put("TELEPHONE", rs.getString("TELEPHONE")); mapObj.put("FAX"
			 * ,rs.getString("FAX")); } String sqlQuery1=" SELECT " +
			 * "                SPLI.EMAIL_ID1 AS EMAIL " + "            FROM " +
			 * "                SC_PRSN_LOG_INFO SPLI " + "            WHERE " +
			 * "                SPLI.PRSN_LOG_ID = '"+userId+"'"; SqlRowSet rs1 =
			 * getNamedParameterJdbcTemplate().queryForRowSet(sqlQuery1, new HashMap());
			 * while(rs1.next()){ mapObj.put("EMAIL", rs.getString("EMAIL")); } lst =
			 * (List<ComboVO>) mapObj; amapParam.put(REP_COMP, lst);
			 */
			/* end Jdbc */

		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getRepresentComp][End]");
		}
		// ---------------------- return map
		return amapParam;

	}
	/* End @07 */

	/* Begin @08 */
	public Map getCocSoc(Map amapParam) {
		System.out.println("[EserviceNewWebBookingDaoImpl][getCocSoc][Begin]");
		Map resultMap = null;
		List<ComboVO> lst = null;
		JdbcStoredProcedure storedProcedure = null;
		String[][] arrParam = null;
		String userId = null;

		try {
			userId = (String) amapParam.get(P_I_V.USER_ID);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCocSoc] userId :: " + userId);

			arrParam = new String[][] { { P_O_V.COC_SOC, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId } };
			// storedProcedure = getStoreProcedure(PCR_ESV_WEB_BKG.PRR_ERCL_GET_COC_SOC, new
			// CocSocMapper(), arrParam);
			/*
			 * if(storedProcedure != null){ resultMap = storedProcedure.execute();
			 * if(resultMap != null && !resultMap.isEmpty()){ lst = (List<ComboVO>)
			 * resultMap.get(P_O_V.COC_SOC); } }
			 */

			resultMap = new HashMap<>();
			resultMap.put(P_I_V.USER_ID, userId);

			PRR_ERCL_GET_COC_SOC prg = new PRR_ERCL_GET_COC_SOC(getJdbcTemplate(), resultMap);
			prg.executeDbProcedure();
			lst = (List<ComboVO>) resultMap.get(P_O_V.COC_SOC);

			if (lst == null) {
				lst = new ArrayList<ComboVO>(0);
			}

			amapParam.put(COC_SOC, lst);

		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getCocSoc][End]");
		}
		// ---------------------- return map
		return amapParam;

	}
	/* End @08 */

	public Map getSpecialCargo(Map amapParam) {
		System.out.println("[EserviceNewWebBookingDaoImpl][getSpecialCargo][Begin]");
		Map resultMap = null;
		List<ComboVO> lst = null;
		JdbcStoredProcedure storedProcedure = null;
		String[][] arrParam = null;
		String userId = null;

		try {
			userId = (String) amapParam.get(P_I_V.USER_ID);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCocSoc] userId :: " + userId);


			resultMap = new HashMap<>();
			resultMap.put(P_I_V.USER_ID, userId);

			PPRR_ERCL_GET_SPECIAL_CARGO prg = new PPRR_ERCL_GET_SPECIAL_CARGO(getJdbcTemplate(), resultMap);
			prg.executeDbProcedure();
			lst = (List<ComboVO>) resultMap.get(P_O_V.SPECIAL_CARGO);

			if (lst == null) {
				lst = new ArrayList<ComboVO>(0);
			}

			lst.add(0, new ComboVO(BLANK, SELECT_ONE));
			
			amapParam.put(SECIAL_CAERGO, lst);

		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getCocSoc][End]");
		}
		// ---------------------- return map
		return amapParam;

	}
	
	
	/**
	 * Method to populate combo data for Refr. Mode.
	 *
	 * @param
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public List getRefrMode() throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getRefrMode][Begin]");
		Map resultMap = new HashMap();
		List lst = null;
		JdbcStoredProcedure storedProcedure = null;
		/*
		 * String[][] arrParam = { { P_O_V.P_O_RESULT_STATUS, BLANK + ORACLE_VARCHAR,
		 * PARAM_OUT, BLANK }, { P_O_V.P_O_RESULT_MESSAGE, BLANK + ORACLE_VARCHAR,
		 * PARAM_OUT, BLANK }, { P_O_V.P_O_RECORD_SET, BLANK + ORACLE_CURSOR, PARAM_OUT,
		 * BLANK }, { P_I_V.P_I_MODULE, BLANK + ORACLE_VARCHAR, PARAM_IN, "CAM" }, {
		 * P_I_V.P_I_TABLE_OWNER, BLANK + ORACLE_VARCHAR, PARAM_IN, "RCL" }, {
		 * P_I_V.P_I_TABLE_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, "REEFER_COMMODITY" },
		 * { P_I_V.P_I_TABLE_FIELD, BLANK + ORACLE_VARCHAR, PARAM_IN, "REEFER_MODE" }, {
		 * P_I_V.P_I_CODE_VALUE, BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK }, };
		 */

		try {

			resultMap.put("P_I_MODULE", "CAM");
			resultMap.put("P_I_TABLE_OWNER", "RCL");
			resultMap.put("P_I_TABLE_NAME", "REEFER_COMMODITY");
			resultMap.put("P_I_TABLE_FIELD", "REEFER_MODE");
			resultMap.put("P_I_CODE_VALUE", "");
			
			PRR_GET_CODE_VALUE_LIST proc= new PRR_GET_CODE_VALUE_LIST(getJdbcTemplate(),resultMap);
			
			/*
			 * storedProcedure = getStoreProcedure(PCR_ZCC_MAIN.PRR_GET_CODE_VALUE_LIST, new
			 * RateTypeRowMapper(), arrParam);
			 */
			//if (storedProcedure != null) {
			proc.executeDbProcedure();
				//if (resultMap != null && !resultMap.isEmpty()) {
					lst = (List) resultMap.get(P_O_V.P_O_RECORD_SET);
				//}
			//}

		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getRefrMode][End]");
		}
		// ---------------------- return map
		return lst;

	}

	/**
	 * Method to populate combo data for Unit Measurement.
	 *
	 * @param
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public List getUnitMeasurementCombo() throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getUnitMeasurementCombo][Begin]");
		Map resultMap = null;
		List lst = null;
		JdbcStoredProcedure storedProcedure = null;
		String[][] arrParam = { { P_O_V.P_O_RESULT_STATUS, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_O_V.P_O_RESULT_MESSAGE, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ P_O_V.P_O_RECORD_SET, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ P_I_V.P_I_MODULE, BLANK + ORACLE_VARCHAR, PARAM_IN, "RCL" },
				{ P_I_V.P_I_TABLE_OWNER, BLANK + ORACLE_VARCHAR, PARAM_IN, "RCL" },
				{ P_I_V.P_I_TABLE_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, "STANDARD_TEMP_UNIT" },
				{ P_I_V.P_I_TABLE_FIELD, BLANK + ORACLE_VARCHAR, PARAM_IN, "TEMPERATURE_UNIT_MEASUREMENT" },
				{ P_I_V.P_I_CODE_VALUE, BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK }, };

		try {
			resultMap = new HashMap();
			resultMap.put(P_I_V.P_I_MODULE, "RCL");
			resultMap.put(P_I_V.P_I_TABLE_OWNER, "RCL");
			resultMap.put(P_I_V.P_I_TABLE_NAME, "STANDARD_TEMP_UNIT");
			resultMap.put(P_I_V.P_I_TABLE_FIELD, "TEMPERATURE_UNIT_MEASUREMENT");
			resultMap.put(P_I_V.P_I_CODE_VALUE, BLANK);

			PRR_GET_CODE_VALUE_LIST proc = new PRR_GET_CODE_VALUE_LIST(getJdbcTemplate(), resultMap);

			// storedProcedure = getStoreProcedure(PCR_ZCC_MAIN.PRR_GET_CODE_VALUE_LIST, new
			// RateTypeRowMapper(),
			// arrParam);
			proc.executeDbProcedure();
			// if (storedProcedure != null) {
			// resultMap = storedProcedure.execute();

			if (resultMap != null && !resultMap.isEmpty()) {
				lst = (List) resultMap.get(P_O_V.P_O_RECORD_SET);
			}
			// }

			if (lst == null) {
				lst = new ArrayList(0);
			}

			lst.add(0, new ComboVO(BLANK, SELECT_ONE));

		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getUnitMeasurementCombo][End]");
		}
		// ---------------------- return map
		return lst;

	}
	/* End @06 */

	/**
	 * Method is used to save booking data when submit booking button is pressed.
	 *
	 * @param eserviceNewWebBookingUim
	 * @return Map
	 * @throws Exception 
	 */
	public Map saveBookingData(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws Exception {
		System.out.println("[EserviceNewWebBookingDaoImpl][saveBookingData][Begin]");
		// ------------------------ variable declaration
		String templateName = null;
		String quotationNumber = null;
		String shipmentTerm = null;
		String customerReference = null;
		String email = null;
		String telephone = null;
		String fax = null;
		String contact = null;
		String additionalMailRecipeints = null;
		String placeOfReceipt = null;
		String portOfLoading = null;
		String portOfDischarge = null;
		String placeOfDelivery = null;
		String desiredArrivalDate = null;
		String routingPref = null;
		String shipmentDate = null;
		String loginId = null;
		String saveOperationFlag = null;
		String cargoDescription = null;
		// add sailing date 05/06/2013
		String sailingDate = null;
		Map map = null;
		String[][] arrParam = null;
		/* Begin @07 */
		String representCompChkBox = null;
		String representComp = null;
		/* End @07 */
		String cocSoc = null;// @08
		String vessel = null;
		String vesselName = null;
		String voyage = null;
		try {
			// ------------------------ variable initialization
			/*
			 * templateName = eserviceNewWebBookingUim.getTemplateName(); quotationNumber =
			 * eserviceNewWebBookingUim.getQuotationNumber(); shipmentTerm =
			 * eserviceNewWebBookingUim.getPol() + eserviceNewWebBookingUim.getPod();
			 * customerReference = eserviceNewWebBookingUim.getCustomerReference(); email =
			 * eserviceNewWebBookingUim.getEmail(); telephone =
			 * eserviceNewWebBookingUim.getTelephone(); fax =
			 * eserviceNewWebBookingUim.getFax(); contact =
			 * eserviceNewWebBookingUim.getContact(); additionalMailRecipeints =
			 * eserviceNewWebBookingUim.getAdditionalMailRecipeints(); placeOfReceipt =
			 * eserviceNewWebBookingUim.getPlaceOfReceipt(); portOfLoading =
			 * eserviceNewWebBookingUim.getPortOfLoading()==null?eserviceNewWebBookingUim.
			 * getPol():eserviceNewWebBookingUim.getPortOfLoading(); portOfDischarge =
			 * eserviceNewWebBookingUim.getPortOfDischarge()==
			 * null?eserviceNewWebBookingUim.getPod():eserviceNewWebBookingUim.
			 * getPortOfDischarge();//sushil placeOfDelivery =
			 * eserviceNewWebBookingUim.getPlaceOfDelivery(); desiredArrivalDate =
			 * eserviceNewWebBookingUim.getDesiredArrivalDate(); routingPref =
			 * eserviceNewWebBookingUim.getRoutingPreference(); shipmentDate =
			 * eserviceNewWebBookingUim.getShipmentDate(); loginId =
			 * eserviceNewWebBookingUim.getUserId(); saveOperationFlag =
			 * eserviceNewWebBookingUim.getSaveOperationFlag(); cargoDescription =
			 * eserviceNewWebBookingUim.getCargoDescription(); sailingDate =
			 * eserviceNewWebBookingUim.getSailingDate(); Begin @07 representCompChkBox =
			 * eserviceNewWebBookingUim.getRepresentCompChkBox(); representComp =
			 * eserviceNewWebBookingUim.getRepresentComp(); End @07 cocSoc =
			 * eserviceNewWebBookingUim.getSocCocUserFlag();// @08 vessel =
			 * eserviceNewWebBookingUim.getVessel(); vesselName =
			 * eserviceNewWebBookingUim.getVesselName(); voyage =
			 * eserviceNewWebBookingUim.getVoyage();
			 */
			System.out.println(
					"[EserviceNewWebBookingDaoImpl][saveBookingData] representCompChkBox    :: " + representCompChkBox);
			System.out.println(
					"[EserviceNewWebBookingDaoImpl][saveBookingData] representComp          :: " + representComp);
			System.out.println("[EserviceNewWebBookingDaoImpl][saveBookingData] cocSoc                 :: " + cocSoc);

			map = new HashMap(0);
			/*
			 * arrParam = new String[][] { { P_O_V.BOOKING_NO, BLANK + ORACLE_VARCHAR,
			 * PARAM_OUT, BLANK }, { P_O_V.LINE, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
			 * { P_O_V.TRADE, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, { P_O_V.AGENT,
			 * BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, { P_O_V.CUSTOMER_CODE, BLANK +
			 * ORACLE_VARCHAR, PARAM_OUT, BLANK }, { P_O_V.CUSTOMER_NAME, BLANK +
			 * ORACLE_VARCHAR, PARAM_OUT, BLANK }, { P_O_V.ERROR, BLANK + ORACLE_VARCHAR,
			 * PARAM_OUT, BLANK }, { P_I_V.TEMPLATE_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * templateName }, { P_I_V.QUOTATION_NUMBER, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * quotationNumber }, { P_I_V.SHIPMENT_TERM, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * shipmentTerm }, { P_I_V.CUSTOMER_REF, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * customerReference }, { P_I_V.EMAIL, BLANK + ORACLE_VARCHAR, PARAM_IN, email
			 * }, { P_I_V.TELEPHONE, BLANK + ORACLE_VARCHAR, PARAM_IN, telephone }, {
			 * P_I_V.FAX, BLANK + ORACLE_VARCHAR, PARAM_IN, fax }, { P_I_V.CONTACT, BLANK +
			 * ORACLE_VARCHAR, PARAM_IN, contact }, { P_I_V.ADD_EMAIL_RECIPEINTS, BLANK +
			 * ORACLE_VARCHAR, PARAM_IN, additionalMailRecipeints }, {
			 * P_I_V.PLACE_OF_RECEIPT, BLANK + ORACLE_VARCHAR, PARAM_IN, placeOfReceipt }, {
			 * P_I_V.PORT_OF_LOADING, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfLoading }, {
			 * P_I_V.PORT_OF_DISCHARGE, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfDischarge },
			 * { P_I_V.PLACE_OF_DELIVERY, BLANK + ORACLE_VARCHAR, PARAM_IN, placeOfDelivery
			 * }, { P_I_V.DESIRED_ARRIVAL_DATE, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * desiredArrivalDate }, { P_I_V.ROUTING_REF, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * routingPref }, { P_I_V.SHIPMENT_DATE, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * shipmentDate }, { P_I_V.SAVE_OPERATION_FLAG, BLANK + ORACLE_VARCHAR,
			 * PARAM_IN, saveOperationFlag }, { P_I_V.USER_ID, BLANK + ORACLE_VARCHAR,
			 * PARAM_IN, loginId }, { P_I_V.CARGO_DESCRIPTION, BLANK + ORACLE_VARCHAR,
			 * PARAM_IN, cargoDescription }, { P_I_V.SAILING_DATE, BLANK + ORACLE_VARCHAR,
			 * PARAM_IN, sailingDate }, { P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * representCompChkBox }, { P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN,
			 * representComp }, { P_I_V.COC_SOC, BLANK + ORACLE_VARCHAR, PARAM_IN, cocSoc }
			 * };
			 * 
			 * // ---------------------- other procedure details map.put(KEY_PROC_NAME,
			 * PCR_ESV_NEW_WEB_BOOKING.PRE_SAVE_BOOKING_DATA); map.put(KEY_PROC_PARAMS,
			 * arrParam);
			 */
			// ---------------------- excecute procedure
			// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);
			map.put("P_I_V_VESSEL", eserviceNewWebBookingUim.getVessel());
			map.put("P_I_V_VESSEL_NAME", eserviceNewWebBookingUim.getVesselName());
			map.put("P_I_V_VOYAGE", eserviceNewWebBookingUim.getVoyage());
			map.put("P_I_V_TEMPLATE_NAME", eserviceNewWebBookingUim.getTemplateName().replaceAll("'", "\\\\'"));
			map.put("P_I_V_QUOTATION_NUMBER", eserviceNewWebBookingUim.getQuotationNumber());
			map.put("P_I_V_SHIPMENT_TERM", eserviceNewWebBookingUim.getPol() + eserviceNewWebBookingUim.getPod());
			map.put("P_I_V_CUSTOMER_REF", eserviceNewWebBookingUim.getCustomerReference());
			map.put("P_I_V_EMAIL", eserviceNewWebBookingUim.getEmail());
			map.put("P_I_V_TELEPHONE", eserviceNewWebBookingUim.getTelephone());
			map.put("P_I_V_FAX", eserviceNewWebBookingUim.getFax());
			map.put("P_I_V_CONTACT", eserviceNewWebBookingUim.getContact());
			map.put("P_I_V_ADD_MAIL_RECIPEINTS", eserviceNewWebBookingUim.getAdditionalMailRecipeints());
			map.put("P_I_V_PLACE_OF_RECEIPT", eserviceNewWebBookingUim.getPlaceOfReceipt());
			map.put("P_I_V_PORT_OF_LOADING",
					eserviceNewWebBookingUim.getPortOfLoading() == null ? eserviceNewWebBookingUim.getPol()
							: eserviceNewWebBookingUim.getPortOfLoading());
			map.put("P_I_V_PORT_OF_DISCHARGE",
					eserviceNewWebBookingUim.getPortOfDischarge() == null ? eserviceNewWebBookingUim.getPod()
							: eserviceNewWebBookingUim.getPortOfDischarge());
			map.put("P_I_V_PLACE_OF_DELIVERY", eserviceNewWebBookingUim.getPlaceOfDelivery());
			map.put("P_I_V_DESIRED_ARRIVAL_DATE", eserviceNewWebBookingUim.getDesiredArrivalDate());
			map.put("P_I_V_ROUTING_REF", eserviceNewWebBookingUim.getRoutingPreference().replaceAll("'", "\\\\'"));
			map.put("P_I_V_SHIPMENT_DATE", eserviceNewWebBookingUim.getShipmentDate());
			map.put("P_I_V_SAVE_OPERATION_FLAG", eserviceNewWebBookingUim.getSaveOperationFlag());
			map.put("P_I_V_USER_ID", eserviceNewWebBookingUim.getUserId());
			map.put("P_I_V_CARGO_DESCRIPTION", eserviceNewWebBookingUim.getCargoDescription().replaceAll("'", "\\\\'"));
			map.put("P_I_V_SAILING_DATE", eserviceNewWebBookingUim.getSailingDate());
			map.put("P_I_V_REP_FLAG", eserviceNewWebBookingUim.getRepresentCompChkBox());
			map.put("P_I_V_REP_CODE", eserviceNewWebBookingUim.getRepresentComp());
			map.put("P_I_V_COC_SOC", eserviceNewWebBookingUim.getSocCocUserFlag());
			map.put("P_I_V_TO_TERMINAL", eserviceNewWebBookingUim.getToTerminal());
			map.put("P_I_V_FROM_TERMINAL", eserviceNewWebBookingUim.getFromTerminal());
			map.put("P_I_V_VESSLE_ETD", eserviceNewWebBookingUim.getVesselEtd());
			map.put("P_I_V_FIRST_LEG_LOCATION", eserviceNewWebBookingUim.getToLocation());
			map.put("P_I_V_FIRST_LEG_TERMINAL", eserviceNewWebBookingUim.getTo());
			
			PRE_SAVE_BOOKING_DATA prgSaveBooking = new PRE_SAVE_BOOKING_DATA(getJdbcTemplate(), map);
			
			prgSaveBooking.executeDbProcedure();
			map = (Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP);
			System.out.println("[EserviceNewWebBookingDaoImpl][saveBookingData] map :: " + map);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][saveBookingData][End]");
		}
		// ---------------------- returned result Map.
		return map;

	} // saveBookingData

	/**
	 * Get Quotation and check Quotaion no.
	 *
	 * @param eserviceNewWebBookingUim
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getCheckQuotationNo(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo][Begin]");

		Map map = new HashMap(0);
		String quotationNumber = null;
		String portOfLoading = null;
		String portOfDischarge = null;
		String loginId = null;
		String size = null;
		String type = null;
		// @01 BEGIN
		String strPlaceOfReceipt = null;
		String strPlaceOfDelivery = null;
		// @01 END
		List equipmentList = null;
		String tempSize = null;
		String tempType = null;
		String[][] arrParam = null;
		/* Begin @07 */
		String representCompChkBox = null;
		String representComp = null;
		/* End @07 */
		String cocSoc = null;// @08

		try {
			if (eserviceNewWebBookingUim.getQuotationNumber() != null
					&& !eserviceNewWebBookingUim.getQuotationNumber().equals("")) {
				quotationNumber = eserviceNewWebBookingUim.getQuotationNumber();
			}

			portOfLoading = eserviceNewWebBookingUim.getPortOfLoading();
			portOfDischarge = eserviceNewWebBookingUim.getPortOfDischarge();
			loginId = eserviceNewWebBookingUim.getUserId();
			// @01 BEGIN
			strPlaceOfReceipt = eserviceNewWebBookingUim.getPlaceOfReceipt();
			strPlaceOfDelivery = eserviceNewWebBookingUim.getPlaceOfDelivery();
			// @01 END
			equipmentList = eserviceNewWebBookingUim.getEquipmentVoDataList();

			tempSize = "";
			tempType = "";
			if (equipmentList != null && equipmentList.size() > 0) {
				for (int i = 0; i < equipmentList.size(); i++) {
					EserviceEquipmentDetailsMod mod = (EserviceEquipmentDetailsMod) equipmentList.get(i);
					if (i == 0) {
						tempSize = mod.getSize();
						tempType = mod.getType();
					} else {
						tempSize = tempSize + "," + mod.getSize();
						tempType = tempType + "," + mod.getType();
					}
				}

				size = tempSize;
				type = tempType;
			}

			/* Begin @07 */
			representCompChkBox = eserviceNewWebBookingUim.getRepresentCompChkBox();
			representComp = eserviceNewWebBookingUim.getRepresentComp();
			/* End @07 */
			cocSoc = eserviceNewWebBookingUim.getSocCocUserFlag();// @08

			System.out.println(
					"[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] loginId                     :: " + loginId);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] strPlaceOfReceipt           :: "
					+ strPlaceOfReceipt);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] strPlaceOfDelivery          :: "
					+ strPlaceOfDelivery);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] portOfLoading               :: "
					+ portOfLoading);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] portOfDischarge             :: "
					+ portOfDischarge);
			System.out.println(
					"[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] size                        :: " + size);
			System.out.println(
					"[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] type                        :: " + type);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] quotationNumber             :: "
					+ quotationNumber);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] representCompChkBox         :: "
					+ representCompChkBox);
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] representComp               :: "
					+ representComp);
			System.out.println(
					"[EserviceNewWebBookingDaoImpl][getCheckQuotationNo] cocSoc                      :: " + cocSoc);

			arrParam = new String[][] { { P_O_V.QTN_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
					{ P_I_V.PLR, BLANK + ORACLE_VARCHAR, PARAM_IN, strPlaceOfReceipt },
					{ P_I_V.PLD, BLANK + ORACLE_VARCHAR, PARAM_IN, strPlaceOfDelivery },
					{ P_I_V.POL, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfLoading },
					{ P_I_V.POD, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfDischarge },
					{ P_I_V.SIZE, BLANK + ORACLE_VARCHAR, PARAM_IN, size },
					{ P_I_V.TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, type },
					{ P_I_V.QTN, BLANK + ORACLE_VARCHAR, PARAM_IN, quotationNumber },
					{ P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, representCompChkBox }, // @07
					{ P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, representComp }, // @07
					{ P_I_V.COC_SOC, BLANK + ORACLE_VARCHAR, PARAM_IN, cocSoc }, // @08
					{ P_O_V.QTN_EXISTS, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

			// ---------------------- other procedure details
			map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ERCL_GET_LIST_QTN);
			map.put(KEY_MAPPER_CLASS, new QuotationRowMapper());
			map.put(KEY_PROC_PARAMS, arrParam);

			// ---------------------- excecute procedure
			map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

			/*
			 * PRR_ERCL_GET_LIST_QTN procListQtn=new
			 * PRR_ERCL_GET_LIST_QTN(getJdbcTemplate(),map);
			 * procListQtn.executeDbProcedure();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][getCheckQuotationNo][End]");
		}
		return map;
	} // end getCheckQuotationNo

	/**
	 * Get Quotation no.
	 *
	 * @param paramsMap
	 * @return resultMap
	 * @throws DataAccessException
	 */
	public Map findQuotationNoList(Map paramsMap) throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList][Begin]");

		JdbcStoredProcedure storedProcedure = null;
		Map resultMap = null;
		String[][] arrParam = null;
		String quotationNumber = null;
		String portOfLoading = null;
		String portOfDischarge = null;
		String strPlaceOfReceipt = null;
		String strPlaceOfDelivery = null;
		String loginId = null;
		String size = null;
		String type = null;
		String errorCode = null;
		String errorDesc = null;
		String cocSoc = null;// @08
		/* Begin @07 */
		String representCompChkBox = null;
		String representComp = null;
		/* End @07 */

		try {

			if (paramsMap != null && !paramsMap.isEmpty()) {
				loginId = (String) paramsMap.get(P_I_V.USER_ID);
				cocSoc = (String) paramsMap.get(P_I_V.COC_SOC);// @08
				representCompChkBox = (String) paramsMap.get(P_I_V.REP_FLAG);
				representComp = (String) paramsMap.get(P_I_V.REP_CODE);

				System.out.println(
						"[EserviceNewWebBookingDaoImpl][findQuotationNoList] loginId              :: " + loginId);
				System.out.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList] strPlaceOfReceipt    :: "
						+ strPlaceOfReceipt);
				System.out.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList] strPlaceOfDelivery   :: "
						+ strPlaceOfDelivery);
				System.out.println(
						"[EserviceNewWebBookingDaoImpl][findQuotationNoList] portOfLoading        :: " + portOfLoading);
				System.out.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList] portOfDischarge      :: "
						+ portOfDischarge);
				System.out
						.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList] size                 :: " + size);
				System.out
						.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList] type                 :: " + type);
				System.out.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList] quotationNumber      :: "
						+ quotationNumber);
				System.out.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList] representCompChkBox  :: "
						+ representCompChkBox);
				System.out.println(
						"[EserviceNewWebBookingDaoImpl][findQuotationNoList] representComp        :: " + representComp);
				System.out.println(
						"[EserviceNewWebBookingDaoImpl][findQuotationNoList] cocSoc               :: " + cocSoc);

				arrParam = new String[][] { { P_O_V.QTN_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
						{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
						{ P_I_V.PLR, BLANK + ORACLE_VARCHAR, PARAM_IN, strPlaceOfReceipt },
						{ P_I_V.PLD, BLANK + ORACLE_VARCHAR, PARAM_IN, strPlaceOfDelivery },
						{ P_I_V.POL, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfLoading },
						{ P_I_V.POD, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfDischarge },
						{ P_I_V.SIZE, BLANK + ORACLE_VARCHAR, PARAM_IN, size },
						{ P_I_V.TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, type },
						{ P_I_V.QTN, BLANK + ORACLE_VARCHAR, PARAM_IN, quotationNumber },
						/* Begin @07 */
						{ P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, representCompChkBox },
						{ P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, representComp },
						/* End @07 */
						{ P_I_V.COC_SOC, BLANK + ORACLE_VARCHAR, PARAM_IN, cocSoc }, // @08
						{ P_O_V.QTN_EXISTS, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

				storedProcedure = getStoreProcedure(PCR_ESV_WEB_BKG.PRR_ERCL_GET_LIST_QTN, new QuotationRowMapper(),
						arrParam);
				if (storedProcedure != null) {
					resultMap = storedProcedure.execute();
					if (resultMap != null && !resultMap.isEmpty()) {
						if (resultMap.containsKey(P_O_V.ERR_CD)) {
							errorCode = (String) resultMap.get(P_O_V.ERR_CD);
						}
						if (resultMap.containsKey(P_O_V.ERR_DESC)) {
							errorDesc = (String) resultMap.get(P_O_V.ERR_DESC);
						}
					}
				}
			} else {
				errorDesc = "Result is null.";
			}
		} catch (DataAccessException ex) {
			throw ex;
		} finally {
			if (resultMap == null) {
				resultMap = new HashMap();
			}
			if (errorDesc != null && !BLANK.equals(errorDesc)) {
				if (errorCode == null || BLANK.equals(errorCode)) {
					resultMap.put(P_O_V.ERR_CD, EXCEPTION);
				}
			}
			System.out.println("[EserviceNewWebBookingDaoImpl][findQuotationNoList][End]");
		}
		return resultMap;
	} // end getQuotationNoList

	/**
	 * This Mehtod is used to execute DB procedure and return result.
	 *
	 * @param arrParameters procecure
	 * @return Data from database.
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map executeDbProcedure(Map arrParameters) throws BusinessException, DataAccessException {

		try {
			/* Stored procedure object */
			JdbcStoredProcedure lobjSP = null;

			/* Return Result from SP execute */
			Map lmapResult = null;

			/* Stores return error code from SP */
			String lstrRetError = null;

			/* Create JDBC Stored Procedure Object */
			if (arrParameters.containsKey(KEY_MAPPER_CLASS)) {
				lobjSP = new JdbcStoredProcedure(getDataSource(), (String) arrParameters.get(KEY_PROC_NAME),
						(JdbcRowMapper) arrParameters.get(KEY_MAPPER_CLASS),
						(String[][]) arrParameters.get(KEY_PROC_PARAMS));

			} else {
				lobjSP = new JdbcStoredProcedure(getDataSource(), (String) arrParameters.get(KEY_PROC_NAME),
						(String[][]) arrParameters.get(KEY_PROC_PARAMS));
			}
			Debug.log("PROCEDURE:=> " + (String) (String) arrParameters.get(KEY_PROC_NAME));
			if (PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PLACE_OF_RECEIPT
					.equals((String) (String) arrParameters.get(KEY_PROC_NAME))) {
				Debug.log("PROCEDURE:=> " + (String) (String) arrParameters.get(KEY_PROC_NAME));
			}
			/* Execute the SP & Get the Return Output values as Map */
			lmapResult = lobjSP.execute();

			/* Read the Return code from SP */
			if (lmapResult.containsKey(KEY_ERROR_DATA)) {

				lstrRetError = (String) lmapResult.get(KEY_ERROR_DATA);
				// System.out.println("lstrRetError >>>>>>>>>>>>> "+lstrRetError);
				/* If return error code is Failure, throw Business Exception */
				if (isErrorCode(lstrRetError)) {
					String[][] lstrarrProcParameters = (String[][]) arrParameters.get(KEY_PROC_PARAMS);
					Debug.logFramework("Error while calling procedure :: " + (String) arrParameters.get(KEY_PROC_NAME));
					Debug.logFramework("With Parameters :: " + NEWLINE);
					for (int i = 0; i < lstrarrProcParameters.length; i++) {
						Debug.logFramework(
								lstrarrProcParameters[i][0] + " :: " + lstrarrProcParameters[i][3] + NEWLINE);
					}
					throw ExceptionFactory.createApplicationException(lstrRetError);
				}
			}

			// for(Object key : lmapResult.keySet()){
			// System.out.println("lmapResult key : " + key + " , value : " +
			// lmapResult.get(key));
			// }

			arrParameters.put(KEY_PROCE_EXCECTION_RESULT_MAP, lmapResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrParameters;
	} // executeDbProcedure

	/**
	 * This function is used add "select one ..." in the list used for combo
	 * pouplation.
	 *
	 * @param amap
	 * @return List containes the combo data.
	 */
	private List addSelectOne(Map amap) {
		List lst = (List) amap.get(P_O_V.REF_CURSOR_DATA);
		if (lst == null) {
			lst = new ArrayList(0);
		}
		lst.add(0, new ComboVO(BLANK, SELECT_ONE));
		return lst;
	} // addSelectOne

	/**
	 * This Function used to populate Comob data, get data from DB.
	 *
	 * @param arrParam
	 * @param procedureName
	 * @return List containes the combo data.
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public List getComboDataFromDB(String[][] arrParam, String procedureName)
			throws BusinessException, DataAccessException {

		// ----------------------- default row mapper class is ComboRowMapper
		return getDataFromDB(arrParam, procedureName, new ComboRowMapper(), true);
	} // getDataFromDB

	/**
	 * This Function used to populate Comob data, get data from DB.
	 *
	 * @param arrParam
	 * @param procedureName
	 * @return List containes the combo data.
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public List getComboDataFromDB(String[][] arrParam, String procedureName, boolean isAddSelectOne)
			throws BusinessException, DataAccessException {

		// ----------------------- default row mapper class is ComboRowMapper
		return getDataFromDB(arrParam, procedureName, new ComboRowMapper(), isAddSelectOne);
	} // getDataFromDB

	/**
	 * This Function used to populate Comob data, get data from DB.
	 *
	 * @param arrParam
	 * @param procedureName
	 * @param objectRowMapper
	 * @return List containes the combo data.
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public List getDataFromDB(String[][] arrParam, String procedureName, JdbcRowMapper objectRowMapper)
			throws BusinessException, DataAccessException {
		return getDataFromDB(arrParam, procedureName, objectRowMapper, false);
	}

	/**
	 * This Function used to populate Comob data, get data from DB.
	 *
	 * @param arrParam
	 * @param procedureName
	 * @param objectRowMapper
	 * @return List containes the combo data.
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public List getDataFromDB(String[][] arrParam, String procedureName, JdbcRowMapper objectRowMapper,
			Boolean isAddSelectOne) throws BusinessException, DataAccessException {
		// ---------------------- map to hold parameter details
		Map mapResult = new HashMap(0);
		// ---------------------- other DB trip details
		mapResult.put(KEY_PROC_NAME, procedureName);
		mapResult.put(KEY_MAPPER_CLASS, objectRowMapper);
		mapResult.put(KEY_PROC_PARAMS, arrParam);

		// ---------------------- excecute procedure
		// mapResult = executeDbProcedure(mapResult);

		if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_SHIPMENT_TERM_COMBO".equals(procedureName)) {
			// mapResult.put("p_i_v_user_id", arrParam[0][0]);
			PRE_GET_SHIPMENT_TERM_COMBO prgShipment = new PRE_GET_SHIPMENT_TERM_COMBO(getJdbcTemplate(), mapResult);
			prgShipment.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_QUOTATION_COMBO".equals(procedureName)) {
			mapResult.put("p_i_v_user_id", arrParam[0][3]);
			PRE_GET_QUOTATION_COMBO prg = new PRE_GET_QUOTATION_COMBO(getJdbcTemplate(), mapResult);
			prg.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_ORIGIN_COUNTRY_COMBO".equals(procedureName)) {
			mapResult.put("P_I_V_REP_FLAG", arrParam[2][3]);
			mapResult.put("P_I_V_REP_CODE", arrParam[3][3]);
			mapResult.put("P_I_V_USER_ID", arrParam[4][3]);
			mapResult.put("P_I_V_PORT_OF_LOADING", arrParam[5][3]);
			PRE_GET_ORIGIN_COUNTRY_COMBO prgountyode = new PRE_GET_ORIGIN_COUNTRY_COMBO(getJdbcTemplate(), mapResult);
			prgountyode.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_DSTNTN_CNTRY_COMBO".equals(procedureName)) {
			mapResult.put("P_I_V_REP_FLAG", arrParam[2][3]);
			mapResult.put("P_I_V_REP_CODE", arrParam[3][3]);
			mapResult.put("P_I_V_USER_ID", arrParam[4][3]);
			mapResult.put("P_I_V_PORT_OF_DISCHARGE", arrParam[5][3]);
			PRE_GET_DSTNTN_CNTRY_COMBO prgdstntncountry = new PRE_GET_DSTNTN_CNTRY_COMBO(getJdbcTemplate(), mapResult);
			prgdstntncountry.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PLACE_OF_RECEIPT".equals(procedureName)) {
			mapResult.put("P_I_V_PORT_OF_LOADING", arrParam[0][3]);
			PRE_GET_PLACE_OF_RECEIPT prgPlsRecetpt = new PRE_GET_PLACE_OF_RECEIPT(getJdbcTemplate(), mapResult);
			prgPlsRecetpt.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PORT_OF_LOADING".equals(procedureName)) {

			mapResult.put("P_I_V_REP_FLAG", arrParam[3][3]);
			mapResult.put("P_I_V_REP_CODE", arrParam[4][3]);
			mapResult.put("P_I_V_USER_ID", arrParam[5][3]);
			mapResult.put("P_I_V_COUNTRY_CODE", arrParam[0][3]);
			mapResult.put("P_I_V_PORT_OF_LOADING", arrParam[6][3]);
			PRE_GET_PORT_OF_LOADING prgPortLoading = new PRE_GET_PORT_OF_LOADING(getJdbcTemplate(), mapResult);
			prgPortLoading.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_EMPTY_PICKUP_DEPOT".equals(procedureName)) {
			mapResult.put("P_I_V_COUNTRY_CODE", arrParam[0][3]);
			mapResult.put("P_I_V_PORT_OF_LOADING", arrParam[3][3]);
			PRE_GET_EMPTY_PICKUP_DEPOT prgMTPickupDepot = new PRE_GET_EMPTY_PICKUP_DEPOT(getJdbcTemplate(), mapResult);
			prgMTPickupDepot.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PORT_OF_DISCHARGE".equals(procedureName)) {
			mapResult.put("P_I_V_REP_FLAG", arrParam[3][3]);
			mapResult.put("P_I_V_REP_CODE", arrParam[4][3]);
			mapResult.put("P_I_V_USER_ID", arrParam[5][3]);
			mapResult.put("P_I_V_COUNTRY_CODE", arrParam[0][3]);
			mapResult.put("P_I_V_PORT_OF_DISCHARGE", arrParam[6][3]);
			PRE_GET_PORT_OF_DISCHARGE prgPod = new PRE_GET_PORT_OF_DISCHARGE(getJdbcTemplate(), mapResult);
			prgPod.executeDbProcedure();
		} else if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_ESERVICE_ONLOAD_DATA".equals(procedureName)) {
			mapResult.put("P_I_V_USER_ID", arrParam[0][3]);
			mapResult.put("P_I_V_PORT_OF_LOADING", arrParam[1][3]);
			PRE_GET_ESERVICE_ONLOAD_DATA prgOnLoad = new PRE_GET_ESERVICE_ONLOAD_DATA(getJdbcTemplate(), mapResult);
			prgOnLoad.executeDbProcedure();
		} else if ("PCR_ESV_WEB_BKG.PRR_ESV_GET_EQUIP_TYPE".equals(procedureName)) {
			mapResult.put("P_I_V_COL_NAME", arrParam[1][3]);
			mapResult.put("P_I_V_COL_VAL", arrParam[2][3]);
            mapResult.put("P_I_V_SORT_BY", arrParam[3][3]);
            mapResult.put("P_I_V_ORDER_BY", arrParam[4][3]);
            mapResult.put("P_I_V_WILD_CARD", arrParam[5][3]);
            mapResult.put("P_I_V_KEY_SEARCH",  "N");
            
            PRR_ESV_GET_EQUIP_TYPE proc=new PRR_ESV_GET_EQUIP_TYPE(getJdbcTemplate(),mapResult);
            proc.executeDbProcedure(); 
		}

		mapResult = (Map) mapResult.get(KEY_PROCE_EXCECTION_RESULT_MAP);

		// ---------------------- get return result

		if (isAddSelectOne) {
			return addSelectOne(mapResult);
		} else {
			return (List) mapResult.get(P_O_V.REF_CURSOR_DATA);
		}
	} // getDataFromDB

	/**
	 * Save equipment size type details.
	 *
	 * @param eserviceNewWebBookingUim
	 * @return
	 * @throws Exception 
	 */
	public Map saveEquipmentDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws Exception {
		Map map = new HashMap(0);

		try {
			saveEquipment(eserviceNewWebBookingUim);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return map;

	}

	/* Begin @06 */
	/**
	 * Save commodity details.
	 *
	 * @param eserviceNewWebBookingUim
	 * @return
	 * @throws Exception 
	 */
	public Map saveCommodityDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws Exception {
		System.out.println("[EserviceNewWebBookingDaoImpl][saveCommodityDetails][Begin]");
		// ------------------------ variable declaration
		String bookingNo = null;
		String line = null;
		String trade = null;
		String agent = null;
		String seq = null;
		String commodityGroup = null;
		String grossWeight = null;
		String specialCargoChkBox = null;
		String specialInstruction = null;
		String loginId = null;
		String YES = "Y";
		String REFER = "RF";
		String DG = "D1";
		String OOG = "O0";
		int lintCount = 0;
		List lstTableData = null;
		double sumOfWeight = 0;
		Map map = new HashMap(0);
		EserviceCommodityDetailsMod objMod = null;
		EserviceReferCommoditiesUim eserviceReferCommoditiesUim = null;
		EserviceDGCommoditiesUim eserviceDGCommoditiesUim = null;
		EserviceOOGCommoditiesUim eserviceOOGCommoditiesUim = null;
		String rateType = null;
		String errMsg = null;

		/* Begin Refer */
		String temperature = BLANK;
		String ventilation = BLANK;
		String remark = BLANK;
		String humidity = BLANK;
		String controlledAtmosphere = BLANK;
		String nitrogen = BLANK;
		String oxygent = BLANK;
		String co2 = BLANK;
		String refMode = BLANK;
		String preCooled = BLANK;
		/* End Refer */
		/* Begin DG */
		String flashPoint = BLANK;
		String unitMeasurement = BLANK;
		String unNo = BLANK;
		String variant = BLANK;
		String imdgClass = BLANK;
		String portClass = BLANK;
		String residue = BLANK;
		String fumigration = BLANK;
		/* End DG */
		/* Begin OOG */
		String txtLength = BLANK;
		String txtWidth = BLANK;
		String txtHeight = BLANK;
		String txtDiameter = BLANK;
		/* End OOG */

		try {
			// ------------------------ variable initialization
			bookingNo = eserviceNewWebBookingUim.getBookingNo();
			line = eserviceNewWebBookingUim.getLine();
			trade = eserviceNewWebBookingUim.getTrade();
			agent = eserviceNewWebBookingUim.getAgent();
			loginId = eserviceNewWebBookingUim.getUserId();
			lstTableData = eserviceNewWebBookingUim.getCommodityVoDataList();

			
			System.out.println("[EserviceNewWebBookingDaoImpl][saveCommodityDetails] lstTableData :: " + lstTableData);
			String sqlDelete = "delete from  SEALINER.BKP050 where bwbkno='" + bookingNo + "'";
			getJdbcTemplate().update(sqlDelete);

			sqlDelete = "delete from  SEALINER.BKP007 where BGBKNO='" + bookingNo + "'";
			getJdbcTemplate().update(sqlDelete);
			
			sqlDelete =  "delete from  SEALINER.BOOKING_RFR_COMM_DETAIL where BOOKING_NO='" + bookingNo + "'";
			getJdbcTemplate().update(sqlDelete);
			// ---------------------- traverse to each cargo record.
			while (lintCount < lstTableData.size()) {

				// ---------------------- get object of vo.
				objMod = (EserviceCommodityDetailsMod) lstTableData.get(lintCount);
				// ---------------------- get screen data.
				seq = String.valueOf(objMod.getSeqNo());
				commodityGroup = objMod.getGroup();
				specialInstruction = objMod.getSpecialInstruction().replaceAll("'", "\\\\'");
				grossWeight = objMod.getGrossWeight();
				specialCargoChkBox = objMod.getSpecialCargo();
				grossWeight = removeComma(grossWeight);
				rateType = objMod.getRateType();
				

				temperature = BLANK;
				ventilation = BLANK;
				remark = BLANK;
				humidity = BLANK;
				controlledAtmosphere = BLANK;
				nitrogen = BLANK;
				oxygent = BLANK;
				co2 = BLANK;
				refMode = BLANK;
				preCooled = BLANK;
				flashPoint = BLANK;
				unitMeasurement = BLANK;
				unNo = BLANK;
				variant = BLANK;
				imdgClass = BLANK;
				portClass = BLANK;
				residue = BLANK;
				fumigration = BLANK;
				txtLength = BLANK;
				txtWidth = BLANK;
				txtHeight = BLANK;
				txtDiameter = BLANK;

				if ((null != grossWeight) && (!grossWeight.equals(BLANK))) {
					sumOfWeight = sumOfWeight + Double.parseDouble(grossWeight);
				}

				System.out.println("[EserviceNewWebBookingDaoImpl][saveCommodityDetails] specialCargoChkBox :: "
						+ specialCargoChkBox);

				if (specialCargoChkBox.equalsIgnoreCase(YES)) {
					System.out.println("[EserviceNewWebBookingDaoImpl][saveCommodityDetails] rateType :: " + rateType);
					if (rateType.equalsIgnoreCase(REFER)) {
						eserviceReferCommoditiesUim = objMod.getEserviceReferCommoditiesUim();
						if (eserviceReferCommoditiesUim != null) {
							temperature = eserviceReferCommoditiesUim.getTemperature();
							ventilation = eserviceReferCommoditiesUim.getVentilation();
							remark = eserviceReferCommoditiesUim.getRemark();
							humidity = eserviceReferCommoditiesUim.getHumidity();
							controlledAtmosphere = eserviceReferCommoditiesUim.getControlledAtmosphere();
							nitrogen = eserviceReferCommoditiesUim.getNitrogen();
							oxygent = eserviceReferCommoditiesUim.getOxygent();
							co2 = eserviceReferCommoditiesUim.getCo2();
							refMode = eserviceReferCommoditiesUim.getRefMode();
							preCooled = eserviceReferCommoditiesUim.getPreCooled();
						}
					} else if (rateType.equalsIgnoreCase(DG)) {
						eserviceDGCommoditiesUim = objMod.getEserviceDGCommoditiesUim();
						if (eserviceDGCommoditiesUim != null) {
							flashPoint = eserviceDGCommoditiesUim.getFlashPoint();
							unitMeasurement = eserviceDGCommoditiesUim.getUnitMeasurement();
							unNo = eserviceDGCommoditiesUim.getUnNo();
							variant = eserviceDGCommoditiesUim.getVariant();
							imdgClass = eserviceDGCommoditiesUim.getImdgClass();
							portClass = eserviceDGCommoditiesUim.getPortClass();
							residue = eserviceDGCommoditiesUim.getResidue();
							fumigration = eserviceDGCommoditiesUim.getFumigration();
						}
					} else if (rateType.equalsIgnoreCase(OOG)) {
						eserviceOOGCommoditiesUim = objMod.getEserviceOOGCommoditiesUim();
						if (eserviceOOGCommoditiesUim != null) {
							txtLength = eserviceOOGCommoditiesUim.getTxtLength();
							txtWidth = eserviceOOGCommoditiesUim.getTxtWidth();
							txtHeight = eserviceOOGCommoditiesUim.getTxtHeight();
							txtDiameter = eserviceOOGCommoditiesUim.getTxtDiameter();
						}
					}
				}

				// ---------------------- map to hold parameter details
				// System.out.println("objMod.getRecordStatus()
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+objMod.getRecordStatus());
				if (objMod.getRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.ADD_OPERATION)) {
					// ----------------------
					// add new cargo detail.
					// ----------------------
					System.out.println(
							"[EserviceNewWebBookingDaoImpl][saveCommodityDetails] Begin ADD COMMODITY LOGIC CALLED");
					System.out.println(grossWeight);

					// ---------------------- String array to hold procedure parameter
					/*
					 * String[][] arrParam = // @04 BEGIN checkDoubleValueNumber(grossWeight) // @04
					 * END { { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo }, {
					 * P_I_V.LINE, BLANK + ORACLE_VARCHAR, PARAM_IN, line }, { P_I_V.TRADE, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, trade }, { P_I_V.AGENT, BLANK + ORACLE_VARCHAR,
					 * PARAM_IN, agent }, { P_I_V.SEQ, BLANK + ORACLE_NUMBER, PARAM_IN, seq }, {
					 * P_I_V.COMMODITY_GROUP, BLANK + ORACLE_VARCHAR, PARAM_IN, commodityGroup }, {
					 * P_I_V.GROSS_WEIGHT, BLANK + ORACLE_VARCHAR, PARAM_IN,
					 * checkDoubleValueNumber(grossWeight) }, { P_I_V.SPECIAL_FLAG, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, specialCargoChkBox }, { P_I_V.SPECIAL_INSTRUCTION,
					 * BLANK + ORACLE_VARCHAR, PARAM_IN, specialInstruction }, { P_I_V.USER_ID,
					 * BLANK + ORACLE_VARCHAR, PARAM_IN, loginId }, { P_O_V.ERROR, BLANK +
					 * ORACLE_VARCHAR, PARAM_OUT, BLANK }, { P_I_V.RATE_TYPE, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, rateType }, { P_I_V.RF_TEMP, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, temperature }, { P_I_V.RF_VENTILATION, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, ventilation }, { P_I_V.RF_REMARK, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, remark }, { P_I_V.RF_HUMIDITY, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, humidity }, { P_I_V.RF_CON_ATM, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, controlledAtmosphere }, { P_I_V.RF_NITROGEN, BLANK
					 * + ORACLE_VARCHAR, PARAM_IN, nitrogen }, { P_I_V.RF_OXYGEN, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, oxygent }, { P_I_V.RF_CO2, BLANK + ORACLE_VARCHAR,
					 * PARAM_IN, co2 }, { P_I_V.RF_REFR_MODE, BLANK + ORACLE_VARCHAR, PARAM_IN,
					 * refMode }, { P_I_V.RF_PRE_COOL, BLANK + ORACLE_VARCHAR, PARAM_IN, preCooled
					 * }, { P_I_V.DG_FLASH_POINT, BLANK + ORACLE_VARCHAR, PARAM_IN, flashPoint }, {
					 * P_I_V.DG_UNIT, BLANK + ORACLE_VARCHAR, PARAM_IN, unitMeasurement }, {
					 * P_I_V.DG_UNNO, BLANK + ORACLE_VARCHAR, PARAM_IN, unNo }, { P_I_V.DG_VARINT,
					 * BLANK + ORACLE_VARCHAR, PARAM_IN, variant }, { P_I_V.DG_IMDG, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, imdgClass }, { P_I_V.PORT_CLASS, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, portClass }, { P_I_V.DG_RESIDUE, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, residue }, { P_I_V.DG_FUMIGATION, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, fumigration }, { P_I_V.OOG_LENGTH, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, txtLength }, { P_I_V.OOG_WIDTH, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, txtWidth }, { P_I_V.OOG_HEIGHT, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, txtHeight }, { P_I_V.OOG_DIAMETER, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, txtDiameter }, };
					 * 
					 * // ---------------------- other procedure details map.put(KEY_PROC_NAME,
					 * PCR_ESV_NEW_WEB_BOOKING.PRE_SAVE_COMMODITY_DATA); map.put(KEY_PROC_PARAMS,
					 * arrParam);
					 */

					// ---------------------- excecute procedure
					// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

					map.put("P_I_V_BOOKING_NO", bookingNo);
					map.put("P_I_V_LINE", line);
					map.put("P_I_V_TRADE", trade);
					map.put("P_I_V_AGENT", agent);
					map.put("P_I_V_SEQ", converNo(seq));
					map.put("P_I_V_COMMODITY_GROUP", commodityGroup);
					map.put("P_I_V_GROSS_WEIGHT", checkDoubleValueNumber(grossWeight));
					map.put("P_I_V_SPECIAL_FLAG", specialCargoChkBox);
					map.put("P_I_V_SPECIAL_INSTRUCTION", specialInstruction);
					map.put("P_I_V_USER_ID", loginId);

					map.put("P_I_V_RATE_TYPE", rateType);
					map.put("P_I_V_RF_TEMP", converNo(temperature)); 
					map.put("P_I_V_RF_VENTILATION", converNo(ventilation)); 
					map.put("P_I_V_RF_REMARK", remark);
					map.put("P_I_V_RF_HUMIDITY", converNo(humidity)); 
					map.put("P_I_V_RF_CON_ATM", controlledAtmosphere);
					map.put("P_I_V_RF_NITROGEN", converNo(nitrogen)); 
					map.put("P_I_V_RF_OXYGEN", converNo(oxygent)); 
					map.put("P_I_V_RF_CO2", converNo(co2)); 
					map.put("P_I_V_RF_REFR_MODE", refMode);
					map.put("P_I_V_RF_PRE_COOL", preCooled);
					map.put("P_I_V_DG_FLASH_POINT", converNo(flashPoint));
					map.put("P_I_V_DG_UNIT", unitMeasurement);
					map.put("P_I_V_DG_UNNO", unNo);
					map.put("P_I_V_DG_VARINT", variant);
					map.put("P_I_V_DG_IMDG", imdgClass);
					map.put("P_I_V_PORT_CLASS", portClass);
					map.put("P_I_V_DG_RESIDUE", residue);
					map.put("P_I_V_DG_FUMIGATION", fumigration);
					map.put("P_I_V_OOG_LENGTH", converNo(txtLength)); 
					map.put("P_I_V_OOG_WIDTH", converNo(txtWidth)); 
					map.put("P_I_V_OOG_HEIGHT", converNo(txtHeight)); 
					map.put("P_I_V_OOG_DIAMETER", converNo(txtDiameter)); 

					PRE_SAVE_COMMODITY_DATA prcCommditySav = new PRE_SAVE_COMMODITY_DATA(getJdbcTemplate(), map);
					prcCommditySav.executeDbProcedure();
					errMsg = (String) map.get(P_O_V.ERROR);

					System.out.println(
							"[EserviceNewWebBookingDaoImpl][saveCommodityDetails] End ADD COMMODITY LOGIC CALLED");

				} else if (objMod.getRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.UPD_OPERATION)) {
					// ----------------------
					// add old cargo detail.
					// ----------------------
					System.out.println(
							"[EserviceNewWebBookingDaoImpl][saveCommodityDetails] Begin UPD COMMODITY LOGIC CALLED");
					System.out.println(grossWeight);

					/*
					 * String[][] arrParam = // @04 BEGIN checkDoubleValueNumber(grossWeight) // @04
					 * END { { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo }, {
					 * P_I_V.SEQ, BLANK + ORACLE_NUMBER, PARAM_IN, seq }, { P_I_V.COMMODITY_GROUP,
					 * BLANK + ORACLE_VARCHAR, PARAM_IN, commodityGroup }, { P_I_V.GROSS_WEIGHT,
					 * BLANK + ORACLE_VARCHAR, PARAM_IN, checkDoubleValueNumber(grossWeight) }, {
					 * P_I_V.SPECIAL_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, specialCargoChkBox }, {
					 * P_I_V.SPECIAL_INSTRUCTION, BLANK + ORACLE_VARCHAR, PARAM_IN,
					 * specialInstruction }, { P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN,
					 * loginId }, { P_O_V.ERROR, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, {
					 * P_I_V.RATE_TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, rateType }, {
					 * P_I_V.RF_TEMP, BLANK + ORACLE_VARCHAR, PARAM_IN, temperature }, {
					 * P_I_V.RF_VENTILATION, BLANK + ORACLE_VARCHAR, PARAM_IN, ventilation }, {
					 * P_I_V.RF_REMARK, BLANK + ORACLE_VARCHAR, PARAM_IN, remark }, {
					 * P_I_V.RF_HUMIDITY, BLANK + ORACLE_VARCHAR, PARAM_IN, humidity }, {
					 * P_I_V.RF_CON_ATM, BLANK + ORACLE_VARCHAR, PARAM_IN, controlledAtmosphere }, {
					 * P_I_V.RF_NITROGEN, BLANK + ORACLE_VARCHAR, PARAM_IN, nitrogen }, {
					 * P_I_V.RF_OXYGEN, BLANK + ORACLE_VARCHAR, PARAM_IN, oxygent }, { P_I_V.RF_CO2,
					 * BLANK + ORACLE_VARCHAR, PARAM_IN, co2 }, { P_I_V.RF_REFR_MODE, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, refMode }, { P_I_V.RF_PRE_COOL, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, preCooled }, { P_I_V.DG_FLASH_POINT, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, flashPoint }, { P_I_V.DG_UNIT, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, unitMeasurement }, { P_I_V.DG_UNNO, BLANK +
					 * ORACLE_VARCHAR, PARAM_IN, unNo }, { P_I_V.DG_VARINT, BLANK + ORACLE_VARCHAR,
					 * PARAM_IN, variant }, { P_I_V.DG_IMDG, BLANK + ORACLE_VARCHAR, PARAM_IN,
					 * imdgClass }, { P_I_V.PORT_CLASS, BLANK + ORACLE_VARCHAR, PARAM_IN, portClass
					 * }, { P_I_V.DG_RESIDUE, BLANK + ORACLE_VARCHAR, PARAM_IN, residue }, {
					 * P_I_V.DG_FUMIGATION, BLANK + ORACLE_VARCHAR, PARAM_IN, fumigration }, {
					 * P_I_V.OOG_LENGTH, BLANK + ORACLE_VARCHAR, PARAM_IN, txtLength }, {
					 * P_I_V.OOG_WIDTH, BLANK + ORACLE_VARCHAR, PARAM_IN, txtWidth }, {
					 * P_I_V.OOG_HEIGHT, BLANK + ORACLE_VARCHAR, PARAM_IN, txtHeight }, {
					 * P_I_V.OOG_DIAMETER, BLANK + ORACLE_VARCHAR, PARAM_IN, txtDiameter }, };
					 * 
					 * // ---------------------- other procedure details map.put(KEY_PROC_NAME,
					 * PCR_ESV_NEW_WEB_BOOKING.PRE_UPD_COMMODITY_DATA); map.put(KEY_PROC_PARAMS,
					 * arrParam);
					 */

					// ---------------------- excecute procedure
					// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

					map.put("P_I_V_BOOKING_NO", bookingNo);
					map.put("P_I_V_LINE", line);
					map.put("P_I_V_TRADE", trade);
					map.put("P_I_V_AGENT", agent);
					map.put("P_I_V_SEQ", converNo(seq));
					map.put("P_I_V_COMMODITY_GROUP", commodityGroup);
					map.put("P_I_V_GROSS_WEIGHT", checkDoubleValueNumber(grossWeight));
					map.put("P_I_V_SPECIAL_FLAG", specialCargoChkBox);
					map.put("P_I_V_SPECIAL_INSTRUCTION", specialInstruction);
					map.put("P_I_V_USER_ID", loginId);

					map.put("P_I_V_RATE_TYPE", rateType);
					map.put("P_I_V_RF_TEMP", converNo(temperature)); 
					map.put("P_I_V_RF_VENTILATION", converNo(ventilation)); 
					map.put("P_I_V_RF_REMARK", remark);
					map.put("P_I_V_RF_HUMIDITY", converNo(humidity)); 
					map.put("P_I_V_RF_CON_ATM", controlledAtmosphere);
					map.put("P_I_V_RF_NITROGEN", converNo(nitrogen)); 
					map.put("P_I_V_RF_OXYGEN", converNo(oxygent)); 
					map.put("P_I_V_RF_CO2", converNo(co2)); 
					map.put("P_I_V_RF_REFR_MODE", refMode);
					map.put("P_I_V_RF_PRE_COOL", preCooled);
					map.put("P_I_V_DG_FLASH_POINT", converNo(flashPoint));
					map.put("P_I_V_DG_UNIT", unitMeasurement);
					map.put("P_I_V_DG_UNNO", unNo);
					map.put("P_I_V_DG_VARINT", variant);
					map.put("P_I_V_DG_IMDG", imdgClass);
					map.put("P_I_V_PORT_CLASS", portClass);
					map.put("P_I_V_DG_RESIDUE", residue);
					map.put("P_I_V_DG_FUMIGATION", fumigration);
					map.put("P_I_V_OOG_LENGTH", converNo(txtLength)); 
					map.put("P_I_V_OOG_WIDTH", converNo(txtWidth)); 
					map.put("P_I_V_OOG_HEIGHT", converNo(txtHeight)); 
					map.put("P_I_V_OOG_DIAMETER", converNo(txtDiameter)); 
					
					PRE_UPD_COMMODITY_DATA prcCommdityadd = new PRE_UPD_COMMODITY_DATA(getJdbcTemplate(), map);
					prcCommdityadd.executeDbProcedure();
					errMsg = (String) map.get(P_O_V.ERROR);

					System.out.println(
							"[EserviceNewWebBookingDaoImpl][saveCommodityDetails] End UPD COMMODITY LOGIC CALLED");
				}

				System.out.println("[EserviceNewWebBookingDaoImpl][saveCommodityDetails] errMsg :: " + errMsg);
				if (errMsg != null && !errMsg.equals("") && !errMsg.equals("000000")) {
					throw new CustomDataAccessException(errMsg);
				}

				lintCount++;
			}
		} catch (CustomDataAccessException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][saveCommodityDetails][End]");
		}
		// ---------------------- returned result Map.
		return map;

	}
	/* End @06 */

	/* Begin @06 */
	/**
	 * Save upload document.
	 *
	 * @param eserviceNewWebBookingUim
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map saveUploadDocument(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException,Exception {
		System.out.println("[EserviceNewWebBookingDaoImpl][saveUploadDocument][Begin]");

		Map resultMap = null;
		Map map = new HashMap(0);
		JdbcStoredProcedure storedProcedure = null;
		String bookingNo = null;
		String loginId = null;
		String errMsg = null;
		String upldSeq = null;
		EserviceUploadUim eserviceUploadUim = null;
		EserviceUploadMod eserviceUploadMod = null;
		List lst = new ArrayList<>();
		String uploadFlag = null;
		String fileName = null;
		String filePathConf = null;
		String newFileName = null;
		String fileType = null;
		File newFile = null;
		FileOutputStream fos = null;
		String status = null;

		try {
			FtpConfig ftfConfig = (FtpConfig) EZLBeanFactory.getBean("ftpConfig");
			//filePathConf = ftfConfig.getFileuploadlocation();
			filePathConf=EservicePropertyFatchOperation.getFileLocation();
			bookingNo = eserviceNewWebBookingUim.getBookingNo();
			loginId = eserviceNewWebBookingUim.getUserId();
			uploadFlag = eserviceNewWebBookingUim.getUploadFlag();
			eserviceUploadUim = eserviceNewWebBookingUim.getEserviceUploadUim();
			// sushil need to visit
			if (eserviceUploadUim != null) {
				lst = eserviceUploadUim.getList();
			}
			if (uploadFlag.equalsIgnoreCase("Y") && lst.size() > 0) {

				String[][] arrayHdr = { { "P_I_V_BOOKING_NO", BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
						{ "P_I_V_MODULE", BLANK + ORACLE_VARCHAR, PARAM_IN, "ESV" },
						{ "P_I_V_USER_ID", BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
						{ "P_O_V_UPLD_SEQ", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
						{ "P_O_V_ERR_CD", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
						{ "P_O_V_ERR_DESC", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

				storedProcedure = getStoreProcedure("PCR_ESV_WEB_BKG.PRR_ESV_INS_UPLOAD_HDR", null, arrayHdr);
				resultMap = new HashMap();
				resultMap.put("P_I_V_BOOKING_NO", bookingNo);
				resultMap.put("P_I_V_MODULE", "ESV");
				resultMap.put("P_I_V_USER_ID", loginId);
				if (storedProcedure != null) {
					PRR_ESV_INS_UPLOAD_HDR proc = new PRR_ESV_INS_UPLOAD_HDR(getJdbcTemplate(), resultMap);
					proc.executeDbProcedure();
					// resultMap = storedProcedure.execute();

					if (resultMap != null && !resultMap.isEmpty()) {
						errMsg = (String) resultMap.get("P_O_V_ERR_DESC");
						upldSeq = (String) resultMap.get("P_O_V_UPLD_SEQ");

						System.out.println("[EserviceNewWebBookingDaoImpl][saveUploadDocument] errMsg :: " + errMsg);
						System.out.println("[EserviceNewWebBookingDaoImpl][saveUploadDocument] upldSeq :: " + upldSeq);

						if (errMsg == null || errMsg.equals("")) {
							for (int i = 0; i < lst.size(); i++) {
								eserviceUploadMod = (EserviceUploadMod) lst.get(i);
								status = eserviceUploadMod.getStatus();
								newFileName = eserviceUploadMod.getNewFileName();
								fileType = eserviceUploadMod.getFileType();
								fileName = eserviceUploadMod.getFileName() + "::" + newFileName;

								if (status.equals(EserviceNewWebBookingDao.ADD_OPERATION)) {
									String[][] arrayDtl = {
											{ "P_I_V_BOOKING_NO", BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
											{ "P_I_V_UPLD_HDR_SEQ", BLANK + ORACLE_VARCHAR, PARAM_IN, upldSeq },
											{ "P_I_V_FILE_NAME", BLANK + ORACLE_VARCHAR, PARAM_IN, fileName },
											{ "P_I_V_USER_ID", BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
											{ "P_I_V_TECHNICAL_FILE_TYPE", BLANK + ORACLE_VARCHAR, PARAM_IN, fileType },
											{ "P_O_V_ERR_CD", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
											{ "P_O_V_ERR_DESC", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

									storedProcedure = getStoreProcedure("PCR_ESV_WEB_BKG.PRR_ESV_INS_UPLOAD_DTL", null,
											arrayDtl);

									resultMap.put("P_I_V_UPLD_HDR_SEQ", upldSeq);
									resultMap.put("P_I_V_FILE_NAME", fileName);
									resultMap.put("P_I_V_TECHNICAL_FILE_TYPE", fileType);

									PRR_ESV_INS_UPLOAD_DTL procUpload = new PRR_ESV_INS_UPLOAD_DTL(getJdbcTemplate(),
											resultMap);
									procUpload.executeDbProcedure();
									// resultMap = storedProcedure.execute();
									errMsg = (String) resultMap.get("P_O_V_ERR_DESC");
									if (errMsg != null && !errMsg.equals("") && !errMsg.equals("000000")) {
										throw new CustomDataAccessException(errMsg);
									} else {
										System.out.println("file upload location : "+filePathConf );
										/*
										 * File createBookingDirectry = new File(filePathConf + File.separator +
										 * bookingNo); if(!createBookingDirectry.exists()) {
										 * createBookingDirectry.mkdirs(); }
										 */
										File createFile = new File(filePathConf + File.separator + newFileName);
										if(createFile.exists()) {
											createFile.delete();
										}
										
										//	newFile = new File(filePathConf, newFileName);
										fos = new FileOutputStream(createFile);

										fos.write(eserviceUploadMod.getDataFile().getFileData());
										fos.flush();
										fos.close();
									}
								}
							}
						}

					}
				}
			}

			map.put(ERR_MSG, BLANK);

		} catch (CustomDataAccessException e) {
			e.printStackTrace();
			map.put(ERR_MSG, e.getMessage());
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			map.put(ERR_MSG, e.getMessage());
			throw e;
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][saveUploadDocument][End]");
		}

		return map;
	}
	/* End @06 */

	/* Begin @06 */
	public String validateDG(EserviceDGCommoditiesUim uim) {
		System.out.println("[EserviceNewWebBookingDaoImpl][validateDG][Begin]");
		Map resultMap = new HashMap();
		JdbcStoredProcedure storedProcedure = null;
		String errMsg = null;
		String unno = null;
		String variant = null;
		String portClass = null;
		String imdg = null;

		try {

			unno = uim.getUnNo();
			variant = uim.getVariant();
			portClass = uim.getPortClass();
			imdg = uim.getImdgClass();

			String[][] array = { { "P_I_V_UNNO", BLANK + ORACLE_VARCHAR, PARAM_IN, unno },
					{ "P_I_V_VARIANT", BLANK + ORACLE_VARCHAR, PARAM_IN, variant },
					{ "P_I_V_PORT_CLASS", BLANK + ORACLE_VARCHAR, PARAM_IN, portClass },
					{ "P_I_V_IMDG", BLANK + ORACLE_VARCHAR, PARAM_IN, imdg },
					{ "P_O_V_ERR_DESC", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

			
			resultMap.put("P_I_V_UNNO", unno);
			resultMap.put("P_I_V_VARIANT", variant);
			resultMap.put("P_I_V_PORT_CLASS", portClass);
			resultMap.put("P_I_V_IMDG", imdg);
			
			PRR_ESV_DG_VALIDATE proc=new PRR_ESV_DG_VALIDATE(getJdbcTemplate(),resultMap);
			proc.executeDbProcedure();
			//storedProcedure = getStoreProcedure("PCR_ESV_WEB_BKG.PRR_ESV_DG_VALIDATE", null, array);

			//resultMap = storedProcedure.execute();
			errMsg = (String) resultMap.get("P_O_V_ERR_DESC");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][validateDG][End]");
		}

		return errMsg;
	}
	/* End @06 */

	// /**
	// * Save commodity details.
	// *
	// * @param eserviceNewWebBookingUim
	// * @return
	// * @throws BusinessException
	// * @throws DataAccessException
	// */
	// public Map saveCommodityDetails(EserviceNewWebBookingUim
	// eserviceNewWebBookingUim) throws BusinessException, DataAccessException{
	// //------------------------ variable declaration
	// String bookingNo = null;
	// String line = null;
	// String trade = null;
	// String agent = null;
	// // String cargoDescription = null;
	// String seq = null;
	// String commodityGroup = null;
	// String grossWeight = null;
	// String specialCargoChkBox = null;
	// String specialInstruction = null;
	// String loginId = null;
	// String NO = "N";
	// String YES = "Y";
	// String ON = "on";
	// int lintCount = 0;
	// List lstTableData = null;
	// double sumOfWeight = 0;
	// Map map = new HashMap(0);
	//
	// //------------------------ variable initialization
	// bookingNo = eserviceNewWebBookingUim.getBookingNo();
	// line = eserviceNewWebBookingUim.getLine();
	// trade = eserviceNewWebBookingUim.getTrade();
	// agent = eserviceNewWebBookingUim.getAgent();
	// // cargoDescription = eserviceNewWebBookingUim.getCargoDescription();
	// loginId = eserviceNewWebBookingUim.getUserId();
	// lstTableData = eserviceNewWebBookingUim.getCommodityVoDataList();
	// // specialInstruction = eserviceNewWebBookingUim.getSpecialInstruction();
	//
	// //---------------------- traverse to each cargo record.
	// while(lintCount<lstTableData.size()){
	//
	// //---------------------- get object of vo.
	// EserviceCommodityDetailsMod objMod = (EserviceCommodityDetailsMod)
	// lstTableData.get(lintCount);
	//
	// //---------------------- get screen data.
	// seq = String.valueOf(objMod.getSeqNo());
	// commodityGroup = objMod.getGroup();
	//
	// specialInstruction = objMod.getSpecialInstruction();
	//
	// System.out.println("commodity group: "+commodityGroup);
	//
	// grossWeight = objMod.getGrossWeight();
	// specialCargoChkBox = objMod.getSpecialCargo();
	//
	//
	// //---------------------- set parameter value according to checkbox.
	// if(specialCargoChkBox==null){
	// specialCargoChkBox = NO;
	// } else if(specialCargoChkBox.equals(ON)){
	// specialCargoChkBox = YES;
	// } else {
	// specialCargoChkBox = NO;
	// }
	//
	// grossWeight = removeComma(grossWeight);
	// if((null!=grossWeight)&&(!grossWeight.equals(BLANK))){
	// sumOfWeight = sumOfWeight+Double.parseDouble(grossWeight);
	// }
	//
	// //---------------------- map to hold parameter details
	// // System.out.println("objMod.getRecordStatus()
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+objMod.getRecordStatus());
	// if(objMod.getRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.ADD_OPERATION)){
	// //----------------------
	// // add new cargo detail.
	// //----------------------
	// System.out.println("%%%%%ADD COMMODITY LOGIC CALLED");
	// System.out.println(grossWeight);
	//
	// //---------------------- String array to hold procedure parameter
	// String[][] arrParam =
	// //@04 BEGIN checkDoubleValueNumber(grossWeight)
	// //@04 END
	// {
	// { P_I_V.BOOKING_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, bookingNo },
	// { P_I_V.LINE, BLANK+ORACLE_VARCHAR, PARAM_IN, line },
	// { P_I_V.TRADE, BLANK+ORACLE_VARCHAR, PARAM_IN, trade },
	// { P_I_V.AGENT, BLANK+ORACLE_VARCHAR, PARAM_IN, agent },
	// { P_I_V.SEQ, BLANK+ORACLE_NUMBER, PARAM_IN, seq },
	// { P_I_V.COMMODITY_GROUP, BLANK+ORACLE_VARCHAR, PARAM_IN, commodityGroup },
	// { P_I_V.GROSS_WEIGHT, BLANK+ORACLE_VARCHAR, PARAM_IN,
	// checkDoubleValueNumber(grossWeight) },
	// { P_I_V.SPECIAL_FLAG, BLANK+ORACLE_VARCHAR, PARAM_IN, specialCargoChkBox },
	// { P_I_V.SPECIAL_INSTRUCTION, BLANK+ORACLE_VARCHAR, PARAM_IN,
	// specialInstruction },
	// { P_I_V.USER_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, loginId },
	// { KEY_ERROR_DATA, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK }
	// };
	//
	// //---------------------- other procedure details
	// map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_SAVE_COMMODITY_DATA);
	// map.put(KEY_PROC_PARAMS, arrParam);
	//
	// //---------------------- excecute procedure
	// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);
	//
	// } else
	// if(objMod.getRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.UPD_OPERATION)){
	// //----------------------
	// // add old cargo detail.
	// //----------------------
	// System.out.println("%%%%%UPD COMMODITY LOGIC CALLED");
	// System.out.println(grossWeight);
	//
	// String[][] arrParam =
	// //@04 BEGIN checkDoubleValueNumber(grossWeight)
	// //@04 END
	// { { P_I_V.BOOKING_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, bookingNo },
	// { P_I_V.SEQ, BLANK+ORACLE_NUMBER, PARAM_IN, seq },
	// { P_I_V.COMMODITY_GROUP, BLANK+ORACLE_VARCHAR, PARAM_IN, commodityGroup },
	// { P_I_V.GROSS_WEIGHT, BLANK+ORACLE_VARCHAR, PARAM_IN,
	// checkDoubleValueNumber(grossWeight) },
	// { P_I_V.SPECIAL_FLAG, BLANK+ORACLE_VARCHAR, PARAM_IN, specialCargoChkBox },
	// { P_I_V.SPECIAL_INSTRUCTION, BLANK+ORACLE_VARCHAR, PARAM_IN,
	// specialInstruction },
	// { P_I_V.USER_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, loginId },
	// { KEY_ERROR_DATA, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK } };
	//
	// //---------------------- other procedure details
	// map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_UPD_COMMODITY_DATA);
	// map.put(KEY_PROC_PARAMS, arrParam);
	//
	// //---------------------- excecute procedure
	// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);
	// }
	//
	// lintCount++;
	// }
	//
	// //---------------------- returned result Map.
	// return map;
	//
	// } // saveCommodityDetails

	/**
	 * Method to send E-Notice, when booking submited successfuly
	 *
	 * @param bookingNo
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map sendEnotice(String bookingNo) throws BusinessException, DataAccessException {
		// ---------------------- map to hold parameter details
		Map map = new HashMap(0);

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_I_V.ENOTICE_BKG_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo } };

		// ---------------------- other procedure details
		map.put(KEY_PROC_NAME, PCE_ENOTICE_WEB_BKG_SUBMISSION.PPRE_RAISE_ENOTICE_WEB_BKG);
		map.put(KEY_PROC_PARAMS, arrParam);

		// ---------------------- excecute procedure
		map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

		// ---------------------- returned result Map.
		return map;

	} // sendEnotice

	/**
	 * Method to get template data when template name change in combo box.
	 *
	 * @param templateName
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map getTemplateOnloadData(String templateName, String userId) throws BusinessException, DataAccessException {

		Map map = new HashMap(0);
		Map ressultMap = new HashMap(0);

		List list = null;

		System.out.println("getTemplateOnloadData >>>>>>>>>>>> " + userId);
		// --------------------------------------------
		// get header data logic start
		// --------------------------------------------

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam = { { P_O_V.HDR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ P_I_V.BKG_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, templateName },
				{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId } };

		// ---------------------- other DB trip details
		map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ERCL_GET_BKG_HDR);
		map.put(KEY_MAPPER_CLASS, new TemplateHDRDataRowMapper());
		map.put(KEY_PROC_PARAMS, arrParam);

		map.put("P_I_V_BKG_NO", arrParam[1][3]);
		map.put("P_I_V_USER_ID", arrParam[2][3]);

		// ---------------------- get data from db.

		// map = executeDbProcedure(map);

		PRR_ERCL_GET_BKG_HDR prcErclObj = new PRR_ERCL_GET_BKG_HDR(getJdbcTemplate(), map);
		prcErclObj.executeDbProcedure();
		list = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get(P_O_V.HDR_DATA);

		// ------------------------ get object of VO
		EserviceNewWebBookingUim objMod = new EserviceNewWebBookingUim();
		EserviceEquipmentDetailsMod objVo = new EserviceEquipmentDetailsMod();

		// ------------------------ get vo object from list
		for (Object obj : list) {
			objMod = (EserviceNewWebBookingUim) obj;
			objMod.setRepresentCompChkBox("N");
		}

		// ------------------------ set result in MAP
		ressultMap.put(KEY_HEADER_DATA, objMod);

		// --------------------------------------------
		// get Size Type data logic start
		// --------------------------------------------

		// ---------------------- String array to hold procedure parameter
		String[][] arrParamOther = { { KEY_REF_PROC_DATA_OUT, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ P_I_V.BKG_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, templateName } };

		// ---------------------- other DB trip details
		map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ERCL_GET_BKG_SIZE_TYPE);
		map.put(KEY_MAPPER_CLASS, new TemplateSizeTypeRowMapper());
		map.put(KEY_PROC_PARAMS, arrParamOther);

		// ---------------------- get data from db.

		// map = executeDbProcedure(map);

		PRR_ERCL_GET_BKG_SIZE_TYPE prcsizeType = new PRR_ERCL_GET_BKG_SIZE_TYPE(getJdbcTemplate(), map);
		prcsizeType.executeDbProcedure();

		list = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get(KEY_REF_PROC_DATA_OUT);

		// ------------------------ get object of VO
		objVo = new EserviceEquipmentDetailsMod();

		// ------------------------ get vo object from list
		// for (Object obj: list) {
		// objVo= (EserviceEquipmentDetailsMod)obj;
		// }
		// ------------------------ set result in map
		System.out.println("[EserviceNewWebBookingDaoImpl][getTemplateOnloadData] KEY_SIZE_TYPE_DATA :: " + list);
		ressultMap.put(KEY_SIZE_TYPE_DATA, list);

		// --------------------------------------------
		// get commodity data logic start
		// --------------------------------------------

		map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ERCL_GET_BKG_COMMD);
		map.put(KEY_MAPPER_CLASS, new TemplateCommodityRowMapper());
		map.put(KEY_PROC_PARAMS, arrParamOther);

		// ---------------------- get data from db.

		// map = executeDbProcedure(map);

		PRR_ERCL_GET_BKG_COMMD prcbkgCommd = new PRR_ERCL_GET_BKG_COMMD(getJdbcTemplate(), map);
		prcbkgCommd.executeDbProcedure();

		list = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get(KEY_REF_PROC_DATA_OUT);

		/* Begin @06 */
		this.setRateTypeDetail(list, templateName);
		/* End @06 */

		// ------------------------ get object of VO
		// objMod = new EserviceNewWebBookingUim();

		// ------------------------ get vo object from list
		// for (Object obj: list) {
		// objMod = (EserviceNewWebBookingUim)obj;
		// }
		// ------------------------ set result in map
		ressultMap.put(KEY_COMMODITY_DATA, list);

		// --------------------------------------------
		// get routing data logic start
		// --------------------------------------------

		// map.put(KEY_PROC_NAME, "PCR_ERCL_WEB_BKG.PRR_ERCL_GET_BKG_ROUTING");
		// map.put(KEY_MAPPER_CLASS, new TemplateRoutingRowMapper());
		// map.put(KEY_PROC_PARAMS, arrParamOther);
		//
		// //---------------------- get data from db.
		//
		// map = executeDbProcedure(map);
		// list =
		// (List)((Map)map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get(KEY_REF_PROC_DATA_OUT);
		//
		// //------------------------ get object of VO
		// objMod = new EserviceNewWebBookingUim();
		//
		// //------------------------ get vo object from list
		// for (Object obj: list) {
		// objMod = (EserviceNewWebBookingUim)obj;
		// }
		// //------------------------ set result in map
		// ressultMap.put("KEY_ROUTING_DATA", objMod);
		//

		// ---------------------- return map.
		return ressultMap;

	} // getComboData

	/* Begin @06 */
	public void setRateTypeDetail(List commodityList, String templateName) {
		System.out.println("[EserviceNewWebBookingDaoImpl][setRateTypeDetail][Begin]");
		EserviceCommodityDetailsMod objVo = null;
		String specialCargo = null;
		String YES = "Y";
		String REFER = "RF";
		String DG = "D1";
		String OOG = "O0";
		EserviceReferCommoditiesUim eserviceReferCommoditiesUim = null;
		EserviceDGCommoditiesUim eserviceDGCommoditiesUim = null;
		EserviceOOGCommoditiesUim eserviceOOGCommoditiesUim = null;
		String rateType = null;
		Map map = new HashMap(0);
		String seq = null;
		List dataList = null;

		try {

			System.out.println("[EserviceNewWebBookingDaoImpl][setRateTypeDetail] commodityList.size() :: "
					+ commodityList.size());

			if (commodityList != null && commodityList.size() > 0) {
				for (int i = 0; i < commodityList.size(); i++) {
					objVo = (EserviceCommodityDetailsMod) commodityList.get(i);
					specialCargo = objVo.getSpecialCargo();
					seq = String.valueOf(objVo.getSeqNo());
					rateType = objVo.getRateType();

					String[][] arrParam = { { KEY_REF_PROC_DATA_OUT, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
							{ P_I_V.BKG_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, templateName },
							{ P_I_V.COMMD_SEQ, BLANK + ORACLE_VARCHAR, PARAM_IN, seq } };
					System.out.println(
							"[EserviceNewWebBookingDaoImpl][setRateTypeDetail] specialCargo :: " + specialCargo);
					if (specialCargo.equalsIgnoreCase(YES)) {
						System.out.println("[EserviceNewWebBookingDaoImpl][setRateTypeDetail] rateType :: " + rateType);
						if (rateType.equalsIgnoreCase(REFER)) {
							map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ESV_GET_BKG_RE_COMMD);
							map.put(KEY_MAPPER_CLASS, new ReferCommodityRowMapper());
							map.put(KEY_PROC_PARAMS, arrParam);

							map = executeDbProcedure(map);
							dataList = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP))
									.get(KEY_REF_PROC_DATA_OUT);
							if (dataList != null) {
								eserviceReferCommoditiesUim = (EserviceReferCommoditiesUim) dataList.get(0);
								objVo.setEserviceReferCommoditiesUim(eserviceReferCommoditiesUim);
								objVo.setRateTypeFlag(YES);
								objVo.setRateTypeClassName(EserviceNewWebBookingDao.STYLE_GREEN);
							}
						} else if (rateType.equalsIgnoreCase(DG)) {
							map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ESV_GET_BKG_DG_COMMD);
							map.put(KEY_MAPPER_CLASS, new DGCommodityRowMapper());
							map.put(KEY_PROC_PARAMS, arrParam);

							map = executeDbProcedure(map);
							dataList = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP))
									.get(KEY_REF_PROC_DATA_OUT);
							if (dataList != null) {
								eserviceDGCommoditiesUim = (EserviceDGCommoditiesUim) dataList.get(0);
								objVo.setEserviceDGCommoditiesUim(eserviceDGCommoditiesUim);
								objVo.setRateTypeFlag(YES);
								objVo.setRateTypeClassName(EserviceNewWebBookingDao.STYLE_GREEN);
							}
						} else if (rateType.equalsIgnoreCase(OOG)) {
							map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ESV_GET_BKG_OOG_COMMD);
							map.put(KEY_MAPPER_CLASS, new OOGCommodityRowMapper());
							map.put(KEY_PROC_PARAMS, arrParam);

							map = executeDbProcedure(map);
							dataList = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP))
									.get(KEY_REF_PROC_DATA_OUT);
							if (dataList != null) {
								eserviceOOGCommoditiesUim = (EserviceOOGCommoditiesUim) dataList.get(0);
								objVo.setEserviceOOGCommoditiesUim(eserviceOOGCommoditiesUim);
								objVo.setRateTypeFlag(YES);
								objVo.setRateTypeClassName(EserviceNewWebBookingDao.STYLE_GREEN);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][setRateTypeDetail][End]");
		}

	}
	/* End @06 */

	public String removeComma(String val) {
		if (null != val) {
			val = val.replace(",", "");
		}
		return val;
	}

	/**
	 * update header data in DB.
	 *
	 * @param eserviceNewWebBookingUim
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map updateBookingData(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException {
		System.out.println("[EserviceNewWebBookingDaoImpl][updateBookingData][Begin]");
		// ------------------------ variable declaration
		String templateName = null;
		String quotationNumber = null;
		String shipmentTerm = null;
		String customerReference = null;
		String email = null;
		String telephone = null;
		String fax = null;
		String contact = null;
		String additionalMailRecipeints = null;
		String placeOfReceipt = null;
		String portOfLoading = null;
		String portOfDischarge = null;
		String placeOfDelivery = null;
		String desiredArrivalDate = null;
		String routingPref = null;
		String shipmentDate = null;
		String loginId = null;
		String saveOperationFlag = null;
		String cargoDescription = null;
		String bookingNo = null;

		// add 05/06/2013
		String sailingDate = null;
		Map map = new HashMap(0);
		String[][] arrParam = null;
		String representCompChkBox = null;// @07
		String representComp = null;// @07
		String cocSoc = null;// @08

		try {
			// ------------------------ variable initialization
			quotationNumber = eserviceNewWebBookingUim.getQuotationNumber();
			shipmentTerm = eserviceNewWebBookingUim.getShipmentTerm();
			customerReference = eserviceNewWebBookingUim.getCustomerReference();
			email = eserviceNewWebBookingUim.getEmail();
			telephone = eserviceNewWebBookingUim.getTelephone();
			fax = eserviceNewWebBookingUim.getFax();
			contact = eserviceNewWebBookingUim.getContact();
			additionalMailRecipeints = eserviceNewWebBookingUim.getAdditionalMailRecipeints();
			placeOfReceipt = eserviceNewWebBookingUim.getPlaceOfReceipt();
			portOfLoading = eserviceNewWebBookingUim.getPortOfLoading();
			portOfDischarge = eserviceNewWebBookingUim.getPortOfDischarge();
			placeOfDelivery = eserviceNewWebBookingUim.getPlaceOfDelivery();
			desiredArrivalDate = eserviceNewWebBookingUim.getDesiredArrivalDate();
			routingPref = eserviceNewWebBookingUim.getRoutingPreference().replaceAll("'", "\\\\'");
			shipmentDate = eserviceNewWebBookingUim.getShipmentDate();
			loginId = eserviceNewWebBookingUim.getUserId();
			saveOperationFlag = eserviceNewWebBookingUim.getSaveOperationFlag();
			cargoDescription = eserviceNewWebBookingUim.getCargoDescription().replaceAll("'", "\\\\'");
			bookingNo = eserviceNewWebBookingUim.getBookingNo();
			sailingDate = eserviceNewWebBookingUim.getSailingDate();
			representCompChkBox = eserviceNewWebBookingUim.getRepresentCompChkBox(); // @07
			representComp = eserviceNewWebBookingUim.getRepresentComp(); // @07
			cocSoc = eserviceNewWebBookingUim.getSocCocUserFlag(); // @08

			System.out.println("[EserviceNewWebBookingDaoImpl][updateBookingData] representCompChkBox    :: "
					+ representCompChkBox);
			System.out.println(
					"[EserviceNewWebBookingDaoImpl][updateBookingData] representComp          :: " + representComp);
			System.out.println("[EserviceNewWebBookingDaoImpl][updateBookingData] cocSoc                 :: " + cocSoc);

			// ---------------------- String array to hold procedure parameter
			arrParam = new String[][] { { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
					{ P_I_V.TEMPLATE_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, templateName },
					{ P_I_V.QUOTATION_NUMBER, BLANK + ORACLE_VARCHAR, PARAM_IN, quotationNumber },
					{ P_I_V.SHIPMENT_TERM, BLANK + ORACLE_VARCHAR, PARAM_IN, shipmentTerm },
					{ P_I_V.CUSTOMER_REF, BLANK + ORACLE_VARCHAR, PARAM_IN, customerReference },
					{ P_I_V.EMAIL, BLANK + ORACLE_VARCHAR, PARAM_IN, email },
					{ P_I_V.TELEPHONE, BLANK + ORACLE_VARCHAR, PARAM_IN, telephone },
					{ P_I_V.FAX, BLANK + ORACLE_VARCHAR, PARAM_IN, fax },
					{ P_I_V.CONTACT, BLANK + ORACLE_VARCHAR, PARAM_IN, contact },
					{ P_I_V.ADD_EMAIL_RECIPEINTS, BLANK + ORACLE_VARCHAR, PARAM_IN, additionalMailRecipeints },
					{ P_I_V.PLACE_OF_RECEIPT, BLANK + ORACLE_VARCHAR, PARAM_IN, placeOfReceipt },
					{ P_I_V.PORT_OF_LOADING, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfLoading },
					{ P_I_V.PORT_OF_DISCHARGE, BLANK + ORACLE_VARCHAR, PARAM_IN, portOfDischarge },
					{ P_I_V.PLACE_OF_DELIVERY, BLANK + ORACLE_VARCHAR, PARAM_IN, placeOfDelivery },
					{ P_I_V.DESIRED_ARRIVAL_DATE, BLANK + ORACLE_VARCHAR, PARAM_IN, desiredArrivalDate },
					{ P_I_V.ROUTING_REF, BLANK + ORACLE_VARCHAR, PARAM_IN, routingPref },
					{ P_I_V.SHIPMENT_DATE, BLANK + ORACLE_VARCHAR, PARAM_IN, shipmentDate },
					{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
					{ P_I_V.CARGO_DESCRIPTION, BLANK + ORACLE_VARCHAR, PARAM_IN, cargoDescription },
					{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
					{ P_I_V.SAILING_DATE, BLANK + ORACLE_VARCHAR, PARAM_IN, sailingDate },
					{ P_I_V.REP_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, representCompChkBox },
					{ P_I_V.REP_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, representComp },
					{ P_I_V.COC_SOC, BLANK + ORACLE_VARCHAR, PARAM_IN, cocSoc } };

			// ---------------------- other procedure details
			map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_UPDATE_TEMPLATE);
			map.put(KEY_PROC_PARAMS, arrParam);

			// ---------------------- excecute procedure

			map.put("P_I_V_BOOKING_NO", arrParam[0][3]);
			map.put("P_I_V_TEMPLATE_NAME", arrParam[1][3]);
			map.put("P_I_V_QUOTATION_NUMBER", arrParam[2][3]);
			map.put("P_I_V_SHIPMENT_TERM", arrParam[3][3]);
			map.put("P_I_V_CUSTOMER_REF", arrParam[4][3]);
			map.put("P_I_V_EMAIL", arrParam[5][3]);
			map.put("P_I_V_TELEPHONE", arrParam[6][3]);
			map.put("P_I_V_FAX", arrParam[7][3]);
			map.put("P_I_V_CONTACT", arrParam[8][3]);
			map.put("P_I_V_ADD_EMAIL_RECIPEINTS", arrParam[9][3]);
			map.put(" P_I_V_PLACE_OF_RECEIPT", arrParam[10][3]);
			map.put("P_I_V_PORT_OF_LOADING", arrParam[11][3]);
			map.put("P_I_V_PORT_OF_DISCHARGE", arrParam[12][3]);
			map.put("P_I_V_PLACE_OF_DELIVERY", arrParam[13][3]);
			map.put("P_I_V_DESIRED_ARRIVAL_DATE", arrParam[14][3]);
			map.put("P_I_V_ROUTING_REF", arrParam[15][3]);
			map.put("P_I_V_SHIPMENT_DATE", arrParam[16][3]);
			map.put("P_I_V_USER_ID", arrParam[17][3]);
			map.put("P_I_V_CARGO_DESCRIPTION", arrParam[18][3]);

			map.put("P_I_V_SAILING_DATE", arrParam[20][3]);
			map.put("P_I_V_REP_FLAG", arrParam[21][3]);
			map.put("P_I_V_REP_CODE", arrParam[22][3]);
			map.put("P_I_V_COC_SOC", arrParam[23][3]);
			map.put("CHANGES_TYPE",saveOperationFlag);

			// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

			PRE_UPDATE_TEMPLATE prcupdateTmlt = new PRE_UPDATE_TEMPLATE(getJdbcTemplate(), map);
			prcupdateTmlt.executeDbProcedure();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceNewWebBookingDaoImpl][updateBookingData][End]");
		}
		// ---------------------- returned result Map.
		return map;

	} // updateBookingData

	/**
	 * update size type details in DB
	 *
	 * @param eserviceNewWebBookingUim
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map updateEquipmentDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException {

		Map map = new HashMap(0);

		try {
			saveEquipment(eserviceNewWebBookingUim);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * update commodity detail in DB
	 *
	 * @param eserviceNewWebBookingUim
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
	public Map updateCommodityDetails(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException {
		// ------------------------ variable declaration
		String bookingNo = null;
		String line = null;
		String trade = null;
		String agent = null;
		// String cargoDescription = null;
		String seq = null;
		String commodityGroup = null;
		String grossWeight = null;
		String specialCargoChkBox = null;
		String specialInstruction = null;
		String loginId = null;
		String NO = "N";
		String YES = "Y";
		String ON = "on";

		// ------------------------ variable initialization
		bookingNo = eserviceNewWebBookingUim.getBookingNo();
		line = eserviceNewWebBookingUim.getLine();
		trade = eserviceNewWebBookingUim.getTrade();
		agent = eserviceNewWebBookingUim.getAgent();
		seq = eserviceNewWebBookingUim.getCommoditySeq();
		commodityGroup = eserviceNewWebBookingUim.getCommodityGroup();
		grossWeight = eserviceNewWebBookingUim.getGrossWeight();
		specialCargoChkBox = eserviceNewWebBookingUim.getSpecialCargoChkBox();
		specialInstruction = eserviceNewWebBookingUim.getSpecialInstruction().replaceAll("'", "\\\\'");
		loginId = eserviceNewWebBookingUim.getUserId();

		grossWeight = removeComma(grossWeight);

		// ---------------------- set parameter value according to checkbox.
		if (specialCargoChkBox == null) {
			specialCargoChkBox = NO;
		} else if (specialCargoChkBox.equals(ON)) {
			specialCargoChkBox = YES;
		} else {
			specialCargoChkBox = NO;
		}

		// ---------------------- map to hold parameter details
		Map map = new HashMap(0);

		// ---------------------- String array to hold procedure parameter
		String[][] arrParam =
				// @04 BEGIN checkDoubleValueNumber(grossWeight)
				// @04 END
				{ { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
						{ P_I_V.SEQ, BLANK + ORACLE_NUMBER, PARAM_IN, seq },
						{ P_I_V.COMMODITY_GROUP, BLANK + ORACLE_VARCHAR, PARAM_IN, commodityGroup },
						{ P_I_V.GROSS_WEIGHT, BLANK + ORACLE_VARCHAR, PARAM_IN, checkDoubleValueNumber(grossWeight) },
						{ P_I_V.SPECIAL_FLAG, BLANK + ORACLE_VARCHAR, PARAM_IN, specialCargoChkBox },
						{ P_I_V.SPECIAL_INSTRUCTION, BLANK + ORACLE_VARCHAR, PARAM_IN, specialInstruction },
						{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
						{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

		// ---------------------- other procedure details
		map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_UPD_COMMODITY_DATA);
		map.put(KEY_PROC_PARAMS, arrParam);

		// ---------------------- excecute procedure
		// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

		map.put("P_I_V_BOOKING_NO", arrParam[0][3]);
		map.put("P_I_V_SEQ", arrParam[1][3]);
		map.put("P_I_V_COMMODITY_GROUP", arrParam[2][3]);
		map.put("P_I_V_GROSS_WEIGHT", arrParam[3][3]);
		map.put("P_I_V_SPECIAL_FLAG", arrParam[4][3]);
		map.put("P_I_V_SPECIAL_INSTRUCTION", arrParam[5][3]);
		map.put("P_I_V_USER_ID", arrParam[6][3]);

		PRE_UPD_COMMODITY_DATA procComm = new PRE_UPD_COMMODITY_DATA(getJdbcTemplate(), map);
		procComm.executeDbProcedure();
		// ---------------------- returned result Map.
		return map;
	}

	public String getCustomerName(Map amap) throws BusinessException, DataAccessException {
		StringBuffer sqlStatement = new StringBuffer(
				"select CUNAME from ITP010, SC_PRSN_LOG_INFO where CUCUST = ORG_CODE and PRSN_LOG_ID = '"
						+ ((String) amap.get(KEY_USER_ID)) + "'");

		SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sqlStatement.toString(), new HashMap());

		String customerName = "";
		while (rs.next()) {
			customerName = rs.getString("CUNAME");
		}

		return customerName;
	}

	
	public void saveEquipment(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws Exception {
		String bookingNo = null;
		String line = null;
		String trade = null;
		String agent = null;
		String customerCode = null;
		String emptyPickupDepot = null;
		String emptyPickupDate = null;
		String seq = null;
		String type = null;
		String size = null;
		String cargoType = null;
		String specialCargo = null;
		String laden = null;
		String mt = null;
		String grossContainerWeight = null;
		String pol = null;
		String loginId = null;
		double sumOfGrossWeight = 0;
		String polStatus = BLANK;
		String podStatus = BLANK;
		int lintCount = 0;
		List lstTableData = null;

		// ------------------------ variable initialization
		pol = eserviceNewWebBookingUim.getPortOfLoading();
		line = eserviceNewWebBookingUim.getLine();
		trade = eserviceNewWebBookingUim.getTrade();
		agent = eserviceNewWebBookingUim.getAgent();
		bookingNo = eserviceNewWebBookingUim.getBookingNo();
		emptyPickupDate = eserviceNewWebBookingUim.getEmptyPickupDate();
		emptyPickupDepot = eserviceNewWebBookingUim.getEmptyPickupDepot();
		loginId = eserviceNewWebBookingUim.getUserId();
		customerCode = eserviceNewWebBookingUim.getCustomerCode();
		lstTableData = eserviceNewWebBookingUim.getEquipmentVoDataList();

		if (eserviceNewWebBookingUim.getSocCocUserFlag().equals("C")) {
			polStatus = "L";
			podStatus = "L";
		}

		// @03 BEGIN if emptyPickupDate is blank then use Cargo Availability Date
		if (emptyPickupDate.equals("")) {
			// emptyPickupDate = eserviceNewWebBookingUim.getShipmentDate(); //P'Nim tell
			// mee give out By Pound 20140630
		}
		// @03 END

		// Begin sum grossContainerWeight before call Procedure comment by Pound
		// 20140722
		for (int i = 0; i < lstTableData.size(); i++) {
			EserviceEquipmentDetailsMod objMod = (EserviceEquipmentDetailsMod) lstTableData.get(i);
			if (!objMod.getEqRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.DEL_OPERATION)) {
				grossContainerWeight = objMod.getGrossContainerWeight();
				grossContainerWeight = removeComma(grossContainerWeight);

				if ((null != grossContainerWeight) && (!grossContainerWeight.equals(BLANK))) {
					sumOfGrossWeight = sumOfGrossWeight + Double.parseDouble(grossContainerWeight);
				}
			}

		}
		// End sum grossContainerWeight before call Procedure comment by Pound 20140722

		System.out.println("sumOfGrossWeight::" + sumOfGrossWeight);

		while (lintCount < lstTableData.size()) {
			EserviceEquipmentDetailsMod objMod = (EserviceEquipmentDetailsMod) lstTableData.get(lintCount);
			// System.out.println("objMod.getPolStatus()
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+objMod.getPolStatus());
			seq = String.valueOf(objMod.getEqSeqNo());

			type = objMod.getType();
			size = objMod.getSize();
			cargoType = objMod.getCargoType();
			specialCargo = objMod.getSpecialCargo();
			laden = objMod.getLaden();
			mt = objMod.getMt();
			grossContainerWeight = objMod.getGrossContainerWeight();// Begin comment by Pound 20140722

			if (!polStatus.equals("L")) {
				polStatus = objMod.getPolStatus();
			}
			if (!podStatus.equals("L")) {
				podStatus = objMod.getPodStatus();
			}

			// ---------------------- remove ',' from number fields.
			mt = removeComma(mt);
			grossContainerWeight = removeComma(grossContainerWeight);// comment by Pound 20140722
			// grossContainerWeight = "1";
			laden = removeComma(laden);
			// if (null != grossContainerWeight){
			// Begin comment by Pound 20140722
			// if((null!=grossContainerWeight)&&(!grossContainerWeight.equals(BLANK))){
			// sumOfGrossWeight = sumOfGrossWeight+Double.parseDouble(grossContainerWeight);
			// }
			// End comment by Pound 20140722

			// ---------------------- map to hold parameter details
			Map map = new HashMap(0);

			System.out.println("RecordStatus::" + objMod.getEqRecordStatus());
			// sushil we will alwasy insert
			// objMod.getEqRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.ADD_OPERATION)
			if (true) {

				System.out.println("%%%%%ADD EQUIPMENT LOGIC CALLED");
				System.out.println(grossContainerWeight);
				// ----------------------
				// add new equipment.
				// ----------------------
				// ---------------------- String array to hold procedure parameter
				String[][] arrParam =

						// @04 BEGIN checkDoubleValueNumber(grossContainerWeight)
						// @04 END
						{ { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
								{ P_I_V.LINE, BLANK + ORACLE_VARCHAR, PARAM_IN, line },
								{ P_I_V.TRADE, BLANK + ORACLE_VARCHAR, PARAM_IN, trade },
								{ P_I_V.AGENT, BLANK + ORACLE_VARCHAR, PARAM_IN, agent },
								{ P_I_V.CUST_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, customerCode },
								{ P_I_V.EMPTY_PICKUP_DEP, BLANK + ORACLE_VARCHAR, PARAM_IN, emptyPickupDepot },
								{ P_I_V.EMPTY_PICKUP_DATE, BLANK + ORACLE_VARCHAR, PARAM_IN, emptyPickupDate },
								{ P_I_V.SEQ, BLANK + ORACLE_NUMBER, PARAM_IN, seq },
								{ P_I_V.EQ_TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, type },
								{ P_I_V.EQ_SIZE, BLANK + ORACLE_VARCHAR, PARAM_IN, size },
								{ P_I_V.CARGO_TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, cargoType },
								{ P_I_V.QTY_LADEN, BLANK + ORACLE_NUMBER, PARAM_IN, laden },
								{ P_I_V.QTY_MTY, BLANK + ORACLE_NUMBER, PARAM_IN, mt },
								{ P_I_V.GROSS_WEIGHT, BLANK + ORACLE_VARCHAR, PARAM_IN,
										checkDoubleValueNumber(grossContainerWeight) },
								{ P_I_V.POL, BLANK + ORACLE_VARCHAR, PARAM_IN, pol },
								{ P_I_V.SUM_GROSS_WEIGHT, BLANK + ORACLE_VARCHAR, PARAM_IN,
										String.valueOf(sumOfGrossWeight) },
								{ P_I_V.WEIGHT_TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, "GCW" },
								{ P_I_V.POL_STATUS, BLANK + ORACLE_VARCHAR, PARAM_IN, polStatus },
								{ P_I_V.POD_STATUS, BLANK + ORACLE_VARCHAR, PARAM_IN, podStatus },
								{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
								{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

				// ---------------------- other procedure details
				map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_SAVE_EQUIPMENT_DATA);
				map.put(KEY_PROC_PARAMS, arrParam);

				map.put("P_I_V_BOOKING_NO", arrParam[0][3]);
				map.put("P_I_V_LINE", arrParam[1][3]);
				map.put("P_I_V_TRADE", arrParam[2][3]);
				map.put("P_I_V_AGENT", arrParam[3][3]);
				map.put("P_I_V_CUST_CODE", arrParam[4][3]);
				map.put("P_I_V_EMPTY_PICKUP_DEP", arrParam[5][3]);
				map.put("P_I_V_EMPTY_PICKUP_DATE", arrParam[6][3]);
				map.put("P_I_V_SEQ", arrParam[7][3]);
				map.put("P_I_V_EQ_TYPE", arrParam[8][3]);
				map.put("P_I_V_EQ_SIZE", arrParam[9][3]);
				map.put("P_I_V_CARGO_TYPE", arrParam[10][3]);
				map.put("P_I_V_QTY_LADEN", arrParam[11][3]);
				map.put("P_I_V_QTY_MTY", arrParam[12][3]);
				map.put("P_I_V_GROSS_WEIGHT", arrParam[13][3]);
				map.put("P_I_V_POL", arrParam[14][3]);
				map.put("P_I_V_SUM_GROSS_WEIGHT", arrParam[15][3]);
				map.put("P_I_V_WEIGHT_TYPE", arrParam[16][3]);
				map.put("P_I_V_POL_STATUS", arrParam[17][3]);
				map.put("P_I_V_POD_STATUS", arrParam[18][3]);
				map.put("P_I_V_USER_ID", arrParam[19][3]);
				map.put("P_I_V_SPECIAL_CARGO" ,specialCargo);
				
				PRE_SAVE_EQUIPMENT_DATA prgSavEqpt = new PRE_SAVE_EQUIPMENT_DATA(getJdbcTemplate(), map);
				prgSavEqpt.executeDbProcedure(lintCount == 0);

				// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);
				System.out.println("%%%%%END ADD EQUIPMENT LOGIC CALLED");
				// } else
				// if(objMod.getRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.UPD_OPERATION)){
			} else if (objMod.getEqRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.UPD_OPERATION)
					|| objMod.getEqRecordStatus().equalsIgnoreCase(EserviceNewWebBookingDao.SER_OPERATION)) {
				System.out.println("%%%%%UPDATE EQUIPMENT LOGIC CALLED");
				System.out.println(grossContainerWeight);
				// ----------------------
				// update old equipment.
				// ----------------------
				// ---------------------- String array to hold procedure parameter
				String[][] arrParam =
						// @04 BEGIN checkDoubleValueNumber(grossContainerWeight)
						// @04 END
						{ { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
								{ P_I_V.EMPTY_PICKUP_DEP, BLANK + ORACLE_VARCHAR, PARAM_IN, emptyPickupDepot },
								{ P_I_V.EMPTY_PICKUP_DATE, BLANK + ORACLE_VARCHAR, PARAM_IN, emptyPickupDate },
								{ P_I_V.SEQ, BLANK + ORACLE_NUMBER, PARAM_IN, seq },
								{ P_I_V.EQ_TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, type },
								{ P_I_V.EQ_SIZE, BLANK + ORACLE_VARCHAR, PARAM_IN, size },
								{ P_I_V.CARGO_TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, cargoType },
								{ P_I_V.QTY_LADEN, BLANK + ORACLE_NUMBER, PARAM_IN, laden },
								{ P_I_V.QTY_MTY, BLANK + ORACLE_NUMBER, PARAM_IN, mt },
								{ P_I_V.GROSS_WEIGHT, BLANK + ORACLE_VARCHAR, PARAM_IN,
										checkDoubleValueNumber(grossContainerWeight) },
								{ P_I_V.POL, BLANK + ORACLE_VARCHAR, PARAM_IN, pol },
								{ P_I_V.SUM_GROSS_WEIGHT, BLANK + ORACLE_VARCHAR, PARAM_IN,
										String.valueOf(sumOfGrossWeight) },
								{ P_I_V.WEIGHT_TYPE, BLANK + ORACLE_VARCHAR, PARAM_IN, "GCW" },
								{ P_I_V.POL_STATUS, BLANK + ORACLE_VARCHAR, PARAM_IN, polStatus },
								{ P_I_V.POD_STATUS, BLANK + ORACLE_VARCHAR, PARAM_IN, podStatus },
								{ P_I_V.USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
								{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

				// ---------------------- other procedure details
				map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_UPD_EQUIPMENT_DATA);
				map.put(KEY_PROC_PARAMS, arrParam);

				map.put("P_I_V_BOOKING_NO", arrParam[0][3]);
				map.put("P_I_V_EMPTY_PICKUP_DEP", arrParam[1][3]);
				map.put("P_I_V_EMPTY_PICKUP_DATE", arrParam[2][3]);
				map.put("P_I_V_SEQ", arrParam[3][3]);
				map.put("P_I_V_EQ_TYPE", arrParam[4][3]);
				map.put("P_I_V_EQ_SIZE", arrParam[5][3]);
				map.put("P_I_V_CARGO_TYPE", arrParam[6][3]);
				map.put("P_I_V_QTY_LADEN", arrParam[7][3]);
				map.put("P_I_V_QTY_MTY", arrParam[8][3]);
				map.put("P_I_V_GROSS_WEIGHT", arrParam[9][3]);
				map.put(" P_I_V_POL", arrParam[10][3]);
				map.put("P_I_V_SUM_GROSS_WEIGHT", arrParam[11][3]);
				map.put("P_I_V_WEIGHT_TYPE", arrParam[12][3]);
				map.put("P_I_V_POL_STATUS", arrParam[13][3]);
				map.put("P_I_V_POD_STATUS", arrParam[14][3]);
				map.put("P_I_V_USER_ID", arrParam[15][3]);
				map.put("P_I_V_SPECIAL_CARGO" ,specialCargo);
				
				PRE_UPD_EQUIPMENT_DATA procUED = new PRE_UPD_EQUIPMENT_DATA(getJdbcTemplate(), map);
				procUED.executeDbProcedure();
				// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

			}
			lintCount++;
		}

	}

	public Map deleleEqSizeType(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException {
		String bookingNo = null;
		String seq = null;
		Map map = new HashMap(0);
		int lintCount = 0;
		List lstTableData = null;
		String recordStatus = null;

		bookingNo = eserviceNewWebBookingUim.getBookingNo();
		lstTableData = eserviceNewWebBookingUim.getEquipmentVoDataList();

		while (lintCount < lstTableData.size()) {
			EserviceEquipmentDetailsMod objMod = (EserviceEquipmentDetailsMod) lstTableData.get(lintCount);

			recordStatus = objMod.getEqRecordStatus();

			if (null != recordStatus && recordStatus.equalsIgnoreCase(DEL_OPERATION)) {
				seq = String.valueOf(objMod.getEqSeqNo());

				String[][] arrParam = { { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
						{ P_I_V.SEQ, BLANK + ORACLE_NUMBER, PARAM_IN, seq },
						{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

				// ---------------------- other procedure details
				map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_DEL_EQ_SIZE_TYPE);
				map.put(KEY_PROC_PARAMS, arrParam);

				// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

				map.put("P_I_V_BOOKING_NO", arrParam[0][3]);
				map.put("P_I_V_SEQ", arrParam[1][3]);

				PRE_DEL_EQ_SIZE_TYPE procEqSizTyp = new PRE_DEL_EQ_SIZE_TYPE(getJdbcTemplate(), map);
				procEqSizTyp.executeDbProcedure();
			}
			lintCount++;
		}
		return map;
	} // deleleEqSizeType

	public Map deleleCommodity(EserviceNewWebBookingUim eserviceNewWebBookingUim)
			throws BusinessException, DataAccessException {

		System.out.println("[deleleCommodity][Begin]");

		String bookingNo = null;
		String seq = null;
		Map map = new HashMap(0);
		int lintCount = 0;
		List lstTableData = null;
		String recordStatus = null;

		bookingNo = eserviceNewWebBookingUim.getBookingNo();
		lstTableData = eserviceNewWebBookingUim.getCommodityVoDataList();

		while (lintCount < lstTableData.size()) {
			EserviceCommodityDetailsMod objMod = (EserviceCommodityDetailsMod) lstTableData.get(lintCount);

			recordStatus = objMod.getRecordStatus();
			System.out.println("recordStatus::" + recordStatus);

			if (null != recordStatus && recordStatus.equalsIgnoreCase(DEL_OPERATION)) {
				seq = String.valueOf(objMod.getSeqNo());

				String[][] arrParam = { { P_I_V.BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
						{ P_I_V.SEQ, BLANK + ORACLE_NUMBER, PARAM_IN, seq },
						{ KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

				// ---------------------- other procedure details
				map.put(KEY_PROC_NAME, PCR_ESV_NEW_WEB_BOOKING.PRE_DEL_COMMODITY_DATA);
				map.put(KEY_PROC_PARAMS, arrParam);

				map.put("P_I_V_BOOKING_NO", arrParam[0][3]);
				map.put("P_I_V_SEQ", arrParam[1][3]);

				// map = (Map) executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);

				PRE_DEL_COMMODITY_DATA procDelCom = new PRE_DEL_COMMODITY_DATA(getJdbcTemplate(), map);
				procDelCom.executeDbProcedure();
			}
			lintCount++;
		}

		System.out.println("[deleleCommodity][End]");
		return map;
	} // deleleCommodity

	/* Begin @06 */
	String nullToSpace(String av_obj) {
		String lv_str = "";

		try {
			if (av_obj != null) {
				lv_str = av_obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lv_str;
	}
	/* Begin @06 */

	// public void testEquipment(EserviceNewWebBookingUim eserviceNewWebBookingUim)
	// throws BusinessException,
	// DataAccessException {
	// String bookingNo = null;
	// String line = null;
	// String trade = null;
	// String agent = null;
	// String customerCode = null;
	// String emptyPickupDepot = null;
	// String emptyPickupDate = null;
	// String seq = null;
	// String type = null;
	// String size = null;
	// String cargoType = null;
	// String laden = null;
	// String mt = null;
	// String grossContainerWeight = null;
	// String pol = null;
	// String loginId = null;
	// int sumOfGrossWeight = 0;
	// String polStatus = null;
	// String podStatus = null;
	// int lintCount = 0;
	// List lstTableData = null;
	//
	// //------------------------ variable initialization
	// pol = eserviceNewWebBookingUim.getPortOfLoading();
	// line = eserviceNewWebBookingUim.getLine();
	// trade = eserviceNewWebBookingUim.getTrade();
	// agent = eserviceNewWebBookingUim.getAgent();
	// bookingNo = eserviceNewWebBookingUim.getBookingNo();
	// emptyPickupDate = eserviceNewWebBookingUim.getEmptyPickupDate();
	// emptyPickupDepot = eserviceNewWebBookingUim.getEmptyPickupDepot();
	// loginId = eserviceNewWebBookingUim.getUserId();
	// customerCode = eserviceNewWebBookingUim.getCustomerCode();
	// lstTableData = eserviceNewWebBookingUim.getEquipmentVoDataList();
	//
	// if (eserviceNewWebBookingUim.getSocCocUserFlag().equals("C")) {
	// polStatus = "L";
	// podStatus = "L";
	// }
	//
	// while (lintCount < lstTableData.size()) {
	// EserviceEquipmentDetailsMod objMod =
	// (EserviceEquipmentDetailsMod)lstTableData.get(lintCount);
	//
	// seq = String.valueOf(objMod.getSeqNo());
	//
	// type = objMod.getType();
	// size = objMod.getSize();
	// cargoType = objMod.getCargoType();
	// laden = objMod.getLaden();
	// mt = objMod.getMt();
	// grossContainerWeight = objMod.getGrossContainerWeight();
	//
	// if (!polStatus.equals("L")) {
	// polStatus = objMod.getPolStatus();
	// }
	// if (!podStatus.equals("L")) {
	// podStatus = objMod.getPodStatus();
	// }
	//
	// //---------------------- remove ',' from number fields.
	// mt = removeComma(mt);
	// grossContainerWeight = removeComma(grossContainerWeight);
	// laden = removeComma(laden);
	//
	// if ((null != grossContainerWeight) &&
	// (!grossContainerWeight.equals(BLANK))) {
	// sumOfGrossWeight += Integer.parseInt(grossContainerWeight);
	// }
	//
	// //---------------------- map to hold parameter details
	// Map map = new HashMap(0);
	//
	// //---------------------- String array to hold procedure parameter
	// String[][] arrParam =
	// { { KEY_BOOKING_NO_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN,
	// bookingNo },
	// { KEY_EMPTY_PICKUP_DEP_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN,
	// emptyPickupDepot },
	// { KEY_EMPTY_PICKUP_DATE_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN,
	// emptyPickupDate },
	// { KEY_SEQ_PIN, BLANK + ORACLE_NUMBER, PARAM_IN, seq },
	// { KEY_EQ_TYPE_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN, type },
	// { KEY_EQ_SIZE_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN, size },
	// { KEY_CARGO_TYPE_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN,
	// cargoType },
	// { KEY_QTY_LADEN_PIN, BLANK + ORACLE_NUMBER, PARAM_IN, laden },
	// { KEY_QTY_MTY_PIN, BLANK + ORACLE_NUMBER, PARAM_IN, mt },
	// { KEY_GROSS_WEIGHT_PIN, BLANK + ORACLE_NUMBER, PARAM_IN,
	// grossContainerWeight },
	// { KEY_POL_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN, pol },
	// { KEY_SUM_GROSS_WEIGHT_PIN, BLANK + ORACLE_NUMBER, PARAM_IN,
	// String.valueOf(sumOfGrossWeight) },
	// { KEY_WEIGHT_TYPE_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN, "GCW" },
	// { KEY_POL_STATUS_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN,
	// polStatus },
	// { KEY_POD_STATUS_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN,
	// podStatus },
	// { KEY_USER_ID_PIN, BLANK + ORACLE_VARCHAR, PARAM_IN, loginId },
	// { KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };
	//
	// //---------------------- other procedure details
	// map.put(KEY_PROC_NAME, SQL_UPD_EQUIPMENT_DATA);
	// map.put(KEY_PROC_PARAMS, arrParam);
	//
	// //---------------------- excecute procedure
	// map =
	// (Map)executeDbProcedure(map).get(KEY_PROCE_EXCECTION_RESULT_MAP);
	// lintCount++;
	// }
	//
	// } // testEquipment

	public Map getFSCDetails(Map amap) {
		String sql = "select SCCODE, SCNAME from ITP030 a, ITP188 b, SC_PRSN_LOG_INFO c\n" + "where PRSN_LOG_ID = '"
				+ ((String) amap.get(KEY_USER_ID)) + "' and c.FSC_CODE = CRCNTR\n" + "and CRCNCD = SCCODE";

		System.out.println("sql : " + sql);

		SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());
		Map result = new HashMap();
		while (rs.next()) {
			result.put(KEY_CODE, rs.getString(1));
			result.put(KEY_NAME, rs.getString(2));
		}
		return result;
	}

	/**
	 *
	 * This abstract method for get quotation information show in screen.
	 *
	 * @exception BusinessException and DataAccessException
	 * @param map List of parameters in
	 */
	public Map getQuotationInfo(Map map) throws BusinessException {
		String[][] arrParam = { { P_O_V.QTN_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ P_I_V.QTN_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.QTN_NO) } };

		map.put(KEY_PROC_NAME, PCR_ESV_WEB_BKG.PRR_ERCL_GET_QTN_INFO);
		map.put(KEY_MAPPER_CLASS, new QuotationInfoRowMapper());
		map.put(KEY_PROC_PARAMS, arrParam);

		map.put("P_I_V_QTN_NO", (String) map.get(P_I_V.QTN_NO));
		// map = executeDbProcedure(map);

		PRR_ERCL_GET_QTN_INFO proc = new PRR_ERCL_GET_QTN_INFO(getJdbcTemplate(), map);
		proc.executeDbProcedure();

		map = (Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP);

		return map;
	}

	/**
	 *
	 * This method for convert POL/POD Term code to value.
	 *
	 * @param str Value POL/POD Term
	 */
	public static String convertToTermValue(String str) {
		if ("CF".equals(str)) {
			str = "CFS";
		} else if ("CD".equals(str)) {
			str = "ICD";
		} else if ("BO".equals(str)) {
			str = "BOM";
		} else if ("DR".equals(str)) {
			str = "DOOR";
		}
		return str;
	}

	// @04 BEGIN

	public String checkDoubleValueNumber(String value) {
		if (null == value || "null".equals(value) || value.equals("")) {
			return "0";
		}
		return String.valueOf(Double.parseDouble(value.replaceAll(",", BLANK)));
	}
	// @04 END

	private JdbcStoredProcedure getStoreProcedure(String procName, JdbcRowMapper rowMapper, String[][] arrParam) {
		JdbcStoredProcedure storeProcedure = null;
		try {
			if (rowMapper != null) {
				if (arrParam != null) {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper, arrParam);
				} else {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper);
				}
			} else {
				if (arrParam != null) {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, arrParam);
				} else {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return storeProcedure;
	}

	/* Begin @07 */
	class RepCompMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			ComboVO objComboVO = new ComboVO();

			objComboVO.setCode(rs.getString("FK_CONTRACT_PARTY_CODE"));
			objComboVO.setName(rs.getString("CONTRACT_PARTY_NAME"));

			return objComboVO;
		}

	}
	/* End @07 */

	/* Begin @08 */
	class CocSocMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			ComboVO objComboVO = new ComboVO();

			objComboVO.setCode(rs.getString("CODE"));
			objComboVO.setName(rs.getString("description"));

			return objComboVO;
		}

	}
	/* End @08 */

	/**
	 * This <code>JdbcRowMapper</code> class used to get onload data
	 */
	class OnloadRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceNewWebBookingMod eserviceNewWebBookingMod = new EserviceNewWebBookingMod();

			eserviceNewWebBookingMod.setSosCoc(rs.getString("SOS_COC"));
			eserviceNewWebBookingMod.setTelephone(rs.getString("TELEPHONE"));
			eserviceNewWebBookingMod.setFax(rs.getString("FAX"));
			eserviceNewWebBookingMod.setEmail(rs.getString("EMAIL"));
			eserviceNewWebBookingMod.setDate(rs.getString("DATE"));

			return eserviceNewWebBookingMod;
		} // mapRow
			// OnloadRowMapper

	} // end of class

	/**
	 * This <code>JdbcRowMapper</code> class used to get onload data
	 */
	class TemplateHDRDataRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			EserviceNewWebBookingUim eserviceNewWebBookingUim = new EserviceNewWebBookingUim();
			eserviceNewWebBookingUim.setBookingNo(rs.getString("BABKNO"));
			eserviceNewWebBookingUim.setQuotationNumber(rs.getString("BAQUNO"));
			eserviceNewWebBookingUim.setStatus(rs.getString("BASTAT"));
			eserviceNewWebBookingUim.setContact(rs.getString("BACLBY"));
			eserviceNewWebBookingUim.setTelephone(rs.getString("BACBPH"));
			eserviceNewWebBookingUim.setFax(rs.getString("CALLER_FAX"));
			eserviceNewWebBookingUim.setEmail(rs.getString("CALLER_EMAIL"));
			eserviceNewWebBookingUim.setShipmentTerm(rs.getString("BAMODE"));
			eserviceNewWebBookingUim.setCustomerReference(rs.getString("REFERENCE_NO"));
			eserviceNewWebBookingUim.setPlaceOfReceipt(rs.getString("BAORGN"));
			eserviceNewWebBookingUim.setPortOfLoading(rs.getString("BAPOL"));
			eserviceNewWebBookingUim.setPortOfDischarge(rs.getString("BAPOD"));
			eserviceNewWebBookingUim.setPlaceOfDelivery(rs.getString("BADSTN"));
			eserviceNewWebBookingUim.setTemplateName(rs.getString("WEB_BOOK_REF"));
			eserviceNewWebBookingUim.setShipmentDate(rs.getString("BACADT"));
			eserviceNewWebBookingUim.setAdditionalMailRecipeints(rs.getString("ADDITIONAL_EMAILS"));
			eserviceNewWebBookingUim.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
			eserviceNewWebBookingUim.setRoutingPreference(rs.getString("ROUTE_PREFERENCE"));
			eserviceNewWebBookingUim.setCargoDescription(rs.getString("CARGO_DESC"));
			eserviceNewWebBookingUim.setOriginCountry(rs.getString("ORGN_COUNTRY"));
			eserviceNewWebBookingUim.setDestinationCountry(rs.getString("DSTN_COUNTRY"));

			eserviceNewWebBookingUim.setLine(rs.getString("BALINE"));
			eserviceNewWebBookingUim.setTrade(rs.getString("BATRAD"));
			eserviceNewWebBookingUim.setAgent(rs.getString("BAAGNT"));
			eserviceNewWebBookingUim.setCustomerCode(rs.getString("BABKBY"));

			/* Begin @07 */
			eserviceNewWebBookingUim.setRepresentCompChkBox(rs.getString("REP_FLAG"));
			eserviceNewWebBookingUim.setRepresentComp(FormatUtil.nullToBlank(rs.getString("REP_CODE")));
			/* End @07 */
			eserviceNewWebBookingUim.setSocCocUserFlag(rs.getString("BABKTP"));// @08

			if (eserviceNewWebBookingUim.getStatus().equals("O")) {
				eserviceNewWebBookingUim.setStatus("Open");
			}

			return eserviceNewWebBookingUim;
		} // mapRow

	} // end of class TemplateHDRDataRowMapper

	// TemplateCommodityRowMapper
	// TemplateSizeTypeRowMapper
	// TemplateRoutingRowMapper
	/**
	 * This <code>JdbcRowMapper</code> class used to get onload data
	 */
	class TemplateCommodityRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			String grossWeight = null;

			// @05 BEGIN
			NumberFormat nf2digit = new DecimalFormat("#,###.00");
			// @05 END

			EserviceCommodityDetailsMod objVo = new EserviceCommodityDetailsMod();
			// eserviceNewWebBookingUim.setCommodityGroup(rs.getString("BWCMSQ"));
			objVo.setGroup(rs.getString("COMMODITY_GROUP_CODE"));
			objVo.setDescription(rs.getString("DESCRIPTION"));

			// @05 BEGIN
			grossWeight = rs.getDouble("BWMTWT") == 0 ? "0.00" : nf2digit.format(rs.getDouble("BWMTWT"));
			objVo.setGrossWeight(grossWeight);
			// @05 END
			objVo.setSeqNo(rs.getInt("BWCMSQ"));
			objVo.setSpecialInstruction(rs.getString("BGRMKS"));
			objVo.setRecordStatus("SER");

			/* Begin @06 */
			objVo.setSpecialCargo(rs.getString("SPECIAL_FLAG"));
			objVo.setRateType(rs.getString("SPECIAL_HANDLING"));
			/* End @06 */

			return objVo;
		} // mapRow

	} // end of class TemplateCommodityRowMapper

	/**
	 * This <code>JdbcRowMapper</code> class used to get onload data
	 */
	class TemplateSizeTypeRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			// @05 BEGIN
			NumberFormat nf2digit = new DecimalFormat("#,###.00");
			// @05 END

			EserviceEquipmentDetailsMod objVo = new EserviceEquipmentDetailsMod();

			objVo.setSize(rs.getString("BCSIZE"));
			objVo.setType(rs.getString("BCTYPE"));
			objVo.setTypeDesc(rs.getString("BCTYPEDESC"));
			objVo.setLaden(rs.getString("BCFQTY"));
			objVo.setMt(rs.getString("BCEQTY"));
			objVo.setEqSeqNo(rs.getInt("EQP_SIZETYPE_SEQNO"));
			objVo.setCargoType(rs.getString("SPECIAL_HANDLING"));
			objVo.setPolStatus(rs.getString("POL_STAT"));
			objVo.setPodStatus(rs.getString("POD_STAT"));
			objVo.setEmptyPickupDepot(rs.getString("PICKUP_DEPOT"));
			objVo.setEmptyPickupDate(rs.getString("PICKUP_DATE"));

			// @05 BEGIN
			objVo.setGrossContainerWeight(nf2digit.format(rs.getDouble("WEIGHT")));
			// @05 END
			objVo.setEqRecordStatus("SER");

			return objVo;
		} // mapRow

	} // end of class TemplateSizeTypeRowMapper

	/**
	 * This <code>JdbcRowMapper</code> class used to get onload data
	 */
	class QuotationRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			EserviceNewWebBookingMod objVo = new EserviceNewWebBookingMod();

			objVo.setQuotationNo(rs.getString("QUOTATION_NO"));

			return objVo;
		} // mapRow

	} // end of class QuotationRowMapper

	/**
	 * This <code>JdbcRowMapper</code> class used to get onload data
	 */
	class RateTypeRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			ComboVO objComboVO = new ComboVO();
			/* Code */
			objComboVO.setCode(rs.getString("CODE_VALUE"));
			/* Description */
			objComboVO.setName(rs.getString("DESCRIPTION_SHORT"));
			return objComboVO;
		} // mapRow

	} // end of class QuotationRowMapper

	class QuotationInfoRowMapper extends JdbcRowMapper {

		/**
		 *
		 * This mothod for set data to quotation information in each row.
		 *
		 * @exception SQLException
		 * @param rs  List of quotation information
		 * @param row Row of quotation information
		 */
		public Object mapRow(ResultSet rs, int row) throws SQLException {

			EserviceNewWebBookingUim eserviceNewWebBookingUim = new EserviceNewWebBookingUim();
			eserviceNewWebBookingUim.setOriginCountryShow(rs.getString("QTN_ORIGIN"));
			eserviceNewWebBookingUim.setDestinationCountryShow(rs.getString("QTN_DESTINATION"));
			eserviceNewWebBookingUim.setPortOfLoadingShow(rs.getString("QTN_POL"));
			eserviceNewWebBookingUim.setPortOfDischargeShow(rs.getString("QTN_POD"));
			eserviceNewWebBookingUim.setPol(rs.getString("QTN_POL_TERM"));
			eserviceNewWebBookingUim.setPod(rs.getString("QTN_POD_TERM"));
			eserviceNewWebBookingUim.setShipmentType(rs.getString("QTN_SHIPMENT_TYPE"));
			eserviceNewWebBookingUim.setSocCocUserFlag(rs.getString("SOC_COC_FLAG"));
			eserviceNewWebBookingUim.setOriginCountry(rs.getString("ORIGIN_CODE"));
			eserviceNewWebBookingUim.setDestinationCountry(rs.getString("DEST_CODE"));
			eserviceNewWebBookingUim.setPortOfLoading(rs.getString("POL_CODE"));
			eserviceNewWebBookingUim.setPortOfDischarge(rs.getString("POD_CODE"));

			// teerakan add @02 19/07/2013 for set Default to Place of Receipt and Place of
			// Delivery
			eserviceNewWebBookingUim.setPlaceOfReceipt(rs.getString("PLR"));
			eserviceNewWebBookingUim.setPlaceOfDelivery(rs.getString("PLD"));

			// teerakan add

			if (StringUtils.isNotBlank(eserviceNewWebBookingUim.getPol())
					&& StringUtils.isNotEmpty(eserviceNewWebBookingUim.getPol())) {
				String pol = EserviceNewWebBookingDaoImpl.convertToTermValue(eserviceNewWebBookingUim.getPol());
				eserviceNewWebBookingUim.setPolShow(pol);
			}

			if (StringUtils.isNotBlank(eserviceNewWebBookingUim.getPod())
					&& StringUtils.isNotEmpty(eserviceNewWebBookingUim.getPod())) {
				String pod = EserviceNewWebBookingDaoImpl.convertToTermValue(eserviceNewWebBookingUim.getPod());
				eserviceNewWebBookingUim.setPodShow(pod);
			}

			return eserviceNewWebBookingUim;
		}
	}

	/* Begin @06 */
	class ReferCommodityRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceReferCommoditiesUim uim = new EserviceReferCommoditiesUim();

			uim.setTemperature(rs.getString("REEFER_FROM"));
			uim.setVentilation(rs.getString("VENTILATION"));
			uim.setRemark(rs.getString("REEFER_REMARKS"));
			uim.setHumidity(rs.getString("HUMIDITY"));
			uim.setControlledAtmosphere(rs.getString("CONTROLLED_ATM"));
			uim.setNitrogen(rs.getString("NITROGEN"));
			uim.setOxygent(rs.getString("OXYGEN"));
			uim.setCo2(rs.getString("CO2"));
			uim.setRefMode(rs.getString("RFR_MODE"));
			uim.setPreCooled(rs.getString("PRE_COOLED"));

			return uim;
		}
	}

	class DGCommodityRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceDGCommoditiesUim uim = new EserviceDGCommoditiesUim();

			uim.setFlashPoint(rs.getString("HZ_FLPT_FROM"));
			uim.setUnitMeasurement(rs.getString("HZ_BS"));
			uim.setUnNo(rs.getString("UN_NO"));
			uim.setVariant(rs.getString("UN_VARIANT"));
			uim.setImdgClass(rs.getString("IMO_CLASS"));
			uim.setPortClass(rs.getString("PORT_CLASS_CODE"));
			uim.setResidue(rs.getString("RESIDUE"));
			uim.setFumigration(rs.getString("FUMIGATION_YN"));

			uim.setUnNoDis(rs.getString("UN_NO"));
			uim.setVariantDis(rs.getString("UN_VARIANT"));
			uim.setImdgClassDis(rs.getString("IMO_CLASS"));

			return uim;
		}
	}

	class OOGCommodityRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceOOGCommoditiesUim uim = new EserviceOOGCommoditiesUim();

			uim.setTxtLength(rs.getString("OG_LENGTH"));
			uim.setTxtWidth(rs.getString("OG_WIDTH"));
			uim.setTxtHeight(rs.getString("OG_HEIGHT"));
			uim.setTxtDiameter(rs.getString("OG_DIAMETER"));

			return uim;
		}
	}
	/* End @06 */

	class ContryMapper implements RowMapper {

		/**
		 * Map each row of data in the ResultSet.
		 * 
		 * @param rs     {@code ResultSet }
		 * @param rowNum the number of the current row
		 * @return the result object for the current row
		 * @throws SQLException
		 */
		public ContryMod mapRow(ResultSet rs, int rowNum) throws SQLException {
			ContryMod model = null;
			model = new ContryMod();
			model.setCode(rs.getString("CODE"));
			model.setContryName(rs.getString("NAME"));

			return model;
		}
	}

	/* End @06 */

	public List<ContryMod> getContry() {

		String SQL_FOR_CONTRY = "select NAME,CODE from VRL_PORT";

		List<ContryMod> result = getJdbcTemplate().query(SQL_FOR_CONTRY, new Object[] {}, new ContryMapper());

		System.out.println(" Query excuted for SQL_FOR_CONTRY " + result.toString());
		return result;

	}

	public String getContryByContyCode(String code) {
		System.out.println("getContryByContyCode() : "+code);
		if(code.equals("THBK7")) {
			String name="BANGKOK (BARGE)";
			return name;	
		}else if(code.equals("THLKR")) {
			String name="BANGKOK (LAT KRABANG)";
			return name;	
		}else {
		String sqlQuery = "select NAME from VRL_PORT where CODE ='" + code + "'";
		
		List<String> result = getJdbcTemplate().queryForList(sqlQuery, String.class);
		return result.get(0);
		}
		

	}

	public CustomerMod getCustomerDetailes(String code) {

		String sqlQuery = "select cuname,cuadd1,cuadd2,cuadd3,cuadd4 from itp010 where cucust = '" + code + "'";
		List<CustomerMod> result = getJdbcTemplate().query(sqlQuery, new Object[] {}, new CustmerMapper());

		return result.get(0);

	}

	class CustmerMapper implements RowMapper {

		/**
		 * Map each row of data in the ResultSet.
		 *
		 * @param rs     {@code ResultSet }
		 * @param rowNum the number of the current row
		 * @return the result object for the current row
		 * @throws SQLException
		 */
		public CustomerMod mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustomerMod model = null;
			model = new CustomerMod();
			model.setCustomerName(rs.getString("cuname"));

			model.setAddress1(rs.getString("cuadd1"));
			model.setAddress2(rs.getString("cuadd2"));
			model.setAddress3(rs.getString("cuadd3"));
			model.setAddress4(rs.getString("cuadd4"));

			return model;
		}
	}

	public List<EserviceNewWebBookingMod> getQuotationComboDataNew(Map amapParam)
			throws BusinessException, DataAccessException {
		// ---------------------- String array to hold procedure parameter
		JdbcStoredProcedure storedProcedure = null;
		Map resultMap = null;

		String[][] arrParam = { { "P_I_V_POL", BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amapParam.get("POL") },
				{ "P_I_V_POD", BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amapParam.get("POD") },
				{ "P_I_V_USER_ID", BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amapParam.get("USER_ID") },
				{ "P_O_V_BLC_MAPPING_LIST", BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK } //
		};

		// storedProcedure =
		// getStoreProcedure("PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION.PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER",
		// new QuotationRowMapper(), arrParam);

		// resultMap = storedProcedure.execute();
		System.out.println(amapParam.get("ETDATE"));
		PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER proc = new PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER(
				getJdbcTemplate(), amapParam);
		resultMap = proc.executeDbProcedure();
		// ---------------------- return map
		return (List<EserviceNewWebBookingMod>) resultMap.get("P_O_V_BLC_MAPPING_LIST");

	}

	public void getEserviceNewWebBookingUim(Map map, EserviceNewWebBookingUim form) {
		try {
		PRR_ERCL_GET_BKG_HDR_EDIT prd = new PRR_ERCL_GET_BKG_HDR_EDIT(getJdbcTemplate(), map, form);
		prd.executeDbProcedure();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setEquipmentDetailsNew(Map mapParams, EserviceNewWebBookingUim objForm)
			throws BusinessException, DataAccessException {
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;

		mapResult = new HashMap();
		mapResult.put("P_I_V_BKG_NO", objForm.getBookingNo());
		PRR_ERCL_GET_BKG_SIZE_TYPE procEqDtl = new PRR_ERCL_GET_BKG_SIZE_TYPE(getJdbcTemplate(), mapResult);
		procEqDtl.executeDbProcedure();
		mapResult = (Map) mapResult.get(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP);

		List<EserviceEquipmentDetailsMod> equipmentDetails = (List<EserviceEquipmentDetailsMod>) mapResult
				.get("P_O_V_DTL_DATA");
		objForm.setEquipmentVoDataList(equipmentDetails);

	}

	@Override
	public void setCommodityDetailsNew(Map mapParams, EserviceNewWebBookingUim objForm) {

		JdbcStoredProcedure objSP = null;
		Map mapResult = null;
		List<EserviceCommodityDetailsMod> commodityDetails = null;
		EserviceCommodityDetailsMod mod = null;
		Hashtable rateType = null;
		String rateTypeCode = null;
		String rateTypeDesc = null;

		try {

			// objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_COMMODITY_DETAILS,
			// new CommodityDetailsRowMapper(),
			// arrParam);
			// mapResult = objSP.execute();
			mapResult = new HashMap();
			mapResult.put("P_I_V_BKG_NO", objForm.getBookingNo());
			PRR_ERCL_GET_BKG_COMMD procCommodity = new PRR_ERCL_GET_BKG_COMMD(getJdbcTemplate(), mapResult);
			procCommodity.executeDbProcedure();
			mapResult = (Map) mapResult.get("KEY_PROCE_EXCECTION_RESULT_MAP");

			commodityDetails = (List<EserviceCommodityDetailsMod>) mapResult.get("P_O_V_DTL_DATA");
			rateType = this.getRateType();

			if (commodityDetails != null) {
				for (int i = 0; i < commodityDetails.size(); i++) {
					mod = commodityDetails.get(i);
					rateTypeCode = mod.getRateType();

					if (rateTypeCode.equalsIgnoreCase("RF") || rateTypeCode.equalsIgnoreCase("D1")
							|| rateTypeCode.equalsIgnoreCase("O0")) {
//                        mod.setRateTypeClassName(STYLE_GREEN);
						this.setRateTypeDetail(mod, objForm.getBookingNo());
					} else {
						mod.setRateTypeDisabled(true);
					}

					if (rateType.containsKey(rateTypeCode)) {
						rateTypeDesc = (String) rateType.get(rateTypeCode);
						mod.setRateTypeDesc(rateTypeDesc);
					}
				}
			}

			objForm.setCommodityVoDataList(commodityDetails);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingDaoImpl][setCommodityDetails][End]");
		}

	}

	public void setRateTypeDetail(EserviceCommodityDetailsMod objVo, String bookingNo) {
		System.out.println("[EserviceInquiryWebBookingDaoImpl][setRateTypeDetail][Begin]");
//        EserviceCommodityDetailsMod     objVo                                   = null;
		String specialCargo = null;
		String YES = "Y";
		String REFER = "RF";
		String DG = "D1";
		String OOG = "O0";
		EserviceReferCommoditiesUim eserviceReferCommoditiesUim = null;
		EserviceDGCommoditiesUim eserviceDGCommoditiesUim = null;
		EserviceOOGCommoditiesUim eserviceOOGCommoditiesUim = null;
		String rateType = null;
		Map map = new HashMap(0);
		String seq = null;
		List dataList = null;

		try {

			specialCargo = objVo.getSpecialCargo();
			seq = String.valueOf(objVo.getSeqNo());
			rateType = objVo.getRateType();

			System.out.println("[EserviceInquiryWebBookingDaoImpl][setRateTypeDetail] bookingNo :: " + bookingNo);
			System.out.println("[EserviceInquiryWebBookingDaoImpl][setRateTypeDetail] seq :: " + seq);

			String[][] arrParam = { { "P_O_V_DTL_DATA", BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ "P_I_V_BKG_NO", BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
					{ "P_I_V_COMMD_SEQ", BLANK + ORACLE_VARCHAR, PARAM_IN, seq } };

			map.put("P_I_V_BKG_NO", bookingNo);
			map.put("P_I_V_COMMD_SEQ", seq);
			map.put("rateType", rateType);

			if (rateType.equalsIgnoreCase(REFER)) {
				map.put(KEY_PROC_NAME, "PCR_ESV_WEB_BKG.PRR_ESV_GET_BKG_RE_COMMD");
				map.put(KEY_MAPPER_CLASS, new ReferCommodityRowMapper());
				map.put(KEY_PROC_PARAMS, arrParam);
				PRR_ESV_GET_BKG_RE_COMMD proc = new PRR_ESV_GET_BKG_RE_COMMD(getJdbcTemplate(), map);
				proc.executeDbProcedure();
				// map = executeDbProcedure(map);
				dataList = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get("P_O_V_DTL_DATA");
				if (dataList != null) {
					eserviceReferCommoditiesUim = (EserviceReferCommoditiesUim) dataList.get(0);
					objVo.setEserviceReferCommoditiesUim(eserviceReferCommoditiesUim);
					objVo.setRateTypeFlag(YES);
					objVo.setRateTypeClassName(STYLE_GREEN);
				}
			} else if (rateType.equalsIgnoreCase(DG)) {
				map.put(KEY_PROC_NAME, "PCR_ESV_WEB_BKG.PRR_ESV_GET_BKG_DG_COMMD");
				map.put(KEY_MAPPER_CLASS, new DGCommodityRowMapper());
				map.put(KEY_PROC_PARAMS, arrParam);

				// map = executeDbProcedure(map);
				PRR_ESV_GET_BKG_RE_COMMD proc = new PRR_ESV_GET_BKG_RE_COMMD(getJdbcTemplate(), map);
				proc.executeDbProcedure();
				dataList = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get("P_O_V_DTL_DATA");
				if (dataList != null) {
					eserviceDGCommoditiesUim = (EserviceDGCommoditiesUim) dataList.get(0);
					objVo.setEserviceDGCommoditiesUim(eserviceDGCommoditiesUim);
					objVo.setRateTypeFlag(YES);
					objVo.setRateTypeClassName(STYLE_GREEN);
				}
			} else if (rateType.equalsIgnoreCase(OOG)) {
				map.put(KEY_PROC_NAME, "PCR_ESV_WEB_BKG.PRR_ESV_GET_BKG_OOG_COMMD");
				map.put(KEY_MAPPER_CLASS, new OOGCommodityRowMapper());
				map.put(KEY_PROC_PARAMS, arrParam);
				PRR_ESV_GET_BKG_RE_COMMD proc = new PRR_ESV_GET_BKG_RE_COMMD(getJdbcTemplate(), map);
				proc.executeDbProcedure();
				// map = executeDbProcedure(map);
				dataList = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get("P_O_V_DTL_DATA");
				if (dataList != null) {
					eserviceOOGCommoditiesUim = (EserviceOOGCommoditiesUim) dataList.get(0);
					objVo.setEserviceOOGCommoditiesUim(eserviceOOGCommoditiesUim);
					objVo.setRateTypeFlag(YES);
					objVo.setRateTypeClassName(STYLE_GREEN);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingDaoImpl][setRateTypeDetail][End]");
		}

	}

	public Hashtable getRateType() throws BusinessException, DataAccessException {
		System.out.println("[EserviceInquiryWebBookingDaoImpl][getRateType][Begin]");

		Map resultMap = null;
		List lst = null;
		JdbcStoredProcedure storedProcedure = null;
		ComboVO objComboVO = null;
		Hashtable hash = new Hashtable();
		String code = null;
		String name = null;
		String[][] arrParam = { { "P_O_RESULT_STATUS", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ "P_O_RESULT_MESSAGE", BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK },
				{ "P_O_RECORD_SET", BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ "P_I_MODULE", BLANK + ORACLE_VARCHAR, PARAM_IN, "CAM" },
				{ "P_I_TABLE_OWNER", BLANK + ORACLE_VARCHAR, PARAM_IN, "RCL" },
				{ "P_I_TABLE_NAME", BLANK + ORACLE_VARCHAR, PARAM_IN, "EQUIPMENT_BOOKING" },
				{ "P_I_TABLE_FIELD", BLANK + ORACLE_VARCHAR, PARAM_IN, "CARGO_TYPE" },
				{ "P_I_CODE_VALUE", BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK }, };

		try {

			// storedProcedure = getStoreProcedure("PCR_ZCC_MAIN.PRR_GET_CODE_VALUE_LIST",
			// new RateTypeRowMapper(),
			// arrParam);
			resultMap = new HashMap();
			resultMap.put("P_I_MODULE", "CAM");
			resultMap.put("P_I_TABLE_OWNER", "RCL");
			resultMap.put("P_I_TABLE_NAME", "EQUIPMENT_BOOKING");
			resultMap.put("P_I_TABLE_FIELD", "CARGO_TYPE");
			resultMap.put("P_I_CODE_VALUE", BLANK);

			PRR_GET_CODE_VALUE_LIST procRateType = new PRR_GET_CODE_VALUE_LIST(getJdbcTemplate(), resultMap);
			if (storedProcedure != null) {
				procRateType.executeDbProcedure();
				// resultMap = storedProcedure.execute();
				if (resultMap != null && !resultMap.isEmpty()) {
					lst = (List) resultMap.get("P_O_RECORD_SET");

					for (int i = 0; i < lst.size(); i++) {
						objComboVO = (ComboVO) lst.get(i);
						code = objComboVO.getCode();
						name = objComboVO.getName();

						System.out.println("[EserviceInquiryWebBookingDaoImpl][getRateType] code :: " + code);
						System.out.println("[EserviceInquiryWebBookingDaoImpl][getRateType] name :: " + name);

						hash.put(code, name);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("[EserviceInquiryWebBookingDaoImpl][getRateType][End]");
		}
		// ---------------------- return map
		return hash;

	}

	@Override
	public List<ComboVO> getComboData(String comboName) {

		String query = "SELECT  DISTINCT CONFIG_CD,     CONFIG_DESC,    SORT_ORDER"
				+ " FROM    VCM_CONFIG_MST       WHERE CONFIG_TYP = '" + comboName
				+ "'  AND STATUS = 'A'         ORDER BY              SORT_ORDER";
		return getJdbcTemplate().query(query, new RowMapper() {

			@Override
			public ComboVO mapRow(ResultSet rs, int arg1) throws SQLException {
				ComboVO com = new ComboVO(rs.getString("CONFIG_CD"), rs.getString("CONFIG_DESC"));
				return com;
			}
		});

	}

	@Override
	public void cancelBooking(EserviceNewWebBookingUim formObj) {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String cuuntDate = dateFormat.format(date);
		
		String CANCEL_BOOKING = "update SEALINER.BKP001 set "
				+ " BASTAT='N' , BKG_CONFRIM_DATE='" +cuuntDate+"'"
				+ ", SPLSTATS='N' "
				+ " where babkno= '" + formObj.getBookingNo() + "' ";
		getJdbcTemplate().update(CANCEL_BOOKING);

		String CHECK_ESI_HEADER = "select count(*) from ESV_SI_HEADER WHERE FK_BOOKING_NO='"+formObj.getBookingNo()+"'";
		int count = getJdbcTemplate().queryForInt(CHECK_ESI_HEADER);
		
		if (count > 0) {
			int sqnNoHrd=0;
			String GET_SQN_NO= "select pk_hdr_seqno from ESV_SI_HEADER  WHERE FK_BOOKING_NO='"+formObj.getBookingNo()+"'";
			sqnNoHrd =   getJdbcTemplate().queryForInt(GET_SQN_NO);
			
			String DELETE_FROM_ESV_SI_HEADER =  "DELETE FROM ESV_SI_HEADER WHERE FK_BOOKING_NO='"+formObj.getBookingNo()+"'";
		    String REMOVE_FROM_ESV_SI_CON =  "DELETE FROM ESV_SI_CONTAINERS con where con.fk_hdr_seqno="+sqnNoHrd   ;
		    String REOMVE_FROM_ESV_SI_COM =  "DELETE FROM ESV_SI_COMMODITY comm where comm.fk_hdr_seqno="+sqnNoHrd ;
			
		    System.out.println("1 DELETE_FROM_ESV_SI_HEADER " + DELETE_FROM_ESV_SI_HEADER);
		    getJdbcTemplate().update(DELETE_FROM_ESV_SI_HEADER);
			
			System.out.println("2 REMOVE_FROM_ESV_SI_CON " + REMOVE_FROM_ESV_SI_CON);
			getJdbcTemplate().update(REMOVE_FROM_ESV_SI_CON);
			
			System.out.println("3 REOMVE_FROM_ESV_SI_COM " + REOMVE_FROM_ESV_SI_COM);
			getJdbcTemplate().update(REOMVE_FROM_ESV_SI_COM);
		}

	}

	@Override
	public List<TerminalMod> getTeminal() {
		 
		String SQL_FOR_TERMINAL = "SELECT PK_TERMINAL,TERMINAL_NAME FROM cam_terminal_depot";

		List<TerminalMod> result = getJdbcTemplate().query(SQL_FOR_TERMINAL, new Object[] {}, new TerminalMapper());

		System.out.println(" Query excuted for SQL_FOR_CONTRY " + result.toString());
		
		return result;
	}
	class TerminalMapper implements RowMapper {

		/**
		 * Map each row of data in the ResultSet.
		 * 
		 * @param rs     {@code ResultSet }
		 * @param rowNum the number of the current row
		 * @return the result object for the current row
		 * @throws SQLException
		 */
		public TerminalMod mapRow(ResultSet rs, int rowNum) throws SQLException {
			TerminalMod model = null;
			model = new TerminalMod();
			model.setTerminalCode(rs.getString("PK_TERMINAL"));
			model.setTerminalName(rs.getString("TERMINAL_NAME"));

			return model;
		}
	}

	@Override
	public List<AutoCompleteVO> getPolList(String val) {
		
		String searchVal=val;
		String query="select DISTINCT pk_port_code,port_name from cam_port where   fk_country NOT IN ('AU','IR','CY') " + 
				"      and record_status = 'A'  and  pk_port_code like'%"+searchVal+"%' ORDER BY pk_port_code limit 50";
		
		List<AutoCompleteVO> list=getJdbcTemplate().query(query, new PolPodMapper());
		
		return list;
	}
	
	class PolPodMapper implements RowMapper {

		/**
		 * Map each row of data in the ResultSet.
		 * 
		 * @param rs     {@code ResultSet }
		 * @param rowNum the number of the current row
		 * @return the result object for the current row
		 * @throws SQLException
		 */
		public AutoCompleteVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			AutoCompleteVO model = null;
			model = new AutoCompleteVO();
			model.setValue(rs.getString("pk_port_code"));
			model.setText(rs.getString("port_name"));

			return model;
		}
	}
	

	@Override
	public String getCommodityCode(String group) {
		String commodityCode="";
		if(group!= null) {
			group=group.trim();
		}
		String query ="select fccode  " + 
				"from ITP080 " + 
				"WHERE FCRCST='A' " + 
				"and commodity_group_code='"+group+"' " + 
				" and LENGTH(fccode)=6 "+
				"order by fccode LIMIT   1";
		
		try {
		 commodityCode=(String) getJdbcTemplate().queryForObject(query, Object.class);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("getCommodityCode "+query);
		}
		return commodityCode;
	}
	@Override
	public String getCommodityGroupCode(String code) {
		String commodityCode="";
		if(code!= null) {
			code=code.trim();
		}
		String query ="select commodity_group_code  " + 
				"from ITP080 " + 
				"WHERE FCRCST='A' " + 
				"and fccode='"+code+"' " + 
				"order by fccode LIMIT   1";
		try {
		 commodityCode=(String) getJdbcTemplate().queryForObject(query, Object.class);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("getCommodityGroupCode "+query);
		}
		return commodityCode;
	}

	public void saveEquipmentBkgTable(List<EserviceEquipmentDetailsMod> equipmentDetailsList,String bookingNo) {
		
		String CLEAR_EQUPMENT_DATA="DELETE FROM BKG_EQUIPMENT where BIBKNO='"+bookingNo+"'";		
		
		getJdbcTemplate().update(CLEAR_EQUPMENT_DATA);		
		
		for (int i = 0; i < equipmentDetailsList.size(); i++) {
			 
			/*
			 * String V_EQP_SEQ_query = "SELECT COALESCE(MAX(EQP_SIZETYPE_SEQNO)+1,1)  " +
			 * "FROM SEALINER.BKP032 WHERE BCBKNO='" + bookingNo +
			 * "' and bcsize='"+equipmentDetailsList.get(i).getSize()+"' and bctype='"
			 * +equipmentDetailsList.get(i).getType()+"' "; String sqn=(String)
			 * getJdbcTemplate().queryForObject(V_EQP_SEQ_query, Object.class);
			 */
			if(equipmentDetailsList.get(i).getEqNumber()!=null && !equipmentDetailsList.get(i).getEqNumber().equals("")) {
			System.out.println("BKG_EQUIPMENT "+equipmentDetailsList.get(i).getEqNumber());
				String INSERT_BKG_EQUIPMENT = "INSERT INTO BKG_EQUIPMENT (BICTRN,BIBKNO,CARRIER_SEAL_VIN,SHIPPER_SEAL,MET_WEIGHT,"
					+ "					  MET_MEASUREMENT,BIEORF,BICSZE,BICNTP,BISEQN	)"
					+ "					  VALUES('"+equipmentDetailsList.get(i).getEqNumber()+"','" + bookingNo + "','','',"
					+ ((equipmentDetailsList.get(i).getGrossContainerWeight()==null || equipmentDetailsList.get(i).getGrossContainerWeight().equals(""))?null:equipmentDetailsList.get(i).getGrossContainerWeight()) + 
					",null,'L','" + equipmentDetailsList.get(i).getSize() + "',"
					+ "					  '" + equipmentDetailsList.get(i).getType() + "'," + i+"" + ")	";

			getJdbcTemplate().update(INSERT_BKG_EQUIPMENT);
			}
		}
	}

	@Override
	public String getUSerID(String bookingNo) {

		String query="select baausr from SEALINER.BKP001 where babkno='"+bookingNo+"'";
		System.out.println("edi get user id "+query);
		String userid=(String) getJdbcTemplate().queryForObject(query, Object.class);
		return userid;
	}

	@Override
	public String getTerminalDes(String terminal) {
		 
				String query="SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal = '"+terminal+"'";
				String terminalResult=(String) getJdbcTemplate().queryForObject(query, Object.class);
		return terminalResult;
	}

	@Override
	public String checkContaineAvailability(EserviceNewWebBookingUim form) {
		String query="select count(*) from BKG_EQUIPMENT where bibkno='"+form.getBookingNo()+"'";
				int count=	getJdbcTemplate().queryForInt(query) ;
				if(count>0)
						return 	"AVA";
				else
						return "NAVA";
				
	}
	
	public double converNo(String no) {
		if(no.equals(""))
			return 0;
		else
			return Double.valueOf(no);
		
	}

	@Override
	public String getRepresentCompName(String bookingNo) {

		String orgCode="Select CUSTOMER_NAME  from SEALINER.BKP001 a INNER JOIN CAM_CUSTOMER  b on a.babkby=b.PK_CUSTOMER_CODE where a.babkno='"+bookingNo+"'";
		String company=(String) getJdbcTemplate().queryForObject(orgCode, Object.class);
		return company;
	}

	@Override
	public String getBookingPatyCompName(String bookingNo) {
		String orgCode="Select CUSTOMER_NAME  from SEALINER.BKP030 a INNER JOIN CAM_CUSTOMER  b on a.BNCSCD=b.PK_CUSTOMER_CODE where a.bnbkno='"+bookingNo+"' and a.bncstp='O'";
		System.out.println("orgCode "+orgCode);
		String company=(String) getJdbcTemplate().queryForObject(orgCode, Object.class);
		return company;
	}

	@Override
	public String getPointByContyCode(String code) {
		System.out.println("getContryByContyCode() : "+code);
		if(code.equals("THBK7")) {
			String name="BANGKOK (BARGE)";
			return name;	
		}else if(code.equals("THLKR")) {
			String name="BANGKOK (LAT KRABANG)";
			return name;	
		}else {
		String sqlQuery = "select point_name from POINT_MASTER where point_code ='" + code + "'";
		
		List<String> result = getJdbcTemplate().queryForList(sqlQuery, String.class);
		return result.get(0);
		}
		

	}

	@Override
	public Map getEmptyPickUpDepoData(String placeOfReceipt) {
		
		Map mapResult=new HashMap();
		
		if(placeOfReceipt.equals("THLKR")) {
		mapResult.put("P_I_V_COUNTRY_CODE", "THLCH");
		mapResult.put("P_I_V_PORT_OF_LOADING", "THLCH");	
		}else {
		mapResult.put("P_I_V_COUNTRY_CODE", placeOfReceipt);
		mapResult.put("P_I_V_PORT_OF_LOADING", placeOfReceipt);
		}
		PRE_GET_EMPTY_PICKUP_DEPOT prgMTPickupDepot = new PRE_GET_EMPTY_PICKUP_DEPOT(getJdbcTemplate(), mapResult);
		prgMTPickupDepot.executeDbProcedure();
		
		return mapResult;
	}

	
	 
}
