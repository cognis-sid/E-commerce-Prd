package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.exception.BusinessException;
import com.niit.control.dao.AncestorJdbcDao;

import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingBookingListMod;

import java.math.BigDecimal;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public class EserviceBookingNoPopupDaoImpl extends AncestorJdbcDao implements EserviceBookingNoPopupDao{
    public EserviceBookingNoPopupDaoImpl(){
    }

    /**
     * 
     * This method for get List of Booking.
     * 
     * @exception BusinessException and DataAccessException
     * @param map List of parameters in
     * @return List of booking data 
     */

    public Map findESIBookingNoDetails(Map paramsMap) throws BusinessException, DataAccessException{
        Map resultMap = null;

        JdbcStoredProcedure storeProcedure = null;

        String[][] arrParam = null;
        String[] paramsMapValue = null;
        
        String errorMsg = null;
        String findText = null;
        String column = null;
        String sortby = null;
        String order = null;
        String status = null;
        String wildcard = null;
        String fromRecord = null;
        String toRecord = null;
        try{
            findText = (String) paramsMap.get(CRITERIA_KEY.TEXT_FIND);
            column = (String) paramsMap.get(CRITERIA_KEY.COLUMN);
            sortby = (String) paramsMap.get(CRITERIA_KEY.SORTBY);
            order = (String) paramsMap.get(CRITERIA_KEY.ORDER);
            status = (String) paramsMap.get(CRITERIA_KEY.STATUS);
            wildcard = (String) paramsMap.get(CRITERIA_KEY.WILDCARD);

            if(null!=(Integer) paramsMap.get(CRITERIA_KEY.FROM_RECORD)){
                fromRecord = String.valueOf((Integer) paramsMap.get(CRITERIA_KEY.FROM_RECORD)+1);
            }

            if(null!=(Integer) paramsMap.get(CRITERIA_KEY.TO_RECORD)){
                toRecord = String.valueOf((Integer) paramsMap.get(CRITERIA_KEY.TO_RECORD)+1);
            }
            
            paramsMapValue = getParamsMapValue(column, findText);
            arrParam = new String[][]{ 
                {P_O_V.REF_CURSOR_DTL_DATA, BLANK+ORACLE_CURSOR, PARAM_OUT, BLANK}, 
                {P_I_V.BOOKING_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[0]}, 
                {P_I_V.SHIPPER_NAME_POPUP, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[1]}, 
                {P_I_V.VESSEL, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[2]}, 
                { P_I_V.VOYAGE, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[3]}, 
                { P_I_V.POL, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[4]}, 
                { P_I_V.POD, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[5]}, 
                { P_I_V.STATUS, BLANK+ORACLE_VARCHAR, PARAM_IN, status }, 
                { P_I_V.BL_NO, BLANK+ORACLE_VARCHAR, PARAM_IN, paramsMapValue[6]}, 
                { P_I_V.LOGIN_ID, BLANK+ORACLE_VARCHAR, PARAM_IN, (String) paramsMap.get(KEY_USER_ID) }, 
                { P_I_V.REC_START, BLANK+ORACLE_VARCHAR, PARAM_IN, fromRecord }, 
                { P_I_V.REC_END, BLANK+ORACLE_VARCHAR, PARAM_IN, toRecord }, 
                { P_O_V.TOTAL_ROW, BLANK+ORACLE_NUMBER, PARAM_OUT, BLANK } 
            };                
            
            storeProcedure = getStoreProcedure(PCR_ESV_SI_MAIN.PRR_ERCL_GET_ESI_BOOKING_POPUP,  new EsiBookingPopupRowMapper(), arrParam);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
            }else{
                errorMsg = "Can not get connection to store procedure.";
            }
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{            
            if(resultMap == null){
                resultMap = new HashMap();
            }
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                resultMap.put(P_O_V.ERR_CD, EXCEPTION);
                resultMap.put(P_O_V.ERR_DESC, errorMsg);
            }
        }
        //        System.out.println("Row(s) All : " + size.intValue());
        return resultMap;
    }
    
    public class EsiBookingPopupRowMapper extends JdbcRowMapper{

        /**
         * 
         * This mothod for set data to booking data in each row.
         * 
         * @exception SQLException
         * @param rs List of booking data
         * @param row Row of booking data
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EshippingBookingListMod obj = new EshippingBookingListMod();
            obj.setBookingDate(rs.getString(1));
            obj.setBookingNo(rs.getString(2));
            //@04 BEGIN
            obj.setShipperName(rs.getString(3));
            //@04 END
            obj.setLegVessel(rs.getString(4));
            obj.setLegVoyage(rs.getString(5));
            obj.setPol(rs.getString(6));
            obj.setPod(rs.getString(7));
            obj.setEsiStatusDesc(rs.getString(8));
            obj.setBlNo(rs.getString(9));
            obj.setCocSoc(rs.getString(10));
            obj.setEsiStatusCode(rs.getString(11));
            obj.setPolNo(rs.getString(12));
            obj.setPodNo(rs.getString(13));
            return obj;
        }
    }

    private String[] getParamsMapValue(String chosenColumn, String findText){
        String[] paramsVal = null;
        try{
            paramsVal = new String[]{
                COLUMN_KEY.BOOKING_NO, COLUMN_KEY.SHIPPER, COLUMN_KEY.VESSEL,
                COLUMN_KEY.VOYAGE, COLUMN_KEY.POL, COLUMN_KEY.POD,
                COLUMN_KEY.BL_NO
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
