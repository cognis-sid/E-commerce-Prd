 /*------------------------------------------------------
  EserviceUserPortPairLookUpDaoImpl.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 11/09/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
 package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePortClassMod;

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

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUserPortPairLookUpUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceSailingSchedulePopupMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUserPortPairLookUpMod;


/**
 * Class for DAO
 * @class EservicePortClassDaoImpl
 * @author NTL) Pratya
 * @version v1.00 2014/08/08
 * @see
 */
 public class EserviceUserPortPairLookUpDaoImpl extends AncestorJdbcDao implements EserviceUserPortPairLookUpDao {

     public Map getUserPortPairList(EserviceUserPortPairLookUpUim form) {
        System.out.println("[EserviceUserPortPairLookUpDaoImpl][getHuaLageList][Begin]");
        
        JdbcStoredProcedure                 storeProcedure  = null;
        Map                                 resultMap       = null;
        String[][]                          arrParams       = null;
        String                              errorMsg        = null;
        List<EserviceUserPortPairLookUpMod> lst             = null;
        String                              find            = null;
        String                              column          = null;
        String                              sortby          = null;
        String                              order           = null;
        String                              wildcard        = null;
        String                              userLoginId     = null;
        Map                                 amap            = null;
        
        try{
            amap            = new HashMap();
            find            = FormatUtil.nullToBlank(form.getFind());
            column          = FormatUtil.nullToBlank(form.getColumn());
            sortby          = FormatUtil.nullToBlank(form.getSortBy());
            order           = FormatUtil.nullToBlank(form.getOrder());
            wildcard        = FormatUtil.nullToBlank(form.getChkBoxWildCard());
            userLoginId     = FormatUtil.nullToBlank(form.getUserLoginId());
            
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] find                    :: " + find);
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] column                  :: " + column);
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] sortby                  :: " + sortby);
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] order                   :: " + order);
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] wildcard                :: " + wildcard);
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] userLoginId             :: " + userLoginId);
            
            arrParams = new String[][]{
                                        {P_I_V.COL_NAME              , BLANK+ORACLE_VARCHAR      , PARAM_IN  , column},
                                        {P_I_V.COL_VAL               , BLANK+ORACLE_VARCHAR      , PARAM_IN  , find},
                                        {P_I_V.SORT_BY               , BLANK+ORACLE_VARCHAR      , PARAM_IN  , sortby},
                                        {P_I_V.ORDER_BY              , BLANK+ORACLE_VARCHAR      , PARAM_IN  , order},
                                        {P_I_V.WILD_CARD             , BLANK+ORACLE_VARCHAR      , PARAM_IN  , wildcard},
                                        {P_I_V.USR_ID                , BLANK+ORACLE_VARCHAR      , PARAM_IN  , userLoginId},
                                        {P_O_V.CONTRACT_PARTY_DATA   , BLANK + ORACLE_CURSOR     , PARAM_OUT , BLANK},
                                        {P_O_V.ERROR                 , BLANK + ORACLE_VARCHAR    , PARAM_OUT , BLANK}
                                    };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_USER_PORT_PAIR, new EserviceUserPortPairLookUpRowMapper(), arrParams);
            
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] storeProcedure :: " + storeProcedure);
            
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    lst             = (List<EserviceUserPortPairLookUpMod>) resultMap.get(P_O_V.CONTRACT_PARTY_DATA);
                }
            }
            
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList] lst.size() :: " + lst.size());
            
            amap.put(KEY_DATA, lst);
            amap.put(KEY_SIZE, lst.size());
            
        }catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
        }finally{
            System.out.println("[EserviceUserPortPairLookUpDaoImpl][getUserPortPairList][End]");
        }
        return amap;
    }
    
    private class EserviceUserPortPairLookUpRowMapper extends JdbcRowMapper{
        public EserviceUserPortPairLookUpRowMapper(){}
    
        public Object mapRow(ResultSet rs, int row) throws SQLException { 
            EserviceUserPortPairLookUpMod mod = new EserviceUserPortPairLookUpMod();
            try{    
                mod.setUserId           (FormatUtil.nullToBlank(rs.getString("FK_USER_ID")));
                mod.setUserName         (FormatUtil.nullToBlank(rs.getString("USER_NAME")));
                mod.setCompanyName      (FormatUtil.nullToBlank(rs.getString("USER_COMPANY_NAME")));
                mod.setContractCompany  (FormatUtil.nullToBlank(rs.getString("CONTRACT_COMPANY")));
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
