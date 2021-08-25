package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ESV_INS_UPLOAD_HDR {

	JdbcTemplate jdbcTemplate;
	Map amapParam ;
	
	public PRR_ESV_INS_UPLOAD_HDR(JdbcTemplate jdbcTemplate,Map amapParam) {
		this.jdbcTemplate=jdbcTemplate;
		this.amapParam=amapParam;
	}
	
	public void executeDbProcedure() {
		
		int V_UPLOAD_HDR_SEQ=jdbcTemplate.queryForInt("SELECT nextval('sr_mnr_fuh01')");
		V_UPLOAD_HDR_SEQ=V_UPLOAD_HDR_SEQ;
		String query=" INSERT INTO ZFU_FILES_UPLOAD_HEADER  " + 
				"                  (PK_UPLOAD_HDR_SEQ  " + 
				"                  ,FK_REFERENCE_SEQ  " + 
				"                  ,MODULE  " + 
				"                  ,RECORD_ADD_USER  " + 
				"                  ,RECORD_ADD_DATE  " + 
				"                  ,RECORD_CHANGE_USER  " + 
				"                  ,RECORD_CHANGE_DATE  " + 
				"                  ,RECORD_STATUS)  " + 
				"      VALUES      ("+V_UPLOAD_HDR_SEQ+ 
				"                  ,'"+amapParam.get("P_I_V_BOOKING_NO")+"' " + 
				"                  ,'"+amapParam.get("P_I_V_MODULE")+"'  " + 
				"                  ,'"+amapParam.get("P_I_V_USER_ID")+"'  " + 
				"                  ,now()  " + 
				"                  ,'"+amapParam.get("P_I_V_USER_ID")+"'  " + 
				"                  ,now()  " + 
				"                  ,'A')";
		
		jdbcTemplate.update(query);
		
		amapParam.put("P_O_V_UPLD_SEQ",V_UPLOAD_HDR_SEQ+"" );
		amapParam.put("P_O_V_ERR_CD",null );
		amapParam.put("P_O_V_ERR_DESC",null );
	}
}
