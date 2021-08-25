package com.rclgroup.dolphin.rcl.web.procedure.user;

import java.util.Arrays;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInternalUserRegistrationDao.P_I_V;

public class PRR_ADMIN_LOGIN {
	private JdbcTemplate jdbcTemplate;
	String P_I_V_USR_ID;
	String P_I_V_NAME;
	String P_I_V_PASSWORD;
	String P_I_V_EMAIL;
	String[] P_I_V_LOCATION;
	
	public PRR_ADMIN_LOGIN(JdbcTemplate jdbcTemplate, String P_I_V_USR_ID,String P_I_V_NAME,String P_I_V_PASSWORD,String[] P_I_V_LOCATION, String P_I_V_EMAIL) {
		this.jdbcTemplate = jdbcTemplate;
		this.P_I_V_USR_ID=P_I_V_USR_ID;
		this.P_I_V_NAME=P_I_V_NAME;
		this.P_I_V_PASSWORD=P_I_V_PASSWORD;
		this.P_I_V_LOCATION=P_I_V_LOCATION;
		this.P_I_V_EMAIL = P_I_V_EMAIL;
	}

	public String executeDbProcedure() {

		String str=Arrays.toString(this.P_I_V_LOCATION);
		str = convertStringArrayToString(this.P_I_V_LOCATION, "#");
        
		String sqlQry =" INSERT INTO RCLTBLS.esm_admin_login (login_id, user_name,pswd,location,email_id) VALUES (UPPER(LTRIM(RTRIM('"+P_I_V_USR_ID+"'))),'"+ P_I_V_NAME+"','"+ P_I_V_PASSWORD+"','"+ str+"','"+P_I_V_EMAIL+"')";
		jdbcTemplate.update(sqlQry);
	   return "";
	}
	
	private static String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}
}
