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

public class PRR_ERCL_GET_REP_COMP {

	private JdbcTemplate jdbcTemplate;
	private Map map;

	public PRR_ERCL_GET_REP_COMP(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	public void executeDbProcedure() {

		String query = "SELECT DISTINCT PP_HDR.FK_CONTRACT_PARTY_CODE " + " , ( "
				+ "   SELECT T.CUNAME FROM ITP010 T WHERE T.CUCUST  = PP_HDR.FK_CONTRACT_PARTY_CODE "
				+ ") AS CONTRACT_PARTY_NAME " + "FROM  ESV_CONTRACT_PARTY_PP_HDR PP_HDR "
				+ "   LEFT JOIN ESV_CONTRACT_PARTY_PP_DTL PP_DTL ON PP_DTL.FK_ESV_PP_HDR_SEQ = PP_HDR.PK_ESV_PP_HDR_SEQ "
				+ " WHERE PP_HDR.USER_ID            = '" + map.get(P_I_V.USER_ID) + "'"
				+ "      AND PP_HDR.RECORD_STATUS  = 'A' " + "     AND PP_HDR.PWD            = PP_HDR.REACT_PWD "
				+ "  AND PP_DTL.POL='"+map.get("POL")+"' AND PP_DTL.POD='"+map.get("POD")+"' "
				+ "    AND (" + "         (" + "          PP_DTL.RECORD_STATUS  = 'A' "
				+ "         AND PP_DTL.EFF_DATE IS NOT NULL " + "        AND PP_DTL.EXP_DATE IS NOT NULL"
				+ "       AND now() BETWEEN PP_DTL.EFF_DATE AND PP_DTL.EXP_DATE" + "    )" + "   OR" + "  ("
				+ "  SELECT COUNT(*)" + "   FROM ESV_CONTRACT_PARTY_PP_DTL DTL"
				+ " WHERE DTL.FK_ESV_PP_HDR_SEQ = PP_HDR.PK_ESV_PP_HDR_SEQ" + "  AND DTL.RECORD_STATUS = 'A'" + ") = 0"
				+ ")" + " ORDER BY  CONTRACT_PARTY_NAME ASC";
		
		List<ComboVO> list = jdbcTemplate.query(query, new Object[] {}, new RepCompMapper());

		 
		map.put(P_O_V.REP_COMP, list);

		 
	}  
	

	class RepCompMapper extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			ComboVO objComboVO = new ComboVO();

			objComboVO.setCode(rs.getString("FK_CONTRACT_PARTY_CODE"));
			objComboVO.setName(rs.getString("CONTRACT_PARTY_NAME"));

			return objComboVO;
		}

	}

}
