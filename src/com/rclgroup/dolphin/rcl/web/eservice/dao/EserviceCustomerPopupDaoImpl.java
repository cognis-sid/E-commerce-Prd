package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.Debug;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCustomerTypePopupMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.niit.control.common.PagingUtil;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;

import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCustomerPopupMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUserPortPairLookUpMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCustomerDetailsMod;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EserviceCustomerPopupDaoImpl extends AncestorJdbcDao implements EserviceCustomerPopupDao{
    public EserviceCustomerPopupDaoImpl(){
    }
    //@03 BEGIN

    public String getValueToConfigDate() throws BusinessException, DataAccessException{
        SqlRowSet rowSet = null;

        StringBuffer sql = null;
        String configDate = BLANK;
        try{
            sql = new StringBuffer();
            sql.append("SELECT CONFIG_VALUE FROM VASAPPS.VCM_CONFIG_MST ");
            sql.append("WHERE CONFIG_TYP = 'ESI' ");
            sql.append("and CONFIG_CD = 'ESI_CUST_HISTORY'");

            rowSet = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(), new HashMap());
            while(rowSet.next()){
                configDate = rowSet.getString("CONFIG_VALUE");
            }
        } catch(DataAccessException ex){
            throw ex;
        }
        return configDate;
    }
    //@03 END

    /**
     * 
     * This method for get List of Customer.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of customer data     
     */
    public Map findCustomerForESICustomer(Map map) throws BusinessException, DataAccessException{
        List<EshippingCustomerDetailsMod> customerList = null;
        
        Map resultMap = null;

        PagingUtil pagingUtil = null;
        EshippingCustomerDetailsMod obj = null;
        StringBuffer stringBuffer = null;

        SqlRowSet rowSet = null;

        String findText = null;
        String column = null;
        String sortby = null;
        String order = null;
        String wildcard = null;
        Integer fromRecord = null;
        Integer toRecord = null;
        String orgCode = null;
        String cocSoc = null;
        //@03 BEGIN
        String configDate = null;
        //@03 END
        String sql = null;
        
        //String QUERY_ORGCODE="select babkby from SEALINER.BKP001 where babkno='"+map.get("BOOKING_NO")+"'";

        int rows = 0;
        try{
            customerList = new ArrayList<EshippingCustomerDetailsMod>();
        
            findText = (String) map.get(CRITERIA_KEY.TEXT_FIND);
            column = (String) map.get(CRITERIA_KEY.COLUMN);
            sortby = (String) map.get(CRITERIA_KEY.SORTBY);
            order = (String) map.get(CRITERIA_KEY.ORDER);
            wildcard = (String) map.get(CRITERIA_KEY.WILDCARD);
            fromRecord = (Integer) map.get(CRITERIA_KEY.FROM_RECORD);
            toRecord = (Integer) map.get(CRITERIA_KEY.TO_RECORD);
             orgCode = (String) map.get(CRITERIA_KEY.ORG_CODE); //(String) getJdbcTemplate().queryForObject(QUERY_ORGCODE, Object.class);
            cocSoc = "C"; //(String) map.get(CRITERIA_KEY.COC_SOC);
            //@03 BEGIN
            configDate = (String) map.get(KEY_CONFIG_DATE);
            //@03 END
            stringBuffer = new StringBuffer("select distinct CUCUST as CUSTOMER_CODE ");
            stringBuffer.append(NEW_LINE).append(", CUNAME as CUSTOMER_NAME ");
            stringBuffer.append(NEW_LINE).append(", (select SCNAME from ITP030 where SCCODE = CUCOUN) as COUNTRY ");
            stringBuffer.append(NEW_LINE).append(", CUCOUN as COUNTRY_CODE, CUCORS as COC_SOC ");
            stringBuffer.append(NEW_LINE).append(", CUADD1, CUADD2, CUADD3, CUADD4 ");
            stringBuffer.append(NEW_LINE).append("from (select distinct AYBLNO from IDP010, IDP030 ");
            stringBuffer.append(NEW_LINE).append("where AYBLNO = CYBLNO ");
            stringBuffer.append(NEW_LINE).append("and CYCUST = '"+orgCode+"' ");
            stringBuffer.append(NEW_LINE).append("and CYRCTP in ('O', 'S') ");
            //@03 BEGIN
            stringBuffer.append(NEW_LINE).append("and AYISDT between To_Number(To_Char(now() - INTERVAL '"+configDate+" DAY', 'yyyymmdd'),'9G999g9999') and To_Number(To_Char(now(), 'yyyymmdd'),'9G999g9999')) BL");
            stringBuffer.append(NEW_LINE).append(", IDP030, ITP010") ;
            //@03 END
            stringBuffer.append(NEW_LINE).append("where BL.AYBLNO = CYBLNO");
            stringBuffer.append(NEW_LINE).append("and CYRCTP not in ('O', 'S')");
            stringBuffer.append(NEW_LINE).append("and CYCUST = CUCUST");
            stringBuffer.append(NEW_LINE).append("and CURCST = 'A'");
            stringBuffer.append(NEW_LINE).append("and CUCORS = '"+cocSoc+"'");

            if(column!=null&&!BLANK.equals(column)){
                stringBuffer.append(NEW_LINE).append("\nand "+column);
                if(wildcard!=null){
                    stringBuffer.append(" like '%"+findText.trim()+"%'");
                } else {
                    stringBuffer.append(" = '"+findText.trim()+"'");
                }
            }
            stringBuffer.append(NEW_LINE).append("order by ");
            if(sortby!=null&&!BLANK.equals(sortby)){
                stringBuffer.append(sortby);
            } else {
                stringBuffer.append("CUCUST, CUNAME, CUCOUN");
            }
            if(order!=null&&!BLANK.equals(order)){
                stringBuffer.append(" "+order);
            }

            sql = stringBuffer.toString();
            System.out.println("sql::" + sql);
            if((fromRecord!=null&&!BLANK.equals(fromRecord))&&(toRecord!=null&&!BLANK.equals(toRecord))){
                pagingUtil = new PagingUtil();

                sql = pagingUtil.getSqlRows(stringBuffer);
                System.out.println(sql.toString());
                rowSet = getNamedParameterJdbcTemplate().queryForRowSet(sql+" a", new HashMap());
                if(rowSet != null){
                    while(rowSet.next()){
                        rows = rowSet.getInt(1);
                    }
                }
                //sql = pagingUtil.setRownum(stringBuffer, fromRecord, toRecord);
                sql="select * from (select a.*,row_number() over() as r from("+stringBuffer+")a )b where r BETWEEN "+(fromRecord+1)+" AND "+ (toRecord+1) +" order by r";
            }
            Debug.logFramework("SQL findCustomerForESICustomer = "+sql);
            
            rowSet = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());
            if(rowSet != null){
                while(rowSet.next()){
                    obj = new EshippingCustomerDetailsMod();
                    obj.setCustomerCode(rowSet.getString(1));
                    obj.setCustomerName(rowSet.getString(2));
                    obj.setCustomerNameRe(rowSet.getString(2).replace("'", "\\\'"));
                    obj.setCountryName(rowSet.getString(3));
                    obj.setCountryCode(rowSet.getString(4));
                    obj.setCocSoc(rowSet.getString(5));
                    obj.setAddress1(rowSet.getString(6));
                    obj.setAddress2(rowSet.getString(7));
                    obj.setAddress3(rowSet.getString(8));
                    obj.setAddress4(rowSet.getString(9));
                    customerList.add(obj);
                }
            }

            resultMap = new HashMap();
            resultMap.put(KEY_DATA, customerList);
            resultMap.put(KEY_SIZE, rows);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return resultMap;
    }

    public Map findCustomerForESVCustomer(Map map) throws BusinessException, DataAccessException{
        List<EserviceCustomerPopupMod> customerList = null;
        
        Map resultMap = null;

        PagingUtil pagingUtil = null;
        EserviceCustomerPopupMod objVO = null;
        StringBuffer stringBuffer = null;

        String findText = null;
        String column = null;
        String sortby = null;
        String order = null;
        String wildcard = null;
        String fscCode = null;
        String controlFsc = null;
        String country = null;
        String sql = null;
        
        Integer fromRecord = null;
        Integer toRecord = null;
        
        SqlRowSet rowSet = null;

        int rows = 0;
        try{
            customerList = new ArrayList<EserviceCustomerPopupMod>();

            findText = (String) map.get(CRITERIA_KEY.TEXT_FIND);
            column = (String) map.get(CRITERIA_KEY.COLUMN);
            sortby = (String) map.get(CRITERIA_KEY.SORTBY);
            order = (String) map.get(CRITERIA_KEY.ORDER);
            wildcard = (String) map.get(CRITERIA_KEY.WILDCARD);
            fscCode = (String) map.get(CRITERIA_KEY.FSC_CODE);
            controlFsc = (String) map.get(CRITERIA_KEY.CONTROL_FSC);
            fromRecord = (Integer) map.get(CRITERIA_KEY.FROM_RECORD);
            toRecord = (Integer) map.get(CRITERIA_KEY.TO_RECORD);
            country = (String) map.get(CRITERIA_KEY.COUNTRY);
            
            System.out.println("column :: " + column);
            System.out.println("findText :: " + findText);
            System.out.println("sortby :: " + sortby);
            System.out.println("order :: " + order);
            System.out.println("wildcard :: " + wildcard);
            System.out.println("fscCode :: " + fscCode);
            System.out.println("controlFsc :: " + controlFsc);
            System.out.println("fromRecord :: " + fromRecord);
            System.out.println("toRecord :: " + toRecord);
            System.out.println("country :: " + country);

            stringBuffer = new StringBuffer("select rownum,a.* from (");
            stringBuffer.append("select distinct CUSTOMER_CODE");
            stringBuffer.append(", DESCRIPTION, ADDRESS, CITY_NAME, STATE_CODE");
            stringBuffer.append(", STATE_NAME, ZIP_CODE, TELEPHONE, FAX_NO");
            stringBuffer.append(", EMAIL, COUNTRY_CODE, COUNTRY_NAME, CONSOLIDATED, FSC, CUSTOMER_TYPE ");
            stringBuffer.append("from RCLAPPS.VR_CRM_CUST_WITH_USER_LEVEL ");
            stringBuffer.append("where 1=1 ");
            
            if(country!=null && !country.equals("")){
                stringBuffer.append(" AND COUNTRY_CODE = '" + country + "' ");
            }
            
            stringBuffer.append(" AND STATUS = 'A' ");
            if(fscCode != null && !BLANK.equals(fscCode)){
                if(YES.equals(controlFsc)){
                    stringBuffer.append("and FSC IN (SELECT CRCNTR FROM itp188 WHERE CRFLV3='"+fscCode+"' AND crrcst='A') ");
                }else{
                    if(!"R".equals(fscCode)){
                        stringBuffer.append("and FSC = '"+fscCode+"' ");
                    }
                }
            }
            if(column!=null&&!BLANK.equals(column)){
                stringBuffer.append("and UPPER ("+column + ")");
                if(wildcard!=null){
                    stringBuffer.append(" like '%"+findText.trim()+"%' ");
                } else {
                    stringBuffer.append(" = '"+findText.trim()+"' ");
                }
            }
            if(sortby!=null&&!BLANK.equals(sortby)){
                stringBuffer.append("order by "+sortby+" "+order);
            }
            stringBuffer.append(") a");
            
            sql = stringBuffer.toString();
            if((fromRecord!=null&&!BLANK.equals(fromRecord))&&(toRecord!=null&&!BLANK.equals(toRecord))){
                pagingUtil = new PagingUtil();

                sql = pagingUtil.getSqlRows(stringBuffer);
                rowSet = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());
                if(rowSet != null){
                    while(rowSet.next()){
                        rows = rowSet.getInt(1);
                    }
                }
                sql = pagingUtil.setRownum(stringBuffer, fromRecord, toRecord);
            }
            System.out.println("SQL findCustomerForESVCustomer = "+sql);
            
            rowSet = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(), new HashMap());
            if(rowSet!=null){
                while(rowSet.next()){
                    objVO = new EserviceCustomerPopupMod();
                    objVO.setRownum(rowSet.getString("rownum"));
                    objVO.setCustomerCode(rowSet.getString("CUSTOMER_CODE"));
                    objVO.setDescription(rowSet.getString("DESCRIPTION"));
                    objVO.setAddress(rowSet.getString("ADDRESS"));
                    objVO.setCityName(rowSet.getString("CITY_NAME"));
                    objVO.setStateCode(rowSet.getString("STATE_CODE"));
                    objVO.setStateName(rowSet.getString("STATE_NAME"));
                    objVO.setZipCode(rowSet.getString("ZIP_CODE"));
                    objVO.setTelephone(rowSet.getString("TELEPHONE"));
                    objVO.setFaxNo(rowSet.getString("FAX_NO"));
                    objVO.setEmail(rowSet.getString("EMAIL"));
                    objVO.setCountryCode(rowSet.getString("COUNTRY_CODE"));
                    objVO.setCountryName(rowSet.getString("COUNTRY_NAME"));
                    objVO.setConsolidated(rowSet.getString("CONSOLIDATED"));
                    objVO.setFscCode(rowSet.getString("FSC"));
                    objVO.setCustomerType(rowSet.getString("CUSTOMER_TYPE"));

                    customerList.add(objVO);
                }
            }
            resultMap = new HashMap();
            resultMap.put(KEY_DATA, customerList);
            resultMap.put(KEY_SIZE, rows);
        } catch(Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }

    public Map onLoad(Map amapParam) throws BusinessException, DataAccessException{
        return amapParam;
    }

    public Map findCustomerTypeForESV(Map map) throws BusinessException, DataAccessException{
        System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV][Begin]");
        
        JdbcStoredProcedure     storeProcedure      = null;
        Map                     resultMap           = null;
        String[][]              arrParams           = null;
        String                  errorMsg            = null;
        String                  find                = null;
        String                  column              = null;
        String                  sortCol             = null;
        String                  orderBy             = null;
        String                  in                  = null;
        String                  wildcard            = null;
        String                  fromRecord          = null;
        String                  toRecord            = null;
        
        try{
            find        = (String) map.get(CRITERIA_KEY.TEXT_FIND);
            column      = (String) map.get(CRITERIA_KEY.COLUMN);
            sortCol     = (String) map.get(CRITERIA_KEY.SORT_COL);
            orderBy     = (String) map.get(CRITERIA_KEY.ORDER);
            in          = (String) map.get(CRITERIA_KEY.IN);
            wildcard    = (String) map.get(CRITERIA_KEY.WILDCARD);

            if(map.containsKey(CRITERIA_KEY.FROM_RECORD)){
                fromRecord = String.valueOf((Integer) map.get(CRITERIA_KEY.FROM_RECORD)+1);
            }

            if(map.containsKey(CRITERIA_KEY.TO_RECORD)){
                toRecord = String.valueOf((Integer) map.get(CRITERIA_KEY.TO_RECORD)+1);
            }
            
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV] fromRecord   :: " + fromRecord);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV] toRecord     :: " + toRecord);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV] sortCol      :: " + sortCol);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV] orderBy      :: " + orderBy);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV] find         :: " + find);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV] in           :: " + in);
            
            arrParams = new String[][]{
                                        {P_I_V.RECORD_START     , BLANK+ORACLE_VARCHAR  , PARAM_IN  , fromRecord}, 
                                        {P_I_V.RECORD_END       , BLANK+ORACLE_VARCHAR  , PARAM_IN  , toRecord}, 
                                        {P_I_V.SORT_COL         , BLANK+ORACLE_VARCHAR  , PARAM_IN  , sortCol}, 
                                        {P_I_V.ORDER_BY         , BLANK+ORACLE_VARCHAR  , PARAM_IN  , orderBy}, 
                                        {P_I_V.FIND             , BLANK+ORACLE_VARCHAR  , PARAM_IN  , find},
                                        {P_I_V.IN               , BLANK+ORACLE_VARCHAR  , PARAM_IN  , in},
                                        {P_O_V.TOTAL_ROW        , BLANK+ORACLE_NUMBER   , PARAM_OUT , BLANK },
                                        {P_O_V.CUST_TYPE_DATA   , BLANK+ORACLE_CURSOR   , PARAM_OUT , BLANK}
                                      };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_CUSTOMER_TYPE_POPUP, new EserviceCustomerTypeRowMapper(), arrParams);
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
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESV][End]");
        }
        return resultMap;
    }
    
    public Map findCustomerTypeForESVNew(Map map) throws BusinessException, DataAccessException{
        System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESVNew][Begin]");
        
        JdbcStoredProcedure     storeProcedure      = null;
        Map                     resultMap           = null;
        String[][]              arrParams           = null;
        String                  errorMsg            = null;
        String                  find                = null;
        String                  column              = null;
        String                  sortCol             = null;
        String                  orderBy             = null;
//        String                  in                  = null;
        String                  wildcard            = null;
        String                  fromRecord          = null;
        String                  toRecord            = null;
        List<EserviceCustomerTypePopupMod>  lst             = null;
        Map                                 amap            = null;
        
        try{
            amap         = new HashMap();
            find        = (String) map.get(CRITERIA_KEY.TEXT_FIND);
            column      = (String) map.get(CRITERIA_KEY.IN);
            sortCol     = (String) map.get(CRITERIA_KEY.SORT_COL);
            orderBy     = (String) map.get(CRITERIA_KEY.ORDER);
//            in          = (String) map.get(CRITERIA_KEY.IN);
            wildcard    = (String) map.get(CRITERIA_KEY.WILDCARD);

            if(map.containsKey(CRITERIA_KEY.FROM_RECORD)){
                fromRecord = String.valueOf((Integer) map.get(CRITERIA_KEY.FROM_RECORD)+1);
            }

            if(map.containsKey(CRITERIA_KEY.TO_RECORD)){
                toRecord = String.valueOf((Integer) map.get(CRITERIA_KEY.TO_RECORD)+1);
            }
            
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESVNew] column           :: " + column);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESVNew] find             :: " + find);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESVNew] sortCol          :: " + sortCol);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESVNew] orderBy          :: " + orderBy);
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESVNew] wildcard         :: " + wildcard);
            
            arrParams = new String[][]{
                                        {P_I_V.COL_NAME              , BLANK+ORACLE_VARCHAR      , PARAM_IN  , column},
                                        {P_I_V.COL_VAL               , BLANK+ORACLE_VARCHAR      , PARAM_IN  , find},
                                        {P_I_V.SORT_BY               , BLANK+ORACLE_VARCHAR      , PARAM_IN  , sortCol},
                                        {P_I_V.ORDER_BY              , BLANK+ORACLE_VARCHAR      , PARAM_IN  , orderBy},
                                        {P_I_V.WILD_CARD             , BLANK+ORACLE_VARCHAR      , PARAM_IN  , wildcard},
                                        {P_O_V.CUST_TYPE_DATA        , BLANK+ORACLE_CURSOR       , PARAM_OUT , BLANK}
                                    };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_CUST_TYPE_POPUP, new EserviceCustomerTypeRowMapper(), arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    lst             = (List<EserviceCustomerTypePopupMod>) resultMap.get(P_O_V.CUST_TYPE_DATA);
                }
            }
            
            amap.put(KEY_DATA, lst);
            amap.put(KEY_SIZE, lst.size());
            
        }catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
        }finally{
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                amap.put(P_O_V.ERR_CD, "EXCEPTION");
                amap.put(P_O_V.ERR_DESC, errorMsg);
            }
            System.out.println("[EserviceCustomerPopupDaoImpl][findCustomerTypeForESVNew][End]");
        }
        return amap;
    }
    
    private class EserviceCustomerTypeRowMapper extends JdbcRowMapper{
        public EserviceCustomerTypeRowMapper(){}
    
        public Object mapRow(ResultSet rs, int row) throws SQLException { 
            EserviceCustomerTypePopupMod mod = new EserviceCustomerTypePopupMod();
            try{    
                mod.setCustomerType(rs.getString("CUSTOMER_TYPE"));
                mod.setDescription(rs.getString("DESCRIPTION"));
                mod.setOrganizationType(rs.getString("ORGANISATION_TYPE"));
                mod.setStatus(rs.getString("STATUS"));
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
}
