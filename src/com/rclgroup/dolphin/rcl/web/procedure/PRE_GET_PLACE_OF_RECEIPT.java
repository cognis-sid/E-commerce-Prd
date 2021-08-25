package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_GET_PLACE_OF_RECEIPT extends AncestorJdbcDao{

	JdbcTemplate jdbcTemplate;
	Map map;
	String query1;
	public PRE_GET_PLACE_OF_RECEIPT(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
	
		
		if(map.get("P_I_V_PORT_OF_LOADING").equals("THLCH")) {
			List<ComboVO> list=new ArrayList<ComboVO>();
			ComboVO combo1=new  ComboVO();
			combo1.setCode("THLCH");combo1.setName("LAEM CHABANG");
			ComboVO combo3=new  ComboVO();
			combo3.setCode("THBKK");combo3.setName("BANGKOK (BARGE)");
			ComboVO combo4=new  ComboVO();
			combo4.setCode("THLKR");combo4.setName("BANGKOK (LAT KRABANG)");
			
			list.add(combo1);
			list.add(combo3);
			list.add(combo4);
			
			Map outPut=new HashMap();
			outPut.put("P_O_V_REF_CURSOR_DATA",list);
			outPut.put("P_O_V_ERROR",null);
			
			map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
			
		}else {
		
		String query1=" SELECT  " + 
				"	                POINT_CODE AS \"CODE\",  " + 
				"	                POINT_NAME AS \"DESC\"  " + 
				"	            FROM  " + 
				"	                POINT_MASTER PM  " + 
				"	                WHERE RECORD_STATUS = 'A'  " + 
				"	                AND  ( COUNTRY_CODE    =(select fk_country_code from cam_point cp where pk_point_code='"+map.get("P_I_V_PORT_OF_LOADING")+"') OR  point_code =(select fk_country_code from cam_point cp where pk_point_code='"+map.get("P_I_V_PORT_OF_LOADING")+"')) "  + 
				"					AND PREFER_PORT_1 IS NOT NULL  " + 
				"	            ORDER BY  " + 
				"	                POINT_NAME";
		
		System.out.println("PRE_GET_PLACE_OF_RECEIPT :"+query1);
		
		List<ComboVO> list=jdbcTemplate.query(query1, new Object[] {}, new ComboRowMapper());
		
		Map outPut=new HashMap();
		outPut.put("P_O_V_REF_CURSOR_DATA",list);
		outPut.put("P_O_V_ERROR",null);
		
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
		}
	}
}
