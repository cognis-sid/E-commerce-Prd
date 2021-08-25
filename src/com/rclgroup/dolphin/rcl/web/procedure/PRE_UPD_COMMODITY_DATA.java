package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_UPD_COMMODITY_DATA {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRE_UPD_COMMODITY_DATA(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	public void executeDbProcedure() {
		String OLD_DATA ;
		String V_COMMD_CD ;
		String V_COMMD_DESC ;
		String COMMODITY_GROUP_CODE_TEMP; 
		String query1;
		String query2;
		String query3;
		String COMMODITY_GROUP_CODE_QUERY=" SELECT COMMODITY_GROUP_CODE " + 
				"   FROM SEALINER.BKP050 " + 
				"   WHERE BWBKNO = '"+map.get("P_I_V_BOOKING_NO")+"' " + 
				"         AND BWCMSQ = 1 ";
		COMMODITY_GROUP_CODE_TEMP=(String) jdbcTemplate.queryForObject(COMMODITY_GROUP_CODE_QUERY, String.class);
		
		if(!map.get("P_I_V_COMMODITY_GROUP").equals(COMMODITY_GROUP_CODE_TEMP)) {
			String countData="SELECT  FCCODE , FCDESC " + 
					"                   INTO V_COMMD_CD,V_COMMD_DESC " + 
					"           FROM (SELECT  FCCODE  , FCDESC " + 
					"                          FROM SEALINER.ITP080 " + 
					"                          WHERE COMMODITY_GROUP_CODE='"+map.get("P_I_V_COMMODITY_GROUP")+"'" + 
					"                          AND FCRCST='A' " + 
					"                          ORDER BY FCCODE ) " + 
					"           WHERE ROWNUM=1 ";
		 int count	=  jdbcTemplate.queryForInt(countData);
			if(count>0){
				
				query1="SELECT  FCCODE , FCDESC " + 
						"        FROM (SELECT  FCCODE  , FCDESC " + 
						"                       FROM SEALINER.ITP080 " + 
						"                       WHERE COMMODITY_GROUP_CODE='"+map.get("P_I_V_COMMODITY_GROUP")+"' " + 
						"                       AND FCRCST='A' " + 
						"                       ORDER BY FCCODE ) " + 
						"        WHERE ROWNUM=1"	 ;
			}else{
				query1="SELECT  FCCODE , FCDESC " +
						"        FROM (SELECT  FCCODE  , FCDESC " + 
						"                       FROM SEALINER.ITP080 " + 
						"                       WHERE COMMODITY_GROUP_CODE=G_V_DEFAULT_COMMD_GROUP " + 
						"                       AND FCRCST='A' " + 
						"                       ORDER BY FCCODE ) " + 
						"        WHERE ROWNUM=1"	 ;
			}
			
			List list=jdbcTemplate.query(query1, new Object[] {}, new CommodityCodeDesc());
			V_COMMD_CD=(String) list.get(0);
			V_COMMD_DESC=(String) list.get(1);
			
			query2="UPDATE SEALINER.BKP050 " + 
					"               SET BWCMCD               = '"+V_COMMD_CD+"'," + 
					"                   BWMTWT               = '"+map.get("P_I_V_GROSS_WEIGHT")+"'    ,  " + 
					"                   BDCUSR               = '"+map.get("P_I_V_USER_ID")+"'    ,  " +
					"                   BDCDAT               = to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'), " + 
					"                   BDCTIM               = to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') , " + 
					"                   COMM_DESC            = '"+V_COMMD_DESC+"', " + 
					"                   COMMODITY_GROUP_CODE = '"+map.get("P_I_V_COMMODITY_GROUP")+"'" + 
					"       WHERE BWBKNO ='"+ map.get("P_I_V_BOOKING_NO") +"'" + 
					"             AND BWCMSQ ='"+ map.get("P_I_V_SEQ") +"'" ;
				jdbcTemplate.update(query2);
		}else {
			query2="UPDATE SEALINER.BKP050 " + 
					"               SET BWMTWT               ='"+map.get("P_I_V_GROSS_WEIGHT")+"'    , " + 
					"                   BDCUSR               ='"+ map.get("P_I_V_USER_ID") +"'     , " + 
					"                   BDCDAT               = to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'), " + 
					"                   BDCTIM               = to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') " + 
					"       WHERE BWBKNO = '"+map.get("P_I_V_BOOKING_NO")+"'" + 
					"             AND BWCMSQ = '"+map.get("P_I_V_SEQ")+"'";	
			jdbcTemplate.update(query2);
		}
		
		query3="UPDATE SEALINER.BKP007 " + 
				"              SET BGRMKS =E'"+ map.get("P_I_V_SPECIAL_INSTRUCTION")+"' , " + 
				"                  BGCUSR = '"+ map.get("P_I_V_USER_ID")+"', " + 
				"                  BGCDAT = to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'), " + 
				"                  BGCTIM = to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') " + 
				"       WHERE BGBKNO = '"+map.get("P_I_V_BOOKING_NO")+ "'" + 
				"             AND BGSEQN ='"+ map.get("P_I_V_SEQ")+"'";
		jdbcTemplate.update(query2);
		
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
	class CommodityCodeDesc implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {

			List lst=new ArrayList();
			lst.add(rs.getString("FCCODE"));
			lst.add(rs.getString("FCDESC"));
			return lst;
		}
		
	}
}
