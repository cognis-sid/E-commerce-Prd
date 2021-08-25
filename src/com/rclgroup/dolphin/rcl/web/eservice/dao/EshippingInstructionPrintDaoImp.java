package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.dao.AncestorJdbcDao;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EReportServerConfigMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingStructionPrintMod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EshippingInstructionPrintDaoImp  extends AncestorJdbcDao implements EshippingInstructionPrintDao{

    private InsertStoreProcedure insertStoreProcedure;
    public EshippingInstructionPrintDaoImp() {
    }    
    
    protected void initDao() throws Exception {
        super.initDao();
        insertStoreProcedure = new InsertStoreProcedure(getJdbcTemplate());
    }
    
    protected class InsertStoreProcedure extends StoredProcedure {
    private static final String STORED_PROCEDURE_NAME = "RCLAPPS.PCR_DEX_BL_PRINT.PR_BL_PRINT";
    protected  InsertStoreProcedure(JdbcTemplate jdbcTemplate) {
            super(jdbcTemplate, STORED_PROCEDURE_NAME);
           System.out.println("InsertStoreProcedure declare parameter begin");
            declareParameter(new SqlParameter("p_ser", Types.VARCHAR));
            declareParameter(new SqlParameter("p_ves", Types.VARCHAR));
            declareParameter(new SqlParameter("p_voy", Types.VARCHAR));
            declareParameter(new SqlParameter("p_dir", Types.VARCHAR));
            declareParameter(new SqlParameter("p_off", Types.VARCHAR));
            declareParameter(new SqlParameter("p_bl", Types.VARCHAR));
            declareParameter(new SqlParameter("p_cocsoc", Types.VARCHAR));
            declareParameter(new SqlParameter("p_print", Types.VARCHAR));
            declareParameter(new SqlParameter("p_pol_sts", Types.VARCHAR));
            declareParameter(new SqlParameter("p_dte_frm", Types.VARCHAR));
            declareParameter(new SqlParameter("p_dte_to", Types.VARCHAR));
            declareParameter(new SqlParameter("p_third", Types.VARCHAR));    
            declareParameter(new SqlParameter("p_fsc", Types.VARCHAR));
            declareParameter(new SqlParameter("p_usr", Types.VARCHAR));
            declareParameter(new SqlInOutParameter("p_sid", Types.VARCHAR));        
            declareParameter(new SqlParameter("p_l_code", Types.VARCHAR));
            declareParameter(new SqlParameter("p_r_code", Types.VARCHAR));
            declareParameter(new SqlParameter("p_a_code", Types.VARCHAR));
            declareParameter(new SqlParameter("p_fsc_code", Types.VARCHAR));
            
          //  declareParameter(new SqlOutParameter("p_cur_temp", OracleTypes.CURSOR));
          //  declareParameter(new SqlOutParameter("p_sysdate", Types.VARCHAR));     
            compile();
            System.out.println("InsertStoreProcedure declare parameter end");
        }
    protected String insert(      String service  ,           String vessel,            String voyage,     String direction, 
                                                       String offCreateBL ,   String bl,                    String cocsoc,      String print,
                                                       String pol_sts,             String dateFrom,      String dateTo,      String third,
                                                       String fsc,                     String userCode,     String sessionid,  String line,
                                                       String region,              String agent,             String fscCode  ) {
                                                       
        return insertPro(                service  ,                       vessel,                       voyage,                  direction, 
                                                       offCreateBL ,                bl,                               cocsoc,                   print,
                                                       pol_sts,                          dateFrom,                 dateTo,                   third,
                                                       fsc,                                  userCode,                sessionid,               line,
                                                      region,                            agent,                        fscCode   );
    }
    protected String insertPro(String service  ,          String vessel,            String voyage,     String direction, 
                                                       String offCreateBL ,   String bl,                    String cocsoc,      String print,
                                                       String pol_sts,             String dateFrom,      String dateTo,      String third,
                                                       String fsc,                     String userCode,     String sessionid,  String line,
                                                       String region,              String agent,             String fscCode  ) {
            System.out.println("InsertStoreProcedure assign value to  parameter begin");
            
            String sessionId = "";
            
            Map inParameters = new HashMap();
            inParameters.put("p_ser",FormatUtil.stringToDb(service));
            inParameters.put("p_ves",FormatUtil.stringToDb(vessel));
            inParameters.put("p_voy",FormatUtil.stringToDb(voyage));
            inParameters.put("p_dir",FormatUtil.stringToDb(direction));
            inParameters.put("p_off",FormatUtil.stringToDb(offCreateBL));
            inParameters.put("p_bl",FormatUtil.stringToDb(bl));
            inParameters.put("p_cocsoc",FormatUtil.stringToDb(cocsoc));
            inParameters.put("p_print",FormatUtil.stringToDb(print));
            inParameters.put("p_pol_sts",FormatUtil.stringToDb(pol_sts));
            inParameters.put("p_dte_frm",FormatUtil.stringToDb(dateFrom));
            inParameters.put("p_dte_to",FormatUtil.stringToDb(dateTo));             
            inParameters.put("p_third",FormatUtil.stringToDb(third));      
            inParameters.put("p_fsc",FormatUtil.stringToDb(fsc));
            inParameters.put("p_usr",FormatUtil.stringToDb(userCode));
            inParameters.put("p_sid",FormatUtil.stringToDb(sessionid));
            inParameters.put("p_l_code",FormatUtil.stringToDb(line));
            inParameters.put("p_r_code",FormatUtil.stringToDb(region));
            inParameters.put("p_a_code",FormatUtil.stringToDb(agent));
            inParameters.put("p_fsc_code",FormatUtil.stringToDb(fscCode));      
    
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_ser = "+inParameters.get("p_ser"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_ves = "+inParameters.get("p_ves"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_voy = "+inParameters.get("p_voy"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_dir = "+inParameters.get("p_dir"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_off = "+inParameters.get("p_off"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_bl = "+inParameters.get("p_bl"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_cocsoc = "+inParameters.get("p_cocsoc"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_print = "+inParameters.get("p_print"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_pol_sts = "+inParameters.get("p_pol_sts"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_dte_frm = "+inParameters.get("p_dte_frm"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_dte_to = "+inParameters.get("p_dte_to"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_third = "+inParameters.get("p_third"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_fsc = "+inParameters.get("p_fsc"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_usr = "+inParameters.get("p_usr"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_sid = "+inParameters.get("p_sid"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_l_code = "+inParameters.get("p_l_code"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_r_code = "+inParameters.get("p_r_code"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_a_code = "+inParameters.get("p_a_code"));
            System.out.println("[DexBillOfLandingPrintJdbcDao][InsertStoreProcedure][insert]: p_fsc_code = "+inParameters.get("p_fsc_code"));
            
          /*  System.out.println("InsertStoreProcedure assign value to  parameter end");*/
            Map outParameters = execute(inParameters);
            if (outParameters.size() > 0) {
               sessionId = FormatUtil.dbToString(outParameters, "p_sid");
               System.out.println("  p_sid >>>>>>>>>>>>> "+sessionId);
            }
            return sessionId;
        }          
    } 
    
    public String  getSessionId(String service  ,          String vessel,            String voyage,     String direction, 
                                                       String offCreateBL ,   String bl,                    String cocsoc,      String print,
                                                       String pol_sts,             String dateFrom,      String dateTo,      String third,
                                                       String fsc,                     String userCode,     String sessionid,  String line,
                                                       String region,              String agent,             String fscCode    )throws DataAccessException {
                                                         
    return insertStoreProcedure.insert(    service  ,         vessel,         voyage,     direction, 
                                                                         offCreateBL ,  bl,                cocsoc,      print,
                                                                         pol_sts,            dateFrom,  dateTo,      third,
                                                                         fsc,                    userCode,  sessionid,  line,
                                                                         region,             agent,          fscCode );
     }
    
    public Vector getListBLPrint(String session, String userName) throws DataAccessException{
        System.out.println("[EshippingInstructionPrintDaoImp][getListBLPrint]");
        System.out.println("[EshippingInstructionPrintDaoImp][getListBLPrint]: With status: sesseion "+session);
        System.out.println("[EshippingInstructionPrintDaoImp][getListBLPrint]: With status: userName "+userName);
        StringBuffer sql = new StringBuffer();
        HashMap map = new HashMap();
            
        Vector manifestPrintVec = new Vector();
        
        EshippingStructionPrintMod eshippingStructionPrintMod = null;

        sql.append("SELECT DISTINCT  ");
        sql.append("   BLNO");
        sql.append(" , (SELECT CYNAME FROM RCLAPPS.DEX_BL_PRI_CUS WHERE CUSFLAG = 1 AND DEX_BL_PRI_CUS.BLNO = DEX_BL_PRI.BLNO AND ROWNUM = 1) SHIPPERNAME");
        sql.append(" ,  PLA_OF_ISSUE");
        sql.append(" , OFF_OR_FSC AS OFFICE");
        sql.append(" , BLCDTEC");
        sql.append(" , COCSOC ");
        sql.append(" ,  BLSTATUSDESC ");
        sql.append(" , DES_PRI ");
        sql.append(" , SESSIONID ");
        sql.append(" , USERNAME ");
        sql.append(" FROM RCLAPPS.DEX_BL_PRI ");
        sql.append(" WHERE SESSIONID = :sesseion ");
        sql.append(" AND USERNAME = :userName ");
        sql.append(" ORDER BY BLNO,BLCDTEC ");
        
        map.put("sesseion",session);
        map.put("userName",userName);
        System.out.println(sql.toString());
        System.out.println("[EshippingInstructionPrintDaoImp][getListManifestPrint]: ");
        System.out.println("[EshippingInstructionPrintDaoImp][getListManifestPrint]: Finished");
        
        SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(),map); 
     
        while (rs.next()){
            eshippingStructionPrintMod = new EshippingStructionPrintMod();
            eshippingStructionPrintMod.setSessionId(FormatUtil.nullToStr(rs.getString("SESSIONID")));
            eshippingStructionPrintMod.setBlNo(FormatUtil.nullToStr(rs.getString("BLNO")));
            eshippingStructionPrintMod.setShipperName(FormatUtil.nullToStr(rs.getString("SHIPPERNAME")));
            eshippingStructionPrintMod.setPla_of_issue(FormatUtil.nullToStr(rs.getString("PLA_OF_ISSUE")));
            eshippingStructionPrintMod.setOffice(FormatUtil.nullToStr(rs.getString("OFFICE")));
            eshippingStructionPrintMod.setBlcdtec(FormatUtil.nullToStr(rs.getString("BLCDTEC")));
            eshippingStructionPrintMod.setCocsoc(FormatUtil.nullToStr(rs.getString("COCSOC")));
            eshippingStructionPrintMod.setBlstatus(FormatUtil.nullToStr(rs.getString("BLSTATUSDESC")));
            eshippingStructionPrintMod.setPrinted(FormatUtil.nullToStr(rs.getString("DES_PRI")));
            eshippingStructionPrintMod.setUserName(FormatUtil.nullToStr(rs.getString("USERNAME")));
            
            manifestPrintVec.add(eshippingStructionPrintMod);
        }
        return manifestPrintVec;
        
    }
    
    
    
    
        
    
        public EReportServerConfigMod getDefaultReportServerConfigMod() {
			/*
			 * EReportServerConfigMod reportServerConfigMod = null;
			 * 
			 * StringBuffer sql = new StringBuffer(); sql.append("select SERVER_NAME ");
			 * sql.append("    ,PORT_NUMBER ");
			 * sql.append("from RCLTBLS.VR_RCM_REPORT_SERVER_CONFIG ");
			 * 
			 * try { reportServerConfigMod = (EReportServerConfigMod)
			 * getNamedParameterJdbcTemplate().queryForObject( sql.toString(), new
			 * HashMap(), new RowMapper() { public Object mapRow(ResultSet rs, int rowNum)
			 * throws SQLException { EReportServerConfigMod bean = new
			 * EReportServerConfigMod();
			 * bean.setServerName(FormatUtil.nullToStr(rs.getString("SERVER_NAME")));
			 * bean.setPortNumber(FormatUtil.nullToStr(rs.getString("PORT_NUMBER"))); return
			 * bean; } } ); } catch (EmptyResultDataAccessException e) {
			 * reportServerConfigMod = null; }
			 */
            
            return null;
        }
    
    
        public Vector getListBKGPrint(String blNumber) throws DataAccessException{
            System.out.println("[EshippingInstructionPrintDaoImp][getListBKGPrint]");
            System.out.println("[EshippingInstructionPrintDaoImp][getListBKGPrint]: With status: blNumber "+blNumber);

            StringBuffer sql = new StringBuffer();
            HashMap map = new HashMap();
                
            Vector manifestPrintVec = new Vector();
         
            EshippingStructionPrintMod eshippingStructionPrintMod = null;
            try {
            

                
            sql.append("SELECT FK_BL_NO as BL_NO ");
            sql.append("  , 'BKG NO: ' || FK_BOOKING_NO as BKG_NO ");
            sql.append("  , DN_SHIPPER_CODE, SHIPPER_NAME , SHIPPER_ADD1 , SHIPPER_ADD2, SHIPPER_ADD3 , SHIPPER_ADD4 ");
            sql.append("  , DN_CNEE_CODE , CNEE_NAME, CNEE_ADD1 , CNEE_ADD2 , CNEE_ADD3 , CNEE_ADD4 ");
            sql.append(" , DN_NTFY_CODE , NTFY_NAME , NTFY_ADD1  , NTFY_ADD2 , NTFY_ADD3  , NTFY_ADD4 ");
             sql.append(" , VESSEL_NAME  , VOYAGE_NO   " );
         //   sql.append(" CASE   WHEN VESSEL_NAME is null THEN ' ' ELSE VESSEL_NAME END  AS VESSEL_NAME, " );
        //    sql.append(" CASE   WHEN VOYAGE_NO is null THEN ' ' ELSE VOYAGE_NO END  AS VOYAGE_NO,  " );          
            sql.append("  ,POL_NAME, POD_NAME , PLR_NAME, PLD_NAME ");
          // sql.append(", TO_CHAR(ROWNUM) as ITEM_NO , COMM_LVL_MARKS_NO, COMM_LVL_DESC, BL_ISSUE_PLACE_NAME ");
           sql.append(", TO_CHAR(ROWNUM) as ITEM_NO ,TO_CHAR(COMM_LVL_DESC), BL_ISSUE_PLACE_NAME ");
         //   sql.append(" , BL_ISSUE_PLACE_NAME ");
       //     sql.append(", (SELECT TO_CHAR(TO_DATE(SAIL_RECEIPT_DATE,'YYYYMMDD'),'DD/MM/YYYY') ");
        //    sql.append(" FROM IDP010 WHERE AYBLNO IN (SELECT FK_BL_NO FROM VASAPPS.ERCL_SI_HEADER WHERE FK_BOOKING_NO = :blNumber)) as SHIPPED_ON_BOARD_DATE ");
          //  sql.append(" , (SELECT TO_CHAR(TO_DATE(BL_ISSUE_DATE,'YYYYMMDD'),'DD/MM/YYYY') ");
     //       sql.append("  FROM IDP010 WHERE AYBLNO IN (SELECT FK_BL_NO FROM VASAPPS.ERCL_SI_HEADER WHERE FK_BOOKING_NO = :blNumber)) as BL_ISSUE_DATE ");
            sql.append(" ,  ORG_BL_COUNT ");
            sql.append(" , (SELECT CRCONM from ITP188, BKP001 WHERE CRCNTR = POL_FSC AND BABKNO =  FK_BOOKING_NO) as BY_FSC_NAME ");
            
            //@01 BEGIN 15/08/2013  TANA change name table 
            sql.append(" FROM VASAPPS.ESV_SI_HEADER HDR ");
            //@01 END
            
            sql.append(" WHERE FK_BOOKING_NO = :blNumber ");

            map.put("blNumber",blNumber);
            map.put("blNumber",blNumber);

            
                System.out.println(sql.toString());
                SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(),map); 
                while (rs.next()){
                    eshippingStructionPrintMod = new EshippingStructionPrintMod();
                    
                    
                    manifestPrintVec.add(eshippingStructionPrintMod);
                }
            } catch (EmptyResultDataAccessException e) {
                    manifestPrintVec = null;
                    e.printStackTrace();
                    System.out.println("error >>>>>>>>>>>>> "+e.getMessage());
                }
            return manifestPrintVec;
            
        }
    
    }
    
