package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingPackageTypeListMod;
import com.rclgroup.dolphin.rcl.web.procedure.PRR_ERCL_GET_ESI_PACKAGE_POPUP;

public class EservicePackagePopupDaoImpl extends AncestorJdbcDao implements EservicePackagePopupDao{
    public EservicePackagePopupDaoImpl(){
    }

    /**
     * 
     * This method for get List of package kind type.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of package kind type 
     */
    public Map findPackageKindTypes(Map paramsMap) throws BusinessException, DataAccessException{
        Map resultMap = null;

        JdbcStoredProcedure storeProcedure = null;

        String[][] arrParam = null;
        String[] paramsMapValue = null;
        
        String errorMsg = null;
        String findText = null;
        String column = null;
        String sortby = null;
        String order = null;
        String fromRecord = null;
        String toRecord = null;
        try{
            findText = (String) paramsMap.get(CRITERIA_KEY.TEXT_FIND);
            column = (String) paramsMap.get(CRITERIA_KEY.COLUMN);
            sortby = (String) paramsMap.get(CRITERIA_KEY.SORTBY);
            order = (String) paramsMap.get(CRITERIA_KEY.ORDER);

            if(null!=(Integer) paramsMap.get(CRITERIA_KEY.FROM_RECORD)){
                fromRecord = String.valueOf((Integer) paramsMap.get(CRITERIA_KEY.FROM_RECORD)+1);
            }

            if(null!=(Integer) paramsMap.get(CRITERIA_KEY.TO_RECORD)){
                toRecord = String.valueOf((Integer) paramsMap.get(CRITERIA_KEY.TO_RECORD)+1);
            }            
            
            paramsMapValue = getParamsMapValue(column, findText);
            arrParam = new String[][]{ { P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK }, 
                        { P_I_V.PKG_NAME, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[0]},
                        { P_I_V.PKG_CODE, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[1]}, 
                        { P_I_V.REC_START, BLANK+ORACLE_VARCHAR, PARAM_IN, fromRecord}, 
                        { P_I_V.REC_END, BLANK+ORACLE_VARCHAR, PARAM_IN, toRecord}, 
                        { P_O_V.TOTAL_ROW, BLANK+ORACLE_NUMBER, PARAM_OUT, BLANK } };

           // storeProcedure = getStoreProcedure(PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_PACKAGE_POPUP, new PackageKingTypeRowMapper(), arrParam);
         
            resultMap=new HashMap();
            resultMap.put("P_I_V_NAME", paramsMapValue[0]);
            resultMap.put("P_I_V_CODE", paramsMapValue[1]);
            resultMap.put("P_I_V_RECORD_START", fromRecord);
            resultMap.put("P_I_V_RECORD_END", toRecord);
            
            PRR_ERCL_GET_ESI_PACKAGE_POPUP proc =new PRR_ERCL_GET_ESI_PACKAGE_POPUP(getJdbcTemplate(),resultMap);
            proc.executeDbProcedure();
            
			/*
			 * if(storeProcedure != null){ resultMap = storeProcedure.execute(); }else{
			 * errorMsg = "Can not get connection to store procedure."; }
			 */
        } catch(DataAccessException ex){
        	ex.printStackTrace();
            throw ex;
        } finally{          
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

    public class PackageKingTypeRowMapper extends JdbcRowMapper{

        /**
         * 
         * This mothod for set data to package kind type in each row.
         * 
         * @exception SQLException
         * @param rs List of package kind type
         * @param row Row of package kind type
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EshippingPackageTypeListMod obj = new EshippingPackageTypeListMod();
            obj.setPackageName(rs.getString(1));
            obj.setPackageCode(rs.getString(2));
            return obj;
        }
    }

    private String[] getParamsMapValue(String chosenColumn, String findText){
        String[] paramsVal = null;
        try{
            paramsVal = new String[]{
                COLUMN_KEY.PACKAGE_NAME, COLUMN_KEY.PACKAGE_CODE
            };
            
            for(int countIndex=0, totalLength=paramsVal.length; countIndex<totalLength; countIndex++){
                if(paramsVal[countIndex].equals(chosenColumn)){
                    paramsVal[countIndex] = findText;
                }else{
                    paramsVal[countIndex] = BLANK;
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return paramsVal;
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
