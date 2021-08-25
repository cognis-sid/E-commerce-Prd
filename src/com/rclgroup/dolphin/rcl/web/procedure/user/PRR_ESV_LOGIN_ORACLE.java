package com.rclgroup.dolphin.rcl.web.procedure.user;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ESV_LOGIN_ORACLE {

	JdbcTemplate jdbcTemplate;
	Map map;
	String[][] param;

	public PRR_ESV_LOGIN_ORACLE(JdbcTemplate jdbcTemplate, String[][] param) {
		this.jdbcTemplate = jdbcTemplate;
		this.param = param;
	}

	public String executeDbProcedure() {
		
        String P_I_V_FIRST_NAME       =      param[0][3];
        String P_I_V_LAST_NAME        =      param[1][3];
        String P_I_V_EMAIL            =      param[2][3];
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
        String P_I_V_SFU              =     param[15][3];  
        String  V_SFU                =    "";
        String V_ROLE_CD              =    "G_V_BASIS";
        if(P_I_V_SFU.endsWith(","))
        		   V_SFU = P_I_V_SFU.substring(1, P_I_V_SFU.length()-1) ;
        else
        		   V_SFU = P_I_V_SFU ;
        
        
        V_ROLE_CD = V_ROLE_CD + ',' + V_SFU;
       
		
        V_ROLE_CD=V_ROLE_CD.replace(",","','");
        V_ROLE_CD = "'"+V_ROLE_CD+"'"; 
        
		String sqlQry = "INSERT INTO RCLTBLS.ESM_USER_LOGIN (LINE, TRADE, AGENT, USER_ID, PERSON_CD, USER_NAME, PSWD, RE_PSWD, PSWD_EXP, PSWD_EXP_DAYS, CHNG_PSWD, AUSR, RECORD_ADD_DATE, RECORD_ADD_TIME, CUSR, RECORD_CHANGE_DATE, RECORD_CHANGE_TIME, RECORD_STATUS, FSC_CODE, DEPT_CODE, ORG_CODE, ORG_TYPE, LAST_PASSWORD_CHANGED_DATE, SHARE_FSC, IS_LOCKED, IS_GROUP_AUTH, EMAIL_ID1, EMAIL_ID2, COMPANY_NAME , CMP_ADDRESS1, CMP_ADDRESS2, CMP_ADDRESS3, CMP_ADDRESS4, CITY, STATE, COUNTRY, PHONE, FAX, LAST_LOGIN_DATE ) VALUES ('R', '*', '***', UPPER(LTRIM(RTRIM('"
				+ P_I_V_USR_ID + "'))), UPPER(LTRIM(RTRIM('" + P_I_V_USR_ID + "'))), RTRIM(LTRIM('" + P_I_V_FIRST_NAME
				+ "')) || RTRIM(LTRIM('" + P_I_V_LAST_NAME
				+ "')), '*', '*', 'Y', 60, 'N', 'WEBREGIST', TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')), TO_NUMBER(TO_CHAR(SYSDATE,'HH24MI')), 'WEBREGIST', TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')), TO_NUMBER(TO_CHAR(SYSDATE,'HH24MI')), 'A', 'R', NULL, NULL, 'C', TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')), 'N', 'Y', 'N','"
				+ P_I_V_EMAIL + "', NULL, '" + P_I_V_CMP_NAME + "','" + P_I_V_ADDRESS1 + "', '" + P_I_V_ADDRESS2 + "','"
				+ P_I_V_ADDRESS3 + "', '" + P_I_V_ADDRESS4 + "','" + P_I_V_CITY + "','" + P_I_V_STATE + "','" + P_I_V_COUNTRY
				+ "','" + P_I_V_PHONENO + "','" + P_I_V_FAXNO + "', SYSDATE )";
		
		jdbcTemplate.update(sqlQry);
		String sqlQry2 =" INSERT INTO SEALINER.ESM_USER_PWD (USER_ID, PWD) VALUES (UPPER(LTRIM(RTRIM('"+P_I_V_USR_ID+"'))),'"+ P_I_V_PASSWORD+"')";
		jdbcTemplate.update(sqlQry2);
		
		

		String sqlQry3 = "INSERT INTO SEALINER.PR_PRSN_ROLE (SYSLVL1,SYSLVL2,SYSLVL3,PRSN_LOG_ID,ROLE_CD,PERSON_ROLE_ID,DESCR,AUSR,ADAT,CUSR,CDAT,RCST)"+
	   "(SELECT 'R','*','***',UPPER(LTRIM(RTRIM('"+P_I_V_USR_ID+"'))),ROLE_CD,0,DESCR,'WEBREGIST',SYSDATE,NULL,NULL,'S'"+
	     " FROM SEALINER.SC_ROLE WHERE ROLE_CD IN ("+V_ROLE_CD+"))";
		
		jdbcTemplate.update(sqlQry3);

	return "";
	}
}
