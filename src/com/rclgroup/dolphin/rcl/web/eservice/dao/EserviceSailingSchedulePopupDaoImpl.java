/*------------------------------------------------------
 EserviceSailingSchedulePopupDaoImpl.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Pratya Thanuchaisak 11/09/2014
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceSailingSchedulePopupMod;

/**
 * Class for DAO
 * 
 * @class EservicePortClassDaoImpl
 * @author NTL) Pratya
 * @version v1.00 2014/08/08
 * @see
 */
public class EserviceSailingSchedulePopupDaoImpl extends AncestorJdbcDao implements EserviceSailingSchedulePopupDao {

	public Map getHuaLageList(Map amap) throws BusinessException, DataAccessException {
		System.out.println("[EserviceSailingSchedulePopupDaoImpl][getHuaLageList][Begin]");

		JdbcStoredProcedure storeProcedure = null;
		Map resultMap = null;
		;
		String[][] arrParams = null;
		String errorMsg = null;
		List lst = null;
		String find = null;
		String column = null;
		String sortby = null;
		String order = null;
		String wildcard = null;

		try {

			find = (String) amap.get(KEY_CRITERIA_TEXT_FIND);
			column = (String) amap.get(KEY_CRITERIA_COLUMN);
			sortby = (String) amap.get(KEY_CRITERIA_SORTBY);
			order = (String) amap.get(KEY_CRITERIA_ORDER);
			wildcard = (String) amap.get(KEY_CRITERIA_WILDCARD);

			arrParams = new String[][] { { P_O_V_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ P_I_V_COL_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, column },
					{ P_I_V_COL_VAL, BLANK + ORACLE_VARCHAR, PARAM_IN, find },
					{ P_I_V_SORT_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, sortby },
					{ P_I_V_ORDER_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, order },
					{ P_I_V_WILD_CARD, BLANK + ORACLE_VARCHAR, PARAM_IN, wildcard } };

			storeProcedure = getStoreProcedure(PCR_ESV_NEW_WEB_BOOKING.PRR_ESV_GET_HUALAGE_LOOKUP,
					new EserviceSailingSchedulePopupRowMapper(), arrParams);

			System.out.println(
					"[EserviceSailingSchedulePopupDaoImpl][getHuaLageList] storeProcedure :: " + storeProcedure);

			if (storeProcedure != null) {
				resultMap = storeProcedure.execute();
				if (resultMap != null && !resultMap.isEmpty()) {
					lst = (List) resultMap.get(P_O_V_DATA);
				}
			}

			System.out.println("[EserviceSailingSchedulePopupDaoImpl][getHuaLageList] lst :: " + lst);

//            if(lst==null){
//                lst = new ArrayList(0);
//            }

			System.out.println("[EserviceSailingSchedulePopupDaoImpl][getHuaLageList] lst.size() :: " + lst.size());

			amap.put(KEY_DATA, lst);
			amap.put(KEY_SIZE, lst.size());

		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
		} finally {
			System.out.println("[EserviceSailingSchedulePopupDaoImpl][getHuaLageList][End]");
		}
		return amap;
	}

	public Map getPortList(Map amap) throws BusinessException, DataAccessException {
		System.out.println("[EserviceSailingSchedulePopupDaoImpl][getPortList][Begin]");

		JdbcStoredProcedure storeProcedure = null;
		Map resultMap = null;
		String[][] arrParams = null;
		String errorMsg = null;
		List lst = null;
		String find = null;
		String column = null;
		String sortby = null;
		String order = null;
		String wildcard = null;

		try {

			find = (String) amap.get(KEY_CRITERIA_TEXT_FIND);
			column = (String) amap.get(KEY_CRITERIA_COLUMN);
			sortby = (String) amap.get(KEY_CRITERIA_SORTBY);
			order = (String) amap.get(KEY_CRITERIA_ORDER);
			wildcard = (String) amap.get(KEY_CRITERIA_WILDCARD);

			arrParams = new String[][] { { P_O_V_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ P_I_V_COL_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, column },
					{ P_I_V_COL_VAL, BLANK + ORACLE_VARCHAR, PARAM_IN, find },
					{ P_I_V_SORT_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, sortby },
					{ P_I_V_ORDER_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, order },
					{ P_I_V_WILD_CARD, BLANK + ORACLE_VARCHAR, PARAM_IN, wildcard } };

			// change done by chandra
			String V_CONDITION = "";

			// for postgre
			String POL_POD_QUERY = "select  code, name as DESCRIPTION from country_code where 1=1 ";

			// for oracle
			String sqlQuery = "select * from (SELECT I40.PICODE AS CODE, I40.PINAME AS DESCRIPTION FROM ITP040 I40,  ITP063 I63"
					+ " WHERE I63.VVVERS = 99  AND I63.VVFORL  IS NOT NULL AND I63.VVLDDS  IN ('L', 'D', 'B')"
					+ "AND I63.VVPCAL   = I40.PICODE "
					+ " AND I40.PIRCST   = 'A'  GROUP BY  I40.PICODE, I40.PINAME  order by  PINAME) where 1=1 ";

			if (column != null && !(column.isEmpty())) {

				if (wildcard != null && !(wildcard.isEmpty())) {
					V_CONDITION = "LIKE";
				}

				if (column.equalsIgnoreCase("DESCRIPTION"))
					column = "name";

				POL_POD_QUERY = POL_POD_QUERY + " AND " + column + " " + V_CONDITION + " '" + find + "%'";

			}

			if (sortby != null && !(sortby.isEmpty()))
				POL_POD_QUERY = POL_POD_QUERY + " ORDER BY " + sortby + " " + order;

			lst = getJdbcTemplate().query(POL_POD_QUERY, new Object[] {}, new EserviceSailingSchedulePopupRowMapper());
			System.out.println("sqlQuery   " + POL_POD_QUERY);

			/**
			 * storeProcedure =
			 * getStoreProcedure(PCR_ESV_NEW_WEB_BOOKING.PRR_ESV_GET_POL_LOOKUP, new
			 * EserviceSailingSchedulePopupRowMapper(), arrParams);
			 * 
			 * System.out.println("[EserviceSailingSchedulePopupDaoImpl][getPortList]
			 * storeProcedure :: " + storeProcedure);
			 * 
			 * if(storeProcedure != null){ resultMap = storeProcedure.execute();
			 * if(resultMap != null && !resultMap.isEmpty()){ lst = (List)
			 * resultMap.get(P_O_V_DATA); } }
			 */
			System.out.println("[EserviceSailingSchedulePopupDaoImpl][getPortList] lst.size() :: " + lst.size());

			amap.put(KEY_DATA, lst);
			amap.put(KEY_SIZE, lst.size());

		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
		} finally {
			System.out.println("[EserviceSailingSchedulePopupDaoImpl][getPortList][End]");
		}
		return amap;
	}

	public Map getPlaceList(Map amap) throws BusinessException, DataAccessException {
		System.out.println("[EserviceSailingSchedulePopupDaoImpl][getPlaceList][Begin]");

		JdbcStoredProcedure storeProcedure = null;
		Map resultMap = null;
		String[][] arrParams = null;
		String errorMsg = null;
		List lst = null;
		String find = null;
		String column = null;
		String sortby = null;
		String order = null;
		String wildcard = null;

		try {

			find = (String) amap.get(KEY_CRITERIA_TEXT_FIND);
			column = (String) amap.get(KEY_CRITERIA_COLUMN);
			sortby = (String) amap.get(KEY_CRITERIA_SORTBY);
			order = (String) amap.get(KEY_CRITERIA_ORDER);
			wildcard = (String) amap.get(KEY_CRITERIA_WILDCARD);

			arrParams = new String[][] { { P_O_V_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ P_I_V_COL_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, column },
					{ P_I_V_COL_VAL, BLANK + ORACLE_VARCHAR, PARAM_IN, find },
					{ P_I_V_SORT_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, sortby },
					{ P_I_V_ORDER_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, order },
					{ P_I_V_WILD_CARD, BLANK + ORACLE_VARCHAR, PARAM_IN, wildcard } };

			storeProcedure = getStoreProcedure(PCR_ESV_NEW_WEB_BOOKING.PRR_ESV_GET_PLR_LOOKUP,
					new EserviceSailingSchedulePopupRowMapper(), arrParams);

			System.out
					.println("[EserviceSailingSchedulePopupDaoImpl][getPlaceList] storeProcedure :: " + storeProcedure);

			if (storeProcedure != null) {
				resultMap = storeProcedure.execute();
				if (resultMap != null && !resultMap.isEmpty()) {
					lst = (List) resultMap.get(P_O_V_DATA);
				}
			}

			System.out.println("[EserviceSailingSchedulePopupDaoImpl][getPlaceList] lst.size() :: " + lst.size());

			amap.put(KEY_DATA, lst);
			amap.put(KEY_SIZE, lst.size());

		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
		} finally {
			System.out.println("[EserviceSailingSchedulePopupDaoImpl][getPlaceList][End]");
		}
		return amap;
	}

	private class EserviceSailingSchedulePopupRowMapper extends JdbcRowMapper {
		public EserviceSailingSchedulePopupRowMapper() {
		}

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceSailingSchedulePopupMod mod = new EserviceSailingSchedulePopupMod();
			try {
				mod.setCode(rs.getString("CODE"));
				mod.setDescription(rs.getString("DESCRIPTION"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return mod;
		}
	}

	private JdbcStoredProcedure getStoreProcedure(String procName, JdbcRowMapper rowMapper, String[][] arrParam) {
		JdbcStoredProcedure storeProcedure = null;
		try {
			if (rowMapper != null) {
				if (arrParam != null) {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper, arrParam);
				} else {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper);
				}
			} else {
				if (arrParam != null) {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, arrParam);
				} else {
					storeProcedure = new JdbcStoredProcedure(getDataSource(), procName);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return storeProcedure;
	}
} // end of class
