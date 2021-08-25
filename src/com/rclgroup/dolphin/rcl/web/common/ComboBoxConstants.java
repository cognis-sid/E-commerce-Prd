package com.rclgroup.dolphin.rcl.web.common;

import com.niit.control.common.ComboVO;
import com.niit.control.common.GlobalConstants;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

public interface ComboBoxConstants extends GlobalConstants {
    public interface ORDER_KEY{
        public final String ASC = "asc";
        public final String DESC = "desc";
    }
    
    public interface ORDER_LABEL{
        public final String ASCENDING = "Ascending";
        public final String DESCENDING = "Descending";  
    }

    public final String KEY_COLUMN_EMPTY = "EMPTY";
    
    public enum ORDER_BY{
        ASC(ORDER_KEY.ASC, ORDER_LABEL.ASCENDING),
        DESC(ORDER_KEY.DESC, ORDER_LABEL.DESCENDING);
    
        private String code;
        private String value;
        
        ORDER_BY(String code, String value){
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
