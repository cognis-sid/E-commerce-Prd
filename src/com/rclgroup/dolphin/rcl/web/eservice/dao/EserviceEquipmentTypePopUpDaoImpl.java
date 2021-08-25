 /*------------------------------------------------------
  EserviceEquipmentTypePopUpDaoImpl.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 02/10/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
 package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentTypePopUpMod;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_EQUIP_TYPE;


/**
 * Class for DAO
 * @class EservicePortClassDaoImpl
 * @author NTL) Pratya
 * @version v1.00 2014/08/08
 * @see
 */
 public class EserviceEquipmentTypePopUpDaoImpl extends AncestorJdbcDao implements EserviceEquipmentTypePopUpDao {

     public Map getEquipmentTypeList(Map amap) throws BusinessException, DataAccessException {
        System.out.println("[EserviceEquipmentTypePopUpDaoImpl][getEquipmentTypeList][Begin]");
        
        JdbcStoredProcedure storeProcedure  = null;
        Map                 resultMap       = null;;
        String[][]          arrParams       = null;
        String              errorMsg        = null;
        List                lst             = null;
        String              find            = null;
        String              column          = null;
        String              sortby          = null;
        String              order           = null;
        String              wildcard        = null;
        
        try{
            
            find            = (String)amap.get(KEY_CRITERIA_TEXT_FIND);
            column          = (String)amap.get(KEY_CRITERIA_COLUMN);
            sortby          = (String)amap.get(KEY_CRITERIA_SORTBY);
            order           = (String)amap.get(KEY_CRITERIA_ORDER);
            wildcard        = (String)amap.get(KEY_CRITERIA_WILDCARD);
            
            arrParams = new String[][]{
                {P_O_V_DATA                 , BLANK + ORACLE_CURSOR , PARAM_OUT , BLANK},
                {P_I_V_COL_NAME             , BLANK+ORACLE_VARCHAR  , PARAM_IN  , column},
                {P_I_V_COL_VAL              , BLANK+ORACLE_VARCHAR  , PARAM_IN  , find},
                {P_I_V_SORT_BY              , BLANK+ORACLE_VARCHAR  , PARAM_IN  , sortby},
                {P_I_V_ORDER_BY             , BLANK+ORACLE_VARCHAR  , PARAM_IN  , order},
                {P_I_V_WILD_CARD            , BLANK+ORACLE_VARCHAR  , PARAM_IN  , wildcard},
                {P_I_V_KEY_SEARCH            , BLANK+ORACLE_VARCHAR  , PARAM_IN , "N"}
            };
        
            //storeProcedure = getStoreProcedure(PCR_ESV_WEB_BKG.PRR_ESV_GET_EQUIP_TYPE, new EserviceEquipmentTypeRowMapper(), arrParams);
            
            //System.out.println("[EserviceEquipmentTypePopUpDaoImpl][getEquipmentTypeList] storeProcedure :: " + storeProcedure);
            resultMap=new HashMap();
            resultMap.put("P_I_V_COL_NAME", column);
            resultMap.put("P_I_V_COL_VAL", find);
            resultMap.put("P_I_V_SORT_BY", sortby);
            resultMap.put("P_I_V_ORDER_BY", order);
            resultMap.put("P_I_V_WILD_CARD", wildcard);
            resultMap.put("P_I_V_KEY_SEARCH",  "N");
            
            PRR_ESV_GET_EQUIP_TYPE proc=new PRR_ESV_GET_EQUIP_TYPE(getJdbcTemplate(),resultMap);
            proc.executeDbProcedure();
            
            //if(storeProcedure != null){
                //resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    lst             = (List) resultMap.get(P_O_V_DATA);
                }
            //}
            
            System.out.println("[EserviceEquipmentTypePopUpDaoImpl][getEquipmentTypeList] lst :: " + lst);
            
//            if(lst==null){
//                lst = new ArrayList(0);
//            }
            
            System.out.println("[EserviceEquipmentTypePopUpDaoImpl][getEquipmentTypeList] lst.size() :: " + lst.size());
            
            amap.put(KEY_DATA, lst);
            amap.put(KEY_SIZE, lst.size());
            
        }catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
        }finally{
            System.out.println("[EserviceEquipmentTypePopUpDaoImpl][getEquipmentTypeList][End]");
        }
        return amap;
    }
    
    private class EserviceEquipmentTypeRowMapper extends JdbcRowMapper{
        public EserviceEquipmentTypeRowMapper(){}
    
        public Object mapRow(ResultSet rs, int row) throws SQLException { 
            EserviceEquipmentTypePopUpMod mod = new EserviceEquipmentTypePopUpMod();
            try{    
                mod.setCode(rs.getString("code"));
                mod.setDescription(rs.getString("descr"));
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
