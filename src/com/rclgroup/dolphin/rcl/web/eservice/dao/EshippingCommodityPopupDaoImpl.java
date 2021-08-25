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
 YOSSUN1         22/08/2013      <Initial version>
  --Change Log--------------------------------------------------------------------
  ## DD/MM/YY –User- -Task/CR No- -Short Description-
  ----------------------------------------------------------------------------- */
 package com.rclgroup.dolphin.rcl.web.eservice.dao;

 import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.ComboVO;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityPopupMod;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_SI_GET_COMMGRP_DDL;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_SI_GET_COMM_POPUP;
 /**
  * Class for DAO
  * @class EserviceCommodityPopupDaoImpl
  * @author YOSSUN1
  * @see
  */
 public class EshippingCommodityPopupDaoImpl extends AncestorJdbcDao implements EshippingCommodityPopupDao {


     public EshippingCommodityPopupDaoImpl() {
     }

     /**
      * Method called when page load
      * 
      * @param amapParam
      * @return
      * @throws BusinessException
      * @throws DataAccessException
      */
     public Map onLoad(Map amapParam) throws BusinessException, 
                                             DataAccessException {
         return amapParam;
     }

     public Map getList(Map map) throws BusinessException, 
                                              DataAccessException {
         System.out.println("[EshippingCommodityPopupDaoImpl][getList][Begin]");
         
         JdbcStoredProcedure                 objSP           = null;
         Map                                 mapResult       = null;
         List<EshippingCommodityPopupMod>    list            = null;
         Integer                            size            = null;
         String[][]                          arrParam        = null;
         String                              commGroupCode   = null;
         String                              commCode        = null;
         String                              commDesc        = null;
         String                              sortBy          = null;
         String                              orderBy         = null;
         String                              fromRecord      = null;
         String                              toRecord        = null;
         String                              chkBoxWildCard  = null;
         
         try{
             if(map != null){
                 commGroupCode   = (String) map.get(P_I_V.COMM_GROUP_CODE);
                 commCode        = (String) map.get(P_I_V.COMM_CODE);
                 commDesc        = (String) map.get(P_I_V.COMM_DESC);
                 sortBy          = (String) map.get(P_I_V.SORT_BY);
                 orderBy         = (String) map.get(P_I_V.ORDER_BY);
                 fromRecord      = (String) map.get(P_I_V.RECORD_START);
                 toRecord        = (String) map.get(P_I_V.RECORD_END);
                 chkBoxWildCard  = (String) map.get(P_I_V.WILDCARD);
             
                 arrParam = new String[][]{ 
                                             { P_O_V.DTL_DATA            , BLANK + ORACLE_CURSOR     , PARAM_OUT     , BLANK },       
                                             { P_I_V.COMM_GROUP_CODE     , BLANK + ORACLE_VARCHAR    , PARAM_IN      , commGroupCode},
                                             { P_I_V.COMM_CODE           , BLANK + ORACLE_VARCHAR    , PARAM_IN      , commCode},
                                             { P_I_V.COMM_DESC           , BLANK + ORACLE_VARCHAR    , PARAM_IN      , commDesc}, 
                                             { P_I_V.RECORD_START        , BLANK + ORACLE_VARCHAR    , PARAM_IN      , fromRecord}, 
                                             { P_I_V.RECORD_END          , BLANK + ORACLE_VARCHAR    , PARAM_IN      , toRecord}, 
                                             { P_I_V.SORT_BY             , BLANK + ORACLE_VARCHAR    , PARAM_IN      , sortBy},
                                             { P_I_V.ORDER_BY            , BLANK + ORACLE_VARCHAR    , PARAM_IN      , orderBy},
                                             { P_I_V.WILDCARD            , BLANK + ORACLE_VARCHAR    , PARAM_IN      , chkBoxWildCard},
                                             { P_O_V.TOTAL_ROW           , BLANK + ORACLE_NUMBER     , PARAM_OUT     , BLANK} 
                                         };
             
                // objSP       = new JdbcStoredProcedure(getDataSource(), PCR_ESV_SI_MAIN.PRR_ESV_SI_GET_COMM_POPUP, new EsiCommodityPopupRowMapper(), arrParam);
               //  mapResult   = objSP.execute();
               mapResult=new HashMap();  
               mapResult.put("P_I_V_COMM_GROUP_CODE", commGroupCode);
               mapResult.put("P_I_V_COMM_CODE", commCode);  
               mapResult.put("P_I_V_COMM_DESC", commDesc);
               mapResult.put("P_I_V_RECORD_START", fromRecord);
               mapResult.put("P_I_V_RECORD_END", toRecord);
               mapResult.put("P_I_V_SORT_BY", sortBy);
               mapResult.put("P_I_V_ORDER_BY", orderBy);
               mapResult.put("P_I_V_WILDCARD", chkBoxWildCard);
               
               PRR_ESV_SI_GET_COMM_POPUP proc =new PRR_ESV_SI_GET_COMM_POPUP(getJdbcTemplate(),mapResult);
               proc.executeDbProcedure();
               
                 if(mapResult != null){
                     list = (List<EshippingCommodityPopupMod>) mapResult.get(P_O_V.DTL_DATA);
                     if(list == null || list.isEmpty()){
                         list = new ArrayList<EshippingCommodityPopupMod>();
                     }
                     
                     if(mapResult.containsKey(P_O_V.TOTAL_ROW)){
                         size =   (Integer) mapResult.get(P_O_V.TOTAL_ROW);    
                     }else{
                         size = new Integer(0);
                     }
                 }else{
                     mapResult = new HashMap();
                 }
             }else{
                 mapResult = new HashMap();
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             if(mapResult == null){
                 mapResult = new HashMap();
             }
             mapResult.put(KEY_DATA, list);
             mapResult.put(KEY_SIZE, size);
             
             System.out.println("[EshippingCommodityPopupDaoImpl][getList][End]");
         }
         return mapResult;
     }

     public class EsiCommodityPopupRowMapper extends JdbcRowMapper {
         
         /**
          * 
          * This mothod for set data to booking data in each row.
          * 
          * @exception SQLException
          * @param rs List of commodity data
          * @param row Row of commodity data
          */
         public Object mapRow(ResultSet rs, int row) throws SQLException {
             EshippingCommodityPopupMod obj = new EshippingCommodityPopupMod();
             obj.setCommGrpDesc(rs.getString("COMM_GRP_DESC"));
             obj.setCommGrpCode(rs.getString("COMM_GRP_CODE"));
             obj.setCommDesc(rs.getString("COMM_DESC"));
             obj.setCommCode(rs.getString("COMM_CODE"));
             return obj;
         }    
     }
     
     
     public Map getComboCommodityGroup() throws BusinessException, DataAccessException {
         JdbcStoredProcedure objSP = null;
         
         Map mapResult = null;
         
         String[][] arrParam = null;
         try{        
             arrParam = new String[][]{ 
                     { P_O_V.DTL_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK }
                 };
               
            // objSP = new JdbcStoredProcedure(getDataSource(),  PCR_ESV_SI_MAIN.PRR_ESV_SI_GET_COMMGRP_DDL, new CommodityDetailsRowMapper(), arrParam);
           //  mapResult = objSP.execute(); 
             mapResult=new HashMap();
             PRR_ESV_SI_GET_COMMGRP_DDL proc=new PRR_ESV_SI_GET_COMMGRP_DDL(getJdbcTemplate(),mapResult);
             proc.executeDbProcedure();
             
         }catch(DataAccessException ex){
             throw ex;
         }
         return mapResult;
     }
     
     public class CommodityDetailsRowMapper extends JdbcRowMapper {
     
         public Object mapRow(ResultSet rs, int row) throws SQLException {
             ComboVO obj = new ComboVO();
             obj.setName(rs.getString(1));
             obj.setCode(rs.getString(2));
            
             return obj;
         }    
     }


 } // end of class
