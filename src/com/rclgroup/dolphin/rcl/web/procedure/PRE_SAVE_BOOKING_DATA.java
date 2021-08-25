package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_SAVE_BOOKING_DATA {

	private JdbcTemplate jdbcTemplate;
	private Connection connection;
	private Map map;
	private String query1;

	public PRE_SAVE_BOOKING_DATA(JdbcTemplate jdbcTemplate, Map map) throws SQLException {
		this.jdbcTemplate = jdbcTemplate;
		this.connection = this.jdbcTemplate.getDataSource().getConnection();
		this.map = map;
	}

	public void executeDbProcedure() throws SQLException {
		System.out.println("save booking Strart");
		Statement stm = null;
		ResultSet rs = null;
		try {

			String V_POL_FSC="";
			String V_C_S="";
			String V_CUST_CD="";
			String V_YEAR="";
			String YEAR="";
			String V_FLAG="";
			String V_VAL="";
			Integer V_CNT=0;
			String V_O_HAUL; // -- MYO: 20130712
			String V_D_HAUL; // -- MYO: 20130712
			String P_O_V_LINE_TEMP;
			String P_O_V_TRADE_TEMP;
			String P_O_V_AGENT_TEMP;

			Map outPut = new HashMap();
			String polfscquery = "SELECT PIOFFC AS V_FSC " + "FROM SEALINER.ITP040 " + "WHERE PICODE='"
					+ map.get("P_I_V_PORT_OF_LOADING") + "'" + " AND PIRCST='A'";
			System.out.println("PRE_SAVE_BOOKING_DATA. -->"+polfscquery);

			V_POL_FSC = (String) jdbcTemplate.queryForObject(polfscquery, new Object[] {}, String.class);

			stm = connection.createStatement();
			rs = stm.executeQuery(polfscquery);
			if (rs.next()) {
				V_POL_FSC = rs.getString("V_FSC");
			}
			rs.close();
			stm.close();
			
			String v_valquery = " SELECT CRFLV1||'-'||CRFLV2||'-'||CRFLV3 as \"V_LINE_TRADE_AGT\" "
					+ "  FROM SEALINER.ITP188 WHERE CRCNTR='" + V_POL_FSC + "' AND CRRCST='A'";
			// System.out.println("PRE_SAVE_BOOKING_DATA. -->"+v_valquery);
			//V_VAL = (String) jdbcTemplate.queryForObject(v_valquery, new Object[] {}, String.class);
			
			stm = connection.createStatement();
			rs = stm.executeQuery(v_valquery);
			if (rs.next()) {
				V_VAL = rs.getString("V_LINE_TRADE_AGT");
			}
			rs.close();
			stm.close();

			String[] arrOfStr = V_VAL.split("-");

			outPut.put("P_O_V_LINE", arrOfStr[0]);
			P_O_V_LINE_TEMP = arrOfStr[0];
			outPut.put("P_O_V_TRADE", arrOfStr[1]);
			P_O_V_TRADE_TEMP = arrOfStr[1];
			outPut.put("P_O_V_AGENT", arrOfStr[2]);
			P_O_V_AGENT_TEMP = arrOfStr[2];

			if (!map.get("P_I_V_PLACE_OF_RECEIPT").equals(map.get("P_I_V_PORT_OF_LOADING")))
				V_O_HAUL = "C";
			else
				V_O_HAUL = "M";

			if (!map.get("P_I_V_PLACE_OF_DELIVERY").equals(map.get("P_I_V_PORT_OF_DISCHARGE")))
				V_D_HAUL = "C";
			else
				V_D_HAUL = "M";

			String v_cntyQurery = "SELECT COUNT(*)  " + "FROM SEALINER.ITP010, SEALINER.SC_PRSN_LOG_INFO "
					+ "WHERE CUCUST = ORG_CODE AND PRSN_LOG_ID = '" + map.get("P_I_V_USER_ID") + "'"
					+ " AND CURCST='A' AND RCST='A'";
			// System.out.println("PRE_SAVE_BOOKING_DATA. -->"+v_cntyQurery);
			//V_CNT = jdbcTemplate.queryForInt(v_cntyQurery, new Object[] {});
			
			stm = connection.createStatement();
			rs = stm.executeQuery(v_cntyQurery);
			if (rs.next()) {
				V_CNT = rs.getInt(1);
			}
			rs.close();
			stm.close();


			if (V_CNT != 0) {
				String V_C_SandV_CUST_CD = "	 SELECT CUCORS  ,CUCUST    "
						+ "    FROM SEALINER.ITP010, SEALINER.SC_PRSN_LOG_INFO  "
						+ "    WHERE CUCUST = ORG_CODE AND PRSN_LOG_ID ='" + map.get("P_I_V_USER_ID") + "'"
						+ "    AND CURCST='A' AND RCST='A'";
				// System.out.println("PRE_SAVE_BOOKING_DATA. -->"+V_C_SandV_CUST_CD);
				//List list = jdbcTemplate.query(V_C_SandV_CUST_CD, new Object[] {}, new V_C_SandV_CUST_CD());
				System.out.println(V_C_SandV_CUST_CD);
				List list = new ArrayList<>();
				stm = connection.createStatement();
				rs = stm.executeQuery(V_C_SandV_CUST_CD);
				while (rs.next()) {
					List list1 = new LinkedList();
					list1.add(rs.getString("CUCORS"));
					list1.add(rs.getString("CUCUST"));
					list.add(list1);
				}
				rs.close();
				stm.close();

				
				V_C_S = ((List) list.get(0)).get(0).toString();// V_C_S
				V_CUST_CD = ((List) list.get(0)).get(1).toString();// V_CUST_CD

			} else {
				V_CUST_CD = null;
				V_C_S = null;
			}
			outPut.put("P_O_V_CUSTOMER_CODE", V_CUST_CD);
			Date today = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(today);
			String yyyy = (cal.get(Calendar.YEAR)) + "";
			V_YEAR = yyyy.substring(0, 2);
			YEAR = yyyy.substring(2, 4);
			String bookingNoQuery = "SELECT substring( cast('10000000' + COUNTER + 1 as varchar), 2)  "
					+ "     FROM SEALINER.REF_NO_COUNTER " + "     WHERE REF_TYPE = 'BKG' AND FSC_CODE = '" + V_POL_FSC
					+ "'" + "     AND COUNTER_YEAR = '" + V_YEAR + "'";
			// System.out.println("PRE_SAVE_BOOKING_DATA. -->"+bookingNoQuery);
			//String V_COUNTER = (String) jdbcTemplate.queryForObject(bookingNoQuery, String.class);
			String V_COUNTER="";
			
			stm = connection.createStatement();
			rs = stm.executeQuery(bookingNoQuery);
			if (rs.next()) {
				V_COUNTER = rs.getString(1);
			}
			rs.close();
			stm.close();

			
			String bookingNo = V_POL_FSC +    YEAR + V_COUNTER;
			outPut.put("P_O_V_BOOKING_NO", bookingNo);
			outPut.put("P_O_V_BOOKING_REF", bookingNo);

			String update_Boking_sqn = " UPDATE SEALINER.REF_NO_COUNTER  " + "          SET COUNTER = TO_NUMBER(RIGHT('"
					+ bookingNo + "',6),'9G999g999')   " + "          WHERE REF_TYPE = 'BKG' AND FSC_CODE ='"
					+ V_POL_FSC + "'  " + "                AND COUNTER_YEAR ='" + V_YEAR + "' ";
			//jdbcTemplate.update(update_Boking_sqn);
			// System.out.println("PRE_SAVE_BOOKING_DATA. -->"+update_Boking_sqn);
			stm = connection.createStatement();
			int stmRes=stm.executeUpdate(update_Boking_sqn);
			stm.close();
			 
			if (map.get("P_I_V_QTN_NO") != null) {

				String custNameQuery = "SELECT CUNAME " + "    FROM SEALINER.QTP001,SEALINER.ITP010 "
						+ "    WHERE CUCUST=QAIQCD " + "    AND QAQUNO='" + map.get("P_I_V_QUOTATION_NUMBER") + "' ";
				// System.out.println("PRE_SAVE_BOOKING_DATA. -->"+custNameQuery);
				
				stm = connection.createStatement();
				rs = stm.executeQuery(custNameQuery);
				if (rs.next()) {
					outPut.put("P_O_V_CUSTOMER_NAME", rs.getString(1));
				}
				rs.close();
				stm.close();
				
				//outPut.put("P_O_V_CUSTOMER_NAME", (String) jdbcTemplate.queryForObject(custNameQuery, String.class));
			}

			String BABKBY_TEMP;
			String BOOKING_TYPE_temp;
			if (map.get("P_I_V_REP_FLAG").equals("Y")) {
				BABKBY_TEMP = map.get("P_I_V_REP_CODE").toString();
			} else {
				BABKBY_TEMP = V_CUST_CD;
			}

			if (map.get("P_I_V_SAVE_OPERATION_FLAG").equals("N")) {
				BOOKING_TYPE_temp = "N";
			} else {
				BOOKING_TYPE_temp = "TB";
			}
            System.out.println("end of select statement ....");
            
			String INSERT_BKP001 = "INSERT INTO SEALINER.BKP001 (BALINE,BATRAD,BAAGNT,BABKNO,BABKDT,BAOFFC,BABKBY,BAQUNO,BABKTP,BASTAT,  "
					+ "                          BACLBY,BACBPH,CALLER_FAX,CALLER_EMAIL,BAOPCD,BAMODE,REFERENCE_NO,BAPORM,  "
					+ "                          BASTP1,BAORGN,BAPOL,BAPOD,BADSTN,CREATED_THRU_WEB,WEB_BOOK_REF,BASLDT,  "
					+ "                          BACADT,BOOKING_TYPE,BARCST,BAAUSR,BAADAT,BAATIM,BKG_STATUS_IND,BABLOF,  "
					+ "                          RATE_FOR,ORIGIN_HAULAGE,DESTINATION_HAULAGE,BKFERN,TOTERMINAL,FROMTERMINAL,vesseletd,first_leg_location,first_leg_terminal)  "
					+ "                    	   VALUES('" + P_O_V_LINE_TEMP + "','" + P_O_V_TRADE_TEMP + "','"
					+ P_O_V_AGENT_TEMP + "','" + bookingNo + "',"
					+ "	TO_NUMBER(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),'" + V_POL_FSC + "',"
					+ ((BABKBY_TEMP==null || "".equals(BABKBY_TEMP) )?null:"'"+BABKBY_TEMP+"'") + "," + "                          '" + map.get("P_I_V_QUOTATION_NUMBER") + "',"
					+ ((V_C_S==null || "".equals(V_C_S) )?null:"'"+V_C_S+"'") + ",'O','" + map.get("P_I_V_CONTACT") + "','" + map.get("P_I_V_TELEPHONE") + "','"
					+ map.get("P_I_V_FAX") + "'," + "                          '" + map.get("P_I_V_EMAIL") + "','RCL','"
					+ map.get("P_I_V_SHIPMENT_TERM") + "','" + map.get("P_I_V_CUSTOMER_REF") + "','M','FCL',"
					+ "							COALESCE('" + map.get("P_I_V_PLACE_OF_RECEIPT") + "','"
					+ map.get("P_I_V_PORT_OF_LOADING") + "')," + "                          '"
					+ map.get("P_I_V_PORT_OF_LOADING") + "'," + "                          '"
					+ map.get("P_I_V_PORT_OF_DISCHARGE") + "'" + "                          ,COALESCE('"
					+ map.get("P_I_V_PLACE_OF_DELIVERY") + "','" + map.get("P_I_V_PORT_OF_DISCHARGE") + "'),'Y',"
					+ ((map.get("P_I_V_TEMPLATE_NAME") == null || "".equals(map.get("P_I_V_TEMPLATE_NAME"))) ? null
							: "E'" + map.get("P_I_V_TEMPLATE_NAME") + "'")
					+ "                          ,TO_NUMBER(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999')"
					+ "                          ,TO_NUMBER(TO_CHAR(TO_DATE('" + map.get("P_I_V_SHIPMENT_DATE")
					+ "', 'DD/MM/YYYY'), 'YYYYMMDD'),'9G999g9999')" + "                          ,'" + BOOKING_TYPE_temp
					+ "','A','" + map.get("P_I_V_USER_ID") + "'"
					+ "                          ,to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999')"
					+ "                          ,to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999'),'S','" + V_POL_FSC
					+ "','S','" + V_O_HAUL + "','" + V_D_HAUL + "','" + bookingNo + "','"+map.get("P_I_V_TO_TERMINAL")+"','"+map.get("P_I_V_FROM_TERMINAL")+"'"
					+ ",to_date(to_char(TO_DATE('"+map.get("P_I_V_VESSLE_ETD")+"','DD/MM/YYYY'),'YYYYMMDD'),'YYYYMMDD'),'"+map.get("P_I_V_FIRST_LEG_LOCATION")+"','"+map.get("P_I_V_FIRST_LEG_TERMINAL")+"')";

			//jdbcTemplate.update(INSERT_BKP001);
			System.out.println(INSERT_BKP001);
			stm = connection.createStatement();
			int countQury = stm.executeUpdate(INSERT_BKP001);
			stm.close();
			for (int i = 1; i < 6; i++) {
				if (i == 1)
					V_FLAG = "O";
				else if (i == 2)
					V_FLAG = "R";
				else if (i == 3)
					V_FLAG = "S";
				else if (i == 4)
					V_FLAG = "U";
				else
					V_FLAG = "B";

				String v_flag_temp;
				if (V_FLAG.equals("R")) {
					v_flag_temp = "Y";
				} else {
					v_flag_temp = "N";
				}

				String INSERT_BKP030 = " INSERT INTO SEALINER.BKP030 (BNLINE, BNTRAD,BNAGNT, BNBKNO,BNCSTP, BNCSCD, BNNAME, EXP_DET_BILLTO, IMP_DET_DEM_BILLTO, "
						+ "                              BNADD1,BNADD2, BNADD3,BNADD4, BNCOUN,BNAUSR, BNADAT,BNATIM,BNCUSR,BNCDAT,BNCTIM) "
						+ "                     ( SELECT '" + P_O_V_LINE_TEMP + "','" + P_O_V_TRADE_TEMP + "','"
						+ P_O_V_AGENT_TEMP + "','" + bookingNo + "','" + V_FLAG + "','" + V_CUST_CD + "'"
						+ "                               ,CUNAME,'" + v_flag_temp
						+ "','N',CUADD1,CUADD2,CUADD3,CUADD4,CUCOUN" + "                               ,'"
						+ map.get("P_I_V_USER_ID")
						+ "',to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999')"
						+ "                               ,'" + map.get("P_I_V_USER_ID")
						+ "',to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999')"
						+ "                               FROM ITP010 WHERE CUCUST='" + V_CUST_CD + "' AND CURCST='A')";

				//jdbcTemplate.update(INSERT_BKP030);
				stm = connection.createStatement();
				int countQury1 = stm.executeUpdate(INSERT_BKP030);
				stm.close();
			}

			SimpleDateFormat sd = new SimpleDateFormat("DD/MM/YYYY");
			String date = sd.format(new Date());

			String INSERT_ESV_WB_EXTEND = " INSERT INTO ESV_WB_EXTEND (PK_BOOKING_NO,ADDITIONAL_EMAILS,DESIRED_ARRIVAL_DATE, "
					+ "                                     ROUTE_PREFERENCE,CARGO_DESC,EXPECTED_SAILING_DATE, "
					+ "                                     RECORD_STATUS,RECORD_ADD_USER,RECORD_ADD_DATE, "
					+ "                                     RECORD_CHANGE_USER,RECORD_CHANGE_DATE) "
					+ "                                     VALUES('" + bookingNo + "',COALESCE(E'"
					+ map.get("P_I_V_ADD_MAIL_RECIPEINTS") + "',' '),"
					+ ((map.get("P_I_V_DESIRED_ARRIVAL_DATE") == null
							|| "".equals(map.get("P_I_V_DESIRED_ARRIVAL_DATE"))) ? null
									: "TO_DATE('" + map.get("P_I_V_DESIRED_ARRIVAL_DATE") + "','DD/MM/YYYY')")
					+ "                                    ,COALESCE(E'" + map.get("P_I_V_ROUTING_REF")
					+ "',' '),SUBSTRING(E'" + map.get("P_I_V_CARGO_DESCRIPTION") + "',1,500)"
					+ "                                 	 ,TO_DATE("
					+ ((map.get("P_I_V_SAILING_DATE") == null || "".equals(map.get("P_I_V_SAILING_DATE"))) ? null
							: "'" + map.get("P_I_V_SAILING_DATE") + "'")
					+ "									 ,'DD/MM/YYYY'),'A','" + map.get("P_I_V_USER_ID") + "',now(),'"
					+ map.get("P_I_V_USER_ID") + "'" + "                                    ,NOW())";
			//jdbcTemplate.update(INSERT_ESV_WB_EXTEND);
			stm = connection.createStatement();
			int countQury2 = stm.executeUpdate(INSERT_ESV_WB_EXTEND);
			stm.close();
			String INSERT_ROUTE_DTL_BOOKING = "insert into route_dtl_booking (BOOKING_NO,VESSEL_NAME,VESSEL_NO,VOYAGE)"
					+ "					 values('" + bookingNo + "','" + map.get("P_I_V_VESSEL_NAME") + "','"
					+ map.get("P_I_V_VESSEL") + "','" + map.get("P_I_V_VOYAGE") + "')";
			//jdbcTemplate.update(INSERT_ROUTE_DTL_BOOKING);
			stm = connection.createStatement();
			int countQury3 = stm.executeUpdate(INSERT_ROUTE_DTL_BOOKING);
			stm.close();
			
			
			map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		System.out.println("save booking end");
	}

	public class V_C_SandV_CUST_CD implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {

			List list = new ArrayList();
			list.add(rs.getString("CUCORS"));
			list.add(rs.getString("CUCUST"));

			return list;
		}

	}

}
