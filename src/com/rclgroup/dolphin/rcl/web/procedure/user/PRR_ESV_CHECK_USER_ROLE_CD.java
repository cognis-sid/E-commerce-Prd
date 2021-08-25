package com.rclgroup.dolphin.rcl.web.procedure.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;


public class PRR_ESV_CHECK_USER_ROLE_CD {
	
	

	JdbcTemplate jdbcTemplate;
	Map map;
	String P_O_V_ERROR;
	String P_O_V_USER_ROLE_CD;
	
	public PRR_ESV_CHECK_USER_ROLE_CD(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	
	public Map executeDbProcedure(String  P_I_V_USR_ID ) {
		Map map=new HashMap<String,String>();//Creating HashMa				
							
			String sqlQry="SELECT ROLE_CD FROM sealiner.PR_PRSN_ROLE WHERE prsn_log_id ='"+ P_I_V_USR_ID +"' AND ROLE_CD IN ('EREG-E','EREG-M')";
							
			/*List<String> result =	jdbcTemplate.query(sqlQry,  new RowMapper<String>(){
                public String mapRow(ResultSet rs, int rowNum) 
                        throws SQLException {
                   return rs.getString(1);
      }*/
//});
			List<String> data=jdbcTemplate.queryForList(sqlQry,String.class);
			
			if(data.size()==1) {
				map.put("P_O_V_USER_ROLE_CD", data.get(0));
			}
			else if(data.size()==0) {
			map.put("P_O_V_USER_ROLE_CD", "No Autorize");
			map.put("P_O_V_ERROR", "No data found");
			}
			else {
			map.put("P_O_V_USER_ROLE_CD", "No Autorize");
			map.put("P_O_V_ERROR", "Can not select from sealiner.PR_PRSN_ROLE");
				
			}
			
						
			return map;
	}
}
