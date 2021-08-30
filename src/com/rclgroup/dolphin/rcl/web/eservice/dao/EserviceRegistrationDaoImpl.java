 /*------------------------------------------------------
  EserviceRegistrationDaoImpl.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author -
 - Change Log -------------------------------------------
 ##     DD/MM/YY    �User-    -TaskRef-   -ShortDescription-
 01     07/10/14    Pratya      @01         PD_CR_20140826_ESV [Contract Party for registeration]
 02     03/06/15    Sarawut     @02         Add method checkUserRoleCD
 03     17/12/15    Watchakorn              Change table to get Contract Party
 04     17/12/15    Watchakorn              Add method activateRepresentedCompany
 05     20/12/2018  Thitipong               Add checkbox Non RA Account.
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.niit.control.common.ComboVO;
import com.niit.control.common.Debug;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserInfoMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PicMailMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PolPod;
import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_ACT_CONTRACT_PARTY_HDR;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_CONTRACT_PARTY;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ESV_GET_CUSTOMER_CODE_MPP;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ESV_CHECK_AVAILABLE_ID;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ESV_CHECK_USER_ROLE_CD;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ESV_GET_COUNTRY_LIST;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ESV_LOGIN;
import com.rclgroup.dolphin.rcl.web.util.RutMessage;

import net.sf.json.JSONObject;


public class EserviceRegistrationDaoImpl extends AncestorJdbcDao implements EserviceRegistrationDao{
	
	private EserviceRegistrationDaoImplOrcle jdbcTemplateOrcl;
	
	private DriverManagerDataSource driverMangerDataBase;

	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate3;
	
	
	
	public void setDriverMangerDataBase(DriverManagerDataSource driverMangerDataBase) {
		
		this.driverMangerDataBase = driverMangerDataBase;
		this.jdbcTemplate3=new JdbcTemplate(driverMangerDataBase);
	}

	public void setJdbcTemplateOrcl(EserviceRegistrationDaoImplOrcle jdbcTemplateOrcl) {
		this.jdbcTemplateOrcl = jdbcTemplateOrcl;
	}

	public Map findCountryList(){
        return Collections.EMPTY_MAP;
    }

    public Map checkAvailableUserId(String userId){
        Map resultMap = null;

        JdbcStoredProcedure storeProcedure = null;

        String[][] arrParam = null;
        String availableFlag = null;
        String errorMsg = null;
        try{
            if(userId != null && !BLANK.equals(userId)){
                arrParam = new String[][]{
                    { P_I_V.USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId},
                    { P_O_V.FLAG, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK}
                };

            //    storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_CHECK_AVAILABLE_ID, null, arrParam);
               /* if(storeProcedure != null){
                    resultMap = storeProcedure.execute();
                    if(resultMap == null || resultMap.isEmpty()){
                        errorMsg = "Result is null.";
                    }else{
                        availableFlag = (String) resultMap.get(P_O_V.FLAG);
                        if(availableFlag == null || BLANK.equals(availableFlag) || YES.equals(availableFlag)){
                            errorMsg = "User ID already in use.";
                        }
                    }
                }else{
                    errorMsg = "Can not get connection to store procedure.";
                }
            }*/
                
                PRR_ESV_CHECK_AVAILABLE_ID registor = new PRR_ESV_CHECK_AVAILABLE_ID(getJdbcTemplate(), resultMap);
                availableFlag =  registor.executeDbProcedure(userId);
              
                    if(availableFlag == null || BLANK.equals(availableFlag) || YES.equals(availableFlag)){
                        errorMsg = "User ID already in use.";
                    }
               
                
            }else{
                errorMsg = "No paramameter input.";
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
        }
        return resultMap;
    }

    public Map verifyPassword(String password){
        return null;
    }

    public Map getCountryList(){
        Map resultMap = null;

        JdbcStoredProcedure storeProcedure = null;

        String[][] arrParams = null;
        String errorMsg = null;
        try{
            arrParams = new String[][]{{ P_O_V.COUNTRY_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK}};

         //  storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_COUNTRY_LIST, new RegistrationCountryDetailsRowMapper(), arrParams);
            PRR_ESV_GET_COUNTRY_LIST proccedure = new PRR_ESV_GET_COUNTRY_LIST(getJdbcTemplate(), null);
            
         //   if(storeProcedure != null){
           
            if(true){
             //   resultMap = storeProcedure.execute();
            	resultMap = proccedure.executeDbProcedure();
                if(resultMap == null || resultMap.isEmpty()){
                    errorMsg = "Result is null.";
                }
            }else{
                errorMsg = "Can not get connection to store procedure.";
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
        }
        return resultMap;
    }

    public String getControlFSCStatus(String fscCode) throws BusinessException, DataAccessException{
        SqlRowSet rs = null;

        String sql = null;
        String controlFsc = null;
        try{
            if(fscCode != null && !BLANK.equals(fscCode)){
                sql = "select CONTROL_FSC from ITP188 where CRCNTR='"+fscCode+"'";
                Debug.logFramework("SQL getControlFSCStatus = "+sql);

                rs = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(), new HashMap());
                if(rs!=null){
                    while(rs.next()){
                       rs.getString("CONTROL_FSC");
                    }
                }
            }
        } catch(DataAccessException ex){
            throw ex;
        }finally{
            if(controlFsc == null || BLANK.equals(controlFsc)){
                controlFsc = NO;
            }
        }
        return controlFsc;
    }

    public String checkUserRoleCD(String userId) throws BusinessException, DataAccessException{
        System.out.println("[EserviceRegistrationDaoImpl][checkUserRoleCD][Begin]");

        Map                                     resultMap                       = null;
        JdbcStoredProcedure                     storeProcedure                  = null;
        String[][]                              arrParams                       = null;
        String                                  errorMsg                        = null;
        String                                  roleCD                          = null;

        try{

            arrParams = new String[][]{
                                        { P_I_V.USR_ID           , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                        { P_O_V.USER_ROLE_CD     , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.ERROR            , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                      };
                                      
                                      
       PRR_ESV_CHECK_USER_ROLE_CD   userRole = new PRR_ESV_CHECK_USER_ROLE_CD(getJdbcTemplate(),null);

        //		map resultMap= userRole.executeDbProcedure(userId);
      //      storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_CHECK_USER_ROLE_CD, null, arrParams);
      //      if(storeProcedure != null){
        		 if(true){
       //         resultMap = storeProcedure.execute();
        			 resultMap =  userRole.executeDbProcedure(userId);
                if(resultMap != null && !resultMap.isEmpty()){
                    errorMsg     = (String) resultMap.get(P_O_V.ERROR);
                    System.out.println("[EserviceRegistrationDaoImpl][checkUserRoleCD] errorMsg                :: " + errorMsg);
                    if(errorMsg!=null && !errorMsg.equals("")){
                        roleCD         = (String) resultMap.get(P_O_V.USER_ROLE_CD);
                        throw new CustomDataAccessException(errorMsg);
                    }else{
                        roleCD         = (String) resultMap.get(P_O_V.USER_ROLE_CD);
                    }
                }
            }else{
                errorMsg = RutMessage.MSG001;
            }
        }catch(CustomDataAccessException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceRegistrationDaoImpl][checkUserRoleCD][End]");
        }

        return roleCD;
    }

    public class RegistrationCountryDetailsRowMapper extends JdbcRowMapper {

        public Object mapRow(ResultSet rs, int row) throws SQLException {
            ComboVO obj = new ComboVO();
            obj.setName(rs.getString(1));
            obj.setCode(rs.getString(2));

            return obj;
        }
    }

    public Map findUserRegisteredService(String userId, String userMode){
        Map resultMap = null;

        JdbcStoredProcedure storeProcedure = null;

        String[][] arrParams = null;
        String errorMsg = null;

        boolean isInternalUser = true;
        try{
            if(EserviceRegistrationDao.USER_MODE.EXTERNAL.equals(userMode)){
                isInternalUser = false;
            }
//            if(EserviceRegistrationDao.USER_MODE.INTERNAL_MRES.equals(userMode)){
//                userMode = EserviceRegistrationDao.USER_MODE.INTERNAL;
//            }
            arrParams = new String[][]{
                {P_I_V.USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId},
                {P_I_V.CALL_FROM, BLANK + ORACLE_VARCHAR, PARAM_IN, userMode},
                {P_O_V.LIST_SERVICE_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK}
                };
            System.out.println("userId xx :: " + userId);
            System.out.println("userMode xx :: " + userMode);

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_USER_SERVICE_LIST, new RegistrationServiceDetailsRowMapper(isInternalUser), arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap == null || resultMap.isEmpty()){
                    errorMsg = "Result is null.";
                }
            }else{
                errorMsg = "Can not get connection to store procedure.";
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
        }
        return resultMap;
    }

    public class RegistrationServiceDetailsRowMapper extends JdbcRowMapper {
        private boolean isInternalUser;
        public RegistrationServiceDetailsRowMapper(boolean isInternalUser){
            this.isInternalUser = isInternalUser;
        }
        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EserviceRegistrationUserServiceMod obj = new EserviceRegistrationUserServiceMod();
            obj.setModuleName(rs.getString(1));
            obj.setSfu(rs.getString(2));
            obj.setUsageRemark(rs.getString(3));
            obj.setChecked(isInternalUser);
            return obj;
        }
    }

    public Map<String, String> getCaptchaKey() throws BusinessException, DataAccessException {
        Map<String, String> keyMap = null;

        SqlRowSet rowSet = null;

        StringBuffer sql = null;
        try{
            keyMap = new HashMap<String, String>();

            sql = new StringBuffer();
            sql.append("select CONFIG_CD, CONFIG_VALUE from VASAPPS.VCM_CONFIG_MST ");
            sql.append("where CONFIG_TYP = '"+CAPTCHA_CONFIG.TYPE+"' ");
            sql.append("order by CONFIG_CD");

            System.out.println("GET Captcha SQL = "+sql.toString());

            rowSet = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(), new HashMap());
            if(rowSet != null){
                while(rowSet.next()){
                    keyMap.put(rowSet.getString("CONFIG_CD"), rowSet.getString("CONFIG_VALUE"));
                }
            }
        }catch(DataAccessException ex){
            throw ex;
        }
        return keyMap;
    }

    public Map findUserRegisteredInformation(String userId, String fscCode){
        Map resultMap = null;

        EserviceRegistrationUserInfoMod userInfoMod = null;

        JdbcStoredProcedure storeProcedure = null;

        String[][] arrParam = null;
        String controlFSC = NO;
        String errorMsg = null;
        try{
            if(userId != null && !BLANK.equals(userId)){
                controlFSC = getControlFSCStatus(fscCode);

                userInfoMod = new EserviceRegistrationUserInfoMod();

                arrParam = new String[][]{
                    { P_I_V.USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, userId},
                    { P_O_V.USR_NAME, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.CMP_NAME, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.EMAIL, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.ADDRESS1, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.ADDRESS2, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.ADDRESS3, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.ADDRESS4, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.CITY, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.STATE, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.COUNTRY, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.PHONENO, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK},
                    { P_O_V.FAXNO, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK}
                };

                storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_USR_INFO, null, arrParam);
                if(storeProcedure != null){
                    resultMap = storeProcedure.execute();
                    if(resultMap == null || resultMap.isEmpty()){
                        errorMsg = "Result is null.";
                    }else{
                        userInfoMod.setUserId(userId);
                        userInfoMod.setUserName((String) resultMap.get(P_O_V.USR_NAME));
                        userInfoMod.setCmpName((String) resultMap.get(P_O_V.CMP_NAME));
                        userInfoMod.setEmail((String) resultMap.get(P_O_V.EMAIL));
                        userInfoMod.setAddress1((String) resultMap.get(P_O_V.ADDRESS1));
                        userInfoMod.setAddress2((String) resultMap.get(P_O_V.ADDRESS2));
                        userInfoMod.setAddress3((String) resultMap.get(P_O_V.ADDRESS3));
                        userInfoMod.setAddress4((String) resultMap.get(P_O_V.ADDRESS4));
                        userInfoMod.setCity((String) resultMap.get(P_O_V.CITY));
                        userInfoMod.setState((String) resultMap.get(P_O_V.STATE));
                        userInfoMod.setCountry((String) resultMap.get(P_O_V.COUNTRY));
                        userInfoMod.setPhoneNo((String) resultMap.get(P_O_V.PHONENO));
                        userInfoMod.setFaxNo((String) resultMap.get(P_O_V.FAXNO));

                        resultMap.put(KEY_REF_CURSOR, userInfoMod);
                    }
                }else{
                    errorMsg = "Can not get connection to store procedure.";
                }
            }else{
                errorMsg = "No paramameter input.";
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
            resultMap.put(P_O_V.CONTROL_FSC, controlFSC);
        }
        return resultMap;
    }

    public Map createCRMCustomer(Map<String, String> paramMap){

        System.out.println("[EserviceRegistrationDaoImpl][createCRMCustomer][Begin]");

        Map                     resultMap           = null;
        JdbcStoredProcedure     storeProcedure      = null;
        String[][]              arrParams           = null;
        String                  errorMsg            = null;
        try{
            arrParams = new String[][]{
                { P_I_V.COMPANY_NAME    , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.COMPANY_NAME)},
                { P_I_V.ADDRESS1        , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.ADDRESS1)},
                { P_I_V.ADDRESS2        , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.ADDRESS2)},
                { P_I_V.ADDRESS3        , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.ADDRESS3)},
                { P_I_V.ADDRESS4        , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.ADDRESS4)},
                { P_I_V.CITY            , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.CITY)},
                { P_I_V.STATE           , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.STATE)},
                { P_I_V.COUNTRY         , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.COUNTRY)},
                { P_I_V.PHONENO         , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.PHONENO)},
                { P_I_V.FAXNO           , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.FAXNO)},
                { P_I_V.EMAIL           , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.EMAIL)},
                { P_I_V.USR_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.USR_ID)},
                { P_I_V.FSC             , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.FSC)},
                { P_I_V.CUST_TYPE       , BLANK + ORACLE_VARCHAR, PARAM_IN  , (String) paramMap.get(P_I_V.CUST_TYPE)},
                { P_O_V.CUST_CODE       , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                { P_O_V.ERR_CD          , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                { P_O_V.ERR_DESC        , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
            };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_CREATE_NEW_CUST, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap == null || resultMap.isEmpty()){
                    errorMsg = RutMessage.MSG002;
                }
            }else{
                errorMsg = RutMessage.MSG001;
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
            System.out.println("[EserviceRegistrationDaoImpl][createCRMCustomer][End]");
        }
        return resultMap;
    }

    public Map insertRegistration(Map<String, String> mapParams, EserviceRegistrationUim form,RegistrationOrclDao daoOrl) throws Exception{

        System.out.println("[EserviceRegistrationDaoImpl][insertRegistration][Begin]"+mapParams);

        Map                                     resultMap               = null;
        JdbcStoredProcedure                     storeProcedure          = null;
        String[][]                              arrParam                = null;
        String                                  errorMsg                = null;
        /*Begin @01*/
        String                                  representedCompanyFlag  = null;
        EserviceContractPartyPortPairMod        mod                     = null;
        List<EserviceContractPartyPortPairMod>  contractPartyList       = null;
		Connection 								connection 				= null;
        /*End @01*/

        try{
        	connection=getJdbcTemplate().getDataSource().getConnection();
        	connection.setAutoCommit(false);
            if(mapParams != null && !mapParams.isEmpty()){
            	// this for if user selected E-Rate then we need to send e-booking 
            	
            	String SFU_HACK_POST_GRE =(String) mapParams.get(P_I_V.SFU);
            	String SFU =(String) mapParams.get(P_I_V.SFU);
            	String SFU_TEMP ="";
            	
            	if(SFU!=null) {
            		if(SFU.contains("EBKG-E")){
            			SFU_TEMP=SFU_TEMP+ "EBKG-E,EDOC-E";
        			}
            		if(SFU.contains("EVGM-G")) {
            			 if(!SFU.contains("EBKG-E")) {
            				 SFU_TEMP=SFU_TEMP+ "EBKG-E,EDOC-E";
            			 }
            		}
            	   if(SFU.contains("EVGM-E")) {
            		   if(SFU_TEMP.length()>1) {
            			   SFU_TEMP=SFU_TEMP+",EBKG-E";
            		   }else{
            			   SFU_TEMP=SFU_TEMP+"EBKG-E";
            		   }
            	   }	
            	}else {
            		SFU="EBKG-E,EDOC-E";
            	}
             if(SFU_HACK_POST_GRE==null) {
            	   SFU_HACK_POST_GRE="EVGM-E";
            	   SFU_TEMP="EVGM-E";
               }
            	String cutomerCode=null;
            	if( mapParams.get(P_I_V.P_ORG_CODE)!=null && !"".equals(((String) mapParams.get(P_I_V.P_ORG_CODE)) )) {
            		cutomerCode=(String) mapParams.get(P_I_V.P_ORG_CODE);
            	}
            	  
                arrParam = new String[][]{
                                            { P_I_V.FIRST_NAME      , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.FIRST_NAME)},
                                            { P_I_V.LAST_NAME       , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.LAST_NAME)},
                                            { P_I_V.EMAIL           , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.EMAIL)},
                                            { P_I_V.USR_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.USR_ID)},
                                            { P_I_V.PASSWORD        , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.PASSWORD)},
                                            { P_I_V.CMP_NAME        , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.CMP_NAME)},
                                            { P_I_V.ADDRESS1        , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get( P_I_V.ADDRESS1)},
                                            { P_I_V.ADDRESS2        , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.ADDRESS2)},
                                            { P_I_V.ADDRESS3        , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.ADDRESS3)},
                                            { P_I_V.ADDRESS4        , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.ADDRESS4)},
                                            { P_I_V.CITY            , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.CITY)},
                                            { P_I_V.STATE           , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.STATE)},
                                            { P_I_V.COUNTRY         , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.COUNTRY)},
                                            { P_I_V.PHONENO         , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.PHONENO)},
                                            { P_I_V.FAXNO           , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.FAXNO)},
                                            { P_I_V.SFU             , BLANK + ORACLE_VARCHAR, PARAM_IN      , SFU_TEMP},
                                           // { P_I_V.CUST_CODE    , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.CUST_CODE)},
                                            { P_O_V.ERR_CD          , BLANK + ORACLE_VARCHAR, PARAM_OUT     , BLANK},
                                            { P_O_V.ERR_DESC        , BLANK + ORACLE_VARCHAR, PARAM_OUT     , BLANK},
                                            { P_I_V.P_ORG_CODE      , BLANK + ORACLE_VARCHAR, PARAM_IN      , cutomerCode},
                                        };
               
                storeProcedure = daoOrl.getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_LOGIN, null, arrParam);
                
                PRR_ESV_LOGIN login = new PRR_ESV_LOGIN( arrParam,mapParams.get(P_I_V.CUST_CODE),SFU_HACK_POST_GRE );
            //  PRR_ESV_LOGIN_ORACLE loginOrcl = new PRR_ESV_LOGIN_ORACLE(this.jdbcTemplateOrcl.getDataSourceOrcl(),arrParam);
                                       
            //    if(storeProcedure != null){
            //       resultMap = storeProcedure.execute();
            //      if(resultMap == null || resultMap.isEmpty()){
            //              errorMsg = RutMessage.MSG002;
                                        
						
						  if(true) { String result = login.executeDbProcedure(connection);
						  try {
							  storeProcedure.execute();
						  
						 // calledRegistrationRestApi(mapParams);
						  
						  }catch (Exception e) {
							  e.printStackTrace();
							  throw e;
						  }
						 // String resultOrcl = loginOrcl.executeDbProcedure();
						  if(result.equalsIgnoreCase("F")) { errorMsg = RutMessage.MSG002;
						           
                    }else{
                        /*Begin @01*/
                        representedCompanyFlag = form.getRepresentedCompanyFlag();
                        System.out.println("[EserviceRegistrationDaoImpl][insertRegistration] representedCompanyFlag :: " + representedCompanyFlag);
                        if(representedCompanyFlag.equals("Y")){
                            contractPartyList = form.getContractPartyList();
                            if(contractPartyList!=null){
                                for(int i=0;i<contractPartyList.size();i++){
                                    mod = contractPartyList.get(i);

                                    if(mod.getStatusFlag().equals(EserviceRegistrationDao.ADD)){
                                        mod.setFkUserId((String) mapParams.get(P_I_V.USR_ID));
                                        mod.setUserId((String) mapParams.get(P_I_V.USR_ID));
                                        mod.setRecStatus(SUSPENDED);
                                        mod.setFlagPortPair(USER_MODE.EXTERNAL);

                                        errorMsg = this.addContractPartyPortPair(mod);

                                        if(errorMsg!=null) break;
                                    }
                                }
                            }
                        }
                        /*End @01*/
                    }

                    /*Begin @01*/
                    if(errorMsg==null || errorMsg.equals("")){
                        arrParam = new String[][]{
                                                     { P_I_V.USR_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.USR_ID).toUpperCase()},
                                                     { P_I_V.NOTICE_FROM     , BLANK + ORACLE_VARCHAR, PARAM_IN      , ENOTICE_MODE.REGISTRATION},
                                                     { P_I_V.EMAIL           , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) mapParams.get(P_I_V.EMAIL)},
                                                     { P_O_V.ERROR           , BLANK + ORACLE_VARCHAR, PARAM_OUT     , BLANK}
                                                 };

						/*
						 * storeProcedure =
						 * getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_REGISTRATION_ENOTICE, null,
						 * arrParam); //oracle convert resultMap = storeProcedure.execute(); errorMsg =
						 * (String) resultMap.get(P_O_V.ERROR); System.out.
						 * println("[EserviceRegistrationDaoImpl][insertRegistration] errorMsg :: " +
						 * errorMsg); if(errorMsg!=null && !errorMsg.equals("")){ errorMsg =
						 * RutMessage.MSG005; }
						 */
                    }
                    /*End @01*/

                }else{
                    errorMsg = RutMessage.MSG001;
                }
            }else{
                errorMsg = RutMessage.MSG003;
            }
         connection.commit();
        }catch(Exception ex){
        	connection.rollback();
            errorMsg = ex.getMessage();
            throw ex;
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }

            System.out.println("[EserviceRegistrationDaoImpl][insertRegistration][End]");
        }
        return resultMap;
    }

    public Map updateRegistration(Map<String, String> paramMap, EserviceRegistrationUim form){

        System.out.println("[EserviceRegistrationDaoImpl][updateRegistration][Begin]");

        Map                                     resultMap               = null;
        JdbcStoredProcedure                     storeProcedure          = null;
        String[][]                              arrParams               = null;
        String                                  errorMsg                = null;
        /*Begin @01*/
        String                                  representedCompanyFlag  = null;
        EserviceContractPartyPortPairMod        mod                     = null;
        List<EserviceContractPartyPortPairMod>  contractPartyList       = null;
        /*End @01*/

        try{
            arrParams = new String[][]{
                                        { P_I_V.USR_ID      , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.USR_ID)},
                                        { P_I_V.CUST_NAME   , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.CUST_NAME)},
                                        { P_I_V.EMAIL       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.EMAIL)},
                                        { P_I_V.CMP_NAME    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.CMP_NAME)},
                                        { P_I_V.ADDRESS1    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS1)},
                                        { P_I_V.ADDRESS2    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS2)},
                                        { P_I_V.ADDRESS3    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS3)},
                                        { P_I_V.ADDRESS4    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS4)},
                                        { P_I_V.CITY        , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.CITY)},
                                        { P_I_V.STATE       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.STATE)},
                                        { P_I_V.COUNTRY     , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.COUNTRY)},
                                        { P_I_V.PHONENO     , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.PHONENO)},
                                        { P_I_V.FAXNO       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.FAXNO)},
                        //                { P_I_V.NEW_USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.NEW_USR_ID)},
                                        { P_I_V.NEW_PWD     , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.NEW_PWD)},
                                        { P_I_V.SFU         , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.SFU)}
                                    };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_MANAGE_ACCOUNT, null, arrParams);
            //storeProcedure = daoOrl.getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_LOGIN, null, arrParam);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                /*Begin @01*/
                representedCompanyFlag = form.getRepresentedCompanyFlag();
                System.out.println("[EserviceRegistrationDaoImpl][updateRegistration] representedCompanyFlag :: " + representedCompanyFlag);
                if(representedCompanyFlag.equals("Y")){
                    contractPartyList = form.getContractPartyList();
                    if(contractPartyList!=null){
                        for(int i=0;i<contractPartyList.size();i++){
                            mod = contractPartyList.get(i);

                            if(mod.getStatusFlag().equals(EserviceRegistrationDao.ADD)){
                                mod.setFkUserId((String) paramMap.get(P_I_V.USR_ID));
                                mod.setUserId((String) paramMap.get(P_I_V.USR_ID));
                                mod.setRecStatus(SUSPENDED);
                                mod.setFlagPortPair(USER_MODE.INTERNAL_MRES);

                                errorMsg = this.addContractPartyPortPair(mod);

                                if(errorMsg!=null) break;
                            }
                        }
                    }
                }
                /*End @01*/

                 /*Begin @01*/
                 if(errorMsg==null || errorMsg.equals("")){
                    //##03 Begin
                    //  arrParams = new String[][]{
                    //                               { P_I_V.USR_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) paramMap.get(P_I_V.USR_ID).toUpperCase()},
                    //                               { P_I_V.NOTICE_FROM     , BLANK + ORACLE_VARCHAR, PARAM_IN      , ENOTICE_MODE.MANAGEACT},
                    //                               { P_I_V.EMAIL           , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) paramMap.get(P_I_V.EMAIL)},
                    //                               { P_O_V.ERROR           , BLANK + ORACLE_VARCHAR, PARAM_OUT     , BLANK}
                    //                           };
                     //
                    //  storeProcedure  = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_REGISTRATION_ENOTICE, null, arrParams);
                    //  resultMap       = storeProcedure.execute();
                    //  errorMsg        = (String) resultMap.get(P_O_V.ERROR);
                    //  System.out.println("[EserviceRegistrationDaoImpl][updateRegistration] errorMsg :: " + errorMsg);
                    //  if(errorMsg!=null && !errorMsg.equals("")){
                    //      errorMsg = RutMessage.MSG005;
                    //  }
                    //##03 End
                 }
                 /*End @01*/
            }else{
                errorMsg = RutMessage.MSG001;
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }

            System.out.println("[EserviceRegistrationDaoImpl][updateRegistration][End]");
        }
        return resultMap;
    }

    public Map updateRegistrationReview(Map<String, String> paramMap, EserviceRegistrationUim form) throws BusinessException, DataAccessException{

        System.out.println("[EserviceRegistrationDaoImpl][updateRegistrationReview][Begin]");

        Map                                     resultMap               = null;
        JdbcStoredProcedure                     storeProcedure          = null;
        String[][]                              arrParams               = null;
        String                                  errorMsg                = null;
        /*Begin @01*/
        String                                  representedCompanyFlag  = null;
        EserviceContractPartyPortPairMod        mod                     = null;
        List<EserviceContractPartyPortPairMod>  contractPartyList       = null;
        /*End @01*/
        //@02 Add parameter userId
        String                                  userId  = null;

        try{
            
            arrParams = new String[][]{
                                        { P_I_V.USR_ID      , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.USR_ID)},
                                        { P_I_V.SFU         , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.SFU)},
                                        { P_I_V.ORG_CODE    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ORG_CODE)},
                                        { P_I_V.FSC         , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.FSC)},
                                        { P_I_V.EMAIL       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.EMAIL)},
                                        { P_I_V.REJECT_REASON   , BLANK + ORACLE_VARCHAR, PARAM_IN, null},
                                        { P_I_V.USR_LOGIN       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.USR_LOGIN)},
                                        { P_I_V.NON_RA      , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.NON_RA)} // #05 ADD
                                    };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_RR_SUBMIT, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();

                /*Begin @01*/
                representedCompanyFlag = form.getRepresentedCompanyFlag();
                if(representedCompanyFlag.equals("Y")){
                    contractPartyList = form.getContractPartyList();
                    if(contractPartyList!=null){
                        for(int i=0;i<contractPartyList.size();i++){
                            mod = contractPartyList.get(i);
                            mod.setUserId(form.getUserLoginId());
                            mod.setRecStatus(ACTIVE);
                            mod.setFlagPortPair(USER_MODE.INTERNAL);

                            if(mod.getApproveFlag().equals("Y")){
                                errorMsg = this.updContractPartyPortPair(mod);
                            }else{
                                errorMsg = this.delContractPartyPortPair(mod);
                            }
                            if(errorMsg!=null) break;
                        }
                    }
                }
                /*End @01*/

                 /*Begin @01*/
                 System.out.println("[EserviceRegistrationDaoImpl][updateRegistrationReview] Before call enotice errorMsg :: " + errorMsg);
                 if(errorMsg==null || errorMsg.equals("")){
                    //##03 BEGIN
                     System.out.println("[EserviceRegistrationDaoImpl][updateRegistrationReview] P_I_V.USR_ID       :: " + (String) paramMap.get(P_I_V.USR_ID).toUpperCase());
                     System.out.println("[EserviceRegistrationDaoImpl][updateRegistrationReview] P_I_V.NOTICE_FROM  :: " + ENOTICE_MODE.REGISTRATION_REVIEW);
                     System.out.println("[EserviceRegistrationDaoImpl][updateRegistrationReview] P_I_V.EMAIL        :: " + (String) paramMap.get(P_I_V.EMAIL));
                     arrParams = new String[][]{
                                                  { P_I_V.USR_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) paramMap.get(P_I_V.USR_ID).toUpperCase()},
                                                  { P_I_V.NOTICE_FROM     , BLANK + ORACLE_VARCHAR, PARAM_IN      , ENOTICE_MODE.REGISTRATION_REVIEW},
                                                  { P_I_V.EMAIL           , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) paramMap.get(P_I_V.EMAIL)},
                                                  { P_O_V.ERROR           , BLANK + ORACLE_VARCHAR, PARAM_OUT     , BLANK}
                                              };

                     storeProcedure  = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_REGISTRATION_ENOTICE, null, arrParams);
                     resultMap       = storeProcedure.execute();
                     errorMsg        = (String) resultMap.get(P_O_V.ERROR);
                     System.out.println("[EserviceRegistrationDaoImpl][updateRegistrationReview] errorMsg :: " + errorMsg);
                     if(errorMsg!=null && !errorMsg.equals("")){
                         errorMsg = RutMessage.MSG005;
                     }
                    //##03 END
                 }
                 /*End @01*/

            }else{
                errorMsg = RutMessage.MSG001;
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
            System.out.println("[EserviceRegistrationDaoImpl][updateRegistrationReview][End]");
        }
        return resultMap;
    }

    public Map updateRejectReason(Map<String, String> paramMap) throws BusinessException, DataAccessException{
        System.out.println("[EserviceRegistrationDaoImpl][updateRejectReason][Begin]");

        Map                 resultMap           = null;
        JdbcStoredProcedure storeProcedure      = null;
        String[][]          arrParams           = null;
        String              errorMsg            = null;

        try{
            arrParams = new String[][]{
                                        { P_I_V.USR_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.USR_ID)},
                                        { P_I_V.SFU             , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.SFU)},
                                        { P_I_V.ORG_CODE        , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ORG_CODE)},
                                        { P_I_V.FSC             , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.FSC)},
                                        { P_I_V.EMAIL           , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.EMAIL)},
                                        { P_I_V.REJECT_REASON   , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.REJECT_REASON)},
                                        { P_I_V.USR_LOGIN       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.USR_LOGIN)},
                                        { P_I_V.NON_RA      , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.NON_RA)} // #05 ADD
                                      };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_RR_SUBMIT, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
            }else{
                errorMsg = RutMessage.MSG001;
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
            System.out.println("[EserviceRegistrationDaoImpl][updateRejectReason][End]");
        }
        return resultMap;
    }

    /*Begin @01*/
    public String addContractPartyPortPair(EserviceContractPartyPortPairMod mod){
        System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair][Begin]");

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
        String                  flagPortPair                    = null;

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
            flagPortPair            = FormatUtil.nullToBlank(mod.getFlagPortPair());

            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] fkUserId                :: " + fkUserId);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] fkContractPartyCode     :: " + fkContractPartyCode);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] contractPartyName       :: " + contractPartyName);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] fkPOL                   :: " + fkPOL);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] fkPOD                   :: " + fkPOD);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] effDate                 :: " + effDate);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] expDate                 :: " + expDate);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] recStatus               :: " + recStatus);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] userId                  :: " + userId);
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] flagPortPair            :: " + flagPortPair);

            arrParams = new String[][]{
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

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_INS_CONTRACT_PARTY, null, arrParams);
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
            System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair][End]");
        }

        return errorMsg;
    }
    /*End @01*/

    /*Begin @01*/
    public String updContractPartyPortPair(EserviceContractPartyPortPairMod mod){
         System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair][Begin]");

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

             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] pkPortPairSeq           :: " + pkPortPairSeq);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] fkUserId                :: " + fkUserId);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] fkContractPartyCode     :: " + fkContractPartyCode);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] contractPartyName       :: " + contractPartyName);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] fkPOL                   :: " + fkPOL);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] fkPOD                   :: " + fkPOD);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] effDate                 :: " + effDate);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] expDate                 :: " + expDate);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] recStatus               :: " + recStatus);
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair] userId                  :: " + userId);
             System.out.println("[EserviceRegistrationDaoImpl][addContractPartyPortPair] flagPortPair            :: " + flagPortPair);

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
             System.out.println("[EserviceRegistrationDaoImpl][updContractPartyPortPair][End]");
         }

         return errorMsg;
    }
    /*End @01*/


    /*Begin @01*/
    public String delContractPartyPortPair(EserviceContractPartyPortPairMod mod){
        System.out.println("[EserviceRegistrationDaoImpl][delContractPartyPortPair][Begin]");

        Map                     resultMap                       = null;
        JdbcStoredProcedure     storeProcedure                  = null;
        String[][]              arrParams                       = null;
        String                  errorMsg                        = null;
        String                  userId                          = null;
        String                  pkPortPairSeq                   = null;

        try{

            userId                  = FormatUtil.nullToBlank(mod.getUserId()).toUpperCase();
            pkPortPairSeq           = FormatUtil.nullToBlank(mod.getPkPortPairSeq());

            System.out.println("[EserviceRegistrationDaoImpl][delContractPartyPortPair] pkPortPairSeq           :: " + pkPortPairSeq);
            System.out.println("[EserviceRegistrationDaoImpl][delContractPartyPortPair] userId                  :: " + userId);

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
            System.out.println("[EserviceRegistrationDaoImpl][delContractPartyPortPair][End]");
        }

        return errorMsg;
    }
    /*End @01*/

     /*Begin @01*/
     public List<EserviceContractPartyPortPairMod> getContractPartyPortPair(EserviceContractPartyPortPairMod mod, String excludeExpireContractParty) throws CustomDataAccessException {
        System.out.println("[EserviceRegistrationDaoImpl][getContractPartyPortPair][Begin]");

        Map                                     resultMap                       = null;
        JdbcStoredProcedure                     storeProcedure                  = null;
        String[][]                              arrParams                       = null;
        String                                  errorMsg                        = null;
        String                                  userId                          = null;
        String                                  pkPortPairSeq                   = null;
        String                                  fkUserId                        = null;
        List<EserviceContractPartyPortPairMod>  list                            = null;

        try{

            fkUserId                = FormatUtil.nullToBlank(mod.getFkUserId()).toUpperCase();
            userId                  = FormatUtil.nullToBlank(mod.getUserId()).toUpperCase();
            pkPortPairSeq           = FormatUtil.nullToBlank(mod.getPkPortPairSeq());

            System.out.println("[EserviceRegistrationDaoImpl][getContractPartyPortPair] fkUserId                   :: " + fkUserId);
            System.out.println("[EserviceRegistrationDaoImpl][getContractPartyPortPair] userId                     :: " + userId);
            System.out.println("[EserviceRegistrationDaoImpl][getContractPartyPortPair] excludeExpireContractParty :: " + excludeExpireContractParty);

            arrParams = new String[][]{
                                        { P_I_V.FK_USER_ID              , BLANK + ORACLE_VARCHAR, PARAM_IN  , fkUserId},
                                        { P_I_V.USR_ID                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                        // { P_I_V.EXCLUDE_EXP             , BLANK + ORACLE_VARCHAR, PARAM_IN  , excludeExpireContractParty},
                                        { P_O_V.CONTRACT_PARTY_DATA     , BLANK + ORACLE_CURSOR , PARAM_OUT , BLANK},
                                        { P_O_V.ERROR                   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                      };

            //storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_CONTRACT_PARTY, new ContractPartyPortPairRowMapper(), arrParams);
            resultMap =new HashMap();
            resultMap.put(P_I_V.FK_USER_ID , fkUserId);
            resultMap.put(P_I_V.USR_ID , userId);
             
            PRR_ESV_GET_CONTRACT_PARTY proc =new PRR_ESV_GET_CONTRACT_PARTY(getJdbcTemplate(),resultMap);
            proc.executeProcedure();
           // if(storeProcedure != null){
              //  resultMap = storeProcedure.execute();
               // if(resultMap != null && !resultMap.isEmpty()){
                    errorMsg     = (String) resultMap.get(P_O_V.ERROR);
               //     System.out.println("[EserviceRegistrationDaoImpl][getContractPartyPortPair] errorMsg                :: " + errorMsg);
                  if(errorMsg!=null && !errorMsg.equals("")){
                       throw new CustomDataAccessException(errorMsg);
                    }else{
                        list         = (List<EserviceContractPartyPortPairMod>) resultMap.get(P_O_V.CONTRACT_PARTY_DATA);
                    }
              //  }
            //}else{
               // errorMsg = RutMessage.MSG001;
            //}
        }catch(CustomDataAccessException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceRegistrationDaoImpl][getContractPartyPortPair][End]");
        }

        return list;
     }

    public class ContractPartyPortPairRowMapper extends JdbcRowMapper {

        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EserviceContractPartyPortPairMod obj = new EserviceContractPartyPortPairMod();

            // obj.setPkPortPairSeq                (FormatUtil.nullToBlank(rs.getString("PK_PORT_PAIR_SEQ")));
            obj.setFkUserId                     (FormatUtil.nullToBlank(rs.getString("FK_USER_ID")));
            obj.setFkContractPartyCode          (FormatUtil.nullToBlank(rs.getString("FK_CONTRACT_PARTY_CODE")));
            obj.setContractPartyName            (FormatUtil.nullToBlank(rs.getString("CONTRACT_PARTY_NAME")));
            obj.setContractPartyNameDisabled    (FormatUtil.nullToBlank(rs.getString("CONTRACT_PARTY_NAME")));
            // obj.setFkPOL                        (FormatUtil.nullToBlank(rs.getString("FK_POL")));
            // obj.setFkPOD                        (FormatUtil.nullToBlank(rs.getString("FK_POD")));
            // obj.setEffDate                      (FormatUtil.dateFormat(rs.getString("EFFECTIVE_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            // obj.setExpDate                      (FormatUtil.dateFormat(rs.getString("EXPIRY_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            obj.setRecStatus                    (FormatUtil.nullToBlank(rs.getString("RECORD_STATUS")));
            obj.setRecStatusDesc                (FormatUtil.statusRecDesc(rs.getString("RECORD_STATUS")));

            //##03 Begin
            obj.setPkEsvPpHdrSeq                (FormatUtil.nullToBlank(rs.getString("PK_ESV_PP_HDR_SEQ")));
            obj.setContractPartyStatus          (FormatUtil.nullToBlank(rs.getString("CONTRACT_PARTY_STATUS")));

            try{
                obj.setPwd                      (EncryptDecryptUtil.convertHexToString(FormatUtil.nullToBlank(rs.getString("PWD"))));

            } catch (Exception e){
                e.printStackTrace();
                obj.setPwd                      (FormatUtil.nullToBlank(rs.getString("PWD")));
            }
            try{
                obj.setReactPwd                      (EncryptDecryptUtil.convertHexToString(FormatUtil.nullToBlank(rs.getString("REACT_PWD"))));
            } catch (Exception e){
                e.printStackTrace();
                obj.setReactPwd                      (FormatUtil.nullToBlank(rs.getString("REACT_PWD")));
            }
            //##03 End

            if(!obj.getRecStatus().equals("P"))obj.setApproveFlag("Y");

            return obj;
        }
    }

     /*End @01*/

    /*Begin @01*/
    public Map sendEnoticeForContractPartyPortPair(Map<String, String> paramMap) throws BusinessException, DataAccessException{

      System.out.println("[EserviceRegistrationDaoImpl][sendEnoticeForContractPartyPortPair][Begin]");

      Map                                     resultMap               = null;
      JdbcStoredProcedure                     storeProcedure          = null;
      String[][]                              arrParams               = null;
      String                                  errorMsg                = null;

      try{
        arrParams = new String[][]{
                                    { P_I_V.USR_ID          , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) paramMap.get(P_I_V.USR_ID).toUpperCase()},
                                    { P_I_V.NOTICE_FROM     , BLANK + ORACLE_VARCHAR, PARAM_IN      , ENOTICE_MODE.MANAGE_PORT_PAIR},
                                    { P_I_V.EMAIL           , BLANK + ORACLE_VARCHAR, PARAM_IN      , (String) paramMap.get(P_I_V.EMAIL)},
                                    { P_O_V.ERROR           , BLANK + ORACLE_VARCHAR, PARAM_OUT     , BLANK}
                                };

        storeProcedure  = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_REGISTRATION_ENOTICE, null, arrParams);
        resultMap       = storeProcedure.execute();
        errorMsg        = (String) resultMap.get(P_O_V.ERROR);

        System.out.println("[EserviceRegistrationDaoImpl][sendEnoticeForContractPartyPortPair] errorMsg :: " + errorMsg);
        if(errorMsg!=null && !errorMsg.equals("")){
           errorMsg = RutMessage.MSG005;
        }

      }catch(Exception ex){
          errorMsg = ex.getMessage();
          ex.printStackTrace();
      }finally{
          if(resultMap == null){
              resultMap = new HashMap();
          }
          if(errorMsg != null && !BLANK.equals(errorMsg)){
              resultMap.put(P_O_V.ERR_CD, EXCEPTION);
              resultMap.put(P_O_V.ERR_DESC, errorMsg);
          }
          System.out.println("[EserviceRegistrationDaoImpl][sendEnoticeForContractPartyPortPair][End]");
      }
      return resultMap;
    }
    /*End @01*/

    public Map findCustomerInfo(String companyName, String countryCode){

        System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfo][Begin]");

        Map                     resultMap           = null;
        JdbcStoredProcedure     storeProcedure      = null;
        String[][]              arrParam            = null;
        String                  errorMsg            = null;

        try{

            System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfo] companyName :: " + companyName);
            System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfo] countryCode :: " + countryCode);

            arrParam = new String[][]{
                                        { P_I_V.CMP_NAME    , BLANK + ORACLE_VARCHAR, PARAM_IN  , companyName},
                                        { P_I_V.COUNTRY_CD  , BLANK + ORACLE_VARCHAR, PARAM_IN  , countryCode},
                                        { P_O_V.CUST_CODE   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.FSC         , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.CUST_TYPE   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.ERR_CD      , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.ERR_DESC    , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK}
                                    };

            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_CUSTOMER_CODE, null, arrParam);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap == null || resultMap.isEmpty()){
                    errorMsg = RutMessage.MSG002;
                }
            }else{
                errorMsg = RutMessage.MSG001;
            }
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
            System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfo][End]");
        }
        return resultMap;
    }

    public Map findCustomerInfoMPP(String userId, String contactPartyName,String flag){

        System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfoMPP][Begin]");

        Map                     resultMap           = null;
        JdbcStoredProcedure     storeProcedure      = null;
        String[][]              arrParam            = null;
        String                  errorMsg            = null;

        try{

            System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfoMPP] userId       :: " + userId);
            System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfoMPP] contactPartyName  :: " + contactPartyName);
            System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfoMPP] flag       :: " + flag);

            arrParam = new String[][]{
                                        { P_I_V.USR_ID      , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                        { P_I_V.CUST_NAME  , BLANK + ORACLE_VARCHAR, PARAM_IN  , contactPartyName},
                                        { P_O_V.CUST_CODE   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.FSC         , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.CUST_TYPE   , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.ERR_CD      , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_O_V.ERR_DESC      , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK},
                                        { P_I_V.FLAG    , BLANK + ORACLE_VARCHAR, PARAM_IN , flag}
                                    };

            //storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_CUSTOMER_CODE_MPP, null, arrParam);
                                    resultMap=new HashMap();
                                    resultMap.put(P_I_V.USR_ID, userId);
                                    resultMap.put(P_I_V.CUST_NAME, contactPartyName);
                                    resultMap.put(P_I_V.FLAG, flag);
                                    
            PRR_ESV_GET_CUSTOMER_CODE_MPP proc=new PRR_ESV_GET_CUSTOMER_CODE_MPP(getJdbcTemplate(),resultMap);
            proc.executeProcedure();
           // if(storeProcedure != null){
            //    resultMap = storeProcedure.execute();
                if(resultMap == null || resultMap.isEmpty()){
                    errorMsg = RutMessage.MSG002;
                }
            //}else{
             //   errorMsg = RutMessage.MSG001;
            //}
        }catch(Exception ex){
            errorMsg = ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
            System.out.println("[EserviceRegistrationDaoImpl][findCustomerInfoMPP][End]");
        }
        return resultMap;
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

    //##04 Begin
    public String activateRepresentedCompany(EserviceContractPartyPortPairMod mod) {
        System.out.println("[EserviceRegistrationDaoImpl][activateRepresentedCompany][Begin]");

        JdbcStoredProcedure     storeProcedure      = null;
        String[][]              arrParam            = null;
        String                  errorMsg            = null;
        Map                     resultMap           = null;
        String                  reactPwd            = null;
        String                  userId              = null;

        try{
            reactPwd  = mod.getReactPwd();
            reactPwd  = EncryptDecryptUtil.convertStringToHex(reactPwd).toUpperCase();
            userId    = mod.getUserId();

            System.out.println("[EserviceRegistrationDaoImpl][activateRepresentedCompany] pkEsvPpHdrSeq :: " + mod.getPkEsvPpHdrSeq());
            System.out.println("[EserviceRegistrationDaoImpl][activateRepresentedCompany] reactPwd      :: " + reactPwd);
            System.out.println("[EserviceRegistrationDaoImpl][activateRepresentedCompany] userId        :: " + userId);

            arrParam = new String[][]{
                                        { P_I_V.PK_ESV_PP_HDR_SEQ      , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getPkEsvPpHdrSeq()}
                                      , { P_I_V.REACT_PWD              , BLANK + ORACLE_VARCHAR, PARAM_IN  , reactPwd}
                                      , { P_I_V.USR_ID                 , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId}
                                      , { P_O_V.ERROR                  , BLANK + ORACLE_VARCHAR, PARAM_IN  , BLANK}
                                    };

           // storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_ACT_CONTRACT_PARTY_HDR, null, arrParam);
            resultMap=new HashMap();
            resultMap.put(P_I_V.PK_ESV_PP_HDR_SEQ, mod.getPkEsvPpHdrSeq());
            resultMap.put(P_I_V.REACT_PWD, reactPwd);
            resultMap.put(P_I_V.USR_ID, userId);
            PRR_ESV_ACT_CONTRACT_PARTY_HDR proc=new PRR_ESV_ACT_CONTRACT_PARTY_HDR(getJdbcTemplate(),resultMap);
            proc.executeDbProcedure();
            //if(storeProcedure != null){
            //    resultMap = storeProcedure.execute();
             //   if(resultMap == null || resultMap.isEmpty()){
            //        errorMsg = "OK";
            //    }
           // }else{
           //     errorMsg = RutMessage.MSG001;
           // }
            errorMsg=(String) resultMap.get(P_O_V.ERROR);
        } catch (Exception e){
            errorMsg = e.getMessage();
        } finally {
            System.out.println("[EserviceRegistrationDaoImpl][activateRepresentedCompany][End]");
        }
        return errorMsg;
    }
    //##04 End

	@Override
	public List<PolPod> getCodeForPolPod(EserviceRegistrationUim form) {

		//String POL_POD_QUERY="select * from country_code";
		String POL_POD_QUERY="select * from country_code where name like '"+form.getPolPod().toUpperCase()+"%'";
		
		List<PolPod> lit= getJdbcTemplate().query(POL_POD_QUERY, new GetCounteyCodeAndName());
		
		return lit;
	}
	
	@Override
	public String checkCustomerCodeAvailable(String customerCode,String emailId) {
		
		 
		String response ="false"; 
		
		String customerQuery="select (fk_country) as fk_country from cam_customer where lower(pk_customer_code)=lower('"+customerCode+"')";
		
		List<String>countryList =getJdbcTemplate().query(customerQuery, new RowMapper() {
			
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("fk_country");
			}
		});
		
		if(countryList != null && countryList.size()!=0) {
			 
			String query ="select  count(email) from cam_customer eul  where lower(email) like lower('%"+emailId.substring(emailId.lastIndexOf("@"))+"%') and lower(pk_customer_code)=lower('"+customerCode+"')"; 
			System.out.println(" Query for check domain "+query);
			int count = getJdbcTemplate().queryForInt(query);
			if(count==0) {
				response="mismatch";
			}else {
				response="match";
			}
		/*	if(country!= null && country.equals(countryList.get(0))) {
				response="match";
			}else {
				response="mismatch";
			}
		*/}
		 //emailId
		return response;
	}
	
	class GetCounteyCodeAndName implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg) throws SQLException {
			
			PolPod model =new PolPod();
			
			model.setValue(rs.getString("code"));
			model.setText(rs.getString("code")+" - "+rs.getString("name"));
			
			return model;
		}
		
		
		
	}

	@Override
	public List<ContryMod> getCountryCodeNameList() {
		
		String POL_POD_QUERY="select name AS COUNTRY_NAME,code AS COUNTRY_CODE from country_code order by  COUNTRY_NAME";
		
		List<ContryMod> lit= getJdbcTemplate().query(POL_POD_QUERY, new CountruCombod());
		
		return lit;
	}
	
	class CountruCombod implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg) throws SQLException {
			
			//ContryMod model =new ContryMod();
			
			ContryMod obj = new ContryMod();
			obj.setContryName(rs.getString("COUNTRY_NAME"));
			obj.setCode(rs.getString("COUNTRY_CODE"));
			
			return obj;
		}
		
		
		
	}
	
	public void calledRegistrationRestApi(Map<String, String> mapParams) {

		String url = "http://localhost:8080/DCSWebService/rclws/registrationService";
		// String url= ftfConfig.getUrlForSeach();

		System.out.println("URL of Search++++++++++++SID+++++++++++++++++ " + url + "?id=" + Math.random());

		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
		httpclient.start();
		final HttpPost post = new HttpPost(url);

		JSONObject json = new JSONObject();
		json.put("firstName", (String) mapParams.get(P_I_V.FIRST_NAME));
		json.put("lastName", (String) mapParams.get(P_I_V.LAST_NAME));
		json.put("userId", (String) mapParams.get(P_I_V.EMAIL));
		json.put("password", (String) mapParams.get(P_I_V.USR_ID));
		json.put("cmpName", (String) mapParams.get(P_I_V.PASSWORD));
		json.put("email", (String) mapParams.get(P_I_V.CMP_NAME));

		json.put("address1", (String) mapParams.get(P_I_V.ADDRESS1));
		json.put("address2", (String) mapParams.get(P_I_V.ADDRESS2));
		json.put("address3", (String) mapParams.get(P_I_V.ADDRESS3));
		json.put("address4", (String) mapParams.get(P_I_V.ADDRESS4));
		json.put("city", (String) mapParams.get(P_I_V.CITY));
		json.put("state", (String) mapParams.get(P_I_V.STATE));

		json.put("country", (String) mapParams.get(P_I_V.COUNTRY));
		json.put("phoneNo", (String) mapParams.get(P_I_V.PHONENO));
		json.put("faxNo", (String) mapParams.get(P_I_V.FAXNO));
		json.put("suf", (String) mapParams.get(P_I_V.SFU));

		System.out.println("json " + json.toString());
		HttpEntity stringEntity = new StringEntity(json.toString(), ContentType.APPLICATION_JSON);
		post.setEntity(stringEntity);

		// post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		Future<HttpResponse> future = httpclient.execute(post, null);
		HttpResponse response1 = null;
		try {
			response1 = future.get();
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// and wait until a response is received
	}

	@Override
	public String getRrepresentedCompany(String customerCode) {
		String V_REP_NAME=""; 
		String query2="select a.CUNAME " + 
				"            from BKP030 T, ITP010 a   " + 
				"            where a.CUCUST    = '"+ customerCode +"'" + 
				"              and BNCSTP    = 'O'   " ;
		System.out.println(" : "+query2);
		try {
		V_REP_NAME=(String) getJdbcTemplate().queryForObject(query2, Object.class);
		}catch (Exception e) {
			V_REP_NAME="";
		}
		
		return V_REP_NAME;
	}

	@Override
	public void getPicMailId(EserviceRegistrationUim form) {
		String fsc=""; 
		String query="SELECT CRCNTR as V_FSC " + 
				"        FROM (SELECT CRCNTR FROM ITP188 b " + 
				"        WHERE CRCITY = UPPER('"+form.getUserInfoMod().getCity()+"') " + 
				"              AND CRCNCD='"+form.getUserInfoMod().getCountry()+"' " + 
				"              AND CRRCST='A' " + 
				"        ORDER  BY CRCNTR DESC) a " + 
				"        limit  1";
		try {
		    fsc=(String) getJdbcTemplate().queryForObject(query, Object.class);
		  	if(fsc!=null && !fsc.equals("")) {
			    String pic_mail_query = "select recipient_email as MAIL,recipient_type as TYPE from pic_mail pm  where e_notice_desc='ESV - Registration Submission - Customer' and  fk_fsc_id='"+fsc+"'";
			    List<PicMailMod> picuser=  getJdbcTemplate().query(pic_mail_query, new MailRowMapper());
			    String toPicMail="";
	            String ccPicMail="";
	            String bccPicMail="";
			    for(int i=0;i<picuser.size();i++) {
	            	 if(picuser.get(i).getMailType().equals("To"))
	            		 toPicMail+=picuser.get(i).getMail()+",";
	            	 else if(picuser.get(i).getMailType().equals("Cc"))
	            		 ccPicMail+=picuser.get(i).getMail()+",";
	            	 else if(picuser.get(i).getMailType().equals("Bcc"))
	            		 bccPicMail+=picuser.get(i).getMail()+",";
	             }
	             if(!toPicMail.equals("")) {
	            	 form.setToPicMail(toPicMail.substring(0,toPicMail.length()-1));
	             }
	             if(!ccPicMail.equals("")) {
	            	 form.setCcPicMail(ccPicMail.substring(0,ccPicMail.length()-1));
	             }
	             if(!bccPicMail.equals("")) {
	            	 form.setBccPicMail(bccPicMail.substring(0,bccPicMail.length()-1));
	             }
		  	}
		  }catch (Exception e) {
			 System.out.println("No fsc found");
			 form.setToPicMail("");
			 form.setCcPicMail("");
			 form.setBccPicMail("");
		}
		
	}
	class MailRowMapper extends JdbcRowMapper{

		@Override
		public Object mapRow(ResultSet rs, int count) throws SQLException {
			 
			PicMailMod picmail= new PicMailMod();
			
			picmail.setMail(rs.getString("MAIL"));
			picmail.setMailType(rs.getString("TYPE"));
			
			return picmail;
		}
		 
	 }
	 
}
