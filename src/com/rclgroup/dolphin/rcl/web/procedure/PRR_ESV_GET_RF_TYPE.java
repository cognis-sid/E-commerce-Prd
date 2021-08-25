package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PRR_ESV_GET_RF_TYPE {
	
	JdbcTemplate jdbcTemplate;
	Map amapParam ;
	
	public PRR_ESV_GET_RF_TYPE(JdbcTemplate jdbcTemplate,Map amapParam) {
		this.jdbcTemplate=jdbcTemplate;
		this.amapParam=amapParam;
	}
	
	public void executeDbProcedure() {
		
		
		String query1="SELECT TRTYPE FROM ITP075 WHERE TRREFR='Y' AND TRRCST='A'";
		
	    List list=jdbcTemplate.query(query1, new Object[] { }, new ResultsData());
	    
		amapParam.put("P_O_V_RF_TYPE",list.toString());
	}
		class ResultsData  implements RowMapper{

			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				
				return rs.getString("TRTYPE");
			}
			
		}
}
