package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao.P_I_V;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao.P_O_V;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_REP_COMP.RepCompMapper;

public class PRR_ERCL_GET_COC_SOC {
	

	private JdbcTemplate jdbcTemplate;
	private Map map;

	public PRR_ERCL_GET_COC_SOC(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	
	public void executeDbProcedure() {

		String query =  "select  " + 
				"distinct CUCORS as CODE ,  " + 
				"(  " + 
				"CASE  " + 
				"WHEN CUCORS='C' THEN 'Carrier own container (RCL)'  " + 
				"ELSE  " + 
				"'Shipper own container'  " + 
				"END  " + 
				")  " + 
				"as description  " + 
				"from  " + 
				"SEALINER.ITP010  " + 
				"where  " + 
				"CUCORS in ('C', 'S')";
		
		List<ComboVO> list = jdbcTemplate.query(query, new Object[] {}, new CocSocMapper());

		 
		map.put(P_O_V.SPECIAL_CARGO, list);

		 
	}

	 class CocSocMapper extends JdbcRowMapper{

         public Object mapRow(ResultSet rs, int row) throws SQLException{

             ComboVO objComboVO = new ComboVO();

             objComboVO.setCode(rs.getString("CODE"));
             objComboVO.setName(rs.getString("description"));

             return objComboVO;
         }

     }

}
