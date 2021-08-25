package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRoutingDetailsMod;

public class PRR_ERCL_GET_BKG_ROUTING {

	JdbcTemplate jdbcTemplate;
	Map map;
	 
	public PRR_ERCL_GET_BKG_ROUTING(JdbcTemplate jdbcTemplate,Map map ) {
		
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
		 
	}
	public Map executeDbProcedure() {
		String V_SQL=" SELECT Voyage_Seqno  " + 
				"			   , LOAD_PORT  " + 
				"			   , (SELECT PINAME || ', ' || SCCODE FROM ITP040, ITP030 WHERE PICODE = LOAD_PORT AND PICNCD = SCCODE) AS LOAD_PORT_NAME  " + 
				"			   , DISCHARGE_PORT  " + 
				"			   , COALESCE ((SELECT PINAME || ', ' || SCCODE FROM ITP040, ITP030 WHERE PICODE = DISCHARGE_PORT AND PICNCD = SCCODE),  " + 
				"			   	     (SELECT POINT_NAME || ', ' || SCCODE FROM POINT_MASTER, ITP030 WHERE POINT_CODE = DISCHARGE_PORT AND COUNTRY_CODE = SCCODE)) AS DISCHARGE_PORT_NAME  " + 
				"			   , (SELECT TQTRNM FROM ITP130 WHERE TQTERM = TO_TERMINAL ) AS TO_TERMINAL_NAME  " + 
				"			   , to_char(TO_DATE(cast(SAILING_DATE as VARCHAR )  ,'YYYYMMDD'),'DD/MM/YYYY') AS SAILING_DATE  " + 
				"			   , to_char(TO_DATE(cast(ARRIVAL_DATE as  VARCHAR ),'YYYYMMDD'),'DD/MM/YYYY') AS ARRIVAL_DATE  " + 
				"			   , ROUTING_DAYS||' days' AS TRANSIT_TIME  " + 
				"			   , SERVICE  " + 
				"			   , (SELECT VESSEL||'-'||VSLGNM FROM ITP060 WHERE VSVESS = VESSEL) AS VESSEL_NAME  " + 
				"			   , VOYNO  " + 
				"			   , FROM_TERMINAL  " + 
				"			   , (SELECT TQTRNM FROM ITP130 WHERE TQTERM = FROM_TERMINAL ) AS FROM_TERMINAL_NAME  " + 
				"			   , TO_TERMINAL  " +
				"			   FROM Booking_Voyage_Routing_Dtl r   " + 
				"			   WHERE Booking_No = '"+map.get("P_I_V_BKG_NO")+"'" + 
				"			   ORDER BY Voyage_Seqno";
		
		List<EserviceRoutingDetailsMod> list=jdbcTemplate.query(V_SQL, new Object[] {}, new RoutingDetailsRowMappers());
		
		Map outPut=new HashMap();
		outPut.put("P_O_V_DTL_DATA", list);
		return outPut;
	}
	public class RoutingDetailsRowMappers extends JdbcRowMapper {

		public EserviceRoutingDetailsMod mapRow(ResultSet rs, int row) throws SQLException {

			EserviceRoutingDetailsMod rdm = new EserviceRoutingDetailsMod();
			rdm.setSeqNo(rs.getInt(1));
			rdm.setFrom(rs.getString(3));
			rdm.setTo(rs.getString(5));
			rdm.setLoadingTerminalName(rs.getString(7));
			rdm.setDischargingTerminalName(rs.getString(9));
			rdm.setEtd(rs.getString(10));
			rdm.setEta(rs.getString(11));
			rdm.setTransitTime(rs.getString(12));
			rdm.setService(rs.getString(13));
			rdm.setVessel(rs.getString(14));
			rdm.setVoyage(rs.getString(15));

			return rdm;
		}
	}
}
