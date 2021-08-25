package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_GET_SHIPMENT_TERM_COMBO extends AncestorJdbcDao {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRE_GET_SHIPMENT_TERM_COMBO(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	public void executeDbProcedure() {
		
		String query1=" SELECT  " + 
				"                MMMODE AS \"CODE\", " + 
				"                MMMODE AS \"DESC\"  " + 
				"            	 FROM  " + 
				"                ITP070  " + 
				"            	 GROUP BY  " + 
				"                MMMODE  " + 
				"            	 ORDER BY  " + 
				"                MMMODE";	
		System.out.println("PRE_GET_SHIPMENT_TERM_COMBO : "+query1);
		List<ComboVO> list=jdbcTemplate.query(query1, new Object[] {}, new ComboRowMapper());
		
		Map outPut=new HashMap();
		outPut.put("P_O_V_REF_CURSOR_DATA",list);
		outPut.put("P_O_V_ERROR",null);
		
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}

	
	
}
