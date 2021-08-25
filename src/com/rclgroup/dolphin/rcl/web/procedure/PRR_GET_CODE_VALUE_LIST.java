package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.JdbcRowMapper;

public class PRR_GET_CODE_VALUE_LIST {
	 private JdbcTemplate jdbcTemplate;
	 private Map map ;
	 
	public PRR_GET_CODE_VALUE_LIST(JdbcTemplate jdbcTemplate,Map map){
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;	
	}

	public void executeDbProcedure() {
		
		String query="SELECT 'TRUE' " + 
				"    FROM  ZCC_CODE_VALUE ZCV " + 
				"    WHERE ZCV.RECORD_STATUS = 'A' " + 
				"      AND ZCV.MODULE = '"+map.get("P_I_MODULE")+"' " + 
				"      AND ZCV.TABLE_OWNER = '"+map.get("P_I_TABLE_OWNER")+"' " + 
				"      AND ZCV.TABLE_NAME = '"+map.get("P_I_TABLE_NAME")+"' " + 
				"      AND ZCV.TABLE_FIELD = '"+map.get("P_I_TABLE_FIELD")+"' " + 
				"      AND ROWNUM = 1 ";
		
		map.put("P_O_RESULT_STATUS", "TRUE");
		map.put("P_O_RESULT_MESSAGE", "COMPLETED");
		
		String query1="SELECT ZCV.CODE_VALUE " + 
				"               ,ZCV.DESCRIPTION_SHORT " + 
				"               ,ZCV.DESCRIPTION_LONG " + 
				"               ,ZCV.REMARKS " + 
				"        FROM ZCC_CODE_VALUE ZCV " + 
				"        WHERE ZCV.RECORD_STATUS = 'A' " + 
				"          AND ZCV.MODULE = '"+ map.get("P_I_MODULE") +"' " + 
				"          AND ZCV.TABLE_OWNER = '"+ map.get("P_I_TABLE_OWNER") +"' " + 
				"          AND ZCV.TABLE_NAME = '"+ map.get("P_I_TABLE_NAME") +"' " + 
				"          AND ZCV.TABLE_FIELD = '"+ map.get("P_I_TABLE_FIELD") +"' " + 
				"        ORDER BY ZCV.SORT_ORDER, ZCV.CODE_VALUE";
		
		List<ComboVO>  list=jdbcTemplate.query(query1, new Object[] {}, new RateTypeRowMappers());
		
		map.put("P_O_RECORD_SET", list);
	}
	
	 class RateTypeRowMappers extends JdbcRowMapper{

         public Object mapRow(ResultSet rs, int row) throws SQLException{

             ComboVO objComboVO = new ComboVO();
             /* Code */
             objComboVO.setCode(rs.getString("CODE_VALUE"));
             /* Description */
             objComboVO.setName(rs.getString("DESCRIPTION_SHORT"));
             return objComboVO;
         } // mapRow

     } // end of class QuotationRowMapper


}
