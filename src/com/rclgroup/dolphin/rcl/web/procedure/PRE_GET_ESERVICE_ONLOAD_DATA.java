package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PicMailMod;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_BKG_HDR.MailRowMapper;

public class PRE_GET_ESERVICE_ONLOAD_DATA extends AncestorJdbcDao{

	JdbcTemplate jdbcTemplate;
	Map map;
	String query1;
	public PRE_GET_ESERVICE_ONLOAD_DATA(JdbcTemplate jdbcTemplate,Map map){
			this.jdbcTemplate=jdbcTemplate;
			this.map=map;
	}
	public void executeDbProcedure() {

			query1="SELECT  " + 
					"                I10.CUCORS AS \"SOS_COC\" ,  " + 
					"                I10.CUTELE AS \"TELEPHONE\" ,  " + 
					"                I10.CUFAX  AS  \"FAX\",   " + 
					"				 SPLI.EMAIL_ID1 AS \"EMAIL\" ,"+
					"				 LOGIN.ORG_CODE AS ORG_CODE, "+	
					"				 '"+map.get("P_I_V_PORT_OF_LOADING")+"' as POL "	+
					"            FROM  " + 
					"                ITP010 I10, SC_PRSN_LOG_INFO SPLI ,ESM_USER_LOGIN LOGIN " + 
					"            WHERE  " + 
					"                I10.CUCUST = SPLI.ORG_CODE  " + 
					"				 AND LOGIN.USER_ID = '"+map.get("P_I_V_USER_ID")+"'"+
					"                AND SPLI.PRSN_LOG_ID = '"+map.get("P_I_V_USER_ID")+"'";
			
			List<ComboVO> list=jdbcTemplate.query(query1, new Object[] {}, new OnloadRowMappers());
			
			Map outPut=new HashMap();
			outPut.put("P_O_V_REF_CURSOR_DATA",list);
			outPut.put("P_O_V_ERROR",null);
			
			map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
			
	}
	
	class OnloadRowMappers extends JdbcRowMapper{
		private List<PicMailMod> picuser;
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EserviceNewWebBookingMod eserviceNewWebBookingMod = new EserviceNewWebBookingMod();
            picuser=new ArrayList<PicMailMod>();
            eserviceNewWebBookingMod.setSosCoc(rs.getString("SOS_COC"));
            eserviceNewWebBookingMod.setTelephone(rs.getString("TELEPHONE"));
            eserviceNewWebBookingMod.setFax(rs.getString("FAX"));
            eserviceNewWebBookingMod.setEmail(rs.getString("EMAIL"));
            System.out.println("org code : "+rs.getString("ORG_CODE"));
            try {
            	String q1="select recipient_email as MAIL,recipient_type as TYPE from pic_mail where E_NOTICE_DESC='ERCL - Web BKG Submission' and fk_customer_id='"+rs.getString("ORG_CODE")+"'";
            	System.out.println("q1 : "+q1);
            	picuser= jdbcTemplate.query(q1, new MailRowMapper());
            	if(picuser.size()==0) {
            		String q2="select pic.recipient_email as MAIL,pic.recipient_type as TYPE from pic_mail pic  where pic.E_NOTICE_DESC='ERCL - Web BKG Submission' and "
            				+ "			pic.FK_FSC_ID=(select PIOFFC from itp040 where picode= '"+rs.getString("POL")+"')";
            		System.out.println("q2 : "+q2);
            		picuser= jdbcTemplate.query(q2, new MailRowMapper());
            		if(picuser.size()==0) {
            			System.out.println("No pic mail.....");
            		}
            	}
            }catch (Exception e) {
            	e.printStackTrace();
			}String toPicMail="";
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
            	eserviceNewWebBookingMod.setToPicMail(toPicMail.substring(0,toPicMail.length()-1));
            }
            if(!ccPicMail.equals("")) {
            	eserviceNewWebBookingMod.setCcPicMail(ccPicMail.substring(0,ccPicMail.length()-1));
            }
            if(!bccPicMail.equals("")) {
            	eserviceNewWebBookingMod.setBccPicMail(bccPicMail.substring(0,bccPicMail.length()-1));
            }
            return eserviceNewWebBookingMod;
        } // mapRow
        // OnloadRowMapper


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
