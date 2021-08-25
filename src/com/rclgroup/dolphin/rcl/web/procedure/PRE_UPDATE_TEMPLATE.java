package com.rclgroup.dolphin.rcl.web.procedure;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_UPDATE_TEMPLATE {
	
	private JdbcTemplate jdbcTemplate;
	private Map map;
	private SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
	
	public PRE_UPDATE_TEMPLATE(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	public void executeDbProcedure() {
		String V_POL_FSC;
		String  V_CNT;
		String P_I_V_SAILING_DATE="";
		String Booking_Type_Falg="";
		try {
			if(!map.get("P_I_V_SAILING_DATE").equals("")) {
			 P_I_V_SAILING_DATE = (String)map.get("P_I_V_SAILING_DATE");
			}else {
				P_I_V_SAILING_DATE =null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!map.get("CHANGES_TYPE").toString().equalsIgnoreCase("T")) {
			Booking_Type_Falg="N";
		}else {
			Booking_Type_Falg="TB";
		}
		String v_pol_fsc_query=" SELECT PIOFFC  " + 
				"   FROM SEALINER.ITP040 " + 
				"   WHERE ( PICODE='"+map.get("P_I_V_PORT_OF_LOADING")+"' OR picncd='"+map.get("P_I_V_PORT_OF_LOADING")+"' )" + 
				"   AND PIRCST='A'";
		V_POL_FSC=(String)jdbcTemplate.queryForObject(v_pol_fsc_query, String.class);
		
		String query1=" UPDATE SEALINER.BKP001 SET  " + 
				"                     BAQUNO = '"+map.get("P_I_V_QUOTATION_NUMBER")+"',  " + 
				"                     BACLBY = '"+map.get("P_I_V_CONTACT")+"',  " + 
				"					  BASTAT = 'O',"+	
				"                     SPLSTATS = '',"+
				"                     BACBPH = '"+map.get("P_I_V_TELEPHONE")+"',  " + 
				"                     CALLER_FAX = '"+map.get("P_I_V_FAX")+"',  " + 
				"                     CALLER_EMAIL = '"+map.get("P_I_V_EMAIL")+"',  " + 
				"                     BAMODE = '"+map.get("P_I_V_SHIPMENT_TERM")+"',  " + 
				"                     REFERENCE_NO = '"+map.get("P_I_V_CUSTOMER_REF")+"',  " + 
				"                     BAORGN  = COALESCE('"+map.get("P_I_V_PLACE_OF_RECEIPT")+"','"+map.get("P_I_V_PORT_OF_LOADING")+"'),  " + 
				"                     BAPOL = '"+map.get("P_I_V_PORT_OF_LOADING")+"',  " + 
				"                     BAPOD = '"+map.get("P_I_V_PORT_OF_DISCHARGE")+"', " + 
				"                     BADSTN = COALESCE('"+map.get("P_I_V_PLACE_OF_DELIVERY")+"','"+map.get("P_I_V_PORT_OF_DISCHARGE")+"'),  " + 
				"                     BAOFFC = '"+V_POL_FSC+"' ,  " + 
				"                     BABLOF = '"+V_POL_FSC+"',  " + 
				"                     BACADT = TO_NUMBER(TO_CHAR(TO_DATE('" + map.get("P_I_V_SHIPMENT_DATE")+"', 'DD/MM/YYYY'), 'YYYYMMDD'),'9G999g9999') , " +    
				"                     BACUSR = '"+map.get("P_I_V_USER_ID").toString().trim()+"',  " + 
				"                     BACDAT = to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),  " + 
				"                     BACTIM = to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999'),  " + 
				"					  BOOKING_TYPE = '"+Booking_Type_Falg+"'	"+
				"  WHERE BABKNO='"+map.get("P_I_V_BOOKING_NO")+"'  " + 
				"        AND (BOOKING_TYPE='TB'  " + 
				"        or BASTAT='C')";
		
		System.out.println("PRE_UPDATE_TEMPLATE "+query1);
		jdbcTemplate.update(query1);
		
		String query2="UPDATE ESV_WB_EXTEND SET " + 
				  
				"                                             DESIRED_ARRIVAL_DATE =TO_DATE('"+ map.get("P_I_V_DESIRED_ARRIVAL_DATE")+"','DD-MM-YYYY'),  " +
				"                                             ROUTE_PREFERENCE = E'"+map.get("P_I_V_ROUTING_REF")+"',  " + 
				"                                             CARGO_DESC  =E'"+map.get("P_I_V_CARGO_DESCRIPTION")+"',  " + 
				"                                             EXPECTED_SAILING_DATE = TO_DATE('"+map.get("P_I_V_SAILING_DATE")+"','DD-MM-YYYY'),  " + 
				"                                             RECORD_CHANGE_USER ='"+ map.get("P_I_V_USER_ID")+"',  " +
				"                                             RECORD_CHANGE_DATE =  now()  " + 
				"       WHERE PK_BOOKING_NO='"+map.get("P_I_V_BOOKING_NO")+"'";
		
		
		System.out.println("PRE_UPDATE_TEMPLATE "+query2);
		jdbcTemplate.update(query2);
		
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
}
