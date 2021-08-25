package com.rclgroup.dolphin.rcl.web.common;

import com.niit.control.common.ComboVO;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;

public interface ComboBoxESVConstants{        
    public interface COMBO_BOX_TYPE{
        public static final String COUNTRY = "COUNTRY";
    }   

    public interface COLUMN_KEY{
        public final String CUSTOMER_CODE = "CUSTOMER_CODE";
        public final String DESCRIPTION = "DESCRIPTION";
        public final String ADDRESS = "ADDRESS";
        public final String CITY_NAME = "CITY_NAME";
        public final String STATE_CODE = "STATE_CODE";
        public final String STATE_NAME = "STATE_NAME";
        public final String ZIP_CODE = "ZIP_CODE";
        public final String TELEPHONE = "TELEPHONE";
        public final String FAX_NO = "FAX_NO";
        public final String EMAIL = "EMAIL";
        public final String COUNTRY_CODE = "COUNTRY_CODE";
        public final String COUNTRY_NAME = "COUNTRY_NAME";
        public final String CONSOLIDATED = "CONSOLIDATED";
        public final String COMMODITY_GROUP_CODE = "COMM_GRP_CODE";
        public final String COMMODITY_GROUP_DESCRIPTION = "COMM_GRP_DESC";
    }
    
    public interface COLUMN_LABEL{
        public final String CUSTOMER_CODE = "Customer Code";
        public final String DESCRIPTION = "Description";
        public final String ADDRESS = "Address";
        public final String CITY_NAME = "City Name";
        public final String STATE_CODE = "State Code";
        public final String STATE_NAME = "State Name";
        public final String ZIP_CODE = "Zip Code";
        public final String TELEPHONE = "Telephone";
        public final String FAX_NO = "Fax No";
        public final String EMAIL = "Email";
        public final String COUNTRY_CODE = "Country Code";
        public final String COUNTRY_NAME = "Country Name";
        public final String CONSOLIDATED = "Consolidated";
        public final String COMMODITY_GROUP_CODE = "Commodity Group";
        public final String COMMODITY_GROUP_DESCRIPTION = "Commodity Description";
    } 
    
    public enum CUSTOMER{        
        CODE(COLUMN_KEY.CUSTOMER_CODE, COLUMN_LABEL.CUSTOMER_CODE),
        ADDRESS(COLUMN_KEY.DESCRIPTION, COLUMN_LABEL.DESCRIPTION),
        CITY_NAME(COLUMN_KEY.CITY_NAME, COLUMN_LABEL.CITY_NAME),
        STATE_CODE(COLUMN_KEY.STATE_CODE, COLUMN_LABEL.STATE_CODE),
        STATE_NAME(COLUMN_KEY.STATE_NAME, COLUMN_LABEL.STATE_NAME),
        ZIP_CODE(COLUMN_KEY.ZIP_CODE, COLUMN_LABEL.ZIP_CODE),
        TELEPHONE(COLUMN_KEY.TELEPHONE, COLUMN_LABEL.TELEPHONE),
        FAX_NO(COLUMN_KEY.FAX_NO, COLUMN_LABEL.FAX_NO),
        EMAIL(COLUMN_KEY.EMAIL, COLUMN_LABEL.EMAIL),
        COUNTRY_CODE(COLUMN_KEY.COUNTRY_CODE, COLUMN_LABEL.COUNTRY_CODE),
        COUNTRY_NAME(COLUMN_KEY.COUNTRY_NAME, COLUMN_LABEL.COUNTRY_NAME),
        CONSOLIDATED(COLUMN_KEY.CONSOLIDATED, COLUMN_LABEL.CONSOLIDATED);
    
        private String code;
        private String value;
        
        CUSTOMER(String code, String value){
            this.code = code;
            this.value = value;
        }
        
        public String getCode(){
            return code;
        }
        
        public String getValue(){
            return value;
        }
    }
    
    public enum CUSTOMER_TYPE{           
        TYPE("CUSTOMER_TYPE", "Customer Type"),
        DESCRIPTION("DESCRIPTION", "Description"),
        ORGANISATION_TYPE("ORGANISATION_TYPE", "Organization Type"),
        STATUS("STATUS", "Status");
    
        private String code;
        private String value;
        
        CUSTOMER_TYPE(String code, String value){
            this.code = code;
            this.value = value;
        }
        
        public String getCode(){
            return code;
        }
        
        public String getValue(){
            return value;
        }
    }   
    
    public enum COMMODITY{
        GROUP(COLUMN_KEY.COMMODITY_GROUP_CODE, COLUMN_LABEL.COMMODITY_GROUP_CODE),
        DESCRIPTION(COLUMN_KEY.COMMODITY_GROUP_DESCRIPTION, COLUMN_LABEL.COMMODITY_GROUP_DESCRIPTION);
    
        private String code;
        private String value;
        
        COMMODITY(String code, String value){
            this.code = code;
            this.value = value;
        }
        
        public String getCode(){
            return code;
        }
        
        public String getValue(){
            return value;
        }
    }
            
    public enum POL_POD{        
        CY("CY", "CY"), CFS("CF", "CFS"), ICD("CD", "ICD"), 
        BOM("BO", "BOM"), DOOR("DR", "DOOR");
    
        private String code;
        private String value;
        
        POL_POD(String code, String value){
            this.code = code;
            this.value = value;
        }
        
        public String getCode(){
            return code;
        }
        
        public String getValue(){
            return value;
        }
    }
            
    public enum POL_POD_STATUS{        
        LOCAL("L", "Local"), TS("T", "TS");
    
        private String code;
        private String value;
        
        POL_POD_STATUS(String code, String value){
            this.code = code;
            this.value = value;
        }
        
        public String getCode(){
            return code;
        }
        
        public String getValue(){
            return value;
        }
    }
}
