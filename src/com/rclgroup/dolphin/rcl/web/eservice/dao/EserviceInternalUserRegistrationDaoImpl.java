/*------------------------------------------------------
 EserviceInternalUserRegistrationDaoImpl.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -Joga------*/

package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInternalUserRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ADMIN_LOGIN;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ESV_CHECK_AVAILABLE_ID;
import com.rclgroup.dolphin.rcl.web.util.RutMessage;

public class EserviceInternalUserRegistrationDaoImpl extends AncestorJdbcDao
		implements EserviceInternalUserRegistrationDao {

	private EserviceRegistrationDaoImplOrcle jdbcTemplateOrcl;

	private DriverManagerDataSource driverMangerDataBase;

	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate3;

	public void setDriverMangerDataBase(DriverManagerDataSource driverMangerDataBase) {

		this.driverMangerDataBase = driverMangerDataBase;
		this.jdbcTemplate3 = new JdbcTemplate(driverMangerDataBase);
	}

	public void setJdbcTemplateOrcl(EserviceRegistrationDaoImplOrcle jdbcTemplateOrcl) {
		this.jdbcTemplateOrcl = jdbcTemplateOrcl;
	}

	public Map findCountryList() {
		return Collections.EMPTY_MAP;
	}

	public Map checkAvailableUserId(String userId) {
		Map resultMap = null;

		JdbcStoredProcedure storeProcedure = null;

		String[][] arrParam = null;
		String availableFlag = null;
		String errorMsg = null;
		try {
			if (userId != null && !BLANK.equals(userId)) {
				arrParam = new String[][] { { P_I_V.USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId },
						{ P_O_V.FLAG, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

				PRR_ESV_CHECK_AVAILABLE_ID registor = new PRR_ESV_CHECK_AVAILABLE_ID(getJdbcTemplate(), resultMap);
				availableFlag = registor.executeDbProcedureAdmin(userId);

				if (availableFlag == null || BLANK.equals(availableFlag) || YES.equals(availableFlag)) {
					errorMsg = "User ID already in use.";
				}

			} else {
				errorMsg = "No paramameter input.";
			}
		} catch (Exception ex) {
			errorMsg = ex.getMessage();
			ex.printStackTrace();
		} finally {
			if (resultMap == null) {
				resultMap = new HashMap();
			}
			if (errorMsg != null && !BLANK.equals(errorMsg)) {
				resultMap.put(P_O_V.ERR_CD, EXCEPTION);
				resultMap.put(P_O_V.ERR_DESC, errorMsg);
			}
		}
		return resultMap;
	}

	public Map verifyPassword(String password) {
		return null;
	}

	public Map insertRegistration(Map<String, String> mapParams, EserviceInternalUserRegistrationUim form,
			RegistrationOrclDao daoOrl) {

		System.out.println("[EserviceRegistrationDaoImpl][insertRegistration][Begin]");

		Map resultMap = null;
		JdbcStoredProcedure storeProcedure = null;
		String[][] arrParam = null;
		String errorMsg = null;
		/* Begin @01 */
		String representedCompanyFlag = null;

		try {
			if (mapParams != null && !mapParams.isEmpty()) {
				// this for if user selected E-Rate then we need to send e-booking

				arrParam = new String[][] {
						{ P_I_V.USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(P_I_V.USR_ID) },
						{ P_I_V.NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(P_I_V.NAME) },
						{ P_I_V.PASSWORD, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(P_I_V.PASSWORD) },
						{ P_I_V.EMAIL, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) mapParams.get(P_I_V.EMAIL) },
						{ P_I_V.LOCATION, BLANK + ORACLE_VARCHAR, PARAM_IN,
								(String) mapParams.get(form.getLocation()) }, };

				storeProcedure = daoOrl.getStoreProcedure(PCR_ESV_REGISTER.PRR_ADMIN_LOGIN, null, arrParam);

				PRR_ADMIN_LOGIN login = new PRR_ADMIN_LOGIN(getJdbcTemplate(), mapParams.get(P_I_V.USR_ID),
						mapParams.get(P_I_V.NAME), (String) mapParams.get(P_I_V.PASSWORD), form.getLocation(), (String) mapParams.get(P_I_V.EMAIL));

				if (true) {
					String result = login.executeDbProcedure();
					try {
						storeProcedure.execute();
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (result.equalsIgnoreCase("F")) {
						errorMsg = RutMessage.MSG002;
					}

					/* Begin @01 */
					if (errorMsg == null || errorMsg.equals("")) {
						arrParam = new String[][] {
								{ P_I_V.USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN,
										(String) mapParams.get(P_I_V.USR_ID).toUpperCase() },
								{ P_O_V.ERROR, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

					}
					/* End @01 */

				}
			} else {
				errorMsg = RutMessage.MSG003;
			}
		} catch (Exception ex) {
			errorMsg = ex.getMessage();
			ex.printStackTrace();
		} finally {
			if (resultMap == null) {
				resultMap = new HashMap();
			}
			if (errorMsg != null && !BLANK.equals(errorMsg)) {
				resultMap.put(P_O_V.ERR_CD, EXCEPTION);
				resultMap.put(P_O_V.ERR_DESC, errorMsg);
			}

			System.out.println("[EserviceRegistrationDaoImpl][insertRegistration][End]");
		}
		return resultMap;
	}

	public Map updateRegistration(Map<String, String> paramMap, EserviceRegistrationUim form) {
		Map resultMap = null;
		return resultMap;

	}

	@Override
	public List<ContryMod> getCountryCodeNameList() {

		String POL_POD_QUERY = "select name AS COUNTRY_NAME,code AS COUNTRY_CODE from country_code order by  COUNTRY_NAME";

		List<ContryMod> lit = getJdbcTemplate().query(POL_POD_QUERY, new CountruCombod());

		return lit;
	}

	class CountruCombod implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int arg) throws SQLException {

			// ContryMod model =new ContryMod();

			ContryMod obj = new ContryMod();
			obj.setContryName(rs.getString("COUNTRY_NAME"));
			obj.setCode(rs.getString("COUNTRY_CODE"));

			return obj;
		}

	}


}
