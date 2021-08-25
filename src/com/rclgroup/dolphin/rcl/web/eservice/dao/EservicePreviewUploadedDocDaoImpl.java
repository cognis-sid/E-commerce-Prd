/* -----------------------------------------------------------------------------
System  : RCLEAPPS
Module  : Common
Prog ID : ESER008 - EservicePreviewUploadedDocDaoImpl.java
Name    : New Web Booking
Purpose : DAO Class for EservicePreviewUploadedDocDao Interface
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
Pratya         29/08/2014      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.Debug;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.common.exception.ExceptionFactory;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePreviewUploadedDocUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePreviewUploadedDocMod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/** 
 * Class for DAO
 * @class EserviceNewWebBookingDaoImpl
 * @author NTL) Vikas
 * @version v1.00 2013/04/29
 * @see
 */
public class EservicePreviewUploadedDocDaoImpl extends AncestorJdbcDao implements EservicePreviewUploadedDocDao {

    public EservicePreviewUploadedDocDaoImpl() {
        
    }
    
     public void setUploadListDetail(EservicePreviewUploadedDocUim form){
         System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail][Begin]");
         Map                             map                                     = new HashMap(0);
         List                            dataList                                = null;
         String                          bookingNo                               = null;
         String                          bookingDateFrom                         = null;
         String                          bookingDateTo                           = null;
         String                          bookingDateBy                           = null;
         String                          sortBy                                  = null;
         String                          orderBy                                 = null;
         String                          userId                                  = null;
         
         try{
             bookingNo              = form.getBookingNo().trim();
             bookingDateFrom        = FormatUtil.dateFormat(form.getBookingDateFrom(), "dd/MM/yyy", "yyyyMMdd").trim();
             bookingDateTo          = FormatUtil.dateFormat(form.getBookingDateTo(), "dd/MM/yyy", "yyyyMMdd").trim();
             bookingDateBy          = form.getBookingDateBy().trim();
             sortBy                 = form.getSortBy();
             orderBy                = form.getOrderBy();
             userId                 = form.getUserId();
             
             System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] bookingNo :: "        + bookingNo);
             System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] bookingDateFrom :: "  + bookingDateFrom);
             System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] bookingDateTo :: "    + bookingDateTo);
             System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] bookingDateBy :: "    + bookingDateBy);
             System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] sortBy :: "           + sortBy);
             System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] orderBy :: "          + orderBy);
             System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] userId :: "        + userId);
             
             String[][] arrParam        = { 
                                             { "P_O_V_UPLOAD_LIST"       , BLANK+ORACLE_CURSOR   , PARAM_OUT     , BLANK }, 
                                             { "P_I_V_BKG_NO"            , BLANK+ORACLE_VARCHAR  , PARAM_IN      , bookingNo }, 
                                             { "P_I_V_BKG_DATE_FROM"     , BLANK+ORACLE_VARCHAR  , PARAM_IN      , bookingDateFrom },
                                             { "P_I_V_BKG_DATE_TO"       , BLANK+ORACLE_VARCHAR  , PARAM_IN      , bookingDateTo },
                                             { "P_I_V_BOOKED_BY"         , BLANK+ORACLE_VARCHAR  , PARAM_IN      , bookingDateBy },
                                             { "P_I_V_SORT_BY"           , BLANK+ORACLE_VARCHAR  , PARAM_IN      , sortBy },
                                             { "P_I_V_ORDER_BY"          , BLANK+ORACLE_VARCHAR  , PARAM_IN      , orderBy },
                                             { "P_I_V_USER_ID"           , BLANK+ORACLE_VARCHAR  , PARAM_IN      , userId }
                                           };
                                           
                     map.put(KEY_PROC_NAME       , "PCR_ESV_WEB_BKG.PRR_ESV_GET_UPLOAD_LIST");
                     map.put(KEY_MAPPER_CLASS    , new UploadListRowMapper());
                     map.put(KEY_PROC_PARAMS     , arrParam);

                     map         = executeDbProcedure(map);
                     dataList    = (List) ((Map) map.get(KEY_PROCE_EXCECTION_RESULT_MAP)).get("P_O_V_UPLOAD_LIST");
                     
                     System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] dataList :: " + dataList);
                     if(dataList!=null){
                         System.out.println("[EservicePreviewUploadedDocDaoImpl][setUploadListDetail] dataList.size() :: " + dataList.size());
                         form.setSearchResultsList(dataList);
                         
                     }else{
                         form.setSearchResultsList(null);
                     }
                     
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             System.out.println("[EserviceInquiryWebBookingDaoImpl][setUploadListDetail][End]");
         }
         
         
     }
    
     /**
      * This Mehtod is used to execute DB procedure and return result.
      * 
      * @param arrParameters: Map containes the parameter to execute 
      * procecure 
      * @return Data from database.
      * @throws BusinessException
      * @throws DataAccessException
      */
     public Map executeDbProcedure(Map arrParameters) throws BusinessException, DataAccessException{


         try{
             /* Stored procedure object */
             JdbcStoredProcedure lobjSP = null;

             /* Return Result from SP execute */
             Map lmapResult = null;

             /* Stores return error code from SP */
             String lstrRetError = null;

             /* Create JDBC Stored Procedure Object */
             if(arrParameters.containsKey(KEY_MAPPER_CLASS)){
                 lobjSP = new JdbcStoredProcedure(getDataSource(), (String) arrParameters.get(KEY_PROC_NAME), (JdbcRowMapper) arrParameters.get(KEY_MAPPER_CLASS), (String[][]) arrParameters.get(KEY_PROC_PARAMS));

             } else {
                 lobjSP = new JdbcStoredProcedure(getDataSource(), (String) arrParameters.get(KEY_PROC_NAME), (String[][]) arrParameters.get(KEY_PROC_PARAMS));
             }
             Debug.log("PROCEDURE:=> "+(String) (String) arrParameters.get(KEY_PROC_NAME));
             if("PCR_ESV_NEW_WEB_BOOKING.PRE_GET_PLACE_OF_RECEIPT".equals((String) (String) arrParameters.get(KEY_PROC_NAME))){
                 Debug.log("PROCEDURE:=> "+(String) (String) arrParameters.get(KEY_PROC_NAME));
             }
             /* Execute the SP & Get the Return Output values as Map */
             lmapResult = lobjSP.execute();

             /* Read the Return code from SP */
             if(lmapResult.containsKey(KEY_ERROR_DATA)){

                 lstrRetError = (String) lmapResult.get(KEY_ERROR_DATA);
                 //System.out.println("lstrRetError >>>>>>>>>>>>> "+lstrRetError);
                 /* If return error code is Failure, throw Business Exception */
                 if(isErrorCode(lstrRetError)){
                     String[][] lstrarrProcParameters = (String[][]) arrParameters.get(KEY_PROC_PARAMS);
                     Debug.logFramework("Error while calling procedure :: "+(String) arrParameters.get(KEY_PROC_NAME));
                     Debug.logFramework("With Parameters :: "+NEWLINE);
                     for(int i = 0; i<lstrarrProcParameters.length; i++){
                         Debug.logFramework(lstrarrProcParameters[i][0]+" :: "+lstrarrProcParameters[i][3]+NEWLINE);
                     }
                     throw ExceptionFactory.createApplicationException(lstrRetError);
                 }
             }

             //        for(Object key : lmapResult.keySet()){
             //            System.out.println("lmapResult    key : " + key + " , value : " + lmapResult.get(key));
             //        }

             arrParameters.put(KEY_PROCE_EXCECTION_RESULT_MAP, lmapResult);
         } catch(Exception e){
             e.printStackTrace();
         }
         return arrParameters;
     } // executeDbProcedure
    
     private JdbcStoredProcedure getStoreProcedure(String procName, JdbcRowMapper rowMapper, String[][] arrParam){
         JdbcStoredProcedure storeProcedure = null;
         try{
             if(rowMapper!=null){
                 if(arrParam!=null){
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper, arrParam);
                 } else {
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper);
                 }
             } else {
                 if(arrParam!=null){
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, arrParam);
                 } else {
                     storeProcedure = new JdbcStoredProcedure(getDataSource(), procName);
                 }
             }
         } catch(Exception ex){
             ex.printStackTrace();
         }
         return storeProcedure;
     }
    
    class UploadListRowMapper extends JdbcRowMapper{

        public Object mapRow(ResultSet rs, int row) throws SQLException{
            System.out.println("[UploadListRowMapper][mapRow][Begin]");
            
            String                              fileName                 = null;
            String                              newFileName              = null;
            String[]                            fileNameArray            = null;
            EservicePreviewUploadedDocMod       mod                      = null;
            
            try{
                mod                 = new EservicePreviewUploadedDocMod();
                fileNameArray       = rs.getString("FILE_NAME").split("::");
                fileName            = fileNameArray[0];
                newFileName         = fileNameArray[1];
                
                mod.setFileName(fileName);
                mod.setNewFileName(newFileName);
                
                mod.setPkUploadDtlSeq(rs.getString("PK_UPLOAD_DTL_SEQ"));
                mod.setUploadSeqNo(rs.getString("UPLOAD_SEQNO"));
                mod.setModule(rs.getString("MODULE"));
                mod.setRecAddUser(rs.getString("RECORD_ADD_USER"));
                mod.setRecAddDate(rs.getString("RECORD_ADD_DATE"));
                mod.setBookingNo(rs.getString("BOOKING_NO"));
                mod.setBookingDate(rs.getString("BOOKING_DATE"));
                mod.setBookingBy(rs.getString("BOOKED_BY"));
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                System.out.println("[UploadListRowMapper][mapRow][End]");
            }
            
            return mod; 
        } // mapRow     

    }
}
