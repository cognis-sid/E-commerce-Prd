 /*------------------------------------------------------
 EshippingInstructionDao.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Anurak Thanapradit 05/07/13
 - Change Log -------------------------------------------
 ## DD/MM/YY 	–User- 		-TaskRef- -ShortDescription-
 ## 17/07/2013                 01       add P_O_V_MODE
 ## 19/08/2013                 02       change package name
 ## 20/08/2013                 03       add CONFIG_DATE and function getValueToConfigDate
 ## 20/08/2013                 04       add P_I_V_SHIPPER for booking popup
 ## 23/08/2013                 05       add commodity
 ## 27/08/2013   YOSSUN1       06       change store for get commodity
 ## 31/10/2013   YOSSUN1       07       add process for esi submission.
 ## 12/12/2013   YOSSUN1       08       add ESI Status constant.
 ## 26/12/2013   YOSSUN1       09         
 ## 10/09/2014   PRATYA        10       PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
 ## 23/08/2019	 Sarawut A.	   17		Add method validate data change, PRR_ESI_VAL_DATA_CHANGE, VALIDATE_RESULT
 ## 26/08/2019	 Sarawut A.	   18		Add method clear ESI data, PRR_ESI_CLEAR_ESI_DATA
 ## 18/10/2019	 Sarawut A.	   19		Add fields vessel no, pol no, pod no for save method
 ------------------------------------------------------*/

 package com.rclgroup.dolphin.rcl.web.eservice.dao;

 import com.niit.control.common.exception.BusinessException;

 import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.CustomerMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingContactDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingRoutingDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingShipmentDetailsMod;

import java.util.List;
import java.util.Map;
 import org.springframework.dao.DataAccessException;
//===================================================================
//OLD VERSION
//===================================================================
 public interface EshippingInstructionDao {
 //    @09 BEGIN
    public static final String DAO_NAME                             = "EshippingInstructionDao";
    public static final String DAO_NAME_COMMODITY                   = "EshippingCommodityPopupDao";
    public static final String EXCEPTION                            = "EXCEPTION";
    
    /*Begin @10*/
    public static final String ADD_OPERATION                        = "ADD";
    public static final String UPD_OPERATION                        = "UPD";
    public static final String DEL_OPERATION                        = "DEL";
    /*End @10*/
    
    public interface STATUS_ESI_KEY{                
        public final String N = "N";
        public final String I = "E";
        public final String S = "S";
    }
    
    public interface STATUS_ESI_LABEL{
        public final String NEW = "NEW";
        public final String IN_PROGRESS = "Entry";
        public final String SUBMITTED = "SUBMITTED";
    }
     
     public interface PCR_ESV_SI_MAIN{
         public final String PACKAGE_NAME = "PCR_ESV_SI_MAIN";
         public final String PRR_ERCL_GET_ESI_SHIPMENT_DTL = PACKAGE_NAME+".PRR_ERCL_GET_ESI_SHIPMENT_DTL";
         public final String PRR_ERCL_GET_ESI_CONTACT_DTL = PACKAGE_NAME+".PRR_ERCL_GET_ESI_CONTACT_DTL";
         public final String PRR_ERCL_GET_ESI_BOOKING_POPUP = PACKAGE_NAME+".PRR_ERCL_GET_ESI_BOOKING_POPUP";
         public final String PRR_ERCL_GET_ESI_ROUTING_DTL = PACKAGE_NAME+".PRR_ERCL_GET_ESI_ROUTING_DTL";
         public final String PRR_ERCL_GET_ESI_EQUIPMENT_DTL = PACKAGE_NAME+".PRR_ERCL_GET_ESI_EQUIPMENT_DTL";
         public final String PRR_ERCL_GET_ESI_CNTRTYPE_DDL = PACKAGE_NAME+".PRR_ERCL_GET_ESI_CNTRTYPE_DDL";
         public final String PRR_ERCL_GET_ESI_PACKAGE_POPUP = PACKAGE_NAME+".PRR_ERCL_GET_ESI_PACKAGE_POPUP";
         public final String PRR_ERCL_INS_ESI_COMMODITY = PACKAGE_NAME+".PRR_ERCL_INS_ESI_COMMODITY";
         public final String PRR_ERCL_GET_ESI_COMM_DETAILS = PACKAGE_NAME+".PRR_ERCL_GET_ESI_COMM_DETAILS";
         //    public final String SQL_GET_COMMODITY_TYPE = PACKAGE_NAME+".PRR_ERCL_GET_ESI_COMMODITY";
         public final String PRR_ERCL_GET_ESI_CARGO_MARK_NO = PACKAGE_NAME+".PRR_ERCL_GET_ESI_CARGO_MARK_NO";
         public final String PRR_ERCL_GET_ESI_ACK_POPUP = PACKAGE_NAME+".PRR_ERCL_GET_ESI_ACK_POPUP";
         public final String PRR_ERCL_INS_ESI_SHIPMENT_HDR = PACKAGE_NAME+".PRR_ERCL_INS_ESI_SHIPMENT_HDR";
         public final String PRR_ERCL_INS_ESI_CONTAINERS = PACKAGE_NAME+".PRR_ERCL_INS_ESI_CONTAINERS";
         public final String PRR_ERCL_ESI_SUBMIT_SI = PACKAGE_NAME+".PRR_ERCL_ESI_SUBMIT_SI";
         public final String PRR_ERCL_GET_ESI_BL_NO = PACKAGE_NAME+".PRR_ERCL_GET_ESI_BL_NO";
         public final String PRR_ESI_CHECK_EXIST_CNTR = PACKAGE_NAME+".PRR_ESI_CHECK_EXIST_CNTR";
         public final String PRR_ESI_VAL_DATA_CHANGE = PACKAGE_NAME+".PRR_ESI_VAL_DATA_CHANGE";
         public final String PRR_ESI_CLEAR_ESI_DATA = PACKAGE_NAME+".PRR_ESI_CLEAR_DATA";
     }
     
     public interface PCE_ENOTICE_ESI_SUBMISSION{
         public final String PACKAGE_NAME = "PCE_ENOTICE_ESI_SUBMISSION";
         public final String PPRE_RAISE_ENOTICE_ESI = PACKAGE_NAME+".PPRE_RAISE_ENOTICE_ESI";
     }
     
     public interface P_I_V{
         public final String LOGIN_ID                   = "P_I_V_LOGIN_ID";
         public final String BL_NO                      = "P_I_V_BL_NO";
         public final String BKG_NO                     = "P_I_V_BKG_NO";
         public final String BOOKING_NO                 = "P_I_V_BOOKING_NO";
         public final String VESSEL                     = "P_I_V_VESSEL";
         public final String VESSEL_NO                  = "P_I_V_VESSEL_NO";
         public final String VOYAGE                     = "P_I_V_VOYAGE";
         public final String POL                        = "P_I_V_POL";
         public final String POD                        = "P_I_V_POD";
         public final String STATUS                     = "P_I_V_ESI_STATUS";
         public final String REC_START                  = "P_I_V_RECORD_START";
         public final String REC_END                    = "P_I_V_RECORD_END";
         public final String MODE                       = "P_I_V_MODE";
         public final String PKG_NAME                   = "P_I_V_NAME";
         public final String PKG_CODE                   = "P_I_V_CODE";
         public final String ARCHE_TYPE                 = "P_I_V_BL_ARCHETYPE";
         public final String BL_TYPE                    = "P_I_V_BL_TYPE";
         public final String SUBMIT_BY                  = "P_I_V_SUBMIT_BY";
         public final String CONTACT                    = "P_I_V_CONTACT";
         public final String EMAIL                      = "P_I_V_EMAIL";
         public final String ADD_EMAILS                 = "P_I_V_ADD_EMAILS";
         public final String PHONE                      = "P_I_V_PHONE";
         public final String FAX                        = "P_I_V_FAX";
         public final String SHIPPER_CODE               = "P_I_V_DN_SHIPPER_CODE";
         public final String SHIPPER_NAME               = "P_I_V_SHIPPER_NAME";
         public final String SHIPPER_ADD1               = "P_I_V_SHIPPER_ADD1";
         public final String SHIPPER_ADD2               = "P_I_V_SHIPPER_ADD2";
         public final String SHIPPER_ADD3               = "P_I_V_SHIPPER_ADD3";
         public final String SHIPPER_ADD4               = "P_I_V_SHIPPER_ADD4";
         public final String CNEE_CODE                  = "P_I_V_DN_CNEE_CODE";
         public final String CNEE_NAME                  = "P_I_V_CNEE_NAME";
         public final String CNEE_ADD1                  = "P_I_V_CNEE_ADD1";
         public final String CNEE_ADD2                  = "P_I_V_CNEE_ADD2";
         public final String CNEE_ADD3                  = "P_I_V_CNEE_ADD3";
         public final String CNEE_ADD4                  = "P_I_V_CNEE_ADD4";
         public final String NTFY_CODE                  = "P_I_V_DN_NTFY_CODE";
         public final String NTFY_NAME                  = "P_I_V_NTFY_NAME";
         public final String NTFY_ADD1                  = "P_I_V_NTFY_ADD1";
         public final String NTFY_ADD2                  = "P_I_V_NTFY_ADD2";
         public final String NTFY_ADD3                  = "P_I_V_NTFY_ADD3";
         public final String NTFY_ADD4                  = "P_I_V_NTFY_ADD4";
         public final String ISSUE_PLACE_NAME           = "P_I_V_BL_ISSUE_PLACE_NAME";
         public final String POL_NAME                   = "P_I_V_POL_NAME";
         public final String POD_NAME                   = "P_I_V_POD_NAME";
         public final String POL_NO                     = "P_I_V_POL_NO";
         public final String POD_NO                     = "P_I_V_POD_NO";
         public final String PLR_NAME                   = "P_I_V_PLR_NAME";
         public final String PLD_NAME                   = "P_I_V_PLD_NAME";
         public final String ORG_BL_COUNT               = "P_I_V_ORG_BL_COUNT";
         public final String MARKS_NO                   = "P_I_V_COMM_LVL_MARKS_NO";
         public final String DESC                       = "P_I_V_COMM_LVL_DESC";
         public final String REMARK                     = "P_I_V_REMARK";
         public final String FSC                        = "P_I_V_FSC";
         public final String SCREEN_SEQNO               = "P_I_V_SCREEN_SEQNO";
         public final String DN_EQ_NO                   = "P_I_V_DN_EQUIPMENT_NO";
         public final String EQ_NO_SOURCE               = "P_I_V_EQUPMENT_NO_SOURCE";
         public final String LADEN_MT                   = "P_I_V_LADEN_MT";
         public final String DN_EQ_SIZE                 = "P_I_V_DN_EQ_SIZE";
         public final String DN_EQ_TYPE                 = "P_I_V_DN_EQ_TYPE";
         public final String GROSS_CARGO_WEIGHT         = "P_I_V_GROSS_CARGO_WEIGHT";
         public final String GROSS_CARGO_MSMT           = "P_I_V_GROSS_CARGO_MSMT";
         public final String CARRIER_SEAL               = "P_I_V_CARRIER_SEAL";
         public final String SHIPPER_SEAL               = "P_I_V_SHIPPER_SEAL";
         public final String NO_OF_PACKAGES             = "P_I_V_NO_OF_PACKAGES";
         public final String DN_PACKAGE_KIND_CODE       = "P_I_V_DN_PACKAGE_KIND_CODE";
         public final String PK_DTL_SEQNO               = "P_I_V_PK_DTL_SEQNO";
         public final String FK_BKG_EQUIPM_DTL          = "P_I_V_FK_BKG_EQUIPM_DTL";
         public final String FK_BKG_SUPPLIER            = "P_I_V_FK_BKG_SUPPLIER";
         public final String FK_BKG_SIZE_TYPE_DTL       = "P_I_V_FK_BKG_SIZE_TYPE_DTL";
         public final String SHIPPER_NAME_POPUP         = "P_I_V_SHIPPER";   
         public final String COMMODITY_CODE             = "P_I_V_DN_COMMODITY_CODE";
         public final String DN_COMMODITY               = "P_I_V_DN_COMMODITY";
         public final String PK_SEQNO                   = "P_I_V_PK_SEQNO";
         public final String WEIGHT                     = "P_I_V_WEIGHT";
         public final String CNTR                       = "P_I_V_CNTR";
         public final String TOT_PACKAGE                = "P_I_V_TOT_PACKAGE";
         public final String TOT_PACKAGE_KIND           = "P_I_V_TOT_PACKAGE_KIND";
         public final String TOT_MEASUREMENT            = "P_I_V_TOT_MEASUREMENT";
         
         /*Begin @10*/
         public final String COMM_LVL_MARKS_NO          = "P_I_V_COMM_LVL_MARKS_NO";
         public final String COMM_LVL_DESC              = "P_I_V_COMM_LVL_DESC";
         /*End @10*/
     }
     
     public interface P_O_V{
         public final String REF_CURSOR_DATA = "P_O_V_HDR_DATA";
         public final String REF_CURSOR_DTL_DATA = "P_O_V_DTL_DATA";
         public final String OUT_BL_NO  = "P_O_V_BL_NO";
         public final String OUT_MODE  = "P_O_V_MODE";
         public final String CREATED_FLAG  = "P_O_V_BL_CREATED_FLAG";
         public final String TOTAL_ROW  = "P_O_V_TOTAL_ROW";
         public final String ERR_CD  = "P_O_V_ERR_CD";
         public final String ERR_DESC  = "P_O_V_ERR_DESC";
         public final String PK_DTL_SEQNO_OUT = "P_O_V_PK_DTL_SEQNO";
         public final String EXIST = "P_O_V_EXIST";
         public final String VALIDATE_RESULT = "P_O_V_RESULT";
     }
 //    @09 END
 //     @08 BEGIN
     public interface ESI_STATUS{
         public final String NEW = "N";
         public final String IN_PROGRESS = "E";
         public final String SUBMITTED = "S";
     }
 //     @08 END
     //@02 BEGIN
     // Package Store Procedure
 //    public static final String SQL_GET_SHIPMENT_DETAIL = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_SHIPMENT_DTL";
 //    public static final String SQL_GET_CONTACT_DETAIL = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_CONTACT_DTL";
 //    public static final String SQL_GET_ESI_BOOKING_POPUP = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_BOOKING_POPUP";
 //    public static final String SQL_GET_ROUTING_DETAIL = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_ROUTING_DTL";
 //    public static final String SQL_GET_EQUIPMENT_DETAIL = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_EQUIPMENT_DTL";
 //    public static final String SQL_GET_CONTAINER_TYPE = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_CNTRTYPE_DDL";
 //    public static final String SQL_GET_PACKAGE_KIND_TYPE = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_PACKAGE_POPUP";
 //@06 BEGIN
 //    public static final String SQL_INSERT_COMMODITY = "PCR_ESV_SI_MAIN.PRR_ERCL_INS_ESI_COMMODITY";
 //    public static final String SQL_GET_COMMODITY_TYPE = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_COMM_DETAILS";
 //    //public static final String SQL_GET_COMMODITY_TYPE = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_COMMODITY";
 //@06 END
 //    public static final String SQL_GET_CARGO_MARK = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_CARGO_MARK_NO";
 //    public static final String SQL_GET_ACKNOWLEDGEMENT_DETAIL = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_ACK_POPUP";
 //    public static final String SQL_INSERT_SHIPMENT_HDR = "PCR_ESV_SI_MAIN.PRR_ERCL_INS_ESI_SHIPMENT_HDR";
 //    public static final String SQL_INSERT_CONTAINER_DETAIL = "PCR_ESV_SI_MAIN.PRR_ERCL_INS_ESI_CONTAINERS";
 //    public static final String SQL_SUBMIT_ESI = "PCR_ESV_SI_MAIN.PRR_ERCL_ESI_SUBMIT_SI";
 //    public static final String SQL_GET_BL_NO = "PCE_ENOTICE_ESI_SUBMISSION.PPRE_RAISE_ENOTICE_ESI";
     //@02 END
 //    @07 BEGIN 
 //    public static final String SQL_ESI_SUBMISSION = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_BL_NO";
 //    @07 END
     //@05 BEGIN
 //     public static final String SQL_GET_COMMODITY_LIST = "PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_COMM_DETAILS";  
     //@05 END
     
     //  Column name dropdown : [column] & column name in jsp page
     public static final String KEY_COLUMN_SHOW_CUSTOMER_CODE = "Customer Code";
     public static final String KEY_COLUMN_SHOW_CUSTOMER_NAME = "Customer Name";
     public static final String KEY_COLUMN_SHOW_COUNTRY = "Country";
     public static final String KEY_COLUMN_SHOW_BOOKING_DATE = "Booking Date";
     public static final String KEY_COLUMN_SHOW_BOOKING_NO = "Booking No";
     //@04 BEGIN
      public static final String KEY_COLUMN_SHOW_SHIPPER_NAME = "Shipper name";
     //@04 END
     public static final String KEY_COLUMN_SHOW_LEG_VESSEL = "1stLeg Vessel";
     public static final String KEY_COLUMN_SHOW_LEG_VOYAGE = "1stLeg Voyage";
     public static final String KEY_COLUMN_SHOW_POL = "Port of Loading";
     public static final String KEY_COLUMN_SHOW_POD = "Port of Discharge";
     public static final String KEY_COLUMN_SHOW_STATUS = "eSI Status";
     public static final String KEY_COLUMN_SHOW_BL_NO = "B/L No.";
     public static final String KEY_COLUMN_SHOW_ORDER_ASC = "Ascending";
     public static final String KEY_COLUMN_SHOW_ORDER_DESC = "Descending";  
     public static final String KEY_COLUMN_SHOW_PKG_CODE = "Package Code";
     public static final String KEY_COLUMN_SHOW_PKG_NAME = "Package Name";
     
     //  Value of dropdown : [column] in jsp page
//     public static final String KEY_COLUMN_CUSTOMER_CODE = "cucust";
//     public static final String KEY_COLUMN_CUSTOMER_NAME = "cuname";
//     public static final String KEY_COLUMN_COUNTRY = "(select SCNAME from ITP030 where SCCODE = cucoun)";
//     public static final String KEY_COLUMN_BOOKING_DATE = "BOOKING_DATE";
     public static final String KEY_COLUMN_BOOKING_NO = "BOOKING_NO";
//     //@04 BEGIN
//     public static final String KEY_COLUMN_SHIPPER_NAME = "Shipper";
//     //@04 END
//     public static final String KEY_COLUMN_LEG_VESSEL = "VESSEL";
//     public static final String KEY_COLUMN_LEG_VOYAGE = "VOYAGE";
//     public static final String KEY_COLUMN_POL = "POL";
//     public static final String KEY_COLUMN_POD = "POD";
//     public static final String KEY_COLUMN_BOOKING_STATUS = "BASTAT";
     public static final String KEY_COLUMN_BL_NO = "BL_NO";
//     public static final String KEY_COLUMN_ORDER_ASC = "asc";
//     public static final String KEY_COLUMN_ORDER_DESC = "desc";
//     public static final String KEY_COLUMN_PKG_CODE = "PACKAGE_CODE";
//     public static final String KEY_COLUMN_PKG_NAME = "PACKAGE_NAME";
     public static final String KEY_COLUMN_LADEN = "LADEN";
     public static final String KEY_COLUMN_EMPTY = "EMPTY";

//     public static final String KEY_COLUMN_NEW = "N";
     public static final String KEY_COLUMN_IN_PROGRESS = "E";
//     public static final String KEY_COLUMN_SUBMITTED = "S";
//     
//     public static final String KEY_COLUMN_SHOW_NEW = "NEW";
//     public static final String KEY_COLUMN_SHOW_IN_PROGRESS = "IN PROGRESS";
//     public static final String KEY_COLUMN_SHOW_SUBMITTED = "SUBMITTED";
     
     //  Criteria in jsp page
     public static final String KEY_CRITERIA_TEXT_FIND = "TEXT";
     public static final String KEY_CRITERIA_COLUMN = "COLUMN";
     public static final String KEY_CRITERIA_SORTBY = "SORTBY";
     public static final String KEY_CRITERIA_ORDER = "ORDER";
     public static final String KEY_CRITERIA_STATUS = "STATUS";
     public static final String KEY_CRITERIA_WILDCARD = "WILDCARD";
     public static final String KEY_FROM_RECORD = "fromRecord";
     public static final String KEY_TO_RECORD = "toRecord";
     public static final String KEY_ORG_CODE = "orgCode";
     public static final String KEY_COC_SOC = "cocSoc";
     //@03 BEGIN
     public static final String KEY_CONFIG_DATE = "configDate";
     //@03 END
     public static final String KEY_FLAG_SHIPPER = "S";
     public static final String KEY_FLAG_CONSIGNEE = "C";
     public static final String KEY_FLAG_NOTIFY_PART = "N";
     
     public static final String KEY_STATUS_INSERT = "I";
     public static final String KEY_STATUS_UPDATE = "U";
     public static final String KEY_STATUS_DELETE = "D";
     
     //  Key for keep data in Map
     public static final String KEY_DATA         = "DATA";
     
     public static final String KEY_IS_SUCCESS = "IS_SUCCESS";
 //    public static final String KEY_LOGIN_ID  = "P_I_V_LOGIN_ID";
 //    public static final String KEY_BL_NO  = "P_I_V_BL_NO";
 //    public static final String KEY_BKG_NO  = "P_I_V_BKG_NO";
 //    public static final String KEY_BOOKING_NO  = "P_I_V_BOOKING_NO";
 //    public static final String KEY_VESSEL  = "P_I_V_VESSEL";
 //    public static final String KEY_VOYAGE  = "P_I_V_VOYAGE";
 //    public static final String KEY_POL  = "P_I_V_POL";
 //    public static final String KEY_POD  = "P_I_V_POD";
 //    public static final String KEY_STATUS  = "P_I_V_ESI_STATUS";
 //    public static final String KEY_REC_START  = "P_I_V_RECORD_START";
 //    public static final String KEY_REC_END  = "P_I_V_RECORD_END";
 //    public static final String KEY_MODE  = "P_I_V_MODE";
 //    public static final String KEY_PKG_NAME  = "P_I_V_NAME";
 //    public static final String KEY_PKG_CODE  = "P_I_V_CODE";
 //    public static final String KEY_ARCHE_TYPE  = "P_I_V_BL_ARCHETYPE";
 //    public static final String KEY_BL_TYPE  = "P_I_V_BL_TYPE";
 //    public static final String KEY_SUBMIT_BY  = "P_I_V_SUBMIT_BY";
 //    public static final String KEY_CONTACT  = "P_I_V_CONTACT";
 //    public static final String KEY_EMAIL  = "P_I_V_EMAIL";
 //    public static final String KEY_ADD_EMAILS  = "P_I_V_ADD_EMAILS";
 //    public static final String KEY_PHONE  = "P_I_V_PHONE";
 //    public static final String KEY_FAX  = "P_I_V_FAX";
 //    public static final String KEY_SHIPPER_CODE  = "P_I_V_DN_SHIPPER_CODE";
 //    public static final String KEY_SHIPPER_NAME  = "P_I_V_SHIPPER_NAME";
 //    public static final String KEY_SHIPPER_ADD1  = "P_I_V_SHIPPER_ADD1";
 //    public static final String KEY_SHIPPER_ADD2  = "P_I_V_SHIPPER_ADD2";
 //    public static final String KEY_SHIPPER_ADD3  = "P_I_V_SHIPPER_ADD3";
 //    public static final String KEY_SHIPPER_ADD4  = "P_I_V_SHIPPER_ADD4";
 //    public static final String KEY_CNEE_CODE  = "P_I_V_DN_CNEE_CODE";
 //    public static final String KEY_CNEE_NAME  = "P_I_V_CNEE_NAME";
 //    public static final String KEY_CNEE_ADD1  = "P_I_V_CNEE_ADD1";
 //    public static final String KEY_CNEE_ADD2  = "P_I_V_CNEE_ADD2";
 //    public static final String KEY_CNEE_ADD3  = "P_I_V_CNEE_ADD3";
 //    public static final String KEY_CNEE_ADD4  = "P_I_V_CNEE_ADD4";
 //    public static final String KEY_NTFY_CODE  = "P_I_V_DN_NTFY_CODE";
 //    public static final String KEY_NTFY_NAME  = "P_I_V_NTFY_NAME";
 //    public static final String KEY_NTFY_ADD1  = "P_I_V_NTFY_ADD1";
 //    public static final String KEY_NTFY_ADD2  = "P_I_V_NTFY_ADD2";
 //    public static final String KEY_NTFY_ADD3  = "P_I_V_NTFY_ADD3";
 //    public static final String KEY_NTFY_ADD4  = "P_I_V_NTFY_ADD4";
 //    public static final String KEY_ISSUE_PLACE_NAME  = "P_I_V_BL_ISSUE_PLACE_NAME";
 //    public static final String KEY_POL_NAME  = "P_I_V_POL_NAME";
 //    public static final String KEY_POD_NAME  = "P_I_V_POD_NAME";
 //    public static final String KEY_PLR_NAME  = "P_I_V_PLR_NAME";
 //    public static final String KEY_PLD_NAME  = "P_I_V_PLD_NAME";
 //    public static final String KEY_ORG_BL_COUNT  = "P_I_V_ORG_BL_COUNT";
 //    public static final String KEY_MARKS_NO  = "P_I_V_COMM_LVL_MARKS_NO";
 //    public static final String KEY_DESC  = "P_I_V_COMM_LVL_DESC";
 //    public static final String KEY_REMARK  = "P_I_V_REMARK";
 //    public static final String KEY_FSC = "P_I_V_FSC";
 //    public static final String KEY_SCREEN_SEQNO = "P_I_V_SCREEN_SEQNO";
 //    public static final String KEY_DN_EQ_NO = "P_I_V_DN_EQUIPMENT_NO";
 //    public static final String KEY_EQ_NO_SOURCE = "P_I_V_EQUPMENT_NO_SOURCE";
 //    public static final String KEY_LADEN_MT = "P_I_V_LADEN_MT";
 //    public static final String KEY_DN_EQ_SIZE = "P_I_V_DN_EQ_SIZE";
 //    public static final String KEY_DN_EQ_TYPE = "P_I_V_DN_EQ_TYPE";
 //    public static final String KEY_GROSS_CARGO_WEIGHT = "P_I_V_GROSS_CARGO_WEIGHT";
 //    public static final String KEY_GROSS_CARGO_MSMT = "P_I_V_GROSS_CARGO_MSMT";
 //    public static final String KEY_CARRIER_SEAL = "P_I_V_CARRIER_SEAL";
 //    public static final String KEY_SHIPPER_SEAL = "P_I_V_SHIPPER_SEAL";
 //    public static final String KEY_NO_OF_PACKAGES = "P_I_V_NO_OF_PACKAGES";
 //    public static final String KEY_DN_PACKAGE_KIND_CODE = "P_I_V_DN_PACKAGE_KIND_CODE";
 //    public static final String KEY_PK_DTL_SEQNO = "P_I_V_PK_DTL_SEQNO";
 //    public static final String KEY_FK_BKG_EQUIPM_DTL = "P_I_V_FK_BKG_EQUIPM_DTL";
 //    public static final String KEY_FK_BKG_SUPPLIER = "P_I_V_FK_BKG_SUPPLIER";
 //    public static final String KEY_FK_BKG_SIZE_TYPE_DTL = "P_I_V_FK_BKG_SIZE_TYPE_DTL";
 //    //@04 BEGIN
 //    public static final String KEY_SHIPPER_NAME_POPUP  = "P_I_V_SHIPPER";
 //    //@04 END
 //    public static final String KEY_REF_CURSOR_DATA = "P_O_V_HDR_DATA";
 //    public static final String KEY_REF_CURSOR_DTL_DATA = "P_O_V_DTL_DATA";
 //    public static final String KEY_OUT_BL_NO  = "P_O_V_BL_NO";
 //    //@01 BEGIN
 //    public static final String KEY_OUT_MODE  = "P_O_V_MODE";
 //    //@01 END
 //    public static final String KEY_CREATED_FLAG  = "P_O_V_BL_CREATED_FLAG";
 //    public static final String KEY_TOTAL_ROW  = "P_O_V_TOTAL_ROW";
 //    public static final String KEY_ERR_CD  = "P_O_V_ERR_CD";
 //    public static final String KEY_ERR_DESC  = "P_O_V_ERR_DESC";
 //    public static final String KEY_PK_DTL_SEQNO_OUT = "P_O_V_PK_DTL_SEQNO";
 //    //@02 BEGIN
 //    public static final String KEY_COMMODITY_CODE = "P_I_V_DN_COMMODITY_CODE";
 //    //@02 END 
 //    //@06 BEGIN
 //    public static final String KEY_DN_COMMODITY = "P_I_V_DN_COMMODITY";
 //    public static final String KEY_PK_SEQNO = "P_I_V_PK_SEQNO";
 //    //@06 END
 //    //@07 BEGIN
 //    public static final String KEY_WEIGHT = "P_I_V_WEIGHT";
 //    //@07 END
     public static final String NEW_LINE = "\n";
     
     /**
      * 
      * This abstract method for set data shipment detail.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @param form Object's Eshipping Instruction Form
      */
     public void setShipmentDetail(Map map, EshippingInstructionUim form) throws Exception;
     
     /**
      * 
      * This abstract method for set data contact detail.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @param form Object's Eshipping Instruction Form
      * @return Value of parameters out from procedure 
      */
     public Map setContactDetail(Map map, EshippingInstructionUim form) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for get List of Booking.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return List of booking data 
      */
     public Map getListEShipping(Map map) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for set data routing detail.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @param form Object's Eshipping Instruction Form
      */
     public void setRoutingDetail(Map map, EshippingInstructionUim form) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for set data equipement detail.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @param form Object's Eshipping Instruction Form
      */
     public void setEquipmentDetail(Map map, EshippingInstructionUim form) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for get List of containter type.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return List of containter type 
      */
     public Map getContainerTypes(Map map) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for get List of package kind type.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return List of package kind type 
      */
     public Map getPackageKindTypes(Map map) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for get List of commodity type.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return List of commodity type 
      */
     public Map getCommodityTypes(Map map) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for set data cargo description, marks&numbers.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @param form Object's Eshipping Instruction Form
      */
     public void setCargoMark(Map map, EshippingInstructionUim form) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for insert or update shipment header(save function).
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return Value of parameters out from procedure(error code or description) 
      */
     public Map insertOrUpdateShipmentHeader(Map map) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for insert or update equipment detail(save function).
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return Value of parameters out from procedure(error code or description) 
     * @throws Exception 
      */
     public Map insertOrUpdateContainerDetail(Map map) throws BusinessException, DataAccessException, Exception;
     
     /**
      * 
      * This abstract method for submit eshipping instruction(submit function).
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return Value of parameters out from procedure(error code or description) 
      */
     public Map submitEsi(Map map) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for set all data to acknowledgement popoup.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @param form Object's Eshipping Instruction Form
      */
     public void setAcknowledgementDetail(Map map, EshippingInstructionUim form) throws BusinessException, DataAccessException;
     
     /**
      * 
      * This abstract method for get BL No.
      * 
      * @exception BusinessException and DataAccessException
      * @param map List of parameters in
      * @return List of data about BL No.
      */
     public Map getBLNo(Map map) throws BusinessException, DataAccessException;
     
     //@05 BEGIN
      public Map getCommodityDetails(Map map) throws BusinessException,DataAccessException ;
      //@05 END
      //@06 BEGIN
      public Map insertOrUpdateCommodityDetails(Map map) throws BusinessException, DataAccessException, Exception;
      //@06 END
 //    @07 BEGIN
     public void doESISubmission(String bookingNo);
 //    @07 END
 //    @09 BEGIN
     public Map findContainerNoExist(Map map) throws BusinessException, DataAccessException;
 //    @09 END
 
     public int validateDataChange(String bookingNo) throws BusinessException, DataAccessException, Exception;
     
     public void clearESIData(String bookingNo) throws BusinessException, DataAccessException, Exception;

     
     public String getContryByContyCode(String code) ;
     
    public CustomerMod getCustomerDetailes(String userId);
   //  public String getCustomerCode(String userId);
      /**
       * 
       * This abstract method for set data shipment detail.
       * 
       * @exception BusinessException and DataAccessException
       * @param map List of parameters in
       */
//      public Map findShipmentDetails(Map map) throws BusinessException, DataAccessException;

	public String getCustomerCode(String userId);

	public Map getInquiryHeaderData(EshippingInstructionUim form,String usrId,String orgCode);

	public Map getInquiryShippingBtn(EshippingInstructionUim form,String usrId, String orgCode);
	
	public int checkBookingNoAndStatus(Map mapParams);

	public String getEsiStatusCodeForValidation(String bookingNo);

	public void cancelBookingDtl(EshippingInstructionUim form);

	public void getRatChargeDtls(EshippingInstructionUim objForm, Map mapParams);

	public void getMailDtls(EshippingInstructionUim form,String userid);

	public void getSailingDate(EshippingInstructionUim objForm, Map mapParams);

	public String checkSiEditFlag(String bookingNo);

	public String getBookingPartyFromCamCustomer(EshippingInstructionUim form);

	public void setRoutingDtls(EshippingInstructionUim objForm, Map mapParams);

	public String getRepresentCompName(String bookingNo);

	public Map<String,String> getValidateConatinerNos(String containerArrayJson);

	public void checkConatinerNoInBookingTbl(EshippingInstructionUim form);

	public boolean checkBookingStatus(String bookingNo);

	public void getFirstLegVesselDtl(EshippingInstructionUim objForm);

 }
