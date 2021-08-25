/* -----------------------------------------------------------------------------
System  : RCL-EZL
Module  : Common
Prog ID : ECM002 - EcmMasterLookupDaoImpl.java
Name    : Master Lookup
Purpose : DAO Class for EcmMasterLookupDao Interface
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
NTL)Ankit        15/01/2011      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
----------------------------------------------------------------------------- */

package com.rclgroup.dolphin.ezl.web.ecm.dao;

import com.niit.control.common.exception.BusinessException;
import com.niit.control.common.exception.ExceptionFactory;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.ezl.web.ecm.vo.EcmMasterLookupMod;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Map;

import org.springframework.dao.DataAccessException;


/** 
 * Class for DAO
 * @class EcmMasterLookupDaoImpl
 * @author NTL) Ankit
 * @version v1.00 15/01/2011
 * @see
 */
public class EcmMasterLookupDaoImpl extends AncestorJdbcDao implements EcmMasterLookupDao {

    /* SQL for Fetching the master configuration and Result list data based on Pre criteria */
    private static final String SQL_MASTER_CONFIG = 
        "PCE_ECM_MASTERLOOKUP.PRE_ECM_MasterConfig";
    /* SQL for searching the result data based on search criteria */
    private static final String SQL_RESULT_LIST = 
        "PCE_ECM_MASTERLOOKUP.PRE_ECM_MasterResultList";
    /* Holds Current Page No incase of pagination */
    public int intCurrPage = 0;

    private int totColumn = 0;

    public EcmMasterLookupDaoImpl() {
    }

    /** getMasterConfig: Gets the configuration details for the particualr master 
     * @param Map
     * @return Map
     * @throws Exception
     */
    public Map getMasterConfig(Map amapParam) throws BusinessException, 
                                                     DataAccessException {
        /* Stores return error code from SP */
        String strRetError = null;

        /* stored procedure object */
        JdbcStoredProcedure objSP = null;

        /* Return Result from SP execute */
        Map mapResult = null;

        /*
         * Prepare 2D Array of Parameters to be passed to SP
         * 1. Param Name
         * 2. Oracle Data Type
         * 3. Param Type(In/Out/InOut)
         * 4. Param Value(for In/InOut types)
         */
        String[][] arrParam = 
        { { KEY_MASTER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_MASTER_ID) }, 
          { KEY_SCREEN_TITLE, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_GRID_VIEW_TITLE, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_FIND_IN_CD, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_FIND_IN_DESC, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_SORT_BY_CD, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_SORT_BY_DESC, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_NO_OF_COLUMN, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_COLUMN_HEADER, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };


        /* Create JDBC Stored Procedure Object */
        objSP = 
                new JdbcStoredProcedure(getDataSource(), SQL_MASTER_CONFIG, arrParam);

        /* Execute the SP & Get the Return Output values as Map*/
        mapResult = objSP.execute();

        /* Read the Return code from SP */
        strRetError = (String)mapResult.get(KEY_ERROR_DATA);

        /* If return error code is Failure, throw Business Exception */
        if (isErrorCode(strRetError)) {
            throw ExceptionFactory.createApplicationException(strRetError);
        }

        return mapResult;
    }

    /** getResultList : Get the result data based on the filter criteria set by the user
     * @param  Map
     * @return Map
     * @throws Exception
     */
    public Map getResultList(Map amapParam) throws BusinessException, 
                                                   DataAccessException {
        /* stored procedure object */
        JdbcStoredProcedure objSP = null;

        /* Return Result from SP execute */
        Map mapResult = null;

        /* Stores return error code from SP */
        String strRetError = null;
        totColumn = Integer.parseInt((String)amapParam.get(KEY_NO_OF_COLUMN));
        /* Fetch Current Page No Incase of pagination*/
        intCurrPage = ((Integer)amapParam.get(KEY_CURR_PAGE_NO)).intValue();

        /*
         * Prepare 2D Array of Parameters to be passed to SP
         * 1. Param Name
         * 2. Oracle Data Type
         * 3. Param Type(In/Out/InOut)
         * 4. Param Value(for In/InOut types)
         * */

        String[][] arrParam = 
        { { KEY_REF_RESULT_LIST, BLANK + ORACLE_CURSOR, PARAM_OUT, BLANK }, 
          { KEY_MASTER_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_MASTER_ID) }, 
          { KEY_PRE_CRITERIA, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_PRE_CRITERIA) }, 
          { KEY_FIND_VAL, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_FIND_VAL) }, 
          { KEY_FIND_IN, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_FIND_IN) }, 
          { KEY_WILD_CARD, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_WILD_CARD) }, 
          { KEY_SORT_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_SORT_BY) }, 
          { KEY_SORT_IN, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_SORT_IN) }, 
          { KEY_REC_STATUS, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_REC_STATUS) }, 
          { KEY_CURR_PAGE_NO, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            "" + intCurrPage }, 
          { KEY_ORDER_BY, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_ORDER_BY) }, 
          { KEY_ASC_DESC, BLANK + ORACLE_VARCHAR, PARAM_IN, 
            (String)amapParam.get(KEY_ASC_DESC) }, 
          { KEY_TOT_REC_COUNT, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK }, 
          { KEY_ERROR_DATA, BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK } };

        /* Create JDBC Stored Procedure Object */
        objSP = 
                new JdbcStoredProcedure(getDataSource(), SQL_RESULT_LIST, new LookupRowMapper(), 
                                        arrParam);

        /* Execute the SP & Get the Return Output values as Map*/
        mapResult = objSP.execute();

        /* Read the Return code from SP */
        strRetError = (String)mapResult.get(KEY_ERROR_DATA);
        /* If return error code is Failure, throw Business Exception */
        if (isErrorCode(strRetError)) {
            throw ExceptionFactory.createApplicationException(createMsgHolder(strRetError));
        }

        return mapResult;
    }

    /** 
     * Inner Row Mapper Class for DAO
     * @class LookupRowMapper
     * @author NTL) Debasis
     * @version v1.00 2009/11/11
     * @see
     */
    private class LookupRowMapper extends JdbcRowMapper {

        /** mapRow : Will be called for each row of result set by spring
         * @param ResultSet
         * @param int - Current Row Number
         * @return Object
         * @throws SQLException
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EcmMasterLookupMod objLookup = null;
            if (row >= getFromRecNo(intCurrPage) && 
                row <= getToRecNo(intCurrPage)) {
                objLookup = new EcmMasterLookupMod();
                objLookup.setSrlNo(row + 1);
                for (int i = 1; i <= totColumn; i++) {
                    objLookup.setValue(i, rs.getString(i));
                }
            }
            return objLookup;
        } //mapRow

    } //End of Inner Class ContractRowMapper
}
