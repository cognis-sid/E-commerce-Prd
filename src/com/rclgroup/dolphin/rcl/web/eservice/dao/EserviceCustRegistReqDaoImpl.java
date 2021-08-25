 /* -----------------------------------------------------------------------------
  System  : RCLEAPPS
  Module  : Eservice
  Prog ID : ESER008 - EserviceCommodityPopupDaoImpl.java
  Name    : New Web Booking
  Purpose : DAO Class for EserviceCommodityPopupDao Interface
  --------------------------------------------------------------------------------
  History : None
  --------------------------------------------------------------------------------
  Author          Date            What
  --------------- --------------- ------------------------------------------------
  NTL)Vikas         24/04/2013      <Initial version>
  --Change Log--------------------------------------------------------------------
  ## DD/MM/YY –User- -Task/CR No- -Short Description-
  ##11/07/2013        01             add SQL for get commodity data
  ----------------------------------------------------------------------------- */
 package com.rclgroup.dolphin.rcl.web.eservice.dao;

 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Types;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import org.springframework.dao.DataAccessException;
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.jdbc.core.RowMapper;
 import org.springframework.jdbc.core.SqlInOutParameter;
 import org.springframework.jdbc.core.SqlOutParameter;
 import org.springframework.jdbc.object.StoredProcedure;

 import com.niit.control.common.exception.BusinessException;
 import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCustRegistReqMod;


 /**
  * Class for DAO
  * @class EserviceCommodityPopupDaoImpl
  * @author NTL) Vikas
  * @version v1.00 2013/04/29
  * @see
  */
 public class EserviceCustRegistReqDaoImpl extends AncestorJdbcDao implements EserviceCustRegistReqDao {

    public Map findCustRegistReq(String fscCode) throws BusinessException, DataAccessException{
        JdbcStoredProcedure storeProcedure = null;
        
        Map resultMap = null;
        
        String[][] arrParams = null;
        
        String errorMsg = null;
        try{
            arrParams = new String[][]{
                {P_I_V.FSC, BLANK+ORACLE_VARCHAR, PARAM_IN, fscCode},
                {P_O_V.LIST_CUST_REQ_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK}
            };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_CUST_REGIST_REQ, new EserviceCustRegistReqRowMapper(), arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
            }
        }catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
        }finally{
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap = new HashMap();
                resultMap.put(P_O_V.ERR_CD, "EXCEPTION");
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
        }
        return resultMap;
    }
    
//     public static String sanitizeURLString(String av_val){
//             
//         System.out.println("[EserviceCustRegistReqDaoImpl][sanitizeURLString][Begin]");
//         String[]    la_symbol   = {"%" , "<" , ">" , "#" , "{" , "}" , "|" , "\\" , "^" , "~" , "[" , "]" , "`" , ";" , "/" , "?" , ":" , "@" , "=" , "&" , "$"};
//         String[]    la_replace  = {"%25", "%3C", "%3E", "%23", "%7B", "%7D", "%7C", "%5C", "%5E", "%7E", "%5B", "%5D", "%60", "%3B", "%2F", "%3F", "%3A", "%40", "%3D", "%26", "%24"};
//         String      lv_return   = null;
//         
//         try{
//             
//                 lv_return = av_val;
//                 
//             for(int i=0;i<la_symbol.length;i++){
//                 if(av_val.indexOf(la_symbol[i]) > -1){
//                         
//                     lv_return = lv_return.replaceAll("\\" + la_symbol[i], la_replace[i]);
//                 }
//             }
//                         
//         }catch(Exception e){
//             e.printStackTrace();
//         }finally{
//             System.out.println("[EserviceCustRegistReqDaoImpl][sanitizeURLString][End]");
//         }
//         
//         return lv_return;
//     }
    
    private class EserviceCustRegistReqRowMapper extends JdbcRowMapper{
        public EserviceCustRegistReqRowMapper(){}
    
        public Object mapRow(ResultSet rs, int row) throws SQLException { 
            EserviceCustRegistReqMod mod = new EserviceCustRegistReqMod();
            try{    
                mod.setCompanyName  (rs.getString("COMPANY_NAME"));
                mod.setCountry      (rs.getString("COUNTRY"));
                mod.setCity         (rs.getString("CITY"));
                mod.setUserId       (FormatUtil.sanitizeURLString(rs.getString("USER_ID")));
                mod.setUserName     (rs.getString("USER_NAME"));
                mod.setAddDate      (rs.getString("RECORD_ADD_DATE"));
                mod.setAddTime      (rs.getString("RECORD_ADD_TIME"));
                mod.setAddDateTime  (rs.getString("REQUESTED_DT"));
                mod.setCountryName  (rs.getString("COUNTRY_NAME"));
                mod.setPortPairFlag (rs.getString("PORT_PAIR_FLAG"));
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return mod;
        }
    }
               
     private JdbcStoredProcedure getStoreProcedure(String procName, JdbcRowMapper rowMapper, String[][] arrParam) {
         JdbcStoredProcedure storeProcedure = null;
         try{
             if(rowMapper != null){
                 if(arrParam != null){
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper, arrParam);
                 }else{
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper);
                 }
             }else{
                 if(arrParam != null){
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, arrParam);
                 }else{
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName);
                 }
             }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return storeProcedure;
     }
 } // end of class
