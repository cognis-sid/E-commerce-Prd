package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_SAVE_EQUIPMENT_DATA {

	private JdbcTemplate jdbcTemplate;
	private Connection connection;
	private Map map;

	public PRE_SAVE_EQUIPMENT_DATA(JdbcTemplate jdbcTemplate, Map map) throws SQLException {
		this.jdbcTemplate = jdbcTemplate;
		this.connection = jdbcTemplate.getDataSource().getConnection();
		this.map = map;
	}

	public void executeDbProcedure(boolean isDeleteFlag)throws Exception {
		Statement stm = null;
		ResultSet rs = null;
		// String V_CUST_NAME;
		String V_EQP_SEQ = "";
		String V_BKG_SUP_SEQ = "";
		String V_TOTAL_TEU = "";
		Integer bcdqty_temp = 0;
		Integer bcoqty_temp = 0;
		int rsResult = 0;
		try {
			if (isDeleteFlag) {
				// delete
				String deleteQuery = "delete from ESV_WB_SIZETYPE Where pk_booking_no='" + map.get("P_I_V_BOOKING_NO")
						+ "' ";
				jdbcTemplate.update(deleteQuery);

				deleteQuery = "delete from SEALINER.BKP032 Where bcbkno='" + map.get("P_I_V_BOOKING_NO") + "' ";
				jdbcTemplate.update(deleteQuery);
				
				deleteQuery = "delete from SEALINER.BOOKING_SUPPLIER_DETAIL Where booking_no='" + map.get("P_I_V_BOOKING_NO") + "' ";
				jdbcTemplate.update(deleteQuery);
			}
			System.out.println("Strat equipment procedure..");
			// no need customer name sushil
			/*
			 * String v_cust_name_query="SELECT CUNAME " +
			 * "  FROM SEALINER.ITP010 WHERE CUCUST='"+map.get("P_I_V_CUST_CODE")+"'";
			 * 
			 * System.out.println(v_cust_name_query); V_CUST_NAME =(String)
			 * jdbcTemplate.queryForObject(v_cust_name_query, String.class);
			 */
			String V_EQP_SEQ_query = "SELECT COALESCE(MAX(EQP_SIZETYPE_SEQNO)+1,1)  "
					+ "FROM SEALINER.BKP032 WHERE BCBKNO='" + map.get("P_I_V_BOOKING_NO") + "'";

			// V_EQP_SEQ =(String) jdbcTemplate.queryForObject(V_EQP_SEQ_query,
			// String.class);
			stm = connection.createStatement();
			rs = stm.executeQuery(V_EQP_SEQ_query);
			if (rs.next()) {
				V_EQP_SEQ = rs.getString(1);
			}
			stm.close();
			rs.close();

			if (map.get("P_I_V_CARGO_TYPE").equals("D1")) {
				bcdqty_temp = Integer.parseInt((String) map.get("P_I_V_QTY_LADEN"));
			} else {
				bcdqty_temp = 0;
			}
			if (map.get("P_I_V_CARGO_TYPE").equals("O0")) {
				bcoqty_temp = (Integer) map.get("P_I_V_QTY_LADEN");
			} else {
				bcoqty_temp = 0;
			}

			String INSERT_BKP032_BAMWT1 = "  INSERT INTO SEALINER.BKP032 (BCLINE,BCTRAD,BCAGNT, BCBKNO,BCSIZE, BCTYPE, SPECIAL_HANDLING,BCTEUS,BCFQTY, "
					+ "                              BCDQTY, BCRQTY, BCOQTY,BCEQTY, BCSTAT,DEMURRAGE_FREEDAYS, EXP_DETENTION_FREEDAYS, "
					+ "                              IMP_DETENTION_FREEDAYS, BCRCST, BCAUSR, BCADAT, BCATIM,BCCUSR, BCCDAT,BCCTIM, "
					+ "                              KILLED_SLOTS,SHIPMENT_TYPE,BUNDLE,EQP_SIZETYPE_SEQNO, POL_STAT, POD_STAT,SPECIAL_STORAGE) "
					+ "                    VALUES ('" + map.get("P_I_V_LINE") + "','" + map.get("P_I_V_TRADE") + "','"
					+ map.get("P_I_V_AGENT") + "'," + "							 '" + map.get("P_I_V_BOOKING_NO") + "',"
					+ "            				 '" + map.get("P_I_V_EQ_SIZE") + "','" + map.get("P_I_V_EQ_TYPE")
					+ "','" + map.get("P_I_V_CARGO_TYPE") + "'," + "CASE WHEN '" + map.get("P_I_V_EQ_SIZE")
					+ "' = '20'  THEN COALESCE(" + map.get("P_I_V_QTY_LADEN") + ",0)+ COALESCE("
					+ map.get("P_I_V_QTY_MTY") + ",0)" + "WHEN '" + map.get("P_I_V_EQ_SIZE")
					+ "' = '40' THEN 2*( COALESCE(" + map.get("P_I_V_QTY_LADEN") + ",0) +" + "COALESCE("
					+ map.get("P_I_V_QTY_MTY") + ",0))" + "ELSE 2.25*(COALESCE(" + map.get("P_I_V_QTY_LADEN")
					+ ",0) + COALESCE(" + map.get("P_I_V_QTY_MTY") + ",0))" + " END," + "'" + map.get("P_I_V_QTY_LADEN")
					+ "'," + +bcdqty_temp + "," + "CASE WHEN '" + map.get("P_I_V_EQ_TYPE") + "' IN ('RE','RH') THEN "
					+ map.get("P_I_V_QTY_LADEN") + " " + "ELSE 0 END ," + +bcoqty_temp + "," + map.get("P_I_V_QTY_MTY")
					+ ",'O',0,0,0,'A','" + map.get("P_I_V_USER_ID") + "',"
					+ "to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),  TO_NUMBER(TO_CHAR(now(),'HH24MI'),'9G999g999') ,"
					+ "'" + map.get("P_I_V_USER_ID") + "',to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),"
					+ "TO_NUMBER(TO_CHAR(now(),'HH24MI'),'9G999g999') ,0," + "'FCL',0," + V_EQP_SEQ + "," + "COALESCE('"
					+ map.get("P_I_V_POL_STATUS") + "','L')," + "COALESCE('" + map.get("P_I_V_POD_STATUS") + "','L'),'"+map.get("P_I_V_SPECIAL_CARGO")+"') ";
			
			// jdbcTemplate.update(INSERT_BKP032_BAMWT1);

			stm = connection.createStatement();
			rsResult = stm.executeUpdate(INSERT_BKP032_BAMWT1);

			stm.close();

			String v_bkg_sup_seq_que = "SELECT COALESCE(MAX(SUPPLIER_SQNO)+1,1)   "
					+ "  FROM SEALINER.BOOKING_SUPPLIER_DETAIL WHERE BOOKING_NO='" + map.get("P_I_V_BOOKING_NO") + "'";
			// V_BKG_SUP_SEQ=(String) jdbcTemplate.queryForObject(v_bkg_sup_seq_que,
			// String.class);

			stm = connection.createStatement();
			rs = stm.executeQuery(v_bkg_sup_seq_que);
			if (rs.next()) {
				V_BKG_SUP_SEQ = rs.getString(1);
			}
			stm.close();
			rs.close();

			String INSERT_BOOKING_SUPPLIER_DETAIL = "INSERT INTO SEALINER.BOOKING_SUPPLIER_DETAIL ( SELVL1,SELVL2,SELVL3,"
					+ "										  BOOKING_NO,SUPPLIER_SQNO,  "
					+ "                                         EQ_SIZE,EQ_TYPE,SPECIAL_HANDLING, SUPPLIER_CODE,SUPPLIER_LOCATION,  "
					+ "                                         POSITIONING_TERMINAL,POSITIONING_DATE,POSITIONING_TIME,FULL_QTY,  "
					+ "                                         EMPTY_QTY, EQP_RESERVED,SERCST, SEAUSR,SEADAT,RECORD_ADD_TIME,  "
					+ "                                         SECUSR, SECDAT,RECORD_CHANGE_TIME,SHIPMENT_TYPE,  "
					+ "                                         EQP_SIZETYPE_SEQNO) VALUES ('" + map.get("P_I_V_LINE")
					+ "','" + map.get("P_I_V_TRADE") + "','" + map.get("P_I_V_AGENT") + "',"
					+ "										  '" + map.get("P_I_V_BOOKING_NO") + "'," + V_BKG_SUP_SEQ
					+ "," + map.get("P_I_V_EQ_SIZE") + ",'" + map.get("P_I_V_EQ_TYPE") + "'"
					+ "										 ,'" + map.get("P_I_V_CARGO_TYPE") + "','"
					+ map.get("P_I_V_CUST_CODE") + "','" + map.get("P_I_V_POL") + "','"
					+ map.get("P_I_V_EMPTY_PICKUP_DEP") + "'" + "										 ,"
					+ ((map.get("P_I_V_EMPTY_PICKUP_DATE") == null || "".equals(map.get("P_I_V_EMPTY_PICKUP_DATE")))
							? null
							: "TO_NUMBER(TO_CHAR(TO_DATE('"+map.get("P_I_V_EMPTY_PICKUP_DATE")+"', 'DD-MM-YYYY'), 'YYYYMMDD'),'9G999g9999')")
					+ " 										 ,0," + map.get("P_I_V_QTY_LADEN") + ","
					+ map.get("P_I_V_QTY_MTY") + ",'N','A'" + "										 ,'"
					+ map.get("P_I_V_USER_ID")
					+ "',to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999')"
					+ "										 ,'" + map.get("P_I_V_USER_ID")
					+ "',to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999'),"
					+ "                                        'FCL'," + V_EQP_SEQ + ")";

			// jdbcTemplate.update(INSERT_BOOKING_SUPPLIER_DETAIL);

			stm = connection.createStatement();
			rsResult = stm.executeUpdate(INSERT_BOOKING_SUPPLIER_DETAIL);
			stm.close();

			String UPDATE_BKP001 = "UPDATE SEALINER.BKP001 " + "              SET BAMWT1 = COALESCE("
					+ map.get("P_I_V_SUM_GROSS_WEIGHT") + ",0) " + "       WHERE  BABKNO='"
					+ map.get("P_I_V_BOOKING_NO") + "'";

			// jdbcTemplate.update(UPDATE_BKP001);

			stm = connection.createStatement();
			rsResult = stm.executeUpdate(UPDATE_BKP001);
			stm.close();

			String INSERT_ESV_WB_SIZETYPE = "INSERT INTO ESV_WB_SIZETYPE (PK_BOOKING_NO,EQ_SIZE_TYPE_SEQ,EQ_SIZE,EQ_TYPE,CARGO_TYPE,LADEN_QTY, "
					+ "                                                MT_QTY,WEIGHT,WEIGHT_TYPE,POL_STAT,POD_STAT,RECORD_STATUS, "
					+ "                                                RECORD_ADD_USER,RECORD_ADD_DATE,RECORD_CHANGE_USER,RECORD_CHANGE_DATE  "
					+ "                                                )VALUES('" + map.get("P_I_V_BOOKING_NO") + "',"
					+ V_EQP_SEQ + "," + map.get("P_I_V_EQ_SIZE") + ",'" + map.get("P_I_V_EQ_TYPE") + "'"
					+ "												,'" + map.get("P_I_V_CARGO_TYPE") + "',"
					+ map.get("P_I_V_QTY_LADEN") + "," + map.get("P_I_V_QTY_MTY") + "," + map.get("P_I_V_GROSS_WEIGHT")
					+ "												,'" + map.get("P_I_V_WEIGHT_TYPE") + "','"
					+ map.get("P_I_V_POL_STATUS") + "','" + map.get("P_I_V_POD_STATUS") + "','A','"
					+ map.get("P_I_V_USER_ID") + "'" + "												,now(),'"
					+ map.get("P_I_V_USER_ID") + "',now() )";
			 //jdbcTemplate.update(INSERT_ESV_WB_SIZETYPE);
			 stm = connection.createStatement();
			 rsResult = stm.executeUpdate(INSERT_ESV_WB_SIZETYPE);
			 stm.close();
			 
			/*
			 * int ladenTemp=Integer. parseInt((String) map.get("P_I_V_QTY_LADEN")); for(int
			 * i=0;i<ladenTemp;i++) { stm = connection.createStatement(); rsResult =
			 * stm.executeUpdate(INSERT_ESV_WB_SIZETYPE); stm.close();
			 * 
			 * 
			 * String INSERT_BKG_EQUIPMENT =
			 * "INSERT INTO BKG_EQUIPMENT (BICTRN,BIBKNO,CARRIER_SEAL_VIN,SHIPPER_SEAL,MET_WEIGHT,"
			 * + "					  MET_MEASUREMENT,BIEORF,BICSZE,BICNTP,BISEQN	)" +
			 * "					  VALUES('','" + map.get("P_I_V_BOOKING_NO") +
			 * "','',''," + map.get("P_I_V_GROSS_WEIGHT") + ",null,'L','" +
			 * map.get("P_I_V_EQ_SIZE") + "'," + "					  '" +
			 * map.get("P_I_V_EQ_TYPE") + "'," + V_EQP_SEQ + ")	";
			 * 
			 * // jdbcTemplate.update(INSERT_BKG_EQUIPMENT);
			 * 
			 * stm = connection.createStatement(); rsResult =
			 * stm.executeUpdate(INSERT_BKG_EQUIPMENT); stm.close(); }
			 */
			 
			String V_TOTAL_TEU_QUERY = "SELECT SUM(CASE EQ_SIZE WHEN 20 THEN LADEN_QTY WHEN 40 THEN LADEN_QTY*2 ELSE LADEN_QTY*2.5 END)+ SUM(CASE EQ_SIZE WHEN 20 THEN MT_QTY WHEN 40 THEN MT_QTY*2 ELSE MT_QTY*2.5 END) TTL_TEU "
					+ "	 FROM ESV_WB_SIZETYPE " + "	 WHERE PK_Booking_no = '" + map.get("P_I_V_BOOKING_NO") + "'";

			// V_TOTAL_TEU=(String) jdbcTemplate.queryForObject(V_TOTAL_TEU_QUERY,
			// String.class);

			stm = connection.createStatement();
			rs = stm.executeQuery(V_TOTAL_TEU_QUERY);
			if (rs.next()) {
				V_TOTAL_TEU = rs.getString(1);
			}
			stm.close();
			rs.close();

			String UPDATE_BKP001_BATEU1 = "UPDATE SEALINER.BKP001 " + "	 SET BATEU1 = '" + V_TOTAL_TEU + "'"
					+ "	 WHERE BABKNO ='" + map.get("P_I_V_BOOKING_NO") + "'";
			// jdbcTemplate.update(UPDATE_BKP001_BATEU1);

			stm = connection.createStatement();
			rsResult = stm.executeUpdate(UPDATE_BKP001_BATEU1);
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

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

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		Map outPut = new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
		System.out.println("end equipment procedure..");
	}

}
