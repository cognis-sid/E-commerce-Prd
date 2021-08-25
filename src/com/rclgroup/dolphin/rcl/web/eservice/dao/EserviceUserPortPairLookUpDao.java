 /*------------------------------------------------------
  EserviceUserPortPairLookUpDao.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 21/10/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUserPortPairLookUpUim;

public interface EserviceUserPortPairLookUpDao {
    public static final String DAO_NAME                     = "EserviceUserPortPairLookUpDao";    
    
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
    
    public interface PCR_ESV_REGISTER{
        public final String PACKAGE_NAME                            = "PCR_ESV_REGISTER";
        
        public final String PRR_ESV_GET_USER_PORT_PAIR              = PACKAGE_NAME+".PRR_ESV_GET_USER_PORT_PAIR";
    }
    
    public interface P_I_V{
        public String COL_NAME                            = "P_I_V_COL_NAME";
        public String COL_VAL                             = "P_I_V_COL_VAL";
        public String SORT_BY                             = "P_I_V_SORT_BY";
        public String ORDER_BY                            = "P_I_V_ORDER_BY";
        public String WILD_CARD                           = "P_I_V_WILD_CARD";
        public String USR_ID                              = "P_I_V_USR_ID";
    }
    
    public interface P_O_V{
        public String CONTRACT_PARTY_DATA                 = "P_O_V_CONTRACT_PARTY_DATA";
        public String ERROR                               = "P_O_V_ERROR";
    }

    public Map getUserPortPairList(EserviceUserPortPairLookUpUim form) throws BusinessException, DataAccessException;
}
