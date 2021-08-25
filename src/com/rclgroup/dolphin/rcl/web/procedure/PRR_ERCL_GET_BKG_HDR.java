package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.action.EservicePropertyFatchOperation;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PicMailMod;

public class PRR_ERCL_GET_BKG_HDR {
	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRR_ERCL_GET_BKG_HDR(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	public void executeDbProcedure() {
		String V_REP_FLAG;
		String V_REP_CODE;
		String V_REP_NAME;
		String countv_cou= "select COUNT(*)   " + 
				"          from BKP030 t  " + 
				"          where BNBKNO = '"+ map.get("P_I_V_BKG_NO") +"'" + 
				"            and BNCSTP = 'O'  " + 
				"            and exists (select 1  " + 
				"                          from BKP030 a  " + 
				"                          where a.BNBKNO = '"+ map.get("P_I_V_BKG_NO") +"'" + 
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
					"            where BNBKNO    = '"+map.get("P_I_V_BKG_NO")+"'   " + 
					"              and BNCSTP    = 'O'   " + 
					"              and a.CUCUST  = t.bncscd";
			List list=jdbcTemplate.query(query2, new Object[] {}, new selctRowMapper());
			V_REP_CODE=((List)list.get(0)).get(0).toString();
			V_REP_NAME=((List)list.get(0)).get(1).toString();
		}
		
		String query="SELECT BABKNO,  " + 
				"                      BAQUNO,  " + 
				"                      BASTAT,  " + 
				"                      BACLBY,  " + 
				"                      BACBPH,  " + 
				"					   BOOKING_TYPE,"+
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
				"                      TO_CHAR(EXPECTED_SAILING_DATE,'DD/MM/YYYY') AS EXPECTED_SAILING_DATE,  " +
				"                      ADDITIONAL_EMAILS,  " + 
				"                      TO_CHAR(DESIRED_ARRIVAL_DATE,'DD/MM/YYYY') AS DESIRED_ARRIVAL_DATE,  " + 
				"                      ROUTE_PREFERENCE,  " + 
				"                      CARGO_DESC,  " + 
				"                      BAORGN,  " + 
				"                      BAPOL,  " + 
				"                      BAPOD,  " + 
				"                      BADSTN,  " + 
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
				"                      '"+V_REP_NAME+"' as REP_NAME,   " + 
				"                      BABKTP,   " + 
				"					   eul.org_code         AS org_code,"+
				"                      (CASE when BABKTP='C' then 'Carrier own container (RCL)' else 'Shipper own container' end) as COC_SOC         "+
				"                         FROM SEALINER.BKP001 LEFT OUTER JOIN  ESV_WB_EXTEND  " + 
				"                ON BABKNO=PK_BOOKING_NO   inner join  esm_user_login   eul on eul.user_id =baausr  " + 
				"                WHERE BABKNO='"+ map.get("P_I_V_BKG_NO") +"'";
		
		List<EserviceNewWebBookingUim> list=jdbcTemplate.query(query, new Object[] {},new TemplateHDRDataRowMappers() );
		Map outPut =new HashMap();
		outPut.put("P_O_V_HDR_DATA", list);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
	 class TemplateHDRDataRowMappers extends JdbcRowMapper{
		 private List<PicMailMod> picuser;
         public EserviceNewWebBookingUim mapRow(ResultSet rs, int row) throws SQLException{
        	 //sushil 
             EserviceNewWebBookingUim eserviceNewWebBookingUim = new EserviceNewWebBookingUim();
             picuser=new ArrayList<PicMailMod>();
             eserviceNewWebBookingUim.setBookingNo(rs.getString("BABKNO"));
             eserviceNewWebBookingUim.setQuotationNumber(rs.getString("BAQUNO"));
             eserviceNewWebBookingUim.setTemplateFlag(rs.getString("BOOKING_TYPE"));
             eserviceNewWebBookingUim.setStatus(rs.getString("BASTAT"));
             eserviceNewWebBookingUim.setContact(rs.getString("BACLBY"));
             eserviceNewWebBookingUim.setTelephone(rs.getString("BACBPH"));
             eserviceNewWebBookingUim.setFax(rs.getString("CALLER_FAX"));
             eserviceNewWebBookingUim.setEmail(rs.getString("CALLER_EMAIL"));
             eserviceNewWebBookingUim.setShipmentTerm(rs.getString("BAMODE"));
             eserviceNewWebBookingUim.setCustomerReference(rs.getString("REFERENCE_NO"));
             eserviceNewWebBookingUim.setPlaceOfReceipt(rs.getString("BAORGN"));
             eserviceNewWebBookingUim.setPortOfLoading(rs.getString("BAPOL"));
             eserviceNewWebBookingUim.setPortOfDischarge(rs.getString("BAPOD"));
             eserviceNewWebBookingUim.setPlaceOfDelivery(rs.getString("BADSTN"));
             eserviceNewWebBookingUim.setTemplateName(rs.getString("WEB_BOOK_REF"));
             eserviceNewWebBookingUim.setShipmentDate(rs.getString("BACADT"));
             eserviceNewWebBookingUim.setAdditionalMailRecipeints(rs.getString("ADDITIONAL_EMAILS"));
             eserviceNewWebBookingUim.setDesiredArrivalDate(rs.getString("DESIRED_ARRIVAL_DATE"));
             eserviceNewWebBookingUim.setSailingDate(rs.getString("EXPECTED_SAILING_DATE"));
             eserviceNewWebBookingUim.setRoutingPreference(rs.getString("ROUTE_PREFERENCE"));
             eserviceNewWebBookingUim.setCargoDescription(rs.getString("CARGO_DESC"));
             eserviceNewWebBookingUim.setOriginCountry(rs.getString("ORGN_COUNTRY"));
             eserviceNewWebBookingUim.setDestinationCountry(rs.getString("DSTN_COUNTRY"));
             eserviceNewWebBookingUim.setLine(rs.getString("BALINE"));
             eserviceNewWebBookingUim.setTrade(rs.getString("BATRAD"));
             eserviceNewWebBookingUim.setAgent(rs.getString("BAAGNT"));
             eserviceNewWebBookingUim.setCustomerCode(rs.getString("BABKBY"));
             
             /*Begin @07*/
             eserviceNewWebBookingUim.setRepresentCompChkBox(rs.getString("REP_FLAG"));
             eserviceNewWebBookingUim.setRepresentComp(FormatUtil.nullToBlank(rs.getString("REP_CODE")));
             /*End @07*/
             eserviceNewWebBookingUim.setSocCocUserFlag(rs.getString("BABKTP"));//@08

             try {
            	 	String q1="select recipient_email as MAIL,recipient_type as TYPE from pic_mail where E_NOTICE_DESC='ERCL - Web BKG Submission' and fk_customer_id='"+rs.getString("org_code")+"'";
            	 	System.out.println("q1 : "+q1);
            	 	picuser= jdbcTemplate.query(q1, new MailRowMapper() );
	            	if(picuser.size()==0) {
	            		String q2="select pic.recipient_email as MAIL,pic.recipient_type as TYPE from pic_mail pic  where pic.E_NOTICE_DESC='ERCL - Web BKG Submission' and pic.FK_FSC_ID=(select PIOFFC from itp040 where picode='"+rs.getString("BAPOL")+"')";
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
             eserviceNewWebBookingUim.setToPicMail(toPicMail.substring(0,toPicMail.length()-1));
             }
             if(!ccPicMail.equals("")) {
             eserviceNewWebBookingUim.setCcPicMail(ccPicMail.substring(0,ccPicMail.length()-1));
             }
             if(!bccPicMail.equals("")) {
             eserviceNewWebBookingUim.setBccPicMail(bccPicMail.substring(0,bccPicMail.length()-1));
             }
             if(eserviceNewWebBookingUim.getStatus().equals("O")){
                 eserviceNewWebBookingUim.setStatus("Open");
             }

             return eserviceNewWebBookingUim;
         } // mapRow

     }
	 class selctRowMapper extends JdbcRowMapper{

         public List mapRow(ResultSet rs, int row) throws SQLException{
        	 
        	 List lst=new ArrayList();
        	 lst.add(rs.getString("CUCUST"));
        	 lst.add(rs.getString("CUNAME"));
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
