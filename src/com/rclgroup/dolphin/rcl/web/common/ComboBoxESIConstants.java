package com.rclgroup.dolphin.rcl.web.common;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;

public interface ComboBoxESIConstants{
     
     //  Value of dropdown : [column] in jsp page
    
    public interface COMBO_BOX_TYPE{
        public static final String COMMODITY = "COMMODITY";
        public static final String CONTAINER_TYPE = "CONTAINER_TYPE";
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
        public final String COMMODITY_GROUP_CODE = "COMM_GRP_DESC";
        public final String COMMODITY_GROUP_DESCRIPTION = "COMM_DESC";
    }
    
    public interface COLUMN_LABEL{
        public final String CUSTOMER_CODE = "Customer Code";
        public final String CUSTOMER_NAME = "Customer Name";
        public final String COUNTRY = "Country";
        public final String BOOKING_DATE = "Booking Date";
        public final String BOOKING_NO = "Booking No";
        public final String SHIPPER_NAME = "Shipper name";
        public final String LEG_VESSEL = "1stLeg Vessel";
        public final String LEG_VOYAGE = "1stLeg Voyage";
        public final String POL = "Port of Loading";
        public final String POD = "Port of Discharge";
        public final String ESI_STATUS = "eSI Status";
        public final String BL_NO = "B/L No.";
        public final String PAKAGE_CODE = "Package Code";
        public final String PAKAGE_NAME = "Package Name";
        public final String COMMODITY_GROUP_CODE = "Commodity Group";
        public final String COMMODITY_GROUP_DESCRIPTION = "Commodity Description";
    }

    public enum BL_TYPE{
        THROUGH_BL("T", "Through B/L");
//        MEMO_BL("M", "Memo B/L"),
//        SEA_WAY_BL("S", "Sea-way B/L");
    
        private String code;
        private String value;
        
        BL_TYPE(String code, String value){
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
    
    public enum LADEN{
        LADEN("F", "Laden"),
        EMPTY("E", "Empty");
    
        private String code;
        private String value;
        
        LADEN(String code, String value){
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
    
    public enum BOOKING{
        BOOKING_NO(COLUMN_KEY.BOOKING_NO, COLUMN_LABEL.BOOKING_NO),
        BOOKING_DATE(COLUMN_KEY.BOOKING_DATE, COLUMN_LABEL.BOOKING_DATE),
        SHIPPER_NAME(COLUMN_KEY.SHIPPER, COLUMN_LABEL.SHIPPER_NAME),
        LEG_VESSEL(COLUMN_KEY.VESSEL, COLUMN_LABEL.LEG_VESSEL),
        LEG_VOYAGE(COLUMN_KEY.VOYAGE, COLUMN_LABEL.LEG_VOYAGE),
        POL(COLUMN_KEY.POL, COLUMN_LABEL.POL),
        POD(COLUMN_KEY.POD, COLUMN_LABEL.POD),
        BL_NO(COLUMN_KEY.BL_NO, COLUMN_LABEL.BL_NO);
    
        private String code;
        private String value;
        
        BOOKING(String code, String value){
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
    
    public enum ESI_STATUS{
        NEW(EshippingInstructionDao.STATUS_ESI_KEY.N, EshippingInstructionDao.STATUS_ESI_LABEL.NEW),
        IN_PROGRESS(EshippingInstructionDao.STATUS_ESI_KEY.I, EshippingInstructionDao.STATUS_ESI_LABEL.IN_PROGRESS),
        SUBMITTED(EshippingInstructionDao.STATUS_ESI_KEY.S, EshippingInstructionDao.STATUS_ESI_LABEL.SUBMITTED);
    
        private String code;
        private String value;
        
        ESI_STATUS(String code, String value){
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
    
    public enum CUSTOMER{
        CODE(COLUMN_KEY.CUCUST, COLUMN_LABEL.CUSTOMER_CODE),
        NAME(COLUMN_KEY.CUNAME, COLUMN_LABEL.CUSTOMER_NAME),
        COUNTRY(COLUMN_KEY.COUNTRY, COLUMN_LABEL.COUNTRY);
    
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
    
    public enum PACKAGE{
        CODE(COLUMN_KEY.PACKAGE_CODE, COLUMN_LABEL.PAKAGE_CODE),
        NAME(COLUMN_KEY.PACKAGE_NAME, COLUMN_LABEL.PAKAGE_NAME);
    
        private String code;
        private String value;
        
        PACKAGE(String code, String value){
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
        CODE(COLUMN_KEY.COMMODITY_GROUP_CODE, COLUMN_LABEL.COMMODITY_GROUP_CODE),
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
}
