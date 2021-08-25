package com.rclgroup.dolphin.rcl.web.procedure.edit.booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PicMailMod;

public class PRR_ERCL_GET_BKG_HDR_EDIT extends AncestorJdbcDao {

	private JdbcTemplate jdbcTemplate;
	private Map map;
	private EserviceNewWebBookingUim form;

	public PRR_ERCL_GET_BKG_HDR_EDIT(JdbcTemplate jdbcTemplate, Map map, EserviceNewWebBookingUim form) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
		this.form = form;
	}

	public void executeDbProcedure() {

		String V_REP_FLAG;
		String V_REP_CODE;
		String V_REP_NAME;
		String countv_cou = "select COUNT(*)   " + "          from BKP030 t  " + "          where BNBKNO = '"
				+ map.get("P_I_V_BKG_NO") + "'  " + "            and BNCSTP = 'O'  "
				+ "            and exists (select 1  " + "                          from BKP030 a  "
				+ "                          where a.BNBKNO = '" + map.get("P_I_V_BKG_NO") + "'  "
				+ "                            and a.BNCSCD = T.BNCSCD  "
				+ "                            and a.BNCSTP = 'B')";

		int v_cou = jdbcTemplate.queryForInt(countv_cou);

		if (v_cou == 0) {
			V_REP_FLAG = "N";
			V_REP_CODE = "";
			V_REP_NAME = "";
		} else {
			String query2 = "select a.CUCUST, a.CUNAME " + "            from SEALINER.BKP001 T, ITP010 a   "
					+ "            where babkno    = '" + map.get("P_I_V_BKG_NO") + "'"
					+ "      " + "              and a.CUCUST  = t.babkby";
			List list = jdbcTemplate.query(query2, new Object[] {}, new selctRowMapper());
			V_REP_CODE = ((List) list.get(0)).get(0).toString();
			V_REP_NAME = ((List) list.get(0)).get(1).toString();
		}
		
		String checkBoxFlag="select BNCSCD from BKP030 where BNBKNO='"+map.get("P_I_V_BKG_NO")+"' and  BNCSTP = 'O'  " ;
		
		String orgCodeFromBKP030= (String) jdbcTemplate.queryForObject(checkBoxFlag, Object.class);
		 
		 if(!orgCodeFromBKP030.equals(V_REP_CODE)) {
			 V_REP_FLAG = "Y";
		 }else {
			 V_REP_FLAG = "N";
		 }
		
		String  V_MTY_PICKUP_DT ;
		String  V_MTY_PICKUP_DEPOT ;
		String  V_MTY_PICKUP_DEPOT_NAME ;
		
		String quey1="SELECT DISTINCT POSITIONING_TERMINAL,  " + 
				"                          TO_CHAR(TO_DATE(cast(POSITIONING_DATE as varchar),'YYYYMMDD'),'DD/MM/YYYY') as date,  " + 
				"                          TQTRNM  " + 
				"          FROM SEALINER.BOOKING_SUPPLIER_DETAIL,SEALINER.ITP130  " + 
				"          WHERE POSITIONING_TERMINAL=TQTERM  " + 
				"                AND TQRCST = 'A'  " + 
				"                AND BOOKING_NO = '"+ map.get("P_I_V_BKG_NO")+"'";
		
		List list=jdbcTemplate.query(quey1,new Object[] {}, new PortDetlsRowMapper());
		
		
		
		if(list.size()>0) {
		V_MTY_PICKUP_DT=((List)list.get(0)).get(1).toString();
		V_MTY_PICKUP_DEPOT=((List)list.get(0)).get(0).toString();
		V_MTY_PICKUP_DEPOT_NAME=((List)list.get(0)).get(2).toString();
		}else {
			String PICKUP_DT_QUERY = "select "+
					"                          TO_CHAR(TO_DATE(cast(POSITIONING_DATE as varchar),'YYYYMMDD'),'DD/MM/YYYY') as date  " +
					"          FROM SEALINER.BOOKING_SUPPLIER_DETAIL  " +
					"                where BOOKING_NO = '"+ map.get("P_I_V_BKG_NO")+"' limit 1";
			V_MTY_PICKUP_DT=(String) jdbcTemplate.queryForObject(PICKUP_DT_QUERY, Object.class) ;
			V_MTY_PICKUP_DEPOT=null;
			V_MTY_PICKUP_DEPOT_NAME=null;
		}
		
//		BABKBY
		String query = "SELECT BABKNO,  " + "                      BAQUNO,  " + "                      BASTAT,  "
				+ "                      BACLBY,  " + "                      BACBPH,  "
				+ "                      CALLER_FAX,  " + "                      CALLER_EMAIL,  "
				+ "                      BAMODE,  " + "                      REFERENCE_NO,  "
				+ "                      BAORGN AS PLR_NAME,  "
				+ "                      BAPOL AS POL_NAME,  "
				+ "						 (select \"name\" from vrl_port where  code=BAPOL) as POLNAME, "	
				+ "                      BAPOD AS POD_NAME,  "
				+ "						 (select \"name\" from vrl_port where  code=BAPOD) as PODNAME, "		
				+ "                      BADSTN AS PLD_NAME,  "
				+ "                      bkfern AS BOOKINGREF,  "				
				+ "                      TOTERMINAL AS TO_TERMINAL,  "
				+ "                      FROMTERMINAL AS FROM_TERMINAL,  "
				+ "                      (SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal = TOTERMINAL) AS TO_TERMINALDES,  "
				+ "                      (SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal = FROMTERMINAL) AS FROM_TERMINALDES,  "
				+ "                      '"+V_MTY_PICKUP_DEPOT+"'  AS PICKUP_DEPOT,   "   
				+ "                      '"+V_MTY_PICKUP_DT+"' AS PICKUP_DATE,  "  
				+ "                      '"+V_MTY_PICKUP_DEPOT_NAME+"' AS PICKUP_DEPOT_NAME,  "   
				+ "						 TO_CHAR(TO_DATE(cast(VESSELETD as VARCHAR), 'YYYY-MM-DD'),'DD/MM/YYYY') AS VESSELETD,	"
				+ " 					 FIRST_LEG_LOCATION AS FIRST_LEG_LOCATION ,"
				+ "						 FIRST_LEG_TERMINAL AS FIRST_LEG_TERMINAL ,"
				+ "                      WEB_BOOK_REF,  "
				+ "                      TO_CHAR(TO_DATE(cast(BACADT as VARCHAR), 'YYYYMMDD'), 'DD/MM/YYYY') as BACADT,  "
				+ "                      ADDITIONAL_EMAILS,  "
				+ "                      TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') AS DESIRED_ARRIVAL_DATE,  "
				+ "                      ROUTE_PREFERENCE,  " + "                      CARGO_DESC,  "
				+ "                      BAORGN,  " + "                      BAPOL,  "
				+ "                      BAPOD,  " + "                      BADSTN,  "
				+ "                      BAPOL AS ORGN_COUNTRY,  "
				+ "                      BAPOD AS DSTN_COUNTRY,  "
				+ "                      (SELECT SCNAME FROM ITP040,ITP030 WHERE PICODE=BAPOL AND SCCODE=PICNCD) AS ORGN_COUNTRY_NAME,  "
				+ "                      (SELECT SCNAME FROM ITP040,ITP030 WHERE PICODE=BAPOD AND SCCODE=PICNCD) AS DSTN_COUNTRY_NAME,  "
				+ "                      BALINE,  " + "                      BATRAD,  "
				+ "                      BAAGNT,  " + "                      BABKBY,  "
				+ "                      TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') AS EXPECTED_SAILING_DATE ,"
				+ "       			   '" + V_REP_FLAG + "' as REP_FLAG,   " + "                      '" + V_REP_CODE
				+ "' as REP_CODE,   " + "                      '" + V_REP_NAME + "' as REP_NAME,   "
				+ "                      BABKTP,   "
				+ "                      (CASE when BABKTP='C' then 'Carrier own container (RCL)' else 'Shipper own container' end) as COC_SOC ,        "
				+ "						VESSEL_NAME as VESSEL_NAME ," + "						VOYAGE  as VOYAGE ,l.org_code as ORG_CODE  "
				+ "                         FROM SEALINER.BKP001 LEFT OUTER JOIN  ESV_WB_EXTEND  "
				+ "                ON BABKNO=PK_BOOKING_NO  "
				+ "											   LEFT OUTER JOIN  route_dtl_booking "
				+ "				 ON BABKNO=BOOKING_NO  "
				+" 					left outer join SEALINER.BKP030 c on  " + 
				"				BNBKNO=BABKNO " + 
				"				left outer join esm_user_login l on  " + 
				"	l.user_id =	c.bnausr"
				+ "                WHERE BABKNO='" + map.get("P_I_V_BKG_NO")
				+ "' and C.BNCSTP='O' ";

		List<EserviceNewWebBookingUim> lis= jdbcTemplate.query(query, new Object[] {},
				new BookingHeaderRowMappers(form));
		Map outPut = new HashMap();
		outPut.put("P_O_V_HDR_DATA", lis);
		System.out.println("PRR_ERCL_GET_BKG_HDR_EDIT--> " + query);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);

	}

	public class BookingHeaderRowMappers extends JdbcRowMapper {

		private EserviceNewWebBookingUim form;
		private List<PicMailMod> picuser;
		public BookingHeaderRowMappers(EserviceNewWebBookingUim form) {
			this.form = form;
		}

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			picuser=new ArrayList<PicMailMod>();
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
			form.setCustomerReference(rs.getString("REFERENCE_NO"));
			form.setPlaceOfReceipt(rs.getString("PLR_NAME"));
			form.setPortOfLoading(rs.getString("POL_NAME"));
			form.setPol(form.getPortOfLoading());
			form.setPolName(rs.getString("POLNAME"));
			form.setPortOfDischarge(rs.getString("POD_NAME"));
			form.setPod(form.getPortOfDischarge());
			form.setPodNmae(rs.getString("PODNAME"));
			form.setToTerminal(rs.getString("TO_TERMINAL"));
			form.setFromTerminal(rs.getString("FROM_TERMINAL"));
			form.setToTerminalDes(rs.getString("TO_TERMINALDES"));
			form.setFromTerminalDes(rs.getString("FROM_TERMINALDES"));
			form.setVesselEtd(rs.getString("VESSELETD"));
			form.setBookingRef(rs.getString("BOOKINGREF"));
			form.setToLocation(rs.getString("FIRST_LEG_LOCATION"));
			form.setTo(rs.getString("FIRST_LEG_TERMINAL"));
			
			form.setPlaceOfDelivery(rs.getString("PLD_NAME"));
			form.setTemplateName(rs.getString("WEB_BOOK_REF"));
			form.setShipmentDate(rs.getString("BACADT"));
			form.setAdditionalMailRecipeints(rs.getString("ADDITIONAL_EMAILS"));
			form.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
			form.setRoutingPreference(rs.getString("ROUTE_PREFERENCE"));
			form.setCargoDescription(rs.getString("CARGO_DESC"));
			form.setOriginCountry(rs.getString("ORGN_COUNTRY"));
			form.setDestinationCountry(rs.getString("DSTN_COUNTRY"));
			form.setSailingDate(rs.getString("EXPECTED_SAILING_DATE"));
			/* Begin @05 */
			form.setRepresentCompChkBox(rs.getString("REP_FLAG"));
			if(rs.getString("REP_FLAG").equals("Y"))
				form.setRepresentedCompanyCheckValidation("CHECKED");
			form.setRepresentComp(rs.getString("REP_CODE"));
			/* End @05 */
			form.setSocCocUserFlag(rs.getString("COC_SOC"));// @06
			form.setVessel(rs.getString("VESSEL_NAME"));
			form.setVoyage(rs.getString("VOYAGE"));
			form.setCustomerCode(rs.getString("BABKBY"));
			form.setEmptyPickupDepot(rs.getString("PICKUP_DEPOT"));
			form.setEmptyPickupDate(rs.getString("PICKUP_DATE"));
			try {
            	String q1="select recipient_email as MAIL,recipient_type as TYPE from pic_mail where E_NOTICE_DESC='ERCL - Web BKG Submission' and fk_customer_id='"+rs.getString("ORG_CODE")+"'";
            	System.out.println("q1 : "+q1);
            	picuser= jdbcTemplate.query(q1, new MailRowMapper() );
            	if(picuser.size()==0) {
            		String q2="select pic.recipient_email as MAIL,pic.recipient_type as TYPE from pic_mail pic  where pic.E_NOTICE_DESC='ERCL - Web BKG Submission' and pic.FK_FSC_ID='"+rs.getString("POL_NAME").substring(2, 5)+"'";
            		System.out.println("q2 : "+q2);
            		picuser= jdbcTemplate.query(q2, new MailRowMapper() );
            		if(picuser.size()==0) {
            			System.out.println("No pic mail.....");
            		}
            	}
            }catch (Exception e) {
            	e.printStackTrace();
			}
         String toPicMail="";
         String ccPicMail="";
         String bccPicMail="";
         for(int i=0;i<picuser.size();i++) {
        	 if(picuser.get(i).getMailType().equals("To"))
        		 toPicMail+=picuser.get(i).getMail()+",";
        	 else if(picuser.get(i).getMailType().equals("Cc"))
        		 ccPicMail+=picuser.get(i).getMail()+",";
        	 else if(picuser.get(i).getMailType().equals("Bcc"))
        		 bccPicMail+=picuser.get(i).getMail()+",";
         }
         if(!toPicMail.equals("")) {
        	 form.setToPicMail(toPicMail.substring(0,toPicMail.length()-1));
         }
         if(!ccPicMail.equals("")) {
        	 form.setCcPicMail(ccPicMail.substring(0,ccPicMail.length()-1));
         }
         if(!bccPicMail.equals("")) {
        	 form.setBccPicMail(bccPicMail.substring(0,bccPicMail.length()-1));
         }
			return null;
		}
	}

	class selctRowMapper extends JdbcRowMapper {

		public List mapRow(ResultSet rs, int row) throws SQLException {

			List lst = new ArrayList();
			lst.add(rs.getString("CUCUST"));
			lst.add(rs.getString("CUNAME"));
			return lst;
		}
	}
	
	class PortDetlsRowMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			
			List lst=new ArrayList ();
			
			lst.add(rs.getString("POSITIONING_TERMINAL"));
			lst.add(rs.getString("date"));
			lst.add(rs.getString("TQTRNM"));
			return lst;
		}
		
	}
	class MailRowMapper extends JdbcRowMapper{

		@Override
		public Object mapRow(ResultSet rs, int count) throws SQLException {
			 
			PicMailMod picmail= new PicMailMod();
			
			picmail.setMail(rs.getString("MAIL"));
			picmail.setMailType(rs.getString("TYPE"));
			
			return picmail;
		}
		 
	 }
}
