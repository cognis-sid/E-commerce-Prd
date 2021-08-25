 /* -----------------------------------------------------------------------------
 System  : RCLEAPPS
 Module  : Common
 Prog ID : ESER008 - EserviceCommodityPopupDao.java
 Name    : New Web Booking
 Purpose : DAO Class for EserviceCommodityPopupDao Interface
 --------------------------------------------------------------------------------
 History : None
 --------------------------------------------------------------------------------
 Author          Date            What
 --------------- --------------- ------------------------------------------------
 YOSSUN1         22/08/2013      <Initial version>
 --Change Log--------------------------------------------------------------------
 ## DD/MM/YY –User- -Task/CR No- -Short Description-
 ----------------------------------------------------------------------------- */
 package com.rclgroup.dolphin.rcl.web.eservice.dao;

 import java.util.Map;

 import org.springframework.dao.DataAccessException;

 import com.niit.control.common.exception.BusinessException;

 import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;

 /** 
  * Interface for DAO
  * @class EdlBulkUpdate
  * @author YOSSUN1
  * @version v1.00 2013/08/22
  * @see
  */
 public interface EshippingCommodityPopupDao {
     public static final String DAO_NAME                     = "EshippingCommodityPopupDao";
     public static final String ESV_LIST_COUNTRY_REF_CUR     = "ESV_LIST_COUNTRY_REF_CUR";
     
     public static final String KEY_COLUMN_ORDER_ASC         = "asc";
     public static final String KEY_COLUMN_ORDER_DESC        = "desc";
     public static final String KEY_COLUMN_SHOW_ORDER_ASC    = "Ascending";
     public static final String KEY_COLUMN_SHOW_ORDER_DESC   = "Descending";
     
     public static final String EXCEPTION = "EXCEPTION";
     public interface PCR_ESV_SI_MAIN{
         public final String PACKAGE_NAME = "PCR_ESV_SI_MAIN";
         public final String PRR_ESV_SI_GET_COMM_POPUP= PACKAGE_NAME+".PRR_ESV_SI_GET_COMM_POPUP";
         public final String PRR_ESV_SI_GET_COMMGRP_DDL = PACKAGE_NAME+".PRR_ESV_SI_GET_COMMGRP_DDL";
     }
     
     public interface P_I_V{
         public final String COMM_CODE = "P_I_V_COMM_CODE";
         public final String COMM_GROUP_CODE = "P_I_V_COMM_GROUP_CODE";
         public final String COMM_DESC = "P_I_V_COMM_DESC";
         public final String ORDER_BY = "P_I_V_ORDER_BY";
         public final String SORT_BY = "P_I_V_SORT_BY";
         public final String RECORD_START = "P_I_V_RECORD_START";
         public final String RECORD_END = "P_I_V_RECORD_END";
         public final String WILDCARD = "P_I_V_WILDCARD";
     }

     public interface P_O_V{
         public final String DTL_DATA = "P_O_V_DTL_DATA";
         public final String TOTAL_ROW = "P_O_V_TOTAL_ROW";
         public final String ERR_CD = "P_O_V_ERR_CD";
         public final String ERR_DESC = "P_O_V_ERR_DESC";
     }

     public static final String KEY_DATA = "KEY_DATA";
     
     //----------------- constants declaration.
     //----------------- method declaration.
     public Map onLoad(Map amapParam) throws BusinessException, DataAccessException;
     public Map getList(Map amap) throws BusinessException, DataAccessException;
     public Map getComboCommodityGroup() throws BusinessException,DataAccessException ;
 }
