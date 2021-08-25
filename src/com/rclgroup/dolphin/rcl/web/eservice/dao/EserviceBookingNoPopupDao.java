package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.exception.BusinessException;

import com.niit.control.dao.AncestorJdbcDao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface EserviceBookingNoPopupDao{    
    public static final String DAO_NAME = "EserviceBookingNoPopupDao";
    public static final String EXCEPTION = "EXCEPTION";
    
    public interface PCR_ESV_SI_MAIN{
        public final String PACKAGE_NAME = "PCR_ESV_SI_MAIN";
        public final String PRR_ERCL_GET_ESI_BOOKING_POPUP = PACKAGE_NAME+".PRR_ERCL_GET_ESI_BOOKING_POPUP";
    }
    
     public interface P_I_V{
         public final String LOGIN_ID  = "P_I_V_LOGIN_ID";
         public final String BL_NO  = "P_I_V_BL_NO";
         public final String BKG_NO  = "P_I_V_BKG_NO";
         public final String BOOKING_NO  = "P_I_V_BOOKING_NO";
         public final String VESSEL  = "P_I_V_VESSEL";
         public final String VOYAGE  = "P_I_V_VOYAGE";
         public final String POL  = "P_I_V_POL";
         public final String POD  = "P_I_V_POD";
         public final String STATUS  = "P_I_V_ESI_STATUS";
         public final String REC_START  = "P_I_V_RECORD_START";
         public final String REC_END  = "P_I_V_RECORD_END";
         public final String MODE  = "P_I_V_MODE";
         public final String PKG_NAME  = "P_I_V_NAME";
         public final String PKG_CODE  = "P_I_V_CODE";
         public final String ARCHE_TYPE  = "P_I_V_BL_ARCHETYPE";
         public final String BL_TYPE  = "P_I_V_BL_TYPE";
         public final String SUBMIT_BY  = "P_I_V_SUBMIT_BY";
         public final String CONTACT  = "P_I_V_CONTACT";
         public final String EMAIL  = "P_I_V_EMAIL";
         public final String ADD_EMAILS  = "P_I_V_ADD_EMAILS";
         public final String PHONE  = "P_I_V_PHONE";
         public final String FAX  = "P_I_V_FAX";
         public final String SHIPPER_CODE  = "P_I_V_DN_SHIPPER_CODE";
         public final String SHIPPER_NAME  = "P_I_V_SHIPPER_NAME";
         public final String SHIPPER_ADD1  = "P_I_V_SHIPPER_ADD1";
         public final String SHIPPER_ADD2  = "P_I_V_SHIPPER_ADD2";
         public final String SHIPPER_ADD3  = "P_I_V_SHIPPER_ADD3";
         public final String SHIPPER_ADD4  = "P_I_V_SHIPPER_ADD4";
         public final String CNEE_CODE  = "P_I_V_DN_CNEE_CODE";
         public final String CNEE_NAME  = "P_I_V_CNEE_NAME";
         public final String CNEE_ADD1  = "P_I_V_CNEE_ADD1";
         public final String CNEE_ADD2  = "P_I_V_CNEE_ADD2";
         public final String CNEE_ADD3  = "P_I_V_CNEE_ADD3";
         public final String CNEE_ADD4  = "P_I_V_CNEE_ADD4";
         public final String NTFY_CODE  = "P_I_V_DN_NTFY_CODE";
         public final String NTFY_NAME  = "P_I_V_NTFY_NAME";
         public final String NTFY_ADD1  = "P_I_V_NTFY_ADD1";
         public final String NTFY_ADD2  = "P_I_V_NTFY_ADD2";
         public final String NTFY_ADD3  = "P_I_V_NTFY_ADD3";
         public final String NTFY_ADD4  = "P_I_V_NTFY_ADD4";
         public final String ISSUE_PLACE_NAME  = "P_I_V_BL_ISSUE_PLACE_NAME";
         public final String POL_NAME  = "P_I_V_POL_NAME";
         public final String POD_NAME  = "P_I_V_POD_NAME";
         public final String PLR_NAME  = "P_I_V_PLR_NAME";
         public final String PLD_NAME  = "P_I_V_PLD_NAME";
         public final String ORG_BL_COUNT  = "P_I_V_ORG_BL_COUNT";
         public final String MARKS_NO  = "P_I_V_COMM_LVL_MARKS_NO";
         public final String DESC  = "P_I_V_COMM_LVL_DESC";
         public final String REMARK  = "P_I_V_REMARK";
         public final String FSC = "P_I_V_FSC";
         public final String SCREEN_SEQNO = "P_I_V_SCREEN_SEQNO";
         public final String DN_EQ_NO = "P_I_V_DN_EQUIPMENT_NO";
         public final String EQ_NO_SOURCE = "P_I_V_EQUPMENT_NO_SOURCE";
         public final String LADEN_MT = "P_I_V_LADEN_MT";
         public final String DN_EQ_SIZE = "P_I_V_DN_EQ_SIZE";
         public final String DN_EQ_TYPE = "P_I_V_DN_EQ_TYPE";
         public final String GROSS_CARGO_WEIGHT = "P_I_V_GROSS_CARGO_WEIGHT";
         public final String GROSS_CARGO_MSMT = "P_I_V_GROSS_CARGO_MSMT";
         public final String CARRIER_SEAL = "P_I_V_CARRIER_SEAL";
         public final String SHIPPER_SEAL = "P_I_V_SHIPPER_SEAL";
         public final String NO_OF_PACKAGES = "P_I_V_NO_OF_PACKAGES";
         public final String DN_PACKAGE_KIND_CODE = "P_I_V_DN_PACKAGE_KIND_CODE";
         public final String PK_DTL_SEQNO = "P_I_V_PK_DTL_SEQNO";
         public final String FK_BKG_EQUIPM_DTL = "P_I_V_FK_BKG_EQUIPM_DTL";
         public final String FK_BKG_SUPPLIER = "P_I_V_FK_BKG_SUPPLIER";
         public final String FK_BKG_SIZE_TYPE_DTL = "P_I_V_FK_BKG_SIZE_TYPE_DTL";
         public final String SHIPPER_NAME_POPUP  = "P_I_V_SHIPPER";   
         public final String COMMODITY_CODE = "P_I_V_DN_COMMODITY_CODE";
         public final String DN_COMMODITY = "P_I_V_DN_COMMODITY";
         public final String PK_SEQNO = "P_I_V_PK_SEQNO";
         public final String WEIGHT = "P_I_V_WEIGHT";
         public final String CNTR = "P_I_V_CNTR";
         public final String TOT_PACKAGE = "P_I_V_TOT_PACKAGE";
        public final String TOT_PACKAGE_KIND = "P_I_V_TOT_PACKAGE_KIND";
        public final String TOT_MEASUREMENT = "P_I_V_TOT_MEASUREMENT";
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
     }    
     
    public interface COLUMN_KEY{
        public final String CUCUST = "CUCUST";
        public final String CUNAME = "CUNAME";
        public final String BOOKING_DATE = "BOOKING_DATE";
        public final String BOOKING_NO = "BOOKING_NO";
        public final String SHIPPER = "SHIPPER";
        public final String VESSEL = "VESSEL";
        public final String VOYAGE = "VOYAGE";
        public final String POL = "POL";
        public final String POD = "POD";
        public final String BASTAT = "BASTAT";
        public final String BL_NO = "BL_NO";
        public final String PACKAGE_CODE = "PACKAGE_CODE";
        public final String PACKAGE_NAME = "PACKAGE_NAME";
        public final String LADEN = "LADEN";
        public final String COUNTRY = "(select SCNAME from ITP030 where SCCODE = cucoun)";
    }
    
    public interface CRITERIA_KEY{
        //  Criteria in jsp page
        public final String TEXT_FIND = "TEXT";
        public final String COLUMN = "COLUMN";
        public final String SORTBY = "SORTBY";
        public final String ORDER = "ORDER";
        public final String STATUS = "STATUS";
        public final String WILDCARD = "WILDCARD";
        public final String FROM_RECORD = "fromRecord";
        public final String TO_RECORD = "toRecord";
        public final String ORG_CODE = "orgCode";
        public final String COC_SOC = "cocSoc";
    }
    
    public Map findESIBookingNoDetails(Map paramsMap) throws BusinessException, DataAccessException; 
}
