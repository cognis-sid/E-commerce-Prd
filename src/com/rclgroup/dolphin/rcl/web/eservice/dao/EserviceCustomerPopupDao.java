package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.exception.BusinessException;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface EserviceCustomerPopupDao{
    public static final String DAO_NAME = "EserviceCustomerPopupDao";
    
    public interface COLUMN_HEADER{
        public final String CUSTOMER_CODE = "Customer Code";
        public final String CUSTOMER_NAME = "Customer Name";
        public final String CUSTOMER_TYPE = "Customer Type";
        public final String COUNTRY = "Country";
        public final String DESCRIPTION = "Description";
        public final String ADDRESS = "Address";
        public final String CITY_NAME = "City Name";
        public final String STATE_CODE = "State Code";
        public final String STATE_NAME = "State Name";
        public final String ZIP_CODE = "Zip Code";
        public final String TELEPHONE = "Telephone";
        public final String FAX_NO = "Fax No.";
        public final String EMAIL = "Email";
        public final String COUNTRY_CODE = "Country Code";
        public final String COUNTRY_NAME = "Country Name";
        public final String CONSOLIDATED = "Consolidated";
        public final String ORGANIZATION_TYPE = "Organization Type";
        public final String STATUS = "Status";
    }

    public interface CRITERIA_KEY{
        public final String TEXT_FIND = "TEXT";
        public final String COLUMN = "COLUMN";
        public final String SORTBY = "SORTBY";
        public final String SORT_COL = "SORT_COL";
        public final String ORDER = "ORDER";
        public final String STATUS = "STATUS";
        public final String WILDCARD = "WILDCARD";
        public final String FROM_RECORD = "fromRecord";
        public final String TO_RECORD = "toRecord";
        public final String FSC_CODE = "fscCode";
        public final String CONTROL_FSC = "controlFsc";  
        public final String ORG_CODE = "orgCode";
        public final String COC_SOC = "cocSoc";
        public final String IN = "in";
        public final String COUNTRY = "COUNTRY";
    }
    
    public interface PCR_ESV_REGISTER{
        public final String PACKAGE_NAME                    = "PCR_ESV_REGISTER";
        public final String PRR_ESV_CUSTOMER_TYPE_POPUP     = PACKAGE_NAME+".PRR_ESV_CUSTOMER_TYPE_POPUP";
        
        public final String PRR_ESV_CUST_TYPE_POPUP         = PACKAGE_NAME+".PRR_ESV_CUST_TYPE_POPUP";
    }
    
    public interface P_I_V{
        public final String RECORD_START                    = "P_I_V_RECORD_START";
        public final String RECORD_END                      = "P_I_V_RECORD_END";
        public final String SORT_COL                        = "P_I_V_SORT_COL";
        public final String ORDER_BY                        = "P_I_V_ORDERBY";
        public final String FIND                            = "P_I_V_FIND";
        public final String IN                              = "P_I_V_IN";
        
        public String COL_NAME                            = "P_I_V_COL_NAME";
        public String COL_VAL                             = "P_I_V_COL_VAL";
        public String SORT_BY                             = "P_I_V_SORT_BY";
        public String WILD_CARD                           = "P_I_V_WILD_CARD";
    }
    
    public interface P_O_V{
        public final String TOTAL_ROW = "P_O_V_TOTAL_ROW";
        public final String CUST_TYPE_DATA = "P_O_V_CUST_TYPE_DATA";
        public final String ERR_CD = "P_O_V_ERR_CD";
        public final String ERR_DESC = "P_O_V_ERR_DESC";
    }

  
    public static final String KEY_CONFIG_DATE = "configDate";
    public static final String KEY_DATA = "DATA";
    public static final String NEW_LINE = "\n";
    public static final String KEY_COLUMN_COUNTRY = "(select SCNAME from ITP030 where SCCODE = cucoun)";

    public String getValueToConfigDate() throws BusinessException, DataAccessException;

    public Map findCustomerForESICustomer(Map map) throws BusinessException, DataAccessException;

    public Map findCustomerForESVCustomer(Map map) throws BusinessException, DataAccessException;
    public Map findCustomerTypeForESV(Map map) throws BusinessException, DataAccessException;
    public Map onLoad(Map amapParam) throws BusinessException,DataAccessException;
    
    public Map findCustomerTypeForESVNew(Map map) throws BusinessException, DataAccessException;
    
//    public Map getList(Map amap) throws BusinessException, DataAccessException;
}
