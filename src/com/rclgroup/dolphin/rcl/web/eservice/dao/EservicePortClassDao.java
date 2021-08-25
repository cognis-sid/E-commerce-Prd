 /*------------------------------------------------------
  EservicePortClassDao.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 08/08/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;

public interface EservicePortClassDao {
    public static final String DAO_NAME                     = "EservicePortClassDao";    
    
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
    
    public String PRR_ESV_GET_DG_LOOKUP                     = "PCR_ESV_WEB_BKG.PRR_ESV_GET_DG_LOOKUP";
    
    public String P_I_V_COL_NAME                            = "P_I_V_COL_NAME";
    public String P_I_V_COL_VAL                             = "P_I_V_COL_VAL";
    public String P_I_V_SORT_BY                             = "P_I_V_SORT_BY";
    public String P_I_V_ORDER_BY                            = "P_I_V_ORDER_BY";
    public String P_I_V_WILD_CARD                           = "P_I_V_WILD_CARD";
    
    public String P_O_V_DG_PORT_CLASS_DATA                  = "P_O_V_DG_PORT_CLASS_DATA";

    public Map getList(Map amap) throws BusinessException, DataAccessException;
}
