package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.JdbcRowMapper;

public class PRR_ESV_SI_GET_COMMGRP_DDL {

	JdbcTemplate jdbcTemplate;
	Map map;
	public PRR_ESV_SI_GET_COMMGRP_DDL(JdbcTemplate jdbcTemplate,Map map){
			this.jdbcTemplate=jdbcTemplate;
			this.map=map;
	}
	public void executeDbProcedure() {

	String	V_SQL = "SELECT Description as Commodity_Group "+
				" , Commodity_Group_Code as Comm_Grp_Code "+
		 " FROM Commodity_Group "+
		 " WHERE Commodity_Group_Code in "+
				 " (Select distinct Commodity_Group_Code from ITP080 where FCRCST = 'A')"+
		 " ORDER BY 1,2 ";

		List<ComboVO> list =jdbcTemplate.query(V_SQL, new CommodityDetailsRowMapper());
			
		map.put("P_O_V_DTL_DATA", list);
	}
	
	 public class CommodityDetailsRowMapper extends JdbcRowMapper {
	     
         public Object mapRow(ResultSet rs, int row) throws SQLException {
             ComboVO obj = new ComboVO();
             obj.setName(rs.getString(1));
             obj.setCode(rs.getString(2));
            
             return obj;
         }    
     }
}
