package com.rclgroup.dolphin.rcl.web.procedure.user;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ESV_LOGIN {
	private String SFU_HACK_POST_GRE;
	private Map map;
	private String[][] param;
	private String customerCode;
	public PRR_ESV_LOGIN(String[][] param,String customerCode,String SFU_HACK_POST_GRE) {
		this.param = param;
		this.customerCode = customerCode;
		this.SFU_HACK_POST_GRE= SFU_HACK_POST_GRE;
	}

	public String executeDbProcedure(Connection connection) throws Exception {
		Statement stm 				  =     null;
		
        String P_I_V_FIRST_NAME       =     param[0][3];
        String P_I_V_LAST_NAME        =     param[1][3];
        String P_I_V_EMAIL            =     param[2][3];
        String P_I_V_USR_ID           =     param[3][3];     
        String P_I_V_PASSWORD         =     param[4][3];     
        String P_I_V_CMP_NAME         =     param[5][3];     
        String P_I_V_ADDRESS1         =     param[6][3];     
        String P_I_V_ADDRESS2         =     param[7][3];     
        String P_I_V_ADDRESS3         =     param[8][3];     
        String P_I_V_ADDRESS4         =     param[9][3];     
        String P_I_V_CITY             =     param[10][3];     
        String P_I_V_STATE            =     param[11][3];     
        String P_I_V_COUNTRY          =     param[12][3];    
        String P_I_V_PHONENO          =     param[13][3];    
        String P_I_V_FAXNO            =     param[14][3];     
       // String P_I_V_SFU            =     param[15][3];  
        String V_SFU                  =     "";
        String V_ROLE_CD              =    "BASIS";
        String P_I_V_ORG_CODE		  =    customerCode;
        String getRate				  =		"";
        String webBooking			  =		"";
        String vgm					  =     "";
        String P_I_V_SFU 			  =     SFU_HACK_POST_GRE;
        if(P_I_V_SFU== null) {
        	throw new Exception();
        }
       
//        EBKG-E-web booking
//        EVGM-G-get rates
        
        if(P_I_V_SFU.contains("EBKG-E")) {
        	webBooking="Y";
        }
        if(P_I_V_SFU.contains("EVGM-G")) {
        	getRate="Y";
        }
        
        if(P_I_V_SFU.contains("EVGM-E")) {
        	vgm="Y";
        }
        
        if(P_I_V_SFU!= null && P_I_V_SFU.endsWith(","))
        		   V_SFU = P_I_V_SFU.substring(1, P_I_V_SFU.length()-1) ;
        else
        		   V_SFU = P_I_V_SFU ;
        
        
        V_ROLE_CD = V_ROLE_CD + ',' + V_SFU;
       
		
        V_ROLE_CD=V_ROLE_CD.replace(",","','");
        V_ROLE_CD = "'"+V_ROLE_CD+"'"; 
        
		String sqlQry = "INSERT INTO RCLTBLS.esm_user_login (LINE, "
				+ "TRADE, "
				+ "AGENT, "
				+ "USER_ID, "
				+ "PERSON_CD, "
				+ "USER_NAME,"
				+ " PSWD,  "
				+ "PSWD_EXP, "
				+ "AUSR, "
				+ "RECORD_ADD_DATE,"
				+ " RECORD_ADD_TIME,"
				+ " CUSR, "
				+ " RECORD_CHANGE_DATE,"
				+ " RECORD_CHANGE_TIME,"
				+ " RECORD_STATUS,"
				+ " FSC_CODE,"
				+ " DEPT_CODE,"
				+ " ORG_CODE,"
				+ " ORG_TYPE, "
				+ "LAST_PASSWORD_CHANGED_DATE, "
				+ " IS_LOCKED, "
				+ " EMAIL_ID1, "
				+ "EMAIL_ID2, "
				+ "COMPANY_NAME,"
				+ "CMP_ADDRESS1,"
				+ "CMP_ADDRESS2, "
				+ "CMP_ADDRESS3, "
				+ "CMP_ADDRESS4, "
				+ "CITY, "
				+ "STATE,"
				+ " COUNTRY, "
				+ "PHONE, "
				+ "FAX, "
				+ "LAST_LOGIN_DATE ,"
				+ "GET_RATES,"
				+ "WEB_BOOKING,VGM) "
				+ "VALUES ('R',"
				+ " '*', "
				+ "'***', "
				+ "UPPER(LTRIM(RTRIM('"
				+ P_I_V_USR_ID + "'))),"
				+ " UPPER(LTRIM(RTRIM('" + P_I_V_USR_ID + "'))), "
				+ "RTRIM(LTRIM('" + P_I_V_FIRST_NAME
				+ "')) ||' '||RTRIM(LTRIM('" + P_I_V_LAST_NAME
				+ "')), '"
				+ P_I_V_PASSWORD+"',"
				+ "  'N',"
				+ " 'E-Commerce',"
				+ " TO_NUMBER(TO_CHAR(now(),'YYYYMMDD'),'9G999g9999'),"
				+ " TO_NUMBER(TO_CHAR(now(),'HH24MI'),'9G999g999'), "
				+ "'E-Commerce',"
				+ " TO_NUMBER(TO_CHAR(now(),'YYYYMMDD'),'9G999g9999'),"
				+ " TO_NUMBER(TO_CHAR(now(),'HH24MI'),'9G999g999'),"
				+ "'',"
				+ " 'R',"
				+ " NULL, "
				+ "'"+((P_I_V_ORG_CODE==null || "".equals(P_I_V_ORG_CODE))?null:P_I_V_ORG_CODE)+"', "
				+ "'C', "
				+ "TO_NUMBER(TO_CHAR(now(),'YYYYMMDD'),'9G999g9999'), "
				+ " 'Y', '"
				+ P_I_V_EMAIL 
				+ "', NULL, '"
				+ P_I_V_CMP_NAME + "',"
				+ "'" + P_I_V_ADDRESS1 + "', "
				+ "'" + P_I_V_ADDRESS2 + "','"
				+ P_I_V_ADDRESS3 + "', "
				+ "'" + P_I_V_ADDRESS4 + "',"
				+ "'" + P_I_V_CITY + "',"
				+ "'" + P_I_V_STATE + "',"
				+ "'" + P_I_V_COUNTRY
				+ "','" + P_I_V_PHONENO + "',"
				+ "'" + P_I_V_FAXNO + "',"
				+ " now() ,"
				+ "'"+getRate+"'  ,"
				+ "'"+webBooking+"','"+vgm+"')";
		
		//jdbcTemplate.update(sqlQry);
		String sqlQry2 =" INSERT INTO SEALINER.ESM_USER_PWD (USER_ID, PWD) VALUES (UPPER(LTRIM(RTRIM('"+P_I_V_USR_ID+"'))),'"+ P_I_V_PASSWORD+"')";
	//	jdbcTemplate.update(sqlQry2);
		stm = connection.createStatement();
		int countQury = stm.executeUpdate(sqlQry2);
	 	stm.close();

		String sqlQry3 = "INSERT INTO SEALINER.PR_PRSN_ROLE (SYSLVL1,SYSLVL2,SYSLVL3,PRSN_LOG_ID,ROLE_CD,PERSON_ROLE_ID,DESCR,AUSR,ADAT,CUSR,CDAT,RCST)"+
	   "(SELECT 'R','*','***',UPPER(LTRIM(RTRIM('"+P_I_V_USR_ID+"'))),ROLE_CD,0,DESCR,'WEBREGIST',now(),NULL,NULL,'S'"+
	     " FROM SEALINER.SC_ROLE WHERE ROLE_CD IN ("+V_ROLE_CD+"))";
		
		//jdbcTemplate.update(sqlQry3);

	return "";
	}
}
