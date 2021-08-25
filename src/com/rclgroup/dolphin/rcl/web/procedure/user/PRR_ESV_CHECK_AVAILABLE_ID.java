package com.rclgroup.dolphin.rcl.web.procedure.user;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ESV_CHECK_AVAILABLE_ID {
	
	JdbcTemplate jdbcTemplate;
	Map map;
	String query1;
	
	public PRR_ESV_CHECK_AVAILABLE_ID(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	
	public String executeDbProcedure(String P_I_V_USR_ID) {
	 int V_COUNT =0;

		String sqlQuery = "SELECT COUNT(1) FROM RCLTBLS.ESM_USER_LOGIN WHERE USER_ID = UPPER(LTRIM(RTRIM('"+P_I_V_USR_ID+"')))";

		V_COUNT = jdbcTemplate.queryForInt(sqlQuery, new Object[] {});

		if(V_COUNT > 0)
		   return "Y" ;
		else
		  return "N" ;
		}
	
	public String executeDbProcedureAdmin(String P_I_V_USR_ID) {
		 int V_COUNT =0;

			String sqlQuery = "SELECT COUNT(1) FROM RCLTBLS.esm_admin_login WHERE login_id = UPPER(LTRIM(RTRIM('"+P_I_V_USR_ID+"')))";

			V_COUNT = jdbcTemplate.queryForInt(sqlQuery, new Object[] {});

			if(V_COUNT > 0)
			   return "Y" ;
			else
			  return "N" ;
			}


}
