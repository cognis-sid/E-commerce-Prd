package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_DEL_EQ_SIZE_TYPE {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRE_DEL_EQ_SIZE_TYPE(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
		
		String deleteQuery1="DELETE SEALINER.BOOKING_SUPPLIER_DETAIL  " + 
				"        WHERE  BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'  " + 
				"        AND EQP_SIZETYPE_SEQNO = '"+map.get("P_I_V_SEQ")+"'";
		jdbcTemplate.update(deleteQuery1);
		
		String deleteQuery2="DELETE SEALINER.BKP032 " + 
				"        WHERE BCBKNO='"+map.get("P_I_V_BOOKING_NO")+"' " + 
				"        AND EQP_SIZETYPE_SEQNO='"+map.get("P_I_V_SEQ")+"'";
		jdbcTemplate.update(deleteQuery2);
		
		String deleteQuery3="DELETE  ESV_WB_SIZETYPE " + 
				"        WHERE PK_BOOKING_NO='"+map.get("P_I_V_BOOKING_NO")+"' " + 
				"        AND EQ_SIZE_TYPE_SEQ='"+map.get("P_I_V_SEQ")+"'";
		jdbcTemplate.update(deleteQuery3);
		
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
}
