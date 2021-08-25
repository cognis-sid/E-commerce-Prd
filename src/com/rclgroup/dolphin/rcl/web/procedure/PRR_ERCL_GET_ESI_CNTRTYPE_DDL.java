package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.JdbcRowMapper;

public class PRR_ERCL_GET_ESI_CNTRTYPE_DDL {

	JdbcTemplate jdbcTemplate;
	Map map;
	public PRR_ERCL_GET_ESI_CNTRTYPE_DDL(JdbcTemplate jdbcTemplate,Map map){
			this.jdbcTemplate=jdbcTemplate;
			this.map=map;
	}
	public void executeDbProcedure() {
		String  V_SQL =""; 
		if(map.get("P_I_V_MODE") == "1") {
			   	  V_SQL = "SELECT "+
				  		   		  " BCSIZE || ' - ' || (SELECT TRTPNM FROM ITP075 WHERE TRTYPE = BCTYPE) as CNTR_TYPE,"+
								  " BCSIZE as EQ_SIZE,"+
								  " BCTYPE as EQ_TYPE "+
							"FROM BKP032 "+
							"WHERE BCBKNO = '"+map.get("P_I_V_BKG_NO")+"' ";

		}else {
			   	  V_SQL = "SELECT "+
				  		   		"   BCSIZE || ' - ' || (SELECT TRTPNM FROM ITP075 WHERE TRTYPE = BCTYPE) as CNTR_TYPE,"+
								"  BCSIZE as EQ_SIZE,"+
								"   BCTYPE as EQ_TYPE "+
						"	FROM BKP032 "+
						"	WHERE BCBKNO = '"+map.get("P_I_V_BKG_NO")+"' ";
		}
			
		List<ComboVO> list=jdbcTemplate.query(V_SQL, new ContainerTypeRowMapper());
		
		map.put("P_O_V_DTL_DATA", list);
	}
	 public class ContainerTypeRowMapper extends JdbcRowMapper{

	        /**
	         * 
	         * This mothod for set data to container type in each row.
	         * 
	         * @exception SQLException
	         * @param rs List of container type
	         * @param row Row of container type
	         */
	        public Object mapRow(ResultSet rs, int row) throws SQLException{
	            ComboVO obj = new ComboVO();
	            obj.setName(rs.getString(1));
	            obj.setCode(rs.getString(2)+"|"+rs.getString(3));
	            return obj;
	        }
	    }
}
