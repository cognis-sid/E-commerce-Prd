package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ERCL_INS_ESI_SHIPMENT_HDR {

	private JdbcTemplate jdbcTemplate;
	private Map map;

	public PRR_ERCL_INS_ESI_SHIPMENT_HDR(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	public void executeDbProcedure() {
		String insert_esv_si_header;
		if((Integer.valueOf((String)map.get("P_I_V_MODE")) == 1) || (Integer.valueOf((String)map.get("P_I_V_MODE"))==3)) {
		
			 insert_esv_si_header="INSERT INTO ESV_SI_HEADER ( " + 
					"			  	     PK_HDR_SEQNO, " + 
					"					 FK_BOOKING_NO, " + 
					"					 FK_BL_NO, " + 
					"					 BL_ARCHETYPE, " + 
					"					 BL_TYPE, " + 
					"					 ESI_STATUS, " + 
					"					 SUBMIT_BY, " + 
					"					 CONTACT, " + 
					"					 EMAIL, " + 
					"					 ADD_EMAILS, " + 
					"					 PHONE, " + 
					"					 FAX, " + 
					"					 DN_SHIPPER_CODE, " + 
					"					 SHIPPER_NAME, " + 
					"					 SHIPPER_ADD1, " + 
					"					 SHIPPER_ADD2, " + 
					"					 SHIPPER_ADD3, " + 
					"					 SHIPPER_ADD4, " + 
					"					 DN_CNEE_CODE, " + 
					"					 CNEE_NAME, " + 
					"					 CNEE_ADD1, " + 
					"					 CNEE_ADD2, " + 
					"					 CNEE_ADD3, " + 
					"					 CNEE_ADD4, " + 
					"					 DN_NTFY_CODE, " + 
					"					 NTFY_NAME, " + 
					"					 NTFY_ADD1, " + 
					"					 NTFY_ADD2, " + 
					"					 NTFY_ADD3, " + 
					"					 NTFY_ADD4, " + 
					"					 VESSEL_NAME, " + 
					"					 VOYAGE_NO, " + 
					"					 BL_ISSUE_PLACE_NAME, " + 
					"					 POL_NAME, " + 
					"					 POD_NAME, " + 
					"					 PLR_NAME, " + 
					"					 PLD_NAME, " + 
					"					 ORG_BL_COUNT, " + 
					"					 COMM_LVL_MARKS_NO, " + 
					"					 COMM_LVL_DESC, " + 
					"					 REMARKS, " + 
					"				     VESSEL_NO,  " + 
					"				     POL,   " + 
					"					 POD,   " + 
					"					 RECORD_STATUS, " + 
					"					 RECORD_ADD_USER, " + 
					"					 RECORD_ADD_DATE, " + 
					"					 RECORD_CHANGE_USER, " + 
					"					 RECORD_CHANGE_DATE, " + 
					"					 to_terminal,	"+
					"					 from_terminal,	"+
					"					 vesseletd,"+
					"					 quotno)"+
					"					 VALUES( " + 
					"					 		(SELECT max(pk_hdr_seqno)+1 FROM ESV_SI_HEADER), " + 
					"							'"+map.get("P_I_V_BOOKING_NO")+"', " + 
					"							COALESCE ('"+map.get("P_I_V_BL_NO")+"', ' '), " + 
										 		((map.get("P_I_V_BL_ARCHETYPE")==null|| "".equals(map.get("P_I_V_BL_ARCHETYPE")) )?null:"'"+map.get("P_I_V_BL_ARCHETYPE")+"'")+", " + 
					"							'"+map.get("P_I_V_BL_TYPE")+"', " + 
					"							'E',				   			    " + 
					"							'"+map.get("P_I_V_SUBMIT_BY")+"', " + 
					"							'"+map.get("P_I_V_CONTACT")+"', " + 
					"							'"+map.get("P_I_V_EMAIL")+"', " + 
					"							'"+map.get("P_I_V_ADD_EMAILS")+"', " + 
					"							'"+map.get("P_I_V_PHONE")+"', " + 
					"							'"+map.get("P_I_V_FAX")+"', " + 
					"							'"+map.get("P_I_V_DN_SHIPPER_CODE")+"', " + 
					"							COALESCE (E'"+map.get("P_I_V_SHIPPER_NAME")+"', ' '), " + 
					"							COALESCE (E'"+map.get("P_I_V_SHIPPER_ADD1")+"',' '), " + 
					"							E'"+map.get("P_I_V_SHIPPER_ADD2")+"', " + 
					"							E'"+map.get("P_I_V_SHIPPER_ADD3")+"', " + 
					"							E'"+map.get("P_I_V_SHIPPER_ADD4")+"', " + 
					"							COALESCE ('"+map.get("P_I_V_DN_CNEE_CODE")+"', ' '), " + 
					"							COALESCE (E'"+map.get("P_I_V_CNEE_NAME")+"', ' '), " + 
					"							COALESCE (E'"+map.get("P_I_V_CNEE_ADD1")+"', ' '), " + 
					"							E'"+map.get("P_I_V_CNEE_ADD2")+"', " + 
					"							E'"+map.get("P_I_V_CNEE_ADD3")+"', " + 
					"							E'"+map.get("P_I_V_CNEE_ADD4")+"', " + 
					"							COALESCE ('"+map.get("P_I_V_DN_NTFY_CODE")+"', ' '), " + 
					"							COALESCE (E'"+map.get("P_I_V_NTFY_NAME")+"', ' '), " + 
					"							COALESCE (E'"+map.get("P_I_V_NTFY_ADD1")+"', ' '), " + 
					"							E'"+map.get("P_I_V_NTFY_ADD2")+"', " + 
					"							E'"+map.get("P_I_V_NTFY_ADD3")+"', " + 
					"							E'"+map.get("P_I_V_NTFY_ADD4")+"', " + 
					"							'"+map.get("P_I_V_VESSEL")+"', " + 
					"							'"+map.get("P_I_V_VOYAGE")+"', " + 
					"							'"+map.get("P_I_V_BL_ISSUE_PLACE_NAME")+"', " + 
					"							COALESCE ('"+map.get("P_I_V_POL_NAME")+"', ' '), " + 
					"							COALESCE ('"+map.get("P_I_V_POD_NAME")+"',	' '), " + 
					"							COALESCE ('"+map.get("P_I_V_PLR_NAME")+"',	' '), " + 
					"							COALESCE ('"+map.get("P_I_V_PLD_NAME")+"', ' '), " + 
					"							to_number(COALESCE('"+map.get("P_I_V_ORG_BL_COUNT")+"','1'),'9G999g999'), " + 
					"							' ',  " + 
					"							' ',   " + 
					"							E'"+map.get("P_I_V_REMARK")+"', " + 
					"							'"+map.get("P_I_V_VESSEL_NO")+"',   " + 
					"							'"+map.get("P_I_V_POL_NO")+"',   " + 
					"							'"+map.get("P_I_V_POD_NO")+"',   " + 
					"							'A', " + 
					"							'"+map.get("P_I_V_LOGIN_ID")+"', " + 
					"							NOW(), " + 
					"							'"+map.get("P_I_V_LOGIN_ID")+"', " + 
					"							NOW(), " + 
					"							'"+map.get("P_I_V_TO_TERMINAL")+"',"+
					"							'"+map.get("P_I_V_FROM_TERMINAL")+"',"+
					"							TO_DATE('"+map.get("P_I_V_VESSEL_ETD")+"','YYYY-MM-DD'),"+
					"							'"+map.get("P_I_V_QUOTATION")+"')";
			 
			 System.out.println("insert_esv_si_header : "+insert_esv_si_header);
			 
			 jdbcTemplate.update(insert_esv_si_header);
			 
			 String UPDATE_BOOKING_STATUS="update SEALINER.BKP001 set bastat='E' where babkno='"+map.get("P_I_V_BOOKING_NO")+"'";
			 jdbcTemplate.update(UPDATE_BOOKING_STATUS);
		 
		}else if((Integer.valueOf((String)map.get("P_I_V_MODE")) == 2) || (Integer.valueOf((String)map.get("P_I_V_MODE")) == 4)) {
			
			insert_esv_si_header="UPDATE ESV_SI_HEADER SET" + 
					"				 BL_ARCHETYPE = "+((map.get("P_I_V_BL_ARCHETYPE")==null|| "".equals(map.get("P_I_V_BL_ARCHETYPE")) )?null:"'"+map.get("P_I_V_BL_ARCHETYPE")+"'")+"," + 
					"				 BL_TYPE = '"+map.get("P_I_V_BL_TYPE")+"'," + 
					"				 SUBMIT_BY = '"+map.get("P_I_V_SUBMIT_BY")+"'," + 
					"				 CONTACT = '"+map.get("P_I_V_CONTACT")+"'," + 
					"				 EMAIL = '"+map.get("P_I_V_EMAIL")+"'," + 
					"				 ADD_EMAILS = '"+map.get("P_I_V_ADD_EMAILS")+"'," + 
					"				 PHONE = '"+map.get("P_I_V_PHONE")+"'," + 
					"				 FAX = '"+map.get("P_I_V_FAX")+"'," + 
					"				 SHIPPER_NAME = '"+map.get("P_I_V_SHIPPER_NAME")+"'," + 
					"				 SHIPPER_ADD1 = '"+map.get("P_I_V_SHIPPER_ADD1")+"'," + 
					"				 SHIPPER_ADD2 = COALESCE('"+map.get("P_I_V_SHIPPER_ADD2")+"', ' ')," + 
					"				 SHIPPER_ADD3 = COALESCE('"+map.get("P_I_V_SHIPPER_ADD3")+"', ' ')," + 
					"				 SHIPPER_ADD4 = COALESCE('"+map.get("P_I_V_SHIPPER_ADD4")+"', ' ')," + 
					"				 DN_CNEE_CODE = COALESCE('"+map.get("P_I_V_DN_CNEE_CODE")+"', ' ')," + 
					"				 CNEE_NAME = COALESCE('"+map.get("P_I_V_CNEE_NAME")+"', ' ')," + 
					"				 CNEE_ADD1 = COALESCE('"+map.get("P_I_V_CNEE_ADD1")+"', ' ')," + 
					"				 CNEE_ADD2 = COALESCE('"+map.get("P_I_V_CNEE_ADD2")+"', ' ')," + 
					"				 CNEE_ADD3 = COALESCE('"+map.get("P_I_V_CNEE_ADD3")+"', ' ')," + 
					"				 CNEE_ADD4 = COALESCE('"+map.get("P_I_V_CNEE_ADD4")+"', ' ')," + 
					"				 DN_NTFY_CODE = COALESCE('"+map.get("P_I_V_DN_NTFY_CODE")+"', ' ')," + 
					"				 NTFY_NAME = COALESCE('"+map.get("P_I_V_NTFY_NAME")+"', ' ')," + 
					"				 NTFY_ADD1 = COALESCE('"+map.get("P_I_V_NTFY_ADD1")+"', ' ')," + 
					"				 NTFY_ADD2 = COALESCE('"+map.get("P_I_V_NTFY_ADD2")+"', ' ')," + 
					"				 NTFY_ADD3 = COALESCE('"+map.get("P_I_V_NTFY_ADD3")+"', ' ')," + 
					"				 NTFY_ADD4 = COALESCE('"+map.get("P_I_V_NTFY_ADD4")+"', ' ')," + 
					"				 VESSEL_NAME = COALESCE('"+map.get("P_I_V_VESSEL")+"', ' ')," + 
					"				 VESSEL_NO = COALESCE('"+map.get("P_I_V_VESSEL_NO")+"', ' '),  " + 
					"				 VOYAGE_NO = COALESCE('"+map.get("P_I_V_VOYAGE")+"', ' ')," + 
					"				 BL_ISSUE_PLACE_NAME = '"+map.get("P_I_V_BL_ISSUE_PLACE_NAME")+"'," + 
					"				 POL_NAME = COALESCE('"+map.get("P_I_V_POL_NAME")+"', ' ')," + 
					"				 POD_NAME = COALESCE('"+map.get("P_I_V_POD_NAME")+"',	' ')," + 
					"				 POL = COALESCE('"+map.get("P_I_V_POL_NO")+"', ' '),  " + 
					"				 POD = COALESCE('"+map.get("P_I_V_POD_NO")+"',	' '),  " + 
					"				 PLR_NAME = COALESCE('"+map.get("P_I_V_PLR_NAME")+"',	' ')," + 
					"				 PLD_NAME = COALESCE('"+map.get("P_I_V_PLD_NAME")+"',	' ')," + 
					"				 ORG_BL_COUNT = to_number(COALESCE('"+map.get("P_I_V_ORG_BL_COUNT")+"','1'),'9G999g999')," + 
					"				 REMARKS = E'"+map.get("P_I_V_REMARK")+"'," + 
					"				 RECORD_CHANGE_USER = '"+map.get("P_I_V_LOGIN_ID")+"'," + 
					"				 RECORD_CHANGE_DATE = now()," +
					"                to_terminal='"+map.get("P_I_V_TO_TERMINAL")+"',	"+
					"				 from_terminal='"+map.get("P_I_V_FROM_TERMINAL")+"',	"+
					"				 vesseletd=TO_DATE('"+map.get("P_I_V_VESSEL_ETD")+"','YYYY-MM-DD'),"+
					"				 quotno='"+map.get("P_I_V_QUOTATION")+"'"+
					"				 WHERE FK_BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'";
			jdbcTemplate.update(insert_esv_si_header);
		}	
		
			
			
		map.put("P_O_V_ERR_CD", "SUCCESS");
		map.put("P_O_V_ERR_DESC", null);
	}
	
}
