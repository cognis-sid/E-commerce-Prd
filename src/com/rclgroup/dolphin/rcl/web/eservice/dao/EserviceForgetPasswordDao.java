package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.exception.BusinessException;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface EserviceForgetPasswordDao{
    public static final String DAO_NAME = "EserviceForgetPasswordDao";
    public interface PCR_ESV_REGISTER{
        public final String PACKAGE_NAME = "PCR_ESV_REGISTER";
        public final String PRR_ESV_FORGOT_PWD = PACKAGE_NAME+".PRR_ESV_FORGOT_PWD";
    }
    public interface P_I_V{
        public String USR_ID = "P_I_V_USR_ID";
        public String EMAIL_ADR = "P_I_V_EMAIL_ADR";
    }
    
    public interface P_O_V{
        public final String ERR_CD = "P_O_V_ERR_CD";
        public final String ERR_DESC = "P_O_V_ERR_DESC";
    }
    
    public Map sendForgetPassword(Map map) throws BusinessException, DataAccessException;
}
