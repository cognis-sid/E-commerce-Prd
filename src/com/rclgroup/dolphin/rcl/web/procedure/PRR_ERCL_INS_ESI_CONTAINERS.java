package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ERCL_INS_ESI_CONTAINERS {
	private JdbcTemplate jdbcTemplate;
	private Connection connection;
	private Map map;

	public PRR_ERCL_INS_ESI_CONTAINERS(JdbcTemplate jdbcTemplate, Map map) throws SQLException {
		this.jdbcTemplate = jdbcTemplate;
		this.connection = jdbcTemplate.getDataSource().getConnection();
		this.map = map;
	}

	public void executeDbProcedure() throws Exception {
		int V_HDR_SEQNO = 0;
		int V_EQP_SEQNO = 0;
		int V_FK_BKG_EQUIPM_DTL = 0;
		int V_FK_BKG_SUPPLIER = 0;
		int V_FK_BKG_SIZE_TYPE_DTL = 0;
		String V_CNTR_MATCH_FLAG = "N";
		int V_PK_DTL_SEQNO = 0;
		Statement stm = null;
		ResultSet rs = null;
		int rsResult=0;
		try {
			if ((Integer.valueOf((String) map.get("P_I_V_MODE")) == 1)) {

				String V_HDR_SEQNO_QUERY = "SELECT PK_HDR_SEQNO  " + "		  FROM  ESV_SI_HEADER  "
						+ "		  WHERE FK_BOOKING_NO = '" + map.get("P_I_V_BOOKING_NO") + "'";
				// V_HDR_SEQNO=(int) jdbcTemplate.queryForObject(V_HDR_SEQNO_QUERY,
				// Integer.class );

				stm = connection.createStatement();
				rs = stm.executeQuery(V_HDR_SEQNO_QUERY);
				if(rs.next()) {
					V_HDR_SEQNO=rs.getInt(1);
				}
				stm.close();
				rs.close();
				
				String V_EQP_SEQNO_QUERY = "SELECT COALESCE(max(BL_EQP_SEQNO) + 1,1)   "
						+ "		  FROM  ESV_SI_CONTAINERS   " + "		  WHERE FK_HDR_SEQNO = " + V_HDR_SEQNO;
				//V_EQP_SEQNO = (int) jdbcTemplate.queryForObject(V_EQP_SEQNO_QUERY, Integer.class);
				stm = connection.createStatement();
				rs = stm.executeQuery(V_EQP_SEQNO_QUERY);

				if(rs.next()) {
					V_EQP_SEQNO=rs.getInt(1);
				}
				stm.close();
				rs.close();
				
				String V_PK_DTL_SEQNO_QUERY = "SELECT count(*)+1 from ESV_SI_CONTAINERS";
			//	V_PK_DTL_SEQNO = jdbcTemplate.queryForInt(V_PK_DTL_SEQNO_QUERY);
				
				stm = connection.createStatement();
				rs = stm.executeQuery(V_PK_DTL_SEQNO_QUERY);

				if(rs.next()) {
					V_PK_DTL_SEQNO=rs.getInt(1);
				}
				stm.close();
				rs.close();
				
				map.put("P_O_V_PK_DTL_SEQNO", V_PK_DTL_SEQNO);

				String INSERT_QUERY = " INSERT INTO ESV_SI_CONTAINERS (  " + "				PK_DTL_SEQNO  "
						+ "				,FK_HDR_SEQNO  " + "				,SCREEN_SEQNO  "
						+ "				,BL_EQP_SEQNO  " + "				,DN_EQUIPMENT_NO  "
						+ "				,FK_BKG_SIZE_TYPE_DTL  " + "				,FK_BKG_SUPPLIER  "
						+ "				,FK_BKG_EQUIPM_DTL  " + "				,EQUPMENT_NO_SOURCE  "
						+ "				,FK_COMMODITY_SEQNO  " + "				,LADEN_MT  "
						+ "				,DN_EQ_SIZE  " + "				,DN_EQ_TYPE  "
						+ "				,GROSS_CARGO_WEIGHT  " + "				,GROSS_CARGO_MSMT  "
						+ "				,CARRIER_SEAL  " + "				,SHIPPER_SEAL  "
						+ "				,NO_OF_PACKAGES  " + "				,DN_PACKAGE_KIND_CODE  "
						+ "				,CNTR_MATCHED  " + "				,RECORD_STATUS  "
						+ "				,RECORD_ADD_USER  " + "				,RECORD_ADD_DATE  "
						+ "				,RECORD_CHANGE_USER  " + "				,RECORD_CHANGE_DATE)  "
						+ "				VALUES(  " + V_PK_DTL_SEQNO + "						," + V_HDR_SEQNO
						+ "						," + map.get("P_I_V_SCREEN_SEQNO") + "						,"
						+ V_EQP_SEQNO + "						,COALESCE('" + map.get("P_I_V_DN_EQUIPMENT_NO")
						+ "', ' ')  			     " + "						,'"
						+ map.get("P_I_V_FK_BKG_SIZE_TYPE_DTL") + "'			 		    "
						+ "						,'" + map.get("P_I_V_FK_BKG_SUPPLIER") + "'				 		     "
						+ "						,'" + map.get("P_I_V_FK_BKG_EQUIPM_DTL") + "'			 		     "
						+ "						,'" + map.get("P_I_V_EQUPMENT_NO_SOURCE") + "'		 			     "
						+ "						,COALESCE("
						+ ((map.get("P_I_V_DN_COMMODITY_CODE") == null
								|| "".equals(map.get("P_I_V_DN_COMMODITY_CODE"))) ? null
										: "'"+map.get("P_I_V_DN_COMMODITY_CODE")+"'")
						+ ", '1')			     " + "						,'" + map.get("P_I_V_LADEN_MT")
						+ "'					 			     " + "						,"
						+ map.get("P_I_V_DN_EQ_SIZE") + "						,CASE WHEN "
						+ map.get("P_I_V_DN_EQ_SIZE") + " = 0 then '' ELSE '" + map.get("P_I_V_DN_EQ_TYPE")
						+ "' END				 			    " + "						,COALESCE(to_number('"
						+ map.get("P_I_V_GROSS_CARGO_WEIGHT") + "','9G999g9999.999'), 0)		 	     "
						+ "						,COALESCE(to_number('" + map.get("P_I_V_GROSS_CARGO_MSMT")
						+ "','9G999g9999.999'), 0)			 	    " + "						,COALESCE('"
						+ map.get("P_I_V_CARRIER_SEAL") + "', ' ')				    "
						+ "						,COALESCE('" + map.get("P_I_V_SHIPPER_SEAL")
						+ "', ' ')				     " + "						,COALESCE('"
						+ map.get("P_I_V_NO_OF_PACKAGES") + "', 0)			 	     "
						+ "						,COALESCE('" + map.get("P_I_V_DN_PACKAGE_KIND_CODE")
						+ "', ' ')		     " + "						,'" + V_CNTR_MATCH_FLAG + "'"
						+ "						,'A'							   			    "
						+ "						,'" + map.get("P_I_V_LOGIN_ID")
						+ "'					 			     " + "						,now()  "
						+ "						,'" + map.get("P_I_V_LOGIN_ID") + "'  "
						+ "						,now())";
				System.out.println("INSERT_QUERY container : "+INSERT_QUERY);
				//jdbcTemplate.update(INSERT_QUERY);
				stm = connection.createStatement();
				rsResult=stm.executeUpdate(INSERT_QUERY);
				stm.close();
				
			} else if ((Integer.valueOf((String) map.get("P_I_V_MODE")) == 2)) {

				String update_query = "UPDATE  ESV_SI_CONTAINERS SET " + "			 		SCREEN_SEQNO ="
						+ map.get("P_I_V_SCREEN_SEQNO") + "					,DN_EQUIPMENT_NO ='"
						+ map.get("P_I_V_DN_EQUIPMENT_NO") + "'" + "					,FK_COMMODITY_SEQNO = COALESCE("
						+ ((map.get("P_I_V_DN_COMMODITY_CODE") == null
								|| "".equals(map.get("P_I_V_DN_COMMODITY_CODE"))) ? null
										:"'"+map.get("P_I_V_DN_COMMODITY_CODE")+"'")
						+ ", '1') " + "					,LADEN_MT = '" + map.get("P_I_V_LADEN_MT") + "'"
						+ "					,DN_EQ_SIZE =" + map.get("P_I_V_DN_EQ_SIZE")
						+ "					,DN_EQ_TYPE = '" + map.get("P_I_V_DN_EQ_TYPE") + "' "
						+ "					,GROSS_CARGO_WEIGHT = to_number('" + map.get("P_I_V_GROSS_CARGO_WEIGHT")
						+ "','9G999g9999.999') " + "					,GROSS_CARGO_MSMT = to_number('"
						+ map.get("P_I_V_GROSS_CARGO_MSMT") + "','9G999g9999.999') " + "					,CARRIER_SEAL ='"
						+ map.get("P_I_V_CARRIER_SEAL") + "' " + "					,SHIPPER_SEAL = '"
						+ map.get("P_I_V_SHIPPER_SEAL") + "' " + "					,NO_OF_PACKAGES = '"
						+ map.get("P_I_V_NO_OF_PACKAGES") + "' " + "					,DN_PACKAGE_KIND_CODE = '"
						+ map.get("P_I_V_DN_PACKAGE_KIND_CODE") + "' " + "					,CNTR_MATCHED = 'N'	    "
						+ "				 	,RECORD_CHANGE_USER = '" + map.get("P_I_V_LOGIN_ID") + "' "
						+ "					,RECORD_CHANGE_DATE = now() " + "					WHERE PK_DTL_SEQNO = "
						+ map.get("P_I_V_PK_DTL_SEQNO");

				//jdbcTemplate.update(update_query);
				
				stm = connection.createStatement();
				rsResult=stm.executeUpdate(update_query);
				stm.close();
				
			} else {
				String delete_query = "DELETE FROM VASAPPS.ESV_SI_CONTAINERS " + "			 WHERE PK_DTL_SEQNO = "
						+ map.get("P_I_V_PK_DTL_SEQNO") + "";
				//jdbcTemplate.update(delete_query);
				
				stm = connection.createStatement();
				rsResult=stm.executeUpdate(delete_query);
				stm.close();
				
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
		map.put("P_O_V_ERR_CD", "SUCCESS");
		map.put("P_O_V_ERR_DESC", null);

	}
}
