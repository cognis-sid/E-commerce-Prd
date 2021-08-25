package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao.P_I_V;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao.P_O_V;

public class PRR_ESV_ACT_CONTRACT_PARTY_HDR {

	private JdbcTemplate jdbcTemplate;
	private Map map;
	
	public PRR_ESV_ACT_CONTRACT_PARTY_HDR(JdbcTemplate jdbcTemplate, Map resultMap) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=resultMap;
	}

	public void executeDbProcedure() {
		
		String query="UPDATE VASAPPS.ESV_CONTRACT_PARTY_PP_HDR " + 
				"      SET REACT_PWD = '"+map.get(P_I_V.REACT_PWD)+ "'  " + 
				"          , RECORD_CHANGE_DATE = now() " + 
				"          , RECORD_CHANGE_USER = '"+map.get(P_I_V.USR_ID)+"' " + 
				"    WHERE PK_ESV_PP_HDR_SEQ = '"+map.get(P_I_V.PK_ESV_PP_HDR_SEQ)+"'";
		
		jdbcTemplate.update(query);
		
		map.put(P_O_V.ERROR, "OK");
		
	}
}
