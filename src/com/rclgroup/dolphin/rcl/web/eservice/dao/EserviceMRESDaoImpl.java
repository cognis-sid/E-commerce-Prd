package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;

import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESNotificationsMod;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EserviceMRESDaoImpl extends AncestorJdbcDao implements EserviceMRESDao{
    public EserviceMRESDaoImpl(){
    }

    public Map findNotifications(Map map){
        JdbcStoredProcedure storeProcedure = null;
    
        List<EserviceMRESNotificationsMod> modList = null;
        
        Map resultMap = null;
        
        String[][] arrParams = null;
        try{
            arrParams = new String[][]{
                {P_I_V.USR_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.USR_ID)},
                {P_I_V.RECORD_START, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.RECORD_START)},
                {P_I_V.RECODE_END, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.RECODE_END)},
                {P_I_V.SORT_COL, BLANK+ORACLE_NUMBER, PARAM_IN, (String) map.get(P_I_V.SORT_COL)},
                {P_I_V.ORDERBY, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.ORDERBY)},
                {P_O_V.TOTAL_ROW, BLANK + ORACLE_NUMBER, PARAM_OUT, BLANK},
                {P_O_V.NOTICE_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK}
            };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_NOTIFICATION, new MRESNotificationDetailsRowMapper(), arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return resultMap;
    }

    public class MRESNotificationDetailsRowMapper extends JdbcRowMapper {
    
        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EserviceMRESNotificationsMod obj = new EserviceMRESNotificationsMod();
            obj.setId(rs.getString(1));
            obj.setMailSubject(rs.getString(2));
            obj.setMailDateStr(rs.getString(3));
            obj.setFlag(rs.getString(4));
            obj.setFlagDesc(rs.getString(4));
            obj.setMailBody(rs.getString(5));
           
            return obj;
        }    
    }

    public Map findMyEService(Map map){
        JdbcStoredProcedure storeProcedure = null;
    
        List<EserviceMRESMyEServiceMod> modList = null;
        
        Map resultMap = null;
    
        String[][] arrParams = null;
        try{
            arrParams = new String[][]{
                {P_I_V.USR_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.USR_ID)},
                {P_O_V.SFU_DATA, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK}
            };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_MENU, new MRESMyEServiceDetailsRowMapper(), arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
            }
//            For test
//            resultMap = getMyEservice();            
//            setMyEservice(resultMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
             if(modList == null){
                 modList = new ArrayList<EserviceMRESMyEServiceMod>();
             }
        }
        return resultMap;
    }
    
    public class MRESMyEServiceDetailsRowMapper extends JdbcRowMapper {
    
        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EserviceMRESMyEServiceMod obj = new EserviceMRESMyEServiceMod();
            
            obj.setMenuCode(rs.getString(1));
            obj.setMenuName(rs.getString(2));
            obj.setInformation(rs.getString(3));
            obj.setUrl(rs.getString(4));
            obj.setModule(rs.getString(5));
           
            return obj;
        }    
    }

    public Map findPasswordAuthen(Map map){
        JdbcStoredProcedure storeProcedure = null;
        
        Map resultMap = null;
        
        String[][] arrParams = null;
        try{
            arrParams = new String[][]{
                {P_I_V.USR_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.USR_ID)},
                {P_I_V.PWD, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.PWD)}, 
                {P_O_V.ERR_MSG, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK}
            };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_GET_AUTHENTICATE, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return resultMap;
    }
    
    private List<EserviceMRESNotificationsMod> getNotifications(){
        List<EserviceMRESNotificationsMod> modList = null;
        
        EserviceMRESNotificationsMod mod = null;
        try{
            modList = new ArrayList<EserviceMRESNotificationsMod>();
            
            mod = new EserviceMRESNotificationsMod();
            mod.setId("52777");
            mod.setMailSubject("Web Booking Confirmation Received - BLCHC13013690");
            mod.setUrl("");
            mod.setMailDateStr("09/12/2013 12:00:00 PM");
            mod.setFlag("N");
            mod.setFlagDesc("New");
            modList.add(mod);
            
            mod = new EserviceMRESNotificationsMod();
            mod.setId("52776");
            mod.setMailSubject("eSI Submitted Successfully - BBKKC13013687");
            mod.setMailDateStr("09/12/2013 12:30:00 PM");
            mod.setFlag("N");
            mod.setFlagDesc("New");
            modList.add(mod);
            
            mod = new EserviceMRESNotificationsMod();
            mod.setId("49303");
            mod.setMailSubject("Web Booking Submitted Successfully - BLCHC13013690");
            mod.setMailDateStr("09/12/2013 11:35:50 AM");
            mod.setFlag("R");
            mod.setFlagDesc("Read");
            modList.add(mod);
            
            mod = new EserviceMRESNotificationsMod();
            mod.setId("48348");
            mod.setMailSubject("Web Booking Confirmation Received - BBKKC13013687");
            mod.setMailDateStr("08/12/2013 14:26:20 PM");
            mod.setFlag("R");
            mod.setFlagDesc("Read");
            modList.add(mod);
            
            mod = new EserviceMRESNotificationsMod();
            mod.setId("43999");
            mod.setMailSubject("Web Booking Submitted Successfully - BBKKC13013687");
            mod.setMailDateStr("08/12/2013  08:00:00 AM");
            mod.setFlag("R");
            mod.setFlagDesc("Read");
            modList.add(mod);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return modList;
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
