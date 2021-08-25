package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import java.util.HashMap;
import java.util.Map;

public class EserviceForgetPasswordDaoImpl extends AncestorJdbcDao implements EserviceForgetPasswordDao{
    public EserviceForgetPasswordDaoImpl(){
    }

    public Map sendForgetPassword(Map map){
        JdbcStoredProcedure storeProcedure = null;
        
        Map resultMap = null;
        
        String[][] arrParams = null;
        
        String errorMsg = null;
        try{
            arrParams = new String[][]{
                {P_I_V.USR_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.USR_ID)},
                {P_I_V.EMAIL_ADR, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) map.get(P_I_V.EMAIL_ADR)}
            };
        
            storeProcedure = getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_FORGOT_PWD, null, arrParams);
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
