package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;

public class PRR_ESV_GET_CUSTOMER_CODE_MPP {

	private JdbcTemplate jdbcTemplate;
	private Map map;

	public PRR_ESV_GET_CUSTOMER_CODE_MPP(JdbcTemplate jdbcTemplate, Map map) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	public void executeProcedure() {
		String query = "";
		String P_I_V_FLAG_TEMP = "";
		String P_O_V_CUST_CODE = "";
		String P_O_V_FSC = "";
		String P_O_V_CUST_TYPE = "";
		if (map.get("P_I_V_FLAG") == null)
			P_I_V_FLAG_TEMP = "-";
		else
			P_I_V_FLAG_TEMP = (String) map.get("P_I_V_FLAG");

		if (P_I_V_FLAG_TEMP.equals("C")) { // this use for show data for contract party section .

			query = " SELECT DISTINCT FK_CONTRACT_PARTY_CODE " + "    ,CULFSC " + "    ,BUSINESS_PARTNER_TYPE  "
					+ "  FROM VASAPPS.ESV_CONTRACT_PARTY_PORT_PAIR,ITP010  " + "  WHERE CUCUST=FK_CONTRACT_PARTY_CODE  "
					+ "  AND FK_USER_ID='" + map.get("P_I_V_USR_ID")
					+ "'   AND UPPER(TRIM(CONTRACT_PARTY_NAME))=UPPER(TRIM('" + map.get("P_I_V_CUST_NAME") + "' ))";

		} else {

			query = "  SELECT  ORG_CODE, " + "   FSC_CODE, " + "    BUSINESS_PARTNER_TYPE "
					+ "    FROM RCLTBLS.ESM_USER_LOGIN, ITP010 " + "    WHERE USER_ID   = '" + map.get("P_I_V_USR_ID")
					+ "' " + "     AND CUCUST    = ORG_CODE ";

		}

		List list = jdbcTemplate.query(query, new CostomRowMap());

		if (list.size() > 0) {
			map.put("P_O_V_CUST_CODE", list.get(0));
			map.put("P_O_V_FSC", list.get(1));
			map.put("P_O_V_CUST_TYPE", list.get(2));
		} else {
			map.put("P_O_V_CUST_CODE", "");
			map.put("P_O_V_FSC", "");
			map.put("P_O_V_CUST_TYPE", "");
		}
	}

		class CostomRowMap extends JdbcRowMapper {

		@Override
		public List mapRow(ResultSet rs, int row) throws SQLException {

			List list = new LinkedList();
			list.add(rs.getString("FK_CONTRACT_PARTY_CODE"));
			list.add(rs.getString("CULFSC"));
			list.add(rs.getString("BUSINESS_PARTNER_TYPE"));

			return list;
		}

	}

}
