package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.AncestorJdbcDao.ComboRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_GET_EMPTY_PICKUP_DEPOT extends AncestorJdbcDao{

	JdbcTemplate jdbcTemplate;
	Map map;
	String query1;
	public PRE_GET_EMPTY_PICKUP_DEPOT(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
		
	
			query1=" SELECT  " + 
					"                TQTERM AS \"CODE\",  " + 
					"                TQTRNM AS \"DESC\"  " + 
					"            FROM  " + 
					"                ITP130 I  " + 
					"            WHERE  " + 
					"                TQTORD           = 'D'  " + 
					"                AND TQRCST       = 'A'  " + 
					"				AND DEPOT_TYPE   = 'D'  			     " + 
					"                AND POINT_CODE  = '"+map.get("P_I_V_PORT_OF_LOADING")+"'" + 
					"            ORDER BY  " + 
					"                TQTRNM";
		

		
		List<ComboVO> list=jdbcTemplate.query(query1, new Object[] {}, new ComboRowMapper()); 
		 
		if(list.size()==0) {
			ComboVO comboVO=new ComboVO();
			comboVO.setCode(" ");
			comboVO.setName("Not Available");
			list.add(comboVO);
		}
		Map outPut=new HashMap();
		outPut.put("P_O_V_REF_CURSOR_DATA",list);
		outPut.put("P_O_V_ERROR",null);
		
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
		
	}
	
}
