package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_SAVE_COMMODITY_DATA {

	private JdbcTemplate jdbcTemplate;
	private Connection connection;
	private Map map;

	public PRE_SAVE_COMMODITY_DATA(JdbcTemplate jdbcTemplate, Map map) throws SQLException {
		this.jdbcTemplate = jdbcTemplate;
		connection = jdbcTemplate.getDataSource().getConnection();
		this.map = map;
	}

	public void executeDbProcedure() throws Exception{
		String V_COMMD_CD="";
		String V_COMMD_DESC="";
		String V_COMMD_SEQ="";
		int rsResult=0;
		Statement stm = null;
		ResultSet rs = null;
		try {
			System.out.println("commodty procedure started..");
			// delete
			

			String query1 = "select  " + "		count(*)  " + "	from  " + "		SEALINER.ITP080  " + "	where  "
					+ "		COMMODITY_GROUP_CODE = '"+map.get("P_I_V_COMMODITY_GROUP")+"'  " + "		and FCRCST = 'A'";

			// int count=jdbcTemplate.queryForInt(query1);
			int count = 0;
			stm = connection.createStatement();
			rs = stm.executeQuery(query1);
			if (rs.next()) {
				count = rs.getInt(1);
			}
			stm.close();
			rs.close();
			String query2;
			if (count > 0) {
				query2 = "SELECT  FCCODE  , FCDESC " + "                          FROM SEALINER.ITP080 "
						+ "                          WHERE COMMODITY_GROUP_CODE='" + map.get("P_I_V_COMMODITY_GROUP")
						+ "' " + "                          AND FCRCST='A' "
						+ "									and LENGTH(fccode)= 6"
						+ "                          ORDER BY FCCODE limit 1 ";
			} else {
				query2 = " SELECT  FCCODE  , FCDESC " + "                            FROM SEALINER.ITP080 "
						+ "                            WHERE COMMODITY_GROUP_CODE='GCA01' "
						+ "                            AND FCRCST='A' "
						+ "                            ORDER BY FCCODE  limit 1";
			}

			//List list = jdbcTemplate.query(query2, new Object[] {}, new CommodityCodeDesc());
			List list=new ArrayList();
			stm=connection.createStatement();
			rs=stm.executeQuery(query2);
			if(rs.next()) {
				List lst = new ArrayList();
				lst.add(rs.getString("FCCODE"));
				lst.add(rs.getString("FCDESC"));
				list.add(lst);
			}
			stm.close();
			rs.close();

			V_COMMD_CD = ((List) list.get(0)).get(0).toString();
			V_COMMD_DESC = ((List) list.get(0)).get(1).toString();
			
			String query3 = "SELECT COALESCE(MAX(BWCMSQ)+1,1) " + "  FROM SEALINER.BKP050 WHERE BWBKNO='"
					+ map.get("P_I_V_BOOKING_NO") + "'";

			//V_COMMD_SEQ = (String) jdbcTemplate.queryForObject(query3, String.class);

			stm=connection.createStatement();
			rs=stm.executeQuery(query3);
			if(rs.next()){
				V_COMMD_SEQ=rs.getString(1);
			}
			stm.close();
			rs.close();
			String INSERT_BKP050 = "INSERT INTO SEALINER.BKP050 (BWLINE,BWTRAD,BWAGNT,BWBKNO,BWSHTP,BWCMSQ,BWCMCD,BWMTWT,BWREFR,  "
					+ "                          BWDANG,BWOGFL,BWPORM,BWAUSR,BWADAT,BWATIM,BDCUSR,BDCDAT,BDCTIM, "
					+ "                          COMM_DESC,SPECIAL_HANDLING,COMMODITY_GROUP_CODE)VALUES ('"
					+ map.get("P_I_V_LINE") + "'" + "						  ,'" + map.get("P_I_V_TRADE") + "','"
					+ map.get("P_I_V_AGENT") + "','" + map.get("P_I_V_BOOKING_NO") + "','FCL'," + V_COMMD_SEQ
					+ "                         ,'" + V_COMMD_CD + "'," + map.get("P_I_V_GROSS_WEIGHT")
					+ ",'N','N','N','M','" + map.get("P_I_V_USER_ID") + "'"
					+ "                         , to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') "
					+ "                         ,'" + map.get("P_I_V_USER_ID")
					+ "', to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999')  "
					+ "                         , to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') ,'" +StringEscapeUtils.escapeSql( V_COMMD_DESC)
					+ "','N','" + map.get("P_I_V_COMMODITY_GROUP") + "' )";
			//jdbcTemplate.update(INSERT_BKP050);
			stm=connection.createStatement();
			rsResult=stm.executeUpdate(INSERT_BKP050);
			stm.close();
			
			if (map.get("P_I_V_SPECIAL_INSTRUCTION") != null) {
				String INSERT_BKP007 = "INSERT INTO SEALINER.BKP007 (BGLINE,BGTRAD, BGAGNT, BGBKNO, BGSEQN,IN_OUT,REMARKS_CATG,  "
						+ "                            BGRMKS,BGRMBY, BGRMDT, BGAUSR, BGADAT,  BGATIM, BGCUSR,BGCDAT, BGCTIM )  "
						+ "                   VALUES ( '" + map.get("P_I_V_LINE") + "','" + map.get("P_I_V_TRADE")
						+ "','" + map.get("P_I_V_AGENT") + "','" + map.get("P_I_V_BOOKING_NO") + "'," + V_COMMD_SEQ
						+ "                            ,'I', 'BKWEB',E'" + map.get("P_I_V_SPECIAL_INSTRUCTION") + "','"
						+ map.get("P_I_V_USER_ID") + "', to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999')"
						+ "                            ,'" + map.get("P_I_V_USER_ID")
						+ "',to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') "
						+ "                            ,'" + map.get("P_I_V_USER_ID")
						+ "',to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999'))";

				//jdbcTemplate.update(INSERT_BKP007);
				stm=connection.createStatement();
				rsResult=stm.executeUpdate(INSERT_BKP007);
				stm.close();
			}
		if(map.get("P_I_V_SPECIAL_FLAG").equals("Y")) {	
			if(map.get("P_I_V_RATE_TYPE").equals("D1")) {
				String SPECIAL_RATE_TYPE_QUERY_D1 ="INSERT INTO SEALINER.BOOKING_DG_COMM_DETAIL (BBLVL1,   " + 
						"                                                         BBLVL2,   " + 
						"                                                         BBLVL3,   " + 
						"                                                         BOOKING_NO,   " + 
						"                                                         SHIPMENT_TYPE,   " + 
						"                                                         COMMODITY_SQNO,   " + 
						"                                                         HZ_FLPT_FROM,   " + 
						"                                                         HZ_BS,   " + 
						"                                                         UN_NO,   " + 
						"                                                         UN_VARIANT,   " + 
						"                                                         IMO_CLASS,   " + 
						"                                                         PORT_CLASS_CODE,   " + 
						"                                                         RESIDUE,   " + 
						"                                                         FUMIGATION_YN,   " + 
						"                                                         BBAUSR,   " + 
						"                                                         BBADAT,   " + 
						"                                                         RECORD_ADD_TIME,   " + 
						"                                                         BBCUSR,   " + 
						"                                                         BBCDAT,   " + 
						"                                                         RECORD_CHANGE_TIME,   " + 
						"                                                         BBRCST)   " + 
						"                                                 VALUES( '" + map.get("P_I_V_LINE") + "',   " + 
						"                                                         '" + map.get("P_I_V_TRADE") + "',   " + 
						"                                                         '" + map.get("P_I_V_AGENT") + "',   " + 
						"                                                         '" + map.get("P_I_V_BOOKING_NO") + "',   " + 
						"                                                         'FCL',   " + 
						"                                                         '" + map.get("P_I_V_SEQ") + "',   " + 
						"                                                         " + map.get("P_I_V_DG_FLASH_POINT") + ",   " + 
						"                                                         '" + map.get("P_I_V_DG_UNIT") + "',   " + 
						"                                                         '" + map.get("P_I_V_DG_UNNO") + "',   " + 
						"                                                         '" + map.get("P_I_V_DG_VARINT") + "',   " + 
						"                                                         '" + map.get("P_I_V_DG_IMDG") + "',   " + 
						"                                                         '" + map.get("P_I_V_PORT_CLASS") + "',   " + 
						"                                                         '" + map.get("P_I_V_DG_RESIDUE") + "',   " + 
						"                                                         '" + map.get("P_I_V_DG_FUMIGATION") + "',   " + 
						"                                                         '" + map.get("P_I_V_USER_ID") + "',   " + 
						"														  to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999') , " + 
						"                                                         to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999')  ,   " + 
						"                                                         '" + map.get("P_I_V_USER_ID") + "',   " + 
						"                                                         to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999') ,   " + 
						"                                                         to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999')  ,   " + 
						"                                                         'A')";
				stm=connection.createStatement();
				rsResult=stm.executeUpdate(SPECIAL_RATE_TYPE_QUERY_D1);
				stm.close();
			}else if(map.get("P_I_V_RATE_TYPE").equals("O0")) {
				String SPECIAL_RATE_TYPE_QUERY_O0 = " INSERT INTO SEALINER.BOOKING_OG_COMM_DETAIL (BBLVL1,  " + 
						"                                                            BBLVL2,  " + 
						"                                                            BBLVL3,  " + 
						"                                                            BOOKING_NO,  " + 
						"                                                            SHIPMENT_TYPE,  " + 
						"                                                            COMMODITY_SQNO,  " + 
						"                                                            OG_LENGTH,  " + 
						"                                                            OG_WIDTH,  " + 
						"                                                            OG_HEIGHT,  " + 
						"                                                            OG_DIAMETER,  " + 
						"                                                            RECORD_ADD_USER,  " + 
						"                                                            RECORD_ADD_DATE,  " + 
						"                                                            RECORD_ADD_TIME,  " + 
						"                                                            RECORD_CHANGE_USER,  " + 
						"                                                            RECORD_CHANGE_DATE,  " + 
						"                                                            RECORD_CHANGE_TIME,  " + 
						"                                                            RECORD_STATUS)  " + 
						"                                                    VALUES( '" + map.get("P_I_V_LINE") + "',  " + 
						"                                                            '" + map.get("P_I_V_TRADE") + "',  " + 
						"                                                            '" + map.get("P_I_V_AGENT") + "',  " + 
						"                                                            '" + map.get("P_I_V_BOOKING_NO") + "',  " + 
						"                                                            'FCL',  " + 
						"                                                            '" + map.get("P_I_V_SEQ") + "',  " + 
						"                                                            " + map.get("P_I_V_OOG_LENGTH") + ",  " + 
						"                                                            " + map.get("P_I_V_OOG_WIDTH") + ",  " + 
						"                                                            " + map.get("P_I_V_OOG_HEIGHT") + ",  " + 
						"                                                            " + map.get("P_I_V_OOG_DIAMETER") + ",  " + 
						"                                                            '" + map.get("P_I_V_USER_ID") + "',  " + 
						"														     to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999')  " + 
						"                                                            to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') ,  " + 
						"                                                            '" + map.get("P_I_V_USER_ID") + "',  " + 
						"                                                            to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),  " + 
						"                                                            to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999'),  " + 
						"                                                            'A') ";
				stm=connection.createStatement();
				rsResult=stm.executeUpdate(SPECIAL_RATE_TYPE_QUERY_O0);
				stm.close();
			}else if(map.get("P_I_V_RATE_TYPE").equals("RF")) {
				String SPECIAL_RATE_TYPE_QUERY_RF = "INSERT INTO SEALINER.BOOKING_RFR_COMM_DETAIL(BBLVL1,   " + 
						"                                                            BBLVL2,   " + 
						"                                                            BBLVL3,   " + 
						"                                                            BOOKING_NO,   " + 
						"                                                            SHIPMENT_TYPE,   " + 
						"                                                            COMMODITY_SQNO,   " + 
						"                                                            REEFER_FROM,   " + 
						"                                                            REEFER_BS,   " + 
						"                                                            VENTILATION,   " + 
						"                                                            REEFER_REMARKS,   " + 
						"                                                            HUMIDITY,   " + 
						"                                                            CONTROLLED_ATM,   " + 
						"                                                            NITROGEN,   " + 
						"                                                            OXYGEN,   " + 
						"                                                            CO2,   " + 
						"                                                            RFR_MODE,   " + 
						"                                                            PRE_COOLED,   " + 
						"                                                            RECORD_ADD_USER,   " + 
						"                                                            RECORD_ADD_DATE,   " + 
						"                                                            RECORD_ADD_TIME,   " + 
						"                                                            RECORD_CHANGE_USER,   " + 
						"                                                            RECORD_CHANGE_DATE,   " + 
						"                                                            RECORD_CHANGE_TIME,   " + 
						"                                                            BBRCST)   " + 
						"                                                    VALUES('" + map.get("P_I_V_LINE") + "',   " + 
						"                                                           '" + map.get("P_I_V_TRADE") + "',   " + 
						"                                                           '" + map.get("P_I_V_AGENT") + "',   " + 
						"                                                           '" + map.get("P_I_V_BOOKING_NO") + "',   " + 
						"                                                           'FCL',   " + 
						"                                                           '" + map.get("P_I_V_SEQ") + "',   " + 
						"                                                           " + map.get("P_I_V_RF_TEMP") + ",   " + 
						"                                                           'C',   " + 
						"                                                           " + map.get("P_I_V_RF_VENTILATION") + ",   " + 
						"                                                           '" + map.get("P_I_V_RF_REMARK") + "',   " + 
						"                                                           " + map.get("P_I_V_RF_HUMIDITY") + ",   " + 
						"                                                           '" + map.get("P_I_V_RF_CON_ATM") + "',   " + 
						"                                                           " + map.get("P_I_V_RF_NITROGEN") + ",   " + 
						"                                                           " + map.get("P_I_V_RF_OXYGEN") + ",   " + 
						"                                                           " + map.get("P_I_V_RF_CO2") + ",   " + 
						"                                                           '" + map.get("P_I_V_RF_REFR_MODE") + "',   " + 
						"                                                           '" + map.get("P_I_V_RF_PRE_COOL") + "',   " + 
						"                                                           '" + map.get("P_I_V_USER_ID") + "',   " + 
						"														    to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999') , " + 
						"                                                           to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999') ,   " + 
						"                                                           '" + map.get("P_I_V_USER_ID") + "',   " + 
						"                                                           to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),   " + 
						"                                                           to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999'),   " + 
						"                                                           'A') ";
				stm=connection.createStatement();
				rsResult=stm.executeUpdate(SPECIAL_RATE_TYPE_QUERY_RF);
				stm.close();
			}	
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (stm != null && !stm.isClosed()) {
					stm.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("commodty procedure ended..");
		Map outPut = new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);

	}

	class CommodityCodeDesc implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {

			List lst = new ArrayList();
			lst.add(rs.getString("FCCODE"));
			lst.add(rs.getString("FCDESC"));
			return lst;
		}

	}
}
