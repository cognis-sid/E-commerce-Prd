package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_DEL_COMMODITY_DATA {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRE_DEL_COMMODITY_DATA(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
			
		String query1=" DELETE FROM SEALINER.BKP050  " + 
				"     WHERE BWBKNO='"+map.get("P_I_V_BOOKING_NO")+"'  " + 
				"     AND BWCMSQ='"+map.get("P_I_V_SEQ")+"'";
		
		jdbcTemplate.update(query1);
		
		String query2="DELETE FROM SEALINER.BKP007 " + 
				"     WHERE BGBKNO = '"+map.get("P_I_V_BOOKING_NO")+"' " + 
				"     AND BGSEQN = '"+map.get("P_I_V_SEQ")+"'";
		
		jdbcTemplate.update(query2);
		
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
}
