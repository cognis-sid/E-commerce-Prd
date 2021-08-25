 /*------------------------------------------------------
  EserviceSailingSchedulePopupDao.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 11/09/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;

public interface EserviceEquipmentTypePopUpDao {
    public static final String DAO_NAME                     = "EserviceSailingSchedulePopupDao";    
    
    public static final String EXCEPTION                    = "EXCEPTION";
    
    public static final String KEY_CRITERIA_TEXT_FIND       = "TEXT";
    public static final String KEY_CRITERIA_COLUMN          = "COLUMN";
    public static final String KEY_CRITERIA_SORTBY          = "SORTBY";
    public static final String KEY_CRITERIA_ORDER           = "ORDER";
    public static final String KEY_CRITERIA_WILDCARD        = "WILDCARD";
    public static final String KEY_DATA                     = "DATA";
    
    public static final String KEY_COLUMN_ORDER_ASC         = "asc";
    public static final String KEY_COLUMN_ORDER_DESC        = "desc";
    public static final String KEY_COLUMN_SHOW_ORDER_ASC    = "Ascending";
    public static final String KEY_COLUMN_SHOW_ORDER_DESC   = "Descending";
    
    public interface PCR_ESV_WEB_BKG{
        public final String PACKAGE_NAME                            = "PCR_ESV_WEB_BKG";
        
        public final String PRR_ESV_GET_EQUIP_TYPE                  = PACKAGE_NAME+".PRR_ESV_GET_EQUIP_TYPE";
    }
    
    public String P_I_V_COL_NAME                            = "P_I_V_COL_NAME";
    public String P_I_V_COL_VAL                             = "P_I_V_COL_VAL";
    public String P_I_V_SORT_BY                             = "P_I_V_SORT_BY";
    public String P_I_V_ORDER_BY                            = "P_I_V_ORDER_BY";
    public String P_I_V_WILD_CARD                           = "P_I_V_WILD_CARD";
    public String P_I_V_KEY_SEARCH                          = "P_I_V_KEY_SEARCH";
    
    public String P_O_V_DATA                                = "P_O_V_DATA";

    public Map getEquipmentTypeList(Map amap) throws BusinessException, DataAccessException;
}
