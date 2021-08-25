package com.rclgroup.dolphin.rcl.web.procedure.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.JdbcRowMapper;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDaoImpl.RegistrationCountryDetailsRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;

public class PRR_ESV_GET_COUNTRY_LIST {

	JdbcTemplate jdbcTemplate;
	Map map;
	String P_O_V_ERROR;
	String P_O_V_USER_ROLE_CD;

	public PRR_ESV_GET_COUNTRY_LIST(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	public Map executeDbProcedure() {
		Map<String, List<ComboVO>> resultMap = new HashMap<String, List<ComboVO>>();

		// PRR_ESV_GET_COUNTRY_LIST (P_O_V_COUNTRY_DATA OUT ESV_LIST_COUNTRY_REF_CUR )
		// IS

		String sqlQry = "SELECT country_name AS COUNTRY_NAME,pk_country_code AS COUNTRY_CODE FROM cam_country WHERE record_status='A' ORDER BY country_name";

		List<ComboVO> result = jdbcTemplate.query(sqlQry, new Object[] {}, new RegistrationCountryDetailsRowMapper());

		if(result.size()>0)
		  resultMap.put("P_O_V_COUNTRY_DATA" , result);
		
		return resultMap;

	}

	public class RegistrationCountryDetailsRowMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			ComboVO obj = new ComboVO();
			obj.setName(rs.getString(1));
			obj.setCode(rs.getString(2));

			return obj;
		}
	}
	
	
}
