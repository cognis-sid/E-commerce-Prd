package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;

public class PRR_ERCL_GET_ESI_ACK_POPUP {

	JdbcTemplate jdbcTemplate;
	Map map;
	EshippingInstructionUim form;
	public PRR_ERCL_GET_ESI_ACK_POPUP(JdbcTemplate jdbcTemplate,Map map,EshippingInstructionUim form) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
		this.form=form;
	}
	public void executeDbProcedure() {
		
		String V_SQL="SELECT email as EMAIL  " + 
				"	   		  	 	, phone as PHONE  " + 
				"	   				, fax as FAX  " + 
				"				  FROM ESV_SI_HEADER  " + 
				"				  WHERE FK_BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'";
		List<EshippingInstructionUim> list=jdbcTemplate.query(V_SQL, new Object[] {}, new AcknowledgementDetailsRowMapper(form));
	    map.put("P_O_V_DTL_DATA", list);
	}
	
	 public class AcknowledgementDetailsRowMapper extends JdbcRowMapper{

	        private EshippingInstructionUim form;

	        /**
	         * 
	         * This constructor for set obj to global variable.
	         * 
	         * @param form Object's Eshipping Instruction Form
	         */
	        public AcknowledgementDetailsRowMapper(EshippingInstructionUim form){
	            this.form = form;
	        }

	        /**
	         * 
	         * This mothod for set data to acknowledgement data in each row.
	         * 
	         * @exception SQLException
	         * @param rs List of acknowledgement data
	         * @param row Row of acknowledgement data
	         */
	        public Object mapRow(ResultSet rs, int row) throws SQLException{
	            form.setVendorEmail(rs.getString(1));
	            form.setVendorTelephone(rs.getString(2));
	            form.setVendorFax(rs.getString(3));
	            return null;
	        }
	    }
}
