package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePortClassMod;

public class PRR_ESV_GET_DG_LOOKUP {
	JdbcTemplate jdbcTemplate;
	Map map;
	public static final String KEY_CRITERIA_TEXT_FIND = "TEXT";
	public static final String KEY_CRITERIA_COLUMN = "COLUMN";
	public static final String KEY_CRITERIA_SORTBY = "SORTBY";
	public static final String KEY_CRITERIA_ORDER = "ORDER";
	public static final String KEY_CRITERIA_WILDCARD = "WILDCARD";

	public PRR_ESV_GET_DG_LOOKUP(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	public Map executeDbProcedure() {
		String P_O_V_DG_PORT_CLASS_DATA = "";
		String P_I_V_COL_NAME = (String) map.get(KEY_CRITERIA_TEXT_FIND);
		String P_I_V_COL_VAL = (String) map.get(KEY_CRITERIA_COLUMN);
		String P_I_V_SORT_BY = (String) map.get(KEY_CRITERIA_SORTBY);
		String P_I_V_ORDER_BY = (String) map.get(KEY_CRITERIA_ORDER);
		String P_I_V_WILD_CARD = (String) map.get(KEY_CRITERIA_WILDCARD);

		String V_SQL = "";
		String V_CONDITION = "";

		V_CONDITION = "=";

		V_SQL = "SELECT distinct PORT_CLASS_CODE ,PORT_CLASS_TYPE ,UNNO ,VARIANT ,IMDG_CLASS ,PSN , RECORD_STATUS FROM PORT_CLASS WHERE record_status ='A' AND PORT_CLASS_TYPE = (SELECT PORT_CLASS_TYPE FROM PORT_CLASS_TYPE  WHERE  record_status ='A' AND PORT_CODE = 'SGSIN')";

		if (!P_I_V_COL_NAME.isEmpty() && P_I_V_COL_NAME != null) {

			if (P_I_V_WILD_CARD.equals("Y")) {
				V_CONDITION = "LIKE";
			}	
			if(P_I_V_COL_NAME.equals("DGRCST")) {
				P_I_V_COL_NAME = "RECORD_STATUS";
				P_I_V_COL_VAL = "A";
			}
			V_SQL = V_SQL + " AND '" + P_I_V_COL_NAME + "' " + V_CONDITION + " " + P_I_V_COL_VAL;
		}

		if (P_I_V_SORT_BY != null && !P_I_V_SORT_BY.isEmpty()) {
			V_SQL = V_SQL + " ORDER BY " + P_I_V_SORT_BY + " " + P_I_V_ORDER_BY;
		}
		List<EservicePortClassMod> list = jdbcTemplate.query(V_SQL, new EservicePortClassRowMapper());
		map.put("P_O_V_DG_PORT_CLASS_DATA", list);
		return map;
	}

	private class EservicePortClassRowMapper extends JdbcRowMapper {
		public EservicePortClassRowMapper() {
		}

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EservicePortClassMod mod = new EservicePortClassMod();
			try {
				mod.setPortClassCode(rs.getString("PORT_CLASS_CODE"));
				mod.setPortClassType(rs.getString("PORT_CLASS_TYPE"));
				mod.setUnno(rs.getString("UNNO"));
				mod.setVariant(rs.getString("VARIANT"));
				mod.setImdgClass(rs.getString("IMDG_CLASS"));
				mod.setPsn(rs.getString("PSN"));
				if(rs.getString("RECORD_STATUS").equals("A"))    
				mod.setRecStatus("ACTIVE");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return mod;
		}
	}
}
