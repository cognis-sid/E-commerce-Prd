/*------------------------------------------------------
 EshippingInstructionDaoImpl.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Anurak Thanapradit 05/07/13
 - Change Log -------------------------------------------
 ## DD/MM/YY 	–User- 		-TaskRef- -ShortDescription-
 ## 31/07/2013   TANA     		01      add get commodity value
 ## 01/08/2013   TANA     		02      add param mode
 ## 20/08/2013   TANA     		03      add function getValueToConfigDate()
 ## 20/08/2013   TANA     		04      add shipper name
 ## 22/08/2013   TANA     		05      add function check double
 ## 23/08/2013   TANA     		06      add function get commodity group
 ## 27/08/2013   YOSSUN1  		07      change method for get commodity data
 ## 02/09/2013   YOSSUN1  		08      change commodity type in insert container
 ## 31/10/2013   YOSSUN1  		09      add esi submission process.
 ## 01/11/2013   YOSSUN1  		10      add weight for commodity.
 ## 21/11/2013   YOSSUN1  		11      add login id parameter for submit ESI.
 ## 12/12/2013   YOSSUN1  		12      add esiStatusCode.
 ## 26/12/2013   YOSSUN1  		13      renovate all.
 ## 20/01/2014   YOSSUN1  		14      cr commodity.
 ## 27/01/2014   YOSSUN1  		15      add insert commodity parameter.
 ## 10/09/2014   PRATYA   		16      PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
 ## 23/08/2019	 Sarawut A.		17		Add method validate data change
 ## 26/08/2019	 Sarawut A.	    18		Add method clear ESI data
 ## 18/10/2019	 Sarawut A.		19		Add fields vessel no, pol no, pod no for save method
 ------------------------------------------------------*/

package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.niit.control.common.ComboVO;
import com.niit.control.common.Debug;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIConstants;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.BlRevenueMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.BookingConatineVo;
import com.rclgroup.dolphin.rcl.web.eservice.vo.CustomerMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingBookingListMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCargoDescriptionMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingInquiryHeaderMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingPackageTypeListMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.RoutingDtldsVo;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_ACK_POPUP;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_BOOKING_POPUP;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_CNTRTYPE_DDL;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_COMM_DETAILS;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_CONTACT_DTL;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_EQUIPMENT_DTL;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_ROUTING_DTL;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_SHIPMENT_DTL;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_INS_ESI_COMMODITY;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_INS_ESI_CONTAINERS;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_INS_ESI_SHIPMENT_HDR;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESI_VAL_DATA_CHANGE;

//===================================================================
//OLD VERSION
//===================================================================
public class EshippingInstructionDaoImpl extends AncestorJdbcDao implements EshippingInstructionDao{
	
    /**
     * 
     * This method for set data shipment detail.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @param form Object's Eshipping Instruction Form
     */
    public void setShipmentDetail(Map map, EshippingInstructionUim form) throws Exception{
        JdbcStoredProcedure objSP = null;
        
        Map mapResult = null;

        String[][] arrParam = null;
        try{
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            //            System.out.println("status : " + ((String)map.get(KEY_STATUS)));
            //            System.out.println("setShipmentDetail >>>>>>>>>>>>>>>>>>>> KEY_MODE : "+((String)map.get(P_I_V.MODE)));
            //            System.out.println("setShipmentDetail >>>>>>>>>>>>>>>>>>>> KEY_LOGIN_ID : "+((String)map.get(KEY_USER_ID)));
            //            System.out.println("setShipmentDetail >>>>>>>>>>>>>>>>>>>> KEY_BL_NO : "+(String)map.get(KEY_BL_NO));
            //            System.out.println("setShipmentDetail >>>>>>>>>>>>>>>>>>>> KEY_BKG_NO : "+(String)map.get(KEY_BKG_NO));
            //@02 BEGIN
                //@02 END  
                arrParam = new String[][]{ { P_O_V.REF_CURSOR_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.MODE, BLANK+ORACLE_VARCHAR, PARAM_IN, ((String) map.get(P_I_V.MODE)) }, 
                        { P_I_V.LOGIN_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, ((String) map.get(KEY_USER_ID)) }, 
                        { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.BL_NO) }, 
                        { P_I_V.BKG_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.BKG_NO) } };
            /*map.put(P_I_V.MODE, "2");*/
           // objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_SHIPMENT_DTL, new ShipmentDetailsRowMapper(form), arrParam);
           // mapResult = objSP.execute();
            mapResult=new HashMap();
            mapResult.put("P_I_V_LOGIN_ID", ((String) map.get(KEY_USER_ID)));
            mapResult.put("P_I_V_BKG_NO", (String) map.get(P_I_V.BKG_NO));
            PRR_ERCL_GET_ESI_SHIPMENT_DTL proc=new PRR_ERCL_GET_ESI_SHIPMENT_DTL(getJdbcTemplate(),mapResult,form)  ;
            mapResult=proc.executeDbProcedure();
        } catch(Exception ex){
            throw ex;
//            ex.printStackTrace();
        }
    }
    //@06 BEGIN

    public Map insertOrUpdateCommodityDetails(Map map) throws Exception{
        
        System.out.println("[EshippingInstructionDaoImpl][insertOrUpdateCommodityDetails][Begin]");
        
        JdbcStoredProcedure     objSP               = null;
        Map                     mapResult           = null;

        String[][]              arrParam            = null;

        String                  mode                = null;
        String                  bookingNo           = null;
        String                  loginId             = null;
        String                  dnCommodity         = null;
        String                  pkSeq               = null;
        Integer                 pkSeqInt            = null;
        //@10 BEGIN
        String                  weight              = null;
        //@10 END
        //@15 BEGIN
        String                  totPackage          = null;
        String                  totPackageKind      = null;
        String                  totMeasurement      = null;
        //@15 END
        /*Begin @16*/
        String                  marksAndNumbers     = null;
        String                  description         = null;
        /*End @16*/
        
        try{
            mode                = (String) map.get(P_I_V.MODE);
            bookingNo           = (String) map.get(P_I_V.BOOKING_NO);
            loginId             = (String) map.get(P_I_V.LOGIN_ID);
            dnCommodity         = (String) map.get(P_I_V.DN_COMMODITY);
            pkSeqInt            = (Integer) map.get(P_I_V.PK_SEQNO);
            marksAndNumbers     = (String) map.get(P_I_V.COMM_LVL_MARKS_NO);
            description         = (String) map.get(P_I_V.COMM_LVL_DESC);
            description			=  description.replaceAll("'", "\\\\'");
            marksAndNumbers		=  marksAndNumbers.replaceAll("'", "\\\\'");
            if(pkSeqInt==null || pkSeqInt.equals("")){
                pkSeq = "0";
            } else {
                pkSeq = String.valueOf(pkSeqInt);
            }
            //@10 BEGIN
            weight = (String) map.get(P_I_V.WEIGHT);
            if(weight==null||BLANK.equals(weight)){
                weight = "0.000";
            } else {
                if(weight.indexOf(",")>-1){
                    weight = weight.replaceAll(",", "");
                }
            }
            //@10 END
//            @15 BEGIN
            totPackageKind = (String) map.get(P_I_V.TOT_PACKAGE_KIND);
            totPackage = (String) map.get(P_I_V.TOT_PACKAGE);
            if(totPackage==null||BLANK.equals(totPackage)){
                totPackage = "0";
            } else {
                if(totPackage.indexOf(",")>-1){
                    totPackage = totPackage.replace(",", "");
                }
            }
            totMeasurement = (String) map.get(P_I_V.TOT_MEASUREMENT);
            if(totMeasurement==null||BLANK.equals(totMeasurement)){
                totMeasurement = "0.0000";
            } else {
                if(totMeasurement.indexOf(",")>-1){
                    totMeasurement = totMeasurement.replace(",", "");
                }
            }
//            @15 END
            Debug.logFramework("1.Mode = "                  + mode + 
                                "\n2.bookingNo = "          + bookingNo +
                                "\n3.loginId = "            + loginId + 
                                "\n4.dnCommodity = "        + dnCommodity+
                                "\n5.pkSeqInt = "           + pkSeqInt + 
                                "\n6.totPackage = "         + totPackage+
                                "\n7.packageKindCode = "    + totPackageKind + 
                                "\n8.weight = "             + weight +
                                "\n9.measurement = "        + totMeasurement + 
                                "\n10.marksAndNumbers = "   + marksAndNumbers + 
                                "\n11.description = "       + description);

			/*
			 * arrParam = new String[][]{ { P_I_V.MODE , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * mode }, { P_I_V.BOOKING_NO , BLANK+ORACLE_VARCHAR , PARAM_IN , bookingNo }, {
			 * P_I_V.LOGIN_ID , BLANK+ORACLE_VARCHAR , PARAM_IN , loginId }, {
			 * P_I_V.DN_COMMODITY , BLANK+ORACLE_VARCHAR , PARAM_IN , dnCommodity }, {
			 * P_I_V.PK_SEQNO , BLANK+ORACLE_NUMBER , PARAM_IN , pkSeq }, { P_O_V.ERR_CD ,
			 * BLANK+ORACLE_VARCHAR , PARAM_OUT , BLANK }, { P_O_V.ERR_DESC ,
			 * BLANK+ORACLE_VARCHAR , PARAM_OUT , BLANK }, { P_I_V.WEIGHT ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN , weight }, { P_I_V.TOT_PACKAGE ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN , totPackage }, { P_I_V.TOT_PACKAGE_KIND ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN , totPackageKind }, { P_I_V.TOT_MEASUREMENT ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN , totMeasurement }, { P_I_V.COMM_LVL_MARKS_NO
			 * , BLANK+ORACLE_VARCHAR , PARAM_IN , marksAndNumbers }, { P_I_V.COMM_LVL_DESC
			 * , BLANK+ORACLE_VARCHAR , PARAM_IN , description } };
			 */
            //objSP       = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_INS_ESI_COMMODITY, arrParam);
          //  mapResult   = objSP.execute();
            
            mapResult=new HashMap();
            mapResult.put("P_I_V_MODE", mode);
            mapResult.put("P_I_V_BOOKING_NO", bookingNo);
            mapResult.put("P_I_V_LOGIN_ID", loginId);
            mapResult.put("P_I_V_DN_COMMODITY",dnCommodity );
            mapResult.put("P_I_V_PK_SEQNO", pkSeq);
            mapResult.put("P_O_V_ERR_CD", BLANK);
            mapResult.put("P_O_V_ERR_DESC",   BLANK);
            mapResult.put("P_I_V_WEIGHT", weight);
            mapResult.put("P_I_V_TOT_PACKAGE", totPackage);
            mapResult.put("P_I_V_TOT_PACKAGE_KIND", totPackageKind);
            mapResult.put("P_I_V_TOT_MEASUREMENT", totMeasurement);
            mapResult.put("P_I_V_COMM_LVL_MARKS_NO", marksAndNumbers);
            mapResult.put("P_I_V_COMM_LVL_DESC", description);
            PRR_ERCL_INS_ESI_COMMODITY proc =new PRR_ERCL_INS_ESI_COMMODITY(getJdbcTemplate(),mapResult);
            proc.executeDbProcedure();
        } catch(Exception ex){
            ex.printStackTrace();
            if(mapResult==null){
                mapResult = new HashMap();
            }
            mapResult.put(P_O_V.ERR_DESC, ex.getMessage());
            throw ex;
        }finally{
            System.out.println("[EshippingInstructionDaoImpl][insertOrUpdateCommodityDetails][End]");
        }
        return mapResult;
    }
    //@06 END
    //    @09 BEGIN

    public void doESISubmission(String bookingNo){
        JdbcStoredProcedure objSP = null;

        String[][] arrParam = null;
        try{
            arrParam = new String[1][4];
            arrParam[0][0] = "p_bkg_no";
            arrParam[0][1] = BLANK+ORACLE_VARCHAR;
            arrParam[0][2] = PARAM_IN;
            arrParam[0][3] = bookingNo;

            objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_BL_NO, arrParam);
            objSP.execute();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public Map findContainerNoExist(Map map) throws BusinessException, DataAccessException{
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        String[][] arrParam = null;
        try{
            arrParam = new String[][]{ { P_I_V.CNTR, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                            (String) map.get(P_I_V.CNTR) }, 
                        { P_O_V.EXIST, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK } };

            objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ESI_CHECK_EXIST_CNTR, arrParam);
            mapResult = objSP.execute();
        } catch(DataAccessException ex){
            throw ex;
        }
        return mapResult;
    }
    //    @09 END    

    public class ShipmentDetailsRowMapper extends JdbcRowMapper{

        private EshippingInstructionUim form;

        /**
         * 
         * This constructor for set obj to global variable.
         * 
         * @param form Object's Eshipping Instruction Form
         */
        public ShipmentDetailsRowMapper(EshippingInstructionUim form){
            this.form = form;
        }

        /**
         * 
         * This mothod for set data to shipment detail in each row.
         * 
         * @exception SQLException
         * @param rs List of shipment detail
         * @param row Row of shipment detail
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            form.setBookingNo(rs.getString(1));
            form.setContact(rs.getString(2));
            form.setEmail(rs.getString(3));
            form.setTelephone(rs.getString(4));
            form.setFax(rs.getString(5));
            form.setSiSubmittedBy(rs.getString(6));
            form.setBlNumber(rs.getString(7));
            form.setBlType(rs.getString(9));
            form.setAdditionalEmail(rs.getString(10));
            form.setNoOfOriginal(rs.getString(11));
            form.setRemarks(rs.getString(12));
            form.setChoiceRad(rs.getString(13));
            //            @12 BEGIN
            //            form.setStatus(rs.getString(8));
            form.setEsiStatusDesc(rs.getString(8));
            form.setEsiStatusCode(rs.getString(14));
            //            @12 END
            //            System.out.println("form setChoiceRad >>>>>>>>>>>>>>>>>>> "+form.getChoiceRad());
            return null;
        }
    }

    /**
     * 
     * This mothod for clear contact detail data.
     * 
     * @exception SQLException
     * @param form Object's Eshipping Instruction Form
     */
    public void clearContactDetails(EshippingInstructionUim form){
        form.setShipperCode(null);
        form.setShipperName(null);
        form.setShipperAddress1(null);
        form.setShipperAddress2(null);
        form.setShipperAddress3(null);
        form.setShipperAddress4(null);

        form.setConsigneeCode(null);
        form.setConsigneeName(null);
        form.setConsigneeAddress1(null);
        form.setConsigneeAddress2(null);
        form.setConsigneeAddress3(null);
        form.setConsigneeAddress4(null);

        form.setNotifyPartyCode(null);
        form.setNotifyPartyName(null);
        form.setNotifyPartyAddress1(null);
        form.setNotifyPartyAddress2(null);
        form.setNotifyPartyAddress3(null);
        form.setNotifyPartyAddress4(null);
    }

    /**
     * 
     * This method for set data contact detail.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @param form Object's Eshipping Instruction Form
     * @return Value of parameters out from procedure 
     */
    public Map setContactDetail(Map map, EshippingInstructionUim form){
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        String[][] arrParam = null;
        try{
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.STATUS, BLANK+ORACLE_VARCHAR, PARAM_IN, ((String) map.get(P_I_V.STATUS)) }, 
                        { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.BL_NO) }, 
                        { P_I_V.BKG_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.BKG_NO) }, 
                        { P_O_V.CREATED_FLAG, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK } };
            //            System.out.println("setContactDetail KEY_STATUS >>>>>>>>>>>>>>>>>>>>>>>>> "+((String)map.get(KEY_STATUS)));
            //            System.out.println("setContactDetail KEY_BL_NO >>>>>>>>>>>>>>>>>>>>>>>>> "+(String)map.get(KEY_BL_NO));
            //            System.out.println("setContactDetail KEY_BKG_NO >>>>>>>>>>>>>>>>>>>>>>>>> "+(String)map.get(KEY_BKG_NO));

            clearContactDetails(form);

            //objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_CONTACT_DTL, new ContactDetailsRowMapper(form), arrParam);
            //mapResult = objSP.execute();
            mapResult=new HashMap();
            mapResult.put("P_I_V_BKG_NO", (String) map.get(P_I_V.BKG_NO));
            PRR_ERCL_GET_ESI_CONTACT_DTL proc=new PRR_ERCL_GET_ESI_CONTACT_DTL(getJdbcTemplate(),mapResult,form);	
            mapResult =proc.executeDbProcedure();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return mapResult;
    }

    public class ContactDetailsRowMapper extends JdbcRowMapper{

        private EshippingInstructionUim form;

        /**
         * 
         * This constructor for set obj to global variable.
         * 
         * @param form Object's Eshipping Instruction Form
         */
        public ContactDetailsRowMapper(EshippingInstructionUim form){
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
            if(KEY_FLAG_SHIPPER.equals(rs.getString(6))){
                //            System.out.println("KEY_FLAG_SHIPPER   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                form.setShipperName(rs.getString(1));
                form.setShipperAddress1(rs.getString(2));
                form.setShipperAddress2(rs.getString(3));
                form.setShipperAddress3(rs.getString(4));
                form.setShipperAddress4(rs.getString(5));
                form.setShipperCode(rs.getString(7));
            } else if(KEY_FLAG_CONSIGNEE.equals(rs.getString(6))){
                //                System.out.println("KEY_FLAG_CONSIGNEE     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                form.setConsigneeName(rs.getString(1));
                form.setConsigneeAddress1(rs.getString(2));
                form.setConsigneeAddress2(rs.getString(3));
                form.setConsigneeAddress3(rs.getString(4));
                form.setConsigneeAddress4(rs.getString(5));
                form.setConsigneeCode(rs.getString(7));
            } else if(KEY_FLAG_NOTIFY_PART.equals(rs.getString(6))){
                //                System.out.println("KEY_FLAG_NOTIFY_PART    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                form.setNotifyPartyName(rs.getString(1));
                form.setNotifyPartyAddress1(rs.getString(2));
                form.setNotifyPartyAddress2(rs.getString(3));
                form.setNotifyPartyAddress3(rs.getString(4));
                form.setNotifyPartyAddress4(rs.getString(5));
                form.setNotifyPartyCode(rs.getString(7));
            }
            return null;
        }
    }

    /**
     * 
     * This mothod for set text value from screen to procedure.
     * 
     * @param currentColumn Column value has been send
     * @param chosenColumn Column selected from screen
     * @param findText Text value from screen
     * @return Value for use in procudure search
     */
    public String getFindText(String currentColumn, String chosenColumn, String findText){
        try{
            if(!currentColumn.equals(chosenColumn)){
                findText = BLANK;
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return findText;
    }

    /**
     * 
     * This method for get List of Booking.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of booking data 
     */
    public Map getListEShipping(Map map) throws BusinessException, DataAccessException{

        JdbcStoredProcedure objSP = null;
        Map mapResult = null;

        List<EshippingBookingListMod> list = null;

        BigDecimal size = null;

        String[][] arrParam = null;

        String findText = null;
        String column = null;
        String sortby = null;
        String order = null;
        String status = null;
        String wildcard = null;
        String fromRecord = null;
        String toRecord = null;
        try{
            findText = (String) map.get(KEY_CRITERIA_TEXT_FIND);
            column = (String) map.get(KEY_CRITERIA_COLUMN);
            sortby = (String) map.get(KEY_CRITERIA_SORTBY);
            order = (String) map.get(KEY_CRITERIA_ORDER);
            status = (String) map.get(KEY_CRITERIA_STATUS);
            wildcard = (String) map.get(KEY_CRITERIA_WILDCARD);

            if(null!=(Integer) map.get(KEY_FROM_RECORD)){
                fromRecord = String.valueOf((Integer) map.get(KEY_FROM_RECORD)+1);
            }

            if(null!=(Integer) map.get(KEY_TO_RECORD)){
                toRecord = String.valueOf((Integer) map.get(KEY_TO_RECORD)+1);
            }
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */

            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                { P_I_V.BOOKING_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.BOOKING_NO, column, findText) }, 
                { P_I_V.SHIPPER_NAME_POPUP, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.SHIPPER, column, findText) }, 
                { P_I_V.VESSEL, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.VESSEL, column, findText) }, 
                { P_I_V.VOYAGE, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.VOYAGE, column, findText) }, 
                { P_I_V.POL, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.POL, column, findText) }, 
                { P_I_V.POD, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.POD, column, findText) }, 
                { P_I_V.STATUS, BLANK+ORACLE_VARCHAR, PARAM_IN, status }, 
                { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.BL_NO, column, findText) }, 
                { P_I_V.LOGIN_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(KEY_USER_ID) }, 
                { P_I_V.REC_START, BLANK+ORACLE_VARCHAR, PARAM_IN, fromRecord }, 
                { P_I_V.REC_END, BLANK+ORACLE_VARCHAR, PARAM_IN, toRecord }, 
                { P_O_V.TOTAL_ROW, BLANK+ORACLE_NUMBER, PARAM_OUT, BLANK } 
            };

           // objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_BOOKING_POPUP, new EsiBookingPopupRowMapper(), arrParam);
           // mapResult = objSP.execute();
            mapResult=new HashMap();
            mapResult.put("P_I_V_BOOKING_NO", arrParam[1][3]);
            mapResult.put("P_I_V_SHIPPER", arrParam[2][3]);
            mapResult.put("P_I_V_VESSEL", arrParam[3][3]);
            mapResult.put("P_I_V_VOYAGE", arrParam[4][3]);
            mapResult.put("P_I_V_POL", arrParam[5][3]);
            mapResult.put("P_I_V_POD", arrParam[6][3]);
            mapResult.put("P_I_V_ESI_STATUS", arrParam[7][3]);
            mapResult.put("P_I_V_BL_NO", arrParam[8][3]);
            mapResult.put("P_I_V_LOGIN_ID", arrParam[9][3]);
            mapResult.put("P_I_V_RECORD_START", arrParam[10][3]);
            mapResult.put("P_I_V_RECORD_END", arrParam[11][3]);
            PRR_ERCL_GET_ESI_BOOKING_POPUP proc=new PRR_ERCL_GET_ESI_BOOKING_POPUP(getJdbcTemplate(),mapResult);
            proc.executeDbProcedure();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            if(mapResult!=null&&!mapResult.isEmpty()){
                list = (List<EshippingBookingListMod>) mapResult.get(P_O_V.REF_CURSOR_DTL_DATA);
                size = (BigDecimal) mapResult.get(P_O_V.TOTAL_ROW);
            } else {
                mapResult = new HashMap();
            }
            if(list==null){
                list = new ArrayList<EshippingBookingListMod>();
            }
            if(size==null){
                size = new BigDecimal(0);
            }
            mapResult.put(KEY_DATA, list);
            mapResult.put(KEY_SIZE, size.intValue());
        }
        //        System.out.println("Row(s) All : " + size.intValue());
        return mapResult;
    }

    //@06 BEGIN

    public Map getCommodityDetails(Map map) throws BusinessException, DataAccessException{
        //@07 BEGIN
        JdbcStoredProcedure objSP = null;
        Map mapResult = null;
        //@08 BEGIN
        List list = null;

        String mode = null;
        String bookingNo = null;
        String blNo = null;
        try{
            System.out.println("START --- setRoutingDetail --- START");
            mode = (String) map.get(P_I_V.STATUS);
            bookingNo = (String) map.get(P_I_V.BKG_NO);
            blNo = (String) map.get(P_I_V.BL_NO);

            System.out.println("PARAMETER --- "+"\n1.Mode("+P_I_V.STATUS+" = "+mode+"\n2.BookingNo("+P_I_V.BKG_NO+") = "+bookingNo+"\n3.BlNo("+P_I_V.BL_NO+" = "+blNo);

            String[][] arrParam = { 
                                    { P_O_V.REF_CURSOR_DTL_DATA     , BLANK+ORACLE_CURSOR   , PARAM_OUT , BLANK }, 
                                    { P_I_V.MODE                    , BLANK+ORACLE_VARCHAR  , PARAM_IN  , (String) map.get(P_I_V.MODE) }, 
                                    { P_I_V.BKG_NO                  , BLANK+ORACLE_VARCHAR  , PARAM_IN  , (String) map.get(P_I_V.BKG_NO) }, 
                                    { P_I_V.BL_NO                   , BLANK+ORACLE_VARCHAR  , PARAM_IN  , (String) map.get(P_I_V.BL_NO) } };

            //objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_COMM_DETAILS, new CommodityDetailsRowMapper(), arrParam);
           // mapResult = objSP.execute();
            
            mapResult=new HashMap();
            mapResult.put("P_I_V_BKG_NO", bookingNo);
            mapResult.put("P_I_V_ESI_STATUS", mode);
            PRR_ERCL_GET_ESI_COMM_DETAILS proc =new PRR_ERCL_GET_ESI_COMM_DETAILS(getJdbcTemplate(),mapResult);
            mapResult = proc.executeDbProcedure(); 
            
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            if(mapResult!=null&&!mapResult.isEmpty()){
                list = (List) mapResult.get(P_O_V.REF_CURSOR_DTL_DATA);
                if(list!=null&&!list.isEmpty()){
                    mapResult.put(KEY_DATA, list);
                }
            }
        }
        //@07 END
        return mapResult;
    }

    public class CommodityDetailsRowMapper extends JdbcRowMapper{
        //@10 BEGIN
        DecimalFormat dfOfPackage   = new DecimalFormat("###,###,##0");
        DecimalFormat dfWeight      = new DecimalFormat("###,###,##0.000");
        DecimalFormat dfMeasurement = new DecimalFormat("###,###,##0.0000");
        //@10 END
        
        /*Begin @16*/
        int           comSeqNo      = 0;
        /*End @16*/

        public Object mapRow(ResultSet rs, int row) throws SQLException{
            //@07 BEGIN
            EshippingCommodityDetailsMod    obj             = null;
            String                          seqNo           = null;
            //@10 BEGIN
            BigDecimal                      weight          = null;
            String                          weightStr       = null;
            //@10 END
            //@14 BEGIN
            BigDecimal                      measurement     = null;
            //@14 END
            BigDecimal                      ofPackage       = null;
            
            try{
                obj = new EshippingCommodityDetailsMod();
                obj.setStrCommGroup(rs.getString("COMMODITY_GROUP"));
                obj.setStrCommDesc(rs.getString("COMMODITY_DESC"));
                obj.setStrCommCode(rs.getString("COMMODITY_CODE"));
                
                /*Begin @16*/
                obj.setComSeqNo(String.valueOf(comSeqNo));
                comSeqNo++;
                /*End @16*/

                seqNo = rs.getString("COMM_GRP_SEQNO");
                if(seqNo!=null){
                    try{
                        obj.setIntCommGroupSeqNo(Integer.valueOf(seqNo));
                    } catch(NumberFormatException nex){
                        obj.setIntCommGroupSeqNo(null);
                    }
                } else {
                    obj.setIntCommGroupSeqNo(null);
                }
                obj.setStrCommGroupCode(rs.getString("COMM_GRP_CODE"));
                //                @10 BEGIN
                weight = rs.getBigDecimal("WEIGHT");
                if(weight==null){
                    weight = new BigDecimal(0.0);
                }
                obj.setStrCommWeight(dfWeight.format(weight));
                //                @10 END
                //                @14 BEGIN
                //                measurement = rs.getDouble("");
                obj.setStrCommPackageKindCode(rs.getString("TOT_PACKAGE_KIND_CODE"));
                obj.setStrCommPackageKindName(rs.getString("TOT_PACKAGE_KIND"));

                measurement = rs.getBigDecimal("TOT_MEASUREMENT");
                if(measurement==null){
                    measurement = new BigDecimal(0.0);
                }
                obj.setStrCommMeasurement(dfMeasurement.format(measurement));

                ofPackage = rs.getBigDecimal("TOT_NO_OF_PACKAGE");
                if(ofPackage==null){
                    ofPackage = new BigDecimal(0);
                }
                obj.setStrCommOfPackages(dfOfPackage.format(ofPackage));
                //                @14 END
                
                /*Begin @16*/
                obj.setMarksAndNumbers(rs.getString("MARKS_NOS"));
                obj.setDescription(rs.getString("DESCRIPTION"));
                obj.setContainerNoToCargo(rs.getString("CNTR_NO"));
                obj.setComBookingNo(rs.getString("BL_NO"));
                obj.setStrCommodityForMark(rs.getString("COMMODITY"));
                /*End @16*/
                
            } catch(Exception ex){
                ex.printStackTrace();
            }
            //@07 END
            return obj;
        }
    }
    //@06 END

    /**
     * 
     * This abstract method for get BL No.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of data about BL No.
     */
    public Map getBLNo(Map map) throws BusinessException, DataAccessException{
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        String[][] arrParam = null;
        try{
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            arrParam = new String[][]{ { P_I_V.BOOKING_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                            (String) map.get(P_I_V.BOOKING_NO) }, 
                        { P_O_V.OUT_BL_NO, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
                        { P_O_V.OUT_MODE, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
                        { P_O_V.ERR_CD, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
                        { P_O_V.ERR_DESC, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK } };

            objSP = new JdbcStoredProcedure(getDataSource(), PCE_ENOTICE_ESI_SUBMISSION.PPRE_RAISE_ENOTICE_ESI, arrParam);
            mapResult = objSP.execute();
        } catch(DataAccessException ex){
            throw ex;
        }
        return mapResult;
    }
    //    
    //    public class BLNoRowMapper extends JdbcRowMapper {
    //        
    //        private Map map;
    //        
    //        public BLNoRowMapper(Map map)
    //        {
    //            this.map = map;
    //        }
    //        
    //        /**
    //         * 
    //         * This mothod for get data about BL No.
    //         * 
    //         * @exception SQLException
    //         * @param rs List of BL No
    //         * @param row Row of BL No
    //         */
    //        public Object mapRow(ResultSet rs, int row) throws SQLException {
    //            map.put(rs.getString(""));
    //            return null;
    //        }    
    //    }

    public class EsiBookingPopupRowMapper extends JdbcRowMapper{

        /**
         * 
         * This mothod for set data to booking data in each row.
         * 
         * @exception SQLException
         * @param rs List of booking data
         * @param row Row of booking data
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EshippingBookingListMod obj = new EshippingBookingListMod();
            obj.setBookingDate(rs.getString(1));
            obj.setBookingNo(rs.getString(2));
            //@04 BEGIN
            obj.setShipperName(rs.getString(3));
            //@04 END
            obj.setLegVessel(rs.getString(4));
            obj.setLegVoyage(rs.getString(5));
            obj.setPol(rs.getString(6));
            obj.setPod(rs.getString(7));
            obj.setEsiStatusDesc(rs.getString(8));
            obj.setBlNo(rs.getString(9));
            obj.setCocSoc(rs.getString(10));
            obj.setEsiStatusCode(rs.getString(11));
            obj.setPolNo(rs.getString(12));
            obj.setPodNo(rs.getString(13));
            return obj;
        }
    }

    /**
     * 
     * This method for set data routing detail.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @param form Object's Eshipping Instruction Form
     */
    public void setRoutingDetail(Map map, EshippingInstructionUim form){
        JdbcStoredProcedure objSP = null;
        Map mapResult = null;
        //@08 BEGIN
        String[][] arrParam = null;

        String mode = null;
        String bookingNo = null;
        String blNo = null;
        try{
            System.out.println("START --- setRoutingDetail --- START");
            mode = (String) map.get(P_I_V.STATUS);
            bookingNo = (String) map.get(P_I_V.BKG_NO);
            blNo = (String) map.get(P_I_V.BL_NO);

            System.out.println("PARAMETER --- "+"\n1.Mod("+P_I_V.STATUS+" = "+mode+"\n2.BookingNo("+P_I_V.BKG_NO+") = "+bookingNo+"\n3.BlNo("+P_I_V.BL_NO+" = "+blNo);
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.STATUS, BLANK+ORACLE_VARCHAR, PARAM_IN, mode }, 
                        { P_I_V.BKG_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, bookingNo }, 
                        { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, blNo } };

            //objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_ROUTING_DTL, new RoutingDetailsRowMapper(form, mode), arrParam);
            //mapResult = objSP.execute();
            mapResult=new HashMap();
            mapResult.put("P_I_V_BKG_NO", bookingNo);
            mapResult.put("P_I_V_ESI_STATUS", mode);
            PRR_ERCL_GET_ESI_ROUTING_DTL proc=new PRR_ERCL_GET_ESI_ROUTING_DTL(getJdbcTemplate(),mapResult,form);
            proc.executeDbProcedure();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            System.out.println("END --- setRoutingDetail --- END");
        }
        //@08 END
    }

    public class RoutingDetailsRowMapper extends JdbcRowMapper{

        private EshippingInstructionUim form;
        private String status;

        /**
         * 
         * This constructor for set obj to global variable.
         * 
         * @param form Object's Eshipping Instruction Form
         * @param status ESI Status
         */
        public RoutingDetailsRowMapper(EshippingInstructionUim form, String status){
            this.form = form;
            this.status = status;
        }

        /**
         * 
         * This mothod for set data to routing detail in each row.
         * 
         * @exception SQLException
         * @param rs List of routing detail
         * @param row Row of routing detail
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            form.setVessel(rs.getString(1));
            form.setVesselNo(rs.getString(2));
            form.setVoyageNo(rs.getString(3));
            form.setShippedOnBoardDate(rs.getString(4));
            form.setPlaceDateOfIssue(rs.getString(5));
            form.setPol(rs.getString(6));
            form.setPod(rs.getString(7));
            form.setPolNo(rs.getString(8));
            form.setPodNo(rs.getString(9));
            form.setPlaceOfReceipt(rs.getString(10));
            form.setPlaceOfDelivery(rs.getString(11));
            form.setFsc(rs.getString(12));
            form.setPodCountry(rs.getString(13));
            return null;
        }
    }

    /**
     * 
     * This method for set data equipement detail.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @param form Object's Eshipping Instruction Form
     */
    public void setEquipmentDetail(Map map, EshippingInstructionUim form){
        JdbcStoredProcedure objSP = null;
        Map mapResult = null;

        //@08 BEGIN
        List<EshippingCargoDescriptionMod> list =new  ArrayList<EshippingCargoDescriptionMod>();
        List<EshippingCargoDescriptionMod> listTemp =new  ArrayList<EshippingCargoDescriptionMod>();
        String[][] arrParam = null;

        String mode = null;
        String bookingNo = null;
        String blNo = null;
        try{
            System.out.println("START --- setEquipmentDetail --- START");
            if(null!=form.getEsiStatusCode() && "E".equals(form.getEsiStatusCode())){
            	mode="2";
            }else {
            mode = (String) map.get(P_I_V.STATUS);
            }
            bookingNo = (String) map.get(P_I_V.BKG_NO);
            blNo = (String) map.get(P_I_V.BL_NO);

            System.out.println("PARAMETER --- "+"\n1.Mod("+P_I_V.STATUS+" = "+mode+"\n2.BookingNo("+P_I_V.BKG_NO+") = "+bookingNo+"\n3.BlNo("+P_I_V.BL_NO+" = "+blNo);
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.STATUS, BLANK+ORACLE_VARCHAR, PARAM_IN, mode }, 
                        { P_I_V.BKG_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, bookingNo }, 
                        { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, blNo } };

           // objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_EQUIPMENT_DTL, new EquipmentDetailsRowMapper(form, mode), arrParam);
          //  mapResult = objSP.execute();
                        mapResult=new HashMap();
                        mapResult.put("P_I_V_BKG_NO", bookingNo);
                        mapResult.put("P_I_V_ESI_STATUS", mode);
                        PRR_ERCL_GET_ESI_EQUIPMENT_DTL proc =new PRR_ERCL_GET_ESI_EQUIPMENT_DTL(getJdbcTemplate(),mapResult,form);
                        mapResult = proc.executeDbProcedure();     
                        
        // if(!form.getPriViewFlag().equals("Y")) {  
           int row=1;  
           for(EshippingCargoDescriptionMod obj:(List<EshippingCargoDescriptionMod>) mapResult.get("P_O_V_DTL_DATA")) {
              if(Integer.parseInt(obj.getLadenCount())>1) {
            	 String sizeType=""+obj.getContainerEqSize()+""+obj.getContainerEqType();
            	 String containerQuery="select BICTRN as container,carrier_seal_vin as csv,shipper_seal as ss ,COALESCE(met_measurement, 0.000) as GROSS_CARGO_MMT,COALESCE(met_weight,0.00) as met_weight  from BKG_EQUIPMENT where bibkno = '"+bookingNo+"' and bicsze='"+obj.getContainerEqSize()+"' and bicntp='"+obj.getContainerEqType()+"'";
            	 List<BookingConatineVo> conList=getJdbcTemplate().query(containerQuery, new GetContainerRowMapper());
            	 for(int i=0;i<Integer.parseInt(obj.getLadenCount());i++) {
            		 EshippingCargoDescriptionMod objTemp= new EshippingCargoDescriptionMod(obj);
            		 objTemp.setGrossContainerWeight(Double.parseDouble(obj.getGrossContainerWeight())/Integer.parseInt(objTemp.getLadenCount())+"");
            		 objTemp.setSeqNo(row);
            		 if(i<conList.size()) {
	            		 objTemp.setContainerNo(conList.get(i).getConatiner());
	            		 objTemp.setCarrierSeal(conList.get(i).getCarrierSealVin());
	            		 objTemp.setShipperSeal(conList.get(i).getShipperSeal());
	            		 objTemp.setGrossContainerWeight(conList.get(i).getWeight());
	            		 objTemp.setGrossCargoMeasurement(conList.get(i).getMetMeasurement());
	            		 objTemp.setEditFlag("N");
            		 } else {
            			 objTemp.setContainerNo("");
                		 objTemp.setCarrierSeal("");
                		 objTemp.setShipperSeal("");
                		 objTemp.setGrossContainerWeight("0.00");
                		 objTemp.setGrossCargoMeasurement("0.000"); 
                		 objTemp.setEditFlag("Y");
            		 }
            		 list.add(objTemp);
            		 row++;
            	 } 
              }else{
            	  list.add(obj);
              }
            }
			/*
			 * }else { list=(List<EshippingCargoDescriptionMod>)
			 * mapResult.get("P_O_V_DTL_DATA"); form.setPriViewFlag(""); }
			 */
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            if(list==null){
                list = new ArrayList<EshippingCargoDescriptionMod>();
            }
            form.setCargoDescriptionDetails(list);
            System.out.println("END --- setEquipmentDetail --- END");
        }
    }

    private int valueOf(String ladenCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public class EquipmentDetailsRowMapper extends JdbcRowMapper{

        private EshippingInstructionUim form;
        private int seqNo = 1;
        private String mode;

        /**
         * 
         * This constructor for set obj to global variable.
         * 
         * @param form Object's Eshipping Instruction Form
         * @param mode Mode of ESI Status (1=New, 2=In Progress, 3=Submitted)
         */
        public EquipmentDetailsRowMapper(EshippingInstructionUim form, String mode){
            this.form = form;
            this.mode = mode;
        }

        /**
         * 
         * This mothod for set data to equipment detail in each row.
         * 
         * @exception SQLException
         * @param rs List of equipment detail
         * @param row Row of equipment detail
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EshippingCargoDescriptionMod cargoDesc = new EshippingCargoDescriptionMod();
            cargoDesc.setContainerNo(rs.getString(1));
            cargoDesc.setContainerType(rs.getString(2));
            cargoDesc.setCarrierSeal(rs.getString(3));
            cargoDesc.setShipperSeal(rs.getString(4));
            cargoDesc.setOfPackages(rs.getString(5));
            cargoDesc.setPackagesKind(rs.getString(6));
            cargoDesc.setPackagesKindCode(rs.getString(7));
            cargoDesc.setGrossContainerWeight(rs.getString(8));
            cargoDesc.setGrossCargoMeasurement(rs.getString(9));
            cargoDesc.setLadenMt(rs.getString(10));
            cargoDesc.setSeqNo(seqNo);
            cargoDesc.setDbFlag("1");

            String stausFlag = EshippingInstructionDao.KEY_STATUS_DELETE;
            if("1".equals(mode)){
                stausFlag = EshippingInstructionDao.KEY_STATUS_INSERT;
            } else if("2".equals(mode)){
                stausFlag = EshippingInstructionDao.KEY_STATUS_UPDATE;
            }

            cargoDesc.setStatusFlag(stausFlag);
            cargoDesc.setOriginalSeqNo(String.valueOf(seqNo));
            cargoDesc.setCntrSeq(rs.getString(11));
            cargoDesc.setContainerEqSize(rs.getString(12));
            cargoDesc.setContainerEqType(rs.getString(13));
            cargoDesc.setFkEquipmentDetail(rs.getString(14));
            cargoDesc.setFkBookingSupplier(rs.getString(15));
            cargoDesc.setFkBookingSizeTypeDetail(rs.getString(16));
            //@01 BEGIN
            cargoDesc.setCommodity(rs.getString(17));
            cargoDesc.setStrCommodityName(rs.getString(18));
            //@01 END
            //            System.out.println("cargoDesc getCommodity >>>>>>>>>>>>>>>>>>>>>>>>>>> "+cargoDesc.getCommodity());
            seqNo++;
            return cargoDesc;
        }
    }

    /**
     * 
     * This method for get List of containter type.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of containter type 
     */
    public Map getContainerTypes(Map map) throws BusinessException, DataAccessException{
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        String[][] arrParam = null;

        String status = null;
        String bookingNo = null;
        try{
            status = (String) map.get(P_I_V.STATUS);
            bookingNo = (String) map.get(P_I_V.BKG_NO);
            /*
             * Prepare 2D Array of Parameters to be passed to SP
             * 1. Param Name
             * 2. Oracle Data Type
             * 3. Param Type(In/Out/InOut)
             * 4. Param Value(for In/InOut types)
             */
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.STATUS, BLANK+ORACLE_VARCHAR, PARAM_IN, status }, 
                        { P_I_V.BKG_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, bookingNo } };

            //objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_CNTRTYPE_DDL, new ContainerTypeRowMapper(), arrParam);
            //mapResult = objSP.execute();
            
            mapResult=new HashMap();
            mapResult.put("P_I_V_ESI_STATUS", status);
            mapResult.put("P_I_V_BKG_NO", bookingNo);
            PRR_ERCL_GET_ESI_CNTRTYPE_DDL proc=new PRR_ERCL_GET_ESI_CNTRTYPE_DDL(getJdbcTemplate(),mapResult);
            proc.executeDbProcedure();
        } catch(DataAccessException ex){
            throw ex;
        }
        return mapResult;
    }

    public class ContainerTypeRowMapper extends JdbcRowMapper{

        /**
         * 
         * This mothod for set data to container type in each row.
         * 
         * @exception SQLException
         * @param rs List of container type
         * @param row Row of container type
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            ComboVO obj = new ComboVO();
            obj.setName(rs.getString(1));
            obj.setCode(rs.getString(2)+"|"+rs.getString(3));
            return obj;
        }
    }

    /**
     * 
     * This method for get List of package kind type.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of package kind type 
     */
    public Map getPackageKindTypes(Map map) throws BusinessException, DataAccessException{
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        List<EshippingBookingListMod> list = null;

        BigDecimal size = null;

        String[][] arrParam = null;

        String findText = null;
        String column = null;
        String sortby = null;
        String order = null;

        Integer fromRecord = null;
        Integer toRecord = null;
        try{
            findText = (String) map.get(KEY_CRITERIA_TEXT_FIND);
            column = (String) map.get(KEY_CRITERIA_COLUMN);
            sortby = (String) map.get(KEY_CRITERIA_SORTBY);
            order = (String) map.get(KEY_CRITERIA_ORDER);

            fromRecord = (Integer) map.get(KEY_FROM_RECORD);
            toRecord = (Integer) map.get(KEY_TO_RECORD);
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                { P_I_V.PKG_NAME, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.PACKAGE_NAME, column, findText) }, 
                { P_I_V.PKG_CODE, BLANK+ORACLE_VARCHAR, PARAM_IN, 
                    getFindText(ComboBoxESIConstants.COLUMN_KEY.PACKAGE_CODE, column, findText) }, 
                { P_I_V.REC_START, BLANK+ORACLE_VARCHAR, PARAM_IN, String.valueOf(fromRecord+1) }, 
                { P_I_V.REC_END, BLANK+ORACLE_VARCHAR, PARAM_IN, String.valueOf(toRecord+1) }, 
                { P_O_V.TOTAL_ROW, BLANK+ORACLE_NUMBER, PARAM_OUT, BLANK } };

            objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_PACKAGE_POPUP, new PackageKingTypeRowMapper(), arrParam);
            mapResult = objSP.execute();
        } catch(Exception ex){

        } finally{
            list = (List<EshippingBookingListMod>) mapResult.get(P_O_V.REF_CURSOR_DTL_DATA);
            if(list==null){
                list = new ArrayList<EshippingBookingListMod>();
            }

            size = (BigDecimal) mapResult.get(P_O_V.TOTAL_ROW);
            if(size==null){
                size = new BigDecimal(0);
            }
            mapResult.put(KEY_DATA, list);
            mapResult.put(KEY_SIZE, size.intValue());
        }
        return mapResult;
    }

    public class PackageKingTypeRowMapper extends JdbcRowMapper{

        /**
         * 
         * This mothod for set data to package kind type in each row.
         * 
         * @exception SQLException
         * @param rs List of package kind type
         * @param row Row of package kind type
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EshippingPackageTypeListMod obj = new EshippingPackageTypeListMod();
            obj.setPackageName(rs.getString(1));
            obj.setPackageCode(rs.getString(2));
            return obj;
        }
    }

    /**
     * 
     * This method for get List of commodity type.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of commodity type 
     */
    public Map getCommodityTypes(Map map) throws BusinessException, DataAccessException{
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        String[][] arrParam = null;

        String mode = null;
        String bookingNo = null;
        String blNo = null;
        try{
            mode = (String) map.get(P_I_V.MODE);
            bookingNo = (String) map.get(P_I_V.BKG_NO);
            blNo = (String) map.get(P_I_V.BL_NO);
            /*
             * Prepare 2D Array of Parameters to be passed to SP
             * 1. Param Name
             * 2. Oracle Data Type
             * 3. Param Type(In/Out/InOut)
             * 4. Param Value(for In/InOut types)
             */
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.MODE, BLANK+ORACLE_VARCHAR, PARAM_IN, mode }, 
                        { P_I_V.BKG_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, bookingNo }, 
                        { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, blNo } };

            objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_COMM_DETAILS, new CommodityTypeRowMapper(), arrParam);
            mapResult = objSP.execute();
        } catch(DataAccessException ex){
            throw ex;
        }
        return mapResult;
    }

    public class CommodityTypeRowMapper extends JdbcRowMapper{

        /**
         * 
         * This mothod for set data to commodity type in each row.
         * 
         * @exception SQLException
         * @param rs List of commodity type
         * @param row Row of commodity type
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            ComboVO obj = new ComboVO();
            obj.setName(rs.getString(1));
            obj.setCode(rs.getString(2));
            return obj;
        }
    }

    /**
     * 
     * This method for set data cargo description, marks&numbers.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @param form Object's Eshipping Instruction Form
     */
    public void setCargoMark(Map map, EshippingInstructionUim form){
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        String[][] arrParam = null;

        String blNo = null;
        try{
            blNo = (String) map.get(P_I_V.BL_NO);
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            arrParam = new String[][]{  
                                        { P_O_V.REF_CURSOR_DTL_DATA     , BLANK+ORACLE_CURSOR       , PARAM_OUT     , BLANK }, 
                                        { P_I_V.MODE                    , BLANK+ORACLE_VARCHAR      , PARAM_IN      , (String) map.get(P_I_V.MODE) }, 
                                        { P_I_V.BKG_NO                  , BLANK+ORACLE_VARCHAR      , PARAM_IN      , (String) map.get(P_I_V.BKG_NO) }, 
                                        { P_I_V.BL_NO                   , BLANK+ORACLE_VARCHAR      , PARAM_IN      , blNo } 
                                     };

//            form.setMarksAndNumbers(StringUtils.EMPTY);
//            form.setDescription(StringUtils.EMPTY);

            objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_CARGO_MARK_NO, new CargoMarkRowMapper(form), arrParam);
            mapResult = objSP.execute();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public class CargoMarkRowMapper extends JdbcRowMapper{

        private EshippingInstructionUim form;

        /**
         * 
         * This constructor for set obj to global variable.
         * 
         * @param form Object's Eshipping Instruction Form
         */
        public CargoMarkRowMapper(EshippingInstructionUim form){
            this.form = form;
        }

        /**
         * 
         * This mothod for set data to cargo description, marks&numbers in each row.
         * 
         * @exception SQLException
         * @param rs List of cargo description, marks&numbers
         * @param row Row of cargo description, marks&numbers
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            form.setBlNumber(rs.getString(1));
            form.setStrCommodityForMark(rs.getString(2));
//            form.setMarksAndNumbers(rs.getString(3));
//            form.setDescription(rs.getString(4));
            form.setContainerNoToCargo(rs.getString(5));
            return null;
        }
    }

    /**
     * 
     * This method for insert or update shipment header(save function).
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return Value of parameters out from procedure(error code or description) 
     */
    public Map insertOrUpdateShipmentHeader(Map map) throws BusinessException, DataAccessException{
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        String[][] arrParam = null;
        try{
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            // ----- Next time will remove from proc
			/*
			 * arrParam = new String[][]{ { P_I_V.MODE, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * ((String) map.get(P_I_V.STATUS)) }, { P_I_V.ARCHE_TYPE, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, ((String) map.get(P_I_V.ARCHE_TYPE)) }, { P_I_V.BL_TYPE,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.BL_TYPE) }, {
			 * P_I_V.BKG_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.BKG_NO)
			 * }, { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.BL_NO) }, { P_I_V.SUBMIT_BY, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * (String) map.get(P_I_V.SUBMIT_BY) }, { P_I_V.CONTACT, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.CONTACT) }, { P_I_V.EMAIL,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.EMAIL) }, {
			 * P_I_V.ADD_EMAILS, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.ADD_EMAILS) }, { P_I_V.PHONE, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * (String) map.get(P_I_V.PHONE) }, { P_I_V.FAX, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * (String) map.get(P_I_V.FAX) }, { P_I_V.SHIPPER_CODE, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.SHIPPER_CODE) }, { P_I_V.SHIPPER_NAME,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.SHIPPER_NAME) }, {
			 * P_I_V.SHIPPER_ADD1, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.SHIPPER_ADD1) }, { P_I_V.SHIPPER_ADD2, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.SHIPPER_ADD2) }, { P_I_V.SHIPPER_ADD3,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.SHIPPER_ADD3) }, {
			 * P_I_V.SHIPPER_ADD4, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.SHIPPER_ADD4) }, { P_I_V.CNEE_CODE, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.CNEE_CODE) }, { P_I_V.CNEE_NAME,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.CNEE_NAME) }, {
			 * P_I_V.CNEE_ADD1, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.CNEE_ADD1) }, { P_I_V.CNEE_ADD2, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.CNEE_ADD2) }, { P_I_V.CNEE_ADD3,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.CNEE_ADD3) }, {
			 * P_I_V.CNEE_ADD4, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.CNEE_ADD4) }, { P_I_V.NTFY_CODE, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.NTFY_CODE) }, { P_I_V.NTFY_NAME,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.NTFY_NAME) }, {
			 * P_I_V.NTFY_ADD1, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.NTFY_ADD1) }, { P_I_V.NTFY_ADD2, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.NTFY_ADD2) }, { P_I_V.NTFY_ADD3,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.NTFY_ADD3) }, {
			 * P_I_V.NTFY_ADD4, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.NTFY_ADD4) }, { P_I_V.ISSUE_PLACE_NAME, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.ISSUE_PLACE_NAME) }, { P_I_V.POL_NAME,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.POL_NAME) }, {
			 * P_I_V.POD_NAME, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.POD_NAME) }, { P_I_V.PLR_NAME, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * (String) map.get(P_I_V.PLR_NAME) }, { P_I_V.PLD_NAME, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.PLD_NAME) }, { P_I_V.ORG_BL_COUNT,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.ORG_BL_COUNT) }, {
			 * P_I_V.MARKS_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.MARKS_NO) }, { P_I_V.DESC, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * (String) map.get(P_I_V.DESC) }, { P_I_V.REMARK, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.REMARK) }, { P_I_V.VESSEL,
			 * BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.VESSEL) }, {
			 * P_I_V.VOYAGE, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.VOYAGE)
			 * }, { P_I_V.STATUS, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.STATUS) }, { P_I_V.LOGIN_ID, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * (String) map.get(P_I_V.LOGIN_ID) }, { P_O_V.ERR_CD, BLANK+ORACLE_VARCHAR,
			 * PARAM_OUT, BLANK }, { P_O_V.ERR_DESC, BLANK+ORACLE_VARCHAR, PARAM_OUT, BLANK
			 * }, { P_I_V.VESSEL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, (String)
			 * map.get(P_I_V.VESSEL_NO) }, { P_I_V.POL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN,
			 * (String) map.get(P_I_V.POL_NO) }, { P_I_V.POD_NO, BLANK+ORACLE_VARCHAR,
			 * PARAM_IN, (String) map.get(P_I_V.POD_NO) }};
			 */
           // objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_INS_ESI_SHIPMENT_HDR, arrParam);
           // mapResult = objSP.execute();
            
            
            mapResult=new HashMap();
            mapResult.put("P_I_V_MODE", ((String) map.get(P_I_V.STATUS)));
            mapResult.put("P_I_V_BL_ARCHETYPE", ((String) map.get(P_I_V.ARCHE_TYPE)));
            mapResult.put("P_I_V_BL_TYPE", (String) map.get(P_I_V.BL_TYPE));
            mapResult.put("P_I_V_BOOKING_NO", (String) map.get(P_I_V.BKG_NO));
            mapResult.put("P_I_V_BL_NO", (String) map.get(P_I_V.BL_NO));
            mapResult.put("P_I_V_SUBMIT_BY", (String) map.get(P_I_V.SUBMIT_BY));
            mapResult.put("P_I_V_CONTACT", (String) map.get(P_I_V.CONTACT));
            mapResult.put("P_I_V_EMAIL", (String) map.get(P_I_V.EMAIL));
            mapResult.put("P_I_V_ADD_EMAILS", (String) map.get(P_I_V.ADD_EMAILS));
            mapResult.put("P_I_V_PHONE", (String) map.get(P_I_V.PHONE));
            mapResult.put("P_I_V_FAX", (String) map.get(P_I_V.FAX));
            mapResult.put("P_I_V_DN_SHIPPER_CODE", (String) map.get(P_I_V.SHIPPER_CODE));
            mapResult.put("P_I_V_SHIPPER_NAME", ((String) map.get(P_I_V.SHIPPER_NAME)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_SHIPPER_ADD1", ((String) map.get(P_I_V.SHIPPER_ADD1)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_SHIPPER_ADD2", ((String) map.get(P_I_V.SHIPPER_ADD2)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_SHIPPER_ADD3", ((String) map.get(P_I_V.SHIPPER_ADD3)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_SHIPPER_ADD4", ((String) map.get(P_I_V.SHIPPER_ADD4)).replaceAll("'", "\\\\'"));
            if(map.get(P_I_V.CNEE_NAME).equals("TO ORDER")) {
            	mapResult.put("P_I_V_DN_CNEE_CODE", "TOORZZ0001");
            	mapResult.put("P_I_V_CNEE_NAME", (String) map.get(P_I_V.CNEE_NAME));
            }else {
            	mapResult.put("P_I_V_DN_CNEE_CODE", (String) map.get(P_I_V.CNEE_CODE));
                mapResult.put("P_I_V_CNEE_NAME", ((String) map.get(P_I_V.CNEE_NAME)).replaceAll("'", "\\\\'"));	
            }
            mapResult.put("P_I_V_CNEE_ADD1", ((String) map.get(P_I_V.CNEE_ADD1)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_CNEE_ADD2", ((String) map.get(P_I_V.CNEE_ADD2)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_CNEE_ADD3", ((String) map.get(P_I_V.CNEE_ADD3)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_CNEE_ADD4", ((String) map.get(P_I_V.CNEE_ADD4)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_DN_NTFY_CODE", (String) map.get(P_I_V.NTFY_CODE));
            mapResult.put("P_I_V_NTFY_NAME", ((String) map.get(P_I_V.NTFY_NAME)).replaceAll("'", "\\\\'"));	
            mapResult.put("P_I_V_NTFY_ADD1", ((String) map.get(P_I_V.NTFY_ADD1)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_NTFY_ADD2", ((String) map.get(P_I_V.NTFY_ADD2)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_NTFY_ADD3", ((String) map.get(P_I_V.NTFY_ADD3)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_NTFY_ADD4", ((String) map.get(P_I_V.NTFY_ADD4)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_BL_ISSUE_PLACE_NAME", (String) map.get(P_I_V.ISSUE_PLACE_NAME));
            mapResult.put("P_I_V_POL_NAME", (String) map.get(P_I_V.POL_NAME));
            mapResult.put("P_I_V_POD_NAME", (String) map.get(P_I_V.POD_NAME));
            mapResult.put("P_I_V_PLR_NAME", (String) map.get(P_I_V.PLR_NAME));
            mapResult.put("P_I_V_PLD_NAME", (String) map.get(P_I_V.PLD_NAME));
            mapResult.put("P_I_V_ORG_BL_COUNT", (String) map.get(P_I_V.ORG_BL_COUNT));
            mapResult.put("P_I_V_COMM_LVL_MARKS_NO", (String) map.get(P_I_V.MARKS_NO));
            mapResult.put("P_I_V_COMM_LVL_DESC", (String) map.get(P_I_V.DESC));
            mapResult.put("P_I_V_REMARK", ((String) map.get(P_I_V.REMARK)).replaceAll("'", "\\\\'"));
            mapResult.put("P_I_V_VESSEL", (String) map.get(P_I_V.VESSEL));
            mapResult.put("P_I_V_VOYAGE", (String) map.get(P_I_V.VOYAGE));
            mapResult.put("P_I_V_ESI_STATUS", (String) map.get(P_I_V.STATUS));
            mapResult.put("P_I_V_LOGIN_ID", (String) map.get(P_I_V.LOGIN_ID));
            mapResult.put("P_I_V_VESSEL_NO", (String) map.get(P_I_V.VESSEL_NO));
            mapResult.put("P_I_V_POL_NO", (String) map.get(P_I_V.POL_NO));
            mapResult.put("P_I_V_POD_NO", (String) map.get(P_I_V.POD_NO));
            mapResult.put("P_I_V_TO_TERMINAL", (String) map.get("P_I_V_TO_TERMINAL"));
            mapResult.put("P_I_V_FROM_TERMINAL", (String) map.get("P_I_V_FROM_TERMINAL"));
            mapResult.put("P_I_V_VESSEL_ETD", (String) map.get("P_I_V_VESSEL_ETD"));
            mapResult.put("P_I_V_QUOTATION", (String) map.get("P_I_V_QUOTATION"));											   
            PRR_ERCL_INS_ESI_SHIPMENT_HDR proc=new PRR_ERCL_INS_ESI_SHIPMENT_HDR(getJdbcTemplate(),mapResult)  ; 
           synchronized(this){
        	   proc.executeDbProcedure();
		}
            
            
        } catch(DataAccessException ex){
           ex.printStackTrace();
           mapResult.put(EshippingInstructionDao.P_O_V.ERR_DESC,"Faild");
           throw ex;
        }
        return mapResult;
    }

    /**
     * 
     * This method for remove number seperate from value in screen.
     * 
     * @param value Value from screen
     * @return Value has been removed separate 
     */
    public String checkValueNumber(String value){
        if(value==null||"null".equals(value)||value.equals("")){
            return "0";
        } else {
            return String.valueOf(Integer.parseInt(value.replaceAll(",", BLANK)));
        }
    }

    //@05 BEGIN

    public String checkDoubleValueNumber(String value){
        if(value==null||"null".equals(value)||"".equals(value)){
            return "0";
        } else {
            return String.valueOf(Double.parseDouble(value.replaceAll(",", BLANK)));
        }
    }
    //@05 END

    /**
     * 
     * This method for insert or update equipment detail(save function).
     * 
     * @param map List of parameters in
     * @return Value of parameters out from procedure(error code or description) 
     * @throws Exception 
     */
    public Map insertOrUpdateContainerDetail(Map map) throws Exception{
        
        System.out.println("[EshippingInstructionDaoImpl][insertOrUpdateContainerDetail][Begin]");
        
        JdbcStoredProcedure         objSP                   = null;
        Map                         mapResult               = null;
        String[][]                  arrParam                = null;
        String                      grossCargoWeight        = null;
        String                      grossCargoMsmt          = null;
        String                      ofPackages              = null;
        String                      screenSeq               = null;
        String                      dnEqSize                = null;
        String                      pkDtlSeq                = null;
        String                      fkBkgEquimpDtl          = null;
        String                      fkBkgSupplier           = null;
        String                      fkBkgSizeTypeDtl        = null;
        //@08 BEGIN
        String                      commodity               = null;
        //@08 END
        
        try{
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            
//            Iterator iterator= map.entrySet().iterator();
//            while(iterator.hasNext()){
//                Set keyset=map.keySet();
//                System.out.println(keyset + " :: " + map.get(keyset.toString()));
//                iterator.next();
//            }
              
            grossCargoWeight        = (String) map.get(EshippingInstructionDao.P_I_V.GROSS_CARGO_WEIGHT);
            grossCargoMsmt          = (String) map.get(EshippingInstructionDao.P_I_V.GROSS_CARGO_MSMT);
            ofPackages              = (String) map.get(EshippingInstructionDao.P_I_V.NO_OF_PACKAGES);
            screenSeq               = (String) map.get(EshippingInstructionDao.P_I_V.SCREEN_SEQNO);
            dnEqSize                = (String) map.get(EshippingInstructionDao.P_I_V.DN_EQ_SIZE);
            pkDtlSeq                = (String) map.get(EshippingInstructionDao.P_I_V.PK_DTL_SEQNO);
            fkBkgEquimpDtl          = (String) map.get(EshippingInstructionDao.P_I_V.FK_BKG_EQUIPM_DTL);
            fkBkgSupplier           = (String) map.get(EshippingInstructionDao.P_I_V.FK_BKG_SUPPLIER);
            fkBkgSizeTypeDtl        = (String) map.get(EshippingInstructionDao.P_I_V.FK_BKG_SIZE_TYPE_DTL);
            commodity               = (String) map.get(P_I_V.COMMODITY_CODE);

            //@08 BEGIN
                //          //@05 BEGIN
                //          { P_I_V.GROSS_CARGO_WEIGHT, BLANK + ORACLE_NUMBER, PARAM_IN, checkDoubleValueNumber(grossCargoWeight)}, 
                //          { P_I_V.GROSS_CARGO_MSMT, BLANK + ORACLE_NUMBER, PARAM_IN, checkDoubleValueNumber(grossCargoMsmt)}, 
                //          //@05 END
                //@08 END
                //@08 BEGIN
                //@08 END
                //@02 BEGIN
                //          { P_I_V.COMMODITY_CODE, BLANK + ORACLE_VARCHAR, PARAM_IN, (String)map.get(P_I_V.COMMODITY_CODE)},
                //@02 END
			/*
			 * arrParam = new String[][]{ { P_I_V.MODE , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(((String) map.get(P_I_V.MODE))) }, { P_I_V.BKG_NO ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN , FormatUtil.nullToBlank((String)
			 * map.get(P_I_V.BKG_NO)) }, { P_I_V.LOGIN_ID , BLANK+ORACLE_VARCHAR , PARAM_IN
			 * , FormatUtil.nullToBlank((String) map.get(P_I_V.LOGIN_ID)) }, {
			 * P_I_V.SCREEN_SEQNO , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkValueNumber(screenSeq)) }, { P_I_V.DN_EQ_NO ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN , FormatUtil.nullToBlank((String)
			 * map.get(P_I_V.DN_EQ_NO)) }, { P_I_V.EQ_NO_SOURCE , BLANK+ORACLE_VARCHAR ,
			 * PARAM_IN , FormatUtil.nullToBlank((String) map.get(P_I_V.EQ_NO_SOURCE)) }, {
			 * P_I_V.LADEN_MT , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank((String) map.get(P_I_V.LADEN_MT)) }, {
			 * P_I_V.DN_EQ_SIZE , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkValueNumber(dnEqSize)) }, { P_I_V.DN_EQ_TYPE ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN , FormatUtil.nullToBlank((String)
			 * map.get(P_I_V.DN_EQ_TYPE)) }, { P_I_V.GROSS_CARGO_WEIGHT ,
			 * BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkDoubleValueNumber(grossCargoWeight)) }, {
			 * P_I_V.GROSS_CARGO_MSMT , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkDoubleValueNumber(grossCargoMsmt)) }, {
			 * P_I_V.CARRIER_SEAL , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank((String) map.get(P_I_V.CARRIER_SEAL)) }, {
			 * P_I_V.SHIPPER_SEAL , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank((String) map.get(P_I_V.SHIPPER_SEAL)) }, {
			 * P_I_V.NO_OF_PACKAGES , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkValueNumber(ofPackages)) }, {
			 * P_I_V.DN_PACKAGE_KIND_CODE, BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank((String) map.get(P_I_V.DN_PACKAGE_KIND_CODE)) }, {
			 * P_I_V.PK_DTL_SEQNO , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkValueNumber(pkDtlSeq)) }, {
			 * P_I_V.FK_BKG_EQUIPM_DTL , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkValueNumber(fkBkgEquimpDtl)) }, {
			 * P_I_V.FK_BKG_SUPPLIER , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkValueNumber(fkBkgSupplier)) }, {
			 * P_I_V.FK_BKG_SIZE_TYPE_DTL, BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(checkValueNumber(fkBkgSizeTypeDtl)) }, {
			 * P_I_V.COMMODITY_CODE , BLANK+ORACLE_VARCHAR , PARAM_IN ,
			 * FormatUtil.nullToBlank(FormatUtil.nullToBlank(commodity)) }, {
			 * P_O_V.PK_DTL_SEQNO_OUT , BLANK+ORACLE_VARCHAR , PARAM_OUT , BLANK }, {
			 * P_O_V.ERR_CD , BLANK+ORACLE_VARCHAR , PARAM_OUT , BLANK }, { P_O_V.ERR_DESC ,
			 * BLANK+ORACLE_VARCHAR , PARAM_OUT , BLANK } };
			 */
           // objSP       = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_INS_ESI_CONTAINERS, arrParam);
           // mapResult   = objSP.execute();
            mapResult=new HashMap();
            mapResult.put("P_I_V_MODE", ((String) map.get(P_I_V.MODE)));
            mapResult.put("P_I_V_BOOKING_NO", (String) map.get(P_I_V.BKG_NO));
            mapResult.put("P_I_V_LOGIN_ID", (String) map.get(P_I_V.LOGIN_ID));
            mapResult.put("P_I_V_SCREEN_SEQNO", checkValueNumber(screenSeq));
            mapResult.put("P_I_V_DN_EQUIPMENT_NO", (String) map.get(P_I_V.DN_EQ_NO));
            mapResult.put("P_I_V_EQUPMENT_NO_SOURCE", (String) map.get(P_I_V.EQ_NO_SOURCE));
            mapResult.put("P_I_V_LADEN_MT", (String) (String) map.get(P_I_V.LADEN_MT));
            mapResult.put("P_I_V_DN_EQ_SIZE", (String) checkValueNumber(dnEqSize));
            mapResult.put("P_I_V_DN_EQ_TYPE", (String) map.get(P_I_V.DN_EQ_TYPE));
            mapResult.put("P_I_V_GROSS_CARGO_WEIGHT", checkDoubleValueNumber(grossCargoWeight));
            mapResult.put("P_I_V_GROSS_CARGO_MSMT", (String) checkDoubleValueNumber(grossCargoMsmt));
            mapResult.put("P_I_V_CARRIER_SEAL", (String) map.get(P_I_V.CARRIER_SEAL));
            mapResult.put("P_I_V_SHIPPER_SEAL", (String) map.get(P_I_V.SHIPPER_SEAL));
            mapResult.put("P_I_V_NO_OF_PACKAGES", checkValueNumber(ofPackages));
            mapResult.put("P_I_V_DN_PACKAGE_KIND_CODE", (String) map.get(P_I_V.DN_PACKAGE_KIND_CODE));
            mapResult.put("P_I_V_PK_DTL_SEQNO", checkValueNumber(pkDtlSeq));
            mapResult.put("P_I_V_FK_BKG_EQUIPM_DTL", checkValueNumber(fkBkgEquimpDtl));
            mapResult.put("P_I_V_FK_BKG_SUPPLIER", checkValueNumber(fkBkgSupplier));
            mapResult.put("P_I_V_FK_BKG_SIZE_TYPE_DTL", checkValueNumber(fkBkgSizeTypeDtl));
            mapResult.put("P_I_V_DN_COMMODITY_CODE", FormatUtil.nullToBlank(commodity));
            try {
                PRR_ERCL_INS_ESI_CONTAINERS proc=new PRR_ERCL_INS_ESI_CONTAINERS(getJdbcTemplate(),mapResult);
                proc.executeDbProcedure();
            }catch (Exception e) {
            	e.printStackTrace();
            	throw e;
            }           
        } catch(DataAccessException ex){
        	ex.printStackTrace();
            throw ex;
        }finally{
            System.out.println("[EshippingInstructionDaoImpl][insertOrUpdateContainerDetail][End]");
        }
        return mapResult;
    }

    /**
     * 
     * This abstract method for submit eshipping instruction(submit function).
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return Value of parameters out from procedure(error code or description) 
     */
    public Map submitEsi(Map map) throws BusinessException, DataAccessException{
        System.out.println("[EshippingInstructionDaoImpl][submitEsi][Begin]");
        
        JdbcStoredProcedure     objSP           = null;
        Map                     mapResult       = null;
        String[][]              arrParam        = null;
        
        try{
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            //        @11 BEGIN  
                //        @11 END
                
                System.out.println("[EshippingInstructionDaoImpl][submitEsi] P_I_V.BOOKING_NO   :: " + (String) map.get(P_I_V.BOOKING_NO));
                System.out.println("[EshippingInstructionDaoImpl][submitEsi] P_I_V.LOGIN_ID     :: " + (String) map.get(P_I_V.LOGIN_ID));
                
                arrParam = new String[][]{ 
                                            { P_I_V.BOOKING_NO  , BLANK+ORACLE_VARCHAR      , PARAM_IN      , (String) map.get(P_I_V.BOOKING_NO) }, 
                                            { P_O_V.ERR_CD      , BLANK+ORACLE_VARCHAR      , PARAM_OUT     , BLANK }, 
                                            { P_O_V.ERR_DESC    , BLANK+ORACLE_VARCHAR      , PARAM_OUT     , BLANK }, 
                                            { P_I_V.LOGIN_ID    , BLANK+ORACLE_VARCHAR      , PARAM_IN      , (String) map.get(P_I_V.LOGIN_ID) } 
                                         };
              Connection connection =getJdbcTemplate().getDataSource().getConnection();
              Statement stm = null;
      		  int rsResult=0;
      		  
      		  try {
      		  stm=connection.createStatement();	  
              String Update_EsiStatus="UPDATE ESV_SI_HEADER SET ESI_STATUS='S' WHERE FK_BOOKING_NO='"+(String) map.get(P_I_V.BOOKING_NO)+"'";                           
              rsResult=stm.executeUpdate(Update_EsiStatus);
              stm.close();
              //getJdbcTemplate().update(Update_EsiStatus);
              
              stm=connection.createStatement();	
              String Update_BOOKING_STATUS="UPDATE SEALINER.BKP001 SET BASTAT='L' WHERE babkno='"+(String) map.get(P_I_V.BOOKING_NO)+"'";                           
              rsResult=stm.executeUpdate(Update_BOOKING_STATUS);
              //getJdbcTemplate().update(Update_BOOKING_STATUS);
              stm.close();
      		  }catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if (stm != null && !stm.isClosed()) {
						stm.close();
					}
					if (connection != null && !connection.isClosed()) {
						connection.close();
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
            //objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_ESI_SUBMIT_SI, arrParam);
            //mapResult = objSP.execute();
              map.put("P_O_V_ERR_CD", "SUCCESS");
              map.put("P_O_V_ERR_DESC", null);
        } catch(DataAccessException ex){
            ex.printStackTrace();
            throw ex;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EshippingInstructionDaoImpl][submitEsi][End]");
        }
        return map;
    }

    /**
     * 
     * This abstract method for set all data to acknowledgement popoup.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @param form Object's Eshipping Instruction Form
     */
    public void setAcknowledgementDetail(Map map, EshippingInstructionUim form){
        JdbcStoredProcedure objSP = null;

        Map mapResult = null;

        List list = null;

        String[][] arrParam = null;
        
        
        
        try{
            /*
              * Prepare 2D Array of Parameters to be passed to SP
              * 1. Param Name
              * 2. Oracle Data Type
              * 3. Param Type(In/Out/InOut)
              * 4. Param Value(for In/InOut types)
              */
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.FSC, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.FSC) } };

            //objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_ACK_POPUP, new AcknowledgementDetailsRowMapper(form), arrParam);
            //mapResult = objSP.execute();
            mapResult=new HashMap();
            mapResult.put("P_I_V_BOOKING_NO", form.getBookingNo());
            PRR_ERCL_GET_ESI_ACK_POPUP proc =new PRR_ERCL_GET_ESI_ACK_POPUP(getJdbcTemplate(),mapResult,form);
            proc.executeDbProcedure();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            list = (List) mapResult.get(P_O_V.REF_CURSOR_DTL_DATA);
        }
    }

    public class AcknowledgementDetailsRowMapper extends JdbcRowMapper{

        private EshippingInstructionUim form;

        /**
         * 
         * This constructor for set obj to global variable.
         * 
         * @param form Object's Eshipping Instruction Form
         */
        public AcknowledgementDetailsRowMapper(EshippingInstructionUim form){
            this.form = form;
        }

        /**
         * 
         * This mothod for set data to acknowledgement data in each row.
         * 
         * @exception SQLException
         * @param rs List of acknowledgement data
         * @param row Row of acknowledgement data
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            form.setVendorEmail(rs.getString(1));
            form.setVendorTelephone(rs.getString(2));
            form.setVendorFax(rs.getString(3));
            return null;
        }
    }
    
    public int validateDataChange(String bookingNo) throws BusinessException, DataAccessException, Exception{
        
        JdbcStoredProcedure objSP = null;
        Map outMap = null;
        BigDecimal validateResult = null;
        

        try{
            System.out.println("START --- validateDataChange --- START");
            
            String[][] arrParam = { 
                                    { P_O_V.VALIDATE_RESULT     , BLANK+ORACLE_NUMBER   , PARAM_OUT , BLANK }, 
                                    { P_I_V.BOOKING_NO          , BLANK+ORACLE_VARCHAR  , PARAM_IN  , bookingNo }
                                  };
            
           // objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ESI_VAL_DATA_CHANGE, arrParam);
           // outMap = objSP.execute();
            outMap=new HashMap();
            outMap.put("P_I_V_BOOKING_NO", bookingNo);
            PRR_ESI_VAL_DATA_CHANGE proc =new PRR_ESI_VAL_DATA_CHANGE(getJdbcTemplate(),outMap);
            proc.executeDbProcedure();
            validateResult = (BigDecimal)outMap.get("P_O_V_RESULT");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return validateResult.intValue();
    }
    
    public void clearESIData(String bookingNo) throws BusinessException, DataAccessException, Exception{
        
        JdbcStoredProcedure objSP = null;
        Map outMap = null;
        BigDecimal clearResult = null;
        

        try{
            System.out.println("START --- clearESIData --- START ==>"+ bookingNo);
            
            String[][] arrParam = { 
                                    { P_I_V.BOOKING_NO          , BLANK+ORACLE_VARCHAR  , PARAM_IN  , bookingNo }
                                  };
            
            objSP = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ESI_CLEAR_ESI_DATA, arrParam);
            outMap = objSP.execute();
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
     
        public String getContryByContyCode(String code) {
      	  String sqlQuery = "select NAME from VRL_PORT where CODE ='"+ code + "'"; 
      	  List<String> result= getJdbcTemplate().queryForList(sqlQuery, String.class);
      	 
      	  if(result.size()!=0)
      	 return result.get(0);
      	  else
      	 return "";
      	  
        }
        
    

public CustomerMod getCustomerDetailes(String userId) {
	  System.out.println("getCustomerDetailes   userId =  "+ userId);
	  String sqlQuery = "select cuname,cuadd1,cuadd2,cuadd3,cuadd4 from itp010 where cucust = (select  ORG_CODE from RCLTBLS.ESM_USER_LOGIN  where user_id='"+ userId + "')"; 
	  List<CustomerMod> result= getJdbcTemplate().query(sqlQuery,
			new Object[] {  }, new CustmerMapper());
	  System.out.println("getCustomerDetailes   "+ result.size());
	 return result.get(0);
	  
}

class CustmerMapper implements RowMapper {

		/**
		 * Map each row of data in the ResultSet.
		 * 
		 * @param rs
		 *            {@code ResultSet }
		 * @param rowNum
		 *            the number of the current row
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
        public String getCustomerCode(String userId) {
        	 
      
      	  
      	 String sqlQuery =  "select  ORG_CODE from RCLTBLS.ESM_USER_LOGIN  where user_id='"+ userId + "'"; 
     	  List<String> result= getJdbcTemplate().queryForList(sqlQuery, String.class);
     	 
     	  if(result.size()!=0)
     	 return result.get(0);
     	  else
     	 return "";
      	  
      	
        	
        }

		@Override
		public Map getInquiryHeaderData(EshippingInstructionUim form,String usrId,String orgCode) {
			Map map=new HashMap();
			EshippingInquiryHeaderMod model= null;
			List<EshippingInquiryHeaderMod> list=null;
			String bookingNo=form.getBookingNo();
			String status=form.getEsiStatusCode();
			String booking_Query="";
			String status_Query="";
			String user_query="";
			String HEADER_DTLS;
			String userid=usrId;
			String orgCodes=orgCode;
			
			if(status.equals("S")) {
				status=" 'S','C'";
			}else if(status.equals("N")) {
				status="'N'";
			}else if(status.equals("E")) {
				status=" 'E'";
			}
			
			if(status!=null && !status.equals("")) {
				status_Query="and esi_status in ("+status+") ";
			}
			
			if(bookingNo!=null && !bookingNo.equals("")) {
				booking_Query=" and fk_booking_no ='"+bookingNo+"'";
			}
			
			
			if(status==null || status.equals("")||status.equals("'N'")) {
				
				if(userid.equalsIgnoreCase("DEV_TEAM")) {
					user_query=" ";
				}else {
					user_query=" and (BAAUSR =   '"+userid+"' or BABKBY='"+orgCodes+"')";
				}
				
				HEADER_DTLS="select   " + 
						"	TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') as eta,   " + 
						"	TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') as etd,   " + 
						"	(CASE when BASTAT ='O' then 'Open' when BASTAT = 'C' then 'Confirmed' " + 
						"					 when BASTAT = 'W' then 'Waitlisted' when BASTAT = 'N' then 'Cancelled' " + 
						"					 when BASTAT = 'J' then 'Rejected' when BASTAT = 'L' then 'Closed'  " + 
						"					 when BASTAT = 'P' then 'Partial' END ) as status,   " + 
						"	PK_BOOKING_NO as BOOKINGNO ,   " + 
						"   '' as BLNUM, " +
						"	bapol as POL,   " + 
						"	bapoD as POD,   " + 
						"	(SELECT PINAME FROM ITP040 WHERE PICODE=bapol) as POLDES , "+	
						"	(SELECT PINAME FROM ITP040 WHERE PICODE=bapoD) as PODDES , "+
					    " 	TO_CHAR(TO_DATE(cast(bkg.VESSELETD as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') as VESSELETD, "+
						"	coalesce (esi.SPECIAL_STATUS, ' ' , esi.SPECIAL_STATUS) as SHPINGSPLSTS   " + 
						"	,'' as COMFIRMDATE"+
						"	,TO_CHAR(TO_DATE(bkg.bkg_received_date, 'YYYYMMDD'), 'DD/MM/YYYY') as RECEIVEDDATE"+
						"	,TO_CHAR(TO_DATE(bkg.bkg_loaded_date, 'YYYYMMDD'), 'DD/MM/YYYY') as LOADEDDATE"+
						"	,TO_CHAR(TO_DATE(bkg.bkg_onboard_date, 'YYYYMMDD'), 'DD/MM/YYYY') as ONBOARDDATE"+
						"  from   " + 
						"	ESV_WB_EXTEND ewe   " + 
						"inner join SEALINER.BKP001 bkg on   " + 
						"	ewe.pk_booking_no = bkg.babkno   " + 
						"left outer join ESV_SI_HEADER esi on   " + 
						"	ewe.PK_BOOKING_NO = esi.fk_booking_no   " + 
						"	    " + 
						"where   " + 
						"	bkg.bastat in('C') and bkg.babkno NOT IN (select fk_booking_no from ESV_SI_HEADER where esi_status = 'E' or esi_status = 'S' or esi_status ='C')"
						+user_query+
						" order by EXPECTED_SAILING_DATE desc limit 50";
			}else {
				
				if(userid.equalsIgnoreCase("DEV_TEAM")) {
					user_query=" ";
				}else {
					user_query=" and SUBMIT_BY =   '"+userid+"'";
				}
				
				HEADER_DTLS="select   " + 
						"	TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') as eta,   " + 
						"	TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') as etd,   " + 
						" 	TO_CHAR(TO_DATE(cast(esh.VESSELETD as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') as VESSELETD, "+
						"(CASE when BASTAT ='O' then 'Open' when BASTAT = 'C' then 'Confirmed' " + 
						"					 when BASTAT = 'W' then 'Waitlisted' when BASTAT = 'N' then 'Cancelled' " + 
						"					 when BASTAT = 'J' then 'Rejected' when BASTAT = 'L' then 'Closed'  " + 
						"					 when BASTAT = 'P' then 'Partial' END ) as status,   " +
						"	PK_BOOKING_NO as BOOKINGNO   " + 
						"   , fk_bl_no as BLNUM " +
						"	, bapol as POL   " + 
						"	, bapod as POD   " +
						"	,(SELECT PINAME FROM ITP040 WHERE PICODE=bapol) as POLDES "+	
						"	,(SELECT PINAME FROM ITP040 WHERE PICODE=bapod) as PODDES "+
						"	, coalesce(special_status,' ',special_status) as SHPINGSPLSTS   " + 
						"	,TO_CHAR(TO_DATE(CONFIRM_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as COMFIRMDATE" +
						"	,TO_CHAR(TO_DATE(bkg.bkg_received_date, 'YYYYMMDD'), 'DD/MM/YYYY') as RECEIVEDDATE "+
						"	,TO_CHAR(TO_DATE(bkg.bkg_loaded_date, 'YYYYMMDD'), 'DD/MM/YYYY') as LOADEDDATE "  +
						"	,TO_CHAR(TO_DATE(bkg.bkg_onboard_date, 'YYYYMMDD'), 'DD/MM/YYYY') as ONBOARDDATE " +
						"  from   " + 
						"	ESV_WB_EXTEND ewe,   " + 
						"	ESV_SI_HEADER esh,   " + 
						"	SEALINER.BKP001  bkg " + 
						"where   " + 
						"	pk_booking_no = fk_booking_no   " + 
						"	and pk_booking_no = babkno   " + 
						"	 "+booking_Query+" "+status_Query+"  "+user_query +" order by EXPECTED_SAILING_DATE desc limit 50";
			}
			
			 
			
			SqlRowSet rsFSC = getNamedParameterJdbcTemplate().queryForRowSet(HEADER_DTLS.toString(), new HashMap());
			list = new ArrayList<EshippingInquiryHeaderMod>();
			while (rsFSC.next()) {
				model = new EshippingInquiryHeaderMod();
				model.setDesiredArrivalDate(rsFSC.getString("eta"));
				model.setSailingDate(rsFSC.getString("etd"));
				model.setStatus(rsFSC.getString("status"));
				/*
				 * if(null!=rsFSC.getString("Status") && !rsFSC.getString("Status").equals("") )
				 * {
				 * 
				 * form.setStatus(rsFSC.getString("Status"));
				 * 
				 * }
				 */
				model.setVesseletd(rsFSC.getString("VESSELETD"));
			    model.setConfirmDate(rsFSC.getString("COMFIRMDATE"));
			    if(rsFSC.getString("RECEIVEDDATE")!=null && !rsFSC.getString("RECEIVEDDATE").equals(""))
			    	model.setBookingSplFlag("R");
			    model.setResivedDate(rsFSC.getString("RECEIVEDDATE"));
			    if(rsFSC.getString("LOADEDDATE")!=null && !rsFSC.getString("LOADEDDATE").equals(""))
			    	model.setBookingSplFlag("L");
			    model.setLoadedDate(rsFSC.getString("LOADEDDATE"));
			    if(rsFSC.getString("ONBOARDDATE")!=null && !rsFSC.getString("ONBOARDDATE").equals(""))
			    	model.setBookingSplFlag("B");
			    model.setOnBoardDate(rsFSC.getString("ONBOARDDATE"));
				model.setBlNumber(rsFSC.getString("BLNUM"));
				model.setBookingNo(rsFSC.getString("BOOKINGNO"));
				model.setShippingSplStatus(rsFSC.getString("SHPINGSPLSTS"));
				model.setPortOfLoading(rsFSC.getString("POL"));
				model.setPortOfDischarge(rsFSC.getString("POD"));
				model.setPortOfLoadingDes(rsFSC.getString("POLDES"));
				model.setPortOfDischargeDess(rsFSC.getString("PODDES"));
				list.add(model);
            }
			
			if(list.size()>0) {
				map.put("DATA", list);
				map.put("ERROR_CODE", null);
			}else {
				map.put("DATA", list);
				map.put("ERROR_CODE", "No Record..");
			}
			
			
			return map;
			
		}

		@Override
		public Map getInquiryShippingBtn(EshippingInstructionUim form,String usrId,String orgCode) {
 			Map map=new HashMap();
			EshippingInquiryHeaderMod model= null;
			List<EshippingInquiryHeaderMod> list=null;
			String bookingNo=form.getBookingNo();
			String status=form.getEsiStatusCode();
			String blNo=form.getBlNo();
			String userId =form.getUserName();
			String booking_Query="";
			String status_Query="";
			String user_query="";
			String bl_query="";
		    int tableId=0;
			String HEADER_DTLS;
			String userid=usrId;
			String orgCodes=orgCode;
			
			if(bookingNo!=null && !bookingNo.equals("")) {
				
				String tableCout="select count(*) from ESV_SI_HEADER where fk_booking_no='"+bookingNo+"'";
				tableId=getJdbcTemplate().queryForInt(tableCout);
				if(tableId==0) {
					booking_Query="and  babkno='"+bookingNo+"' ";
				}else {
					booking_Query="and  pk_booking_no='"+bookingNo+"' ";
					if(status==null && status.equals("")) {
					status=" 'E','C','S'";
					}
				}
			}
			
			if(blNo!=null && !blNo.equals("")) {
				bl_query=" and FK_BL_NO ='"+blNo+"'";
				tableId=1;
			}
			
			if(status.equals("S")) {
				status="'S'";
			}else if(status.equals("C")) {
				status="'C'";
			}else if(status.equals("N")) {
				status="'N'";
			}else if(status.equals("E")) {
				status=" 'E'";
			}
			
			if(status!=null && !status.equals("")) {
				status_Query="and esi_status in ("+status+") ";
			}
			
			
			
			
			if((status==null || status.equals("")||status.equals("'N'")) && tableId==0) {
				
				if(userid.equalsIgnoreCase("DEV_TEAM")) {
					user_query=" ";
				}else {
					user_query=" and (BAAUSR =   '"+userid+"' or BABKBY='"+orgCodes+"')";
				}
				
				HEADER_DTLS="select   " + 
						"	TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') as eta   " + 
						"	,TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') as etd   " + 
						"	,'New' as status   " + 
						"	,PK_BOOKING_NO as BOOKINGNO    " + 
						"   , '' as BLNUM " +
						"	,bapol as POL    " + 
						"	,bapoD as POD    " +
						"	,(SELECT PINAME FROM ITP040 WHERE PICODE=bapol) as POLDES  "+	
						"	,(SELECT PINAME FROM ITP040 WHERE PICODE=bapod) as PODDES "+
						" 	,TO_CHAR(TO_DATE(cast(bkg.VESSELETD as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') as VESSELETD "+
						"	,coalesce (esi.SPECIAL_STATUS, ' ' , esi.SPECIAL_STATUS) as SHPINGSPLSTS   " +
						"	,'' as COMFIRMDATE" +
						"	,'' as RECEIVEDDATE"+
						"	,'' as LOADEDDATE"  +
						"	,'' as ONBOARDDATE" +
						"  from   " + 
						"	ESV_WB_EXTEND ewe   " + 
						"inner join SEALINER.BKP001 bkg on   " + 
						"	ewe.pk_booking_no = bkg.babkno   " + 
						"left outer join ESV_SI_HEADER esi on   " + 
						"	ewe.PK_BOOKING_NO = esi.fk_booking_no   " + 
						"	    " + 
						"where   " + 
						"	bkg.bastat in('C') and bkg.babkno NOT IN (select fk_booking_no from ESV_SI_HEADER where esi_status = 'E' or esi_status = 'S')"
						+user_query+ booking_Query;
			}else {
				
				if(userid.equalsIgnoreCase("DEV_TEAM")) {
					user_query=" ";
				}else {
					user_query=" and SUBMIT_BY =   '"+userid+"'";
				}
				
				HEADER_DTLS="select   " + 
						"	TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') as eta,   " + 
						"	TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') as etd,   " + 
						"(CASE when ESI_STATUS ='N' then 'New' when ESI_STATUS = 'C' then 'Confirmed' " + 
						"					 when ESI_STATUS = 'S' then 'Submit' when ESI_STATUS = 'E' then 'Entry' " + 
						"					 END ) as status,   " +
						"	PK_BOOKING_NO as BOOKINGNO   " + 
						"   , fk_bl_no as BLNUM " +
						"	, bapol as POL   " + 
						"	, bapod as POD   " + 
						"	,(SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal=bapol) as POLDES "+	
						"	,(SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal=bapod) as PODDES "+
						" 	,TO_CHAR(TO_DATE(cast(esh.VESSELETD as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') as VESSELETD "+
						"	, coalesce(special_status,' ',special_status) as SHPINGSPLSTS   " + 
						"	,TO_CHAR(TO_DATE(CONFIRM_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as COMFIRMDATE" +
						"	,TO_CHAR(TO_DATE(RECEIVED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as RECEIVEDDATE "+
						"	,TO_CHAR(TO_DATE(LOADED_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as LOADEDDATE "  +
						"	,TO_CHAR(TO_DATE(ON_BOARD_DATE, 'YYYYMMDD'), 'DD/MM/YYYY') as ONBOARDDATE " +
						"  from   " + 
						"	ESV_WB_EXTEND ewe,   " + 
						"	ESV_SI_HEADER esh,   " + 
						"	SEALINER.BKP001   " + 
						"where   " + 
						"	pk_booking_no = fk_booking_no   " + 
						"	and pk_booking_no = babkno   " + 
						"	 "+booking_Query+" "+status_Query+" "+user_query+" "+bl_query;
			}
			
			 
			
			SqlRowSet rsFSC = getNamedParameterJdbcTemplate().queryForRowSet(HEADER_DTLS.toString(), new HashMap());
			list = new ArrayList<EshippingInquiryHeaderMod>();
			while (rsFSC.next()) {
				model = new EshippingInquiryHeaderMod();
				model.setDesiredArrivalDate(rsFSC.getString("eta"));
				model.setSailingDate(rsFSC.getString("etd"));
				model.setStatus(rsFSC.getString("status"));
				
				if(null!=rsFSC.getString("Status") && !rsFSC.getString("Status").equals("")  ) {
					
					form.setEsiStatusCode(rsFSC.getString("Status"));
					
				}
				model.setVesseletd(rsFSC.getString("VESSELETD"));
				model.setConfirmDate(rsFSC.getString("COMFIRMDATE"));
			    model.setResivedDate(rsFSC.getString("RECEIVEDDATE"));
			    model.setLoadedDate(rsFSC.getString("LOADEDDATE"));
			    model.setOnBoardDate(rsFSC.getString("ONBOARDDATE"));
				model.setBlNumber(rsFSC.getString("BLNUM"));
				model.setBookingNo(rsFSC.getString("BOOKINGNO"));
				model.setShippingSplStatus(rsFSC.getString("SHPINGSPLSTS"));
				model.setPortOfLoading(rsFSC.getString("POL"));
				model.setPortOfDischarge(rsFSC.getString("POD"));
				model.setPortOfLoadingDes(rsFSC.getString("POLDES"));
				model.setPortOfDischargeDess(rsFSC.getString("PODDES"));
				list.add(model);
            }
			if(list.size()>0) {
				map.put("DATA", list);
				map.put("ERROR_CODE", null);
			}else {
				map.put("DATA", list);
				map.put("ERROR_CODE", "No Record..");
			}
			return map;
		}
		
		@Override
		public int checkBookingNoAndStatus(Map mapParams) {
			
			return 1;
		}

		@Override
		public String getEsiStatusCodeForValidation(String bookingNo) {
		
			String esiStatus="";
			String CHECK_ESI_STATUS="Select count(*) from ESV_SI_HEADER where FK_BOOKING_NO='"+bookingNo+"'";
			int checkEsiStatus=getJdbcTemplate().queryForInt(CHECK_ESI_STATUS);
			
			if(checkEsiStatus>0) {
				String GET_ESISTATUS="SELECT ESI_STATUS FROM ESV_SI_HEADER WHERE FK_BOOKING_NO='"+bookingNo+"'";
				esiStatus=(String) getJdbcTemplate().queryForObject(GET_ESISTATUS, String.class);
			}else if(checkEsiStatus==0) {
				esiStatus="N";
			}
			
			return esiStatus;
		}

		@Override
		public void cancelBookingDtl(EshippingInstructionUim form) {
			
			Connection connection=null;
			Statement statement=null;
			ResultSet rs = null;
			
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String cuuntDate = dateFormat.format(date); 
			try {	
			connection=(Connection) getJdbcTemplate().getDataSource().getConnection();;
			
			System.out.println("SI cancelation started  ......... ");
			int sqnNoHrd=0;
			String GET_SQN_NO= "select pk_hdr_seqno from ESV_SI_HEADER  WHERE FK_BOOKING_NO='"+form.getBookingNo()+"'";
			statement = connection.createStatement();
			rs = statement.executeQuery(GET_SQN_NO);
			if (rs.next()) {
				sqnNoHrd = rs.getInt("pk_hdr_seqno");
			}
			rs.close();
			statement.close();

			String DELETE_FROM_ESV_SI_HEADER =  "DELETE FROM ESV_SI_HEADER WHERE FK_BOOKING_NO='"+form.getBookingNo()+"'";
		    String REMOVE_FROM_ESV_SI_CON=  "DELETE FROM ESV_SI_CONTAINERS con where con.fk_hdr_seqno="+sqnNoHrd   ;
		    String REOMVE_FROM_ESV_SI_COM=  "DELETE FROM ESV_SI_COMMODITY comm where comm.fk_hdr_seqno="+sqnNoHrd ;
		    String UPDATE_BOOKING_HRD = "UPDATE SEALINER.BKP001 SET BASTAT='C'  " + 
		    		"						   ,BKG_CONFRIM_DATE='"+cuuntDate+"' " + 
		    		"						   ,SPLSTATS='C'  " + 
		    		"						   WHERE BABKNO= '"+form.getBookingNo()+"'";
		    
		    System.out.println("1 DELETE_FROM_ESV_SI_HEADER " + DELETE_FROM_ESV_SI_HEADER);
			statement = connection.createStatement();
			int row = statement.executeUpdate(DELETE_FROM_ESV_SI_HEADER);
			statement.close();
			
			System.out.println("2 REMOVE_FROM_ESV_SI_CON " + REMOVE_FROM_ESV_SI_CON);
			statement = connection.createStatement();
			row = statement.executeUpdate(REMOVE_FROM_ESV_SI_CON);
			statement.close();
			
			System.out.println("3 REOMVE_FROM_ESV_SI_COM " + REOMVE_FROM_ESV_SI_COM);
			statement = connection.createStatement();
			row = statement.executeUpdate(REOMVE_FROM_ESV_SI_COM);
			statement.close();
			
			System.out.println("4 UPDATE_BOOKING_HRD " + UPDATE_BOOKING_HRD);
			statement = connection.createStatement();
			row = statement.executeUpdate(UPDATE_BOOKING_HRD);
			statement.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void getRatChargeDtls(EshippingInstructionUim objForm, Map mapParams) {
			// TODO Auto-generated method stub
			
			String QUERY_REVENUE=" SELECT ESH.FK_BL_NO AS BLNO,ESH.FK_BOOKING_NO as BOOKINGNO,DN_FRT_SUR_CODE AS CHARGECODE,RATE ,AMOUNT, "
					+ " AMOUNT_CURR,RATE_BASIS,DESC_CHARGE_CODE AS DESCCHAREGCODE "
					+ " FROM BL_REVENUE BR "
					+ " INNER JOIN ESV_SI_HEADER ESH ON BR.FK_BL_NO=ESH.FK_BL_NO "
					+ " WHERE ESH.FK_BOOKING_NO ='"+mapParams.get("P_I_V_BKG_NO")+"'";
			
		List<BlRevenueMod>	list=getJdbcTemplate().query(QUERY_REVENUE,new BlRevenueData());
		
		objForm.setRevinue(list);
		
		}

	    public class BlRevenueData extends JdbcRowMapper{

	        public BlRevenueMod mapRow(ResultSet rs, int row) throws SQLException{
	            
	        	BlRevenueMod mod=new BlRevenueMod();
	        	
	        	mod.setAmount(rs.getString("AMOUNT"));
	        	mod.setBasis(rs.getString("RATE_BASIS"));
	        	mod.setChargeCode(rs.getString("CHARGECODE"));
	        	mod.setCurrency(rs.getString("AMOUNT_CURR"));
	        	mod.setDescreiptionCharegCode(rs.getString("DESCCHAREGCODE"));
	        	mod.setRate(rs.getString("RATE"));
	        	mod.setBlNo(rs.getString("BLNO"));
	        	mod.setBookingNo(rs.getString("BOOKINGNO"));
	           
	        	return mod;
	        }
	    }

		@Override
		public void getMailDtls(EshippingInstructionUim form,String userid) {
			Connection connection;
			Statement stm = null;
			ResultSet rs = null;
			int index=0;
			String volume_temp="";
			String GET_COMPANY_NAME = "Select  company_name,user_name  from esm_user_login l where user_id='"+userid+"'";
			String GET_BOOKING_PARTY="Select company_name from  esm_user_login l where org_code = " + 
					"(select " + 
					"	BNCSCD as booking_org " + 
					"from " + 
					"SEALINER.BKP030 b  " + 
					"where " + 
					"	bnbkno = '"+form.getBookingNo()+"' " + 
					"	and bncstp = 'O') and company_name is not null limit  1 ";
			String GET_CONTRACT_PARTY="Select company_name from  esm_user_login l where org_code = " + 
					"(select " + 
					"	BABKBY as booking_org " + 
					"from " + 
					"SEALINER.BKP001 b  " + 
					"where " + 
					"	babkno = '"+form.getBookingNo()+"') and company_name is not null limit  1 ";
			String GET_VOLUME_QUERY="select eq_type,eq_size,full_qty,special_handling from SEALINER.BOOKING_SUPPLIER_DETAIL where booking_no='"+form.getBookingNo()+"' ";
			try {
				 connection =getJdbcTemplate().getDataSource().getConnection();
				 stm = connection.createStatement();
				 rs = stm.executeQuery(GET_BOOKING_PARTY);
				 if(rs.next()) {
				     form.setBookingPartyCompany(rs.getString("company_name"));
					}
				 stm.close();
				 rs.close();
				 
				 stm = connection.createStatement();
				 rs = stm.executeQuery(GET_CONTRACT_PARTY);
				 if(rs.next()) {
					 form.setContractPartyCompany(rs.getString("company_name"));
					}
				 stm.close();
				 rs.close();
				 
				 stm = connection.createStatement();
				 rs = stm.executeQuery(GET_COMPANY_NAME);
				 if(rs.next()) {
					 form.setCustomerCompany(rs.getString("company_name"));
					 form.setCustomerName(rs.getString("user_name"));
					}
				 stm.close();
				 rs.close();
				 
				 stm = connection.createStatement();
				 rs = stm.executeQuery(GET_VOLUME_QUERY);
				 while(rs.next()) {
					 index++;
					 String cargtype="";
					 if(rs.getString("special_handling").equals("N")) {
				        	cargtype="Normal";
				        }else if(rs.getString("special_handling").equals("NR")){
				        	cargtype="Non-Reefer";
				        }else if(rs.getString("special_handling").equals("O0")){
				        	cargtype="OOG";
				        }else if(rs.getString("special_handling").equals("OD")){
				        	cargtype="Open Door";
				        }else if(rs.getString("special_handling").equals("D1")){
				        	cargtype="DG";
				        }else if(rs.getString("special_handling").equals("DA")){
				        	cargtype="Door Ajar";
				        }
					 if(index==1)
						 volume_temp= rs.getString("eq_size")+""+rs.getString("eq_type")+" X "+rs.getString("full_qty")+" (Laden-"+cargtype+")";
					 else 
						 volume_temp= volume_temp +" & "+rs.getString("eq_size")+""+rs.getString("eq_type")+" X "+rs.getString("full_qty")+" (Laden-"+cargtype+")";	 
				 }
				 stm.close();
				 rs.close();
				 form.setVolume(volume_temp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		@Override
		public void getSailingDate(EshippingInstructionUim objForm, Map mapParams) {
		try {	 
			String QUERY_REVENUE=" SELECT TO_CHAR(TO_DATE(cast(EXPECTED_SAILING_DATE as VARCHAR), 'YYYY-MM-DD'), 'DD/MM/YYYY') "
					+ " FROM ESV_WB_EXTEND  "
					+ " WHERE  pk_booking_no ='"+mapParams.get("P_I_V_BKG_NO")+"' limit 1";
			
		String date= (String) getJdbcTemplate().queryForObject(QUERY_REVENUE,Object.class);
		
		objForm.setSailinDate(date); 
		}catch (Exception e) {
			System.out.println("No data Exception.");
			objForm.setSailinDate(""); 
		}	
		}

		@Override
		public String checkSiEditFlag(String bookingNo) {
			System.out.println("checkSiEditFlaf() called....."+bookingNo); 
			
			String CHECK_EDI_FLAG="select edit_falg from ESV_SI_HEADER where fk_booking_no='"+bookingNo+"'";
			System.out.println("query "+CHECK_EDI_FLAG);
			String flag=(String) getJdbcTemplate().queryForObject(CHECK_EDI_FLAG, Object.class);
			
			return flag;
		}

		@Override
		public String getBookingPartyFromCamCustomer(EshippingInstructionUim form) {

			String GET_BOOKING_PARTY="SELECT CUSTOMER_NAME FROM CAM_CUSTOMER WHERE PK_CUSTOMER_CODE='"+form.getShipperCode()+"'";
			String orgCode=(String) getJdbcTemplate().queryForObject(GET_BOOKING_PARTY, Object.class);
			return orgCode;
			
		}

		@Override
		public void setRoutingDtls(EshippingInstructionUim objForm, Map mapParams) {
			 
			String query="select vessel_name,vessel_no,voyage from route_dtl_booking where  booking_no='"+mapParams.get("P_I_V_BKG_NO")+"'";
			
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
		public class GetContainerRowMapper extends JdbcRowMapper{

			@Override
			public Object mapRow(ResultSet rs, int row) throws SQLException {
				BookingConatineVo bookingConatinerVo=new BookingConatineVo();
				
				bookingConatinerVo.setConatiner(rs.getString("container"));
				bookingConatinerVo.setCarrierSealVin(rs.getString("csv"));
				bookingConatinerVo.setShipperSeal(rs.getString("ss"));
				bookingConatinerVo.setWeight(rs.getString("met_weight"));
				bookingConatinerVo.setMetMeasurement(rs.getString("GROSS_CARGO_MMT"));
				return bookingConatinerVo;
			}
			
		}
		
		@Override
		public String getRepresentCompName(String bookingNo) {

			String orgCode="Select CUSTOMER_NAME  from SEALINER.BKP001 a INNER JOIN CAM_CUSTOMER  b on a.babkby=b.PK_CUSTOMER_CODE where a.babkno='"+bookingNo+"'";
			String company=(String) getJdbcTemplate().queryForObject(orgCode, Object.class);
			return company;
		}

		@Override
		public Map<String,String> getValidateConatinerNos(String containerArrayJson) {
			
			String conatiner[]=containerArrayJson.split(",");
			Map map=new HashMap<String, String >();
			for(int i=0;i<conatiner.length;i++) {
				String CONTAINR_CHECK="select count(*) from coc_active where eq_no='"+conatiner[i]+"'";
				int count = getJdbcTemplate().queryForInt(CONTAINR_CHECK);
				if(count>0)
				map.put(conatiner[i], "A");
				else
				map.put(conatiner[i], "NA");	
			}
			
			return map;
		}

		@Override
		public void checkConatinerNoInBookingTbl(EshippingInstructionUim form) {

			for(int i=0;i<form.getCargoDescriptionDetails().size();i++) {
				if(form.getCargoDescriptionDetails().get(i).getEditFlag().equals("N")) {
					int containerCount=0;	
					String CONTAINER_AVL_QUERY="SELECT count(*) from BKG_EQUIPMENT where bibkno='"+form.getBookingNo()+"' and bictrn='"+form.getCargoDescriptionDetails().get(i).getContainerNo()+"'";
					
					containerCount= getJdbcTemplate().queryForInt(CONTAINER_AVL_QUERY);
					if(containerCount==0) {
						form.getCargoDescriptionDetails().get(i).setContainerNo("");
					}
				}else {
					form.getCargoDescriptionDetails().get(i).setContainerNo("");
				}
			}
		}

		@Override
		public boolean checkBookingStatus(String bookingNo) {
			
				String CHECK_BOOKING_STATUS="select BASTAT from SEALINER.BKP001 WHERE babkno='"+bookingNo+"'";
				
				String result= (String) getJdbcTemplate().queryForObject(CHECK_BOOKING_STATUS, Object.class);
				
				if(result.equals("C") || result.equals("E")) {
					return true;
				}else {			
					return false;
				}
		}

		@Override
		public void getFirstLegVesselDtl(EshippingInstructionUim objForm) {
			 
		String query="select vessel_name,vessel_no,voyage from route_dtl_booking where booking_no='"+objForm.getBookingNo()+"' and <> 'TBA'  limit 1  ";
			getJdbcTemplate().query(query, new VesselDtlRowMapper(objForm));
		}
		
		 public class VesselDtlRowMapper extends JdbcRowMapper{

			EshippingInstructionUim objForm; 
			 
			public VesselDtlRowMapper(EshippingInstructionUim objForm) {
				this.objForm=objForm;
			}

			@Override
			public Object mapRow(ResultSet rs, int row) throws SQLException {
				 
				objForm.setVessel1(rs.getString("vessel_name"));
				objForm.setVesselNo1(rs.getString("vessel_no"));
				objForm.setVoyage1(rs.getString("voyage"));
				
				return null;
			}
		 
		 }

		
}
//    /**
//     * 
//     * This method for set data shipment detail.
//     * 
//     * @exception BusinessException and DataAccessException
//     * @param mapParams List of parameters in
//     */
//    public Map findShipmentDetails(Map mapParams) throws BusinessException, DataAccessException{
//        Map resultMap = null;
//    
//        JdbcStoredProcedure storeProcedure = null;
//        
//        String[][] arrParam = null;
//        String errorMsg = null;
//        try{
//            if(mapParams != null && !mapParams.isEmpty()){
//                arrParam = new String[][]{
//                    { P_O_V.REF_CURSOR_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK }, 
//                    { P_I_V.MODE, BLANK + ORACLE_VARCHAR, PARAM_IN, ((String)mapParams.get(P_I_V.MODE)) },
//                    { P_I_V.LOGIN_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, ((String)mapParams.get(KEY_USER_ID))}, 
//                    { P_I_V.BL_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String)mapParams.get(P_I_V.BL_NO)},
//                    { P_I_V.BKG_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, (String)mapParams.get(P_I_V.BKG_NO)} 
//                };   
//                
//                storeProcedure = getStoreProcedure(PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_SHIPMENT_DTL, new ShipmentDetailsRowMapper(), arrParam);
//                if(storeProcedure != null){
//                    resultMap = storeProcedure.execute();
//                    if(resultMap == null || resultMap.isEmpty()){
//                        errorMsg = "Result is null.";
//                    }
//                }else{
//                    errorMsg = "Can not get connection to store procedure.";
//                }
//            }else{
//                errorMsg = "No paramameter input.";
//            }
//        }catch(Exception ex){
//            errorMsg = ex.getMessage();
//            ex.printStackTrace();
//        }finally{
//            if(resultMap == null){
//                resultMap = new HashMap();
//            }
//            if(errorMsg != null && !BLANK.equals(errorMsg)){
//                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
//                resultMap.put(P_O_V.ERR_DESC, errorMsg);
//            }
//        }
//        return resultMap;
//    }
//    //    @09 END    
//    public class ShipmentDetailsRowMapper extends JdbcRowMapper {    
//        /**
//         * 
//         * This mothod for set data to shipment detail in each row.
//         * 
//         * @exception SQLException
//         * @param rs List of shipment detail
//         * @param row Row of shipment detail
//         */
//        public Object mapRow(ResultSet rs, int row) throws SQLException {
//            EshippingShipmentDetailsMod mod = new EshippingShipmentDetailsMod();
//            mod.setBookingNo(rs.getString(1));
//            mod.setContact(rs.getString(2));
//            mod.setEmail(rs.getString(3));
//            mod.setTelephone(rs.getString(4));
//            mod.setFax(rs.getString(5));
//            mod.setSubmittedBy(rs.getString(6));
//            mod.setBlNumber(rs.getString(7));
//            mod.setBlType(rs.getString(9));
//            mod.setAdditionalEmail(rs.getString(10));
//            mod.setNoOfOriginal(rs.getString(11));
//            mod.setRemarks(rs.getString(12));
//            mod.setChoiceRad(rs.getString(13));
//    //            mod.setStatus(rs.getString(8));
//            mod.setEsiStatusDesc(rs.getString(8));
//            mod.setEsiStatusCode(rs.getString(14));
//            return mod;
//        }    
//    }
//            
//    private JdbcStoredProcedure getStoreProcedure(String procName, JdbcRowMapper rowMapper, String[][] arrParam) {
//        JdbcStoredProcedure storeProcedure = null;
//        try{
//            if(rowMapper != null){
//                if(arrParam != null){
//                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper, arrParam);
//                }else{
//                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper);
//                }
//            }else{
//                if(arrParam != null){
//                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, arrParam);
//                }else{
//                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName);
//                }
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return storeProcedure;
//    }

