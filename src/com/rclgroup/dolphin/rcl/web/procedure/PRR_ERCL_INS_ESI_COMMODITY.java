package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ERCL_INS_ESI_COMMODITY {

	private JdbcTemplate jdbcTemplate;
	private Map map;
	private Connection connection;
	
	public PRR_ERCL_INS_ESI_COMMODITY(JdbcTemplate jdbcTemplate, Map map) throws SQLException {
		this.jdbcTemplate = jdbcTemplate;
		this.connection = jdbcTemplate.getDataSource().getConnection();
		this.map = map;
	}

	public void executeDbProcedure() {
		int V_HDR_SEQNO=0;
		String V_DN_COMMODITY_GROUP="";
		Statement stm = null;
		ResultSet rs = null;
		int rsResult=0;
		try {
		if((Integer.valueOf((String)map.get("P_I_V_MODE")) == 1)) {
			
			String V_HDR_SEQNO_QUERY="SELECT PK_HDR_SEQNO  " + 
					"		  FROM  ESV_SI_HEADER  " + 
					"		  WHERE FK_BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'";
			//V_HDR_SEQNO=(int) jdbcTemplate.queryForObject(V_HDR_SEQNO_QUERY, Integer.class);
			
			stm = connection.createStatement();
			rs = stm.executeQuery(V_HDR_SEQNO_QUERY);
			if(rs.next()) {
				V_HDR_SEQNO=rs.getInt(1);
			}
			stm.close();
			rs.close();
			
			String commodity_Count="SELECT count(*)   " + 
					"			  FROM ITP080 CM,  ESV_SI_HEADER HDR, Commodity_Group CG   " + 
					"			  WHERE HDR.FK_BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'   " + 
					"			  		AND CG.COMMODITY_GROUP_CODE = CM.COMMODITY_GROUP_CODE   " + 
					"					AND CM.FCCODE = '"+map.get("P_I_V_DN_COMMODITY")+"'";
			//int count=jdbcTemplate.queryForInt(commodity_Count);
			int count=0;
			stm = connection.createStatement();
			rs = stm.executeQuery(commodity_Count);
			if(rs.next()) {
				count=rs.getInt(1);
			}
			stm.close();
			rs.close();
			
			if(count>0) {
				String commodity_query="SELECT CM.COMMODITY_GROUP_CODE   " + 
						"			  FROM ITP080 CM,  ESV_SI_HEADER HDR, Commodity_Group CG   " + 
						"			  WHERE HDR.FK_BOOKING_NO ='"+map.get("P_I_V_BOOKING_NO")+"'   " + 
						"			  		AND CG.COMMODITY_GROUP_CODE = CM.COMMODITY_GROUP_CODE   " + 
						"					AND CM.FCCODE =  '"+map.get("P_I_V_DN_COMMODITY")+"'";
				
				//V_DN_COMMODITY_GROUP=(String) jdbcTemplate.queryForObject(commodity_query, String.class);
				
				stm = connection.createStatement();
				rs = stm.executeQuery(commodity_query);
				if(rs.next()) {
					V_DN_COMMODITY_GROUP=rs.getString(1);
				}
				stm.close();
				rs.close();
				
			}else {
				V_DN_COMMODITY_GROUP="";
			}
			
			String insrt_query=" INSERT INTO ESV_SI_COMMODITY (   " + 
					"				PK_SEQNO   " + 
					"				,FK_HDR_SEQNO   " + 
					"				,DN_COMMODITY_GROUP   " + 
					"				,DN_COMMODITY_CODE   " + 
					"				,WEIGHT     " + 
					"				,RECORD_STATUS   " + 
					"				,RECORD_ADD_USER   " + 
					"				,RECORD_ADD_DATE   " + 
					"				,RECORD_CHANGE_USER   " + 
					"				,RECORD_CHANGE_DATE   " + 
					"				,TOT_NO_OF_PACKAGE     " + 
					"				,TOT_PACKAGE_KIND     " + 
					"				,TOT_MEASUREMENT     " + 
					"				,COMM_LVL_MARKS_NO     " + 
					"				,COMM_LVL_DESC     " + 
					"				,RATE_TYPE)   " + 
					"				VALUES(   " + 
					"					     (select count(*)+1 from ESV_SI_COMMODITY)	      " + 
					"						,"+V_HDR_SEQNO +
					"						,'"+V_DN_COMMODITY_GROUP+"'"+				 		    
					"						,'"+map.get("P_I_V_DN_COMMODITY")+"'"+			 			  
					"	            		,TO_NUMBER('"+map.get("P_I_V_WEIGHT")+"','9G999g999999.999') 					    " + 
					"						,'A'							   			     " + 
					"						,COALESCE('"+map.get("P_I_V_LOGIN_ID")+"','ESI')		 			     " + 
					"						,now()   " + 
					"						,COALESCE('"+map.get("P_I_V_LOGIN_ID")+"','ESI')   " + 
					"						,now()   " + 
					"						,TO_NUMBER('"+map.get("P_I_V_TOT_PACKAGE")+"','9G999g999')     " + 
					"						,'"+map.get("P_I_V_TOT_PACKAGE_KIND")+"'     " + 
					"						,TO_NUMBER('"+map.get("P_I_V_TOT_MEASUREMENT")+"','9G999g999999.999')   " + 
					"						,COALESCE(E'"+map.get("P_I_V_COMM_LVL_MARKS_NO")+"', ' ')    " + 
					"						,COALESCE(E'"+map.get("P_I_V_COMM_LVL_DESC")+"', ' ')     " + 
					"						,"+((map.get("P_I_V_RATE_TYPE")==null|| "".equals(map.get("P_I_V_RATE_TYPE")) )?null:map.get("P_I_V_RATE_TYPE"))+") ";
			//jdbcTemplate.update(insrt_query);
			
			System.out.println("insrt_query commodity : "+insrt_query);
			
			stm = connection.createStatement();
			rsResult=stm.executeUpdate(insrt_query);
			stm.close();
			
		}else if((Integer.valueOf((String)map.get("P_I_V_MODE")) == 2)) {
			
			String commodity_Count="SELECT count(*)   " + 
					"			  FROM ITP080 CM,  ESV_SI_HEADER HDR, Commodity_Group CG   " + 
					"			  WHERE HDR.FK_BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'   " + 
					"			  		AND CG.COMMODITY_GROUP_CODE = CM.COMMODITY_GROUP_CODE   " + 
					"					AND CM.FCCODE = '"+map.get("P_I_V_DN_COMMODITY")+"'";
			//int count=jdbcTemplate.queryForInt(commodity_Count);
			int count=0;
			stm = connection.createStatement();
			rs = stm.executeQuery(commodity_Count);
			if(rs.next()) {
				count=rs.getInt(1);
			}
			stm.close();
			rs.close();
			
			if(count>0) {
				String commodity_query="SELECT CM.COMMODITY_GROUP_CODE   " + 
						"			  FROM ITP080 CM,  ESV_SI_HEADER HDR, Commodity_Group CG   " + 
						"			  WHERE HDR.FK_BOOKING_NO ='"+map.get("P_I_V_BOOKING_NO")+"'   " + 
						"			  		AND CG.COMMODITY_GROUP_CODE = CM.COMMODITY_GROUP_CODE   " + 
						"					AND CM.FCCODE =  '"+map.get("P_I_V_DN_COMMODITY")+"'";
				//V_DN_COMMODITY_GROUP=(String) jdbcTemplate.queryForObject(commodity_query, String.class);
				
				stm = connection.createStatement();
				rs = stm.executeQuery(commodity_query);
				if(rs.next()) {
					V_DN_COMMODITY_GROUP=rs.getString(1);
				}
				stm.close();
				rs.close();
				
			}else {
				V_DN_COMMODITY_GROUP="";
			}
				
				String update_query="UPDATE  ESV_SI_COMMODITY SET   " + 
						"			 		DN_COMMODITY_GROUP = '"+V_DN_COMMODITY_GROUP+"'"+
						"					,DN_COMMODITY_CODE = '"+map.get("P_I_V_DN_COMMODITY")+"'   " + 
						"          ,WEIGHT = TO_NUMBER('"+map.get("P_I_V_WEIGHT")+"','9G999g999999.999')   " + 
						"				 	,RECORD_CHANGE_USER = COALESCE('"+map.get("P_I_V_LOGIN_ID")+"','ESI')   " + 
						"					,RECORD_CHANGE_DATE = now()   " + 
						"          ,TOT_NO_OF_PACKAGE = TO_NUMBER('"+map.get("P_I_V_TOT_PACKAGE")+"','9G999g999')     " + 
						"          ,TOT_PACKAGE_KIND = '"+map.get("P_I_V_TOT_PACKAGE_KIND")+"'      " + 
						"          ,TOT_MEASUREMENT = TO_NUMBER('"+map.get("P_I_V_TOT_MEASUREMENT")+"','9G999g999999.999')     " + 
						"				  ,COMM_LVL_MARKS_NO = COALESCE(E'"+map.get("P_I_V_COMM_LVL_MARKS_NO")+"', ' ')     " + 
						"				  ,COMM_LVL_DESC = COALESCE(E'"+map.get("P_I_V_COMM_LVL_DESC")+"', ' ')     " + 
						"					WHERE PK_SEQNO = "+map.get("P_I_V_PK_SEQNO");
				//jdbcTemplate.update(update_query);
				
				stm = connection.createStatement();
				rsResult=stm.executeUpdate(update_query);
				stm.close();
				
			}else {
				
				String delete_query="DELETE FROM VASAPPS.ESV_SI_COMMODITY  " + 
						"			 WHERE PK_SEQNO = "+map.get("P_I_V_PK_SEQNO") ;
				jdbcTemplate.update(delete_query);
				
				stm = connection.createStatement();
				rsResult=stm.executeUpdate(delete_query);
				stm.close();
				
			}
		}catch (Exception e) {
			e.printStackTrace();
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

