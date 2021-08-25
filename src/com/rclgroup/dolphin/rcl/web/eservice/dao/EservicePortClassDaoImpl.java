/*------------------------------------------------------
 EservicePortClassDaoImpl.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Pratya Thanuchaisak 08/08/2014
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePortClassMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityPopupMod;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_SI_GET_COMM_POPUP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_DG_LOOKUP;

/**
 * Class for DAO
 * 
 * @class EservicePortClassDaoImpl
 * @author NTL) Pratya
 * @version v1.00 2014/08/08
 * @see
 */
public class EservicePortClassDaoImpl extends AncestorJdbcDao implements EservicePortClassDao {

	public Map getList(Map amap) throws BusinessException, DataAccessException {
		System.out.println("[EservicePortClassDaoImpl][getList][Begin]");

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

			arrParams = new String[][] { { P_O_V_DG_PORT_CLASS_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK },
					{ P_I_V_COL_NAME, BLANK + ORACLE_VARCHAR, PARAM_IN, column },
					{ P_I_V_COL_VAL, BLANK + ORACLE_VARCHAR, PARAM_IN, find },
					{ P_I_V_SORT_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, sortby },
					{ P_I_V_ORDER_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, order },
					{ P_I_V_WILD_CARD, BLANK + ORACLE_VARCHAR, PARAM_IN, wildcard } };

			resultMap = new HashMap();
			System.out.println("[EservicePortClassDaoImpl][getList] storeProcedure :: " + storeProcedure);

			resultMap.put(KEY_CRITERIA_TEXT_FIND, find);
			resultMap.put(KEY_CRITERIA_COLUMN, column);
			resultMap.put(KEY_CRITERIA_SORTBY, sortby);
			resultMap.put(KEY_CRITERIA_ORDER, order);
			resultMap.put(KEY_CRITERIA_WILDCARD, wildcard);

			PRR_ESV_GET_DG_LOOKUP proc = new PRR_ESV_GET_DG_LOOKUP(getJdbcTemplate(), resultMap);
			resultMap = proc.executeDbProcedure();

			if (resultMap != null && !resultMap.isEmpty()) {
				lst = (List<EservicePortClassMod>) resultMap.get(P_O_V_DG_PORT_CLASS_DATA);
			}                             

			//System.out.println("[EservicePortClassDaoImpl][getList] lst :: " + lst);

			System.out.println("[EservicePortClassDaoImpl][getList] lst.size() :: " + lst.size());

			amap.put(KEY_DATA, lst);
			amap.put(KEY_SIZE, lst.size());

		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
		} finally {
			System.out.println("[EservicePortClassDaoImpl][getList][End]");
		}
		return amap;
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
				mod.setRecStatus(rs.getString("RECORD_STATUS"));
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
