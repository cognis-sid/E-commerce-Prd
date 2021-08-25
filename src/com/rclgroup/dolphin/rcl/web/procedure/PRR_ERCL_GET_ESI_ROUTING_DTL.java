package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PicMailMod;

public class PRR_ERCL_GET_ESI_ROUTING_DTL {

	JdbcTemplate jdbcTemplate;
	Map map;
	EshippingInstructionUim form;

public PRR_ERCL_GET_ESI_ROUTING_DTL(JdbcTemplate jdbcTemplate,Map map,EshippingInstructionUim form) {
	this.jdbcTemplate=jdbcTemplate;
	this.map=map;
	this.form=form;
}

public void executeDbProcedure() {

    String MODE_COUNT="Select Count(*) from ESV_SI_HEADER where FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'"; 
	
	int count=jdbcTemplate.queryForInt(MODE_COUNT);
	
		if(count==0) {
		String V_SQL="select   " + 
				"	 VESSEL_NAME ,   " + 
				"	 VESSEL_NO ,   " + 
				"	 VOYAGE ,   " + 
				"	(Select TO_CHAR(TO_DATE(cast(SAILING_DATE as VARCHAR), 'YYYYMMDD'), 'DD/MM/YYYY') "+
				"	form FROM RCLTBLS.BKG_VOYAGE_ROUTE WHERE  FK_BOOKING_NO ='"+map.get("P_I_V_BKG_NO")+"' limit 1 )as SHIPPED_ON_BOARD_DATE ," + 
				"	(   " + 
				"	select   " + 
				"		name as Issue_Place   " + 
				"	from   " + 
				"		VRL_PORT, ITP030   " + 
				"	where   " + 
				"		CODE = BAPOL   " + 
				"		and country = SCCODE) as PLACE_OF_ISSUE ,   " + 
				"	(   " + 
				"	select   " + 
				"		name || ', ' || SCNAME as POL   " + 
				"	from   " + 
				"		VRL_PORT,ITP030   " + 
				"	where   " + 
				"		CODE = BAPOL   " + 
				"		and country = SCCODE) as POL ,   " + 
				"	(   " + 
				"	select   " + 
				"		name || ', ' || SCNAME as POD   " + 
				"	from   " + 
				"		VRL_PORT, ITP030   " + 
				"	where   " + 
				"		CODE = BAPOD   " + 
				"		and country = SCCODE) as POD ,   " + 
				"	BAPOL ,   " + 
				"	BAPOD ,   " + 
				"	(   " + 
				"	select   " + 
				"		POINT_NAME || ', ' || SCNAME as PLR   " + 
				"	from   " + 
				"		POINT_MASTER, ITP030   " + 
				"	where   " + 
				"		POINT_CODE = BAORGN   " + 
				"		and COUNTRY_CODE = SCCODE) || ' ' || substr(BAMODE, 1, 2) as PLR ,   " + 
				"	(   " + 
				"	select   " + 
				"		POINT_NAME || ', ' || SCNAME as PLD   " + 
				"	from   " + 
				"		POINT_MASTER, ITP030   " + 
				"	where   " + 
				"		POINT_CODE = BADSTN   " + 
				"		and COUNTRY_CODE = SCCODE) || ' ' || substr(BAMODE, 3, 4) as PLD ,   " + 
				"	POL_FSC ,   " + 
				"	(   " + 
				"	select   " + 
				"		SCNAME   " + 
				"	from   " + 
				"		VRL_PORT, ITP030   " + 
				"	where   " + 
				"		CODE = BAPOD   " + 
				"		and country = SCCODE) as POD_COUNTRY_NAME ,  " + 
				"	 b.toterminal as TOTERMINAL,	"+
				"	 (SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal=b.toterminal) as TOTERMINALDES,	"+
				"	 b.fromterminal as FROMTERMINAL,	"+
				"	 (SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal=b.fromterminal) as FROMTERMINALDES,	"+
				"	 b.vesseletd as VESSELETD	"+
				"	,babkby			as org_code "+
				"	,(select port_name from cam_port where pk_port_code=b.bapot1)  port1	"+
				"	,(select port_name from cam_port where pk_port_code=b.bapot2)  port2	"+
				"	,(select port_name from cam_port where pk_port_code=b.bapot3)  port3	"+
				"from   " + 
				"	BKP001 b left outer join    " + 
				"	route_dtl_booking r  on b.babkno=r.BOOKING_NO   " + 
				"where   " + 
				"	babkno = '"+map.get("P_I_V_BKG_NO")+"'  limit 1 " ;
				
			
		jdbcTemplate.query(V_SQL, new Object[] {}, new RoutingDetailsRowMappers(form, (String)map.get("P_I_V_ESI_STATUS")));
		}else {
			String V_SQL="select   " + 
					"		R.VESSEL_NAME as VESSEL_NAME ,   " + 
					"		R.VESSEL_NO as VESSEL_NO ,   " + 
					"		R.VOYAGE as VOYAGE ,   " + 
					"		(Select TO_CHAR(TO_DATE(cast(SAILING_DATE as VARCHAR), 'YYYYMMDD'), 'DD/MM/YYYY') "+
					"		form FROM RCLTBLS.BKG_VOYAGE_ROUTE WHERE  FK_BOOKING_NO ='"+map.get("P_I_V_BKG_NO")+"' limit 1 )as SHIPPED_ON_BOARD_DATE ," + 
					"		BL_ISSUE_PLACE_NAME as PLACE_OF_ISSUE ,   " + 
					"		POL_NAME as POL ,   " + 
					"		POD_NAME as POD ,   " + 
					"		W.BAPOL AS POL_NO ,   " + 
					"		W.BAPOD AS POD_NO ,   " +
					"		PLR_NAME as PLR ,   " + 
					"		PLD_NAME as PLD ,   " + 
					"		(   " + 
					"		select   " + 
					"			POL_FSC   " + 
					"		from   " + 
					"			BKP001   " + 
					"		where   " + 
					"			BABKNO = '"+map.get("P_I_V_BKG_NO")+"') as POL_FSC ,   " + 
					"		(   " + 
					"		select   " + 
					"			SCNAME   " + 
					"		from   " + 
					"			VRL_PORT, ITP030, BKP001   " + 
					"		where   " + 
					"			CODE = BAPOD   " + 
					"			and country = SCCODE   " + 
					"			and BABKNO ='"+map.get("P_I_V_BKG_NO")+"') as POD_COUNTRY_NAME , " + 
					"		B.TO_TERMINAL as TOTERMINAL,	"+
					"	 (SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal=B.TO_TERMINAL) as TOTERMINALDES,	"+
					"		B.FROM_TERMINAL as FROMTERMINAL,	"+
					"	 (SELECT terminal_name FROM cam_terminal_depot ctd  WHERE pk_terminal=B.FROM_TERMINAL) as FROMTERMINALDES,	"+
					"		B.VESSELETD as VESSELETD , "+
					"		B.dn_shipper_code         AS org_code"+
					"		,(select port_name from cam_port where pk_port_code=w.bapot1)  port1	"+
					"		,(select port_name from cam_port where pk_port_code=w.bapot2)  port2	"+
					"		,(select port_name from cam_port where pk_port_code=w.bapot3)  port3	"+
					"	from   " + 
					"		 ESV_SI_HEADER B LEFT OUTER JOIN   " + 
					"		 ROUTE_DTL_BOOKING R  ON B.FK_BOOKING_NO=R.BOOKING_NO   " + 
					"		 LEFT OUTER join BKP001 W ON B.FK_BOOKING_NO=W.BABKNO   " + 
					"		    " + 
					"	   " + 
					"where FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"' limit 1";
		System.out.println("PRR_ERCL_GET_ESI_ROUTING_DTL "+ V_SQL);
			jdbcTemplate.query(V_SQL, new Object[] {}, new RoutingDetailsRowMappers(form, (String)map.get("P_I_V_ESI_STATUS")));			
		}
	}
	
public class RoutingDetailsRowMappers extends JdbcRowMapper{

    private EshippingInstructionUim form;
    private String status;
    private List<PicMailMod> picuser;
    /**
     * 
     * This constructor for set obj to global variable.
     * 
     * @param form Object's Eshipping Instruction Form
     * @param status ESI Status
     */
    public RoutingDetailsRowMappers(EshippingInstructionUim form, String status){
        this.form = form;
        this.status = status;
    }

    /**
     * 
     * This mothod for set data to routing detail in each row.
     * 
     * @exception SQLException
     * @param rs List of routing detail
     * @param row Row of routing detail
     */
    public Object mapRow(ResultSet rs, int row) throws SQLException{
        form.setVessel(rs.getString(1));
        form.setVesselNo(rs.getString(2));
        form.setVoyageNo(rs.getString(3));
        form.setShippedOnBoardDate(rs.getString(4));
        form.setPlaceDateOfIssue(rs.getString(5));
        form.setPol(rs.getString(6));
        form.setPod(rs.getString(7));
        form.setPolNo(rs.getString(8));
        form.setPodNo(rs.getString(9));
        form.setPlaceOfReceipt(rs.getString(10));
        form.setPlaceOfDelivery(rs.getString(11));
        form.setFsc(rs.getString(12));
        form.setPodCountry(rs.getString(13));
        form.setFromTerminal(rs.getString("FROMTERMINAL"));
        form.setToTerminal(rs.getString("TOTERMINAL"));
        form.setFromTerminalDes(rs.getString("FROMTERMINALDES"));
        form.setToTerminalDes(rs.getString("TOTERMINALDES"));
        form.setVesselEdi(rs.getString("VESSELETD"));
        try {
        	String q1="select recipient_email as MAIL,recipient_type as TYPE from pic_mail where E_NOTICE_DESC='ERCL - eSI Submission' and fk_customer_id='"+rs.getString("org_code")+"' ";
        	System.out.println("q1 : "+q1);
        	picuser= jdbcTemplate.query(q1, new MailRowMapper() );
        	if(picuser.size()==0) {
        		String q2="select pic.recipient_email as MAIL,pic.recipient_type as TYPE from pic_mail pic  where pic.E_NOTICE_DESC='ERCL - eSI Submission' and pic.FK_FSC_ID='"+rs.getString(8).substring(2, 5)+"'";
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
     	form.setPort1(rs.getString("port1"));
		form.setPort2(rs.getString("port2"));
		form.setPort3(rs.getString("port3"));   
        return null;
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
