package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ESV_INS_UPLOAD_DTL {
	

	JdbcTemplate jdbcTemplate;
	Map amapParam ;
	
	public PRR_ESV_INS_UPLOAD_DTL(JdbcTemplate jdbcTemplate,Map amapParam) {
		this.jdbcTemplate=jdbcTemplate;
		this.amapParam=amapParam;
	}
	
	public void executeDbProcedure() {
	
		 int  V_UPLOAD_DTL_SEQ;
		 int  V_UPOAD_SEQ;
		 String   V_FLAG;
		 int  V_CHECK_EXISTS;
		 
		 String countQuery="SELECT COUNT (*)" + 
		 		"          " + 
		 		"         FROM   ZFU_FILES_UPLOAD_HEADER FUH" + 
		 		"               ,ZFU_FILES_UPLOAD_DETAIL FUD" + 
		 		"         WHERE  FUD.FK_UPLOAD_HDR_SEQ = FUH.PK_UPLOAD_HDR_SEQ" + 
		 		"                AND FUH.FK_REFERENCE_SEQ ='"+ amapParam.get("P_I_V_BOOKING_NO")+"' " + 
		 		"                AND FUD.FILE_NAME = '"+ amapParam.get("P_I_V_FILE_NAME")+"'";
		 
		Integer count=jdbcTemplate.queryForInt(countQuery);
		
		if(count==0) {
			
			 V_UPLOAD_DTL_SEQ=jdbcTemplate.queryForInt("SELECT nextval('sr_mnr_fud01')");
			 
			 String V_UPOAD_SEQ_QUERY="SELECT CASE  " + 
			 		"                      WHEN COUNT (*) > 0  " + 
			 		"                         THEN MAX (UPLOAD_SEQNO) + 1  " + 
			 		"                      ELSE 1  " + 
			 		"                   END  " + 
			 		"              " + 
			 		"            FROM   ZFU_FILES_UPLOAD_DETAIL  " + 
			 		"            WHERE  FK_UPLOAD_HDR_SEQ = '"+amapParam.get("P_I_V_UPLD_HDR_SEQ")+"'";
			
			 V_UPOAD_SEQ= (int) jdbcTemplate.queryForObject(V_UPOAD_SEQ_QUERY,Integer.class);
			 
			 String insertQuery="INSERT INTO  ZFU_FILES_UPLOAD_DETAIL  " + 
			 		"                        (PK_UPLOAD_DTL_SEQ  " + 
			 		"                        ,FK_UPLOAD_HDR_SEQ  " + 
			 		"                        ,UPLOAD_SEQNO  " + 
			 		"                        ,FILE_NAME  " + 
			 		"                        ,TECHNICAL_FILE_TYPE  " + 
			 		"                        ,RECORD_ADD_USER  " + 
			 		"                        ,RECORD_ADD_DATE  " + 
			 		"                        ,RECORD_CHANGE_USER  " + 
			 		"                        ,RECORD_CHANGE_DATE  " + 
			 		"                        ,RECORD_STATUS)  " + 
			 		"            VALUES      ("+V_UPLOAD_DTL_SEQ  +
			 		"                        ,'"+amapParam.get("P_I_V_UPLD_HDR_SEQ")+  "'" + 
			 		"                        ,"+V_UPOAD_SEQ + 
			 		"                        ,'"+amapParam.get("P_I_V_FILE_NAME")+  "'" + 
			 		"                        ,'"+amapParam.get("P_I_V_TECHNICAL_FILE_TYPE")+  "'" + 
			 		"                        ,'"+amapParam.get("P_I_V_USER_ID")+  "'" + 
			 		"                        ,now()  " + 
			 		"                        ,'"+amapParam.get("P_I_V_USER_ID")+  "'" + 
			 		"                        ,now()  " + 
			 		"                        ,'A')";
			 
			 jdbcTemplate.update(insertQuery);
			 
			 amapParam.put("P_O_V_ERR_DESC", null);
			 amapParam.put("P_O_V_ERR_CD", null);
			 
		}else {
			amapParam.put("P_O_V_ERR_DESC", "Duplicate File Name "+ amapParam.get("P_I_V_FILE_NAME"));
			amapParam.put("P_O_V_ERR_CD", -20000);
		}
		
		
		
	}
}
