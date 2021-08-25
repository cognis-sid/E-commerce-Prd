package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRR_ERCL_GET_LIST_QTN {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRR_ERCL_GET_LIST_QTN(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
		
	String 	  L_COUNT ;
	String	  L_ARRAY ;
	String	  L_ARRAY1 ;
	String	  V_SQL  ;
	String	  V_SUB_SQL ;
	String	  V_SIZE  ;
	String	  V_TYPE  ;
	String	  V_SQL1  ;
		
	if( map.get("P_I_V_POL")==null && map.get("P_I_V_POD") ==null && map.get("P_I_V_SIZE")==null && map.get("P_I_V_TYPE") ==null )
	{
		V_SQL=  " SELECT DISTINCT QAQUNO  AS QUOTATION_NO  " + 
				"                FROM SEALINER.QTP001 H,SEALINER.SC_PRSN_LOG_INFO L  " + 
				"                WHERE H.QAIQCD = L.ORG_CODE  " + 
				"                AND to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999') BETWEEN H.QAEFDT AND H.QAEXDT  " + 
				"                AND H.QASTAT = 'C'  " + 
				"                AND L.PRSN_LOG_ID='"+map.get("P_I_V_USR_ID")+"'  " + 
				"				ORDER BY QAQUNO";
		
	}else {
		
		
		
	}
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
}
