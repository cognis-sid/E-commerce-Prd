package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;

public class PRR_ERCL_GET_ESI_CONTACT_DTL {
	JdbcTemplate jdbcTemplate;
	Map map;
	EshippingInstructionUim form;

public PRR_ERCL_GET_ESI_CONTACT_DTL(JdbcTemplate jdbcTemplate,Map map,EshippingInstructionUim form) {
	this.jdbcTemplate=jdbcTemplate;
	this.map=map;
	this.form=form;
}

public Map executeDbProcedure() {
	
	String MODE_COUNT="Select Count(*) from ESV_SI_HEADER where FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'"; 
	
	int count=jdbcTemplate.queryForInt(MODE_COUNT);
	
	if(count==0) {
	String V_SQL="SELECT S.BNNAME AS NAME   " + 
			"                          ,S.BNADD1 AS ADR1   " + 
			"                          ,S.BNADD2 AS ADR2   " + 
			"                          ,S.BNADD3 AS ADR3   " + 
			"                          ,S.BNADD4 AS ADR4   " + 
			"                          ,'S' AS FLAG   " + 
			"						  ,S.BNCSCD AS SHIPPER_CODE   " + 
			"                    FROM BKP030 S   " + 
			"                    WHERE S.BNBKNO =  '"+map.get("P_I_V_BKG_NO")+"'    " + 
			"                          AND S.BNCSTP = 'S'   " + 
			"                    UNION   " + 
			"                    SELECT C.BNNAME AS NAME   " + 
			"                          ,C.BNADD1 AS ADR1   " + 
			"                          ,C.BNADD2 AS ADR2   " + 
			"                          ,C.BNADD3 AS ADR3   " + 
			"                          ,C.BNADD4 AS ADR4   " + 
			"                          ,'C' AS FLAG   " + 
			"						  ,C.BNCSCD AS CNEE_CODE   " + 
			"                    FROM BKP030 C   " + 
			"                    WHERE C.BNBKNO =  '"+map.get("P_I_V_BKG_NO")+"'    " +
			"                          AND C.BNCSTP = 'C'   " + 
			"                    UNION   " + 
			"                    SELECT N.BNNAME AS NAME   " + 
			"                          ,N.BNADD1 AS ADR1   " + 
			"                          ,N.BNADD2 AS ADR2   " + 
			"                          ,N.BNADD3 AS ADR3   " + 
			"                          ,N.BNADD4 AS ADR4   " + 
			"                          ,'N' AS FLAG   " + 
			"						  ,N.BNCSCD AS NTFY_CODE   " + 
			"                    FROM BKP030 N   " + 
			"                    WHERE N.BNBKNO = '"+map.get("P_I_V_BKG_NO")+"'    " +
			"                          AND N.BNCSTP = 'N' ";
	
	jdbcTemplate.query(V_SQL, new Object[] {}, new ContactDetailsRowMappers(form) );
	
	}else {
		String V_SQL="  " + 
				"SELECT S.SHIPPER_NAME AS NAME  " + 
				"                          ,S.SHIPPER_ADD1 AS ADR1  " + 
				"                          ,S.SHIPPER_ADD2 AS ADR2  " + 
				"                          ,S.SHIPPER_ADD3 AS ADR3  " + 
				"                          ,S.SHIPPER_ADD4 AS ADR4  " + 
				"                          ,'S' AS FLAG  " + 
				"						  ,S.DN_SHIPPER_CODE AS SHIPPER_CODE  " + 
				"                    FROM  ESV_SI_HEADER S  " + 
				"                    WHERE S.FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'"  + 
				"                    UNION  " + 
				"                    SELECT C.CNEE_NAME AS NAME  " + 
				"                          ,C.CNEE_ADD1 AS ADR1  " + 
				"                          ,C.CNEE_ADD2 AS ADR2  " + 
				"                          ,C.CNEE_ADD3 AS ADR3  " + 
				"                          ,C.CNEE_ADD4 AS ADR4  " + 
				"                          ,'C' AS FLAG  " + 
				"						  ,C.DN_CNEE_CODE AS CNEE_CODE  " + 
				"                    FROM  ESV_SI_HEADER C  " + 
				"                    WHERE C.FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'  " + 
				"                    UNION  " + 
				"                    SELECT N.NTFY_NAME AS NAME  " + 
				"                          ,N.NTFY_ADD1 AS ADR1  " + 
				"                          ,N.NTFY_ADD2 AS ADR2  " + 
				"                          ,N.NTFY_ADD3 AS ADR3  " + 
				"                          ,N.NTFY_ADD4 AS ADR4  " + 
				"                          ,'N' AS FLAG  " + 
				"						  ,N.DN_NTFY_CODE AS NTFY_CODE  " + 
				"                    FROM  ESV_SI_HEADER N  " + 
				"                    WHERE N.FK_BOOKING_NO ='"+map.get("P_I_V_BKG_NO")+"'";
		jdbcTemplate.query(V_SQL, new Object[] {}, new ContactDetailsRowMappers(form) );
	}
	
	Map outPut=new HashMap();
	outPut.put("P_O_V_DTL_DATA", null);
	
	return null;
}
public class ContactDetailsRowMappers extends JdbcRowMapper{

    private EshippingInstructionUim form;

    /**
     * 
     * This constructor for set obj to global variable.
     * 
     * @param form Object's Eshipping Instruction Form
     */
    public ContactDetailsRowMappers(EshippingInstructionUim form){
        this.form = form;
    }

    /**
     * 
     * This mothod for set data to contact detail in each row.
     * 
     * @exception SQLException
     * @param rs List of contact detail
     * @param row Row of contact detail
     */
    public Object mapRow(ResultSet rs, int row) throws SQLException{
        if(EshippingInstructionDao.KEY_FLAG_SHIPPER.equals(rs.getString(6))){
            //            System.out.println("KEY_FLAG_SHIPPER   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            form.setShipperName(rs.getString(1));
            form.setShipperAddress1(rs.getString(2));
            form.setShipperAddress2(rs.getString(3));
            form.setShipperAddress3(rs.getString(4));
            form.setShipperAddress4(rs.getString(5));
            form.setShipperCode(rs.getString(7));
        } else if(EshippingInstructionDao.KEY_FLAG_CONSIGNEE.equals(rs.getString(6))){
            //                System.out.println("KEY_FLAG_CONSIGNEE     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            form.setConsigneeName(rs.getString(1));
            form.setConsigneeAddress1(rs.getString(2));
            form.setConsigneeAddress2(rs.getString(3));
            form.setConsigneeAddress3(rs.getString(4));
            form.setConsigneeAddress4(rs.getString(5));
            form.setConsigneeCode(rs.getString(7));
        } else if(EshippingInstructionDao.KEY_FLAG_NOTIFY_PART.equals(rs.getString(6))){
            //                System.out.println("KEY_FLAG_NOTIFY_PART    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            form.setNotifyPartyName(rs.getString(1));
            form.setNotifyPartyAddress1(rs.getString(2));
            form.setNotifyPartyAddress2(rs.getString(3));
            form.setNotifyPartyAddress3(rs.getString(4));
            form.setNotifyPartyAddress4(rs.getString(5));
            form.setNotifyPartyCode(rs.getString(7));
        }
        return null;
    }
}
}