package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.AncestorJdbcDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;

public class PRE_GET_QUOTATION_COMBO extends AncestorJdbcDao{

	 private JdbcTemplate jdbcTemplate;
	 private Map map ;
	 
	public PRE_GET_QUOTATION_COMBO(JdbcTemplate jdbcTemplate,Map map){
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;	
	}

	public void executeDbProcedure() {
		String query1="SELECT  " + 
				"                QAQUNO as  \"CODE\" ," + 
				"                QAQUNO as  \"DESC\"  " + 
				"            FROM  " + 
				"                QTP001 QTP1,  " + 
				"                SC_PRSN_LOG_INFO SPLI  " + 
				"            WHERE  " + 
				"                SPLI.PRSN_LOG_ID = '"+map.get("p_i_v_user_id") +"'" + 
				"                AND SPLI.ORG_CODE      = QTP1.QAIQCD " + 
				"                AND SPLI.ORG_CODE     IS NOT NULL " + 
// Need to re Visit Cognis"      AND to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g999') BETWEEN QAEFDT AND QAEXDT " + 
				"                AND QASTAT = 'C'  " + 
				"            ORDER BY  " + 
				"                QAQUNO";
		
		System.out.println("query PRE_GET_QUOTATION_COMBO : " + query1);
		
		List<EserviceNewWebBookingMod> list=jdbcTemplate.query(query1,new Object[] { },  new ComboRowMapper());
		
		Map outPut=new HashMap();
		outPut.put("P_O_V_REF_CURSOR_DATA",list);
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
	 
}
