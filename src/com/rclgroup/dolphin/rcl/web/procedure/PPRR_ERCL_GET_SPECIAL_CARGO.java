package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao.P_O_V;

public class PPRR_ERCL_GET_SPECIAL_CARGO {

	private JdbcTemplate jdbcTemplate;
	private Map map;
	
	public PPRR_ERCL_GET_SPECIAL_CARGO(JdbcTemplate jdbcTemplate,Map map) {
		
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
		
	}

	public void executeDbProcedure() {
		
		String query="select special_Cargo_code,special_cargo_desc from SHP040 where record_status='A'";
		
		List<ComboVO> list = jdbcTemplate.query(query, new Object[] {}, new CocSocMapper());

		 
		map.put(P_O_V.SPECIAL_CARGO, list);
		
		
	}
	
	 class CocSocMapper extends JdbcRowMapper{

         public Object mapRow(ResultSet rs, int row) throws SQLException{

             ComboVO objComboVO = new ComboVO();

             objComboVO.setCode(rs.getString("special_Cargo_code"));
             objComboVO.setName(rs.getString("special_cargo_desc"));

             return objComboVO;
         }

     }
	
}
