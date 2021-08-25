package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ESI_VAL_DATA_CHANGE {
	
	
	JdbcTemplate jdbcTemplate;
	Map map;

	public PRR_ESI_VAL_DATA_CHANGE(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
		

		 boolean 		V_VLD_PASS_FAIL;
		  int 	  		V_COUNT = 0;
		  String  		V_ORI_COMM_GROUP_CODE;
		  String 		V_ORI_COMM_CODE;
		  int 			V_ORI_COMM_WKG;
		  String 		V_ORI_PACKAGE_KIND_CODE;
		  int 			V_ORI_NO_OF_PACKAGE;
		  int 			V_ORI_CON_MEASUREMENT;
		  String 		V_ESI_COMM_GROUP_CODE;
		  String 		V_ESI_COMM_CODE;
		  int 			V_ESI_COMM_WKG;
		  String 		V_ESI_PACKAGE_KIND_CODE ;
		  int 			V_ESI_NO_OF_PACKAGE;
		  int 			V_ESI_CON_MEASUREMENT;
		  int 			V_ORI_CON_COUNT;
		  int 			V_ESI_CON_COUNT;
		  String 		V_ORI_VES_NO;
		  String 		V_ORI_VOY_NO;
		  String 		V_ORI_POL_NO;
		  String 		V_ORI_POD_NO;
		  String 		V_ESI_VES_NO;
		  String 		V_ESI_VOY_NO;
		  String 		V_ESI_POL_NO;
		  String 		V_ESI_POD_NO;
		  String 		V_BL_NO;
		  String 		V_BKP_STATUS;
		  String 		V_ESI_CHANGE_DATE; 
		  String 		V_ORI_CHANGE_DATE; 
		  String 		BookingNo=(String) map.get("P_I_V_BOOKING_NO");
		  
		String query_v_count="SELECT COUNT(*)  FROM ESV_SI_HEADER  " + 
				"         WHERE FK_BOOKING_NO = '"+BookingNo+"' " + 
				"           AND ESI_STATUS = 'I' " + 
				"           AND RECORD_STATUS = 'A'";
		
		
		
	map.put("P_O_V_RESULT", null);	
	}
}
