/*------------------------------------------------------
 EserviceInternalUserRegistrationDao.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -Joga */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInternalUserRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;

public abstract interface EserviceInternalUserRegistrationDao {
	public static final String DAO_NAME = "EserviceInternalUserRegistrationDao";

	public static final String EXCEPTION = "EXCEPTION";

	public interface PCR_ESV_REGISTER {
		public final String PACKAGE_NAME = "VASAPPS.PCR_ESV_REGISTER";
		public final String PRR_ADMIN_LOGIN = PACKAGE_NAME + ".PRR_ADMIN_LOGIN";
			
	}

	public interface P_I_V {
		public final String NAME = "P_I_V_NAME";
		public final String LAST_NAME = "P_I_V_LAST_NAME";
		public final String EMAIL = "P_I_V_EMAIL";
		public final String USR_ID = "P_I_V_USR_ID";
		public final String PASSWORD = "P_I_V_PASSWORD";
		public final String LOCATION = "P_I_V_LOCATION";

	}

	public interface P_O_V {
		public final String FLAG = "P_O_V_FLAG";
		public final String ERR_CD = "P_O_V_ERR_CD";
		public final String ERR_DESC = "P_O_V_ERR_DESC";
		public final String ERROR = "P_O_V_ERROR";
		}

	public Map checkAvailableUserId(String userId) throws BusinessException, DataAccessException;

	public Map insertRegistration(Map<String, String> paramMap, EserviceInternalUserRegistrationUim form,
			RegistrationOrclDao daoOrl) throws BusinessException, DataAccessException;

	public List<ContryMod> getCountryCodeNameList();
}
