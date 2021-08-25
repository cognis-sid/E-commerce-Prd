package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.exception.BusinessException;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESNotificationsMod;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface EserviceMRESDao{
    public static final String DAO_NAME = "EserviceMRESDao";

    public interface PCR_ESV_REGISTER{
        public final String PACKAGE_NAME = "PCR_ESV_REGISTER";
        public final String PRR_ESV_GET_NOTIFICATION= PACKAGE_NAME+".PRR_ESV_GET_NOTIFICATION";
        public final String PRR_ESV_GET_MENU = PACKAGE_NAME+".PRR_ESV_GET_MENU";
        public final String PRR_ESV_GET_AUTHENTICATE = PACKAGE_NAME+".PRR_ESV_GET_AUTHENTICATE";
    }
    
    public interface MY_ESERVICE{
        public String ESV = "EBKG-E";
        public String ESI = "EDOC-E";
        public String EBL = "CSDO-E";
    }
    
    public interface NOTIFICATION_FLAG{
        public String NEW = "NEW";
        public String OLD = "OLD";
    }
    
    public interface P_I_V{
        public final String USR_ID = "P_I_V_USR_ID";
        public final String PWD = "P_I_V_PWD";
        public final String RECORD_START= "P_I_V_RECORD_START";
        public final String RECODE_END = "P_I_V_RECORD_END";
        public final String SORT_COL = "P_I_V_SORT_COL";
        public final String ORDERBY = "P_I_V_ORDERBY";
    }
    
    public interface P_O_V{
        public final String ERR_CD = "P_O_V_ERR_CD";
        public final String ERR_DESC = "P_O_V_ERR_DESC";
        public final String ERR_MSG = "P_O_V_ERR_MSG";
        public final String NOTICE_DATA = "P_O_V_NOTICE_DATA";
        public final String SFU_DATA = "P_O_V_SFU_DATA";
        public final String DTL_DATA = "P_O_V_DTL_DATA";
        public final String TOTAL_ROW = "P_O_V_TOTAL_ROW";
    }
    
    public Map findNotifications(Map map) throws BusinessException, DataAccessException;
    public Map findMyEService(Map map) throws BusinessException, DataAccessException;
    public Map findPasswordAuthen(Map map) throws BusinessException, DataAccessException;
}
