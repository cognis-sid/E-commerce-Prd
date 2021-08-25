/* -----------------------------------------------------------------------------
System  : RCLEAPPS
Module  : Common
Prog ID : ESER008 - EserviceInquiryWebBookingDaoImpl.java
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
## 02/08/2013   TANA    01           change value R to J for Reject
## 20/09/2013   TANA    02           change format for gross weight to 2 digit
## 04/10/2013   TANA    03           add "and booking_Type <> 'TB'"
## 04/10/2013   PRATYA  04           Eservice phase 3.1
## 27/10/2014   Pratya  05           PD_CR_20140826_ESV [Contract Party for registeration]
## 27/10/2014   Pratya  06           PD_CR_20141003_ESV [COC_SOC in eBKG]
## 10/06/2015   Sarawut 07           Change query for new where condition
## 21/06/2016   Tanaphol 08          Change table from VASAPPS.ESV_CONTRACT_PARTY_PORT_PAIR to VASAPPS.ESV_CONTRACT_PARTY_PP_HDR
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.mozilla.javascript.ObjArray;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.niit.control.common.ComboVO;
import com.niit.control.common.Debug;
import com.niit.control.common.PagingUtil;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.common.exception.ExceptionFactory;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.eservice.action.EservicePropertyFatchOperation;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceDGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceOOGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceReferCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDaoImpl.RoutingDtlsRowMappers;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceBookingListMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceInquieyHeaderMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceInquiryCustomerDtlMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRoutingDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.RoutingDtldsVo;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_COMMD;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_HDR_INQUIRY;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_ROUTING;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_SIZE_TYPE;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_BKG_RE_COMMD;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_GET_CODE_VALUE_LIST;

/**
 * Class for DAO
 * 
 * @class EserviceNewWebBookingDaoImpl
 * @author NTL) Vikas
 * @version v1.00 2013/04/29
 * @see
 */
public class EserviceInquiryWebBookingDaoImpl extends AncestorJdbcDao implements EserviceInquiryWebBookingDao {

	public NumberFormat nf = new DecimalFormat("#,###");
	// @02 BEGIN
	public NumberFormat nf2digit = new DecimalFormat("#,###.00");
	// @02 END

	public EserviceInquiryWebBookingDaoImpl() {
	}

    public Map getListWebBooking(Map amap) throws BusinessException, 
                                             DataAccessException {
                                             
        System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][Begin]");
                                             
        List<EserviceBookingListMod>    list            = null;
        String                          findText        = null;
        String                          column          = null;
        String                          sortby          = null;
        String                          order           = null;
        String                          status          = null;
        String                          wildcard        = null;
        Integer                         fromRecord      = null;
        Integer                         toRecord        = null;
        String                          userId          = null;
        int                             rows            = 0;
        String                          sql             = null;
        PagingUtil                      pu              = null;
        SqlRowSet                       r               = null;
        String                          bookingDate     = null;
        EserviceBookingListMod          blm             = null;
        StringBuffer                    sqlStmtCount    = new StringBuffer("");
        StringBuffer                    sqlStmtFSC      = new StringBuffer("");
        String                          controlFSC      = null;
        String                          userFSC         = null;
        StringBuffer                    sqlCondition    = new StringBuffer("");
        
        //@01 @03 BEGIN
        StringBuffer                    sqlStatement    =  new StringBuffer("");
        //@01 @03 END
        System.out.println("new property data testing "+EservicePropertyFatchOperation.ip);
        try{
            findText        = (String)amap.get(KEY_CRITERIA_TEXT_FIND);
            column          = (String)amap.get(KEY_CRITERIA_COLUMN);
            sortby          = (String)amap.get(KEY_CRITERIA_SORTBY);
            order           = (String)amap.get(KEY_CRITERIA_ORDER);
            status          = (String)amap.get(KEY_CRITERIA_STATUS);
            wildcard        = (String)amap.get(KEY_CRITERIA_WILDCARD);
            fromRecord      = (Integer)amap.get(KEY_FROM_RECORD);
            toRecord        = (Integer)amap.get(KEY_TO_RECORD);
            userId          = (String)amap.get(KEY_USER_ID);
            
            //@07 Begin
            sqlStmtCount.append(" SELECT COUNT(*) AS CCOUNT");
            sqlStmtCount.append(" FROM VASAPPS.ZCC_CODE_VALUE Z,RCLTBLS.ESM_USER_LOGIN U");
            sqlStmtCount.append(" WHERE Z.CODE_VALUE=U.ORG_CODE");
            sqlStmtCount.append(" AND Z.module='ESV' AND Z.TABLE_FIELD='BKG_ESI_ORG_CODE'");
            sqlStmtCount.append(" AND Z.RECORD_STATUS='A' AND U.USER_ID='"+userId+"'");
            
            int rsCount = getNamedParameterJdbcTemplate().queryForInt(sqlStmtCount.toString(), new HashMap());
            
            if (rsCount > 0){
                sqlStmtFSC.append(" SELECT I.CONTROL_FSC,U.FSC_CODE");
                sqlStmtFSC.append(" FROM SEALINER.ITP188 I ,RCLTBLS.ESM_USER_LOGIN U");
                sqlStmtFSC.append(" WHERE I.CRCNTR = U.FSC_CODE");
                sqlStmtFSC.append(" AND I.CRRCST='A' AND ROWNUM=1 AND U.USER_ID='"+userId+"'");
                
                SqlRowSet rsFSC = getNamedParameterJdbcTemplate().queryForRowSet(sqlStmtFSC.toString(), new HashMap());
                
                while (rsFSC.next()) {
                    controlFSC = rsFSC.getString("CONTROL_FSC");
                    userFSC = rsFSC.getString("FSC_CODE");
                }
                
                if (userFSC != null && userFSC.length() > 0 && !"R".equals(userFSC)){
                    if (controlFSC != null && controlFSC.length() > 0 && "Y".equals(controlFSC)){
                        sqlCondition.append(" AND BAOFFC IN (SELECT DISTINCT CRCNTR FROM  SEALINER.ITP188 WHERE CRFLV3='"+userFSC+"')");
                    }else{
                        sqlCondition.append(" AND BAOFFC IN (SELECT DISTINCT CRCNTR FROM  SEALINER.ITP188 WHERE CRCNTR='"+userFSC+"')");
                    }
                }                
            }else{
                sqlCondition.append(" AND BABKBY IN (SELECT ORG_CODE FROM SC_PRSN_LOG_INFO WHERE PRSN_LOG_ID = '"+userId+"'");
                
                //@08 BEGIN
                 sqlCondition.append(" UNION SELECT DISTINCT FK_CONTRACT_PARTY_CODE FROM VASAPPS.ESV_CONTRACT_PARTY_PP_HDR");
                 sqlCondition.append(" WHERE RECORD_STATUS= 'A' AND USER_ID = '"+userId+"')");
//                sqlCondition.append(" UNION SELECT DISTINCT FK_CONTRACT_PARTY_CODE FROM VASAPPS.ESV_CONTRACT_PARTY_PORT_PAIR");
//                sqlCondition.append(" WHERE RECORD_STATUS= 'A' AND FK_USER_ID = '"+userId+"')");
                //@08 END
            }
            //@07 End
            //sqlStatement.append("select BABKDT as \"Booking Date\"");
            //sqlStatement.append("     , BABKNO as \"BOOKING_NO\"");
            //sqlStatement.append("     , BABKTP \"COC/SOC\"");
            //sqlStatement.append("     , DECODE(BOOKING_TYPE,'N','NORMAL','ER','EMPTY REPO','TB','TEMPLATE','MB','MASTER','SP','SPONSORSHIP','FC','FEEDER CARGO') as \"BOOKING TYPE\"");
            //sqlStatement.append("     , BAPOL as \"POL\"");
            //sqlStatement.append("     , BAPOD as \"POD\"");
            //sqlStatement.append("     , DECODE(BASTAT,'O','Open','C','Confirmed','W','Waitlisted','N','Cancelled','J','Rejected','L','Closed','P','Partial') as \"Status\"");
            //sqlStatement.append("     from BKP001 ");
            //sqlStatement.append("     where BABKBY IN (SELECT ORG_CODE FROM SC_PRSN_LOG_INFO WHERE PRSN_LOG_ID = '"+userId+"'\n" + 
            //                    "                      UNION \n" + 
            //                    "                      SELECT DISTINCT FK_CONTRACT_PARTY_CODE\n" + 
            //                        "                      FROM VASAPPS.esv_contract_party_port_pair\n" + 
            //                        "                      WHERE FK_USER_ID = '"+userId+"' \n" + 
            //                        "                      AND RECORD_STATUS='A')");
            //sqlStatement.append("       and created_thru_Web = 'Y' and booking_Type <> 'TB'");
            
            if(null!=column && !"".equals(column)){
                sqlCondition.append(" and ");
                
                if(KEY_COLUMN_BOOKING_DATE.equals(column)){
                    sqlCondition.append(" (substr(BABKDT,7,2)||'/'||substr(BABKDT,5,2)||'/'||substr(BABKDT,0,4)) ");
                }else{
                    sqlCondition.append(column);
                }
                
                if(null!=wildcard){
                    sqlCondition.append(" like '%"+findText.trim()+"%'");
                }else{
                    sqlCondition.append(" = '"+findText.trim()+"'");
                }
            }
            
            if(null!=status  && !"".equals(status)){
                sqlCondition.append(" and BASTAT = '"+status+"'");
            }  
                        
            sqlStatement.append(" select BABKDT as Booking_Date");
            sqlStatement.append("     , BABKNO as BOOKING_NO");
            sqlStatement.append("     , BABKTP COC_SOC");
            sqlStatement.append("     , DECODE(BOOKING_TYPE,'N','NORMAL','ER','EMPTY REPO','TB','TEMPLATE','MB','MASTER','SP','SPONSORSHIP','FC','FEEDER CARGO') as BOOKING_TYPE");
            sqlStatement.append("     , BAPOL as POL");
            sqlStatement.append("     , BAPOD as POD");
            sqlStatement.append("     , DECODE(BASTAT,'O','Open','C','Confirmed','W','Waitlisted','N','Cancelled','J','Rejected','L','Closed','P','Partial') as Status");
            sqlStatement.append(" from BKP001 ");
            sqlStatement.append(" where created_thru_Web = 'Y' and booking_Type <> 'TB' "+sqlCondition);            
            sqlStatement.append(" order by BABKDT desc,BABKNO,BABKTP,BOOKING_TYPE,BAPOL,BAPOD,BASTAT");
                        
            sql     = sqlStatement.toString();
            
            if((null!=fromRecord && !"".equals(fromRecord)) && (null!=toRecord && !"".equals(toRecord))){
                pu          = new PagingUtil();
                sql         = pu.getSqlRows(sqlStatement);
                r           = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());
                
                while (r.next()){
                    rows = r.getInt(1);
                }
                
                sql = pu.setRownum(sqlStatement, fromRecord, toRecord);
            }
            
            System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] sql : " + sql);
    
            SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());
    
    //------------------ for paging without rownum in SQL --------------------        
    //        rs.last();
    //        int size = rs.getRow();
    //        rs.beforeFirst();
    //        System.out.println("Row(s) with from-to record : " + size);
    
            System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] Row(s) All : " + rows);
            
            list = new ArrayList<EserviceBookingListMod>();
            
            while (rs.next()) {
                blm         = new EserviceBookingListMod();
                bookingDate = rs.getString("Booking_Date");
                
                blm.setBookingDate  (null!=bookingDate?bookingDate.substring(6,8)+"/"+bookingDate.substring(4,6)+"/"+bookingDate.substring(0,4):bookingDate);
                blm.setBookingNo    (rs.getString("BOOKING_NO"));
                blm.setCocSoc       (rs.getString("COC_SOC"));
                blm.setBookingType  (rs.getString("BOOKING_TYPE"));
                blm.setPol          (rs.getString("POL"));
                blm.setPod          (rs.getString("POD"));
                blm.setStatus       (rs.getString("Status"));
                
                list.add(blm);
            }
            
            amap.put(KEY_DATA, list);
            amap.put(KEY_SIZE, rows);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][End]");
        }
        
        return amap;        
    }    

	public void setBookingHeader(Map amap, EserviceInquiryWebBookingUim form) {
		System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader][Begin]");

		JdbcStoredProcedure objSP = null;
		Map mapResult = null;
		String[][] arrParam = null;

		System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader] (String)amap.get(KEY_USER_ID) >>>>>>"
				+ (String) amap.get(KEY_USER_ID));
		try {
			arrParam = new String[][] { { KEY_REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(KEY_BOOKING_NO) },
					{ KEY_P_USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(KEY_USER_ID) } };

			objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_BOOKING_HEADER, new BookingHeaderRowMapper(form),
					arrParam);
			mapResult = objSP.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader][End]");
		}
	}

	public class BookingHeaderRowMapper extends JdbcRowMapper {

		private EserviceInquiryWebBookingUim form;

		public BookingHeaderRowMapper(EserviceInquiryWebBookingUim form) {
			this.form = form;
		}

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			form.setBookingNo(rs.getString("BABKNO"));
			form.setQuotationNumber(rs.getString("BAQUNO"));

			String status = rs.getString("BASTAT");
			if (null != status) {
				if ("O".equals(status)) {
					status = "Open";
				} else if ("C".equals(status)) {
					status = "Confirmed";
				} else if ("W".equals(status)) {
					status = "Waitlisted";
				} else if ("N".equals(status)) {
					status = "Cancelled";
				} else if ("J".equals(status)) {
					status = "Rejected";
				} else if ("L".equals(status)) {
					status = "Closed";
				} else if ("P".equals(status)) {
					status = "Partial";
				}
			}
			form.setStatus(status);

			form.setContact(rs.getString("BACLBY"));
			form.setTelephone(rs.getString("BACBPH"));
			form.setFax(rs.getString("CALLER_FAX"));
			form.setEmail(rs.getString("CALLER_EMAIL"));
			form.setShipmentTerm(rs.getString("BAMODE"));
			form.setCustomerReference(rs.getString("REFERENCE_NO"));
			form.setPlaceOfReceipt(rs.getString("PLR_NAME"));
			form.setPortOfLoading(rs.getString("POL_NAME"));
			form.setPortOfDischarge(rs.getString("POD_NAME"));
			form.setPlaceOfDelivery(rs.getString("PLD_NAME"));
			form.setTemplateName(rs.getString("WEB_BOOK_REF"));
			form.setShipmentDate(rs.getString("BACADT"));
			form.setAdditionalMailRecipeints(rs.getString("ADDITIONAL_EMAILS"));
			form.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
			form.setRoutingPreference(rs.getString("ROUTE_PREFERENCE"));
			form.setCargoDescription(rs.getString("CARGO_DESC"));
			form.setOriginCountry(rs.getString("ORGN_COUNTRY_NAME"));
			form.setDestinationCountry(rs.getString("DSTN_COUNTRY_NAME"));
			form.setSailingDate(rs.getString("EXPECTED_SAILING_DATE"));
			/* Begin @05 */
			form.setRepresentCompChkBox(rs.getString("REP_FLAG"));
			form.setRepresentComp(rs.getString("REP_NAME"));
			/* End @05 */
			form.setSocCocUserFlag(rs.getString("COC_SOC"));// @06

			return null;
		}
	}

	public void setEquipmentDetails(Map amap, EserviceInquiryWebBookingUim form) {
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;

		/*
		 * Prepare 2D Array of Parameters to be passed to SP 1. Param Name 2. Oracle
		 * Data Type 3. Param Type(In/Out/InOut) 4. Param Value(for In/InOut types)
		 */
		String[][] arrParam = { { KEY_DTL_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(KEY_BOOKING_NO) } };

		objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_EQUIPMENT_DETAILS,
				new EquipementDetailsRowMapper(form), arrParam);
		mapResult = objSP.execute();

		List<EserviceEquipmentDetailsMod> equipmentDetails = (List<EserviceEquipmentDetailsMod>) mapResult
				.get(KEY_DTL_CURSOR_DATA);
		form.setEquipmentDetails(equipmentDetails);
	}

	public class EquipementDetailsRowMapper extends JdbcRowMapper {

		private EserviceInquiryWebBookingUim form;
		private int i = 1;

		public EquipementDetailsRowMapper(EserviceInquiryWebBookingUim form) {
			this.form = form;
		}

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			EserviceEquipmentDetailsMod edm = new EserviceEquipmentDetailsMod();
			edm.setSize(rs.getString(1));
			edm.setType(rs.getString(2));
			edm.setCargoType(rs.getString(3));
			edm.setLaden(nf.format(rs.getInt(4)));
			edm.setMt(nf.format(rs.getInt(5)));
			edm.setEqSeqNo(rs.getInt(6));
			edm.setPolStatus(rs.getString(7));
			edm.setPodStatus(rs.getString(8));
			if (1 == i) {
				form.setEmptyPickupDepot(rs.getString(14));
				form.setEmptyPickupDate(rs.getString(13));

//                System.out.println("form.getEmptyPickupDepot() >>>>>>>>>>>>>>>>> "+form.getEmptyPickupDepot());
			}

			// @02 BEGIN
			edm.setGrossContainerWeight(nf2digit.format(rs.getDouble(15)));
			// @02 END

			return edm;
		}
	}

	public void setCommodityDetails(Map amap, EserviceInquiryWebBookingUim form) {
		System.out.println("[EserviceInquiryWebBookingDaoImpl][setCommodityDetails][Begin]");

		JdbcStoredProcedure objSP = null;
		Map mapResult = null;
		List<EserviceCommodityDetailsMod> commodityDetails = null;
		EserviceCommodityDetailsMod mod = null;
		Hashtable rateType = null;
		String rateTypeCode = null;
		String rateTypeDesc = null;

		try {
			String[][] arrParam = { { KEY_DTL_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(KEY_BOOKING_NO) } };

			objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_COMMODITY_DETAILS, new CommodityDetailsRowMapper(),
					arrParam);
			mapResult = objSP.execute();
			commodityDetails = (List<EserviceCommodityDetailsMod>) mapResult.get(KEY_DTL_CURSOR_DATA);
			rateType = this.getRateType();

			if (commodityDetails != null) {
				for (int i = 0; i < commodityDetails.size(); i++) {
					mod = commodityDetails.get(i);
					rateTypeCode = mod.getRateType();

					if (rateTypeCode.equalsIgnoreCase("RF") || rateTypeCode.equalsIgnoreCase("D1")
							|| rateTypeCode.equalsIgnoreCase("O0")) {
//                        mod.setRateTypeClassName(STYLE_GREEN);
						this.setRateTypeDetail(mod, form.getBookingNo());
					} else {
						mod.setRateTypeDisabled(true);
					}

					if (rateType.containsKey(rateTypeCode)) {
						rateTypeDesc = (String) rateType.get(rateTypeCode);
						mod.setRateTypeDesc(rateTypeDesc);
					}
				}
			}

			form.setCommodityDetails(commodityDetails);
			if (!commodityDetails.isEmpty()) {
				form.setFirstCheckedCommodity(commodityDetails.get(0).getSeqNo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingDaoImpl][setCommodityDetails][End]");
		}
	}

	/* Begin @04 */
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
				PRR_ESV_GET_BKG_RE_COMMD proc=new PRR_ESV_GET_BKG_RE_COMMD(getJdbcTemplate(),map);
				proc.executeDbProcedure();
				//map = executeDbProcedure(map);
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

				//map = executeDbProcedure(map);
				PRR_ESV_GET_BKG_RE_COMMD proc=new PRR_ESV_GET_BKG_RE_COMMD(getJdbcTemplate(),map);
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
				PRR_ESV_GET_BKG_RE_COMMD proc=new PRR_ESV_GET_BKG_RE_COMMD(getJdbcTemplate(),map);
				proc.executeDbProcedure();
				//map = executeDbProcedure(map);
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
	/* End @04 */

	/* Begin @04 */
	public void setUploadListDetail(EserviceInquiryWebBookingUim form, EserviceUploadUim eserviceUploadUim) {
		System.out.println("[EserviceInquiryWebBookingDaoImpl][setUploadListDetail][Begin]");
		Map map = new HashMap(0);
		List dataList = null;
		String bookingNo = null;

		try {
			bookingNo = form.getBookingNo();
			System.out.println("[EserviceInquiryWebBookingDaoImpl][setUploadListDetail] bookingNo :: " + bookingNo);

			String[][] arrParam = { { "P_O_V_UPLOAD_LIST", BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ "P_I_V_BKG_NO", BLANK + ORACLE_VARCHAR, PARAM_IN, bookingNo },
					{ "P_I_V_BKG_DATE_FROM", BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK },
					{ "P_I_V_BKG_DATE_TO", BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK },
					{ "P_I_V_BOOKED_BY", BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK },
					{ "P_I_V_SORT_BY", BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK },
					{ "P_I_V_ORDER_BY", BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK },
					{ "P_I_V_USER_ID", BLANK + ORACLE_VARCHAR, PARAM_IN, BLANK } };

			map.put(KEY_PROC_NAME, "PCR_ESV_WEB_BKG.PRR_ESV_GET_UPLOAD_LIST");
			map.put(KEY_MAPPER_CLASS, new UploadListRowMapper());
			map.put(KEY_PROC_PARAMS, arrParam);

			map = executeDbProcedure(map);
			dataList = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get("P_O_V_UPLOAD_LIST");

			System.out.println("[EserviceInquiryWebBookingDaoImpl][setUploadListDetail] dataList :: " + dataList);
			if (dataList != null) {
				System.out.println("[EserviceInquiryWebBookingDaoImpl][setUploadListDetail] dataList.size() :: "
						+ dataList.size());
				eserviceUploadUim.setList(dataList);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingDaoImpl][setUploadListDetail][End]");
		}

	}
	/* End @04 */

	/* Begin @04 */
	/**
	 * Method to populate combo data for Rate Type.
	 * 
	 * @param
	 * @return
	 * @throws BusinessException
	 * @throws DataAccessException
	 */
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

			//storedProcedure = getStoreProcedure("PCR_ZCC_MAIN.PRR_GET_CODE_VALUE_LIST", new RateTypeRowMapper(),
			//		arrParam);
			resultMap=new HashMap();
			resultMap.put("P_I_MODULE", "CAM");
			resultMap.put("P_I_TABLE_OWNER", "RCL");
			resultMap.put("P_I_TABLE_NAME", "EQUIPMENT_BOOKING");
			resultMap.put("P_I_TABLE_FIELD", "CARGO_TYPE");
			resultMap.put("P_I_CODE_VALUE", BLANK);
			
			PRR_GET_CODE_VALUE_LIST procRateType=new PRR_GET_CODE_VALUE_LIST(getJdbcTemplate(),resultMap);
			if (storedProcedure != null) {
				procRateType.executeDbProcedure();
				//resultMap = storedProcedure.execute();
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
	/* End @04 */

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
			if ("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PLACE_OF_RECEIPT"
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

	public class CommodityDetailsRowMapper extends JdbcRowMapper {

		private int i = 1;

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			EserviceCommodityDetailsMod cdm = new EserviceCommodityDetailsMod();

			cdm.setSeqNo(rs.getInt("BWCMSQ"));
			if (1 == i) {
				cdm.setRadCommodity(String.valueOf(cdm.getSeqNo()));
			}
			cdm.setGroup(rs.getString("COMMODITY_GROUP_CODE"));
			cdm.setDescription(rs.getString("DESCRIPTION"));
			// @02 BEGIN
			cdm.setGrossWeight(nf2digit.format(rs.getDouble("BWMTWT")));
			// @02 END
			cdm.setMeasurement(nf2digit.format(rs.getDouble("BWMTMS")));
			
			cdm.setSpecialInstruction(rs.getString("BGRMKS"));

			/* Begin @04 */
			cdm.setSpecialCargo(rs.getString("SPECIAL_FLAG"));
			cdm.setRateType(rs.getString("SPECIAL_HANDLING"));
			/* End @04 */

			i++;

			return cdm;
		}
	}

	class UploadListRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			System.out.println("[UploadListRowMapper][mapRow][Begin]");

			String fileName = null;
			String newFileName = null;
			String[] fileNameArray = null;
			EserviceUploadMod eserviceUploadMod = null;

			try {
				eserviceUploadMod = new EserviceUploadMod();
				fileNameArray = rs.getString("FILE_NAME").split("::");
				fileName = fileNameArray[0];
				newFileName = fileNameArray[1];

				eserviceUploadMod.setFileName(fileName);
				eserviceUploadMod.setNewFileName(newFileName);
				eserviceUploadMod.setSeq(rs.getString("PK_UPLOAD_DTL_SEQ"));
				eserviceUploadMod.setStatus("SER");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("[UploadListRowMapper][mapRow][End]");
			}

			return eserviceUploadMod;
		} // mapRow

	}

	class RateTypeRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			ComboVO objComboVO = new ComboVO();
			/* Code */
			objComboVO.setCode(rs.getString("CODE_VALUE"));
			/* Description */
			objComboVO.setName(rs.getString("DESCRIPTION_SHORT"));
			return objComboVO;
		} // mapRow

	}

	public void setRoutingDetails(Map amap, EserviceInquiryWebBookingUim form) {
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;

		/*
		 * Prepare 2D Array of Parameters to be passed to SP 1. Param Name 2. Oracle
		 * Data Type 3. Param Type(In/Out/InOut) 4. Param Value(for In/InOut types)
		 */
		String[][] arrParam = { { KEY_DTL_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) amap.get(KEY_BOOKING_NO) } };

		//objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_ROUNTING_DETAILS, new RoutingDetailsRowMapper(),
		//		arrParam);
		//mapResult = objSP.execute();
		
		mapResult=new HashMap();
		
		mapResult.get("p_i_v_bkg_no");
		
		PRR_ERCL_GET_BKG_ROUTING procRouting=new PRR_ERCL_GET_BKG_ROUTING(getJdbcTemplate(),mapResult);
		
		mapResult=procRouting.executeDbProcedure();

		List<EserviceRoutingDetailsMod> routingDetails = (List<EserviceRoutingDetailsMod>) mapResult
				.get(KEY_DTL_CURSOR_DATA);
		form.setRoutingDetails(routingDetails);
	}

	public class RoutingDetailsRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			EserviceRoutingDetailsMod rdm = new EserviceRoutingDetailsMod();
			rdm.setSeqNo(rs.getInt(1));
			rdm.setFrom(rs.getString(3));
			rdm.setTo(rs.getString(5));
			rdm.setLoadingTerminalName(rs.getString(7));
			rdm.setDischargingTerminalName(rs.getString(9));
			rdm.setEtd(rs.getString(10));
			rdm.setEta(rs.getString(11));
			rdm.setTransitTime(rs.getString(12));
			rdm.setService(rs.getString(13));
			rdm.setVessel(rs.getString(14));
			rdm.setVoyage(rs.getString(15));

			return rdm;
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

	@Override
	public int checkBookingNoAndStatus(Map amap) {
		int Count = 0;
		String BookingNo = (String) amap.get(KEY_BOOKING_NO);
		String BookingStatus = (String) amap.get(KEY_BOOKING_STATUS);
		String query_B_S_C = "SELECT COUNT(*) FROM SEALINER.BKP001 WHERE BABKNO = '" + BookingNo + "' or BKFERN = '"+BookingNo+"'";
		if (BookingStatus != null && !BookingStatus.equals("")) {
			String status = "";

			if (BookingStatus.equals("Open")) {
				status = "O";
			}
			query_B_S_C = query_B_S_C + "AND BASTAT='" + status + "'";
		}

		Count = getJdbcTemplate().queryForInt(query_B_S_C);

		return Count;
	}
	
	public Map getListWebBookingNew(Map amap) throws BusinessException, 
	DataAccessException {

		System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][Begin]");

		List<EserviceInquieyHeaderMod>    list            = null;
		String                          findText        = null;
		String                          column          = null;
		String                          sortby          = null;
		String                          order           = null;
		String                          status          = null;
		String                          wildcard        = null;
		Integer                         fromRecord      = null;
		Integer                         toRecord        = null;
		String                          userId          = null;
		int                             rows            = 0;
		String                          sql             = null;
		PagingUtil                      pu              = null;
		SqlRowSet                       r               = null;
		String                          bookingDate     = null;
		EserviceInquieyHeaderMod          blm             = null;
		StringBuffer                    sqlStmtCount    = new StringBuffer("");
		StringBuffer                    sqlStmtFSC      = new StringBuffer("");
		String                          controlFSC      = null;
		String                          userFSC         = null;
		StringBuffer                    sqlCondition    = new StringBuffer("");
		String 							org_code		= "";

		//@01 @03 BEGIN
		StringBuffer                    sqlStatement    =  new StringBuffer("");
		//@01 @03 END

		try{
			findText        = (String)amap.get(KEY_CRITERIA_TEXT_FIND);
			column          = (String)amap.get(KEY_CRITERIA_COLUMN);
			sortby          = (String)amap.get(KEY_CRITERIA_SORTBY);
			order           = (String)amap.get(KEY_CRITERIA_ORDER);
			status          = (String)amap.get(KEY_CRITERIA_STATUS);
			wildcard        = (String)amap.get(KEY_CRITERIA_WILDCARD);
			fromRecord      = (Integer)amap.get(KEY_FROM_RECORD);
			toRecord        = (Integer)amap.get(KEY_TO_RECORD);
			userId          = (String)amap.get(KEY_USER_ID);
			org_code		= (String)amap.get("ORG_CODE");
			if(null!=status  && !"".equals(status)){
				
				if ("Open".equals(status)) {
					status = "O";
				} else if ("Confirmed".equals(status)) {
					status = "C";
				} else if ("Cancelled".equals(status)) {
					status = "N";
				} 
				
			sqlCondition.append(" and BASTAT = '"+status+"' and BASTAT <> 'E' ");
			}if(status==null || status.equals(""))
			{
				sqlCondition.append(" and BASTAT = 'O' and BASTAT <> 'E' ");
			}
			
			if(userId.equalsIgnoreCase("DEV_TEAM")) {
				sqlCondition.append("   ");
			}else {
				sqlCondition.append(" and (BAAUSR =   '"+userId+"' or  BABKBY='"+org_code+"')");
			}
			
			
			
			sqlStatement.append("   select");  
			sqlStatement.append("        BABKNO as BOOKING_NO");
			//sqlStatement.append("       ,DECODE(BOOKING_TYPE,'N','NORMAL','ER','EMPTY REPO','TB','TEMPLATE','MB','MASTER','SP','SPONSORSHIP','FC','FEEDER CARGO') as BOOKING_TYPE");
			sqlStatement.append(" 		,BKFERN as BOOKINGREFERENCENO");
			//sqlStatement.append("      ,rutdtl.SAILING_DATE as ETD ");
			sqlStatement.append("       ,BAPOL AS POL_NAME");
            sqlStatement.append(" 		,BAPOD AS POD_NAME");
            sqlStatement.append("       ,(SELECT PINAME FROM ITP040 WHERE PICODE=BAPOL) AS POL_DES");
            sqlStatement.append(" 		,(SELECT PINAME FROM ITP040 WHERE PICODE=BAPOD) AS POD_DES");
            sqlStatement.append(" 		,TO_CHAR(TO_DATE(cast(B.VESSELETD as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') as VESSELETD");
			sqlStatement.append("       ,TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') AS EXPECTED_SAILING_DATE");
            sqlStatement.append("       ,TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') AS DESIRED_ARRIVAL_DATE");
			sqlStatement.append("       ,(CASE when BASTAT ='O' then 'Open' when BASTAT = 'C' then 'Confirmed'"
					+ "  when BASTAT = 'N' then 'Cancelled' END) as Status,");
			sqlStatement.append("		COALESCE (splstats, ' ' , splstats) as BOOKINGSPLFLAG,");
			sqlStatement.append("		COALESCE (esi.SPECIAL_STATUS,'',esi.SPECIAL_STATUS) as SHIPPINGSPLFLAG");
			
			sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_CONFRIM_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as COMFIRMDATE");
			sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_RECEIVED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as RECEIVEDDATE");
			sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_LOADED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as LOADEDDATE");
			sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_ONBOARD_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as ONBOARDDATE");
			sqlStatement.append(" from BKP001 B");
			sqlStatement.append(" LEFT OUTER JOIN  ESV_WB_EXTEND  ON BABKNO=PK_BOOKING_NO");
			sqlStatement.append(" LEFT OUTER JOIN  ESV_SI_HEADER ESI ON FK_BOOKING_NO=PK_BOOKING_NO");
			sqlStatement.append(" where created_thru_Web = 'Y' and booking_Type <> 'TB' and booking_type <> 'NA' "+sqlCondition);            
			sqlStatement.append(" order by BABKDT desc limit 10");

			sql     = sqlStatement.toString();

			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] sql : " + sql);

			SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());

			
			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] Row(s) All : " + rows);

			list = new ArrayList<EserviceInquieyHeaderMod>();

			
			while (rs.next()) {
				blm         = new EserviceInquieyHeaderMod();
				//bookingDate = rs.getString("Booking_Date");

				//blm.setBookingDate  (null!=bookingDate?bookingDate.substring(6,8)+"/"+bookingDate.substring(4,6)+"/"+bookingDate.substring(0,4):bookingDate);
				String booking_no="";
				if(!rs.getString("BOOKING_NO").equals(rs.getString("BOOKINGREFERENCENO"))) {
					booking_no=rs.getString("BOOKING_NO");
				}else {
					try {
						String tempBookingNo="select x_booking_no from SEALINER.BKP001 a  where babkno = '"+rs.getString("BOOKING_NO")+"' limit 1";
						booking_no=(String) getJdbcTemplate().queryForObject(tempBookingNo, Object.class);
						if(booking_no==null || booking_no.equals("")) {
							booking_no="-";
						}
					}catch (Exception e) {
						booking_no="-";
					}
				}
				blm.setBookingNo(booking_no);
				String repCompNameQuery ="select  a.CUNAME  from BKP001 T, ITP010 a where BABKNO = '"+rs.getString("BOOKING_NO")+"'"+ 
						" and a.CUCUST  = t.BABKBY"; 
				System.out.println(repCompNameQuery);
				//blm.setCocSoc       (rs.getString("COC_SOC"));
				//blm.setBookingType  (rs.getString("BOOKING_TYPE"));
				blm.setPortOfDischarge(rs.getString("POD_NAME"));
				blm.setPortOfLoading(rs.getString("POL_NAME"));
				blm.setPodNameDes(rs.getString("POD_DES"));
				blm.setPolNameDes(rs.getString("POL_DES"));
				blm.setVesselEtd(rs.getString("VESSELETD"));
				blm.setSailingDate(rs.getString("EXPECTED_SAILING_DATE"));
				blm.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
				//blm.setEtd(rs.getString("ETD"));
				blm.setStatus(rs.getString("Status"));
				blm.setBookingReferenceNo(rs.getString("BOOKINGREFERENCENO"));
				blm.setBookingSplFlag(rs.getString("BOOKINGSPLFLAG"));
				blm.setShippingSplFalg(rs.getString("SHIPPINGSPLFLAG"));
				blm.setRepCompName((String)getJdbcTemplate().queryForObject(repCompNameQuery, Object.class));
				blm.setConfirmDate(rs.getString("COMFIRMDATE"));
				blm.setResivedDate(rs.getString("RECEIVEDDATE"));
				blm.setLoadedDate(rs.getString("LOADEDDATE"));
				blm.setOnBoardDate(rs.getString("ONBOARDDATE"));
				
				
				list.add(blm);
			}

			if(list.size()>0) {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, null);
			}else {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, "No record..");
			}
			amap.put(KEY_SIZE, rows);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][End]");
		}

		return amap;        
	}

	@Override
	public Map getBookingDtlsNew(Map amap) throws BusinessException, 
	DataAccessException {

		System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][Begin]");

		
		List<EserviceInquieyHeaderMod>    list            = null;
		String                          findText        = null;
		String                          column          = null;
		String                          sortby          = null;
		String                          order           = null;
		String                          status          = null;
		String                          wildcard        = null;
		Integer                         fromRecord      = null;
		Integer                         toRecord        = null;
		String                          userId          = null;
		int                             rows            = 0;
		String                          sql             = null;
		PagingUtil                      pu              = null;
		SqlRowSet                       r               = null;
		String                          bookingDate     = null;
		EserviceInquieyHeaderMod          blm             = null;
		StringBuffer                    sqlStmtCount    = new StringBuffer("");
		StringBuffer                    sqlStmtFSC      = new StringBuffer("");
		String                          controlFSC      = null;
		String                          userFSC         = null;
		StringBuffer                    sqlCondition    = new StringBuffer("");
		String 							bookingNo       = null;
		String 							bookingRef		= null;
		//@01 @03 BEGIN
		StringBuffer                    sqlStatement    =  new StringBuffer("");
		//@01 @03 END

		try{
			findText        = (String)amap.get(KEY_CRITERIA_TEXT_FIND);
			column          = (String)amap.get(KEY_CRITERIA_COLUMN);
			sortby          = (String)amap.get(KEY_CRITERIA_SORTBY);
			order           = (String)amap.get(KEY_CRITERIA_ORDER);
			status          = (String)amap.get(KEY_CRITERIA_STATUS);
			wildcard        = (String)amap.get(KEY_CRITERIA_WILDCARD);
			fromRecord      = (Integer)amap.get(KEY_FROM_RECORD);
			toRecord        = (Integer)amap.get(KEY_TO_RECORD);
			userId          = (String)amap.get(KEY_USER_ID);
			bookingNo		= (String)amap.get(KEY_BOOKING_NO);
			bookingRef		= (String)amap.get(KEY_BOOKING_REF);
			String org_code		= (String)amap.get("ORG_CODE"); 
			if(!bookingNo.equals("")) {
				sqlCondition.append(" and BABKNO ='"+bookingNo+"' ");
			}
			if(bookingRef!=null && !bookingRef.equals("")) {
				sqlCondition.append(" and BKFERN ='"+bookingRef+"' ");
			}
			if(userId.equalsIgnoreCase("DEV_TEAM")) {
				sqlCondition.append(" ");
			}else {
				sqlCondition.append(" and (BAAUSR =   '"+userId+"' or  BABKBY='"+org_code+"')");
			}
			
			sqlStatement.append("   select"); 
			sqlStatement.append("   BABKDT as Booking_Date ,");      
						sqlStatement.append("        BABKNO as BOOKING_NO");
						sqlStatement.append(" 		,BKFERN as BOOKINGREFERENCENO");
						sqlStatement.append("       ,BAPOL AS POL_NAME");
			            sqlStatement.append(" 		,BAPOD AS POD_NAME");
			            sqlStatement.append("       ,(SELECT PINAME FROM ITP040 WHERE PICODE=BAPOL) AS POL_DES");
			            sqlStatement.append(" 		,(SELECT PINAME FROM ITP040 WHERE PICODE=BAPOD) AS POD_DES");
			            sqlStatement.append(" 		,TO_CHAR(TO_DATE(cast(B.VESSELETD as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') as VESSELETD");
						sqlStatement.append("       ,TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') AS EXPECTED_SAILING_DATE");
			            sqlStatement.append("       ,TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') AS DESIRED_ARRIVAL_DATE");
			            sqlStatement.append("       ,(CASE when BASTAT ='O' then 'Open' when BASTAT = 'C' then 'Confirmed'"
								+ "  when BASTAT = 'N' then 'Cancelled' END) as Status");
			            sqlStatement.append("		,splstats as BOOKINGSPLFLAG");
						sqlStatement.append("		,esi.SPECIAL_STATUS as SHIPPINGSPLFLAG");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_CONFRIM_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as COMFIRMDATE");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_RECEIVED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as RECEIVEDDATE");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_LOADED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as LOADEDDATE");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_ONBOARD_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as ONBOARDDATE");
			            sqlStatement.append(" from BKP001 B");
						sqlStatement.append(" LEFT OUTER JOIN  ESV_WB_EXTEND  ON BABKNO=PK_BOOKING_NO");
						sqlStatement.append(" LEFT OUTER JOIN  ESV_SI_HEADER ESI ON FK_BOOKING_NO=PK_BOOKING_NO");
						sqlStatement.append(" where created_thru_Web = 'Y' and booking_Type <> 'TB' and booking_type <> 'NA' "+sqlCondition);            
						sqlStatement.append("  ");
						sqlStatement.append(" order by BABKDT desc limit 10");

			sql     = sqlStatement.toString();

			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] sql : " + sql);

			SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());

			
			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] Row(s) All : " + rows);

			list = new ArrayList<EserviceInquieyHeaderMod>();

			while (rs.next()) {
				blm         = new EserviceInquieyHeaderMod();
				//bookingDate = rs.getString("Booking_Date");
				
				//blm.setBookingDate  (null!=bookingDate?bookingDate.substring(6,8)+"/"+bookingDate.substring(4,6)+"/"+bookingDate.substring(0,4):bookingDate);
				String booking_no="";
				if(!rs.getString("BOOKING_NO").equals(rs.getString("BOOKINGREFERENCENO"))) {
					booking_no=rs.getString("BOOKING_NO");
				}else {
					try {
						String tempBookingNo="select x_booking_no from SEALINER.BKP001 a  where babkno = '"+rs.getString("BOOKING_NO")+"' limit 1";
						booking_no=(String) getJdbcTemplate().queryForObject(tempBookingNo, Object.class);
						if(booking_no==null || booking_no.equals("")) {
							booking_no="-";
						}
					}catch (Exception e) {
						booking_no="-";
					}
				}
				blm.setBookingNo(booking_no);
				String repCompNameQuery ="select  a.CUNAME  from BKP001 T, ITP010 a where BABKNO = '"+rs.getString("BOOKING_NO")+"'"+ 
						" and a.CUCUST  = t.BABKBY"; 
				//blm.setCocSoc       (rs.getString("COC_SOC"));
				//blm.setBookingType  (rs.getString("BOOKING_TYPE"));
				blm.setPortOfDischarge(rs.getString("POD_NAME"));
				blm.setPortOfLoading(rs.getString("POL_NAME"));
				blm.setPodNameDes(rs.getString("POD_DES"));
				blm.setPolNameDes(rs.getString("POL_DES"));
				blm.setVesselEtd(rs.getString("VESSELETD"));
				blm.setSailingDate(rs.getString("EXPECTED_SAILING_DATE"));
				blm.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
				//blm.setEtd(rs.getString("ETD"));
				blm.setStatus(rs.getString("Status"));
				blm.setBookingReferenceNo(rs.getString("BOOKINGREFERENCENO"));
				blm.setBookingSplFlag(rs.getString("BOOKINGSPLFLAG"));
				blm.setShippingSplFalg(rs.getString("SHIPPINGSPLFLAG"));
				blm.setRepCompName((String)getJdbcTemplate().queryForObject(repCompNameQuery, Object.class));
				blm.setConfirmDate(rs.getString("COMFIRMDATE"));
				blm.setResivedDate(rs.getString("RECEIVEDDATE"));
				blm.setLoadedDate(rs.getString("LOADEDDATE"));
				blm.setOnBoardDate(rs.getString("ONBOARDDATE"));
				
				list.add(blm);
			}

			if(list.size()>0) {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, null);
			}else {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, "No record..");
			}
			amap.put(KEY_SIZE, rows);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][End]");
		}

		return amap;        
	}
	
	@Override
	public Map getBookingDtlsBtn(Map amap,EserviceInquiryWebBookingUim  	formObj ) throws BusinessException, DataAccessException {
	System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][Begin]");

		
		List<EserviceInquieyHeaderMod>    list            = null;
		String                          findText        = null;
		String                          column          = null;
		String                          sortby          = null;
		String                          order           = null;
		String                          status          = null;
		String                          wildcard        = null;
		Integer                         fromRecord      = null;
		Integer                         toRecord        = null;
		String                          userId          = null;
		int                             rows            = 0;
		String                          sql             = null;
		PagingUtil                      pu              = null;
		SqlRowSet                       r               = null;
		String                          bookingDate     = null;
		EserviceInquieyHeaderMod          blm             = null;
		StringBuffer                    sqlStmtCount    = new StringBuffer("");
		StringBuffer                    sqlStmtFSC      = new StringBuffer("");
		String                          controlFSC      = null;
		String                          userFSC         = null;
		StringBuffer                    sqlCondition    = new StringBuffer("");
		String 							bookingNo       = null;
		String 							bookingRef		= null;
		//@01 @03 BEGIN
		StringBuffer                    sqlStatement    =  new StringBuffer("");
		String 							org_code		="";
		String							bookingTemp     =  null;
		//@01 @03 END

		try{
			findText        = (String)amap.get(KEY_CRITERIA_TEXT_FIND);
			column          = (String)amap.get(KEY_CRITERIA_COLUMN);
			sortby          = (String)amap.get(KEY_CRITERIA_SORTBY);
			order           = (String)amap.get(KEY_CRITERIA_ORDER);
			status          = (String)amap.get(KEY_CRITERIA_STATUS);
			wildcard        = (String)amap.get(KEY_CRITERIA_WILDCARD);
			fromRecord      = (Integer)amap.get(KEY_FROM_RECORD);
			toRecord        = (Integer)amap.get(KEY_TO_RECORD);
			userId          = (String)amap.get(KEY_USER_ID);
			bookingNo		= (String)amap.get(KEY_BOOKING_NO);
			bookingRef		= (String)amap.get(KEY_BOOKING_REF);
			org_code		= (String)amap.get("ORG_CODE"); 
			
			
			
			
			  if(bookingRef!=null && !bookingRef.equals("")) {
				  String CHECK_REJECTED = "SELECT count(*) FROM BKP001 WHERE BABKNO='"+bookingRef+"' AND BASTAT='R'";
				  int checkRejected= getJdbcTemplate().queryForInt(CHECK_REJECTED);
				  if(checkRejected>0) {
				  amap.put(KYE_ERROR_CODE," This booking Ref was Rejected "+bookingRef);
				  return amap;
				  }
			  }
			  if(bookingNo!=null && !bookingNo.equals("")) {
					
				  String checkTmpAndBookingNo="select count(*) from BKP001 where BABKNO!=x_booking_no and x_booking_no='"+bookingNo+"'"; 
				  int count= getJdbcTemplate().queryForInt(checkTmpAndBookingNo);
				  if(count>0) {
					   try {
						bookingTemp=bookingNo;
						String query="select babkno from BKP001 where x_booking_no='"+bookingNo+"' limit 1";
						bookingNo = (String) getJdbcTemplate().queryForObject(query, Object.class);
					   }catch (Exception e) {
						bookingNo="";   
					}
				  }
					 			  
				  String checkSiBookingQuery="select count(*) from ESV_SI_HEADER where fk_booking_no='"+bookingNo+"' AND esi_status in ('C','S','E')";
				  int checkSi= getJdbcTemplate().queryForInt(checkSiBookingQuery);
				  if(checkSi>0) {
				  amap.put(KYE_ERROR_CODE," SI already created for this booking "+bookingNo);
				  return amap;
				  }
				  String checkBookingQuery="select count(*) from BKP001 where BABKNO='"+bookingNo+"'";
				  int checkBooking= getJdbcTemplate().queryForInt(checkBookingQuery);
				  if(checkBooking==0) {
					  amap.put(KYE_ERROR_CODE,"Booking No Doesn't Exist.."); 
					  return amap;
				  }
				  if(bookingTemp==null) {
				      String checkStatusQuery="select BASTAT from BKP001 where BABKNO='"+bookingNo+"'";
					  String checkStatus=(String) getJdbcTemplate().queryForObject(checkStatusQuery, Object.class);
						  if(checkStatus.equals("O")) { 
						  amap.put(KYE_ERROR_CODE,"Booking No Doesn't Exist.."); 
						  return amap; 
						  }
				  }	  
			  }
			  
			 
			if(null!=status  && !"".equals(status)){
				if ("Open".equals(status)) {
					status = "O";
				} else if ("Confirmed".equals(status)) {
					status = "C";
				} else if ("Cancelled".equals(status)) {
					status = "N";
				} 
				
				sqlCondition.append(" and BASTAT = '"+status+"' and BASTAT <> 'E' ");
			}if((status==null || status.equals("") ) && bookingRef==null && bookingNo==null)
			{
				sqlCondition.append(" and (BASTAT = 'O' or BASTAT = 'C')  and BASTAT <> 'E'  ");
			}
			if(!bookingNo.equals("")) {
				sqlCondition.append(" and BABKNO ='"+bookingNo+"' ");
			}
			if(bookingRef!=null && !bookingRef.equals("")) {
				sqlCondition.append(" and BKFERN ='"+bookingRef+"' ");
			}
			if(userId.equalsIgnoreCase("DEV_TEAM")) {
				sqlCondition.append(" ");
			}else {
				sqlCondition.append(" and (BAAUSR =   '"+userId+"' or  BABKBY='"+org_code+"')");
			}
			
			sqlStatement.append("   select"); 
			sqlStatement.append("   BABKDT as Booking_Date ,");      
						sqlStatement.append("        BABKNO as BOOKING_NO");
						sqlStatement.append(" 		,BKFERN as BOOKINGREFERENCENO");
						sqlStatement.append("       ,BAPOL AS POL_NAME");
			            sqlStatement.append(" 		,BAPOD AS POD_NAME");
			            
			            sqlStatement.append("       ,(SELECT PINAME FROM ITP040 WHERE PICODE=BAPOL) AS POL_DES");
			            sqlStatement.append(" 		,(SELECT PINAME FROM ITP040 WHERE PICODE=BAPOD) AS POD_DES");
			            sqlStatement.append(" 		,TO_CHAR(TO_DATE(cast(B.VESSELETD as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') as VESSELETD");
						sqlStatement.append("       ,TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') AS EXPECTED_SAILING_DATE");
			            sqlStatement.append("       ,TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') AS DESIRED_ARRIVAL_DATE");
			            sqlStatement.append("       ,(CASE when BASTAT ='O' then 'Open' when BASTAT = 'C' then 'Confirmed'"
								+ "  when BASTAT = 'N' then 'Cancelled' END) as Status");
			            sqlStatement.append("		,splstats as BOOKINGSPLFLAG");
						sqlStatement.append("		,esi.SPECIAL_STATUS as SHIPPINGSPLFLAG");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_CONFRIM_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as COMFIRMDATE");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_RECEIVED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as RECEIVEDDATE");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_LOADED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as LOADEDDATE");
						sqlStatement.append("		,TO_CHAR(TO_DATE(BKG_ONBOARD_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as ONBOARDDATE");
			            sqlStatement.append(" from BKP001 B");
						sqlStatement.append(" LEFT OUTER JOIN  ESV_WB_EXTEND  ON BABKNO=PK_BOOKING_NO");
						sqlStatement.append(" LEFT OUTER JOIN  ESV_SI_HEADER ESI ON FK_BOOKING_NO=PK_BOOKING_NO");
						sqlStatement.append(" where created_thru_Web = 'Y' and booking_Type <> 'TB' and booking_type <> 'NA' "+sqlCondition);            
						sqlStatement.append("  ");
						sqlStatement.append(" order by BABKDT desc limit 10");

			sql     = sqlStatement.toString();

			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] sql : " + sql);

			SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());

			
			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking] Row(s) All : " + rows);

			list = new ArrayList<EserviceInquieyHeaderMod>();

			while (rs.next()) {
				blm         = new EserviceInquieyHeaderMod();
				//bookingDate = rs.getString("Booking_Date");

				//blm.setBookingDate  (null!=bookingDate?bookingDate.substring(6,8)+"/"+bookingDate.substring(4,6)+"/"+bookingDate.substring(0,4):bookingDate);
				String booking_no="";
				if(!rs.getString("BOOKING_NO").equals(rs.getString("BOOKINGREFERENCENO"))) {
					booking_no=rs.getString("BOOKING_NO");
				}else {
					try {
						String tempBookingNo="select x_booking_no from SEALINER.BKP001 a  where babkno = '"+rs.getString("BOOKING_NO")+"' limit 1";
						booking_no=(String) getJdbcTemplate().queryForObject(tempBookingNo, Object.class);
						if(booking_no==null || booking_no.equals("")) {
							booking_no="-";
						}
					}catch (Exception e) {
						booking_no="-";
					}
				}
				blm.setBookingNo(booking_no);
				String repCompNameQuery ="select  a.CUNAME  from BKP001 T, ITP010 a where BABKNO = '"+rs.getString("BOOKING_NO")+"'"+ 
						" and a.CUCUST  = t.BABKBY"; 
				//blm.setCocSoc       (rs.getString("COC_SOC"));
				//blm.setBookingType  (rs.getString("BOOKING_TYPE"));
				blm.setPortOfDischarge(rs.getString("POD_NAME"));
				blm.setPortOfLoading(rs.getString("POL_NAME"));
				blm.setPodNameDes(rs.getString("POD_DES"));
				blm.setPolNameDes(rs.getString("POL_DES"));
				blm.setVesselEtd(rs.getString("VESSELETD"));
				blm.setSailingDate(rs.getString("EXPECTED_SAILING_DATE"));
				blm.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
				//blm.setEtd(rs.getString("ETD"));
				blm.setStatus(rs.getString("Status"));
				if(null!=rs.getString("Status") && !rs.getString("Status").equals("")  ) {
					
					 formObj.setStatus(rs.getString("Status"));
					
				}
				blm.setBookingReferenceNo(rs.getString("BOOKINGREFERENCENO"));
				blm.setBookingSplFlag(rs.getString("BOOKINGSPLFLAG"));
				blm.setShippingSplFalg(rs.getString("SHIPPINGSPLFLAG"));
				blm.setRepCompName((String)getJdbcTemplate().queryForObject(repCompNameQuery, Object.class));
				blm.setConfirmDate(rs.getString("COMFIRMDATE"));
				blm.setResivedDate(rs.getString("RECEIVEDDATE"));
				blm.setLoadedDate(rs.getString("LOADEDDATE"));
				blm.setOnBoardDate(rs.getString("ONBOARDDATE"));
				
				list.add(blm);
			}
			if(list.size()>0) {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, null);
			}else {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, "No record found..");
			}
			
			amap.put(KEY_SIZE, rows);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("[EserviceInquiryWebBookingSvc][getListWebBooking][End]");
		}

		return amap;     
	}

	
	@Override 
	public void getCustomerDtls(Map param,EserviceInquiryWebBookingUim objForm) throws BusinessException, DataAccessException {
		
		System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader][Begin]");

		JdbcStoredProcedure objSP = null;
		Map mapResult = null;
		String[][] arrParam = null;

		System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader] (String)amap.get(KEY_USER_ID) >>>>>>"
				+ (String) param.get(KEY_USER_ID));
		EserviceInquiryCustomerDtlMod customerDtlMod = new EserviceInquiryCustomerDtlMod();
		String bkg_no=(String) param.get(KEY_BOOKING_NO);
		try {
			
			String V_SQL="SELECT S.BNNAME AS NAME   " + 
					"                          ,S.BNADD1 AS ADR1   " + 
					"                          ,S.BNADD2 AS ADR2   " + 
					"                          ,S.BNADD3 AS ADR3   " + 
					"                          ,S.BNADD4 AS ADR4   " + 
					"                          ,'S' AS FLAG   " + 
					"						  ,S.BNCSCD AS SHIPPER_CODE   " + 
					"                    FROM BKP030 S   " + 
					"                    WHERE S.BNBKNO =  '"+bkg_no+"'    " + 
					"                          AND S.BNCSTP = 'S'   " + 
					"                    UNION   " + 
					"                    SELECT C.BNNAME AS NAME   " + 
					"                          ,C.BNADD1 AS ADR1   " + 
					"                          ,C.BNADD2 AS ADR2   " + 
					"                          ,C.BNADD3 AS ADR3   " + 
					"                          ,C.BNADD4 AS ADR4   " + 
					"                          ,'C' AS FLAG   " + 
					"						  ,C.BNCSCD AS CNEE_CODE   " + 
					"                    FROM BKP030 C   " + 
					"                    WHERE C.BNBKNO =  '"+bkg_no+"'    " +
					"                          AND C.BNCSTP = 'C'   " + 
					"                    UNION   " + 
					"                    SELECT N.BNNAME AS NAME   " + 
					"                          ,N.BNADD1 AS ADR1   " + 
					"                          ,N.BNADD2 AS ADR2   " + 
					"                          ,N.BNADD3 AS ADR3   " + 
					"                          ,N.BNADD4 AS ADR4   " + 
					"                          ,'N' AS FLAG   " + 
					"						  ,N.BNCSCD AS NTFY_CODE   " + 
					"                    FROM BKP030 N   " + 
					"                    WHERE N.BNBKNO = '"+bkg_no+"'    " +
					"                          AND N.BNCSTP = 'N' ";
			
			getJdbcTemplate().query(V_SQL, new Object[] {}, new ContactDetailsRowMappers(customerDtlMod) );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader][End]");
		}
		objForm.setCustomerDtls(customerDtlMod);
	}

	
	public class ContactDetailsRowMappers extends JdbcRowMapper{

	    private EserviceInquiryCustomerDtlMod form;

	    /**
	     * 
	     * This constructor for set obj to global variable.
	     * 
	     * @param form Object's Eshipping Instruction Form
	     */
	    public ContactDetailsRowMappers(EserviceInquiryCustomerDtlMod form){
	        this.form = form;
	    }

	    /**
	     * 
	     * This mothod for set data to contact detail in each row.
	     * 
	     * @exception SQLException
	     * @param rs List of contact detail
	     * @param row Row of contact detail
	     */
	    public Object mapRow(ResultSet rs, int row) throws SQLException{
	        if(EshippingInstructionDao.KEY_FLAG_SHIPPER.equals(rs.getString(6))){
	            //            System.out.println("KEY_FLAG_SHIPPER   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	            form.setShipperName(rs.getString(1));
	            form.setShipperAddress1(rs.getString(2));
	            form.setShipperAddress2(rs.getString(3));
	            form.setShipperAddress3(rs.getString(4));
	            form.setShipperAddress4(rs.getString(5));
	            form.setShipperCode(rs.getString(7));
	        } else if(EshippingInstructionDao.KEY_FLAG_CONSIGNEE.equals(rs.getString(6))){
	            //                System.out.println("KEY_FLAG_CONSIGNEE     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	            form.setConsigneeName(rs.getString(1));
	            form.setConsigneeAddress1(rs.getString(2));
	            form.setConsigneeAddress2(rs.getString(3));
	            form.setConsigneeAddress3(rs.getString(4));
	            form.setConsigneeAddress4(rs.getString(5));
	            form.setConsigneeCode(rs.getString(7));
	        } else if(EshippingInstructionDao.KEY_FLAG_NOTIFY_PART.equals(rs.getString(6))){
	            //                System.out.println("KEY_FLAG_NOTIFY_PART    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	            form.setNotifyName(rs.getString(1));
	            form.setNotifyAddress1(rs.getString(2));
	            form.setNotifyAddress2(rs.getString(3));
	            form.setNotifyAddress3(rs.getString(4));
	            form.setNotifyAddress4(rs.getString(5));
	            form.setNotifyCode(rs.getString(7));
	        }
	        return null;
	    }
	}
	
	@Override
	public void setBookingHeaderNew(Map mapParams, EserviceInquiryWebBookingUim objForm)
			throws BusinessException, DataAccessException {
		
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;
		String[][] arrParam = null;

		System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader] (String)amap.get(KEY_USER_ID) >>>>>>"
				+ (String) mapParams.get(KEY_USER_ID));
		try {
			arrParam = new String[][] { { KEY_REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(KEY_BOOKING_NO) },
					{ KEY_P_USER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(KEY_USER_ID) } };

			//objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_BOOKING_HEADER, new BookingHeaderRowMapper(objForm),
			//		arrParam);
					mapResult=new HashMap();		
					mapResult.put("P_I_V_BKG_NO", (String) mapParams.get(KEY_BOOKING_NO));
					mapResult.put("P_I_V_USER_ID", (String) mapParams.get(KEY_USER_ID));
			PRR_ERCL_GET_BKG_HDR_INQUIRY procBkgHrd=new PRR_ERCL_GET_BKG_HDR_INQUIRY(getJdbcTemplate(),mapResult,objForm);
			procBkgHrd.executeDbProcedure();
			//mapResult = objSP.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingSvc][setBookingHeader][End]");
		}
		
	}

	@Override
	public void setRoutingDetailsNew(Map mapParams, EserviceInquiryWebBookingUim objForm)
			throws BusinessException, DataAccessException {
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;

		/*
		 * Prepare 2D Array of Parameters to be passed to SP 1. Param Name 2. Oracle
		 * Data Type 3. Param Type(In/Out/InOut) 4. Param Value(for In/InOut types)
		 */
		String[][] arrParam = { { KEY_DTL_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(KEY_BOOKING_NO) } };

		//objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_ROUNTING_DETAILS, new RoutingDetailsRowMapper(),
		//		arrParam);
		//mapResult = objSP.execute();
		mapResult=new HashMap();
		mapResult.put("P_I_V_BKG_NO", (String) mapParams.get(KEY_BOOKING_NO));
		PRR_ERCL_GET_BKG_ROUTING procRouting=new PRR_ERCL_GET_BKG_ROUTING(getJdbcTemplate(),mapResult);
		mapResult=procRouting.executeDbProcedure();
		
		List<EserviceRoutingDetailsMod> routingDetails = (List<EserviceRoutingDetailsMod>) mapResult
				.get(KEY_DTL_CURSOR_DATA);
		objForm.setRoutingDetails(routingDetails);
		
	}

	@Override
	public void setEquipmentDetailsNew(Map mapParams, EserviceInquiryWebBookingUim objForm)
			throws BusinessException, DataAccessException {
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;

		/*
		 * Prepare 2D Array of Parameters to be passed to SP 1. Param Name 2. Oracle
		 * Data Type 3. Param Type(In/Out/InOut) 4. Param Value(for In/InOut types)
		 */
		String[][] arrParam = { { KEY_DTL_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
				{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(KEY_BOOKING_NO) } };

		//objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_EQUIPMENT_DETAILS,
		//		new EquipementDetailsRowMapper(objForm), arrParam);
		//mapResult = objSP.execute();
		
		mapResult=new HashMap();
		mapResult.put("P_I_V_BKG_NO", (String) mapParams.get(KEY_BOOKING_NO));
		PRR_ERCL_GET_BKG_SIZE_TYPE procEqDtl=new PRR_ERCL_GET_BKG_SIZE_TYPE(getJdbcTemplate(),mapResult);
        procEqDtl.executeDbProcedure();
        mapResult=(Map) mapResult.get("KEY_PROCE_EXCECTION_RESULT_MAP");
        
		List<EserviceEquipmentDetailsMod> equipmentDetails = (List<EserviceEquipmentDetailsMod>) mapResult
				.get(KEY_DTL_CURSOR_DATA);
		objForm.setEquipmentDetails(equipmentDetails);
		
	}

	@Override
	public void setCommodityDetailsNew(Map mapParams, EserviceInquiryWebBookingUim objForm){
		
		JdbcStoredProcedure objSP = null;
		Map mapResult = null;
		List<EserviceCommodityDetailsMod> commodityDetails = null;
		EserviceCommodityDetailsMod mod = null;
		Hashtable rateType = null;
		String rateTypeCode = null;
		String rateTypeDesc = null;

		try {
			String[][] arrParam = { { KEY_DTL_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ KEY_BOOKING_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(KEY_BOOKING_NO) } };

			//objSP = new JdbcStoredProcedure(getDataSource(), SQL_GET_COMMODITY_DETAILS, new CommodityDetailsRowMapper(),
			//		arrParam);
			//mapResult = objSP.execute();
			mapResult=new HashMap();
			mapResult.put("P_I_V_BKG_NO", (String) mapParams.get(KEY_BOOKING_NO));
			PRR_ERCL_GET_BKG_COMMD procCommodity=new PRR_ERCL_GET_BKG_COMMD(getJdbcTemplate(),mapResult);
			procCommodity.executeDbProcedure();
			mapResult=(Map) mapResult.get("KEY_PROCE_EXCECTION_RESULT_MAP");
			
			commodityDetails = (List<EserviceCommodityDetailsMod>) mapResult.get(KEY_DTL_CURSOR_DATA);
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

			objForm.setCommodityDetails(commodityDetails);
			if (!commodityDetails.isEmpty()) {
				objForm.setFirstCheckedCommodity(commodityDetails.get(0).getSeqNo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EserviceInquiryWebBookingDaoImpl][setCommodityDetails][End]");
		}
		
	}

	

	@Override
	public Map getListOfTemplate(String id) {
			EserviceInquieyHeaderMod          blm             = null;
			StringBuffer sqlQueryForTemplate=new StringBuffer("");
			Map amap=new HashMap();
			List<EserviceInquieyHeaderMod> list=new ArrayList<EserviceInquieyHeaderMod>();
		
			sqlQueryForTemplate.append("SELECT BAPOL AS POL,"
					+ "BAPOD AS POD ,WEB_BOOK_REF as TEMPLATE ,'T' as Status,bkfern as BOOKIGREFNO from SEALINER.BKP001 where booking_type='TB' and BABKBY in( " + 
					"	select " + 
					"		ORG_CODE " + 
					"	from " + 
					"		SC_PRSN_LOG_INFO " + 
					"	where " + 
					"		PRSN_LOG_ID = '"+id+"' )");
		
			SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sqlQueryForTemplate.toString(), new HashMap());
			
			while(rs.next()) {
				blm=new EserviceInquieyHeaderMod();
				
				blm.setPortOfLoading(rs.getString("POL"));
				blm.setPortOfDischarge(rs.getString("POD"));
				blm.setTemplateName(rs.getString("TEMPLATE"));
				blm.setStatus(rs.getString("Status"));
				blm.setBookingReferenceNo(rs.getString("BOOKIGREFNO"));
				list.add(blm);
			}
			
			if(list.size()>0) {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, null);
			}else {
				amap.put(KEY_DATA, list);
				amap.put(KYE_ERROR_CODE, "No record..");
			}
			amap.put(KEY_SIZE, 0);
			
		return amap;
	}

	@Override
	public void deleteTemplate(EserviceInquiryWebBookingUim formObj) {

		String DELETE_TEMPLATE_QUERY="UPDATE SEALINER.BKP001 SET BOOKING_TYPE='NA' WHERE BABKNO='"+formObj.getBookingNo()+"'"
				+ " AND WEB_BOOK_REF='"+formObj.getTemplateName()+"'";
		
		getJdbcTemplate().update(DELETE_TEMPLATE_QUERY);
		
	}

	@Override
	public void setRoutingDtls(Map mapParams,EserviceInquiryWebBookingUim objForm ) {
		 
		String query="select vessel_name,vessel_no,voyage from route_dtl_booking where  booking_no='"+mapParams.get("p_i_v_bkg_no")+"'";
		
		List<RoutingDtldsVo> list= getJdbcTemplate().query(query, new RoutingDtlsRowMappers());
		
		objForm.setRoutingDtls(list);
	}
	
	public class RoutingDtlsRowMappers extends JdbcRowMapper{

		@Override
		public Object mapRow(ResultSet rs, int row) throws SQLException {
			
			RoutingDtldsVo obj=new RoutingDtldsVo(); 
			
			obj.setVesselName(rs.getString("vessel_name"));
			obj.setVesselNo(rs.getString("vessel_no"));
			obj.setVoyage(rs.getString("voyage"));
			
			return obj;
		}
	 
	}
	
	
}
