package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.exception.BusinessException;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface EservicePackagePopupDao{
    public static final String DAO_NAME = "EservicePackagePopupDao";
    public static final String EXCEPTION = "EXCEPTION";
    
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
    
     
    public interface COLUMN_KEY{
        public final String PACKAGE_CODE = "PACKAGE_CODE";
        public final String PACKAGE_NAME = "PACKAGE_NAME";
    }
     
     public interface P_I_V{
         public final String REC_START  = "P_I_V_RECORD_START";
         public final String REC_END  = "P_I_V_RECORD_END";
         public final String PKG_NAME  = "P_I_V_NAME";
         public final String PKG_CODE  = "P_I_V_CODE";
     }
     
     public interface P_O_V{
         public final String REF_CURSOR_DTL_DATA = "P_O_V_DTL_DATA";
         public final String TOTAL_ROW  = "P_O_V_TOTAL_ROW";
         public final String ERR_CD  = "P_O_V_ERR_CD";
         public final String ERR_DESC  = "P_O_V_ERR_DESC";
     }
     
     public interface PCR_ESV_SI_MAIN{
         public final String PACKAGE_NAME = "PCR_ESV_SI_MAIN";
         public final String PRR_ERCL_GET_ESI_PACKAGE_POPUP = PACKAGE_NAME+".PRR_ERCL_GET_ESI_PACKAGE_POPUP";
     }


    /**
     * 
     * This abstract method for get List of package kind type.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of package kind type 
     */
    public Map findPackageKindTypes(Map map) throws BusinessException, DataAccessException;
}
