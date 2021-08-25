 /*------------------------------------------------------
  EserviceManagePortPairDaoImpl.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 16/10/2014
 - Change Log -------------------------------------------
 ##     DD/MM/YY    �User-      -TaskRef-   -ShortDescription-
 01     15/12/15    Watchakorn                Change solution for Contract Party/Represented Company.
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceManagePortPairUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;

import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;
import com.rclgroup.dolphin.rcl.web.util.RutMessage;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;


public class EserviceManagePortPairDaoImpl extends AncestorJdbcDao implements EserviceManagePortPairDao{

    public String addContractPartyPortPair(EserviceContractPartyPortPairMod mod){
        System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair][Begin]");

        Map                     resultMap                       = null;
        JdbcStoredProcedure     storeProcedure                  = null;
        String[][]              arrParams                       = null;
        String                  resultMsg                        = null;
        String                  fkUserId                        = null;
        String                  fkContractPartyCode             = null;
        //##01 Begin
        // String                  contractPartyName               = null;
        // String                  fkPOL                           = null;
        // String                  fkPOD                           = null;
        // String                  effDate                         = null;
        // String                  expDate                         = null;
        String                  pwd                             = null;
        String                  reactPwd                        = null;
        //##01 End
        String                  recStatus                       = null;
        String                  userId                          = null;
        String                  flagPortPair                    = null;
        String                  contractCompany                 = null;

        try{

            fkUserId                = FormatUtil.nullToBlank(mod.getFkUserId()).toUpperCase();
            fkContractPartyCode     = FormatUtil.nullToBlank(mod.getFkContractPartyCode());
            //##01 Begin
            // contractPartyName       = FormatUtil.nullToBlank(mod.getContractPartyName());
            // fkPOL                   = FormatUtil.nullToBlank(mod.getFkPOL());
            // fkPOD                   = FormatUtil.nullToBlank(mod.getFkPOD());
            // effDate                 = FormatUtil.nullToBlank(mod.getEffDate()) == "" ? "":FormatUtil.dateFormat(mod.getEffDate(), "dd/MM/yyyy", "yyyyMMdd");
            // expDate                 = FormatUtil.nullToBlank(mod.getExpDate()) == "" ? "":FormatUtil.dateFormat(mod.getExpDate(), "dd/MM/yyyy", "yyyyMMdd");
            pwd                     = FormatUtil.nullToBlank(mod.getPwd());
            reactPwd                = FormatUtil.nullToBlank(mod.getReactPwd());
            pwd                     = EncryptDecryptUtil.convertStringToHex(pwd);
            reactPwd                = EncryptDecryptUtil.convertStringToHex(reactPwd);
            //##01 End
            recStatus               = FormatUtil.nullToBlank(mod.getRecStatus());
            userId                  = FormatUtil.nullToBlank(mod.getUserId()).toUpperCase();
            flagPortPair            = FormatUtil.nullToBlank(mod.getFlagPortPair());
            contractCompany         = FormatUtil.nullToBlank(mod.getContractCompany());

            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] fkUserId                :: " + fkUserId);
            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] fkContractPartyCode     :: " + fkContractPartyCode);
            //##01 Begin
            // System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] contractPartyName       :: " + contractPartyName);
            // System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] fkPOL                   :: " + fkPOL);
            // System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] fkPOD                   :: " + fkPOD);
            // System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] effDate                 :: " + effDate);
            // System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] expDate                 :: " + expDate);
            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] pwd                     :: " + pwd);
            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] reactPwd                :: " + reactPwd);
            //##01 End
            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] recStatus               :: " + recStatus);
            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] userId                  :: " + userId);
            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair] flagPortPair            :: " + flagPortPair);
            // System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] contractCompany              :: " + contractCompany);

            arrParams = new String[][]{
                                        { P_I_V.FK_USER_ID              , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkUserId},
                                        { P_I_V.CONTRACT_PARTY_CODE     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkContractPartyCode},
//                                        { P_I_V.CONTRACT_PARTY_NAME     , BLANK + ORACLE_VARCHAR, PARAM_IN  , contractPartyName},
                                        //##01 Begin
                                        // { P_I_V.CONTRACT_PARTY_NAME     , BLANK + ORACLE_VARCHAR, PARAM_IN  , contractCompany}, //P'Nim tell me send from screen to package 20150217 Pound
                                        // { P_I_V.POL                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOL},
                                        // { P_I_V.POD                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOD},
                                        // { P_I_V.EFF_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , effDate},
                                        // { P_I_V.EXP_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , expDate},
                                        { P_I_V.PWD                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , pwd},
                                        { P_I_V.REACT_PWD               , BLANK + ORACLE_VARCHAR, PARAM_IN  , reactPwd},
                                        //##01 End
                                        { P_I_V.STATUS                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , recStatus},
                                        { P_I_V.USR_ID                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                        { P_I_V.FLAG                    , BLANK + ORACLE_VARCHAR, PARAM_IN  , flagPortPair},
                                        { P_O_V.PK_ESV_PP_HDR_SEQ       , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}, //##01
                                        { P_O_V.ERROR                   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_INS_CONTRACT_PARTY_HDR, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    resultMsg = (String) resultMap.get("P_O_V_ERROR");
                    if(resultMsg == null || "".equals(resultMsg)){
                        resultMsg = (String) resultMap.get(P_O_V.PK_ESV_PP_HDR_SEQ);
                    }
                }
            }else{
                resultMsg = RutMessage.MSG001;
            }
        }catch(Exception e){
            resultMsg = e.getMessage();
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceManagePortPairDaoImpl][addContractPartyPortPair][End]");
        }

        return resultMsg;
    }

    public String updContractPartyPortPair(EserviceContractPartyPortPairMod mod){
         System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair][Begin]");

         Map                     resultMap                       = null;
         JdbcStoredProcedure     storeProcedure                  = null;
         String[][]              arrParams                       = null;
         String                  errorMsg                        = null;
         String                  fkUserId                        = null;
         String                  fkContractPartyCode             = null;
         String                  contractPartyName               = null;
         String                  fkPOL                           = null;
         String                  fkPOD                           = null;
         String                  effDate                         = null;
         String                  expDate                         = null;
         String                  recStatus                       = null;
         String                  userId                          = null;
         String                  pkPortPairSeq                   = null;
         String                  flagPortPair                    = null;
         String                  contractCompany                 = null;

         try{

             fkUserId                = FormatUtil.nullToBlank(mod.getFkUserId()).toUpperCase();
             fkContractPartyCode     = FormatUtil.nullToBlank(mod.getFkContractPartyCode());
             contractPartyName       = FormatUtil.nullToBlank(mod.getContractPartyName());
             fkPOL                   = FormatUtil.nullToBlank(mod.getFkPOL());
             fkPOD                   = FormatUtil.nullToBlank(mod.getFkPOD());
             effDate                 = FormatUtil.nullToBlank(mod.getEffDate()) == "" ? "":FormatUtil.dateFormat(mod.getEffDate(), "dd/MM/yyyy", "yyyyMMdd");
             expDate                 = FormatUtil.nullToBlank(mod.getExpDate()) == "" ? "":FormatUtil.dateFormat(mod.getExpDate(), "dd/MM/yyyy", "yyyyMMdd");
             recStatus               = FormatUtil.nullToBlank(mod.getRecStatus());
             userId                  = FormatUtil.nullToBlank(mod.getUserId()).toUpperCase();
             pkPortPairSeq           = FormatUtil.nullToBlank(mod.getPkPortPairSeq());
             flagPortPair            = FormatUtil.nullToBlank(mod.getFlagPortPair());
             contractCompany         = FormatUtil.nullToBlank(mod.getContractCompany());

             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] pkPortPairSeq           :: " + pkPortPairSeq);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] fkUserId                :: " + fkUserId);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] fkContractPartyCode     :: " + fkContractPartyCode);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] contractPartyName       :: " + contractPartyName);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] fkPOL                   :: " + fkPOL);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] fkPOD                   :: " + fkPOD);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] effDate                 :: " + effDate);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] expDate                 :: " + expDate);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] recStatus               :: " + recStatus);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] userId                  :: " + userId);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] flagPortPair            :: " + flagPortPair);
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair] contractCompany         :: " + contractCompany);

             arrParams = new String[][]{
                                         { P_I_V.PK_PORT_PAIR_SEQ        , BLANK + ORACLE_VARCHAR, PARAM_IN  , pkPortPairSeq},
                                         { P_I_V.FK_USER_ID              , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkUserId},
                                         { P_I_V.CONTRACT_PARTY_CODE     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkContractPartyCode},
                                         { P_I_V.CONTRACT_PARTY_NAME     , BLANK + ORACLE_VARCHAR, PARAM_IN  , contractPartyName},
                                         { P_I_V.POL                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOL},
                                         { P_I_V.POD                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOD},
                                         { P_I_V.EFF_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , effDate},
                                         { P_I_V.EXP_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , expDate},
                                         { P_I_V.STATUS                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , recStatus},
                                         { P_I_V.USR_ID                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                         { P_I_V.FLAG                    , BLANK + ORACLE_VARCHAR, PARAM_IN  , flagPortPair},
                                         { P_O_V.ERROR                   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                       };

             storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_UPD_CONTRACT_PARTY, null, arrParams);
             if(storeProcedure != null){
                 resultMap = storeProcedure.execute();
                 if(resultMap != null && !resultMap.isEmpty()){
                     errorMsg     = (String) resultMap.get("P_O_V_ERROR");
                 }
             }else{
                 errorMsg = RutMessage.MSG001;
             }
         }catch(Exception e){
             errorMsg = e.getMessage();
             e.printStackTrace();
         }finally{
             System.out.println("[EserviceManagePortPairDaoImpl][updContractPartyPortPair][End]");
         }

         return errorMsg;
    }

    public String delContractPartyPortPair(EserviceContractPartyPortPairMod mod){
        System.out.println("[EserviceManagePortPairDaoImpl][delContractPartyPortPair][Begin]");

        Map                     resultMap                       = null;
        JdbcStoredProcedure     storeProcedure                  = null;
        String[][]              arrParams                       = null;
        String                  errorMsg                        = null;
        String                  userId                          = null;
        String                  pkPortPairSeq                   = null;

        try{

            userId                  = FormatUtil.nullToBlank(mod.getUserId()).toUpperCase();
            pkPortPairSeq           = FormatUtil.nullToBlank(mod.getPkPortPairSeq());

            System.out.println("[EserviceManagePortPairDaoImpl][delContractPartyPortPair] pkPortPairSeq           :: " + pkPortPairSeq);
            System.out.println("[EserviceManagePortPairDaoImpl][delContractPartyPortPair] userId                  :: " + userId);

            arrParams = new String[][]{
                                        { P_I_V.PK_PORT_PAIR_SEQ        , BLANK + ORACLE_VARCHAR, PARAM_IN  , pkPortPairSeq},
                                        { P_I_V.USR_ID                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                        { P_O_V.ERROR                   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_DEL_CONTRACT_PARTY, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    errorMsg     = (String) resultMap.get("P_O_V_ERROR");
                }
            }else{
                errorMsg = RutMessage.MSG001;
            }
        }catch(Exception e){
            errorMsg = e.getMessage();
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceManagePortPairDaoImpl][delContractPartyPortPair][End]");
        }

        return errorMsg;
    }

    public List<EserviceContractPartyPortPairMod> getList(EserviceManagePortPairUim uim, String chkBoxExcludeExpiredPortPair) {
       System.out.println("[EserviceManagePortPairDaoImpl][getList][Begin]");

       JdbcStoredProcedure                      storeProcedure               = null;
       Map                                      resultMap                    = null;
       String[][]                               arrParams                    = null;
       List<EserviceContractPartyPortPairMod>   lst                          = null;
       String                                   find                         = null;
       String                                   column                       = null;
       String                                   sortby                       = null;
       String                                   order                        = null;
       String                                   wildcard                     = null;
       String                                   POL                          = null;
       String                                   POD                          = null;
       String                                   userLoginId                  = null;
       String                                   vChkBoxExcludeExpiredPortPair = null;

       try{

           find                          = uim.getFind();
           column                        = uim.getColumn();
           sortby                        = uim.getSortBy();
           order                         = uim.getOrder();
           wildcard                      = uim.getChkBoxWildCard();
           POL                           = uim.getPOL();
           POD                           = uim.getPOD();
           userLoginId                   = uim.getUserLoginId();
           vChkBoxExcludeExpiredPortPair = chkBoxExcludeExpiredPortPair;

           System.out.println("[EserviceManagePortPairDaoImpl][getList] find                          :: " + find);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] column                        :: " + column);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] sortby                        :: " + sortby);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] order                         :: " + order);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] wildcard                      :: " + wildcard);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] fkPOL                         :: " + POL);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] fkPOD                         :: " + POD);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] userLoginId                   :: " + userLoginId);
           System.out.println("[EserviceManagePortPairDaoImpl][getList] chkBoxExcludeExpiredPortPair  :: " + vChkBoxExcludeExpiredPortPair);

           arrParams = new String[][]{
                                       {P_I_V.COL_NAME              , BLANK + ORACLE_VARCHAR      , PARAM_IN  , column},
                                       {P_I_V.COL_VAL               , BLANK + ORACLE_VARCHAR      , PARAM_IN  , find},
                                       {P_I_V.SORT_BY               , BLANK + ORACLE_VARCHAR      , PARAM_IN  , sortby},
                                       {P_I_V.ORDER_BY              , BLANK + ORACLE_VARCHAR      , PARAM_IN  , order},
                                       {P_I_V.WILD_CARD             , BLANK + ORACLE_VARCHAR      , PARAM_IN  , wildcard},
                                       {P_I_V.POL                   , BLANK + ORACLE_VARCHAR      , PARAM_IN  , POL},
                                       {P_I_V.POD                   , BLANK + ORACLE_VARCHAR      , PARAM_IN  , POD},
                                       {P_I_V.USR_ID                , BLANK + ORACLE_VARCHAR      , PARAM_IN  , userLoginId},
                                       {P_I_V.EXCLUDE_EXP           , BLANK + ORACLE_VARCHAR      , PARAM_IN  , vChkBoxExcludeExpiredPortPair},
                                       {P_O_V.CONTRACT_PARTY_DATA   , BLANK + ORACLE_CURSOR       , PARAM_OUT , BLANK},
                                       {P_O_V.ERROR                 , BLANK + ORACLE_VARCHAR      , PARAM_OUT , BLANK}
                                   };

           storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_MANAGE_PORT_PAIR, new ContractPartyPortPairRowMapper(), arrParams);

           System.out.println("[EserviceManagePortPairDaoImpl][getList] storeProcedure :: " + storeProcedure);

           if(storeProcedure != null){
               resultMap = storeProcedure.execute();
               if(resultMap != null && !resultMap.isEmpty()){
                   lst             = (List<EserviceContractPartyPortPairMod>) resultMap.get(P_O_V.CONTRACT_PARTY_DATA);
               }
           }

           System.out.println("[EserviceManagePortPairDaoImpl][getList] lst.size(); :: " + lst.size());

       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
           System.out.println("[EserviceManagePortPairDaoImpl][getList][End]");
       }
       return lst;
    }

    //##01 BEGIN
    public class PortPairRowMapper extends JdbcRowMapper {
        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EserviceContractPartyPortPairMod obj = new EserviceContractPartyPortPairMod();
            obj.setPkEsvPpDtlSeq                (FormatUtil.nullToBlank(rs.getString("PK_ESV_PP_DTL_SEQ")));
            obj.setFkPOL                        (FormatUtil.nullToBlank(rs.getString("FK_POL")));
            obj.setPOLDesc                      (FormatUtil.nullToBlank(rs.getString("POL_DESC")));
            obj.setFkPOD                        (FormatUtil.nullToBlank(rs.getString("FK_POD")));
            obj.setPODDesc                      (FormatUtil.nullToBlank(rs.getString("POD_DESC")));
            obj.setEffDate                      (FormatUtil.dateFormat(rs.getString("EFFECTIVE_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            obj.setExpDate                      (FormatUtil.dateFormat(rs.getString("EXPIRY_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            return obj;
        }
    }
    //##01 End

    public class ContractPartyPortPairRowMapper extends JdbcRowMapper {

        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EserviceContractPartyPortPairMod obj = new EserviceContractPartyPortPairMod();

            // obj.setPkPortPairSeq                (FormatUtil.nullToBlank(rs.getString("PK_PORT_PAIR_SEQ"))); //##01
            obj.setFkUserId                     (FormatUtil.nullToBlank(rs.getString("FK_USER_ID")));
            obj.setUserName                     (FormatUtil.nullToBlank(rs.getString("USER_NAME")));
            obj.setUserNameDisabled             (FormatUtil.nullToBlank(rs.getString("USER_NAME")));
            obj.setFkContractPartyCode          (FormatUtil.nullToBlank(rs.getString("FK_CONTRACT_PARTY_CODE")));
            obj.setContractPartyName            (FormatUtil.nullToBlank(rs.getString("USER_COMPANY_NAME")));
            obj.setContractPartyNameDisabled    (FormatUtil.nullToBlank(rs.getString("USER_COMPANY_NAME")));
            /* ##01 Begin */
            // obj.setFkPOL                        (FormatUtil.nullToBlank(rs.getString("FK_POL")));
            // obj.setPOLDesc                      (FormatUtil.nullToBlank(rs.getString("POL_DESC")));
            // obj.setFkPOD                        (FormatUtil.nullToBlank(rs.getString("FK_POD")));
            // obj.setPODDesc                      (FormatUtil.nullToBlank(rs.getString("POD_DESC")));
            // obj.setEffDate                      (FormatUtil.dateFormat(rs.getString("EFFECTIVE_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            // obj.setExpDate                      (FormatUtil.dateFormat(rs.getString("EXPIRY_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            obj.setPkEsvPpHdrSeq                (FormatUtil.nullToBlank(rs.getString("PK_ESV_PP_HDR_SEQ")));
            try{
                obj.setPwd                      (EncryptDecryptUtil.convertHexToString(FormatUtil.nullToBlank(rs.getString("PWD"))));
            } catch (Exception e){
                obj.setPwd                      (FormatUtil.nullToBlank(rs.getString("PWD")));
            }
            try{
                obj.setReactPwd                 (EncryptDecryptUtil.convertHexToString(FormatUtil.nullToBlank(rs.getString("REACT_PWD"))));
            } catch (Exception e){
                obj.setReactPwd                 (FormatUtil.nullToBlank(rs.getString("REACT_PWD")));
            }
            /* ##01 End */

            return obj;
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

    /*##01 Begin*/
    public String genUniqPwd(int length) {
        System.out.println("[EserviceManagePortPairDaoImpl][genUniqPwd][Begin]");
        String result   = null;
        String errorMsg = null;
        try{
            JdbcStoredProcedure                      storeProcedure         = null;
            Map                                      resultMap              = null;
            String[][]                               arrParams              = null;

            System.out.println("[EserviceManagePortPairDaoImpl][genUniqPwd] length :: " + length);

            arrParams = new String[][]{
                                        {P_I_V.LENGTH , BLANK + ORACLE_NUMBER   , PARAM_IN  , String.valueOf(length)}
                                      , {P_O_V.PWD    , BLANK + ORACLE_VARCHAR  , PARAM_OUT , BLANK}
                                      , {P_O_V.ERROR  , BLANK + ORACLE_VARCHAR  , PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_RANDOM_PWD, null, arrParams);

            System.out.println("[EserviceManagePortPairDaoImpl][genUniqPwd] storeProcedure :: " + storeProcedure);

            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                      result = (String) resultMap.get(P_O_V.PWD);
                      if(result == null){
                          errorMsg = (String) resultMap.get(P_O_V.ERROR);
                      }
                }
            } else {
                errorMsg = RutMessage.MSG001;
            }

            if(errorMsg != null){
                result = errorMsg;
            }
        } catch (Exception e){
            errorMsg = e.getMessage();
            e.printStackTrace();
            result = errorMsg;
        } finally {
            System.out.println("[EserviceManagePortPairDaoImpl][genUniqPwd][End]");
        }
        return result;
    }
    /*##01 End*/

    /*##01 Begin*/
    /**
     * Use for suspend contract party by pk(s)
     * @param pkEsvPpHdrSeq : e.g. 4231 or 4231,4232
     * @return
     */
    public String suspendContractParty(String pkEsvPpHdrSeq, String userId){
        System.out.println("[EserviceManagePortPairDaoImpl][suspendContractParty][Begin]");

        String result   = null;
        String errorMsg = null;

        try{
            JdbcStoredProcedure storeProcedure  = null;
            Map                 resultMap       = null;
            String[][]          arrParams       = null;

            System.out.println("[EserviceManagePortPairDaoImpl][suspendContractParty] pkEsvPpHdrSeq :: "+pkEsvPpHdrSeq);
            System.out.println("[EserviceManagePortPairDaoImpl][suspendContractParty] userId        :: "+userId);

            arrParams = new String[][]{
                                        {P_I_V.PK_ESV_PP_HDR_SEQ  , BLANK + ORACLE_VARCHAR  , PARAM_IN  , pkEsvPpHdrSeq}
                                      , {P_I_V.USR_ID             , BLANK + ORACLE_VARCHAR  , PARAM_IN  , userId}
                                      , {P_O_V.ERROR              , BLANK + ORACLE_VARCHAR  , PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_DEL_PP_HDR, null, arrParams);

            System.out.println("[EserviceManagePortPairDaoImpl][genUniqPwd] storeProcedure :: " + storeProcedure);

            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    errorMsg = (String) resultMap.get(P_O_V.ERROR);
                }

                if(errorMsg != null){
                    result = errorMsg;
                } else {
                    result = "OK";
                }
            } else {
                errorMsg = RutMessage.MSG001;
            }

        } catch (Exception e){
            e.printStackTrace();
            result = e.getMessage();
        } finally {
            System.out.println("[EserviceManagePortPairDaoImpl][suspendContractParty][End]");
        }
        return result;
    }
    /*##01 End*/

    /*##01 Begin*/
    public List<EserviceContractPartyPortPairMod> findPortPair(String pkEsvPpHdrSeq, String chkBoxExcludeExpiredPortPair){
        System.out.println("[EserviceManagePortPairDaoImpl][findPortPair][Begin]");

        List<EserviceContractPartyPortPairMod>    resultList  = null;
        String                                    errorMsg    = null;

        try{
            JdbcStoredProcedure storeProcedure  = null;
            Map                 resultMap       = null;
            String[][]          arrParams       = null;

            System.out.println("[EserviceManagePortPairDaoImpl][findPortPair] pkEsvPpHdrSeq                :: "+pkEsvPpHdrSeq);
            System.out.println("[EserviceManagePortPairDaoImpl][findPortPair] chkBoxExcludeExpiredPortPair :: "+chkBoxExcludeExpiredPortPair);

            arrParams = new String[][]{
                                        {P_I_V.PK_ESV_PP_HDR_SEQ  , BLANK + ORACLE_VARCHAR  , PARAM_IN  , pkEsvPpHdrSeq}
                                      , {P_I_V.EXCLUDE_EXP        , BLANK + ORACLE_VARCHAR  , PARAM_IN  , chkBoxExcludeExpiredPortPair}
                                      , {P_O_V.PORT_PAIR_DATA     , BLANK + ORACLE_CURSOR   , PARAM_OUT , BLANK}
                                      , {P_O_V.ERROR              , BLANK + ORACLE_VARCHAR  , PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_FIND_PP_DTL, new PortPairRowMapper(), arrParams);

            System.out.println("[EserviceManagePortPairDaoImpl][findPortPair] storeProcedure :: " + storeProcedure);

            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    resultList = (List<EserviceContractPartyPortPairMod>) resultMap.get(P_O_V.PORT_PAIR_DATA);
                }

            } else {
                errorMsg = RutMessage.MSG001;
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("[EserviceManagePortPairDaoImpl][findPortPair][End]");
        }
        return resultList;
    }
    /*##01 End*/

    /*##01 Begin*/
    public String updPortPair(EserviceContractPartyPortPairMod mod){
        System.out.println("[EserviceManagePortPairDaoImpl][updPortPair][Begin]");

        Map                     resultMap       = null;
        JdbcStoredProcedure     storeProcedure  = null;
        String[][]              arrParams       = null;
        String                  pkEsvPpDtlSeq   = null;
        String                  fkEsvPpHdrSeq   = null;
        String                  fkPOL           = null;
        String                  fkPOD           = null;
        String                  effDate         = null;
        String                  expDate         = null;
        String                  userLoginId     = null;
        String                  recordStatus    = null;
        String                  flagPortPair    = null;
        String                  errorMsg        = null;
        String                  fkUserId        = null;

        try{
            pkEsvPpDtlSeq   = FormatUtil.nullToBlank(mod.getPkEsvPpDtlSeq());
            fkEsvPpHdrSeq   = FormatUtil.nullToBlank(mod.getPkEsvPpHdrSeq());
            fkUserId        = FormatUtil.nullToBlank(mod.getFkUserId());
            fkPOL           = FormatUtil.nullToBlank(mod.getFkPOL());
            fkPOD           = FormatUtil.nullToBlank(mod.getFkPOD());
            effDate         = FormatUtil.nullToBlank(mod.getEffDate()) == "" ? "":FormatUtil.dateFormat(mod.getEffDate(), "dd/MM/yyyy", "yyyyMMdd");
            expDate         = FormatUtil.nullToBlank(mod.getExpDate()) == "" ? "":FormatUtil.dateFormat(mod.getExpDate(), "dd/MM/yyyy", "yyyyMMdd");
            userLoginId     = FormatUtil.nullToBlank(mod.getUserId()).toUpperCase();
            recordStatus    = FormatUtil.nullToBlank(mod.getRecStatus());
            flagPortPair    = FormatUtil.nullToBlank(mod.getFlagPortPair());

            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] pkEsvPpDtlSeq   :: " + pkEsvPpDtlSeq);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] fkEsvPpHdrSeq   :: " + fkEsvPpHdrSeq);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] fkUserId        :: " + fkUserId);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] fkPOL           :: " + fkPOL);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] fkPOD           :: " + fkPOD);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] effDate         :: " + effDate);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] expDate         :: " + expDate);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] userLoginId     :: " + userLoginId);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] recordStatus    :: " + recordStatus);
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] flagPortPair    :: " + flagPortPair);

            arrParams = new String[][]{
                                        { P_I_V.PK_ESV_PP_DTL_SEQ       , BLANK + ORACLE_VARCHAR, PARAM_IN  , pkEsvPpDtlSeq},
                                        { P_I_V.FK_ESV_PP_HDR_SEQ       , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkEsvPpHdrSeq},
                                        { P_I_V.FK_USER_ID              , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkUserId},
                                        { P_I_V.POL                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOL},
                                        { P_I_V.POD                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOD},
                                        { P_I_V.EFF_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , effDate},
                                        { P_I_V.EXP_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , expDate},
                                        { P_I_V.STATUS                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , recordStatus},
                                        { P_I_V.USR_ID                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , userLoginId},
                                        { P_I_V.FLAG                    , BLANK + ORACLE_VARCHAR, PARAM_IN  , flagPortPair},
                                        { P_O_V.ERROR                   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_UPD_CONTRACT_PARTY_DTL, null, arrParams);

            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair] storeProcedure :: " + storeProcedure);

            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    errorMsg     = (String) resultMap.get("P_O_V_ERROR");
                }
            }else{
                errorMsg = RutMessage.MSG001;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("[EserviceManagePortPairDaoImpl][updPortPair][End]");
        }
        return "";
    }
    /*##01 End*/

    /*##01 Begin*/
    public String addPortPair(EserviceContractPartyPortPairMod mod){
      System.out.println("[EserviceManagePortPairDaoImpl][addPortPair][Begin]");

      Map                     resultMap       = null;
      JdbcStoredProcedure     storeProcedure  = null;
      String[][]              arrParams       = null;
      String                  pkEsvPpDtlSeq   = null;
      String                  fkEsvPpHdrSeq   = null;
      String                  fkPOL           = null;
      String                  fkPOD           = null;
      String                  effDate         = null;
      String                  expDate         = null;
      String                  userLoginId     = null;
      String                  recordStatus    = null;
      String                  flagPortPair    = null;
      String                  errorMsg        = null;
      String                  fkUserId        = null;

      try{
          pkEsvPpDtlSeq   = FormatUtil.nullToBlank(mod.getPkEsvPpDtlSeq());
          fkEsvPpHdrSeq   = FormatUtil.nullToBlank(mod.getPkEsvPpHdrSeq());
          fkUserId        = FormatUtil.nullToBlank(mod.getFkUserId());
          fkPOL           = FormatUtil.nullToBlank(mod.getFkPOL());
          fkPOD           = FormatUtil.nullToBlank(mod.getFkPOD());
          effDate         = FormatUtil.nullToBlank(mod.getEffDate()) == "" ? "":FormatUtil.dateFormat(mod.getEffDate(), "dd/MM/yyyy", "yyyyMMdd");
          expDate         = FormatUtil.nullToBlank(mod.getExpDate()) == "" ? "":FormatUtil.dateFormat(mod.getExpDate(), "dd/MM/yyyy", "yyyyMMdd");
          userLoginId     = FormatUtil.nullToBlank(mod.getUserId()).toUpperCase();
          recordStatus    = FormatUtil.nullToBlank(mod.getRecStatus());
          flagPortPair    = FormatUtil.nullToBlank(mod.getFlagPortPair());

          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] pkEsvPpDtlSeq   :: " + pkEsvPpDtlSeq);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] fkEsvPpHdrSeq   :: " + fkEsvPpHdrSeq);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] fkUserId        :: " + fkUserId);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] fkPOL           :: " + fkPOL);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] fkPOD           :: " + fkPOD);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] effDate         :: " + effDate);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] expDate         :: " + expDate);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] userLoginId     :: " + userLoginId);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] recordStatus    :: " + recordStatus);
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] flagPortPair    :: " + flagPortPair);

          arrParams = new String[][]{
                                      { P_I_V.PK_ESV_PP_DTL_SEQ       , BLANK + ORACLE_VARCHAR, PARAM_IN  , pkEsvPpDtlSeq},
                                      { P_I_V.FK_ESV_PP_HDR_SEQ       , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkEsvPpHdrSeq},
                                      { P_I_V.FK_USER_ID              , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkUserId},
                                      { P_I_V.POL                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOL},
                                      { P_I_V.POD                     , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkPOD},
                                      { P_I_V.EFF_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , effDate},
                                      { P_I_V.EXP_DATE                , BLANK + ORACLE_VARCHAR, PARAM_IN  , expDate},
                                      { P_I_V.STATUS                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , recordStatus},
                                      { P_I_V.USR_ID                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , userLoginId},
                                      { P_I_V.FLAG                    , BLANK + ORACLE_VARCHAR, PARAM_IN  , flagPortPair},
                                      { P_O_V.ERROR                   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                    };

      storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_INS_CONTRACT_PARTY_DTL, null, arrParams);

      System.out.println("[EserviceManagePortPairDaoImpl][addPortPair] storeProcedure :: " + storeProcedure);

      if(storeProcedure != null){
          resultMap = storeProcedure.execute();
          if(resultMap != null && !resultMap.isEmpty()){
              errorMsg     = (String) resultMap.get("P_O_V_ERROR");
          }
      }else{
          errorMsg = RutMessage.MSG001;
      }

      } catch (Exception e){
          e.printStackTrace();
      } finally {
          System.out.println("[EserviceManagePortPairDaoImpl][addPortPair][End]");
      }
      return errorMsg;

    }
    /*##01 End*/

    /*##01 Begin*/
    public String suspendPortPair(String pkEsvPpDtlSeq, String userId){
        System.out.println("[EserviceManagePortPairDaoImpl][suspendPortPair][Begin]");

        JdbcStoredProcedure storeProcedure  = null;
        Map                 resultMap       = null;
        String[][]          arrParams       = null;
        String              result          = null;
        String              errorMsg        = null;

        try{
            System.out.println("[EserviceManagePortPairDaoImpl][suspendPortPair] pkEsvPpDtlSeq  :: " + pkEsvPpDtlSeq);
            System.out.println("[EserviceManagePortPairDaoImpl][suspendPortPair] userId         :: " + userId);

            arrParams = new String[][]{
                                        { P_I_V.PK_ESV_PP_DTL_SEQ       , BLANK + ORACLE_VARCHAR, PARAM_IN  , pkEsvPpDtlSeq},
                                        { P_I_V.USR_ID                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                        { P_O_V.ERROR                   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_DEL_PP_DTL, null, arrParams);

            System.out.println("[EserviceManagePortPairDaoImpl][suspendPortPair] storeProcedure :: " + storeProcedure);

            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    errorMsg = (String) resultMap.get(P_O_V.ERROR);
                }

                if(errorMsg != null){
                    result = errorMsg;
                } else {
                    result = "OK";
                }
            } else {
                errorMsg = RutMessage.MSG001;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("[EserviceManagePortPairDaoImpl][suspendPortPair][End]");
        }
        return result;
    }
    /*##01 End*/

    /*##01 Begin*/
    public EserviceContractPartyPortPairMod findUserDetail(String fkUserId){
        System.out.println("[EserviceManagePortPairDaoImpl][findUserDetail][Begin]");

        List<EserviceContractPartyPortPairMod>  lst             = null;
        EserviceContractPartyPortPairMod        modRes          = null;
        JdbcStoredProcedure                     storeProcedure  = null;
        Map                                     resultMap       = null;
        String[][]                              arrParams       = null;
        String                                  errorMsg        = null;

        try{
            System.out.println("[EserviceManagePortPairDaoImpl][findUserDetail] fkUserId :: " + fkUserId);

            arrParams = new String[][]{
                                        { P_I_V.FK_USER_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkUserId},
                                        { P_O_V.CONTRACT_PARTY_DATA , BLANK + ORACLE_CURSOR,  PARAM_OUT , BLANK},
                                        { P_O_V.ERROR               , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_FIND_USER_DETAIL, new EsmUserLoginMapper(), arrParams);

            System.out.println("[EserviceManagePortPairDaoImpl][findUserDetail] storeProcedure :: " + storeProcedure);

            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    lst = (List<EserviceContractPartyPortPairMod>) resultMap.get(P_O_V.CONTRACT_PARTY_DATA);
                }
            }

            if(lst != null && lst.size() > 0){
                System.out.println("[EserviceManagePortPairDaoImpl][findUserDetail] lst.size(); :: " + lst.size());
                modRes = lst.get(0);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("[EserviceManagePortPairDaoImpl][findUserDetail][End]");
        }
        return modRes;
    }
    /*##01 End*/

    /*##01 Begin*/
    public class EsmUserLoginMapper extends JdbcRowMapper{
        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EserviceContractPartyPortPairMod obj = new EserviceContractPartyPortPairMod();
            obj.setUserName           (FormatUtil.nullToBlank(rs.getString("USER_NAME")));
            obj.setContractPartyName  (FormatUtil.nullToBlank(rs.getString("CONTRACT_PARTY_NAME")));
            obj.setFkContractPartyCode(FormatUtil.nullToBlank(rs.getString("FK_CONTRACT_PARTY_CODE")));
            return obj;
        }
    }
    /*##01 End*/
}
