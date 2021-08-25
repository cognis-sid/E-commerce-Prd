package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao.P_I_V;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_GET_TEMPLATE_COMBO_DATA extends AncestorJdbcDao{

	JdbcTemplate jdbcTemplate;
	Map map;
	String query1;
	public PRE_GET_TEMPLATE_COMBO_DATA(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
	
		if("Y".equalsIgnoreCase((String)map.get(P_I_V.REP_FLAG)) && !" ".equals((String)map.get(P_I_V.REP_FLAG))) {
			query1=" SELECT  " + 
					"                BABKNO AS \"CODE\",  " + 
					"                WEB_BOOK_REF AS \"DESC\"  " + 
					"            FROM  " + 
					"                BKP001 B  " + 
					"            WHERE  " + 
					"                BABKBY                = '"+map.get(P_I_V.REP_FLAG)  +"'" + 
					"                AND WEB_BOOK_REF     IS NOT NULL  " + 
					"                AND CREATED_THRU_WEB IS NOT NULL  " + 
					"                AND BASTAT            = 'O'  " + 
					"                AND BOOKING_TYPE      = 'TB'  " + 
					"            ORDER BY  " + 
					"                WEB_BOOK_REF";
		}else {
			query1= " SELECT " + 
					"                BABKNO AS \"CODE\", " + 
					"                WEB_BOOK_REF AS \"DESC\" " + 
					"            FROM " + 
					"                BKP001 B " + 
					"            WHERE " + 
					"                BABKBY IN( " + 
					"                    SELECT ORG_CODE FROM SC_PRSN_LOG_INFO WHERE PRSN_LOG_ID = '"+map.get(AncestorJdbcDao.KEY_USER_ID) +"'" + 
					"                ) " + 
					"                AND WEB_BOOK_REF     IS NOT NULL " + 
					"                AND CREATED_THRU_WEB IS NOT NULL " + 
					"                AND BASTAT            = 'O' " + 
					"                AND BOOKING_TYPE      = 'TB' " + 
					"                AND BAPOL = '"+map.get("PORT_OF_LOADING_TEMPLATE")+"' "+
					"				 AND BAPOD = '"+map.get("PORT_OF_DISCHARGE_TEMPLATE")+"' "+
					"            ORDER BY " + 
					"                WEB_BOOK_REF";
		}
	
		
		
		List<ComboVO> list=jdbcTemplate.query(query1, new Object[] {}, new ComboRowMapper());
		
		Map outPut=new HashMap();
		outPut.put("P_O_V_REF_CURSOR_DATA",list);
		outPut.put("P_O_V_ERROR",null);
		
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}

}
