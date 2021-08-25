package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRR_ERCL_GET_BKG_HDR_INQUIRY extends AncestorJdbcDao{

	
	JdbcTemplate jdbcTemplate;
	Map map;
	EserviceInquiryWebBookingUim form;
	public PRR_ERCL_GET_BKG_HDR_INQUIRY(JdbcTemplate jdbcTemplate,Map map,EserviceInquiryWebBookingUim form) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
		this.form=form;
	}
	public void executeDbProcedure() {
		
		String V_REP_FLAG;
		String V_REP_CODE;
		String V_REP_NAME;
		String countv_cou= "select COUNT(*)   " + 
				"          from BKP030 t  " + 
				"          where BNBKNO = '"+map.get("P_I_V_BKG_NO")+"'  " + 
				"            and BNCSTP = 'O'  " + 
				"            and exists (select 1  " + 
				"                          from BKP030 a  " + 
				"                          where a.BNBKNO = '"+map.get("P_I_V_BKG_NO")+"'  " +  
				"                            and a.BNCSCD = T.BNCSCD  " + 
				"                            and a.BNCSTP = 'B')";
		
		int v_cou=jdbcTemplate.queryForInt(countv_cou);
		
		if(v_cou==0) {
			V_REP_FLAG  = "N";
			V_REP_CODE  = "";
			V_REP_NAME  = "";
		}else {
			V_REP_FLAG = "Y"	;
			String query2="select a.CUCUST, a.CUNAME " + 
					"            from BKP030 T, ITP010 a   " + 
					"            where BNBKNO    = '"+ map.get("P_I_V_BKG_NO") +"'" + 
					"              and BNCSTP    = 'O'   " + 
					"              and a.CUCUST  = t.bncscd";
			List list=jdbcTemplate.query(query2, new Object[] {}, new selctRowMapper());
			V_REP_CODE=((List)list.get(0)).get(0).toString();
			V_REP_NAME=((List)list.get(0)).get(1).toString().replaceAll("'", "\\\\'");
		}
		
		String query="SELECT BABKNO,  " + 
				"                      BAQUNO,  " + 
				"                      BASTAT,  " + 
				"                      BACLBY,  " + 
				"                      BACBPH,  " + 
				"                      CALLER_FAX,  " + 
				"                      CALLER_EMAIL,  " + 
				"                      BAMODE,  " + 
				"                      REFERENCE_NO,  " + 
				"                      (SELECT POINT_NAME FROM POINT_MASTER WHERE POINT_CODE= BAORGN) AS PLR_NAME,  " + 
				"                      (SELECT PINAME FROM ITP040 WHERE PICODE=BAPOL) AS POL_NAME,  " + 
				"                      (SELECT PINAME FROM ITP040 WHERE PICODE=BAPOD) AS POD_NAME,  " + 
				"                      (SELECT POINT_NAME FROM POINT_MASTER WHERE POINT_CODE=BADSTN) AS PLD_NAME,  " + 
				"                      WEB_BOOK_REF,  " + 
				"                      TO_CHAR(TO_DATE(cast(BACADT as VARCHAR), 'YYYYMMDD'), 'DD/MM/YYYY') as BACADT,  " + 
				"                      ADDITIONAL_EMAILS,  " + 
				"                      TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') AS DESIRED_ARRIVAL_DATE,  " + 
				"                      ROUTE_PREFERENCE,  " + 
				"                      CARGO_DESC,  " + 
				"                      BAORGN,  " + 
				"                      BAPOL,  " + 
				"                      BAPOD,  " + 
				"                      BADSTN,  " + 
				"					   TOTERMINAL as TOTERMINAL,"    +
				"					   (SELECT TERMINAL_NAME FROM CAM_TERMINAL_DEPOT ctd  WHERE PK_TERMINAL=TOTERMINAL) as TOTERMINALDEC,"+
				"					   TO_CHAR(TO_DATE(cast(VESSELETD as VARCHAR), 'YYYY-MM-DD'),'DD/MM/YYYY') AS VESSELETD,"	+
				"					   FROMTERMINAL as FROMTERMINAL,"	+
				"					   (SELECT TERMINAL_NAME FROM CAM_TERMINAL_DEPOT ctd  WHERE PK_TERMINAL=FROMTERMINAL) as FROMTERMINALDEC,"+
				"                      (SELECT PICNCD FROM ITP040 WHERE PICODE=BAPOL ) AS ORGN_COUNTRY,  " + 
				"                      (SELECT PICNCD FROM ITP040 WHERE PICODE=BAPOD) AS DSTN_COUNTRY,  " + 
				"                      (SELECT SCNAME FROM ITP040,ITP030 WHERE PICODE=BAPOL AND SCCODE=PICNCD) AS ORGN_COUNTRY_NAME,  " + 
				"                      (SELECT SCNAME FROM ITP040,ITP030 WHERE PICODE=BAPOD AND SCCODE=PICNCD) AS DSTN_COUNTRY_NAME,  " + 
				"                      BALINE,  " + 
				"                      BATRAD,  " + 
				"                      BAAGNT,  " + 
				"                      BABKBY,  " + 
				"                      TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') AS EXPECTED_SAILING_DATE ," + 
				"       			   '"+V_REP_FLAG+"' as REP_FLAG,   " + 
				"                      '"+V_REP_CODE+"' as REP_CODE,   " + 
				"                      E'"+V_REP_NAME+"' as REP_NAME,   " + 
				"                      BABKTP,   " + 
				"                      (CASE when BABKTP='C' then 'Carrier own container (RCL)' else 'Shipper own container' end) as COC_SOC ,        "+
				"						VESSEL_NAME as VESSEL_NAME ,"+
				"						VOYAGE  as VOYAGE  "+
				"			   			,(select port_name from cam_port where pk_port_code=bapot1)  port1	"+
				"			  			,(select port_name from cam_port where pk_port_code=bapot2)  port2	"+
				"			   			,(select port_name from cam_port where pk_port_code=bapot3)  port3	"+
				"                         FROM SEALINER.BKP001 LEFT OUTER JOIN  ESV_WB_EXTEND  " + 
				"                ON BABKNO=PK_BOOKING_NO  " + 
				"											   LEFT OUTER JOIN  route_dtl_booking "+
				"				 ON BABKNO=BOOKING_NO  "+
				"                WHERE BABKNO='"+ map.get("P_I_V_BKG_NO") +"' limit 1";
		
		List<EserviceNewWebBookingUim> list=jdbcTemplate.query(query, new Object[] {}, new BookingHeaderRowMappers(form) );
		Map outPut =new HashMap();
		outPut.put("P_O_V_HDR_DATA", list);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	
		}
	
	public class BookingHeaderRowMappers extends JdbcRowMapper {

		private EserviceInquiryWebBookingUim form;

		public BookingHeaderRowMappers(EserviceInquiryWebBookingUim form) {
			this.form = form;
		}

		public Object mapRow(ResultSet rs, int row) throws SQLException {

			form.setBookingNo(rs.getString("BABKNO"));
			form.setQuotationNumber(rs.getString("BAQUNO"));

			String status = rs.getString("BASTAT");
			if (null != status) {
				if ("O".equals(status)) {
					status = "Open";
				} else if ("C".equals(status)) {
					status = "Confirmed";
				} else if ("W".equals(status)) {
					status = "Waitlisted";
				} else if ("N".equals(status)) {
					status = "Cancelled";
				} else if ("J".equals(status)) {
					status = "Rejected";
				} else if ("L".equals(status)) {
					status = "Closed";
				} else if ("P".equals(status)) {
					status = "Partial";
				}
			}
			form.setStatus(status);

			form.setContact(rs.getString("BACLBY"));
			form.setTelephone(rs.getString("BACBPH"));
			form.setFax(rs.getString("CALLER_FAX"));
			form.setEmail(rs.getString("CALLER_EMAIL"));
			form.setShipmentTerm(rs.getString("BAMODE"));
			form.setPol(rs.getString("BAMODE").substring(0, 2));
			form.setPod(rs.getString("BAMODE").substring(2, 4));
			form.setCustomerReference(rs.getString("REFERENCE_NO"));
			form.setPlaceOfReceipt(rs.getString("PLR_NAME"));
			form.setPortOfLoading(rs.getString("POL_NAME"));
			form.setPortOfDischarge(rs.getString("POD_NAME"));
			form.setPlaceOfDelivery(rs.getString("PLD_NAME"));
			if(rs.getString("WEB_BOOK_REF")==null)
				form.setTemplateName("");
			else
				form.setTemplateName(rs.getString("WEB_BOOK_REF"));
			form.setShipmentDate(rs.getString("BACADT"));
			form.setAdditionalMailRecipeints(rs.getString("ADDITIONAL_EMAILS"));
			form.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
			form.setRoutingPreference(rs.getString("ROUTE_PREFERENCE"));
			form.setCargoDescription(rs.getString("CARGO_DESC"));
			form.setOriginCountry(rs.getString("ORGN_COUNTRY_NAME"));
			form.setDestinationCountry(rs.getString("DSTN_COUNTRY_NAME"));
			form.setSailingDate(rs.getString("EXPECTED_SAILING_DATE"));
			/* Begin @05 */
			form.setRepresentCompChkBox(rs.getString("REP_FLAG"));
			form.setRepresentComp(rs.getString("REP_NAME"));
			/* End @05 */
			form.setSocCocUserFlag(rs.getString("COC_SOC"));// @06
			form.setVessel(rs.getString("VESSEL_NAME"));
			form.setVoyage(rs.getString("VOYAGE"));
			
			form.setFromTerminal(rs.getString("FROMTERMINAL"));
			form.setFromTerminalDes(rs.getString("FROMTERMINALDEC"));
			form.setToTerminal(rs.getString("TOTERMINAL"));
			form.setToTerminalDes(rs.getString("TOTERMINALDEC"));
			form.setVesselEtd(rs.getString("VESSELETD"));
			form.setPort1(rs.getString("port1"));
			form.setPort2(rs.getString("port2"));
			form.setPort3(rs.getString("port3"));
			return null;
		}
	}
	 class selctRowMapper extends JdbcRowMapper{

         public List mapRow(ResultSet rs, int row) throws SQLException{
        	 
        	 List lst=new ArrayList();
        	 lst.add(rs.getString("CUCUST"));
        	 lst.add(rs.getString("CUNAME"));
        	 return lst;
         }
	 }
}
