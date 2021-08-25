/*------------------------------------------------------
 EserviceRegistrationDao.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -
- Change Log -------------------------------------------
##     DD/MM/YY    �User-  -TaskRef-   -ShortDescription-
01     07/10/14    Pratya  @01         PD_CR_20140826_ESV [Contract Party for registeration]
02     03/06/15    Sarawut @02         Add method checkUserRoleCD
03     17/12/15    Watchakorn          add method activateRepresentedCompany
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PolPod;
import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;

public abstract interface EserviceRegistrationDao {
	public static final String DAO_NAME = "EserviceRegistrationDao";
	public static final String ESV_LIST_COUNTRY_REF_CUR = "ESV_LIST_COUNTRY_REF_CUR";

	/* Begin @01 */
	public static final String ADD = "ADD";
	public static final String UPD = "UPD";
	public static final String DEL = "DEL";

	public static final String ACTIVE = "A";
	public static final String SUSPENDED = "S";
	/* End @01 */

	public interface USER_MODE {
		public final String INTERNAL = "RR";
		public final String INTERNAL_MRES = "MA";
		public final String EXTERNAL = "R";
	}

	/* Begin @01 */
	public interface ENOTICE_MODE {
		public final String REGISTRATION = "REGISTRATION";
		public final String MANAGEACT = "MA";
		public final String REGISTRATION_REVIEW = "RR";
		public final String MANAGE_PORT_PAIR = "MPP";
	}
	/* End @01 */

	public static final String EXCEPTION = "EXCEPTION";

	public interface PCR_ESV_REGISTER {
		public final String PACKAGE_NAME = "VASAPPS.PCR_ESV_REGISTER";
		public final String PRR_ESV_LOGIN = PACKAGE_NAME + ".PRR_ESV_LOGIN";
		public final String PRR_ESV_GET_PWD = PACKAGE_NAME + ".PRR_ESV_GET_PWD";
		public final String PRR_ESV_CHECK_AVAILABLE_ID = PACKAGE_NAME + ".PRR_ESV_CHECK_AVAILABLE_ID";
		public final String PRR_ESV_GET_COUNTRY_LIST = PACKAGE_NAME + ".PRR_ESV_GET_COUNTRY_LIST";
		public final String PRR_ESV_CREATE_NEW_CUST = PACKAGE_NAME + ".PRR_ESV_CREATE_NEW_CUST";
		public final String PRR_ESV_GET_USR_INFO = PACKAGE_NAME + ".PRR_ESV_GET_USR_INFO";
		public final String PRR_ESV_USER_SERVICE_LIST = PACKAGE_NAME + ".PRR_ESV_USER_SERVICE_LIST";
		public final String PRR_ESV_RR_SUBMIT = PACKAGE_NAME + ".PRR_ESV_RR_SUBMIT";
		public final String PRR_ESV_MANAGE_ACCOUNT = PACKAGE_NAME + ".PRR_ESV_MANAGE_ACCOUNT";
		public final String PRR_ESV_GET_CUSTOMER_CODE = PACKAGE_NAME + ".PRR_ESV_GET_CUSTOMER_CODE";

		/* Begin @01 */
		public final String PRR_ESV_INS_CONTRACT_PARTY = PACKAGE_NAME + ".PRR_ESV_INS_CONTRACT_PARTY";
		public final String PRR_ESV_UPD_CONTRACT_PARTY = PACKAGE_NAME + ".PRR_ESV_UPD_CONTRACT_PARTY";
		public final String PRR_ESV_GET_CONTRACT_PARTY = PACKAGE_NAME + ".PRR_ESV_GET_CONTRACT_PARTY";
		public final String PRR_ESV_DEL_CONTRACT_PARTY = PACKAGE_NAME + ".PRR_ESV_DEL_CONTRACT_PARTY";

		public final String PRR_ESV_REGISTRATION_ENOTICE = PACKAGE_NAME + ".PRR_ESV_REGISTRATION_ENOTICE";
		/* End @01 */

		public final String PRR_ESV_GET_CUSTOMER_CODE_MPP = PACKAGE_NAME + ".PRR_ESV_GET_CUSTOMER_CODE_MPP";
		public final String PRR_ESV_CHECK_USER_ROLE_CD = PACKAGE_NAME + ".PRR_ESV_CHECK_USER_ROLE_CD";

		// ##03 Begin
		public final String PRR_ESV_ACT_CONTRACT_PARTY_HDR = PACKAGE_NAME + ".PRR_ESV_ACT_CONTRACT_PARTY_HDR";
		// ##03 End
	}

	public interface P_I_V {
		public final String FIRST_NAME = "P_I_V_FIRST_NAME";
		public final String LAST_NAME = "P_I_V_LAST_NAME";
		public final String EMAIL = "P_I_V_EMAIL";
		public final String USR_ID = "P_I_V_USR_ID";
		public final String PASSWORD = "P_I_V_PASSWORD";
		public final String CMP_NAME = "P_I_V_CMP_NAME";
		public final String ADDRESS1 = "P_I_V_ADDRESS1";
		public final String ADDRESS2 = "P_I_V_ADDRESS2";
		public final String ADDRESS3 = "P_I_V_ADDRESS3";
		public final String ADDRESS4 = "P_I_V_ADDRESS4";
		public final String CITY = "P_I_V_CITY";
		public final String STATE = "P_I_V_STATE";
		public final String COUNTRY = "P_I_V_COUNTRY";
		public final String PHONENO = "P_I_V_PHONENO";
		public final String FAXNO = "P_I_V_FAXNO";
		public final String WEB_BKG_FLAG = "P_I_V_WEB_BKG_FLAG";
		public final String ESI_FLAG = "P_I_V_ESI_FLAG";
		public final String EBL_FLAG = "P_I_V_EBL_FLAG";
		public final String CUST_NAME = "P_I_V_CUST_NAME";
		public final String COUNTRY_CODE = "P_I_V_COUNTRY_CODE";
		public final String ROLE = "P_I_V_ROLE";
		public final String FSC = "P_I_V_FSC";
		public final String CUST_TYPE = "P_I_V_CUST_TYPE";
		public final String CALL_FROM = "P_I_V_CALL_FROM";
		public final String SFU = "P_I_V_SFU";
		public final String ORG_CODE = "P_I_V_ORG_CODE";
		public final String NEW_USR_ID = "P_I_V_NEW_USR_ID";
		public final String NEW_PWD = "P_I_V_NEW_PWD";
		public final String COUNTRY_CD = "P_I_V_COUNTRY_CD";
		public final String COMPANY_NAME = "P_I_V_COMPANY_NAME";
		public final String REJECT_REASON = "P_I_V_REJECT_REASON";
		public final String P_ORG_CODE = "P_ORG_CODE";

		/* Begin @01 */
		public final String PK_PORT_PAIR_SEQ = "P_I_V_PK_PORT_PAIR_SEQ";
		public final String FK_USER_ID = "P_I_V_FK_USER_ID";
		public final String CONTRACT_PARTY_CODE = "P_I_V_CONTRACT_PARTY_CODE";
		public final String CONTRACT_PARTY_NAME = "P_I_V_CONTRACT_PARTY_NAME";
		public final String POL = "P_I_V_POL";
		public final String POD = "P_I_V_POD";
		public final String EFF_DATE = "P_I_V_EFF_DATE";
		public final String EXP_DATE = "P_I_V_EXP_DATE";
		public final String TYPE = "P_I_V_TYPE";
		public final String STATUS = "P_I_V_STATUS";
		public final String FLAG = "P_I_V_FLAG";
		public final String NOTICE_FROM = "P_I_V_NOTICE_FROM";
		/* End @01 */

		// ##03 Begin
		public final String PK_ESV_PP_HDR_SEQ = "P_I_V_PK_ESV_PP_HDR_SEQ";
		public final String REACT_PWD = "P_I_V_REACT_PWD";
		public final String EXCLUDE_EXP = "P_I_V_EXCLUDE_EXP";
		// ##03 End

		// @04 add param user login 31/10/2016
		public final String USR_LOGIN = "P_I_V_USR_LOGIN";

		// #05 START
		public final String NON_RA = "P_I_V_NON_RA";
		// #05 END
		public final String CUST_CODE = "P_I_V_CUST_CODE";

	}

	public interface P_O_V {
		public final String FLAG = "P_O_V_FLAG";
		public final String PWD = "P_O_V_PWD";
		public final String COUNTRY_DATA = "P_O_V_COUNTRY_DATA";
		public final String CUST_CODE = "P_O_V_CUST_CODE";
		public final String ERR_CD = "P_O_V_ERR_CD";
		public final String ERR_DESC = "P_O_V_ERR_DESC";
		public final String USR_NAME = "P_O_V_USR_NAME";
		public final String CMP_NAME = "P_O_V_CMP_NAME";
		public final String ADDRESS1 = "P_O_V_ADDRESS1";
		public final String ADDRESS2 = "P_O_V_ADDRESS2";
		public final String ADDRESS3 = "P_O_V_ADDRESS3";
		public final String ADDRESS4 = "P_O_V_ADDRESS4";
		public final String EMAIL = "P_O_V_EMAIL";
		public final String CITY = "P_O_V_CITY";
		public final String STATE = "P_O_V_STATE";
		public final String COUNTRY = "P_O_V_COUNTRY";
		public final String PHONENO = "P_O_V_PHONENO";
		public final String FAXNO = "P_O_V_FAXNO";
		public final String LIST_SERVICE_DATA = "P_O_V_LIST_SERVICE_DATA";
		public final String CONTROL_FSC = "P_O_V_CONTROL_FSC";
		public final String FSC = "P_O_V_FSC";
		public final String CUST_TYPE = "P_O_V_CUST_TYPE";

		/* Begin @01 */
		public final String ERROR = "P_O_V_ERROR";
		public final String CONTRACT_PARTY_DATA = "P_O_V_CONTRACT_PARTY_DATA";
		/* End @01 */

		public final String USER_ROLE_CD = "P_O_V_USER_ROLE_CD";
	}

	public interface CAPTCHA_CONFIG {
		public final String TYPE = "ESV_CAPCHA_KEY";
		public final String CD_PRIVATE_KEY = "PRIVATE_KEY";
		public final String CD_PUBLIC_KEY = "PUBLIC_KEY";
		public final String LIST_SERVICE_DATA = "P_O_V_LIST_SERVICE_DATA";
	}

	public Map findCountryList() throws BusinessException, DataAccessException;

	public Map checkAvailableUserId(String userId) throws BusinessException, DataAccessException;

	public Map verifyPassword(String paramString) throws BusinessException, DataAccessException;

	public Map getCountryList() throws BusinessException, DataAccessException;

	public Map<String, String> getCaptchaKey() throws BusinessException, DataAccessException;

	public Map createCRMCustomer(Map<String, String> paramMap) throws BusinessException, DataAccessException;

	public Map findUserRegisteredInformation(String userId, String fscCode) throws Exception;

	public Map findUserRegisteredService(String userId, String userMode) throws Exception;

	public Map insertRegistration(Map<String, String> paramMap, EserviceRegistrationUim form,
			RegistrationOrclDao daoOrl) throws BusinessException, DataAccessException, Exception;

	public Map updateRegistration(Map<String, String> paramMap, EserviceRegistrationUim form)
			throws BusinessException, DataAccessException;

	public Map updateRegistrationReview(Map<String, String> paramMap, EserviceRegistrationUim form)
			throws BusinessException, DataAccessException;

	public Map updateRejectReason(Map<String, String> paramMap) throws BusinessException, DataAccessException;

	public Map findCustomerInfo(String customerName, String countryCode) throws BusinessException, DataAccessException;

	public Map findCustomerInfoMPP(String userId, String contactPartyName, String flag);

	public String getControlFSCStatus(String fscCode) throws BusinessException, DataAccessException;

	public String checkUserRoleCD(String userId) throws BusinessException, DataAccessException;

	/* Begin @01 */
	public String addContractPartyPortPair(EserviceContractPartyPortPairMod mod);

	public String updContractPartyPortPair(EserviceContractPartyPortPairMod mod);

	public String delContractPartyPortPair(EserviceContractPartyPortPairMod mod);

	public List<EserviceContractPartyPortPairMod> getContractPartyPortPair(EserviceContractPartyPortPairMod mod,
			String excludeExpireContractParty) throws CustomDataAccessException;

	public Map sendEnoticeForContractPartyPortPair(Map<String, String> paramMap)
			throws BusinessException, DataAccessException;
	/* End @01 */

	/* ##03 Begin */
	public String activateRepresentedCompany(EserviceContractPartyPortPairMod mod);
	/* ##03 End */

	public List<PolPod> getCodeForPolPod(EserviceRegistrationUim form);

	public List<ContryMod> getCountryCodeNameList();
	
	public String checkCustomerCodeAvailable(String customerCode,String country);

	public String getRrepresentedCompany(String customerCode);

	public void getPicMailId(EserviceRegistrationUim form);
}
