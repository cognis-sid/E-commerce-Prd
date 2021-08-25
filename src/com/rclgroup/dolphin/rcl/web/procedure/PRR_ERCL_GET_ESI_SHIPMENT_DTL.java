package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.action.EservicePropertyFatchOperation;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PicMailMod;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_HDR.MailRowMapper;

public class PRR_ERCL_GET_ESI_SHIPMENT_DTL {
	
	JdbcTemplate jdbcTemplate;
	Map map;
	EshippingInstructionUim form;
	
	public PRR_ERCL_GET_ESI_SHIPMENT_DTL(JdbcTemplate jdbcTemplate,Map map,EshippingInstructionUim form) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
		this.form=form;
	}

	public Map executeDbProcedure() {
		
		String MODE_COUNT="Select Count(*) from ESV_SI_HEADER where FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'"; 
		
		int count=jdbcTemplate.queryForInt(MODE_COUNT);
		
		if(count==0) {
		
		String V_SQL=" SELECT BABKNO              AS BOOKING_NO  " + 
				"                            ,BACLBY             AS CONTACT  " + 
				"                            ,COALESCE(CALLER_EMAIL, (SELECT EMAIL_ID1 FROM SEALINER.SC_PRSN_LOG_INFO WHERE PRSN_LOG_ID='"+map.get("P_I_V_LOGIN_ID")+"' )) AS EMAIL  " + 
				"                            ,BACBPH             AS TELEPHONE  " + 
				"                            ,CALLER_FAX         AS FAX  " + 
				"                            ,'' AS LOGIN_NAME   " + 
				"                            ,''               AS BL_NO  " + 
				"                            ,'NEW'            AS BL_STATUS  " + 
				"                            ,''               AS BL_TYPE  " + 
				"							,ADDITIONAL_EMAILS				AS ADD_EMAILS  " + 
				"							,3					AS NO_ORG_BL  " + 
				"							,''				AS REMARKS  " + 
				"							,babkby			as org_code"+
				"							,'1'				AS BL_ARCHETYPE    " + 
				"              				, 'N' as Status_Code   " +
				"							,BAQUNO as quotetionNo "+
				"                     FROM BKP001 left join ESV_WB_EXTEND on BABKNO=pk_booking_no  " + 
				"                     WHERE BABKNO= '"+map.get("P_I_V_BKG_NO")+"' ";
		
		
		jdbcTemplate.query(V_SQL, new Object[] {}, new ShipmentDetailsRowMappers(form));
		
		}else {
			
			String V_SQL="SELECT FK_BOOKING_NO 	   AS BOOKING_NO  " + 
					"						   	 , CONTACT	 	   AS CONTACT  " + 
					"						   	 , EMAIL		   AS EMAIL  " + 
					"						   	 , esi.PHONE		   AS TELEPHONE  " + 
					"						   	 , esi.FAX		 	   AS FAX  " + 
					"						   	 , SUBMIT_BY 	   AS LOGIN_NAME  " + 
					"                 ,CASE WHEN ESI_STATUS ='I' THEN '' ELSE FK_BL_NO END AS BL_NO   " + 
					"						   	 , CASE WHEN ESI_STATUS ='E' THEN 'Entry' WHEN (ESI_STATUS='S' AND SUBMIT_BY = ' ') THEN 'B/L Created by RCL DOC Team'  " + 
					"                        WHEN ESI_STATUS ='S' THEN 'ESI SUBMITTED' END 	   AS BL_STATUS  " + 
					"						   	 , BL_TYPE	   	   AS BL_TYPE  " + 
					"							 , ADD_EMAILS	   AS ADD_EMAILS  " + 
					"							 , ORG_BL_COUNT	   AS NO_ORG_BL  " + 
					"							 , REMARKS		   AS REMARKS  " + 
					"							 , BL_ARCHETYPE	   AS BL_ARCHETYPE  " + 
					"							 , eul.org_code         AS org_code"+
					"               , ESI_STATUS as Status_Code    " + 
					"				,quotno as quotetionNo"+
					"					  FROM  ESV_SI_HEADER esi,esm_user_login eul" + 
					"					  WHERE FK_BOOKING_NO ='"+map.get("P_I_V_BKG_NO")+"' and eul.user_id='"+map.get("P_I_V_LOGIN_ID")+"'";
			jdbcTemplate.query(V_SQL, new Object[] {}, new ShipmentDetailsRowMappers(form));
		}
		return null;
	}
	 public class ShipmentDetailsRowMappers extends JdbcRowMapper{

	        private EshippingInstructionUim form;
	        private String picuser ="";
	        /**
	         * 
	         * This constructor for set obj to global variable.
	         * 
	         * @param form Object's Eshipping Instruction Form
	         */
	        public ShipmentDetailsRowMappers(EshippingInstructionUim form){
	            this.form = form;
	        }

	        /**
	         * 
	         * This mothod for set data to shipment detail in each row.
	         * 
	         * @exception SQLException
	         * @param rs List of shipment detail
	         * @param row Row of shipment detail
	         */
	        public Object mapRow(ResultSet rs, int row) throws SQLException{
	            form.setBookingNo(rs.getString("BOOKING_NO"));
	            form.setContact(rs.getString("CONTACT"));
	            form.setEmail(rs.getString("EMAIL"));
	            form.setTelephone(rs.getString("TELEPHONE"));
	            form.setFax(rs.getString("FAX"));
	            form.setSiSubmittedBy(rs.getString("LOGIN_NAME"));
	            form.setBlNumber(rs.getString("BL_NO"));
	            form.setBlType(rs.getString("BL_TYPE"));
	            form.setAdditionalEmail(rs.getString("ADD_EMAILS"));
	            form.setNoOfOriginal(rs.getString("NO_ORG_BL"));
	            form.setRemarks(rs.getString("REMARKS"));
	            form.setChoiceRad(rs.getString("BL_ARCHETYPE"));
	            //            @12 BEGIN
	            //            form.setStatus(rs.getString(8));
	            form.setEsiStatusDesc(rs.getString("BL_STATUS"));
	            form.setEsiStatusCode(rs.getString("Status_Code"));
	            form.setQuotation(rs.getString("quotetionNo"));
	            //            @12 END
	            //            System.out.println("form setChoiceRad >>>>>>>>>>>>>>>>>>> "+form.getChoiceRad());
	            return null;
	        }
	    }
}
